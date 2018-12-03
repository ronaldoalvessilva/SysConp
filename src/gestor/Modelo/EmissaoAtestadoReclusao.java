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
public class EmissaoAtestadoReclusao {

    private int idAtestado;
    private int codRegAux;
    private String utilizadoCrc;
    private String statusAtestado;
    private String classAtestado;
    private Date dataAtestado;
    private int idVisitaAtestado;
    private String nomeSolicitanteAtestado;
    private int idInternoAtestado;
    private String nomeInternoAtestado;
    private String textoAtestado;
    private String utilizacao;
    private int idColaborador;
    private String nomeColaborador;
    private Date dataLiberacao;
    private String dataAssinatura;
    private String horarioLiberacao;
    private byte [] AssinaturaColaborador;
    private byte [] validadorDados;
    private byte[] chaveInterno;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String horarioInsert;
    private String dataUp;
    private String horarioUp;

    public EmissaoAtestadoReclusao() {
    }

    public EmissaoAtestadoReclusao(int idAtestado, int codRegAux, String utilizadoCrc, String statusAtestado, String classAtestado, Date dataAtestado, int idVisitaAtestado, String nomeSolicitanteAtestado, int idInternoAtestado, String nomeInternoAtestado, String textoAtestado, String utilizacao, int idColaborador, String nomeColaborador, Date dataLiberacao, String dataAssinatura, String horarioLiberacao, byte[] AssinaturaColaborador, byte[] validadorDados, byte[] chaveInterno, String usuarioInsert, String usuarioUp, String dataInsert, String horarioInsert, String dataUp, String horarioUp) {
        this.idAtestado = idAtestado;
        this.codRegAux = codRegAux;
        this.utilizadoCrc = utilizadoCrc;
        this.statusAtestado = statusAtestado;
        this.classAtestado = classAtestado;
        this.dataAtestado = dataAtestado;
        this.idVisitaAtestado = idVisitaAtestado;
        this.nomeSolicitanteAtestado = nomeSolicitanteAtestado;
        this.idInternoAtestado = idInternoAtestado;
        this.nomeInternoAtestado = nomeInternoAtestado;
        this.textoAtestado = textoAtestado;
        this.utilizacao = utilizacao;
        this.idColaborador = idColaborador;
        this.nomeColaborador = nomeColaborador;
        this.dataLiberacao = dataLiberacao;
        this.dataAssinatura = dataAssinatura;
        this.horarioLiberacao = horarioLiberacao;
        this.AssinaturaColaborador = AssinaturaColaborador;
        this.validadorDados = validadorDados;
        this.chaveInterno = chaveInterno;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idAtestado
     */
    public int getIdAtestado() {
        return idAtestado;
    }

    /**
     * @param idAtestado the idAtestado to set
     */
    public void setIdAtestado(int idAtestado) {
        this.idAtestado = idAtestado;
    }

    /**
     * @return the codRegAux
     */
    public int getCodRegAux() {
        return codRegAux;
    }

    /**
     * @param codRegAux the codRegAux to set
     */
    public void setCodRegAux(int codRegAux) {
        this.codRegAux = codRegAux;
    }

    /**
     * @return the utilizadoCrc
     */
    public String getUtilizadoCrc() {
        return utilizadoCrc;
    }

    /**
     * @param utilizadoCrc the utilizadoCrc to set
     */
    public void setUtilizadoCrc(String utilizadoCrc) {
        this.utilizadoCrc = utilizadoCrc;
    }

    /**
     * @return the statusAtestado
     */
    public String getStatusAtestado() {
        return statusAtestado;
    }

    /**
     * @param statusAtestado the statusAtestado to set
     */
    public void setStatusAtestado(String statusAtestado) {
        this.statusAtestado = statusAtestado;
    }

    /**
     * @return the classAtestado
     */
    public String getClassAtestado() {
        return classAtestado;
    }

    /**
     * @param classAtestado the classAtestado to set
     */
    public void setClassAtestado(String classAtestado) {
        this.classAtestado = classAtestado;
    }

    /**
     * @return the dataAtestado
     */
    public Date getDataAtestado() {
        return dataAtestado;
    }

    /**
     * @param dataAtestado the dataAtestado to set
     */
    public void setDataAtestado(Date dataAtestado) {
        this.dataAtestado = dataAtestado;
    }

    /**
     * @return the idVisitaAtestado
     */
    public int getIdVisitaAtestado() {
        return idVisitaAtestado;
    }

    /**
     * @param idVisitaAtestado the idVisitaAtestado to set
     */
    public void setIdVisitaAtestado(int idVisitaAtestado) {
        this.idVisitaAtestado = idVisitaAtestado;
    }

    /**
     * @return the nomeSolicitanteAtestado
     */
    public String getNomeSolicitanteAtestado() {
        return nomeSolicitanteAtestado;
    }

    /**
     * @param nomeSolicitanteAtestado the nomeSolicitanteAtestado to set
     */
    public void setNomeSolicitanteAtestado(String nomeSolicitanteAtestado) {
        this.nomeSolicitanteAtestado = nomeSolicitanteAtestado;
    }

    /**
     * @return the idInternoAtestado
     */
    public int getIdInternoAtestado() {
        return idInternoAtestado;
    }

    /**
     * @param idInternoAtestado the idInternoAtestado to set
     */
    public void setIdInternoAtestado(int idInternoAtestado) {
        this.idInternoAtestado = idInternoAtestado;
    }

    /**
     * @return the nomeInternoAtestado
     */
    public String getNomeInternoAtestado() {
        return nomeInternoAtestado;
    }

    /**
     * @param nomeInternoAtestado the nomeInternoAtestado to set
     */
    public void setNomeInternoAtestado(String nomeInternoAtestado) {
        this.nomeInternoAtestado = nomeInternoAtestado;
    }

    /**
     * @return the textoAtestado
     */
    public String getTextoAtestado() {
        return textoAtestado;
    }

    /**
     * @param textoAtestado the textoAtestado to set
     */
    public void setTextoAtestado(String textoAtestado) {
        this.textoAtestado = textoAtestado;
    }

    /**
     * @return the utilizacao
     */
    public String getUtilizacao() {
        return utilizacao;
    }

    /**
     * @param utilizacao the utilizacao to set
     */
    public void setUtilizacao(String utilizacao) {
        this.utilizacao = utilizacao;
    }

    /**
     * @return the idColaborador
     */
    public int getIdColaborador() {
        return idColaborador;
    }

    /**
     * @param idColaborador the idColaborador to set
     */
    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
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
     * @return the dataLiberacao
     */
    public Date getDataLiberacao() {
        return dataLiberacao;
    }

    /**
     * @param dataLiberacao the dataLiberacao to set
     */
    public void setDataLiberacao(Date dataLiberacao) {
        this.dataLiberacao = dataLiberacao;
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
     * @return the horarioLiberacao
     */
    public String getHorarioLiberacao() {
        return horarioLiberacao;
    }

    /**
     * @param horarioLiberacao the horarioLiberacao to set
     */
    public void setHorarioLiberacao(String horarioLiberacao) {
        this.horarioLiberacao = horarioLiberacao;
    }

    /**
     * @return the AssinaturaColaborador
     */
    public byte[] getAssinaturaColaborador() {
        return AssinaturaColaborador;
    }

    /**
     * @param AssinaturaColaborador the AssinaturaColaborador to set
     */
    public void setAssinaturaColaborador(byte[] AssinaturaColaborador) {
        this.AssinaturaColaborador = AssinaturaColaborador;
    }

    /**
     * @return the validadorDados
     */
    public byte[] getValidadorDados() {
        return validadorDados;
    }

    /**
     * @param validadorDados the validadorDados to set
     */
    public void setValidadorDados(byte[] validadorDados) {
        this.validadorDados = validadorDados;
    }

    /**
     * @return the chaveInterno
     */
    public byte[] getChaveInterno() {
        return chaveInterno;
    }

    /**
     * @param chaveInterno the chaveInterno to set
     */
    public void setChaveInterno(byte[] chaveInterno) {
        this.chaveInterno = chaveInterno;
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
