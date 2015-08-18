package basicstopwatch;

import java.lang.Runtime;

public class BasicStopwatch 
{

    public static void main( String[] args ) 
    {
        int second = 0;
        int minute = 0;
        int hour = 0;
        
        while ( second <= 60 )
        {            
            System.out.println( hour + ":" + minute + ":" + second );
            
            try { 
                Thread.sleep(1000);                
            } catch( InterruptedException ex ) {
                Thread.currentThread().interrupt();
            }
            
            second++;
            
            if ( second == 60 )
            {
                minute++;
                second = 0;
            }
            
            if ( minute == 60 )
            {
                hour++;
                minute = 0;
                second = 0;
            }
        }
    }
}