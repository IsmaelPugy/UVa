package com.company.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
        static ArrayList<Integer> primes = new ArrayList<>();
        static HashSet<Integer> Primes = new HashSet<>();
    public static void main(String[] args) throws IOException{
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        SeiveOfEisten(32780);
        while ((s=br.readLine())!=null&&!s.equals("0"))
        {
            int T = Integer.parseInt(s);
           int i=0;
           int howmanyCobjectures = 0;
           while (primes.get(i)<=Math.ceil(T/2.0)) {
                if (Primes.contains(T-primes.get(i)))
                    howmanyCobjectures++;
                i++;
           }
            System.out.println(howmanyCobjectures);
        }
    }
    static void SeiveOfEisten(int n)
    {
        boolean[] prime = new boolean[n+1];
        for (int i=0;i<=n;i++)
            prime[i] = true;
        for (int factor = 2; factor*factor<=n;factor++)
        {
            if (prime[factor])
                for (int i=factor*factor;i<=n;i+=factor)
                    prime[i] =false;
        }
        for (int i=2;i<=n;i++)
            if (prime[i]) {
                primes.add(i);
                Primes.add(i);
            }
    }
    public  static class Pair
    {
        int u;
        int v;
        Pair(int u, int v)
        {
            this.u = u;
            this.v = v;
        }

        }
    }

