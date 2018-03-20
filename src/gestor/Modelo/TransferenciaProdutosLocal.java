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
public class TransferenciaProdutosLocal {

    private int idLanc;
    private String statusLanc;
    private Date dataLanc;
    private int idLocal;
    private String nomeLocal;
    private int idFunc;
    private String NomeColaborador;
    private int idRequisicaoEnfermaria;
    private int idLocalDst;
    private String descricaoLocalDestino;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;    
    private String dataInsert;
    private String dataUp;    
    private String horarioInsert;
    private String horarioUp;      

    public TransferenciaProdutosLocal(int idLanc, String statusLanc, Date dataLanc, int idLocal, String nomeLocal, int idFunc, String NomeColaborador, int idRequisicaoEnfermaria, int idLocalDst, String descricaoLocalDestino, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idLanc = idLanc;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.idLocal = idLocal;
        this.nomeLocal = nomeLocal;
        this.idFunc = idFunc;
        this.NomeColaborador = NomeColaborador;
        this.idRequisicaoEnfermaria = idRequisicaoEnfermaria;
        this.idLocalDst = idLocalDst;
        this.descricaoLocalDestino = descricaoLocalDestino;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public TransferenciaProdutosLocal() {
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
     * @return the dataLanc
     */
    public Date getDataLanc() {
        return dataLanc;
    }

    /**
     * @param dataLanc the dataLanc to set
     */
    public void setDataLanc(Date dataLanc) {
        this.dataLanc = dataLanc;
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
     * @return the nomeLocal
     */
    public String getNomeLocal() {
        return nomeLocal;
    }

    /**
     * @param nomeLocal the nomeLocal to set
     */
    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
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
     * @return the NomeColaborador
     */
    public String getNomeColaborador() {
        return NomeColaborador;
    }

    /**
     * @param NomeColaborador the NomeColaborador to set
     */
    public void setNomeColaborador(String NomeColaborador) {
        this.NomeColaborador = NomeColaborador;
    }

    /**
     * @return the idRequisicaoEnfermaria
     */
    public int getIdRequisicaoEnfermaria() {
        return idRequisicaoEnfermaria;
    }

    /**
     * @param idRequisicaoEnfermaria the idRequisicaoEnfermaria to set
     */
    public void setIdRequisicaoEnfermaria(int idRequisicaoEnfermaria) {
        this.idRequisicaoEnfermaria = idRequisicaoEnfermaria;
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
