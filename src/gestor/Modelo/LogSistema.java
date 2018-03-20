/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronaldo
 */
public class LogSistema {

    private int idLog;
    private String dataMov;
    private String horarioMov;
    private String nomeModuloTela;
    private int idLancMov;
    private String nomeUsuarioLogado;
    private String statusMov;              

    public LogSistema(int idLog, String dataMov, String horarioMov, String nomeModuloTela, int idLancMov, String nomeUsuarioLogado, String statusMov) {
        this.idLog = idLog;
        this.dataMov = dataMov;
        this.horarioMov = horarioMov;
        this.nomeModuloTela = nomeModuloTela;
        this.idLancMov = idLancMov;
        this.nomeUsuarioLogado = nomeUsuarioLogado;
        this.statusMov = statusMov;
    }

    public LogSistema() {
    }

    /**
     * @return the idLog
     */
    public int getIdLog() {
        return idLog;
    }

    /**
     * @param idLog the idLog to set
     */
    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    /**
     * @return the dataMov
     */
    public String getDataMov() {
        return dataMov;
    }

    /**
     * @param dataMov the dataMov to set
     */
    public void setDataMov(String dataMov) {
        this.dataMov = dataMov;
    }

    /**
     * @return the horarioMov
     */
    public String getHorarioMov() {
        return horarioMov;
    }

    /**
     * @param horarioMov the horarioMov to set
     */
    public void setHorarioMov(String horarioMov) {
        this.horarioMov = horarioMov;
    }

    /**
     * @return the nomeModuloTela
     */
    public String getNomeModuloTela() {
        return nomeModuloTela;
    }

    /**
     * @param nomeModuloTela the nomeModuloTela to set
     */
    public void setNomeModuloTela(String nomeModuloTela) {
        this.nomeModuloTela = nomeModuloTela;
    }

    /**
     * @return the idLancMov
     */
    public int getIdLancMov() {
        return idLancMov;
    }

    /**
     * @param idLancMov the idLancMov to set
     */
    public void setIdLancMov(int idLancMov) {
        this.idLancMov = idLancMov;
    }

    /**
     * @return the nomeUsuarioLogado
     */
    public String getNomeUsuarioLogado() {
        return nomeUsuarioLogado;
    }

    /**
     * @param nomeUsuarioLogado the nomeUsuarioLogado to set
     */
    public void setNomeUsuarioLogado(String nomeUsuarioLogado) {
        this.nomeUsuarioLogado = nomeUsuarioLogado;
    }

    /**
     * @return the statusMov
     */
    public String getStatusMov() {
        return statusMov;
    }

    /**
     * @param statusMov the statusMov to set
     */
    public void setStatusMov(String statusMov) {
        this.statusMov = statusMov;
    }
}
