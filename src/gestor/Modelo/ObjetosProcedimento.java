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
public class ObjetosProcedimento {

    private int idObjPro;
    private String descricaoObjeto;
    private String unidadeObjeto;
    private int idProc;
    private int idItensPcip;
    private int idCela;
    private String descricaoCela;
    private float qtde;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;       

    public ObjetosProcedimento(int idObjPro, String descricaoObjeto, String unidadeObjeto, int idProc, int idItensPcip, int idCela, String descricaoCela, float qtde, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idObjPro = idObjPro;
        this.descricaoObjeto = descricaoObjeto;
        this.unidadeObjeto = unidadeObjeto;
        this.idProc = idProc;
        this.idItensPcip = idItensPcip;
        this.idCela = idCela;
        this.descricaoCela = descricaoCela;
        this.qtde = qtde;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ObjetosProcedimento() {
    }

    /**
     * @return the idObjPro
     */
    public int getIdObjPro() {
        return idObjPro;
    }

    /**
     * @param idObjPro the idObjPro to set
     */
    public void setIdObjPro(int idObjPro) {
        this.idObjPro = idObjPro;
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
     * @return the unidadeObjeto
     */
    public String getUnidadeObjeto() {
        return unidadeObjeto;
    }

    /**
     * @param unidadeObjeto the unidadeObjeto to set
     */
    public void setUnidadeObjeto(String unidadeObjeto) {
        this.unidadeObjeto = unidadeObjeto;
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
     * @return the idItensPcip
     */
    public int getIdItensPcip() {
        return idItensPcip;
    }

    /**
     * @param idItensPcip the idItensPcip to set
     */
    public void setIdItensPcip(int idItensPcip) {
        this.idItensPcip = idItensPcip;
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
     * @return the qtde
     */
    public float getQtde() {
        return qtde;
    }

    /**
     * @param qtde the qtde to set
     */
    public void setQtde(float qtde) {
        this.qtde = qtde;
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
