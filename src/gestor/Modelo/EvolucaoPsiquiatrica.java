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
public class EvolucaoPsiquiatrica {

    private int idItem;
    private String statusLanc;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private Date dataDiag;
    private int idLanc;
    private String evolucaoPsiquiatrica;
    private String hipoteseDiagnostica;
    private String examesSolicitados;
    private String patologiaAdquidida;
    private String deptoMedicoPsiq;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;     
    private String admEvo;

    public EvolucaoPsiquiatrica() {
    }

    public EvolucaoPsiquiatrica(int idItem, String statusLanc, int idInternoCrc, String nomeInternoCrc, Date dataDiag, int idLanc, String evolucaoPsiquiatrica, String hipoteseDiagnostica, String examesSolicitados, String patologiaAdquidida, String deptoMedicoPsiq, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String admEvo) {
        this.idItem = idItem;
        this.statusLanc = statusLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.dataDiag = dataDiag;
        this.idLanc = idLanc;
        this.evolucaoPsiquiatrica = evolucaoPsiquiatrica;
        this.hipoteseDiagnostica = hipoteseDiagnostica;
        this.examesSolicitados = examesSolicitados;
        this.patologiaAdquidida = patologiaAdquidida;
        this.deptoMedicoPsiq = deptoMedicoPsiq;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.admEvo = admEvo;
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
     * @return the dataDiag
     */
    public Date getDataDiag() {
        return dataDiag;
    }

    /**
     * @param dataDiag the dataDiag to set
     */
    public void setDataDiag(Date dataDiag) {
        this.dataDiag = dataDiag;
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
     * @return the evolucaoPsiquiatrica
     */
    public String getEvolucaoPsiquiatrica() {
        return evolucaoPsiquiatrica;
    }

    /**
     * @param evolucaoPsiquiatrica the evolucaoPsiquiatrica to set
     */
    public void setEvolucaoPsiquiatrica(String evolucaoPsiquiatrica) {
        this.evolucaoPsiquiatrica = evolucaoPsiquiatrica;
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
     * @return the patologiaAdquidida
     */
    public String getPatologiaAdquidida() {
        return patologiaAdquidida;
    }

    /**
     * @param patologiaAdquidida the patologiaAdquidida to set
     */
    public void setPatologiaAdquidida(String patologiaAdquidida) {
        this.patologiaAdquidida = patologiaAdquidida;
    }

    /**
     * @return the deptoMedicoPsiq
     */
    public String getDeptoMedicoPsiq() {
        return deptoMedicoPsiq;
    }

    /**
     * @param deptoMedicoPsiq the deptoMedicoPsiq to set
     */
    public void setDeptoMedicoPsiq(String deptoMedicoPsiq) {
        this.deptoMedicoPsiq = deptoMedicoPsiq;
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
     * @return the admEvo
     */
    public String getAdmEvo() {
        return admEvo;
    }

    /**
     * @param admEvo the admEvo to set
     */
    public void setAdmEvo(String admEvo) {
        this.admEvo = admEvo;
    }
}
