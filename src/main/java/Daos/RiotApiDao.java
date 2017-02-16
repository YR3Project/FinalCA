/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

/**
 *
 * @author Chris
 */
import java.util.Map;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import com.google.gson.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RiotApiDao extends Dao implements RiotApiDaoInterface{

    public RiotApiDao(String databaseName) {
        super(databaseName);
    }

    @Override
    public String summonerName(String name) {
        RiotApi api = new RiotApi("RGAPI-fdf965a6-41b8-4fac-831a-f4aaeb133659E");
        name = "chips97";
        api.setRegion(Region.EUW);
        Map<String, Summoner> summoners = null;
        try {
            summoners = api.getSummonersByName(name);
        } catch (RiotApiException ex) {
            Logger.getLogger(RiotApiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Summoner summoner = summoners.get("chips97");
        String name2 = summoner.getName();
        return name2;
    }

   
    
    
}
