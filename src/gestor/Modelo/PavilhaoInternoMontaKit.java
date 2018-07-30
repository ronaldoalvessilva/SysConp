/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronal
 */
public class PavilhaoInternoMontaKit {

    private int idInternoCrc;
    private String nomeInternoCrc;
    private String cncInternoCrc;
    private int idPav;
    private String descricaoPav;
    private boolean opcao;

    public PavilhaoInternoMontaKit() {
    }

    public PavilhaoInternoMontaKit(int idInternoCrc, String nomeInternoCrc, String cncInternoCrc, int idPav, String descricaoPav, boolean opcao) {
        this.idInternoCrc = idInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.cncInternoCrc = cncInternoCrc;
        this.idPav = idPav;
        this.descricaoPav = descricaoPav;
        this.opcao = opcao;
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
     * @return the nomeInternoCrc
     */
    public String getNomeInternoCrc() {
        return nomeInternoCrc;
    }

    /**
     * @param nomeInternoCrc the nomeInternoCrc to set
     */
    public void setNomeInternoCrc(String nomeInternoCrc) {
        this.nomeInternoCrc = nomeInternoCrc;
    }

    /**
     * @return the cncInternoCrc
     */
    public String getCncInternoCrc() {
        return cncInternoCrc;
    }

    /**
     * @param cncInternoCrc the cncInternoCrc to set
     */
    public void setCncInternoCrc(String cncInternoCrc) {
        this.cncInternoCrc = cncInternoCrc;
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
     * @return the descricaoPav
     */
    public String getDescricaoPav() {
        return descricaoPav;
    }

    /**
     * @param descricaoPav the descricaoPav to set
     */
    public void setDescricaoPav(String descricaoPav) {
        this.descricaoPav = descricaoPav;
    }

    /**
     * @return the opcao
     */
    public boolean isOpcao() {
        return opcao;
    }

    /**
     * @param opcao the opcao to set
     */
    public void setOpcao(boolean opcao) {
        this.opcao = opcao;
    }
    
}
