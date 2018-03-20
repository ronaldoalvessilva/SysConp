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
public class InventarioEstoqueAcervo {

    private int idLanc;
    private String statusLanc;
    private String tipoInventario;
    private int idLocal;
    private String nomeLocalArmazenamento;
    private String responsavel;
    private Date dataInicio;
    private Date dataTermino;
    private String horarioInicio;
    private String horarioTermino;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String usuarioDelete;
    private String horarioInsert;
    private String horarioUp;
    private String horarioDelete;

    public InventarioEstoqueAcervo(int idLanc, String statusLanc, String tipoInventario, int idLocal, String nomeLocalArmazenamento, String responsavel, Date dataInicio, Date dataTermino, String horarioInicio, String horarioTermino, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String dataDelete, String usuarioDelete, String horarioInsert, String horarioUp, String horarioDelete) {
        this.idLanc = idLanc;
        this.statusLanc = statusLanc;
        this.tipoInventario = tipoInventario;
        this.idLocal = idLocal;
        this.nomeLocalArmazenamento = nomeLocalArmazenamento;
        this.responsavel = responsavel;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.usuarioDelete = usuarioDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.horarioDelete = horarioDelete;
    }

    public InventarioEstoqueAcervo() {
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
     * @return the tipoInventario
     */
    public String getTipoInventario() {
        return tipoInventario;
    }

    /**
     * @param tipoInventario the tipoInventario to set
     */
    public void setTipoInventario(String tipoInventario) {
        this.tipoInventario = tipoInventario;
    }

    /**
     * @return the idLocal
     */
    public int getIdLocal() {
        return idLocal;
    }

    /**
     * @param idLocal the idLocal to set
     */
    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    /**
     * @return the nomeLocalArmazenamento
     */
    public String getNomeLocalArmazenamento() {
        return nomeLocalArmazenamento;
    }

    /**
     * @param nomeLocalArmazenamento the nomeLocalArmazenamento to set
     */
    public void setNomeLocalArmazenamento(String nomeLocalArmazenamento) {
        this.nomeLocalArmazenamento = nomeLocalArmazenamento;
    }

    /**
     * @return the responsavel
     */
    public String getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataTermino
     */
    public Date getDataTermino() {
        return dataTermino;
    }

    /**
     * @param dataTermino the dataTermino to set
     */
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    /**
     * @return the horarioInicio
     */
    public String getHorarioInicio() {
        return horarioInicio;
    }

    /**
     * @param horarioInicio the horarioInicio to set
     */
    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    /**
     * @return the horarioTermino
     */
    public String getHorarioTermino() {
        return horarioTermino;
    }

    /**
     * @param horarioTermino the horarioTermino to set
     */
    public void setHorarioTermino(String horarioTermino) {
        this.horarioTermino = horarioTermino;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
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

    /**
     * @return the horarioDelete
     */
    public String getHorarioDelete() {
        return horarioDelete;
    }

    /**
     * @param horarioDelete the horarioDelete to set
     */
    public void setHorarioDelete(String horarioDelete) {
        this.horarioDelete = horarioDelete;
    }
}
