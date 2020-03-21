package chapter10.date;

public class DateAndCalendar {

    public static void main(String[] args) {
        /*
         * Date클래스는 JDK 1.0부터 있던 클래스이다.
         * java.util.Date / java.sql.Date
         * java.sql.Date는 java.util.Date로부터 상속받은 클래스
         * java.sql.Date는 millisecond의 wrapper 클래스 JDBC를 통해 DBMS의 Date 타입을 식별하기 위해 사용
         * */
        java.util.Date uDate = new java.util.Date(); //Date + Time
        System.out.println(uDate);
        System.out.println(uDate.getTime()); //millisecond
        java.sql.Date sDate = new java.sql.Date(uDate.getTime()); //Date
        System.out.println(sDate);

        System.out.println("||||||||||||||||||||||||||||||||||");

        /*
        * Calendar 클래스는 Date 클래스의 단점을 보완하기 위해서 JDK1.1 때 나왔다.
        *
        * */
        java.util.Calendar c = java.util.Calendar.getInstance();


    }
}
