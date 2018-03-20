/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author user
 */
public class LocacaoInternos {

    private int idLoca;
    private String statusLoca;
    private Date dataLanca;
    private int idCela;
    private String descricaoCela;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;

    public LocacaoInternos(int idLoca, String statusLoca, Date dataLanca, int idCela, String descricaoCela, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp) {
        this.idLoca = idLoca;
        this.statusLoca = statusLoca;
        this.dataLanca = dataLanca;
        this.idCela = idCela;
        this.descricaoCela = descricaoCela;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
    }

    public LocacaoInternos() {
    }

    /**
     * @return the idLoca
     */
    public int getIdLoca() {
        return idLoca;
    }

    /**
     * @param idLoca the idLoca to set
     */
    public void setIdLoca(int idLoca) {
        this.idLoca = idLoca;
    }

    /**
     * @return the statusLoca
     */
    public String getStatusLoca() {
        return statusLoca;
    }

    /**
     * @param statusLoca the statusLoca to set
     */
    public void setStatusLoca(String statusLoca) {
        this.statusLoca = statusLoca;
    }

    /**
     * @return the dataLanca
     */
    public Date getDataLanca() {
        return dataLanca;
    }

    /**
     * @param dataLanca the dataLanca to set
     */
    public void setDataLanca(Date dataLanca) {
        this.dataLanca = dataLanca;
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
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
     * @return the horaInsert
     */
    public String getHoraInsert() {
        return horaInsert;
    }

    /**
     * @param horaInsert the horaInsert to set
     */
    public void setHoraInsert(String horaInsert) {
        this.horaInsert = horaInsert;
    }

    /**
     * @return the horaUp
     */
    public String getHoraUp() {
        return horaUp;
    }

    /**
     * @param horaUp the horaUp to set
     */
    public void setHoraUp(String horaUp) {
        this.horaUp = horaUp;
    }
}
