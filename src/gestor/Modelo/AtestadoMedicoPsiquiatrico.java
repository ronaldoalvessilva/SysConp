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
public class AtestadoMedicoPsiquiatrico {

    private int idItem;
    private Date dataAtesta;
    private int modeloAtestado;
    private String statusLanc;
    private int idInternoCrc;
    private int idLanc;
    private String textoAtestado;
    private String deptoMedico;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public AtestadoMedicoPsiquiatrico(int idItem, Date dataAtesta, int modeloAtestado, String statusLanc, int idInternoCrc, int idLanc, String textoAtestado, String deptoMedico, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.dataAtesta = dataAtesta;
        this.modeloAtestado = modeloAtestado;
        this.statusLanc = statusLanc;
        this.idInternoCrc = idInternoCrc;
        this.idLanc = idLanc;
        this.textoAtestado = textoAtestado;
        this.deptoMedico = deptoMedico;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AtestadoMedicoPsiquiatrico() {
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
     * @return the dataAtesta
     */
    public Date getDataAtesta() {
        return dataAtesta;
    }

    /**
     * @param dataAtesta the dataAtesta to set
     */
    public void setDataAtesta(Date dataAtesta) {
        this.dataAtesta = dataAtesta;
    }

    /**
     * @return the modeloAtestado
     */
    public int getModeloAtestado() {
        return modeloAtestado;
    }

    /**
     * @param modeloAtestado the modeloAtestado to set
     */
    public void setModeloAtestado(int modeloAtestado) {
        this.modeloAtestado = modeloAtestado;
    }

    /**
     * @return the statusLanc
     */
    public String getStatusLanc() {
        return statusLanc;
    }

    /**
     * @param statusLanc the statusLanc to set
     */
    public void setStatusLanc(String statusLanc) {
        this.statusLanc = statusLanc;
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
     * @return the textoAtestado
     */
    public String getTextoAtestado() {
        return textoAtestado;
    }

    /**
     * @param textoAtestado the textoAtestado to set
     */
    public void setTextoAtestado(String textoAtestado) {
        this.textoAtestado = textoAtestado;
    }

    /**
     * @return the deptoMedico
     */
    public String getDeptoMedico() {
        return deptoMedico;
    }

    /**
     * @param deptoMedico the deptoMedico to set
     */
    public void setDeptoMedico(String deptoMedico) {
        this.deptoMedico = deptoMedico;
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
