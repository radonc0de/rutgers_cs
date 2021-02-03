/*************************************************************************
 *  Compilation:  javac RURottenTomatoes.java
 *  Execution:    java RURottenTomatoes
 *
 *  @author: Keith Lehman [email: kpl56@scarletmail.rutgers.edu, netid: kpl56]
 *
 * RURottenTomatoes creates a 2 dimensional array of movie ratings 
 * from the command line arguments and displays the index of the movie 
 * that has the highest sum of ratings.
 *
 *  java RURottenTomatoes 3 2 5 2 3 3 4 1
 *  0
 *************************************************************************/

public class RURottenTomatoes {

    public static void main(String[] args) {
        
        int[][] reviews = new int[Integer.parseInt(args[0])][Integer.parseInt(args[1])];

        int numValues = args.length - 2;

        int reviewer = 0;
        int movie = -1;
            
        for(int i = 0; i < numValues; i++) {
            int currentReviewer = i / Integer.parseInt(args[1]);
            if (reviewer == currentReviewer) {
                movie++;
            } else if (currentReviewer > reviewer) {
                reviewer = currentReviewer;
                movie = 0;
            } 
            reviews[reviewer][movie] = Integer.parseInt(args[i+2]);
        }

        int[] ratings = new int[Integer.parseInt(args[1])]; 

        for(int i = 0; i < ratings.length; i++){
            
            int sum = 0;
            
            for(int j = 0; j < Integer.parseInt(args[0]); j++){
            
                sum += reviews[j][i];
            
            }

            ratings[i] = sum;
        }

        int bestMovie = 0;
        int bestMovieScore = 0;

        for(int i = 0; i < ratings.length; i++){
            if(ratings[i] > bestMovieScore){
                bestMovie = i;
                bestMovieScore =  ratings[i];
            } 
        }

        System.out.println(bestMovie);

    }
}
