package br.ufmg.coltec.lolzinho;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by a2016951782 on 06/08/18.
 */

public class Champion {

    @SerializedName("id")
    @Expose public int id;

    @SerializedName("name")
    @Expose public String name;

    @SerializedName("title")
    @Expose public String title;
}
