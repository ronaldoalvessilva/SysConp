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
public class Arma {

    private Integer idArma;
    private String serieArma;
    private String nCMArma;
    private Date dataCadastroArma;
    private String statusArma;
    private String descricaoArma;
    private Integer idGrupoArma;
    private String grupoArma;
    private String marcaArma;
    private String modeloArma;
    private String calibreArma;
    private String canoArma;
    private String numeroTirosArma;
    private String acabamentoArma;
    private String pesoArma;
    private String miraArma;
    private String alturaArma;
    private String larguraArma;
    private String comprimentoCanoArma;
    private String comprimentoTotalArma;
    private String dispositivoSegurancaArma;
    private String outrasCaracteristicasArma;
    private String registroArma;
    private String licencaArma;
    private Date dataLicencaArma;
    private String unidadeArma;
    private String localizacaoArma;
    private float custoArma;
    private String estoqueArma;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;
    private byte[] fotoArma;
    private byte[] qRCodeArma;
    private String textoQRCode;
    private Integer idQrCodeArma;
    private Integer idAcesArma;
    private int quantidade;
    private Integer idCodigoBarraArma;
    private byte[] codigoBarra;
    private Integer idArmaACE;
    private String descricaoAcessorio;
    private String observacao;        

    public Arma() {
    }

    public Arma(Integer idArma, String serieArma, String nCMArma, Date dataCadastroArma, String statusArma, String descricaoArma, Integer idGrupoArma, String grupoArma, String marcaArma, String modeloArma, String calibreArma, String canoArma, String numeroTirosArma, String acabamentoArma, String pesoArma, String miraArma, String alturaArma, String larguraArma, String comprimentoCanoArma, String comprimentoTotalArma, String dispositivoSegurancaArma, String outrasCaracteristicasArma, String registroArma, String licencaArma, Date dataLicencaArma, String unidadeArma, String localizacaoArma, float custoArma, String estoqueArma, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp, byte[] fotoArma, byte[] qRCodeArma, String textoQRCode, Integer idQrCodeArma, Integer idAcesArma, int quantidade, Integer idCodigoBarraArma, byte[] codigoBarra, Integer idArmaACE, String descricaoAcessorio, String observacao) {
        this.idArma = idArma;
        this.serieArma = serieArma;
        this.nCMArma = nCMArma;
        this.dataCadastroArma = dataCadastroArma;
        this.statusArma = statusArma;
        this.descricaoArma = descricaoArma;
        this.idGrupoArma = idGrupoArma;
        this.grupoArma = grupoArma;
        this.marcaArma = marcaArma;
        this.modeloArma = modeloArma;
        this.calibreArma = calibreArma;
        this.canoArma = canoArma;
        this.numeroTirosArma = numeroTirosArma;
        this.acabamentoArma = acabamentoArma;
        this.pesoArma = pesoArma;
        this.miraArma = miraArma;
        this.alturaArma = alturaArma;
        this.larguraArma = larguraArma;
        this.comprimentoCanoArma = comprimentoCanoArma;
        this.comprimentoTotalArma = comprimentoTotalArma;
        this.dispositivoSegurancaArma = dispositivoSegurancaArma;
        this.outrasCaracteristicasArma = outrasCaracteristicasArma;
        this.registroArma = registroArma;
        this.licencaArma = licencaArma;
        this.dataLicencaArma = dataLicencaArma;
        this.unidadeArma = unidadeArma;
        this.localizacaoArma = localizacaoArma;
        this.custoArma = custoArma;
        this.estoqueArma = estoqueArma;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
        this.fotoArma = fotoArma;
        this.qRCodeArma = qRCodeArma;
        this.textoQRCode = textoQRCode;
        this.idQrCodeArma = idQrCodeArma;
        this.idAcesArma = idAcesArma;
        this.quantidade = quantidade;
        this.idCodigoBarraArma = idCodigoBarraArma;
        this.codigoBarra = codigoBarra;
        this.idArmaACE = idArmaACE;
        this.descricaoAcessorio = descricaoAcessorio;
        this.observacao = observacao;
    }

