/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilitarios;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author CPLF
 */
public class LimiteDigitosAlfa extends PlainDocument {
    
    private int quantidadeMax;
    public LimiteDigitosAlfa(int maxLen){
        super();
        if(maxLen <= 0)
            throw new IllegalArgumentException("Especifique a quantidade!!!");
        quantidadeMax=maxLen;
    }
    @Override
    public void insertString(int offset, String str, AttributeSet attr)
    throws BadLocationException{
        if(str == null || getLength()== quantidadeMax)
            return;
        int totalquantia = (getLength()+ str.length());
        if(totalquantia <= quantidadeMax){
            super.insertString(offset, str.toUpperCase().replaceAll("[^a-z|^A-Z|^ |0-9|^,|^.|^+ |^-]",""), attr);
            return;
        }
        String nova = str.substring(0,getLength()-quantidadeMax);
        super.insertString(offset, nova, attr);
    }    
}
