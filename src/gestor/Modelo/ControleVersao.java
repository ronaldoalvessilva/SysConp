/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronaldo.silva7
 */
public class ControleVersao {

    /**
     * @return the versao
     */
    public Double getVersao() {
        return versao;
    }

    /**
     * @param versao the versao to set
     */
    public void setVersao(Double versao) {
        this.versao = versao;
    }

    /**
     * @return the dataVersao
     */
    public Date getDataVersao() {
        return dataVersao;
    }

    /**
     * @param dataVersao the dataVersao to set
     */
    public void setDataVersao(Date dataVersao) {
        this.dataVersao = dataVersao;
    }

    private Double versao;
    private Date dataVersao;

    public ControleVersao(Double versao, Date dataVersao) {
        this.versao = versao;
        this.dataVersao = dataVersao;
    }

    public ControleVersao() {
    }

    public void setDataVersao(String dataVersao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
