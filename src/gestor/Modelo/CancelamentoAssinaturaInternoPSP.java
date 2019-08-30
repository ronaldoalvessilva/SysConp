/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronal
 */
public class CancelamentoAssinaturaInternoPSP {

    private int idCancel;
    private String statusCancelamento;
    private Date dataCancelamento;
    private int idInternoCrc;
    private String nomeInterno;
    private int idDepartamento;
    private String descricaoDepartamento;
    private int idRegistro;
    private String usuarioAtendente;
    private Date dataRegistro;
    private String horario;
    private String tipoAtendimento;
    private String motivo;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String horarioInsert;

    public CancelamentoAssinaturaInternoPSP() {
    }

    public CancelamentoAssinaturaInternoPSP(int idCancel, String statusCancelamento, Date dataCancelamento, int idInternoCrc, String nomeInterno, int idDepartamento, String descricaoDepartamento, int idRegistro, String usuarioAtendente, Date dataRegistro, String horario, String tipoAtendimento, String motivo, String usuarioInsert, String usuarioUp, String dataInsert, String horarioInsert) {
        this.idCancel = idCancel;
        this.statusCancelamento = statusCancelamento;
        this.dataCancelamento = dataCancelamento;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.idDepartamento = idDepartamento;
        this.descricaoDepartamento = descricaoDepartamento;
        this.idRegistro = idRegistro;
        this.usuarioAtendente = usuarioAtendente;
        this.dataRegistro = dataRegistro;
        this.horario = horario;
        this.tipoAtendimento = tipoAtendimento;
        this.motivo = motivo;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
    }

    /**
     * @return the idCancel
     */
    public int getIdCancel() {
        return idCancel;
    }

    /**
     * @param idCancel the idCancel to set
     */
    public void setIdCancel(int idCancel) {
        this.idCancel = idCancel;
    }

    /**
     * @return the statusCancelamento
     */
    public String getStatusCancelamento() {
        return statusCancelamento;
    }

    /**
     * @param statusCancelamento the statusCancelamento to set
     */
    public void setStatusCancelamento(String statusCancelamento) {
        this.statusCancelamento = statusCancelamento;
    }

    /**
     * @return the dataCancelamento
     */
    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    /**
     * @param dataCancelamento the dataCancelamento to set
     */
    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
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
     * @return the idDepartamento
     */
    public int getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    /**
     * @return the descricaoDepartamento
     */
    public String getDescricaoDepartamento() {
        return descricaoDepartamento;
    }

    /**
     * @param descricaoDepartamento the descricaoDepartamento to set
     */
    public void setDescricaoDepartamento(String descricaoDepartamento) {
        this.descricaoDepartamento = descricaoDepartamento;
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
     * @return the usuarioAtendente
     */
    public String getUsuarioAtendente() {
        return usuarioAtendente;
    }

    /**
     * @param usuarioAtendente the usuarioAtendente to set
     */
    public void setUsuarioAtendente(String usuarioAtendente) {
        this.usuarioAtendente = usuarioAtendente;
    }

    /**
     * @return the dataRegistro
     */
    public Date getDataRegistro() {
        return dataRegistro;
    }

    /**
     * @param dataRegistro the dataRegistro to set
     */
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the tipoAtendimento
     */
    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    /**
     * @param tipoAtendimento the tipoAtendimento to set
     */
    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
}
