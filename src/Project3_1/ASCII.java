package Project3_1;

public class ASCII {

	
	public ASCII(){}


	public String StringToASCII(String X){
		String ascii = "";
		for(int i=0; i<X.length(); i++){
			char N = (char) X.charAt(i);
			//System.out.print(N);
			int as = (int) N;
			String Y = Integer.toString(as);
			ascii += Y;
		}
		//long E = long.parselong(ascii);
		return ascii;
		//System.out.println(ascii);
	}
	
	public void ASCIIToString(int X){
		
	}


}