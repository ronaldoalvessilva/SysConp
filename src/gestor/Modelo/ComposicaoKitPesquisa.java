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
public class ComposicaoKitPesquisa {

    private Integer idRegistroComp;
    private String statusComp;
    private Date dataComp;
    private Integer idKit;
    private String descricaoKit;
    private Integer idPav;
    private String descricaoPav;
    private String descricaoCela;

    public ComposicaoKitPesquisa() {
    }

    public ComposicaoKitPesquisa(Integer idRegistroComp, String statusComp, Date dataComp, Integer idKit, String descricaoKit, Integer idPav, String descricaoPav, String descricaoCela) {
        this.idRegistroComp = idRegistroComp;
        this.statusComp = statusComp;
        this.dataComp = dataComp;
        this.idKit = idKit;
        this.descricaoKit = descricaoKit;
        this.idPav = idPav;
        this.descricaoPav = descricaoPav;
        this.descricaoCela = descricaoCela;
    }

    /**
     * @return the idRegistroComp
     */
    public Integer getIdRegistroComp() {
        return idRegistroComp;
    }

    /**
     * @param idRegistroComp the idRegistroComp to set
     */
    public void setIdRegistroComp(Integer idRegistroComp) {
        this.idRegistroComp = idRegistroComp;
    }

    /**
     * @return the statusComp
     */
    public String getStatusComp() {
        return statusComp;
    }

    /**
     * @param statusComp the statusComp to set
     */
    public void setStatusComp(String statusComp) {
        this.statusComp = statusComp;
    }

    /**
     * @return the dataComp
     */
    public Date getDataComp() {
        return dataComp;
    }

    /**
     * @param dataComp the dataComp to set
     */
    public void setDataComp(Date dataComp) {
        this.dataComp = dataComp;
    }

    /**
     * @return the idKit
     */
    public Integer getIdKit() {
        return idKit;
    }

    /**
     * @param idKit the idKit to set
     */
    public void setIdKit(Integer idKit) {
        this.idKit = idKit;
    }

    /**
     * @return the descricaoKit
     */
    public String getDescricaoKit() {
        return descricaoKit;
    }

    /**
     * @param descricaoKit the descricaoKit to set
     */
    public void setDescricaoKit(String descricaoKit) {
        this.descricaoKit = descricaoKit;
    }

    /**
     * @return the idPav
     */
    public Integer getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(Integer idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the descricaoPav
     */
    public String getDescricaoPav() {
        return descricaoPav;
    }

    /**
     * @param descricaoPav the descricaoPav to set
     */
    public void setDescricaoPav(String descricaoPav) {
        this.descricaoPav = descricaoPav;
    }

    /**
     * @return the descricaoCela
     */
    public String getDescricaoCela() {
        return descricaoCela;
    }

    /**
     * @param descricaoCela the descricaoCela to set
     */
    public void setDescricaoCela(String descricaoCela) {
        this.descricaoCela = descricaoCela;
    }
}
