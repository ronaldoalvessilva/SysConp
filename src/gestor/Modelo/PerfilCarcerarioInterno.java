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
public class PerfilCarcerarioInterno {

    private int idPerfil;
    private String statusPerfil;
    private Date dataPerfil;
    private int idInternoCrc;
    private String nomeInternoPerfil;
    private String opcaoSexual;
    private int anoNascimento;
    private int anoReferencia;
    private String observacaoPerfil;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;       

    public PerfilCarcerarioInterno(int idPerfil, String statusPerfil, Date dataPerfil, int idInternoCrc, String nomeInternoPerfil, String opcaoSexual, int anoNascimento, int anoReferencia, String observacaoPerfil, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idPerfil = idPerfil;
        this.statusPerfil = statusPerfil;
        this.dataPerfil = dataPerfil;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoPerfil = nomeInternoPerfil;
        this.opcaoSexual = opcaoSexual;
        this.anoNascimento = anoNascimento;
        this.anoReferencia = anoReferencia;
        this.observacaoPerfil = observacaoPerfil;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public PerfilCarcerarioInterno() {
    }

    /**
     * @return the idPerfil
     */
    public int getIdPerfil() {
        return idPerfil;
    }

    /**
     * @param idPerfil the idPerfil to set
     */
    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    /**
     * @return the statusPerfil
     */
    public String getStatusPerfil() {
        return statusPerfil;
    }

    /**
     * @param statusPerfil the statusPerfil to set
     */
    public void setStatusPerfil(String statusPerfil) {
        this.statusPerfil = statusPerfil;
    }

    /**
     * @return the dataPerfil
     */
    public Date getDataPerfil() {
        return dataPerfil;
    }

    /**
     * @param dataPerfil the dataPerfil to set
     */
    public void setDataPerfil(Date dataPerfil) {
        this.dataPerfil = dataPerfil;
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
     * @return the nomeInternoPerfil
     */
    public String getNomeInternoPerfil() {
        return nomeInternoPerfil;
    }

    /**
     * @param nomeInternoPerfil the nomeInternoPerfil to set
     */
    public void setNomeInternoPerfil(String nomeInternoPerfil) {
        this.nomeInternoPerfil = nomeInternoPerfil;
    }

    /**
     * @return the opcaoSexual
     */
    public String getOpcaoSexual() {
        return opcaoSexual;
    }

    /**
     * @param opcaoSexual the opcaoSexual to set
     */
    public void setOpcaoSexual(String opcaoSexual) {
        this.opcaoSexual = opcaoSexual;
    }

    /**
     * @return the anoNascimento
     */
    public int getAnoNascimento() {
        return anoNascimento;
    }

    /**
     * @param anoNascimento the anoNascimento to set
     */
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    /**
     * @return the anoReferencia
     */
    public int getAnoReferencia() {
        return anoReferencia;
    }

    /**
     * @param anoReferencia the anoReferencia to set
     */
    public void setAnoReferencia(int anoReferencia) {
        this.anoReferencia = anoReferencia;
    }

    /**
     * @return the observacaoPerfil
     */
    public String getObservacaoPerfil() {
        return observacaoPerfil;
    }

    /**
     * @param observacaoPerfil the observacaoPerfil to set
     */
    public void setObservacaoPerfil(String observacaoPerfil) {
        this.observacaoPerfil = observacaoPerfil;
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
