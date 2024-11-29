package battleshipgame;

import battleshipgame.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Gamesrv implements Serializable {
    private Playersrv humanPlayersrv;
    private Playersrv AIPlayersrv;

    public Playersrv getHumanPlayer() {
        return humanPlayersrv;
    }

    public void setHumanPlayer(Playersrv humanPlayersrv) {
        this.humanPlayersrv = humanPlayersrv;
    }

    public Playersrv getAIPlayer() {
        return AIPlayersrv;
    }

    public void setAIPlayer(Playersrv AIPlayersrv) {
        this.AIPlayersrv = AIPlayersrv;
    }

    public void Start(int board_x_size, int board_y_size){
        Scanner myScanner = new Scanner(System.in);
        String user_input = "";
        boolean gameOver = false;
        this.humanPlayersrv = new Playersrv("Human");
        AI_Playersrv aiPlayer = new AI_Playersrv("AI");

        Playersrv currentPlayersrv = new Playersrv();
        Playersrv next_playersrv = Playersrv.get_player_not_turn(this.humanPlayersrv,aiPlayer);
        Boardsrv aiPlayerShipBoardsrv = AI_Playersrv.placeShip(new Boardsrv(board_x_size,board_y_size), this.AIPlayersrv);
        Boardsrv humanPlayerShipBoardsrv = new Boardsrv(board_x_size, board_y_size);

        this.humanPlayersrv.shipBoardsrv = humanPlayerShipBoardsrv;
        aiPlayer.shipBoardsrv = aiPlayerShipBoardsrv;
        this.humanPlayersrv.attackBoardsrv = aiPlayerShipBoardsrv;
        aiPlayer.attackBoardsrv = humanPlayerShipBoardsrv;

        ArrayList<ShipType> shipTypes = ShipType.getShipTypes();
        int x;
        int y;
        String posit;
        for(ShipType shipType : shipTypes) {
            do{
                this.humanPlayersrv.shipBoardsrv.showBoard("Ship Board");
                String shipPositions = setShipInputs(shipType, this.humanPlayersrv.shipBoardsrv);
                x = Integer.parseInt(String.valueOf(shipPositions.charAt(0)));
                y = Integer.parseInt(String.valueOf(shipPositions.charAt(1)));
                posit = String.valueOf(shipPositions.charAt(2));
            }while(!isInputValid(x,y,posit,shipType,board_x_size,board_y_size, humanPlayerShipBoardsrv));
            Ship ship = new Ship(shipType, x, y);
            ArrayList<Ship>humanPlayerCurrShips = this.humanPlayersrv.getShips();
            humanPlayerCurrShips.add(ship);
            this.humanPlayersrv.setShips(humanPlayerCurrShips);
            for(int k=0; k < shipType.getSize(); k++) {
                if(posit.equals("h")){
                    humanPlayerShipBoardsrv.setPieceOnSpace(ship, x+k, y, posit);
                }else {
                    humanPlayerShipBoardsrv.setPieceOnSpace(ship, x, y+k, posit);
                }
            }

        }
        System.out.println(humanPlayersrv.getName() + " Ship Board:");
        this.humanPlayersrv.shipBoardsrv.showBoard("Ship Board");
        this.humanPlayersrv.attackBoardsrv = aiPlayer.getShipBoard();
        ArrayList<String> previousAttk = new ArrayList<>();

        while(!gameOver){
            System.out.println("Do you want to save the game? ");
            user_input = myScanner.nextLine();

            if(user_input.equals("yes") || user_input.equals("y") || user_input.equals("YES")){
                this.save_game();
                break;
            }

            currentPlayersrv = Playersrv.get_player_turn(this.humanPlayersrv,aiPlayer);
            if(currentPlayersrv.getName().equals("AI")){
                System.out.println("The current players turn is: " + currentPlayersrv.getName());
                currentPlayersrv.attackBoardsrv.showAttackBoard();
                next_playersrv.shipBoardsrv.showBoard("Ship Board");
                Locationsrv coordsOfAttack = aiPlayer.attackCoords(aiPlayer.attackBoardsrv, previousAttk);
                String kari = locationToString(coordsOfAttack);
                previousAttk.add(kari);
                System.out.println(coordsOfAttack.getX());
                System.out.println(coordsOfAttack.getY());
                boolean aiAttackResult = aiPlayer.aiAttackResult(coordsOfAttack, aiPlayer.attackBoardsrv);
                if(areAIShipsDestoryed(aiPlayerShipBoardsrv)){
                    System.out.println("Game Over. " + next_playersrv.getName() + " wins!");
                    gameOver = true;
                }
                currentPlayersrv.flipTurn(next_playersrv);
                next_playersrv = Playersrv.get_player_not_turn(currentPlayersrv, next_playersrv);
            }else {
                System.out.println("The current players turn is: " + currentPlayersrv.getName());
                currentPlayersrv.attackBoardsrv.showAttackBoard();
                currentPlayersrv.shipBoardsrv.showBoard("Ship Board");
                String attackPositions = setAttackInputs(currentPlayersrv.getAttackBoard());
                boolean attackResult = attack(attackPositions, currentPlayersrv.getAttackBoard());
                if(areShipsDestoryed(currentPlayersrv)){
                    System.out.println("Games Over. " + next_playersrv.getName() + " wins!");
                    gameOver = true;
                }
                currentPlayersrv.flipTurn(next_playersrv);
                next_playersrv = Playersrv.get_player_not_turn(currentPlayersrv, next_playersrv);
            }

        }

    }

    public void save_game(){
        try{
            FileOutputStream st = new FileOutputStream("game.txt");
            ObjectOutputStream os = new ObjectOutputStream(st);
            os.writeObject(this);
            os.close();

        }catch (Exception ex){
            System.out.println("Error occured saving " + ex);
        }
    }

    public static Gamesrv load_game(){
        Gamesrv myGamesrv = new Gamesrv();
        try{
            FileInputStream st = new FileInputStream("game.txt");
            ObjectInputStream os = new ObjectInputStream(st);
            myGamesrv = (Gamesrv) os.readObject();
            os.close();
        }catch (Exception ex){
            System.out.println("Error occured loading " + ex);
        }
        return myGamesrv;
    }

    public String setShipInputs(ShipType shipType, Boardsrv humanPlayerShipBoardsrv){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter X coordinate to place " + shipType.getName());
        int x = -1;
        while (x < 0 || x > humanPlayerShipBoardsrv.x_size - 1) {
            try {
                x = Integer.parseInt(myScanner.nextLine());
                if (x < 0 || x > humanPlayerShipBoardsrv.x_size - 1) {
                    System.out.println("X coordinate out of bounds, please try again!");
                }
            } catch (Exception ex) {
                System.out.println("Invalid input, please make sure to enter a number");
            }
        }
        System.out.println("Enter Y coordinate to place " + shipType.getName());
        int y = -1;
        while (y < 0 || y > humanPlayerShipBoardsrv.y_size - 1) {
            try {
                y = Integer.parseInt(myScanner.nextLine());
                if (y < 0 || y > humanPlayerShipBoardsrv.y_size - 1) {
                    System.out.println("Y coordinate out of bounds, please try again!");
                }
            } catch (Exception ex) {
                System.out.println("Invalid input, please make sure to enter a number");
            }
        }
        System.out.println("Enter direction of " + shipType.getName());
        String posit = "";
        while (!(posit.equals("v") || posit.equals("h"))) {
            try {
                posit = myScanner.nextLine();
                if (!(posit.equals("v") || posit.equals("h"))) {
                    System.out.println("Invalid input, please make sure to enter a direction");
                }
            } catch (Exception ex) {
                System.out.println("Invalid input, please make sure to enter a direction");
            }
        }
        return String.valueOf(x) + String.valueOf(y) + posit;
    }

    public String setAttackInputs(Boardsrv attackBoardsrv) {
        int x = -1;
        int y = -1;
        boolean isHit;
        boolean validInput;
        do {
            isHit = false;
            validInput =true;
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Enter X coordinate to attack ");
            while (x < 0 || x > attackBoardsrv.x_size - 1) {
                try {
                    x = Integer.parseInt(myScanner.nextLine());
                    if (x < 0 || x > attackBoardsrv.x_size - 1) {
                        System.out.println("X coordinate out of bounds, please try again!");
                    }
                } catch (Exception ex) {
                    System.out.println("Invalid input, please make sure to enter a number");
                }
            }
            System.out.println("Enter Y coordinate to attack ");
            while (y < 0 || y > attackBoardsrv.y_size - 1) {
                try {
                    y = Integer.parseInt(myScanner.nextLine());
                    if (y < 0 || y > attackBoardsrv.y_size - 1) {
                        System.out.println("Y coordinate out of bounds, please try again!");
                    }
                } catch (Exception ex) {
                    System.out.println("Invalid input, please make sure to enter a number");
                }
            }
            for (int i = 0; i < attackBoardsrv.x_size; i++) {
                for (int j = 0; j < attackBoardsrv.y_size; j++) {
                    if (attackBoardsrv.getSquares()[i][j].isHit && i == x && j == y) {
                        validInput = false;
                        System.out.println("This position has already been attacked, please choose a different position");
                        x = -1;
                        y = -1;
                        break;
                    }
                }
                if (!validInput) {
                    break;
                }
            }
        } while (!validInput);
        String coordinatesOfAttack = String.valueOf(x) + String.valueOf(y);
        return coordinatesOfAttack;
    }

    public boolean attack(String coordinatesOfAttack, Boardsrv attackBoardsrv){
        int x = Integer.parseInt(String.valueOf(coordinatesOfAttack.charAt(0)));
        int y = Integer.parseInt(String.valueOf(coordinatesOfAttack.charAt(1)));
        if (attackBoardsrv.isSquareEmpty(x, y)) {
            Square [][] squares = attackBoardsrv.getSquares();
            Square square = squares[x][y];
            square.setHit(true);
            squares[x][y] = square;
            attackBoardsrv.setSquares(squares);
            System.out.println("Miss!");
            return false;
        } else{
            Square [][] squares = attackBoardsrv.getSquares();
            Square square = squares[x][y];
            square.setHit(true);
            squares[x][y] = square;
            attackBoardsrv.setSquares(squares);
            System.out.println("Hit!");
            return true;
        }
    }

    public boolean isInputValid(int x, int y, String posit, ShipType shipType, int board_x_size, int board_y_size, Boardsrv boardsrv) {
        boolean ret_val = false;
        int horizontalSize = x + shipType.getSize();
        int verticalSize = y + shipType.getSize();
        if((posit.equals("h") && horizontalSize < board_x_size)){
            boolean isAvailable = true;
            for(int i = x; i  < horizontalSize; i++) {
                if(!boardsrv.getSquares()[i][y].getShip().getShipType().getName().equals("______Water")) {
                    isAvailable = false;
                }
            }
            ret_val = isAvailable;
        } else if((posit.equals("v") && verticalSize < board_y_size)){
            boolean isAvailable = true;
            for(int i = y; i  < verticalSize; i++) {
                if(!boardsrv.getSquares()[x][i].getShip().getShipType().getName().equals("______Water")) {
                    isAvailable = false;
                }
            }
            ret_val = isAvailable;
        }
        return ret_val;
    }

    public boolean areShipsDestoryed(Playersrv playersrv){
        ArrayList<Ship> ships = playersrv.getShips();
        for(Ship ship : ships){
            int x = ship.getX();
            int y = ship.getY();
            String direction = ship.getDirection();
            ShipType shipType = ship.getShipType();
            for(int i = 0; i<shipType.getSize(); i++){
                if(direction.equals("h")){
                    if(!playersrv.getShipBoard().getSquares()[x+i][y].isHit()){
                        return false;
                    }
                }
                if(direction.equals("v")){
                    if(!playersrv.getShipBoard().getSquares()[x][y+i].isHit()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean areAIShipsDestoryed(Boardsrv boardsrv){
        int x;
        int y;
        for(x=0; x< boardsrv.x_size; x++){
            for(y=0; y< boardsrv.y_size; y++){
                if(!(boardsrv.getSquares()[x][y].isHit) && !(boardsrv.getPieceByCoords(x,y).getShipType().getName().equals("____Water"))){
                    return false;
                }
            }
        }
        return true;
    }

    public String locationToString (Locationsrv location){
        return location.getX() + "" + location.getY();
    }

    public Gamesrv(){
        this.humanPlayersrv = new Playersrv("humanPlayer");
        this.AIPlayersrv = new Playersrv("AI Player");
        this.humanPlayersrv.setTurn(true);
        this.AIPlayersrv.setTurn(false);
    }

}
