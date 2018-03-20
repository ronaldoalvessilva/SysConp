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
public class AssistenciaEducativa {

    private int idEduca;
    private String statusLanc;
    private Date dataLanc;
    private int idCod;
    private String descricaoInstituicao;
    private int idTurno;
    private String descricaoTurno;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public AssistenciaEducativa(int idEduca, String statusLanc, Date dataLanc, int idCod, String descricaoInstituicao, int idTurno, String descricaoTurno, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idEduca = idEduca;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.idCod = idCod;
        this.descricaoInstituicao = descricaoInstituicao;
        this.idTurno = idTurno;
        this.descricaoTurno = descricaoTurno;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AssistenciaEducativa() {
    }

    /**
     * @return the idEduca
     */
    public int getIdEduca() {
        return idEduca;
    }

    /**
     * @param idEduca the idEduca to set
     */
    public void setIdEduca(int idEduca) {
        this.idEduca = idEduca;
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
     * @return the dataLanc
     */
    public Date getDataLanc() {
        return dataLanc;
    }

    /**
     * @param dataLanc the dataLanc to set
     */
    public void setDataLanc(Date dataLanc) {
        this.dataLanc = dataLanc;
    }

    /**
     * @return the idCod
     */
    public int getIdCod() {
        return idCod;
    }

    /**
     * @param idCod the idCod to set
     */
    public void setIdCod(int idCod) {
        this.idCod = idCod;
    }

    /**
     * @return the descricaoInstituicao
     */
    public String getDescricaoInstituicao() {
        return descricaoInstituicao;
    }

    /**
     * @param descricaoInstituicao the descricaoInstituicao to set
     */
    public void setDescricaoInstituicao(String descricaoInstituicao) {
        this.descricaoInstituicao = descricaoInstituicao;
    }

    /**
     * @return the idTurno
     */
    public int getIdTurno() {
        return idTurno;
    }

    /**
     * @param idTurno the idTurno to set
     */
    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    /**
     * @return the descricaoTurno
     */
    public String getDescricaoTurno() {
        return descricaoTurno;
    }

    /**
     * @param descricaoTurno the descricaoTurno to set
     */
    public void setDescricaoTurno(String descricaoTurno) {
        this.descricaoTurno = descricaoTurno;
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
