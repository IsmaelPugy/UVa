package com.company.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;



public class Main {

    public static void main(String[] args) throws IOException{
	// write your code here
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String s;
        HashMap<Character,Integer> value = new HashMap<>();
        for (int i=1;i<=26;i++)
        {
            value.put(((char)(i+64)),i+26);
        }
        for (int i=1;i<=26;i++)
        {
            value.put((char)(i+96),i);
        }
        while ((s=br.readLine())!=null&&!s.equals("EOF"))
        {
            long n= 0;
            n = returnValue(s,value);

            BigInteger N  = new BigInteger(String.valueOf(n));
            if (n==1)
                System.out.println("It is a prime word.");
            else if (N.isProbablePrime(20))
                System.out.println("It is a prime word.");
            else
                System.out.println("It is not a prime word.");
        }
    }

    private static long returnValue(String s,HashMap<Character,Integer>value) {
        int n =0;
        for (int i=0; i<s.length();i++)
            n+=value.get(s.charAt(i));
        return n;
    }
}
