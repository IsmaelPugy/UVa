package com.company.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
import java.math.*;


public class Main {
    static HashSet<Integer> set = new HashSet<>();
    static   ArrayList<Integer> primes = new ArrayList<>();
    static   ArrayList<IntergerPair> twinPrime = new ArrayList<>();
    public static void main(String[] args) throws IOException{
     /**   // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        SieveOfEratosthenes(20000000);
        for (int i=0;i<primes.size();i++)
        {
            if (set.contains(primes.get(i)+2))
                twinPrime.add(new IntergerPair(primes.get(i),primes.get(i)+2));
        }
        while ((s= br.readLine())!=null)
        {
            System.out.println("("+twinPrime.get(Integer.parseInt(s)-1).u+", "+twinPrime.get(Integer.parseInt(s)-1).v+")");
        }
      */

     BigInteger value  =new BigInteger("10000000");
        System.out.println(factorial(value));

    }
    public static BigInteger factorial(BigInteger number) {
        BigInteger result = BigInteger.valueOf(1);

        for (long factor = 2; factor <= number.longValue(); factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }

        return result;
    }
    private static void SieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n+1];
        for (int i=0;i<=n;i++)
            prime[i] = true;
        for (int factor = 2;factor*factor<=n;factor++)
        {
            if (prime[factor])
                for (int i=factor*factor;i<=n;i+=factor)
                    prime[i] = false;
        }
        for (int i=2;i<=n;i++)
            if (prime[i])
            {
                set.add(i);
                primes.add(i);
            }
    }
    public static class IntergerPair
    {
        int u;
        int v;
        IntergerPair(int u, int v)
        {
            this.u = u;
            this.v = v;
        }
    }
}

