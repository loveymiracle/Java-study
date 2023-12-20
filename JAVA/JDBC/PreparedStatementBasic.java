
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PreparedStatementBasic {
	public static Connection conn = null;
	public static PreparedStatement pstmt = null; // ★★★★★
	public static ResultSet rs = null;
	
	public static String driverClass = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/jdbc";
	public static String user = "user";
	public static String password = "1234";
	
	
	public static void main(String[] args) {
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			
			List<Member> list = selectAll();
			print(list);
			
			System.out.println("select one 호출");
			String id = "user1";
			Member m = selectOne(id);
			System.out.println(m);
			System.out.println("select one 끝");
			
			// 회원가입 할 멤버 생성
			Calendar c = Calendar.getInstance();
			c.set(2000, 10, 9); // 2000년 11월 9일 생
			m = new Member(0, "test6", "1234", "이길동", "M", 26, "lee@test.com", 
					       "01012345678", "서울시 강남구", "야구", c.getTime(), null);
			insert(m);
			list = selectAll();
			print(list);
			
			update(m.getID(), "김길동");
			list = selectAll();
			print(list);
			
			delete(m.getID());
			list = selectAll();
			print(list);
			
//			conn.commit(); // 수동으로 commit 명령을 내리는 방법
			conn.rollback(); // commit 이후에 실행된 명령을 모두 돌리는 코드
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null && rs.isClosed() == false) {
					rs.close();
				}
				if(pstmt != null && pstmt.isClosed() == false) {
					pstmt.close();
				}
				if(conn != null && conn.isClosed() == false) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	private static void print(List<Member> list) {
		System.out.println("------------------ MEMBER -----------------------");
		list.forEach((v) -> System.out.println(v));
		System.out.println("-------------------------------------------------\n");
	}

	public static List<Member> selectAll() throws SQLException {
		String sql = "SELECT * FROM MEMBER";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		List<Member> list = new ArrayList<>();
		
		while(rs.next()) {
			int no 				= rs.getInt("mno");  // 컬럼명으로 맞춰서 가져와야한다!
			String id           = rs.getString("id");
			String pwd          = rs.getString("password");	// pwd -> password 맵핑 필요!
			String name         = rs.getString("name");
			String gender       = rs.getString("gender");
			int age             = rs.getInt("age");
			String email        = rs.getString("email");
			String phone        = rs.getString("phone");
			String address      = rs.getString("address");
			String hobby        = rs.getString("hobby");
			Date birthday       = rs.getDate("birthday");
			Date enrolldate     = rs.getTimestamp("enrolldate"); // 시간 + 날짜
			Member m = new Member(no, id, pwd, name, gender, age, email, phone, address, hobby, birthday, enrolldate);
			list.add(m);
		}
		pstmt.close();
		rs.close();
		return list;
	}

	private static Member selectOne(String memberId) throws SQLException {
		// PreparedStatement 사용방법 정리
		// 1. 반만 완성된 쿼리를 작성, '?'를 통해 나중에 문자열이 주입될 부분을 채워야한다.
		String sql = "SELECT * FROM MEMBER WHERE ID = ? ORDER BY ? DESC";
		pstmt = conn.prepareStatement(sql); // 쿼리가 준비된 상태로, 현재까지는 DB의 요청하지 않음!
		
		// 2. ?를 사용자의 입력으로 변경 ※ 주의 : DB index는 1부터 시작한다.
		pstmt.setString(1, memberId);		// 첫번째 ?를 사용자 id로 교체
		pstmt.setString(2, "name"); // 두번째 ?자를 "name"으로 교체
		
		// 3. 실행
//		pstmt.executeQuery(sql); // 금지!! 기존에 셋팅한 sql, setString의 정보가 초기화됨!
		rs = pstmt.executeQuery(); // 옳은 방법!
		
		Member m = null;
		if(rs.next()) {
			// select *로 가져오는 경우, 컬럼의 선언 순번대로 가져옵니다.
			int count = 1;
			int no 				= rs.getInt(count++);  
			String id           = rs.getString(count++);
			String pwd          = rs.getString(count++);	
			String name         = rs.getString(count++);
			String gender       = rs.getString(count++);
			int age             = rs.getInt(count++);
			String email        = rs.getString(count++);
			String phone        = rs.getString(count++);
			String address      = rs.getString(count++);
			String hobby        = rs.getString(count++);
			Date birthday       = rs.getDate(count++);
			Date enrolldate     = rs.getTimestamp(count++); 
			m = new Member(no, id, pwd, name, gender, age, email, phone, address, hobby, birthday, enrolldate);

		}
		pstmt.close();
		rs.close();
		return m;
	}
	
	private static void insert(Member m) throws SQLException {
		System.out.println("Insert 시작!");
		String sql = "INSERT INTO MEMBER VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)";
		pstmt = conn.prepareStatement(sql);
		
//		int count = 1; // count 활용해도 된다!
		pstmt.setString(1, m.getID());
		pstmt.setString(2, m.getPwd());
		pstmt.setString(3, m.getNAME());
		pstmt.setString(4, m.getGENDER());
		pstmt.setInt(5, m.getAGE());
		pstmt.setString(6, m.getEMAIL());
		pstmt.setString(7, m.getPHONE());
		pstmt.setString(8, m.getADDRESS());
		pstmt.setString(9, m.getHOBBY());
		pstmt.setDate(10, new java.sql.Date(m.getBIRTHDAY().getTime()));
		
		int result = pstmt.executeUpdate();
		
		if(result > 0) {
			System.out.println("Insert 성공");
		} else {
			System.out.println("Insert 실패");
		}
		System.out.println("Insert 종료\n");
	}


	private static void update(String id, String name) throws SQLException {
		System.out.println("Update 시작!!");
		String sql = "update member set name = ? where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, id);
		
		int result = pstmt.executeUpdate();
		if(result > 0) { // 0보다 커야 성공!
			System.out.println("Update 성공!");
		} else {
			System.out.println("Update 실패.");
		}
		System.out.println("Update 종료\n");
	}
	

	private static void delete(String id) throws SQLException {
		System.out.println("delete 시작!!");
		String sql = "delete from member where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		int result = pstmt.executeUpdate();
		if(result > 0) { // 0보다 커야 성공!
			System.out.println("delete 성공!");
		} else {
			System.out.println("delete 실패.");
		}
		System.out.println("delete 종료\n");
	}
}







