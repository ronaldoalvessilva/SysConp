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
public class ProdutoMedicamento {

    private int idProd;
    private String statusProd;
    private String codigoBarra;
    private String descricao;
    private String unidade;
    private String referencia;
    private float pesoBruto;
    private float pesoLiquido;
    private float fatorCorrecao;
    private float fatorCoccao;
    private String aplicaDose;
    private int qdtTotalDose;
    private String fotoProduto;
    private String fotoProduto1;
    private int idGrupo;
    private int idForn;
    private int idLocal;
    private int idLote;
    private int idLanc;
    private String nomeGrupo;
    private String nomeLocal;
    private String DescricaoFornecedor;
    private Date dataFabricacao;
    private Date dataCompra;
    private Date dataValidade;
    private float valorCompra;
    private float qtdCompra;
    private Date dataSaida;
    private float qtdSaida;
    private float aliquotaIcms;
    private float aliquotaIpi;
    private String classificaoFiscal;
    private String observacao;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private float estoqueMaximo;
    private float estoqueMinimo;
    private float pontoPedido;
    private float saldoAtual;
    private Date dataVencLote;
    private String lote;
    private float qtdLote;  
    private String tipoInventario;
    private String tipoEntrada;
    private String tipoSaida;   
    private Date dataEstoque;
    private String topicos;
    private String contraIndicaoes;
    private String substancias;
    private String acoesTerapeuticas; 
    private String modulo;    

    public ProdutoMedicamento(int idProd, String statusProd, String codigoBarra, String descricao, String unidade, String referencia, float pesoBruto, float pesoLiquido, float fatorCorrecao, float fatorCoccao, String aplicaDose, int qdtTotalDose, String fotoProduto, String fotoProduto1, int idGrupo, int idForn, int idLocal, int idLote, int idLanc, String nomeGrupo, String nomeLocal, String DescricaoFornecedor, Date dataFabricacao, Date dataCompra, Date dataValidade, float valorCompra, float qtdCompra, Date dataSaida, float qtdSaida, float aliquotaIcms, float aliquotaIpi, String classificaoFiscal, String observacao, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, float estoqueMaximo, float estoqueMinimo, float pontoPedido, float saldoAtual, Date dataVencLote, String lote, float qtdLote, String tipoInventario, String tipoEntrada, String tipoSaida, Date dataEstoque, String topicos, String contraIndicaoes, String substancias, String acoesTerapeuticas, String modulo) {
        this.idProd = idProd;
        this.statusProd = statusProd;
        this.codigoBarra = codigoBarra;
        this.descricao = descricao;
        this.unidade = unidade;
        this.referencia = referencia;
        this.pesoBruto = pesoBruto;
        this.pesoLiquido = pesoLiquido;
        this.fatorCorrecao = fatorCorrecao;
        this.fatorCoccao = fatorCoccao;
        this.aplicaDose = aplicaDose;
        this.qdtTotalDose = qdtTotalDose;
        this.fotoProduto = fotoProduto;
        this.fotoProduto1 = fotoProduto1;
        this.idGrupo = idGrupo;
        this.idForn = idForn;
        this.idLocal = idLocal;
        this.idLote = idLote;
        this.idLanc = idLanc;
        this.nomeGrupo = nomeGrupo;
        this.nomeLocal = nomeLocal;
        this.DescricaoFornecedor = DescricaoFornecedor;
        this.dataFabricacao = dataFabricacao;
        this.dataCompra = dataCompra;
        this.dataValidade = dataValidade;
        this.valorCompra = valorCompra;
        this.qtdCompra = qtdCompra;
        this.dataSaida = dataSaida;
        this.qtdSaida = qtdSaida;
        this.aliquotaIcms = aliquotaIcms;
        this.aliquotaIpi = aliquotaIpi;
        this.classificaoFiscal = classificaoFiscal;
        this.observacao = observacao;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.estoqueMaximo = estoqueMaximo;
        this.estoqueMinimo = estoqueMinimo;
        this.pontoPedido = pontoPedido;
        this.saldoAtual = saldoAtual;
        this.dataVencLote = dataVencLote;
        this.lote = lote;
        this.qtdLote = qtdLote;
        this.tipoInventario = tipoInventario;
        this.tipoEntrada = tipoEntrada;
        this.tipoSaida = tipoSaida;
        this.dataEstoque = dataEstoque;
        this.topicos = topicos;
        this.contraIndicaoes = contraIndicaoes;
        this.substancias = substancias;
        this.acoesTerapeuticas = acoesTerapeuticas;
        this.modulo = modulo;
    }

