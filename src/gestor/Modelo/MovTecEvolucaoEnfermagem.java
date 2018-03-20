/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author user
 */
public class MovTecEvolucaoEnfermagem {

    private int IdMov;
    private int IdInternoCrc;
    private int IdAtend;
    private String StMov;
    private Date DataMov;
    private String NomeOpe;
    private String DeptoMov;

    public MovTecEvolucaoEnfermagem(int IdMov, int IdInternoCrc, int IdAtend, String StMov, Date DataMov, String NomeOpe, String DeptoMov) {
        this.IdMov = IdMov;
        this.IdInternoCrc = IdInternoCrc;
        this.IdAtend = IdAtend;
        this.StMov = StMov;
        this.DataMov = DataMov;
        this.NomeOpe = NomeOpe;
        this.DeptoMov = DeptoMov;
    }

    public MovTecEvolucaoEnfermagem() {
    }

    /**
     * @return the IdMov
     */
    public int getIdMov() {
        return IdMov;
    }

    /**
     * @param IdMov the IdMov to set
     */
    public void setIdMov(int IdMov) {
        this.IdMov = IdMov;
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
     * @return the IdAtend
     */
    public int getIdAtend() {
        return IdAtend;
    }

    /**
     * @param IdAtend the IdAtend to set
     */
    public void setIdAtend(int IdAtend) {
        this.IdAtend = IdAtend;
    }

    /**
     * @return the StMov
     */
    public String getStMov() {
        return StMov;
    }

    /**
     * @param StMov the StMov to set
     */
    public void setStMov(String StMov) {
        this.StMov = StMov;
    }

    /**
     * @return the DataMov
     */
    public Date getDataMov() {
        return DataMov;
    }

    /**
     * @param DataMov the DataMov to set
     */
    public void setDataMov(Date DataMov) {
        this.DataMov = DataMov;
    }

    /**
     * @return the NomeOpe
     */
    public String getNomeOpe() {
        return NomeOpe;
    }

    /**
     * @param NomeOpe the NomeOpe to set
     */
    public void setNomeOpe(String NomeOpe) {
        this.NomeOpe = NomeOpe;
    }

    /**
     * @return the DeptoMov
     */
    public String getDeptoMov() {
        return DeptoMov;
    }

    /**
     * @param DeptoMov the DeptoMov to set
     */
    public void setDeptoMov(String DeptoMov) {
        this.DeptoMov = DeptoMov;
    }
}
