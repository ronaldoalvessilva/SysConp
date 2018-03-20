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
public class ItensTransInterno {

    private int idTrans;
    private int idItemTrans;
    private String idSaidTransfTmp;
    private Date dataTrans;
    private Date dataRetorno;
    private String nomeOrigem;
    private String nomeDestino;
    private String documento;
    private int idInternoCrc;
    private String nomeInterno;
    private String nomeUnidade;
    private String confirmaSaida;
    private String internoEvadido;
    private int idItemCrcPortaria;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;       
    private byte[] assinaturaDigital;    

    public ItensTransInterno(int idTrans, int idItemTrans, String idSaidTransfTmp, Date dataTrans, Date dataRetorno, String nomeOrigem, String nomeDestino, String documento, int idInternoCrc, String nomeInterno, String nomeUnidade, String confirmaSaida, String internoEvadido, int idItemCrcPortaria, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, byte[] assinaturaDigital) {
        this.idTrans = idTrans;
        this.idItemTrans = idItemTrans;
        this.idSaidTransfTmp = idSaidTransfTmp;
        this.dataTrans = dataTrans;
        this.dataRetorno = dataRetorno;
        this.nomeOrigem = nomeOrigem;
        this.nomeDestino = nomeDestino;
        this.documento = documento;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.nomeUnidade = nomeUnidade;
        this.confirmaSaida = confirmaSaida;
        this.internoEvadido = internoEvadido;
        this.idItemCrcPortaria = idItemCrcPortaria;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.assinaturaDigital = assinaturaDigital;
    }

    public ItensTransInterno() {
    }

    /**
     * @return the idTrans
     */
    public int getIdTrans() {
        return idTrans;
    }

    /**
     * @param idTrans the idTrans to set
     */
    public void setIdTrans(int idTrans) {
        this.idTrans = idTrans;
    }

    /**
     * @return the idItemTrans
     */
    public int getIdItemTrans() {
        return idItemTrans;
    }

    /**
     * @param idItemTrans the idItemTrans to set
     */
    public void setIdItemTrans(int idItemTrans) {
        this.idItemTrans = idItemTrans;
    }

    /**
     * @return the idSaidTransfTmp
     */
    public String getIdSaidTransfTmp() {
        return idSaidTransfTmp;
    }

    /**
     * @param idSaidTransfTmp the idSaidTransfTmp to set
     */
    public void setIdSaidTransfTmp(String idSaidTransfTmp) {
        this.idSaidTransfTmp = idSaidTransfTmp;
    }

    /**
     * @return the dataTrans
     */
    public Date getDataTrans() {
        return dataTrans;
    }

    /**
     * @param dataTrans the dataTrans to set
     */
    public void setDataTrans(Date dataTrans) {
        this.dataTrans = dataTrans;
    }

    /**
     * @return the dataRetorno
     */
    public Date getDataRetorno() {
        return dataRetorno;
    }

    /**
     * @param dataRetorno the dataRetorno to set
     */
    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    /**
     * @return the nomeOrigem
     */
    public String getNomeOrigem() {
        return nomeOrigem;
    }

    /**
     * @param nomeOrigem the nomeOrigem to set
     */
    public void setNomeOrigem(String nomeOrigem) {
        this.nomeOrigem = nomeOrigem;
    }

    /**
     * @return the nomeDestino
     */
    public String getNomeDestino() {
        return nomeDestino;
    }

    /**
     * @param nomeDestino the nomeDestino to set
     */
    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
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
     * @return the nomeInterno
     */
    public String getNomeInterno() {
        return nomeInterno;
    }

    /**
     * @param nomeInterno the nomeInterno to set
     */
    public void setNomeInterno(String nomeInterno) {
        this.nomeInterno = nomeInterno;
    }

    /**
     * @return the nomeUnidade
     */
    public String getNomeUnidade() {
        return nomeUnidade;
    }

    /**
     * @param nomeUnidade the nomeUnidade to set
     */
    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    /**
     * @return the confirmaSaida
     */
    public String getConfirmaSaida() {
        return confirmaSaida;
    }

    /**
     * @param confirmaSaida the confirmaSaida to set
     */
    public void setConfirmaSaida(String confirmaSaida) {
        this.confirmaSaida = confirmaSaida;
    }

    /**
     * @return the internoEvadido
     */
    public String getInternoEvadido() {
        return internoEvadido;
    }

    /**
     * @param internoEvadido the internoEvadido to set
     */
    public void setInternoEvadido(String internoEvadido) {
        this.internoEvadido = internoEvadido;
    }

    /**
     * @return the idItemCrcPortaria
     */
    public int getIdItemCrcPortaria() {
        return idItemCrcPortaria;
    }

    /**
     * @param idItemCrcPortaria the idItemCrcPortaria to set
     */
    public void setIdItemCrcPortaria(int idItemCrcPortaria) {
        this.idItemCrcPortaria = idItemCrcPortaria;
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
     * @return the assinaturaDigital
     */
    public byte[] getAssinaturaDigital() {
        return assinaturaDigital;
    }

    /**
     * @param assinaturaDigital the assinaturaDigital to set
     */
    public void setAssinaturaDigital(byte[] assinaturaDigital) {
        this.assinaturaDigital = assinaturaDigital;
    }
}
