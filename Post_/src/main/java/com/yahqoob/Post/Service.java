package com.yahqoob.Post;




@org.springframework.stereotype.Service
public class Service {

    public String chaine(int taille) {

        String texte = "pipo";
        StringBuilder result = new StringBuilder();


        while (result.length() < taille) {
            result.append(texte);
        }

        return result.toString();
    }



}
