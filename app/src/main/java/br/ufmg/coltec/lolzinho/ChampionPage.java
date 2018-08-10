package br.ufmg.coltec.lolzinho;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChampionPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_page);


        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        String title = extras.getString("title");
        long id = extras.getLong("id");

        TextView nome = findViewById(R.id.nome);
        nome.setText(name);
        TextView titulo = findViewById(R.id.titulo);
        titulo.setText(title);
    }
}
