package com.kelvem;
import java.util.ArrayList;
public class UsandoArrayList {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("A");
		arrayList.add("C");
		
		System.out.println(arrayList);
		
		arrayList.add(1, "B");
		System.out.println(arrayList);
		
		System.out.println(arrayList.contains("A"));
		
		System.out.println(arrayList.indexOf("C"));
		
		System.out.println(arrayList.get(1));
		
		arrayList.remove(1);
		System.out.println(arrayList);
		
		arrayList.remove("C");
		
		System.out.println(arrayList);
		
		
	}
	
}
