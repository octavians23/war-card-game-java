package com.company;


import java.util.*;

public class Deck {
    private List<PlayingCard> cards;

    public Deck() {
        this.cards = new LinkedList<>();
    }

    public List<PlayingCard> getList(){
        return Collections.unmodifiableList(cards);
    }

    public boolean addPlayingCard(PlayingCard c){
      if(cards.contains(c)){
          System.out.println("The card is already in the deck.");
          return false;
      } else {
          cards.add(c);
          return true;
      }
    }


    public int isEmpty(){
        if(cards.isEmpty()){
            return 1;
        } else return 0;
    }


    public boolean removeCard(PlayingCard card) {
//        PlayingCard card = new PlayingCard(rank, suit);
        if(cards.contains(card)){
            cards.remove(card);
            return true;
        } else {
            System.out.println("The card is not in the deck");
            return false;
        }
    }


    public void sort(){
        Collections.sort(cards);
    }
    public void shuffle() {
        Collections.shuffle(cards, new Random());
    }

    public void display(){
        int i = 1;
        for(PlayingCard card: cards){
            System.out.println("Card " + (i++) + ": "+ card.getRank() + " of " + card.getSuit());
        }
    }
}
