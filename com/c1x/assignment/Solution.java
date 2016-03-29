package com.c1x.assignment;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input");
		int testCase = Integer.parseInt(br.readLine());
        for(int cas=0;cas<testCase;cas++){
        	String input2 = br.readLine();
            int arrSize = Integer.parseInt(input2.split(" ")[0]);
            int modulo = Integer.parseInt(input2.split(" ")[1]);
            System.out.println("arrSize"+arrSize);
            System.out.println("modulo"+modulo);
            int[] arr = new int[arrSize];
            Set<List<Integer>> set = new HashSet<List<Integer>>();
            String adata = br.readLine();
            for(int i =0;i<arrSize;i++){
                arr[i] = Integer.parseInt(adata.split(" ")[i]);
                System.out.println("arr"+i+":"+arr[i]);
            }
//            
//            int j = 1;
//            while(j<arrSize -1){
//                for(int i=0;i<arrSize-1;i=i+j){
//                    List<Integer> lst = new ArrayList<Integer>();
//                    for(int k = i;k<i+j;k++){
//                        lst.add(arr[k]);    
//                    }
//                    System.out.println("List Data: ");
//                    for(Integer data : lst){
//                        System.out.println(data);
//                    }
//                    set.add(lst);
//                }
//            }
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}