    /**
     * @return the idArma
     */
    public Integer getIdArma() {
        return idArma;
    }

    /**
     * @param idArma the idArma to set
     */
    public void setIdArma(Integer idArma) {
        this.idArma = idArma;
    }

    /**
     * @return the serieArma
     */
    public String getSerieArma() {
        return serieArma;
    }

    /**
     * @param serieArma the serieArma to set
     */
    public void setSerieArma(String serieArma) {
        this.serieArma = serieArma;
    }

    /**
     * @return the nCMArma
     */
    public String getnCMArma() {
        return nCMArma;
    }

    /**
     * @param nCMArma the nCMArma to set
     */
    public void setnCMArma(String nCMArma) {
        this.nCMArma = nCMArma;
    }

    /**
     * @return the dataCadastroArma
     */
    public Date getDataCadastroArma() {
        return dataCadastroArma;
    }

    /**
     * @param dataCadastroArma the dataCadastroArma to set
     */
    public void setDataCadastroArma(Date dataCadastroArma) {
        this.dataCadastroArma = dataCadastroArma;
    }

    /**
     * @return the statusArma
     */
    public String getStatusArma() {
        return statusArma;
    }

    /**
     * @param statusArma the statusArma to set
     */
    public void setStatusArma(String statusArma) {
        this.statusArma = statusArma;
    }

    /**
     * @return the descricaoArma
     */
    public String getDescricaoArma() {
        return descricaoArma;
    }

    /**
     * @param descricaoArma the descricaoArma to set
     */
    public void setDescricaoArma(String descricaoArma) {
        this.descricaoArma = descricaoArma;
    }

    /**
     * @return the idGrupoArma
     */
    public Integer getIdGrupoArma() {
        return idGrupoArma;
    }

    /**
     * @param idGrupoArma the idGrupoArma to set
     */
    public void setIdGrupoArma(Integer idGrupoArma) {
        this.idGrupoArma = idGrupoArma;
    }

    /**
     * @return the grupoArma
     */
    public String getGrupoArma() {
        return grupoArma;
    }

    /**
     * @param grupoArma the grupoArma to set
     */
    public void setGrupoArma(String grupoArma) {
        this.grupoArma = grupoArma;
    }

    /**
     * @return the marcaArma
     */
    public String getMarcaArma() {
        return marcaArma;
    }

    /**
     * @param marcaArma the marcaArma to set
     */
    public void setMarcaArma(String marcaArma) {
        this.marcaArma = marcaArma;
    }

    /**
     * @return the modeloArma
     */
    public String getModeloArma() {
        return modeloArma;
    }

    /**
     * @param modeloArma the modeloArma to set
     */
    public void setModeloArma(String modeloArma) {
        this.modeloArma = modeloArma;
    }

    /**
     * @return the calibreArma
     */
    public String getCalibreArma() {
        return calibreArma;
    }

    /**
     * @param calibreArma the calibreArma to set
     */
    public void setCalibreArma(String calibreArma) {
        this.calibreArma = calibreArma;
    }

    /**
     * @return the canoArma
     */
    public String getCanoArma() {
        return canoArma;
    }

    /**
     * @param canoArma the canoArma to set
     */
    public void setCanoArma(String canoArma) {
        this.canoArma = canoArma;
    }

    /**
     * @return the numeroTirosArma
     */
    public String getNumeroTirosArma() {
        return numeroTirosArma;
    }

    /**
     * @param numeroTirosArma the numeroTirosArma to set
     */
    public void setNumeroTirosArma(String numeroTirosArma) {
        this.numeroTirosArma = numeroTirosArma;
    }

    /**
     * @return the acabamentoArma
     */
    public String getAcabamentoArma() {
        return acabamentoArma;
    }

