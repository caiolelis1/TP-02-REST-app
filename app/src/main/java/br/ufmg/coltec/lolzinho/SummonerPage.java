package br.ufmg.coltec.lolzinho;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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

            SummonerService service1 = new RetrofitConfig().getSummonerService();
            Call<Summoner> enderecoCall1 = service1.getElo(id);

            // fazendo a requisição de forma assíncrona
            enderecoCall1.enqueue(new Callback<Summoner>() {
                @Override
                public void onResponse(Call<Summoner> call, Response<Summoner> response) {
                    Summoner jogador2 = response.body();

                    Log.e("caioopkcaispdoiaxoxwkd", jogador2.tier);
                    Log.e("caioopkcaispdoiaxoxwkd", jogador2.rank);

                    TextView tier = findViewById(R.id.eloRank);
                    tier.setText(jogador2.tier);
                    TextView rank = findViewById(R.id.eloTier);
                    rank.setText(jogador2.rank);

                    // Manipulação do endereço recebido
                }

                @Override
                public void onFailure(Call<Summoner> call, Throwable t) {
                    Log.e("caioopkcaispdoiaxoxwkd", "dklaw", t);
                    Log.e("caioopkcaispdoiaxoxwkd", "jdoai");
                }
            });

            SummonerService MatchService = new RetrofitConfig().getSummonerService();
            Call<List<Match>> MatchCall = MatchService.getMatchId(accountId);

            MatchCall.enqueue(new Callback<List<Match>>() {
                @Override
                public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {
                    Match match = (Match) response.body();
                }

                @Override
                public void onFailure(Call<List<Match>> call, Throwable t) {

                }
            });




        ListView partidasList = (ListView) findViewById(R.id.partidas);


        TextView nome = findViewById(R.id.name);
        nome.setText(name);

        TextView lvl = findViewById(R.id.level);
        lvl.setText(String.valueOf(summonerLevel));
    }
}
