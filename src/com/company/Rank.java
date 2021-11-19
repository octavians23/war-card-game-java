package com.company;

public enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
    public String toString() {
        switch (this) {
            case ACE:
                return "Ace";
            case JACK:
                return "Jack";
            case QUEEN:
                return "Queen";
            case KING:
                return "King";
            default:
                int numericValue = 1 + ordinal();
                return "" + numericValue;
        }
    }
}
