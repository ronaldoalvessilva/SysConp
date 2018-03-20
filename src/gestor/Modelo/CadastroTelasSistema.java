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
public class CadastroTelasSistema {

    private int idTelas;
    private int idModulo;
    private String nomeTela;
    private String nomeModulo;

    public CadastroTelasSistema(int idTelas, int idModulo, String nomeTela, String nomeModulo) {
        this.idTelas = idTelas;
        this.idModulo = idModulo;
        this.nomeTela = nomeTela;
        this.nomeModulo = nomeModulo;
    }

    public CadastroTelasSistema() {
    }

    /**
     * @return the idTelas
     */
    public int getIdTelas() {
        return idTelas;
    }

    /**
     * @param idTelas the idTelas to set
     */
    public void setIdTelas(int idTelas) {
        this.idTelas = idTelas;
    }

    /**
     * @return the idModulo
     */
    public int getIdModulo() {
        return idModulo;
    }

    /**
     * @param idModulo the idModulo to set
     */
    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    /**
     * @return the nomeTela
     */
    public String getNomeTela() {
        return nomeTela;
    }

    /**
     * @param nomeTela the nomeTela to set
     */
    public void setNomeTela(String nomeTela) {
        this.nomeTela = nomeTela;
    }

    /**
     * @return the nomeModulo
     */
    public String getNomeModulo() {
        return nomeModulo;
    }

    /**
     * @param nomeModulo the nomeModulo to set
     */
    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }
}
