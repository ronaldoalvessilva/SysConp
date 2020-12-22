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
public class PesquisaInternosRolVisitasPortaria {

    private Integer idRol;
    private Integer idInternoCrc;
    private String nomeInternoCrc;
    private String regime;
    private Integer idPav;
    private String descricaoPav;
    private Integer idVisita;
    private String nomeVisita;
    private String imagemVisita;
    private String parentescoVisita;
    private byte[] BiometriaDedo1;
    private byte[] BiometriaDedo2;
    private byte[] BiometriaDedo3;
    private byte[] BiometriaDedo4;
    private byte[] imagemFrenteVI;

    public PesquisaInternosRolVisitasPortaria() {
    }

    public PesquisaInternosRolVisitasPortaria(Integer idRol, Integer idInternoCrc, String nomeInternoCrc, String regime, Integer idPav, String descricaoPav, Integer idVisita, String nomeVisita, String imagemVisita, String parentescoVisita, byte[] BiometriaDedo1, byte[] BiometriaDedo2, byte[] BiometriaDedo3, byte[] BiometriaDedo4, byte[] imagemFrenteVI) {
        this.idRol = idRol;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.regime = regime;
        this.idPav = idPav;
        this.descricaoPav = descricaoPav;
        this.idVisita = idVisita;
        this.nomeVisita = nomeVisita;
        this.imagemVisita = imagemVisita;
        this.parentescoVisita = parentescoVisita;
        this.BiometriaDedo1 = BiometriaDedo1;
        this.BiometriaDedo2 = BiometriaDedo2;
        this.BiometriaDedo3 = BiometriaDedo3;
        this.BiometriaDedo4 = BiometriaDedo4;
        this.imagemFrenteVI = imagemFrenteVI;
    }

    /**
     * @return the idRol
     */
    public Integer getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the idInternoCrc
     */
    public Integer getIdInternoCrc() {
        return idInternoCrc;
    }

    /**
     * @param idInternoCrc the idInternoCrc to set
     */
    public void setIdInternoCrc(Integer idInternoCrc) {
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
     * @return the regime
     */
    public String getRegime() {
        return regime;
    }

    /**
     * @param regime the regime to set
     */
    public void setRegime(String regime) {
        this.regime = regime;
    }

    /**
     * @return the idPav
     */
    public Integer getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(Integer idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the descricaoPav
     */
    public String getDescricaoPav() {
        return descricaoPav;
    }

    /**
     * @param descricaoPav the descricaoPav to set
     */
    public void setDescricaoPav(String descricaoPav) {
        this.descricaoPav = descricaoPav;
    }

    /**
     * @return the idVisita
     */
    public Integer getIdVisita() {
        return idVisita;
    }

    /**
     * @param idVisita the idVisita to set
     */
    public void setIdVisita(Integer idVisita) {
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
     * @return the imagemVisita
     */
    public String getImagemVisita() {
        return imagemVisita;
    }

    /**
     * @param imagemVisita the imagemVisita to set
     */
    public void setImagemVisita(String imagemVisita) {
        this.imagemVisita = imagemVisita;
    }

    /**
     * @return the parentescoVisita
     */
    public String getParentescoVisita() {
        return parentescoVisita;
    }

    /**
     * @param parentescoVisita the parentescoVisita to set
     */
    public void setParentescoVisita(String parentescoVisita) {
        this.parentescoVisita = parentescoVisita;
    }

    /**
     * @return the BiometriaDedo1
     */
    public byte[] getBiometriaDedo1() {
        return BiometriaDedo1;
    }

    /**
     * @param BiometriaDedo1 the BiometriaDedo1 to set
     */
    public void setBiometriaDedo1(byte[] BiometriaDedo1) {
        this.BiometriaDedo1 = BiometriaDedo1;
    }

    /**
     * @return the BiometriaDedo2
     */
    public byte[] getBiometriaDedo2() {
        return BiometriaDedo2;
    }

    /**
     * @param BiometriaDedo2 the BiometriaDedo2 to set
     */
    public void setBiometriaDedo2(byte[] BiometriaDedo2) {
        this.BiometriaDedo2 = BiometriaDedo2;
    }

    /**
     * @return the BiometriaDedo3
     */
    public byte[] getBiometriaDedo3() {
        return BiometriaDedo3;
    }

    /**
     * @param BiometriaDedo3 the BiometriaDedo3 to set
     */
    public void setBiometriaDedo3(byte[] BiometriaDedo3) {
        this.BiometriaDedo3 = BiometriaDedo3;
    }

    /**
     * @return the BiometriaDedo4
     */
    public byte[] getBiometriaDedo4() {
        return BiometriaDedo4;
    }

    /**
     * @param BiometriaDedo4 the BiometriaDedo4 to set
     */
    public void setBiometriaDedo4(byte[] BiometriaDedo4) {
        this.BiometriaDedo4 = BiometriaDedo4;
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
