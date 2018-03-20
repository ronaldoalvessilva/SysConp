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
public class EntradaSaidaOficialJusticaInternos {

    private int idLanc;
    private Date DataLanc;
    private int IdOficialJustica;
    private String nomeOficialJustica;
    private String StatusLanc;
    private String ObsLanc;
    private Date dataEntrada;
    private String horarioEntrada;
    private Date dataSaida;
    private String horarioSaida;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;   

    public EntradaSaidaOficialJusticaInternos(int idLanc, Date DataLanc, int IdOficialJustica, String nomeOficialJustica, String StatusLanc, String ObsLanc, Date dataEntrada, String horarioEntrada, Date dataSaida, String horarioSaida, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento) {
        this.idLanc = idLanc;
        this.DataLanc = DataLanc;
        this.IdOficialJustica = IdOficialJustica;
        this.nomeOficialJustica = nomeOficialJustica;
        this.StatusLanc = StatusLanc;
        this.ObsLanc = ObsLanc;
        this.dataEntrada = dataEntrada;
        this.horarioEntrada = horarioEntrada;
        this.dataSaida = dataSaida;
        this.horarioSaida = horarioSaida;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
    }

    public EntradaSaidaOficialJusticaInternos() {
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
     * @return the DataLanc
     */
    public Date getDataLanc() {
        return DataLanc;
    }

    /**
     * @param DataLanc the DataLanc to set
     */
    public void setDataLanc(Date DataLanc) {
        this.DataLanc = DataLanc;
    }

    /**
     * @return the IdOficialJustica
     */
    public int getIdOficialJustica() {
        return IdOficialJustica;
    }

    /**
     * @param IdOficialJustica the IdOficialJustica to set
     */
    public void setIdOficialJustica(int IdOficialJustica) {
        this.IdOficialJustica = IdOficialJustica;
    }

    /**
     * @return the nomeOficialJustica
     */
    public String getNomeOficialJustica() {
        return nomeOficialJustica;
    }

    /**
     * @param nomeOficialJustica the nomeOficialJustica to set
     */
    public void setNomeOficialJustica(String nomeOficialJustica) {
        this.nomeOficialJustica = nomeOficialJustica;
    }

    /**
     * @return the StatusLanc
     */
    public String getStatusLanc() {
        return StatusLanc;
    }

    /**
     * @param StatusLanc the StatusLanc to set
     */
    public void setStatusLanc(String StatusLanc) {
        this.StatusLanc = StatusLanc;
    }

    /**
     * @return the ObsLanc
     */
    public String getObsLanc() {
        return ObsLanc;
    }

    /**
     * @param ObsLanc the ObsLanc to set
     */
    public void setObsLanc(String ObsLanc) {
        this.ObsLanc = ObsLanc;
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
     * @return the horarioEntrada
     */
    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    /**
     * @param horarioEntrada the horarioEntrada to set
     */
    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
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

    /**
     * @return the dataFechamento
     */
    public String getDataFechamento() {
        return dataFechamento;
    }

    /**
     * @param dataFechamento the dataFechamento to set
     */
    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    /**
     * @return the horaFechamento
     */
    public String getHoraFechamento() {
        return horaFechamento;
    }

    /**
     * @param horaFechamento the horaFechamento to set
     */
    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }
}
