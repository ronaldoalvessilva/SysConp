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
public class CamposAcessos {

    private int codigoUsuario;
    private String nomeUsuario;
    private int codigoUsuarioGrupo;
    private int codigoGrupo;
    private String nomeGrupo;
    private int codigoUsuarioAcesso;
    private String nomeTelaAcesso;
    private int codigoAbrir;
    private int codigoIncluir;
    private int codigoAlterar;
    private int codigoExcluir;
    private int codigoGravar;
    private int codigoConsultar;
    private String nomeTelaPesquisa;
    private String nomeTelaCadastrada;
    private int codigoModulo;
    private String nomeModulo;        

    public CamposAcessos() {
    }

    public CamposAcessos(int codigoUsuario, String nomeUsuario, int codigoUsuarioGrupo, int codigoGrupo, String nomeGrupo, int codigoUsuarioAcesso, String nomeTelaAcesso, int codigoAbrir, int codigoIncluir, int codigoAlterar, int codigoExcluir, int codigoGravar, int codigoConsultar, String nomeTelaPesquisa, String nomeTelaCadastrada, int codigoModulo, String nomeModulo) {
        this.codigoUsuario = codigoUsuario;
        this.nomeUsuario = nomeUsuario;
        this.codigoUsuarioGrupo = codigoUsuarioGrupo;
        this.codigoGrupo = codigoGrupo;
        this.nomeGrupo = nomeGrupo;
        this.codigoUsuarioAcesso = codigoUsuarioAcesso;
        this.nomeTelaAcesso = nomeTelaAcesso;
        this.codigoAbrir = codigoAbrir;
        this.codigoIncluir = codigoIncluir;
        this.codigoAlterar = codigoAlterar;
        this.codigoExcluir = codigoExcluir;
        this.codigoGravar = codigoGravar;
        this.codigoConsultar = codigoConsultar;
        this.nomeTelaPesquisa = nomeTelaPesquisa;
        this.nomeTelaCadastrada = nomeTelaCadastrada;
        this.codigoModulo = codigoModulo;
        this.nomeModulo = nomeModulo;
    }

    /**
     * @return the codigoUsuario
     */
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * @param codigoUsuario the codigoUsuario to set
     */
    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * @return the codigoUsuarioGrupo
     */
    public int getCodigoUsuarioGrupo() {
        return codigoUsuarioGrupo;
    }

    /**
     * @param codigoUsuarioGrupo the codigoUsuarioGrupo to set
     */
    public void setCodigoUsuarioGrupo(int codigoUsuarioGrupo) {
        this.codigoUsuarioGrupo = codigoUsuarioGrupo;
    }

    /**
     * @return the codigoGrupo
     */
    public int getCodigoGrupo() {
        return codigoGrupo;
    }

    /**
     * @param codigoGrupo the codigoGrupo to set
     */
    public void setCodigoGrupo(int codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
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
     * @return the codigoUsuarioAcesso
     */
    public int getCodigoUsuarioAcesso() {
        return codigoUsuarioAcesso;
    }

    /**
     * @param codigoUsuarioAcesso the codigoUsuarioAcesso to set
     */
    public void setCodigoUsuarioAcesso(int codigoUsuarioAcesso) {
        this.codigoUsuarioAcesso = codigoUsuarioAcesso;
    }

    /**
     * @return the nomeTelaAcesso
     */
    public String getNomeTelaAcesso() {
        return nomeTelaAcesso;
    }

    /**
     * @param nomeTelaAcesso the nomeTelaAcesso to set
     */
    public void setNomeTelaAcesso(String nomeTelaAcesso) {
        this.nomeTelaAcesso = nomeTelaAcesso;
    }

    /**
     * @return the codigoAbrir
     */
    public int getCodigoAbrir() {
        return codigoAbrir;
    }

    /**
     * @param codigoAbrir the codigoAbrir to set
     */
    public void setCodigoAbrir(int codigoAbrir) {
        this.codigoAbrir = codigoAbrir;
    }

    /**
     * @return the codigoIncluir
     */
    public int getCodigoIncluir() {
        return codigoIncluir;
    }

    /**
     * @param codigoIncluir the codigoIncluir to set
     */
    public void setCodigoIncluir(int codigoIncluir) {
        this.codigoIncluir = codigoIncluir;
    }

    /**
     * @return the codigoAlterar
     */
    public int getCodigoAlterar() {
        return codigoAlterar;
    }

    /**
     * @param codigoAlterar the codigoAlterar to set
     */
    public void setCodigoAlterar(int codigoAlterar) {
        this.codigoAlterar = codigoAlterar;
    }

    /**
     * @return the codigoExcluir
     */
    public int getCodigoExcluir() {
        return codigoExcluir;
    }

    /**
     * @param codigoExcluir the codigoExcluir to set
     */
    public void setCodigoExcluir(int codigoExcluir) {
        this.codigoExcluir = codigoExcluir;
    }

    /**
     * @return the codigoGravar
     */
    public int getCodigoGravar() {
        return codigoGravar;
    }

    /**
     * @param codigoGravar the codigoGravar to set
     */
    public void setCodigoGravar(int codigoGravar) {
        this.codigoGravar = codigoGravar;
    }

    /**
     * @return the codigoConsultar
     */
    public int getCodigoConsultar() {
        return codigoConsultar;
    }

    /**
     * @param codigoConsultar the codigoConsultar to set
     */
    public void setCodigoConsultar(int codigoConsultar) {
        this.codigoConsultar = codigoConsultar;
    }

    /**
     * @return the nomeTelaPesquisa
     */
    public String getNomeTelaPesquisa() {
        return nomeTelaPesquisa;
    }

    /**
     * @param nomeTelaPesquisa the nomeTelaPesquisa to set
     */
    public void setNomeTelaPesquisa(String nomeTelaPesquisa) {
        this.nomeTelaPesquisa = nomeTelaPesquisa;
    }

    /**
     * @return the nomeTelaCadastrada
     */
    public String getNomeTelaCadastrada() {
        return nomeTelaCadastrada;
    }

    /**
     * @param nomeTelaCadastrada the nomeTelaCadastrada to set
     */
    public void setNomeTelaCadastrada(String nomeTelaCadastrada) {
        this.nomeTelaCadastrada = nomeTelaCadastrada;
    }

    /**
     * @return the codigoModulo
     */
    public int getCodigoModulo() {
        return codigoModulo;
    }

    /**
     * @param codigoModulo the codigoModulo to set
     */
    public void setCodigoModulo(int codigoModulo) {
        this.codigoModulo = codigoModulo;
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
