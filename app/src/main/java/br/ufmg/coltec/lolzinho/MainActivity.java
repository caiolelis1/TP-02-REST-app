package br.ufmg.coltec.lolzinho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText summoner = findViewById(R.id.search);
        final Button invocador = findViewById(R.id.summoner);
        final Button campeao = findViewById(R.id.champion);

        invocador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Invocador = summoner.getText().toString();

                SummonerService service = new RetrofitConfig().getSummonerService();
                Call<Summoner> enderecoCall = service.getSummoner(Invocador);

                //fazendo a requisição de forma assíncrona
                enderecoCall.enqueue(new Callback<Summoner>() {
                    @Override
                    public void onResponse(Call<Summoner> call, Response<Summoner> response) {
                        Summoner jogador = response.body();

//                        if(jogador.name.equals(null)){
//                            Toast toast = Toast.makeText(MainActivity.this, "Não existe invocador com este nome", Toast.LENGTH_SHORT);
//                            toast.show();
//                        } else {

                            Intent intent = new Intent(MainActivity.this, SummonerPage.class);


                            Bundle args = new Bundle();
                            args.putString("name", jogador.name);
                            args.putLong("id", jogador.id);
                            args.putLong("accountId", jogador.accountId);
                            args.putLong("summonerLevel", jogador.summonerLevel);
                            args.putInt("profileIconId", jogador.profileIconId);
                            intent.putExtras(args);

                            startActivity(intent);
//                        }
                    }

                    @Override
                    public void onFailure(Call<Summoner> call, Throwable t) {

                    }
                });
            }
        });

        campeao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long championID = Long.valueOf(summoner.getText().toString());

                SummonerService service = new RetrofitConfig().getSummonerService();
                Call<Champion> enderecoCall = service.getChampion(championID);

                // fazendo a requisição de forma assíncrona
                enderecoCall.enqueue(new Callback<Champion>() {
                    @Override
                    public void onResponse(Call<Champion> call, Response<Champion> response) {
                        Champion champion = response.body();

                        Intent intent = new Intent(MainActivity.this, ChampionPage.class);

                        Bundle args = new Bundle();
                        args.putLong("id", champion.id);
                        args.putString("title", champion.title);
                        args.putString("name", champion.name);
                        intent.putExtras(args);

                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Champion> call, Throwable t) {

                    }

                });
            }
        });


   }


}