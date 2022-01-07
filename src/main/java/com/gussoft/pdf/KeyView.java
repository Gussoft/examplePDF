package com.gussoft.pdf;

import java.security.KeyStore;
import java.security.KeyStoreException;

public class KeyView {
    public static void main(String[] args) {
        KeyStore keystore2 = null;
        try {
            KeyStore keystore = KeyStore.getInstance("Windows-MY");//KeyStore.getInstance(KeyStore.getDefaultType());//
            System.out.println(keystore.aliases());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }

    }
}
