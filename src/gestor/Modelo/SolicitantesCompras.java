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
public class SolicitantesCompras {

    private int idSoli;
    private String statusSoli;
    private Date dataSoli;
    private Date dataInicial;
    private Date dataFinal;
    private int idDepartamento;
    private String nomeDepartamento;
    private int tipoValor;
    private float valorMax;
    private float valorGAC;
    private String dataInicialComp;
    private String dataFinalComp;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;                    

    public SolicitantesCompras(int idSoli, String statusSoli, Date dataSoli, Date dataInicial, Date dataFinal, int idDepartamento, String nomeDepartamento, int tipoValor, float valorMax, float valorGAC, String dataInicialComp, String dataFinalComp, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idSoli = idSoli;
        this.statusSoli = statusSoli;
        this.dataSoli = dataSoli;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.idDepartamento = idDepartamento;
        this.nomeDepartamento = nomeDepartamento;
        this.tipoValor = tipoValor;
        this.valorMax = valorMax;
        this.valorGAC = valorGAC;
        this.dataInicialComp = dataInicialComp;
        this.dataFinalComp = dataFinalComp;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public SolicitantesCompras() {
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
     * @return the statusSoli
     */
    public String getStatusSoli() {
        return statusSoli;
    }

    /**
     * @param statusSoli the statusSoli to set
     */
    public void setStatusSoli(String statusSoli) {
        this.statusSoli = statusSoli;
    }

    /**
     * @return the dataSoli
     */
    public Date getDataSoli() {
        return dataSoli;
    }

    /**
     * @param dataSoli the dataSoli to set
     */
    public void setDataSoli(Date dataSoli) {
        this.dataSoli = dataSoli;
    }

    /**
     * @return the dataInicial
     */
    public Date getDataInicial() {
        return dataInicial;
    }

    /**
     * @param dataInicial the dataInicial to set
     */
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    /**
     * @return the dataFinal
     */
    public Date getDataFinal() {
        return dataFinal;
    }

    /**
     * @param dataFinal the dataFinal to set
     */
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    /**
     * @return the idDepartamento
     */
    public int getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    /**
     * @return the nomeDepartamento
     */
    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    /**
     * @param nomeDepartamento the nomeDepartamento to set
     */
    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    /**
     * @return the tipoValor
     */
    public int getTipoValor() {
        return tipoValor;
    }

    /**
     * @param tipoValor the tipoValor to set
     */
    public void setTipoValor(int tipoValor) {
        this.tipoValor = tipoValor;
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
     * @return the valorGAC
     */
    public float getValorGAC() {
        return valorGAC;
    }

    /**
     * @param valorGAC the valorGAC to set
     */
    public void setValorGAC(float valorGAC) {
        this.valorGAC = valorGAC;
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
