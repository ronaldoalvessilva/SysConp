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
public class RegistroChegadaVisitaPortariaExterna {

    private int idRegVisita;
    private String statusReg;
    private Date DataReg;
    private int idVisita;
    private int idRol;
    private String nomeVisita;
    private int idInternoCrc;
    private String nomeInterno;
    private Date dataChegada;
    private String horaChegada;
    private byte[] assinaturaDigitalVisita;
    private int tipoAssinatura;
    private String motivoNaoAssinarDigital;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private int tipoOperacao;
    private int ordemChegadaVisita;

    public RegistroChegadaVisitaPortariaExterna() {
    }

    public RegistroChegadaVisitaPortariaExterna(int idRegVisita, String statusReg, Date DataReg, int idVisita, int idRol, String nomeVisita, int idInternoCrc, String nomeInterno, Date dataChegada, String horaChegada, byte[] assinaturaDigitalVisita, int tipoAssinatura, String motivoNaoAssinarDigital, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, int tipoOperacao, int ordemChegadaVisita) {
        this.idRegVisita = idRegVisita;
        this.statusReg = statusReg;
        this.DataReg = DataReg;
        this.idVisita = idVisita;
        this.idRol = idRol;
        this.nomeVisita = nomeVisita;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.dataChegada = dataChegada;
        this.horaChegada = horaChegada;
        this.assinaturaDigitalVisita = assinaturaDigitalVisita;
        this.tipoAssinatura = tipoAssinatura;
        this.motivoNaoAssinarDigital = motivoNaoAssinarDigital;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.tipoOperacao = tipoOperacao;
        this.ordemChegadaVisita = ordemChegadaVisita;
    }

    /**
     * @return the idRegVisita
     */
    public int getIdRegVisita() {
        return idRegVisita;
    }

    /**
     * @param idRegVisita the idRegVisita to set
     */
    public void setIdRegVisita(int idRegVisita) {
        this.idRegVisita = idRegVisita;
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
     * @return the DataReg
     */
    public Date getDataReg() {
        return DataReg;
    }

    /**
     * @param DataReg the DataReg to set
     */
    public void setDataReg(Date DataReg) {
        this.DataReg = DataReg;
    }

    /**
     * @return the idVisita
     */
    public int getIdVisita() {
        return idVisita;
    }

    /**
     * @param idVisita the idVisita to set
     */
    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    /**
     * @return the idRol
     */
    public int getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the nomeVisita
     */
    public String getNomeVisita() {
        return nomeVisita;
    }

    /**
     * @param nomeVisita the nomeVisita to set
     */
    public void setNomeVisita(String nomeVisita) {
        this.nomeVisita = nomeVisita;
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
     * @return the dataChegada
     */
    public Date getDataChegada() {
        return dataChegada;
    }

    /**
     * @param dataChegada the dataChegada to set
     */
    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    /**
     * @return the horaChegada
     */
    public String getHoraChegada() {
        return horaChegada;
    }

    /**
     * @param horaChegada the horaChegada to set
     */
    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
    }

    /**
     * @return the assinaturaDigitalVisita
     */
    public byte[] getAssinaturaDigitalVisita() {
        return assinaturaDigitalVisita;
    }

    /**
     * @param assinaturaDigitalVisita the assinaturaDigitalVisita to set
     */
    public void setAssinaturaDigitalVisita(byte[] assinaturaDigitalVisita) {
        this.assinaturaDigitalVisita = assinaturaDigitalVisita;
    }

    /**
     * @return the tipoAssinatura
     */
    public int getTipoAssinatura() {
        return tipoAssinatura;
    }

    /**
     * @param tipoAssinatura the tipoAssinatura to set
     */
    public void setTipoAssinatura(int tipoAssinatura) {
        this.tipoAssinatura = tipoAssinatura;
    }

    /**
     * @return the motivoNaoAssinarDigital
     */
    public String getMotivoNaoAssinarDigital() {
        return motivoNaoAssinarDigital;
    }

    /**
     * @param motivoNaoAssinarDigital the motivoNaoAssinarDigital to set
     */
    public void setMotivoNaoAssinarDigital(String motivoNaoAssinarDigital) {
        this.motivoNaoAssinarDigital = motivoNaoAssinarDigital;
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
     * @return the tipoOperacao
     */
    public int getTipoOperacao() {
        return tipoOperacao;
    }

    /**
     * @param tipoOperacao the tipoOperacao to set
     */
    public void setTipoOperacao(int tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    /**
     * @return the ordemChegadaVisita
     */
    public int getOrdemChegadaVisita() {
        return ordemChegadaVisita;
    }

    /**
     * @param ordemChegadaVisita the ordemChegadaVisita to set
     */
    public void setOrdemChegadaVisita(int ordemChegadaVisita) {
        this.ordemChegadaVisita = ordemChegadaVisita;
    }

}
