/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronaldo
 */
public class NaturezaEvento {

    private int idNatureza;
    private String statusNatureza;
    private String tipoFalta;
    private String descricaoNatureza;
    private String descrucaoDetalhada;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public NaturezaEvento(int idNatureza, String statusNatureza, String tipoFalta, String descricaoNatureza, String descrucaoDetalhada, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idNatureza = idNatureza;
        this.statusNatureza = statusNatureza;
        this.tipoFalta = tipoFalta;
        this.descricaoNatureza = descricaoNatureza;
        this.descrucaoDetalhada = descrucaoDetalhada;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public NaturezaEvento() {
    }

    /**
     * @return the idNatureza
     */
    public int getIdNatureza() {
        return idNatureza;
    }

    /**
     * @param idNatureza the idNatureza to set
     */
    public void setIdNatureza(int idNatureza) {
        this.idNatureza = idNatureza;
    }

    /**
     * @return the statusNatureza
     */
    public String getStatusNatureza() {
        return statusNatureza;
    }

    /**
     * @param statusNatureza the statusNatureza to set
     */
    public void setStatusNatureza(String statusNatureza) {
        this.statusNatureza = statusNatureza;
    }

    /**
     * @return the tipoFalta
     */
    public String getTipoFalta() {
        return tipoFalta;
    }

    /**
     * @param tipoFalta the tipoFalta to set
     */
    public void setTipoFalta(String tipoFalta) {
        this.tipoFalta = tipoFalta;
    }

    /**
     * @return the descricaoNatureza
     */
    public String getDescricaoNatureza() {
        return descricaoNatureza;
    }

    /**
     * @param descricaoNatureza the descricaoNatureza to set
     */
    public void setDescricaoNatureza(String descricaoNatureza) {
        this.descricaoNatureza = descricaoNatureza;
    }

    /**
     * @return the descrucaoDetalhada
     */
    public String getDescrucaoDetalhada() {
        return descrucaoDetalhada;
    }

    /**
     * @param descrucaoDetalhada the descrucaoDetalhada to set
     */
    public void setDescrucaoDetalhada(String descrucaoDetalhada) {
        this.descrucaoDetalhada = descrucaoDetalhada;
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
