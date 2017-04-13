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
public class Entries {
    private String divion;
    private String playerOrTeamName;
    private int wins;
    private int losses;

    public Entries() {
    }

    public String getDivion() {
        return divion;
    }

    public void setDivion(String divion) {
        this.divion = divion;
    }

    public String getPlayerOrTeamName() {
        return playerOrTeamName;
    }

    public void setPlayerOrTeamName(String playerOrTeamName) {
        this.playerOrTeamName = playerOrTeamName;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
    
    
}
