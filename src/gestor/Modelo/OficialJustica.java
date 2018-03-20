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
public class OficialJustica {

    private int idOficial;
    private String statusOficial;
    private Date dataCadastro;
    private String fotoOficial;
    private String nomeOficial;
    private String rgOficial;
    private String cpfOficial;
    private String regOficial;
    private String obsOficial;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;    

    public OficialJustica(int idOficial, String statusOficial, Date dataCadastro, String fotoOficial, String nomeOficial, String rgOficial, String cpfOficial, String regOficial, String obsOficial, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento) {
        this.idOficial = idOficial;
        this.statusOficial = statusOficial;
        this.dataCadastro = dataCadastro;
        this.fotoOficial = fotoOficial;
        this.nomeOficial = nomeOficial;
        this.rgOficial = rgOficial;
        this.cpfOficial = cpfOficial;
        this.regOficial = regOficial;
        this.obsOficial = obsOficial;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
    }

    public OficialJustica() {
    }

    /**
     * @return the idOficial
     */
    public int getIdOficial() {
        return idOficial;
    }

    /**
     * @param idOficial the idOficial to set
     */
    public void setIdOficial(int idOficial) {
        this.idOficial = idOficial;
    }

    /**
     * @return the statusOficial
     */
    public String getStatusOficial() {
        return statusOficial;
    }

    /**
     * @param statusOficial the statusOficial to set
     */
    public void setStatusOficial(String statusOficial) {
        this.statusOficial = statusOficial;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the fotoOficial
     */
    public String getFotoOficial() {
        return fotoOficial;
    }

    /**
     * @param fotoOficial the fotoOficial to set
     */
    public void setFotoOficial(String fotoOficial) {
        this.fotoOficial = fotoOficial;
    }

    /**
     * @return the nomeOficial
     */
    public String getNomeOficial() {
        return nomeOficial;
    }

    /**
     * @param nomeOficial the nomeOficial to set
     */
    public void setNomeOficial(String nomeOficial) {
        this.nomeOficial = nomeOficial;
    }

    /**
     * @return the rgOficial
     */
    public String getRgOficial() {
        return rgOficial;
    }

    /**
     * @param rgOficial the rgOficial to set
     */
    public void setRgOficial(String rgOficial) {
        this.rgOficial = rgOficial;
    }

    /**
     * @return the cpfOficial
     */
    public String getCpfOficial() {
        return cpfOficial;
    }

    /**
     * @param cpfOficial the cpfOficial to set
     */
    public void setCpfOficial(String cpfOficial) {
        this.cpfOficial = cpfOficial;
    }

    /**
     * @return the regOficial
     */
    public String getRegOficial() {
        return regOficial;
    }

    /**
     * @param regOficial the regOficial to set
     */
    public void setRegOficial(String regOficial) {
        this.regOficial = regOficial;
    }

    /**
     * @return the obsOficial
     */
    public String getObsOficial() {
        return obsOficial;
    }

    /**
     * @param obsOficial the obsOficial to set
     */
    public void setObsOficial(String obsOficial) {
        this.obsOficial = obsOficial;
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
