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
public class EscoltaInternosPSP {

    private int idEsco;
    private String statusEscolta;
    private Date dataRegistro;
    private int idFunc;
    private int idDepartamento;
    private String descricaoDepartamento;
    private String nomeColaborador;
    private String funcao;
    private String fotoColaborador;
    private byte [] imagemFrenteFunc;
    private byte [] biometriaDedo1;
    private byte [] biometriaDedo2;
    private byte [] biometriaDedo3;
    private byte [] biometriaDedo4;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private Date dataSaida;
    private String horaSaida;
    private Date dataEntrada;
    private String horaEntrada;
    private byte[] assinaturaColaboradorSaida;
    private byte[] assinaturaColaboradorEntrada;
    private byte[] assinaturaInternoSaida;
    private byte[] assinaturaInternoEntrada;
    private byte[] assinaturaColaboradorLiberadorSaida;
    private byte[] assinaturaColaboradorLiberadorRetorno;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;

    public EscoltaInternosPSP() {
    }

    public EscoltaInternosPSP(int idEsco, String statusEscolta, Date dataRegistro, int idFunc, int idDepartamento, String descricaoDepartamento, String nomeColaborador, String funcao, String fotoColaborador, byte[] imagemFrenteFunc, byte[] biometriaDedo1, byte[] biometriaDedo2, byte[] biometriaDedo3, byte[] biometriaDedo4, int idInternoCrc, String nomeInternoCrc, Date dataSaida, String horaSaida, Date dataEntrada, String horaEntrada, byte[] assinaturaColaboradorSaida, byte[] assinaturaColaboradorEntrada, byte[] assinaturaInternoSaida, byte[] assinaturaInternoEntrada, byte[] assinaturaColaboradorLiberadorSaida, byte[] assinaturaColaboradorLiberadorRetorno, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp) {
        this.idEsco = idEsco;
        this.statusEscolta = statusEscolta;
        this.dataRegistro = dataRegistro;
        this.idFunc = idFunc;
        this.idDepartamento = idDepartamento;
        this.descricaoDepartamento = descricaoDepartamento;
        this.nomeColaborador = nomeColaborador;
        this.funcao = funcao;
        this.fotoColaborador = fotoColaborador;
        this.imagemFrenteFunc = imagemFrenteFunc;
        this.biometriaDedo1 = biometriaDedo1;
        this.biometriaDedo2 = biometriaDedo2;
        this.biometriaDedo3 = biometriaDedo3;
        this.biometriaDedo4 = biometriaDedo4;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.dataSaida = dataSaida;
        this.horaSaida = horaSaida;
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
        this.assinaturaColaboradorSaida = assinaturaColaboradorSaida;
        this.assinaturaColaboradorEntrada = assinaturaColaboradorEntrada;
        this.assinaturaInternoSaida = assinaturaInternoSaida;
        this.assinaturaInternoEntrada = assinaturaInternoEntrada;
        this.assinaturaColaboradorLiberadorSaida = assinaturaColaboradorLiberadorSaida;
        this.assinaturaColaboradorLiberadorRetorno = assinaturaColaboradorLiberadorRetorno;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idEsco
     */
    public int getIdEsco() {
        return idEsco;
    }

    /**
     * @param idEsco the idEsco to set
     */
    public void setIdEsco(int idEsco) {
        this.idEsco = idEsco;
    }

    /**
     * @return the statusEscolta
     */
    public String getStatusEscolta() {
        return statusEscolta;
    }

    /**
     * @param statusEscolta the statusEscolta to set
     */
    public void setStatusEscolta(String statusEscolta) {
        this.statusEscolta = statusEscolta;
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
     * @return the idFunc
     */
    public int getIdFunc() {
        return idFunc;
    }

    /**
     * @param idFunc the idFunc to set
     */
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    /**
     * @return the idDepartamento
     */
    public int getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    /**
     * @return the descricaoDepartamento
     */
    public String getDescricaoDepartamento() {
        return descricaoDepartamento;
    }

    /**
     * @param descricaoDepartamento the descricaoDepartamento to set
     */
    public void setDescricaoDepartamento(String descricaoDepartamento) {
        this.descricaoDepartamento = descricaoDepartamento;
    }

    /**
     * @return the nomeColaborador
     */
    public String getNomeColaborador() {
        return nomeColaborador;
    }

    /**
     * @param nomeColaborador the nomeColaborador to set
     */
    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    /**
     * @return the funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * @return the fotoColaborador
     */
    public String getFotoColaborador() {
        return fotoColaborador;
    }

    /**
     * @param fotoColaborador the fotoColaborador to set
     */
    public void setFotoColaborador(String fotoColaborador) {
        this.fotoColaborador = fotoColaborador;
    }

    /**
     * @return the imagemFrenteFunc
     */
    public byte[] getImagemFrenteFunc() {
        return imagemFrenteFunc;
    }

    /**
     * @param imagemFrenteFunc the imagemFrenteFunc to set
     */
    public void setImagemFrenteFunc(byte[] imagemFrenteFunc) {
        this.imagemFrenteFunc = imagemFrenteFunc;
    }

    /**
     * @return the biometriaDedo1
     */
    public byte[] getBiometriaDedo1() {
        return biometriaDedo1;
    }

    /**
     * @param biometriaDedo1 the biometriaDedo1 to set
     */
    public void setBiometriaDedo1(byte[] biometriaDedo1) {
        this.biometriaDedo1 = biometriaDedo1;
    }

    /**
     * @return the biometriaDedo2
     */
    public byte[] getBiometriaDedo2() {
        return biometriaDedo2;
    }

    /**
     * @param biometriaDedo2 the biometriaDedo2 to set
     */
    public void setBiometriaDedo2(byte[] biometriaDedo2) {
        this.biometriaDedo2 = biometriaDedo2;
    }

    /**
     * @return the biometriaDedo3
     */
    public byte[] getBiometriaDedo3() {
        return biometriaDedo3;
    }

    /**
     * @param biometriaDedo3 the biometriaDedo3 to set
     */
    public void setBiometriaDedo3(byte[] biometriaDedo3) {
        this.biometriaDedo3 = biometriaDedo3;
    }

    /**
     * @return the biometriaDedo4
     */
    public byte[] getBiometriaDedo4() {
        return biometriaDedo4;
    }

    /**
     * @param biometriaDedo4 the biometriaDedo4 to set
     */
    public void setBiometriaDedo4(byte[] biometriaDedo4) {
        this.biometriaDedo4 = biometriaDedo4;
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
     * @return the horaSaida
     */
    public String getHoraSaida() {
        return horaSaida;
    }

    /**
     * @param horaSaida the horaSaida to set
     */
    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    /**
     * @return the dataEntrada
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the horaEntrada
     */
    public String getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * @return the assinaturaColaboradorSaida
     */
    public byte[] getAssinaturaColaboradorSaida() {
        return assinaturaColaboradorSaida;
    }

    /**
     * @param assinaturaColaboradorSaida the assinaturaColaboradorSaida to set
     */
    public void setAssinaturaColaboradorSaida(byte[] assinaturaColaboradorSaida) {
        this.assinaturaColaboradorSaida = assinaturaColaboradorSaida;
    }

    /**
     * @return the assinaturaColaboradorEntrada
     */
    public byte[] getAssinaturaColaboradorEntrada() {
        return assinaturaColaboradorEntrada;
    }

    /**
     * @param assinaturaColaboradorEntrada the assinaturaColaboradorEntrada to set
     */
    public void setAssinaturaColaboradorEntrada(byte[] assinaturaColaboradorEntrada) {
        this.assinaturaColaboradorEntrada = assinaturaColaboradorEntrada;
    }

    /**
     * @return the assinaturaInternoSaida
     */
    public byte[] getAssinaturaInternoSaida() {
        return assinaturaInternoSaida;
    }

    /**
     * @param assinaturaInternoSaida the assinaturaInternoSaida to set
     */
    public void setAssinaturaInternoSaida(byte[] assinaturaInternoSaida) {
        this.assinaturaInternoSaida = assinaturaInternoSaida;
    }

    /**
     * @return the assinaturaInternoEntrada
     */
    public byte[] getAssinaturaInternoEntrada() {
        return assinaturaInternoEntrada;
    }

    /**
     * @param assinaturaInternoEntrada the assinaturaInternoEntrada to set
     */
    public void setAssinaturaInternoEntrada(byte[] assinaturaInternoEntrada) {
        this.assinaturaInternoEntrada = assinaturaInternoEntrada;
    }

    /**
     * @return the assinaturaColaboradorLiberadorSaida
     */
    public byte[] getAssinaturaColaboradorLiberadorSaida() {
        return assinaturaColaboradorLiberadorSaida;
    }

    /**
     * @param assinaturaColaboradorLiberadorSaida the assinaturaColaboradorLiberadorSaida to set
     */
    public void setAssinaturaColaboradorLiberadorSaida(byte[] assinaturaColaboradorLiberadorSaida) {
        this.assinaturaColaboradorLiberadorSaida = assinaturaColaboradorLiberadorSaida;
    }

    /**
     * @return the assinaturaColaboradorLiberadorRetorno
     */
    public byte[] getAssinaturaColaboradorLiberadorRetorno() {
        return assinaturaColaboradorLiberadorRetorno;
    }

    /**
     * @param assinaturaColaboradorLiberadorRetorno the assinaturaColaboradorLiberadorRetorno to set
     */
    public void setAssinaturaColaboradorLiberadorRetorno(byte[] assinaturaColaboradorLiberadorRetorno) {
        this.assinaturaColaboradorLiberadorRetorno = assinaturaColaboradorLiberadorRetorno;
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
