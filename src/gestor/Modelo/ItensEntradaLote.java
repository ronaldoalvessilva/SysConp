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
public class ItensEntradaLote {

    private int IdItem;
    private int IdInternoCrc;
    private int IdEntrada;
    private int qtdEntrada;
    private String nomeInterno;
    private String nomeUnidade;
    private Date DataEntrada;
    private Date DataCrime;
    private Date DataPrisao;
    private Date DataCondenacao;
    private String Participacao;
    private String Regime;
    private String Pena;
    private String Artigo1;
    private String Artigo2;
    private String Artigo3;
    private String Paragrafo1;
    private String Paragrafo2;
    private String Paragrafo3;
    private String crimeEdiondo;
    private Date terminoPena;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;   

    public ItensEntradaLote(int IdItem, int IdInternoCrc, int IdEntrada, int qtdEntrada, String nomeInterno, String nomeUnidade, Date DataEntrada, Date DataCrime, Date DataPrisao, Date DataCondenacao, String Participacao, String Regime, String Pena, String Artigo1, String Artigo2, String Artigo3, String Paragrafo1, String Paragrafo2, String Paragrafo3, String crimeEdiondo, Date terminoPena, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp) {
        this.IdItem = IdItem;
        this.IdInternoCrc = IdInternoCrc;
        this.IdEntrada = IdEntrada;
        this.qtdEntrada = qtdEntrada;
        this.nomeInterno = nomeInterno;
        this.nomeUnidade = nomeUnidade;
        this.DataEntrada = DataEntrada;
        this.DataCrime = DataCrime;
        this.DataPrisao = DataPrisao;
        this.DataCondenacao = DataCondenacao;
        this.Participacao = Participacao;
        this.Regime = Regime;
        this.Pena = Pena;
        this.Artigo1 = Artigo1;
        this.Artigo2 = Artigo2;
        this.Artigo3 = Artigo3;
        this.Paragrafo1 = Paragrafo1;
        this.Paragrafo2 = Paragrafo2;
        this.Paragrafo3 = Paragrafo3;
        this.crimeEdiondo = crimeEdiondo;
        this.terminoPena = terminoPena;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
    }

    public ItensEntradaLote() {
    }

    /**
     * @return the IdItem
     */
    public int getIdItem() {
        return IdItem;
    }

    /**
     * @param IdItem the IdItem to set
     */
    public void setIdItem(int IdItem) {
        this.IdItem = IdItem;
    }

    /**
     * @return the IdInternoCrc
     */
    public int getIdInternoCrc() {
        return IdInternoCrc;
    }

    /**
     * @param IdInternoCrc the IdInternoCrc to set
     */
    public void setIdInternoCrc(int IdInternoCrc) {
        this.IdInternoCrc = IdInternoCrc;
    }

    /**
     * @return the IdEntrada
     */
    public int getIdEntrada() {
        return IdEntrada;
    }

    /**
     * @param IdEntrada the IdEntrada to set
     */
    public void setIdEntrada(int IdEntrada) {
        this.IdEntrada = IdEntrada;
    }

    /**
     * @return the qtdEntrada
     */
    public int getQtdEntrada() {
        return qtdEntrada;
    }

    /**
     * @param qtdEntrada the qtdEntrada to set
     */
    public void setQtdEntrada(int qtdEntrada) {
        this.qtdEntrada = qtdEntrada;
    }

    /**
     * @return the nomeInterno
     */
    public String getNomeInterno() {
        return nomeInterno;
    }

    /**
     * @param nomeInterno the nomeInterno to set
     */
    public void setNomeInterno(String nomeInterno) {
        this.nomeInterno = nomeInterno;
    }

    /**
     * @return the nomeUnidade
     */
    public String getNomeUnidade() {
        return nomeUnidade;
    }

    /**
     * @param nomeUnidade the nomeUnidade to set
     */
    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    /**
     * @return the DataEntrada
     */
    public Date getDataEntrada() {
        return DataEntrada;
    }

    /**
     * @param DataEntrada the DataEntrada to set
     */
    public void setDataEntrada(Date DataEntrada) {
        this.DataEntrada = DataEntrada;
    }

    /**
     * @return the DataCrime
     */
    public Date getDataCrime() {
        return DataCrime;
    }

