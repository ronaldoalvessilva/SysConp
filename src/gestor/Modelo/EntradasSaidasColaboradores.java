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
public class EntradasSaidasColaboradores {

    private Integer idRegistro;
    private String statusRegistro;
    private Date dataRegistro;
    private String operacao;
    private String tipoMovimento;
    private String unidadeOrigem;
    private String unidadeDestino;
    private String motivo;
    private Integer idItem;
    private Integer idColaborador;
    private String matricula;
    private String funcao;
    private String nomeColaborador;
    private String nomeMaeColaborador;
    private Date dataEvento;
    private Date dataRetrono;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;

    public EntradasSaidasColaboradores() {
    }

    public EntradasSaidasColaboradores(Integer idRegistro, String statusRegistro, Date dataRegistro, String operacao, String tipoMovimento, String unidadeOrigem, String unidadeDestino, String motivo, Integer idItem, Integer idColaborador, String matricula, String funcao, String nomeColaborador, String nomeMaeColaborador, Date dataEvento, Date dataRetrono, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idRegistro = idRegistro;
        this.statusRegistro = statusRegistro;
        this.dataRegistro = dataRegistro;
        this.operacao = operacao;
        this.tipoMovimento = tipoMovimento;
        this.unidadeOrigem = unidadeOrigem;
        this.unidadeDestino = unidadeDestino;
        this.motivo = motivo;
        this.idItem = idItem;
        this.idColaborador = idColaborador;
        this.matricula = matricula;
        this.funcao = funcao;
        this.nomeColaborador = nomeColaborador;
        this.nomeMaeColaborador = nomeMaeColaborador;
        this.dataEvento = dataEvento;
        this.dataRetrono = dataRetrono;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    /**
     * @return the idRegistro
     */
    public Integer getIdRegistro() {
        return idRegistro;
    }

    /**
     * @param idRegistro the idRegistro to set
     */
    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    /**
     * @return the statusRegistro
     */
    public String getStatusRegistro() {
        return statusRegistro;
    }

    /**
     * @param statusRegistro the statusRegistro to set
     */
    public void setStatusRegistro(String statusRegistro) {
        this.statusRegistro = statusRegistro;
    }

    /**
     * @return the dataRegistro
     */
    public Date getDataRegistro() {
        return dataRegistro;
    }

    /**
     * @param dataRegistro the dataRegistro to set
     */
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    /**
     * @return the operacao
     */
    public String getOperacao() {
        return operacao;
    }

    /**
     * @param operacao the operacao to set
     */
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    /**
     * @return the tipoMovimento
     */
    public String getTipoMovimento() {
        return tipoMovimento;
    }

    /**
     * @param tipoMovimento the tipoMovimento to set
     */
    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    /**
     * @return the unidadeOrigem
     */
    public String getUnidadeOrigem() {
        return unidadeOrigem;
    }

    /**
     * @param unidadeOrigem the unidadeOrigem to set
     */
    public void setUnidadeOrigem(String unidadeOrigem) {
        this.unidadeOrigem = unidadeOrigem;
    }

    /**
     * @return the unidadeDestino
     */
    public String getUnidadeDestino() {
        return unidadeDestino;
    }

    /**
     * @param unidadeDestino the unidadeDestino to set
     */
    public void setUnidadeDestino(String unidadeDestino) {
        this.unidadeDestino = unidadeDestino;
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
     * @return the idColaborador
     */
    public Integer getIdColaborador() {
        return idColaborador;
    }

    /**
     * @param idColaborador the idColaborador to set
     */
    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * @return the nomeColaborador
     */
    public String getNomeColaborador() {
        return nomeColaborador;
    }

    /**
     * @param nomeColaborador the nomeColaborador to set
     */
    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    /**
     * @return the nomeMaeColaborador
     */
    public String getNomeMaeColaborador() {
        return nomeMaeColaborador;
    }

    /**
     * @param nomeMaeColaborador the nomeMaeColaborador to set
     */
    public void setNomeMaeColaborador(String nomeMaeColaborador) {
        this.nomeMaeColaborador = nomeMaeColaborador;
    }

    /**
     * @return the dataEvento
     */
    public Date getDataEvento() {
        return dataEvento;
    }

    /**
     * @param dataEvento the dataEvento to set
     */
    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    /**
     * @return the dataRetrono
     */
    public Date getDataRetrono() {
        return dataRetrono;
    }

    /**
     * @param dataRetrono the dataRetrono to set
     */
    public void setDataRetrono(Date dataRetrono) {
        this.dataRetrono = dataRetrono;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.idRegistro);
        hash = 31 * hash + Objects.hashCode(this.idItem);
        hash = 31 * hash + Objects.hashCode(this.idColaborador);
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
        final EntradasSaidasColaboradores other = (EntradasSaidasColaboradores) obj;
        if (!Objects.equals(this.idRegistro, other.idRegistro)) {
            return false;
        }
        if (!Objects.equals(this.idItem, other.idItem)) {
            return false;
        }
        if (!Objects.equals(this.idColaborador, other.idColaborador)) {
            return false;
        }
        return true;
    }
}
