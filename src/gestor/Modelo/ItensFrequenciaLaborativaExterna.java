/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author Ronaldo
 */
public class ItensFrequenciaLaborativaExterna {
    
        private int idItem;
	private int idFreqLab;
	private int idInternoCrc;
        private String nomeInterno;
	private int totalDias;
	private String mesReferencia;
	private int anoReferencia;
	private String usuarioInsert;
	private String usuarioUp;
	private String dataInsert;
	private String dataUp;
	private String horarioInsert;
	private String horarioUp;       

    public ItensFrequenciaLaborativaExterna(int idItem, int idFreqLab, int idInternoCrc, String nomeInterno, int totalDias, String mesReferencia, int anoReferencia, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.idFreqLab = idFreqLab;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.totalDias = totalDias;
        this.mesReferencia = mesReferencia;
        this.anoReferencia = anoReferencia;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensFrequenciaLaborativaExterna() {
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
     * @return the idFreqLab
     */
    public int getIdFreqLab() {
        return idFreqLab;
    }

    /**
     * @param idFreqLab the idFreqLab to set
     */
    public void setIdFreqLab(int idFreqLab) {
        this.idFreqLab = idFreqLab;
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
     * @return the totalDias
     */
    public int getTotalDias() {
        return totalDias;
    }

    /**
     * @param totalDias the totalDias to set
     */
    public void setTotalDias(int totalDias) {
        this.totalDias = totalDias;
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
    public int getAnoReferencia() {
        return anoReferencia;
    }

    /**
     * @param anoReferencia the anoReferencia to set
     */
    public void setAnoReferencia(int anoReferencia) {
        this.anoReferencia = anoReferencia;
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
