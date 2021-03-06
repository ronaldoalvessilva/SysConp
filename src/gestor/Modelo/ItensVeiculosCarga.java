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
public class ItensVeiculosCarga {

    private int idItem;
    private int idLanc;
    private int idVisita;
    private String nomeVisita;
    private Date dataEntrada;
    private String horarioEntrada;
    private Date dataSaida;
    private String horarioSaida;
    private String origemEntrada;
    private String destinoEntrada;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;

    public ItensVeiculosCarga(int idItem, int idLanc, int idVisita, String nomeVisita, Date dataEntrada, String horarioEntrada, Date dataSaida, String horarioSaida, String origemEntrada, String destinoEntrada, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp) {
        this.idItem = idItem;
        this.idLanc = idLanc;
        this.idVisita = idVisita;
        this.nomeVisita = nomeVisita;
        this.dataEntrada = dataEntrada;
        this.horarioEntrada = horarioEntrada;
        this.dataSaida = dataSaida;
        this.horarioSaida = horarioSaida;
        this.origemEntrada = origemEntrada;
        this.destinoEntrada = destinoEntrada;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
    }

    public ItensVeiculosCarga() {
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
     * @return the dataEntrada
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the horarioEntrada
     */
    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    /**
     * @param horarioEntrada the horarioEntrada to set
     */
    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    /**
     * @return the dataSaida
     */
    public Date getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * @return the horarioSaida
     */
    public String getHorarioSaida() {
        return horarioSaida;
    }

    /**
     * @param horarioSaida the horarioSaida to set
     */
    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    /**
     * @return the origemEntrada
     */
    public String getOrigemEntrada() {
        return origemEntrada;
    }

    /**
     * @param origemEntrada the origemEntrada to set
     */
    public void setOrigemEntrada(String origemEntrada) {
        this.origemEntrada = origemEntrada;
    }

    /**
     * @return the destinoEntrada
     */
    public String getDestinoEntrada() {
        return destinoEntrada;
    }

    /**
     * @param destinoEntrada the destinoEntrada to set
     */
    public void setDestinoEntrada(String destinoEntrada) {
        this.destinoEntrada = destinoEntrada;
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

}
