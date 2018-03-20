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
public class EstoqueAcervoEmprestimo {
    private int idEstoque;
    private int idDocumento;
    private Date dataLanc;
    private String tipoMov;
    private int idLivro;
    private String nomeLivro;
    private int idLocal;
    private String descricaoLocal;
    private float saldoEstoque;
    private float saldoEstoqueAtual;

    public EstoqueAcervoEmprestimo(int idEstoque, int idDocumento, Date dataLanc, String tipoMov, int idLivro, String nomeLivro, int idLocal, String descricaoLocal, float saldoEstoque, float saldoEstoqueAtual) {
        this.idEstoque = idEstoque;
        this.idDocumento = idDocumento;
        this.dataLanc = dataLanc;
        this.tipoMov = tipoMov;
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.idLocal = idLocal;
        this.descricaoLocal = descricaoLocal;
        this.saldoEstoque = saldoEstoque;
        this.saldoEstoqueAtual = saldoEstoqueAtual;
    }

    public EstoqueAcervoEmprestimo() {
    }

    /**
     * @return the idEstoque
     */
    public int getIdEstoque() {
        return idEstoque;
    }

    /**
     * @param idEstoque the idEstoque to set
     */
    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    /**
     * @return the idDocumento
     */
    public int getIdDocumento() {
        return idDocumento;
    }

    /**
     * @param idDocumento the idDocumento to set
     */
    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
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
     * @return the tipoMov
     */
    public String getTipoMov() {
        return tipoMov;
    }

    /**
     * @param tipoMov the tipoMov to set
     */
    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    /**
     * @return the idLivro
     */
    public int getIdLivro() {
        return idLivro;
    }

    /**
     * @param idLivro the idLivro to set
     */
    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    /**
     * @return the nomeLivro
     */
    public String getNomeLivro() {
        return nomeLivro;
    }

    /**
     * @param nomeLivro the nomeLivro to set
     */
    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    /**
     * @return the idLocal
     */
    public int getIdLocal() {
        return idLocal;
    }

    /**
     * @param idLocal the idLocal to set
     */
    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    /**
     * @return the descricaoLocal
     */
    public String getDescricaoLocal() {
        return descricaoLocal;
    }

    /**
     * @param descricaoLocal the descricaoLocal to set
     */
    public void setDescricaoLocal(String descricaoLocal) {
        this.descricaoLocal = descricaoLocal;
    }

    /**
     * @return the saldoEstoque
     */
    public float getSaldoEstoque() {
        return saldoEstoque;
    }

    /**
     * @param saldoEstoque the saldoEstoque to set
     */
    public void setSaldoEstoque(float saldoEstoque) {
        this.saldoEstoque = saldoEstoque;
    }

    /**
     * @return the saldoEstoqueAtual
     */
    public float getSaldoEstoqueAtual() {
        return saldoEstoqueAtual;
    }

    /**
     * @param saldoEstoqueAtual the saldoEstoqueAtual to set
     */
    public void setSaldoEstoqueAtual(float saldoEstoqueAtual) {
        this.saldoEstoqueAtual = saldoEstoqueAtual;
    }
}
