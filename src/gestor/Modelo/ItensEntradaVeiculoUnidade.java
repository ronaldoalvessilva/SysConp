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
public class ItensEntradaVeiculoUnidade {

    private int idItem;
    private int idFunc;
    private String nomeColaborador;
    private int idlanc;
    private int idVeiculo;
    private String modeloVeiculo;
    private Date dataEntrada;
    private String horarioEntrada;
    private Date dataSaida;
    private String horarioSaida;
    private float kmInicial;
    private float kmFinal;
    private String destinoEntrada;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;               

    public ItensEntradaVeiculoUnidade(int idItem, int idFunc, String nomeColaborador, int idlanc, int idVeiculo, String modeloVeiculo, Date dataEntrada, String horarioEntrada, Date dataSaida, String horarioSaida, float kmInicial, float kmFinal, String destinoEntrada, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp) {
        this.idItem = idItem;
        this.idFunc = idFunc;
        this.nomeColaborador = nomeColaborador;
        this.idlanc = idlanc;
        this.idVeiculo = idVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.dataEntrada = dataEntrada;
        this.horarioEntrada = horarioEntrada;
        this.dataSaida = dataSaida;
        this.horarioSaida = horarioSaida;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.destinoEntrada = destinoEntrada;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
    }

    public ItensEntradaVeiculoUnidade() {
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
     * @return the idFunc
     */
    public int getIdFunc() {
        return idFunc;
    }

    /**
     * @param idFunc the idFunc to set
     */
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    /**
     * @return the nomeColaborador
     */
    public String getNomeColaborador() {
        return nomeColaborador;
    }

    /**
     * @param nomeColaborador the nomeColaborador to set
     */
    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
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
     * @return the idVeiculo
     */
    public int getIdVeiculo() {
        return idVeiculo;
    }

    /**
     * @param idVeiculo the idVeiculo to set
     */
    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    /**
     * @return the modeloVeiculo
     */
    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    /**
     * @param modeloVeiculo the modeloVeiculo to set
     */
    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
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
     * @return the kmInicial
     */
    public float getKmInicial() {
        return kmInicial;
    }

    /**
     * @param kmInicial the kmInicial to set
     */
    public void setKmInicial(float kmInicial) {
        this.kmInicial = kmInicial;
    }

    /**
     * @return the kmFinal
     */
    public float getKmFinal() {
        return kmFinal;
    }

    /**
     * @param kmFinal the kmFinal to set
     */
    public void setKmFinal(float kmFinal) {
        this.kmFinal = kmFinal;
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
