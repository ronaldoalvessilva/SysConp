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
public class VisitasDiversas {

    private int IdVisita;
    private Date DataCadastro;
    private String FotoVisita;
    private String NomeVisita;
    private String RgVisita;
    private String CpfVisita;
    private String cnhVisita;
    private String classeVisita;
    private String ObsVisita;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;  
    private String tipoVisita;
    private byte[] imagemFrenteVD;
    private String nomeMae;

    public VisitasDiversas() {
    }

    public VisitasDiversas(int IdVisita, Date DataCadastro, String FotoVisita, String NomeVisita, String RgVisita, String CpfVisita, String cnhVisita, String classeVisita, String ObsVisita, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento, String tipoVisita, byte[] imagemFrenteVD, String nomeMae) {
        this.IdVisita = IdVisita;
        this.DataCadastro = DataCadastro;
        this.FotoVisita = FotoVisita;
        this.NomeVisita = NomeVisita;
        this.RgVisita = RgVisita;
        this.CpfVisita = CpfVisita;
        this.cnhVisita = cnhVisita;
        this.classeVisita = classeVisita;
        this.ObsVisita = ObsVisita;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.tipoVisita = tipoVisita;
        this.imagemFrenteVD = imagemFrenteVD;
        this.nomeMae = nomeMae;
    }

    /**
     * @return the IdVisita
     */
    public int getIdVisita() {
        return IdVisita;
    }

    /**
     * @param IdVisita the IdVisita to set
     */
    public void setIdVisita(int IdVisita) {
        this.IdVisita = IdVisita;
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
     * @return the FotoVisita
     */
    public String getFotoVisita() {
        return FotoVisita;
    }

    /**
     * @param FotoVisita the FotoVisita to set
     */
    public void setFotoVisita(String FotoVisita) {
        this.FotoVisita = FotoVisita;
    }

    /**
     * @return the NomeVisita
     */
    public String getNomeVisita() {
        return NomeVisita;
    }

    /**
     * @param NomeVisita the NomeVisita to set
     */
    public void setNomeVisita(String NomeVisita) {
        this.NomeVisita = NomeVisita;
    }

    /**
     * @return the RgVisita
     */
    public String getRgVisita() {
        return RgVisita;
    }

    /**
     * @param RgVisita the RgVisita to set
     */
    public void setRgVisita(String RgVisita) {
        this.RgVisita = RgVisita;
    }

    /**
     * @return the CpfVisita
     */
    public String getCpfVisita() {
        return CpfVisita;
    }

    /**
     * @param CpfVisita the CpfVisita to set
     */
    public void setCpfVisita(String CpfVisita) {
        this.CpfVisita = CpfVisita;
    }

    /**
     * @return the cnhVisita
     */
    public String getCnhVisita() {
        return cnhVisita;
    }

    /**
     * @param cnhVisita the cnhVisita to set
     */
    public void setCnhVisita(String cnhVisita) {
        this.cnhVisita = cnhVisita;
    }

    /**
     * @return the classeVisita
     */
    public String getClasseVisita() {
        return classeVisita;
    }

    /**
     * @param classeVisita the classeVisita to set
     */
    public void setClasseVisita(String classeVisita) {
        this.classeVisita = classeVisita;
    }

    /**
     * @return the ObsVisita
     */
    public String getObsVisita() {
        return ObsVisita;
    }

    /**
     * @param ObsVisita the ObsVisita to set
     */
    public void setObsVisita(String ObsVisita) {
        this.ObsVisita = ObsVisita;
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

    /**
     * @return the tipoVisita
     */
    public String getTipoVisita() {
        return tipoVisita;
    }

    /**
     * @param tipoVisita the tipoVisita to set
     */
    public void setTipoVisita(String tipoVisita) {
        this.tipoVisita = tipoVisita;
    }

    /**
     * @return the imagemFrenteVD
     */
    public byte[] getImagemFrenteVD() {
        return imagemFrenteVD;
    }

    /**
     * @param imagemFrenteVD the imagemFrenteVD to set
     */
    public void setImagemFrenteVD(byte[] imagemFrenteVD) {
        this.imagemFrenteVD = imagemFrenteVD;
    }

    /**
     * @return the nomeMae
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * @param nomeMae the nomeMae to set
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }
}
