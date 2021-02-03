/*************************************************************************
 *  Compilation:  javac PolygonTransform.java
 *  Execution:    java PolygonTransform
 *
 *  @author: Keith Lehman [email: kpl56@scarletmail.rutgers.edu, netid:kpl56]
 *
 *************************************************************************/

public class PolygonTransform {


    // Returns a new array that is an exact copy of the given array. 
    // The given array is not mutated. 
    public static double[] copy(double[] array) {

        double[] copiedArray = new double[array.length];
        for(int i = 0; i < array.length; i++){
            copiedArray[i] = array[i];
        }
        return copiedArray;
    
    }
    
    // Scales the given polygon by the factor alpha. 
    public static void scale(double[] x, double[] y, double alpha) {

        for(int i = 0; i < x.length; i++){
            x[i] = x[i] * alpha;
            y[i] = y[i] * alpha;
        }
        
    }
    
    // Translates the given polygon by (dx, dy). 
    public static void translate(double[] x, double[] y, double dx, double dy) {

        double[] translatedX = x;
        double[] translatedY = y;
        for(int i = 0; i < x.length; i++){
            translatedX[i] = translatedX[i] + dx;
            translatedY[i] = translatedY[i] + dy;
        }
        
        x = translatedX;
        y = translatedY;

    }
    
    // Rotates the given polygon theta degrees counterclockwise, about the origin. 
    public static void rotate(double[] x, double[] y, double theta) {

        double thetaRadians = Math.toRadians(theta);
        System.out.println(thetaRadians);    

        double[] rotatedX = x;
        double[] rotatedY = y;
        for(int i = 0; i < x.length; i++){
            double[] tempX = copy(x);
            double[] tempY = copy(y);
            rotatedX[i] = (tempX[i] * Math.cos(thetaRadians)) - (tempY[i] * Math.sin(thetaRadians));
            rotatedY[i] = (tempY[i] * Math.cos(thetaRadians)) + (tempX[i] * Math.sin(thetaRadians));
            System.out.println("x: " + rotatedX[i] + " y: " + rotatedY[i]);
        }

        x = rotatedX;
        y = rotatedY;

    }

    // Tests each of the API methods by directly calling them. 
    public static void main(String[] args) {
    
    }
}
