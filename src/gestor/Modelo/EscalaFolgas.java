/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronal
 */
public class EscalaFolgas {
    private Integer idRegistro;
    private Integer idEscala;
    private Integer idFunc;
    private String nomeFuncEscala;
    private String statusEscala;
    private Date dataCadastro;
    private Integer quantidadeTrab;
    private Integer quantidadeFolga;
    private String descricaoEscala;
    private String turno;
    private String turma;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;
    private int idCrono;
    private String PrimeiroApt;
    private String SegundoApt;
    private Date dataInicial;
    private Date dataFinal;
    private Date dataPrimeiraFolga;
    private Date dataCronograma;
    private String StatusTrabFolga;
    private String horarioInicial;
    private String horarioFinal;
    private String mesReferencia;
    private String anoReferencia;

    public EscalaFolgas() {
    }

    public EscalaFolgas(Integer idRegistro, Integer idEscala, Integer idFunc, String nomeFuncEscala, String statusEscala, Date dataCadastro, Integer quantidadeTrab, Integer quantidadeFolga, String descricaoEscala, String turno, String turma, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp, int idCrono, String PrimeiroApt, String SegundoApt, Date dataInicial, Date dataFinal, Date dataPrimeiraFolga, Date dataCronograma, String StatusTrabFolga, String horarioInicial, String horarioFinal, String mesReferencia, String anoReferencia) {
        this.idRegistro = idRegistro;
        this.idEscala = idEscala;
        this.idFunc = idFunc;
        this.nomeFuncEscala = nomeFuncEscala;
        this.statusEscala = statusEscala;
        this.dataCadastro = dataCadastro;
        this.quantidadeTrab = quantidadeTrab;
        this.quantidadeFolga = quantidadeFolga;
        this.descricaoEscala = descricaoEscala;
        this.turno = turno;
        this.turma = turma;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
        this.idCrono = idCrono;
        this.PrimeiroApt = PrimeiroApt;
        this.SegundoApt = SegundoApt;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.dataPrimeiraFolga = dataPrimeiraFolga;
        this.dataCronograma = dataCronograma;
        this.StatusTrabFolga = StatusTrabFolga;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.mesReferencia = mesReferencia;
        this.anoReferencia = anoReferencia;
    }

    /**
     * @return the idRegistro
     */
    public Integer getIdRegistro() {
        return idRegistro;
    }

    /**
     * @param idRegistro the idRegistro to set
     */
    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    /**
     * @return the idEscala
     */
    public Integer getIdEscala() {
        return idEscala;
    }

    /**
     * @param idEscala the idEscala to set
     */
    public void setIdEscala(Integer idEscala) {
        this.idEscala = idEscala;
    }

    /**
     * @return the idFunc
     */
    public Integer getIdFunc() {
        return idFunc;
    }

    /**
     * @param idFunc the idFunc to set
     */
    public void setIdFunc(Integer idFunc) {
        this.idFunc = idFunc;
    }

    /**
     * @return the nomeFuncEscala
     */
    public String getNomeFuncEscala() {
        return nomeFuncEscala;
    }

    /**
     * @param nomeFuncEscala the nomeFuncEscala to set
     */
    public void setNomeFuncEscala(String nomeFuncEscala) {
        this.nomeFuncEscala = nomeFuncEscala;
    }

    /**
     * @return the statusEscala
     */
    public String getStatusEscala() {
        return statusEscala;
    }

