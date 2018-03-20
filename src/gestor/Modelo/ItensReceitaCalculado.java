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
public class ItensReceitaCalculado {
    private int item;
    private int idCalc;
    private Date dataCalc;
    private int idFicha;
    private String statusCalc;    
    private int itemCalc;
    private int idProd;
    private String descricaoProduto;
    private String unidade;
    private float qtdPorcaoCalc;
    private float qtdPorcao;
    private float qtdFinal;
    private float qtdTotal;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;    

    public ItensReceitaCalculado(int item, int idCalc, Date dataCalc, int idFicha, String statusCalc, int itemCalc, int idProd, String descricaoProduto, String unidade, float qtdPorcaoCalc, float qtdPorcao, float qtdFinal, float qtdTotal, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.item = item;
        this.idCalc = idCalc;
        this.dataCalc = dataCalc;
        this.idFicha = idFicha;
        this.statusCalc = statusCalc;
        this.itemCalc = itemCalc;
        this.idProd = idProd;
        this.descricaoProduto = descricaoProduto;
        this.unidade = unidade;
        this.qtdPorcaoCalc = qtdPorcaoCalc;
        this.qtdPorcao = qtdPorcao;
        this.qtdFinal = qtdFinal;
        this.qtdTotal = qtdTotal;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensReceitaCalculado() {
    }

    /**
     * @return the item
     */
    public int getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(int item) {
        this.item = item;
    }

    /**
     * @return the idCalc
     */
    public int getIdCalc() {
        return idCalc;
    }

    /**
     * @param idCalc the idCalc to set
     */
    public void setIdCalc(int idCalc) {
        this.idCalc = idCalc;
    }

    /**
     * @return the dataCalc
     */
    public Date getDataCalc() {
        return dataCalc;
    }

    /**
     * @param dataCalc the dataCalc to set
     */
    public void setDataCalc(Date dataCalc) {
        this.dataCalc = dataCalc;
    }

    /**
     * @return the idFicha
     */
    public int getIdFicha() {
        return idFicha;
    }

    /**
     * @param idFicha the idFicha to set
     */
    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }

    /**
     * @return the statusCalc
     */
    public String getStatusCalc() {
        return statusCalc;
    }

    /**
     * @param statusCalc the statusCalc to set
     */
    public void setStatusCalc(String statusCalc) {
        this.statusCalc = statusCalc;
    }

    /**
     * @return the itemCalc
     */
    public int getItemCalc() {
        return itemCalc;
    }

    /**
     * @param itemCalc the itemCalc to set
     */
    public void setItemCalc(int itemCalc) {
        this.itemCalc = itemCalc;
    }

    /**
     * @return the idProd
     */
    public int getIdProd() {
        return idProd;
    }

    /**
     * @param idProd the idProd to set
     */
    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the qtdPorcaoCalc
     */
    public float getQtdPorcaoCalc() {
        return qtdPorcaoCalc;
    }

    /**
     * @param qtdPorcaoCalc the qtdPorcaoCalc to set
     */
    public void setQtdPorcaoCalc(float qtdPorcaoCalc) {
        this.qtdPorcaoCalc = qtdPorcaoCalc;
    }

    /**
     * @return the qtdPorcao
     */
    public float getQtdPorcao() {
        return qtdPorcao;
    }

    /**
     * @param qtdPorcao the qtdPorcao to set
     */
    public void setQtdPorcao(float qtdPorcao) {
        this.qtdPorcao = qtdPorcao;
    }

    /**
     * @return the qtdFinal
     */
    public float getQtdFinal() {
        return qtdFinal;
    }

    /**
     * @param qtdFinal the qtdFinal to set
     */
    public void setQtdFinal(float qtdFinal) {
        this.qtdFinal = qtdFinal;
    }

    /**
     * @return the qtdTotal
     */
    public float getQtdTotal() {
        return qtdTotal;
    }

    /**
     * @param qtdTotal the qtdTotal to set
     */
    public void setQtdTotal(float qtdTotal) {
        this.qtdTotal = qtdTotal;
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
