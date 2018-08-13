import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Deck{

    private String[] CARD_SUITS = {"CLUBS", "SPADES", "DIAMONDS", "HEARTS"};
    private String[] CARD_NAMES = {"ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING"};
    private ArrayList<Card> cards;
  public Deck(){
    this.cards = new ArrayList<Card>();
  }

  public void buildDeck(String[] CARD_SUITS, String[] CARD_NAMES){
    //ArrayList<Card> cards = new ArrayList<Card>();
    int val;
    for(int i = 0; i<4; i++){   //i<4
      for(int j = 0; j<13; j++){   //j<13
        if(j==0){
          val = 11;
        }else if(j>0 && j<9){
          val = j+1;
        }else{
          val = 10;
        }
        Card c = new Card(CARD_SUITS[i], CARD_NAMES[j], val);
        this.cards.add(c);
      }
    }
    //return cards;
  }

  public void shuffle(){
    ArrayList<Card> tempDeck = new ArrayList<Card>();

    Random random = new Random();
    int randomCardIndex = 0;
    int originSize = this.cards.size();
    for(int i = 0; i<originSize; i++){
      //generate random Index rand.nextInt((max-min)+1)+min;
      randomCardIndex = random.nextInt((this.cards.size()-1 - 0) + 1)+0;
      tempDeck.add(this.cards.get(randomCardIndex));
      this.cards.remove(randomCardIndex);
    }
    this.cards = tempDeck;
  }
  public String toString(){
    String cardList = "";
    int k = 0;
    for(Card aCard: this.cards){
      cardList += + k + " - " + aCard.toString() + "\n";
      k++;
    }
    return cardList;
  }
  public int size() {
	  return cards.size();
  }
  public int cardsValue(){
    int totalValue = 0;
    int aces = 0;
    for(Card aCard : this.cards)
    {
        if(aCard.getValue() == 11)
        {
            aces++;
        }
        else
        {
            totalValue += aCard.getValue();
        }
    }

    for(int i = 0; i<aces; i++){
      if(totalValue>10){
        totalValue+=1;
      }else{
        totalValue += 11;
      }
    }
    return totalValue;
  }
//remove card from deck
public void removeCard(int i){
  cards.remove(i);
}

//check card
public Card getCard(int i){
  return this.cards.get(i);
}
public String getName(int i){
  return cards.get(i).getName();
}
//add card to deck
public void addCard(Card addCard){
  this.cards.add(addCard);
}
public void draw(Deck i){
  this.cards.add(i.getCard(0));
  i.removeCard(0);
}
public void deckClear(){
  cards.clear();
}
}
