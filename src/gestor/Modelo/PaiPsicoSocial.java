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
public class PaiPsicoSocial {

    private int idPai;
    private String statusPai;
    private Date dataPai;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int idadeInterno;
    private String OrientacaoSexual;
    private String dadosPessoais;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public PaiPsicoSocial(int idPai, String statusPai, Date dataPai, int idInternoCrc, String nomeInternoCrc, int idadeInterno, String OrientacaoSexual, String dadosPessoais, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idPai = idPai;
        this.statusPai = statusPai;
        this.dataPai = dataPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idadeInterno = idadeInterno;
        this.OrientacaoSexual = OrientacaoSexual;
        this.dadosPessoais = dadosPessoais;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public PaiPsicoSocial() {
    }

    /**
     * @return the idPai
     */
    public int getIdPai() {
        return idPai;
    }

    /**
     * @param idPai the idPai to set
     */
    public void setIdPai(int idPai) {
        this.idPai = idPai;
    }

    /**
     * @return the statusPai
     */
    public String getStatusPai() {
        return statusPai;
    }

    /**
     * @param statusPai the statusPai to set
     */
    public void setStatusPai(String statusPai) {
        this.statusPai = statusPai;
    }

    /**
     * @return the dataPai
     */
    public Date getDataPai() {
        return dataPai;
    }

    /**
     * @param dataPai the dataPai to set
     */
    public void setDataPai(Date dataPai) {
        this.dataPai = dataPai;
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
     * @return the idadeInterno
     */
    public int getIdadeInterno() {
        return idadeInterno;
    }

    /**
     * @param idadeInterno the idadeInterno to set
     */
    public void setIdadeInterno(int idadeInterno) {
        this.idadeInterno = idadeInterno;
    }

    /**
     * @return the OrientacaoSexual
     */
    public String getOrientacaoSexual() {
        return OrientacaoSexual;
    }

    /**
     * @param OrientacaoSexual the OrientacaoSexual to set
     */
    public void setOrientacaoSexual(String OrientacaoSexual) {
        this.OrientacaoSexual = OrientacaoSexual;
    }

    /**
     * @return the dadosPessoais
     */
    public String getDadosPessoais() {
        return dadosPessoais;
    }

    /**
     * @param dadosPessoais the dadosPessoais to set
     */
    public void setDadosPessoais(String dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
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
