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
public class AutorEventos {

    private int idAutor;
    private int idLanc;
    private int idInternoCrc;
    private String nomeInterno;
    private int idCela;
    private String descricaoCela;
    private float qtdDias;
    private String utilizacaoSaida;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;    

    public AutorEventos(int idAutor, int idLanc, int idInternoCrc, String nomeInterno, int idCela, String descricaoCela, float qtdDias, String utilizacaoSaida, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idAutor = idAutor;
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.idCela = idCela;
        this.descricaoCela = descricaoCela;
        this.qtdDias = qtdDias;
        this.utilizacaoSaida = utilizacaoSaida;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AutorEventos() {
    }

    /**
     * @return the idAutor
     */
    public int getIdAutor() {
        return idAutor;
    }

    /**
     * @param idAutor the idAutor to set
     */
    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
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
     * @return the idCela
     */
    public int getIdCela() {
        return idCela;
    }

    /**
     * @param idCela the idCela to set
     */
    public void setIdCela(int idCela) {
        this.idCela = idCela;
    }

    /**
     * @return the descricaoCela
     */
    public String getDescricaoCela() {
        return descricaoCela;
    }

    /**
     * @param descricaoCela the descricaoCela to set
     */
    public void setDescricaoCela(String descricaoCela) {
        this.descricaoCela = descricaoCela;
    }

    /**
     * @return the qtdDias
     */
    public float getQtdDias() {
        return qtdDias;
    }

    /**
     * @param qtdDias the qtdDias to set
     */
    public void setQtdDias(float qtdDias) {
        this.qtdDias = qtdDias;
    }

    /**
     * @return the utilizacaoSaida
     */
    public String getUtilizacaoSaida() {
        return utilizacaoSaida;
    }

    /**
     * @param utilizacaoSaida the utilizacaoSaida to set
     */
    public void setUtilizacaoSaida(String utilizacaoSaida) {
        this.utilizacaoSaida = utilizacaoSaida;
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
