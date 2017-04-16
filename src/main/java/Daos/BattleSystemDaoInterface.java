/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.BattleSystem;
import java.util.ArrayList;
public interface BattleSystemDaoInterface {
    
    /**
     * This method gets the champion name
     * @param id
     * @return The champions name based on the ID
     */
    public BattleSystem getChampName(int id);
    
    /**
     * This method gets the champions value 
     * @param name
     * @return The champions value based on the name
     */
    public int getChampValue(String name);
    
    /**
     * This method gets the champions position or role
     * @param id
     * @return The champions position based on the ID
     */
    
    public String getChampPosition(int id);
    
    /**
     * @param position
     * @return The champions from a certain position 
     */
    public ArrayList<BattleSystem> getChampsBasedOnPosition(String position);
    
    
}
