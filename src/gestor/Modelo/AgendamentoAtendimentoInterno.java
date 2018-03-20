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
public class AgendamentoAtendimentoInterno {

    private int idReg;
    private String statusReg;
    private Date dataReg;
    private String departamentoAgendamento;
    private Date dataAg;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public AgendamentoAtendimentoInterno(int idReg, String statusReg, Date dataReg, String departamentoAgendamento, Date dataAg, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idReg = idReg;
        this.statusReg = statusReg;
        this.dataReg = dataReg;
        this.departamentoAgendamento = departamentoAgendamento;
        this.dataAg = dataAg;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AgendamentoAtendimentoInterno() {
    }

    /**
     * @return the idReg
     */
    public int getIdReg() {
        return idReg;
    }

    /**
     * @param idReg the idReg to set
     */
    public void setIdReg(int idReg) {
        this.idReg = idReg;
    }

    /**
     * @return the statusReg
     */
    public String getStatusReg() {
        return statusReg;
    }

    /**
     * @param statusReg the statusReg to set
     */
    public void setStatusReg(String statusReg) {
        this.statusReg = statusReg;
    }

    /**
     * @return the dataReg
     */
    public Date getDataReg() {
        return dataReg;
    }

    /**
     * @param dataReg the dataReg to set
     */
    public void setDataReg(Date dataReg) {
        this.dataReg = dataReg;
    }

    /**
     * @return the departamentoAgendamento
     */
    public String getDepartamentoAgendamento() {
        return departamentoAgendamento;
    }

    /**
     * @param departamentoAgendamento the departamentoAgendamento to set
     */
    public void setDepartamentoAgendamento(String departamentoAgendamento) {
        this.departamentoAgendamento = departamentoAgendamento;
    }

    /**
     * @return the dataAg
     */
    public Date getDataAg() {
        return dataAg;
    }

    /**
     * @param dataAg the dataAg to set
     */
    public void setDataAg(Date dataAg) {
        this.dataAg = dataAg;
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
