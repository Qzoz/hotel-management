/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Quraishi
 */
public class BookingPOJO {
        public String booking_id;
        public CustomerDetailsPOJO customer;
        public RoomsPOJO room;
        public String date_time;
        public String check_out;
        
        private int[] leapMonthDays = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
        private int[] monthDays = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        
        private Map<String, Integer> mappedMonth;

        public BookingPOJO () {
                mappedMonth = new HashMap<>();
                mappedMonth.put("JAN", 1);
                mappedMonth.put("FEB", 2);
                mappedMonth.put("MAR", 3);
                mappedMonth.put("APR", 4);
                mappedMonth.put("MAY", 5);
                mappedMonth.put("JUN", 6);
                mappedMonth.put("JUL", 7);
                mappedMonth.put("AUG", 8);
                mappedMonth.put("SEP", 9);
                mappedMonth.put("OCT", 10);
                mappedMonth.put("NOV", 11);
                mappedMonth.put("DEC", 12);
        }
        
        
        public int getNoOfDays(){
                String[] date_timeST = date_time.split(" ");
                String[] date_timeEN = check_out.split(" ");
                
                int dates1[] = getDateInIntArray(date_timeST[0]);
                int checkInTime = getDaysInYear(dates1[2], dates1[1]) + dates1[0];
                
                int dates2[] = getDateInIntArray(date_timeEN[0]);
                int checkOutTime = getDaysBetweenYears(dates1[2], dates2[2]) +
                        getDaysInYear(dates2[2], dates2[1]) + dates2[0];
                
                int diffDays = checkOutTime - checkInTime;
                
                int time1[] = getTimeInIntArray(date_timeST[1]);
                int time2[] = getTimeInIntArray(date_timeEN[1]);
                
                int hourDiff = (time2[0]*60 + time2[1]) - (time1[0]*60 + time1[1]);
                hourDiff /= 60;
                
                if(hourDiff < -18){
                        diffDays -= 1;
                }
                if(hourDiff > 6){
                        diffDays += 1;
                }
                
                return diffDays;
        }
        
        private int getDaysBetweenYears(int sYear, int eYear){
                int days = 0;
                for(int i = sYear; i < eYear; i++){
                        if(isLeapYear(i)){
                                days += 366;
                        }
                        else{
                                days += 365;
                        }
                }
                return days;
        }
        
        private int getDaysInYear(int year, int month){
                int days = 0;
                if(isLeapYear(year)){
                        for(int i = 0; i < month-1; i++){
                                days += leapMonthDays[i];
                        }
                }
                else{
                        for(int i = 0; i < month-1; i++){
                                days += monthDays[i];
                        }
                }
                return days;
        }
        
        private boolean isLeapYear(int year){
                if((year%100 != 0 && year%4 == 0) || year%400 == 0){
                        return true;
                }
                return false;
        }
        
        private int[] getDateInIntArray(String date){
                String dateItems[] = date.split("-");
                return new int[]{
                        Integer.parseInt(dateItems[0]),
                        mappedMonth.get(dateItems[1]),
                        Integer.parseInt(dateItems[2])
                };
        }
        
        private int[] getTimeInIntArray(String time){
                String timeItems[] = time.split(":");
                return new int[]{
                        Integer.parseInt(timeItems[0]),
                        Integer.parseInt(timeItems[1])
                };
        }
        
        
}
