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
public class ItensPavilhaoCelaInternosProcedimento {

    private int idItensPcip;
    private int idItensIntProc;
    private Date dataProc;
    private int idProc;
    private int idPav;
    private String descricaoPavilhao;
    private int idCela;
    private String descricaoCela;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;     

    public ItensPavilhaoCelaInternosProcedimento(int idItensPcip, int idItensIntProc, Date dataProc, int idProc, int idPav, String descricaoPavilhao, int idCela, String descricaoCela, int idInternoCrc, String nomeInternoCrc, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItensPcip = idItensPcip;
        this.idItensIntProc = idItensIntProc;
        this.dataProc = dataProc;
        this.idProc = idProc;
        this.idPav = idPav;
        this.descricaoPavilhao = descricaoPavilhao;
        this.idCela = idCela;
        this.descricaoCela = descricaoCela;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensPavilhaoCelaInternosProcedimento() {
    }

    /**
     * @return the idItensPcip
     */
    public int getIdItensPcip() {
        return idItensPcip;
    }

    /**
     * @param idItensPcip the idItensPcip to set
     */
    public void setIdItensPcip(int idItensPcip) {
        this.idItensPcip = idItensPcip;
    }

    /**
     * @return the idItensIntProc
     */
    public int getIdItensIntProc() {
        return idItensIntProc;
    }

    /**
     * @param idItensIntProc the idItensIntProc to set
     */
    public void setIdItensIntProc(int idItensIntProc) {
        this.idItensIntProc = idItensIntProc;
    }

    /**
     * @return the dataProc
     */
    public Date getDataProc() {
        return dataProc;
    }

    /**
     * @param dataProc the dataProc to set
     */
    public void setDataProc(Date dataProc) {
        this.dataProc = dataProc;
    }

    /**
     * @return the idProc
     */
    public int getIdProc() {
        return idProc;
    }

    /**
     * @param idProc the idProc to set
     */
    public void setIdProc(int idProc) {
        this.idProc = idProc;
    }

    /**
     * @return the idPav
     */
    public int getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(int idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the descricaoPavilhao
     */
    public String getDescricaoPavilhao() {
        return descricaoPavilhao;
    }

    /**
     * @param descricaoPavilhao the descricaoPavilhao to set
     */
    public void setDescricaoPavilhao(String descricaoPavilhao) {
        this.descricaoPavilhao = descricaoPavilhao;
    }

    /**
     * @return the idCela
     */
    public int getIdCela() {
        return idCela;
    }

    /**
     * @param idCela the idCela to set
     */
    public void setIdCela(int idCela) {
        this.idCela = idCela;
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
    public int getIdInternoCrc() {
        return idInternoCrc;
    }

    /**
     * @param idInternoCrc the idInternoCrc to set
     */
    public void setIdInternoCrc(int idInternoCrc) {
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
     * @return the usuarioInsert
     */
    public String getUsuarioInsert() {
        return usuarioInsert;
    }

    /**
     * @param usuarioInsert the usuarioInsert to set
     */
    public void setUsuarioInsert(String usuarioInsert) {
        this.usuarioInsert = usuarioInsert;
    }

    /**
     * @return the usuarioUp
     */
    public String getUsuarioUp() {
        return usuarioUp;
    }

    /**
     * @param usuarioUp the usuarioUp to set
     */
    public void setUsuarioUp(String usuarioUp) {
        this.usuarioUp = usuarioUp;
    }

    /**
     * @return the dataInsert
     */
    public String getDataInsert() {
        return dataInsert;
    }

    /**
     * @param dataInsert the dataInsert to set
     */
    public void setDataInsert(String dataInsert) {
        this.dataInsert = dataInsert;
    }

    /**
     * @return the dataUp
     */
    public String getDataUp() {
        return dataUp;
    }

    /**
     * @param dataUp the dataUp to set
     */
    public void setDataUp(String dataUp) {
        this.dataUp = dataUp;
    }

    /**
     * @return the horarioInsert
     */
    public String getHorarioInsert() {
        return horarioInsert;
    }

    /**
     * @param horarioInsert the horarioInsert to set
     */
    public void setHorarioInsert(String horarioInsert) {
        this.horarioInsert = horarioInsert;
    }

    /**
     * @return the horarioUp
     */
    public String getHorarioUp() {
        return horarioUp;
    }

    /**
     * @param horarioUp the horarioUp to set
     */
    public void setHorarioUp(String horarioUp) {
        this.horarioUp = horarioUp;
    }
}
