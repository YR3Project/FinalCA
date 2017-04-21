/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WOWApi;
import java.io.*;
import com.google.gson.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
/**
 *
 * @author Chris
 */
public class WOWRootObject {
    public Zones api;
    
    public Zones getArray()
    {
        return api;
    }

    public void setApi(Zones api) {
        this.api = api;
    }
    
    public Quest getQuest() throws MalformedURLException, IOException
    {
        URL url = new URL("https://us.api.battle.net/wow/quest/12146?locale=en_US&apikey=5vqst2ugb8xbbzyyhq3u5uebr3g9q6a2");
        
        try (InputStream in = url.openStream(); 
                BufferedReader reader = new BufferedReader
        (new InputStreamReader(in, "UTF-8")))
        {
            Gson gson = new GsonBuilder().create();
            
            Quest myObject = gson.fromJson(reader, Quest.class);
            
            myObject.getId();
            myObject.getLvl();
            myObject.getTitle();
            return myObject;
        }
        
        
        
    }
    
    /**
     *
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    public Zones getZones() throws MalformedURLException , IOException
    {
        URL url = new URL("https://us.api.battle.net/wow/zone/4131?locale=en_US&apikey=5vqst2ugb8xbbzyyhq3u5uebr3g9q6a2");
        try (InputStream in = url.openStream(); 
                BufferedReader reader = new BufferedReader
        (new InputStreamReader(in, "UTF-8")))
        {
            Gson gson = new GsonBuilder().create();
            
            Zones myObject = gson.fromJson(reader, Zones.class);
            
            myObject.getDescription();
            myObject.getId();
            myObject.getMaxLevel();
            myObject.getName();
            return myObject;
        }
        
        
    }
    
    public CharacterItem getItems() throws MalformedURLException, IOException
    {
        URL url = new URL("https://eu.api.battle.net/wow/character/Silvermoon/AleksMtr?fields=items&locale=en_GB&apikey=5vqst2ugb8xbbzyyhq3u5uebr3g9q6a2");
        try (InputStream in = url.openStream(); 
                BufferedReader reader = new BufferedReader
        (new InputStreamReader(in, "UTF-8")))
        {
            Gson gson = new GsonBuilder().create();
            
            CharacterItem myObject = gson.fromJson(reader, CharacterItem.class);
            
            myObject.getAvgLvl();
            myObject.getId();
           
            myObject.getName();
            return myObject;
        }
    }
    public CharacterProfile getChar(String realm, String name) throws MalformedURLException, IOException
    {
        URL url = new URL("https://eu.api.battle.net/wow/character/"+realm+"/"+name+"?fields=item&locale=en_GB&apikey=q4t5bsyufrehzx4a98wazgax79tbhbur");
        try (InputStream in = url.openStream(); 
                BufferedReader reader = new BufferedReader
        (new InputStreamReader(in, "UTF-8")))
        {
            Gson gson = new GsonBuilder().create();
            CharacterProfile myObject = gson.fromJson(reader, CharacterProfile.class);
            
            myObject.getAchPoints();
            myObject.getBattlegroup();
            myObject.getCharClass();
            myObject.getRealm();
            myObject.getRace();
            myObject.getName();
            myObject.getLevel();
            myObject.getGender();
            myObject.getFaction();
            myObject.getAvglvl();
            
            return myObject;
            
            
        }
        
        
    }
}
