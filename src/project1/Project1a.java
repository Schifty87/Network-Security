package project1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;


public class Project1a extends FileNotFoundException {
	
	static char[] alphabet;
	static double[] counter = new double[26];
	static String content;
	static int sum = 0;
	
	public static void main(String[] args) throws IOException{
		
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
				
		load();
		letterCount();
		sum();
		output();
			
	}//end main
	
	//load the file
	@SuppressWarnings("resource")
	public static void load() throws FileNotFoundException{
		content = new Scanner(new File("Ryan.txt")).useDelimiter("\\Z").next();
	}
	
	//count the number of times each letter is used
	public static void letterCount(){
		for(int i=0; i<content.length(); i++){
			for(int j = 0; j<alphabet.length; j++){
				if(content.charAt(i)==alphabet[j]){
					counter[j]++;
				}
			}
		}
	}
	
	//count the total number of letters to help with percentage calculation
	public static void sum(){
		for(int z=0; z<counter.length; z++){
			sum += counter[z];
		}
	}
	
	//print the percent-use of every letter
	public static void output(){
		DecimalFormat df = new DecimalFormat("0.00");
		for(int k=0; k<alphabet.length; k++){
			System.out.println(alphabet[k] + "  -  " + df.format((counter[k]/sum)*100) + " %");
		}
	}
	
}//end class

