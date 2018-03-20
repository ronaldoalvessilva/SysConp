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
public class EapiCrcPaiPsicoSocial {

    private int idEapi;
    private int idPai;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int idUnid;
    private String descricaoUnidade;
    private String tempPenaSentenca;
    private String tempoPenaCumprida;
    private String assistenciaJuridica;
    private String tempoPenaACumprir;
    private String reintegraSistemaPenal;
    private String situacaoJuridica;
    private Date dataEntradaSistemaPenal;
    private String defensorPublico;
    private String outroDefensor;
    private String qualDefensor;
    private String textoPSP;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public EapiCrcPaiPsicoSocial(int idEapi, int idPai, int idInternoCrc, String nomeInternoCrc, int idUnid, String descricaoUnidade, String tempPenaSentenca, String tempoPenaCumprida, String assistenciaJuridica, String tempoPenaACumprir, String reintegraSistemaPenal, String situacaoJuridica, Date dataEntradaSistemaPenal, String defensorPublico, String outroDefensor, String qualDefensor, String textoPSP, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idEapi = idEapi;
        this.idPai = idPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idUnid = idUnid;
        this.descricaoUnidade = descricaoUnidade;
        this.tempPenaSentenca = tempPenaSentenca;
        this.tempoPenaCumprida = tempoPenaCumprida;
        this.assistenciaJuridica = assistenciaJuridica;
        this.tempoPenaACumprir = tempoPenaACumprir;
        this.reintegraSistemaPenal = reintegraSistemaPenal;
        this.situacaoJuridica = situacaoJuridica;
        this.dataEntradaSistemaPenal = dataEntradaSistemaPenal;
        this.defensorPublico = defensorPublico;
        this.outroDefensor = outroDefensor;
        this.qualDefensor = qualDefensor;
        this.textoPSP = textoPSP;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public EapiCrcPaiPsicoSocial() {
    }

    /**
     * @return the idEapi
     */
    public int getIdEapi() {
        return idEapi;
    }

    /**
     * @param idEapi the idEapi to set
     */
    public void setIdEapi(int idEapi) {
        this.idEapi = idEapi;
    }

    /**
     * @return the idPai
     */
    public int getIdPai() {
        return idPai;
    }

    /**
     * @param idPai the idPai to set
     */
    public void setIdPai(int idPai) {
        this.idPai = idPai;
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
     * @return the nomeInternoCrc
     */
    public String getNomeInternoCrc() {
        return nomeInternoCrc;
    }

    /**
     * @param nomeInternoCrc the nomeInternoCrc to set
     */
    public void setNomeInternoCrc(String nomeInternoCrc) {
        this.nomeInternoCrc = nomeInternoCrc;
    }

    /**
     * @return the idUnid
     */
    public int getIdUnid() {
        return idUnid;
    }

    /**
     * @param idUnid the idUnid to set
     */
    public void setIdUnid(int idUnid) {
        this.idUnid = idUnid;
    }

    /**
     * @return the descricaoUnidade
     */
    public String getDescricaoUnidade() {
        return descricaoUnidade;
    }

    /**
     * @param descricaoUnidade the descricaoUnidade to set
     */
    public void setDescricaoUnidade(String descricaoUnidade) {
        this.descricaoUnidade = descricaoUnidade;
    }

    /**
     * @return the tempPenaSentenca
     */
    public String getTempPenaSentenca() {
        return tempPenaSentenca;
    }

    /**
     * @param tempPenaSentenca the tempPenaSentenca to set
     */
    public void setTempPenaSentenca(String tempPenaSentenca) {
        this.tempPenaSentenca = tempPenaSentenca;
    }

    /**
     * @return the tempoPenaCumprida
     */
    public String getTempoPenaCumprida() {
        return tempoPenaCumprida;
    }

    /**
     * @param tempoPenaCumprida the tempoPenaCumprida to set
     */
    public void setTempoPenaCumprida(String tempoPenaCumprida) {
        this.tempoPenaCumprida = tempoPenaCumprida;
    }

    /**
     * @return the assistenciaJuridica
     */
    public String getAssistenciaJuridica() {
        return assistenciaJuridica;
    }

    /**
     * @param assistenciaJuridica the assistenciaJuridica to set
     */
    public void setAssistenciaJuridica(String assistenciaJuridica) {
        this.assistenciaJuridica = assistenciaJuridica;
    }

    /**
     * @return the tempoPenaACumprir
     */
    public String getTempoPenaACumprir() {
        return tempoPenaACumprir;
    }

    /**
     * @param tempoPenaACumprir the tempoPenaACumprir to set
     */
    public void setTempoPenaACumprir(String tempoPenaACumprir) {
        this.tempoPenaACumprir = tempoPenaACumprir;
    }

    /**
     * @return the reintegraSistemaPenal
     */
    public String getReintegraSistemaPenal() {
        return reintegraSistemaPenal;
    }

    /**
     * @param reintegraSistemaPenal the reintegraSistemaPenal to set
     */
    public void setReintegraSistemaPenal(String reintegraSistemaPenal) {
        this.reintegraSistemaPenal = reintegraSistemaPenal;
    }

    /**
     * @return the situacaoJuridica
     */
    public String getSituacaoJuridica() {
        return situacaoJuridica;
    }

    /**
     * @param situacaoJuridica the situacaoJuridica to set
     */
    public void setSituacaoJuridica(String situacaoJuridica) {
        this.situacaoJuridica = situacaoJuridica;
    }

    /**
     * @return the dataEntradaSistemaPenal
     */
    public Date getDataEntradaSistemaPenal() {
        return dataEntradaSistemaPenal;
    }

    /**
     * @param dataEntradaSistemaPenal the dataEntradaSistemaPenal to set
     */
    public void setDataEntradaSistemaPenal(Date dataEntradaSistemaPenal) {
        this.dataEntradaSistemaPenal = dataEntradaSistemaPenal;
    }

    /**
     * @return the defensorPublico
     */
    public String getDefensorPublico() {
        return defensorPublico;
    }

    /**
     * @param defensorPublico the defensorPublico to set
     */
    public void setDefensorPublico(String defensorPublico) {
        this.defensorPublico = defensorPublico;
    }

    /**
     * @return the outroDefensor
     */
    public String getOutroDefensor() {
        return outroDefensor;
    }

    /**
     * @param outroDefensor the outroDefensor to set
     */
    public void setOutroDefensor(String outroDefensor) {
        this.outroDefensor = outroDefensor;
    }

    /**
     * @return the qualDefensor
     */
    public String getQualDefensor() {
        return qualDefensor;
    }

    /**
     * @param qualDefensor the qualDefensor to set
     */
    public void setQualDefensor(String qualDefensor) {
        this.qualDefensor = qualDefensor;
    }

    /**
     * @return the textoPSP
     */
    public String getTextoPSP() {
        return textoPSP;
    }

    /**
     * @param textoPSP the textoPSP to set
     */
    public void setTextoPSP(String textoPSP) {
        this.textoPSP = textoPSP;
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
