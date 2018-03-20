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
public class RegistroIndisciplinarPortaria {

    private int IdReg;
    private String statusReg;
    private String tipoVisita;
    private String tipoOcorrencia;
    private Date dataReg;
    private int idInternoCrc;
    private String nomeInterno;
    private String statusAprovacao;
    private Date dataAprovacao;
    private Date dataAprovacao1;
    private String usuarioAprovador;
    private String usuarioAprovador1;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;       

    public RegistroIndisciplinarPortaria(int IdReg, String statusReg, String tipoVisita, String tipoOcorrencia, Date dataReg, int idInternoCrc, String nomeInterno, String statusAprovacao, Date dataAprovacao, Date dataAprovacao1, String usuarioAprovador, String usuarioAprovador1, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.IdReg = IdReg;
        this.statusReg = statusReg;
        this.tipoVisita = tipoVisita;
        this.tipoOcorrencia = tipoOcorrencia;
        this.dataReg = dataReg;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.statusAprovacao = statusAprovacao;
        this.dataAprovacao = dataAprovacao;
        this.dataAprovacao1 = dataAprovacao1;
        this.usuarioAprovador = usuarioAprovador;
        this.usuarioAprovador1 = usuarioAprovador1;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public RegistroIndisciplinarPortaria() {
    }

    /**
     * @return the IdReg
     */
    public int getIdReg() {
        return IdReg;
    }

    /**
     * @param IdReg the IdReg to set
     */
    public void setIdReg(int IdReg) {
        this.IdReg = IdReg;
    }

    /**
     * @return the statusReg
     */
    public String getStatusReg() {
        return statusReg;
    }

    /**
     * @param statusReg the statusReg to set
     */
    public void setStatusReg(String statusReg) {
        this.statusReg = statusReg;
    }

    /**
     * @return the tipoVisita
     */
    public String getTipoVisita() {
        return tipoVisita;
    }

    /**
     * @param tipoVisita the tipoVisita to set
     */
    public void setTipoVisita(String tipoVisita) {
        this.tipoVisita = tipoVisita;
    }

    /**
     * @return the tipoOcorrencia
     */
    public String getTipoOcorrencia() {
        return tipoOcorrencia;
    }

    /**
     * @param tipoOcorrencia the tipoOcorrencia to set
     */
    public void setTipoOcorrencia(String tipoOcorrencia) {
        this.tipoOcorrencia = tipoOcorrencia;
    }

    /**
     * @return the dataReg
     */
    public Date getDataReg() {
        return dataReg;
    }

    /**
     * @param dataReg the dataReg to set
     */
    public void setDataReg(Date dataReg) {
        this.dataReg = dataReg;
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
     * @return the nomeInterno
     */
    public String getNomeInterno() {
        return nomeInterno;
    }

    /**
     * @param nomeInterno the nomeInterno to set
     */
    public void setNomeInterno(String nomeInterno) {
        this.nomeInterno = nomeInterno;
    }

    /**
     * @return the statusAprovacao
     */
    public String getStatusAprovacao() {
        return statusAprovacao;
    }

    /**
     * @param statusAprovacao the statusAprovacao to set
     */
    public void setStatusAprovacao(String statusAprovacao) {
        this.statusAprovacao = statusAprovacao;
    }

    /**
     * @return the dataAprovacao
     */
    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    /**
     * @param dataAprovacao the dataAprovacao to set
     */
    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    /**
     * @return the dataAprovacao1
     */
    public Date getDataAprovacao1() {
        return dataAprovacao1;
    }

    /**
     * @param dataAprovacao1 the dataAprovacao1 to set
     */
    public void setDataAprovacao1(Date dataAprovacao1) {
        this.dataAprovacao1 = dataAprovacao1;
    }

    /**
     * @return the usuarioAprovador
     */
    public String getUsuarioAprovador() {
        return usuarioAprovador;
    }

    /**
     * @param usuarioAprovador the usuarioAprovador to set
     */
    public void setUsuarioAprovador(String usuarioAprovador) {
        this.usuarioAprovador = usuarioAprovador;
    }

    /**
     * @return the usuarioAprovador1
     */
    public String getUsuarioAprovador1() {
        return usuarioAprovador1;
    }

    /**
     * @param usuarioAprovador1 the usuarioAprovador1 to set
     */
    public void setUsuarioAprovador1(String usuarioAprovador1) {
        this.usuarioAprovador1 = usuarioAprovador1;
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
