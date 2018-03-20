/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Ronaldo
 */
public class ItensDoencas {

    private int idItem;
    private Date dataLanc;
    private int idLanc;
    private int idDoenca;
    private String descricaoDoenca;

    public ItensDoencas(int idItem, Date dataLanc, int idLanc, int idDoenca, String descricaoDoenca) {
        this.idItem = idItem;
        this.dataLanc = dataLanc;
        this.idLanc = idLanc;
        this.idDoenca = idDoenca;
        this.descricaoDoenca = descricaoDoenca;
    }

    public ItensDoencas() {
    }

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the dataLanc
     */
    public Date getDataLanc() {
        return dataLanc;
    }

    /**
     * @param dataLanc the dataLanc to set
     */
    public void setDataLanc(Date dataLanc) {
        this.dataLanc = dataLanc;
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
     * @return the idDoenca
     */
    public int getIdDoenca() {
        return idDoenca;
    }

    /**
     * @param idDoenca the idDoenca to set
     */
    public void setIdDoenca(int idDoenca) {
        this.idDoenca = idDoenca;
    }

    /**
     * @return the descricaoDoenca
     */
    public String getDescricaoDoenca() {
        return descricaoDoenca;
    }

    /**
     * @param descricaoDoenca the descricaoDoenca to set
     */
    public void setDescricaoDoenca(String descricaoDoenca) {
        this.descricaoDoenca = descricaoDoenca;
    }   
}
