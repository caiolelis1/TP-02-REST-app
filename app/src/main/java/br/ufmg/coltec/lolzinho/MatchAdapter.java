package br.ufmg.coltec.lolzinho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by a2016951782 on 16/08/18.
 */

public class MatchAdapter extends BaseAdapter {

    private ArrayList<Match> partidas;
    private Context context;

    public MatchAdapter(SummonerPage summonerPage) {
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Match partida = this.partidas.get(i);


        // recupera a view do adapter que será customizada
        View newView = LayoutInflater.from(this.context).inflate(R.layout.adapter_match, viewGroup, false);


        return newView;
    }
}
