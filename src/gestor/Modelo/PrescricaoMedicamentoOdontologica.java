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
public class PrescricaoMedicamentoOdontologica {

    private int idPre;
    private String statusLanc;
    private int idInternoCrc;
    private Date dataPrescricao;
    private int idLanc;
    private int tipoPrescricaoMedica;
    private String textoPrescricao;
    private String deptoMedico;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;    

    public PrescricaoMedicamentoOdontologica(int idPre, String statusLanc, int idInternoCrc, Date dataPrescricao, int idLanc, int tipoPrescricaoMedica, String textoPrescricao, String deptoMedico, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento) {
        this.idPre = idPre;
        this.statusLanc = statusLanc;
        this.idInternoCrc = idInternoCrc;
        this.dataPrescricao = dataPrescricao;
        this.idLanc = idLanc;
        this.tipoPrescricaoMedica = tipoPrescricaoMedica;
        this.textoPrescricao = textoPrescricao;
        this.deptoMedico = deptoMedico;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
    }

    public PrescricaoMedicamentoOdontologica() {
    }

    /**
     * @return the idPre
     */
    public int getIdPre() {
        return idPre;
    }

    /**
     * @param idPre the idPre to set
     */
    public void setIdPre(int idPre) {
        this.idPre = idPre;
    }

    /**
     * @return the statusLanc
     */
    public String getStatusLanc() {
        return statusLanc;
    }

    /**
     * @param statusLanc the statusLanc to set
     */
    public void setStatusLanc(String statusLanc) {
        this.statusLanc = statusLanc;
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
     * @return the dataPrescricao
     */
    public Date getDataPrescricao() {
        return dataPrescricao;
    }

    /**
     * @param dataPrescricao the dataPrescricao to set
     */
    public void setDataPrescricao(Date dataPrescricao) {
        this.dataPrescricao = dataPrescricao;
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
     * @return the tipoPrescricaoMedica
     */
    public int getTipoPrescricaoMedica() {
        return tipoPrescricaoMedica;
    }

    /**
     * @param tipoPrescricaoMedica the tipoPrescricaoMedica to set
     */
    public void setTipoPrescricaoMedica(int tipoPrescricaoMedica) {
        this.tipoPrescricaoMedica = tipoPrescricaoMedica;
    }

    /**
     * @return the textoPrescricao
     */
    public String getTextoPrescricao() {
        return textoPrescricao;
    }

    /**
     * @param textoPrescricao the textoPrescricao to set
     */
    public void setTextoPrescricao(String textoPrescricao) {
        this.textoPrescricao = textoPrescricao;
    }

    /**
     * @return the deptoMedico
     */
    public String getDeptoMedico() {
        return deptoMedico;
    }

    /**
     * @param deptoMedico the deptoMedico to set
     */
    public void setDeptoMedico(String deptoMedico) {
        this.deptoMedico = deptoMedico;
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

    /**
     * @return the dataFechamento
     */
    public String getDataFechamento() {
        return dataFechamento;
    }

    /**
     * @param dataFechamento the dataFechamento to set
     */
    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    /**
     * @return the horaFechamento
     */
    public String getHoraFechamento() {
        return horaFechamento;
    }

    /**
     * @param horaFechamento the horaFechamento to set
     */
    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }
}
