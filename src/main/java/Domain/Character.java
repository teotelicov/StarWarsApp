package Domain;

import java.util.ArrayList;
import java.util.List;

public class Character extends BaseEntity<Long> {

    private String name;
    private List<ShipType> ships_type;

    public Character(String name, List<ShipType> ships_type) {
        this.name = name;
        this.ships_type = ships_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ShipType> getShips_type() {
        return ships_type;
    }

    public void setShips_type(ArrayList<ShipType> ships_type) {
        this.ships_type = ships_type;
    }

    @Override
    public String toString() {
        return super.toString()+" Character{" +
                "name='" + name + '\'' +
                ", ships_type=" + ships_type +
                "} ";
    }
}
