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
public class TransferenciaInternos {
    
    private int idTrans;
    private Date datalancamento;
    private String statusTransf;
    private String nomeOperacao;
    private String obsTrans;   
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;  

    public TransferenciaInternos(int idTrans, Date datalancamento, String statusTransf, String nomeOperacao, String obsTrans, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento) {
        this.idTrans = idTrans;
        this.datalancamento = datalancamento;
        this.statusTransf = statusTransf;
        this.nomeOperacao = nomeOperacao;
        this.obsTrans = obsTrans;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
    }

    public TransferenciaInternos() {
    }

    /**
     * @return the idTrans
     */
    public int getIdTrans() {
        return idTrans;
    }

    /**
     * @param idTrans the idTrans to set
     */
    public void setIdTrans(int idTrans) {
        this.idTrans = idTrans;
    }

    /**
     * @return the datalancamento
     */
    public Date getDatalancamento() {
        return datalancamento;
    }

    /**
     * @param datalancamento the datalancamento to set
     */
    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
    }

    /**
     * @return the statusTransf
     */
    public String getStatusTransf() {
        return statusTransf;
    }

    /**
     * @param statusTransf the statusTransf to set
     */
    public void setStatusTransf(String statusTransf) {
        this.statusTransf = statusTransf;
    }

    /**
     * @return the nomeOperacao
     */
    public String getNomeOperacao() {
        return nomeOperacao;
    }

    /**
     * @param nomeOperacao the nomeOperacao to set
     */
    public void setNomeOperacao(String nomeOperacao) {
        this.nomeOperacao = nomeOperacao;
    }

    /**
     * @return the obsTrans
     */
    public String getObsTrans() {
        return obsTrans;
    }

    /**
     * @param obsTrans the obsTrans to set
     */
    public void setObsTrans(String obsTrans) {
        this.obsTrans = obsTrans;
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