    /**
     * @param acabamentoArma the acabamentoArma to set
     */
    public void setAcabamentoArma(String acabamentoArma) {
        this.acabamentoArma = acabamentoArma;
    }

    /**
     * @return the pesoArma
     */
    public String getPesoArma() {
        return pesoArma;
    }

    /**
     * @param pesoArma the pesoArma to set
     */
    public void setPesoArma(String pesoArma) {
        this.pesoArma = pesoArma;
    }

    /**
     * @return the miraArma
     */
    public String getMiraArma() {
        return miraArma;
    }

    /**
     * @param miraArma the miraArma to set
     */
    public void setMiraArma(String miraArma) {
        this.miraArma = miraArma;
    }

    /**
     * @return the alturaArma
     */
    public String getAlturaArma() {
        return alturaArma;
    }

    /**
     * @param alturaArma the alturaArma to set
     */
    public void setAlturaArma(String alturaArma) {
        this.alturaArma = alturaArma;
    }

    /**
     * @return the larguraArma
     */
    public String getLarguraArma() {
        return larguraArma;
    }

    /**
     * @param larguraArma the larguraArma to set
     */
    public void setLarguraArma(String larguraArma) {
        this.larguraArma = larguraArma;
    }

    /**
     * @return the comprimentoCanoArma
     */
    public String getComprimentoCanoArma() {
        return comprimentoCanoArma;
    }

    /**
     * @param comprimentoCanoArma the comprimentoCanoArma to set
     */
    public void setComprimentoCanoArma(String comprimentoCanoArma) {
        this.comprimentoCanoArma = comprimentoCanoArma;
    }

    /**
     * @return the comprimentoTotalArma
     */
    public String getComprimentoTotalArma() {
        return comprimentoTotalArma;
    }

    /**
     * @param comprimentoTotalArma the comprimentoTotalArma to set
     */
    public void setComprimentoTotalArma(String comprimentoTotalArma) {
        this.comprimentoTotalArma = comprimentoTotalArma;
    }

    /**
     * @return the dispositivoSegurancaArma
     */
    public String getDispositivoSegurancaArma() {
        return dispositivoSegurancaArma;
    }

    /**
     * @param dispositivoSegurancaArma the dispositivoSegurancaArma to set
     */
    public void setDispositivoSegurancaArma(String dispositivoSegurancaArma) {
        this.dispositivoSegurancaArma = dispositivoSegurancaArma;
    }

    /**
     * @return the outrasCaracteristicasArma
     */
    public String getOutrasCaracteristicasArma() {
        return outrasCaracteristicasArma;
    }

    /**
     * @param outrasCaracteristicasArma the outrasCaracteristicasArma to set
     */
    public void setOutrasCaracteristicasArma(String outrasCaracteristicasArma) {
        this.outrasCaracteristicasArma = outrasCaracteristicasArma;
    }

    /**
     * @return the registroArma
     */
    public String getRegistroArma() {
        return registroArma;
    }

    /**
     * @param registroArma the registroArma to set
     */
    public void setRegistroArma(String registroArma) {
        this.registroArma = registroArma;
    }

    /**
     * @return the licencaArma
     */
    public String getLicencaArma() {
        return licencaArma;
    }

    /**
     * @param licencaArma the licencaArma to set
     */
    public void setLicencaArma(String licencaArma) {
        this.licencaArma = licencaArma;
    }

    /**
     * @return the dataLicencaArma
     */
    public Date getDataLicencaArma() {
        return dataLicencaArma;
    }

    /**
     * @param dataLicencaArma the dataLicencaArma to set
     */
    public void setDataLicencaArma(Date dataLicencaArma) {
        this.dataLicencaArma = dataLicencaArma;
    }

    /**
     * @return the unidadeArma
     */
    public String getUnidadeArma() {
        return unidadeArma;
    }

