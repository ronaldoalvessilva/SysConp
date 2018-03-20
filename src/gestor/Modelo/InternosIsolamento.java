/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author Ronaldo
 */
public class InternosIsolamento {

    private int idIsola;
    private int idInternoCrc;
    private String nomeInterno;
    private int idLancRet;
    private int idLanc;
    private String confirmaUtilizacao;
    private String observacaoIsolamento;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public InternosIsolamento(int idIsola, int idInternoCrc, String nomeInterno, int idLancRet, int idLanc, String confirmaUtilizacao, String observacaoIsolamento, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idIsola = idIsola;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.idLancRet = idLancRet;
        this.idLanc = idLanc;
        this.confirmaUtilizacao = confirmaUtilizacao;
        this.observacaoIsolamento = observacaoIsolamento;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public InternosIsolamento() {
    }

    /**
     * @return the idIsola
     */
    public int getIdIsola() {
        return idIsola;
    }

    /**
     * @param idIsola the idIsola to set
     */
    public void setIdIsola(int idIsola) {
        this.idIsola = idIsola;
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
     * @return the idLancRet
     */
    public int getIdLancRet() {
        return idLancRet;
    }

    /**
     * @param idLancRet the idLancRet to set
     */
    public void setIdLancRet(int idLancRet) {
        this.idLancRet = idLancRet;
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
     * @return the confirmaUtilizacao
     */
    public String getConfirmaUtilizacao() {
        return confirmaUtilizacao;
    }

    /**
     * @param confirmaUtilizacao the confirmaUtilizacao to set
     */
    public void setConfirmaUtilizacao(String confirmaUtilizacao) {
        this.confirmaUtilizacao = confirmaUtilizacao;
    }

    /**
     * @return the observacaoIsolamento
     */
    public String getObservacaoIsolamento() {
        return observacaoIsolamento;
    }

    /**
     * @param observacaoIsolamento the observacaoIsolamento to set
     */
    public void setObservacaoIsolamento(String observacaoIsolamento) {
        this.observacaoIsolamento = observacaoIsolamento;
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
