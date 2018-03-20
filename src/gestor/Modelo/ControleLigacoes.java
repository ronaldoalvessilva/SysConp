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
public class ControleLigacoes {

    private int IdControl;
    private Date DataControl;
    private String statusLigacao;
    private int IdInternoCrc;
    private String nomeInterno;
    private String TelefoneControl;
    private String TempoControl;
    private String LocalLigacao;
    private String ObsControl;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;

    public ControleLigacoes(int IdControl, Date DataControl, String statusLigacao, int IdInternoCrc, String nomeInterno, String TelefoneControl, String TempoControl, String LocalLigacao, String ObsControl, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento) {
        this.IdControl = IdControl;
        this.DataControl = DataControl;
        this.statusLigacao = statusLigacao;
        this.IdInternoCrc = IdInternoCrc;
        this.nomeInterno = nomeInterno;
        this.TelefoneControl = TelefoneControl;
        this.TempoControl = TempoControl;
        this.LocalLigacao = LocalLigacao;
        this.ObsControl = ObsControl;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
    }

    public ControleLigacoes() {
    }

    /**
     * @return the IdControl
     */
    public int getIdControl() {
        return IdControl;
    }

    /**
     * @param IdControl the IdControl to set
     */
    public void setIdControl(int IdControl) {
        this.IdControl = IdControl;
    }

    /**
     * @return the DataControl
     */
    public Date getDataControl() {
        return DataControl;
    }

    /**
     * @param DataControl the DataControl to set
     */
    public void setDataControl(Date DataControl) {
        this.DataControl = DataControl;
    }

    /**
     * @return the statusLigacao
     */
    public String getStatusLigacao() {
        return statusLigacao;
    }

    /**
     * @param statusLigacao the statusLigacao to set
     */
    public void setStatusLigacao(String statusLigacao) {
        this.statusLigacao = statusLigacao;
    }

    /**
     * @return the IdInternoCrc
     */
    public int getIdInternoCrc() {
        return IdInternoCrc;
    }

    /**
     * @param IdInternoCrc the IdInternoCrc to set
     */
    public void setIdInternoCrc(int IdInternoCrc) {
        this.IdInternoCrc = IdInternoCrc;
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
     * @return the TelefoneControl
     */
    public String getTelefoneControl() {
        return TelefoneControl;
    }

    /**
     * @param TelefoneControl the TelefoneControl to set
     */
    public void setTelefoneControl(String TelefoneControl) {
        this.TelefoneControl = TelefoneControl;
    }

    /**
     * @return the TempoControl
     */
    public String getTempoControl() {
        return TempoControl;
    }

    /**
     * @param TempoControl the TempoControl to set
     */
    public void setTempoControl(String TempoControl) {
        this.TempoControl = TempoControl;
    }

    /**
     * @return the LocalLigacao
     */
    public String getLocalLigacao() {
        return LocalLigacao;
    }

    /**
     * @param LocalLigacao the LocalLigacao to set
     */
    public void setLocalLigacao(String LocalLigacao) {
        this.LocalLigacao = LocalLigacao;
    }

    /**
     * @return the ObsControl
     */
    public String getObsControl() {
        return ObsControl;
    }

    /**
     * @param ObsControl the ObsControl to set
     */
    public void setObsControl(String ObsControl) {
        this.ObsControl = ObsControl;
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
