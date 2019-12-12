//strong insperation form https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/NQueens/NQueens.java
//The N Queens Placement Problem Clear Explanation (Backtracking/Recursion)
//0.090 in this time
import java.util.*;
import java.io.*;
public class Main {
static int[][] board = new int[8][8];
static int Max = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        //solve the n queen promblem
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();
        n = removeSpace(n);
        int k = Integer.parseInt(n);
        while (k-->0) {
            StringTokenizer st;

            //insert all the value in the board
            for (int j=0;j<8;j++){
                int i=0;
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens())
                    board[j][i++] = Integer.parseInt(st.nextToken());
            }
            solveNqueen(0,  new ArrayList<>());
            pw.printf("%5d\n",Max);
            Max = 0;
        }
        pw.flush();
    }

    private static String removeSpace(String n) {
        String sum = "";
        for (char i:n.toCharArray())
            if(Character.isDigit(i))
                sum+=i;
            return sum;
    }

    private static void solveNqueen(int row, ArrayList<Integer> colPlacment) {
        if(row==8){
            Max = Math.max(getMax(colPlacment),Max);
            return ;
        }
        for (int col=0;col<8;col++){
            colPlacment.add(col);
            if(isValid(colPlacment))
                solveNqueen(row+1,colPlacment);
            colPlacment.remove(colPlacment.size()-1);
        }
    }

    private static boolean isValid(ArrayList<Integer> colPlacment) {
        //the queen i'm chekcing agsint on every other queens
        int queenvalidintg = colPlacment.size()-1;
        //check previous
        for (int ithQueenRow =0;ithQueenRow < queenvalidintg;ithQueenRow++){
            int  absoluteDitasnce = Math.abs(colPlacment.get(ithQueenRow)-colPlacment.get(queenvalidintg));
            //check if diagnolly and horizontal
            int rowDistance = queenvalidintg-ithQueenRow;
            if(rowDistance==absoluteDitasnce||absoluteDitasnce==0)
                return false;
        }
        return true;
    }

    private static int getMax(ArrayList<Integer> colPlacment) {
        int sum = 0;
        for (int i=0;i<colPlacment.size();i++)
            sum+=board[i][colPlacment.get(i)];
        return sum;
    }


}
