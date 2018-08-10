package br.ufmg.coltec.lolzinho;
/**
 * Created by a2016951782 on 02/08/18.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SummonerService {

    @GET("/lol/summoner/v3/summoners/by-name/{summonerName}?api_key=RGAPI-a705db8e-1d93-4259-a24c-935822ee6974")
    Call<Summoner> getSummoner(@Path("summonerName") String Invocador);

    @GET("/lol/league/v3/positions/by-summoner/{summonerId}?api_key=RGAPI-a705db8e-1d93-4259-a24c-935822ee6974")
    Call<Summoner> getElo(@Path("summonerId") long id);

    @GET("/lol/static-data/v3/champions/{id}?api_key=RGAPI-a705db8e-1d93-4259-a24c-935822ee6974")
    Call<Champion> getChampion(@Path("id") long id);

    @GET("/lol/match/v3/matchlists/by-account/{accountId}?queue=420?api_key=RGAPI-a705db8e-1d93-4259-a24c-935822ee6974")
    Call<List<Match>> getMatchId(@Path("accountId") long id);

    @GET("/lol/match/v3/matches/{matchId}?api_key=RGAPI-a705db8e-1d93-4259-a24c-935822ee6974")
    Call<Match> getMatchInfo(@Path("matchId") long id);

}

