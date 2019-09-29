package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer st;
        int Case  =1;
        while ((s=br.readLine())!=null&&!s.equals("0 0")){
            st= new StringTokenizer(s);
            int roads = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int value = roads-N;
            String answer = "Case "+Case+": ";
            if (value<=0)
               answer +=0;
            else if ((N)*26<value)
               answer+="impossible";
            else if (value>=0){
                double determine = Math.ceil(value/(double)N);
                answer+=((int)determine);
            }
            Case++;
            System.out.println(answer);
        }
    }
}
