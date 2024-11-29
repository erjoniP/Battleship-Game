package com.example.battleship_gui;

import battleshipgame.Boardsrv;
import battleshipgame.Playersrv;
import battleshipgame.Ship;
import battleshipgame.ShipType;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Board {
    private VBox rows = new VBox();

    public Boardsrv PlayerBoard = new Boardsrv(10,10);

    public Board(){
        this.PlayerBoard = new Boardsrv(10,10);
        /*this.PlayerBoard.setX_size(10);
        this.PlayerBoard.setY_size(10);*/
    }

    public boolean placeShip(Ship ship, int x, int y, String posit) {
        if (isInputValid(x, y, ship.getShipType(), 10, 10, posit, PlayerBoard)) {
            for (int k = 0; k < ship.getShipType().getSize(); k++) {
                if (posit.equals("h")) {
                    this.PlayerBoard.setPieceOnSpace(ship, x + k, y, posit);
                } else {
                    this.PlayerBoard.setPieceOnSpace(ship, x, y + k, posit);
                }
            }
            return true;
        }
        return false;
    }

    public boolean isInputValid(int x, int y, ShipType shipType, int board_x_size, int board_y_size, String posit, Boardsrv boardsrv){
        boolean ret_val = false;
        int horizontalSize = x + shipType.getSize();
        int verticalSize = y + shipType.getSize();

        if((posit.equals("h") && horizontalSize <= board_x_size)){
            boolean isAvailable = true;
            for(int i = x; i  < horizontalSize; i++) {
                if(!boardsrv.getSquares()[i][y].getShip().getShipType().getName().equals("______Water")) {
                    isAvailable = false;
                }
            }
            ret_val = isAvailable;
        } else if((posit.equals("v") && verticalSize <= board_y_size)){
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

}
