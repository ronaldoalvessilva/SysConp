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
    private int idCurso;
    private String descricaoCurso;
    private int DiaSeg;
    private int DiaTer;
    private int DiaQua;
    private int DiaQui;
    private int DiaSex;
    private int DiaSab;
    private int DiaDom;

    public AssistenciaEducativa() {
    }

    public AssistenciaEducativa(int idEduca, String statusLanc, Date dataLanc, int idCod, String descricaoInstituicao, int idTurno, String descricaoTurno, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, int idCurso, String descricaoCurso, int DiaSeg, int DiaTer, int DiaQua, int DiaQui, int DiaSex, int DiaSab, int DiaDom) {
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
        this.idCurso = idCurso;
        this.descricaoCurso = descricaoCurso;
        this.DiaSeg = DiaSeg;
        this.DiaTer = DiaTer;
        this.DiaQua = DiaQua;
        this.DiaQui = DiaQui;
        this.DiaSex = DiaSex;
        this.DiaSab = DiaSab;
        this.DiaDom = DiaDom;
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

    /**
     * @return the idCurso
     */
    public int getIdCurso() {
        return idCurso;
    }

    /**
     * @param idCurso the idCurso to set
     */
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * @return the descricaoCurso
     */
    public String getDescricaoCurso() {
        return descricaoCurso;
    }

    /**
     * @param descricaoCurso the descricaoCurso to set
     */
    public void setDescricaoCurso(String descricaoCurso) {
        this.descricaoCurso = descricaoCurso;
    }

    /**
     * @return the DiaSeg
     */
    public int getDiaSeg() {
        return DiaSeg;
    }

    /**
     * @param DiaSeg the DiaSeg to set
     */
    public void setDiaSeg(int DiaSeg) {
        this.DiaSeg = DiaSeg;
    }

    /**
     * @return the DiaTer
     */
    public int getDiaTer() {
        return DiaTer;
    }

    /**
     * @param DiaTer the DiaTer to set
     */
    public void setDiaTer(int DiaTer) {
        this.DiaTer = DiaTer;
    }

    /**
     * @return the DiaQua
     */
    public int getDiaQua() {
        return DiaQua;
    }

    /**
     * @param DiaQua the DiaQua to set
     */
    public void setDiaQua(int DiaQua) {
        this.DiaQua = DiaQua;
    }

    /**
     * @return the DiaQui
     */
    public int getDiaQui() {
        return DiaQui;
    }

    /**
     * @param DiaQui the DiaQui to set
     */
    public void setDiaQui(int DiaQui) {
        this.DiaQui = DiaQui;
    }

    /**
     * @return the DiaSex
     */
    public int getDiaSex() {
        return DiaSex;
    }

    /**
     * @param DiaSex the DiaSex to set
     */
    public void setDiaSex(int DiaSex) {
        this.DiaSex = DiaSex;
    }

    /**
     * @return the DiaSab
     */
    public int getDiaSab() {
        return DiaSab;
    }

    /**
     * @param DiaSab the DiaSab to set
     */
    public void setDiaSab(int DiaSab) {
        this.DiaSab = DiaSab;
    }

    /**
     * @return the DiaDom
     */
    public int getDiaDom() {
        return DiaDom;
    }

    /**
     * @param DiaDom the DiaDom to set
     */
    public void setDiaDom(int DiaDom) {
        this.DiaDom = DiaDom;
    }
}
