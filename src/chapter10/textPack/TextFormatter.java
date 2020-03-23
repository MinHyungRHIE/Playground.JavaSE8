package chapter10.textPack;

import java.text.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class TextFormatter {
    public static void main(String[] args) {
        /*
        * ParsePosition.class
        *  - getIndex(), setIndex()
        * */
        ChoiceFormat choiceFormat;
        double[] limits = {1,2,3,4,5,6,7}; //double이여야 한다.
        String[] formats = {"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
        choiceFormat = new ChoiceFormat(limits, formats);
        System.out.println("choiceForamt : " + choiceFormat.format(2));
        ParsePosition status = new ParsePosition(0);
        for (double i = 0.0; i <= 8.0; ++i) {
            status.setIndex(0);
            System.out.println(i + " -> " + choiceFormat.format(i) + " -> "
                    + choiceFormat.parse(choiceFormat.format(i),status));
        }

        //==============================//
        /*
        * the subclass, simpleDateFormat allows to use
        * formatter(date -> text), parsing(text -> date)
        *
        SHORT is completely numeric, such as 12.13.52 or 3:30pm
        MEDIUM is longer, such as Jan 12, 1952
        LONG is longer, such as January 12, 1952 or 3:30:32pm
        FULL is pretty completely specified, such as Tuesday, April 12, 1952 AD or 3:30:42pm PST.
        * */
        Date myDate = new Date();
        DateFormat dateFormat;
//        dateFormat = DateFormat.getDateInstance(); //SimpleDateFormat을 리턴한다. for using format(), parse
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
        System.out.println("myDate : " + myDate);
        System.out.println("DateFormat.getDateInstance().format(myDate) : "
        + dateFormat.format(myDate));
        System.out.println("dateFormat : " + dateFormat.getClass().getName());

        //==============================//
        DecimalFormat decimalFormat;
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println("nf : " + nf.getClass().getName());
        int number = 1000000;
        //#,0,%
        ((DecimalFormat)nf).applyPattern("###,###");

        String numString = nf.format(number);
        System.out.println("numString : " + numString);
        //==============================//
        MessageFormat messageFormat;
        int planet = 7;
        String event = "a disturbance in the Force";
        String result = MessageFormat.format(
                "At {1,time} on {1, date}, there was {2} on planet {0, number, integer}.",
                planet, new Date(), event);
        System.out.println("MessageFormatting result : " + result);
        //==============================//
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy년 MM월 dd일입니다");
        String mySimpleDate = simpleDateFormat.format(new Date());
        System.out.println(mySimpleDate);

        //==============================//
    }
}
