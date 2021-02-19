package ca.bcit.kang_virdee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NHLRoster {
    @SerializedName("person")
    @Expose
    private Person person = new Person();
    public Person getPerson() {
        return person;
    }
    public void setId(Person person) {
        this.person = person;
    }
}
