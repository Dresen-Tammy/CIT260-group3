/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.model;

/**
 *
 * @author Dresen_HP
 */
public enum InventoryType {
    Food(5),
    Clothing(20),
    Medicine(10),
    Bullets(1),
    Oxen(40),
    WagonWheel(10),
    Money(1),
    Guide(50);
    
    private final int cost;
    // constructor function
    private InventoryType(int cost){
        this.cost = cost;
        
    }
    
    public int getCost() {
        return cost;
    }
    
}
