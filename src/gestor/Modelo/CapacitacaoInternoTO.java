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
public class CapacitacaoInternoTO {

    private int idCap;
    private Date dataRegistro;
    private String statusRegistro;
    private int idCurso;
    private String descricaoCurso;
    private String observacao;
    private int idInterno;
    private String nomeInterno;
    private Date dataInicio;
    private Date dataConclusao;
    private String cargaHoraria;
    private float notaAvaliacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private int idItemCap;
    private String situacaoCurso;
    private Float NotaAvalia;  

    public CapacitacaoInternoTO() {
    }

    public CapacitacaoInternoTO(int idCap, Date dataRegistro, String statusRegistro, int idCurso, String descricaoCurso, String observacao, int idInterno, String nomeInterno, Date dataInicio, Date dataConclusao, String cargaHoraria, float notaAvaliacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, int idItemCap, String situacaoCurso, Float NotaAvalia) {
        this.idCap = idCap;
        this.dataRegistro = dataRegistro;
        this.statusRegistro = statusRegistro;
        this.idCurso = idCurso;
        this.descricaoCurso = descricaoCurso;
        this.observacao = observacao;
        this.idInterno = idInterno;
        this.nomeInterno = nomeInterno;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.cargaHoraria = cargaHoraria;
        this.notaAvaliacao = notaAvaliacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.idItemCap = idItemCap;
        this.situacaoCurso = situacaoCurso;
        this.NotaAvalia = NotaAvalia;
    }

    /**
     * @return the idCap
     */
    public int getIdCap() {
        return idCap;
    }

    /**
     * @param idCap the idCap to set
     */
    public void setIdCap(int idCap) {
        this.idCap = idCap;
    }

    /**
     * @return the dataRegistro
     */
    public Date getDataRegistro() {
        return dataRegistro;
    }

    /**
     * @param dataRegistro the dataRegistro to set
     */
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    /**
     * @return the statusRegistro
     */
    public String getStatusRegistro() {
        return statusRegistro;
    }

    /**
     * @param statusRegistro the statusRegistro to set
     */
    public void setStatusRegistro(String statusRegistro) {
        this.statusRegistro = statusRegistro;
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
     * @return the idInterno
     */
    public int getIdInterno() {
        return idInterno;
    }

    /**
     * @param idInterno the idInterno to set
     */
    public void setIdInterno(int idInterno) {
        this.idInterno = idInterno;
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
     * @return the dataConclusao
     */
    public Date getDataConclusao() {
        return dataConclusao;
    }

    /**
     * @param dataConclusao the dataConclusao to set
     */
    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    /**
     * @return the cargaHoraria
     */
    public String getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @param cargaHoraria the cargaHoraria to set
     */
    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @return the notaAvaliacao
     */
    public float getNotaAvaliacao() {
        return notaAvaliacao;
    }

    /**
     * @param notaAvaliacao the notaAvaliacao to set
     */
    public void setNotaAvaliacao(float notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
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
     * @return the idItemCap
     */
    public int getIdItemCap() {
        return idItemCap;
    }

    /**
     * @param idItemCap the idItemCap to set
     */
    public void setIdItemCap(int idItemCap) {
        this.idItemCap = idItemCap;
    }

    /**
     * @return the situacaoCurso
     */
    public String getSituacaoCurso() {
        return situacaoCurso;
    }

    /**
     * @param situacaoCurso the situacaoCurso to set
     */
    public void setSituacaoCurso(String situacaoCurso) {
        this.situacaoCurso = situacaoCurso;
    }

    /**
     * @return the NotaAvalia
     */
    public Float getNotaAvalia() {
        return NotaAvalia;
    }

    /**
     * @param NotaAvalia the NotaAvalia to set
     */
    public void setNotaAvalia(Float NotaAvalia) {
        this.NotaAvalia = NotaAvalia;
    }
}
