package ca.bcit.kang_virdee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseRoster {
    @SerializedName("roster")
    @Expose
    private ArrayList<NHLRoster> roster = new ArrayList<>();
    public  ArrayList<NHLRoster> getRoster(){return roster;}
    public void setRoster(ArrayList<NHLRoster> roster) {this.roster = roster;}
}
