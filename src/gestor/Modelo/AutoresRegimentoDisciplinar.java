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
public class AutoresRegimentoDisciplinar {

    private int idAutor;
    private int idReg;
    private int idInternoCrc;
    private String nomeInternoCrc;
    private int idPav;
    private String descricaoPavilhao;
    private int idCela;
    private String descricaoCela;
    private int qtdeDias;
    private Date dataInicio;
    private Date dataTermino;
    private String utilizaSaida;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private String descricaoPavilhaoOrigem;
    private String descricaoCelaOrigem;

    public AutoresRegimentoDisciplinar() {
    }

    public AutoresRegimentoDisciplinar(int idAutor, int idReg, int idInternoCrc, String nomeInternoCrc, int idPav, String descricaoPavilhao, int idCela, String descricaoCela, int qtdeDias, Date dataInicio, Date dataTermino, String utilizaSaida, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String descricaoPavilhaoOrigem, String descricaoCelaOrigem) {
        this.idAutor = idAutor;
        this.idReg = idReg;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.idPav = idPav;
        this.descricaoPavilhao = descricaoPavilhao;
        this.idCela = idCela;
        this.descricaoCela = descricaoCela;
        this.qtdeDias = qtdeDias;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.utilizaSaida = utilizaSaida;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.descricaoPavilhaoOrigem = descricaoPavilhaoOrigem;
        this.descricaoCelaOrigem = descricaoCelaOrigem;
    }

    /**
     * @return the idAutor
     */
    public int getIdAutor() {
        return idAutor;
    }

    /**
     * @param idAutor the idAutor to set
     */
    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    /**
     * @return the idReg
     */
    public int getIdReg() {
        return idReg;
    }

    /**
     * @param idReg the idReg to set
     */
    public void setIdReg(int idReg) {
        this.idReg = idReg;
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
     * @return the idCela
     */
    public int getIdCela() {
        return idCela;
    }

    /**
     * @param idCela the idCela to set
     */
    public void setIdCela(int idCela) {
        this.idCela = idCela;
    }

    /**
     * @return the descricaoCela
     */
    public String getDescricaoCela() {
        return descricaoCela;
    }

    /**
     * @param descricaoCela the descricaoCela to set
     */
    public void setDescricaoCela(String descricaoCela) {
        this.descricaoCela = descricaoCela;
    }

    /**
     * @return the qtdeDias
     */
    public int getQtdeDias() {
        return qtdeDias;
    }

    /**
     * @param qtdeDias the qtdeDias to set
     */
    public void setQtdeDias(int qtdeDias) {
        this.qtdeDias = qtdeDias;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataTermino
     */
    public Date getDataTermino() {
        return dataTermino;
    }

    /**
     * @param dataTermino the dataTermino to set
     */
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    /**
     * @return the utilizaSaida
     */
    public String getUtilizaSaida() {
        return utilizaSaida;
    }

    /**
     * @param utilizaSaida the utilizaSaida to set
     */
    public void setUtilizaSaida(String utilizaSaida) {
        this.utilizaSaida = utilizaSaida;
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
     * @return the descricaoPavilhaoOrigem
     */
    public String getDescricaoPavilhaoOrigem() {
        return descricaoPavilhaoOrigem;
    }

    /**
     * @param descricaoPavilhaoOrigem the descricaoPavilhaoOrigem to set
     */
    public void setDescricaoPavilhaoOrigem(String descricaoPavilhaoOrigem) {
        this.descricaoPavilhaoOrigem = descricaoPavilhaoOrigem;
    }

    /**
     * @return the descricaoCelaOrigem
     */
    public String getDescricaoCelaOrigem() {
        return descricaoCelaOrigem;
    }

    /**
     * @param descricaoCelaOrigem the descricaoCelaOrigem to set
     */
    public void setDescricaoCelaOrigem(String descricaoCelaOrigem) {
        this.descricaoCelaOrigem = descricaoCelaOrigem;
    }
    
}
