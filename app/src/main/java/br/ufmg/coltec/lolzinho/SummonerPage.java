package br.ufmg.coltec.lolzinho;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SummonerPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summoner_page);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        long summonerLevel = extras.getLong("summonerLevel");
        final long id = extras.getLong("id");
        long accountId = extras.getLong("accountId");
        int profileIconId = extras.getInt("profileIconId");

            SummonerService service1 = new RetrofitConfig().getSummonerService();
            Call<List<Summoner>> enderecoCall1 = service1.getElo(id);

            // fazendo a requisição de forma assíncrona
            enderecoCall1.enqueue(new Callback<List<Summoner>>() {
                @Override
                public void onResponse(Call<List<Summoner>> call, Response<List<Summoner>> response) {
                    List<Summoner> jogador2 = response.body();

                    TextView tier = findViewById(R.id.eloRank);
                    tier.setText(jogador2.get(0).tier);
                    TextView rank = findViewById(R.id.eloTier);
                    rank.setText(jogador2.get(0).rank);

                    ImageView elo = findViewById(R.id.eloImage);

                    if (jogador2.get(0).tier.equals("BRONZE")){
                        if(jogador2.get(0).rank.equals("I")){
                            elo.setImageResource(R.drawable.bronze_i);
                        } else if(jogador2.get(0).rank.equals("II")){
                            elo.setImageResource(R.drawable.bronze_ii);
                        } else if(jogador2.get(0).rank.equals("III")){
                            elo.setImageResource(R.drawable.bronze_iii);
                        } else if(jogador2.get(0).rank.equals("IV")){
                            elo.setImageResource(R.drawable.bronze_iv);
                        } else if(jogador2.get(0).rank.equals("V")){
                            elo.setImageResource(R.drawable.bronze_v);
                        }
                    }
                    else if (jogador2.get(0).tier.equals("SILVER")){
                        if(jogador2.get(0).rank.equals("I")){
                            elo.setImageResource(R.drawable.silver_i);
                        } else if(jogador2.get(0).rank.equals("II")){
                            elo.setImageResource(R.drawable.silver_ii);
                        } else if(jogador2.get(0).rank.equals("III")){
                            elo.setImageResource(R.drawable.silver_iii);
                        } else if(jogador2.get(0).rank.equals("IV")){
                            elo.setImageResource(R.drawable.silver_iv);
                        } else if(jogador2.get(0).rank.equals("V")){
                            elo.setImageResource(R.drawable.silver_v);
                        }

                    } else if(jogador2.get(0).tier.equals("GOLD")) {
                        if (jogador2.get(0).rank.equals("I")) {
                            elo.setImageResource(R.drawable.gold_i);
                        } else if (jogador2.get(0).rank.equals("II")) {
                            elo.setImageResource(R.drawable.gold_ii);
                        } else if (jogador2.get(0).rank.equals("III")) {
                            elo.setImageResource(R.drawable.gold_iii);
                        } else if (jogador2.get(0).rank.equals("IV")) {
                            elo.setImageResource(R.drawable.gold_iv);
                        } else if (jogador2.get(0).rank.equals("V")) {
                            elo.setImageResource(R.drawable.gold_v);
                        }
                    } else if(jogador2.get(0).tier.equals("PLATINUM")) {
                        if (jogador2.get(0).rank.equals("I")) {
                            elo.setImageResource(R.drawable.platinum_i);
                        } else if (jogador2.get(0).rank.equals("II")) {
                            elo.setImageResource(R.drawable.platinum_ii);
                        } else if (jogador2.get(0).rank.equals("III")) {
                            elo.setImageResource(R.drawable.platinum_iii);
                        } else if (jogador2.get(0).rank.equals("IV")) {
                            elo.setImageResource(R.drawable.platinum_iv);
                        } else if (jogador2.get(0).rank.equals("V")) {
                            elo.setImageResource(R.drawable.platinum_v);
                        }
                    }
                    else if(jogador2.get(0).tier.equals("DIAMOND")) {
                        if (jogador2.get(0).rank.equals("I")) {
                            elo.setImageResource(R.drawable.diamond_i);
                        } else if (jogador2.get(0).rank.equals("II")) {
                            elo.setImageResource(R.drawable.diamond_ii);
                        } else if (jogador2.get(0).rank.equals("III")) {
                            elo.setImageResource(R.drawable.diamond_iii);
                        } else if (jogador2.get(0).rank.equals("IV")) {
                            elo.setImageResource(R.drawable.diamond_iv);
                        } else if (jogador2.get(0).rank.equals("V")) {
                            elo.setImageResource(R.drawable.diamond_v);
                        }
                    }

                    // Manipulação do endereço recebido
                }

                @Override
                public void onFailure(Call<List<Summoner>> call, Throwable t) {


                }
            });

        SummonerService service2 = new RetrofitConfig().getSummonerService();
        Call<List<Match>> enderecoCall2 = service2.getMatchId(accountId);

        enderecoCall2.enqueue(new Callback<List<Match>>() {
            @Override
            public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {
                List<Match> partidas = response.body();
            }

            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {

            }
        });

        new DownloadImageTask((ImageView) findViewById(R.id.profile))
                .execute("http://ddragon.leagueoflegends.com/cdn/8.16.1/img/profileicon/"+ profileIconId  +".png");


        ListView languagesListView = findViewById(R.id.partidas);
        languagesListView.setAdapter(new MatchAdapter(this));


        TextView nome = findViewById(R.id.name);
        nome.setText(name);

        TextView lvl = findViewById(R.id.level);
        lvl.setText(String.valueOf(summonerLevel));
    }
}
