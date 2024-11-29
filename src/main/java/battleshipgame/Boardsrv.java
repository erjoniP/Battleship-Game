package battleshipgame;

import battleshipgame.Ship;
import battleshipgame.ShipType;
import battleshipgame.Square;

import java.io.Serializable;
import java.util.ArrayList;

public class Boardsrv implements Serializable {
    Square[][] squares = null;
    int x_size = 0;
    int y_size = 0;

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    public Boardsrv(int x, int y){
        this.squares = new Square[x][y];
        this.x_size = x;
        this.y_size = y;
        setBoard();
    }

    private void setBoard(){
        for (int x=0;x<this.x_size;x++){
            for(int y = 0;y<this.y_size;y++){
                squares[x][y] = new Square();
            }
            setAllBlank(x);
        }
    }


    public void setAllBlank(int row){
        for (int y=0;y<this.y_size;y++){
            Ship emptyPiece = new Ship();
            emptyPiece.setShipType(ShipType.EMPTY);
            setPieceOnSpace(emptyPiece,row,y,"e");
        }
    }


    public void setPieceOnSpace(Ship piece, int x, int y, String posit){
        squares[x][y].setShip(piece);
        piece.setDirection(posit);

    }

    public void setPieceOnSpaceCnt4(Ship piece, int y){
        int x = 0;
        for(int i=0;i<this.x_size;i++){
            if(this.isSquareEmpty(i,y)){
                x= i;
            }
        }
        this.squares[x][y].setShip(piece);
    }

    public Ship getPieceByCoords(int x, int y){
        return this.squares[x][y].getShip();
    }

    public boolean isSquareEmpty(int x, int y){
        if(squares[x][y].getShip().getShipType().getName().equals("______Water")){
            return true;
        }else{
            return false;
        }
    }


    /*public void removePieceOnSpace(int x, int y){
        Ship emptyPiece = new Ship();
        setPieceOnSpace(emptyPiece,x,y,"v");
        //emptyPiece.setName("__" + x + "-" + y + "__");
        emptyPiece.getShipType.set("empty");
    }*/


    public String serializeBoard(){
        String line= "board:\n";

        for (int x =0; x<this.x_size;x++){
            for (int y =0; y<this.y_size;y++){
                line = line + squares[x][y].getShip().getShipType().getName();
            }
            line = line + "\n";
        }
        line = line +"";
        return line;
    }

    public ArrayList<Ship> showBoard(String Title){
        System.out.println("===========================" +  Title +"=============================================");
        ArrayList<Ship> piece_list = new ArrayList<>();
        for (int y=y_size-1;y>-1;y--){
            for(int x =0;x<x_size;x++){
                Square square = squares[x][y];
                if (square.isHit() && !square.getShip().getShipType().getName().equals("______Water")) {
                    System.out.print("__"+ "\033[31mX\u001B[0m" + x+"-"+y + "__"); // hit
                }else{
                    System.out.print("__" + "\u001B[34m" + squares[x][y].getShip().getShipType().getName().charAt(5)+ "\u001B[0m" + x+"-"+y + "__");
                    piece_list.add(squares[x][y].getShip());
                }
            }

            System.out.println();
        }
        return piece_list;
    }
    public void showAttackBoard() {
            System.out.println("=========================== Attack Board =========================================");
            for (int y = y_size-1; y >= 0; y--) {
                for (int x = 0; x < x_size; x++) {
                    Square square = squares[x][y];
                    if (square.isHit() && !square.getShip().getShipType().getName().equals("______Water")) {
                        System.out.print("__"+ "\033[31mX\u001B[0m" + x+"-"+y + "__");
                    } else if (square.isHit() && square.getShip().getShipType().getName().equals("______Water")) {
                        System.out.print("__" + "\u001B[37m" + "O\u001B[0m" + x+"-"+y + "__");
                    } else {
                        System.out.print("__" + "\u001B[34m" + "_" + "\u001B[0m" + x+"-"+y + "__");
                    }
                }
                System.out.println();
            }
        }
    }

