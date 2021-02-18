package ca.bcit.kang_virdee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NHLTeam {
    @SerializedName("id")
    @Expose
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("name")
    @Expose
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
