import java.util.LinkedList;
import java.util.Queue;


public class Sieve {



    public void primesTo( int n ) {
        Queue< Integer > numbers = new LinkedList< Integer >( );
        Queue< Integer > primes = new LinkedList< Integer >( );
        // filling up numbers
        if ( n < 2 ) {
            System.out.println( "sorry it must be larger than 2" );
            return;
        }
        for ( int i = 2; i <= n; i++ )
            numbers.add( i );
        double sqrt = Math.sqrt( n );
        System.out.println( sqrt );
        int p = numbers.remove( );
        while ( p <= sqrt ) {
            System.out.println( "test: " + p );
            primes.add( p );
            int constantSize = numbers.size( ); //needed bc the size changes and we dont want that
            for ( int j = 0; j < constantSize; j++ ) { 
                int check = numbers.remove( );
                if ( check % p != 0 )
                    numbers.add( check );
            }
            printQueue( numbers );
            p = numbers.remove( );
        }
        while ( !numbers.isEmpty( ) )       //moves everything from numbers to primes
            primes.add( numbers.remove( ) );
        printQueue( primes );
    }

    public void printQueue( Queue< Integer > list ) {
        for ( int i = 0; i < list.size( ); i++ ) {
            int pri = list.remove( );    
            System.out.print( pri + " " );
            list.add( pri );
        }
        System.out.println( );
    }

    public static void main( String [] args ) {
        Sieve x = new Sieve( );
        x.primesTo( 100 );
    }


}