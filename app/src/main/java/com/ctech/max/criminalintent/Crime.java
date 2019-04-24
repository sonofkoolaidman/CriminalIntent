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

    //the user can now specify their own UUID
    public Crime(UUID id) {
        mId = id;
        mDate = new Date(); // default the crime date to right now
    }
    // automatically generates a gueranteed unique id if not provided one
    public Crime() {
        this(UUID.randomUUID());
    }
}
