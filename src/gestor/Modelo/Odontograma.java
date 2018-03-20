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
public class Odontograma {

    private int idOdonto;
    private int idLanc;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int idProcOdonto;
    private String descricaoProcedimento;
    private int numeroDente;
    private Date dataOdontograma;
    private String facesDente;
    private int vermelho;
    private int verde;
    private int azul;
    private String planoTratamento;
    private String corDente;
    private String parcialTotal;

    public Odontograma() {
    }

    public Odontograma(int idOdonto, int idLanc, int idInternoCrc, String nomeInternoCrc, int idProcOdonto, String descricaoProcedimento, int numeroDente, Date dataOdontograma, String facesDente, int vermelho, int verde, int azul, String planoTratamento, String corDente, String parcialTotal) {
        this.idOdonto = idOdonto;
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idProcOdonto = idProcOdonto;
        this.descricaoProcedimento = descricaoProcedimento;
        this.numeroDente = numeroDente;
        this.dataOdontograma = dataOdontograma;
        this.facesDente = facesDente;
        this.vermelho = vermelho;
        this.verde = verde;
        this.azul = azul;
        this.planoTratamento = planoTratamento;
        this.corDente = corDente;
        this.parcialTotal = parcialTotal;
    }

    /**
     * @return the idOdonto
     */
    public int getIdOdonto() {
        return idOdonto;
    }

    /**
     * @param idOdonto the idOdonto to set
     */
    public void setIdOdonto(int idOdonto) {
        this.idOdonto = idOdonto;
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
     * @return the idProcOdonto
     */
    public int getIdProcOdonto() {
        return idProcOdonto;
    }

    /**
     * @param idProcOdonto the idProcOdonto to set
     */
    public void setIdProcOdonto(int idProcOdonto) {
        this.idProcOdonto = idProcOdonto;
    }

    /**
     * @return the descricaoProcedimento
     */
    public String getDescricaoProcedimento() {
        return descricaoProcedimento;
    }

    /**
     * @param descricaoProcedimento the descricaoProcedimento to set
     */
    public void setDescricaoProcedimento(String descricaoProcedimento) {
        this.descricaoProcedimento = descricaoProcedimento;
    }

    /**
     * @return the numeroDente
     */
    public int getNumeroDente() {
        return numeroDente;
    }

    /**
     * @param numeroDente the numeroDente to set
     */
    public void setNumeroDente(int numeroDente) {
        this.numeroDente = numeroDente;
    }

    /**
     * @return the dataOdontograma
     */
    public Date getDataOdontograma() {
        return dataOdontograma;
    }

    /**
     * @param dataOdontograma the dataOdontograma to set
     */
    public void setDataOdontograma(Date dataOdontograma) {
        this.dataOdontograma = dataOdontograma;
    }

    /**
     * @return the facesDente
     */
    public String getFacesDente() {
        return facesDente;
    }

    /**
     * @param facesDente the facesDente to set
     */
    public void setFacesDente(String facesDente) {
        this.facesDente = facesDente;
    }

    /**
     * @return the vermelho
     */
    public int getVermelho() {
        return vermelho;
    }

    /**
     * @param vermelho the vermelho to set
     */
    public void setVermelho(int vermelho) {
        this.vermelho = vermelho;
    }

    /**
     * @return the verde
     */
    public int getVerde() {
        return verde;
    }

    /**
     * @param verde the verde to set
     */
    public void setVerde(int verde) {
        this.verde = verde;
    }

    /**
     * @return the azul
     */
    public int getAzul() {
        return azul;
    }

    /**
     * @param azul the azul to set
     */
    public void setAzul(int azul) {
        this.azul = azul;
    }

    /**
     * @return the planoTratamento
     */
    public String getPlanoTratamento() {
        return planoTratamento;
    }

    /**
     * @param planoTratamento the planoTratamento to set
     */
    public void setPlanoTratamento(String planoTratamento) {
        this.planoTratamento = planoTratamento;
    }

    /**
     * @return the corDente
     */
    public String getCorDente() {
        return corDente;
    }

    /**
     * @param corDente the corDente to set
     */
    public void setCorDente(String corDente) {
        this.corDente = corDente;
    }

    /**
     * @return the parcialTotal
     */
    public String getParcialTotal() {
        return parcialTotal;
    }

    /**
     * @param parcialTotal the parcialTotal to set
     */
    public void setParcialTotal(String parcialTotal) {
        this.parcialTotal = parcialTotal;
    }
}
