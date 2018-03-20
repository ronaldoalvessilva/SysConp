/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Ronaldo
 */
public class ItensTransientes {

    private int idItens;
    private int idTrans;
    private int idAdvogado;
    private int idFunc;
    private int idVisitaDiversas;    
    private int tipoTrans;
    private String nomeAdvogado;
    private String nomeColaborador;
    private String nomeVisitaDiversa;
    private String destino;
    private String motivo;
    private Date dataEntrada;
    private String horaEntrada;
    private Date dataSaida;
    private String horaSaida;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private String tipoOperacao;    
    private byte [] assinaturaEntradaColaborador;   

    public ItensTransientes(int idItens, int idTrans, int idAdvogado, int idFunc, int idVisitaDiversas, int tipoTrans, String nomeAdvogado, String nomeColaborador, String nomeVisitaDiversa, String destino, String motivo, Date dataEntrada, String horaEntrada, Date dataSaida, String horaSaida, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String tipoOperacao, byte[] assinaturaEntradaColaborador) {
        this.idItens = idItens;
        this.idTrans = idTrans;
        this.idAdvogado = idAdvogado;
        this.idFunc = idFunc;
        this.idVisitaDiversas = idVisitaDiversas;
        this.tipoTrans = tipoTrans;
        this.nomeAdvogado = nomeAdvogado;
        this.nomeColaborador = nomeColaborador;
        this.nomeVisitaDiversa = nomeVisitaDiversa;
        this.destino = destino;
        this.motivo = motivo;
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
        this.dataSaida = dataSaida;
        this.horaSaida = horaSaida;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.tipoOperacao = tipoOperacao;
        this.assinaturaEntradaColaborador = assinaturaEntradaColaborador;
    }

    public ItensTransientes() {
    }

    /**
     * @return the idItens
     */
    public int getIdItens() {
        return idItens;
    }

    /**
     * @param idItens the idItens to set
     */
    public void setIdItens(int idItens) {
        this.idItens = idItens;
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
     * @return the idVisitaDiversas
     */
    public int getIdVisitaDiversas() {
        return idVisitaDiversas;
    }

    /**
     * @param idVisitaDiversas the idVisitaDiversas to set
     */
    public void setIdVisitaDiversas(int idVisitaDiversas) {
        this.idVisitaDiversas = idVisitaDiversas;
    }

    /**
     * @return the tipoTrans
     */
    public int getTipoTrans() {
        return tipoTrans;
    }

    /**
     * @param tipoTrans the tipoTrans to set
     */
    public void setTipoTrans(int tipoTrans) {
        this.tipoTrans = tipoTrans;
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
     * @return the nomeVisitaDiversa
     */
    public String getNomeVisitaDiversa() {
        return nomeVisitaDiversa;
    }

    /**
     * @param nomeVisitaDiversa the nomeVisitaDiversa to set
     */
    public void setNomeVisitaDiversa(String nomeVisitaDiversa) {
        this.nomeVisitaDiversa = nomeVisitaDiversa;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
     * @return the tipoOperacao
     */
    public String getTipoOperacao() {
        return tipoOperacao;
    }

    /**
     * @param tipoOperacao the tipoOperacao to set
     */
    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    /**
     * @return the assinaturaEntradaColaborador
     */
    public byte[] getAssinaturaEntradaColaborador() {
        return assinaturaEntradaColaborador;
    }

    /**
     * @param assinaturaEntradaColaborador the assinaturaEntradaColaborador to set
     */
    public void setAssinaturaEntradaColaborador(byte[] assinaturaEntradaColaborador) {
        this.assinaturaEntradaColaborador = assinaturaEntradaColaborador;
    }
}
