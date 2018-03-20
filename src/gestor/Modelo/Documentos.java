/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author CPLF
 */
public class Documentos {

    private int idDoc;
    private int idFunc;
    private String nomeFunc;
    private String rgDoc;
    private Date dataEmissaoDoc;
    private String orgaoDoc;
    private String estadoOrgao;
    private String cpfDoc;
    private String pisDoc;
    private Date dataCadPisDoc;
    private String tituloDoc;
    private String zonaDoc;
    private String secaoDoc;
    private String ctpsDoc;
    private String serieDoc;
    private String habiliDoc;
    private String reserVistaDoc;
    private String cateDoc;
    private String cartSaudeDoc;
    private String profDoc;
    private String alturaDoc;
    private String pesoDoc;
    private String calcaDoc;
    private String camisaDoc;
    private String sapatoDoc;
    private String carteiraDoc;
    private String tipoConjugue;
    private Date dataNasConjugue;
    private String nomeConjugue;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;    

    public Documentos(int idDoc, int idFunc, String nomeFunc, String rgDoc, Date dataEmissaoDoc, String orgaoDoc, String estadoOrgao, String cpfDoc, String pisDoc, Date dataCadPisDoc, String tituloDoc, String zonaDoc, String secaoDoc, String ctpsDoc, String serieDoc, String habiliDoc, String reserVistaDoc, String cateDoc, String cartSaudeDoc, String profDoc, String alturaDoc, String pesoDoc, String calcaDoc, String camisaDoc, String sapatoDoc, String carteiraDoc, String tipoConjugue, Date dataNasConjugue, String nomeConjugue, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idDoc = idDoc;
        this.idFunc = idFunc;
        this.nomeFunc = nomeFunc;
        this.rgDoc = rgDoc;
        this.dataEmissaoDoc = dataEmissaoDoc;
        this.orgaoDoc = orgaoDoc;
        this.estadoOrgao = estadoOrgao;
        this.cpfDoc = cpfDoc;
        this.pisDoc = pisDoc;
        this.dataCadPisDoc = dataCadPisDoc;
        this.tituloDoc = tituloDoc;
        this.zonaDoc = zonaDoc;
        this.secaoDoc = secaoDoc;
        this.ctpsDoc = ctpsDoc;
        this.serieDoc = serieDoc;
        this.habiliDoc = habiliDoc;
        this.reserVistaDoc = reserVistaDoc;
        this.cateDoc = cateDoc;
        this.cartSaudeDoc = cartSaudeDoc;
        this.profDoc = profDoc;
        this.alturaDoc = alturaDoc;
        this.pesoDoc = pesoDoc;
        this.calcaDoc = calcaDoc;
        this.camisaDoc = camisaDoc;
        this.sapatoDoc = sapatoDoc;
        this.carteiraDoc = carteiraDoc;
        this.tipoConjugue = tipoConjugue;
        this.dataNasConjugue = dataNasConjugue;
        this.nomeConjugue = nomeConjugue;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public Documentos() {
    }

    /**
     * @return the idDoc
     */
    public int getIdDoc() {
        return idDoc;
    }

    /**
     * @param idDoc the idDoc to set
     */
    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    /**
     * @return the idFunc
     */
    public int getIdFunc() {
        return idFunc;
    }

    /**
     * @param idFunc the idFunc to set
     */
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    /**
     * @return the nomeFunc
     */
    public String getNomeFunc() {
        return nomeFunc;
    }

    /**
     * @param nomeFunc the nomeFunc to set
     */
    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    /**
     * @return the rgDoc
     */
    public String getRgDoc() {
        return rgDoc;
    }

    /**
     * @param rgDoc the rgDoc to set
     */
    public void setRgDoc(String rgDoc) {
        this.rgDoc = rgDoc;
    }

    /**
     * @return the dataEmissaoDoc
     */
    public Date getDataEmissaoDoc() {
        return dataEmissaoDoc;
    }

    /**
     * @param dataEmissaoDoc the dataEmissaoDoc to set
     */
    public void setDataEmissaoDoc(Date dataEmissaoDoc) {
        this.dataEmissaoDoc = dataEmissaoDoc;
    }

    /**
     * @return the orgaoDoc
     */
    public String getOrgaoDoc() {
        return orgaoDoc;
    }

    /**
     * @param orgaoDoc the orgaoDoc to set
     */
    public void setOrgaoDoc(String orgaoDoc) {
        this.orgaoDoc = orgaoDoc;
    }

    /**
     * @return the estadoOrgao
     */
    public String getEstadoOrgao() {
        return estadoOrgao;
    }

    /**
     * @param estadoOrgao the estadoOrgao to set
     */
    public void setEstadoOrgao(String estadoOrgao) {
        this.estadoOrgao = estadoOrgao;
    }

    /**
     * @return the cpfDoc
     */
    public String getCpfDoc() {
        return cpfDoc;
    }

    /**
     * @param cpfDoc the cpfDoc to set
     */
    public void setCpfDoc(String cpfDoc) {
        this.cpfDoc = cpfDoc;
    }

    /**
     * @return the pisDoc
     */
    public String getPisDoc() {
        return pisDoc;
    }

    /**
     * @param pisDoc the pisDoc to set
     */
    public void setPisDoc(String pisDoc) {
        this.pisDoc = pisDoc;
    }

    /**
     * @return the dataCadPisDoc
     */
    public Date getDataCadPisDoc() {
        return dataCadPisDoc;
    }

    /**
     * @param dataCadPisDoc the dataCadPisDoc to set
     */
    public void setDataCadPisDoc(Date dataCadPisDoc) {
        this.dataCadPisDoc = dataCadPisDoc;
    }

    /**
     * @return the tituloDoc
     */
    public String getTituloDoc() {
        return tituloDoc;
    }

    /**
     * @param tituloDoc the tituloDoc to set
     */
    public void setTituloDoc(String tituloDoc) {
        this.tituloDoc = tituloDoc;
    }

    /**
     * @return the zonaDoc
     */
    public String getZonaDoc() {
        return zonaDoc;
    }

    /**
     * @param zonaDoc the zonaDoc to set
     */
    public void setZonaDoc(String zonaDoc) {
        this.zonaDoc = zonaDoc;
    }

    /**
     * @return the secaoDoc
     */
    public String getSecaoDoc() {
        return secaoDoc;
    }

    /**
     * @param secaoDoc the secaoDoc to set
     */
    public void setSecaoDoc(String secaoDoc) {
        this.secaoDoc = secaoDoc;
    }

    /**
     * @return the ctpsDoc
     */
    public String getCtpsDoc() {
        return ctpsDoc;
    }

    /**
     * @param ctpsDoc the ctpsDoc to set
     */
    public void setCtpsDoc(String ctpsDoc) {
        this.ctpsDoc = ctpsDoc;
    }

    /**
     * @return the serieDoc
     */
    public String getSerieDoc() {
        return serieDoc;
    }

    /**
     * @param serieDoc the serieDoc to set
     */
    public void setSerieDoc(String serieDoc) {
        this.serieDoc = serieDoc;
    }

    /**
     * @return the habiliDoc
     */
    public String getHabiliDoc() {
        return habiliDoc;
    }

    /**
     * @param habiliDoc the habiliDoc to set
     */
    public void setHabiliDoc(String habiliDoc) {
        this.habiliDoc = habiliDoc;
    }

    /**
     * @return the reserVistaDoc
     */
    public String getReserVistaDoc() {
        return reserVistaDoc;
    }

    /**
     * @param reserVistaDoc the reserVistaDoc to set
     */
    public void setReserVistaDoc(String reserVistaDoc) {
        this.reserVistaDoc = reserVistaDoc;
    }

    /**
     * @return the cateDoc
     */
    public String getCateDoc() {
        return cateDoc;
    }

    /**
     * @param cateDoc the cateDoc to set
     */
    public void setCateDoc(String cateDoc) {
        this.cateDoc = cateDoc;
    }

    /**
     * @return the cartSaudeDoc
     */
    public String getCartSaudeDoc() {
        return cartSaudeDoc;
    }

    /**
     * @param cartSaudeDoc the cartSaudeDoc to set
     */
    public void setCartSaudeDoc(String cartSaudeDoc) {
        this.cartSaudeDoc = cartSaudeDoc;
    }

    /**
     * @return the profDoc
     */
    public String getProfDoc() {
        return profDoc;
    }

    /**
     * @param profDoc the profDoc to set
     */
    public void setProfDoc(String profDoc) {
        this.profDoc = profDoc;
    }

    /**
     * @return the alturaDoc
     */
    public String getAlturaDoc() {
        return alturaDoc;
    }

    /**
     * @param alturaDoc the alturaDoc to set
     */
    public void setAlturaDoc(String alturaDoc) {
        this.alturaDoc = alturaDoc;
    }

    /**
     * @return the pesoDoc
     */
    public String getPesoDoc() {
        return pesoDoc;
    }

    /**
     * @param pesoDoc the pesoDoc to set
     */
    public void setPesoDoc(String pesoDoc) {
        this.pesoDoc = pesoDoc;
    }

    /**
     * @return the calcaDoc
     */
    public String getCalcaDoc() {
        return calcaDoc;
    }

    /**
     * @param calcaDoc the calcaDoc to set
     */
    public void setCalcaDoc(String calcaDoc) {
        this.calcaDoc = calcaDoc;
    }

    /**
     * @return the camisaDoc
     */
    public String getCamisaDoc() {
        return camisaDoc;
    }

    /**
     * @param camisaDoc the camisaDoc to set
     */
    public void setCamisaDoc(String camisaDoc) {
        this.camisaDoc = camisaDoc;
    }

    /**
     * @return the sapatoDoc
     */
    public String getSapatoDoc() {
        return sapatoDoc;
    }

    /**
     * @param sapatoDoc the sapatoDoc to set
     */
    public void setSapatoDoc(String sapatoDoc) {
        this.sapatoDoc = sapatoDoc;
    }

    /**
     * @return the carteiraDoc
     */
    public String getCarteiraDoc() {
        return carteiraDoc;
    }

    /**
     * @param carteiraDoc the carteiraDoc to set
     */
    public void setCarteiraDoc(String carteiraDoc) {
        this.carteiraDoc = carteiraDoc;
    }

    /**
     * @return the tipoConjugue
     */
    public String getTipoConjugue() {
        return tipoConjugue;
    }

    /**
     * @param tipoConjugue the tipoConjugue to set
     */
    public void setTipoConjugue(String tipoConjugue) {
        this.tipoConjugue = tipoConjugue;
    }

    /**
     * @return the dataNasConjugue
     */
    public Date getDataNasConjugue() {
        return dataNasConjugue;
    }

    /**
     * @param dataNasConjugue the dataNasConjugue to set
     */
    public void setDataNasConjugue(Date dataNasConjugue) {
        this.dataNasConjugue = dataNasConjugue;
    }

    /**
     * @return the nomeConjugue
     */
    public String getNomeConjugue() {
        return nomeConjugue;
    }

    /**
     * @param nomeConjugue the nomeConjugue to set
     */
    public void setNomeConjugue(String nomeConjugue) {
        this.nomeConjugue = nomeConjugue;
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
