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
public class ProdutosCotacaoCompras {

    private int idItem;
    private int idCota;
    private int idFor;
    private String nomeFornecedor;
    private int idDepartamento;
    private int idProd;
    private int idSol;
    private float qtdItem;
    private float valorUnitario;
    private float valorTotalProduto;
    private String nomeDepartamnto;
    private String nomeProduto;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;      

    public ProdutosCotacaoCompras(int idItem, int idCota, int idFor, String nomeFornecedor, int idDepartamento, int idProd, int idSol, float qtdItem, float valorUnitario, float valorTotalProduto, String nomeDepartamnto, String nomeProduto, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.idCota = idCota;
        this.idFor = idFor;
        this.nomeFornecedor = nomeFornecedor;
        this.idDepartamento = idDepartamento;
        this.idProd = idProd;
        this.idSol = idSol;
        this.qtdItem = qtdItem;
        this.valorUnitario = valorUnitario;
        this.valorTotalProduto = valorTotalProduto;
        this.nomeDepartamnto = nomeDepartamnto;
        this.nomeProduto = nomeProduto;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public ProdutosCotacaoCompras() {
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
     * @return the idCota
     */
    public int getIdCota() {
        return idCota;
    }

    /**
     * @param idCota the idCota to set
     */
    public void setIdCota(int idCota) {
        this.idCota = idCota;
    }

    /**
     * @return the idFor
     */
    public int getIdFor() {
        return idFor;
    }

    /**
     * @param idFor the idFor to set
     */
    public void setIdFor(int idFor) {
        this.idFor = idFor;
    }

    /**
     * @return the nomeFornecedor
     */
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    /**
     * @param nomeFornecedor the nomeFornecedor to set
     */
    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    /**
     * @return the idDepartamento
     */
    public int getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    /**
     * @return the idProd
     */
    public int getIdProd() {
        return idProd;
    }

    /**
     * @param idProd the idProd to set
     */
    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    /**
     * @return the idSol
     */
    public int getIdSol() {
        return idSol;
    }

    /**
     * @param idSol the idSol to set
     */
    public void setIdSol(int idSol) {
        this.idSol = idSol;
    }

    /**
     * @return the qtdItem
     */
    public float getQtdItem() {
        return qtdItem;
    }

    /**
     * @param qtdItem the qtdItem to set
     */
    public void setQtdItem(float qtdItem) {
        this.qtdItem = qtdItem;
    }

    /**
     * @return the valorUnitario
     */
    public float getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the valorTotalProduto
     */
    public float getValorTotalProduto() {
        return valorTotalProduto;
    }

    /**
     * @param valorTotalProduto the valorTotalProduto to set
     */
    public void setValorTotalProduto(float valorTotalProduto) {
        this.valorTotalProduto = valorTotalProduto;
    }

    /**
     * @return the nomeDepartamnto
     */
    public String getNomeDepartamnto() {
        return nomeDepartamnto;
    }

    /**
     * @param nomeDepartamnto the nomeDepartamnto to set
     */
    public void setNomeDepartamnto(String nomeDepartamnto) {
        this.nomeDepartamnto = nomeDepartamnto;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
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
     * @return the usuarioUp
     */
    public String getUsuarioUp() {
        return usuarioUp;
    }

    /**
     * @param usuarioUp the usuarioUp to set
     */
    public void setUsuarioUp(String usuarioUp) {
        this.usuarioUp = usuarioUp;
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
