package com.example.battleship_gui;

import battleshipgame.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public class GameController {

        @FXML
        private Pane a00;

        @FXML
        private Pane a01;

        @FXML
        private Pane a02;

        @FXML
        private Pane a03;

        @FXML
        private Pane a04;

        @FXML
        private Pane a05;

        @FXML
        private Pane a06;

        @FXML
        private Pane a07;

        @FXML
        private Pane a08;

        @FXML
        private Pane a09;

        @FXML
        private Pane a10;

        @FXML
        private Pane a11;

        @FXML
        private Pane a12;

        @FXML
        private Pane a13;

        @FXML
        private Pane a14;

        @FXML
        private Pane a15;

        @FXML
        private Pane a16;

        @FXML
        private Pane a17;

        @FXML
        private Pane a18;

        @FXML
        private Pane a19;

        @FXML
        private Pane a20;

        @FXML
        private Pane a21;

        @FXML
        private Pane a22;

        @FXML
        private Pane a23;

        @FXML
        private Pane a24;

        @FXML
        private Pane a25;

        @FXML
        private Pane a26;

        @FXML
        private Pane a27;

        @FXML
        private Pane a28;

        @FXML
        private Pane a29;

        @FXML
        private Pane a30;

        @FXML
        private Pane a31;

        @FXML
        private Pane a32;

        @FXML
        private Pane a33;

        @FXML
        private Pane a34;

        @FXML
        private Pane a35;

        @FXML
        private Pane a36;

        @FXML
        private Pane a37;

        @FXML
        private Pane a38;

        @FXML
        private Pane a39;

        @FXML
        private Pane a40;

        @FXML
        private Pane a41;

        @FXML
        private Pane a42;

        @FXML
        private Pane a43;

        @FXML
        private Pane a44;

        @FXML
        private Pane a45;

        @FXML
        private Pane a46;

        @FXML
        private Pane a47;

        @FXML
        private Pane a48;

        @FXML
        private Pane a49;

        @FXML
        private Pane a50;

        @FXML
        private Pane a51;

        @FXML
        private Pane a52;

        @FXML
        private Pane a53;

        @FXML
        private Pane a54;

        @FXML
        private Pane a55;

        @FXML
        private Pane a56;

        @FXML
        private Pane a57;

        @FXML
        private Pane a58;

        @FXML
        private Pane a59;

        @FXML
        private Pane a60;

        @FXML
        private Pane a61;

        @FXML
        private Pane a62;

        @FXML
        private Pane a63;

        @FXML
        private Pane a64;

        @FXML
        private Pane a65;

        @FXML
        private Pane a66;

        @FXML
        private Pane a67;

        @FXML
        private Pane a68;

        @FXML
        private Pane a69;

        @FXML
        private Pane a70;

        @FXML
        private Pane a71;

        @FXML
        private Pane a72;

        @FXML
        private Pane a73;

        @FXML
        private Pane a74;

        @FXML
        private Pane a75;

        @FXML
        private Pane a76;

        @FXML
        private Pane a77;

        @FXML
        private Pane a78;

        @FXML
        private Pane a79;

        @FXML
        private Pane a80;

        @FXML
        private Pane a81;

        @FXML
        private Pane a82;

        @FXML
        private Pane a83;

        @FXML
        private Pane a84;

        @FXML
        private Pane a85;

        @FXML
        private Pane a86;

        @FXML
        private Pane a87;

        @FXML
        private Pane a88;

        @FXML
        private Pane a89;

        @FXML
        private Pane a90;

        @FXML
        private Pane a91;

        @FXML
        private Pane a92;

        @FXML
        private Pane a93;

        @FXML
        private Pane a94;

        @FXML
        private Pane a95;

        @FXML
        private Pane a96;

        @FXML
        private Pane a97;

        @FXML
        private Pane a98;

        @FXML
        private Pane a99;

        @FXML
        private Button battack;

        @FXML
        private Button bplaceships;

        @FXML
        private Pane s00;

        @FXML
        private Pane s011;

        @FXML
        private Pane s021;

        @FXML
        private Pane s031;

        @FXML
        private Pane s041;

        @FXML
        private Pane s051;

        @FXML
        private Pane s061;

        @FXML
        private Pane s071;

        @FXML
        private Pane s081;

        @FXML
        private Pane s091;

        @FXML
        private Pane s10;

        @FXML
        private Pane s111;

        @FXML
        private Pane s121;

        @FXML
        private Pane s131;

        @FXML
        private Pane s141;

        @FXML
        private Pane s151;

        @FXML
        private Pane s161;

        @FXML
        private Pane s171;

        @FXML
        private Pane s181;

        @FXML
        private Pane s191;

        @FXML
        private Pane s20;

        @FXML
        private Pane s211;

        @FXML
        private Pane s221;

        @FXML
        private Pane s231;

        @FXML
        private Pane s241;

        @FXML
        private Pane s251;

        @FXML
        private Pane s261;

        @FXML
        private Pane s271;

        @FXML
        private Pane s281;

        @FXML
        private Pane s291;

        @FXML
        private Pane s301;

        @FXML
        private Pane s311;

        @FXML
        private Pane s321;

        @FXML
        private Pane s331;

        @FXML
        private Pane s341;

        @FXML
        private Pane s351;

        @FXML
        private Pane s361;

        @FXML
        private Pane s371;

        @FXML
        private Pane s381;

        @FXML
        private Pane s391;

        @FXML
        private Pane s401;

        @FXML
        private Pane s411;

        @FXML
        private Pane s421;

        @FXML
        private Pane s431;

        @FXML
        private Pane s441;

        @FXML
        private Pane s451;

        @FXML
        private Pane s461;

        @FXML
        private Pane s471;

        @FXML
        private Pane s481;

        @FXML
        private Pane s491;

        @FXML
        private Pane s501;

        @FXML
        private Pane s511;

        @FXML
        private Pane s521;

        @FXML
        private Pane s531;

        @FXML
        private Pane s541;

        @FXML
        private Pane s551;

        @FXML
        private Pane s561;

        @FXML
        private Pane s571;

        @FXML
        private Pane s581;

        @FXML
        private Pane s591;

        @FXML
        private Pane s601;

        @FXML
        private Pane s611;

        @FXML
        private Pane s621;

        @FXML
        private Pane s631;

        @FXML
        private Pane s641;

        @FXML
        private Pane s651;

        @FXML
        private Pane s661;

        @FXML
        private Pane s671;

        @FXML
        private Pane s681;

        @FXML
        private Pane s691;

        @FXML
        private Pane s701;

        @FXML
        private Pane s711;

        @FXML
        private Pane s721;

        @FXML
        private Pane s731;

        @FXML
        private Pane s741;

        @FXML
        private Pane s751;

        @FXML
        private Pane s761;

        @FXML
        private Pane s771;

        @FXML
        private Pane s781;

        @FXML
        private Pane s791;

        @FXML
        private Pane s801;

        @FXML
        private Pane s811;

        @FXML
        private Pane s821;

        @FXML
        private Pane s831;

        @FXML
        private Pane s841;

        @FXML
        private Pane s851;

        @FXML
        private Pane s861;

        @FXML
        private Pane s871;

        @FXML
        private Pane s881;

        @FXML
        private Pane s891;

        @FXML
        private Pane s901;

        @FXML
        private Pane s911;

        @FXML
        private Pane s921;

        @FXML
        private Pane s931;

        @FXML
        private Pane s941;

        @FXML
        private Pane s951;

        @FXML
        private Pane s961;

        @FXML
        private Pane s971;

        @FXML
        private Pane s981;

        @FXML
        private Pane s991;

        @FXML
        private TextField tsxvalue;

        @FXML
        private TextField tsyvalue;

        @FXML
        private TextField txvalue;

        @FXML
        private TextField tyvalue;

    @FXML
    private GridPane sgp;
    @FXML
    private GridPane agp;


    private Board humanPlayerBoard = new Board();
    private Board aiPlayerBoard = new Board();
    private AI_Playersrv ai_player = new AI_Playersrv("AI Player");
    private Playersrv humanPlayer = new Playersrv();
    public int numOfShips = 0;
    private int humanPlayerShipsAlive = 17;
    private int aiPlayerShipsAlive = 17;
    private Node[][] gridPaneArray = null;
    private Node[][] gridPaneAttackArray = null;
    public boolean gameRun = true;
    public ArrayList<String> attacks = new ArrayList<>();

        private void initializeGridPaneArray(String player) {
            if(player.equals(ai_player.getName())) {
                    this.gridPaneAttackArray = new Node[10][10];
                    int i = 0;
                    for (Node node : this.agp.getChildren()) {
                            if (i < 100) {
                                    this.gridPaneAttackArray[GridPane.getRowIndex(node)][GridPane.getColumnIndex(node)] = node;
                                    i++;
                            }

                    }
            }else{
                    this.gridPaneArray = new Node[10][10];
                    int i = 0;
                    for (Node node : this.sgp.getChildren()) {
                            if (i < 100) {
                                    this.gridPaneArray[GridPane.getRowIndex(node)][GridPane.getColumnIndex(node)] = node;
                                    i++;
                            }

                    }
            }
    }


    @FXML
    void btnPlaceShipsClicked(MouseEvent event) throws IOException {
            if (numOfShips < 5) {
                    ShipType currentShipType = null;
                    if (numOfShips < 5) {
                            currentShipType = getShipTypes().get(numOfShips);
                    }
                    if (currentShipType == null) {
                            return;
                    }
                    boolean isHorizontal = event.getButton() == MouseButton.SECONDARY;
                    String posit = isHorizontal ? "h" : "v";
                    int x = Integer.parseInt(String.valueOf(event.getSource().toString().charAt(9)));
                    int y = Integer.parseInt(String.valueOf(event.getSource().toString().charAt(10)));
                    Ship ship = new Ship(currentShipType, x, y);
                    if (!humanPlayerBoard.isInputValid(x, y, ship.getShipType(), 10, 10, posit, humanPlayerBoard.PlayerBoard)) {
                            System.out.println("Invalid placement, Cannot place ship on selected squares.");
                            return;
                    }
                    humanPlayerBoard.placeShip(ship, x, y, posit);
                    numOfShips++;

                    try {
                            updateGameBoardDisplay("");
                            System.out.println(humanPlayerBoard.PlayerBoard);
                    } catch (IOException e) {
                            throw new RuntimeException(e);
                    }
            }else if(gameRun){
                    AI_Playersrv.placeShip(aiPlayerBoard.PlayerBoard,ai_player);
                    updateGameBoardDisplay(ai_player.getName());
                    gameRun = false;
            }
    }

        @FXML
        void btnAttackShipsClicked(MouseEvent event) {
                if (!gameRun) {
                        int x = Integer.parseInt(String.valueOf(event.getSource().toString().charAt(9)));
                        int y = Integer.parseInt(String.valueOf(event.getSource().toString().charAt(10)));
                        if (aiPlayerBoard.PlayerBoard.isSquareEmpty(x, y)) {
                                gridPaneAttackArray[y][x].setStyle("-fx-background-color: WHITE");
                        } else {
                                gridPaneAttackArray[y][x].setStyle("-fx-background-color: RED");
                                aiPlayerShipsAlive--;
                        }
                        aiPlayerBoard.PlayerBoard.getSquares()[x][y].setHit(true);

                        Locationsrv attkloc = ai_player.attackCoords(humanPlayerBoard.PlayerBoard, attacks);
                        attacks.add(attkloc.getX() + "" + attkloc.getY());
                        humanPlayerBoard.PlayerBoard.getSquares()[attkloc.getX()][attkloc.getY()].setHit(true);
                        if (humanPlayerBoard.PlayerBoard.isSquareEmpty(attkloc.getX(), attkloc.getY())) {
                                gridPaneArray[attkloc.getY()][attkloc.getX()].setStyle("-fx-background-color: WHITE");
                        } else {
                                gridPaneArray[attkloc.getY()][attkloc.getX()].setStyle("-fx-background-color: RED");
                                humanPlayerShipsAlive--;
                        }
                        if (humanPlayerShipsAlive == 0) {
                                System.out.println("ALL YOUR SHIPS WERE DESTROYED, AI PLAYER WINS!");
                                gameRun = true;
                        }
                        if (aiPlayerShipsAlive == 0) {
                                System.out.println("YOU DESTROYED ALL ENEMY SHIPS, YOU WIN!");
                                gameRun = true;
                        }

                }
        }

    private void updateGameBoardDisplay(String player) throws IOException {
            initializeGridPaneArray(player);
            if(player.equals(ai_player.getName())) {
                    for (int i = 0; i < 10; i++) {
                            for (int j = 0; j < 10; j++) {
                                    Node node = gridPaneAttackArray[i][j];
                                    if (!aiPlayerBoard.PlayerBoard.isSquareEmpty(j, i)) {
                                    }
                            }
                    }
            }else{
                    for (int i = 0; i < 10; i++) {
                            for (int j = 0; j < 10; j++) {
                                    Node node = gridPaneArray[i][j];
                                    if (!humanPlayerBoard.PlayerBoard.isSquareEmpty(j, i)) {
                                            node.setStyle("-fx-background-color: BLUE");
                                    }
                            }
                    }
            }

    }

    public ArrayList<ShipType> getShipTypes(){
        ArrayList<ShipType> listofships = ShipType.getShipTypes();
        return listofships;
    }



}
