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
public class ItensHistoricoDoencaAtual {
        private int itensIdHist;
	private int idHist;
	private int idDoenca;
        private String descricaoDoenca;
	private String grauParentresco;
	private String usuarioInsert;
	private String usuarioUp;	
	private String dataInsert;
	private String dataUp;	
	private String horarioInsert;
	private String horarioUp;

    public ItensHistoricoDoencaAtual(int itensIdHist, int idHist, int idDoenca, String descricaoDoenca, String grauParentresco, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.itensIdHist = itensIdHist;
        this.idHist = idHist;
        this.idDoenca = idDoenca;
        this.descricaoDoenca = descricaoDoenca;
        this.grauParentresco = grauParentresco;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensHistoricoDoencaAtual() {
    }

    /**
     * @return the itensIdHist
     */
    public int getItensIdHist() {
        return itensIdHist;
    }

    /**
     * @param itensIdHist the itensIdHist to set
     */
    public void setItensIdHist(int itensIdHist) {
        this.itensIdHist = itensIdHist;
    }

    /**
     * @return the idHist
     */
    public int getIdHist() {
        return idHist;
    }

    /**
     * @param idHist the idHist to set
     */
    public void setIdHist(int idHist) {
        this.idHist = idHist;
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
     * @return the descricaoDoenca
     */
    public String getDescricaoDoenca() {
        return descricaoDoenca;
    }

    /**
     * @param descricaoDoenca the descricaoDoenca to set
     */
    public void setDescricaoDoenca(String descricaoDoenca) {
        this.descricaoDoenca = descricaoDoenca;
    }

    /**
     * @return the grauParentresco
     */
    public String getGrauParentresco() {
        return grauParentresco;
    }

    /**
     * @param grauParentresco the grauParentresco to set
     */
    public void setGrauParentresco(String grauParentresco) {
        this.grauParentresco = grauParentresco;
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
