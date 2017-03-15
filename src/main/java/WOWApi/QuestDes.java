/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WOWApi;
import java.lang.reflect.Type;

import com.google.gson.*;
/**
 *
 * @author Chris
 */
public class QuestDes implements JsonDeserializer<Quest>{

    @Override
    public Quest deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        final JsonObject jsonObject = je.getAsJsonObject();
        
        final String title = jsonObject.get("title").getAsString();
        final int lvl = jsonObject.get("level").getAsInt();
        final int id = jsonObject.get("id").getAsInt();
        
        
        final Quest quest = new Quest();
        
        quest.setId(id);
        quest.setTitle(title);
        quest.setLvl(lvl);
       
        return quest;
    }
    
}
