/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

/**
 *
 * @author ronaldo
 */
public class ItensDevolucaoAcervo {

    private int idItem;
    private int idDevolucao;
    private int idEmprestimo;
    private int tipoOperacao;
    private int idLivro;
    private String tituloLivro;
    private int quantidade;
    private int idEstoque;
    private float qtdEmprestada;
    private float saldoEstoque;
    private String utilizaEmprestimoAcervo;
    private String usuarioInsert;
    private String UsuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public ItensDevolucaoAcervo(int idItem, int idDevolucao, int idEmprestimo, int tipoOperacao, int idLivro, String tituloLivro, int quantidade, int idEstoque, float qtdEmprestada, float saldoEstoque, String utilizaEmprestimoAcervo, String usuarioInsert, String UsuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.idDevolucao = idDevolucao;
        this.idEmprestimo = idEmprestimo;
        this.tipoOperacao = tipoOperacao;
        this.idLivro = idLivro;
        this.tituloLivro = tituloLivro;
        this.quantidade = quantidade;
        this.idEstoque = idEstoque;
        this.qtdEmprestada = qtdEmprestada;
        this.saldoEstoque = saldoEstoque;
        this.utilizaEmprestimoAcervo = utilizaEmprestimoAcervo;
        this.usuarioInsert = usuarioInsert;
        this.UsuarioUp = UsuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ItensDevolucaoAcervo() {
    }

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the idDevolucao
     */
    public int getIdDevolucao() {
        return idDevolucao;
    }

    /**
     * @param idDevolucao the idDevolucao to set
     */
    public void setIdDevolucao(int idDevolucao) {
        this.idDevolucao = idDevolucao;
    }

    /**
     * @return the idEmprestimo
     */
    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    /**
     * @param idEmprestimo the idEmprestimo to set
     */
    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    /**
     * @return the tipoOperacao
     */
    public int getTipoOperacao() {
        return tipoOperacao;
    }

    /**
     * @param tipoOperacao the tipoOperacao to set
     */
    public void setTipoOperacao(int tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    /**
     * @return the idLivro
     */
    public int getIdLivro() {
        return idLivro;
    }

    /**
     * @param idLivro the idLivro to set
     */
    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    /**
     * @return the tituloLivro
     */
    public String getTituloLivro() {
        return tituloLivro;
    }

    /**
     * @param tituloLivro the tituloLivro to set
     */
    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the idEstoque
     */
    public int getIdEstoque() {
        return idEstoque;
    }

    /**
     * @param idEstoque the idEstoque to set
     */
    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    /**
     * @return the qtdEmprestada
     */
    public float getQtdEmprestada() {
        return qtdEmprestada;
    }

    /**
     * @param qtdEmprestada the qtdEmprestada to set
     */
    public void setQtdEmprestada(float qtdEmprestada) {
        this.qtdEmprestada = qtdEmprestada;
    }

    /**
     * @return the saldoEstoque
     */
    public float getSaldoEstoque() {
        return saldoEstoque;
    }

    /**
     * @param saldoEstoque the saldoEstoque to set
     */
    public void setSaldoEstoque(float saldoEstoque) {
        this.saldoEstoque = saldoEstoque;
    }

    /**
     * @return the utilizaEmprestimoAcervo
     */
    public String getUtilizaEmprestimoAcervo() {
        return utilizaEmprestimoAcervo;
    }

    /**
     * @param utilizaEmprestimoAcervo the utilizaEmprestimoAcervo to set
     */
    public void setUtilizaEmprestimoAcervo(String utilizaEmprestimoAcervo) {
        this.utilizaEmprestimoAcervo = utilizaEmprestimoAcervo;
    }

    /**
     * @return the usuarioInsert
     */
    public String getUsuarioInsert() {
        return usuarioInsert;
    }

    /**
     * @param usuarioInsert the usuarioInsert to set
     */
    public void setUsuarioInsert(String usuarioInsert) {
        this.usuarioInsert = usuarioInsert;
    }

    /**
     * @return the UsuarioUp
     */
    public String getUsuarioUp() {
        return UsuarioUp;
    }

    /**
     * @param UsuarioUp the UsuarioUp to set
     */
    public void setUsuarioUp(String UsuarioUp) {
        this.UsuarioUp = UsuarioUp;
    }

    /**
     * @return the dataInsert
     */
    public String getDataInsert() {
        return dataInsert;
    }

    /**
     * @param dataInsert the dataInsert to set
     */
    public void setDataInsert(String dataInsert) {
        this.dataInsert = dataInsert;
    }

    /**
     * @return the dataUp
     */
    public String getDataUp() {
        return dataUp;
    }

    /**
     * @param dataUp the dataUp to set
     */
    public void setDataUp(String dataUp) {
        this.dataUp = dataUp;
    }

    /**
     * @return the horarioInsert
     */
    public String getHorarioInsert() {
        return horarioInsert;
    }

    /**
     * @param horarioInsert the horarioInsert to set
     */
    public void setHorarioInsert(String horarioInsert) {
        this.horarioInsert = horarioInsert;
    }

    /**
     * @return the horarioUp
     */
    public String getHorarioUp() {
        return horarioUp;
    }

    /**
     * @param horarioUp the horarioUp to set
     */
    public void setHorarioUp(String horarioUp) {
        this.horarioUp = horarioUp;
    }
}
