/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WOWApi;
import java.io.*;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.json.*;
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
    /*
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
        
        
        
    }*/
    
    /**
     *
     * @return
     * @throws MalformedURLException
     * @throws IOException
     
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
    */
    /**
     * 
     * @param realm
     * @param name
     * @return
     * @throws MalformedURLException
     * @throws IOException 
     */
    public CharacterItem getItems(String realm, String name) throws MalformedURLException, IOException
    {
        URL url = new URL("https://eu.api.battle.net/wow/character/"+realm+"/"+name+"?fields=items&locale=en_GB&apikey=q4t5bsyufrehzx4a98wazgax79tbhbur");
        try (InputStream in = url.openStream(); 
                BufferedReader reader = new BufferedReader
        (new InputStreamReader(in, "UTF-8")))
        {
            
            CharacterItem cItem = new CharacterItem();
            JsonReader jsonReader = Json.createReader(in);
            
            JsonObject jsonObject = jsonReader.readObject();
            
            jsonReader.close();
            in.close();
            
            JsonObject items = jsonObject.getJsonObject("items");
            String headName = items.getJsonObject("head").getString("name");
            int headLevel = items.getJsonObject("head").getInt("itemLevel");
            String neckName = items.getJsonObject("neck").getJsonString("name").toString();
            int neckLevel = items.getJsonObject("neck").getInt("itemLevel");
            String shoulderName = items.getJsonObject("shoulder").getJsonString("name").toString();
            int shoulderLevel = items.getJsonObject("shoulder").getInt("itemLevel");
            String backName = items.getJsonObject("back").getJsonString("name").toString();
            int backLevel = items.getJsonObject("back").getInt("itemLevel");
            String chestName = items.getJsonObject("chest").getJsonString("name").toString();
            int chestLevel = items.getJsonObject("chest").getInt("itemLevel");
            String wristName = items.getJsonObject("wrist").getJsonString("name").toString();
            int wristLevel = items.getJsonObject("wrist").getInt("itemLevel");
            String legName = items.getJsonObject("legs").getJsonString("name").toString();
            int legLevel = items.getJsonObject("legs").getInt("itemLevel");
            String handName = items.getJsonObject("hands").getJsonString("name").toString();
            int handLevel = items.getJsonObject("hands").getInt("itemLevel");
            String finger1Name = items.getJsonObject("finger1").getJsonString("name").toString();
            int finger1Level = items.getJsonObject("finger1").getInt("itemLevel");
            String finger2Name = items.getJsonObject("finger2").getJsonString("name").toString();
            int finger2Level = items.getJsonObject("finger2").getInt("itemLevel");
            String trinket1Name = items.getJsonObject("trinket1").getJsonString("name").toString();
            int trinket1Level = items.getJsonObject("trinket1").getInt("itemLevel");
            String trinket2Name = items.getJsonObject("trinket2").getJsonString("name").toString();
            int trinket2Level = items.getJsonObject("trinket2").getInt("itemLevel");
            String mainhandName = items.getJsonObject("mainHand").getJsonString("name").toString();
            int mainhandLevel = items.getJsonObject("mainHand").getInt("itemLevel");
            String waistName = items.getJsonObject("waist").getJsonString("name").toString();
            int waistLevel = items.getJsonObject("waist").getInt("itemLevel");
            
            
            cItem.setBackLevel(backLevel);
            cItem.setBackName(backName);
            cItem.setChestLevel(chestLevel);
            cItem.setChestName(chestName);
            cItem.setFinger1Level(finger1Level);
            cItem.setFinger1Name(finger1Name);
            cItem.setFinger2Level(finger2Level);
            cItem.setFinger2Name(finger2Name);
            cItem.setHandLevel(handLevel);
            cItem.setHandName(handName);
            
            cItem.setLegLevel(legLevel);
            cItem.setLegName(legName);
            cItem.setMainHandLevel(mainhandLevel);
            cItem.setMainHandName(mainhandName);
            cItem.setNeckLevel(neckLevel);
            cItem.setNeckName(neckName);
            cItem.setShoulderLevel(shoulderLevel);
            cItem.setShoulderName(shoulderName);
            cItem.setTrinket1Level(trinket1Level);
            cItem.setTrinket1Name(trinket1Name);
            cItem.setTrinket2Level(trinket2Level);
            cItem.setTrinket2Name(trinket2Name);
            cItem.setWaistLevel(waistLevel);
            cItem.setWaistName(waistName);
            cItem.setWristLevel(wristLevel);
            cItem.setWristName(wristName);
            cItem.setHeadLevel(headLevel);
            cItem.setHeadName(headName);
            
            return cItem;
        }
    }
    public CharacterProfile getChar(String realm, String name) throws MalformedURLException, IOException
    {
        URL url = new URL("https://eu.api.battle.net/wow/character/"+realm+"/"+name+"?locale=en_GB&apikey=5vqst2ugb8xbbzyyhq3u5uebr3g9q6a2");
        try (InputStream in = url.openStream(); 
                BufferedReader reader = new BufferedReader
        (new InputStreamReader(in, "UTF-8")))
        {
            
            CharacterProfile cProf = new CharacterProfile();
            JsonReader jsonReader = Json.createReader(in);
            
            JsonObject jsonObject = jsonReader.readObject();
            
            jsonReader.close();
            in.close();
            
            int classID = jsonObject.getInt("class");
            int race = jsonObject.getInt("race");
            int gender = jsonObject.getInt("gender");
            int level = jsonObject.getInt("level");
            
            cProf.setCharClass(classID);
            cProf.setRealm(realm);
            cProf.setName(name);
            cProf.setLevel(level);
            cProf.setRace(race);
            cProf.setGender(gender);
            String thumbnail = jsonObject.getString("thumbnail");
            
            cProf.setThumbnail(thumbnail);
            return cProf;
            
            
        }
        
        
    }
}
