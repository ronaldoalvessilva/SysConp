/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Dao;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ronaldo
 */
public class AlinharColunasTabelas extends DefaultTableCellRenderer{

    DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
    DefaultTableCellRenderer direita = new DefaultTableCellRenderer();

    //

    /**
     *
     */
    
    public void colunaEsquerdo(int coluna) {
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
    }

    public void colunaCentralizado(int coluna) {
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void ColunaDireita(int coluna) {
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
    }
//        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
//        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
//        direita.setHorizontalAlignment(SwingConstants.RIGHT);
}
