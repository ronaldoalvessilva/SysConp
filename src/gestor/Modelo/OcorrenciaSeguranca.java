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
public class OcorrenciaSeguranca {

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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the textoArea
     */
    public String getTextoArea() {
        return textoArea;
    }

    /**
     * @param textoArea the textoArea to set
     */
    public void setTextoArea(String textoArea) {
        this.textoArea = textoArea;
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

    /**
     * @return the fonte
     */
    public String getFonte() {
        return fonte;
    }

    /**
     * @param fonte the fonte to set
     */
    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    /**
     * @return the Tamanho
     */
    public String getTamanho() {
        return Tamanho;
    }

    /**
     * @param Tamanho the Tamanho to set
     */
    public void setTamanho(String Tamanho) {
        this.Tamanho = Tamanho;
    }

    /**
     * @return the Btesq
     */
    public int getBtesq() {
        return Btesq;
    }

    /**
     * @param Btesq the Btesq to set
     */
    public void setBtesq(int Btesq) {
        this.Btesq = Btesq;
    }

    /**
     * @return the BtCen
     */
    public int getBtCen() {
        return BtCen;
    }

    /**
     * @param BtCen the BtCen to set
     */
    public void setBtCen(int BtCen) {
        this.BtCen = BtCen;
    }

    /**
     * @return the BtDir
     */
    public int getBtDir() {
        return BtDir;
    }

    /**
     * @param BtDir the BtDir to set
     */
    public void setBtDir(int BtDir) {
        this.BtDir = BtDir;
    }

    /**
     * @return the BtJus
     */
    public int getBtJus() {
        return BtJus;
    }

    /**
     * @param BtJus the BtJus to set
     */
    public void setBtJus(int BtJus) {
        this.BtJus = BtJus;
    }

    private int idLanc;
    private String statusLanc;
    private Date dataLanc;
    private String titulo;
    private String textoArea;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private String fonte;
    private String Tamanho;
    private int Btesq;
    private int BtCen;
    private int BtDir;
    private int BtJus;

    public OcorrenciaSeguranca(int idLanc, String statusLanc, Date dataLanc, String titulo, String textoArea, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String fonte, String Tamanho, int Btesq, int BtCen, int BtDir, int BtJus) {
        this.idLanc = idLanc;
        this.statusLanc = statusLanc;
        this.dataLanc = dataLanc;
        this.titulo = titulo;
        this.textoArea = textoArea;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.fonte = fonte;
        this.Tamanho = Tamanho;
        this.Btesq = Btesq;
        this.BtCen = BtCen;
        this.BtDir = BtDir;
        this.BtJus = BtJus;
    }

    public OcorrenciaSeguranca() {
    }
}
