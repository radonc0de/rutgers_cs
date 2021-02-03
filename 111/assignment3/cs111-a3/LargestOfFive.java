/*************************************************************************
 *  Compilation:  javac LargestOfFive.java
 *  Execution:    java LargestOfFive 35 10 32 1 8
 *
 *  @author: Keith Lehman [email: kpl56@scarletmail.rutgers.edu, netid: kpl56]
 *
 *  Takes five distinct integers as command-line arguments and prints the 
 *  largest value
 *
 *
 *  % java LargestOfFive 35 10 32 1 8
 *  35
 *
 *  Assume the inputs are 5 distinct integers.
 *  Print only the largest value, nothing else.
 *
 *************************************************************************/

public class LargestOfFive {

    public static void main (String[] args) {
        
        //read 5 integers from command line argument
        int i = Integer.parseInt(args[0]);
        int j = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        int l = Integer.parseInt(args[3]);
        int m = Integer.parseInt(args[4]);

        //test if 'i' is largest integer
        if (i > j && i > k && i > l && i > m) {
            System.out.println(i);
        //test if 'j' is largest integer
        }else if (j > i && j > k && j > l && j > m) {
            System.out.println(j);
        //test if 'k' is largest integer
        }else if (k  > i && k > j && k > l && k > m) {
            System.out.println(k);
        //test if 'l' is largest integer
        }else if (l > i && l > j && l > k && l > m) {
            System.out.println(l);
        //test if 'm' is largest integer
        }else if (m > i && m > j && m > k && m > l) {
            System.out.println(m);
        }
    }
}
