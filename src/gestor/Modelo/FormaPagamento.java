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
public class FormaPagamento {

    private int IdForma;
    private Date DataForma;
    private String StatusForma;
    private String DescricaoForma;
    private String UsuarioInsert;
    private String UsuarioUp;
    private String DataInsert;
    private String DataUp;
    private String HorarioInsert;
    private String HorarioUp;

    public FormaPagamento(int IdForma, Date DataForma, String StatusForma, String DescricaoForma, String UsuarioInsert, String UsuarioUp, String DataInsert, String DataUp, String HorarioInsert, String HorarioUp) {
        this.IdForma = IdForma;
        this.DataForma = DataForma;
        this.StatusForma = StatusForma;
        this.DescricaoForma = DescricaoForma;
        this.UsuarioInsert = UsuarioInsert;
        this.UsuarioUp = UsuarioUp;
        this.DataInsert = DataInsert;
        this.DataUp = DataUp;
        this.HorarioInsert = HorarioInsert;
        this.HorarioUp = HorarioUp;
    }

    public FormaPagamento() {
    }

    /**
     * @return the IdForma
     */
    public int getIdForma() {
        return IdForma;
    }

    /**
     * @param IdForma the IdForma to set
     */
    public void setIdForma(int IdForma) {
        this.IdForma = IdForma;
    }

    /**
     * @return the DataForma
     */
    public Date getDataForma() {
        return DataForma;
    }

    /**
     * @param DataForma the DataForma to set
     */
    public void setDataForma(Date DataForma) {
        this.DataForma = DataForma;
    }

    /**
     * @return the StatusForma
     */
    public String getStatusForma() {
        return StatusForma;
    }

    /**
     * @param StatusForma the StatusForma to set
     */
    public void setStatusForma(String StatusForma) {
        this.StatusForma = StatusForma;
    }

    /**
     * @return the DescricaoForma
     */
    public String getDescricaoForma() {
        return DescricaoForma;
    }

    /**
     * @param DescricaoForma the DescricaoForma to set
     */
    public void setDescricaoForma(String DescricaoForma) {
        this.DescricaoForma = DescricaoForma;
    }

    /**
     * @return the UsuarioInsert
     */
    public String getUsuarioInsert() {
        return UsuarioInsert;
    }

    /**
     * @param UsuarioInsert the UsuarioInsert to set
     */
    public void setUsuarioInsert(String UsuarioInsert) {
        this.UsuarioInsert = UsuarioInsert;
    }

    /**
     * @return the UsuarioUp
     */
    public String getUsuarioUp() {
        return UsuarioUp;
    }

    /**
     * @param UsuarioUp the UsuarioUp to set
     */
    public void setUsuarioUp(String UsuarioUp) {
        this.UsuarioUp = UsuarioUp;
    }

    /**
     * @return the DataInsert
     */
    public String getDataInsert() {
        return DataInsert;
    }

    /**
     * @param DataInsert the DataInsert to set
     */
    public void setDataInsert(String DataInsert) {
        this.DataInsert = DataInsert;
    }

    /**
     * @return the DataUp
     */
    public String getDataUp() {
        return DataUp;
    }

    /**
     * @param DataUp the DataUp to set
     */
    public void setDataUp(String DataUp) {
        this.DataUp = DataUp;
    }

    /**
     * @return the HorarioInsert
     */
    public String getHorarioInsert() {
        return HorarioInsert;
    }

    /**
     * @param HorarioInsert the HorarioInsert to set
     */
    public void setHorarioInsert(String HorarioInsert) {
        this.HorarioInsert = HorarioInsert;
    }

    /**
     * @return the HorarioUp
     */
    public String getHorarioUp() {
        return HorarioUp;
    }

    /**
     * @param HorarioUp the HorarioUp to set
     */
    public void setHorarioUp(String HorarioUp) {
        this.HorarioUp = HorarioUp;
    }
}
