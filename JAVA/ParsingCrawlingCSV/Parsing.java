package ex01.parsing;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BoxOfficeOpenApi {
	
	public static final String KEY = "";
	public static final String WEEKLY_BOXOFFICE_XML_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml";
	public static final String WEEKLY_BOXOFFICE_JSON_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json";
	
	
	public static void main(String[] args) {
//		parseWeeklyBoxOfficeByXML("20231126");
		parseWeeklyBoxOfficeByJson("20231126");
		
		
	}
	
	// https://www.delftstack.com/ko/howto/java/java-read-xml/
	public static void parseWeeklyBoxOfficeByXML(String targetDt) {
		try {
			// 1. URL 가공 코드
			StringBuilder urlBuilder = new StringBuilder(WEEKLY_BOXOFFICE_XML_URL);
			urlBuilder.append("?" + "key" + "=" + KEY);
			urlBuilder.append("&" + "targetDt" + "=" + targetDt);
			urlBuilder.append("&" + "weekGb" + "=" + 1); // 주말만 보는 옵션
			
			// URLEncoder.encode : 특정 char-set으로 인코딩 하는 함수, 주로 UTF-8을 사용, UTF-8일 경우 영문은 안해도 무관!
			// 					   한글일 경우는 반드시 UTF-8 포맷팅하는 것을 권장
//			url.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); // 과한 인코딩 예시
//			url.append("&" + "name" + "=" + URLEncoder.encode("홍길동", "UTF-8"));
			System.out.println(urlBuilder);
			
			// 2. URL을 통해 HTML을 요청하는 코드를 작성
			URL url = new URL(urlBuilder.toString()); // url 객체 생성
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // URL을 통해서 Http 연결을 요청
			conn.setRequestMethod("GET"); // get 방식으로  요청을 알리는 코드
			
			// API마다 요청에 대한 property 셋팅이 달라지는 코드
			// 아래 4가지 중에서 골라서 선택을 해야하는데, 안될 수도 있으니 정확한 방법은 API 예제 코드를 참고하거나 문서 참고
//			conn.setRequestProperty("Content-type", "application/json");
//			conn.setRequestProperty("Content-type", "application/xml");
			conn.setRequestProperty("Accept", "application/xml");
//			conn.setRequestProperty("Accept", "application/json");
			System.out.println("Response code : " + conn.getResponseCode()); // 실제 HTTP로 호출을 시도하는 코드
			// 2. URL을 HTTP 객체를 통해 요청하는 코드 끝
			
			// 3. Response code 여부를 판단하고 파싱을 시작하는 코드를 작성
			//     성공은 200번 대
			if(conn.getResponseCode() < 200 || conn.getResponseCode() >= 300) {
				System.out.println("페이지를 찾을 수 없습니다.");
				return;
			}
			
			// 4. XML 파싱 시작, DocumentBuilderFactory 활용 (1.8부터 가능!)
			// Document : 문서, html 원본을 의미, 태그(트리) 상태의 객체
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(conn.getInputStream()); // html 문서를 가져와서 xml 파싱 준비 완료!
			doc.normalizeDocument(); // xml을 표준으로 다시 정리해주는 기능 -> 해도 되고 안해도 될 수도 있음.
			// 셋팅부 끝
			
			// 본격적인 파싱 코드 시작
			System.out.println("Root element(=tag) : " + doc.getDocumentElement().getNodeName());
			System.out.println("----------------------------------------------------------------------------");
			
			// 자식 node 접근하는 방법 -> 트리 순회하는 방법이 필요
			// -> 추천하지 않는 방법
			System.out.println(doc.getDocumentElement().getChildNodes().item(0).getTextContent());
			System.out.println(doc.getDocumentElement().getChildNodes().item(1).getTextContent());
			System.out.println(doc.getDocumentElement().getChildNodes().item(2).getTextContent());
			
			// getElementsByTagName을 통해 순회하는 것을 추천 ✭✭✭✭✭
			// ※ 주의 : 파싱 대상이 되는 문자열은 대소문자 구별됨, 반드시 올바른 대소문자 사용할것
	        // getElementsByTagName : 태그 이름으로부터 node 가져오는 기능, node안에 node 있을수 있는 구조, Tree구조
	        //                        장점 : 자식 부모 상관 없이 tag 이름을 통해서 node 가져올수 있음.
	        //                        s가 붙는 경우 list로 반환됨
//	        <tag-name>content</tag-name>
			System.out.println("boxofficeType : " + doc.getElementsByTagName("boxofficeType").item(0).getTextContent());
			System.out.println("showRange : " + doc.getElementsByTagName("showRange").item(0).getTextContent());
			System.out.println("yearWeekTime: " + doc.getElementsByTagName("yearWeekTime").item(0).getTextContent());
			
			NodeList boxofficeList = doc.getElementsByTagName("weeklyBoxOffice");
			for(int i = 0; i < boxofficeList.getLength(); i++ ) {
				Node node = boxofficeList.item(i);
				System.out.println("\n Current node : " + node.getNodeName());
				if(node.getNodeType() == Node.ELEMENT_NODE) { // ELEMENT_NODE 배열이 아닌 일반 노드 일 때
					Element e = (Element)node;
					System.out.println("rank : " + e.getElementsByTagName("rank").item(0).getTextContent());
					System.out.println("movieNm : " + e.getElementsByTagName("movieNm").item(0).getTextContent());
					System.out.println("openDt : " + e.getElementsByTagName("openDt").item(0).getTextContent());
					System.out.println("audiAcc : " + e.getElementsByTagName("audiAcc").item(0).getTextContent());

					// 가끔 누락된 데이터 값의 예시
					// -> 누락된 데이터는 skip할 수 있도록 try-catch로 싼다.
					try {
						System.out.println("error : " + e.getElementsByTagName("error").item(0).getTextContent());
					} catch (Exception e2) {
//						e2.printStackTrace();
					}
					// 위와 같이 try-catch문으로 도배가 되는 경우 코드가 난잡해짐으로 메소드로 정리해서 빼준다.
					String str = getString(e, "error");
					System.out.println("error : " + str);
					System.out.println();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getString(Element e, String name) {
		try {
			e.getElementsByTagName(name).item(0).getTextContent();
		} catch (Exception e2) {}
		// 전략에 따라.. return 값 달라짐... 
		return null;
//		return ""; // 결측 오류날 수 있음
//		return "-"; // 출력에 -가 나옴
	}
	
	// https://codechacha.com/ko/java-parse-json/
	public static void parseWeeklyBoxOfficeByJson(String targetDt) {
		try {
			// 1. URL 가공 코드
			StringBuilder urlBuilder = new StringBuilder(WEEKLY_BOXOFFICE_JSON_URL);
			urlBuilder.append("?" + "key" + "=" + KEY);
			urlBuilder.append("&" + "targetDt" + "=" + targetDt);
			urlBuilder.append("&" + "weekGb" + "=" + 1); // 주말만 보는 옵션
			
			// URLEncoder.encode : 특정 char-set으로 인코딩 하는 함수, 주로 UTF-8을 사용, UTF-8일 경우 영문은 안해도 무관!
			// 					   한글일 경우는 반드시 UTF-8 포맷팅하는 것을 권장
//			url.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); // 과한 인코딩 예시
//			url.append("&" + "name" + "=" + URLEncoder.encode("홍길동", "UTF-8"));
			System.out.println(urlBuilder);
			
			// 2. URL을 통해 HTML을 요청하는 코드를 작성
			URL url = new URL(urlBuilder.toString()); // url 객체 생성
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // URL을 통해서 Http 연결을 요청
			conn.setRequestMethod("GET"); // get 방식으로  요청을 알리는 코드
			
			// API마다 요청에 대한 property 셋팅이 달라지는 코드
			// 아래 4가지 중에서 골라서 선택을 해야하는데, 안될 수도 있으니 정확한 방법은 API 예제 코드를 참고하거나 문서 참고
//			conn.setRequestProperty("Content-type", "application/json");
//			conn.setRequestProperty("Content-type", "application/xml");
//			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Accept", "application/json");
			System.out.println("Response code : " + conn.getResponseCode()); // 실제 HTTP로 호출을 시도하는 코드
			// 2. URL을 HTTP 객체를 통해 요청하는 코드 끝
			
			// 3. Response code 여부를 판단하고 파싱을 시작하는 코드를 작성
			//    성공은 200번 대
			if(conn.getResponseCode() < 200 || conn.getResponseCode() >= 300) {
				System.out.println("페이지를 찾을 수 없습니다.");
				return;
			}
			
			// 4. Json 파싱부 시작
			// JSONObject : Key-value로 구성된 객체를 의미
			// JSONArray : Json배열로 구성된 객체를 의미
			
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			// JSONParser : 트리 구조로 순회 해야한다.
			JSONParser jsonParser = new JSONParser();
			JSONObject rootObj = (JSONObject) jsonParser.parse(br); // root라 데이터도 없는 곳
			JSONObject childObj = (JSONObject) rootObj.get("boxOfficeResult"); // 데이터가 존재하는 곳
			
			// get : key값으로 value를 가져오는 메소드
			// Root의 자식 출력
			System.out.println("boxofficeType : " + childObj.get("boxofficeType"));
	        System.out.println("showRange : " + childObj.get("showRange"));
	        System.out.println("yearWeekTime : " + childObj.get("yearWeekTime"));
	        System.out.println("weeklyBoxOfficeList : " + childObj.get("weeklyBoxOfficeList").getClass().getName());
	        System.out.println("--------------------------------------------------------------------------");
	        
	        // weeklyBoxOfficeList 반복문으로 순회하는 방법
	        JSONArray array = (JSONArray) childObj.get("weeklyBoxOfficeList");
	        
	        for(int i = 0; i < array.size(); i++) {
	        	JSONObject obj = (JSONObject) array.get(i);
	        	System.out.println("rank : " + obj.get("rank"));
				System.out.println("movieNm : " + obj.get("movieNm"));
				System.out.println("openDt : " + obj.get("openDt"));
				System.out.println("audiAcc : " + obj.get("audiAcc"));
				System.out.println("error : " + obj.get("error")); // 없을 경우 null을 반환!
				System.out.println();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
