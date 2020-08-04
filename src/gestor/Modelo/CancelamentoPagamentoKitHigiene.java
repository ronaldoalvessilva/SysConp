/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronaldo.silva7
 */
public class CancelamentoPagamentoKitHigiene {

    private Integer idRegistro;
    private String statusRegistro;
    private Date dataRegistro;
    private Integer idPav;
    private String descricaoPav;
    private Integer idCela;
    private String descricaoCela;
    private Integer idKit;
    private String tipoKit;
    private Integer idRegistroKit;
    private Date dataRegistroKit;
    private String motivoCancelamento;
    private Integer idInternoKit;
    private String matriculaInterno;
    private String regimeInterno;
    private String nomeInternoKit;
    private Integer item;
    private Integer codigoProduto;
    private String descricaoProduto;
    private String unidadeProduto;
    private String quantidadeProduto;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;      
    private String horarioUp;        

    public CancelamentoPagamentoKitHigiene() {
    }

    public CancelamentoPagamentoKitHigiene(Integer idRegistro, String statusRegistro, Date dataRegistro, Integer idPav, String descricaoPav, Integer idCela, String descricaoCela, Integer idKit, String tipoKit, Integer idRegistroKit, Date dataRegistroKit, String motivoCancelamento, Integer idInternoKit, String matriculaInterno, String regimeInterno, String nomeInternoKit, Integer item, Integer codigoProduto, String descricaoProduto, String unidadeProduto, String quantidadeProduto, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idRegistro = idRegistro;
        this.statusRegistro = statusRegistro;
        this.dataRegistro = dataRegistro;
        this.idPav = idPav;
        this.descricaoPav = descricaoPav;
        this.idCela = idCela;
        this.descricaoCela = descricaoCela;
        this.idKit = idKit;
        this.tipoKit = tipoKit;
        this.idRegistroKit = idRegistroKit;
        this.dataRegistroKit = dataRegistroKit;
        this.motivoCancelamento = motivoCancelamento;
        this.idInternoKit = idInternoKit;
        this.matriculaInterno = matriculaInterno;
        this.regimeInterno = regimeInterno;
        this.nomeInternoKit = nomeInternoKit;
        this.item = item;
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.unidadeProduto = unidadeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
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
     * @return the idPav
     */
    public Integer getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(Integer idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the descricaoPav
     */
    public String getDescricaoPav() {
        return descricaoPav;
    }

    /**
     * @param descricaoPav the descricaoPav to set
     */
    public void setDescricaoPav(String descricaoPav) {
        this.descricaoPav = descricaoPav;
    }

    /**
     * @return the idCela
     */
    public Integer getIdCela() {
        return idCela;
    }

    /**
     * @param idCela the idCela to set
     */
    public void setIdCela(Integer idCela) {
        this.idCela = idCela;
    }

    /**
     * @return the descricaoCela
     */
    public String getDescricaoCela() {
        return descricaoCela;
    }

    /**
     * @param descricaoCela the descricaoCela to set
     */
    public void setDescricaoCela(String descricaoCela) {
        this.descricaoCela = descricaoCela;
    }

    /**
     * @return the idKit
     */
    public Integer getIdKit() {
        return idKit;
    }

    /**
     * @param idKit the idKit to set
     */
    public void setIdKit(Integer idKit) {
        this.idKit = idKit;
    }

    /**
     * @return the tipoKit
     */
    public String getTipoKit() {
        return tipoKit;
    }

    /**
     * @param tipoKit the tipoKit to set
     */
    public void setTipoKit(String tipoKit) {
        this.tipoKit = tipoKit;
    }

    /**
     * @return the idRegistroKit
     */
    public Integer getIdRegistroKit() {
        return idRegistroKit;
    }

    /**
     * @param idRegistroKit the idRegistroKit to set
     */
    public void setIdRegistroKit(Integer idRegistroKit) {
        this.idRegistroKit = idRegistroKit;
    }

    /**
     * @return the dataRegistroKit
     */
    public Date getDataRegistroKit() {
        return dataRegistroKit;
    }

    /**
     * @param dataRegistroKit the dataRegistroKit to set
     */
    public void setDataRegistroKit(Date dataRegistroKit) {
        this.dataRegistroKit = dataRegistroKit;
    }

    /**
     * @return the motivoCancelamento
     */
    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    /**
     * @param motivoCancelamento the motivoCancelamento to set
     */
    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    /**
     * @return the idInternoKit
     */
    public Integer getIdInternoKit() {
        return idInternoKit;
    }

    /**
     * @param idInternoKit the idInternoKit to set
     */
    public void setIdInternoKit(Integer idInternoKit) {
        this.idInternoKit = idInternoKit;
    }

    /**
     * @return the matriculaInterno
     */
    public String getMatriculaInterno() {
        return matriculaInterno;
    }

    /**
     * @param matriculaInterno the matriculaInterno to set
     */
    public void setMatriculaInterno(String matriculaInterno) {
        this.matriculaInterno = matriculaInterno;
    }

    /**
     * @return the regimeInterno
     */
    public String getRegimeInterno() {
        return regimeInterno;
    }

    /**
     * @param regimeInterno the regimeInterno to set
     */
    public void setRegimeInterno(String regimeInterno) {
        this.regimeInterno = regimeInterno;
    }

    /**
     * @return the nomeInternoKit
     */
    public String getNomeInternoKit() {
        return nomeInternoKit;
    }

    /**
     * @param nomeInternoKit the nomeInternoKit to set
     */
    public void setNomeInternoKit(String nomeInternoKit) {
        this.nomeInternoKit = nomeInternoKit;
    }

    /**
     * @return the item
     */
    public Integer getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Integer item) {
        this.item = item;
    }

    /**
     * @return the codigoProduto
     */
    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * @param codigoProduto the codigoProduto to set
     */
    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    /**
     * @return the unidadeProduto
     */
    public String getUnidadeProduto() {
        return unidadeProduto;
    }

    /**
     * @param unidadeProduto the unidadeProduto to set
     */
    public void setUnidadeProduto(String unidadeProduto) {
        this.unidadeProduto = unidadeProduto;
    }

    /**
     * @return the quantidadeProduto
     */
    public String getQuantidadeProduto() {
        return quantidadeProduto;
    }

    /**
     * @param quantidadeProduto the quantidadeProduto to set
     */
    public void setQuantidadeProduto(String quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
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
