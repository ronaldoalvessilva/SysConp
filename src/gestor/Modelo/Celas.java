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
public class Celas {

    private int IdCela;
    private String statusCela;
    private int idPav;
    private String descricaoPavilhao;
    private String motivo;
    private String EndCelaPav;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;    
    private String nivelCela;    
    private int capacidade;
    private int numeroCela;    

    public Celas(int IdCela, String statusCela, int idPav, String descricaoPavilhao, String motivo, String EndCelaPav, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String nivelCela, int capacidade, int numeroCela) {
        this.IdCela = IdCela;
        this.statusCela = statusCela;
        this.idPav = idPav;
        this.descricaoPavilhao = descricaoPavilhao;
        this.motivo = motivo;
        this.EndCelaPav = EndCelaPav;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.nivelCela = nivelCela;
        this.capacidade = capacidade;
        this.numeroCela = numeroCela;
    }

    public Celas() {
    }

    /**
     * @return the IdCela
     */
    public int getIdCela() {
        return IdCela;
    }

    /**
     * @param IdCela the IdCela to set
     */
    public void setIdCela(int IdCela) {
        this.IdCela = IdCela;
    }

    /**
     * @return the statusCela
     */
    public String getStatusCela() {
        return statusCela;
    }

    /**
     * @param statusCela the statusCela to set
     */
    public void setStatusCela(String statusCela) {
        this.statusCela = statusCela;
    }

    /**
     * @return the idPav
     */
    public int getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(int idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the descricaoPavilhao
     */
    public String getDescricaoPavilhao() {
        return descricaoPavilhao;
    }

    /**
     * @param descricaoPavilhao the descricaoPavilhao to set
     */
    public void setDescricaoPavilhao(String descricaoPavilhao) {
        this.descricaoPavilhao = descricaoPavilhao;
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
     * @return the EndCelaPav
     */
    public String getEndCelaPav() {
        return EndCelaPav;
    }

    /**
     * @param EndCelaPav the EndCelaPav to set
     */
    public void setEndCelaPav(String EndCelaPav) {
        this.EndCelaPav = EndCelaPav;
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
     * @return the nivelCela
     */
    public String getNivelCela() {
        return nivelCela;
    }

    /**
     * @param nivelCela the nivelCela to set
     */
    public void setNivelCela(String nivelCela) {
        this.nivelCela = nivelCela;
    }

    /**
     * @return the capacidade
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * @param capacidade the capacidade to set
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    /**
     * @return the numeroCela
     */
    public int getNumeroCela() {
        return numeroCela;
    }

    /**
     * @param numeroCela the numeroCela to set
     */
    public void setNumeroCela(int numeroCela) {
        this.numeroCela = numeroCela;
    }
}
