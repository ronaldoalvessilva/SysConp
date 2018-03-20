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
public class PopAgentes {

    private int idAgente;
    private Date dataMov;
    private int agenteMasc;
    private int agenteFem;   
    private int motoristas;    

    public PopAgentes(int idAgente, Date dataMov, int agenteMasc, int agenteFem, int motoristas) {
        this.idAgente = idAgente;
        this.dataMov = dataMov;
        this.agenteMasc = agenteMasc;
        this.agenteFem = agenteFem;
        this.motoristas = motoristas;
    }

    public PopAgentes() {
    }

    /**
     * @return the idAgente
     */
    public int getIdAgente() {
        return idAgente;
    }

    /**
     * @param idAgente the idAgente to set
     */
    public void setIdAgente(int idAgente) {
        this.idAgente = idAgente;
    }

    /**
     * @return the dataMov
     */
    public Date getDataMov() {
        return dataMov;
    }

    /**
     * @param dataMov the dataMov to set
     */
    public void setDataMov(Date dataMov) {
        this.dataMov = dataMov;
    }

    /**
     * @return the agenteMasc
     */
    public int getAgenteMasc() {
        return agenteMasc;
    }

    /**
     * @param agenteMasc the agenteMasc to set
     */
    public void setAgenteMasc(int agenteMasc) {
        this.agenteMasc = agenteMasc;
    }

    /**
     * @return the agenteFem
     */
    public int getAgenteFem() {
        return agenteFem;
    }

    /**
     * @param agenteFem the agenteFem to set
     */
    public void setAgenteFem(int agenteFem) {
        this.agenteFem = agenteFem;
    }

    /**
     * @return the motoristas
     */
    public int getMotoristas() {
        return motoristas;
    }

    /**
     * @param motoristas the motoristas to set
     */
    public void setMotoristas(int motoristas) {
        this.motoristas = motoristas;
    }
}
