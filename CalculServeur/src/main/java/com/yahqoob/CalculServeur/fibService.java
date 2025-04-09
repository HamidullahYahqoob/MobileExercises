package com.yahqoob.CalculServeur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class fibService{

    public BigInteger fibonacci(int n){

        if(n<0){
            throw new IllegalArgumentException("Salut");
        }

        if(n==0){
            return BigInteger.ZERO;
        }

        if(n==1){
            return BigInteger.ONE;
        }


        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;


        for (int i = 2; i <= n; i++) {
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
        }

        return b;


    }
}
