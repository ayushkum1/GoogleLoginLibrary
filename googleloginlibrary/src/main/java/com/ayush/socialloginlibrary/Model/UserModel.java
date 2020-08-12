package com.ayush.socialloginlibrary.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {

    String name, photo, email;

    public UserModel() {
    }

    public UserModel(String name, String photo, String email) {
        this.name = name;
        this.photo = photo;
        this.email = email;
    }

    private UserModel(Parcel in) {
        name = in.readString();
        photo = in.readString();
        email = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(photo);
        dest.writeString(email);
    }
}
