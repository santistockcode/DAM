package com.santi.ficusing;

import java.util.Date;
import java.util.UUID;
//Class to define principal object of the application, that is, plant.
public class Plant {

    private UUID mId;
    private String mName;
    private String mAbout;
    private int mFrequency;
    private int mState;
    private int mBackFrequency;
    private Date mAlarm;

    //Constructor with universal unique identifier and Date.
    public Plant(){
        this (UUID.randomUUID());
    }
    public Plant(UUID id){
        mId = id;
        mAlarm = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getAbout() {
        return mAbout;
    }

    public int getFrequency() {
        return mFrequency;
    }

    public int getState() {
        return mState;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setAbout(String about) {
        mAbout = about;
    }

    public void setFrequency(int frequency) {
        mFrequency = frequency;
    }

    public void setState(int state) {
        mState = state;
    }

    public Date getAlarm() {return mAlarm;}

    public void setAlarm(Date alarm) {mAlarm = alarm; }

    public String getPhotoFilename(){
        return "IMG_"+getId().toString()+".jpg";
    }

    public int getBackFrequency() {
        return mBackFrequency;
    }

    public void setBackFrequency(int backFrequency) {
        mBackFrequency = backFrequency;
    }


}
