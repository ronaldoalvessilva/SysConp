/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronaldo
 */
public class OcorrenciaIndisciplinaPortaria {

    private int idOcr;
    private int idReg;
    private int idVisita;
    private String nomeVisita;
    private int idInternoCrc;
    private String nomeIntenoCrc;
    private String textoOcorrencia;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;        

    public OcorrenciaIndisciplinaPortaria(int idOcr, int idReg, int idVisita, String nomeVisita, int idInternoCrc, String nomeIntenoCrc, String textoOcorrencia, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idOcr = idOcr;
        this.idReg = idReg;
        this.idVisita = idVisita;
        this.nomeVisita = nomeVisita;
        this.idInternoCrc = idInternoCrc;
        this.nomeIntenoCrc = nomeIntenoCrc;
        this.textoOcorrencia = textoOcorrencia;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public OcorrenciaIndisciplinaPortaria() {
    }

    /**
     * @return the idOcr
     */
    public int getIdOcr() {
        return idOcr;
    }

    /**
     * @param idOcr the idOcr to set
     */
    public void setIdOcr(int idOcr) {
        this.idOcr = idOcr;
    }

    /**
     * @return the idReg
     */
    public int getIdReg() {
        return idReg;
    }

    /**
     * @param idReg the idReg to set
     */
    public void setIdReg(int idReg) {
        this.idReg = idReg;
    }

    /**
     * @return the idVisita
     */
    public int getIdVisita() {
        return idVisita;
    }

    /**
     * @param idVisita the idVisita to set
     */
    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    /**
     * @return the nomeVisita
     */
    public String getNomeVisita() {
        return nomeVisita;
    }

    /**
     * @param nomeVisita the nomeVisita to set
     */
    public void setNomeVisita(String nomeVisita) {
        this.nomeVisita = nomeVisita;
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
     * @return the nomeIntenoCrc
     */
    public String getNomeIntenoCrc() {
        return nomeIntenoCrc;
    }

    /**
     * @param nomeIntenoCrc the nomeIntenoCrc to set
     */
    public void setNomeIntenoCrc(String nomeIntenoCrc) {
        this.nomeIntenoCrc = nomeIntenoCrc;
    }

    /**
     * @return the textoOcorrencia
     */
    public String getTextoOcorrencia() {
        return textoOcorrencia;
    }

    /**
     * @param textoOcorrencia the textoOcorrencia to set
     */
    public void setTextoOcorrencia(String textoOcorrencia) {
        this.textoOcorrencia = textoOcorrencia;
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
