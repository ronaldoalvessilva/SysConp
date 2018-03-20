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
public class VisitasOficialJusticaInternos {

    private int IdVisita;
    private int idLanc;
    private int IdOficial;
    private String nomeOficial;
    private int IdInternoCrc;
    private String nomeInterno;
    private Date DataEntrada;
    private String HorarioEntrada;
    private Date DataSaida;
    private String HorarioSaida;

    public VisitasOficialJusticaInternos(int IdVisita, int idLanc, int IdOficial, String nomeOficial, int IdInternoCrc, String nomeInterno, Date DataEntrada, String HorarioEntrada, Date DataSaida, String HorarioSaida) {
        this.IdVisita = IdVisita;
        this.idLanc = idLanc;
        this.IdOficial = IdOficial;
        this.nomeOficial = nomeOficial;
        this.IdInternoCrc = IdInternoCrc;
        this.nomeInterno = nomeInterno;
        this.DataEntrada = DataEntrada;
        this.HorarioEntrada = HorarioEntrada;
        this.DataSaida = DataSaida;
        this.HorarioSaida = HorarioSaida;
    }

    public VisitasOficialJusticaInternos() {
    }

    /**
     * @return the IdVisita
     */
    public int getIdVisita() {
        return IdVisita;
    }

    /**
     * @param IdVisita the IdVisita to set
     */
    public void setIdVisita(int IdVisita) {
        this.IdVisita = IdVisita;
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
     * @return the IdOficial
     */
    public int getIdOficial() {
        return IdOficial;
    }

    /**
     * @param IdOficial the IdOficial to set
     */
    public void setIdOficial(int IdOficial) {
        this.IdOficial = IdOficial;
    }

    /**
     * @return the nomeOficial
     */
    public String getNomeOficial() {
        return nomeOficial;
    }

    /**
     * @param nomeOficial the nomeOficial to set
     */
    public void setNomeOficial(String nomeOficial) {
        this.nomeOficial = nomeOficial;
    }

    /**
     * @return the IdInternoCrc
     */
    public int getIdInternoCrc() {
        return IdInternoCrc;
    }

    /**
     * @param IdInternoCrc the IdInternoCrc to set
     */
    public void setIdInternoCrc(int IdInternoCrc) {
        this.IdInternoCrc = IdInternoCrc;
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
     * @return the DataEntrada
     */
    public Date getDataEntrada() {
        return DataEntrada;
    }

    /**
     * @param DataEntrada the DataEntrada to set
     */
    public void setDataEntrada(Date DataEntrada) {
        this.DataEntrada = DataEntrada;
    }

    /**
     * @return the HorarioEntrada
     */
    public String getHorarioEntrada() {
        return HorarioEntrada;
    }

    /**
     * @param HorarioEntrada the HorarioEntrada to set
     */
    public void setHorarioEntrada(String HorarioEntrada) {
        this.HorarioEntrada = HorarioEntrada;
    }

    /**
     * @return the DataSaida
     */
    public Date getDataSaida() {
        return DataSaida;
    }

    /**
     * @param DataSaida the DataSaida to set
     */
    public void setDataSaida(Date DataSaida) {
        this.DataSaida = DataSaida;
    }

    /**
     * @return the HorarioSaida
     */
    public String getHorarioSaida() {
        return HorarioSaida;
    }

    /**
     * @param HorarioSaida the HorarioSaida to set
     */
    public void setHorarioSaida(String HorarioSaida) {
        this.HorarioSaida = HorarioSaida;
    }
}
