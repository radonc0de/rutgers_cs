/*************************************************************************
 *  Compilation:  javac FindDuplicate.java
 *  Execution:    java FindDuplicate
 *
 *  @author: Keith Lehman [email: kpl56@scarletmail.rutgers.edu, netid: kpl56]
 *
 * FindDuplicate that reads n integer arguments from the command line 
 * into an integer array of length n, where each value is between is 1 and n, 
 * and displays true if there are any duplicate values, false otherwise.
 *
 *  % java FindDuplicate 10 8 5 4 1 3 6 7 9
 *  false
 *
 *  % java FindDuplicate 4 5 2 1 
 *  true
 *************************************************************************/

public class FindDuplicate {

    public static void main(String[] args) {

        boolean duplicates = false;

		for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args.length; j++) {
                if (i != j && Integer.parseInt(args[i]) == Integer.parseInt(args[j])) {
                
                    duplicates = true;
                
                }
            }
        }

        System.out.println(duplicates);

	}
}
