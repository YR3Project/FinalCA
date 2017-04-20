/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeagueAPI;

import java.io.*;
import javax.json.*;
import java.net.*;

/**
 *
 * @author PC
 */
public class PlayerObject {
    public Player getPlayer(String name, String region) throws MalformedURLException, IOException, UnknownHostException
    {
        URL url = new URL("https://"+region + "1.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+ name +"?api_key=RGAPI-fdf965a6-41b8-4fac-831a-f4aaeb133659");
        
            try(InputStream in = url.openStream();
                   BufferedReader reader = new BufferedReader(
                   new InputStreamReader(in, "UTF-8")))
            {
                Master master = new Master();
                JsonReader jsonReader = Json.createReader(in);

                JsonObject jsonObject = jsonReader.readObject();

                jsonReader.close();
                in.close();

                Player player = new Player();

                player.setName(name);
                player.setSummonerID(jsonObject.getInt("id"));
                
                player.getName();
                player.getSummonerID();
                return player;
            }
    }
}
