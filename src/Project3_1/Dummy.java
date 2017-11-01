package Project3_1;

import java.math.BigInteger;

public class Dummy {
	public static void main(String[] args){
		
		BigInteger P = new BigInteger("13");
		BigInteger Q = new BigInteger("3");
		BigInteger E = new BigInteger("17");
		System.out.println(PrivateKey.pKey(P, Q, E));
		
		BigInteger P1 = new BigInteger("128");
		BigInteger P2 = new BigInteger("47");
		BigInteger P3 = new BigInteger("101");
		BigInteger P4 = new BigInteger("35");
		BigInteger P5 = new BigInteger("256");
		BigInteger P6 = new BigInteger("35");
		
		BigInteger K = P1.multiply(P2).multiply(P3).multiply(P4).multiply(P5).multiply(P6);
		System.out.println(K);
		BigInteger M = new BigInteger("527");
		BigInteger mod = K.mod(M);
		System.out.println(mod);
	}
}