    /**
     * @param statusEscala the statusEscala to set
     */
    public void setStatusEscala(String statusEscala) {
        this.statusEscala = statusEscala;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the quantidadeTrab
     */
    public Integer getQuantidadeTrab() {
        return quantidadeTrab;
    }

    /**
     * @param quantidadeTrab the quantidadeTrab to set
     */
    public void setQuantidadeTrab(Integer quantidadeTrab) {
        this.quantidadeTrab = quantidadeTrab;
    }

    /**
     * @return the quantidadeFolga
     */
    public Integer getQuantidadeFolga() {
        return quantidadeFolga;
    }

    /**
     * @param quantidadeFolga the quantidadeFolga to set
     */
    public void setQuantidadeFolga(Integer quantidadeFolga) {
        this.quantidadeFolga = quantidadeFolga;
    }

    /**
     * @return the descricaoEscala
     */
    public String getDescricaoEscala() {
        return descricaoEscala;
    }

    /**
     * @param descricaoEscala the descricaoEscala to set
     */
    public void setDescricaoEscala(String descricaoEscala) {
        this.descricaoEscala = descricaoEscala;
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
     * @return the turma
     */
    public String getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(String turma) {
        this.turma = turma;
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

    /**
     * @return the idCrono
     */
    public int getIdCrono() {
        return idCrono;
    }

    /**
     * @param idCrono the idCrono to set
     */
    public void setIdCrono(int idCrono) {
        this.idCrono = idCrono;
    }

    /**
     * @return the PrimeiroApt
     */
    public String getPrimeiroApt() {
        return PrimeiroApt;
    }

    /**
     * @param PrimeiroApt the PrimeiroApt to set
     */
    public void setPrimeiroApt(String PrimeiroApt) {
        this.PrimeiroApt = PrimeiroApt;
    }

    /**
     * @return the SegundoApt
     */
    public String getSegundoApt() {
        return SegundoApt;
    }

    /**
     * @param SegundoApt the SegundoApt to set
     */
    public void setSegundoApt(String SegundoApt) {
        this.SegundoApt = SegundoApt;
    }

    /**
     * @return the dataInicial
     */
    public Date getDataInicial() {
        return dataInicial;
    }

    /**
     * @param dataInicial the dataInicial to set
     */
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    /**
     * @return the dataFinal
     */
    public Date getDataFinal() {
        return dataFinal;
    }

    /**
     * @param dataFinal the dataFinal to set
     */
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    /**
     * @return the dataPrimeiraFolga
     */
    public Date getDataPrimeiraFolga() {
        return dataPrimeiraFolga;
    }

    /**
     * @param dataPrimeiraFolga the dataPrimeiraFolga to set
     */
    public void setDataPrimeiraFolga(Date dataPrimeiraFolga) {
        this.dataPrimeiraFolga = dataPrimeiraFolga;
    }

    /**
     * @return the dataCronograma
     */
    public Date getDataCronograma() {
        return dataCronograma;
    }

    /**
     * @param dataCronograma the dataCronograma to set
     */
    public void setDataCronograma(Date dataCronograma) {
        this.dataCronograma = dataCronograma;
    }

    /**
     * @return the StatusTrabFolga
     */
    public String getStatusTrabFolga() {
        return StatusTrabFolga;
    }

    /**
     * @param StatusTrabFolga the StatusTrabFolga to set
     */
    public void setStatusTrabFolga(String StatusTrabFolga) {
        this.StatusTrabFolga = StatusTrabFolga;
    }

    /**
     * @return the horarioInicial
     */
    public String getHorarioInicial() {
        return horarioInicial;
    }

    /**
     * @param horarioInicial the horarioInicial to set
     */
    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    /**
     * @return the horarioFinal
     */
    public String getHorarioFinal() {
        return horarioFinal;
    }

    /**
     * @param horarioFinal the horarioFinal to set
     */
    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    /**
     * @return the mesReferencia
     */
    public String getMesReferencia() {
        return mesReferencia;
    }

    /**
     * @param mesReferencia the mesReferencia to set
     */
    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    /**
     * @return the anoReferencia
     */
    public String getAnoReferencia() {
        return anoReferencia;
    }

    /**
     * @param anoReferencia the anoReferencia to set
     */
    public void setAnoReferencia(String anoReferencia) {
        this.anoReferencia = anoReferencia;
    }
}
