/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronaldo.silva7
 */
public class FichaCadastroPaiEapi2 {

    private int idEAP2;
    private int idPai;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String aSSISTENCIA;
    private String dOCUMENTOCIVIL;
    private String eAPI2PAI;
    private String tecnicoServicoSocial;
    private String tecnicoPsicologico;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public FichaCadastroPaiEapi2(int idEAP2, int idPai, int idInternoCrc, String nomeInternoCrc, String aSSISTENCIA, String dOCUMENTOCIVIL, String eAPI2PAI, String tecnicoServicoSocial, String tecnicoPsicologico, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idEAP2 = idEAP2;
        this.idPai = idPai;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.aSSISTENCIA = aSSISTENCIA;
        this.dOCUMENTOCIVIL = dOCUMENTOCIVIL;
        this.eAPI2PAI = eAPI2PAI;
        this.tecnicoServicoSocial = tecnicoServicoSocial;
        this.tecnicoPsicologico = tecnicoPsicologico;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public FichaCadastroPaiEapi2() {
    }

    /**
     * @return the idEAP2
     */
    public int getIdEAP2() {
        return idEAP2;
    }

    /**
     * @param idEAP2 the idEAP2 to set
     */
    public void setIdEAP2(int idEAP2) {
        this.idEAP2 = idEAP2;
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
     * @return the aSSISTENCIA
     */
    public String getaSSISTENCIA() {
        return aSSISTENCIA;
    }

    /**
     * @param aSSISTENCIA the aSSISTENCIA to set
     */
    public void setaSSISTENCIA(String aSSISTENCIA) {
        this.aSSISTENCIA = aSSISTENCIA;
    }

    /**
     * @return the dOCUMENTOCIVIL
     */
    public String getdOCUMENTOCIVIL() {
        return dOCUMENTOCIVIL;
    }

    /**
     * @param dOCUMENTOCIVIL the dOCUMENTOCIVIL to set
     */
    public void setdOCUMENTOCIVIL(String dOCUMENTOCIVIL) {
        this.dOCUMENTOCIVIL = dOCUMENTOCIVIL;
    }

    /**
     * @return the eAPI2PAI
     */
    public String geteAPI2PAI() {
        return eAPI2PAI;
    }

    /**
     * @param eAPI2PAI the eAPI2PAI to set
     */
    public void seteAPI2PAI(String eAPI2PAI) {
        this.eAPI2PAI = eAPI2PAI;
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
