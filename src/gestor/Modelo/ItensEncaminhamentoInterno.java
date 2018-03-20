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
public class ItensEncaminhamentoInterno {

    private int idItemEnca;
    private int idEnca;
    private int tipoEnca;
    private String descricaoEncaminhamento;
    private Date dataSaida;
    private String horaSaida;
    private Date dataRetorno;
    private String horaRetorno;
    private String motivo;
    private String destino;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;       

    public ItensEncaminhamentoInterno(int idItemEnca, int idEnca, int tipoEnca, String descricaoEncaminhamento, Date dataSaida, String horaSaida, Date dataRetorno, String horaRetorno, String motivo, String destino, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItemEnca = idItemEnca;
        this.idEnca = idEnca;
        this.tipoEnca = tipoEnca;
        this.descricaoEncaminhamento = descricaoEncaminhamento;
        this.dataSaida = dataSaida;
        this.horaSaida = horaSaida;
        this.dataRetorno = dataRetorno;
        this.horaRetorno = horaRetorno;
        this.motivo = motivo;
        this.destino = destino;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensEncaminhamentoInterno() {
    }

    /**
     * @return the idItemEnca
     */
    public int getIdItemEnca() {
        return idItemEnca;
    }

    /**
     * @param idItemEnca the idItemEnca to set
     */
    public void setIdItemEnca(int idItemEnca) {
        this.idItemEnca = idItemEnca;
    }

    /**
     * @return the idEnca
     */
    public int getIdEnca() {
        return idEnca;
    }

    /**
     * @param idEnca the idEnca to set
     */
    public void setIdEnca(int idEnca) {
        this.idEnca = idEnca;
    }

    /**
     * @return the tipoEnca
     */
    public int getTipoEnca() {
        return tipoEnca;
    }

    /**
     * @param tipoEnca the tipoEnca to set
     */
    public void setTipoEnca(int tipoEnca) {
        this.tipoEnca = tipoEnca;
    }

    /**
     * @return the descricaoEncaminhamento
     */
    public String getDescricaoEncaminhamento() {
        return descricaoEncaminhamento;
    }

    /**
     * @param descricaoEncaminhamento the descricaoEncaminhamento to set
     */
    public void setDescricaoEncaminhamento(String descricaoEncaminhamento) {
        this.descricaoEncaminhamento = descricaoEncaminhamento;
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
     * @return the horaSaida
     */
    public String getHoraSaida() {
        return horaSaida;
    }

    /**
     * @param horaSaida the horaSaida to set
     */
    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    /**
     * @return the dataRetorno
     */
    public Date getDataRetorno() {
        return dataRetorno;
    }

    /**
     * @param dataRetorno the dataRetorno to set
     */
    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    /**
     * @return the horaRetorno
     */
    public String getHoraRetorno() {
        return horaRetorno;
    }

    /**
     * @param horaRetorno the horaRetorno to set
     */
    public void setHoraRetorno(String horaRetorno) {
        this.horaRetorno = horaRetorno;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
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
