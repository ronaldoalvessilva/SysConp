/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author user
 */
public class AvaliacaoPsicologica {

    private int idLanc;
    private String statusLanc;
    private Date dataLanc;
    private int idInternoCrc;
    private String nomeInterno;
    private String infanciaPergunta1;
    private String infanciaPergunta2;
    private String infanciaPergunta3;
    private String infanciaPergunta4;
    private String escolaPergunta1;
    private String escolaPergunta2;
    private String vidaLaborativa;
    private String redeSocial;
    private String substanciaPsicoativa;
    private String relacaoAfetiva;
    private String pespectiva;
    private String historicoCriminal;
    private String historicoPrisional;
    private String dadosCognitivos;
    private String indicadorPsicopatologico;
    private String deptoPsicologico;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;         

    public AvaliacaoPsicologica(int idLanc, String statusLanc, Date dataLanc, int idInternoCrc, String nomeInterno, String infanciaPergunta1, String infanciaPergunta2, String infanciaPergunta3, String infanciaPergunta4, String escolaPergunta1, String escolaPergunta2, String vidaLaborativa, String redeSocial, String substanciaPsicoativa, String relacaoAfetiva, String pespectiva, String historicoCriminal, String historicoPrisional, String dadosCognitivos, String indicadorPsicopatologico, String deptoPsicologico, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento) {
        this.idLanc = idLanc;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.infanciaPergunta1 = infanciaPergunta1;
        this.infanciaPergunta2 = infanciaPergunta2;
        this.infanciaPergunta3 = infanciaPergunta3;
        this.infanciaPergunta4 = infanciaPergunta4;
        this.escolaPergunta1 = escolaPergunta1;
        this.escolaPergunta2 = escolaPergunta2;
        this.vidaLaborativa = vidaLaborativa;
        this.redeSocial = redeSocial;
        this.substanciaPsicoativa = substanciaPsicoativa;
        this.relacaoAfetiva = relacaoAfetiva;
        this.pespectiva = pespectiva;
        this.historicoCriminal = historicoCriminal;
        this.historicoPrisional = historicoPrisional;
        this.dadosCognitivos = dadosCognitivos;
        this.indicadorPsicopatologico = indicadorPsicopatologico;
        this.deptoPsicologico = deptoPsicologico;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
    }

    public AvaliacaoPsicologica() {
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
     * @return the infanciaPergunta1
     */
    public String getInfanciaPergunta1() {
        return infanciaPergunta1;
    }

    /**
     * @param infanciaPergunta1 the infanciaPergunta1 to set
     */
    public void setInfanciaPergunta1(String infanciaPergunta1) {
        this.infanciaPergunta1 = infanciaPergunta1;
    }

    /**
     * @return the infanciaPergunta2
     */
    public String getInfanciaPergunta2() {
        return infanciaPergunta2;
    }

    /**
     * @param infanciaPergunta2 the infanciaPergunta2 to set
     */
    public void setInfanciaPergunta2(String infanciaPergunta2) {
        this.infanciaPergunta2 = infanciaPergunta2;
    }

    /**
     * @return the infanciaPergunta3
     */
    public String getInfanciaPergunta3() {
        return infanciaPergunta3;
    }

    /**
     * @param infanciaPergunta3 the infanciaPergunta3 to set
     */
    public void setInfanciaPergunta3(String infanciaPergunta3) {
        this.infanciaPergunta3 = infanciaPergunta3;
    }

    /**
     * @return the infanciaPergunta4
     */
    public String getInfanciaPergunta4() {
        return infanciaPergunta4;
    }

    /**
     * @param infanciaPergunta4 the infanciaPergunta4 to set
     */
    public void setInfanciaPergunta4(String infanciaPergunta4) {
        this.infanciaPergunta4 = infanciaPergunta4;
    }

    /**
     * @return the escolaPergunta1
     */
    public String getEscolaPergunta1() {
        return escolaPergunta1;
    }

    /**
     * @param escolaPergunta1 the escolaPergunta1 to set
     */
    public void setEscolaPergunta1(String escolaPergunta1) {
        this.escolaPergunta1 = escolaPergunta1;
    }

    /**
     * @return the escolaPergunta2
     */
    public String getEscolaPergunta2() {
        return escolaPergunta2;
    }

    /**
     * @param escolaPergunta2 the escolaPergunta2 to set
     */
    public void setEscolaPergunta2(String escolaPergunta2) {
        this.escolaPergunta2 = escolaPergunta2;
    }

    /**
     * @return the vidaLaborativa
     */
    public String getVidaLaborativa() {
        return vidaLaborativa;
    }

    /**
     * @param vidaLaborativa the vidaLaborativa to set
     */
    public void setVidaLaborativa(String vidaLaborativa) {
        this.vidaLaborativa = vidaLaborativa;
    }

    /**
     * @return the redeSocial
     */
    public String getRedeSocial() {
        return redeSocial;
    }

    /**
     * @param redeSocial the redeSocial to set
     */
    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }

    /**
     * @return the substanciaPsicoativa
     */
    public String getSubstanciaPsicoativa() {
        return substanciaPsicoativa;
    }

    /**
     * @param substanciaPsicoativa the substanciaPsicoativa to set
     */
    public void setSubstanciaPsicoativa(String substanciaPsicoativa) {
        this.substanciaPsicoativa = substanciaPsicoativa;
    }

    /**
     * @return the relacaoAfetiva
     */
    public String getRelacaoAfetiva() {
        return relacaoAfetiva;
    }

    /**
     * @param relacaoAfetiva the relacaoAfetiva to set
     */
    public void setRelacaoAfetiva(String relacaoAfetiva) {
        this.relacaoAfetiva = relacaoAfetiva;
    }

    /**
     * @return the pespectiva
     */
    public String getPespectiva() {
        return pespectiva;
    }

    /**
     * @param pespectiva the pespectiva to set
     */
    public void setPespectiva(String pespectiva) {
        this.pespectiva = pespectiva;
    }

    /**
     * @return the historicoCriminal
     */
    public String getHistoricoCriminal() {
        return historicoCriminal;
    }

    /**
     * @param historicoCriminal the historicoCriminal to set
     */
    public void setHistoricoCriminal(String historicoCriminal) {
        this.historicoCriminal = historicoCriminal;
    }

    /**
     * @return the historicoPrisional
     */
    public String getHistoricoPrisional() {
        return historicoPrisional;
    }

    /**
     * @param historicoPrisional the historicoPrisional to set
     */
    public void setHistoricoPrisional(String historicoPrisional) {
        this.historicoPrisional = historicoPrisional;
    }

    /**
     * @return the dadosCognitivos
     */
    public String getDadosCognitivos() {
        return dadosCognitivos;
    }

    /**
     * @param dadosCognitivos the dadosCognitivos to set
     */
    public void setDadosCognitivos(String dadosCognitivos) {
        this.dadosCognitivos = dadosCognitivos;
    }

    /**
     * @return the indicadorPsicopatologico
     */
    public String getIndicadorPsicopatologico() {
        return indicadorPsicopatologico;
    }

    /**
     * @param indicadorPsicopatologico the indicadorPsicopatologico to set
     */
    public void setIndicadorPsicopatologico(String indicadorPsicopatologico) {
        this.indicadorPsicopatologico = indicadorPsicopatologico;
    }

    /**
     * @return the deptoPsicologico
     */
    public String getDeptoPsicologico() {
        return deptoPsicologico;
    }

    /**
     * @param deptoPsicologico the deptoPsicologico to set
     */
    public void setDeptoPsicologico(String deptoPsicologico) {
        this.deptoPsicologico = deptoPsicologico;
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
}
