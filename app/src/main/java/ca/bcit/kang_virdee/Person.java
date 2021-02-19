package ca.bcit.kang_virdee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Person {
    @SerializedName("fullName")
    @Expose
    private String fullName;
    public String getFullName() {
        return fullName;
    }
    public void setfullName(String fullName) {
        this.fullName = fullName;
    }
}
