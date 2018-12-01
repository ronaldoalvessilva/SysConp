/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronal
 */
public class DigitalVisitasInterno {
    private int idVisita;
    private String nomeVisita;
    private String grauParentesco;
    private String caminhoFotoVisita;
    private String statusVisita;  
    private String fotoVisita;
    private byte[] biometriaDedo1;
    private byte[] biometriaDedo2;
    private byte[] biometriaDedo3;
    private byte[] biometriaDedo4;    
    private byte[] imagemFrenteVI;

    public DigitalVisitasInterno() {
    }

    public DigitalVisitasInterno(int idVisita, String nomeVisita, String grauParentesco, String caminhoFotoVisita, String statusVisita, String fotoVisita, byte[] biometriaDedo1, byte[] biometriaDedo2, byte[] biometriaDedo3, byte[] biometriaDedo4, byte[] imagemFrenteVI) {
        this.idVisita = idVisita;
        this.nomeVisita = nomeVisita;
        this.grauParentesco = grauParentesco;
        this.caminhoFotoVisita = caminhoFotoVisita;
        this.statusVisita = statusVisita;
        this.fotoVisita = fotoVisita;
        this.biometriaDedo1 = biometriaDedo1;
        this.biometriaDedo2 = biometriaDedo2;
        this.biometriaDedo3 = biometriaDedo3;
        this.biometriaDedo4 = biometriaDedo4;
        this.imagemFrenteVI = imagemFrenteVI;
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
     * @return the statusVisita
     */
    public String getStatusVisita() {
        return statusVisita;
    }

    /**
     * @param statusVisita the statusVisita to set
     */
    public void setStatusVisita(String statusVisita) {
        this.statusVisita = statusVisita;
    }

    /**
     * @return the fotoVisita
     */
    public String getFotoVisita() {
        return fotoVisita;
    }

    /**
     * @param fotoVisita the fotoVisita to set
     */
    public void setFotoVisita(String fotoVisita) {
        this.fotoVisita = fotoVisita;
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
