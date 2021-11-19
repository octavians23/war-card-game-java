package com.company;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Main {

    //linkedList for when a tie within a tie happens, to put all the previous cards
    public static LinkedList<PlayingCard> furtherTies = new LinkedList<>();
    public static LinkedList<PlayingCard> firstWar = new LinkedList<>();

    //int to check if the current tie is within a tie
    public static int number = 0;


    public static void main(String[] args) {
        //initialize a new deck and fill it with all the cards, after that we shuffle it
        Deck deck = new Deck();
        for (Suit suit : Suit.values())
            for (Rank value : Rank.values()) {
                PlayingCard c = new PlayingCard(value, suit);
                deck.addPlayingCard(c);
            }
        deck.shuffle();

//        PlayingCard c1 = new PlayingCard(Rank.THREE, Suit.DIAMONDS);
//        PlayingCard c2 = new PlayingCard(Rank.FOUR, Suit.DIAMONDS);
//        PlayingCard c3 = new PlayingCard(Rank.FIVE, Suit.DIAMONDS);
//        PlayingCard c4 = new PlayingCard(Rank.SIX, Suit.DIAMONDS);
//        PlayingCard c5 = new PlayingCard(Rank.SEVEN, Suit.DIAMONDS);
//        PlayingCard c6 = new PlayingCard(Rank.EIGHT, Suit.DIAMONDS);
//        PlayingCard c7 = new PlayingCard(Rank.NINE, Suit.DIAMONDS);
//        PlayingCard c8 = new PlayingCard(Rank.TWO, Suit.DIAMONDS);
//        PlayingCard c9 = new PlayingCard(Rank.KING, Suit.DIAMONDS);
//        PlayingCard c10 = new PlayingCard(Rank.ACE, Suit.DIAMONDS);
//        PlayingCard c11 = new PlayingCard(Rank.THREE, Suit.CLUBS);
//        PlayingCard c12 = new PlayingCard(Rank.FOUR,  Suit.CLUBS);
//        PlayingCard c13 = new PlayingCard(Rank.FIVE,  Suit.CLUBS);
//        PlayingCard c14 = new PlayingCard(Rank.SIX,  Suit.CLUBS);
//        PlayingCard c15 = new PlayingCard(Rank.SEVEN,  Suit.CLUBS);
//        PlayingCard c16 = new PlayingCard(Rank.EIGHT,  Suit.CLUBS);
//        PlayingCard c17 = new PlayingCard(Rank.NINE,  Suit.CLUBS);
//        PlayingCard c18 = new PlayingCard(Rank.TWO,  Suit.CLUBS);
//        PlayingCard c19 = new PlayingCard(Rank.KING,  Suit.CLUBS);
//        PlayingCard c20 = new PlayingCard(Rank.QUEEN,  Suit.CLUBS);


        LinkedList<PlayingCard> player1 = new LinkedList<>(deck.getList().subList(0, 25));
        LinkedList<PlayingCard> player2 = new LinkedList<>(deck.getList().subList(26, 52));

//        player1.add(c1);
//        player1.add(c2);
//        player1.add(c3);
//        player1.add(c4);
//        player1.add(c5);
//        player1.add(c6);
//        player1.add(c7);
//        player1.add(c8);
//        player1.add(c9);
//        player1.add(c10);
//        player2.add(c11);
//        player2.add(c12);
//        player2.add(c13);
//        player2.add(c14);
//        player2.add(c15);
//        player2.add(c16);
//        player2.add(c17);
//        player2.add(c18);
//        player2.add(c19);
//        player2.add(c20);

        //print for testing
//        for(PlayingCard card: player1){
//           System.out.println("Card " + (player1.indexOf(card)+1) + ": " + card);
//       }
//        System.out.println("=========================");
//        for(PlayingCard card: player2){
//            System.out.println("Card " + (player2.indexOf(card)+1) + ": " + card);
//        }


        boolean flag = false;
        while (!flag) {
            //both players place one card face up
            PlayingCard p1Card = player1.pop();
            PlayingCard p2Card = player2.pop();

            //display the cards drawn
            System.out.println("Player 1 plays " + p1Card);
            System.out.println("Player 2 plays " + p2Card);

            int randomizer = (int) ((Math.random() * (3 - 1)) + 1);
            //compare the ranks of the two cards
            if (p1Card.compareTo(p2Card) > 0) { //p1 wins, add the two cards random
                if(randomizer == 1){
                    player1.addLast(p1Card);
                    player1.addLast(p2Card);
                } else{
                    player1.addLast(p2Card);
                    player1.addLast(p1Card);
                }
                System.out.println("Player 1 wins the round.");
            } else if (p1Card.compareTo(p2Card) < 0) { //p2 wins, add the two cards random
                if(randomizer == 1){
                    player2.addLast(p1Card);
                    player2.addLast(p2Card);
                } else{
                    player2.addLast(p2Card);
                    player2.addLast(p1Card);
                }
                System.out.println("Player 2 wins the round.");
            } else { // the cards are equal so we get a war
                firstWar.add(p1Card);
                firstWar.add(p2Card);
                tie(player1, player2, p1Card);
            }
            //game over either one player runs out of card(deck size is 0)
            flag = check_winner(player1, player2);
        }

        for(PlayingCard card: player1){
           System.out.println("Card " + (player1.indexOf(card)+1) + ": " + card);
       }
        System.out.println("=========================");
        for(PlayingCard card: player2){
            System.out.println("Card " + (player2.indexOf(card)+1) + ": " + card);
        }
    }

    //tie method
    public static void tie(LinkedList<PlayingCard> player1, LinkedList<PlayingCard> player2, PlayingCard card){

        //check if one player remains without cards
        check_winner(player1, player2);

        System.out.println("War:");
        //check for how many cards they will play war with
        int index = card.getNumber();
        if(player1.size() < index || player2.size() < index){
            index = Math.min(player1.size(), player2.size());
        }

        LinkedList<PlayingCard> war1 = new LinkedList<>();
        LinkedList<PlayingCard> war2 = new LinkedList<>();

        //prepare the war decks
        for (int i = 0; i < index; i++) {

            war1.add(player1.pop());
            war2.add(player2.pop());
        }
        //PlayingCard c1 = war1.
        System.out.println("Player 1 plays: " + war1.getLast() + " out of " + war1.size() + " cards");
        System.out.println("Player 2 plays: " + war2.getLast() + " out of " + war2.size() + " cards");
        //if player 1 wins, he gets all the cards
        if (war1.getLast().compareTo(war2.getLast()) > 0) {
            if(number > 0 ){  //if this is a tie within a tie put all the cards from the previous tie too
                player1.addAll(firstWar);
                firstWar.clear();
                player1.addAll(war1);
                player1.addAll(war2);
                player1.addAll(furtherTies);
                furtherTies.clear();
                number = 0;
            }else{
                player1.addAll(firstWar);
                firstWar.clear();
                player1.addAll(war1);
                player1.addAll(war2);
                System.out.println("Player 1 wins the war round");
            }

            //if player 2 wins, the gets all the cards
        } else if(war1.getLast().compareTo(war2.getLast()) < 0){
            if(number > 0) {
                //if this is a tie within a tie put all the cards from the previous tie too
                player2.addAll(firstWar);
                firstWar.clear();
                player2.addAll(war1);
                player2.addAll(war2);
                player2.addAll(furtherTies);
                furtherTies.clear();
                number = 0;
            } else{
                player2.addAll(firstWar);
                firstWar.clear();
                player2.addAll(war1);
                player2.addAll(war2);
                System.out.println("Player 2 wins the war round");
            }
            //if it's again a tie, war again
        } else{
            try{
                furtherTies.addAll(war1);
                furtherTies.addAll(war2);
                number++;
                tie(player1, player2, furtherTies.getLast());
            } catch(NoSuchElementException e){
                //ignore
            }
        }
    }

    //check if the size of wither of the decks is 0, meaning the other player wins
    public static boolean check_winner(LinkedList<PlayingCard> player1, LinkedList<PlayingCard> player2){
        boolean flag = false;
        if(player1.size() == 0){
            System.out.println("Player two wins the game");
            flag = true;
        }else if(player2.size() == 0){
            System.out.println("Player one wins the game");
            flag = true;
        }
        return flag;
    }
}
