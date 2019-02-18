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
public class RegistroAtendimentoInternos {

    private int idRegistro;
    private Date dataReg;
    private String horario;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String tipoAtemdimento;
    private int idDepartamento;
    private String nomeDepartamento;
    private byte[] assinaturaDigital; 
    private byte[] assinaturaLiberador; 
    private String atendido;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private Date dataAtendimento;    
    private int IdAtend;
    private int IdEvol;  
    private String atendeEvol;
    private String impressaoAuto;
    private int codigoFunc;
    private String nomeFunc;
    private String dataAssinatura;
    private String horaAssinatura;
    private String motivoImpressao;
    private int qtdAtend;
    private int qtd;

    public RegistroAtendimentoInternos() {
    }

    public RegistroAtendimentoInternos(int idRegistro, Date dataReg, String horario, int idInternoCrc, String nomeInternoCrc, String tipoAtemdimento, int idDepartamento, String nomeDepartamento, byte[] assinaturaDigital, byte[] assinaturaLiberador, String atendido, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, Date dataAtendimento, int IdAtend, int IdEvol, String atendeEvol, String impressaoAuto, int codigoFunc, String nomeFunc, String dataAssinatura, String horaAssinatura, String motivoImpressao, int qtdAtend, int qtd) {
        this.idRegistro = idRegistro;
        this.dataReg = dataReg;
        this.horario = horario;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.tipoAtemdimento = tipoAtemdimento;
        this.idDepartamento = idDepartamento;
        this.nomeDepartamento = nomeDepartamento;
        this.assinaturaDigital = assinaturaDigital;
        this.assinaturaLiberador = assinaturaLiberador;
        this.atendido = atendido;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.dataAtendimento = dataAtendimento;
        this.IdAtend = IdAtend;
        this.IdEvol = IdEvol;
        this.atendeEvol = atendeEvol;
        this.impressaoAuto = impressaoAuto;
        this.codigoFunc = codigoFunc;
        this.nomeFunc = nomeFunc;
        this.dataAssinatura = dataAssinatura;
        this.horaAssinatura = horaAssinatura;
        this.motivoImpressao = motivoImpressao;
        this.qtdAtend = qtdAtend;
        this.qtd = qtd;
    }

    /**
     * @return the idRegistro
     */
    public int getIdRegistro() {
        return idRegistro;
    }

    /**
     * @param idRegistro the idRegistro to set
     */
    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    /**
     * @return the dataReg
     */
    public Date getDataReg() {
        return dataReg;
    }

    /**
     * @param dataReg the dataReg to set
     */
    public void setDataReg(Date dataReg) {
        this.dataReg = dataReg;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
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
     * @return the tipoAtemdimento
     */
    public String getTipoAtemdimento() {
        return tipoAtemdimento;
    }

    /**
     * @param tipoAtemdimento the tipoAtemdimento to set
     */
    public void setTipoAtemdimento(String tipoAtemdimento) {
        this.tipoAtemdimento = tipoAtemdimento;
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
     * @return the nomeDepartamento
     */
    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    /**
     * @param nomeDepartamento the nomeDepartamento to set
     */
    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
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
     * @return the assinaturaLiberador
     */
    public byte[] getAssinaturaLiberador() {
        return assinaturaLiberador;
    }

    /**
     * @param assinaturaLiberador the assinaturaLiberador to set
     */
    public void setAssinaturaLiberador(byte[] assinaturaLiberador) {
        this.assinaturaLiberador = assinaturaLiberador;
    }

    /**
     * @return the atendido
     */
    public String getAtendido() {
        return atendido;
    }

    /**
     * @param atendido the atendido to set
     */
    public void setAtendido(String atendido) {
        this.atendido = atendido;
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

    /**
     * @return the dataAtendimento
     */
    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    /**
     * @param dataAtendimento the dataAtendimento to set
     */
    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    /**
     * @return the IdAtend
     */
    public int getIdAtend() {
        return IdAtend;
    }

    /**
     * @param IdAtend the IdAtend to set
     */
    public void setIdAtend(int IdAtend) {
        this.IdAtend = IdAtend;
    }

    /**
     * @return the IdEvol
     */
    public int getIdEvol() {
        return IdEvol;
    }

    /**
     * @param IdEvol the IdEvol to set
     */
    public void setIdEvol(int IdEvol) {
        this.IdEvol = IdEvol;
    }

    /**
     * @return the atendeEvol
     */
    public String getAtendeEvol() {
        return atendeEvol;
    }

    /**
     * @param atendeEvol the atendeEvol to set
     */
    public void setAtendeEvol(String atendeEvol) {
        this.atendeEvol = atendeEvol;
    }

    /**
     * @return the impressaoAuto
     */
    public String getImpressaoAuto() {
        return impressaoAuto;
    }

    /**
     * @param impressaoAuto the impressaoAuto to set
     */
    public void setImpressaoAuto(String impressaoAuto) {
        this.impressaoAuto = impressaoAuto;
    }

    /**
     * @return the codigoFunc
     */
    public int getCodigoFunc() {
        return codigoFunc;
    }

    /**
     * @param codigoFunc the codigoFunc to set
     */
    public void setCodigoFunc(int codigoFunc) {
        this.codigoFunc = codigoFunc;
    }

    /**
     * @return the nomeFunc
     */
    public String getNomeFunc() {
        return nomeFunc;
    }

    /**
     * @param nomeFunc the nomeFunc to set
     */
    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    /**
     * @return the dataAssinatura
     */
    public String getDataAssinatura() {
        return dataAssinatura;
    }

    /**
     * @param dataAssinatura the dataAssinatura to set
     */
    public void setDataAssinatura(String dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }

    /**
     * @return the horaAssinatura
     */
    public String getHoraAssinatura() {
        return horaAssinatura;
    }

    /**
     * @param horaAssinatura the horaAssinatura to set
     */
    public void setHoraAssinatura(String horaAssinatura) {
        this.horaAssinatura = horaAssinatura;
    }

    /**
     * @return the motivoImpressao
     */
    public String getMotivoImpressao() {
        return motivoImpressao;
    }

    /**
     * @param motivoImpressao the motivoImpressao to set
     */
    public void setMotivoImpressao(String motivoImpressao) {
        this.motivoImpressao = motivoImpressao;
    }

    /**
     * @return the qtdAtend
     */
    public int getQtdAtend() {
        return qtdAtend;
    }

    /**
     * @param qtdAtend the qtdAtend to set
     */
    public void setQtdAtend(int qtdAtend) {
        this.qtdAtend = qtdAtend;
    }

    /**
     * @return the qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param qtd the qtd to set
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
