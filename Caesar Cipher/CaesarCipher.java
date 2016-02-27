package caesarcipher;

import java.util.Arrays;
import java.util.Scanner;

public class CaesarCipher 
{
    private static final Scanner sc = new Scanner( System.in );

    public static void main( String[] args ) 
    {
        String choice, phrase, message;
        int shift_value;
        
        System.out.println( "(E)ncryption or (D)ecryption?" );
        choice = sc.next(); choice = choice.toUpperCase(); sc.nextLine();
        
        if ( choice.equals( "E" ) )
        {
            System.out.println( "Enter the phrase to encrypt." );
            phrase = sc.nextLine();
            
            System.out.println( "Enter the shift value." );
            shift_value = sc.nextInt();
            
            if ( shift_value <= 0 ) { System.out.println( "Shift value error. (Less than 0 or 0)." ); }
            else {
                message = Encrypt( phrase, shift_value );
                System.out.println( "The encrypted message is:\n" + message );
            }
        }
        else if (choice.equals("D"))
        {
            System.out.println( "Enter the phrase to decrypt." );
            phrase = sc.nextLine();
            
            System.out.println( "Enter the shift value." );
            shift_value = sc.nextInt();
            
            if ( shift_value <= 0 ) { System.out.println( "Shift value error. (Less than 0 or 0)." ); }
            else {
                message = Decrypt( phrase, shift_value );
                System.out.println( "The decrypted message is:\n" + message );
            }
        }
    }
    
    private static String Encrypt( String p, int s )
    {
        String final_message;
        boolean isUppercase;
        char[] temp = p.toCharArray();
        
        for ( int x = 0; x < temp.length; x++ )
        {
            char st = temp[x];
            isUppercase = (st >= 'A') && (st <= 'Z');
            
            if ( st != ' ' ) 
            {
                st = (char) (st + s);

                if ( st < (isUppercase ? 'A' : 'a' ) ) { st = (char) (st - 26); }
                else if ( st > (isUppercase ? 'Z' : 'z' ) ) { st = (char) (st + 26); }
            }
            temp[x] = st;
        }
        
        final_message = new String(temp);
        return final_message;
    }
    
    private static String Decrypt( String p, int s )
    {
        String final_message;
        boolean isUppercase;
        char[] temp = p.toCharArray();
        
        for ( int x = 0; x < temp.length; x++ )
        {
            char st = temp[x];
            isUppercase = (st >= 'A') && (st <= 'Z');
            
            if ( st != ' ' ) 
            {
                st = (char) (st - s);

                if ( st < (isUppercase ? 'A' : 'a' ) ) { st = (char) (st - 26); }
                else if ( st > (isUppercase ? 'Z' : 'z' ) ) { st = (char) (st + 26); }
            }
            temp[x] = st;
        }
        
        final_message = new String(temp);
        return final_message;
    }
}
