//Kenny Alderman
//Final project
/*War - pt 1 card class simulates making a card, makes rank(card number)
and suit.*/


//imports
import javax.swing.*;
import java.awt.*;

/** This class is used to simply simulate a Card. 
The suit is a character and the ranks used are 2-14
*/

public class Card extends JButton
{
   //A card has a suit and rank
   private char suit;
   private int rank;
  
   /** 
      Creates a new card, using a copy constructor
   
    @param suit the suit of the card
    @param rank the rank of the card
   */
   public Card (char suit, int rank)
   {
      this.suit = suit;
      this.rank = rank;
   }
   
   /** 
      setSuit gets the suid of the card and sets it
   
    @param suit a char, the suit of the card
   */
   
   public void setSuit(char suit)
   {
      this.suit = suit;
   }
   
   /** 
      setRank gets the rank of the card and sets it
   
    @param rank an int, the rank of the card
   */
   public void setRank(int Rank)
   {
      this.rank = rank;
   }
   
   /** 
      getSuit gets the rank of the card and sets it
   
    @return suit suit of the card
   */
   public char getSuit()
   {
      return suit;
   }
   
   /** 
      getrank gets the rank of the card and sets it
   
    @return rank rank of the card
   */
   public int getRank()
   {
      return rank;
   }
   
   /**
   toString - Returns a description of this card
    Ex. names from card images
    King of Hearts --> kingh
          2 of Clubs --> 2c 
   
   @return s - the name of the card.
  
   */
   
   
   public String toString()
   {
      String str=null;
      
      if(rank == 11)
         str = "jack";
      
      if(rank == 12)
         str = "queen";
      
      if(rank == 13)
         str = "king";
      
      if(rank == 14)
         str = "ace";
      
      if(rank > 10)
      {
         String s = str+suit;
         return s;
      }
      
      String s1 = String.valueOf(rank)+suit;
      return s1;
     
   }
   
   /**
    The compareTo  used to compare two card objects based off of their
    rank and suit
    
    @param other  The card other being tested. 
    @return 1   if card being compared to other is greater in rank
    @return -1  if the card being compared is less in rank
   
   */
   public int compareTo(Card other)
   {
      if(this.rank > other.getRank())
         return 1;
      
      if(this.rank < other.getRank())
         return -1;
         
      else
      {
         return 0;
      }
   }
}