    /**
     * @param DataCrime the DataCrime to set
     */
    public void setDataCrime(Date DataCrime) {
        this.DataCrime = DataCrime;
    }

    /**
     * @return the DataPrisao
     */
    public Date getDataPrisao() {
        return DataPrisao;
    }

    /**
     * @param DataPrisao the DataPrisao to set
     */
    public void setDataPrisao(Date DataPrisao) {
        this.DataPrisao = DataPrisao;
    }

    /**
     * @return the DataCondenacao
     */
    public Date getDataCondenacao() {
        return DataCondenacao;
    }

    /**
     * @param DataCondenacao the DataCondenacao to set
     */
    public void setDataCondenacao(Date DataCondenacao) {
        this.DataCondenacao = DataCondenacao;
    }

    /**
     * @return the Participacao
     */
    public String getParticipacao() {
        return Participacao;
    }

    /**
     * @param Participacao the Participacao to set
     */
    public void setParticipacao(String Participacao) {
        this.Participacao = Participacao;
    }

    /**
     * @return the Regime
     */
    public String getRegime() {
        return Regime;
    }

    /**
     * @param Regime the Regime to set
     */
    public void setRegime(String Regime) {
        this.Regime = Regime;
    }

    /**
     * @return the Pena
     */
    public String getPena() {
        return Pena;
    }

    /**
     * @param Pena the Pena to set
     */
    public void setPena(String Pena) {
        this.Pena = Pena;
    }

    /**
     * @return the Artigo1
     */
    public String getArtigo1() {
        return Artigo1;
    }

    /**
     * @param Artigo1 the Artigo1 to set
     */
    public void setArtigo1(String Artigo1) {
        this.Artigo1 = Artigo1;
    }

    /**
     * @return the Artigo2
     */
    public String getArtigo2() {
        return Artigo2;
    }

    /**
     * @param Artigo2 the Artigo2 to set
     */
    public void setArtigo2(String Artigo2) {
        this.Artigo2 = Artigo2;
    }

    /**
     * @return the Artigo3
     */
    public String getArtigo3() {
        return Artigo3;
    }

    /**
     * @param Artigo3 the Artigo3 to set
     */
    public void setArtigo3(String Artigo3) {
        this.Artigo3 = Artigo3;
    }

    /**
     * @return the Paragrafo1
     */
    public String getParagrafo1() {
        return Paragrafo1;
    }

    /**
     * @param Paragrafo1 the Paragrafo1 to set
     */
    public void setParagrafo1(String Paragrafo1) {
        this.Paragrafo1 = Paragrafo1;
    }

    /**
     * @return the Paragrafo2
     */
    public String getParagrafo2() {
        return Paragrafo2;
    }

    /**
     * @param Paragrafo2 the Paragrafo2 to set
     */
    public void setParagrafo2(String Paragrafo2) {
        this.Paragrafo2 = Paragrafo2;
    }

    /**
     * @return the Paragrafo3
     */
    public String getParagrafo3() {
        return Paragrafo3;
    }

    /**
     * @param Paragrafo3 the Paragrafo3 to set
     */
    public void setParagrafo3(String Paragrafo3) {
        this.Paragrafo3 = Paragrafo3;
    }

    /**
     * @return the crimeEdiondo
     */
    public String getCrimeEdiondo() {
        return crimeEdiondo;
    }

    /**
     * @param crimeEdiondo the crimeEdiondo to set
     */
    public void setCrimeEdiondo(String crimeEdiondo) {
        this.crimeEdiondo = crimeEdiondo;
    }

    /**
     * @return the terminoPena
     */
    public Date getTerminoPena() {
        return terminoPena;
    }

    /**
     * @param terminoPena the terminoPena to set
     */
    public void setTerminoPena(Date terminoPena) {
        this.terminoPena = terminoPena;
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
     * @return the horaInsert
     */
    public String getHoraInsert() {
        return horaInsert;
    }

    /**
     * @param horaInsert the horaInsert to set
     */
    public void setHoraInsert(String horaInsert) {
        this.horaInsert = horaInsert;
    }

    /**
     * @return the horaUp
     */
    public String getHoraUp() {
        return horaUp;
    }

    /**
     * @param horaUp the horaUp to set
     */
    public void setHoraUp(String horaUp) {
        this.horaUp = horaUp;
    }
}
