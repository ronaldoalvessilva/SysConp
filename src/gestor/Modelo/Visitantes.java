/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Modelo;

/**
 *
 * @author Ronaldo
 */
public class Visitantes {
    private String idVisita;   
    private String dataVisita;
    private String statusVisita;
    private String nomeVisita;
    private String rgVisita;
    private String nomeInterno;
    private String DataValidade;    

    public Visitantes(String idVisita, String dataVisita, String statusVisita, String nomeVisita, String rgVisita, String nomeInterno, String DataValidade) {
        this.idVisita = idVisita;
        this.dataVisita = dataVisita;
        this.statusVisita = statusVisita;
        this.nomeVisita = nomeVisita;
        this.rgVisita = rgVisita;
        this.nomeInterno = nomeInterno;
        this.DataValidade = DataValidade;
    }

    public Visitantes() {
    }

    /**
     * @return the idVisita
     */
    public String getIdVisita() {
        return idVisita;
    }

    /**
     * @param idVisita the idVisita to set
     */
    public void setIdVisita(String idVisita) {
        this.idVisita = idVisita;
    }

    /**
     * @return the dataVisita
     */
    public String getDataVisita() {
        return dataVisita;
    }

    /**
     * @param dataVisita the dataVisita to set
     */
    public void setDataVisita(String dataVisita) {
        this.dataVisita = dataVisita;
    }

    /**
     * @return the statusVisita
     */
    public String getStatusVisita() {
        return statusVisita;
    }

    /**
     * @param statusVisita the statusVisita to set
     */
    public void setStatusVisita(String statusVisita) {
        this.statusVisita = statusVisita;
    }

    /**
     * @return the nomeVisita
     */
    public String getNomeVisita() {
        return nomeVisita;
    }

    /**
     * @param nomeVisita the nomeVisita to set
     */
    public void setNomeVisita(String nomeVisita) {
        this.nomeVisita = nomeVisita;
    }

    /**
     * @return the rgVisita
     */
    public String getRgVisita() {
        return rgVisita;
    }

    /**
     * @param rgVisita the rgVisita to set
     */
    public void setRgVisita(String rgVisita) {
        this.rgVisita = rgVisita;
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
     * @return the DataValidade
     */
    public String getDataValidade() {
        return DataValidade;
    }

    /**
     * @param DataValidade the DataValidade to set
     */
    public void setDataValidade(String DataValidade) {
        this.DataValidade = DataValidade;
    }

    
}
