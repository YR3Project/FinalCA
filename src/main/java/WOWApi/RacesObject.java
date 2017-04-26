/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WOWApi;
import java.io.*;
import java.net.*;
import javax.json.*;
/**
 *
 * @author PC
 */
public class RacesObject {
    public Races getRaces() throws MalformedURLException, IOException
    {
        URL url = new URL("https://us.api.battle.net/wow/data/character/races?locale=en_US&apikey=5vqst2ugb8xbbzyyhq3u5uebr3g9q6a2");
        
        try(InputStream in = url.openStream();
                BufferedReader reader = new BufferedReader
                (new InputStreamReader(in, "UTF-8")))
        {
            Races races = new Races();
            
            JsonReader jsonReader = Json.createReader(in);
            JsonObject jsonObject = jsonReader.readObject();
            
            jsonReader.close();
            in.close();
            
            
            
            JsonArray jsonRaces = jsonObject.getJsonArray("races");
            String[] array = new String[jsonRaces.size()];
            int[] arrayNum = new int[jsonRaces.size()];
            for(int i = 0; i < array.length;i++)
            {
                JsonObject objectRaces = jsonRaces.getJsonObject(i);
                arrayNum[i] = objectRaces.getInt("id");
                array[i] = objectRaces.getJsonString("name").toString();
            }    
            races.setIdArray(arrayNum);
            races.setNameArray(array);
            return races;
        }
    }
}
