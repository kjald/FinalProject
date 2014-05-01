//Kenny Alderman
//Final project
/*War - pt 2 simulate the deck using an ArrayList makes a full deck based on the card class
also simulates the shuffle, and toString used in the comparison
*/

//imports
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Deck
{
   static ArrayList<Card> deck = new ArrayList<Card>();
   /** 
      Deck - simulates the deck
      @param card class, adds cards
      
   */
   public Deck(Card card)
   {
      deck.add(card);
   }
   /** 
      getDeck() - simulates getting the deck 
      @return deck full deck of card in ArrayList
      
   */
   public static ArrayList<Card> getDeck()
   {
      return deck;
   }
   /** 
      shuffle() - takes full deck in ArrayList and shuffles
      @return deck which has now been shuffled         
   */
   public ArrayList<Card> shuffle()
   {
      Collections.shuffle(deck);
       
      return deck;
   } 
   /** 
      toString() - takes full shuffled deck and writes it toString for
      comparisons
      @return deck.toString which is the same deck content as str's         
   */
   public String toString()
   {
      return deck.toString();
   }
 
   
}