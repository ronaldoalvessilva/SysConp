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
public class EntradaLote {
    
    private int idLanc;
    private Date dateLancamento;
    private String statusEntrada;
    private String obs;
    private String nomeOperacao;
    private int qtdEntrada;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;       

    public EntradaLote(int idLanc, Date dateLancamento, String statusEntrada, String obs, String nomeOperacao, int qtdEntrada, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento) {
        this.idLanc = idLanc;
        this.dateLancamento = dateLancamento;
        this.statusEntrada = statusEntrada;
        this.obs = obs;
        this.nomeOperacao = nomeOperacao;
        this.qtdEntrada = qtdEntrada;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
    }

    public EntradaLote() {
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
     * @return the dateLancamento
     */
    public Date getDateLancamento() {
        return dateLancamento;
    }

    /**
     * @param dateLancamento the dateLancamento to set
     */
    public void setDateLancamento(Date dateLancamento) {
        this.dateLancamento = dateLancamento;
    }

    /**
     * @return the statusEntrada
     */
    public String getStatusEntrada() {
        return statusEntrada;
    }

    /**
     * @param statusEntrada the statusEntrada to set
     */
    public void setStatusEntrada(String statusEntrada) {
        this.statusEntrada = statusEntrada;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @return the nomeOperacao
     */
    public String getNomeOperacao() {
        return nomeOperacao;
    }

    /**
     * @param nomeOperacao the nomeOperacao to set
     */
    public void setNomeOperacao(String nomeOperacao) {
        this.nomeOperacao = nomeOperacao;
    }

    /**
     * @return the qtdEntrada
     */
    public int getQtdEntrada() {
        return qtdEntrada;
    }

    /**
     * @param qtdEntrada the qtdEntrada to set
     */
    public void setQtdEntrada(int qtdEntrada) {
        this.qtdEntrada = qtdEntrada;
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

    /**
     * @return the dataFechamento
     */
    public String getDataFechamento() {
        return dataFechamento;
    }

    /**
     * @param dataFechamento the dataFechamento to set
     */
    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    /**
     * @return the horaFechamento
     */
    public String getHoraFechamento() {
        return horaFechamento;
    }

    /**
     * @param horaFechamento the horaFechamento to set
     */
    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }
}
