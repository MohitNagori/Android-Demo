package com.example.mohit.savedstatedemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mohit on 3/6/2018.
 */

public class Record implements Parcelable {

    public static final int GENDER_MALE = 1;
    public static final int GENDER_FEMALE = 2;

    public String firstName, lastName, email, contact;
    public int gender;
    public boolean acceptTermsAndConditions;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.email);
        dest.writeString(this.contact);
        dest.writeInt(this.gender);
        dest.writeByte(this.acceptTermsAndConditions ? (byte) 1 : (byte) 0);
    }

    public Record() {
    }

    protected Record(Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.email = in.readString();
        this.contact = in.readString();
        this.gender = in.readInt();
        this.acceptTermsAndConditions = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Record> CREATOR = new Parcelable.Creator<Record>() {
        @Override
        public Record createFromParcel(Parcel source) {
            return new Record(source);
        }

        @Override
        public Record[] newArray(int size) {
            return new Record[size];
        }
    };
}
