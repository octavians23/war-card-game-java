package com.company;

public class PlayingCard implements Comparable<PlayingCard> {
    private final Suit suit;
    private final Rank rank;

    public PlayingCard(Rank rank, Suit suit) {
        if (rank == null || suit == null)
            throw new NullPointerException("Card suit and value cannot be null.");
        this.rank = rank;
        this.suit = suit;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public String toString() {
        return this.rank + " of " + this.suit;
    }

    @Override
    public int compareTo(PlayingCard c) {
        if (getRank().compareTo(c.getRank()) == 0)
            return 0;
        if (getRank().compareTo(c.getRank()) > 0)
            return 1;
        if (getRank().compareTo(c.getRank()) < 0)
            return -1;
        return getRank().compareTo(c.getRank());
    }

    public int getNumber() {
        return switch (this.getRank()) {
            case ACE, QUEEN, JACK, KING, TEN -> 10;
            case TWO -> 2;
            case THREE -> 3;
            case FOUR -> 4;
            case FIVE -> 5;
            case SIX -> 6;
            case SEVEN -> 7;
            case EIGHT -> 8;
            case NINE -> 9;
        };
    }
}


