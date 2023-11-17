package hw.ex05.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// 날짜 관련 Library
public class DateTest {
	public static void main(String[] args) throws ParseException {
		// Date : java 1.0 부터 날짜 Type 활용, Calendar와 병행 사용을 권장 -> LocalDateTime으로 교체되고 있다.
		Date date = new Date();
		System.out.println(date); // 오늘 날짜, -> 미국식 표기
		System.out.println(date.getTime()); // since January 1, 1970, 00:00:00, 단위 : ms = 1/1000초
		System.out.println(System.currentTimeMillis());
		// GMT -> 그리니치 표준시, 영국 : 0시, 우리나라 : GMT + 9, 9시간 시차 존재!
		// 1699600775017 -> 1970년 1월 1일 0시로부터 현재까지 흐른 ms 시차!
		
		Date date2 = new Date(System.currentTimeMillis());
		System.out.println(date2);
		
		// Date format 바꾸는 방법 ✭✭✭✭✭
		// https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분 ss초");
		// MM : 월, mm : 분
		System.out.println(sdf1.format(new Date()));
		System.out.println(sdf2.format(new Date()));
		System.out.println("-----------------------------------------");
		// 문자열 -> 날짜로 변경하는 방법
		Date d = sdf1.parse("2023-11-10(금) 04:29:13");
		System.out.println(sdf1.format(d));
		
		// Calendar : Date 단점을 보완한 Library, date에서 delicate 된 메소드를 Calendar에서 사용하면 된다. 
		// 특징 : 자체 생성이 불가능!!
//		Calendar cal = new Calendar(); // abstract class 라 생성되지 않음
		Calendar cal = Calendar.getInstance(); // Class를 대신 생성시켜주는 생성자 패턴
		System.out.println(cal.toString().replace(",", ",\n")); // GregorianCalendar
		
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1); // +1 
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.AM_PM));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		String dateStr1 = sdf1.format(cal.getTime());
		String dateStr2 = sdf1.format(cal.getTimeInMillis());
		System.out.println(dateStr1);
		System.out.println(dateStr2);
		
		// 날짜를 지정해서 생성 시키는 방법 : GregorianCalendar를 권장
		GregorianCalendar gc = new GregorianCalendar(2000, 5-1, 10); // 2000-05-10
		System.out.println(sdf1.format(gc.getTime()));
		
		// 날짜간 대소 비교
		System.out.println(gc.after(cal));
		System.out.println(gc.before(cal));
		
		// 날짜 더하기
		gc.add(cal.DAY_OF_MONTH, 1);
		System.out.println(sdf1.format(gc.getTime()));
		System.out.println("----------------------------------------");
		
		// Java8 이후 추가된 java.time
		// - 기존 Date, Calendar 체계보다 성능적으로나 활용적으로 더 좋은 Joda-Time을 내장 시켯다.
		// - 하지만 기존 DB와 호환성 이슈와 jsp와 궁합이 맞지 않아서 활용하기 까다롭다.
		//   -> 가급적 안쓸 예정. 프로젝트 때 이슈가 많아져서 수업 떄는 Date type을 선호
		
		LocalDate localDate = LocalDate.now(); // 날짜 까지만 다룰 때
		LocalTime localTime = LocalTime.now(); // 시간만 다룰 때
		LocalDateTime localDateTime = LocalDateTime.now(); // 날짜 + 시간
		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println(localDateTime); // ISO 표준 포멧팅
		// the ISO-8601 calendar system. such as 2007-12-03T10:15:30.
		
		// 년월일시분 까지 다루는 방법
		LocalDateTime birthDay = LocalDateTime.of(1996, 03, 24, 12, 0);
		System.out.println(birthDay);
		System.out.println(birthDay.format(DateTimeFormatter.ISO_DATE_TIME));
		System.out.println(birthDay.format(DateTimeFormatter.ISO_DATE));
		System.out.println(birthDay.format(DateTimeFormatter.ISO_TIME));
		System.out.println(birthDay.format(DateTimeFormatter.ISO_WEEK_DATE)); // 주단위
		
		// Zone
		ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(ZoneId.of("Asia/Seoul")); 
		System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
		System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
		System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));

//		ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(ZoneId.of("Europe/London")); 
//		System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
//		System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
//		System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
//		System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
//		System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));

		// 날짜 연산
		LocalDate dateTime1 = LocalDate.of(2023, 11, 9);
		LocalDate dateTime2 = LocalDate.now();
		
		System.out.println(dateTime1.isAfter(dateTime2));
		System.out.println(dateTime2.isAfter(dateTime1));
		Period period = Period.between(dateTime1, dateTime2);
		System.out.println(period.getDays());
		
		System.out.println(dateTime1.plusDays(5));
		System.out.println(dateTime1.minusDays(5));
		System.out.println(dateTime1.plusWeeks(1));
		System.out.println(dateTime1.minusWeeks(1));
		System.out.println(dateTime1.plusMonths(5));
		System.out.println(dateTime1.minusMonths(5));
				
		// Date -> LocalDateTime
		Date d1 = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(d1.toInstant(), ZoneId.systemDefault());
		System.out.println(ldt);
				
		// LocalDateTime -> Date
		LocalDateTime ldt2 = LocalDateTime.now();
		Date d2 = Date.from(ldt2.toInstant(ZoneOffset.ofHours(9)));
		System.out.println(d2);
		// 결론!! 날짜 계산은 Java로 다루기 까다로움으로 보통 DB 날짜 연산을 통해 쉽게 구현할 수 있다.
	}
}
