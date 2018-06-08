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
public class TransferenciaInternosPortaria {
    private int idSaida;
    private String idItemRegSaida;   
    private String idSaidTransfTmp;
    private Date dataSaida;
    private Date dataRetorno;
    private String nomeDestino;
    private String documento;
    private String idItemSaida;
    private int idItemCrcPortaria;
    private String cncPortaria;
    private String matriculaCrc;
    private int idInternoSaida;
    private String nomeInternoCrc;    
    private String nomeUnidade;
    private String horarioSaida;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String confirmaSaida;  
    private byte[] assinaturaDigital;       
    private int idItemCrcPort;  
    private String confirmaExp;
    private String confirmaImp;

    public TransferenciaInternosPortaria() {
    }

    public TransferenciaInternosPortaria(int idSaida, String idItemRegSaida, String idSaidTransfTmp, Date dataSaida, Date dataRetorno, String nomeDestino, String documento, String idItemSaida, int idItemCrcPortaria, String cncPortaria, String matriculaCrc, int idInternoSaida, String nomeInternoCrc, String nomeUnidade, String horarioSaida, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String confirmaSaida, byte[] assinaturaDigital, int idItemCrcPort, String confirmaExp, String confirmaImp) {
        this.idSaida = idSaida;
        this.idItemRegSaida = idItemRegSaida;
        this.idSaidTransfTmp = idSaidTransfTmp;
        this.dataSaida = dataSaida;
        this.dataRetorno = dataRetorno;
        this.nomeDestino = nomeDestino;
        this.documento = documento;
        this.idItemSaida = idItemSaida;
        this.idItemCrcPortaria = idItemCrcPortaria;
        this.cncPortaria = cncPortaria;
        this.matriculaCrc = matriculaCrc;
        this.idInternoSaida = idInternoSaida;
        this.nomeInternoCrc = nomeInternoCrc;
        this.nomeUnidade = nomeUnidade;
        this.horarioSaida = horarioSaida;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.confirmaSaida = confirmaSaida;
        this.assinaturaDigital = assinaturaDigital;
        this.idItemCrcPort = idItemCrcPort;
        this.confirmaExp = confirmaExp;
        this.confirmaImp = confirmaImp;
    }

    /**
     * @return the idSaida
     */
    public int getIdSaida() {
        return idSaida;
    }

    /**
     * @param idSaida the idSaida to set
     */
    public void setIdSaida(int idSaida) {
        this.idSaida = idSaida;
    }

    /**
     * @return the idItemRegSaida
     */
    public String getIdItemRegSaida() {
        return idItemRegSaida;
    }

    /**
     * @param idItemRegSaida the idItemRegSaida to set
     */
    public void setIdItemRegSaida(String idItemRegSaida) {
        this.idItemRegSaida = idItemRegSaida;
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
     * @return the idItemSaida
     */
    public String getIdItemSaida() {
        return idItemSaida;
    }

    /**
     * @param idItemSaida the idItemSaida to set
     */
    public void setIdItemSaida(String idItemSaida) {
        this.idItemSaida = idItemSaida;
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
     * @return the cncPortaria
     */
    public String getCncPortaria() {
        return cncPortaria;
    }

    /**
     * @param cncPortaria the cncPortaria to set
     */
    public void setCncPortaria(String cncPortaria) {
        this.cncPortaria = cncPortaria;
    }

    /**
     * @return the matriculaCrc
     */
    public String getMatriculaCrc() {
        return matriculaCrc;
    }

    /**
     * @param matriculaCrc the matriculaCrc to set
     */
    public void setMatriculaCrc(String matriculaCrc) {
        this.matriculaCrc = matriculaCrc;
    }

    /**
     * @return the idInternoSaida
     */
    public int getIdInternoSaida() {
        return idInternoSaida;
    }

    /**
     * @param idInternoSaida the idInternoSaida to set
     */
    public void setIdInternoSaida(int idInternoSaida) {
        this.idInternoSaida = idInternoSaida;
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
     * @return the horarioSaida
     */
    public String getHorarioSaida() {
        return horarioSaida;
    }

    /**
     * @param horarioSaida the horarioSaida to set
     */
    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
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

    /**
     * @return the idItemCrcPort
     */
    public int getIdItemCrcPort() {
        return idItemCrcPort;
    }

    /**
     * @param idItemCrcPort the idItemCrcPort to set
     */
    public void setIdItemCrcPort(int idItemCrcPort) {
        this.idItemCrcPort = idItemCrcPort;
    }

    /**
     * @return the confirmaExp
     */
    public String getConfirmaExp() {
        return confirmaExp;
    }

    /**
     * @param confirmaExp the confirmaExp to set
     */
    public void setConfirmaExp(String confirmaExp) {
        this.confirmaExp = confirmaExp;
    }

    /**
     * @return the confirmaImp
     */
    public String getConfirmaImp() {
        return confirmaImp;
    }

    /**
     * @param confirmaImp the confirmaImp to set
     */
    public void setConfirmaImp(String confirmaImp) {
        this.confirmaImp = confirmaImp;
    }
    
}
