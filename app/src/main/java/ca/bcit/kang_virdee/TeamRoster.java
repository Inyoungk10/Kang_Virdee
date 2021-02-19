package ca.bcit.kang_virdee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamRoster {

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
    private String fullName;
    public String getName() {
        return fullName;
    }
    public void setName(String fullName) {
        this.fullName = fullName;
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
