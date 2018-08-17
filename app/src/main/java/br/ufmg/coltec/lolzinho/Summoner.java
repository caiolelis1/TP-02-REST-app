package br.ufmg.coltec.lolzinho;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by a2016951782 on 02/08/18.
 */

public class Summoner {

    @SerializedName("name")
    @Expose public String name;

    @SerializedName("summonerLevel")
    @Expose public long summonerLevel;

    @SerializedName("accountId")
    @Expose public long accountId;

    @SerializedName("id")
    @Expose public long id;

    @SerializedName("tier")
    @Expose public String tier;

    @SerializedName("rank")
    @Expose public String rank;

    @SerializedName("profileIconId")
    @Expose public int profileIconId;
}
