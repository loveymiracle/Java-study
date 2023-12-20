
import java.util.Date;

//VO : Table의 컬럼 값을 멤버 변수로 가진 객체
//     Table과 Mapping하여 설계할때는 가급적 Table과 네이밍을 일치하는 것이 일반적인데,
//     컬럼명이 길 경우 Java 스타일로 변경하고 다른 방법으로 Mapping이 필요하다.
//     단, 대소문자는 구별되지 않음으로 무관함.
public class Member {
	private int no; // INT PRIMARY KEY auto_increment,
	private String ID; // VARCHAR(20) NOT NULL unique,
	private String pwd; // VARCHAR(20) NOT NULL,
	private String NAME; // VARCHAR(20) NOT NULL,
	private String GENDER; // VARCHAR(1) CHECK(GENDER IN ('M','F')),
	private int AGE; // INT NOT NULL,
	private String EMAIL; // VARCHAR(30),
	private String PHONE; // CHAR(13),
	private String ADDRESS; // VARCHAR(200),
	private String HOBBY; // VARCHAR(100),
	private Date BIRTHDAY; // DATE,
	private Date ENROLLDATE; // DATETIME DEFAULT NOW()
	// LocalDate, LocalDateTime 사용할 수도 있다!
//	private LocalDate BIRTHDAY;// DATE,
//	private LocalDateTime ENROLLDATE;// DATETIME DEFAULT NOW()

	public Member() {
		super();
	}

	public Member(int mno, String iD, String pwd, String nAME, String gENDER, int aGE, String eMAIL, String pHONE,
			String aDDRESS, String hOBBY, Date bIRTHDAY, Date eNROLLDATE) {
		super();
		this.no = mno;
		ID = iD;
		this.pwd = pwd;
		NAME = nAME;
		GENDER = gENDER;
		AGE = aGE;
		EMAIL = eMAIL;
		PHONE = pHONE;
		ADDRESS = aDDRESS;
		HOBBY = hOBBY;
		BIRTHDAY = bIRTHDAY;
		ENROLLDATE = eNROLLDATE;
	}

	@Override
	public String toString() {
		return "Member [mno=" + no + ", ID=" + ID + ", pwd=" + pwd + ", NAME=" + NAME + ", GENDER=" + GENDER + ", AGE="
				+ AGE + ", EMAIL=" + EMAIL + ", PHONE=" + PHONE + ", ADDRESS=" + ADDRESS + ", HOBBY=" + HOBBY
				+ ", BIRTHDAY=" + BIRTHDAY + ", ENROLLDATE=" + ENROLLDATE + "]";
	}

	public int getMno() {
		return no;
	}

	public void setMno(int mno) {
		this.no = mno;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public int getAGE() {
		return AGE;
	}

	public void setAGE(int aGE) {
		AGE = aGE;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getHOBBY() {
		return HOBBY;
	}

	public void setHOBBY(String hOBBY) {
		HOBBY = hOBBY;
	}

	public Date getBIRTHDAY() {
		return BIRTHDAY;
	}

	public void setBIRTHDAY(Date bIRTHDAY) {
		BIRTHDAY = bIRTHDAY;
	}

	public Date getENROLLDATE() {
		return ENROLLDATE;
	}

	public void setENROLLDATE(Date eNROLLDATE) {
		ENROLLDATE = eNROLLDATE;
	}

}
