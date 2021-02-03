/*************************************************************************
 *  Compilation:  javac RecursiveAppend.java
 *  Execution:    java RecursiveAppend
 *
 *  @author: Keith Lehman [email: kpl56@scarletmail.rutgers.edu, netid: kpl56]
 *
 *************************************************************************/

public class RecursiveAppend {

    // Returns the original string appended to the original string n times 
    public static String appendNTimes (String original, int n) {

        if(n >= 0){
            n -= 1;
            return(original + appendNTimes(original, n));

        }else{
            return "";
        }
    
    }

    public static void main (String[] args) {

        String original = args[0];
        int n = Integer.parseInt(args[1]);
        StdOut.println(appendNTimes(original, n));
    
    }

}
