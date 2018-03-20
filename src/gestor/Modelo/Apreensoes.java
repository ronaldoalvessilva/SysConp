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
public class Apreensoes {

    private int idAprende;
    private int idLanc;
    private int idInternoCrc;
    private String nomeInternoApreensoes;
    private int idObjeto;
    private String descricaoObjeto;
    private float qtdEncontrada;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public Apreensoes(int idAprende, int idLanc, int idInternoCrc, String nomeInternoApreensoes, int idObjeto, String descricaoObjeto, float qtdEncontrada, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idAprende = idAprende;
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoApreensoes = nomeInternoApreensoes;
        this.idObjeto = idObjeto;
        this.descricaoObjeto = descricaoObjeto;
        this.qtdEncontrada = qtdEncontrada;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public Apreensoes() {
    }

    /**
     * @return the idAprende
     */
    public int getIdAprende() {
        return idAprende;
    }

    /**
     * @param idAprende the idAprende to set
     */
    public void setIdAprende(int idAprende) {
        this.idAprende = idAprende;
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
     * @return the nomeInternoApreensoes
     */
    public String getNomeInternoApreensoes() {
        return nomeInternoApreensoes;
    }

    /**
     * @param nomeInternoApreensoes the nomeInternoApreensoes to set
     */
    public void setNomeInternoApreensoes(String nomeInternoApreensoes) {
        this.nomeInternoApreensoes = nomeInternoApreensoes;
    }

    /**
     * @return the idObjeto
     */
    public int getIdObjeto() {
        return idObjeto;
    }

    /**
     * @param idObjeto the idObjeto to set
     */
    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    /**
     * @return the descricaoObjeto
     */
    public String getDescricaoObjeto() {
        return descricaoObjeto;
    }

    /**
     * @param descricaoObjeto the descricaoObjeto to set
     */
    public void setDescricaoObjeto(String descricaoObjeto) {
        this.descricaoObjeto = descricaoObjeto;
    }

    /**
     * @return the qtdEncontrada
     */
    public float getQtdEncontrada() {
        return qtdEncontrada;
    }

    /**
     * @param qtdEncontrada the qtdEncontrada to set
     */
    public void setQtdEncontrada(float qtdEncontrada) {
        this.qtdEncontrada = qtdEncontrada;
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
