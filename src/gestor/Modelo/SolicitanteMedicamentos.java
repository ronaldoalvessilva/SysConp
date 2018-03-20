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
public class SolicitanteMedicamentos {

    private int idSolicitante;
    private String StatusSoli;
    private String fotoSolicitante;
    private String nomeSolicitante;
    private String matriculaSolicitante;
    private String cargoSolicitante;
    private int idDepartamento;
    private String descricaoDepartamento;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;      

    public SolicitanteMedicamentos(int idSolicitante, String StatusSoli, String fotoSolicitante, String nomeSolicitante, String matriculaSolicitante, String cargoSolicitante, int idDepartamento, String descricaoDepartamento, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idSolicitante = idSolicitante;
        this.StatusSoli = StatusSoli;
        this.fotoSolicitante = fotoSolicitante;
        this.nomeSolicitante = nomeSolicitante;
        this.matriculaSolicitante = matriculaSolicitante;
        this.cargoSolicitante = cargoSolicitante;
        this.idDepartamento = idDepartamento;
        this.descricaoDepartamento = descricaoDepartamento;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public SolicitanteMedicamentos() {
    }

    /**
     * @return the idSolicitante
     */
    public int getIdSolicitante() {
        return idSolicitante;
    }

    /**
     * @param idSolicitante the idSolicitante to set
     */
    public void setIdSolicitante(int idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    /**
     * @return the StatusSoli
     */
    public String getStatusSoli() {
        return StatusSoli;
    }

    /**
     * @param StatusSoli the StatusSoli to set
     */
    public void setStatusSoli(String StatusSoli) {
        this.StatusSoli = StatusSoli;
    }

    /**
     * @return the fotoSolicitante
     */
    public String getFotoSolicitante() {
        return fotoSolicitante;
    }

    /**
     * @param fotoSolicitante the fotoSolicitante to set
     */
    public void setFotoSolicitante(String fotoSolicitante) {
        this.fotoSolicitante = fotoSolicitante;
    }

    /**
     * @return the nomeSolicitante
     */
    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    /**
     * @param nomeSolicitante the nomeSolicitante to set
     */
    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }

    /**
     * @return the matriculaSolicitante
     */
    public String getMatriculaSolicitante() {
        return matriculaSolicitante;
    }

    /**
     * @param matriculaSolicitante the matriculaSolicitante to set
     */
    public void setMatriculaSolicitante(String matriculaSolicitante) {
        this.matriculaSolicitante = matriculaSolicitante;
    }

    /**
     * @return the cargoSolicitante
     */
    public String getCargoSolicitante() {
        return cargoSolicitante;
    }

    /**
     * @param cargoSolicitante the cargoSolicitante to set
     */
    public void setCargoSolicitante(String cargoSolicitante) {
        this.cargoSolicitante = cargoSolicitante;
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
