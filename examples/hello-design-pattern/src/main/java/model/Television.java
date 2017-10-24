package model;

public class Television extends Product {

    public enum TVType {
        LED, OLED, PLASMA, CRT
    }

    private TVType type;

    public TVType getType() {
        return type;
    }

    public void setType(TVType type) {
        this.type = type;
    }
}
