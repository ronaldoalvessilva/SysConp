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
public class EstornoRequisicaoMateriais {

    private int IdEstorno;
    private String StatusEstorno;
    private Date DataEstorno;
    private int tipoEstorno;
    private Date DataReq;
    private int localEstoque;
    private int idRequisicao;
    private String nomeRequisitante;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;    

    public EstornoRequisicaoMateriais(int IdEstorno, String StatusEstorno, Date DataEstorno, int tipoEstorno, Date DataReq, int localEstoque, int idRequisicao, String nomeRequisitante, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.IdEstorno = IdEstorno;
        this.StatusEstorno = StatusEstorno;
        this.DataEstorno = DataEstorno;
        this.tipoEstorno = tipoEstorno;
        this.DataReq = DataReq;
        this.localEstoque = localEstoque;
        this.idRequisicao = idRequisicao;
        this.nomeRequisitante = nomeRequisitante;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public EstornoRequisicaoMateriais() {
    }

    /**
     * @return the IdEstorno
     */
    public int getIdEstorno() {
        return IdEstorno;
    }

    /**
     * @param IdEstorno the IdEstorno to set
     */
    public void setIdEstorno(int IdEstorno) {
        this.IdEstorno = IdEstorno;
    }

    /**
     * @return the StatusEstorno
     */
    public String getStatusEstorno() {
        return StatusEstorno;
    }

    /**
     * @param StatusEstorno the StatusEstorno to set
     */
    public void setStatusEstorno(String StatusEstorno) {
        this.StatusEstorno = StatusEstorno;
    }

    /**
     * @return the DataEstorno
     */
    public Date getDataEstorno() {
        return DataEstorno;
    }

    /**
     * @param DataEstorno the DataEstorno to set
     */
    public void setDataEstorno(Date DataEstorno) {
        this.DataEstorno = DataEstorno;
    }

    /**
     * @return the tipoEstorno
     */
    public int getTipoEstorno() {
        return tipoEstorno;
    }

    /**
     * @param tipoEstorno the tipoEstorno to set
     */
    public void setTipoEstorno(int tipoEstorno) {
        this.tipoEstorno = tipoEstorno;
    }

    /**
     * @return the DataReq
     */
    public Date getDataReq() {
        return DataReq;
    }

    /**
     * @param DataReq the DataReq to set
     */
    public void setDataReq(Date DataReq) {
        this.DataReq = DataReq;
    }

    /**
     * @return the localEstoque
     */
    public int getLocalEstoque() {
        return localEstoque;
    }

    /**
     * @param localEstoque the localEstoque to set
     */
    public void setLocalEstoque(int localEstoque) {
        this.localEstoque = localEstoque;
    }

    /**
     * @return the idRequisicao
     */
    public int getIdRequisicao() {
        return idRequisicao;
    }

    /**
     * @param idRequisicao the idRequisicao to set
     */
    public void setIdRequisicao(int idRequisicao) {
        this.idRequisicao = idRequisicao;
    }

    /**
     * @return the nomeRequisitante
     */
    public String getNomeRequisitante() {
        return nomeRequisitante;
    }

    /**
     * @param nomeRequisitante the nomeRequisitante to set
     */
    public void setNomeRequisitante(String nomeRequisitante) {
        this.nomeRequisitante = nomeRequisitante;
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
