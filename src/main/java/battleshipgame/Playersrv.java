package battleshipgame;

import java.io.Serializable;
import java.util.ArrayList;

public class Playersrv implements Serializable {
    private String name;
    private ArrayList<Ship> ships;
    public Boardsrv attackBoardsrv;
    public Boardsrv shipBoardsrv;
    public boolean Turn;

    public Playersrv(String name){
        this.name = name;
        this.ships = new ArrayList<Ship>();


    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }

    public Boardsrv getAttackBoard() {
        return attackBoardsrv;
    }

    public void setAttackBoard(Boardsrv attackBoardsrv) {
        this.attackBoardsrv = attackBoardsrv;
    }

    public Boardsrv getShipBoard() {
        return shipBoardsrv;
    }

    public void setShipBoard(Boardsrv shipBoardsrv) {
        this.shipBoardsrv = shipBoardsrv;
    }

    public Playersrv() {
    }

    public boolean isTurn() {
        return Turn;
    }

    public void setTurn(boolean turn) {
        Turn = turn;
    }

    public static Playersrv player(String name, int x , int y){
        return new Playersrv();
    }

    public String getName(){
        return name;
    }


    public void flipTurn(Playersrv playersrv_not_turn){
        this.setTurn(false);
        playersrv_not_turn.setTurn(true);
    }
    public static Playersrv get_player_turn(Playersrv p1, Playersrv p2){
        if(p1.isTurn()){
            return p1;
        }else{
            return p2;
        }
    }

    public static Playersrv get_player_not_turn(Playersrv p1, Playersrv p2){
        if(!p1.isTurn()){
            return p1;
        }else{
            return p2;
        }
    }

    private int countShips(ArrayList<Ship> ships, int size){
        int count = 0;
        for(Ship ship : ships){
            if (ship.getShipType().getSize() == size){
                count ++;
            }
        }
        return count;
    }




}
