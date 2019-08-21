/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Ronaldo
 */
public class Advogados {

    private int idAdvogado;
    private String statusAdv;
    private Date dataCadastro;
    private String fotoAdvogado;
    private String nomeAdvogado;
    private String rgAdvogado;
    private String cpfAdvogado;
    private String oabAdvogado;
    private String obsAdvogado;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento; 
    private byte[] imagemFrenteAD;
    private String nomeMae;
    private String nomePai;
    private String situacaoCadastral;

    public Advogados() {
    }

    public Advogados(int idAdvogado, String statusAdv, Date dataCadastro, String fotoAdvogado, String nomeAdvogado, String rgAdvogado, String cpfAdvogado, String oabAdvogado, String obsAdvogado, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento, byte[] imagemFrenteAD, String nomeMae, String nomePai, String situacaoCadastral) {
        this.idAdvogado = idAdvogado;
        this.statusAdv = statusAdv;
        this.dataCadastro = dataCadastro;
        this.fotoAdvogado = fotoAdvogado;
        this.nomeAdvogado = nomeAdvogado;
        this.rgAdvogado = rgAdvogado;
        this.cpfAdvogado = cpfAdvogado;
        this.oabAdvogado = oabAdvogado;
        this.obsAdvogado = obsAdvogado;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.imagemFrenteAD = imagemFrenteAD;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.situacaoCadastral = situacaoCadastral;
    }

    /**
     * @return the idAdvogado
     */
    public int getIdAdvogado() {
        return idAdvogado;
    }

    /**
     * @param idAdvogado the idAdvogado to set
     */
    public void setIdAdvogado(int idAdvogado) {
        this.idAdvogado = idAdvogado;
    }

    /**
     * @return the statusAdv
     */
    public String getStatusAdv() {
        return statusAdv;
    }

    /**
     * @param statusAdv the statusAdv to set
     */
    public void setStatusAdv(String statusAdv) {
        this.statusAdv = statusAdv;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the fotoAdvogado
     */
    public String getFotoAdvogado() {
        return fotoAdvogado;
    }

    /**
     * @param fotoAdvogado the fotoAdvogado to set
     */
    public void setFotoAdvogado(String fotoAdvogado) {
        this.fotoAdvogado = fotoAdvogado;
    }

    /**
     * @return the nomeAdvogado
     */
    public String getNomeAdvogado() {
        return nomeAdvogado;
    }

    /**
     * @param nomeAdvogado the nomeAdvogado to set
     */
    public void setNomeAdvogado(String nomeAdvogado) {
        this.nomeAdvogado = nomeAdvogado;
    }

    /**
     * @return the rgAdvogado
     */
    public String getRgAdvogado() {
        return rgAdvogado;
    }

    /**
     * @param rgAdvogado the rgAdvogado to set
     */
    public void setRgAdvogado(String rgAdvogado) {
        this.rgAdvogado = rgAdvogado;
    }

    /**
     * @return the cpfAdvogado
     */
    public String getCpfAdvogado() {
        return cpfAdvogado;
    }

    /**
     * @param cpfAdvogado the cpfAdvogado to set
     */
    public void setCpfAdvogado(String cpfAdvogado) {
        this.cpfAdvogado = cpfAdvogado;
    }

    /**
     * @return the oabAdvogado
     */
    public String getOabAdvogado() {
        return oabAdvogado;
    }

    /**
     * @param oabAdvogado the oabAdvogado to set
     */
    public void setOabAdvogado(String oabAdvogado) {
        this.oabAdvogado = oabAdvogado;
    }

    /**
     * @return the obsAdvogado
     */
    public String getObsAdvogado() {
        return obsAdvogado;
    }

    /**
     * @param obsAdvogado the obsAdvogado to set
     */
    public void setObsAdvogado(String obsAdvogado) {
        this.obsAdvogado = obsAdvogado;
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
     * @return the imagemFrenteAD
     */
    public byte[] getImagemFrenteAD() {
        return imagemFrenteAD;
    }

    /**
     * @param imagemFrenteAD the imagemFrenteAD to set
     */
    public void setImagemFrenteAD(byte[] imagemFrenteAD) {
        this.imagemFrenteAD = imagemFrenteAD;
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

    /**
     * @return the nomePai
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * @param nomePai the nomePai to set
     */
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    /**
     * @return the situacaoCadastral
     */
    public String getSituacaoCadastral() {
        return situacaoCadastral;
    }

    /**
     * @param situacaoCadastral the situacaoCadastral to set
     */
    public void setSituacaoCadastral(String situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }
}
