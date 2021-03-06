/*
 * Simple Class to handle TimerTask's
 */
package com.csci360.alarmclock.domain.TimerTest;
import java.util.TimerTask;

/**
 *
 * @author brycebarrett
 */
public class KeepingTime extends TimerTask {
    private int hours;
    private int minutes;
    private int seconds;
    private String meridian;
    private boolean militaryTime;
    
    public KeepingTime(int hours, int minutes, int seconds, String meridian,
            boolean militaryTime){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.meridian = meridian;
        this.militaryTime = militaryTime;
    }
    
    public KeepingTime(){
        hours = 0;
        minutes = 0;
        seconds = 0;
        meridian = "AM";
        militaryTime = false;
    }
         
    @Override
    public void run(){
        
        /*
        *Large nested if to handle military and non-military time.
        */
        if(militaryTime == false){
            if(seconds == 59){
                if(minutes == 59){
                    if(hours == 12){
                        hours = 1;
                    }
                    else{
                        if(hours == 11){
                            if(meridian.equals("AM")){
                                meridian = "PM";
                            }
                            else{
                                meridian = "AM";
                            }
                        }
                        hours++;
                    }
                    minutes = 0;
                }
                else{
                    minutes++;
                }
                seconds = 0;
            }
            else{
                seconds++;
            }
        }
        else{
            if(seconds == 59){
                if(minutes == 59){
                    if(hours == 23){
                        hours = 0;
                    }
                    else{
                        hours++;
                    }
                    minutes = 0;
                }
                else{
                    minutes++;
                }
                seconds = 0;
            }
            else{
                seconds++;
            }
        }
        
        //Check to print out the meridian if military time is not being used
        if(militaryTime == false){
            System.out.println(Integer.toString(hours) + ": " + Integer.toString(minutes) + 
                "." + Integer.toString(seconds) + " " + meridian);
        }
        else{
            System.out.println(Integer.toString(hours) + ": " + Integer.toString(minutes) + 
                "." + Integer.toString(seconds));
        }
        
    }
    
    @Override
    public String toString(){
        return Integer.toString(hours) + ": " + Integer.toString(minutes) +
                "." + Integer.toString(seconds);
    }
    
//    public static void main(String[] args) {
//
//        TimerTask timeTest = new KeepingTime();
//        timeTest.run();
//        System.out.print(timeTest.toString());
//    }
    
}
