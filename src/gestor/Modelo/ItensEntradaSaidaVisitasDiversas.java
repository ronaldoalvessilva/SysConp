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
public class ItensEntradaSaidaVisitasDiversas {

    private int IdItem;
    private int Idlanc;
    private int IdVisita;
    private String nomeVisita;
    private int idDepartamento;
    private String nomeDepartamento;
    private String motivoVisita;
    private Date DataEntrada;
    private String HorarioEntrada;
    private Date DataSaida;
    private String HorarioSaida;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;   

    public ItensEntradaSaidaVisitasDiversas(int IdItem, int Idlanc, int IdVisita, String nomeVisita, int idDepartamento, String nomeDepartamento, String motivoVisita, Date DataEntrada, String HorarioEntrada, Date DataSaida, String HorarioSaida, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp) {
        this.IdItem = IdItem;
        this.Idlanc = Idlanc;
        this.IdVisita = IdVisita;
        this.nomeVisita = nomeVisita;
        this.idDepartamento = idDepartamento;
        this.nomeDepartamento = nomeDepartamento;
        this.motivoVisita = motivoVisita;
        this.DataEntrada = DataEntrada;
        this.HorarioEntrada = HorarioEntrada;
        this.DataSaida = DataSaida;
        this.HorarioSaida = HorarioSaida;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
    }

    public ItensEntradaSaidaVisitasDiversas() {
    }

    /**
     * @return the IdItem
     */
    public int getIdItem() {
        return IdItem;
    }

    /**
     * @param IdItem the IdItem to set
     */
    public void setIdItem(int IdItem) {
        this.IdItem = IdItem;
    }

    /**
     * @return the Idlanc
     */
    public int getIdlanc() {
        return Idlanc;
    }

    /**
     * @param Idlanc the Idlanc to set
     */
    public void setIdlanc(int Idlanc) {
        this.Idlanc = Idlanc;
    }

    /**
     * @return the IdVisita
     */
    public int getIdVisita() {
        return IdVisita;
    }

    /**
     * @param IdVisita the IdVisita to set
     */
    public void setIdVisita(int IdVisita) {
        this.IdVisita = IdVisita;
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
     * @return the idDepartamento
     */
    public int getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    /**
     * @return the nomeDepartamento
     */
    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    /**
     * @param nomeDepartamento the nomeDepartamento to set
     */
    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    /**
     * @return the motivoVisita
     */
    public String getMotivoVisita() {
        return motivoVisita;
    }

    /**
     * @param motivoVisita the motivoVisita to set
     */
    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    /**
     * @return the DataEntrada
     */
    public Date getDataEntrada() {
        return DataEntrada;
    }

    /**
     * @param DataEntrada the DataEntrada to set
     */
    public void setDataEntrada(Date DataEntrada) {
        this.DataEntrada = DataEntrada;
    }

    /**
     * @return the HorarioEntrada
     */
    public String getHorarioEntrada() {
        return HorarioEntrada;
    }

    /**
     * @param HorarioEntrada the HorarioEntrada to set
     */
    public void setHorarioEntrada(String HorarioEntrada) {
        this.HorarioEntrada = HorarioEntrada;
    }

    /**
     * @return the DataSaida
     */
    public Date getDataSaida() {
        return DataSaida;
    }

    /**
     * @param DataSaida the DataSaida to set
     */
    public void setDataSaida(Date DataSaida) {
        this.DataSaida = DataSaida;
    }

    /**
     * @return the HorarioSaida
     */
    public String getHorarioSaida() {
        return HorarioSaida;
    }

    /**
     * @param HorarioSaida the HorarioSaida to set
     */
    public void setHorarioSaida(String HorarioSaida) {
        this.HorarioSaida = HorarioSaida;
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
     * @return the horaInsert
     */
    public String getHoraInsert() {
        return horaInsert;
    }

    /**
     * @param horaInsert the horaInsert to set
     */
    public void setHoraInsert(String horaInsert) {
        this.horaInsert = horaInsert;
    }

    /**
     * @return the horaUp
     */
    public String getHoraUp() {
        return horaUp;
    }

    /**
     * @param horaUp the horaUp to set
     */
    public void setHoraUp(String horaUp) {
        this.horaUp = horaUp;
    }
}
