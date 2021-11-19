package com.company;

public enum Suit {
    SPADES, HEARTS, DIAMONDS, CLUBS;

    public String toString(){
        switch (this){
            case SPADES:   return "Spades";
            case HEARTS:   return "Hearts";
            case DIAMONDS: return "Diamonds";
            default:       return "Clubs";
        }
    }
}
