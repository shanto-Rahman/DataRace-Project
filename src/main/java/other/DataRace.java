package dataRace;

import java.util.*;
import java.util.Collections;


public class DataRace {
	private ArrayList list=new ArrayList();
    private static ArrayList arr4 = new ArrayList();
	private static  String[] rep;
	private static int[] testIntArr;

	public static String[] request3(){
		ArrayList arr3 = new ArrayList();
		for(int i=0;i<5;i++){
			arr3.add("Request 3");
		}
		
		rep = new String[5];
		arr3.toArray(rep);
		testIntArr = new int[2];
		testIntArr[0] =5;
		return rep;
	}

	public static int request4(){
		arr4.add("Request 4");
        System.out.println("I AM REQUEST 4");
        int size=arr4.size();
        int hashcode=arr4.hashCode();
		return size;
	}

}
