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
public class EvolucaoJuridico {

    private int idEvo;
    private Date dataEvo;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int idLanc;
    private String evolucao;
    private Date DataEnca;
    private String tipoAdvogado;
    private String resposta;
    private String horaEnvio;
    private String setorEncaminhamento;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public EvolucaoJuridico(int idEvo, Date dataEvo, int idInternoCrc, String nomeInternoCrc, int idLanc, String evolucao, Date DataEnca, String tipoAdvogado, String resposta, String horaEnvio, String setorEncaminhamento, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idEvo = idEvo;
        this.dataEvo = dataEvo;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idLanc = idLanc;
        this.evolucao = evolucao;
        this.DataEnca = DataEnca;
        this.tipoAdvogado = tipoAdvogado;
        this.resposta = resposta;
        this.horaEnvio = horaEnvio;
        this.setorEncaminhamento = setorEncaminhamento;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public EvolucaoJuridico() {
    }

    /**
     * @return the idEvo
     */
    public int getIdEvo() {
        return idEvo;
    }

    /**
     * @param idEvo the idEvo to set
     */
    public void setIdEvo(int idEvo) {
        this.idEvo = idEvo;
    }

    /**
     * @return the dataEvo
     */
    public Date getDataEvo() {
        return dataEvo;
    }

    /**
     * @param dataEvo the dataEvo to set
     */
    public void setDataEvo(Date dataEvo) {
        this.dataEvo = dataEvo;
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
     * @return the evolucao
     */
    public String getEvolucao() {
        return evolucao;
    }

    /**
     * @param evolucao the evolucao to set
     */
    public void setEvolucao(String evolucao) {
        this.evolucao = evolucao;
    }

    /**
     * @return the DataEnca
     */
    public Date getDataEnca() {
        return DataEnca;
    }

    /**
     * @param DataEnca the DataEnca to set
     */
    public void setDataEnca(Date DataEnca) {
        this.DataEnca = DataEnca;
    }

    /**
     * @return the tipoAdvogado
     */
    public String getTipoAdvogado() {
        return tipoAdvogado;
    }

    /**
     * @param tipoAdvogado the tipoAdvogado to set
     */
    public void setTipoAdvogado(String tipoAdvogado) {
        this.tipoAdvogado = tipoAdvogado;
    }

    /**
     * @return the resposta
     */
    public String getResposta() {
        return resposta;
    }

    /**
     * @param resposta the resposta to set
     */
    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    /**
     * @return the horaEnvio
     */
    public String getHoraEnvio() {
        return horaEnvio;
    }

    /**
     * @param horaEnvio the horaEnvio to set
     */
    public void setHoraEnvio(String horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    /**
     * @return the setorEncaminhamento
     */
    public String getSetorEncaminhamento() {
        return setorEncaminhamento;
    }

    /**
     * @param setorEncaminhamento the setorEncaminhamento to set
     */
    public void setSetorEncaminhamento(String setorEncaminhamento) {
        this.setorEncaminhamento = setorEncaminhamento;
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
