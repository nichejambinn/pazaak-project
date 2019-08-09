package ca.sheridancollege.project;

public enum TableValue {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10);

    public final int value;

    private TableValue(int value) { this.value = value; }
    
    public int getValue() {
        return value;
    }
}