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
import java.util.ArrayList;
import com.google.gson.*;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;

public interface RiotApiDaoInterface {
    
    /**
     * @param Users name
     * @return Users details
     */
    public String summonerName(String name);
    
}
