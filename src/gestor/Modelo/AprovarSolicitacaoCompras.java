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
public class AprovarSolicitacaoCompras {

    private int IdAprova;
    private String StatusAprova;
    private Date DataAprova;
    private String nomeUsuarioAprovador;
    private int IdSol;
    private String situacaoSol;
    private String statusSol;    
    private String Observacao;
    private float valorTotalSolicitacao;
    private float valorTotalAprovado;
    private String UsuarioInsert;
    private String UsuarioUp;
    private String DataInsert;
    private String DataUp;
    private String HorarioInsert;
    private String HorarioUp;         

    public AprovarSolicitacaoCompras(int IdAprova, String StatusAprova, Date DataAprova, String nomeUsuarioAprovador, int IdSol, String situacaoSol, String statusSol, String Observacao, float valorTotalSolicitacao, float valorTotalAprovado, String UsuarioInsert, String UsuarioUp, String DataInsert, String DataUp, String HorarioInsert, String HorarioUp) {
        this.IdAprova = IdAprova;
        this.StatusAprova = StatusAprova;
        this.DataAprova = DataAprova;
        this.nomeUsuarioAprovador = nomeUsuarioAprovador;
        this.IdSol = IdSol;
        this.situacaoSol = situacaoSol;
        this.statusSol = statusSol;
        this.Observacao = Observacao;
        this.valorTotalSolicitacao = valorTotalSolicitacao;
        this.valorTotalAprovado = valorTotalAprovado;
        this.UsuarioInsert = UsuarioInsert;
        this.UsuarioUp = UsuarioUp;
        this.DataInsert = DataInsert;
        this.DataUp = DataUp;
        this.HorarioInsert = HorarioInsert;
        this.HorarioUp = HorarioUp;
    }

    public AprovarSolicitacaoCompras() {
    }

    /**
     * @return the IdAprova
     */
    public int getIdAprova() {
        return IdAprova;
    }

    /**
     * @param IdAprova the IdAprova to set
     */
    public void setIdAprova(int IdAprova) {
        this.IdAprova = IdAprova;
    }

    /**
     * @return the StatusAprova
     */
    public String getStatusAprova() {
        return StatusAprova;
    }

    /**
     * @param StatusAprova the StatusAprova to set
     */
    public void setStatusAprova(String StatusAprova) {
        this.StatusAprova = StatusAprova;
    }

    /**
     * @return the DataAprova
     */
    public Date getDataAprova() {
        return DataAprova;
    }

    /**
     * @param DataAprova the DataAprova to set
     */
    public void setDataAprova(Date DataAprova) {
        this.DataAprova = DataAprova;
    }

    /**
     * @return the nomeUsuarioAprovador
     */
    public String getNomeUsuarioAprovador() {
        return nomeUsuarioAprovador;
    }

    /**
     * @param nomeUsuarioAprovador the nomeUsuarioAprovador to set
     */
    public void setNomeUsuarioAprovador(String nomeUsuarioAprovador) {
        this.nomeUsuarioAprovador = nomeUsuarioAprovador;
    }

    /**
     * @return the IdSol
     */
    public int getIdSol() {
        return IdSol;
    }

    /**
     * @param IdSol the IdSol to set
     */
    public void setIdSol(int IdSol) {
        this.IdSol = IdSol;
    }

    /**
     * @return the situacaoSol
     */
    public String getSituacaoSol() {
        return situacaoSol;
    }

    /**
     * @param situacaoSol the situacaoSol to set
     */
    public void setSituacaoSol(String situacaoSol) {
        this.situacaoSol = situacaoSol;
    }

    /**
     * @return the statusSol
     */
    public String getStatusSol() {
        return statusSol;
    }

    /**
     * @param statusSol the statusSol to set
     */
    public void setStatusSol(String statusSol) {
        this.statusSol = statusSol;
    }

    /**
     * @return the Observacao
     */
    public String getObservacao() {
        return Observacao;
    }

    /**
     * @param Observacao the Observacao to set
     */
    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    /**
     * @return the valorTotalSolicitacao
     */
    public float getValorTotalSolicitacao() {
        return valorTotalSolicitacao;
    }

    /**
     * @param valorTotalSolicitacao the valorTotalSolicitacao to set
     */
    public void setValorTotalSolicitacao(float valorTotalSolicitacao) {
        this.valorTotalSolicitacao = valorTotalSolicitacao;
    }

    /**
     * @return the valorTotalAprovado
     */
    public float getValorTotalAprovado() {
        return valorTotalAprovado;
    }

    /**
     * @param valorTotalAprovado the valorTotalAprovado to set
     */
    public void setValorTotalAprovado(float valorTotalAprovado) {
        this.valorTotalAprovado = valorTotalAprovado;
    }

    /**
     * @return the UsuarioInsert
     */
    public String getUsuarioInsert() {
        return UsuarioInsert;
    }

    /**
     * @param UsuarioInsert the UsuarioInsert to set
     */
    public void setUsuarioInsert(String UsuarioInsert) {
        this.UsuarioInsert = UsuarioInsert;
    }

    /**
     * @return the UsuarioUp
     */
    public String getUsuarioUp() {
        return UsuarioUp;
    }

    /**
     * @param UsuarioUp the UsuarioUp to set
     */
    public void setUsuarioUp(String UsuarioUp) {
        this.UsuarioUp = UsuarioUp;
    }

    /**
     * @return the DataInsert
     */
    public String getDataInsert() {
        return DataInsert;
    }

    /**
     * @param DataInsert the DataInsert to set
     */
    public void setDataInsert(String DataInsert) {
        this.DataInsert = DataInsert;
    }

    /**
     * @return the DataUp
     */
    public String getDataUp() {
        return DataUp;
    }

    /**
     * @param DataUp the DataUp to set
     */
    public void setDataUp(String DataUp) {
        this.DataUp = DataUp;
    }

    /**
     * @return the HorarioInsert
     */
    public String getHorarioInsert() {
        return HorarioInsert;
    }

    /**
     * @param HorarioInsert the HorarioInsert to set
     */
    public void setHorarioInsert(String HorarioInsert) {
        this.HorarioInsert = HorarioInsert;
    }

    /**
     * @return the HorarioUp
     */
    public String getHorarioUp() {
        return HorarioUp;
    }

    /**
     * @param HorarioUp the HorarioUp to set
     */
    public void setHorarioUp(String HorarioUp) {
        this.HorarioUp = HorarioUp;
    }
}
