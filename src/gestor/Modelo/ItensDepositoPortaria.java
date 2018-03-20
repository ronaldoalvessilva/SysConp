/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author user
 */
public class ItensDepositoPortaria {

    private int idItem;
    private int idlanc;
    private int idInternoCrc;
    private String nomeInterno;
    private String setorDepositante;
    private float valorDeposito;
    private Date dataDeposito;
    private String efetuado;
    private String origemDeposito;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;      

    public ItensDepositoPortaria(int idItem, int idlanc, int idInternoCrc, String nomeInterno, String setorDepositante, float valorDeposito, Date dataDeposito, String efetuado, String origemDeposito, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento) {
        this.idItem = idItem;
        this.idlanc = idlanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.setorDepositante = setorDepositante;
        this.valorDeposito = valorDeposito;
        this.dataDeposito = dataDeposito;
        this.efetuado = efetuado;
        this.origemDeposito = origemDeposito;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
    }

    public ItensDepositoPortaria() {
    }

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the idlanc
     */
    public int getIdlanc() {
        return idlanc;
    }

    /**
     * @param idlanc the idlanc to set
     */
    public void setIdlanc(int idlanc) {
        this.idlanc = idlanc;
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
     * @return the setorDepositante
     */
    public String getSetorDepositante() {
        return setorDepositante;
    }

    /**
     * @param setorDepositante the setorDepositante to set
     */
    public void setSetorDepositante(String setorDepositante) {
        this.setorDepositante = setorDepositante;
    }

    /**
     * @return the valorDeposito
     */
    public float getValorDeposito() {
        return valorDeposito;
    }

    /**
     * @param valorDeposito the valorDeposito to set
     */
    public void setValorDeposito(float valorDeposito) {
        this.valorDeposito = valorDeposito;
    }

    /**
     * @return the dataDeposito
     */
    public Date getDataDeposito() {
        return dataDeposito;
    }

    /**
     * @param dataDeposito the dataDeposito to set
     */
    public void setDataDeposito(Date dataDeposito) {
        this.dataDeposito = dataDeposito;
    }

    /**
     * @return the efetuado
     */
    public String getEfetuado() {
        return efetuado;
    }

    /**
     * @param efetuado the efetuado to set
     */
    public void setEfetuado(String efetuado) {
        this.efetuado = efetuado;
    }

    /**
     * @return the origemDeposito
     */
    public String getOrigemDeposito() {
        return origemDeposito;
    }

    /**
     * @param origemDeposito the origemDeposito to set
     */
    public void setOrigemDeposito(String origemDeposito) {
        this.origemDeposito = origemDeposito;
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
