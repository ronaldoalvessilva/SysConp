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
public class ItensSolicitantesCompras {

    private int idItem;
    private int idSeq;
    private int idSoli;
    private int idFunc;
    private String nomeColaborador;
    private float valorMax;
    private Date dataInicialFunc;
    private Date dataFinalFunc;
    private float ValorVTA; 
    private String dataInicialComp;
    private String dataFinalComp;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;            

    public ItensSolicitantesCompras(int idItem, int idSeq, int idSoli, int idFunc, String nomeColaborador, float valorMax, Date dataInicialFunc, Date dataFinalFunc, float ValorVTA, String dataInicialComp, String dataFinalComp, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.idSeq = idSeq;
        this.idSoli = idSoli;
        this.idFunc = idFunc;
        this.nomeColaborador = nomeColaborador;
        this.valorMax = valorMax;
        this.dataInicialFunc = dataInicialFunc;
        this.dataFinalFunc = dataFinalFunc;
        this.ValorVTA = ValorVTA;
        this.dataInicialComp = dataInicialComp;
        this.dataFinalComp = dataFinalComp;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensSolicitantesCompras() {
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
     * @return the idSeq
     */
    public int getIdSeq() {
        return idSeq;
    }

    /**
     * @param idSeq the idSeq to set
     */
    public void setIdSeq(int idSeq) {
        this.idSeq = idSeq;
    }

    /**
     * @return the idSoli
     */
    public int getIdSoli() {
        return idSoli;
    }

    /**
     * @param idSoli the idSoli to set
     */
    public void setIdSoli(int idSoli) {
        this.idSoli = idSoli;
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
     * @return the valorMax
     */
    public float getValorMax() {
        return valorMax;
    }

    /**
     * @param valorMax the valorMax to set
     */
    public void setValorMax(float valorMax) {
        this.valorMax = valorMax;
    }

    /**
     * @return the dataInicialFunc
     */
    public Date getDataInicialFunc() {
        return dataInicialFunc;
    }

    /**
     * @param dataInicialFunc the dataInicialFunc to set
     */
    public void setDataInicialFunc(Date dataInicialFunc) {
        this.dataInicialFunc = dataInicialFunc;
    }

    /**
     * @return the dataFinalFunc
     */
    public Date getDataFinalFunc() {
        return dataFinalFunc;
    }

    /**
     * @param dataFinalFunc the dataFinalFunc to set
     */
    public void setDataFinalFunc(Date dataFinalFunc) {
        this.dataFinalFunc = dataFinalFunc;
    }

    /**
     * @return the ValorVTA
     */
    public float getValorVTA() {
        return ValorVTA;
    }

    /**
     * @param ValorVTA the ValorVTA to set
     */
    public void setValorVTA(float ValorVTA) {
        this.ValorVTA = ValorVTA;
    }

    /**
     * @return the dataInicialComp
     */
    public String getDataInicialComp() {
        return dataInicialComp;
    }

    /**
     * @param dataInicialComp the dataInicialComp to set
     */
    public void setDataInicialComp(String dataInicialComp) {
        this.dataInicialComp = dataInicialComp;
    }

    /**
     * @return the dataFinalComp
     */
    public String getDataFinalComp() {
        return dataFinalComp;
    }

    /**
     * @param dataFinalComp the dataFinalComp to set
     */
    public void setDataFinalComp(String dataFinalComp) {
        this.dataFinalComp = dataFinalComp;
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
