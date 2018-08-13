import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
public class Blackjack{
  static Scanner turnInput = new Scanner(System.in);
  static Card lastCard;
  static Deck originDeck = new Deck();
  static boolean isDoubleDown = false;
  static boolean playerStand = false;
  static boolean player2Stand = false;
  static boolean playerBust = false;
  static boolean player2Bust = false;
  static int bet = 1;
  static String input;
  public static void main(String[] args){

    final String[] CARD_SUITS = {"CLUBS", "SPADES", "DIAMONDS", "HEARTS"};
    final String[] CARD_NAMES = {"ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING"};
    boolean gameRunning = true;
    boolean dealerStand = false;
    boolean dealerBust = false;
    boolean playerSplit = false;

    int playerMoney = 100;        //Buy in

    //For testing split
    Card a = new Card("Heart", "King", 10);
    Card b = new Card ("Diamond", "King", 10);
    Deck sampleDeck = new Deck();
    boolean giveSplit = false;      //true = test split

    Deck playerDeck = new Deck();
    Deck dealerDeck = new Deck();
    Deck playerDeck2 = new Deck();

    while(gameRunning){
      sampleDeck.addCard(a);
      sampleDeck.addCard(b);
      boolean isValid = false;
      originDeck.buildDeck(CARD_SUITS, CARD_NAMES);
      System.out.println("You have: $" + playerMoney);
      originDeck.shuffle();
      System.out.println("How much do you want to bet?");
      while(!isValid){
        if(turnInput.hasNextInt()){
          bet = turnInput.nextInt();
          isValid = true;
        }else{
          System.out.println("Please enter a number");
          turnInput.nextLine();
        }
      }
      playerMoney = playerMoney - bet;

      if(giveSplit){
        playerDeck.draw(sampleDeck);      //When testing split set originDeck to playerDeck
        dealerDeck.draw(originDeck);
        playerDeck.draw(sampleDeck);      //When testing split set originDeck to playerDeck
        dealerDeck.draw(originDeck);
      }else{
        playerDeck.draw(originDeck);
        dealerDeck.draw(originDeck);
        playerDeck.draw(originDeck);
        dealerDeck.draw(originDeck);
      }
      System.out.println("Dealer's first card");
      System.out.println(dealerDeck.getCard(0).toString());
      if(playerDeck.getName(0)==playerDeck.getName(1)){
        System.out.println("Your current hand:");
        System.out.println(playerDeck.toString() );
        System.out.println("Do you want to split the hand?");
        input = turnInput.next();
        playerSplit = checkPlayerDone(input);   //checkPlayerDone returns true if yes
      }
      if(playerSplit){
        playerDeck2.draw(playerDeck);
        playerDeck2.draw(originDeck);
      }
      if(!playerSplit){
        if(playerDeck.cardsValue()==21){
          System.out.println("Blackjack!");
          playerStand = true;
        }
      }
      //Player1 plays
      if(playerSplit) {
    	  while(!playerStand) {
          playerDeck.draw(originDeck);
          lastCard = playerDeck.getCard(playerDeck.size()-1);
          if(lastCard.getValue()==11 && playerDeck.cardsValue()!=21) {
            if(playerDeck.cardsValue()>21){
              lastCard.setValue(1);
            }
          }
          if(playerDeck.cardsValue() == 21){
            System.out.println("Blackjack!");
            playerStand = true;
          }else{
            System.out.println("Player1 current hand:");
    		    System.out.println(playerDeck.toString() );
            checkDoubleDown(playerDeck);
            if(!isDoubleDown){
                System.out.println("Do you want to hit or stand?");
                input = turnInput.next();
                playerStand = checkPlayerMove(input);
            }
              if(!playerStand){
                playerDeck.draw(originDeck);
                lastCard = playerDeck.getCard(playerDeck.size()-1);
                if(lastCard.getValue()==11 && playerDeck.cardsValue()!=21) {
                  if(playerDeck.cardsValue()>21){
                		lastCard.setValue(1);
                  }
                }
              }
                //check for bust & blackjack
                if(playerDeck.cardsValue() > 21){
                  System.out.println("Bust");
                  playerBust = true;
                  playerStand = true;
                }else if(playerDeck.cardsValue() == 21){
                  System.out.println("Blackjack!");
                  playerStand = true;
                }
              }
    	  }
        System.out.println("Player1 final hand: ");
        System.out.println(playerDeck.toString() );
        //Player2
        while(!player2Stand) {
          lastCard = playerDeck2.getCard(playerDeck2.size()-1);
          if(lastCard.getValue()==11 && playerDeck2.cardsValue()!=21) {
            if(playerDeck2.cardsValue()>21){
              lastCard.setValue(1);
            }
          }
          if(playerDeck2.cardsValue()==21){
            System.out.println("Blackjack");
            player2Stand = true;
          }else{
              System.out.println("Your current hand:");
    		      System.out.println(playerDeck2.toString());
              checkDoubleDown(playerDeck);
              if(!isDoubleDown){
        		      System.out.println("Do you want to hit or stand?");
                  input = turnInput.next();
                  player2Stand = checkPlayerMove(input);
                }
                  if(!player2Stand){
                    playerDeck2.draw(originDeck);
                    lastCard = playerDeck2.getCard(playerDeck2.size()-1);
                    if(lastCard.getValue()==11 && playerDeck2.cardsValue()!=21) {
                      if(playerDeck2.cardsValue()>21){
                    		lastCard.setValue(1);
                      }
                    }

                    //check for bust & blackjack
                    if(playerDeck2.cardsValue() > 21){
                      System.out.println("Bust");
                      player2Bust = true;
                      player2Stand = true;
                    }else if(playerDeck2.cardsValue() == 21){
                      System.out.println("Blackjack!");
                      player2Stand = true;
                    }
                  }
                }
              }
          System.out.println("Player 2 final hand: ");
          System.out.println(playerDeck2.toString());
    	//set playerDeck equal to the highest playerDeck that didn't bust
    	if(!playerBust && !player2Bust) {
    	  if(playerDeck2.cardsValue() > playerDeck.cardsValue()) {
    		  playerDeck = playerDeck2;
    	  }
    	}else if(playerBust && !player2Bust) {
    		playerDeck = playerDeck2;
    		playerBust = false;
    	}
      }else{

        while(!playerStand){
          lastCard = playerDeck.getCard(playerDeck.size()-1);
          if(lastCard.getValue()==11 && playerDeck.cardsValue()!=21) {
            if(playerDeck.cardsValue()>21){
              lastCard.setValue(1);
            }
          }
          if(playerDeck.cardsValue()==21){
            System.out.println("Blackjack!");
            playerStand = true;
            break;
          }else{
          //Print Cards in hand
              System.out.println("Your current hand:");
    	        System.out.println(playerDeck.toString() );
              checkDoubleDown(playerDeck);
          if(!isDoubleDown){
              System.out.println("Do you want to hit or stand?");
              input = turnInput.next();
              playerStand = checkPlayerMove(input);
            }
          if(!playerStand){
            playerDeck.draw(originDeck);
            lastCard = playerDeck.getCard(playerDeck.size()-1);
            if(lastCard.getValue()==11 && playerDeck.cardsValue()!=21) {
              if(playerDeck.cardsValue()>21){
            		lastCard.setValue(1);
              }
            }
          }
            //check for bust & blackjack
            if(playerDeck.cardsValue() > 21){
              System.out.println("Bust");
              playerBust = true;
              playerStand = true;
            }else if(playerDeck.cardsValue() == 21){
              System.out.println("Blackjack!");
              playerStand = true;
              break;
            }

        }
      }
    }
      System.out.println("Your final hand: ");
      System.out.println(playerDeck.toString()  );
        while(!dealerStand){
          lastCard = dealerDeck.getCard(dealerDeck.size()-1);
          if(lastCard.getValue()==11 && dealerDeck.cardsValue()!=21) {
            if(dealerDeck.cardsValue()>21){
              lastCard.setValue(1);
            }
          }
          //dealer AI decides if it should hit or not
          //Rule is dealer stands at or above 17
          if(dealerDeck.cardsValue() >= 17 && dealerDeck.cardsValue()<22){
              dealerStand = true;
              break;
          //if hit, check for bust
        }else if(dealerDeck.cardsValue()>21){
            dealerBust = true;
            dealerStand = true;
            break;
          }else{
              dealerDeck.draw(originDeck);
              lastCard = dealerDeck.getCard(dealerDeck.size()-1);
              if(lastCard.getValue()==11 && dealerDeck.cardsValue()!=21) {
                if(dealerDeck.cardsValue()>21){
                  lastCard.setValue(1);
                }
              }
              //check for bust & blackjack
              if(dealerDeck.cardsValue() > 21){
                dealerBust = true;
                dealerStand = true;
                break;
              }
            }
        }
        if(!dealerBust) {
        	System.out.println("Dealer's final hand");
          System.out.println(dealerDeck.toString() );
        }else {
        	System.out.println("Dealer busted with:  ");
          System.out.println(dealerDeck.toString() );
        }
        bet = bet * 2;
        //compare scores
        if(!playerBust && !dealerBust){
          if(playerDeck.cardsValue() > dealerDeck.cardsValue()){
            System.out.println("You win.");
            playerMoney = playerMoney + bet;
            bet = 0;
          }else if(playerDeck.cardsValue() < dealerDeck.cardsValue()){
            System.out.println("You Lost.");
            bet = 0;
          }else{
            System.out.println("It was a tie.");
            bet = bet/2;
            playerMoney = playerMoney + bet;
            bet = 0;
          }
        }else if(playerBust && !dealerBust){
          System.out.println("You lost.");
          bet = 0;
        }else if(!playerBust && dealerBust){
          System.out.println("You won.");
          playerMoney = playerMoney + bet;
          bet = 0;
        }else if(playerBust && dealerBust){
          System.out.println("It was a tie.");
          bet = bet/2;
          playerMoney = playerMoney + bet;
          bet = 0;
        }
      //ask player if they want to play again
    if(playerMoney > 0){
      System.out.println("Do you want to play next hand?");
      input = turnInput.nextLine();
      gameRunning = checkPlayerDone(input);
    }else{
      System.out.println("You are out of money.  GET OUT!");
      gameRunning = false;
    }
      //empty player and dealer decks back into original deck
      originDeck.deckClear();
      playerDeck.deckClear();
      dealerDeck.deckClear();
      playerDeck2.deckClear();
      //reset for next round
      isDoubleDown = false;
      playerStand = false;
      player2Stand = false;
      dealerStand = false;
      playerBust = false;
      player2Bust = false;
      dealerBust = false;
      playerSplit = false;

    }
    System.out.println("You left with: $" + playerMoney);
  }

