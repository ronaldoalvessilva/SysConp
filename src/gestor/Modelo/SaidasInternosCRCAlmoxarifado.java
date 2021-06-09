/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronaldo.silva7
 */
public class SaidasInternosCRCAlmoxarifado {

    private Integer IdInternoCrc;
    private String NomeInternoCrc;
    private Date dataSaida;
    private String destinoInterno;

    public SaidasInternosCRCAlmoxarifado() {
    }

    public SaidasInternosCRCAlmoxarifado(Integer IdInternoCrc, String NomeInternoCrc, Date dataSaida, String destinoInterno) {
        this.IdInternoCrc = IdInternoCrc;
        this.NomeInternoCrc = NomeInternoCrc;
        this.dataSaida = dataSaida;
        this.destinoInterno = destinoInterno;
    }

    /**
     * @return the IdInternoCrc
     */
    public Integer getIdInternoCrc() {
        return IdInternoCrc;
    }

    /**
     * @param IdInternoCrc the IdInternoCrc to set
     */
    public void setIdInternoCrc(Integer IdInternoCrc) {
        this.IdInternoCrc = IdInternoCrc;
    }

    /**
     * @return the NomeInternoCrc
     */
    public String getNomeInternoCrc() {
        return NomeInternoCrc;
    }

    /**
     * @param NomeInternoCrc the NomeInternoCrc to set
     */
    public void setNomeInternoCrc(String NomeInternoCrc) {
        this.NomeInternoCrc = NomeInternoCrc;
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
     * @return the destinoInterno
     */
    public String getDestinoInterno() {
        return destinoInterno;
    }

    /**
     * @param destinoInterno the destinoInterno to set
     */
    public void setDestinoInterno(String destinoInterno) {
        this.destinoInterno = destinoInterno;
    }
}
