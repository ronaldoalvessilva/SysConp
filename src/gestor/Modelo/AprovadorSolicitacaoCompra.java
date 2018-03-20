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
public class AprovadorSolicitacaoCompra {

    private int idFuncAprova;
    private String fotoFuncAprova;
    private String statusAprova;
    private String tipoAprova;
    private String nomeAprovador;
    private int idDepartamento;
    private String nomeColaborador;
    private String descricaoDepartamento;
    private Float valorSolicita;
    private Float valorPedido;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;          

    public AprovadorSolicitacaoCompra(int idFuncAprova, String fotoFuncAprova, String statusAprova, String tipoAprova, String nomeAprovador, int idDepartamento, String nomeColaborador, String descricaoDepartamento, Float valorSolicita, Float valorPedido, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idFuncAprova = idFuncAprova;
        this.fotoFuncAprova = fotoFuncAprova;
        this.statusAprova = statusAprova;
        this.tipoAprova = tipoAprova;
        this.nomeAprovador = nomeAprovador;
        this.idDepartamento = idDepartamento;
        this.nomeColaborador = nomeColaborador;
        this.descricaoDepartamento = descricaoDepartamento;
        this.valorSolicita = valorSolicita;
        this.valorPedido = valorPedido;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public AprovadorSolicitacaoCompra() {
    }

    /**
     * @return the idFuncAprova
     */
    public int getIdFuncAprova() {
        return idFuncAprova;
    }

    /**
     * @param idFuncAprova the idFuncAprova to set
     */
    public void setIdFuncAprova(int idFuncAprova) {
        this.idFuncAprova = idFuncAprova;
    }

    /**
     * @return the fotoFuncAprova
     */
    public String getFotoFuncAprova() {
        return fotoFuncAprova;
    }

    /**
     * @param fotoFuncAprova the fotoFuncAprova to set
     */
    public void setFotoFuncAprova(String fotoFuncAprova) {
        this.fotoFuncAprova = fotoFuncAprova;
    }

    /**
     * @return the statusAprova
     */
    public String getStatusAprova() {
        return statusAprova;
    }

    /**
     * @param statusAprova the statusAprova to set
     */
    public void setStatusAprova(String statusAprova) {
        this.statusAprova = statusAprova;
    }

    /**
     * @return the tipoAprova
     */
    public String getTipoAprova() {
        return tipoAprova;
    }

    /**
     * @param tipoAprova the tipoAprova to set
     */
    public void setTipoAprova(String tipoAprova) {
        this.tipoAprova = tipoAprova;
    }

    /**
     * @return the nomeAprovador
     */
    public String getNomeAprovador() {
        return nomeAprovador;
    }

    /**
     * @param nomeAprovador the nomeAprovador to set
     */
    public void setNomeAprovador(String nomeAprovador) {
        this.nomeAprovador = nomeAprovador;
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
     * @return the descricaoDepartamento
     */
    public String getDescricaoDepartamento() {
        return descricaoDepartamento;
    }

    /**
     * @param descricaoDepartamento the descricaoDepartamento to set
     */
    public void setDescricaoDepartamento(String descricaoDepartamento) {
        this.descricaoDepartamento = descricaoDepartamento;
    }

    /**
     * @return the valorSolicita
     */
    public Float getValorSolicita() {
        return valorSolicita;
    }

    /**
     * @param valorSolicita the valorSolicita to set
     */
    public void setValorSolicita(Float valorSolicita) {
        this.valorSolicita = valorSolicita;
    }

    /**
     * @return the valorPedido
     */
    public Float getValorPedido() {
        return valorPedido;
    }

    /**
     * @param valorPedido the valorPedido to set
     */
    public void setValorPedido(Float valorPedido) {
        this.valorPedido = valorPedido;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
