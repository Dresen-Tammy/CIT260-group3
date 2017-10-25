/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.model;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author Dresen_HP
 */
public class Player implements Serializable{
    // class instance variables
    private String name;
    private String savedGameFile;
    private int pace;
    private double totalHealth;

   

    
    private int currentScore;
    // relationships with other classes 
    private List<Game> games = new ArrayList<>(); //0-* // TODO: Probably don't need because game higher.
    private Actor actor; // 1-1 TODO: Add player type and change this.
    private Map<InventoryType, InventoryItem> items = new HashMap();
    private Occupation occupation; //


    
    // default constructor

    public Player() {
    }
    
    // methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     
    public String getSavedGameFile() {
        return savedGameFile;
    }

    public void setSavedGameFile(String savedGameFile) {
        this.savedGameFile = savedGameFile;
    }

    public int getPace() {
        return pace;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Map getItems() {
        return items;
    }

    public void setItems(Map items) {
        this.items = items;
    }
    
    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.savedGameFile);
        hash = 23 * hash + this.pace;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.totalHealth) ^ (Double.doubleToLongBits(this.totalHealth) >>> 32));
        hash = 23 * hash + this.currentScore;
        hash = 23 * hash + Objects.hashCode(this.games);
        hash = 23 * hash + Objects.hashCode(this.actor);
        hash = 23 * hash + Objects.hashCode(this.items);
        hash = 23 * hash + Objects.hashCode(this.occupation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.pace != other.pace) {
            return false;
        }
        if (Double.doubleToLongBits(this.totalHealth) != Double.doubleToLongBits(other.totalHealth)) {
            return false;
        }
        if (this.currentScore != other.currentScore) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.savedGameFile, other.savedGameFile)) {
            return false;
        }
        if (!Objects.equals(this.games, other.games)) {
            return false;
        }
        if (this.actor != other.actor) {
            return false;
        }
        if (!Objects.equals(this.items, other.items)) {
            return false;
        }
        if (this.occupation != other.occupation) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", savedGameFile=" + savedGameFile + ", pace=" + pace + ", totalHealth=" + totalHealth + ", currentScore=" + currentScore + ", games=" + games + ", actor=" + actor + ", items=" + items + ", occupation=" + occupation + '}';
    }

    

    
    
    


    
    
    
}
