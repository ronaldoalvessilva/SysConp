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
public class AlertaVisitasPortariaPavilhoes {

    private int idRegAlerta;
    private int idRegistroAD;
    private int idRegistroVI;
    private int idRegistroOF;
    private Date dataChegada;
    private String horaChegada;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int idVisita;
    private String nomeVisita;
    private int idAdvogado;
    private String nomeAdvogado;
    private int idOficial;
    private String nomeOficial;
    private String confirmacao;
    private int idPav;
    private String descricaoPavilhao;
    private byte[] assinaturaDigitalVisita;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public AlertaVisitasPortariaPavilhoes() {
    }

    public AlertaVisitasPortariaPavilhoes(int idRegAlerta, int idRegistroAD, int idRegistroVI, int idRegistroOF, Date dataChegada, String horaChegada, int idInternoCrc, String nomeInternoCrc, int idVisita, String nomeVisita, int idAdvogado, String nomeAdvogado, int idOficial, String nomeOficial, String confirmacao, int idPav, String descricaoPavilhao, byte[] assinaturaDigitalVisita, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idRegAlerta = idRegAlerta;
        this.idRegistroAD = idRegistroAD;
        this.idRegistroVI = idRegistroVI;
        this.idRegistroOF = idRegistroOF;
        this.dataChegada = dataChegada;
        this.horaChegada = horaChegada;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idVisita = idVisita;
        this.nomeVisita = nomeVisita;
        this.idAdvogado = idAdvogado;
        this.nomeAdvogado = nomeAdvogado;
        this.idOficial = idOficial;
        this.nomeOficial = nomeOficial;
        this.confirmacao = confirmacao;
        this.idPav = idPav;
        this.descricaoPavilhao = descricaoPavilhao;
        this.assinaturaDigitalVisita = assinaturaDigitalVisita;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idRegAlerta
     */
    public int getIdRegAlerta() {
        return idRegAlerta;
    }

    /**
     * @param idRegAlerta the idRegAlerta to set
     */
    public void setIdRegAlerta(int idRegAlerta) {
        this.idRegAlerta = idRegAlerta;
    }

    /**
     * @return the idRegistroAD
     */
    public int getIdRegistroAD() {
        return idRegistroAD;
    }

    /**
     * @param idRegistroAD the idRegistroAD to set
     */
    public void setIdRegistroAD(int idRegistroAD) {
        this.idRegistroAD = idRegistroAD;
    }

    /**
     * @return the idRegistroVI
     */
    public int getIdRegistroVI() {
        return idRegistroVI;
    }

    /**
     * @param idRegistroVI the idRegistroVI to set
     */
    public void setIdRegistroVI(int idRegistroVI) {
        this.idRegistroVI = idRegistroVI;
    }

    /**
     * @return the idRegistroOF
     */
    public int getIdRegistroOF() {
        return idRegistroOF;
    }

    /**
     * @param idRegistroOF the idRegistroOF to set
     */
    public void setIdRegistroOF(int idRegistroOF) {
        this.idRegistroOF = idRegistroOF;
    }

    /**
     * @return the dataChegada
     */
    public Date getDataChegada() {
        return dataChegada;
    }

    /**
     * @param dataChegada the dataChegada to set
     */
    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    /**
     * @return the horaChegada
     */
    public String getHoraChegada() {
        return horaChegada;
    }

    /**
     * @param horaChegada the horaChegada to set
     */
    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
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
     * @return the idVisita
     */
    public int getIdVisita() {
        return idVisita;
    }

    /**
     * @param idVisita the idVisita to set
     */
    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    /**
     * @return the nomeVisita
     */
    public String getNomeVisita() {
        return nomeVisita;
    }

    /**
     * @param nomeVisita the nomeVisita to set
     */
    public void setNomeVisita(String nomeVisita) {
        this.nomeVisita = nomeVisita;
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
     * @return the idOficial
     */
    public int getIdOficial() {
        return idOficial;
    }

    /**
     * @param idOficial the idOficial to set
     */
    public void setIdOficial(int idOficial) {
        this.idOficial = idOficial;
    }

    /**
     * @return the nomeOficial
     */
    public String getNomeOficial() {
        return nomeOficial;
    }

    /**
     * @param nomeOficial the nomeOficial to set
     */
    public void setNomeOficial(String nomeOficial) {
        this.nomeOficial = nomeOficial;
    }

    /**
     * @return the confirmacao
     */
    public String getConfirmacao() {
        return confirmacao;
    }

    /**
     * @param confirmacao the confirmacao to set
     */
    public void setConfirmacao(String confirmacao) {
        this.confirmacao = confirmacao;
    }

    /**
     * @return the idPav
     */
    public int getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(int idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the descricaoPavilhao
     */
    public String getDescricaoPavilhao() {
        return descricaoPavilhao;
    }

    /**
     * @param descricaoPavilhao the descricaoPavilhao to set
     */
    public void setDescricaoPavilhao(String descricaoPavilhao) {
        this.descricaoPavilhao = descricaoPavilhao;
    }

    /**
     * @return the assinaturaDigitalVisita
     */
    public byte[] getAssinaturaDigitalVisita() {
        return assinaturaDigitalVisita;
    }

    /**
     * @param assinaturaDigitalVisita the assinaturaDigitalVisita to set
     */
    public void setAssinaturaDigitalVisita(byte[] assinaturaDigitalVisita) {
        this.assinaturaDigitalVisita = assinaturaDigitalVisita;
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
