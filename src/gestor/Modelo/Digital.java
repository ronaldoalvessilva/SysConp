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
public class Digital {

    private int idRol;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String caminhoFotoInterno;
    private String Regime;
    private String pavilhao;
    private String statusRol;
    private int idVisita;
    private String nomeVisita;    
    private String caminhoFotoVisita;
    private String statusVisitaInterno;
    private String grauParentesco;
    private byte[] biometriaDedo1;
    private byte[] biometriaDedo2;
    private byte[] biometriaDedo3;
    private byte[] biometriaDedo4; 
    private byte[] imagemFrenteVI;

    public Digital() {
    }

    public Digital(int idRol, int idInternoCrc, String nomeInternoCrc, String caminhoFotoInterno, String Regime, String pavilhao, String statusRol, int idVisita, String nomeVisita, String caminhoFotoVisita, String statusVisitaInterno, String grauParentesco, byte[] biometriaDedo1, byte[] biometriaDedo2, byte[] biometriaDedo3, byte[] biometriaDedo4, byte[] imagemFrenteVI) {
        this.idRol = idRol;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.caminhoFotoInterno = caminhoFotoInterno;
        this.Regime = Regime;
        this.pavilhao = pavilhao;
        this.statusRol = statusRol;
        this.idVisita = idVisita;
        this.nomeVisita = nomeVisita;
        this.caminhoFotoVisita = caminhoFotoVisita;
        this.statusVisitaInterno = statusVisitaInterno;
        this.grauParentesco = grauParentesco;
        this.biometriaDedo1 = biometriaDedo1;
        this.biometriaDedo2 = biometriaDedo2;
        this.biometriaDedo3 = biometriaDedo3;
        this.biometriaDedo4 = biometriaDedo4;
        this.imagemFrenteVI = imagemFrenteVI;
    }

    /**
     * @return the idRol
     */
    public int getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(int idRol) {
        this.idRol = idRol;
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
     * @return the caminhoFotoInterno
     */
    public String getCaminhoFotoInterno() {
        return caminhoFotoInterno;
    }

    /**
     * @param caminhoFotoInterno the caminhoFotoInterno to set
     */
    public void setCaminhoFotoInterno(String caminhoFotoInterno) {
        this.caminhoFotoInterno = caminhoFotoInterno;
    }

    /**
     * @return the Regime
     */
    public String getRegime() {
        return Regime;
    }

    /**
     * @param Regime the Regime to set
     */
    public void setRegime(String Regime) {
        this.Regime = Regime;
    }

    /**
     * @return the pavilhao
     */
    public String getPavilhao() {
        return pavilhao;
    }

    /**
     * @param pavilhao the pavilhao to set
     */
    public void setPavilhao(String pavilhao) {
        this.pavilhao = pavilhao;
    }

    /**
     * @return the statusRol
     */
    public String getStatusRol() {
        return statusRol;
    }

    /**
     * @param statusRol the statusRol to set
     */
    public void setStatusRol(String statusRol) {
        this.statusRol = statusRol;
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
     * @return the caminhoFotoVisita
     */
    public String getCaminhoFotoVisita() {
        return caminhoFotoVisita;
    }

    /**
     * @param caminhoFotoVisita the caminhoFotoVisita to set
     */
    public void setCaminhoFotoVisita(String caminhoFotoVisita) {
        this.caminhoFotoVisita = caminhoFotoVisita;
    }

    /**
     * @return the statusVisitaInterno
     */
    public String getStatusVisitaInterno() {
        return statusVisitaInterno;
    }

    /**
     * @param statusVisitaInterno the statusVisitaInterno to set
     */
    public void setStatusVisitaInterno(String statusVisitaInterno) {
        this.statusVisitaInterno = statusVisitaInterno;
    }

    /**
     * @return the grauParentesco
     */
    public String getGrauParentesco() {
        return grauParentesco;
    }

    /**
     * @param grauParentesco the grauParentesco to set
     */
    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    /**
     * @return the biometriaDedo1
     */
    public byte[] getBiometriaDedo1() {
        return biometriaDedo1;
    }

    /**
     * @param biometriaDedo1 the biometriaDedo1 to set
     */
    public void setBiometriaDedo1(byte[] biometriaDedo1) {
        this.biometriaDedo1 = biometriaDedo1;
    }

    /**
     * @return the biometriaDedo2
     */
    public byte[] getBiometriaDedo2() {
        return biometriaDedo2;
    }

    /**
     * @param biometriaDedo2 the biometriaDedo2 to set
     */
    public void setBiometriaDedo2(byte[] biometriaDedo2) {
        this.biometriaDedo2 = biometriaDedo2;
    }

    /**
     * @return the biometriaDedo3
     */
    public byte[] getBiometriaDedo3() {
        return biometriaDedo3;
    }

    /**
     * @param biometriaDedo3 the biometriaDedo3 to set
     */
    public void setBiometriaDedo3(byte[] biometriaDedo3) {
        this.biometriaDedo3 = biometriaDedo3;
    }

    /**
     * @return the biometriaDedo4
     */
    public byte[] getBiometriaDedo4() {
        return biometriaDedo4;
    }

    /**
     * @param biometriaDedo4 the biometriaDedo4 to set
     */
    public void setBiometriaDedo4(byte[] biometriaDedo4) {
        this.biometriaDedo4 = biometriaDedo4;
    }

    /**
     * @return the imagemFrenteVI
     */
    public byte[] getImagemFrenteVI() {
        return imagemFrenteVI;
    }

    /**
     * @param imagemFrenteVI the imagemFrenteVI to set
     */
    public void setImagemFrenteVI(byte[] imagemFrenteVI) {
        this.imagemFrenteVI = imagemFrenteVI;
    }
   
}
