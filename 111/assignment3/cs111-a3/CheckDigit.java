/*************************************************************************
 *  Compilation:  javac CheckDigit.java
 *  Execution:    java CheckDigit 020131452
 *
 *  @author: Keith Lehman [email: kpl56@scarletmail.rutgers.edu, netid: kpl56]
 *
 *  Takes a 12 or 13 digit integer as a command line argument, then computes
 *  and displays the check digit
 *
 *  java CheckDigit 048231312622
 *  0
 *
 *  java CheckDigit 9780470458310
 *  0
 * 
 *  java CheckDigit 9780470454310
 *  8
 * 
 *  Print only the check digit character, nothing else.
 *
 *************************************************************************/

public class CheckDigit {

    public static void main (String[] args) {
        
        //assign long 'i' to command line argument
        long i = Long.parseLong(args[0]);
        
        //declare max_count variable to be used in loop  
        int max_count = 0;

        //determine if input is either a 12 digit or 13 digit number and assign max_count accordingly
        if (i < 1000000000000L) {
            max_count = 12;   
        }else{
            max_count = 13;
        }
        
        //declare counting variable for loop
        int count = 0;

        //declare sum values to be used when adding digits
        long sum_evens = 0;
        long sum_odds = 0;
        long sum_total = 0;

        //loop that sums digits, assigning every other one to a different category using even/odds
        while (count < max_count) {
            
            long digit = i % 10L;
            i =  i / 10;

            if (count % 2 == 0){
                sum_evens = sum_evens + digit;
            } else {
                sum_odds = sum_odds + digit;
            }
            
            count++;

        }
        
        //get last digit of first sum 
        sum_evens = (sum_evens % 100) % 10;
        
        //get last digit of second sum, multiply by 3, then get last digit once more
        sum_odds = (sum_odds % 100) % 10;
        sum_odds = sum_odds * 3;
        sum_odds = (sum_odds % 100) % 10;
        
        //add two syms and get last digit
        sum_total = sum_evens + sum_odds;
        sum_total = (sum_total % 100) % 10;

        System.out.println(sum_total);

    }
}
