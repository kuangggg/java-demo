package jdbc;

import java.sql.Time;
import java.sql.Timestamp;

public class Main3 {

    public static void main(String[] args) {

//        final Date date = new Date();
//        System.out.println(date.getTime());
//        System.out.println(System.currentTimeMillis());
//        System.out.println(date.toString());


        final java.sql.Date date1 = new java.sql.Date(System.currentTimeMillis());
        System.out.println(date1.toString());

        final Time time = new Time(System.currentTimeMillis());
        System.out.println(time);

        final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);


    }
}
