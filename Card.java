public class Card{
  private int value;
  private String suit;
  private String name;
  public Card(String suit, String name, int value){
    this.suit = suit;
    this.name = name;
    this.value = value;
  }
  public int getValue(){
    return this.value;
  }
  public String getName(){
	  return this.name;
	}
  public String toString(){
    return this.name + " of " + this.suit;
  }
  public void setValue(int i) {
	  value = i;
  }
}
