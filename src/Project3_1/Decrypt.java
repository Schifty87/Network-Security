package Project3_1;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


/*plug numbers in to decrypt message*/

public class Decrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//first submission
        BigInteger p = new BigInteger("12131072439211271897323671531612440428472427633701410925634549312301964373042085619324197365322416866541017057361365214171711713797974299334871062829803541");
        BigInteger q = new BigInteger("12027524255478748885956220793734512128733387803682075433653899983955179850988797899869146900809131611153346817050832096022160146366346391812470987105415233");
        //original N
        BigInteger n = new BigInteger("145906768007583323230186939349070635292401872375357164399581871019873438799005358938369571402670149802121818086292467422828157022922076746906543401224889672472407926969987100581290103199317858753663710862357656510507883714297115637342788911463535102712032765166518411726859837988672111837205085526346618740053");
		
        
        /*file holds text to be decrypted*/
        String file = "decrypt.txt";
        
        ArrayList<String> cipher = new ArrayList<String>();
        
        try(Scanner scanner = new Scanner(new File(file))){
			while(scanner.hasNext()){
				String[] X = scanner.nextLine().split(",");
				
				cipher.add(X[0]);
				//System.out.println(X[0]);
				
			}			
		}catch(Exception e){
			System.out.print("error");
		}
 
        //create a public key
        BigInteger publicKey = new BigInteger("65537");
        
        //create private key with the use of the newly created public key
        BigInteger privateKey = PrivateKey.pKey(p, q, publicKey);
      
        
        for(int i=0; i<cipher.size(); i++){
        	//pull out the next string value in the array
        	String trout = cipher.get(i);
        	//convert the string value into a BigInteger
        	BigInteger bluegill = new BigInteger(trout);
        	//use decrypt method within Encryptor class to get ascii values
        	BigInteger northernPike = Encryptor.decrypt(bluegill, privateKey, n);
        	//convert BigInteger ascii value to integer
        	int minnow = northernPike.intValue();
        	//use (char)int method to convert ascii value to character
        	System.out.print((char)minnow);
        }
	
	}
}
