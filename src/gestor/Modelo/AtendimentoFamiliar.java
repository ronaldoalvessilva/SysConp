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
public class AtendimentoFamiliar {

    private int IdAtendf;
    private String statusAtend;
    private int IdVisita;
    private int IdInternoCrc;
    private String nomeVisita;
    private String nomeInterno;
    private Date DataAtendf;
    private String Pergunta1Atendf;
    private String Pergunta2Atendf;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;
    //
    private String companheiroUnidade;
    private String visitaInternoUnidade;
    private String creasCreas;
    private String bolsaFamilia;
    //       

    public AtendimentoFamiliar(int IdAtendf, String statusAtend, int IdVisita, int IdInternoCrc, String nomeVisita, String nomeInterno, Date DataAtendf, String Pergunta1Atendf, String Pergunta2Atendf, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento, String companheiroUnidade, String visitaInternoUnidade, String creasCreas, String bolsaFamilia) {
        this.IdAtendf = IdAtendf;
        this.statusAtend = statusAtend;
        this.IdVisita = IdVisita;
        this.IdInternoCrc = IdInternoCrc;
        this.nomeVisita = nomeVisita;
        this.nomeInterno = nomeInterno;
        this.DataAtendf = DataAtendf;
        this.Pergunta1Atendf = Pergunta1Atendf;
        this.Pergunta2Atendf = Pergunta2Atendf;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.companheiroUnidade = companheiroUnidade;
        this.visitaInternoUnidade = visitaInternoUnidade;
        this.creasCreas = creasCreas;
        this.bolsaFamilia = bolsaFamilia;
    }

    public AtendimentoFamiliar() {
    }

    /**
     * @return the IdAtendf
     */
    public int getIdAtendf() {
        return IdAtendf;
    }

    /**
     * @param IdAtendf the IdAtendf to set
     */
    public void setIdAtendf(int IdAtendf) {
        this.IdAtendf = IdAtendf;
    }

    /**
     * @return the statusAtend
     */
    public String getStatusAtend() {
        return statusAtend;
    }

    /**
     * @param statusAtend the statusAtend to set
     */
    public void setStatusAtend(String statusAtend) {
        this.statusAtend = statusAtend;
    }

    /**
     * @return the IdVisita
     */
    public int getIdVisita() {
        return IdVisita;
    }

    /**
     * @param IdVisita the IdVisita to set
     */
    public void setIdVisita(int IdVisita) {
        this.IdVisita = IdVisita;
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
     * @return the nomeVisita
     */
    public String getNomeVisita() {
        return nomeVisita;
    }

    /**
     * @param nomeVisita the nomeVisita to set
     */
    public void setNomeVisita(String nomeVisita) {
        this.nomeVisita = nomeVisita;
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
     * @return the DataAtendf
     */
    public Date getDataAtendf() {
        return DataAtendf;
    }

    /**
     * @param DataAtendf the DataAtendf to set
     */
    public void setDataAtendf(Date DataAtendf) {
        this.DataAtendf = DataAtendf;
    }

    /**
     * @return the Pergunta1Atendf
     */
    public String getPergunta1Atendf() {
        return Pergunta1Atendf;
    }

    /**
     * @param Pergunta1Atendf the Pergunta1Atendf to set
     */
    public void setPergunta1Atendf(String Pergunta1Atendf) {
        this.Pergunta1Atendf = Pergunta1Atendf;
    }

    /**
     * @return the Pergunta2Atendf
     */
    public String getPergunta2Atendf() {
        return Pergunta2Atendf;
    }

    /**
     * @param Pergunta2Atendf the Pergunta2Atendf to set
     */
    public void setPergunta2Atendf(String Pergunta2Atendf) {
        this.Pergunta2Atendf = Pergunta2Atendf;
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

    /**
     * @return the dataFechamento
     */
    public String getDataFechamento() {
        return dataFechamento;
    }

    /**
     * @param dataFechamento the dataFechamento to set
     */
    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    /**
     * @return the horaFechamento
     */
    public String getHoraFechamento() {
        return horaFechamento;
    }

    /**
     * @param horaFechamento the horaFechamento to set
     */
    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    /**
     * @return the companheiroUnidade
     */
    public String getCompanheiroUnidade() {
        return companheiroUnidade;
    }

    /**
     * @param companheiroUnidade the companheiroUnidade to set
     */
    public void setCompanheiroUnidade(String companheiroUnidade) {
        this.companheiroUnidade = companheiroUnidade;
    }

    /**
     * @return the visitaInternoUnidade
     */
    public String getVisitaInternoUnidade() {
        return visitaInternoUnidade;
    }

    /**
     * @param visitaInternoUnidade the visitaInternoUnidade to set
     */
    public void setVisitaInternoUnidade(String visitaInternoUnidade) {
        this.visitaInternoUnidade = visitaInternoUnidade;
    }

    /**
     * @return the creasCreas
     */
    public String getCreasCreas() {
        return creasCreas;
    }

    /**
     * @param creasCreas the creasCreas to set
     */
    public void setCreasCreas(String creasCreas) {
        this.creasCreas = creasCreas;
    }

    /**
     * @return the bolsaFamilia
     */
    public String getBolsaFamilia() {
        return bolsaFamilia;
    }

    /**
     * @param bolsaFamilia the bolsaFamilia to set
     */
    public void setBolsaFamilia(String bolsaFamilia) {
        this.bolsaFamilia = bolsaFamilia;
    }
}
