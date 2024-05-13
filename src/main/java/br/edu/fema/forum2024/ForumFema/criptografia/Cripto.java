package br.edu.fema.forum2024.ForumFema.criptografia;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Cripto {
    public static void main(String[] args){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
