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
public class ChampObject {
    public Champ getChampID(int id) throws MalformedURLException, IOException
    {
        URL url = new URL("https://global.api.riotgames.com/api/lol/static-data/EUW/v1.2/champion/" + id + "?api_key=RGAPI-fdf965a6-41b8-4fac-831a-f4aaeb133659");
        
        try(InputStream in = url.openStream();
               BufferedReader reader = new BufferedReader(
               new InputStreamReader(in, "UTF-8")))
        {
            Champ champ = new Champ();
            JsonReader jsonReader = Json.createReader(in);
            
            JsonObject jsonObject = jsonReader.readObject();
            
            jsonReader.close();
            in.close();
        
            String name = jsonObject.getString("name");
            String title = jsonObject.getString("title");
            
            
            champ.setName(name);
            champ.setTitle(title);
            
            champ.getName();
            champ.getTitle();
            
            return champ;
        }
    }
}
