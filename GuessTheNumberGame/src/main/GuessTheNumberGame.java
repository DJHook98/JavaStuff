package main;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame 
{
    
    public static void main( String[] args ) 
    {
        
        Scanner scan = new Scanner( System.in );
        Random rand = new Random();  
        
        int maxGuesses = 3;
        int userGuesses = 0;
        int randomNumber = rand.nextInt( 10 - 1 + 1 ) + 1;
        // debug System.out.println( randomNumber );
        
        System.out.println( "Welcome to Dan's Number Guessing Game!" );
        System.out.println( "The random number is between 1 and 19." );
        System.out.println( "You have " + maxGuesses + " tries to guess the random number." );
        
        while ( userGuesses != maxGuesses )
        {
            System.out.println( "Guess a number." );
            
            int guess = scan.nextInt();
            
            if ( guess == randomNumber ) {
                System.out.println( "You win!" );
                break;
            } else if ( guess < randomNumber ) {
                System.out.println( "Your guess was too low!" );
                userGuesses++;
            } else if ( guess > randomNumber ) {
                System.out.println( "Your guess was too high!" );
                userGuesses++;
            } else {
                System.out.println( "That wasn't a valid guess." );
            }
        }
        
        if ( userGuesses == maxGuesses )
        {
            System.out.println( "You failed!" );
        }
    }
    
}
