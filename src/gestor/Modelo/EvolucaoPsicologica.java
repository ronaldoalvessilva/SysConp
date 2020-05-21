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
public class EvolucaoPsicologica {

    private int idEvolucao;
    private String statusEvo;
    private Date dataEvolucao;
    private int idLanc;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String historico;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;   
    private Date dataEncaminhamento;
    private String horaEncaminhamento;
    private String nomeDepartamento;  
    private String AdmEvo;

    public EvolucaoPsicologica() {
    }

    public EvolucaoPsicologica(int idEvolucao, String statusEvo, Date dataEvolucao, int idLanc, int idInternoCrc, String nomeInternoCrc, String historico, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp, Date dataEncaminhamento, String horaEncaminhamento, String nomeDepartamento, String AdmEvo) {
        this.idEvolucao = idEvolucao;
        this.statusEvo = statusEvo;
        this.dataEvolucao = dataEvolucao;
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.historico = historico;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.dataEncaminhamento = dataEncaminhamento;
        this.horaEncaminhamento = horaEncaminhamento;
        this.nomeDepartamento = nomeDepartamento;
        this.AdmEvo = AdmEvo;
    }

    /**
     * @return the idEvolucao
     */
    public int getIdEvolucao() {
        return idEvolucao;
    }

    /**
     * @param idEvolucao the idEvolucao to set
     */
    public void setIdEvolucao(int idEvolucao) {
        this.idEvolucao = idEvolucao;
    }

    /**
     * @return the statusEvo
     */
    public String getStatusEvo() {
        return statusEvo;
    }

    /**
     * @param statusEvo the statusEvo to set
     */
    public void setStatusEvo(String statusEvo) {
        this.statusEvo = statusEvo;
    }

    /**
     * @return the dataEvolucao
     */
    public Date getDataEvolucao() {
        return dataEvolucao;
    }

    /**
     * @param dataEvolucao the dataEvolucao to set
     */
    public void setDataEvolucao(Date dataEvolucao) {
        this.dataEvolucao = dataEvolucao;
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
     * @return the historico
     */
    public String getHistorico() {
        return historico;
    }

    /**
     * @param historico the historico to set
     */
    public void setHistorico(String historico) {
        this.historico = historico;
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
     * @return the usuarioDelete
     */
    public String getUsuarioDelete() {
        return usuarioDelete;
    }

    /**
     * @param usuarioDelete the usuarioDelete to set
     */
    public void setUsuarioDelete(String usuarioDelete) {
        this.usuarioDelete = usuarioDelete;
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
     * @return the dataDelete
     */
    public String getDataDelete() {
        return dataDelete;
    }

    /**
     * @param dataDelete the dataDelete to set
     */
    public void setDataDelete(String dataDelete) {
        this.dataDelete = dataDelete;
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
     * @return the dataEncaminhamento
     */
    public Date getDataEncaminhamento() {
        return dataEncaminhamento;
    }

    /**
     * @param dataEncaminhamento the dataEncaminhamento to set
     */
    public void setDataEncaminhamento(Date dataEncaminhamento) {
        this.dataEncaminhamento = dataEncaminhamento;
    }

    /**
     * @return the horaEncaminhamento
     */
    public String getHoraEncaminhamento() {
        return horaEncaminhamento;
    }

    /**
     * @param horaEncaminhamento the horaEncaminhamento to set
     */
    public void setHoraEncaminhamento(String horaEncaminhamento) {
        this.horaEncaminhamento = horaEncaminhamento;
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
     * @return the AdmEvo
     */
    public String getAdmEvo() {
        return AdmEvo;
    }

    /**
     * @param AdmEvo the AdmEvo to set
     */
    public void setAdmEvo(String AdmEvo) {
        this.AdmEvo = AdmEvo;
    }
}
