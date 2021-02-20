package ca.bcit.kang_virdee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BasePlayer {
    @SerializedName("people")
    @Expose
    private ArrayList<NHLPlayer> playerData = new ArrayList<>();
    public ArrayList<NHLPlayer> getPlayerData() {
        return playerData;
    }
    public void setPlayerData(ArrayList<NHLPlayer> playerData) {
        this.playerData = playerData;
    }
}
