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
public class Veiculos {

    private int idVeiculo;
    private String statusVei;
    private Date dataCadastro;
    private String placaVeiculo;
    private String marcaVeiculo;
    private String modeloVeiculo;
    private String cidade;
    private String estado;
    private String fotoFrente;
    private String fotoLadoDireito;
    private String fotoLadoEsquerdo;
    private String fotoFundo;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;      

    public Veiculos(int idVeiculo, String statusVei, Date dataCadastro, String placaVeiculo, String marcaVeiculo, String modeloVeiculo, String cidade, String estado, String fotoFrente, String fotoLadoDireito, String fotoLadoEsquerdo, String fotoFundo, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento) {
        this.idVeiculo = idVeiculo;
        this.statusVei = statusVei;
        this.dataCadastro = dataCadastro;
        this.placaVeiculo = placaVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.cidade = cidade;
        this.estado = estado;
        this.fotoFrente = fotoFrente;
        this.fotoLadoDireito = fotoLadoDireito;
        this.fotoLadoEsquerdo = fotoLadoEsquerdo;
        this.fotoFundo = fotoFundo;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
    }

    public Veiculos() {
    }

    /**
     * @return the idVeiculo
     */
    public int getIdVeiculo() {
        return idVeiculo;
    }

    /**
     * @param idVeiculo the idVeiculo to set
     */
    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    /**
     * @return the statusVei
     */
    public String getStatusVei() {
        return statusVei;
    }

    /**
     * @param statusVei the statusVei to set
     */
    public void setStatusVei(String statusVei) {
        this.statusVei = statusVei;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the placaVeiculo
     */
    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    /**
     * @param placaVeiculo the placaVeiculo to set
     */
    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    /**
     * @return the marcaVeiculo
     */
    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    /**
     * @param marcaVeiculo the marcaVeiculo to set
     */
    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    /**
     * @return the modeloVeiculo
     */
    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    /**
     * @param modeloVeiculo the modeloVeiculo to set
     */
    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the fotoFrente
     */
    public String getFotoFrente() {
        return fotoFrente;
    }

    /**
     * @param fotoFrente the fotoFrente to set
     */
    public void setFotoFrente(String fotoFrente) {
        this.fotoFrente = fotoFrente;
    }

    /**
     * @return the fotoLadoDireito
     */
    public String getFotoLadoDireito() {
        return fotoLadoDireito;
    }

    /**
     * @param fotoLadoDireito the fotoLadoDireito to set
     */
    public void setFotoLadoDireito(String fotoLadoDireito) {
        this.fotoLadoDireito = fotoLadoDireito;
    }

    /**
     * @return the fotoLadoEsquerdo
     */
    public String getFotoLadoEsquerdo() {
        return fotoLadoEsquerdo;
    }

    /**
     * @param fotoLadoEsquerdo the fotoLadoEsquerdo to set
     */
    public void setFotoLadoEsquerdo(String fotoLadoEsquerdo) {
        this.fotoLadoEsquerdo = fotoLadoEsquerdo;
    }

    /**
     * @return the fotoFundo
     */
    public String getFotoFundo() {
        return fotoFundo;
    }

    /**
     * @param fotoFundo the fotoFundo to set
     */
    public void setFotoFundo(String fotoFundo) {
        this.fotoFundo = fotoFundo;
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
     * @return the dataFechamento
     */
    public String getDataFechamento() {
        return dataFechamento;
    }

    /**
     * @param dataFechamento the dataFechamento to set
     */
    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    /**
     * @return the horaFechamento
     */
    public String getHoraFechamento() {
        return horaFechamento;
    }

    /**
     * @param horaFechamento the horaFechamento to set
     */
    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }
}
