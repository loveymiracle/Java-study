package ex02.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupExam {
	
	// https://offbyone.tistory.com/116
	public static void main(String[] args) throws IOException {
		// 다음 뉴스 페이지 크롤링 예제
		String URL = "http://media.daum.net/digital/";
		
//		<li>
//        <strong class="tit_g">
//            <span class="info_cp">아시아경제</span>
//            <a href="https://v.daum.net/v/20231201081157040" class="link_txt">카카오 폭로전…내홍 수습 나선 홍은택</a>
//        </strong>
//   	</li>

		Connection conn = Jsoup.connect(URL);
		Document doc = conn.get(); // Document : html 문서를 의미
		
		List<Element> newsList = new ArrayList<>();
		
		// Elements : 태그 List로 구성된 객체
		// Element : 태그 하나만 의미
		
		// 태그 기준으로 가져오는 방법
		Elements elements = doc.getElementsByTag("a"); // 태그 기준으로 원하는 태그만 가져오는 메소드
		for(int i = 0; i < elements.size(); i++) {
//			System.out.println(element);
			Elements elements2 = elements.get(i).getElementsByClass("link_txt");
			if(elements2.size() > 0 && elements2.toString().contains("#direct_") == false) {
//				System.out.println(elements2);
				
			}
		}
		System.out.println("-------------------------------------------------------------------------------");
		
		// Class + 부모 자식으로 검색하는 방법 (1) -> 자식 구조 영향 없음
		Element newsmajorElement = doc.getElementsByClass("list_newsmajor").get(0);
//		System.out.println(newsmajorElement);
		Elements newListElements = newsmajorElement.getElementsByTag("strong");
		for(int i = 0; i < newListElements.size(); i++) {
			Element spanTag = newListElements.get(i).getElementsByTag("span").get(0);
			Element aTag = newListElements.get(i).getElementsByTag("a").get(0);
			System.out.println("제목 : " + aTag.text());
			System.out.println("링크 : " + aTag.attr("href"));
			System.out.println("작성자 : " + spanTag.text());
			System.out.println();
		}
		System.out.println("-------------------------------------------------------------------------------");
		
		// Class + 부모 자식으로 검색한느 방법 (2) -> 자식 구조 영향 있음
		Element newsmajorElement1 = doc.getElementsByClass("list_newsmajor").get(0);
//		System.out.println(newsmajorElement);
		Elements newListElements1 = newsmajorElement.getElementsByTag("strong");
		for(int i = 0; i < newListElements.size(); i++) {
			Element spanTag = newListElements1.get(i).child(0); // 자식으로 접근하는 방법
			Element aTag = newListElements.get(i).child(1);
			System.out.println("제목 : " + aTag.text());
			System.out.println("링크 : " + aTag.attr("href"));
			System.out.println("작성자 : " + spanTag.text());
			System.out.println();
		}
		System.out.println("css-------------------------------------------------------------------------------");
		
		// css query를 통해 접근하는 방법 (class를 통해 접근하는 방법)
//		Elements newListElements2 = doc.select(".list_newsmajor .tit_g");
		Elements newListElements2 = doc.select(".list_newsmajor strong"); // class : list_newsmajor
		for(int i = 0; i < newListElements2.size(); i++) {
			Element spanTag = newListElements.get(i).getElementsByTag("span").get(0);
			Element aTag = newListElements.get(i).getElementsByTag("a").get(0);
			System.out.println("제목 : " + aTag.text());
			System.out.println("링크 : " + aTag.attr("href"));
			System.out.println("작성자 : " + spanTag.text());
			System.out.println();
		}
		System.out.println("-------------------------------------------------------------------------------");
		
		System.out.println("벅스 100");
		URL = "https://music.bugs.co.kr/chart";
		conn = Jsoup.connect(URL);
		doc = conn.get();
		Elements titles = doc.select(".title > a");
		Elements artist = doc.select(".artist > a");
		for(int i = 0; i < titles.size(); i++) {
			System.out.println(i + 1 + "위 : ");
			System.out.println(titles.get(i).text().strip() + " - ");
			System.out.println(artist.get(i).text().strip());
			System.out.println();
		}
	}
}
