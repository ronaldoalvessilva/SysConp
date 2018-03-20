/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronaldo.silva7
 */
public class EstornoDepositoSaque {

    private int idEstorno;
    private String statusEstorno;
    private Date dataLanc;
    private int tipo;
    private int idRegistro;
    private Date DataRegistro;
    private float valorEstorno;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private float valorDepositoSaque;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public EstornoDepositoSaque(int idEstorno, String statusEstorno, Date dataLanc, int tipo, int idRegistro, Date DataRegistro, float valorEstorno, int idInternoCrc, String nomeInternoCrc, float valorDepositoSaque, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idEstorno = idEstorno;
        this.statusEstorno = statusEstorno;
        this.dataLanc = dataLanc;
        this.tipo = tipo;
        this.idRegistro = idRegistro;
        this.DataRegistro = DataRegistro;
        this.valorEstorno = valorEstorno;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.valorDepositoSaque = valorDepositoSaque;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public EstornoDepositoSaque() {
    }

    /**
     * @return the idEstorno
     */
    public int getIdEstorno() {
        return idEstorno;
    }

    /**
     * @param idEstorno the idEstorno to set
     */
    public void setIdEstorno(int idEstorno) {
        this.idEstorno = idEstorno;
    }

    /**
     * @return the statusEstorno
     */
    public String getStatusEstorno() {
        return statusEstorno;
    }

    /**
     * @param statusEstorno the statusEstorno to set
     */
    public void setStatusEstorno(String statusEstorno) {
        this.statusEstorno = statusEstorno;
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
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the idRegistro
     */
    public int getIdRegistro() {
        return idRegistro;
    }

    /**
     * @param idRegistro the idRegistro to set
     */
    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    /**
     * @return the DataRegistro
     */
    public Date getDataRegistro() {
        return DataRegistro;
    }

    /**
     * @param DataRegistro the DataRegistro to set
     */
    public void setDataRegistro(Date DataRegistro) {
        this.DataRegistro = DataRegistro;
    }

    /**
     * @return the valorEstorno
     */
    public float getValorEstorno() {
        return valorEstorno;
    }

    /**
     * @param valorEstorno the valorEstorno to set
     */
    public void setValorEstorno(float valorEstorno) {
        this.valorEstorno = valorEstorno;
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
     * @return the valorDepositoSaque
     */
    public float getValorDepositoSaque() {
        return valorDepositoSaque;
    }

    /**
     * @param valorDepositoSaque the valorDepositoSaque to set
     */
    public void setValorDepositoSaque(float valorDepositoSaque) {
        this.valorDepositoSaque = valorDepositoSaque;
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
