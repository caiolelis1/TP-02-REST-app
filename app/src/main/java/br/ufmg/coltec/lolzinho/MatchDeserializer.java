package br.ufmg.coltec.lolzinho;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a2016951782 on 17/08/18.
 */

public class MatchDeserializer implements JsonDeserializer<List<Match>> {



    @Override
    public List<Match> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        List<Match> partidas = new ArrayList<>();

        JsonObject resp = jsonObject.get("petfinder").getAsJsonObject();
        resp = resp.get("matches").getAsJsonObject();
        JsonArray p = resp.get("pet").getAsJsonArray();

        for(int i =0; i<10;i++) {

            JsonObject obj = p.get(i).getAsJsonObject();
            Match partida = new Match();

            JsonObject gameId = obj.get("gameId").getAsJsonObject();
            partida.gameId = gameId.getAsLong();
            JsonObject champion = obj.get("champion").getAsJsonObject();
            partida.championId = champion.getAsInt();

            partidas.add(partida);
        }

        return partidas;
    }
}
