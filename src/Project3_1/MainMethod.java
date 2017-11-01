package Project3_1;

import java.math.BigInteger;
import java.util.Scanner;

//perform AES cipher/decipher

public class MainMethod {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
               
        //first submission
        //BigInteger p = new BigInteger("12131072439211271897323671531612440428472427633701410925634549312301964373042085619324197365322416866541017057361365214171711713797974299334871062829803541");
        //BigInteger q = new BigInteger("12027524255478748885956220793734512128733387803682075433653899983955179850988797899869146900809131611153346817050832096022160146366346391812470987105415233");
        BigInteger p = new BigInteger("3");
		BigInteger q = new BigInteger("13");
        //original N
        //BigInteger n = new BigInteger("145906768007583323230186939349070635292401872375357164399581871019873438799005358938369571402670149802121818086292467422828157022922076746906543401224889672472407926969987100581290103199317858753663710862357656510507883714297115637342788911463535102712032765166518411726859837988672111837205085526346618740053");
        BigInteger n = new BigInteger("39");
        // get public key from user
        System.out.print("Please choose a public key: ");
        String response = s.nextLine().trim();
        BigInteger publicKey = new BigInteger(response);

        
        // create a private key from the p, q, and public key
        BigInteger privateKey = PrivateKey.pKey(p, q, publicKey);

        // get two digit number from user
        System.out.print("A two digit number please: ");
        BigInteger message = new BigInteger(s.nextLine().trim());

        System.out.println("Encrypting: '" + message + "'" + "\nPublic key: " + publicKey.toString() + "\nPrivate key: " + privateKey.toString());

        BigInteger cipherText = Encryptor.encrypt(message, publicKey, n);
        System.out.println("\n\nEncrypted text: " + cipherText.toString());

        
        System.out.println("\n\nDecrypted text: " + Encryptor.decrypt(cipherText, privateKey, n));
        
    }
}
