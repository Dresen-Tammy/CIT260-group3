/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.InventoryControl;
import byui.cit260.oregonTrail.control.MapControl;
import byui.cit260.oregonTrail.exceptions.InventoryControlException;
import byui.cit260.oregonTrail.exceptions.MapControlException;
import byui.cit260.oregonTrail.model.Game;
import byui.cit260.oregonTrail.model.InventoryItem;
import byui.cit260.oregonTrail.model.InventoryType;
import byui.cit260.oregonTrail.model.Location;
import java.awt.Point;
import static java.lang.Integer.parseInt;
import oregonTrail.OregonTrail;

/**
 *
 * @author Dresen_HP
 */
class SceneView extends View {

    SceneView(String menu) {
        super("\n" + menu
                + "\n Enter your choice.");

        String sceneMenu = menu;

    }

    @Override
    public void display() {  //called from main() in OregonTrail.java
        boolean done = false; // set flag to not done
        MainMenuView mainMenu = new MainMenuView();
        do {
            //prompt for and get player's name
            String value = this.getInput(); // calls getPlayersName() from this class, stores in string playersName

            if (value.toUpperCase().equals("Q")) // user wants to quit
            {
                mainMenu.display(); //exit the game
            }
            //do the requested action and display the next view
            done = this.doAction(value);// Calls doAction()in this class and passes in name. Return value changes boolean to true to exit do while loop.
        } while (!done);
    }

    @Override
    public boolean doAction(String value) {

        // get game for current location
        Game game = OregonTrail.getCurrentGame();
        Location location = null;
        try {
            location = MapControl.getCurrentLocation();
        } catch (MapControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            display();
        }
        String scene = location.getScene().getName();
        // get current row and column

        // initialize number variable
        int number = 0;

        try {// change entry to int.
            number = parseInt(value);
        } catch (NumberFormatException nf) {
            int row = game.getPlayer().getRow();
            int column = game.getPlayer().getColumn();
            // create coordinates in case number is not valid number.
            Point coordinates = new Point(row, column);
            // create new object in case number is not valid, needed to recreate menu.
            ConfirmMoveView confirmMove = new ConfirmMoveView(0, 0, coordinates);
            ErrorView.display(this.getClass().getName(), "Error reading input: Please enter a valid number.");
            confirmMove.deliverNextView(location, value);
        }

        switch (number) {
            case 1:
                switch (scene) {
                    case "Regular":
                        TalkToLocalsView talkToLocals = new TalkToLocalsView();
                        talkToLocals.display();
                        break;
                    case "Start":
                        CompanionView companionView = new CompanionView();
                        companionView.display();
                        break;
                    case "River":
                        RiverMenuView riverMenu = new RiverMenuView();
                        riverMenu.display();
                        break;
                    case "Hunting":
                        HuntView huntView = new HuntView();
                        huntView.display();
                        break;
                    case "Fort":
                        String inventory;
                         {
                            try {
                                inventory = InventoryControl.displayInventoryQuantityPrice();
                            } catch (InventoryControlException ex) {
                                ErrorView.display(this.getClass().getName(), ex.getMessage());
                                return false;
                            }
                        }
                         {
                            try {
                                PurchaseGoodsView purchaseGoods = new PurchaseGoodsView(inventory);
                                purchaseGoods.display();
                            } catch (InventoryControlException ex) {
                                ErrorView.display(this.getClass().getName(), ex.getMessage());
                                return false;
                            }
                        }

                        break;
                    case "Finish":
                        EndGameView endGame = new EndGameView();
                        endGame.display();
                        break;
                }
            case 2:
                BarterMenuView barterMenu = new BarterMenuView();
                barterMenu.display();
                break;
            case 3:
                ChangePaceView changePace = new ChangePaceView();
                changePace.display();
                break;
            case 4:
                HireGuideView hireGuide = new HireGuideView();
                hireGuide.display();
                break;
            case 5:
                GameMenuView gameMenu = new GameMenuView();
                gameMenu.displayMap();
                break;
            default:
                double food = 0;
                try {
                    InventoryItem item = InventoryControl.getItem(InventoryType.Food);
                    food = item.getQuantityInStock();
                } catch (InventoryControlException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());

                }
                int days = 0;
                ErrorView.display(this.getClass().getName(), "Error reading input: Invalid entry. Try again.");
                int row = game.getPlayer().getRow();
                int column = game.getPlayer().getColumn();
                // create coordinates in case number is not valid number.
                Point coordinates = new Point(row, column);
                ConfirmMoveView confirmMove = new ConfirmMoveView(food, days, coordinates);
                confirmMove.deliverNextView(location, scene);
                break;

        }
        return false;

    }
}