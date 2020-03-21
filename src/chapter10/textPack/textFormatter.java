package chapter10.textPack;

import java.text.*;

public class textFormatter {
    public static void main(String[] args) {
        /*
        * ParsePosition.class
        *  - getIndex(), setIndex()
        * */
        ChoiceFormat choiceFormat;
        double[] limits = {1,2,3,4,5,6,7}; //double이여야 한다.
        String[] formats = {"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
        choiceFormat = new ChoiceFormat(limits, formats);
        ParsePosition status = new ParsePosition(0);
        for (double i = 0.0; i <= 8.0; ++i) {
            status.setIndex(0);
            System.out.println(i + " -> " + choiceFormat.format(i) + " -> "
                    + choiceFormat.parse(choiceFormat.format(i),status));
        }

        //==============================//
        DateFormat dateFormat;
        DecimalFormat decimalFormat;
        MessageFormat messageFormat;
        textFormatter numberFormat;
        SimpleDateFormat simpleDateFormat;
    }
}
