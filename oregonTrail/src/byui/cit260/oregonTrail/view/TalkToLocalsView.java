/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.MapControl;
import byui.cit260.oregonTrail.exceptions.MapControlException;
import byui.cit260.oregonTrail.model.Actor;
import byui.cit260.oregonTrail.model.Location;
import java.util.Scanner;


/**
 *
 * @author hannahwilliams
 */
public class TalkToLocalsView extends View{
    public TalkToLocalsView() {
    
    super("\n"
                    +"\n----------------------------------------------------"
                    +"\n| Character Menu                                    |"
                    +"\n----------------------------------------------------"
                    +"\nA - Settler"
                    +"\nB - Pioneer"
                    +"\nC - Trapper"
                    +"\nD - Soldier"
                    +"\nE - Clerk"
                    +"\nF - Shoshone"
                    +"\nG - Cayusa"
                    +"\nH - Guide"
                    +"\nI - Wife"
                    +"\nJ - Son"
                    +"\nK - Daughter"
                    +"\nQ - Quit"
                    +"\n----------------------------------------------------"
                    + "\nWho would you like to speak to?");

    
    }


    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        try {
            // set activity to done.
            Location location = MapControl.getCurrentLocation();
            location.getScene().setActivityDone(true);
        } catch (MapControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        Actor actor;
        
        switch (choice) {
            case "A":
                actor = Actor.Settler;
                // grab person
                //create view
            case "B":
                actor = Actor.Pioneer;
            case "C":
                actor = Actor.Trapper;
            case "D":
                actor = Actor.Soldier;
            case "E":
                actor = Actor.Clerk;
            case "F":
                actor = Actor.Shoshone;
            case "G":
                actor = Actor.Cayusa;
            case "H":
                actor = Actor.Guide;
            case "I":
                actor = Actor.Wife;
            case "J":
                actor = Actor.Son;
            case "K":
                actor = Actor.Daughter;
                
        }
        return false;
    
    
    }
    
}
