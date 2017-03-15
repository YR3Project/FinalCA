/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WOWApi;

/**
 *
 * @author PC
 */
import com.google.gson.*;
import java.lang.reflect.Type;
public class CharacterDes implements JsonDeserializer<CharacterProfile>{

    @Override
    public CharacterProfile deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        final JsonObject jsonObject = je.getAsJsonObject();
        
        final String name = jsonObject.get("name").getAsString();
        final String realm = jsonObject.get("realm").getAsString();
        final String battlegroup = jsonObject.get("battlegroup").getAsString();
        final String thumbnail = jsonObject.get("thumbnail").getAsString();
        final int charClass = jsonObject.get("class").getAsInt();
        final int race = jsonObject.get("race").getAsInt();
        final int gender = jsonObject.get("gender").getAsInt();
        final int level = jsonObject.get("level").getAsInt();
        final int points = jsonObject.get("achievementPoints").getAsInt();
        final int faction = jsonObject.get("faction").getAsInt();
        final int totalHonorableKills = jsonObject.get("totalHonorableKills").getAsInt();
        
        
        
        CharacterProfile charc = new CharacterProfile();
        
        charc.setAchPoints(points);
        charc.setBattlegroup(battlegroup);
        charc.setRealm(realm);
        charc.setCharClass(charClass);
        charc.setFaction(faction);
        charc.setThumbnail(thumbnail);
        charc.setGender(gender);
        charc.setLevel(level);
        charc.setName(name);
        charc.setRace(race);
        charc.setTotalHonorableKills(totalHonorableKills);
        
        return charc;
    }
    
}
