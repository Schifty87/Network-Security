package Project3_1;

import java.math.BigInteger;


public class PrivateKey {


    public static BigInteger pKey(BigInteger p, BigInteger q, BigInteger e){

        BigInteger one = BigInteger.valueOf(1);
        BigInteger P1 = p.subtract(one);
        BigInteger Q1 = q.subtract(one);
        BigInteger N1 = p.multiply(q);
        BigInteger N = P1.multiply(Q1);
        BigInteger Z = N;
        BigInteger R_2= N;
        BigInteger R_1= e;
        BigInteger R;
        BigInteger X;
        BigInteger Y_1 = BigInteger.valueOf(1);
        BigInteger Y_2= BigInteger.valueOf(0);
        BigInteger Y;
        BigInteger Q;
        boolean bool = true;

        do{
            //find Q using the two previous R's
            Q = R_2.divide(R_1);

            //find the new R (modulus of previous two)
            R = R_2.mod(R_1);

            //get new Y
            //do two separate operations for BigInteger
            X = Q.multiply(Y_1);
            Y = Y_2.subtract(X);

            //move the numbers down
            R_2 = R_1;
            R_1 = R;

            Y_2 = Y_1;
            Y_1 = Y;

            if(R_1 == BigInteger.valueOf(0)){
                //System.out.println("false");
                bool = false;
            }

            //current R is now set to previous
        }while(bool == true);

        if(Y_2.compareTo(BigInteger.valueOf(0)) < 0){
            Y_2 = Y_2.add(Z);
        }

        return Y_2;


    }

}