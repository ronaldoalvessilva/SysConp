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
public class ItensAgendaAtendimentoInternos {

    private int idItem;
    private int idReg;
    private int idInternoCrc;
    private String nomeInternoAgenda;
    private String departamento;
    private Date dataAg;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String HorarioUp;

    public ItensAgendaAtendimentoInternos(int idItem, int idReg, int idInternoCrc, String nomeInternoAgenda, String departamento, Date dataAg, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String HorarioUp) {
        this.idItem = idItem;
        this.idReg = idReg;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoAgenda = nomeInternoAgenda;
        this.departamento = departamento;
        this.dataAg = dataAg;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.HorarioUp = HorarioUp;
    }

    public ItensAgendaAtendimentoInternos() {
    }

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
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
     * @return the nomeInternoAgenda
     */
    public String getNomeInternoAgenda() {
        return nomeInternoAgenda;
    }

    /**
     * @param nomeInternoAgenda the nomeInternoAgenda to set
     */
    public void setNomeInternoAgenda(String nomeInternoAgenda) {
        this.nomeInternoAgenda = nomeInternoAgenda;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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
     * @return the HorarioUp
     */
    public String getHorarioUp() {
        return HorarioUp;
    }

    /**
     * @param HorarioUp the HorarioUp to set
     */
    public void setHorarioUp(String HorarioUp) {
        this.HorarioUp = HorarioUp;
    }
}
