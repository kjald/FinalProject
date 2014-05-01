//Kenny Alderman
//Final project
//War gui
/* GUI simulator of the war game. */

//imports
import java.util.*;
import java.util.Collections;     
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class myWarGUI extends JFrame //Extend JFrame method
{

  //4 panels used for the War card game
   private JPanel panel1 = new JPanel();
   private JPanel panel2 = new JPanel();
   private JPanel panel3 = new JPanel();
   private JPanel panel4 = new JPanel();
 
 
   private ImageIcon back = new ImageIcon("back.jpg");//back of a card
   private ImageIcon leftCard = new ImageIcon();//left most face up card
   private ImageIcon rightCard = new ImageIcon();//right most face up cardpl
   private ImageIcon leftWarCard = new ImageIcon();//face down card when War occurs for Player 1
   private ImageIcon rightWarCard = new ImageIcon();//face down card when War occurs for Player 2
   private ImageIcon topLeftWarCard = new ImageIcon();//face up card when War occurs for Player 1
   private ImageIcon topRightWarCard = new ImageIcon();//face up card when War occurs for Player 2
 
  
  
   private JLabel player1Card = new JLabel();
   private JLabel player2Card = new JLabel();
   private JLabel player1CardWar = new JLabel();
   private JLabel player2CardWar = new JLabel();          //These labels are used to hold the images
   private JLabel player1CardWarTop = new JLabel();
   private JLabel player2CardWarTop = new JLabel();
   private JLabel deck1 = new JLabel(back);
   private JLabel deck2 = new JLabel(back);
  
   private JLabel deck1size; //Label to display player 1 deck
   private JLabel deck2size; //Label to display player 2 deck
   private JLabel winner = new JLabel(); //Label to display the winner
   
   private JButton play = new JButton();//Play button
  
   private ArrayList<Card> deck = new ArrayList<Card>(); //ArrayList of full deck
   private ArrayList<Card> player1 = new ArrayList<Card>();//Player 1's deck
   private ArrayList<Card> player2 = new ArrayList<Card>();//Player 2's deck
  
   private int compare; //Integer that holds the value of the compareTo card 
 
 
  //Long window for war game, with perfect height of cards (resized 2 clubs)
   private final int windowWidth = 1600; 
   private final int windowHeight = 800;
  
 
      
     
   public myWarGUI()
   {
      setSize(windowWidth,windowHeight);
      
        
         //Simulates making the deck
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
                  
               //Shuffle the deck
      Collections.shuffle(deck); 
               
               
                  
               
               //Split the deck for the players makes sure they are both 26 to start the game
      for(int i = 0; i<deck.size();i++)//deck.size()
      {
         if(i<26)
            player1.add(deck.get(i));
                  
         else
            player2.add(deck.get(i));
          
      }
         
         //Display the size of the decks      
      deck1size = new JLabel("Player 1: "+player1.size());
      deck2size = new JLabel("Player 2: "+player2.size());
         
         //Add a play button
      play = new JButton("Play");
      play.addActionListener(new PlayerListener());
        
         //Set each panel to the background color of red
      panel1.setBackground(new Color(199, 19, 19));
      panel2.setBackground(new Color(199, 19, 19));
      panel3.setBackground(new Color(199, 19, 19));
      panel4.setBackground(new Color(199, 19, 19));
         
      //adds information to deck panels and play button   
      panel1.add(deck1size); 
      panel1.add(play);
      panel1.add(deck2size);
         
         //Sets font for Player 1 and Player 2 deck
      deck1size.setFont(new Font("HELVETICA",Font.BOLD,24));
      deck2size.setFont(new Font("HELVETICA",Font.BOLD,24));
         
         //Set the font for button
      play.setFont(new Font("HELVETICA",Font.BOLD,24));
         
      winner.setFont(new Font("HELVETICA",Font.BOLD,50));
         
      panel2.add(deck1);//Add the "deck" Player 1 panel 2
      panel2.add(player1Card); //Player 1's face up card to panel 2
      panel2.add(player1CardWar);//Player 1's face down war card to panel 2
      panel2.add(player1CardWarTop);//Player 1's face up war card to panel 2
      panel3.add(player2CardWarTop);//Player 2's face up war card to panel 3
      panel3.add(player2CardWar);//Player 2's face down war card to panel 3
      panel3.add(player2Card); //Player 2's face up card to panel 3
      panel3.add(deck2); //Add the "deck" for Player 2 to panel 3
      panel4.add(winner); //Add the winner label to display who is the winner after a war or the game ends
         
         
         
         
       
         
         
      setLayout(new BorderLayout());// BorderLayout
      //set location of player panels
      add(panel1,BorderLayout.NORTH); 
      add(panel2,BorderLayout.WEST);
      add(panel3,BorderLayout.EAST);
      add(panel4,BorderLayout.SOUTH);
          
          
      setVisible(true); //Make this BorderLayout visible
   }
     
     /**  PlayerListener class simulates the player flipping the top card of the deck when
     the game is played
           */
           
   private class PlayerListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
            
            //This string will be set to "Play" when the play button is pushed
         String actionCommand = e.getActionCommand();
            
         try//Need try due to end of game ArrayList out of bounds exception thrown
         {
            if(actionCommand.equals("Play")) //when the play button is pushed
            {
                        
               winner.setText(null); //Set the winner label to null before game starts
                        
                        
                        
               //Set each the war cards to null. Only want to see them when a war occurs
               player1CardWar.setIcon(null);
               player2CardWar.setIcon(null);
               player1CardWarTop.setIcon(null);
               player2CardWarTop.setIcon(null);
                        
               //Set both deck size labels to there appropriate values
               deck1size.setText("Player 1: "+player1.size());
               deck2size.setText("Player 2: "+player2.size());
                        
                        
               //set the appropriate ImageIcons with their respective top deck card image
               leftCard = new ImageIcon(player1.get(player1.size()-1)+".jpg");
               rightCard = new ImageIcon(player2.get(player2.size()-1)+".jpg");
            
              //set the two image icons to their respective labels
               player1Card.setIcon(leftCard);
               player2Card.setIcon(rightCard);
                        
               //Compare the top cards for each players deck
               compare = player1.get(player1.size()-1).compareTo(player2.get(player2.size()-1));
                        
               if(compare == 1)//If player 1's card wins
               {
               
                  winner.setText("Player 1 wins the draw!");//display player 1 wins the war
               
                  //Add player 2's card to player 1's deck
                  player1.add(player2.remove(player2.size()-1));
                  
                  //Shuffle Player 1's deck
                  Collections.shuffle(player1);
               
               }
                            
                            
               if(compare == -1)//If player 2's card wins
               {
               
                  winner.setText("Player 2 wins the draw!");//display player 2 wins the war
               
                               //Add player 1's card to player 2's deck
                  player2.add(player1.remove(player1.size()-1));
                              //Shuffle Player 2's deck
                  Collections.shuffle(player2);
               
               }
                            
                            
               while(compare == 0)//If a war occurs
               {
                  //Shuffle both decks
                  Collections.shuffle(player1);
                  Collections.shuffle(player2);
                                 
                  //Display a face down card image 
                  player1CardWar.setIcon(back);
                  player2CardWar.setIcon(back);
                                 
                  //Set the ImageIcons with their appropriate card images when a war occurs
                  topLeftWarCard = new ImageIcon(player1.get(player1.size()-3)+".jpg");
                  topRightWarCard = new ImageIcon(player2.get(player2.size()-3)+".jpg");
                                 
                  //Set the labels with their respective card
                  player1CardWarTop.setIcon(topLeftWarCard);
                  player2CardWarTop.setIcon(topRightWarCard);
                                 
                  //use the compareTo method in Card class
                  compare = player1.get(player1.size()-3).compareTo(player2.get(player2.size()-3));
                                 
                  if(compare == 1)//If player 1 wins the war
                  {
                                    
                     winner.setText("Player 1 wins the war!");//display player 1 wins the war
                                     
                    //Add the 3 cards to player 1's deck
                     for (int i = 1; i<=3; i++)
                        player1.add(player2.remove(player2.size()-i));
                                       
                     //shuffle the deck   
                     Collections.shuffle(player1);
                  }
                                  
                  if(compare == -1)//if player 2 wins
                  {
                                    
                                    
                     winner.setText("Player 2 wins the war!");//display player 2 wins the war
                                      
                    //Add the 3 cards to player 2's deck
                     for (int i = 1; i<=3; i++)
                        player2.add(player1.remove(player1.size()-i));
                                     
                     //shuffle the deck  
                     Collections.shuffle(player2);
                                    
                  }
                                  
                                   
               }
                        
                        
                        
                     
            }
                      
         }  
                    
         catch (IndexOutOfBoundsException theException)  //tries to catch this
         {
            
            if(player1.size() == 0)//If player 2 wins
            {
               winner.setText("Player two won this round!" );//Display player 2 wins
               panel1.remove(play); //Remove the play button
               panel2.remove(deck1);//remove the "deck" ImageIcon for Player 1
               panel2.remove(player1Card); //remove Player 1's face up card
               
            
            }
         
            if(player2.size() == 0)//If player 1 wins
            {
               winner.setText("P1ayer one won this round!" );//Display player 1 wins
               panel1.remove(play);//Remove the play button
               panel3.remove(deck2); //remove the "deck" ImageIcon for Player 2
               panel3.remove(player2Card); //remove Player 2's face up card
            
            }
               
         
         } 
            
      }
       
       
   }
      
      /** driver for myWarGui */
      
      
   public static void main(String[] args)
   {
         //Make an instance of my war GUI
      myWarGUI war = new myWarGUI();
         
         //Set the title
      war.setTitle("The Game of War");
         
         //Set the background to red
      war.getContentPane().setBackground(new Color(199, 19, 19));
         
         //Exit on close
      war.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

  
}