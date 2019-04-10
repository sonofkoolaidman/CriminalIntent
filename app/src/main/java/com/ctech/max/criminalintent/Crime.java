package com.ctech.max.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {

    public UUID getId() {
        return mId;
    }

    private UUID mId;   //the crime's unique id

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    private String mTitle;  //title of the crime

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        this.mDate = date;
    }

    private Date mDate;  //date of the crime

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        this.mSolved = solved;
    }

    private boolean mSolved;  //has the crime been solved?

    public Crime() {
        mId = UUID.randomUUID(); //automatically generate a random id
        mDate = new Date(); //defaults the date to right now
    }
}
