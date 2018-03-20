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
public class ItensListagemInternosAlbergados {

    private int idItem;
    private int idAgenda;
    private int idInternoCrc;
    private String nomeInterno;
    private String statusInterno;
    private String situacaoInterno;
    private String observacaoInterno;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;

    public ItensListagemInternosAlbergados(int idItem, int idAgenda, int idInternoCrc, String nomeInterno, String statusInterno, String situacaoInterno, String observacaoInterno, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp) {
        this.idItem = idItem;
        this.idAgenda = idAgenda;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.statusInterno = statusInterno;
        this.situacaoInterno = situacaoInterno;
        this.observacaoInterno = observacaoInterno;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
    }

    public ItensListagemInternosAlbergados() {
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
     * @return the idAgenda
     */
    public int getIdAgenda() {
        return idAgenda;
    }

    /**
     * @param idAgenda the idAgenda to set
     */
    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
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
     * @return the statusInterno
     */
    public String getStatusInterno() {
        return statusInterno;
    }

    /**
     * @param statusInterno the statusInterno to set
     */
    public void setStatusInterno(String statusInterno) {
        this.statusInterno = statusInterno;
    }

    /**
     * @return the situacaoInterno
     */
    public String getSituacaoInterno() {
        return situacaoInterno;
    }

    /**
     * @param situacaoInterno the situacaoInterno to set
     */
    public void setSituacaoInterno(String situacaoInterno) {
        this.situacaoInterno = situacaoInterno;
    }

    /**
     * @return the observacaoInterno
     */
    public String getObservacaoInterno() {
        return observacaoInterno;
    }

    /**
     * @param observacaoInterno the observacaoInterno to set
     */
    public void setObservacaoInterno(String observacaoInterno) {
        this.observacaoInterno = observacaoInterno;
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
     * @return the horaInsert
     */
    public String getHoraInsert() {
        return horaInsert;
    }

    /**
     * @param horaInsert the horaInsert to set
     */
    public void setHoraInsert(String horaInsert) {
        this.horaInsert = horaInsert;
    }

    /**
     * @return the horaUp
     */
    public String getHoraUp() {
        return horaUp;
    }

    /**
     * @param horaUp the horaUp to set
     */
    public void setHoraUp(String horaUp) {
        this.horaUp = horaUp;
    }
}
