public class Power {
    private String powerName;
    private PowerType powerType;


    public Power(String powerName, PowerType powerType) {
        if (powerName.length() > 20) {
            this.powerName = powerName.substring(0, 20);
        } else {
            this.powerName = powerName;
        }
        this.powerType = powerType;
    }

    public void setPowerName(String powerName) {
        if (powerName.length() > 20) {
            this.powerName = powerName.substring(0, 20);
        } else {
            this.powerName = powerName;
        }
    }

    public void setPowerType(PowerType powerType) {
        this.powerType = powerType;
    }

    public String getPowerName() {

        return powerName;
    }

    public PowerType getPowerType() {
        return powerType;
    }

    @Override
    public String toString() {
        return this.powerName + " " + this.powerType;
    }
}
