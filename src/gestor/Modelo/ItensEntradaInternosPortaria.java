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
public class ItensEntradaInternosPortaria {

    private int idItem;
    private int idItem_SAIDA;
    private int idItem_MOVIMENTO;
    private int idLanc;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private String situacaoCrc;
    private String confirmaEntrada;
    private Date dataChegada;
    private String horarioChegada;
    private String numeroOficio;
    private String origemInterno;
    private String usuarioInsert;
    private String usuarioUp;
    private String usuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;      
    private String registroCancelado;
    private int idRetorno;
    private String confirmaRetPort;
    private String confirmaRetCrc;
    private int idEntraSaida;
    private String nomeDestino;
    private Date dataSaida;
    private String saidaConfirmada;
    private String horaSaida;
    private String observacaoInterno;

    public ItensEntradaInternosPortaria() {
    }

    public ItensEntradaInternosPortaria(int idItem, int idItem_SAIDA, int idItem_MOVIMENTO, int idLanc, int idInternoCrc, String nomeInternoCrc, String situacaoCrc, String confirmaEntrada, Date dataChegada, String horarioChegada, String numeroOficio, String origemInterno, String usuarioInsert, String usuarioUp, String usuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp, String registroCancelado, int idRetorno, String confirmaRetPort, String confirmaRetCrc, int idEntraSaida, String nomeDestino, Date dataSaida, String saidaConfirmada, String horaSaida, String observacaoInterno) {
        this.idItem = idItem;
        this.idItem_SAIDA = idItem_SAIDA;
        this.idItem_MOVIMENTO = idItem_MOVIMENTO;
        this.idLanc = idLanc;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.situacaoCrc = situacaoCrc;
        this.confirmaEntrada = confirmaEntrada;
        this.dataChegada = dataChegada;
        this.horarioChegada = horarioChegada;
        this.numeroOficio = numeroOficio;
        this.origemInterno = origemInterno;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.usuarioDelete = usuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.registroCancelado = registroCancelado;
        this.idRetorno = idRetorno;
        this.confirmaRetPort = confirmaRetPort;
        this.confirmaRetCrc = confirmaRetCrc;
        this.idEntraSaida = idEntraSaida;
        this.nomeDestino = nomeDestino;
        this.dataSaida = dataSaida;
        this.saidaConfirmada = saidaConfirmada;
        this.horaSaida = horaSaida;
        this.observacaoInterno = observacaoInterno;
    }

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the idItem_SAIDA
     */
    public int getIdItem_SAIDA() {
        return idItem_SAIDA;
    }

    /**
     * @param idItem_SAIDA the idItem_SAIDA to set
     */
    public void setIdItem_SAIDA(int idItem_SAIDA) {
        this.idItem_SAIDA = idItem_SAIDA;
    }

    /**
     * @return the idItem_MOVIMENTO
     */
    public int getIdItem_MOVIMENTO() {
        return idItem_MOVIMENTO;
    }

    /**
     * @param idItem_MOVIMENTO the idItem_MOVIMENTO to set
     */
    public void setIdItem_MOVIMENTO(int idItem_MOVIMENTO) {
        this.idItem_MOVIMENTO = idItem_MOVIMENTO;
    }

    /**
     * @return the idLanc
     */
    public int getIdLanc() {
        return idLanc;
    }

    /**
     * @param idLanc the idLanc to set
     */
    public void setIdLanc(int idLanc) {
        this.idLanc = idLanc;
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
     * @return the situacaoCrc
     */
    public String getSituacaoCrc() {
        return situacaoCrc;
    }

    /**
     * @param situacaoCrc the situacaoCrc to set
     */
    public void setSituacaoCrc(String situacaoCrc) {
        this.situacaoCrc = situacaoCrc;
    }

    /**
     * @return the confirmaEntrada
     */
    public String getConfirmaEntrada() {
        return confirmaEntrada;
    }

    /**
     * @param confirmaEntrada the confirmaEntrada to set
     */
    public void setConfirmaEntrada(String confirmaEntrada) {
        this.confirmaEntrada = confirmaEntrada;
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
     * @return the horarioChegada
     */
    public String getHorarioChegada() {
        return horarioChegada;
    }

    /**
     * @param horarioChegada the horarioChegada to set
     */
    public void setHorarioChegada(String horarioChegada) {
        this.horarioChegada = horarioChegada;
    }

    /**
     * @return the numeroOficio
     */
    public String getNumeroOficio() {
        return numeroOficio;
    }

    /**
     * @param numeroOficio the numeroOficio to set
     */
    public void setNumeroOficio(String numeroOficio) {
        this.numeroOficio = numeroOficio;
    }

    /**
     * @return the origemInterno
     */
    public String getOrigemInterno() {
        return origemInterno;
    }

    /**
     * @param origemInterno the origemInterno to set
     */
    public void setOrigemInterno(String origemInterno) {
        this.origemInterno = origemInterno;
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
     * @return the usuarioDelete
     */
    public String getUsuarioDelete() {
        return usuarioDelete;
    }

    /**
     * @param usuarioDelete the usuarioDelete to set
     */
    public void setUsuarioDelete(String usuarioDelete) {
        this.usuarioDelete = usuarioDelete;
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
     * @return the dataDelete
     */
    public String getDataDelete() {
        return dataDelete;
    }

    /**
     * @param dataDelete the dataDelete to set
     */
    public void setDataDelete(String dataDelete) {
        this.dataDelete = dataDelete;
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
     * @return the registroCancelado
     */
    public String getRegistroCancelado() {
        return registroCancelado;
    }

    /**
     * @param registroCancelado the registroCancelado to set
     */
    public void setRegistroCancelado(String registroCancelado) {
        this.registroCancelado = registroCancelado;
    }

    /**
     * @return the idRetorno
     */
    public int getIdRetorno() {
        return idRetorno;
    }

    /**
     * @param idRetorno the idRetorno to set
     */
    public void setIdRetorno(int idRetorno) {
        this.idRetorno = idRetorno;
    }

    /**
     * @return the confirmaRetPort
     */
    public String getConfirmaRetPort() {
        return confirmaRetPort;
    }

    /**
     * @param confirmaRetPort the confirmaRetPort to set
     */
    public void setConfirmaRetPort(String confirmaRetPort) {
        this.confirmaRetPort = confirmaRetPort;
    }

    /**
     * @return the confirmaRetCrc
     */
    public String getConfirmaRetCrc() {
        return confirmaRetCrc;
    }

    /**
     * @param confirmaRetCrc the confirmaRetCrc to set
     */
    public void setConfirmaRetCrc(String confirmaRetCrc) {
        this.confirmaRetCrc = confirmaRetCrc;
    }

    /**
     * @return the idEntraSaida
     */
    public int getIdEntraSaida() {
        return idEntraSaida;
    }

    /**
     * @param idEntraSaida the idEntraSaida to set
     */
    public void setIdEntraSaida(int idEntraSaida) {
        this.idEntraSaida = idEntraSaida;
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
     * @return the saidaConfirmada
     */
    public String getSaidaConfirmada() {
        return saidaConfirmada;
    }

    /**
     * @param saidaConfirmada the saidaConfirmada to set
     */
    public void setSaidaConfirmada(String saidaConfirmada) {
        this.saidaConfirmada = saidaConfirmada;
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
     * @return the observacaoInterno
     */
    public String getObservacaoInterno() {
        return observacaoInterno;
    }

    /**
     * @param observacaoInterno the observacaoInterno to set
     */
    public void setObservacaoInterno(String observacaoInterno) {
        this.observacaoInterno = observacaoInterno;
    }
}
