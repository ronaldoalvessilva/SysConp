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
public class ConsultaSaldoInternos {
    
    private int idMov;
    private int idInternoCrc;
    private String nomeInterno;
    private int idLanc;
    private String Historico;
    private String FavorecidoDepositante;
    private Date dataMov;
    private Float saldo;  
    private String statusMov; 
    private Double saldoAtual;   

    public ConsultaSaldoInternos(int idMov, int idInternoCrc, String nomeInterno, int idLanc, String Historico, String FavorecidoDepositante, Date dataMov, Float saldo, String statusMov, Double saldoAtual) {
        this.idMov = idMov;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.idLanc = idLanc;
        this.Historico = Historico;
        this.FavorecidoDepositante = FavorecidoDepositante;
        this.dataMov = dataMov;
        this.saldo = saldo;
        this.statusMov = statusMov;
        this.saldoAtual = saldoAtual;
    }

    public ConsultaSaldoInternos() {
    }

    /**
     * @return the idMov
     */
    public int getIdMov() {
        return idMov;
    }

    /**
     * @param idMov the idMov to set
     */
    public void setIdMov(int idMov) {
        this.idMov = idMov;
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
     * @return the Historico
     */
    public String getHistorico() {
        return Historico;
    }

    /**
     * @param Historico the Historico to set
     */
    public void setHistorico(String Historico) {
        this.Historico = Historico;
    }

    /**
     * @return the FavorecidoDepositante
     */
    public String getFavorecidoDepositante() {
        return FavorecidoDepositante;
    }

    /**
     * @param FavorecidoDepositante the FavorecidoDepositante to set
     */
    public void setFavorecidoDepositante(String FavorecidoDepositante) {
        this.FavorecidoDepositante = FavorecidoDepositante;
    }

    /**
     * @return the dataMov
     */
    public Date getDataMov() {
        return dataMov;
    }

    /**
     * @param dataMov the dataMov to set
     */
    public void setDataMov(Date dataMov) {
        this.dataMov = dataMov;
    }

    /**
     * @return the saldo
     */
    public Float getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the statusMov
     */
    public String getStatusMov() {
        return statusMov;
    }

    /**
     * @param statusMov the statusMov to set
     */
    public void setStatusMov(String statusMov) {
        this.statusMov = statusMov;
    }

    /**
     * @return the saldoAtual
     */
    public Double getSaldoAtual() {
        return saldoAtual;
    }

    /**
     * @param saldoAtual the saldoAtual to set
     */
    public void setSaldoAtual(Double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }
    
}
