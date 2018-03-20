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
public class RegistroRetornoInternos {
    
    private int idRetorno;
    private Date dateLancamento;
    private String statusRetorno;
    private String obsRetorno;
    private String nomeOperacao;
    private int qtdRetorno; 
    private String nomeUsuario;
    private String dataInsert;
    private String dataUpdate;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;  
    private byte[] assinaturaDigital;    

    public RegistroRetornoInternos(int idRetorno, Date dateLancamento, String statusRetorno, String obsRetorno, String nomeOperacao, int qtdRetorno, String nomeUsuario, String dataInsert, String dataUpdate, String usuarioInsert, String usuarioUp, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento, byte[] assinaturaDigital) {
        this.idRetorno = idRetorno;
        this.dateLancamento = dateLancamento;
        this.statusRetorno = statusRetorno;
        this.obsRetorno = obsRetorno;
        this.nomeOperacao = nomeOperacao;
        this.qtdRetorno = qtdRetorno;
        this.nomeUsuario = nomeUsuario;
        this.dataInsert = dataInsert;
        this.dataUpdate = dataUpdate;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.assinaturaDigital = assinaturaDigital;
    }

    public RegistroRetornoInternos() {
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
     * @return the dateLancamento
     */
    public Date getDateLancamento() {
        return dateLancamento;
    }

    /**
     * @param dateLancamento the dateLancamento to set
     */
    public void setDateLancamento(Date dateLancamento) {
        this.dateLancamento = dateLancamento;
    }

    /**
     * @return the statusRetorno
     */
    public String getStatusRetorno() {
        return statusRetorno;
    }

    /**
     * @param statusRetorno the statusRetorno to set
     */
    public void setStatusRetorno(String statusRetorno) {
        this.statusRetorno = statusRetorno;
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
     * @return the qtdRetorno
     */
    public int getQtdRetorno() {
        return qtdRetorno;
    }

    /**
     * @param qtdRetorno the qtdRetorno to set
     */
    public void setQtdRetorno(int qtdRetorno) {
        this.qtdRetorno = qtdRetorno;
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
     * @return the dataUpdate
     */
    public String getDataUpdate() {
        return dataUpdate;
    }

    /**
     * @param dataUpdate the dataUpdate to set
     */
    public void setDataUpdate(String dataUpdate) {
        this.dataUpdate = dataUpdate;
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
     * @return the assinaturaDigital
     */
    public byte[] getAssinaturaDigital() {
        return assinaturaDigital;
    }

    /**
     * @param assinaturaDigital the assinaturaDigital to set
     */
    public void setAssinaturaDigital(byte[] assinaturaDigital) {
        this.assinaturaDigital = assinaturaDigital;
    }
}
