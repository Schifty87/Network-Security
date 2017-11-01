/*
This program decyphers ciphertext to plaintext using Caesar cipher
Program Name:  Lab1.java
Author:  Ryan J Schiferl
CS 462 - Network Security
*/

/*
(a) 	pidm ncv epqtm ewzsqvo pizl
		have fun while working hard (-8)
(b) 	mabl lnffxk ptl lh gbvx
		this summer was so nice (+7)
(c) 	ikhzktffbgz bl ghm yng
		programming is not fun  (+7)
*/


package Lab1;

import java.util.Scanner;

public class Lab1 {
	
	//create global variables
	static String code;		
	static char[] letters = new char[26];		
	
	public static void main(String[] args){
		
		letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
				
		Scanner s = new Scanner(System.in);
	
			System.out.print("Input code to decypher: ");
			code = s.nextLine();
			//decypherDown();
			decypher();
					
	}//end main
		
	public static void decypher(){
		int rem;
		
		//range is +-13 for each character in ciphertext
		for(int x=-13;x<14;x++){
			System.out.print(x + ": ");
		
			//run through individual items withing ciphertext
			for(int i=0;i<code.length();i++){
				//t now represents the individual character in coded text
				char t = code.charAt(i);
				
				//if there is a space, include it
				if(t == ' '){
					System.out.print(" ");
					//don't go any further with this character
					continue;
				}
				
				//find the letters in ciphertext in the alphabet array and identify them
				//once the letters are found, they are shifted based on first 'for' loop
				for(int j=0; j<letters.length;j++){
					if(t == letters[j]){
						//if letter shift bottoms out in array.  Must go to Z
						if(j+x < 0){
							rem = 26 - (Math.abs(x)-j);
							System.out.print(letters[rem]);
						}
						//if letter shift exceeds array limit.  Must go to A
						else if(j+x > 25){
							rem = 0 + (j-26+x);
							System.out.print(letters[rem]);
						}
						//if the letter shift doesn't exceed the bounds of the array
						else{
							System.out.print(letters[j+x]);
						}				
					}							
				}
			}
			//return down a line and perform next decryption
			System.out.println();
		}
	}		
}//end class Decrypt