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
public class SolicitacaoAtestadoReclusao {

    private int codRegAux;
    private String statusAux;
    private String finalidade;
    private Date dataRegAux;
    private Date dataPedAux;
    private Date dataPrevAux;
    private int idVisitaAux;
    private String nomeVisitaSolicitanteAux;
    private int idInternoAux;
    private String nomeInternoCrc;
    private String cnc;
    private String regimePenal;
    private String nomeMaeInterno;
    private String motivoAux;
    private byte[] assinaturaVisita;
    private byte[] assinaturaInterno;
    private Date dataAssinatura;
    private String horaAssinatura;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public SolicitacaoAtestadoReclusao() {
    }

    public SolicitacaoAtestadoReclusao(int codRegAux, String statusAux, String finalidade, Date dataRegAux, Date dataPedAux, Date dataPrevAux, int idVisitaAux, String nomeVisitaSolicitanteAux, int idInternoAux, String nomeInternoCrc, String cnc, String regimePenal, String nomeMaeInterno, String motivoAux, byte[] assinaturaVisita, byte[] assinaturaInterno, Date dataAssinatura, String horaAssinatura, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.codRegAux = codRegAux;
        this.statusAux = statusAux;
        this.finalidade = finalidade;
        this.dataRegAux = dataRegAux;
        this.dataPedAux = dataPedAux;
        this.dataPrevAux = dataPrevAux;
        this.idVisitaAux = idVisitaAux;
        this.nomeVisitaSolicitanteAux = nomeVisitaSolicitanteAux;
        this.idInternoAux = idInternoAux;
        this.nomeInternoCrc = nomeInternoCrc;
        this.cnc = cnc;
        this.regimePenal = regimePenal;
        this.nomeMaeInterno = nomeMaeInterno;
        this.motivoAux = motivoAux;
        this.assinaturaVisita = assinaturaVisita;
        this.assinaturaInterno = assinaturaInterno;
        this.dataAssinatura = dataAssinatura;
        this.horaAssinatura = horaAssinatura;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the codRegAux
     */
    public int getCodRegAux() {
        return codRegAux;
    }

    /**
     * @param codRegAux the codRegAux to set
     */
    public void setCodRegAux(int codRegAux) {
        this.codRegAux = codRegAux;
    }

    /**
     * @return the statusAux
     */
    public String getStatusAux() {
        return statusAux;
    }

    /**
     * @param statusAux the statusAux to set
     */
    public void setStatusAux(String statusAux) {
        this.statusAux = statusAux;
    }

    /**
     * @return the finalidade
     */
    public String getFinalidade() {
        return finalidade;
    }

    /**
     * @param finalidade the finalidade to set
     */
    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    /**
     * @return the dataRegAux
     */
    public Date getDataRegAux() {
        return dataRegAux;
    }

    /**
     * @param dataRegAux the dataRegAux to set
     */
    public void setDataRegAux(Date dataRegAux) {
        this.dataRegAux = dataRegAux;
    }

    /**
     * @return the dataPedAux
     */
    public Date getDataPedAux() {
        return dataPedAux;
    }

    /**
     * @param dataPedAux the dataPedAux to set
     */
    public void setDataPedAux(Date dataPedAux) {
        this.dataPedAux = dataPedAux;
    }

    /**
     * @return the dataPrevAux
     */
    public Date getDataPrevAux() {
        return dataPrevAux;
    }

    /**
     * @param dataPrevAux the dataPrevAux to set
     */
    public void setDataPrevAux(Date dataPrevAux) {
        this.dataPrevAux = dataPrevAux;
    }

    /**
     * @return the idVisitaAux
     */
    public int getIdVisitaAux() {
        return idVisitaAux;
    }

    /**
     * @param idVisitaAux the idVisitaAux to set
     */
    public void setIdVisitaAux(int idVisitaAux) {
        this.idVisitaAux = idVisitaAux;
    }

    /**
     * @return the nomeVisitaSolicitanteAux
     */
    public String getNomeVisitaSolicitanteAux() {
        return nomeVisitaSolicitanteAux;
    }

    /**
     * @param nomeVisitaSolicitanteAux the nomeVisitaSolicitanteAux to set
     */
    public void setNomeVisitaSolicitanteAux(String nomeVisitaSolicitanteAux) {
        this.nomeVisitaSolicitanteAux = nomeVisitaSolicitanteAux;
    }

    /**
     * @return the idInternoAux
     */
    public int getIdInternoAux() {
        return idInternoAux;
    }

    /**
     * @param idInternoAux the idInternoAux to set
     */
    public void setIdInternoAux(int idInternoAux) {
        this.idInternoAux = idInternoAux;
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
     * @return the cnc
     */
    public String getCnc() {
        return cnc;
    }

    /**
     * @param cnc the cnc to set
     */
    public void setCnc(String cnc) {
        this.cnc = cnc;
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
     * @return the nomeMaeInterno
     */
    public String getNomeMaeInterno() {
        return nomeMaeInterno;
    }

    /**
     * @param nomeMaeInterno the nomeMaeInterno to set
     */
    public void setNomeMaeInterno(String nomeMaeInterno) {
        this.nomeMaeInterno = nomeMaeInterno;
    }

    /**
     * @return the motivoAux
     */
    public String getMotivoAux() {
        return motivoAux;
    }

    /**
     * @param motivoAux the motivoAux to set
     */
    public void setMotivoAux(String motivoAux) {
        this.motivoAux = motivoAux;
    }

    /**
     * @return the assinaturaVisita
     */
    public byte[] getAssinaturaVisita() {
        return assinaturaVisita;
    }

    /**
     * @param assinaturaVisita the assinaturaVisita to set
     */
    public void setAssinaturaVisita(byte[] assinaturaVisita) {
        this.assinaturaVisita = assinaturaVisita;
    }

    /**
     * @return the assinaturaInterno
     */
    public byte[] getAssinaturaInterno() {
        return assinaturaInterno;
    }

    /**
     * @param assinaturaInterno the assinaturaInterno to set
     */
    public void setAssinaturaInterno(byte[] assinaturaInterno) {
        this.assinaturaInterno = assinaturaInterno;
    }

    /**
     * @return the dataAssinatura
     */
    public Date getDataAssinatura() {
        return dataAssinatura;
    }

    /**
     * @param dataAssinatura the dataAssinatura to set
     */
    public void setDataAssinatura(Date dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }

    /**
     * @return the horaAssinatura
     */
    public String getHoraAssinatura() {
        return horaAssinatura;
    }

    /**
     * @param horaAssinatura the horaAssinatura to set
     */
    public void setHoraAssinatura(String horaAssinatura) {
        this.horaAssinatura = horaAssinatura;
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
