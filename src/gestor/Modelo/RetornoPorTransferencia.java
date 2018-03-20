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
public class RetornoPorTransferencia {

    private int idRetorno;
    private String statusRet;
    private Date dataLancRetorno;
    private int idOp;
    private String nomeOperacao;
    private String obsRetorno;    
    private String nomeUsuarioInsert;
    private String nomeUsuarioUpdate;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;                 

    public RetornoPorTransferencia(int idRetorno, String statusRet, Date dataLancRetorno, int idOp, String nomeOperacao, String obsRetorno, String nomeUsuarioInsert, String nomeUsuarioUpdate, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento) {
        this.idRetorno = idRetorno;
        this.statusRet = statusRet;
        this.dataLancRetorno = dataLancRetorno;
        this.idOp = idOp;
        this.nomeOperacao = nomeOperacao;
        this.obsRetorno = obsRetorno;
        this.nomeUsuarioInsert = nomeUsuarioInsert;
        this.nomeUsuarioUpdate = nomeUsuarioUpdate;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
    }

    public RetornoPorTransferencia() {
    }

    /**
     * @return the idRetorno
     */
    public int getIdRetorno() {
        return idRetorno;
    }

    /**
     * @param idRetorno the idRetorno to set
     */
    public void setIdRetorno(int idRetorno) {
        this.idRetorno = idRetorno;
    }

    /**
     * @return the statusRet
     */
    public String getStatusRet() {
        return statusRet;
    }

    /**
     * @param statusRet the statusRet to set
     */
    public void setStatusRet(String statusRet) {
        this.statusRet = statusRet;
    }

    /**
     * @return the dataLancRetorno
     */
    public Date getDataLancRetorno() {
        return dataLancRetorno;
    }

    /**
     * @param dataLancRetorno the dataLancRetorno to set
     */
    public void setDataLancRetorno(Date dataLancRetorno) {
        this.dataLancRetorno = dataLancRetorno;
    }

    /**
     * @return the idOp
     */
    public int getIdOp() {
        return idOp;
    }

    /**
     * @param idOp the idOp to set
     */
    public void setIdOp(int idOp) {
        this.idOp = idOp;
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
     * @return the obsRetorno
     */
    public String getObsRetorno() {
        return obsRetorno;
    }

    /**
     * @param obsRetorno the obsRetorno to set
     */
    public void setObsRetorno(String obsRetorno) {
        this.obsRetorno = obsRetorno;
    }

    /**
     * @return the nomeUsuarioInsert
     */
    public String getNomeUsuarioInsert() {
        return nomeUsuarioInsert;
    }

    /**
     * @param nomeUsuarioInsert the nomeUsuarioInsert to set
     */
    public void setNomeUsuarioInsert(String nomeUsuarioInsert) {
        this.nomeUsuarioInsert = nomeUsuarioInsert;
    }

    /**
     * @return the nomeUsuarioUpdate
     */
    public String getNomeUsuarioUpdate() {
        return nomeUsuarioUpdate;
    }

    /**
     * @param nomeUsuarioUpdate the nomeUsuarioUpdate to set
     */
    public void setNomeUsuarioUpdate(String nomeUsuarioUpdate) {
        this.nomeUsuarioUpdate = nomeUsuarioUpdate;
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
