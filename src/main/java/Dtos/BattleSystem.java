/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author PC
 */
public class BattleSystem {
    protected int ChampID;
    protected String ChampName;
    protected double ChampValue;
    protected String position;
    
    public BattleSystem(){}
    public BattleSystem(int ChampID, String ChampName, double ChampValue, String position)
    {
        this.ChampID = ChampID;
        this.ChampName = ChampName;
        this.ChampValue = ChampValue;
        this.position = position;
    }
    
    public BattleSystem(String ChampName, String position)
    {
        this.ChampName = ChampName;
        this.position = position;
    }
    public int getChampID() {
        return ChampID;
    }

    public void setChampID(int ChampID) {
        this.ChampID = ChampID;
    }

    public String getChampName() {
        return ChampName;
    }

    public void setChampName(String ChampName) {
        this.ChampName = ChampName;
    }

    public double getChampValue() {
        return ChampValue;
    }

    public void setChampValue(double ChampValue) {
        this.ChampValue = ChampValue;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
}
