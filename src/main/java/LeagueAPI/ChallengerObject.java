/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeagueAPI;

import java.util.*;
import java.io.*;
import java.net.*;
import javax.json.*;
public class ChallengerObject {
    public Challenger getChallenger(String region) throws MalformedURLException, IOException
    {
        URL url = new URL("https://"+ region +".api.riotgames.com/api/lol/"+ region + "/v2.5/league/challenger?type=RANKED_SOLO_5x5&api_key=RGAPI-fdf965a6-41b8-4fac-831a-f4aaeb133659");
       
       try(InputStream in = url.openStream();
               BufferedReader reader = new BufferedReader(
               new InputStreamReader(in, "UTF-8")))
        {
            Challenger challenger = new Challenger();
            JsonReader jsonReader = Json.createReader(in);
            
            JsonObject jsonObject = jsonReader.readObject();
            
            jsonReader.close();
            in.close();
            
           
            
            
            String jsonArrayTest = null;
            for(int i = 0; i < 10; i++)
            {
                jsonArrayTest = jsonObject.getJsonArray("entries").getJsonObject(i).getString("playerOrTeamName");
                challenger.setPlayerName(jsonArrayTest);
            }
            
           
            int jsonArrayTest2;
            ArrayList<String> arrays = new ArrayList();
            
            for(int j = 0; j < 10; j++)
            {
                //jsonArrayTest = jsonObject.getJsonArray("entries").getJsonObject(j).getString("playerOrTeamName") + "\n";
                
              //  arrays.add(jsonArrayTest);
                
                challenger.setPlayerName(jsonObject.getJsonArray("entries").getJsonObject(0).getString("playerOrTeamName"));
                challenger.setPlayerName2(jsonObject.getJsonArray("entries").getJsonObject(1).getString("playerOrTeamName"));
                challenger.setPlayerName3(jsonObject.getJsonArray("entries").getJsonObject(2).getString("playerOrTeamName"));
                challenger.setPlayerName4(jsonObject.getJsonArray("entries").getJsonObject(3).getString("playerOrTeamName"));
                challenger.setPlayerName5(jsonObject.getJsonArray("entries").getJsonObject(4).getString("playerOrTeamName"));
                challenger.setPlayerName6(jsonObject.getJsonArray("entries").getJsonObject(5).getString("playerOrTeamName"));
                challenger.setPlayerName7(jsonObject.getJsonArray("entries").getJsonObject(6).getString("playerOrTeamName"));
                challenger.setPlayerName8(jsonObject.getJsonArray("entries").getJsonObject(7).getString("playerOrTeamName"));
                challenger.setPlayerName9(jsonObject.getJsonArray("entries").getJsonObject(8).getString("playerOrTeamName"));
                challenger.setPlayerName10(jsonObject.getJsonArray("entries").getJsonObject(9).getString("playerOrTeamName"));
                challenger.setWins(jsonObject.getJsonArray("entries").getJsonObject(0).getInt("wins"));
                challenger.setWins2(jsonObject.getJsonArray("entries").getJsonObject(1).getInt("wins"));
                challenger.setWins3(jsonObject.getJsonArray("entries").getJsonObject(2).getInt("wins"));
                challenger.setWins4(jsonObject.getJsonArray("entries").getJsonObject(3).getInt("wins"));
                challenger.setWins5(jsonObject.getJsonArray("entries").getJsonObject(4).getInt("wins"));
                challenger.setWins6(jsonObject.getJsonArray("entries").getJsonObject(5).getInt("wins"));
                challenger.setWins7(jsonObject.getJsonArray("entries").getJsonObject(6).getInt("wins"));
                challenger.setWins8(jsonObject.getJsonArray("entries").getJsonObject(7).getInt("wins"));
                challenger.setWins9(jsonObject.getJsonArray("entries").getJsonObject(8).getInt("wins"));
                challenger.setWins10(jsonObject.getJsonArray("entries").getJsonObject(9).getInt("wins"));
                challenger.setLosses1(jsonObject.getJsonArray("entries").getJsonObject(0).getInt("losses"));
                challenger.setLosses2(jsonObject.getJsonArray("entries").getJsonObject(1).getInt("losses"));
                challenger.setLosses3(jsonObject.getJsonArray("entries").getJsonObject(2).getInt("losses"));
                challenger.setLosses4(jsonObject.getJsonArray("entries").getJsonObject(3).getInt("losses"));
                challenger.setLosses5(jsonObject.getJsonArray("entries").getJsonObject(4).getInt("losses"));
                challenger.setLosses6(jsonObject.getJsonArray("entries").getJsonObject(5).getInt("losses"));
                challenger.setLosses7(jsonObject.getJsonArray("entries").getJsonObject(6).getInt("losses"));
                challenger.setLosses8(jsonObject.getJsonArray("entries").getJsonObject(7).getInt("losses"));
                challenger.setLosses9(jsonObject.getJsonArray("entries").getJsonObject(8).getInt("losses"));
                challenger.setLosses10(jsonObject.getJsonArray("entries").getJsonObject(9).getInt("losses"));
                challenger.setLeaguePoints(jsonObject.getJsonArray("entries").getJsonObject(0).getInt("leaguePoints"));
                challenger.setLeaguePoints2(jsonObject.getJsonArray("entries").getJsonObject(1).getInt("leaguePoints"));
                challenger.setLeaguePoints3(jsonObject.getJsonArray("entries").getJsonObject(2).getInt("leaguePoints"));
                challenger.setLeaguePoints4(jsonObject.getJsonArray("entries").getJsonObject(3).getInt("leaguePoints"));
                challenger.setLeaguePoints5(jsonObject.getJsonArray("entries").getJsonObject(4).getInt("leaguePoints"));
                challenger.setLeaguePoints6(jsonObject.getJsonArray("entries").getJsonObject(5).getInt("leaguePoints"));
                challenger.setLeaguePoints7(jsonObject.getJsonArray("entries").getJsonObject(6).getInt("leaguePoints"));
                challenger.setLeaguePoints8(jsonObject.getJsonArray("entries").getJsonObject(7).getInt("leaguePoints"));
                challenger.setLeaguePoints9(jsonObject.getJsonArray("entries").getJsonObject(8).getInt("leaguePoints"));
                challenger.setLeaguePoints10(jsonObject.getJsonArray("entries").getJsonObject(9).getInt("leaguePoints"));
            }
            challenger.getPlayerName();
            challenger.getName();
            challenger.getTier();
            challenger.getEntry();
            return challenger;
    }
    }
}