    /**
     * @param unidadeArma the unidadeArma to set
     */
    public void setUnidadeArma(String unidadeArma) {
        this.unidadeArma = unidadeArma;
    }

    /**
     * @return the localizacaoArma
     */
    public String getLocalizacaoArma() {
        return localizacaoArma;
    }

    /**
     * @param localizacaoArma the localizacaoArma to set
     */
    public void setLocalizacaoArma(String localizacaoArma) {
        this.localizacaoArma = localizacaoArma;
    }

    /**
     * @return the custoArma
     */
    public float getCustoArma() {
        return custoArma;
    }

    /**
     * @param custoArma the custoArma to set
     */
    public void setCustoArma(float custoArma) {
        this.custoArma = custoArma;
    }

    /**
     * @return the estoqueArma
     */
    public String getEstoqueArma() {
        return estoqueArma;
    }

    /**
     * @param estoqueArma the estoqueArma to set
     */
    public void setEstoqueArma(String estoqueArma) {
        this.estoqueArma = estoqueArma;
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

    /**
     * @return the fotoArma
     */
    public byte[] getFotoArma() {
        return fotoArma;
    }

    /**
     * @param fotoArma the fotoArma to set
     */
    public void setFotoArma(byte[] fotoArma) {
        this.fotoArma = fotoArma;
    }

    /**
     * @return the qRCodeArma
     */
    public byte[] getqRCodeArma() {
        return qRCodeArma;
    }

    /**
     * @param qRCodeArma the qRCodeArma to set
     */
    public void setqRCodeArma(byte[] qRCodeArma) {
        this.qRCodeArma = qRCodeArma;
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
     * @return the idQrCodeArma
     */
    public Integer getIdQrCodeArma() {
        return idQrCodeArma;
    }

    /**
     * @param idQrCodeArma the idQrCodeArma to set
     */
    public void setIdQrCodeArma(Integer idQrCodeArma) {
        this.idQrCodeArma = idQrCodeArma;
    }

    /**
     * @return the idAcesArma
     */
    public Integer getIdAcesArma() {
        return idAcesArma;
    }

    /**
     * @param idAcesArma the idAcesArma to set
     */
    public void setIdAcesArma(Integer idAcesArma) {
        this.idAcesArma = idAcesArma;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the idCodigoBarraArma
     */
    public Integer getIdCodigoBarraArma() {
        return idCodigoBarraArma;
    }

    /**
     * @param idCodigoBarraArma the idCodigoBarraArma to set
     */
    public void setIdCodigoBarraArma(Integer idCodigoBarraArma) {
        this.idCodigoBarraArma = idCodigoBarraArma;
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
     * @return the idArmaACE
     */
    public Integer getIdArmaACE() {
        return idArmaACE;
    }

    /**
     * @param idArmaACE the idArmaACE to set
     */
    public void setIdArmaACE(Integer idArmaACE) {
        this.idArmaACE = idArmaACE;
    }

    /**
     * @return the descricaoAcessorio
     */
    public String getDescricaoAcessorio() {
        return descricaoAcessorio;
    }

    /**
     * @param descricaoAcessorio the descricaoAcessorio to set
     */
    public void setDescricaoAcessorio(String descricaoAcessorio) {
        this.descricaoAcessorio = descricaoAcessorio;
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
        final Arma other = (Arma) obj;
        if (!Objects.equals(this.idArma, other.idArma)) {
            return false;
        }
        if (!Objects.equals(this.idQrCodeArma, other.idQrCodeArma)) {
            return false;
        }
        if (!Objects.equals(this.idAcesArma, other.idAcesArma)) {
            return false;
        }
        if (!Objects.equals(this.idCodigoBarraArma, other.idCodigoBarraArma)) {
            return false;
        }
        if (!Objects.equals(this.idArmaACE, other.idArmaACE)) {
            return false;
        }
        return true;
    }
}
