package com.test.ghiny.timetracker;

/**
 * Created by GhinY on 29/04/2016.
 */
public class TimeRecord {
    String time;
    String note;


    //Constructor#####################################
    public TimeRecord(){
        //Do nothing (General Constructor)
    }
    public TimeRecord(String time, String note){
        this.time = time;
        this.note = note;
    }


    //Getter method##################################
    public String getTime() {
        return time;
    }
    public String getNote(){
        return note;
    }

    //Setter method###################################
    public void setTime(String time){
        this.time = time;
    }
    public void setNote(String note){
        this.note = note;
    }


}
