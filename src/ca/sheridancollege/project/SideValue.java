package ca.sheridancollege.project;

public enum SideValue {
    PLUS_ONE(1), PLUS_TWO(2), MINUS_ONE(-1), MINUS_TWO(-2), PLUS_FOUR(4), PLUS_FIVE(5), MINUS_FOUR(-4), MINUS_FIVE(-5);

    public final int value;

    private SideValue(int value) { this.value = value; }
}