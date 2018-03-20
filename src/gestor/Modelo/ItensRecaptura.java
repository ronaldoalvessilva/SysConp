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
public class ItensRecaptura {

    private int idItem;
    private int idInternoCrc;
    private String nomeInterno;
    private int idRecaptura;
    private int idRegistro;
    private Date dataRetorno;
    private String origemRetorno;
    private String documentoRetorno;
    private String confirmaRecaptura;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;          

    public ItensRecaptura(int idItem, int idInternoCrc, String nomeInterno, int idRecaptura, int idRegistro, Date dataRetorno, String origemRetorno, String documentoRetorno, String confirmaRecaptura, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp) {
        this.idItem = idItem;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.idRecaptura = idRecaptura;
        this.idRegistro = idRegistro;
        this.dataRetorno = dataRetorno;
        this.origemRetorno = origemRetorno;
        this.documentoRetorno = documentoRetorno;
        this.confirmaRecaptura = confirmaRecaptura;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
    }

    public ItensRecaptura() {
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
     * @return the idRecaptura
     */
    public int getIdRecaptura() {
        return idRecaptura;
    }

    /**
     * @param idRecaptura the idRecaptura to set
     */
    public void setIdRecaptura(int idRecaptura) {
        this.idRecaptura = idRecaptura;
    }

    /**
     * @return the idRegistro
     */
    public int getIdRegistro() {
        return idRegistro;
    }

    /**
     * @param idRegistro the idRegistro to set
     */
    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    /**
     * @return the dataRetorno
     */
    public Date getDataRetorno() {
        return dataRetorno;
    }

    /**
     * @param dataRetorno the dataRetorno to set
     */
    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    /**
     * @return the origemRetorno
     */
    public String getOrigemRetorno() {
        return origemRetorno;
    }

    /**
     * @param origemRetorno the origemRetorno to set
     */
    public void setOrigemRetorno(String origemRetorno) {
        this.origemRetorno = origemRetorno;
    }

    /**
     * @return the documentoRetorno
     */
    public String getDocumentoRetorno() {
        return documentoRetorno;
    }

    /**
     * @param documentoRetorno the documentoRetorno to set
     */
    public void setDocumentoRetorno(String documentoRetorno) {
        this.documentoRetorno = documentoRetorno;
    }

    /**
     * @return the confirmaRecaptura
     */
    public String getConfirmaRecaptura() {
        return confirmaRecaptura;
    }

    /**
     * @param confirmaRecaptura the confirmaRecaptura to set
     */
    public void setConfirmaRecaptura(String confirmaRecaptura) {
        this.confirmaRecaptura = confirmaRecaptura;
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
