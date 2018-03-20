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
public class VisitasReligiosasPortaria {

    private int idLanc;
    private int IdIstituicao;
    private String nomeIstituicao;
    private int IdVisitaRel;
    private String nomeVisitaRel;
    private Date DataEntrada;
    private String HorarioEntrada;
    private Date DataSaida;
    private String HorarioSaida;

    public VisitasReligiosasPortaria(int idLanc, int IdIstituicao, String nomeIstituicao, int IdVisitaRel, String nomeVisitaRel, Date DataEntrada, String HorarioEntrada, Date DataSaida, String HorarioSaida) {
        this.idLanc = idLanc;
        this.IdIstituicao = IdIstituicao;
        this.nomeIstituicao = nomeIstituicao;
        this.IdVisitaRel = IdVisitaRel;
        this.nomeVisitaRel = nomeVisitaRel;
        this.DataEntrada = DataEntrada;
        this.HorarioEntrada = HorarioEntrada;
        this.DataSaida = DataSaida;
        this.HorarioSaida = HorarioSaida;
    }

    public VisitasReligiosasPortaria() {
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
     * @return the IdIstituicao
     */
    public int getIdIstituicao() {
        return IdIstituicao;
    }

    /**
     * @param IdIstituicao the IdIstituicao to set
     */
    public void setIdIstituicao(int IdIstituicao) {
        this.IdIstituicao = IdIstituicao;
    }

    /**
     * @return the nomeIstituicao
     */
    public String getNomeIstituicao() {
        return nomeIstituicao;
    }

    /**
     * @param nomeIstituicao the nomeIstituicao to set
     */
    public void setNomeIstituicao(String nomeIstituicao) {
        this.nomeIstituicao = nomeIstituicao;
    }

    /**
     * @return the IdVisitaRel
     */
    public int getIdVisitaRel() {
        return IdVisitaRel;
    }

    /**
     * @param IdVisitaRel the IdVisitaRel to set
     */
    public void setIdVisitaRel(int IdVisitaRel) {
        this.IdVisitaRel = IdVisitaRel;
    }

    /**
     * @return the nomeVisitaRel
     */
    public String getNomeVisitaRel() {
        return nomeVisitaRel;
    }

    /**
     * @param nomeVisitaRel the nomeVisitaRel to set
     */
    public void setNomeVisitaRel(String nomeVisitaRel) {
        this.nomeVisitaRel = nomeVisitaRel;
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
