/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author Socializa TI 02
 */
public class ColaboradorDocumentos {
    
    private int idColaborador;
    private String nomeColaborador;
    private String cPf;
    private String rG;   
    private String nomeMae;

    public ColaboradorDocumentos() {
    }

    public ColaboradorDocumentos(int idColaborador, String nomeColaborador, String cPf, String rG, String nomeMae) {
        this.idColaborador = idColaborador;
        this.nomeColaborador = nomeColaborador;
        this.cPf = cPf;
        this.rG = rG;
        this.nomeMae = nomeMae;
    }

    /**
     * @return the idColaborador
     */
    public int getIdColaborador() {
        return idColaborador;
    }

    /**
     * @param idColaborador the idColaborador to set
     */
    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
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
     * @return the cPf
     */
    public String getcPf() {
        return cPf;
    }

    /**
     * @param cPf the cPf to set
     */
    public void setcPf(String cPf) {
        this.cPf = cPf;
    }

    /**
     * @return the rG
     */
    public String getrG() {
        return rG;
    }

    /**
     * @param rG the rG to set
     */
    public void setrG(String rG) {
        this.rG = rG;
    }

    /**
     * @return the nomeMae
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * @param nomeMae the nomeMae to set
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }
}
