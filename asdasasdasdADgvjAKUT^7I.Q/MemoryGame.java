/**
 * Project 3.1.5
 *
 * The Memory Game shows a random sequence of "memory strings" in a variety of buttons.
 * After wathcing the memory strings appear in the buttons one at a time, the
 * player recreates the sequence from memory.
 */

public class MemoryGame
{
   public static void main(String[] args) {

    // TO DO: Create the "memory strings" - an array of at least 4 single character  
    // strings to show in the buttons, one element at a time. This is the sequence
    // the player will have to remember.
 
String mem[] = {"a","b","c"};
String mem2[] = {"a","b","c","d"};
String mem3[] = {"a","b","c","d","e"};
boolean match=false;


    // Create the game and gameboard. Configure a randomized board with 3 buttons.
    // (Later, you can change options to configure more or less buttons
    // and turn randomization on or off.))
    MemoryGameGUI game = new MemoryGameGUI();
    game.createBoard(3, true);
    int score = 0;
    int rounds = 1;
    
    // TO DO: Play the game until user wants to quit.
  while(true){
   String temp[] = RandomPermutation.next(mem);
   String seq = "";
   for(int i=0; i < temp.length; i++){
    seq+=temp[i];
   }
        // TO DO: Call the next method in RandomPermutation to create a random version 
        // of the "memory strings"
  
        // TO DO: Play one sequence with a .5 second delay. Save the player's guess. 
        // (Later, you can speed up or slow down the game.)
        String guess = game.playSequence(temp, .5);

        // TO DO: If the guess is not null, determine a match
        if(guess!=null){ //only do if guess is not null
      
          guess = guess.replaceAll(", ", ""); //replace comma and space with nothing
          for(int i=0; i < temp.length; i++){ //iterate over each array element
            if(guess.equals(seq)){ //set match to true if guess is the same as an array element
              match = true;
            }
              
          }
        }

            if (match) //execute if match is correct
            {
              match = false; //set match back to false
              game.matched(); 
              score++; // increase score
             } 
            else
            {
              game.tryAgain();
              
              }

        // TO DO: Ask if user wants to play another round of the game 
        // and track the number of games played.
              game.showScore(score, rounds);
        
              if (game.playAgain())
              {
                rounds++; // new rounds
               }
              else
              {
                game.quit(); // end game
               }
            }
    // When done playing, show score and end the game.
  }
}