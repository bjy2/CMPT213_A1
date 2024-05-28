package ca.sfu.cmpt213.as1;

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
        return String.format("%s[Id:%d, Owner:%s, Type:%s, Serial:%s, Brake:%s, WheelSize:%d]",
                getClass().getName(), bikeID, ownerName, type, serialNumber, brakeType, wheelSize);
    }

}
