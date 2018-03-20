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
public class ItensRegressaoRegime {

    private int idItem;
    private int idLanc;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private Date dataRegressao;
    private String regime;
    private Date dataCondenacao;
    private String pena;
    private Date terminoPena;
    private String crimeHediondo;
    private String juizo;
    private String artigo1;
    private String artigo2;
    private String artigo3;
    private String paragrafo1;
    private String paragrafo2;
    private String paragrafo3;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;

    public ItensRegressaoRegime(int idItem, int idLanc, int idInternoCrc, String nomeInternoCrc, Date dataRegressao, String regime, Date dataCondenacao, String pena, Date terminoPena, String crimeHediondo, String juizo, String artigo1, String artigo2, String artigo3, String paragrafo1, String paragrafo2, String paragrafo3, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.dataRegressao = dataRegressao;
        this.regime = regime;
        this.dataCondenacao = dataCondenacao;
        this.pena = pena;
        this.terminoPena = terminoPena;
        this.crimeHediondo = crimeHediondo;
        this.juizo = juizo;
        this.artigo1 = artigo1;
        this.artigo2 = artigo2;
        this.artigo3 = artigo3;
        this.paragrafo1 = paragrafo1;
        this.paragrafo2 = paragrafo2;
        this.paragrafo3 = paragrafo3;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensRegressaoRegime() {
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
     * @return the dataRegressao
     */
    public Date getDataRegressao() {
        return dataRegressao;
    }

    /**
     * @param dataRegressao the dataRegressao to set
     */
    public void setDataRegressao(Date dataRegressao) {
        this.dataRegressao = dataRegressao;
    }

    /**
     * @return the regime
     */
    public String getRegime() {
        return regime;
    }

    /**
     * @param regime the regime to set
     */
    public void setRegime(String regime) {
        this.regime = regime;
    }

    /**
     * @return the dataConedencao
     */
    public Date getDataCondenacao() {
        return dataCondenacao;
    }

    /**
     * @param dataConedencao the dataConedencao to set
     */
    public void setDataCondenacao(Date dataConedencao) {
        this.dataCondenacao = dataConedencao;
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
     * @return the juizo
     */
    public String getJuizo() {
        return juizo;
    }

    /**
     * @param juizo the juizo to set
     */
    public void setJuizo(String juizo) {
        this.juizo = juizo;
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
     * @return the usuarioDelete
     */
    public String getUsuarioDelete() {
        return usuarioDelete;
    }

    /**
     * @param usuarioDelete the usuarioDelete to set
     */
    public void setUsuarioDelete(String usuarioDelete) {
        this.usuarioDelete = usuarioDelete;
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
     * @return the dataDelete
     */
    public String getDataDelete() {
        return dataDelete;
    }

    /**
     * @param dataDelete the dataDelete to set
     */
    public void setDataDelete(String dataDelete) {
        this.dataDelete = dataDelete;
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
