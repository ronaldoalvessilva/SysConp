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
public class IngredientesFichaTecnica {

    private int idItem;
    private int item;
    private int idFicha;
    private int idProd;
    private String descricaoProduto;
    private float qtdItem;
    private float perda;
    private float quantidadeFinal;
    private float pesoBruto;
    private float pesoLiquido;
    private float fatorCorrecao;
    private float fatorCoccao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;   

    public IngredientesFichaTecnica(int idItem, int item, int idFicha, int idProd, String descricaoProduto, float qtdItem, float perda, float quantidadeFinal, float pesoBruto, float pesoLiquido, float fatorCorrecao, float fatorCoccao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idItem = idItem;
        this.item = item;
        this.idFicha = idFicha;
        this.idProd = idProd;
        this.descricaoProduto = descricaoProduto;
        this.qtdItem = qtdItem;
        this.perda = perda;
        this.quantidadeFinal = quantidadeFinal;
        this.pesoBruto = pesoBruto;
        this.pesoLiquido = pesoLiquido;
        this.fatorCorrecao = fatorCorrecao;
        this.fatorCoccao = fatorCoccao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public IngredientesFichaTecnica() {
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
     * @return the item
     */
    public int getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(int item) {
        this.item = item;
    }

    /**
     * @return the idFicha
     */
    public int getIdFicha() {
        return idFicha;
    }

    /**
     * @param idFicha the idFicha to set
     */
    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
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
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
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
     * @return the perda
     */
    public float getPerda() {
        return perda;
    }

    /**
     * @param perda the perda to set
     */
    public void setPerda(float perda) {
        this.perda = perda;
    }

    /**
     * @return the quantidadeFinal
     */
    public float getQuantidadeFinal() {
        return quantidadeFinal;
    }

    /**
     * @param quantidadeFinal the quantidadeFinal to set
     */
    public void setQuantidadeFinal(float quantidadeFinal) {
        this.quantidadeFinal = quantidadeFinal;
    }

    /**
     * @return the pesoBruto
     */
    public float getPesoBruto() {
        return pesoBruto;
    }

    /**
     * @param pesoBruto the pesoBruto to set
     */
    public void setPesoBruto(float pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    /**
     * @return the pesoLiquido
     */
    public float getPesoLiquido() {
        return pesoLiquido;
    }

    /**
     * @param pesoLiquido the pesoLiquido to set
     */
    public void setPesoLiquido(float pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    /**
     * @return the fatorCorrecao
     */
    public float getFatorCorrecao() {
        return fatorCorrecao;
    }

    /**
     * @param fatorCorrecao the fatorCorrecao to set
     */
    public void setFatorCorrecao(float fatorCorrecao) {
        this.fatorCorrecao = fatorCorrecao;
    }

    /**
     * @return the fatorCoccao
     */
    public float getFatorCoccao() {
        return fatorCoccao;
    }

    /**
     * @param fatorCoccao the fatorCoccao to set
     */
    public void setFatorCoccao(float fatorCoccao) {
        this.fatorCoccao = fatorCoccao;
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
