package ca.cmpt213_a1.bike;

public class Bike {
    private int bikeID;
    private String ownerName;
    private String type;
    private String serialNumber;
    private String brakeType;
    private int wheelSize;

    public Bike(int bikeID, String ownerName, String type, String serialNumber, String brakeType, int wheelSize) {
        this.bikeID = bikeID;
        this.ownerName = ownerName;
        this.type = type;
        this.serialNumber = serialNumber;
        this.brakeType = brakeType;
        this.wheelSize = wheelSize;
    }

    public int getBikeID() {
        return bikeID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrakeType() {
        return brakeType;
    }

    public void setBrakeType(String brakeType) {
        this.brakeType = brakeType;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    @Override
    public String toString() {
        return String.format("Bike ID: %d, Owner Name: %s, Serial Number: %s, Brake Type: %s, Wheel Size: %d",
                bikeID, ownerName, serialNumber, brakeType, wheelSize);
    }

}
