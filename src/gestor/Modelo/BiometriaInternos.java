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
public class BiometriaInternos {

    private int IdBioInter;
    private Date DataCadastro;
    private int IdInternoCrc;
    private String nomeInternoBio;
    private byte[] BiometriaDedo1;
    private byte[] BiometriaDedo2;
    private byte[] BiometriaDedo3;
    private byte[] BiometriaDedo4;
    private String CaminhoImagemDedo1;
    private String CaminhoImagemDedo2;
    private String CaminhoImagemDedo3;
    private String CaminhoImagemDedo4;
    private String CaminhoImagemDedo5;
    private String CaminhoImagemDedo6;
    private String CaminhoImagemDedo7;
    private String CaminhoImagemDedo8;
    private String CaminhoImagemDedo9;
    private String CaminhoImagemDedo10;
    private String UsuarioInsert;
    private String DataInsert;
    private String HorarioInsert;
    private String UsuarioUp;
    private String DataUp;
    private String HorarioUp;   

    public BiometriaInternos(int IdBioInter, Date DataCadastro, int IdInternoCrc, String nomeInternoBio, byte[] BiometriaDedo1, byte[] BiometriaDedo2, byte[] BiometriaDedo3, byte[] BiometriaDedo4, String CaminhoImagemDedo1, String CaminhoImagemDedo2, String CaminhoImagemDedo3, String CaminhoImagemDedo4, String CaminhoImagemDedo5, String CaminhoImagemDedo6, String CaminhoImagemDedo7, String CaminhoImagemDedo8, String CaminhoImagemDedo9, String CaminhoImagemDedo10, String UsuarioInsert, String DataInsert, String HorarioInsert, String UsuarioUp, String DataUp, String HorarioUp) {
        this.IdBioInter = IdBioInter;
        this.DataCadastro = DataCadastro;
        this.IdInternoCrc = IdInternoCrc;
        this.nomeInternoBio = nomeInternoBio;
        this.BiometriaDedo1 = BiometriaDedo1;
        this.BiometriaDedo2 = BiometriaDedo2;
        this.BiometriaDedo3 = BiometriaDedo3;
        this.BiometriaDedo4 = BiometriaDedo4;
        this.CaminhoImagemDedo1 = CaminhoImagemDedo1;
        this.CaminhoImagemDedo2 = CaminhoImagemDedo2;
        this.CaminhoImagemDedo3 = CaminhoImagemDedo3;
        this.CaminhoImagemDedo4 = CaminhoImagemDedo4;
        this.CaminhoImagemDedo5 = CaminhoImagemDedo5;
        this.CaminhoImagemDedo6 = CaminhoImagemDedo6;
        this.CaminhoImagemDedo7 = CaminhoImagemDedo7;
        this.CaminhoImagemDedo8 = CaminhoImagemDedo8;
        this.CaminhoImagemDedo9 = CaminhoImagemDedo9;
        this.CaminhoImagemDedo10 = CaminhoImagemDedo10;
        this.UsuarioInsert = UsuarioInsert;
        this.DataInsert = DataInsert;
        this.HorarioInsert = HorarioInsert;
        this.UsuarioUp = UsuarioUp;
        this.DataUp = DataUp;
        this.HorarioUp = HorarioUp;
    }

    public BiometriaInternos() {
    }

    /**
     * @return the IdBioInter
     */
    public int getIdBioInter() {
        return IdBioInter;
    }

    /**
     * @param IdBioInter the IdBioInter to set
     */
    public void setIdBioInter(int IdBioInter) {
        this.IdBioInter = IdBioInter;
    }

    /**
     * @return the DataCadastro
     */
    public Date getDataCadastro() {
        return DataCadastro;
    }

    /**
     * @param DataCadastro the DataCadastro to set
     */
    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
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
     * @return the nomeInternoBio
     */
    public String getNomeInternoBio() {
        return nomeInternoBio;
    }

