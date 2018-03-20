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
public class ItensValeTransporteColaborador {

    private int idItem;
    private Date dataLanc ;
    private String mesReferencia;
    private int idLanc;
    private int idFunc;
    private String nomeColaborador;
    private float valorVale ;
    private int qtdDias;
    private int qtdValeDia;
    private float valorTotalVale ;
    private String textoRecibo;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;         

    public ItensValeTransporteColaborador(int idItem, Date dataLanc, String mesReferencia, int idLanc, int idFunc, String nomeColaborador, float valorVale, int qtdDias, int qtdValeDia, float valorTotalVale, String textoRecibo, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.dataLanc = dataLanc;
        this.mesReferencia = mesReferencia;
        this.idLanc = idLanc;
        this.idFunc = idFunc;
        this.nomeColaborador = nomeColaborador;
        this.valorVale = valorVale;
        this.qtdDias = qtdDias;
        this.qtdValeDia = qtdValeDia;
        this.valorTotalVale = valorTotalVale;
        this.textoRecibo = textoRecibo;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensValeTransporteColaborador() {
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
     * @return the mesReferencia
     */
    public String getMesReferencia() {
        return mesReferencia;
    }

    /**
     * @param mesReferencia the mesReferencia to set
     */
    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
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
     * @return the valorVale
     */
    public float getValorVale() {
        return valorVale;
    }

    /**
     * @param valorVale the valorVale to set
     */
    public void setValorVale(float valorVale) {
        this.valorVale = valorVale;
    }

    /**
     * @return the qtdDias
     */
    public int getQtdDias() {
        return qtdDias;
    }

    /**
     * @param qtdDias the qtdDias to set
     */
    public void setQtdDias(int qtdDias) {
        this.qtdDias = qtdDias;
    }

    /**
     * @return the qtdValeDia
     */
    public int getQtdValeDia() {
        return qtdValeDia;
    }

    /**
     * @param qtdValeDia the qtdValeDia to set
     */
    public void setQtdValeDia(int qtdValeDia) {
        this.qtdValeDia = qtdValeDia;
    }

    /**
     * @return the valorTotalVale
     */
    public float getValorTotalVale() {
        return valorTotalVale;
    }

    /**
     * @param valorTotalVale the valorTotalVale to set
     */
    public void setValorTotalVale(float valorTotalVale) {
        this.valorTotalVale = valorTotalVale;
    }

    /**
     * @return the textoRecibo
     */
    public String getTextoRecibo() {
        return textoRecibo;
    }

    /**
     * @param textoRecibo the textoRecibo to set
     */
    public void setTextoRecibo(String textoRecibo) {
        this.textoRecibo = textoRecibo;
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

    public void getQtdDias(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
