/*
This program uses DES to create a cipher from hex code
Program Name:  Lab2.java
Author:  Ryan J Schiferl
CS 462 - Network Security
*/

/*
(a) 	3a456b73 e24d2537
		3e89e2ee 10dd259d
(b) 	624b3a2d 92345f3d
		43f4e8ca 10adce57
*/



package Lab2;

public class Lab2 {
	
	static String[] binary = new String[16];
	static char[] convert = new char[16];
	static String code_1;

	public static void main(String[] args){
		
		
		//code_1 = "675a6967 5e5a6b5a";
		//code_1 = "3a456b73 e24d2537";
		code_1 = "624b3a2d 92345f3d";
		
		//convert individual numbers/hex to binary
		binary[0] = "0000";
		binary[1] = "0001";
		binary[2] = "0010";
		binary[3] = "0011";
		binary[4] = "0100";
		binary[5] = "0101";
		binary[6] = "0110";
		binary[7] = "0111";
		binary[8] = "1000";
		binary[9] = "1001";
		binary[10] = "1010";
		binary[11] = "1011";
		binary[12] = "1100";
		binary[13] = "1101";
		binary[14] = "1110";
		binary[15] = "1111";
					
		//fill array with hex values to match binary
		convert = "0123456789abcdef".toCharArray();
			
			hexToBinary();
			fillNew();
			convert();
	}
	
	static String bin = "";
	private static char[] initial = new char[64];
	private static char[] inverse = new char[64];
	private static String[] numbers = new String[16];
	
	//convert from hex to binary
	static void hexToBinary(){
		//create empty string
		for(int i=0; i<code_1.length(); i++){
			for(int j=0; j<binary.length; j++){
				if(code_1.charAt(i) == convert[j]){
					bin += binary[j];
				}
			}
		}
		//fill initial array with items in bin
		for(int i=0; i< bin.length(); i++){
			initial[i] = bin.charAt(i);
		}	
	}
	
	//fill inverse array
	static void fillNew(){
		
		int i = 57;
		int k = 0;
		while(i >= 1){
			inverse[k] = initial[i];
			k++;
			i -= 8;
		}
		i = 59;
		k = 8;
		while(i >= 3){
			inverse[k] = initial[i];
			k++;
			i -= 8;
		}
		i = 61;
		k = 16;
		while(i >= 5){
			inverse[k] = initial[i];
			k++;
			i -= 8;
		}
		i = 63;
		k = 24;
		while(i >= 7){
			inverse[k] = initial[i];
			k++;
			i -= 8;
		}
		i = 56;
		k = 32;
		while(i >= 0){
			inverse[k] = initial[i];
			k++;
			i -= 8;
		}
		i = 58;
		k = 40;
		while(i >= 2){
			inverse[k] = initial[i];
			k++;
			i -= 8;
		}
		i = 60;
		k = 48;
		while(i >= 4){
			inverse[k] = initial[i];
			k++;
			i -= 8;
		}
		i = 62;
		k = 56;
		while(i >= 6){
			inverse[k] = initial[i];
			k++;
			i -= 8;
		}
	}
	
	//go from binary to hex
	static void convert(){
	
		//string items in inverse array together
		String code = "";
		for(int i=0; i<inverse.length; i++){
			code += inverse[i];
		}
		
		//fill array with 4-bit binary strings
		String F = "";
		int M = 0;
		for(int i=0; i< code.length(); i++){
			F += code.charAt(i);
			if(F.length() == 4){
				numbers[M] = F;
				M++;
				F="";					
			}				
		}
		//convert binary strings into hex and print them out
		for(int K = 0; K<numbers.length; K++){
			for(int L=0; L<binary.length; L++){
				if(numbers[K].equals(binary[L])){
					System.out.print(convert[L]);
				}
			}
		}		
	}	
}
