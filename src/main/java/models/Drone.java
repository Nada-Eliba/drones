package models;

public class Drone {
    String serialNumber;
    float weight;
    float batteryPercentage;
    Model model;
    State state;

    enum Model {
        LIGHT_WEIGHT,
        MIDDLE_WEIGHT,
        CRUISER_WEIGHT,
        HEAVY_WEIGHT
    }

    enum State {
        IDLE,
        LOADING,
        LOADED,
        DELIVERING,
        DELIVERED,
        RETURNING
    }

    /** Constructors **/

    public Drone () {
        // default constructor
        // do nothing
    }

    public Drone (String serialNumber,
                  float weight,
                  float batteryPercentage,
                  Model model,
                  State state) {

        if (getIsSerialNumberValid(serialNumber)) {
            this.serialNumber = serialNumber;
        }
        else {
            throw new IllegalArgumentException("Serial number must be 100" +
                    " character long maximum");
        }

        if (getIsWeightValid(weight)) {
            this.weight = weight;
        }
        else {
            throw new IllegalArgumentException("Weight must be 500gm maximum");
        }

        if (getIsBatteryPercentageValid(batteryPercentage)) {
            this.batteryPercentage = batteryPercentage;
        }
        else {
            throw new IllegalArgumentException("Battery Percentage must range" +
                    " between 0 and 100");
        }

        this.model = model;
        this.state = state;
    }

    /** Getter Methods **/

    public float getBatteryPercentage() {
        return batteryPercentage;
    }

    public float getWeight() {
        return weight;
    }

    public Model getModel() {
        return model;
    }

    public State getState() {
        return state;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    /** Setter Methods **/

    public void setBatteryPercentage(float batteryPercentage) {
        if (getIsBatteryPercentageValid(batteryPercentage)) {
            this.batteryPercentage = batteryPercentage;
        }
        else {
            throw new IllegalArgumentException("Battery Percentage must range" +
                    " between 0 and 100");
        }
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setSerialNumber(String serialNumber) {
        if (getIsSerialNumberValid(serialNumber)) {
            this.serialNumber = serialNumber;
        }
        else {
            throw new IllegalArgumentException("Serial number must be 100" +
                    " character long maximum");
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setWeight(float weight) {
        if (getIsWeightValid(weight)) {
            this.weight = weight;
        }
        else {
            throw new IllegalArgumentException("Weight must be 500gm maximum");
        }
    }

    /** Class Attributes Validator Methods **/

    boolean getIsBatteryPercentageValid(float batteryPercentage){
        return (batteryPercentage >= 0 && batteryPercentage <= 100);
    }

    boolean getIsSerialNumberValid(String serialNumber) {
        return (serialNumber.length() <= 100);
    }

    boolean getIsWeightValid(float weight) {
        return (weight > 0 && weight <= 500);
    }
}
