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
public class TriagemOcupacional {

    private int idTraigem;
    private String statusLanc;
    private Date dataLanc;
    private int idInternoCrc;
    private String nomeInternoTriagem;
    private String jaTrabalho;
    private String ondeTrabalhou;
    private String interesseUnidade;
    private String qualTipoAtividade;
    private String visitasFinaisSemana;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public TriagemOcupacional(int idTraigem, String statusLanc, Date dataLanc, int idInternoCrc, String nomeInternoTriagem, String jaTrabalho, String ondeTrabalhou, String interesseUnidade, String qualTipoAtividade, String visitasFinaisSemana, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idTraigem = idTraigem;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoTriagem = nomeInternoTriagem;
        this.jaTrabalho = jaTrabalho;
        this.ondeTrabalhou = ondeTrabalhou;
        this.interesseUnidade = interesseUnidade;
        this.qualTipoAtividade = qualTipoAtividade;
        this.visitasFinaisSemana = visitasFinaisSemana;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public TriagemOcupacional() {
    }

    /**
     * @return the idTraigem
     */
    public int getIdTraigem() {
        return idTraigem;
    }

    /**
     * @param idTraigem the idTraigem to set
     */
    public void setIdTraigem(int idTraigem) {
        this.idTraigem = idTraigem;
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
     * @return the nomeInternoTriagem
     */
    public String getNomeInternoTriagem() {
        return nomeInternoTriagem;
    }

    /**
     * @param nomeInternoTriagem the nomeInternoTriagem to set
     */
    public void setNomeInternoTriagem(String nomeInternoTriagem) {
        this.nomeInternoTriagem = nomeInternoTriagem;
    }

    /**
     * @return the jaTrabalho
     */
    public String getJaTrabalho() {
        return jaTrabalho;
    }

    /**
     * @param jaTrabalho the jaTrabalho to set
     */
    public void setJaTrabalho(String jaTrabalho) {
        this.jaTrabalho = jaTrabalho;
    }

    /**
     * @return the ondeTrabalhou
     */
    public String getOndeTrabalhou() {
        return ondeTrabalhou;
    }

    /**
     * @param ondeTrabalhou the ondeTrabalhou to set
     */
    public void setOndeTrabalhou(String ondeTrabalhou) {
        this.ondeTrabalhou = ondeTrabalhou;
    }

    /**
     * @return the interesseUnidade
     */
    public String getInteresseUnidade() {
        return interesseUnidade;
    }

    /**
     * @param interesseUnidade the interesseUnidade to set
     */
    public void setInteresseUnidade(String interesseUnidade) {
        this.interesseUnidade = interesseUnidade;
    }

    /**
     * @return the qualTipoAtividade
     */
    public String getQualTipoAtividade() {
        return qualTipoAtividade;
    }

    /**
     * @param qualTipoAtividade the qualTipoAtividade to set
     */
    public void setQualTipoAtividade(String qualTipoAtividade) {
        this.qualTipoAtividade = qualTipoAtividade;
    }

    /**
     * @return the visitasFinaisSemana
     */
    public String getVisitasFinaisSemana() {
        return visitasFinaisSemana;
    }

    /**
     * @param visitasFinaisSemana the visitasFinaisSemana to set
     */
    public void setVisitasFinaisSemana(String visitasFinaisSemana) {
        this.visitasFinaisSemana = visitasFinaisSemana;
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
