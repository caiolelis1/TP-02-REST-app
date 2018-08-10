package br.ufmg.coltec.lolzinho;

/**
 * Created by a2016951782 on 02/08/18.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {

        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://br1.api.riotgames.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public SummonerService getSummonerService() {
        return this.retrofit.create(SummonerService.class);
    }

}
