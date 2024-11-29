package battleshipgame;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class AI_Playersrv extends Playersrv {

    private String last_hit;
    private int lastHitX = -1;
    private int lastHitY = -1;
    private Locationsrv next_post;
    private ArrayList<Locationsrv> attacks = new ArrayList<>();
    private ArrayList<Locationsrv> nextAttack = new ArrayList<>();
    public AI_Playersrv(String name) {
        super("AI");

    }

    public static Boardsrv placeShip(Boardsrv aiShipBoardsrv, Playersrv aiplayer) {
        Random random = new Random();
        ArrayList<ShipType> shipTypes = ShipType.getShipTypes();
        int x = -1;
        int y = -1;
        String direction = random.nextInt(2) == 0 ? "v" : "h";
        for (ShipType shipType : shipTypes) {
            do {
                x = random.nextInt(aiShipBoardsrv.x_size);
                y = random.nextInt(aiShipBoardsrv.y_size);
                direction = direction.equals("v") ? "h" : "v";
            } while (!isInputValid(x,y, direction, shipType, aiShipBoardsrv.x_size, aiShipBoardsrv.y_size, aiShipBoardsrv));
            Ship ship = new Ship(shipType, x, y);
            ArrayList<Ship>aiPlayerCurrShips = aiplayer.getShips();
            aiPlayerCurrShips.add(ship);
            aiplayer.setShips(aiPlayerCurrShips);
            for(int k=0; k < shipType.getSize(); k++) {
                if(direction.equals("h")){
                    aiShipBoardsrv.setPieceOnSpace(ship, x+k, y, direction);
                }else {
                    aiShipBoardsrv.setPieceOnSpace(ship, x, y+k, direction);
                }
            }
        }
        return aiShipBoardsrv;
    }

    public static boolean isInputValid(int x, int y, String posit, ShipType shipType, int board_x_size, int board_y_size, Boardsrv boardsrv) {
        boolean ret_val = false;
        int horizontalSize = x + shipType.getSize();
        int verticalSize = y + shipType.getSize();
        if((posit.equals("h") && horizontalSize < board_x_size && verticalSize < board_y_size)){
            boolean isAvailable = true;
            for(int i = x; i  < horizontalSize; i++) {
                if(!boardsrv.getSquares()[i][y].getShip().getShipType().getName().equals("______Water")) {
                    isAvailable = false;
                }
            }
            ret_val = isAvailable;
        } else if((posit.equals("v") && verticalSize < board_y_size &&  horizontalSize < board_x_size)){
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

    public Locationsrv attackCoords(Boardsrv aiAttackBoardsrv, ArrayList<String> attacks) {
        Locationsrv last_post = null;
        Locationsrv next_post = null;
        SecureRandom random = new SecureRandom();
        int x = 0;
        int y = 0;
        Locationsrv lastAttack = getLastAttack();
        if (lastAttack != null) {
            Square square1 = aiAttackBoardsrv.getSquares()[lastAttack.getX()][lastAttack.getY()];
            ShipType shipType = square1.getShip().getShipType();

            if ((!shipType.getName().equals("______Water") && !getAllNearPositions(getLastAttack().getX(),getLastAttack().getY(), aiAttackBoardsrv).isEmpty()) || !nextAttack.isEmpty()) {
                last_post = getLastAttack();
                if(!aiAttackBoardsrv.getSquares()[last_post.getX()][last_post.getY()].getShip().getShipType().getName().equals("______Water")) {
                    nextAttack.addAll(getAllNearPositions(last_post.getX(), last_post.getY(), aiAttackBoardsrv));
                }
                do {
                    next_post = nextAttack.get(0);
                    nextAttack.remove(0);
                }while(attacks.contains(locationToString(next_post)));
            }else {
                do {
                    x = random.nextInt(aiAttackBoardsrv.x_size - 1);
                    y = random.nextInt(aiAttackBoardsrv.y_size - 1);
                    next_post = new Locationsrv(x, y);
                }while(attacks.contains(locationToString(next_post)));
            }
            this.attacks.add(next_post);
            return next_post;
        } else {
            Locationsrv locationsrv = new Locationsrv(x, y);
            this.attacks.add(locationsrv);
            return locationsrv;
        }
    }


    public boolean aiAttackResult(Locationsrv next_post, Boardsrv attackBoardsrv) {
        int x = next_post.getX();
        int y = next_post.getY();
        if (attackBoardsrv.isSquareEmpty(x, y)) {
            Square[][] squares = attackBoardsrv.getSquares();
            Square square = squares[x][y];
            square.setHit(true);
            squares[x][y] = square;
            attackBoardsrv.setSquares(squares);
            System.out.println("Miss!");
            return true;
        } else {
            Square[][] squares = attackBoardsrv.getSquares();
            Square square = squares[x][y];
            square.setHit(true);
            squares[x][y] = square;
            attackBoardsrv.setSquares(squares);
            last_hit = squares[x][y].toString();
            System.out.println("Hit!");
            return true;
        }
    }


    public Locationsrv getLastAttack(){
        if(attacks.isEmpty()){
            return null;
        }
        return attacks.get(attacks.size() - 1);
    }

    public ArrayList<Locationsrv> getAllNearPositions(int x, int y, Boardsrv boardsrv){
        ArrayList<Locationsrv> list = new ArrayList<>();
        Locationsrv positions = new Locationsrv(x,y);
        if (x - 1 >= 0 && !boardsrv.getSquares()[x-1][y].isHit) list.add(new Locationsrv(x - 1, y));
        if (x + 1 < boardsrv.x_size && !boardsrv.getSquares()[x+1][y].isHit) list.add(new Locationsrv(x + 1, y));
        if (y + 1 < boardsrv.y_size && !boardsrv.getSquares()[x][y+1].isHit) list.add(new Locationsrv(x, y + 1));
        if (y - 1 >= 0 && !boardsrv.getSquares()[x][y-1].isHit) list.add(new Locationsrv(x, y - 1));
        return list;
    }

    public String locationToString (Locationsrv location){
        return location.getX() + "" + location.getY();
    }



}