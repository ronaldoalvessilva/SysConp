/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronal
 */
public class LiberadoresInternoColaboradores {

    private int idLibe;
    private String statusLibera;
    private Date dataRegistro;
    private int idPav;
    private String descricaoPavilhao;
    private String observacao;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;
    private int idItemLibPSP;
    private String statusFunc;
    private int idFunc;
    private String nomeColaborador;

    public LiberadoresInternoColaboradores() {
    }

    public LiberadoresInternoColaboradores(int idLibe, String statusLibera, Date dataRegistro, int idPav, String descricaoPavilhao, String observacao, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp, int idItemLibPSP, String statusFunc, int idFunc, String nomeColaborador) {
        this.idLibe = idLibe;
        this.statusLibera = statusLibera;
        this.dataRegistro = dataRegistro;
        this.idPav = idPav;
        this.descricaoPavilhao = descricaoPavilhao;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
        this.idItemLibPSP = idItemLibPSP;
        this.statusFunc = statusFunc;
        this.idFunc = idFunc;
        this.nomeColaborador = nomeColaborador;
    }

    /**
     * @return the idLibe
     */
    public int getIdLibe() {
        return idLibe;
    }

    /**
     * @param idLibe the idLibe to set
     */
    public void setIdLibe(int idLibe) {
        this.idLibe = idLibe;
    }

    /**
     * @return the statusLibera
     */
    public String getStatusLibera() {
        return statusLibera;
    }

    /**
     * @param statusLibera the statusLibera to set
     */
    public void setStatusLibera(String statusLibera) {
        this.statusLibera = statusLibera;
    }

    /**
     * @return the dataRegistro
     */
    public Date getDataRegistro() {
        return dataRegistro;
    }

    /**
     * @param dataRegistro the dataRegistro to set
     */
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    /**
     * @return the idPav
     */
    public int getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(int idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the descricaoPavilhao
     */
    public String getDescricaoPavilhao() {
        return descricaoPavilhao;
    }

    /**
     * @param descricaoPavilhao the descricaoPavilhao to set
     */
    public void setDescricaoPavilhao(String descricaoPavilhao) {
        this.descricaoPavilhao = descricaoPavilhao;
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

    /**
     * @return the idItemLibPSP
     */
    public int getIdItemLibPSP() {
        return idItemLibPSP;
    }

    /**
     * @param idItemLibPSP the idItemLibPSP to set
     */
    public void setIdItemLibPSP(int idItemLibPSP) {
        this.idItemLibPSP = idItemLibPSP;
    }

    /**
     * @return the statusFunc
     */
    public String getStatusFunc() {
        return statusFunc;
    }

    /**
     * @param statusFunc the statusFunc to set
     */
    public void setStatusFunc(String statusFunc) {
        this.statusFunc = statusFunc;
    }

    /**
     * @return the idFunc
     */
    public int getIdFunc() {
        return idFunc;
    }

    /**
     * @param idFunc the idFunc to set
     */
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    /**
     * @return the nomeColaborador
     */
    public String getNomeColaborador() {
        return nomeColaborador;
    }

    /**
     * @param nomeColaborador the nomeColaborador to set
     */
    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    @Override
    public String toString() {
        return getNomeColaborador(); //To change body of generated methods, choose Tools | Templates.
    }
}
