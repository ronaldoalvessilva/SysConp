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
public class ItensAgendaEscolta {

    private int IdItem;
    private int idAgenda;
    private int idInternoCrc;
    private String nomeInterno;
    private Date dataAgendamento;
    private String horarioAgenda;
    private String localAgenda;
    private String oficioAgenda;
    private String utilizaAgenda;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;    

    public ItensAgendaEscolta(int IdItem, int idAgenda, int idInternoCrc, String nomeInterno, Date dataAgendamento, String horarioAgenda, String localAgenda, String oficioAgenda, String utilizaAgenda, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp) {
        this.IdItem = IdItem;
        this.idAgenda = idAgenda;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.dataAgendamento = dataAgendamento;
        this.horarioAgenda = horarioAgenda;
        this.localAgenda = localAgenda;
        this.oficioAgenda = oficioAgenda;
        this.utilizaAgenda = utilizaAgenda;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
    }

    public ItensAgendaEscolta() {
    }

    /**
     * @return the IdItem
     */
    public int getIdItem() {
        return IdItem;
    }

    /**
     * @param IdItem the IdItem to set
     */
    public void setIdItem(int IdItem) {
        this.IdItem = IdItem;
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
     * @return the dataAgendamento
     */
    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    /**
     * @param dataAgendamento the dataAgendamento to set
     */
    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    /**
     * @return the horarioAgenda
     */
    public String getHorarioAgenda() {
        return horarioAgenda;
    }

    /**
     * @param horarioAgenda the horarioAgenda to set
     */
    public void setHorarioAgenda(String horarioAgenda) {
        this.horarioAgenda = horarioAgenda;
    }

    /**
     * @return the localAgenda
     */
    public String getLocalAgenda() {
        return localAgenda;
    }

    /**
     * @param localAgenda the localAgenda to set
     */
    public void setLocalAgenda(String localAgenda) {
        this.localAgenda = localAgenda;
    }

    /**
     * @return the oficioAgenda
     */
    public String getOficioAgenda() {
        return oficioAgenda;
    }

    /**
     * @param oficioAgenda the oficioAgenda to set
     */
    public void setOficioAgenda(String oficioAgenda) {
        this.oficioAgenda = oficioAgenda;
    }

    /**
     * @return the utilizaAgenda
     */
    public String getUtilizaAgenda() {
        return utilizaAgenda;
    }

    /**
     * @param utilizaAgenda the utilizaAgenda to set
     */
    public void setUtilizaAgenda(String utilizaAgenda) {
        this.utilizaAgenda = utilizaAgenda;
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
}
