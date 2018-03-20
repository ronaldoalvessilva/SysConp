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
public class ItensTratamentoInterno {

    private int idItemTrat;
    private int idAvalia;
    private int idDoenca;    
    private int idTipo;
    private String descricaoTipoTratamento;
    private String descricaoPatologia;
    private String tratamento;
    private String notificacao;
    private String outros;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;        

    public ItensTratamentoInterno(int idItemTrat, int idAvalia, int idDoenca, int idTipo, String descricaoTipoTratamento, String descricaoPatologia, String tratamento, String notificacao, String outros, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItemTrat = idItemTrat;
        this.idAvalia = idAvalia;
        this.idDoenca = idDoenca;
        this.idTipo = idTipo;
        this.descricaoTipoTratamento = descricaoTipoTratamento;
        this.descricaoPatologia = descricaoPatologia;
        this.tratamento = tratamento;
        this.notificacao = notificacao;
        this.outros = outros;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensTratamentoInterno() {
    }

    /**
     * @return the idItemTrat
     */
    public int getIdItemTrat() {
        return idItemTrat;
    }

    /**
     * @param idItemTrat the idItemTrat to set
     */
    public void setIdItemTrat(int idItemTrat) {
        this.idItemTrat = idItemTrat;
    }

    /**
     * @return the idAvalia
     */
    public int getIdAvalia() {
        return idAvalia;
    }

    /**
     * @param idAvalia the idAvalia to set
     */
    public void setIdAvalia(int idAvalia) {
        this.idAvalia = idAvalia;
    }

    /**
     * @return the idDoenca
     */
    public int getIdDoenca() {
        return idDoenca;
    }

    /**
     * @param idDoenca the idDoenca to set
     */
    public void setIdDoenca(int idDoenca) {
        this.idDoenca = idDoenca;
    }

    /**
     * @return the idTipo
     */
    public int getIdTipo() {
        return idTipo;
    }

    /**
     * @param idTipo the idTipo to set
     */
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    /**
     * @return the descricaoTipoTratamento
     */
    public String getDescricaoTipoTratamento() {
        return descricaoTipoTratamento;
    }

    /**
     * @param descricaoTipoTratamento the descricaoTipoTratamento to set
     */
    public void setDescricaoTipoTratamento(String descricaoTipoTratamento) {
        this.descricaoTipoTratamento = descricaoTipoTratamento;
    }

    /**
     * @return the descricaoPatologia
     */
    public String getDescricaoPatologia() {
        return descricaoPatologia;
    }

    /**
     * @param descricaoPatologia the descricaoPatologia to set
     */
    public void setDescricaoPatologia(String descricaoPatologia) {
        this.descricaoPatologia = descricaoPatologia;
    }

    /**
     * @return the tratamento
     */
    public String getTratamento() {
        return tratamento;
    }

    /**
     * @param tratamento the tratamento to set
     */
    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    /**
     * @return the notificacao
     */
    public String getNotificacao() {
        return notificacao;
    }

    /**
     * @param notificacao the notificacao to set
     */
    public void setNotificacao(String notificacao) {
        this.notificacao = notificacao;
    }

    /**
     * @return the outros
     */
    public String getOutros() {
        return outros;
    }

    /**
     * @param outros the outros to set
     */
    public void setOutros(String outros) {
        this.outros = outros;
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
