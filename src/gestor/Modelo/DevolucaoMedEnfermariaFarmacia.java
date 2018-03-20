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
public class DevolucaoMedEnfermariaFarmacia {

    private int idDevo;
    private String statusDevo;
    private Date dataDevo;
    private int idMot;
    private String descricaoMotivo;
    private int idLocal;
    private String DescricaoLocalOrigem;
    private int idFunc;
    private String nomecolaborador;
    private int idLocalDst;
    private String descricaoLocalDestino;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public DevolucaoMedEnfermariaFarmacia(int idDevo, String statusDevo, Date dataDevo, int idMot, String descricaoMotivo, int idLocal, String DescricaoLocalOrigem, int idFunc, String nomecolaborador, int idLocalDst, String descricaoLocalDestino, String observacao, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idDevo = idDevo;
        this.statusDevo = statusDevo;
        this.dataDevo = dataDevo;
        this.idMot = idMot;
        this.descricaoMotivo = descricaoMotivo;
        this.idLocal = idLocal;
        this.DescricaoLocalOrigem = DescricaoLocalOrigem;
        this.idFunc = idFunc;
        this.nomecolaborador = nomecolaborador;
        this.idLocalDst = idLocalDst;
        this.descricaoLocalDestino = descricaoLocalDestino;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public DevolucaoMedEnfermariaFarmacia() {
    }

    /**
     * @return the idDevo
     */
    public int getIdDevo() {
        return idDevo;
    }

    /**
     * @param idDevo the idDevo to set
     */
    public void setIdDevo(int idDevo) {
        this.idDevo = idDevo;
    }

    /**
     * @return the statusDevo
     */
    public String getStatusDevo() {
        return statusDevo;
    }

    /**
     * @param statusDevo the statusDevo to set
     */
    public void setStatusDevo(String statusDevo) {
        this.statusDevo = statusDevo;
    }

    /**
     * @return the dataDevo
     */
    public Date getDataDevo() {
        return dataDevo;
    }

    /**
     * @param dataDevo the dataDevo to set
     */
    public void setDataDevo(Date dataDevo) {
        this.dataDevo = dataDevo;
    }

    /**
     * @return the idMot
     */
    public int getIdMot() {
        return idMot;
    }

    /**
     * @param idMot the idMot to set
     */
    public void setIdMot(int idMot) {
        this.idMot = idMot;
    }

    /**
     * @return the descricaoMotivo
     */
    public String getDescricaoMotivo() {
        return descricaoMotivo;
    }

    /**
     * @param descricaoMotivo the descricaoMotivo to set
     */
    public void setDescricaoMotivo(String descricaoMotivo) {
        this.descricaoMotivo = descricaoMotivo;
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
     * @return the DescricaoLocalOrigem
     */
    public String getDescricaoLocalOrigem() {
        return DescricaoLocalOrigem;
    }

    /**
     * @param DescricaoLocalOrigem the DescricaoLocalOrigem to set
     */
    public void setDescricaoLocalOrigem(String DescricaoLocalOrigem) {
        this.DescricaoLocalOrigem = DescricaoLocalOrigem;
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
     * @return the nomecolaborador
     */
    public String getNomecolaborador() {
        return nomecolaborador;
    }

    /**
     * @param nomecolaborador the nomecolaborador to set
     */
    public void setNomecolaborador(String nomecolaborador) {
        this.nomecolaborador = nomecolaborador;
    }

    /**
     * @return the idLocalDst
     */
    public int getIdLocalDst() {
        return idLocalDst;
    }

    /**
     * @param idLocalDst the idLocalDst to set
     */
    public void setIdLocalDst(int idLocalDst) {
        this.idLocalDst = idLocalDst;
    }

    /**
     * @return the descricaoLocalDestino
     */
    public String getDescricaoLocalDestino() {
        return descricaoLocalDestino;
    }

    /**
     * @param descricaoLocalDestino the descricaoLocalDestino to set
     */
    public void setDescricaoLocalDestino(String descricaoLocalDestino) {
        this.descricaoLocalDestino = descricaoLocalDestino;
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
