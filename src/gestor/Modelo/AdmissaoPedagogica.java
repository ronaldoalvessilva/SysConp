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
public class AdmissaoPedagogica {

    private int idAdm;
    private String statusAdm;
    private Date dataAdm;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String ultimaEscola;
    private String serieAno;
    private String turno;
    private String observacao;
    private String deptoPedagogia;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public AdmissaoPedagogica(int idAdm, String statusAdm, Date dataAdm, int idInternoCrc, String nomeInternoCrc, String ultimaEscola, String serieAno, String turno, String observacao, String deptoPedagogia, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idAdm = idAdm;
        this.statusAdm = statusAdm;
        this.dataAdm = dataAdm;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.ultimaEscola = ultimaEscola;
        this.serieAno = serieAno;
        this.turno = turno;
        this.observacao = observacao;
        this.deptoPedagogia = deptoPedagogia;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AdmissaoPedagogica() {
    }

    /**
     * @return the idAdm
     */
    public int getIdAdm() {
        return idAdm;
    }

    /**
     * @param idAdm the idAdm to set
     */
    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
    }

    /**
     * @return the statusAdm
     */
    public String getStatusAdm() {
        return statusAdm;
    }

    /**
     * @param statusAdm the statusAdm to set
     */
    public void setStatusAdm(String statusAdm) {
        this.statusAdm = statusAdm;
    }

    /**
     * @return the dataAdm
     */
    public Date getDataAdm() {
        return dataAdm;
    }

    /**
     * @param dataAdm the dataAdm to set
     */
    public void setDataAdm(Date dataAdm) {
        this.dataAdm = dataAdm;
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
     * @return the ultimaEscola
     */
    public String getUltimaEscola() {
        return ultimaEscola;
    }

    /**
     * @param ultimaEscola the ultimaEscola to set
     */
    public void setUltimaEscola(String ultimaEscola) {
        this.ultimaEscola = ultimaEscola;
    }

    /**
     * @return the serieAno
     */
    public String getSerieAno() {
        return serieAno;
    }

    /**
     * @param serieAno the serieAno to set
     */
    public void setSerieAno(String serieAno) {
        this.serieAno = serieAno;
    }

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
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
     * @return the deptoPedagogia
     */
    public String getDeptoPedagogia() {
        return deptoPedagogia;
    }

    /**
     * @param deptoPedagogia the deptoPedagogia to set
     */
    public void setDeptoPedagogia(String deptoPedagogia) {
        this.deptoPedagogia = deptoPedagogia;
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
