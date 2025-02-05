
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementBasic {
	// DB 연결을 유지하는 객체
	public static Connection conn = null;
	// SQL을 담는 객체
	public static Statement stmt = null;
	// select문의 결과 값을 받는 객체 
	public static ResultSet rs = null;
	
	public static String driverClass = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/jdbc"; // localhost 자기자신
//	public static String url = "jdbc:mysql://127.0.0.1:3306/jdbc"; // 127.0.0.1 = loofback IP, 3306 = 포트주소
	public static String user = "user";
	public static String password = "1234";
	
	public static void main(String[] args) {
		try {
			// 1. 클래스 드라이버 등록 (최초 한번만 필요, 최신버전들은 거의 필요가 없다.)
			Class.forName(driverClass);
			System.out.println("1. 드라이버 등록 성공!");
			
			// 2. Connection = (DB 연결객체) 객체 생성
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("2. DB 접속 및 로그인 성공!");
			
			// 3. 자동 커밋여부 해제 : default - true, false로 설정해야 해제가 된다.
			// -> 사용자가 트랜잭션을 제어한다.
			conn.setAutoCommit(false);
			
			// 4. conn 객체를 통해 DB SQL을 요청할 수 있는 statement 객첼르 생성
			stmt = conn.createStatement();
			System.out.println("3. createStatement 성공!");
			
			// 5. 필요한 쿼리부를 작성
			select();
			
			insert();
			select();
			
			update();
			select();
			
			delete();
			select();
			
			// 6. commit이 필요한 경우 commit
			conn.commit(); // 수동으로 commit 명령을 내리는 방법
//			conn.rollback(); // commit 이후에 실행된 명령을 모두 돌리는 코드
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 생성됬던 객체 Close
			// -> 생성된 객체의 역순으로 Close 수행
			try {
				if(rs != null && rs.isClosed() == false) {
					rs.close();
				}
				if(stmt != null && stmt.isClosed() == false) {
					stmt.close();
				}
				if(conn != null && conn.isClosed() == false) {
					conn.close();
				}
				System.out.println("6. Close 성공!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void select() throws SQLException {
		System.out.println("SELECT문 시작!");
		
		String query = "SELECT * FROM MEMBER"; // 쿼리 끝에 세미콜론 붙이면 에러발생!
		rs = stmt.executeQuery(query); // DB로 query를 날리는 명령
		// rs : db 쿼리 실행 결과가 담기는 객체!
		
		// next : 커서를 넘겨서 다음 행으로 이동하는 명령, 만일 끝일 경우 false 반환
		while(rs.next()) {
			// DB -> java로 결과가 올때는 모든 결과는 문자열로 저장됨
			// DB의 type에 따라서 알맞은 자바 type으로 변경하는 것을 권장
			StringBuffer sb = new StringBuffer();
			
			// 1. index로 db값 가져오는 방법 -> 현업에서는 추천하지 않음
//			sb.append(rs.getInt(1) + ", "); // index로 가져오는 방법
//			sb.append(rs.getString(2) + ", "); 
//			sb.append(rs.getString(3) + ", "); 
//			sb.append(rs.getString(4) + ", "); 
			// index로 가져올 때는 table의 컬럼 순서에 따라 반환된다.
			
			// 2. index로 db값 가져오는 방법, i 활용 -> 현업에서는 추천하지 않음
//			int i = 1;
//			sb.append(rs.getInt(i++) + ", "); // index로 가져오는 방법
//			sb.append(rs.getString(i++) + ", "); 
//			sb.append(rs.getString(i++) + ", "); 
//			sb.append(rs.getString(i++) + ", "); 
			// index로 가져올 때는 table의 컬럼 순서에 따라 반환된다.
			
			// 3. 컬럼명으로 데이터를 가져오는 방법 ✭✭✭✭✭ FM, 정석적인 방법
			// - 컬럼명의 경우 대소문자를 가리지 않고 가져올 수 있음
			// getInt : 숫자로 가져올 때
			// getDouble : 실수를 가져올 때
			// getDate : 날짜로만 이뤄진 데이터 가져올 때
			//           만일 시간이 있는데, Date로 가져온 경우 time부분이 손실 된다.
			// getTimestamp : 날짜와 시간을 모두 갖는 데이터를 가져올 때
			sb.append(rs.getInt("mno")+ ", ");
			sb.append(rs.getString("ID")+ ", ");
			sb.append(rs.getString("password")+ ", ");
			sb.append(rs.getString("NAME")+ ", ");
			sb.append(rs.getString("GENDER")+ ", ");
			sb.append(rs.getDouble("AGE")+ ", ");
			sb.append(rs.getString("EMAIL")+ ", ");
			sb.append(rs.getString("PHONE")+ ", ");
			sb.append(rs.getString("ADDRESS")+ ", ");
			sb.append(rs.getString("HOBBY")+ ", ");
			sb.append(rs.getDate("BIRTHDAY")+ ", ");
			sb.append(rs.getTimestamp("ENROLLDATE")+ ", ");
			System.out.println(sb);
			
		}
		System.out.println("SELECT문 종료!\n");
	}
	
	private static void insert() throws SQLException {
		System.out.println("insert문 시작");
		
		// 텍스트가 너무 긴 경우 중간에 줄넘김 필요!
		// ※ 주의점 : 줄넘김 이후에는 문자열 시작과 끝에 공백을 붙이면 거의 문제가 없다.
		String sql = "INSERT INTO MEMBER "
				     + "VALUES(default, 'test6','1212', '안길동','M', "
				     + "	  28, 'ahn@test.com', '01017778885','서울시 강남구 역삼동 10-5', "
				     + "      '요리,축구,기타', '2001-08-23', default) ";
		int result = stmt.executeUpdate(sql);
		// result : 실행된 행의 갯수
		
		if(result > 0) { // 결과는 보통 0보다 커야한다!
			System.out.println("insert 성공, 결과 : " + result);
		} else {
			System.out.println("insert 실패");
		}
		System.out.println("insert문 종료");
		
	}
	
	private static void update() throws SQLException {
		System.out.println("update 시작!!");

		String sql = "update member set name = '이길동2222' where id = 'test6'";
		int result = stmt.executeUpdate(sql);
		
		if(result > 0) { // 0보다 커야 성공!
			System.out.println("update 성공!");
		} else {
			System.out.println("update 실패.");
		}
		
		System.out.println("update 종료\n");
	}
	
	private static void delete() throws SQLException {
		System.out.println("delete 시작!!");
		String sql = "delete from member where id = 'test6'";
		int result = stmt.executeUpdate(sql);

		if(result > 0) { // 0보다 커야 성공!
			System.out.println("delete 성공!");
		} else {
			System.out.println("delete 실패.");
		}
		
		System.out.println("delete 종료\n");
	}

}
