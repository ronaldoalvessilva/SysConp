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
public class MatriculaEscolar {

    private int idMat;
    private String statusMatricula;
    private Date dataMat;
    private int idInstituicao;
    private int idTempo;
    private int idCarga;
    private int idSala; 
    private String nomeIstituicao;
    private String descricaoTempoFormativo;
    private String descricaoCargaHoraria;
    private String descricaoSala;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;       

    public MatriculaEscolar(int idMat, String statusMatricula, Date dataMat, int idInstituicao, int idTempo, int idCarga, int idSala, String nomeIstituicao, String descricaoTempoFormativo, String descricaoCargaHoraria, String descricaoSala, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idMat = idMat;
        this.statusMatricula = statusMatricula;
        this.dataMat = dataMat;
        this.idInstituicao = idInstituicao;
        this.idTempo = idTempo;
        this.idCarga = idCarga;
        this.idSala = idSala;
        this.nomeIstituicao = nomeIstituicao;
        this.descricaoTempoFormativo = descricaoTempoFormativo;
        this.descricaoCargaHoraria = descricaoCargaHoraria;
        this.descricaoSala = descricaoSala;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public MatriculaEscolar() {
    }

    /**
     * @return the idMat
     */
    public int getIdMat() {
        return idMat;
    }

    /**
     * @param idMat the idMat to set
     */
    public void setIdMat(int idMat) {
        this.idMat = idMat;
    }

    /**
     * @return the statusMatricula
     */
    public String getStatusMatricula() {
        return statusMatricula;
    }

    /**
     * @param statusMatricula the statusMatricula to set
     */
    public void setStatusMatricula(String statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

    /**
     * @return the dataMat
     */
    public Date getDataMat() {
        return dataMat;
    }

    /**
     * @param dataMat the dataMat to set
     */
    public void setDataMat(Date dataMat) {
        this.dataMat = dataMat;
    }

    /**
     * @return the idInstituicao
     */
    public int getIdInstituicao() {
        return idInstituicao;
    }

    /**
     * @param idInstituicao the idInstituicao to set
     */
    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    /**
     * @return the idTempo
     */
    public int getIdTempo() {
        return idTempo;
    }

    /**
     * @param idTempo the idTempo to set
     */
    public void setIdTempo(int idTempo) {
        this.idTempo = idTempo;
    }

    /**
     * @return the idCarga
     */
    public int getIdCarga() {
        return idCarga;
    }

    /**
     * @param idCarga the idCarga to set
     */
    public void setIdCarga(int idCarga) {
        this.idCarga = idCarga;
    }

    /**
     * @return the idSala
     */
    public int getIdSala() {
        return idSala;
    }

    /**
     * @param idSala the idSala to set
     */
    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    /**
     * @return the nomeIstituicao
     */
    public String getNomeIstituicao() {
        return nomeIstituicao;
    }

    /**
     * @param nomeIstituicao the nomeIstituicao to set
     */
    public void setNomeIstituicao(String nomeIstituicao) {
        this.nomeIstituicao = nomeIstituicao;
    }

    /**
     * @return the descricaoTempoFormativo
     */
    public String getDescricaoTempoFormativo() {
        return descricaoTempoFormativo;
    }

    /**
     * @param descricaoTempoFormativo the descricaoTempoFormativo to set
     */
    public void setDescricaoTempoFormativo(String descricaoTempoFormativo) {
        this.descricaoTempoFormativo = descricaoTempoFormativo;
    }

    /**
     * @return the descricaoCargaHoraria
     */
    public String getDescricaoCargaHoraria() {
        return descricaoCargaHoraria;
    }

    /**
     * @param descricaoCargaHoraria the descricaoCargaHoraria to set
     */
    public void setDescricaoCargaHoraria(String descricaoCargaHoraria) {
        this.descricaoCargaHoraria = descricaoCargaHoraria;
    }

    /**
     * @return the descricaoSala
     */
    public String getDescricaoSala() {
        return descricaoSala;
    }

    /**
     * @param descricaoSala the descricaoSala to set
     */
    public void setDescricaoSala(String descricaoSala) {
        this.descricaoSala = descricaoSala;
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
