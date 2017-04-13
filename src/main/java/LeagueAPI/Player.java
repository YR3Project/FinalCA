/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeagueAPI;

/**
 *
 * @author PC
 */
public class Player {
    private int summonerID;
    private String name;

    public Player() {
    }

    public int getSummonerID() {
        return summonerID;
    }

    public void setSummonerID(int summonerID) {
        this.summonerID = summonerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
