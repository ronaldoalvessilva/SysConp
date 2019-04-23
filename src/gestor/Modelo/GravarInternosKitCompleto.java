/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronal
 */
public class GravarInternosKitCompleto {

    private int idRegIntAgrupComp;
    private int idRegistroComp;
    private int idKit;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String agrupado;
    private int gravado;
    private int tipoKitCI;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private String utili;
    private Date dataPagamento;
    private Date dataPrevisao;
    private String kitPago;
    private int IDREG_PROG;

    public GravarInternosKitCompleto() {
    }

    public GravarInternosKitCompleto(int idRegIntAgrupComp, int idRegistroComp, int idKit, int idInternoCrc, String nomeInternoCrc, String agrupado, int gravado, int tipoKitCI, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String utili, Date dataPagamento, Date dataPrevisao, String kitPago, int IDREG_PROG) {
        this.idRegIntAgrupComp = idRegIntAgrupComp;
        this.idRegistroComp = idRegistroComp;
        this.idKit = idKit;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.agrupado = agrupado;
        this.gravado = gravado;
        this.tipoKitCI = tipoKitCI;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.utili = utili;
        this.dataPagamento = dataPagamento;
        this.dataPrevisao = dataPrevisao;
        this.kitPago = kitPago;
        this.IDREG_PROG = IDREG_PROG;
    }

    /**
     * @return the idRegIntAgrupComp
     */
    public int getIdRegIntAgrupComp() {
        return idRegIntAgrupComp;
    }

    /**
     * @param idRegIntAgrupComp the idRegIntAgrupComp to set
     */
    public void setIdRegIntAgrupComp(int idRegIntAgrupComp) {
        this.idRegIntAgrupComp = idRegIntAgrupComp;
    }

    /**
     * @return the idRegistroComp
     */
    public int getIdRegistroComp() {
        return idRegistroComp;
    }

    /**
     * @param idRegistroComp the idRegistroComp to set
     */
    public void setIdRegistroComp(int idRegistroComp) {
        this.idRegistroComp = idRegistroComp;
    }

    /**
     * @return the idKit
     */
    public int getIdKit() {
        return idKit;
    }

    /**
     * @param idKit the idKit to set
     */
    public void setIdKit(int idKit) {
        this.idKit = idKit;
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
     * @return the agrupado
     */
    public String getAgrupado() {
        return agrupado;
    }

    /**
     * @param agrupado the agrupado to set
     */
    public void setAgrupado(String agrupado) {
        this.agrupado = agrupado;
    }

    /**
     * @return the gravado
     */
    public int getGravado() {
        return gravado;
    }

    /**
     * @param gravado the gravado to set
     */
    public void setGravado(int gravado) {
        this.gravado = gravado;
    }

    /**
     * @return the tipoKitCI
     */
    public int getTipoKitCI() {
        return tipoKitCI;
    }

    /**
     * @param tipoKitCI the tipoKitCI to set
     */
    public void setTipoKitCI(int tipoKitCI) {
        this.tipoKitCI = tipoKitCI;
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

    /**
     * @return the utili
     */
    public String getUtili() {
        return utili;
    }

    /**
     * @param utili the utili to set
     */
    public void setUtili(String utili) {
        this.utili = utili;
    }

    /**
     * @return the dataPagamento
     */
    public Date getDataPagamento() {
        return dataPagamento;
    }

    /**
     * @param dataPagamento the dataPagamento to set
     */
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    /**
     * @return the dataPrevisao
     */
    public Date getDataPrevisao() {
        return dataPrevisao;
    }

    /**
     * @param dataPrevisao the dataPrevisao to set
     */
    public void setDataPrevisao(Date dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    /**
     * @return the kitPago
     */
    public String getKitPago() {
        return kitPago;
    }

    /**
     * @param kitPago the kitPago to set
     */
    public void setKitPago(String kitPago) {
        this.kitPago = kitPago;
    }

    /**
     * @return the IDREG_PROG
     */
    public int getIDREG_PROG() {
        return IDREG_PROG;
    }

    /**
     * @param IDREG_PROG the IDREG_PROG to set
     */
    public void setIDREG_PROG(int IDREG_PROG) {
        this.IDREG_PROG = IDREG_PROG;
    }
}
