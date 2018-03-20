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
public class AgendaCompromissos {

    private int idAgenda;
    private String statusAgenda;
    private String tipoEvento;
    private Date dataAgenda;
    private String assunto;
    private String prioridade;
    private String conclusao;
    private Date dataInicio;
    private Date dataTermino;
    private String horaInicio;
    private String horaTermino;
    private Date dataLembrete;
    private String horaLembrete;
    private String texto;
    private String usuarioAgenda;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public AgendaCompromissos(int idAgenda, String statusAgenda, String tipoEvento, Date dataAgenda, String assunto, String prioridade, String conclusao, Date dataInicio, Date dataTermino, String horaInicio, String horaTermino, Date dataLembrete, String horaLembrete, String texto, String usuarioAgenda, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idAgenda = idAgenda;
        this.statusAgenda = statusAgenda;
        this.tipoEvento = tipoEvento;
        this.dataAgenda = dataAgenda;
        this.assunto = assunto;
        this.prioridade = prioridade;
        this.conclusao = conclusao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.dataLembrete = dataLembrete;
        this.horaLembrete = horaLembrete;
        this.texto = texto;
        this.usuarioAgenda = usuarioAgenda;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AgendaCompromissos() {
    }

    /**
     * @return the idAgenda
     */
    public int getIdAgenda() {
        return idAgenda;
    }

    /**
     * @param idAgenda the idAgenda to set
     */
    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    /**
     * @return the statusAgenda
     */
    public String getStatusAgenda() {
        return statusAgenda;
    }

    /**
     * @param statusAgenda the statusAgenda to set
     */
    public void setStatusAgenda(String statusAgenda) {
        this.statusAgenda = statusAgenda;
    }

    /**
     * @return the tipoEvento
     */
    public String getTipoEvento() {
        return tipoEvento;
    }

    /**
     * @param tipoEvento the tipoEvento to set
     */
    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    /**
     * @return the dataAgenda
     */
    public Date getDataAgenda() {
        return dataAgenda;
    }

    /**
     * @param dataAgenda the dataAgenda to set
     */
    public void setDataAgenda(Date dataAgenda) {
        this.dataAgenda = dataAgenda;
    }

    /**
     * @return the assunto
     */
    public String getAssunto() {
        return assunto;
    }

    /**
     * @param assunto the assunto to set
     */
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    /**
     * @return the prioridade
     */
    public String getPrioridade() {
        return prioridade;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    /**
     * @return the conclusao
     */
    public String getConclusao() {
        return conclusao;
    }

    /**
     * @param conclusao the conclusao to set
     */
    public void setConclusao(String conclusao) {
        this.conclusao = conclusao;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataTermino
     */
    public Date getDataTermino() {
        return dataTermino;
    }

    /**
     * @param dataTermino the dataTermino to set
     */
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    /**
     * @return the horaInicio
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaTermino
     */
    public String getHoraTermino() {
        return horaTermino;
    }

    /**
     * @param horaTermino the horaTermino to set
     */
    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }

    /**
     * @return the dataLembrete
     */
    public Date getDataLembrete() {
        return dataLembrete;
    }

    /**
     * @param dataLembrete the dataLembrete to set
     */
    public void setDataLembrete(Date dataLembrete) {
        this.dataLembrete = dataLembrete;
    }

    /**
     * @return the horaLembrete
     */
    public String getHoraLembrete() {
        return horaLembrete;
    }

    /**
     * @param horaLembrete the horaLembrete to set
     */
    public void setHoraLembrete(String horaLembrete) {
        this.horaLembrete = horaLembrete;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the usuarioAgenda
     */
    public String getUsuarioAgenda() {
        return usuarioAgenda;
    }

    /**
     * @param usuarioAgenda the usuarioAgenda to set
     */
    public void setUsuarioAgenda(String usuarioAgenda) {
        this.usuarioAgenda = usuarioAgenda;
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
