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
public class ItensAprazamentoMedicamento {

    private int idItem;
    private int idProd;
    private String descricaoProduto;
    private int idReq;
    private int idLanc;
    private int idInternoCrc;
    private int codItem;
    private int qtdItem;
    private int qtdDoseAtend;
    private int quantidadeRequisitada;
    private int qtdDosesAplicada;
    private String unidade;
    private String frequencia;
    private int diasUso;
    private Date dataInicio;
    private Date dataTermino;
    private String periodoHoras;
    private String horarioInicial;
    private String horarioFinal;
    private String textoObservacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;                               

    public ItensAprazamentoMedicamento(int idItem, int idProd, String descricaoProduto, int idReq, int idLanc, int idInternoCrc, int codItem, int qtdItem, int qtdDoseAtend, int quantidadeRequisitada, int qtdDosesAplicada, String unidade, String frequencia, int diasUso, Date dataInicio, Date dataTermino, String periodoHoras, String horarioInicial, String horarioFinal, String textoObservacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.idProd = idProd;
        this.descricaoProduto = descricaoProduto;
        this.idReq = idReq;
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.codItem = codItem;
        this.qtdItem = qtdItem;
        this.qtdDoseAtend = qtdDoseAtend;
        this.quantidadeRequisitada = quantidadeRequisitada;
        this.qtdDosesAplicada = qtdDosesAplicada;
        this.unidade = unidade;
        this.frequencia = frequencia;
        this.diasUso = diasUso;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.periodoHoras = periodoHoras;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.textoObservacao = textoObservacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensAprazamentoMedicamento() {
    }

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the idProd
     */
    public int getIdProd() {
        return idProd;
    }

    /**
     * @param idProd the idProd to set
     */
    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
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
     * @return the codItem
     */
    public int getCodItem() {
        return codItem;
    }

    /**
     * @param codItem the codItem to set
     */
    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    /**
     * @return the qtdItem
     */
    public int getQtdItem() {
        return qtdItem;
    }

    /**
     * @param qtdItem the qtdItem to set
     */
    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }

    /**
     * @return the qtdDoseAtend
     */
    public int getQtdDoseAtend() {
        return qtdDoseAtend;
    }

    /**
     * @param qtdDoseAtend the qtdDoseAtend to set
     */
    public void setQtdDoseAtend(int qtdDoseAtend) {
        this.qtdDoseAtend = qtdDoseAtend;
    }

    /**
     * @return the quantidadeRequisitada
     */
    public int getQuantidadeRequisitada() {
        return quantidadeRequisitada;
    }

    /**
     * @param quantidadeRequisitada the quantidadeRequisitada to set
     */
    public void setQuantidadeRequisitada(int quantidadeRequisitada) {
        this.quantidadeRequisitada = quantidadeRequisitada;
    }

    /**
     * @return the qtdDosesAplicada
     */
    public int getQtdDosesAplicada() {
        return qtdDosesAplicada;
    }

    /**
     * @param qtdDosesAplicada the qtdDosesAplicada to set
     */
    public void setQtdDosesAplicada(int qtdDosesAplicada) {
        this.qtdDosesAplicada = qtdDosesAplicada;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the frequencia
     */
    public String getFrequencia() {
        return frequencia;
    }

    /**
     * @param frequencia the frequencia to set
     */
    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    /**
     * @return the diasUso
     */
    public int getDiasUso() {
        return diasUso;
    }

    /**
     * @param diasUso the diasUso to set
     */
    public void setDiasUso(int diasUso) {
        this.diasUso = diasUso;
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
     * @return the periodoHoras
     */
    public String getPeriodoHoras() {
        return periodoHoras;
    }

    /**
     * @param periodoHoras the periodoHoras to set
     */
    public void setPeriodoHoras(String periodoHoras) {
        this.periodoHoras = periodoHoras;
    }

    /**
     * @return the horarioInicial
     */
    public String getHorarioInicial() {
        return horarioInicial;
    }

    /**
     * @param horarioInicial the horarioInicial to set
     */
    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    /**
     * @return the horarioFinal
     */
    public String getHorarioFinal() {
        return horarioFinal;
    }

    /**
     * @param horarioFinal the horarioFinal to set
     */
    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    /**
     * @return the textoObservacao
     */
    public String getTextoObservacao() {
        return textoObservacao;
    }

    /**
     * @param textoObservacao the textoObservacao to set
     */
    public void setTextoObservacao(String textoObservacao) {
        this.textoObservacao = textoObservacao;
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
