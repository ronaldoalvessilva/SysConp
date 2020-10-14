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
public class AtivarDesativarAlertaEntradas {

    private Integer idItem;
    private Integer numeroRegistro;
    private Date dataEntrada;
    private String horaEntrada;
    private String numeroOficio;
    private int idInternoCrc;
    private String nomeInterno;
    private String origemInterno;
    private String confirmaEntrada;
    private String ativaDesativa; 
    private String tipoEntradaSaida;
    private String usuarioInsert;
    private String dataInsert;
    private String horarioInsert;
    private String usuarioUp;
    private String dataUp;
    private String horarioUp;

    public AtivarDesativarAlertaEntradas() {
    }

    public AtivarDesativarAlertaEntradas(Integer idItem, Integer numeroRegistro, Date dataEntrada, String horaEntrada, String numeroOficio, int idInternoCrc, String nomeInterno, String origemInterno, String confirmaEntrada, String ativaDesativa, String tipoEntradaSaida, String usuarioInsert, String dataInsert, String horarioInsert, String usuarioUp, String dataUp, String horarioUp) {
        this.idItem = idItem;
        this.numeroRegistro = numeroRegistro;
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
        this.numeroOficio = numeroOficio;
        this.idInternoCrc = idInternoCrc;
        this.nomeInterno = nomeInterno;
        this.origemInterno = origemInterno;
        this.confirmaEntrada = confirmaEntrada;
        this.ativaDesativa = ativaDesativa;
        this.tipoEntradaSaida = tipoEntradaSaida;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horarioInsert = horarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idItem
     */
    public Integer getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the numeroRegistro
     */
    public Integer getNumeroRegistro() {
        return numeroRegistro;
    }

    /**
     * @param numeroRegistro the numeroRegistro to set
     */
    public void setNumeroRegistro(Integer numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    /**
     * @return the dataEntrada
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the horaEntrada
     */
    public String getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * @return the numeroOficio
     */
    public String getNumeroOficio() {
        return numeroOficio;
    }

    /**
     * @param numeroOficio the numeroOficio to set
     */
    public void setNumeroOficio(String numeroOficio) {
        this.numeroOficio = numeroOficio;
    }

    /**
     * @return the idInternoCrc
     */
    public int getIdInternoCrc() {
        return idInternoCrc;
    }

    /**
     * @param idInternoCrc the idInternoCrc to set
     */
    public void setIdInternoCrc(int idInternoCrc) {
        this.idInternoCrc = idInternoCrc;
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
     * @return the origemInterno
     */
    public String getOrigemInterno() {
        return origemInterno;
    }

    /**
     * @param origemInterno the origemInterno to set
     */
    public void setOrigemInterno(String origemInterno) {
        this.origemInterno = origemInterno;
    }

    /**
     * @return the confirmaEntrada
     */
    public String getConfirmaEntrada() {
        return confirmaEntrada;
    }

    /**
     * @param confirmaEntrada the confirmaEntrada to set
     */
    public void setConfirmaEntrada(String confirmaEntrada) {
        this.confirmaEntrada = confirmaEntrada;
    }

    /**
     * @return the ativaDesativa
     */
    public String getAtivaDesativa() {
        return ativaDesativa;
    }

    /**
     * @param ativaDesativa the ativaDesativa to set
     */
    public void setAtivaDesativa(String ativaDesativa) {
        this.ativaDesativa = ativaDesativa;
    }

    /**
     * @return the tipoEntradaSaida
     */
    public String getTipoEntradaSaida() {
        return tipoEntradaSaida;
    }

    /**
     * @param tipoEntradaSaida the tipoEntradaSaida to set
     */
    public void setTipoEntradaSaida(String tipoEntradaSaida) {
        this.tipoEntradaSaida = tipoEntradaSaida;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.idItem);
        hash = 61 * hash + Objects.hashCode(this.numeroRegistro);
        hash = 61 * hash + this.idInternoCrc;
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
        final AtivarDesativarAlertaEntradas other = (AtivarDesativarAlertaEntradas) obj;
        if (this.idInternoCrc != other.idInternoCrc) {
            return false;
        }
        if (!Objects.equals(this.idItem, other.idItem)) {
            return false;
        }
        if (!Objects.equals(this.numeroRegistro, other.numeroRegistro)) {
            return false;
        }
        return true;
    }
}
