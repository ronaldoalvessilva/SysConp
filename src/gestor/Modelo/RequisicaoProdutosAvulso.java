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
public class RequisicaoProdutosAvulso {
    
    private int idReq;
    private String statusReq;
    private String statusReqAtend;
    private Date dataReq;
    private int idLocal;    
    private String nomeLocalArmazenamento;
    private int idFuncAutorizador;
    private String nomeFuncAutorizador;
    private String descricaoDeptoAutorizador;
    private String matriculaFuncAutorizador;   
    private int idFuncReq;
    private String nomeColaboradorReq;
    private int idMot;
    private String tituloMotivo;
    private int TipoRequisicao;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;  
    private String produtosAvaria;   

    public RequisicaoProdutosAvulso(int idReq, String statusReq, String statusReqAtend, Date dataReq, int idLocal, String nomeLocalArmazenamento, int idFuncAutorizador, String nomeFuncAutorizador, String descricaoDeptoAutorizador, String matriculaFuncAutorizador, int idFuncReq, String nomeColaboradorReq, int idMot, String tituloMotivo, int TipoRequisicao, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String produtosAvaria) {
        this.idReq = idReq;
        this.statusReq = statusReq;
        this.statusReqAtend = statusReqAtend;
        this.dataReq = dataReq;
        this.idLocal = idLocal;
        this.nomeLocalArmazenamento = nomeLocalArmazenamento;
        this.idFuncAutorizador = idFuncAutorizador;
        this.nomeFuncAutorizador = nomeFuncAutorizador;
        this.descricaoDeptoAutorizador = descricaoDeptoAutorizador;
        this.matriculaFuncAutorizador = matriculaFuncAutorizador;
        this.idFuncReq = idFuncReq;
        this.nomeColaboradorReq = nomeColaboradorReq;
        this.idMot = idMot;
        this.tituloMotivo = tituloMotivo;
        this.TipoRequisicao = TipoRequisicao;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.produtosAvaria = produtosAvaria;
    }

    public RequisicaoProdutosAvulso() {
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
     * @return the statusReqAtend
     */
    public String getStatusReqAtend() {
        return statusReqAtend;
    }

    /**
     * @param statusReqAtend the statusReqAtend to set
     */
    public void setStatusReqAtend(String statusReqAtend) {
        this.statusReqAtend = statusReqAtend;
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
     * @return the idFuncAutorizador
     */
    public int getIdFuncAutorizador() {
        return idFuncAutorizador;
    }

    /**
     * @param idFuncAutorizador the idFuncAutorizador to set
     */
    public void setIdFuncAutorizador(int idFuncAutorizador) {
        this.idFuncAutorizador = idFuncAutorizador;
    }

    /**
     * @return the nomeFuncAutorizador
     */
    public String getNomeFuncAutorizador() {
        return nomeFuncAutorizador;
    }

    /**
     * @param nomeFuncAutorizador the nomeFuncAutorizador to set
     */
    public void setNomeFuncAutorizador(String nomeFuncAutorizador) {
        this.nomeFuncAutorizador = nomeFuncAutorizador;
    }

    /**
     * @return the descricaoDeptoAutorizador
     */
    public String getDescricaoDeptoAutorizador() {
        return descricaoDeptoAutorizador;
    }

    /**
     * @param descricaoDeptoAutorizador the descricaoDeptoAutorizador to set
     */
    public void setDescricaoDeptoAutorizador(String descricaoDeptoAutorizador) {
        this.descricaoDeptoAutorizador = descricaoDeptoAutorizador;
    }

    /**
     * @return the matriculaFuncAutorizador
     */
    public String getMatriculaFuncAutorizador() {
        return matriculaFuncAutorizador;
    }

    /**
     * @param matriculaFuncAutorizador the matriculaFuncAutorizador to set
     */
    public void setMatriculaFuncAutorizador(String matriculaFuncAutorizador) {
        this.matriculaFuncAutorizador = matriculaFuncAutorizador;
    }

    /**
     * @return the idFuncReq
     */
    public int getIdFuncReq() {
        return idFuncReq;
    }

    /**
     * @param idFuncReq the idFuncReq to set
     */
    public void setIdFuncReq(int idFuncReq) {
        this.idFuncReq = idFuncReq;
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
     * @return the tituloMotivo
     */
    public String getTituloMotivo() {
        return tituloMotivo;
    }

    /**
     * @param tituloMotivo the tituloMotivo to set
     */
    public void setTituloMotivo(String tituloMotivo) {
        this.tituloMotivo = tituloMotivo;
    }

    /**
     * @return the TipoRequisicao
     */
    public int getTipoRequisicao() {
        return TipoRequisicao;
    }

    /**
     * @param TipoRequisicao the TipoRequisicao to set
     */
    public void setTipoRequisicao(int TipoRequisicao) {
        this.TipoRequisicao = TipoRequisicao;
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

    /**
     * @return the produtosAvaria
     */
    public String getProdutosAvaria() {
        return produtosAvaria;
    }

    /**
     * @param produtosAvaria the produtosAvaria to set
     */
    public void setProdutosAvaria(String produtosAvaria) {
        this.produtosAvaria = produtosAvaria;
    }
}
