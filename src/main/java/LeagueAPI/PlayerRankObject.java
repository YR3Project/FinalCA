/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeagueAPI;

import java.io.*;
import java.util.*;
import java.net.*;
import javax.json.*;
public class PlayerRankObject {
    public PlayerRank getPlayerRank(String id) throws MalformedURLException, IOException
    {
        URL url = new URL("https://euw.api.riotgames.com/api/lol/EUW/v2.5/league/by-summoner/"+ id +"?api_key=RGAPI-fdf965a6-41b8-4fac-831a-f4aaeb133659");
        
        try(InputStream in = url.openStream();
               BufferedReader reader = new BufferedReader(
               new InputStreamReader(in, "UTF-8")))
        {
            PlayerRank player = new PlayerRank();
            JsonReader jsonReader = Json.createReader(in);
            
            JsonObject jsonObject = jsonReader.readObject();
            
            jsonReader.close();
            in.close();
        
            JsonObject jsonArray = jsonObject.getJsonArray(id).getJsonObject(0);
            String tierName = jsonArray.getString("name");
            String tier = jsonArray.getString("tier");
            
            JsonArray entries = jsonArray.getJsonArray("entries");
            for(int i = 0; i < entries.size(); i++)
            {
               if(id.equals(entries.getJsonObject(i).getJsonString("playerOrTeamId").getString()))
               {
                   String division = entries.getJsonObject(i).getJsonString("division").getString();
                   player.setDivision(division);
                   player.getDivision();
                   int wins = entries.getJsonObject(i).getInt("wins");
                   player.setWins(wins);
                   player.getWins();
                   int losses = entries.getJsonObject(i).getInt("losses");
                   player.setLosses(losses);
                   player.getLosses();
                   int points = entries.getJsonObject(i).getInt("leaguePoints");
                   player.setLeaguePoints(points);
                   player.getLeaguePoints();
               }
            }
            
            player.setTierName(tierName);
            player.setTier(tier);
            
            player.getTierName();
            player.getTier();
            
            return player;
        }
    }
}
