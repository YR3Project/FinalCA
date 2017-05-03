/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WOWApi;
import javax.json.*;
import java.util.*;
import java.io.*;
import java.net.*;
public class PetsObject {
    public Pets getPets(String realm, String name) throws MalformedURLException, IOException
   {
       URL url = new URL("https://eu.api.battle.net/wow/character/"+realm+"/"+name+"?fields=pets&locale=en_GB&apikey=5vqst2ugb8xbbzyyhq3u5uebr3g9q6a2");
       
       try(
               InputStream in = url.openStream();
               
               BufferedReader reader = new BufferedReader(
               new InputStreamReader(in, "UTF-8")))
        {
            Pets pet = new Pets();
            JsonReader jsonReader = Json.createReader(in);
            
            JsonObject jsonObject = jsonReader.readObject();
            
            jsonReader.close();
            in.close();
            
            JsonArray collected = jsonObject.getJsonObject("pets").getJsonArray("collected");
            int test = jsonObject.getJsonObject("pets").getInt("numCollected");
            
            
            
            int arraysize = collected.size();
            ArrayList petsCollected = new ArrayList();
            
            
            
            for(int i = 0; i < arraysize; i++)
            {
                petsCollected.add(collected.getJsonObject(i).getJsonString("name").toString());
                
                pet.setName(petsCollected);
            }
            
            
            return pet;
        }
       
   }
}
