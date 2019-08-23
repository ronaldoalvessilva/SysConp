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
public class ProntuarioPesquisaRel {

    private int idInterno;
    private String nomeInterno;
    private String nomeMae;
    private String rgInterno;
    private String cpfInterno;   

    public ProntuarioPesquisaRel() {
    }

    public ProntuarioPesquisaRel(int idInterno, String nomeInterno, String nomeMae, String rgInterno, String cpfInterno) {
        this.idInterno = idInterno;
        this.nomeInterno = nomeInterno;
        this.nomeMae = nomeMae;
        this.rgInterno = rgInterno;
        this.cpfInterno = cpfInterno;
    }
    

    /**
     * @return the idInterno
     */
    public int getIdInterno() {
        return idInterno;
    }

    /**
     * @param idInterno the idInterno to set
     */
    public void setIdInterno(int idInterno) {
        this.idInterno = idInterno;
    }

    /**
     * @return the nomeInterno
     */
    public String getNomeInterno() {
        return nomeInterno;
    }

    /**
     * @param nomeInterno the nomeInterno to set
     */
    public void setNomeInterno(String nomeInterno) {
        this.nomeInterno = nomeInterno;
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

    /**
     * @return the rgInterno
     */
    public String getRgInterno() {
        return rgInterno;
    }

    /**
     * @param rgInterno the rgInterno to set
     */
    public void setRgInterno(String rgInterno) {
        this.rgInterno = rgInterno;
    }

    /**
     * @return the cpfInterno
     */
    public String getCpfInterno() {
        return cpfInterno;
    }

    /**
     * @param cpfInterno the cpfInterno to set
     */
    public void setCpfInterno(String cpfInterno) {
        this.cpfInterno = cpfInterno;
    }
    @Override
    public String toString() {
        return getNomeInterno();

    }
}
