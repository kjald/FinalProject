//Kenny Alderman
//Final project -  war game tester simulates game of war, 
//shows player deck size, card drawn, and war card



//imports
import java.util.*;
import java.util.Scanner;
import java.util.Collections;
import javax.swing.*;


/**
      War class simulates making the deck for the players, asking the decision to play again, and reads the Scanner
      */
public class War
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in); //Allows Input
      ArrayList<Card> deck = new ArrayList<Card>(); //array for deck
      String decision; //creates string for decision (yes/no)
      
     //loop to make a deck, assigns suits to cards
      for(int i = 2; i<=14; i++)
      {
         Card hearts = new Card('h',i);
         deck.add(hearts);
         Card clubs = new Card('c',i);
         deck.add(clubs);
         Card diamonds = new Card('d',i);
         deck.add(diamonds);
         Card spades = new Card('s',i);
         deck.add(spades);
      }
         
      //Shuffles the deck
      Collections.shuffle(deck); 
      
      
         
      //Arrays for player 1 and 2 created here
      ArrayList<Card> Player1 = new ArrayList<Card>();
      ArrayList<Card> Player2 = new ArrayList<Card>();
      
      //Split deck for two players to simulate game of war 26/26
      for(int i = 0; i<deck.size();i++)
      {
         if(i<26)
            Player1.add(deck.get(i));
         
         else
            Player2.add(deck.get(i));
      
      }
          
      System.out.println("Start a game of war!");
       
      System.out.println("Deal? y/n");
      //decision to start game
      decision = keyboard.nextLine();  
       //makes sure decks are not empty, and y makes a round of war
      try
      {
         while((!((Player1.isEmpty() && Player2.isEmpty())))&& decision.equals("y"))
         {
         //simulates player deck size
            System.out.println("Player 1 # of cards: " +
               Player1.size()+ " <---->" +" Player 2 # of cards: " +Player2.size());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         
            System.out.println("Player 1 : "+Player1.get(Player1.size()-1) +
               " VS Player 2: " + Player2.get(Player2.size()-1));
         
            int compare = Player1.get(Player1.size()-1).compareTo(Player2.get(Player2.size()-1));
         
         //if statement for player one
            if(compare == 1)
            {
            
               System.out.println("Player 1 wins!");
            //if player one wins, add player 2's cards to player one
               Player1.add(Player2.remove(Player2.size()-1));
               //shuffle deck with new cards for next round (personal game decision)
               Collections.shuffle(Player1);
            
            }
         
         //if statment for player 2
            if(compare == -1)
            {
               System.out.println("Player 2 wins!");
            //if player two wins, add player 1's card to player 2
               Player2.add(Player1.remove(Player1.size()-1));
               //shuffle deck with new cards for next round (personal game decision)
               Collections.shuffle(Player2);
            
            }
         //If cards == begin game of war
            while(compare == 0)
            {
               Collections.shuffle(Player1);
               Collections.shuffle(Player2);
            
               System.out.println("WAR!");
               //war cards
               System.out.println("Player 1 : "+Player1.get(Player1.size()-3) +
                  " VS Player 2: " + Player2.get(Player2.size()-3));
            //compare new face up card
               compare = Player1.get(Player1.size()-3).compareTo(Player2.get(Player2.size()-3));
            //player one if statement
               if(compare == 1)
               {
                  System.out.println("Player 1 wins the war!");
               
                  for (int i = 1; i<=3; i++)
                     Player1.add(Player2.remove(Player2.size()-i));
                  
                  
                  Collections.shuffle(Player1);
               }
             //player 2 if statement
               if(compare == -1)
               {
                  System.out.println("Player 2 wins the war!!");
               
                 
                  for (int i = 1; i<=3; i++)
                     Player2.add(Player1.remove(Player1.size()-i));
                
                  
                  Collections.shuffle(Player2);
               
               }
             
              
            }    
            //after that round, start a new one?
            System.out.println("Deal? y/n ");
            decision = keyboard.nextLine();
         } 
       
       
      }
      catch (IndexOutOfBoundsException theException)  //tries to catch this
      
      {
            //when player 1 deck == 0 player 2 wins
         if(Player1.size() == 0)
            System.out.println("Winner is Player 2" );
      
          
         //when player 2 deck ==0 player 1 wins
         if(Player2.size() == 0)
            System.out.println("Winner is Player 1" );
      
      }       
            
         
   }   
 
}