/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronaldo
 */
public class AtualizaLoteEnfermaria {
    
    private int idProd;
    private int idLanc;
    private Date DataValidade;
    private String lote;
    private float qtd;

    public AtualizaLoteEnfermaria(int idProd, int idLanc, Date DataValidade, String lote, float qtd) {
        this.idProd = idProd;
        this.idLanc = idLanc;
        this.DataValidade = DataValidade;
        this.lote = lote;
        this.qtd = qtd;
    }

    public AtualizaLoteEnfermaria() {
    }

    /**
     * @return the idProd
     */
    public int getIdProd() {
        return idProd;
    }

    /**
     * @param idProd the idProd to set
     */
    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    /**
     * @return the idLanc
     */
    public int getIdLanc() {
        return idLanc;
    }

    /**
     * @param idLanc the idLanc to set
     */
    public void setIdLanc(int idLanc) {
        this.idLanc = idLanc;
    }

    /**
     * @return the DataValidade
     */
    public Date getDataValidade() {
        return DataValidade;
    }

    /**
     * @param DataValidade the DataValidade to set
     */
    public void setDataValidade(Date DataValidade) {
        this.DataValidade = DataValidade;
    }

    /**
     * @return the lote
     */
    public String getLote() {
        return lote;
    }

    /**
     * @param lote the lote to set
     */
    public void setLote(String lote) {
        this.lote = lote;
    }

    /**
     * @return the qtd
     */
    public float getQtd() {
        return qtd;
    }

    /**
     * @param qtd the qtd to set
     */
    public void setQtd(float qtd) {
        this.qtd = qtd;
    }
  
}
