package com.company.calender;

import com.company.dataStructure.MyStack;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderStack {

    public static void main(String[] args) {

        //	stack to store weeks
        MyStack<WeekS> weekStack = new MyStack<WeekS>();
        Calendar calendar = null;	// calendar reference

        int mon = Integer.parseInt(args[0]);
        // adding 0 if month number is single digit
        String month = mon < 10 ? ("0" + String.valueOf(mon)) : String.valueOf(mon);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");

        System.out.println(new DateFormatSymbols().getMonths()[mon - 1] + " " + args[1]);
        System.out.println("\nSu\tM\tT\tW\tTh\tF\tSa");

        Date date = null;
        try {
            date = sdf.parse("01 " + month + " " + args[1]);
            calendar = Calendar.getInstance();
            calendar.setTime(date);	//	setting date as '1'
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // getting maximum number of days in the month
        int totalDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // getting last day of the month
        try {
            date = sdf.parse(totalDays + " " + month + " " + args[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        int lastDay = calendar.get(Calendar.DAY_OF_WEEK);

        // getting total number of weeks in a month
        int totalWeeks = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);

        int currentDate = totalDays; // starting from last day

        for (int i = 0; i < totalWeeks; i++) {
            WeekS weekNum = new WeekS(); // week object for a week
            weekStack.push(weekNum);
            for (int j = 7; j > 0; j--) {
                // pushes a day
                if ((i == 0) && j > (lastDay)) {
                    weekNum.weekDayStack.push(new WeekDay(dayName(j), " "));
                } else if (currentDate > 0) {
                    weekNum.weekDayStack.push(new WeekDay(dayName(j), String.valueOf(currentDate)));
                    currentDate--;
                } else
                    weekNum.weekDayStack.push(new WeekDay(" ", " "));
            }
        }

        // pop and print
        for (int i = 0; i < totalWeeks; i++) {
            WeekS weekNum = weekStack.pop();
            for (int j = 0; j < 7; j++) {
                WeekDay weekDay = weekNum.weekDayStack.pop();
                System.out.print(weekDay.date + "\t");
            }
            System.out.println();
        }
    }

    // returns day from integer
    static String dayName(int i) {
        return switch (i) {
            case 1 -> "Su";
            case 2 -> "M";
            case 3 -> "T";
            case 4 -> "W";
            case 5 -> "Th";
            case 6 -> "F";
            default -> "Sa";
        };

    }
}