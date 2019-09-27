package com.company;

import java.io.BufferedReader;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
   // thank you so much for the help I didn't understand how to use my graph search algorthim on a 2d grid
    //https://prosenc.blogspot.com/2015/02/uva-572-oil-deposits-solution.html
        static  int row;
        static int col;
        static char [] []grid = new char[100][100];
        static  String line;
        static boolean[][] visted = new boolean[100][100];
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer st;
        while ((s=br.readLine())!=null&&!s.equals("0 0")){
            st = new StringTokenizer(s);
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            for (int i=0;i<row;i++){
                line = br.readLine();
                for (int j=0;j<col;j++)
                    grid[i][j] = line.charAt(j);
            }
            //count
            int count = 0;
            // count the island in the graph
            for (int i=0;i<row;i++)
                for (int j=0;j<col;j++) {
                    // use Depthr first searc algorthim
                    if (grid[i][j] == '@' && !visted[i][j])
                    {
                        DFS(i, j);
                    count++;
                }
                }
            for (int i=0;i<100;i++)
                Arrays.fill(visted[i],false);
            System.out.println(count);
        }
    }

    private static void DFS(int i, int j) {
        if (i>=0&&j>=0&&j<col&&i<row&&!visted[i][j]&&grid[i][j]=='@')
        {
            visted[i][j] = true;
            //go north
            DFS(i+1,j);
            //go northRight
            DFS(i+1,j+1);
            //go right
            DFS(i,j+1);
            //go right bottom
            DFS(i-1,j+1);
            //go bottom
            DFS(i-1,j);
            //go left bottom
            DFS(i-1,j-1);
            //go left
            DFS(i,j-1);
            //go left top
            DFS(i+1,j-1);
        }
    }
}
