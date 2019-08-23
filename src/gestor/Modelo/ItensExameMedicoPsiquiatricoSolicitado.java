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
public class ItensExameMedicoPsiquiatricoSolicitado {

    private int idItemExame;
    private int IdSolExame;
    private int idExame;
    private String descricaoExame;
    private int idInternoCrc;
    private String nomeInternoExame;
    private String primeiraAmostra;
    private String segundaAmostra;
    private String terceiraAmostra;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;    
    private String nomeSolicitante;
    private String exameRealizado;
    private String motivoRealizado;

    public ItensExameMedicoPsiquiatricoSolicitado() {
    }

    public ItensExameMedicoPsiquiatricoSolicitado(int idItemExame, int IdSolExame, int idExame, String descricaoExame, int idInternoCrc, String nomeInternoExame, String primeiraAmostra, String segundaAmostra, String terceiraAmostra, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String nomeSolicitante, String exameRealizado, String motivoRealizado) {
        this.idItemExame = idItemExame;
        this.IdSolExame = IdSolExame;
        this.idExame = idExame;
        this.descricaoExame = descricaoExame;
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoExame = nomeInternoExame;
        this.primeiraAmostra = primeiraAmostra;
        this.segundaAmostra = segundaAmostra;
        this.terceiraAmostra = terceiraAmostra;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.nomeSolicitante = nomeSolicitante;
        this.exameRealizado = exameRealizado;
        this.motivoRealizado = motivoRealizado;
    }

    /**
     * @return the idItemExame
     */
    public int getIdItemExame() {
        return idItemExame;
    }

    /**
     * @param idItemExame the idItemExame to set
     */
    public void setIdItemExame(int idItemExame) {
        this.idItemExame = idItemExame;
    }

    /**
     * @return the IdSolExame
     */
    public int getIdSolExame() {
        return IdSolExame;
    }

    /**
     * @param IdSolExame the IdSolExame to set
     */
    public void setIdSolExame(int IdSolExame) {
        this.IdSolExame = IdSolExame;
    }

    /**
     * @return the idExame
     */
    public int getIdExame() {
        return idExame;
    }

    /**
     * @param idExame the idExame to set
     */
    public void setIdExame(int idExame) {
        this.idExame = idExame;
    }

    /**
     * @return the descricaoExame
     */
    public String getDescricaoExame() {
        return descricaoExame;
    }

    /**
     * @param descricaoExame the descricaoExame to set
     */
    public void setDescricaoExame(String descricaoExame) {
        this.descricaoExame = descricaoExame;
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
     * @return the nomeInternoExame
     */
    public String getNomeInternoExame() {
        return nomeInternoExame;
    }

    /**
     * @param nomeInternoExame the nomeInternoExame to set
     */
    public void setNomeInternoExame(String nomeInternoExame) {
        this.nomeInternoExame = nomeInternoExame;
    }

    /**
     * @return the primeiraAmostra
     */
    public String getPrimeiraAmostra() {
        return primeiraAmostra;
    }

    /**
     * @param primeiraAmostra the primeiraAmostra to set
     */
    public void setPrimeiraAmostra(String primeiraAmostra) {
        this.primeiraAmostra = primeiraAmostra;
    }

    /**
     * @return the segundaAmostra
     */
    public String getSegundaAmostra() {
        return segundaAmostra;
    }

    /**
     * @param segundaAmostra the segundaAmostra to set
     */
    public void setSegundaAmostra(String segundaAmostra) {
        this.segundaAmostra = segundaAmostra;
    }

    /**
     * @return the terceiraAmostra
     */
    public String getTerceiraAmostra() {
        return terceiraAmostra;
    }

    /**
     * @param terceiraAmostra the terceiraAmostra to set
     */
    public void setTerceiraAmostra(String terceiraAmostra) {
        this.terceiraAmostra = terceiraAmostra;
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
     * @return the exameRealizado
     */
    public String getExameRealizado() {
        return exameRealizado;
    }

    /**
     * @param exameRealizado the exameRealizado to set
     */
    public void setExameRealizado(String exameRealizado) {
        this.exameRealizado = exameRealizado;
    }

    /**
     * @return the motivoRealizado
     */
    public String getMotivoRealizado() {
        return motivoRealizado;
    }

    /**
     * @param motivoRealizado the motivoRealizado to set
     */
    public void setMotivoRealizado(String motivoRealizado) {
        this.motivoRealizado = motivoRealizado;
    }
}
