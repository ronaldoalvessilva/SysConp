/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author user
 */
public class EvolucaoMedica {

    private int idItem;
    private String statusLanc;
    private int idInternoCrc;
    private String nomeInternoEvoluMedica;
    private Date dataEvolu;
    private int idLanc;
    private String textoEvolucao;
    private String hipoteseDiagnostica;
    private String examesSolicitados;
    private String patologiaAdquiridaMedica;
    private String deptoMedico;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;          

    public EvolucaoMedica(int idItem, String statusLanc, int idInternoCrc, String nomeInternoEvoluMedica, Date dataEvolu, int idLanc, String textoEvolucao, String hipoteseDiagnostica, String examesSolicitados, String patologiaAdquiridaMedica, String deptoMedico, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento) {
        this.idItem = idItem;
        this.statusLanc = statusLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoEvoluMedica = nomeInternoEvoluMedica;
        this.dataEvolu = dataEvolu;
        this.idLanc = idLanc;
        this.textoEvolucao = textoEvolucao;
        this.hipoteseDiagnostica = hipoteseDiagnostica;
        this.examesSolicitados = examesSolicitados;
        this.patologiaAdquiridaMedica = patologiaAdquiridaMedica;
        this.deptoMedico = deptoMedico;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
    }

    public EvolucaoMedica() {
    }

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
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
     * @return the nomeInternoEvoluMedica
     */
    public String getNomeInternoEvoluMedica() {
        return nomeInternoEvoluMedica;
    }

    /**
     * @param nomeInternoEvoluMedica the nomeInternoEvoluMedica to set
     */
    public void setNomeInternoEvoluMedica(String nomeInternoEvoluMedica) {
        this.nomeInternoEvoluMedica = nomeInternoEvoluMedica;
    }

    /**
     * @return the dataEvolu
     */
    public Date getDataEvolu() {
        return dataEvolu;
    }

    /**
     * @param dataEvolu the dataEvolu to set
     */
    public void setDataEvolu(Date dataEvolu) {
        this.dataEvolu = dataEvolu;
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
     * @return the textoEvolucao
     */
    public String getTextoEvolucao() {
        return textoEvolucao;
    }

    /**
     * @param textoEvolucao the textoEvolucao to set
     */
    public void setTextoEvolucao(String textoEvolucao) {
        this.textoEvolucao = textoEvolucao;
    }

    /**
     * @return the hipoteseDiagnostica
     */
    public String getHipoteseDiagnostica() {
        return hipoteseDiagnostica;
    }

    /**
     * @param hipoteseDiagnostica the hipoteseDiagnostica to set
     */
    public void setHipoteseDiagnostica(String hipoteseDiagnostica) {
        this.hipoteseDiagnostica = hipoteseDiagnostica;
    }

    /**
     * @return the examesSolicitados
     */
    public String getExamesSolicitados() {
        return examesSolicitados;
    }

    /**
     * @param examesSolicitados the examesSolicitados to set
     */
    public void setExamesSolicitados(String examesSolicitados) {
        this.examesSolicitados = examesSolicitados;
    }

    /**
     * @return the patologiaAdquiridaMedica
     */
    public String getPatologiaAdquiridaMedica() {
        return patologiaAdquiridaMedica;
    }

    /**
     * @param patologiaAdquiridaMedica the patologiaAdquiridaMedica to set
     */
    public void setPatologiaAdquiridaMedica(String patologiaAdquiridaMedica) {
        this.patologiaAdquiridaMedica = patologiaAdquiridaMedica;
    }

    /**
     * @return the deptoMedico
     */
    public String getDeptoMedico() {
        return deptoMedico;
    }

    /**
     * @param deptoMedico the deptoMedico to set
     */
    public void setDeptoMedico(String deptoMedico) {
        this.deptoMedico = deptoMedico;
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
     * @return the horaInsert
     */
    public String getHoraInsert() {
        return horaInsert;
    }

    /**
     * @param horaInsert the horaInsert to set
     */
    public void setHoraInsert(String horaInsert) {
        this.horaInsert = horaInsert;
    }

    /**
     * @return the horaUp
     */
    public String getHoraUp() {
        return horaUp;
    }

    /**
     * @param horaUp the horaUp to set
     */
    public void setHoraUp(String horaUp) {
        this.horaUp = horaUp;
    }

    /**
     * @return the dataFechamento
     */
    public String getDataFechamento() {
        return dataFechamento;
    }

    /**
     * @param dataFechamento the dataFechamento to set
     */
    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    /**
     * @return the horaFechamento
     */
    public String getHoraFechamento() {
        return horaFechamento;
    }

    /**
     * @param horaFechamento the horaFechamento to set
     */
    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }
}
