package ca.bcit.kang_virdee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseRoster {
    @SerializedName("roster")
    @Expose
    private ArrayList<TeamRoster> roster = new ArrayList<>();
    public  ArrayList<TeamRoster> getRoster(){return roster;}
    public void setRoster(ArrayList<TeamRoster> roster) {this.roster = roster;}
}
