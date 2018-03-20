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
public class SolicitacaoComprasAC {

    private int idSol;
    private String statusSol;
    private String situacao;
    private Date dataSol;
    private int idFunc;
    private String nomeColaborador;
    private int idLibera;  
    private String nomeLiberador;
    private int idlocalEstoque;
    private String descricaoLocal;
    private int tipoValor;
    private String modulo;
    private float valorAprovado;
    private String observacao;
    private float valorSaldoRequisicao;
    private float valorSaldoPedido;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;                 

    public SolicitacaoComprasAC(int idSol, String statusSol, String situacao, Date dataSol, int idFunc, String nomeColaborador, int idLibera, String nomeLiberador, int idlocalEstoque, String descricaoLocal, int tipoValor, String modulo, float valorAprovado, String observacao, float valorSaldoRequisicao, float valorSaldoPedido, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idSol = idSol;
        this.statusSol = statusSol;
        this.situacao = situacao;
        this.dataSol = dataSol;
        this.idFunc = idFunc;
        this.nomeColaborador = nomeColaborador;
        this.idLibera = idLibera;
        this.nomeLiberador = nomeLiberador;
        this.idlocalEstoque = idlocalEstoque;
        this.descricaoLocal = descricaoLocal;
        this.tipoValor = tipoValor;
        this.modulo = modulo;
        this.valorAprovado = valorAprovado;
        this.observacao = observacao;
        this.valorSaldoRequisicao = valorSaldoRequisicao;
        this.valorSaldoPedido = valorSaldoPedido;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public SolicitacaoComprasAC() {
    }

    /**
     * @return the idSol
     */
    public int getIdSol() {
        return idSol;
    }

    /**
     * @param idSol the idSol to set
     */
    public void setIdSol(int idSol) {
        this.idSol = idSol;
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
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the dataSol
     */
    public Date getDataSol() {
        return dataSol;
    }

    /**
     * @param dataSol the dataSol to set
     */
    public void setDataSol(Date dataSol) {
        this.dataSol = dataSol;
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
     * @return the nomeColaborador
     */
    public String getNomeColaborador() {
        return nomeColaborador;
    }

    /**
     * @param nomeColaborador the nomeColaborador to set
     */
    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    /**
     * @return the idLibera
     */
    public int getIdLibera() {
        return idLibera;
    }

    /**
     * @param idLibera the idLibera to set
     */
    public void setIdLibera(int idLibera) {
        this.idLibera = idLibera;
    }

    /**
     * @return the nomeLiberador
     */
    public String getNomeLiberador() {
        return nomeLiberador;
    }

    /**
     * @param nomeLiberador the nomeLiberador to set
     */
    public void setNomeLiberador(String nomeLiberador) {
        this.nomeLiberador = nomeLiberador;
    }

    /**
     * @return the idlocalEstoque
     */
    public int getIdlocalEstoque() {
        return idlocalEstoque;
    }

    /**
     * @param idlocalEstoque the idlocalEstoque to set
     */
    public void setIdlocalEstoque(int idlocalEstoque) {
        this.idlocalEstoque = idlocalEstoque;
    }

    /**
     * @return the descricaoLocal
     */
    public String getDescricaoLocal() {
        return descricaoLocal;
    }

    /**
     * @param descricaoLocal the descricaoLocal to set
     */
    public void setDescricaoLocal(String descricaoLocal) {
        this.descricaoLocal = descricaoLocal;
    }

    /**
     * @return the tipoValor
     */
    public int getTipoValor() {
        return tipoValor;
    }

    /**
     * @param tipoValor the tipoValor to set
     */
    public void setTipoValor(int tipoValor) {
        this.tipoValor = tipoValor;
    }

    /**
     * @return the modulo
     */
    public String getModulo() {
        return modulo;
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    /**
     * @return the valorAprovado
     */
    public float getValorAprovado() {
        return valorAprovado;
    }

    /**
     * @param valorAprovado the valorAprovado to set
     */
    public void setValorAprovado(float valorAprovado) {
        this.valorAprovado = valorAprovado;
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
     * @return the valorSaldoRequisicao
     */
    public float getValorSaldoRequisicao() {
        return valorSaldoRequisicao;
    }

    /**
     * @param valorSaldoRequisicao the valorSaldoRequisicao to set
     */
    public void setValorSaldoRequisicao(float valorSaldoRequisicao) {
        this.valorSaldoRequisicao = valorSaldoRequisicao;
    }

    /**
     * @return the valorSaldoPedido
     */
    public float getValorSaldoPedido() {
        return valorSaldoPedido;
    }

    /**
     * @param valorSaldoPedido the valorSaldoPedido to set
     */
    public void setValorSaldoPedido(float valorSaldoPedido) {
        this.valorSaldoPedido = valorSaldoPedido;
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
