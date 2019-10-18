/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Socializa TI 02
 */
public class TratamentoPsicologico {

    private int idTRAT;
    private String statusTrat;
    private Date dataTrat;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int ID_REGISTRO_ATEND_EVOL;
    private int idTipo;
    private Date dataInicio;
    private Date dataTermino;
    private String textoTratamento;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;   

    public TratamentoPsicologico() {
    }

    public TratamentoPsicologico(int idTRAT, String statusTrat, Date dataTrat, int idInternoCrc, String nomeInternoCrc, int ID_REGISTRO_ATEND_EVOL, int idTipo, Date dataInicio, Date dataTermino, String textoTratamento, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp) {
        this.idTRAT = idTRAT;
        this.statusTrat = statusTrat;
        this.dataTrat = dataTrat;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.ID_REGISTRO_ATEND_EVOL = ID_REGISTRO_ATEND_EVOL;
        this.idTipo = idTipo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.textoTratamento = textoTratamento;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idTRAT
     */
    public int getIdTRAT() {
        return idTRAT;
    }

    /**
     * @param idTRAT the idTRAT to set
     */
    public void setIdTRAT(int idTRAT) {
        this.idTRAT = idTRAT;
    }

    /**
     * @return the statusTrat
     */
    public String getStatusTrat() {
        return statusTrat;
    }

    /**
     * @param statusTrat the statusTrat to set
     */
    public void setStatusTrat(String statusTrat) {
        this.statusTrat = statusTrat;
    }

    /**
     * @return the dataTrat
     */
    public Date getDataTrat() {
        return dataTrat;
    }

    /**
     * @param dataTrat the dataTrat to set
     */
    public void setDataTrat(Date dataTrat) {
        this.dataTrat = dataTrat;
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
     * @return the ID_REGISTRO_ATEND_EVOL
     */
    public int getID_REGISTRO_ATEND_EVOL() {
        return ID_REGISTRO_ATEND_EVOL;
    }

    /**
     * @param ID_REGISTRO_ATEND_EVOL the ID_REGISTRO_ATEND_EVOL to set
     */
    public void setID_REGISTRO_ATEND_EVOL(int ID_REGISTRO_ATEND_EVOL) {
        this.ID_REGISTRO_ATEND_EVOL = ID_REGISTRO_ATEND_EVOL;
    }

    /**
     * @return the idTipo
     */
    public int getIdTipo() {
        return idTipo;
    }

    /**
     * @param idTipo the idTipo to set
     */
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
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
     * @return the textoTratamento
     */
    public String getTextoTratamento() {
        return textoTratamento;
    }

    /**
     * @param textoTratamento the textoTratamento to set
     */
    public void setTextoTratamento(String textoTratamento) {
        this.textoTratamento = textoTratamento;
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