    public static boolean checkPlayerMove(String response){
      String playerResponse = response.toLowerCase();
      while(true){
        if(playerResponse.equals("hit") || playerResponse.equals("h")){
          return false;
        }
        else if(playerResponse.equals("stand")||playerResponse.equals("s")){
          return true;
        }else{
          System.out.println("Enter hit or stand");
          playerResponse = turnInput.next();
          playerResponse.toLowerCase();
        }
      }
    }

    public static boolean checkPlayerDone(String response){
      String playerResponse = response.toLowerCase();
      while(true){
        if(playerResponse.equals("yes") || playerResponse.equals("y")){
          return true;
        }
        else if(playerResponse.equals("no")||playerResponse.equals("n")){
          return false;
        }else{
          System.out.println("Enter yes or no");
          playerResponse = turnInput.next();
          playerResponse.toLowerCase();
        }
      }
    }
    public static void checkDoubleDown(Deck i){
      System.out.println("Do you want to double down");
      input = turnInput.next();
      isDoubleDown = checkPlayerDone(input);
      if(isDoubleDown){
        bet = bet * 2;
        i.draw(originDeck);
        lastCard = i.getCard(i.size()-1);
        if(lastCard.getValue()==11 && i.cardsValue()!=21) {
          if(i.cardsValue()>21){
            lastCard.setValue(1);
          }
        }
        playerStand = true;
      }
    }
}
