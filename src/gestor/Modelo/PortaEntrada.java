/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Socializa TI 02
 */
public class PortaEntrada {

    private int idAdmPorta;
    private Date DataEntrada;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String pSPEnf;
    private String habEnf;
    private String pSPMed;
    private String habMed;
    private String pSPJur;
    private String habJur;
    private String pSPPed;
    private String habPed;
    private String pSPPsi;
    private String habPsi;
    private String pSPSso;
    private String habSso;
    private String pSPOdo;
    private String habOdo;
    private String pSPTer;
    private String habTer;
    private String pSPEdu;
    private String habEdu;

    public PortaEntrada() {
    }

    public PortaEntrada(int idAdmPorta, Date DataEntrada, int idInternoCrc, String nomeInternoCrc, String pSPEnf, String habEnf, String pSPMed, String habMed, String pSPJur, String habJur, String pSPPed, String habPed, String pSPPsi, String habPsi, String pSPSso, String habSso, String pSPOdo, String habOdo, String pSPTer, String habTer, String pSPEdu, String habEdu) {
        this.idAdmPorta = idAdmPorta;
        this.DataEntrada = DataEntrada;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.pSPEnf = pSPEnf;
        this.habEnf = habEnf;
        this.pSPMed = pSPMed;
        this.habMed = habMed;
        this.pSPJur = pSPJur;
        this.habJur = habJur;
        this.pSPPed = pSPPed;
        this.habPed = habPed;
        this.pSPPsi = pSPPsi;
        this.habPsi = habPsi;
        this.pSPSso = pSPSso;
        this.habSso = habSso;
        this.pSPOdo = pSPOdo;
        this.habOdo = habOdo;
        this.pSPTer = pSPTer;
        this.habTer = habTer;
        this.pSPEdu = pSPEdu;
        this.habEdu = habEdu;
    }

    /**
     * @return the idAdmPorta
     */
    public int getIdAdmPorta() {
        return idAdmPorta;
    }

    /**
     * @param idAdmPorta the idAdmPorta to set
     */
    public void setIdAdmPorta(int idAdmPorta) {
        this.idAdmPorta = idAdmPorta;
    }

    /**
     * @return the DataEntrada
     */
    public Date getDataEntrada() {
        return DataEntrada;
    }

    /**
     * @param DataEntrada the DataEntrada to set
     */
    public void setDataEntrada(Date DataEntrada) {
        this.DataEntrada = DataEntrada;
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
     * @return the pSPEnf
     */
    public String getpSPEnf() {
        return pSPEnf;
    }

    /**
     * @param pSPEnf the pSPEnf to set
     */
    public void setpSPEnf(String pSPEnf) {
        this.pSPEnf = pSPEnf;
    }

    /**
     * @return the habEnf
     */
    public String getHabEnf() {
        return habEnf;
    }

    /**
     * @param habEnf the habEnf to set
     */
    public void setHabEnf(String habEnf) {
        this.habEnf = habEnf;
    }

    /**
     * @return the pSPMed
     */
    public String getpSPMed() {
        return pSPMed;
    }

    /**
     * @param pSPMed the pSPMed to set
     */
    public void setpSPMed(String pSPMed) {
        this.pSPMed = pSPMed;
    }

    /**
     * @return the habMed
     */
    public String getHabMed() {
        return habMed;
    }

    /**
     * @param habMed the habMed to set
     */
    public void setHabMed(String habMed) {
        this.habMed = habMed;
    }

    /**
     * @return the pSPJur
     */
    public String getpSPJur() {
        return pSPJur;
    }

    /**
     * @param pSPJur the pSPJur to set
     */
    public void setpSPJur(String pSPJur) {
        this.pSPJur = pSPJur;
    }

    /**
     * @return the habJur
     */
    public String getHabJur() {
        return habJur;
    }

    /**
     * @param habJur the habJur to set
     */
    public void setHabJur(String habJur) {
        this.habJur = habJur;
    }

    /**
     * @return the pSPPed
     */
    public String getpSPPed() {
        return pSPPed;
    }

    /**
     * @param pSPPed the pSPPed to set
     */
    public void setpSPPed(String pSPPed) {
        this.pSPPed = pSPPed;
    }

    /**
     * @return the habPed
     */
    public String getHabPed() {
        return habPed;
    }

    /**
     * @param habPed the habPed to set
     */
    public void setHabPed(String habPed) {
        this.habPed = habPed;
    }

    /**
     * @return the pSPPsi
     */
    public String getpSPPsi() {
        return pSPPsi;
    }

    /**
     * @param pSPPsi the pSPPsi to set
     */
    public void setpSPPsi(String pSPPsi) {
        this.pSPPsi = pSPPsi;
    }

    /**
     * @return the habPsi
     */
    public String getHabPsi() {
        return habPsi;
    }

    /**
     * @param habPsi the habPsi to set
     */
    public void setHabPsi(String habPsi) {
        this.habPsi = habPsi;
    }

    /**
     * @return the pSPSso
     */
    public String getpSPSso() {
        return pSPSso;
    }

    /**
     * @param pSPSso the pSPSso to set
     */
    public void setpSPSso(String pSPSso) {
        this.pSPSso = pSPSso;
    }

    /**
     * @return the habSso
     */
    public String getHabSso() {
        return habSso;
    }

    /**
     * @param habSso the habSso to set
     */
    public void setHabSso(String habSso) {
        this.habSso = habSso;
    }

    /**
     * @return the pSPOdo
     */
    public String getpSPOdo() {
        return pSPOdo;
    }

    /**
     * @param pSPOdo the pSPOdo to set
     */
    public void setpSPOdo(String pSPOdo) {
        this.pSPOdo = pSPOdo;
    }

    /**
     * @return the habOdo
     */
    public String getHabOdo() {
        return habOdo;
    }

    /**
     * @param habOdo the habOdo to set
     */
    public void setHabOdo(String habOdo) {
        this.habOdo = habOdo;
    }

    /**
     * @return the pSPTer
     */
    public String getpSPTer() {
        return pSPTer;
    }

    /**
     * @param pSPTer the pSPTer to set
     */
    public void setpSPTer(String pSPTer) {
        this.pSPTer = pSPTer;
    }

    /**
     * @return the habTer
     */
    public String getHabTer() {
        return habTer;
    }

    /**
     * @param habTer the habTer to set
     */
    public void setHabTer(String habTer) {
        this.habTer = habTer;
    }

    /**
     * @return the pSPEdu
     */
    public String getpSPEdu() {
        return pSPEdu;
    }

    /**
     * @param pSPEdu the pSPEdu to set
     */
    public void setpSPEdu(String pSPEdu) {
        this.pSPEdu = pSPEdu;
    }

    /**
     * @return the habEdu
     */
    public String getHabEdu() {
        return habEdu;
    }

    /**
     * @param habEdu the habEdu to set
     */
    public void setHabEdu(String habEdu) {
        this.habEdu = habEdu;
    }
}
