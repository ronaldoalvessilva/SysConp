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
public class ProrrogarSaidaTemporariaPrisaoDomicilicar {

    private Integer idRegistro;
    private String statusRegistro;
    private Date dataRegistro;
    private String responsavel;
    private String tipoSaida;
    private String documento;
    private Date dataDocumento;
    private String observacao;
    //ABA INRERNOS
    private Integer idItem;
    private Integer idInternoPro;
    private String situacaoPro;
    private Integer idSaida;
    private String nomeInternoPro;
    private Date dataSaida;
    private String dataPrevisaoRetorno;
    private Date dataNova;
    private Integer idRetorno;
    private String nrDocRetorno;
    private String dataEvasao;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;

    public ProrrogarSaidaTemporariaPrisaoDomicilicar() {
    }

    public ProrrogarSaidaTemporariaPrisaoDomicilicar(Integer idRegistro, String statusRegistro, Date dataRegistro, String responsavel, String tipoSaida, String documento, Date dataDocumento, String observacao, Integer idItem, Integer idInternoPro, String situacaoPro, Integer idSaida, String nomeInternoPro, Date dataSaida, String dataPrevisaoRetorno, Date dataNova, Integer idRetorno, String nrDocRetorno, String dataEvasao, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp) {
        this.idRegistro = idRegistro;
        this.statusRegistro = statusRegistro;
        this.dataRegistro = dataRegistro;
        this.responsavel = responsavel;
        this.tipoSaida = tipoSaida;
        this.documento = documento;
        this.dataDocumento = dataDocumento;
        this.observacao = observacao;
        this.idItem = idItem;
        this.idInternoPro = idInternoPro;
        this.situacaoPro = situacaoPro;
        this.idSaida = idSaida;
        this.nomeInternoPro = nomeInternoPro;
        this.dataSaida = dataSaida;
        this.dataPrevisaoRetorno = dataPrevisaoRetorno;
        this.dataNova = dataNova;
        this.idRetorno = idRetorno;
        this.nrDocRetorno = nrDocRetorno;
        this.dataEvasao = dataEvasao;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idRegistro
     */
    public Integer getIdRegistro() {
        return idRegistro;
    }

    /**
     * @param idRegistro the idRegistro to set
     */
    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    /**
     * @return the statusRegistro
     */
    public String getStatusRegistro() {
        return statusRegistro;
    }

    /**
     * @param statusRegistro the statusRegistro to set
     */
    public void setStatusRegistro(String statusRegistro) {
        this.statusRegistro = statusRegistro;
    }

    /**
     * @return the dataRegistro
     */
    public Date getDataRegistro() {
        return dataRegistro;
    }

    /**
     * @param dataRegistro the dataRegistro to set
     */
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    /**
     * @return the responsavel
     */
    public String getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * @return the tipoSaida
     */
    public String getTipoSaida() {
        return tipoSaida;
    }

    /**
     * @param tipoSaida the tipoSaida to set
     */
    public void setTipoSaida(String tipoSaida) {
        this.tipoSaida = tipoSaida;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the dataDocumento
     */
    public Date getDataDocumento() {
        return dataDocumento;
    }

    /**
     * @param dataDocumento the dataDocumento to set
     */
    public void setDataDocumento(Date dataDocumento) {
        this.dataDocumento = dataDocumento;
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
     * @return the idItem
     */
    public Integer getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the idInternoPro
     */
    public Integer getIdInternoPro() {
        return idInternoPro;
    }

    /**
     * @param idInternoPro the idInternoPro to set
     */
    public void setIdInternoPro(Integer idInternoPro) {
        this.idInternoPro = idInternoPro;
    }

    /**
     * @return the situacaoPro
     */
    public String getSituacaoPro() {
        return situacaoPro;
    }

    /**
     * @param situacaoPro the situacaoPro to set
     */
    public void setSituacaoPro(String situacaoPro) {
        this.situacaoPro = situacaoPro;
    }

    /**
     * @return the idSaida
     */
    public Integer getIdSaida() {
        return idSaida;
    }

    /**
     * @param idSaida the idSaida to set
     */
    public void setIdSaida(Integer idSaida) {
        this.idSaida = idSaida;
    }

    /**
     * @return the nomeInternoPro
     */
    public String getNomeInternoPro() {
        return nomeInternoPro;
    }

    /**
     * @param nomeInternoPro the nomeInternoPro to set
     */
    public void setNomeInternoPro(String nomeInternoPro) {
        this.nomeInternoPro = nomeInternoPro;
    }

    /**
     * @return the dataSaida
     */
    public Date getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * @return the dataPrevisaoRetorno
     */
    public String getDataPrevisaoRetorno() {
        return dataPrevisaoRetorno;
    }

    /**
     * @param dataPrevisaoRetorno the dataPrevisaoRetorno to set
     */
    public void setDataPrevisaoRetorno(String dataPrevisaoRetorno) {
        this.dataPrevisaoRetorno = dataPrevisaoRetorno;
    }

    /**
     * @return the dataNova
     */
    public Date getDataNova() {
        return dataNova;
    }

    /**
     * @param dataNova the dataNova to set
     */
    public void setDataNova(Date dataNova) {
        this.dataNova = dataNova;
    }

    /**
     * @return the idRetorno
     */
    public Integer getIdRetorno() {
        return idRetorno;
    }

    /**
     * @param idRetorno the idRetorno to set
     */
    public void setIdRetorno(Integer idRetorno) {
        this.idRetorno = idRetorno;
    }

    /**
     * @return the nrDocRetorno
     */
    public String getNrDocRetorno() {
        return nrDocRetorno;
    }

    /**
     * @param nrDocRetorno the nrDocRetorno to set
     */
    public void setNrDocRetorno(String nrDocRetorno) {
        this.nrDocRetorno = nrDocRetorno;
    }

    /**
     * @return the dataEvasao
     */
    public String getDataEvasao() {
        return dataEvasao;
    }

    /**
     * @param dataEvasao the dataEvasao to set
     */
    public void setDataEvasao(String dataEvasao) {
        this.dataEvasao = dataEvasao;
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
