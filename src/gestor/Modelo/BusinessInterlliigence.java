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
public class BusinessInterlliigence {
    
    private Date dataAtual;
    private float capacidade;
    private float populacaoAtual;
    private float percentual;
    private int totalAtividadeEdu;
    private int totalLaborExterno;
    private int totalLaborInterno;      

    public BusinessInterlliigence(Date dataAtual, float capacidade, float populacaoAtual, float percentual, int totalAtividadeEdu, int totalLaborExterno, int totalLaborInterno) {
        this.dataAtual = dataAtual;
        this.capacidade = capacidade;
        this.populacaoAtual = populacaoAtual;
        this.percentual = percentual;
        this.totalAtividadeEdu = totalAtividadeEdu;
        this.totalLaborExterno = totalLaborExterno;
        this.totalLaborInterno = totalLaborInterno;
    }

    public BusinessInterlliigence() {
    }

    /**
     * @return the dataAtual
     */
    public Date getDataAtual() {
        return dataAtual;
    }

    /**
     * @param dataAtual the dataAtual to set
     */
    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    /**
     * @return the capacidade
     */
    public float getCapacidade() {
        return capacidade;
    }

    /**
     * @param capacidade the capacidade to set
     */
    public void setCapacidade(float capacidade) {
        this.capacidade = capacidade;
    }

    /**
     * @return the populacaoAtual
     */
    public float getPopulacaoAtual() {
        return populacaoAtual;
    }

    /**
     * @param populacaoAtual the populacaoAtual to set
     */
    public void setPopulacaoAtual(float populacaoAtual) {
        this.populacaoAtual = populacaoAtual;
    }

    /**
     * @return the percentual
     */
    public float getPercentual() {
        return percentual;
    }

    /**
     * @param percentual the percentual to set
     */
    public void setPercentual(float percentual) {
        this.percentual = percentual;
    }

    /**
     * @return the totalAtividadeEdu
     */
    public int getTotalAtividadeEdu() {
        return totalAtividadeEdu;
    }

    /**
     * @param totalAtividadeEdu the totalAtividadeEdu to set
     */
    public void setTotalAtividadeEdu(int totalAtividadeEdu) {
        this.totalAtividadeEdu = totalAtividadeEdu;
    }

    /**
     * @return the totalLaborExterno
     */
    public int getTotalLaborExterno() {
        return totalLaborExterno;
    }

    /**
     * @param totalLaborExterno the totalLaborExterno to set
     */
    public void setTotalLaborExterno(int totalLaborExterno) {
        this.totalLaborExterno = totalLaborExterno;
    }

    /**
     * @return the totalLaborInterno
     */
    public int getTotalLaborInterno() {
        return totalLaborInterno;
    }

    /**
     * @param totalLaborInterno the totalLaborInterno to set
     */
    public void setTotalLaborInterno(int totalLaborInterno) {
        this.totalLaborInterno = totalLaborInterno;
    }
}
