package Project3_1;

import java.math.BigInteger;


/**
 * Created by Jeremy Bernien on 11/26/2016.
 */
public class Encryptor {


    // Returns the decrypted result
    public static BigInteger decrypt(BigInteger cipherText, BigInteger d, BigInteger modN){
        return bigModulus(cipherText, d, modN);
    }

    // C = M^e mod n
    public static BigInteger encrypt(BigInteger message, BigInteger exponent, BigInteger n){
        return bigModulus(message, exponent, n);
    }

    //For each smaller number, mod n and then multiply with the running result
    // (message^exponent) mod n = [(base^exponentA) mod n] * [(base^exponentB] mod n
    private static BigInteger bigModulus(BigInteger message, BigInteger exponent, BigInteger n) {
        BigInteger cipherText = BigInteger.ONE;

        // from exponent to zero, text = text*message mod n
        //      multiply the running total with the previous values
        //      exponent = exponent / 2
        //      message = message*message mod n
        while (exponent.compareTo(BigInteger.valueOf(0)) > 0) {
            // if exponent is odd
            if(exponent.testBit(0)){
                cipherText = (cipherText.multiply(message));
                cipherText = cipherText.mod(n);
            }
            // exponent is now even, we can have the work by squaring the result of half the exp
            exponent = exponent.divide(BigInteger.valueOf(2L));
            message = (message.multiply(message)).mod(n);
        }
        return cipherText;

    }


    // main method to test
    public static void main(String[] args){

        BigInteger message = new BigInteger("1976620216402300889624482718775150");
        String bigValueN = "145906768007583323230186939349070635292401872375357164399581871019873438799005358938369571402670149802121818086292467422828157022922076746906543401224889672472407926969987100581290103199317858753663710862357656510507883714297115637342788911463535102712032765166518411726859837988672111837205085526346618740053";
        String bigValueD = "89489425009274444368228545921773093919669586065884257445497854456487674839629818390934941973262879616797970608917283679875499331574161113854088813275488110588247193077582527278437906504015680623423550067240042466665654232383502922215493623289472138866445818789127946123407807725702626644091036502372545139713";
        String bigValueE = "65537";

        BigInteger cipherText = encrypt(message, new BigInteger(bigValueE), new BigInteger(bigValueN));
        System.out.println(cipherText);

        BigInteger plainText = decrypt(cipherText, new BigInteger(bigValueD), new BigInteger(bigValueN));
        System.out.println(plainText);
    }

}