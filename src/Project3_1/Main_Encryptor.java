package Project3_1;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_Encryptor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//BigInteger p = new BigInteger("12131072439211271897323671531612440428472427633701410925634549312301964373042085619324197365322416866541017057361365214171711713797974299334871062829803541");
        //BigInteger q = new BigInteger("12027524255478748885956220793734512128733387803682075433653899983955179850988797899869146900809131611153346817050832096022160146366346391812470987105415233");
		BigInteger p = new BigInteger("3");
		BigInteger q = new BigInteger("13");
		//original N
        //BigInteger n = new BigInteger("145906768007583323230186939349070635292401872375357164399581871019873438799005358938369571402670149802121818086292467422828157022922076746906543401224889672472407926969987100581290103199317858753663710862357656510507883714297115637342788911463535102712032765166518411726859837988672111837205085526346618740053");

        //need to ask for E and N     
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a message to encrypt ");
		String msg = scan.nextLine();
		System.out.println("Enter the public key");
		int E = scan.nextInt();
		String pk = Integer.toString(E);
		BigInteger publicKey = new BigInteger(pk);
		System.out.println("Enter value for N ");
		BigInteger N = scan.nextBigInteger();
		
		
		for(int i=0; i<msg.length(); i++){
			char L = msg.charAt(i);
			int ascii = (int) L;
			String R = Integer.toString(ascii);
			BigInteger M = new BigInteger(R);
			
		
			BigInteger cipherText = Encryptor.encrypt(M, publicKey, N);
			System.out.println("\n\nEncrypted text: " + cipherText.toString());
		}
	}

}
