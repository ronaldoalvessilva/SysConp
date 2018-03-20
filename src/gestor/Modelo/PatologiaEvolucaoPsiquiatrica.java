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
public class PatologiaEvolucaoPsiquiatrica {

    private int idPatPsi;
    private Date dataReg;
    private int idItem;
    private int idInternoCrc;
    private String nomeInternoPsi;
    private int idDoenca;
    private String descricaoDoenca;
    private String tipoAna;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public PatologiaEvolucaoPsiquiatrica(int idPatPsi, Date dataReg, int idItem, int idInternoCrc, String nomeInternoPsi, int idDoenca, String descricaoDoenca, String tipoAna, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idPatPsi = idPatPsi;
        this.dataReg = dataReg;
        this.idItem = idItem;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoPsi = nomeInternoPsi;
        this.idDoenca = idDoenca;
        this.descricaoDoenca = descricaoDoenca;
        this.tipoAna = tipoAna;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public PatologiaEvolucaoPsiquiatrica() {
    }

    /**
     * @return the idPatPsi
     */
    public int getIdPatPsi() {
        return idPatPsi;
    }

    /**
     * @param idPatPsi the idPatPsi to set
     */
    public void setIdPatPsi(int idPatPsi) {
        this.idPatPsi = idPatPsi;
    }

    /**
     * @return the dataReg
     */
    public Date getDataReg() {
        return dataReg;
    }

    /**
     * @param dataReg the dataReg to set
     */
    public void setDataReg(Date dataReg) {
        this.dataReg = dataReg;
    }

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the idInternoCrc
     */
    public int getIdInternoCrc() {
        return idInternoCrc;
    }

    /**
     * @param idInternoCrc the idInternoCrc to set
     */
    public void setIdInternoCrc(int idInternoCrc) {
        this.idInternoCrc = idInternoCrc;
    }

    /**
     * @return the nomeInternoPsi
     */
    public String getNomeInternoPsi() {
        return nomeInternoPsi;
    }

    /**
     * @param nomeInternoPsi the nomeInternoPsi to set
     */
    public void setNomeInternoPsi(String nomeInternoPsi) {
        this.nomeInternoPsi = nomeInternoPsi;
    }

    /**
     * @return the idDoenca
     */
    public int getIdDoenca() {
        return idDoenca;
    }

    /**
     * @param idDoenca the idDoenca to set
     */
    public void setIdDoenca(int idDoenca) {
        this.idDoenca = idDoenca;
    }

    /**
     * @return the descricaoDoenca
     */
    public String getDescricaoDoenca() {
        return descricaoDoenca;
    }

    /**
     * @param descricaoDoenca the descricaoDoenca to set
     */
    public void setDescricaoDoenca(String descricaoDoenca) {
        this.descricaoDoenca = descricaoDoenca;
    }

    /**
     * @return the tipoAna
     */
    public String getTipoAna() {
        return tipoAna;
    }

    /**
     * @param tipoAna the tipoAna to set
     */
    public void setTipoAna(String tipoAna) {
        this.tipoAna = tipoAna;
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
