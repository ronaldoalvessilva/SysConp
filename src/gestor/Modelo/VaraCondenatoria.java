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
public class VaraCondenatoria {
    private int IdInternoCrc;
    private String nomeInternoCrc;
    private String descricaoVaraCondenatoria;    

    public VaraCondenatoria() {
    }

    public VaraCondenatoria(int IdInternoCrc, String nomeInternoCrc, String descricaoVaraCondenatoria) {
        this.IdInternoCrc = IdInternoCrc;
        this.nomeInternoCrc = nomeInternoCrc;
        this.descricaoVaraCondenatoria = descricaoVaraCondenatoria;
    }

    /**
     * @return the IdInternoCrc
     */
    public int getIdInternoCrc() {
        return IdInternoCrc;
    }

    /**
     * @param IdInternoCrc the IdInternoCrc to set
     */
    public void setIdInternoCrc(int IdInternoCrc) {
        this.IdInternoCrc = IdInternoCrc;
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
     * @return the descricaoVaraCondenatoria
     */
    public String getDescricaoVaraCondenatoria() {
        return descricaoVaraCondenatoria;
    }

    /**
     * @param descricaoVaraCondenatoria the descricaoVaraCondenatoria to set
     */
    public void setDescricaoVaraCondenatoria(String descricaoVaraCondenatoria) {
        this.descricaoVaraCondenatoria = descricaoVaraCondenatoria;
    }

    @Override
    public String toString() {
        return getDescricaoVaraCondenatoria(); //To change body of generated methods, choose Tools | Templates.
    }    
}
