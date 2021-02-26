/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronaldo.silva7
 */
public class ChaveLiberacao {

    private Integer iD_REGISTRO;
    private Date dataLiberacao;
    private String cNPJ;
    private String razaoSocial;
    private Date dataValidade;
    private String cHAVE01_liberacao; 
    private String cHAVE02_liberacao; 
    private String cHAVE03_liberacao; 
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;

    public ChaveLiberacao() {
    }

    public ChaveLiberacao(Integer iD_REGISTRO, Date dataLiberacao, String cNPJ, String razaoSocial, Date dataValidade, String cHAVE01_liberacao, String cHAVE02_liberacao, String cHAVE03_liberacao, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp) {
        this.iD_REGISTRO = iD_REGISTRO;
        this.dataLiberacao = dataLiberacao;
        this.cNPJ = cNPJ;
        this.razaoSocial = razaoSocial;
        this.dataValidade = dataValidade;
        this.cHAVE01_liberacao = cHAVE01_liberacao;
        this.cHAVE02_liberacao = cHAVE02_liberacao;
        this.cHAVE03_liberacao = cHAVE03_liberacao;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the iD_REGISTRO
     */
    public Integer getiD_REGISTRO() {
        return iD_REGISTRO;
    }

    /**
     * @param iD_REGISTRO the iD_REGISTRO to set
     */
    public void setiD_REGISTRO(Integer iD_REGISTRO) {
        this.iD_REGISTRO = iD_REGISTRO;
    }

    /**
     * @return the dataLiberacao
     */
    public Date getDataLiberacao() {
        return dataLiberacao;
    }

    /**
     * @param dataLiberacao the dataLiberacao to set
     */
    public void setDataLiberacao(Date dataLiberacao) {
        this.dataLiberacao = dataLiberacao;
    }

    /**
     * @return the cNPJ
     */
    public String getcNPJ() {
        return cNPJ;
    }

    /**
     * @param cNPJ the cNPJ to set
     */
    public void setcNPJ(String cNPJ) {
        this.cNPJ = cNPJ;
    }

    /**
     * @return the razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razaoSocial the razaoSocial to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * @return the dataValidade
     */
    public Date getDataValidade() {
        return dataValidade;
    }

    /**
     * @param dataValidade the dataValidade to set
     */
    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
     * @return the cHAVE01_liberacao
     */
    public String getcHAVE01_liberacao() {
        return cHAVE01_liberacao;
    }

    /**
     * @param cHAVE01_liberacao the cHAVE01_liberacao to set
     */
    public void setcHAVE01_liberacao(String cHAVE01_liberacao) {
        this.cHAVE01_liberacao = cHAVE01_liberacao;
    }

    /**
     * @return the cHAVE02_liberacao
     */
    public String getcHAVE02_liberacao() {
        return cHAVE02_liberacao;
    }

    /**
     * @param cHAVE02_liberacao the cHAVE02_liberacao to set
     */
    public void setcHAVE02_liberacao(String cHAVE02_liberacao) {
        this.cHAVE02_liberacao = cHAVE02_liberacao;
    }

    /**
     * @return the cHAVE03_liberacao
     */
    public String getcHAVE03_liberacao() {
        return cHAVE03_liberacao;
    }

    /**
     * @param cHAVE03_liberacao the cHAVE03_liberacao to set
     */
    public void setcHAVE03_liberacao(String cHAVE03_liberacao) {
        this.cHAVE03_liberacao = cHAVE03_liberacao;
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
}
