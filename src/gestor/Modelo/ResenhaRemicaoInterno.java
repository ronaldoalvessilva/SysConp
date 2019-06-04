/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Socializa TI 02
 */
public class ResenhaRemicaoInterno {

    private int idResenha;
    private String statusResenha;
    private Date dataResenha;
    private int idLivro;
    private String tituloLivro;
    private String autorLivro;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int idFunc;
    private String nomeColaboradorResp;
    private String resenhaEntregue;
    private Date dataEntraga;
    private int nrResenha;
    private float validacaoResenha;
    private float paragrafo;
    private float margens;
    private float legivel;
    private float rasuras;
    private float compreensao;
    private float compatibilidade;
    private float tema;
    private String fidedignidade;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public ResenhaRemicaoInterno() {
    }

    public ResenhaRemicaoInterno(int idResenha, String statusResenha, Date dataResenha, int idLivro, String tituloLivro, String autorLivro, int idInternoCrc, String nomeInternoCrc, int idFunc, String nomeColaboradorResp, String resenhaEntregue, Date dataEntraga, int nrResenha, float validacaoResenha, float paragrafo, float margens, float legivel, float rasuras, float compreensao, float compatibilidade, float tema, String fidedignidade, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idResenha = idResenha;
        this.statusResenha = statusResenha;
        this.dataResenha = dataResenha;
        this.idLivro = idLivro;
        this.tituloLivro = tituloLivro;
        this.autorLivro = autorLivro;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idFunc = idFunc;
        this.nomeColaboradorResp = nomeColaboradorResp;
        this.resenhaEntregue = resenhaEntregue;
        this.dataEntraga = dataEntraga;
        this.nrResenha = nrResenha;
        this.validacaoResenha = validacaoResenha;
        this.paragrafo = paragrafo;
        this.margens = margens;
        this.legivel = legivel;
        this.rasuras = rasuras;
        this.compreensao = compreensao;
        this.compatibilidade = compatibilidade;
        this.tema = tema;
        this.fidedignidade = fidedignidade;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idResenha
     */
    public int getIdResenha() {
        return idResenha;
    }

    /**
     * @param idResenha the idResenha to set
     */
    public void setIdResenha(int idResenha) {
        this.idResenha = idResenha;
    }

    /**
     * @return the statusResenha
     */
    public String getStatusResenha() {
        return statusResenha;
    }

    /**
     * @param statusResenha the statusResenha to set
     */
    public void setStatusResenha(String statusResenha) {
        this.statusResenha = statusResenha;
    }

    /**
     * @return the dataResenha
     */
    public Date getDataResenha() {
        return dataResenha;
    }

    /**
     * @param dataResenha the dataResenha to set
     */
    public void setDataResenha(Date dataResenha) {
        this.dataResenha = dataResenha;
    }

    /**
     * @return the idLivro
     */
    public int getIdLivro() {
        return idLivro;
    }

    /**
     * @param idLivro the idLivro to set
     */
    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    /**
     * @return the tituloLivro
     */
    public String getTituloLivro() {
        return tituloLivro;
    }

    /**
     * @param tituloLivro the tituloLivro to set
     */
    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    /**
     * @return the autorLivro
     */
    public String getAutorLivro() {
        return autorLivro;
    }

    /**
     * @param autorLivro the autorLivro to set
     */
    public void setAutorLivro(String autorLivro) {
        this.autorLivro = autorLivro;
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
     * @return the nomeInternoCrc
     */
    public String getNomeInternoCrc() {
        return nomeInternoCrc;
    }

    /**
     * @param nomeInternoCrc the nomeInternoCrc to set
     */
    public void setNomeInternoCrc(String nomeInternoCrc) {
        this.nomeInternoCrc = nomeInternoCrc;
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
     * @return the nomeColaboradorResp
     */
    public String getNomeColaboradorResp() {
        return nomeColaboradorResp;
    }

    /**
     * @param nomeColaboradorResp the nomeColaboradorResp to set
     */
    public void setNomeColaboradorResp(String nomeColaboradorResp) {
        this.nomeColaboradorResp = nomeColaboradorResp;
    }

    /**
     * @return the resenhaEntregue
     */
    public String getResenhaEntregue() {
        return resenhaEntregue;
    }

    /**
     * @param resenhaEntregue the resenhaEntregue to set
     */
    public void setResenhaEntregue(String resenhaEntregue) {
        this.resenhaEntregue = resenhaEntregue;
    }

    /**
     * @return the dataEntraga
     */
    public Date getDataEntraga() {
        return dataEntraga;
    }

    /**
     * @param dataEntraga the dataEntraga to set
     */
    public void setDataEntraga(Date dataEntraga) {
        this.dataEntraga = dataEntraga;
    }

    /**
     * @return the nrResenha
     */
    public int getNrResenha() {
        return nrResenha;
    }

    /**
     * @param nrResenha the nrResenha to set
     */
    public void setNrResenha(int nrResenha) {
        this.nrResenha = nrResenha;
    }

    /**
     * @return the validacaoResenha
     */
    public float getValidacaoResenha() {
        return validacaoResenha;
    }

    /**
     * @param validacaoResenha the validacaoResenha to set
     */
    public void setValidacaoResenha(float validacaoResenha) {
        this.validacaoResenha = validacaoResenha;
    }

    /**
     * @return the paragrafo
     */
    public float getParagrafo() {
        return paragrafo;
    }

    /**
     * @param paragrafo the paragrafo to set
     */
    public void setParagrafo(float paragrafo) {
        this.paragrafo = paragrafo;
    }

    /**
     * @return the margens
     */
    public float getMargens() {
        return margens;
    }

    /**
     * @param margens the margens to set
     */
    public void setMargens(float margens) {
        this.margens = margens;
    }

    /**
     * @return the legivel
     */
    public float getLegivel() {
        return legivel;
    }

    /**
     * @param legivel the legivel to set
     */
    public void setLegivel(float legivel) {
        this.legivel = legivel;
    }

    /**
     * @return the rasuras
     */
    public float getRasuras() {
        return rasuras;
    }

    /**
     * @param rasuras the rasuras to set
     */
    public void setRasuras(float rasuras) {
        this.rasuras = rasuras;
    }

    /**
     * @return the compreensao
     */
    public float getCompreensao() {
        return compreensao;
    }

    /**
     * @param compreensao the compreensao to set
     */
    public void setCompreensao(float compreensao) {
        this.compreensao = compreensao;
    }

    /**
     * @return the compatibilidade
     */
    public float getCompatibilidade() {
        return compatibilidade;
    }

    /**
     * @param compatibilidade the compatibilidade to set
     */
    public void setCompatibilidade(float compatibilidade) {
        this.compatibilidade = compatibilidade;
    }

    /**
     * @return the tema
     */
    public float getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(float tema) {
        this.tema = tema;
    }

    /**
     * @return the fidedignidade
     */
    public String getFidedignidade() {
        return fidedignidade;
    }

    /**
     * @param fidedignidade the fidedignidade to set
     */
    public void setFidedignidade(String fidedignidade) {
        this.fidedignidade = fidedignidade;
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
