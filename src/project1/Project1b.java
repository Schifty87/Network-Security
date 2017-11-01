package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project1b {
	
	static char[] letters;
	static char[] newLetters;
	static String content;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		//order based on freqency (matched with cyphertext characters) from original
		//46% are correct
		//newLetters = "LGXWJZFUSVPARTBQOCEDYMHINK".toCharArray();
		
		//correct order - A=L, B=W, C=X, etc 
		newLetters = "LWXCJZGYHKFOSTBQAUEDPMRINV".toCharArray();
		
		load();
		replace();
		System.out.print(content.charAt(100));
		
	}//end main
	
	//load the file
	@SuppressWarnings("resource")
	public static void load() throws FileNotFoundException{
		content = new Scanner(new File("Ryan.txt")).useDelimiter("\\Z").next();
	}
	
	//replace
	public static void replace(){
		
		//for every character in the message.....
		for(int i=0; i<content.length(); i++){
			char x = content.charAt(i);
			//for each letter, keep y=0 until a letter is found
			int y = 0;
			for(int j=0; j<letters.length;j++){
				//determine if character is in fact a letter
				if(letters[j] == x){
					System.out.print(newLetters[j]);
					//prevents second "if" statement from working
					y++;
				}			
			}
			//if y=0, a letter could not be found
			//wrong letter is not printed if y=1
			//used for other characters, punctuation, new line, etc
			if(y==0){
				System.out.print(content.charAt(i));
			}
		}
	}
}
