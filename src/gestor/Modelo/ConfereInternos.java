/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronal
 */
public class ConfereInternos {

    private Integer idConfere;
    private Integer idInternoCrc;
    private String nomeInternoCrc;
    private Date dataConfere;
    private String horarioConfere;
    private byte[] assinaturaBiometricaInterno;
    private Integer idPav;
    private String nomePavilhao;
    private Integer idCela;
    private String nomeCela;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private String dataRealizacao;

    public ConfereInternos(Integer idConfere, Integer idInternoCrc, String nomeInternoCrc, Date dataConfere, String horarioConfere, byte[] assinaturaBiometricaInterno, Integer idPav, String nomePavilhao, Integer idCela, String nomeCela, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String dataRealizacao) {
        this.idConfere = idConfere;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.dataConfere = dataConfere;
        this.horarioConfere = horarioConfere;
        this.assinaturaBiometricaInterno = assinaturaBiometricaInterno;
        this.idPav = idPav;
        this.nomePavilhao = nomePavilhao;
        this.idCela = idCela;
        this.nomeCela = nomeCela;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.dataRealizacao = dataRealizacao;
    }

    public ConfereInternos() {
    }

    /**
     * @return the idConfere
     */
    public Integer getIdConfere() {
        return idConfere;
    }

    /**
     * @param idConfere the idConfere to set
     */
    public void setIdConfere(Integer idConfere) {
        this.idConfere = idConfere;
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
     * @return the dataConfere
     */
    public Date getDataConfere() {
        return dataConfere;
    }

    /**
     * @param dataConfere the dataConfere to set
     */
    public void setDataConfere(Date dataConfere) {
        this.dataConfere = dataConfere;
    }

    /**
     * @return the horarioConfere
     */
    public String getHorarioConfere() {
        return horarioConfere;
    }

    /**
     * @param horarioConfere the horarioConfere to set
     */
    public void setHorarioConfere(String horarioConfere) {
        this.horarioConfere = horarioConfere;
    }

    /**
     * @return the assinaturaBiometricaInterno
     */
    public byte[] getAssinaturaBiometricaInterno() {
        return assinaturaBiometricaInterno;
    }

    /**
     * @param assinaturaBiometricaInterno the assinaturaBiometricaInterno to set
     */
    public void setAssinaturaBiometricaInterno(byte[] assinaturaBiometricaInterno) {
        this.assinaturaBiometricaInterno = assinaturaBiometricaInterno;
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
     * @return the nomePavilhao
     */
    public String getNomePavilhao() {
        return nomePavilhao;
    }

    /**
     * @param nomePavilhao the nomePavilhao to set
     */
    public void setNomePavilhao(String nomePavilhao) {
        this.nomePavilhao = nomePavilhao;
    }

    /**
     * @return the idCela
     */
    public Integer getIdCela() {
        return idCela;
    }

    /**
     * @param idCela the idCela to set
     */
    public void setIdCela(Integer idCela) {
        this.idCela = idCela;
    }

    /**
     * @return the nomeCela
     */
    public String getNomeCela() {
        return nomeCela;
    }

    /**
     * @param nomeCela the nomeCela to set
     */
    public void setNomeCela(String nomeCela) {
        this.nomeCela = nomeCela;
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

    /**
     * @return the dataRealizacao
     */
    public String getDataRealizacao() {
        return dataRealizacao;
    }

    /**
     * @param dataRealizacao the dataRealizacao to set
     */
    public void setDataRealizacao(String dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
}
