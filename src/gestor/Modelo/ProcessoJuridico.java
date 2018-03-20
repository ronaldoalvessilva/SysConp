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
public class ProcessoJuridico {

    private int idProc;
    private int idFicha;
    private String nrProcesso;
    private String inquerito;
    private String regime;
    private String sentenca;
    private String tipoSentenca;
    private String situacaoPresoProcesso;
    private int anos;
    private int meses;
    private int dias;
    private Date dataInicio;
    private Date dataTermino;
    private int totalDias;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;  

    public ProcessoJuridico(int idProc, int idFicha, String nrProcesso, String inquerito, String regime, String sentenca, String tipoSentenca, String situacaoPresoProcesso, int anos, int meses, int dias, Date dataInicio, Date dataTermino, int totalDias, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idProc = idProc;
        this.idFicha = idFicha;
        this.nrProcesso = nrProcesso;
        this.inquerito = inquerito;
        this.regime = regime;
        this.sentenca = sentenca;
        this.tipoSentenca = tipoSentenca;
        this.situacaoPresoProcesso = situacaoPresoProcesso;
        this.anos = anos;
        this.meses = meses;
        this.dias = dias;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.totalDias = totalDias;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ProcessoJuridico() {
    }

    /**
     * @return the idProc
     */
    public int getIdProc() {
        return idProc;
    }

    /**
     * @param idProc the idProc to set
     */
    public void setIdProc(int idProc) {
        this.idProc = idProc;
    }

    /**
     * @return the idFicha
     */
    public int getIdFicha() {
        return idFicha;
    }

    /**
     * @param idFicha the idFicha to set
     */
    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }

    /**
     * @return the nrProcesso
     */
    public String getNrProcesso() {
        return nrProcesso;
    }

    /**
     * @param nrProcesso the nrProcesso to set
     */
    public void setNrProcesso(String nrProcesso) {
        this.nrProcesso = nrProcesso;
    }

    /**
     * @return the inquerito
     */
    public String getInquerito() {
        return inquerito;
    }

    /**
     * @param inquerito the inquerito to set
     */
    public void setInquerito(String inquerito) {
        this.inquerito = inquerito;
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
     * @return the sentenca
     */
    public String getSentenca() {
        return sentenca;
    }

    /**
     * @param sentenca the sentenca to set
     */
    public void setSentenca(String sentenca) {
        this.sentenca = sentenca;
    }

    /**
     * @return the tipoSentenca
     */
    public String getTipoSentenca() {
        return tipoSentenca;
    }

    /**
     * @param tipoSentenca the tipoSentenca to set
     */
    public void setTipoSentenca(String tipoSentenca) {
        this.tipoSentenca = tipoSentenca;
    }

    /**
     * @return the situacaoPresoProcesso
     */
    public String getSituacaoPresoProcesso() {
        return situacaoPresoProcesso;
    }

    /**
     * @param situacaoPresoProcesso the situacaoPresoProcesso to set
     */
    public void setSituacaoPresoProcesso(String situacaoPresoProcesso) {
        this.situacaoPresoProcesso = situacaoPresoProcesso;
    }

    /**
     * @return the anos
     */
    public int getAnos() {
        return anos;
    }

    /**
     * @param anos the anos to set
     */
    public void setAnos(int anos) {
        this.anos = anos;
    }

    /**
     * @return the meses
     */
    public int getMeses() {
        return meses;
    }

    /**
     * @param meses the meses to set
     */
    public void setMeses(int meses) {
        this.meses = meses;
    }

    /**
     * @return the dias
     */
    public int getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(int dias) {
        this.dias = dias;
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
     * @return the totalDias
     */
    public int getTotalDias() {
        return totalDias;
    }

    /**
     * @param totalDias the totalDias to set
     */
    public void setTotalDias(int totalDias) {
        this.totalDias = totalDias;
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
