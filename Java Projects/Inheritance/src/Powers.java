public class Powers {
    private String name;

    private PowerType powerType;

    public Powers(String name, PowerType powerType) {
        this.name = name;
        this.powerType = powerType;
    }

    @Override
    public String toString() {
        return this.name + " is of type " + this.powerType;
    }

    @Override
    public boolean equals(Object obj) {
        return this.powerType == obj;
    }
}
