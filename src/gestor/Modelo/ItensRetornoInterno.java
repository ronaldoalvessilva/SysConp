/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author user
 */
public class ItensRetornoInterno {

    private int idRetorno;
    private Date dataRetorno;
    private String nomerOrigem;
    private int idItemRetorno;
    private String documento;
    private int idRegistro;
    private int idInternoCrc;
    private String nomeInterno;
    private String horarioRetorno;
    private String confirmaRetorno;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;    

    public ItensRetornoInterno(int idRetorno, Date dataRetorno, String nomerOrigem, int idItemRetorno, String documento, int idRegistro, int idInternoCrc, String nomeInterno, String horarioRetorno, String confirmaRetorno, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp) {
        this.idRetorno = idRetorno;
        this.dataRetorno = dataRetorno;
        this.nomerOrigem = nomerOrigem;
        this.idItemRetorno = idItemRetorno;
        this.documento = documento;
        this.idRegistro = idRegistro;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.horarioRetorno = horarioRetorno;
        this.confirmaRetorno = confirmaRetorno;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
    }

    public ItensRetornoInterno() {
    }

    /**
     * @return the idRetorno
     */
    public int getIdRetorno() {
        return idRetorno;
    }

    /**
     * @param idRetorno the idRetorno to set
     */
    public void setIdRetorno(int idRetorno) {
        this.idRetorno = idRetorno;
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
     * @return the nomerOrigem
     */
    public String getNomerOrigem() {
        return nomerOrigem;
    }

    /**
     * @param nomerOrigem the nomerOrigem to set
     */
    public void setNomerOrigem(String nomerOrigem) {
        this.nomerOrigem = nomerOrigem;
    }

    /**
     * @return the idItemRetorno
     */
    public int getIdItemRetorno() {
        return idItemRetorno;
    }

    /**
     * @param idItemRetorno the idItemRetorno to set
     */
    public void setIdItemRetorno(int idItemRetorno) {
        this.idItemRetorno = idItemRetorno;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
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
     * @return the horarioRetorno
     */
    public String getHorarioRetorno() {
        return horarioRetorno;
    }

    /**
     * @param horarioRetorno the horarioRetorno to set
     */
    public void setHorarioRetorno(String horarioRetorno) {
        this.horarioRetorno = horarioRetorno;
    }

    /**
     * @return the confirmaRetorno
     */
    public String getConfirmaRetorno() {
        return confirmaRetorno;
    }

    /**
     * @param confirmaRetorno the confirmaRetorno to set
     */
    public void setConfirmaRetorno(String confirmaRetorno) {
        this.confirmaRetorno = confirmaRetorno;
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
