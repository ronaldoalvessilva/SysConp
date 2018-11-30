/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronal
 */
public class DigitalInterno {

    private int IdInternoCrc;
    private String NomeInternoCrc;
    private byte[] fotoInternoDB;
    private String caminhoFoto;
    private String regimePenal;
    private String cnc;
    private String nomeMaeInterno;
    private Date dataAssinatura;
    private String horaAssinatura;
    private byte[] biometriaDedo1;
    private byte[] biometriaDedo2;
    private byte[] biometriaDedo3;
    private byte[] biometriaDedo4;

    public DigitalInterno() {
    }

    public DigitalInterno(int IdInternoCrc, String NomeInternoCrc, byte[] fotoInternoDB, String caminhoFoto, String regimePenal, String cnc, String nomeMaeInterno, Date dataAssinatura, String horaAssinatura, byte[] biometriaDedo1, byte[] biometriaDedo2, byte[] biometriaDedo3, byte[] biometriaDedo4) {
        this.IdInternoCrc = IdInternoCrc;
        this.NomeInternoCrc = NomeInternoCrc;
        this.fotoInternoDB = fotoInternoDB;
        this.caminhoFoto = caminhoFoto;
        this.regimePenal = regimePenal;
        this.cnc = cnc;
        this.nomeMaeInterno = nomeMaeInterno;
        this.dataAssinatura = dataAssinatura;
        this.horaAssinatura = horaAssinatura;
        this.biometriaDedo1 = biometriaDedo1;
        this.biometriaDedo2 = biometriaDedo2;
        this.biometriaDedo3 = biometriaDedo3;
        this.biometriaDedo4 = biometriaDedo4;
    }

    /**
     * @return the IdInternoCrc
     */
    public int getIdInternoCrc() {
        return IdInternoCrc;
    }

    /**
     * @param IdInternoCrc the IdInternoCrc to set
     */
    public void setIdInternoCrc(int IdInternoCrc) {
        this.IdInternoCrc = IdInternoCrc;
    }

    /**
     * @return the NomeInternoCrc
     */
    public String getNomeInternoCrc() {
        return NomeInternoCrc;
    }

    /**
     * @param NomeInternoCrc the NomeInternoCrc to set
     */
    public void setNomeInternoCrc(String NomeInternoCrc) {
        this.NomeInternoCrc = NomeInternoCrc;
    }

    /**
     * @return the fotoInternoDB
     */
    public byte[] getFotoInternoDB() {
        return fotoInternoDB;
    }

    /**
     * @param fotoInternoDB the fotoInternoDB to set
     */
    public void setFotoInternoDB(byte[] fotoInternoDB) {
        this.fotoInternoDB = fotoInternoDB;
    }

    /**
     * @return the caminhoFoto
     */
    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    /**
     * @param caminhoFoto the caminhoFoto to set
     */
    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    /**
     * @return the regimePenal
     */
    public String getRegimePenal() {
        return regimePenal;
    }

    /**
     * @param regimePenal the regimePenal to set
     */
    public void setRegimePenal(String regimePenal) {
        this.regimePenal = regimePenal;
    }

    /**
     * @return the cnc
     */
    public String getCnc() {
        return cnc;
    }

    /**
     * @param cnc the cnc to set
     */
    public void setCnc(String cnc) {
        this.cnc = cnc;
    }

    /**
     * @return the nomeMaeInterno
     */
    public String getNomeMaeInterno() {
        return nomeMaeInterno;
    }

    /**
     * @param nomeMaeInterno the nomeMaeInterno to set
     */
    public void setNomeMaeInterno(String nomeMaeInterno) {
        this.nomeMaeInterno = nomeMaeInterno;
    }

    /**
     * @return the dataAssinatura
     */
    public Date getDataAssinatura() {
        return dataAssinatura;
    }

    /**
     * @param dataAssinatura the dataAssinatura to set
     */
    public void setDataAssinatura(Date dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }

    /**
     * @return the horaAssinatura
     */
    public String getHoraAssinatura() {
        return horaAssinatura;
    }

    /**
     * @param horaAssinatura the horaAssinatura to set
     */
    public void setHoraAssinatura(String horaAssinatura) {
        this.horaAssinatura = horaAssinatura;
    }

    /**
     * @return the biometriaDedo1
     */
    public byte[] getBiometriaDedo1() {
        return biometriaDedo1;
    }

    /**
     * @param biometriaDedo1 the biometriaDedo1 to set
     */
    public void setBiometriaDedo1(byte[] biometriaDedo1) {
        this.biometriaDedo1 = biometriaDedo1;
    }

    /**
     * @return the biometriaDedo2
     */
    public byte[] getBiometriaDedo2() {
        return biometriaDedo2;
    }

    /**
     * @param biometriaDedo2 the biometriaDedo2 to set
     */
    public void setBiometriaDedo2(byte[] biometriaDedo2) {
        this.biometriaDedo2 = biometriaDedo2;
    }

    /**
     * @return the biometriaDedo3
     */
    public byte[] getBiometriaDedo3() {
        return biometriaDedo3;
    }

    /**
     * @param biometriaDedo3 the biometriaDedo3 to set
     */
    public void setBiometriaDedo3(byte[] biometriaDedo3) {
        this.biometriaDedo3 = biometriaDedo3;
    }

    /**
     * @return the biometriaDedo4
     */
    public byte[] getBiometriaDedo4() {
        return biometriaDedo4;
    }

    /**
     * @param biometriaDedo4 the biometriaDedo4 to set
     */
    public void setBiometriaDedo4(byte[] biometriaDedo4) {
        this.biometriaDedo4 = biometriaDedo4;
    }
}
