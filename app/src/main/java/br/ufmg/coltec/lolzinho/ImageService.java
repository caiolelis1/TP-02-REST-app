package br.ufmg.coltec.lolzinho;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by a2016951782 on 16/08/18.
 */

public interface ImageService {

    @GET("champion/{champion}.png")
    Call<Champion> getChampionImage(@Path("champion") String ChampionName);
    @GET("profileicon/{iconId}.png")
    Call<Summoner> getProfileIcon(@Path("iconId") int id);
}
