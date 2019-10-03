package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
        static int size =0;
        static HashMap<Integer,Integer> start = new HashMap<>();
        static HashMap<Integer,Integer> end = new HashMap<>();
       static int min =0;

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer st;
        while ((s=br.readLine())!=null&&!s.equals("")){
;            size = Integer.parseInt(s);
            st = new StringTokenizer(br.readLine());
            for (int i=0;i<size;i++)
                start.put(i,Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            for (int i=0;i<size;i++)
                end.put(i,Integer.parseInt(st.nextToken()));
            ///loop through the map
            for (int i=0;i<size;i++){
              //  System.out.println(start);
                //System.out.println(start);
                //loop through the end position if if there is it behind it
                boolean isBehind = false;
                for (int j=i;j<size;j++){
                    if(end.get(j)==start.get(i))
                        isBehind =true;
                }
               // System.out.println(isBehind);
                if (!isBehind){
                    //this value will be the one if they cross some cars
                    //index of the of the car at the end
                    int indexOfCar = 0;
                    for (int j=0;j<size;j++){
                        if (start.get(i)==end.get(j)) {
                            indexOfCar = j;
                            moveAllTheCar(indexOfCar,start.get(i),i);
                          //  System.out.println(i-j);
                            min +=i-j;
                            j= 100;
                          i=0;
                        }
                    }
                }
            }
            System.out.println(min);
            min =0;
            start.clear();
            end.clear();
        }
    }
    private static void moveAllTheCar(int indexOfCar, Integer integer,int startPosition) {
        for (int i=startPosition;i>indexOfCar;i--)
        {
            start.replace(i,start.get(i-1));
        }
        start.replace(indexOfCar,integer);
    }
}