    public ProdutoMedicamento() {
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
     * @return the statusProd
     */
    public String getStatusProd() {
        return statusProd;
    }

    /**
     * @param statusProd the statusProd to set
     */
    public void setStatusProd(String statusProd) {
        this.statusProd = statusProd;
    }

    /**
     * @return the codigoBarra
     */
    public String getCodigoBarra() {
        return codigoBarra;
    }

    /**
     * @param codigoBarra the codigoBarra to set
     */
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
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
     * @return the aplicaDose
     */
    public String getAplicaDose() {
        return aplicaDose;
    }

    /**
     * @param aplicaDose the aplicaDose to set
     */
    public void setAplicaDose(String aplicaDose) {
        this.aplicaDose = aplicaDose;
    }

    /**
     * @return the qdtTotalDose
     */
    public int getQdtTotalDose() {
        return qdtTotalDose;
    }

    /**
     * @param qdtTotalDose the qdtTotalDose to set
     */
    public void setQdtTotalDose(int qdtTotalDose) {
        this.qdtTotalDose = qdtTotalDose;
    }

    /**
     * @return the fotoProduto
     */
    public String getFotoProduto() {
        return fotoProduto;
    }

    /**
     * @param fotoProduto the fotoProduto to set
     */
    public void setFotoProduto(String fotoProduto) {
        this.fotoProduto = fotoProduto;
    }

    /**
     * @return the fotoProduto1
     */
    public String getFotoProduto1() {
        return fotoProduto1;
    }

    /**
     * @param fotoProduto1 the fotoProduto1 to set
     */
    public void setFotoProduto1(String fotoProduto1) {
        this.fotoProduto1 = fotoProduto1;
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
     * @return the idForn
     */
    public int getIdForn() {
        return idForn;
    }

    /**
     * @param idForn the idForn to set
     */
    public void setIdForn(int idForn) {
        this.idForn = idForn;
    }

    /**
     * @return the idLocal
     */
    public int getIdLocal() {
        return idLocal;
    }

    /**
     * @param idLocal the idLocal to set
     */
    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    /**
     * @return the idLote
     */
    public int getIdLote() {
        return idLote;
    }

    /**
     * @param idLote the idLote to set
     */
    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    /**
     * @return the idLanc
     */
    public int getIdLanc() {
        return idLanc;
    }

    /**
     * @param idLanc the idLanc to set
     */
    public void setIdLanc(int idLanc) {
        this.idLanc = idLanc;
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
     * @return the nomeLocal
     */
    public String getNomeLocal() {
        return nomeLocal;
    }

    /**
     * @param nomeLocal the nomeLocal to set
     */
    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    /**
     * @return the DescricaoFornecedor
     */
    public String getDescricaoFornecedor() {
        return DescricaoFornecedor;
    }

    /**
     * @param DescricaoFornecedor the DescricaoFornecedor to set
     */
    public void setDescricaoFornecedor(String DescricaoFornecedor) {
        this.DescricaoFornecedor = DescricaoFornecedor;
    }

    /**
     * @return the dataFabricacao
     */
    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    /**
     * @param dataFabricacao the dataFabricacao to set
     */
    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    /**
     * @return the dataCompra
     */
    public Date getDataCompra() {
        return dataCompra;
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * @return the dataValidade
     */
    public Date getDataValidade() {
        return dataValidade;
    }

    /**
     * @param dataValidade the dataValidade to set
     */
    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
     * @return the valorCompra
     */
    public float getValorCompra() {
        return valorCompra;
    }

    /**
     * @param valorCompra the valorCompra to set
     */
    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    /**
     * @return the qtdCompra
     */
    public float getQtdCompra() {
        return qtdCompra;
    }

    /**
     * @param qtdCompra the qtdCompra to set
     */
    public void setQtdCompra(float qtdCompra) {
        this.qtdCompra = qtdCompra;
    }

    /**
     * @return the dataSaida
     */
    public Date getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * @return the qtdSaida
     */
    public float getQtdSaida() {
        return qtdSaida;
    }

    /**
     * @param qtdSaida the qtdSaida to set
     */
    public void setQtdSaida(float qtdSaida) {
        this.qtdSaida = qtdSaida;
    }

    /**
     * @return the aliquotaIcms
     */
    public float getAliquotaIcms() {
        return aliquotaIcms;
    }

    /**
     * @param aliquotaIcms the aliquotaIcms to set
     */
    public void setAliquotaIcms(float aliquotaIcms) {
        this.aliquotaIcms = aliquotaIcms;
    }

    /**
     * @return the aliquotaIpi
     */
    public float getAliquotaIpi() {
        return aliquotaIpi;
    }

    /**
     * @param aliquotaIpi the aliquotaIpi to set
     */
    public void setAliquotaIpi(float aliquotaIpi) {
        this.aliquotaIpi = aliquotaIpi;
    }

    /**
     * @return the classificaoFiscal
     */
    public String getClassificaoFiscal() {
        return classificaoFiscal;
    }

    /**
     * @param classificaoFiscal the classificaoFiscal to set
     */
    public void setClassificaoFiscal(String classificaoFiscal) {
        this.classificaoFiscal = classificaoFiscal;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
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

    /**
     * @return the estoqueMaximo
     */
    public float getEstoqueMaximo() {
        return estoqueMaximo;
    }

    /**
     * @param estoqueMaximo the estoqueMaximo to set
     */
    public void setEstoqueMaximo(float estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    /**
     * @return the estoqueMinimo
     */
    public float getEstoqueMinimo() {
        return estoqueMinimo;
    }

    /**
     * @param estoqueMinimo the estoqueMinimo to set
     */
    public void setEstoqueMinimo(float estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    /**
     * @return the pontoPedido
     */
    public float getPontoPedido() {
        return pontoPedido;
    }

    /**
     * @param pontoPedido the pontoPedido to set
     */
    public void setPontoPedido(float pontoPedido) {
        this.pontoPedido = pontoPedido;
    }

    /**
     * @return the saldoAtual
     */
    public float getSaldoAtual() {
        return saldoAtual;
    }

    /**
     * @param saldoAtual the saldoAtual to set
     */
    public void setSaldoAtual(float saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    /**
     * @return the dataVencLote
     */
    public Date getDataVencLote() {
        return dataVencLote;
    }

    /**
     * @param dataVencLote the dataVencLote to set
     */
    public void setDataVencLote(Date dataVencLote) {
        this.dataVencLote = dataVencLote;
    }

    /**
     * @return the lote
     */
    public String getLote() {
        return lote;
    }

    /**
     * @param lote the lote to set
     */
    public void setLote(String lote) {
        this.lote = lote;
    }

    /**
     * @return the qtdLote
     */
    public float getQtdLote() {
        return qtdLote;
    }

    /**
     * @param qtdLote the qtdLote to set
     */
    public void setQtdLote(float qtdLote) {
        this.qtdLote = qtdLote;
    }

    /**
     * @return the tipoInventario
     */
    public String getTipoInventario() {
        return tipoInventario;
    }

    /**
     * @param tipoInventario the tipoInventario to set
     */
    public void setTipoInventario(String tipoInventario) {
        this.tipoInventario = tipoInventario;
    }

    /**
     * @return the tipoEntrada
     */
    public String getTipoEntrada() {
        return tipoEntrada;
    }

    /**
     * @param tipoEntrada the tipoEntrada to set
     */
    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    /**
     * @return the tipoSaida
     */
    public String getTipoSaida() {
        return tipoSaida;
    }

    /**
     * @param tipoSaida the tipoSaida to set
     */
    public void setTipoSaida(String tipoSaida) {
        this.tipoSaida = tipoSaida;
    }

    /**
     * @return the dataEstoque
     */
    public Date getDataEstoque() {
        return dataEstoque;
    }

    /**
     * @param dataEstoque the dataEstoque to set
     */
    public void setDataEstoque(Date dataEstoque) {
        this.dataEstoque = dataEstoque;
    }

    /**
     * @return the topicos
     */
    public String getTopicos() {
        return topicos;
    }

    /**
     * @param topicos the topicos to set
     */
    public void setTopicos(String topicos) {
        this.topicos = topicos;
    }

    /**
     * @return the contraIndicaoes
     */
    public String getContraIndicaoes() {
        return contraIndicaoes;
    }

    /**
     * @param contraIndicaoes the contraIndicaoes to set
     */
    public void setContraIndicaoes(String contraIndicaoes) {
        this.contraIndicaoes = contraIndicaoes;
    }

    /**
     * @return the substancias
     */
    public String getSubstancias() {
        return substancias;
    }

    /**
     * @param substancias the substancias to set
     */
    public void setSubstancias(String substancias) {
        this.substancias = substancias;
    }

    /**
     * @return the acoesTerapeuticas
     */
    public String getAcoesTerapeuticas() {
        return acoesTerapeuticas;
    }

    /**
     * @param acoesTerapeuticas the acoesTerapeuticas to set
     */
    public void setAcoesTerapeuticas(String acoesTerapeuticas) {
        this.acoesTerapeuticas = acoesTerapeuticas;
    }

    /**
     * @return the modulo
     */
    public String getModulo() {
        return modulo;
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
}