    /**
     * @param nomeInternoBio the nomeInternoBio to set
     */
    public void setNomeInternoBio(String nomeInternoBio) {
        this.nomeInternoBio = nomeInternoBio;
    }

    /**
     * @return the BiometriaDedo1
     */
    public byte[] getBiometriaDedo1() {
        return BiometriaDedo1;
    }

    /**
     * @param BiometriaDedo1 the BiometriaDedo1 to set
     */
    public void setBiometriaDedo1(byte[] BiometriaDedo1) {
        this.BiometriaDedo1 = BiometriaDedo1;
    }

    /**
     * @return the BiometriaDedo2
     */
    public byte[] getBiometriaDedo2() {
        return BiometriaDedo2;
    }

    /**
     * @param BiometriaDedo2 the BiometriaDedo2 to set
     */
    public void setBiometriaDedo2(byte[] BiometriaDedo2) {
        this.BiometriaDedo2 = BiometriaDedo2;
    }

    /**
     * @return the BiometriaDedo3
     */
    public byte[] getBiometriaDedo3() {
        return BiometriaDedo3;
    }

    /**
     * @param BiometriaDedo3 the BiometriaDedo3 to set
     */
    public void setBiometriaDedo3(byte[] BiometriaDedo3) {
        this.BiometriaDedo3 = BiometriaDedo3;
    }

    /**
     * @return the BiometriaDedo4
     */
    public byte[] getBiometriaDedo4() {
        return BiometriaDedo4;
    }

    /**
     * @param BiometriaDedo4 the BiometriaDedo4 to set
     */
    public void setBiometriaDedo4(byte[] BiometriaDedo4) {
        this.BiometriaDedo4 = BiometriaDedo4;
    }

    /**
     * @return the CaminhoImagemDedo1
     */
    public String getCaminhoImagemDedo1() {
        return CaminhoImagemDedo1;
    }

    /**
     * @param CaminhoImagemDedo1 the CaminhoImagemDedo1 to set
     */
    public void setCaminhoImagemDedo1(String CaminhoImagemDedo1) {
        this.CaminhoImagemDedo1 = CaminhoImagemDedo1;
    }

    /**
     * @return the CaminhoImagemDedo2
     */
    public String getCaminhoImagemDedo2() {
        return CaminhoImagemDedo2;
    }

    /**
     * @param CaminhoImagemDedo2 the CaminhoImagemDedo2 to set
     */
    public void setCaminhoImagemDedo2(String CaminhoImagemDedo2) {
        this.CaminhoImagemDedo2 = CaminhoImagemDedo2;
    }

    /**
     * @return the CaminhoImagemDedo3
     */
    public String getCaminhoImagemDedo3() {
        return CaminhoImagemDedo3;
    }

    /**
     * @param CaminhoImagemDedo3 the CaminhoImagemDedo3 to set
     */
    public void setCaminhoImagemDedo3(String CaminhoImagemDedo3) {
        this.CaminhoImagemDedo3 = CaminhoImagemDedo3;
    }

    /**
     * @return the CaminhoImagemDedo4
     */
    public String getCaminhoImagemDedo4() {
        return CaminhoImagemDedo4;
    }

    /**
     * @param CaminhoImagemDedo4 the CaminhoImagemDedo4 to set
     */
    public void setCaminhoImagemDedo4(String CaminhoImagemDedo4) {
        this.CaminhoImagemDedo4 = CaminhoImagemDedo4;
    }

    /**
     * @return the CaminhoImagemDedo5
     */
    public String getCaminhoImagemDedo5() {
        return CaminhoImagemDedo5;
    }

    /**
     * @param CaminhoImagemDedo5 the CaminhoImagemDedo5 to set
     */
    public void setCaminhoImagemDedo5(String CaminhoImagemDedo5) {
        this.CaminhoImagemDedo5 = CaminhoImagemDedo5;
    }

