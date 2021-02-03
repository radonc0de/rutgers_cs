/*************************************************************************
 *  Compilation:  javac TwoSmallest.java
 *  Execution:    java TwoSmallest 1.1 6.9 0.3
 *
 *  @author: Keith Lehman [email: kpl56@scarletmail.rutgers.edu, netid: kpl56]
 *
 *  The program TwoSmallest takes a set of double command-line
 *  arguments and prints the smallest and second-smallest number, in that
 *  order. It is possible for the smallest and second-smallest numbers to
 *  be the same (if the sequence contains duplicate numbers).
 *
 *  Note: display one number per line
 *
 *  % java TwoSmallest 17.0 23.0 5.0 1.1 6.9 0.3
 *  0.3
 *  1.1
 *
 *  % java TwoSmallest 17.0 23.0 5.0 1.1 6.9 0.3
 *  0.3
 *  0.3
 *************************************************************************/

public class TwoSmallest {

    public static void main(String[] args) {

        //figure out how many numbers were entered
        int length = args.length;

        //set smallest and second smallest to the largest possible number
        double smallest = Double.MAX_VALUE;
        double second_smallest = Double.MAX_VALUE;

        //loop through all numbers entered, figuring out smallest and second smalelst
        for (int i = 0; i < length; i++) {
            double j = Double.parseDouble(args[i]);
            if (j < smallest){
                second_smallest = smallest;
                smallest = j;
            } else if (j < second_smallest) {
                second_smallest = j;
            }
        }

        System.out.println(smallest);
        System.out.println(second_smallest);

    }

}
