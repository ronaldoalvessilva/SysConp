/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Ronaldo
 */
public class RequisicaoProdutosInternosSEAC {
    private int idReq;
    private String statusReq;
    private Date dataReq;
    private int idLocal;    
    private String nomeLocalArmazenamento;
    private int idInternoCrc;
    private String nomeInternoReq;
    private String descricaoPavilhao;
    private String descricaoCela;
    private int requisicaoUsuario;
    private int idFunc;
    private String nomeColaboradorReq;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;     

    public RequisicaoProdutosInternosSEAC(int idReq, String statusReq, Date dataReq, int idLocal, String nomeLocalArmazenamento, int idInternoCrc, String nomeInternoReq, String descricaoPavilhao, String descricaoCela, int requisicaoUsuario, int idFunc, String nomeColaboradorReq, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idReq = idReq;
        this.statusReq = statusReq;
        this.dataReq = dataReq;
        this.idLocal = idLocal;
        this.nomeLocalArmazenamento = nomeLocalArmazenamento;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoReq = nomeInternoReq;
        this.descricaoPavilhao = descricaoPavilhao;
        this.descricaoCela = descricaoCela;
        this.requisicaoUsuario = requisicaoUsuario;
        this.idFunc = idFunc;
        this.nomeColaboradorReq = nomeColaboradorReq;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public RequisicaoProdutosInternosSEAC() {
    }

    /**
     * @return the idReq
     */
    public int getIdReq() {
        return idReq;
    }

    /**
     * @param idReq the idReq to set
     */
    public void setIdReq(int idReq) {
        this.idReq = idReq;
    }

    /**
     * @return the statusReq
     */
    public String getStatusReq() {
        return statusReq;
    }

    /**
     * @param statusReq the statusReq to set
     */
    public void setStatusReq(String statusReq) {
        this.statusReq = statusReq;
    }

    /**
     * @return the dataReq
     */
    public Date getDataReq() {
        return dataReq;
    }

    /**
     * @param dataReq the dataReq to set
     */
    public void setDataReq(Date dataReq) {
        this.dataReq = dataReq;
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
     * @return the nomeInternoReq
     */
    public String getNomeInternoReq() {
        return nomeInternoReq;
    }

    /**
     * @param nomeInternoReq the nomeInternoReq to set
     */
    public void setNomeInternoReq(String nomeInternoReq) {
        this.nomeInternoReq = nomeInternoReq;
    }

    /**
     * @return the descricaoPavilhao
     */
    public String getDescricaoPavilhao() {
        return descricaoPavilhao;
    }

    /**
     * @param descricaoPavilhao the descricaoPavilhao to set
     */
    public void setDescricaoPavilhao(String descricaoPavilhao) {
        this.descricaoPavilhao = descricaoPavilhao;
    }

    /**
     * @return the descricaoCela
     */
    public String getDescricaoCela() {
        return descricaoCela;
    }

    /**
     * @param descricaoCela the descricaoCela to set
     */
    public void setDescricaoCela(String descricaoCela) {
        this.descricaoCela = descricaoCela;
    }

    /**
     * @return the requisicaoUsuario
     */
    public int getRequisicaoUsuario() {
        return requisicaoUsuario;
    }

    /**
     * @param requisicaoUsuario the requisicaoUsuario to set
     */
    public void setRequisicaoUsuario(int requisicaoUsuario) {
        this.requisicaoUsuario = requisicaoUsuario;
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
     * @return the nomeColaboradorReq
     */
    public String getNomeColaboradorReq() {
        return nomeColaboradorReq;
    }

    /**
     * @param nomeColaboradorReq the nomeColaboradorReq to set
     */
    public void setNomeColaboradorReq(String nomeColaboradorReq) {
        this.nomeColaboradorReq = nomeColaboradorReq;
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
