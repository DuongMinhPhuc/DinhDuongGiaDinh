package phucduongcom.dinhduonggiadinh.model;

import java.io.Serializable;

/**
 * Created by phucd on 10/25/2017.
 */

public class User implements Serializable{
    private String mName;
    private int mCount;
    private int mID;

    public User(String mName, int mCount, int mID) {
        this.mName = mName;
        this.mCount = mCount;
        this.mID = mID;
    }

    public User(String mName, int mCount) {
        this.mName = mName;
        this.mCount = mCount;
    }

    public User() {
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmCount() {
        return mCount;
    }

    public void setmCount(int mCount) {
        this.mCount = mCount;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }
}
