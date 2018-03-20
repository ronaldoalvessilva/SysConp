/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronaldo
 */
public class AgendaRecados {

    private Integer idLanc;
    private Date dataLanc;
    private String horario;
    private String statusAgena;
    private Integer idUsuario;
    private String nomeUsuarioLogado;
    private String nomeUsuario;
    private String recados;  
    private String mensagemEnviada;
    private String mensagemRecebida;  

    public AgendaRecados(Integer idLanc, Date dataLanc, String horario, String statusAgena, Integer idUsuario, String nomeUsuarioLogado, String nomeUsuario, String recados, String mensagemEnviada, String mensagemRecebida) {
        this.idLanc = idLanc;
        this.dataLanc = dataLanc;
        this.horario = horario;
        this.statusAgena = statusAgena;
        this.idUsuario = idUsuario;
        this.nomeUsuarioLogado = nomeUsuarioLogado;
        this.nomeUsuario = nomeUsuario;
        this.recados = recados;
        this.mensagemEnviada = mensagemEnviada;
        this.mensagemRecebida = mensagemRecebida;
    }

    public AgendaRecados() {
    }

    /**
     * @return the idLanc
     */
    public Integer getIdLanc() {
        return idLanc;
    }

    /**
     * @param idLanc the idLanc to set
     */
    public void setIdLanc(Integer idLanc) {
        this.idLanc = idLanc;
    }

    /**
     * @return the dataLanc
     */
    public Date getDataLanc() {
        return dataLanc;
    }

    /**
     * @param dataLanc the dataLanc to set
     */
    public void setDataLanc(Date dataLanc) {
        this.dataLanc = dataLanc;
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
     * @return the statusAgena
     */
    public String getStatusAgena() {
        return statusAgena;
    }

    /**
     * @param statusAgena the statusAgena to set
     */
    public void setStatusAgena(String statusAgena) {
        this.statusAgena = statusAgena;
    }

    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the nomeUsuarioLogado
     */
    public String getNomeUsuarioLogado() {
        return nomeUsuarioLogado;
    }

    /**
     * @param nomeUsuarioLogado the nomeUsuarioLogado to set
     */
    public void setNomeUsuarioLogado(String nomeUsuarioLogado) {
        this.nomeUsuarioLogado = nomeUsuarioLogado;
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * @return the recados
     */
    public String getRecados() {
        return recados;
    }

    /**
     * @param recados the recados to set
     */
    public void setRecados(String recados) {
        this.recados = recados;
    }

    /**
     * @return the mensagemEnviada
     */
    public String getMensagemEnviada() {
        return mensagemEnviada;
    }

    /**
     * @param mensagemEnviada the mensagemEnviada to set
     */
    public void setMensagemEnviada(String mensagemEnviada) {
        this.mensagemEnviada = mensagemEnviada;
    }

    /**
     * @return the mensagemRecebida
     */
    public String getMensagemRecebida() {
        return mensagemRecebida;
    }

    /**
     * @param mensagemRecebida the mensagemRecebida to set
     */
    public void setMensagemRecebida(String mensagemRecebida) {
        this.mensagemRecebida = mensagemRecebida;
    }
}
