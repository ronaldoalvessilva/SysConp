/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronaldo.silva7
 */
public class FichaCadastroPaiEapi1 {

    private int idDS;
    private int idPai;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String pSP;
    private String cEDEGEP;
    private String cRASCREAS;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public FichaCadastroPaiEapi1(int idDS, int idPai, int idInternoCrc, String nomeInternoCrc, String pSP, String cEDEGEP, String cRASCREAS, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idDS = idDS;
        this.idPai = idPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.pSP = pSP;
        this.cEDEGEP = cEDEGEP;
        this.cRASCREAS = cRASCREAS;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public FichaCadastroPaiEapi1() {
    }

    /**
     * @return the idDS
     */
    public int getIdDS() {
        return idDS;
    }

    /**
     * @param idDS the idDS to set
     */
    public void setIdDS(int idDS) {
        this.idDS = idDS;
    }

    /**
     * @return the idPai
     */
    public int getIdPai() {
        return idPai;
    }

    /**
     * @param idPai the idPai to set
     */
    public void setIdPai(int idPai) {
        this.idPai = idPai;
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
     * @return the nomeInternoCrc
     */
    public String getNomeInternoCrc() {
        return nomeInternoCrc;
    }

    /**
     * @param nomeInternoCrc the nomeInternoCrc to set
     */
    public void setNomeInternoCrc(String nomeInternoCrc) {
        this.nomeInternoCrc = nomeInternoCrc;
    }

    /**
     * @return the pSP
     */
    public String getpSP() {
        return pSP;
    }

    /**
     * @param pSP the pSP to set
     */
    public void setpSP(String pSP) {
        this.pSP = pSP;
    }

    /**
     * @return the cEDEGEP
     */
    public String getcEDEGEP() {
        return cEDEGEP;
    }

    /**
     * @param cEDEGEP the cEDEGEP to set
     */
    public void setcEDEGEP(String cEDEGEP) {
        this.cEDEGEP = cEDEGEP;
    }

    /**
     * @return the cRASCREAS
     */
    public String getcRASCREAS() {
        return cRASCREAS;
    }

    /**
     * @param cRASCREAS the cRASCREAS to set
     */
    public void setcRASCREAS(String cRASCREAS) {
        this.cRASCREAS = cRASCREAS;
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
