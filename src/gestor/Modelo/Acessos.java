/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author user
 */
public class Acessos {

    private int idAcesso;
    private Date dataLanc;
    private int idModulo;
    private String nomeModulo;
    private int idGrupo;
    private String nomeGrupo;
    private String permissao;

    public Acessos(int idAcesso, Date dataLanc, int idModulo, String nomeModulo, int idGrupo, String nomeGrupo, String permissao) {
        this.idAcesso = idAcesso;
        this.dataLanc = dataLanc;
        this.idModulo = idModulo;
        this.nomeModulo = nomeModulo;
        this.idGrupo = idGrupo;
        this.nomeGrupo = nomeGrupo;
        this.permissao = permissao;
    }

    public Acessos() {
    }

    /**
     * @return the idAcesso
     */
    public int getIdAcesso() {
        return idAcesso;
    }

    /**
     * @param idAcesso the idAcesso to set
     */
    public void setIdAcesso(int idAcesso) {
        this.idAcesso = idAcesso;
    }

    /**
     * @return the dataLanc
     */
    public Date getDataLanc() {
        return dataLanc;
    }

    /**
     * @param dataLanc the dataLanc to set
     */
    public void setDataLanc(Date dataLanc) {
        this.dataLanc = dataLanc;
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

    /**
     * @return the permissao
     */
    public String getPermissao() {
        return permissao;
    }

    /**
     * @param permissao the permissao to set
     */
    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
}
