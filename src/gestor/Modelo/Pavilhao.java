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
public class Pavilhao {

    private int IdPav;
    private String statusPavilhao;
    private String DescricaoPav;
    private String motivoInativacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;   
    private String nivelPavilhao;   

    public Pavilhao(int IdPav, String statusPavilhao, String DescricaoPav, String motivoInativacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String nivelPavilhao) {
        this.IdPav = IdPav;
        this.statusPavilhao = statusPavilhao;
        this.DescricaoPav = DescricaoPav;
        this.motivoInativacao = motivoInativacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.nivelPavilhao = nivelPavilhao;
    }

    public Pavilhao() {
    }

    /**
     * @return the IdPav
     */
    public int getIdPav() {
        return IdPav;
    }

    /**
     * @param IdPav the IdPav to set
     */
    public void setIdPav(int IdPav) {
        this.IdPav = IdPav;
    }

    /**
     * @return the statusPavilhao
     */
    public String getStatusPavilhao() {
        return statusPavilhao;
    }

    /**
     * @param statusPavilhao the statusPavilhao to set
     */
    public void setStatusPavilhao(String statusPavilhao) {
        this.statusPavilhao = statusPavilhao;
    }

    /**
     * @return the DescricaoPav
     */
    public String getDescricaoPav() {
        return DescricaoPav;
    }

    /**
     * @param DescricaoPav the DescricaoPav to set
     */
    public void setDescricaoPav(String DescricaoPav) {
        this.DescricaoPav = DescricaoPav;
    }

    /**
     * @return the motivoInativacao
     */
    public String getMotivoInativacao() {
        return motivoInativacao;
    }

    /**
     * @param motivoInativacao the motivoInativacao to set
     */
    public void setMotivoInativacao(String motivoInativacao) {
        this.motivoInativacao = motivoInativacao;
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

    /**
     * @return the nivelPavilhao
     */
    public String getNivelPavilhao() {
        return nivelPavilhao;
    }

    /**
     * @param nivelPavilhao the nivelPavilhao to set
     */
    public void setNivelPavilhao(String nivelPavilhao) {
        this.nivelPavilhao = nivelPavilhao;
    }

    @Override
    public String toString() {
        return getDescricaoPav(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
