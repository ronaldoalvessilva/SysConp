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
public class ItensPrevisaoSaida {

    private int idItem;
    private int idLanc;
    private int idInternoCrc;
    private String nomeInterno;
    private Date dataPrevSaida;
    private Date dataPrevRetorno;
    private Date dataSaida;
    private String numeroDocumento;
    private String beneficio;
    private String confirmaSaida;
    private String utilizadoSaida;
    private String evadidos;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;   

    public ItensPrevisaoSaida(int idItem, int idLanc, int idInternoCrc, String nomeInterno, Date dataPrevSaida, Date dataPrevRetorno, Date dataSaida, String numeroDocumento, String beneficio, String confirmaSaida, String utilizadoSaida, String evadidos, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.dataPrevSaida = dataPrevSaida;
        this.dataPrevRetorno = dataPrevRetorno;
        this.dataSaida = dataSaida;
        this.numeroDocumento = numeroDocumento;
        this.beneficio = beneficio;
        this.confirmaSaida = confirmaSaida;
        this.utilizadoSaida = utilizadoSaida;
        this.evadidos = evadidos;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensPrevisaoSaida() {
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
     * @return the idLanc
     */
    public int getIdLanc() {
        return idLanc;
    }

    /**
     * @param idLanc the idLanc to set
     */
    public void setIdLanc(int idLanc) {
        this.idLanc = idLanc;
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
     * @return the dataPrevSaida
     */
    public Date getDataPrevSaida() {
        return dataPrevSaida;
    }

    /**
     * @param dataPrevSaida the dataPrevSaida to set
     */
    public void setDataPrevSaida(Date dataPrevSaida) {
        this.dataPrevSaida = dataPrevSaida;
    }

    /**
     * @return the dataPrevRetorno
     */
    public Date getDataPrevRetorno() {
        return dataPrevRetorno;
    }

    /**
     * @param dataPrevRetorno the dataPrevRetorno to set
     */
    public void setDataPrevRetorno(Date dataPrevRetorno) {
        this.dataPrevRetorno = dataPrevRetorno;
    }

    /**
     * @return the dataSaida
     */
    public Date getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * @return the numeroDocumento
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento the numeroDocumento to set
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return the beneficio
     */
    public String getBeneficio() {
        return beneficio;
    }

    /**
     * @param beneficio the beneficio to set
     */
    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    /**
     * @return the confirmaSaida
     */
    public String getConfirmaSaida() {
        return confirmaSaida;
    }

    /**
     * @param confirmaSaida the confirmaSaida to set
     */
    public void setConfirmaSaida(String confirmaSaida) {
        this.confirmaSaida = confirmaSaida;
    }

    /**
     * @return the utilizadoSaida
     */
    public String getUtilizadoSaida() {
        return utilizadoSaida;
    }

    /**
     * @param utilizadoSaida the utilizadoSaida to set
     */
    public void setUtilizadoSaida(String utilizadoSaida) {
        this.utilizadoSaida = utilizadoSaida;
    }

    /**
     * @return the evadidos
     */
    public String getEvadidos() {
        return evadidos;
    }

    /**
     * @param evadidos the evadidos to set
     */
    public void setEvadidos(String evadidos) {
        this.evadidos = evadidos;
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
     * @return the usuarioDelete
     */
    public String getUsuarioDelete() {
        return usuarioDelete;
    }

    /**
     * @param usuarioDelete the usuarioDelete to set
     */
    public void setUsuarioDelete(String usuarioDelete) {
        this.usuarioDelete = usuarioDelete;
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
     * @return the dataDelete
     */
    public String getDataDelete() {
        return dataDelete;
    }

    /**
     * @param dataDelete the dataDelete to set
     */
    public void setDataDelete(String dataDelete) {
        this.dataDelete = dataDelete;
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
