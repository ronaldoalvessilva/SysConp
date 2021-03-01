/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author ronal
 */
public class CriptografarDadosChaveSistema {

    private static byte[] dadosCriptografos = null;
    private static byte[] dadosDescriptografados = null;

    public static byte[] criptografar(String dadosCripto) {

        //CRIPTOGRAFIA SIMÉTRICA AES, RC2, RC4, RC5, IDEA, Blowfish
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecretKey secretKey = keyGenerator.generateKey();
            Cipher cipher;
            cipher = Cipher.getInstance("AES");
            //CRIPTOGRAFANDO OS DADOS  
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            dadosCriptografos = cipher.doFinal(dadosCripto.getBytes());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CriptografarDadosChaveSistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(CriptografarDadosChaveSistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(CriptografarDadosChaveSistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(CriptografarDadosChaveSistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(CriptografarDadosChaveSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String desCriptografar(byte[] dados2) {
        //CRIPTOGRAFANDO OS DADOS
        //CRIPTOGRAFIA SIMÉTRICA AES, RC2, RC4, RC5, IDEA, Blowfish
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecretKey secretKey = keyGenerator.generateKey();
            Cipher cipher;
            cipher = Cipher.getInstance("AES");
            //DESCRIPTOGRAFANDO OS DADOS            
            if (keyGenerator != null) {
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                dadosDescriptografados = cipher.doFinal(dados2);
            }
            //
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CriptografarDadosChaveSistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(CriptografarDadosChaveSistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(CriptografarDadosChaveSistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(CriptografarDadosChaveSistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(CriptografarDadosChaveSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
