package battleshipgame;

import java.util.ArrayList;

public enum ShipType {
    DESTROYER(2, "\033[34mDestroyer\033[0m",1),
    SUBMARINE(3, "\033[34mSubmarine\033[0m",2),
    BATTLESHIP(4,"\033[34mBattleship\033[0m",3),
    CARRIER(5,"\033[34mCarrier\033[0m", 4),
    PATROLBOAT(3,"\033[34mPatrolBoat\033[0m",5 ),
    EMPTY(0, "______Water", 0);

    private int id;
    private final int size;
    private final String name;

    private ShipType(int size, String name, int id){
        this.size = size;
        this.name = name;
        this.id = id;
        if(name == "Destroyer"){
            this.id = 1;
        }
        if(name == "Battleship"){
            this.id = 3;
        }
        if(name == "Submarine"){
            this.id = 2;
        }
        if(name == "Carrier"){
            this.id = 4;
        }
        if(name == "PatrolBoat"){
            this.id = 5;
        }
        if(name == "EMPTY_SHIP"){
            this.id = 0;
        }

    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }


    public String getName() {
        return name;
    }
    public String getCoordinates() {
        String letter = this.name().charAt(0) + "";
        String number = this.size + "";
        return letter + number;
    }

    public static ArrayList<ShipType> getShipTypes(){
        ArrayList<ShipType> allShipTypes = new ArrayList<ShipType>();
        for (ShipType shipType : ShipType.values()){
            allShipTypes.add(shipType);
        }
        return allShipTypes;
    }
}
