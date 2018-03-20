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
public class SS3PaiPsicoSocial {

    private int IdSS3;
    private int idPai;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String textoCEDEGEP;
    private String textoCRASCREAS;
    private String textoASSISTENCIA;
    private String textoDOCUMENTOCIVIL;
    private Date dataInclusaoPAI;
    private String tecnicoServicoSocial;
    private String tecnicoPsicologico;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public SS3PaiPsicoSocial(int IdSS3, int idPai, int idInternoCrc, String nomeInternoCrc, String textoCEDEGEP, String textoCRASCREAS, String textoASSISTENCIA, String textoDOCUMENTOCIVIL, Date dataInclusaoPAI, String tecnicoServicoSocial, String tecnicoPsicologico, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.IdSS3 = IdSS3;
        this.idPai = idPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.textoCEDEGEP = textoCEDEGEP;
        this.textoCRASCREAS = textoCRASCREAS;
        this.textoASSISTENCIA = textoASSISTENCIA;
        this.textoDOCUMENTOCIVIL = textoDOCUMENTOCIVIL;
        this.dataInclusaoPAI = dataInclusaoPAI;
        this.tecnicoServicoSocial = tecnicoServicoSocial;
        this.tecnicoPsicologico = tecnicoPsicologico;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public SS3PaiPsicoSocial() {
    }

    /**
     * @return the IdSS3
     */
    public int getIdSS3() {
        return IdSS3;
    }

    /**
     * @param IdSS3 the IdSS3 to set
     */
    public void setIdSS3(int IdSS3) {
        this.IdSS3 = IdSS3;
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
     * @return the textoCEDEGEP
     */
    public String getTextoCEDEGEP() {
        return textoCEDEGEP;
    }

    /**
     * @param textoCEDEGEP the textoCEDEGEP to set
     */
    public void setTextoCEDEGEP(String textoCEDEGEP) {
        this.textoCEDEGEP = textoCEDEGEP;
    }

    /**
     * @return the textoCRASCREAS
     */
    public String getTextoCRASCREAS() {
        return textoCRASCREAS;
    }

    /**
     * @param textoCRASCREAS the textoCRASCREAS to set
     */
    public void setTextoCRASCREAS(String textoCRASCREAS) {
        this.textoCRASCREAS = textoCRASCREAS;
    }

    /**
     * @return the textoASSISTENCIA
     */
    public String getTextoASSISTENCIA() {
        return textoASSISTENCIA;
    }

    /**
     * @param textoASSISTENCIA the textoASSISTENCIA to set
     */
    public void setTextoASSISTENCIA(String textoASSISTENCIA) {
        this.textoASSISTENCIA = textoASSISTENCIA;
    }

    /**
     * @return the textoDOCUMENTOCIVIL
     */
    public String getTextoDOCUMENTOCIVIL() {
        return textoDOCUMENTOCIVIL;
    }

    /**
     * @param textoDOCUMENTOCIVIL the textoDOCUMENTOCIVIL to set
     */
    public void setTextoDOCUMENTOCIVIL(String textoDOCUMENTOCIVIL) {
        this.textoDOCUMENTOCIVIL = textoDOCUMENTOCIVIL;
    }

    /**
     * @return the dataInclusaoPAI
     */
    public Date getDataInclusaoPAI() {
        return dataInclusaoPAI;
    }

    /**
     * @param dataInclusaoPAI the dataInclusaoPAI to set
     */
    public void setDataInclusaoPAI(Date dataInclusaoPAI) {
        this.dataInclusaoPAI = dataInclusaoPAI;
    }

    /**
     * @return the tecnicoServicoSocial
     */
    public String getTecnicoServicoSocial() {
        return tecnicoServicoSocial;
    }

    /**
     * @param tecnicoServicoSocial the tecnicoServicoSocial to set
     */
    public void setTecnicoServicoSocial(String tecnicoServicoSocial) {
        this.tecnicoServicoSocial = tecnicoServicoSocial;
    }

    /**
     * @return the tecnicoPsicologico
     */
    public String getTecnicoPsicologico() {
        return tecnicoPsicologico;
    }

    /**
     * @param tecnicoPsicologico the tecnicoPsicologico to set
     */
    public void setTecnicoPsicologico(String tecnicoPsicologico) {
        this.tecnicoPsicologico = tecnicoPsicologico;
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
