package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * thank you so much https://www.youtube.com/watch?v=ASoaQq66foQ&t=9s BackToSWE and Steven Halim
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1;
        while ((s1=br.readLine())!=null){
            String s2 = br.readLine();
            System.out.println(LCS(s1,s2));
        }
    }

    private static int LCS(String s1, String s2) {
        // create a dp table
        int [][] dp = new int[s1.length()+1][s2.length()+1];
        //  loop the dp table
        for (int row =0;row<=s1.length();row++){
            for (int col = 0; col<=s2.length();col++){
                if(row==0||col==0)
                    dp[row][col] = 0;
                //if the string mathces
                else if (s1.charAt(row-1)==s2.charAt(col-1))
                    dp[row][col] = dp[row-1][col-1]+1;
                else
                    dp[row][col] = Math.max(dp[row-1][col],dp[row][col-1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
