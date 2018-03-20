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
public class Modulos {
    private int idModulo;
    private int idGrupo;
    private String nomeModulo;
    private String Permissao;
    private String nomeGrupo;

    public Modulos(int idModulo, int idGrupo, String nomeModulo, String Permissao, String nomeGrupo) {
        this.idModulo = idModulo;
        this.idGrupo = idGrupo;
        this.nomeModulo = nomeModulo;
        this.Permissao = Permissao;
        this.nomeGrupo = nomeGrupo;
    }

    public Modulos() {
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
     * @return the idGrupo
     */
    public int getIdGrupo() {
        return idGrupo;
    }

    /**
     * @param idGrupo the idGrupo to set
     */
    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
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

    /**
     * @return the Permissao
     */
    public String getPermissao() {
        return Permissao;
    }

    /**
     * @param Permissao the Permissao to set
     */
    public void setPermissao(String Permissao) {
        this.Permissao = Permissao;
    }

    /**
     * @return the nomeGrupo
     */
    public String getNomeGrupo() {
        return nomeGrupo;
    }

    /**
     * @param nomeGrupo the nomeGrupo to set
     */
    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    
}
