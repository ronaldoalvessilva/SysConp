/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author CPLF
 */
public class Enderecos {

    private int idEnd;
    private int idFunc;
    private String nomeFunc;
    private String endereco;
    private String bairroEnd;
    private String compEnd;
    private String cidadeEnd;
    private String estadoEnd;
    private String cepEnd;
    private String foneEnd;
    private String telEnd;
    private String celEnd;
    private String emalEnd;
    private String emailEndEmp;
    private String url;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public Enderecos(int idEnd, int idFunc, String nomeFunc, String endereco, String bairroEnd, String compEnd, String cidadeEnd, String estadoEnd, String cepEnd, String foneEnd, String telEnd, String celEnd, String emalEnd, String emailEndEmp, String url, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idEnd = idEnd;
        this.idFunc = idFunc;
        this.nomeFunc = nomeFunc;
        this.endereco = endereco;
        this.bairroEnd = bairroEnd;
        this.compEnd = compEnd;
        this.cidadeEnd = cidadeEnd;
        this.estadoEnd = estadoEnd;
        this.cepEnd = cepEnd;
        this.foneEnd = foneEnd;
        this.telEnd = telEnd;
        this.celEnd = celEnd;
        this.emalEnd = emalEnd;
        this.emailEndEmp = emailEndEmp;
        this.url = url;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public Enderecos() {
    }

    /**
     * @return the idEnd
     */
    public int getIdEnd() {
        return idEnd;
    }

    /**
     * @param idEnd the idEnd to set
     */
    public void setIdEnd(int idEnd) {
        this.idEnd = idEnd;
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
     * @return the nomeFunc
     */
    public String getNomeFunc() {
        return nomeFunc;
    }

    /**
     * @param nomeFunc the nomeFunc to set
     */
    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairroEnd
     */
    public String getBairroEnd() {
        return bairroEnd;
    }

    /**
     * @param bairroEnd the bairroEnd to set
     */
    public void setBairroEnd(String bairroEnd) {
        this.bairroEnd = bairroEnd;
    }

    /**
     * @return the compEnd
     */
    public String getCompEnd() {
        return compEnd;
    }

    /**
     * @param compEnd the compEnd to set
     */
    public void setCompEnd(String compEnd) {
        this.compEnd = compEnd;
    }

    /**
     * @return the cidadeEnd
     */
    public String getCidadeEnd() {
        return cidadeEnd;
    }

    /**
     * @param cidadeEnd the cidadeEnd to set
     */
    public void setCidadeEnd(String cidadeEnd) {
        this.cidadeEnd = cidadeEnd;
    }

    /**
     * @return the estadoEnd
     */
    public String getEstadoEnd() {
        return estadoEnd;
    }

    /**
     * @param estadoEnd the estadoEnd to set
     */
    public void setEstadoEnd(String estadoEnd) {
        this.estadoEnd = estadoEnd;
    }

    /**
     * @return the cepEnd
     */
    public String getCepEnd() {
        return cepEnd;
    }

    /**
     * @param cepEnd the cepEnd to set
     */
    public void setCepEnd(String cepEnd) {
        this.cepEnd = cepEnd;
    }

    /**
     * @return the foneEnd
     */
    public String getFoneEnd() {
        return foneEnd;
    }

    /**
     * @param foneEnd the foneEnd to set
     */
    public void setFoneEnd(String foneEnd) {
        this.foneEnd = foneEnd;
    }

    /**
     * @return the telEnd
     */
    public String getTelEnd() {
        return telEnd;
    }

    /**
     * @param telEnd the telEnd to set
     */
    public void setTelEnd(String telEnd) {
        this.telEnd = telEnd;
    }

    /**
     * @return the celEnd
     */
    public String getCelEnd() {
        return celEnd;
    }

    /**
     * @param celEnd the celEnd to set
     */
    public void setCelEnd(String celEnd) {
        this.celEnd = celEnd;
    }

    /**
     * @return the emalEnd
     */
    public String getEmalEnd() {
        return emalEnd;
    }

    /**
     * @param emalEnd the emalEnd to set
     */
    public void setEmalEnd(String emalEnd) {
        this.emalEnd = emalEnd;
    }

    /**
     * @return the emailEndEmp
     */
    public String getEmailEndEmp() {
        return emailEndEmp;
    }

    /**
     * @param emailEndEmp the emailEndEmp to set
     */
    public void setEmailEndEmp(String emailEndEmp) {
        this.emailEndEmp = emailEndEmp;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
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
