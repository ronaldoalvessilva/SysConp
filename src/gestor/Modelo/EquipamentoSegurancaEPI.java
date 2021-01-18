/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ronaldo.silva7
 */
public class EquipamentoSegurancaEPI {

    private Integer idEquipamento;
    private String statusEquipamento;
    private Date dataCadastroEquipamento;
    private String descricaoEquipamento;
    private String marcaEquipamento;
    private String modeloEquipamento;
    private String comprimentoEquipamento;
    private String tipoMaterialEquipamento;
    private Float pesoEquipamento;
    private String corEquipamento;
    private String observacao;
    private byte[] fotoEquipamento;
    private byte[] qRCodeEquipamento;
    private String textoQRCode;
    private Integer idQrCodeEquipamento;
    private Integer idCodigoBarraEquipamento;
    private byte[] codigoBarra;
    private String numeroCodigoBarras;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public EquipamentoSegurancaEPI() {
    }

    public EquipamentoSegurancaEPI(Integer idEquipamento, String statusEquipamento, Date dataCadastroEquipamento, String descricaoEquipamento, String marcaEquipamento, String modeloEquipamento, String comprimentoEquipamento, String tipoMaterialEquipamento, Float pesoEquipamento, String corEquipamento, String observacao, byte[] fotoEquipamento, byte[] qRCodeEquipamento, String textoQRCode, Integer idQrCodeEquipamento, Integer idCodigoBarraEquipamento, byte[] codigoBarra, String numeroCodigoBarras, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idEquipamento = idEquipamento;
        this.statusEquipamento = statusEquipamento;
        this.dataCadastroEquipamento = dataCadastroEquipamento;
        this.descricaoEquipamento = descricaoEquipamento;
        this.marcaEquipamento = marcaEquipamento;
        this.modeloEquipamento = modeloEquipamento;
        this.comprimentoEquipamento = comprimentoEquipamento;
        this.tipoMaterialEquipamento = tipoMaterialEquipamento;
        this.pesoEquipamento = pesoEquipamento;
        this.corEquipamento = corEquipamento;
        this.observacao = observacao;
        this.fotoEquipamento = fotoEquipamento;
        this.qRCodeEquipamento = qRCodeEquipamento;
        this.textoQRCode = textoQRCode;
        this.idQrCodeEquipamento = idQrCodeEquipamento;
        this.idCodigoBarraEquipamento = idCodigoBarraEquipamento;
        this.codigoBarra = codigoBarra;
        this.numeroCodigoBarras = numeroCodigoBarras;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idEquipamento
     */
    public Integer getIdEquipamento() {
        return idEquipamento;
    }

    /**
     * @param idEquipamento the idEquipamento to set
     */
    public void setIdEquipamento(Integer idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    /**
     * @return the statusEquipamento
     */
    public String getStatusEquipamento() {
        return statusEquipamento;
    }

    /**
     * @param statusEquipamento the statusEquipamento to set
     */
    public void setStatusEquipamento(String statusEquipamento) {
        this.statusEquipamento = statusEquipamento;
    }

    /**
     * @return the dataCadastroEquipamento
     */
    public Date getDataCadastroEquipamento() {
        return dataCadastroEquipamento;
    }

    /**
     * @param dataCadastroEquipamento the dataCadastroEquipamento to set
     */
    public void setDataCadastroEquipamento(Date dataCadastroEquipamento) {
        this.dataCadastroEquipamento = dataCadastroEquipamento;
    }

    /**
     * @return the descricaoEquipamento
     */
    public String getDescricaoEquipamento() {
        return descricaoEquipamento;
    }

    /**
     * @param descricaoEquipamento the descricaoEquipamento to set
     */
    public void setDescricaoEquipamento(String descricaoEquipamento) {
        this.descricaoEquipamento = descricaoEquipamento;
    }

    /**
     * @return the marcaEquipamento
     */
    public String getMarcaEquipamento() {
        return marcaEquipamento;
    }

    /**
     * @param marcaEquipamento the marcaEquipamento to set
     */
    public void setMarcaEquipamento(String marcaEquipamento) {
        this.marcaEquipamento = marcaEquipamento;
    }

    /**
     * @return the modeloEquipamento
     */
    public String getModeloEquipamento() {
        return modeloEquipamento;
    }

    /**
     * @param modeloEquipamento the modeloEquipamento to set
     */
    public void setModeloEquipamento(String modeloEquipamento) {
        this.modeloEquipamento = modeloEquipamento;
    }

    /**
     * @return the comprimentoEquipamento
     */
    public String getComprimentoEquipamento() {
        return comprimentoEquipamento;
    }

    /**
     * @param comprimentoEquipamento the comprimentoEquipamento to set
     */
    public void setComprimentoEquipamento(String comprimentoEquipamento) {
        this.comprimentoEquipamento = comprimentoEquipamento;
    }

    /**
     * @return the tipoMaterialEquipamento
     */
    public String getTipoMaterialEquipamento() {
        return tipoMaterialEquipamento;
    }

    /**
     * @param tipoMaterialEquipamento the tipoMaterialEquipamento to set
     */
    public void setTipoMaterialEquipamento(String tipoMaterialEquipamento) {
        this.tipoMaterialEquipamento = tipoMaterialEquipamento;
    }

    /**
     * @return the pesoEquipamento
     */
    public Float getPesoEquipamento() {
        return pesoEquipamento;
    }

    /**
     * @param pesoEquipamento the pesoEquipamento to set
     */
    public void setPesoEquipamento(Float pesoEquipamento) {
        this.pesoEquipamento = pesoEquipamento;
    }

    /**
     * @return the corEquipamento
     */
    public String getCorEquipamento() {
        return corEquipamento;
    }

    /**
     * @param corEquipamento the corEquipamento to set
     */
    public void setCorEquipamento(String corEquipamento) {
        this.corEquipamento = corEquipamento;
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
     * @return the fotoEquipamento
     */
    public byte[] getFotoEquipamento() {
        return fotoEquipamento;
    }

    /**
     * @param fotoEquipamento the fotoEquipamento to set
     */
    public void setFotoEquipamento(byte[] fotoEquipamento) {
        this.fotoEquipamento = fotoEquipamento;
    }

    /**
     * @return the qRCodeEquipamento
     */
    public byte[] getqRCodeEquipamento() {
        return qRCodeEquipamento;
    }

    /**
     * @param qRCodeEquipamento the qRCodeEquipamento to set
     */
    public void setqRCodeEquipamento(byte[] qRCodeEquipamento) {
        this.qRCodeEquipamento = qRCodeEquipamento;
    }

    /**
     * @return the textoQRCode
     */
    public String getTextoQRCode() {
        return textoQRCode;
    }

    /**
     * @param textoQRCode the textoQRCode to set
     */
    public void setTextoQRCode(String textoQRCode) {
        this.textoQRCode = textoQRCode;
    }

    /**
     * @return the idQrCodeEquipamento
     */
    public Integer getIdQrCodeEquipamento() {
        return idQrCodeEquipamento;
    }

    /**
     * @param idQrCodeEquipamento the idQrCodeEquipamento to set
     */
    public void setIdQrCodeEquipamento(Integer idQrCodeEquipamento) {
        this.idQrCodeEquipamento = idQrCodeEquipamento;
    }

    /**
     * @return the idCodigoBarraEquipamento
     */
    public Integer getIdCodigoBarraEquipamento() {
        return idCodigoBarraEquipamento;
    }

    /**
     * @param idCodigoBarraEquipamento the idCodigoBarraEquipamento to set
     */
    public void setIdCodigoBarraEquipamento(Integer idCodigoBarraEquipamento) {
        this.idCodigoBarraEquipamento = idCodigoBarraEquipamento;
    }

    /**
     * @return the codigoBarra
     */
    public byte[] getCodigoBarra() {
        return codigoBarra;
    }

    /**
     * @param codigoBarra the codigoBarra to set
     */
    public void setCodigoBarra(byte[] codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    /**
     * @return the numeroCodigoBarras
     */
    public String getNumeroCodigoBarras() {
        return numeroCodigoBarras;
    }

    /**
     * @param numeroCodigoBarras the numeroCodigoBarras to set
     */
    public void setNumeroCodigoBarras(String numeroCodigoBarras) {
        this.numeroCodigoBarras = numeroCodigoBarras;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.idEquipamento);
        hash = 41 * hash + Objects.hashCode(this.idQrCodeEquipamento);
        hash = 41 * hash + Objects.hashCode(this.idCodigoBarraEquipamento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EquipamentoSegurancaEPI other = (EquipamentoSegurancaEPI) obj;
        if (!Objects.equals(this.idEquipamento, other.idEquipamento)) {
            return false;
        }
        if (!Objects.equals(this.idQrCodeEquipamento, other.idQrCodeEquipamento)) {
            return false;
        }
        if (!Objects.equals(this.idCodigoBarraEquipamento, other.idCodigoBarraEquipamento)) {
            return false;
        }
        return true;
    }
}
