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
public class FrequenciaCapacitacaoInterno {

    private int idFreqCap;
    private Date dataRegistro;
    private String statusRegistro;
    private int idCurso;
    private String descricaoCurso;
    private String localCurso;
    private String observacao;
    private int idItemFreqCap;
    private Float NotaAvalia;
    private int idInterno;
    private String nomeInterno;
    private Date dataEntrada;
    private Date dataSaida;
    private String horariaEntrada;
    private String horarioSaida;
    private float notaAvaliacao;
    private String frequencia;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;    

    public FrequenciaCapacitacaoInterno() {
    }

    public FrequenciaCapacitacaoInterno(int idFreqCap, Date dataRegistro, String statusRegistro, int idCurso, String descricaoCurso, String localCurso, String observacao, int idItemFreqCap, Float NotaAvalia, int idInterno, String nomeInterno, Date dataEntrada, Date dataSaida, String horariaEntrada, String horarioSaida, float notaAvaliacao, String frequencia, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idFreqCap = idFreqCap;
        this.dataRegistro = dataRegistro;
        this.statusRegistro = statusRegistro;
        this.idCurso = idCurso;
        this.descricaoCurso = descricaoCurso;
        this.localCurso = localCurso;
        this.observacao = observacao;
        this.idItemFreqCap = idItemFreqCap;
        this.NotaAvalia = NotaAvalia;
        this.idInterno = idInterno;
        this.nomeInterno = nomeInterno;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.horariaEntrada = horariaEntrada;
        this.horarioSaida = horarioSaida;
        this.notaAvaliacao = notaAvaliacao;
        this.frequencia = frequencia;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idFreqCap
     */
    public int getIdFreqCap() {
        return idFreqCap;
    }

    /**
     * @param idFreqCap the idFreqCap to set
     */
    public void setIdFreqCap(int idFreqCap) {
        this.idFreqCap = idFreqCap;
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
     * @return the localCurso
     */
    public String getLocalCurso() {
        return localCurso;
    }

    /**
     * @param localCurso the localCurso to set
     */
    public void setLocalCurso(String localCurso) {
        this.localCurso = localCurso;
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
     * @return the idItemFreqCap
     */
    public int getIdItemFreqCap() {
        return idItemFreqCap;
    }

    /**
     * @param idItemFreqCap the idItemFreqCap to set
     */
    public void setIdItemFreqCap(int idItemFreqCap) {
        this.idItemFreqCap = idItemFreqCap;
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
     * @return the dataEntrada
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the dataSaida
     */
    public Date getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * @return the horariaEntrada
     */
    public String getHorariaEntrada() {
        return horariaEntrada;
    }

    /**
     * @param horariaEntrada the horariaEntrada to set
     */
    public void setHorariaEntrada(String horariaEntrada) {
        this.horariaEntrada = horariaEntrada;
    }

    /**
     * @return the horarioSaida
     */
    public String getHorarioSaida() {
        return horarioSaida;
    }

    /**
     * @param horarioSaida the horarioSaida to set
     */
    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
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
     * @return the frequencia
     */
    public String getFrequencia() {
        return frequencia;
    }

    /**
     * @param frequencia the frequencia to set
     */
    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
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
