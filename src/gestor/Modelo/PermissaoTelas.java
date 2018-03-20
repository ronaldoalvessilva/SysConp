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
public class PermissaoTelas {
    private int IdTela;
    private String nomeTela;
    private String abrir;
    private String incluir;
    private String alterar;
    private String excluir;
    private String salvar;
    private String Relatorio;
    private String nomeModulo;

    public PermissaoTelas(int IdTela, String nomeTela, String abrir, String incluir, String alterar, String excluir, String salvar, String Relatorio, String nomeModulo) {
        this.IdTela = IdTela;
        this.nomeTela = nomeTela;
        this.abrir = abrir;
        this.incluir = incluir;
        this.alterar = alterar;
        this.excluir = excluir;
        this.salvar = salvar;
        this.Relatorio = Relatorio;
        this.nomeModulo = nomeModulo;
    }

    public PermissaoTelas() {
    }

    /**
     * @return the IdTela
     */
    public int getIdTela() {
        return IdTela;
    }

    /**
     * @param IdTela the IdTela to set
     */
    public void setIdTela(int IdTela) {
        this.IdTela = IdTela;
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
     * @return the abrir
     */
    public String getAbrir() {
        return abrir;
    }

    /**
     * @param abrir the abrir to set
     */
    public void setAbrir(String abrir) {
        this.abrir = abrir;
    }

    /**
     * @return the incluir
     */
    public String getIncluir() {
        return incluir;
    }

    /**
     * @param incluir the incluir to set
     */
    public void setIncluir(String incluir) {
        this.incluir = incluir;
    }

    /**
     * @return the alterar
     */
    public String getAlterar() {
        return alterar;
    }

    /**
     * @param alterar the alterar to set
     */
    public void setAlterar(String alterar) {
        this.alterar = alterar;
    }

    /**
     * @return the excluir
     */
    public String getExcluir() {
        return excluir;
    }

    /**
     * @param excluir the excluir to set
     */
    public void setExcluir(String excluir) {
        this.excluir = excluir;
    }

    /**
     * @return the salvar
     */
    public String getSalvar() {
        return salvar;
    }

    /**
     * @param salvar the salvar to set
     */
    public void setSalvar(String salvar) {
        this.salvar = salvar;
    }

    /**
     * @return the Relatorio
     */
    public String getRelatorio() {
        return Relatorio;
    }

    /**
     * @param Relatorio the Relatorio to set
     */
    public void setRelatorio(String Relatorio) {
        this.Relatorio = Relatorio;
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
