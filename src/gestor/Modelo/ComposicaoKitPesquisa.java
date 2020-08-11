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
    private Integer idInternoCrc;
    private String nomeInternoCrc;
    private String regimePenal;
    private String matriculaPenal;
    private Integer idProd;
    private String descricaoProd;
    private String unidade;
    private Integer quantidade;    

    public ComposicaoKitPesquisa() {
    }

    public ComposicaoKitPesquisa(Integer idRegistroComp, String statusComp, Date dataComp, Integer idKit, String descricaoKit, Integer idPav, String descricaoPav, String descricaoCela, Integer idInternoCrc, String nomeInternoCrc, String regimePenal, String matriculaPenal, Integer idProd, String descricaoProd, String unidade, Integer quantidade) {
        this.idRegistroComp = idRegistroComp;
        this.statusComp = statusComp;
        this.dataComp = dataComp;
        this.idKit = idKit;
        this.descricaoKit = descricaoKit;
        this.idPav = idPav;
        this.descricaoPav = descricaoPav;
        this.descricaoCela = descricaoCela;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.regimePenal = regimePenal;
        this.matriculaPenal = matriculaPenal;
        this.idProd = idProd;
        this.descricaoProd = descricaoProd;
        this.unidade = unidade;
        this.quantidade = quantidade;
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

    /**
     * @return the idInternoCrc
     */
    public Integer getIdInternoCrc() {
        return idInternoCrc;
    }

    /**
     * @param idInternoCrc the idInternoCrc to set
     */
    public void setIdInternoCrc(Integer idInternoCrc) {
        this.idInternoCrc = idInternoCrc;
    }

    /**
     * @return the nomeInternoCrc
     */
    public String getNomeInternoCrc() {
        return nomeInternoCrc;
    }

    /**
     * @param nomeInternoCrc the nomeInternoCrc to set
     */
    public void setNomeInternoCrc(String nomeInternoCrc) {
        this.nomeInternoCrc = nomeInternoCrc;
    }

    /**
     * @return the regimePenal
     */
    public String getRegimePenal() {
        return regimePenal;
    }

    /**
     * @param regimePenal the regimePenal to set
     */
    public void setRegimePenal(String regimePenal) {
        this.regimePenal = regimePenal;
    }

    /**
     * @return the matriculaPenal
     */
    public String getMatriculaPenal() {
        return matriculaPenal;
    }

    /**
     * @param matriculaPenal the matriculaPenal to set
     */
    public void setMatriculaPenal(String matriculaPenal) {
        this.matriculaPenal = matriculaPenal;
    }

    /**
     * @return the idProd
     */
    public Integer getIdProd() {
        return idProd;
    }

    /**
     * @param idProd the idProd to set
     */
    public void setIdProd(Integer idProd) {
        this.idProd = idProd;
    }

    /**
     * @return the descricaoProd
     */
    public String getDescricaoProd() {
        return descricaoProd;
    }

    /**
     * @param descricaoProd the descricaoProd to set
     */
    public void setDescricaoProd(String descricaoProd) {
        this.descricaoProd = descricaoProd;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the quantidade
     */
    public Integer getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
