package com.itnova.hello;

import java.util.Arrays;
import java.util.Collections;

public class Sort {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 7, 9, 0 } ;
		Arrays.sort(arr);
		for(int i : arr) {
			System.out.print("[" + i + "]");
		}
		
		System.out.println();
		
		String strs[] = {"T1" ,"T10" , "T2"};
		Arrays.sort(strs, Collections.reverseOrder());
		
		for(String s : strs) {
			System.out.print("[" + s + "]");
		}
		
		System.out.println("replace--> " + strs[0].replace("T", ""));
		
		EmstRf[] emstRfs = {
			new EmstRf("P1", "T1")
		   ,new EmstRf("P2", "T2")
		   ,new EmstRf("P3", "T10")
		};
		
		Arrays.sort(emstRfs, Collections.reverseOrder());
		
		for(EmstRf e : emstRfs) {
			System.out.print("[" + e.show() + "]");
		}
	}

	
}
