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
public class AtendimentoFemininoP1 {

    private int idAfp1;
    private int idLanc;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String hipertensao;
    private String cardiopatias;
    private String anemias;
    private String doencasRenais;
    private String diabetes;
    private String aPAlergias;
    private String portadorHIV;
    private String transfusao;
    private String retroviarias;
    private String quaisRetroviarias;
    private String cirurgias;
    private Date dataCirurgia;
    private String tipoCirurgia;
    private String ciclos;
    private String metodos;
    private String doencas;
    private String colpocitologia;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public AtendimentoFemininoP1(int idAfp1, int idLanc, int idInternoCrc, String nomeInternoCrc, String hipertensao, String cardiopatias, String anemias, String doencasRenais, String diabetes, String aPAlergias, String portadorHIV, String transfusao, String retroviarias, String quaisRetroviarias, String cirurgias, Date dataCirurgia, String tipoCirurgia, String ciclos, String metodos, String doencas, String colpocitologia, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idAfp1 = idAfp1;
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.hipertensao = hipertensao;
        this.cardiopatias = cardiopatias;
        this.anemias = anemias;
        this.doencasRenais = doencasRenais;
        this.diabetes = diabetes;
        this.aPAlergias = aPAlergias;
        this.portadorHIV = portadorHIV;
        this.transfusao = transfusao;
        this.retroviarias = retroviarias;
        this.quaisRetroviarias = quaisRetroviarias;
        this.cirurgias = cirurgias;
        this.dataCirurgia = dataCirurgia;
        this.tipoCirurgia = tipoCirurgia;
        this.ciclos = ciclos;
        this.metodos = metodos;
        this.doencas = doencas;
        this.colpocitologia = colpocitologia;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AtendimentoFemininoP1() {
    }

    /**
     * @return the idAfp1
     */
    public int getIdAfp1() {
        return idAfp1;
    }

    /**
     * @param idAfp1 the idAfp1 to set
     */
    public void setIdAfp1(int idAfp1) {
        this.idAfp1 = idAfp1;
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
     * @return the hipertensao
     */
    public String getHipertensao() {
        return hipertensao;
    }

    /**
     * @param hipertensao the hipertensao to set
     */
    public void setHipertensao(String hipertensao) {
        this.hipertensao = hipertensao;
    }

    /**
     * @return the cardiopatias
     */
    public String getCardiopatias() {
        return cardiopatias;
    }

    /**
     * @param cardiopatias the cardiopatias to set
     */
    public void setCardiopatias(String cardiopatias) {
        this.cardiopatias = cardiopatias;
    }

    /**
     * @return the anemias
     */
    public String getAnemias() {
        return anemias;
    }

    /**
     * @param anemias the anemias to set
     */
    public void setAnemias(String anemias) {
        this.anemias = anemias;
    }

    /**
     * @return the doencasRenais
     */
    public String getDoencasRenais() {
        return doencasRenais;
    }

    /**
     * @param doencasRenais the doencasRenais to set
     */
    public void setDoencasRenais(String doencasRenais) {
        this.doencasRenais = doencasRenais;
    }

    /**
     * @return the diabetes
     */
    public String getDiabetes() {
        return diabetes;
    }

    /**
     * @param diabetes the diabetes to set
     */
    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    /**
     * @return the aPAlergias
     */
    public String getaPAlergias() {
        return aPAlergias;
    }

    /**
     * @param aPAlergias the aPAlergias to set
     */
    public void setaPAlergias(String aPAlergias) {
        this.aPAlergias = aPAlergias;
    }

    /**
     * @return the portadorHIV
     */
    public String getPortadorHIV() {
        return portadorHIV;
    }

    /**
     * @param portadorHIV the portadorHIV to set
     */
    public void setPortadorHIV(String portadorHIV) {
        this.portadorHIV = portadorHIV;
    }

    /**
     * @return the transfusao
     */
    public String getTransfusao() {
        return transfusao;
    }

    /**
     * @param transfusao the transfusao to set
     */
    public void setTransfusao(String transfusao) {
        this.transfusao = transfusao;
    }

    /**
     * @return the retroviarias
     */
    public String getRetroviarias() {
        return retroviarias;
    }

    /**
     * @param retroviarias the retroviarias to set
     */
    public void setRetroviarias(String retroviarias) {
        this.retroviarias = retroviarias;
    }

    /**
     * @return the quaisRetroviarias
     */
    public String getQuaisRetroviarias() {
        return quaisRetroviarias;
    }

    /**
     * @param quaisRetroviarias the quaisRetroviarias to set
     */
    public void setQuaisRetroviarias(String quaisRetroviarias) {
        this.quaisRetroviarias = quaisRetroviarias;
    }

    /**
     * @return the cirurgias
     */
    public String getCirurgias() {
        return cirurgias;
    }

    /**
     * @param cirurgias the cirurgias to set
     */
    public void setCirurgias(String cirurgias) {
        this.cirurgias = cirurgias;
    }

    /**
     * @return the dataCirurgia
     */
    public Date getDataCirurgia() {
        return dataCirurgia;
    }

    /**
     * @param dataCirurgia the dataCirurgia to set
     */
    public void setDataCirurgia(Date dataCirurgia) {
        this.dataCirurgia = dataCirurgia;
    }

    /**
     * @return the tipoCirurgia
     */
    public String getTipoCirurgia() {
        return tipoCirurgia;
    }

    /**
     * @param tipoCirurgia the tipoCirurgia to set
     */
    public void setTipoCirurgia(String tipoCirurgia) {
        this.tipoCirurgia = tipoCirurgia;
    }

    /**
     * @return the ciclos
     */
    public String getCiclos() {
        return ciclos;
    }

    /**
     * @param ciclos the ciclos to set
     */
    public void setCiclos(String ciclos) {
        this.ciclos = ciclos;
    }

    /**
     * @return the metodos
     */
    public String getMetodos() {
        return metodos;
    }

    /**
     * @param metodos the metodos to set
     */
    public void setMetodos(String metodos) {
        this.metodos = metodos;
    }

    /**
     * @return the doencas
     */
    public String getDoencas() {
        return doencas;
    }

    /**
     * @param doencas the doencas to set
     */
    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    /**
     * @return the colpocitologia
     */
    public String getColpocitologia() {
        return colpocitologia;
    }

    /**
     * @param colpocitologia the colpocitologia to set
     */
    public void setColpocitologia(String colpocitologia) {
        this.colpocitologia = colpocitologia;
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
