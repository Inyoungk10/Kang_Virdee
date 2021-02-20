package ca.bcit.kang_virdee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NHLPlayer {
    @SerializedName("id")
    @Expose
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("fullName")
    @Expose
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("currentTeam")
    @Expose
    private NHLTeam team = new NHLTeam();
    public NHLTeam getTeam() {
        return team;
    }
    public void setTeam(NHLTeam team) {
        this.team = team;
    }

    @SerializedName("primaryPosition")
    @Expose
    private Position pos = new Position();
    public Position getPos() {
        return pos;
    }
    public void setPos(Position pos) {
        this.pos = pos;
    }

    @SerializedName("currentAge")
    @Expose
    private int currentAge;
    public int getCurrentAge() {
        return currentAge;
    }
    public void setCurrentAge(int currentAge) {
        this.currentAge = currentAge;
    }

    @SerializedName("nationality")
    @Expose
    private String nationality;
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @SerializedName("link")
    @Expose
    private String link;
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
}
