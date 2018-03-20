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
public class DepositoInterno {

    private int idLanc;
    private String statusLanc;
    private Date dataLanc;
    private int idInternoCrc;
    private String nomeInterno;
    private float valorDeposito;
    private String depositante;
    private String efetuado;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;
    private int idLancHist;
    private Date dataLancMov;
    private int idHist;
    private int tipo;
    private float valorLiberado;
    private int idUsuario;
    private String nomeUsuario;
    private float saldoAtual;   
    private String tipoTrans;

    public DepositoInterno(int idLanc, String statusLanc, Date dataLanc, int idInternoCrc, String nomeInterno, float valorDeposito, String depositante, String efetuado, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento, int idLancHist, Date dataLancMov, int idHist, int tipo, float valorLiberado, int idUsuario, String nomeUsuario, float saldoAtual, String tipoTrans) {
        this.idLanc = idLanc;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.valorDeposito = valorDeposito;
        this.depositante = depositante;
        this.efetuado = efetuado;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.idLancHist = idLancHist;
        this.dataLancMov = dataLancMov;
        this.idHist = idHist;
        this.tipo = tipo;
        this.valorLiberado = valorLiberado;
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.saldoAtual = saldoAtual;
        this.tipoTrans = tipoTrans;
    }

    public DepositoInterno() {
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
     * @return the statusLanc
     */
    public String getStatusLanc() {
        return statusLanc;
    }

    /**
     * @param statusLanc the statusLanc to set
     */
    public void setStatusLanc(String statusLanc) {
        this.statusLanc = statusLanc;
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
     * @return the depositante
     */
    public String getDepositante() {
        return depositante;
    }

    /**
     * @param depositante the depositante to set
     */
    public void setDepositante(String depositante) {
        this.depositante = depositante;
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

    /**
     * @return the idLancHist
     */
    public int getIdLancHist() {
        return idLancHist;
    }

    /**
     * @param idLancHist the idLancHist to set
     */
    public void setIdLancHist(int idLancHist) {
        this.idLancHist = idLancHist;
    }

    /**
     * @return the dataLancMov
     */
    public Date getDataLancMov() {
        return dataLancMov;
    }

    /**
     * @param dataLancMov the dataLancMov to set
     */
    public void setDataLancMov(Date dataLancMov) {
        this.dataLancMov = dataLancMov;
    }

    /**
     * @return the idHist
     */
    public int getIdHist() {
        return idHist;
    }

    /**
     * @param idHist the idHist to set
     */
    public void setIdHist(int idHist) {
        this.idHist = idHist;
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
     * @return the valorLiberado
     */
    public float getValorLiberado() {
        return valorLiberado;
    }

    /**
     * @param valorLiberado the valorLiberado to set
     */
    public void setValorLiberado(float valorLiberado) {
        this.valorLiberado = valorLiberado;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * @return the saldoAtual
     */
    public float getSaldoAtual() {
        return saldoAtual;
    }

    /**
     * @param saldoAtual the saldoAtual to set
     */
    public void setSaldoAtual(float saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    /**
     * @return the tipoTrans
     */
    public String getTipoTrans() {
        return tipoTrans;
    }

    /**
     * @param tipoTrans the tipoTrans to set
     */
    public void setTipoTrans(String tipoTrans) {
        this.tipoTrans = tipoTrans;
    }
}
