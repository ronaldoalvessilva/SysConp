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
public class FichaTecnicaReceitas {
    
    private int idFicha;
    private String statusFicha;
    private Date DataFicha;
    private String descricaoFicha;
    private int idCategoria;
    private String descricaoCategoria;
    private int porcoes;
    private String modoFazer;
    private String observacao;
    private String caminhoFoto;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public FichaTecnicaReceitas(int idFicha, String statusFicha, Date DataFicha, String descricaoFicha, int idCategoria, String descricaoCategoria, int porcoes, String modoFazer, String observacao, String caminhoFoto, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idFicha = idFicha;
        this.statusFicha = statusFicha;
        this.DataFicha = DataFicha;
        this.descricaoFicha = descricaoFicha;
        this.idCategoria = idCategoria;
        this.descricaoCategoria = descricaoCategoria;
        this.porcoes = porcoes;
        this.modoFazer = modoFazer;
        this.observacao = observacao;
        this.caminhoFoto = caminhoFoto;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public FichaTecnicaReceitas() {
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
     * @return the statusFicha
     */
    public String getStatusFicha() {
        return statusFicha;
    }

    /**
     * @param statusFicha the statusFicha to set
     */
    public void setStatusFicha(String statusFicha) {
        this.statusFicha = statusFicha;
    }

    /**
     * @return the DataFicha
     */
    public Date getDataFicha() {
        return DataFicha;
    }

    /**
     * @param DataFicha the DataFicha to set
     */
    public void setDataFicha(Date DataFicha) {
        this.DataFicha = DataFicha;
    }

    /**
     * @return the descricaoFicha
     */
    public String getDescricaoFicha() {
        return descricaoFicha;
    }

    /**
     * @param descricaoFicha the descricaoFicha to set
     */
    public void setDescricaoFicha(String descricaoFicha) {
        this.descricaoFicha = descricaoFicha;
    }

    /**
     * @return the idCategoria
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @return the descricaoCategoria
     */
    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    /**
     * @param descricaoCategoria the descricaoCategoria to set
     */
    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    /**
     * @return the porcoes
     */
    public int getPorcoes() {
        return porcoes;
    }

    /**
     * @param porcoes the porcoes to set
     */
    public void setPorcoes(int porcoes) {
        this.porcoes = porcoes;
    }

    /**
     * @return the modoFazer
     */
    public String getModoFazer() {
        return modoFazer;
    }

    /**
     * @param modoFazer the modoFazer to set
     */
    public void setModoFazer(String modoFazer) {
        this.modoFazer = modoFazer;
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
     * @return the caminhoFoto
     */
    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    /**
     * @param caminhoFoto the caminhoFoto to set
     */
    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
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
