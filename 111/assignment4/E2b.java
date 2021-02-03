public class E2b 
{
    public static void main(String[] args)
    {
     
        int n = StdIn.readInt();
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            int input = StdIn.readInt();
            for(int j = (n-1); j > 0; j--){
                arr[i][j] = input % 10;
                input = input / 10;
            }
            arr[i][0] = input;
        
        }

        for(int i = (n - 1); i >= 0; i--){
            System.out.println("");
            for(int j = (n - 1); j >= 0; j--){
                System.out.print(arr[j][i]+" ");
            }
        
        }

    }
}
