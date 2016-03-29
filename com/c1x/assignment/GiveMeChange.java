package com.c1x.assignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GiveMeChange {

	static Map<String,Integer> coinVsCount = new HashMap<String,Integer>();
	static final int[] rpArr = { 5, 2, 1 };
	static final int[] paArr = { 50, 25, 10 };
	
	public static void main(String[] args) {
		try {
			System.out.println("Enter change amount:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String data = br.readLine();
			int rupee = Integer.parseInt(data.split("\\.")[0]);
			int paise = Integer.parseInt(data.split("\\.")[1]);
			if (paise < 100 && paise % 25 != 0 && paise % 10 != 0) {
				System.out.println("Cannot give the change");
				System.exit(0);
			}
			calculate(rpArr, rupee, "rupees");
			calculate(paArr, paise, "paise");

			StringBuffer output = new StringBuffer();
			for (String key : coinVsCount.keySet()) {
				output.append(key).append(" = ").append(coinVsCount.get(key))
						.append(",");
			}
			System.out.println(output.substring(0, output.length() - 1));
		} catch (Exception e) {
			System.out.println("Exception :"+e);
		}
	}

	private static void calculate(int[] rpArr, int rupee,String type) throws Exception {
		for(int rp : rpArr){
			while(rupee >= rp){
				if(rp == 25 && (rupee%25 != 0 || rupee%10 !=0)){
					break;
				}
				putInMap(rp+" "+type);
				rupee=rupee-rp;
			}
		}
	}
	
	private static void putInMap(String key) throws Exception {
		Integer count = coinVsCount.get(key);
		if(count == null){
			count = 0;
		}
		coinVsCount.put(key, count+1);
	}

}