package chapter10.date;

import java.time.*;

public class JavaTimePack {
    public static void main(String[] args) {
        /*
        * [java.time]
        * Instant /Epoch(UTC) 사용 - 초,나노초(10억분의 1초), 1/1000초(millisecond)
        * LocalDate + LocalTime --> LocalDateTime
        * LocalDateTime + 시간대 --> ZonedDateTime
        * ZoneOffset : UTC로부터 얼마나 떨어져 있는지 + ZoneId
        * OffsetDateTime : ZoneOffset에서 ZoneId가 빠짐
        *
        * 날짜 - 날짜 = Period
        * 시간 - 시간 = Duration
        * between() -static, until() -instance
        * of(), with()
        * plus(), minus()
        * get(), to()
        *
        *
        * [java.time.chrono] - 다양한 연대 지원
        * 표준이 아닌 달력 시스템 제공
        * ex)Gregorian력이 아닌 태국
        *
        * [java.time.format] - 시간 형식 관련 기능 지원
        * DateTimeFormatter
        * .format(날짜시간) return String
        * ofPattern("형식 커스텀")
        *
        * [java.time.temporal] - java.time을 위한 인터페이스
        * java.time의 날짜와 시간을 표현하기 위한 클래스들이 모여있음
        *
        * [java.time.zone] - 시간대 관련 기능 지원
        *
        * ============================================
        * Unit과 Field
        *  - Unit : 단위(Hours, Months) TemporalUnit *impl:ChronoUnit
        *  - Field : 필드(DAY_OF_YEAR, DAY_OF_MONTH) TemporalField *impl:ChronoField
        * */
        LocalDateTime nowDate = LocalDateTime.now();
        LocalDateTime ofDate = LocalDateTime.of(2020,3,21,12,31,59);
        LocalDateTime fromDate = LocalDateTime.from(nowDate);
        System.out.println(nowDate);
        System.out.println(ofDate);
        System.out.println(fromDate);

        //field 변경 : with(), plus(), minus()
        //시간비교 : isAfter(), isBefore(), isEqual()

        //UTC 사용
        Instant now = Instant.now();
        Instant now2 = Instant.ofEpochSecond(now.getEpochSecond());
        Instant now3 = Instant.ofEpochSecond(now.getEpochSecond(),now.getNano());
        System.out.println(now);
        System.out.println(now2);
        System.out.println(now3);

        LocalDate date = LocalDate.of(2015,12,31);
        LocalTime time = LocalTime.of(12,34,56);
        LocalDateTime dt = LocalDateTime.of(date,time);

        ZoneId zid = ZoneId.of("Asia/Seoul");
        ZonedDateTime zdt = dt.atZone(zid);
//        String strZid = zdt.getZone().getId();

        ZonedDateTime seoulTime = ZonedDateTime.now();
        ZoneId nyId = ZoneId.of("America/New_York");
        ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyId);

        //ZonedDateTime -> offsetDateTime
        OffsetDateTime odt = seoulTime.toOffsetDateTime();
        System.out.println("========================");
        System.out.println(dt);
        System.out.println(zid);
        System.out.println(zdt);
        System.out.println(seoulTime);
        System.out.println(nyTime);
        System.out.println(odt);


    }
}
