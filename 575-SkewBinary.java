package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SkewBinary {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s=br.readLine())!=null&&!s.equals("0")){
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            String n = sb.toString();
            long ans = 0;
            for (int i=0;i<s.length();i++){
                double mutiply = Double.parseDouble(n.substring(i,i+1));
                double powerOfTwp = Math.pow(2,i+1);
                ans+=(mutiply*(powerOfTwp-1));
            }
            if (!s.equals("0"))
            System.out.println(ans);
        }
    }
}
