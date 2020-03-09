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
public class GerarPopNominal {
    
    private Date dataLanc;
    private int IdInternoCrc; 
    private String cnc;
    private String nomeInterno;
    private String situacaoEntrada;
    private String situacaoRetorno;       

    public GerarPopNominal() {
    }

    public GerarPopNominal(Date dataLanc, int IdInternoCrc, String cnc, String nomeInterno, String situacaoEntrada, String situacaoRetorno) {
        this.dataLanc = dataLanc;
        this.IdInternoCrc = IdInternoCrc;
        this.cnc = cnc;
        this.nomeInterno = nomeInterno;
        this.situacaoEntrada = situacaoEntrada;
        this.situacaoRetorno = situacaoRetorno;
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
     * @return the IdInternoCrc
     */
    public int getIdInternoCrc() {
        return IdInternoCrc;
    }

    /**
     * @param IdInternoCrc the IdInternoCrc to set
     */
    public void setIdInternoCrc(int IdInternoCrc) {
        this.IdInternoCrc = IdInternoCrc;
    }

    /**
     * @return the cnc
     */
    public String getCnc() {
        return cnc;
    }

    /**
     * @param cnc the cnc to set
     */
    public void setCnc(String cnc) {
        this.cnc = cnc;
    }

    /**
     * @return the nomeInterno
     */
    public String getNomeInterno() {
        return nomeInterno;
    }

    /**
     * @param nomeInterno the nomeInterno to set
     */
    public void setNomeInterno(String nomeInterno) {
        this.nomeInterno = nomeInterno;
    }

    /**
     * @return the situacaoEntrada
     */
    public String getSituacaoEntrada() {
        return situacaoEntrada;
    }

    /**
     * @param situacaoEntrada the situacaoEntrada to set
     */
    public void setSituacaoEntrada(String situacaoEntrada) {
        this.situacaoEntrada = situacaoEntrada;
    }

    /**
     * @return the situacaoRetorno
     */
    public String getSituacaoRetorno() {
        return situacaoRetorno;
    }

    /**
     * @param situacaoRetorno the situacaoRetorno to set
     */
    public void setSituacaoRetorno(String situacaoRetorno) {
        this.situacaoRetorno = situacaoRetorno;
    }
}