    /**
     * @return the CaminhoImagemDedo6
     */
    public String getCaminhoImagemDedo6() {
        return CaminhoImagemDedo6;
    }

    /**
     * @param CaminhoImagemDedo6 the CaminhoImagemDedo6 to set
     */
    public void setCaminhoImagemDedo6(String CaminhoImagemDedo6) {
        this.CaminhoImagemDedo6 = CaminhoImagemDedo6;
    }

    /**
     * @return the CaminhoImagemDedo7
     */
    public String getCaminhoImagemDedo7() {
        return CaminhoImagemDedo7;
    }

    /**
     * @param CaminhoImagemDedo7 the CaminhoImagemDedo7 to set
     */
    public void setCaminhoImagemDedo7(String CaminhoImagemDedo7) {
        this.CaminhoImagemDedo7 = CaminhoImagemDedo7;
    }

    /**
     * @return the CaminhoImagemDedo8
     */
    public String getCaminhoImagemDedo8() {
        return CaminhoImagemDedo8;
    }

    /**
     * @param CaminhoImagemDedo8 the CaminhoImagemDedo8 to set
     */
    public void setCaminhoImagemDedo8(String CaminhoImagemDedo8) {
        this.CaminhoImagemDedo8 = CaminhoImagemDedo8;
    }

    /**
     * @return the CaminhoImagemDedo9
     */
    public String getCaminhoImagemDedo9() {
        return CaminhoImagemDedo9;
    }

    /**
     * @param CaminhoImagemDedo9 the CaminhoImagemDedo9 to set
     */
    public void setCaminhoImagemDedo9(String CaminhoImagemDedo9) {
        this.CaminhoImagemDedo9 = CaminhoImagemDedo9;
    }

    /**
     * @return the CaminhoImagemDedo10
     */
    public String getCaminhoImagemDedo10() {
        return CaminhoImagemDedo10;
    }

    /**
     * @param CaminhoImagemDedo10 the CaminhoImagemDedo10 to set
     */
    public void setCaminhoImagemDedo10(String CaminhoImagemDedo10) {
        this.CaminhoImagemDedo10 = CaminhoImagemDedo10;
    }

    /**
     * @return the UsuarioInsert
     */
    public String getUsuarioInsert() {
        return UsuarioInsert;
    }

    /**
     * @param UsuarioInsert the UsuarioInsert to set
     */
    public void setUsuarioInsert(String UsuarioInsert) {
        this.UsuarioInsert = UsuarioInsert;
    }

    /**
     * @return the DataInsert
     */
    public String getDataInsert() {
        return DataInsert;
    }

    /**
     * @param DataInsert the DataInsert to set
     */
    public void setDataInsert(String DataInsert) {
        this.DataInsert = DataInsert;
    }

    /**
     * @return the HorarioInsert
     */
    public String getHorarioInsert() {
        return HorarioInsert;
    }

    /**
     * @param HorarioInsert the HorarioInsert to set
     */
    public void setHorarioInsert(String HorarioInsert) {
        this.HorarioInsert = HorarioInsert;
    }

    /**
     * @return the UsuarioUp
     */
    public String getUsuarioUp() {
        return UsuarioUp;
    }

    /**
     * @param UsuarioUp the UsuarioUp to set
     */
    public void setUsuarioUp(String UsuarioUp) {
        this.UsuarioUp = UsuarioUp;
    }

    /**
     * @return the DataUp
     */
    public String getDataUp() {
        return DataUp;
    }

    /**
     * @param DataUp the DataUp to set
     */
    public void setDataUp(String DataUp) {
        this.DataUp = DataUp;
    }

    /**
     * @return the HorarioUp
     */
    public String getHorarioUp() {
        return HorarioUp;
    }

    /**
     * @param HorarioUp the HorarioUp to set
     */
    public void setHorarioUp(String HorarioUp) {
        this.HorarioUp = HorarioUp;
    }
}
