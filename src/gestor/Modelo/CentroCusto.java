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
public class CentroCusto {

    private int idCusto;
    private String codigo;
    private Date dataLanc;
    private String statusCentro;
    private String tipoCusto;
    private String descricaoCentro;
    private int idDepartamento;
    private String descricaoDepartamento;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;        

    public CentroCusto(int idCusto, String codigo, Date dataLanc, String statusCentro, String tipoCusto, String descricaoCentro, int idDepartamento, String descricaoDepartamento, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idCusto = idCusto;
        this.codigo = codigo;
        this.dataLanc = dataLanc;
        this.statusCentro = statusCentro;
        this.tipoCusto = tipoCusto;
        this.descricaoCentro = descricaoCentro;
        this.idDepartamento = idDepartamento;
        this.descricaoDepartamento = descricaoDepartamento;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public CentroCusto() {
    }

    /**
     * @return the idCusto
     */
    public int getIdCusto() {
        return idCusto;
    }

    /**
     * @param idCusto the idCusto to set
     */
    public void setIdCusto(int idCusto) {
        this.idCusto = idCusto;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * @return the statusCentro
     */
    public String getStatusCentro() {
        return statusCentro;
    }

    /**
     * @param statusCentro the statusCentro to set
     */
    public void setStatusCentro(String statusCentro) {
        this.statusCentro = statusCentro;
    }

    /**
     * @return the tipoCusto
     */
    public String getTipoCusto() {
        return tipoCusto;
    }

    /**
     * @param tipoCusto the tipoCusto to set
     */
    public void setTipoCusto(String tipoCusto) {
        this.tipoCusto = tipoCusto;
    }

    /**
     * @return the descricaoCentro
     */
    public String getDescricaoCentro() {
        return descricaoCentro;
    }

    /**
     * @param descricaoCentro the descricaoCentro to set
     */
    public void setDescricaoCentro(String descricaoCentro) {
        this.descricaoCentro = descricaoCentro;
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
     * @return the descricaoDepartamento
     */
    public String getDescricaoDepartamento() {
        return descricaoDepartamento;
    }

    /**
     * @param descricaoDepartamento the descricaoDepartamento to set
     */
    public void setDescricaoDepartamento(String descricaoDepartamento) {
        this.descricaoDepartamento = descricaoDepartamento;
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
