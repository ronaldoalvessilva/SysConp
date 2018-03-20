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
public class CriarTabela {
    private String nomeTabela;

    public CriarTabela(String nomeTabela) {
        this.nomeTabela = nomeTabela;
    }

    public CriarTabela() {
    }

    /**
     * @return the nomeTabela
     */
    public String getNomeTabela() {
        return nomeTabela;
    }

    /**
     * @param nomeTabela the nomeTabela to set
     */
    public void setNomeTabela(String nomeTabela) {
        this.nomeTabela = nomeTabela;
    }
}
