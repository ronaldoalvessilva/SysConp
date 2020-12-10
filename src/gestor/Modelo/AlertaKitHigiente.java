/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ronaldo.silva7
 */
public class AlertaKitHigiente {

    private Integer idRegProdutoKC;
    private Integer idRegistroComp;
    private Date dataPrevisao;
    private Date dataPagamento;
    private String kitPago;
    private Integer idKit;
    private int kitInicial;
    private int kitDecendial;
    private int kitQuinzenal;
    private int kitMensal;
    private int kitSemestral;
    private int kitAnual;
    private String tipoKit;
    private Integer codigoProduto;
    private String descricaoProduto;
    private Integer quantProd;
    private Integer idPav;
    private String descricaoPav;

    public AlertaKitHigiente() {
    }

    public AlertaKitHigiente(Integer idRegProdutoKC, Integer idRegistroComp, Date dataPrevisao, Date dataPagamento, String kitPago, Integer idKit, int kitInicial, int kitDecendial, int kitQuinzenal, int kitMensal, int kitSemestral, int kitAnual, String tipoKit, Integer codigoProduto, String descricaoProduto, Integer quantProd, Integer idPav, String descricaoPav) {
        this.idRegProdutoKC = idRegProdutoKC;
        this.idRegistroComp = idRegistroComp;
        this.dataPrevisao = dataPrevisao;
        this.dataPagamento = dataPagamento;
        this.kitPago = kitPago;
        this.idKit = idKit;
        this.kitInicial = kitInicial;
        this.kitDecendial = kitDecendial;
        this.kitQuinzenal = kitQuinzenal;
        this.kitMensal = kitMensal;
        this.kitSemestral = kitSemestral;
        this.kitAnual = kitAnual;
        this.tipoKit = tipoKit;
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.quantProd = quantProd;
        this.idPav = idPav;
        this.descricaoPav = descricaoPav;
    }

    /**
     * @return the idRegProdutoKC
     */
    public Integer getIdRegProdutoKC() {
        return idRegProdutoKC;
    }

    /**
     * @param idRegProdutoKC the idRegProdutoKC to set
     */
    public void setIdRegProdutoKC(Integer idRegProdutoKC) {
        this.idRegProdutoKC = idRegProdutoKC;
    }

    /**
     * @return the idRegistroComp
     */
    public Integer getIdRegistroComp() {
        return idRegistroComp;
    }

    /**
     * @param idRegistroComp the idRegistroComp to set
     */
    public void setIdRegistroComp(Integer idRegistroComp) {
        this.idRegistroComp = idRegistroComp;
    }

    /**
     * @return the dataPrevisao
     */
    public Date getDataPrevisao() {
        return dataPrevisao;
    }

    /**
     * @param dataPrevisao the dataPrevisao to set
     */
    public void setDataPrevisao(Date dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    /**
     * @return the dataPagamento
     */
    public Date getDataPagamento() {
        return dataPagamento;
    }

    /**
     * @param dataPagamento the dataPagamento to set
     */
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    /**
     * @return the kitPago
     */
    public String getKitPago() {
        return kitPago;
    }

    /**
     * @param kitPago the kitPago to set
     */
    public void setKitPago(String kitPago) {
        this.kitPago = kitPago;
    }

    /**
     * @return the idKit
     */
    public Integer getIdKit() {
        return idKit;
    }

    /**
     * @param idKit the idKit to set
     */
    public void setIdKit(Integer idKit) {
        this.idKit = idKit;
    }

    /**
     * @return the kitInicial
     */
    public int getKitInicial() {
        return kitInicial;
    }

    /**
     * @param kitInicial the kitInicial to set
     */
    public void setKitInicial(int kitInicial) {
        this.kitInicial = kitInicial;
    }

    /**
     * @return the kitDecendial
     */
    public int getKitDecendial() {
        return kitDecendial;
    }

    /**
     * @param kitDecendial the kitDecendial to set
     */
    public void setKitDecendial(int kitDecendial) {
        this.kitDecendial = kitDecendial;
    }

    /**
     * @return the kitQuinzenal
     */
    public int getKitQuinzenal() {
        return kitQuinzenal;
    }

    /**
     * @param kitQuinzenal the kitQuinzenal to set
     */
    public void setKitQuinzenal(int kitQuinzenal) {
        this.kitQuinzenal = kitQuinzenal;
    }

    /**
     * @return the kitMensal
     */
    public int getKitMensal() {
        return kitMensal;
    }

    /**
     * @param kitMensal the kitMensal to set
     */
    public void setKitMensal(int kitMensal) {
        this.kitMensal = kitMensal;
    }

    /**
     * @return the kitSemestral
     */
    public int getKitSemestral() {
        return kitSemestral;
    }

    /**
     * @param kitSemestral the kitSemestral to set
     */
    public void setKitSemestral(int kitSemestral) {
        this.kitSemestral = kitSemestral;
    }

    /**
     * @return the kitAnual
     */
    public int getKitAnual() {
        return kitAnual;
    }

    /**
     * @param kitAnual the kitAnual to set
     */
    public void setKitAnual(int kitAnual) {
        this.kitAnual = kitAnual;
    }

    /**
     * @return the tipoKit
     */
    public String getTipoKit() {
        return tipoKit;
    }

    /**
     * @param tipoKit the tipoKit to set
     */
    public void setTipoKit(String tipoKit) {
        this.tipoKit = tipoKit;
    }

    /**
     * @return the codigoProduto
     */
    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * @param codigoProduto the codigoProduto to set
     */
    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
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
     * @return the quantProd
     */
    public Integer getQuantProd() {
        return quantProd;
    }

    /**
     * @param quantProd the quantProd to set
     */
    public void setQuantProd(Integer quantProd) {
        this.quantProd = quantProd;
    }

    /**
     * @return the idPav
     */
    public Integer getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(Integer idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the descricaoPav
     */
    public String getDescricaoPav() {
        return descricaoPav;
    }

    /**
     * @param descricaoPav the descricaoPav to set
     */
    public void setDescricaoPav(String descricaoPav) {
        this.descricaoPav = descricaoPav;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.getIdRegProdutoKC());
        hash = 61 * hash + Objects.hashCode(this.getIdRegistroComp());
        hash = 61 * hash + Objects.hashCode(this.getIdKit());
        hash = 61 * hash + Objects.hashCode(this.getCodigoProduto());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AlertaKitHigiente other = (AlertaKitHigiente) obj;
        if (!Objects.equals(this.idRegProdutoKC, other.idRegProdutoKC)) {
            return false;
        }
        if (!Objects.equals(this.idRegistroComp, other.idRegistroComp)) {
            return false;
        }
        if (!Objects.equals(this.idKit, other.idKit)) {
            return false;
        }
        if (!Objects.equals(this.codigoProduto, other.codigoProduto)) {
            return false;
        }
        return true;
    }
}
