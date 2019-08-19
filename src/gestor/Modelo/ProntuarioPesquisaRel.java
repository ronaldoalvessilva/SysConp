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

    public ProntuarioPesquisaRel() {
    }

    public ProntuarioPesquisaRel(int idInterno, String nomeInterno) {
        this.idInterno = idInterno;
        this.nomeInterno = nomeInterno;
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

    @Override
    public String toString() {
        return getNomeInterno();

    }
}
