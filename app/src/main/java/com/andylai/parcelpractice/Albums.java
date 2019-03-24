package com.andylai.parcelpractice;

import android.os.Parcel;
import android.os.Parcelable;

public class Albums implements Parcelable {

    Albums(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    int userId;
    int id;
    String title;

    public static final Creator<Albums> CREATOR = new Creator<Albums>() {
        @Override
        public Albums createFromParcel(Parcel in) {
            return new Albums(in);
        }

        @Override
        public Albums[] newArray(int size) {
            return new Albums[size];
        }
    };

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeInt(id);
        dest.writeString(title);
    }

    protected Albums(Parcel in) {
        userId = in.readInt();
        id = in.readInt();
        title = in.readString();
    }
}
