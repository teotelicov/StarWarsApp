package Domain;

public class Ship extends BaseEntity<Long>{

    private long maxCargoWeight;
    private String name;
    private long speed;
    private ShipType type;

    public Ship( String name, long speed, ShipType type,long maxCargoWeight) {
        this.name = name;
        this.speed = speed;
        this.type = type;
        this.maxCargoWeight = maxCargoWeight;
    }

    public long getMaxCargoWeight() {
        return maxCargoWeight;
    }

    public void setMaxCargoWeight(long maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public ShipType getType() {
        return type;
    }

    public void setType(ShipType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString()+" Ship{" +
                "maxCargoWeight=" + maxCargoWeight +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", type=" + type +
                '}';
    }
}

