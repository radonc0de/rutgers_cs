/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author: Keith Lehman [email: kpl56@scarletmail.rutgers.edu, netid: kpl56]
 *
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {
        
        return (Math.sqrt(3.0) * length) / 2.0;

    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {
        double height = height(length);
        double[] xVer = { x, (x + (length/2)), (x - (length/2)) };
        double[] yVer = { y, (y + height), (y + height) };
        StdDraw.filledPolygon(xVer, yVer);

    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {
        if(n > 0){
            filledTriangle(x, y, length);
            sierpinski((n - 1), (x - (length/2)), y, (length/2));
            sierpinski((n - 1), (x + (length/2)), y, (length/2));
            sierpinski((n - 1), x, (y + height(length)), (length/2));
        }
    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {
       
        //draw empty triangle
        double[] xVer = {0, 0.5, 1};
        double[] yVer = {0, height(1.0), 0}; 
        StdDraw.polygon(xVer, yVer);
        
        //call sierpinski
        sierpinski(Integer.parseInt(args[0]), 0.5, 0, 0.5);

    }
}
