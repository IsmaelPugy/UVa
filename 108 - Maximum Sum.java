package com.company.Main;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
	// write your code here
        Scanner in = new Scanner(new InputStreamReader(System.in));
        while (in.hasNextInt())
        {
            int n= in.nextInt();
            for (int i =0; i<n;i++)
            {
                for (int j=0; j<n;j++)
                {
                    grid[i][j] = in.nextInt();
                }
            }
            System.out.println(TwoDsum(n));
        }
    }
    static int [] [] grid = new int[100][100];
    public static int TwoDsum(int n)
    {
        int [] collectionOfKadene = new int[n];
        int globalMax = Integer.MIN_VALUE;
        for (int leftPointer=0;leftPointer<n;leftPointer++)
        {
            for (int rightPointer =leftPointer; rightPointer<n;rightPointer++) {
                for (int j = 0; j < n; j++) {
                    if (leftPointer == rightPointer)
                        collectionOfKadene[j] = grid[j][leftPointer];
                    else
                        collectionOfKadene[j] = maxSubArray(grid[j], leftPointer, rightPointer);
                }
                //System.out.println(Arrays.toString(collectionOfKadene));
                globalMax = Math.max(maxSubArray(collectionOfKadene),globalMax);
            }

        }
        return globalMax;
    }
    public  static int maxSubArray(int [] value,int leftPointer,int rightPointer)
    {
        int max =0;
        for (int i=leftPointer;i<=rightPointer;i++)
            max+=value[i];
        return max;

    }
    public  static int maxSubArray(int [] value)
    {
        int maxSoFar =value[0];
        int maxEndingHere = value[0];
        for (int i=1;i<value.length;i++)
        {
            maxEndingHere = Math.max(maxEndingHere+value[i],value[i]);
            maxSoFar = Math.max(maxSoFar,maxEndingHere);
        }
        return maxSoFar;
    }

}
