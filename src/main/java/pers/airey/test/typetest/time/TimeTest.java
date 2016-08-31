package pers.airey.test.typetest.time;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Airey on 2016/8/29.
 */
public class TimeTest {
    static  void testDate() {
        System.out.println("start testDate");
        Date date = new Date(); //Date 类被设计为用于时间点 年月日日历用Calendar更加合适
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println("end testDate");
    }

    static void testCalender() {
        System.out.println("start testCalender");
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH)); //从0开始
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("end testCalender");
    }

    public static void main(String[] args) {
        //testDate();
        testCalender();
    }
}
