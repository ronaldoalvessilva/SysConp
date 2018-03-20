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
public class SentencaInternos {

    private int idLanc;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private Date dataLanc;
    private String mudancaRegime;
    private Date dataEntradaCrc;
    private int idUnid;
    private String descricaoUnidade;
    private Date dataCrimeCrc;
    private Date dataPrisaoCrc;
    private Date dataCondenacaoCrc;
    private String participacao;
    private String regimeAnterior;
    private String pena;
    private String artigo1;
    private String artigo2;
    private String artigo3;
    private String paragrafo1;
    private String paragrafo2;
    private String paragrafo3;
    private String crimeHediondo;
    private Date terminoPenaCrc;

    public SentencaInternos(int idLanc, int idInternoCrc, String nomeInternoCrc, Date dataLanc, String mudancaRegime, Date dataEntradaCrc, int idUnid, String descricaoUnidade, Date dataCrimeCrc, Date dataPrisaoCrc, Date dataCondenacaoCrc, String participacao, String regimeAnterior, String pena, String artigo1, String artigo2, String artigo3, String paragrafo1, String paragrafo2, String paragrafo3, String crimeHediondo, Date terminoPenaCrc) {
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.dataLanc = dataLanc;
        this.mudancaRegime = mudancaRegime;
        this.dataEntradaCrc = dataEntradaCrc;
        this.idUnid = idUnid;
        this.descricaoUnidade = descricaoUnidade;
        this.dataCrimeCrc = dataCrimeCrc;
        this.dataPrisaoCrc = dataPrisaoCrc;
        this.dataCondenacaoCrc = dataCondenacaoCrc;
        this.participacao = participacao;
        this.regimeAnterior = regimeAnterior;
        this.pena = pena;
        this.artigo1 = artigo1;
        this.artigo2 = artigo2;
        this.artigo3 = artigo3;
        this.paragrafo1 = paragrafo1;
        this.paragrafo2 = paragrafo2;
        this.paragrafo3 = paragrafo3;
        this.crimeHediondo = crimeHediondo;
        this.terminoPenaCrc = terminoPenaCrc;
    }

    public SentencaInternos() {
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
     * @return the mudancaRegime
     */
    public String getMudancaRegime() {
        return mudancaRegime;
    }

    /**
     * @param mudancaRegime the mudancaRegime to set
     */
    public void setMudancaRegime(String mudancaRegime) {
        this.mudancaRegime = mudancaRegime;
    }

    /**
     * @return the dataEntradaCrc
     */
    public Date getDataEntradaCrc() {
        return dataEntradaCrc;
    }

    /**
     * @param dataEntradaCrc the dataEntradaCrc to set
     */
    public void setDataEntradaCrc(Date dataEntradaCrc) {
        this.dataEntradaCrc = dataEntradaCrc;
    }

    /**
     * @return the idUnid
     */
    public int getIdUnid() {
        return idUnid;
    }

    /**
     * @param idUnid the idUnid to set
     */
    public void setIdUnid(int idUnid) {
        this.idUnid = idUnid;
    }

    /**
     * @return the descricaoUnidade
     */
    public String getDescricaoUnidade() {
        return descricaoUnidade;
    }

    /**
     * @param descricaoUnidade the descricaoUnidade to set
     */
    public void setDescricaoUnidade(String descricaoUnidade) {
        this.descricaoUnidade = descricaoUnidade;
    }

    /**
     * @return the dataCrimeCrc
     */
    public Date getDataCrimeCrc() {
        return dataCrimeCrc;
    }

    /**
     * @param dataCrimeCrc the dataCrimeCrc to set
     */
    public void setDataCrimeCrc(Date dataCrimeCrc) {
        this.dataCrimeCrc = dataCrimeCrc;
    }

    /**
     * @return the dataPrisaoCrc
     */
    public Date getDataPrisaoCrc() {
        return dataPrisaoCrc;
    }

    /**
     * @param dataPrisaoCrc the dataPrisaoCrc to set
     */
    public void setDataPrisaoCrc(Date dataPrisaoCrc) {
        this.dataPrisaoCrc = dataPrisaoCrc;
    }

    /**
     * @return the dataCondenacaoCrc
     */
    public Date getDataCondenacaoCrc() {
        return dataCondenacaoCrc;
    }

    /**
     * @param dataCondenacaoCrc the dataCondenacaoCrc to set
     */
    public void setDataCondenacaoCrc(Date dataCondenacaoCrc) {
        this.dataCondenacaoCrc = dataCondenacaoCrc;
    }

    /**
     * @return the participacao
     */
    public String getParticipacao() {
        return participacao;
    }

    /**
     * @param participacao the participacao to set
     */
    public void setParticipacao(String participacao) {
        this.participacao = participacao;
    }

    /**
     * @return the regimeAnterior
     */
    public String getRegimeAnterior() {
        return regimeAnterior;
    }

    /**
     * @param regimeAnterior the regimeAnterior to set
     */
    public void setRegimeAnterior(String regimeAnterior) {
        this.regimeAnterior = regimeAnterior;
    }

    /**
     * @return the pena
     */
    public String getPena() {
        return pena;
    }

    /**
     * @param pena the pena to set
     */
    public void setPena(String pena) {
        this.pena = pena;
    }

    /**
     * @return the artigo1
     */
    public String getArtigo1() {
        return artigo1;
    }

    /**
     * @param artigo1 the artigo1 to set
     */
    public void setArtigo1(String artigo1) {
        this.artigo1 = artigo1;
    }

    /**
     * @return the artigo2
     */
    public String getArtigo2() {
        return artigo2;
    }

    /**
     * @param artigo2 the artigo2 to set
     */
    public void setArtigo2(String artigo2) {
        this.artigo2 = artigo2;
    }

    /**
     * @return the artigo3
     */
    public String getArtigo3() {
        return artigo3;
    }

    /**
     * @param artigo3 the artigo3 to set
     */
    public void setArtigo3(String artigo3) {
        this.artigo3 = artigo3;
    }

    /**
     * @return the paragrafo1
     */
    public String getParagrafo1() {
        return paragrafo1;
    }

    /**
     * @param paragrafo1 the paragrafo1 to set
     */
    public void setParagrafo1(String paragrafo1) {
        this.paragrafo1 = paragrafo1;
    }

    /**
     * @return the paragrafo2
     */
    public String getParagrafo2() {
        return paragrafo2;
    }

    /**
     * @param paragrafo2 the paragrafo2 to set
     */
    public void setParagrafo2(String paragrafo2) {
        this.paragrafo2 = paragrafo2;
    }

    /**
     * @return the paragrafo3
     */
    public String getParagrafo3() {
        return paragrafo3;
    }

    /**
     * @param paragrafo3 the paragrafo3 to set
     */
    public void setParagrafo3(String paragrafo3) {
        this.paragrafo3 = paragrafo3;
    }

    /**
     * @return the crimeHediondo
     */
    public String getCrimeHediondo() {
        return crimeHediondo;
    }

    /**
     * @param crimeHediondo the crimeHediondo to set
     */
    public void setCrimeHediondo(String crimeHediondo) {
        this.crimeHediondo = crimeHediondo;
    }

    /**
     * @return the terminoPenaCrc
     */
    public Date getTerminoPenaCrc() {
        return terminoPenaCrc;
    }

    /**
     * @param terminoPenaCrc the terminoPenaCrc to set
     */
    public void setTerminoPenaCrc(Date terminoPenaCrc) {
        this.terminoPenaCrc = terminoPenaCrc;
    }
}
