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
public class AtendimentoInternoSocial {

    private int idLanc;
    private String statusLanc;
    private Date dataLanc;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String pedidoRec;
    private Date dataPedRec;
    private String encaSetor;
    private String qualSetor;
    private String encaTirarDoc;
    private Date dataTirarDoc;
    private String encaRecPai;
    private Date dataRecPai;
    private String cancelaVisita;
    private String motivoCancelVisita;
    private String outros;
    private String observacao;
    private String deptoSocial;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;        

    public AtendimentoInternoSocial(int idLanc, String statusLanc, Date dataLanc, int idInternoCrc, String nomeInternoCrc, String pedidoRec, Date dataPedRec, String encaSetor, String qualSetor, String encaTirarDoc, Date dataTirarDoc, String encaRecPai, Date dataRecPai, String cancelaVisita, String motivoCancelVisita, String outros, String observacao, String deptoSocial, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp) {
        this.idLanc = idLanc;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.pedidoRec = pedidoRec;
        this.dataPedRec = dataPedRec;
        this.encaSetor = encaSetor;
        this.qualSetor = qualSetor;
        this.encaTirarDoc = encaTirarDoc;
        this.dataTirarDoc = dataTirarDoc;
        this.encaRecPai = encaRecPai;
        this.dataRecPai = dataRecPai;
        this.cancelaVisita = cancelaVisita;
        this.motivoCancelVisita = motivoCancelVisita;
        this.outros = outros;
        this.observacao = observacao;
        this.deptoSocial = deptoSocial;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AtendimentoInternoSocial() {
    }

    /**
     * @return the idLanc
     */
    public int getIdLanc() {
        return idLanc;
    }

    /**
     * @param idLanc the idLanc to set
     */
    public void setIdLanc(int idLanc) {
        this.idLanc = idLanc;
    }

    /**
     * @return the statusLanc
     */
    public String getStatusLanc() {
        return statusLanc;
    }

    /**
     * @param statusLanc the statusLanc to set
     */
    public void setStatusLanc(String statusLanc) {
        this.statusLanc = statusLanc;
    }

    /**
     * @return the dataLanc
     */
    public Date getDataLanc() {
        return dataLanc;
    }

    /**
     * @param dataLanc the dataLanc to set
     */
    public void setDataLanc(Date dataLanc) {
        this.dataLanc = dataLanc;
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
     * @return the pedidoRec
     */
    public String getPedidoRec() {
        return pedidoRec;
    }

    /**
     * @param pedidoRec the pedidoRec to set
     */
    public void setPedidoRec(String pedidoRec) {
        this.pedidoRec = pedidoRec;
    }

    /**
     * @return the dataPedRec
     */
    public Date getDataPedRec() {
        return dataPedRec;
    }

    /**
     * @param dataPedRec the dataPedRec to set
     */
    public void setDataPedRec(Date dataPedRec) {
        this.dataPedRec = dataPedRec;
    }

    /**
     * @return the encaSetor
     */
    public String getEncaSetor() {
        return encaSetor;
    }

    /**
     * @param encaSetor the encaSetor to set
     */
    public void setEncaSetor(String encaSetor) {
        this.encaSetor = encaSetor;
    }

    /**
     * @return the qualSetor
     */
    public String getQualSetor() {
        return qualSetor;
    }

    /**
     * @param qualSetor the qualSetor to set
     */
    public void setQualSetor(String qualSetor) {
        this.qualSetor = qualSetor;
    }

    /**
     * @return the encaTirarDoc
     */
    public String getEncaTirarDoc() {
        return encaTirarDoc;
    }

    /**
     * @param encaTirarDoc the encaTirarDoc to set
     */
    public void setEncaTirarDoc(String encaTirarDoc) {
        this.encaTirarDoc = encaTirarDoc;
    }

    /**
     * @return the dataTirarDoc
     */
    public Date getDataTirarDoc() {
        return dataTirarDoc;
    }

    /**
     * @param dataTirarDoc the dataTirarDoc to set
     */
    public void setDataTirarDoc(Date dataTirarDoc) {
        this.dataTirarDoc = dataTirarDoc;
    }

    /**
     * @return the encaRecPai
     */
    public String getEncaRecPai() {
        return encaRecPai;
    }

    /**
     * @param encaRecPai the encaRecPai to set
     */
    public void setEncaRecPai(String encaRecPai) {
        this.encaRecPai = encaRecPai;
    }

    /**
     * @return the dataRecPai
     */
    public Date getDataRecPai() {
        return dataRecPai;
    }

    /**
     * @param dataRecPai the dataRecPai to set
     */
    public void setDataRecPai(Date dataRecPai) {
        this.dataRecPai = dataRecPai;
    }

    /**
     * @return the cancelaVisita
     */
    public String getCancelaVisita() {
        return cancelaVisita;
    }

    /**
     * @param cancelaVisita the cancelaVisita to set
     */
    public void setCancelaVisita(String cancelaVisita) {
        this.cancelaVisita = cancelaVisita;
    }

    /**
     * @return the motivoCancelVisita
     */
    public String getMotivoCancelVisita() {
        return motivoCancelVisita;
    }

    /**
     * @param motivoCancelVisita the motivoCancelVisita to set
     */
    public void setMotivoCancelVisita(String motivoCancelVisita) {
        this.motivoCancelVisita = motivoCancelVisita;
    }

    /**
     * @return the outros
     */
    public String getOutros() {
        return outros;
    }

    /**
     * @param outros the outros to set
     */
    public void setOutros(String outros) {
        this.outros = outros;
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
     * @return the deptoSocial
     */
    public String getDeptoSocial() {
        return deptoSocial;
    }

    /**
     * @param deptoSocial the deptoSocial to set
     */
    public void setDeptoSocial(String deptoSocial) {
        this.deptoSocial = deptoSocial;
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
     * @return the usuarioDelete
     */
    public String getUsuarioDelete() {
        return usuarioDelete;
    }

    /**
     * @param usuarioDelete the usuarioDelete to set
     */
    public void setUsuarioDelete(String usuarioDelete) {
        this.usuarioDelete = usuarioDelete;
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
     * @return the dataDelete
     */
    public String getDataDelete() {
        return dataDelete;
    }

    /**
     * @param dataDelete the dataDelete to set
     */
    public void setDataDelete(String dataDelete) {
        this.dataDelete = dataDelete;
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
