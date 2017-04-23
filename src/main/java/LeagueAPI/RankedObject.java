/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeagueAPI;

import java.io.*;
import java.net.*;
import javax.json.*;
public class RankedObject {
    public RankedStats getRankedStats(int id, String region, String season) throws MalformedURLException, IOException
    {
        URL url = new URL("https://"+ region +".api.riotgames.com/api/lol/"+ region + "/v1.3/stats/by-summoner/"+ id +"/ranked?season="+ season + "&api_key=RGAPI-fdf965a6-41b8-4fac-831a-f4aaeb133659");
        try(InputStream in = url.openStream();
                   BufferedReader reader = new BufferedReader(
                   new InputStreamReader(in, "UTF-8")))
            {
                RankedStats stats = new RankedStats();
                //Reads the URL
                JsonReader jsonReader = Json.createReader(in);
                JsonObject jsonObject = jsonReader.readObject();
                //The data is read and created so can close the readers
                jsonReader.close();
                in.close();
                
                //Finding values from inside the Json
                int champID = jsonObject.getJsonArray("champions").getJsonObject(0).getInt("id");
                int champID2 = jsonObject.getJsonArray("champions").getJsonObject(1).getInt("id");
                int champID3 = jsonObject.getJsonArray("champions").getJsonObject(2).getInt("id");
                
                //Finding objects inside the jsonarray
                JsonObject champions = jsonObject.getJsonArray("champions").getJsonObject(0).getJsonObject("stats");
                JsonObject champions2 = jsonObject.getJsonArray("champions").getJsonObject(1).getJsonObject("stats");
                JsonObject champions3 = jsonObject.getJsonArray("champions").getJsonObject(2).getJsonObject("stats");
                //Get the items inside the Object "stats"
                int totalDamage = champions.getInt("totalPhysicalDamageDealt");
                int totalDamageDealt = champions.getInt("totalDamageDealt");
                int mostKills = champions.getInt("maxChampionsKilled");
                int mostDeaths = champions.getInt("maxNumDeaths");
                int wins = champions.getInt("totalSessionsWon");
                int losses = champions.getInt("totalSessionsLost");
                
                int totalDamage2 = champions2.getInt("totalPhysicalDamageDealt");
                int totalDamageDealt2 = champions2.getInt("totalDamageDealt");
                int mostKills2 = champions2.getInt("maxChampionsKilled");
                int mostDeaths2 = champions2.getInt("maxNumDeaths");
                int wins2 = champions2.getInt("totalSessionsWon");
                int losses2 = champions2.getInt("totalSessionsLost");
                
                int totalDamage3 = champions3.getInt("totalPhysicalDamageDealt");
                int totalDamageDealt3 = champions3.getInt("totalDamageDealt");
                int mostKills3 = champions3.getInt("maxChampionsKilled");
                int mostDeaths3 = champions3.getInt("maxNumDeaths");
                int wins3 = champions3.getInt("totalSessionsWon");
                int losses3 = champions3.getInt("totalSessionsLost");
                
                
                
                //Inputting values into the array
                /*JsonArray array = jsonObject.getJsonArray("champions");
                int[] values = new int[5];
                for(int i = 0; i < 5;i++)
                {
                    JsonObject championsArray = array.getJsonObject(i).getJsonObject("stats");
                    int mostWins = championsArray.getInt("totalSessionsWon");
                    int champID2 = jsonObject.getJsonArray("champions").getJsonObject(i).getInt("id");
                    
                    values[i] = mostWins;
                    values[i] = champID2;
                    stats.setArray(values);
                    stats.getArray();
                }
                
                */
                //First item
                //Users ID
                stats.setId(id);
                //Users Stats
                
                stats.setMostDeaths(mostDeaths);
                stats.setMostKills(mostKills);
                stats.setTotalDamage(totalDamage);
                stats.setTotalDamageDealt(totalDamageDealt);
                stats.setChampID(champID);
                stats.setWins(wins);
                stats.setLosses(losses);
                //Second item
                
                stats.setMostDeaths2(mostDeaths2);
                stats.setMostKills2(mostKills2);
                stats.setTotalDamage2(totalDamage2);
                stats.setTotalDamageDealt2(totalDamageDealt2);
                stats.setChampID2(champID2);
                stats.setWins2(wins2);
                stats.setLosses2(losses2);
                //Third item
                
                stats.setMostDeaths3(mostDeaths3);
                stats.setMostKills3(mostKills3);
                stats.setTotalDamage3(totalDamage3);
                stats.setTotalDamageDealt3(totalDamageDealt3);
                stats.setChampID3(champID3);
                stats.setWins3(wins3);
                stats.setLosses3(losses3);
                
                //Get the stats
                stats.getChampID();
                stats.getId();
                stats.getMostDeaths();
                stats.getMostKills();
                stats.getTotalDamage();
                stats.getTotalDamageDealt();
                
                return stats;
            }
    }
}
