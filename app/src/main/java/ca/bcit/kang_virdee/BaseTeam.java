package ca.bcit.kang_virdee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseTeam {
    @SerializedName("teams")
    @Expose
    private ArrayList<NHLTeam> teams = new ArrayList<>();
    public ArrayList<NHLTeam> getTeams() {return teams;}
    public void setTeams(ArrayList<NHLTeam> teams) {this.teams = teams;}
}
