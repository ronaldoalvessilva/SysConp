/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author ronal
 */
public class ComposicaoKit {

    private int idRegistroComp;
    private String statusComp;
    private Date dataComp;
    private int idKit;
    private int idItem;
    private int idFunc;
    private String nomeColaborador;
    private String fotoColaborador;
    private byte [] imagemColaborador;
    private String nomeDepartamento;
    private Integer idPav;
    private String descricaoPavilhao;
    private String observacao;
    private String progGerada;
    private Date dataProgramacao;
    private int kitInicial;
    private int kitDecendial;
    private int kitQuinzenal;
    private int kitMensal;
    private int kitSemestral;
    private int kitAnual;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private String kitPago;
    private Date dataPagamentoKit;   
    private int idProd;
    private String descricaoProd;
    private float quantItem;
    private String unidadeProd;

    public ComposicaoKit() {
    }

    public ComposicaoKit(int idRegistroComp, String statusComp, Date dataComp, int idKit, int idItem, int idFunc, String nomeColaborador, String fotoColaborador, byte[] imagemColaborador, String nomeDepartamento, Integer idPav, String descricaoPavilhao, String observacao, String progGerada, Date dataProgramacao, int kitInicial, int kitDecendial, int kitQuinzenal, int kitMensal, int kitSemestral, int kitAnual, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String kitPago, Date dataPagamentoKit, int idProd, String descricaoProd, float quantItem, String unidadeProd) {
        this.idRegistroComp = idRegistroComp;
        this.statusComp = statusComp;
        this.dataComp = dataComp;
        this.idKit = idKit;
        this.idItem = idItem;
        this.idFunc = idFunc;
        this.nomeColaborador = nomeColaborador;
        this.fotoColaborador = fotoColaborador;
        this.imagemColaborador = imagemColaborador;
        this.nomeDepartamento = nomeDepartamento;
        this.idPav = idPav;
        this.descricaoPavilhao = descricaoPavilhao;
        this.observacao = observacao;
        this.progGerada = progGerada;
        this.dataProgramacao = dataProgramacao;
        this.kitInicial = kitInicial;
        this.kitDecendial = kitDecendial;
        this.kitQuinzenal = kitQuinzenal;
        this.kitMensal = kitMensal;
        this.kitSemestral = kitSemestral;
        this.kitAnual = kitAnual;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.kitPago = kitPago;
        this.dataPagamentoKit = dataPagamentoKit;
        this.idProd = idProd;
        this.descricaoProd = descricaoProd;
        this.quantItem = quantItem;
        this.unidadeProd = unidadeProd;
    }

    /**
     * @return the idRegistroComp
     */
    public int getIdRegistroComp() {
        return idRegistroComp;
    }

    /**
     * @param idRegistroComp the idRegistroComp to set
     */
    public void setIdRegistroComp(int idRegistroComp) {
        this.idRegistroComp = idRegistroComp;
    }

    /**
     * @return the statusComp
     */
    public String getStatusComp() {
        return statusComp;
    }

    /**
     * @param statusComp the statusComp to set
     */
    public void setStatusComp(String statusComp) {
        this.statusComp = statusComp;
    }

    /**
     * @return the dataComp
     */
    public Date getDataComp() {
        return dataComp;
    }

    /**
     * @param dataComp the dataComp to set
     */
    public void setDataComp(Date dataComp) {
        this.dataComp = dataComp;
    }

    /**
     * @return the idKit
     */
    public int getIdKit() {
        return idKit;
    }

    /**
     * @param idKit the idKit to set
     */
    public void setIdKit(int idKit) {
        this.idKit = idKit;
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
     * @return the idFunc
     */
    public int getIdFunc() {
        return idFunc;
    }

    /**
     * @param idFunc the idFunc to set
     */
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    /**
     * @return the nomeColaborador
     */
    public String getNomeColaborador() {
        return nomeColaborador;
    }

    /**
     * @param nomeColaborador the nomeColaborador to set
     */
    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    /**
     * @return the fotoColaborador
     */
    public String getFotoColaborador() {
        return fotoColaborador;
    }

    /**
     * @param fotoColaborador the fotoColaborador to set
     */
    public void setFotoColaborador(String fotoColaborador) {
        this.fotoColaborador = fotoColaborador;
    }

    /**
     * @return the imagemColaborador
     */
    public byte[] getImagemColaborador() {
        return imagemColaborador;
    }

    /**
     * @param imagemColaborador the imagemColaborador to set
     */
    public void setImagemColaborador(byte[] imagemColaborador) {
        this.imagemColaborador = imagemColaborador;
    }

    /**
     * @return the nomeDepartamento
     */
    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    /**
     * @param nomeDepartamento the nomeDepartamento to set
     */
    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    /**
     * @return the idPav
     */
    public Integer getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(Integer idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the descricaoPavilhao
     */
    public String getDescricaoPavilhao() {
        return descricaoPavilhao;
    }

    /**
     * @param descricaoPavilhao the descricaoPavilhao to set
     */
    public void setDescricaoPavilhao(String descricaoPavilhao) {
        this.descricaoPavilhao = descricaoPavilhao;
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
     * @return the progGerada
     */
    public String getProgGerada() {
        return progGerada;
    }

    /**
     * @param progGerada the progGerada to set
     */
    public void setProgGerada(String progGerada) {
        this.progGerada = progGerada;
    }

    /**
     * @return the dataProgramacao
     */
    public Date getDataProgramacao() {
        return dataProgramacao;
    }

    /**
     * @param dataProgramacao the dataProgramacao to set
     */
    public void setDataProgramacao(Date dataProgramacao) {
        this.dataProgramacao = dataProgramacao;
    }

    /**
     * @return the kitInicial
     */
    public int getKitInicial() {
        return kitInicial;
    }

    /**
     * @param kitInicial the kitInicial to set
     */
    public void setKitInicial(int kitInicial) {
        this.kitInicial = kitInicial;
    }

    /**
     * @return the kitDecendial
     */
    public int getKitDecendial() {
        return kitDecendial;
    }

    /**
     * @param kitDecendial the kitDecendial to set
     */
    public void setKitDecendial(int kitDecendial) {
        this.kitDecendial = kitDecendial;
    }

    /**
     * @return the kitQuinzenal
     */
    public int getKitQuinzenal() {
        return kitQuinzenal;
    }

    /**
     * @param kitQuinzenal the kitQuinzenal to set
     */
    public void setKitQuinzenal(int kitQuinzenal) {
        this.kitQuinzenal = kitQuinzenal;
    }

    /**
     * @return the kitMensal
     */
    public int getKitMensal() {
        return kitMensal;
    }

    /**
     * @param kitMensal the kitMensal to set
     */
    public void setKitMensal(int kitMensal) {
        this.kitMensal = kitMensal;
    }

    /**
     * @return the kitSemestral
     */
    public int getKitSemestral() {
        return kitSemestral;
    }

    /**
     * @param kitSemestral the kitSemestral to set
     */
    public void setKitSemestral(int kitSemestral) {
        this.kitSemestral = kitSemestral;
    }

    /**
     * @return the kitAnual
     */
    public int getKitAnual() {
        return kitAnual;
    }

    /**
     * @param kitAnual the kitAnual to set
     */
    public void setKitAnual(int kitAnual) {
        this.kitAnual = kitAnual;
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
     * @return the kitPago
     */
    public String getKitPago() {
        return kitPago;
    }

    /**
     * @param kitPago the kitPago to set
     */
    public void setKitPago(String kitPago) {
        this.kitPago = kitPago;
    }

    /**
     * @return the dataPagamentoKit
     */
    public Date getDataPagamentoKit() {
        return dataPagamentoKit;
    }

    /**
     * @param dataPagamentoKit the dataPagamentoKit to set
     */
    public void setDataPagamentoKit(Date dataPagamentoKit) {
        this.dataPagamentoKit = dataPagamentoKit;
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
     * @return the descricaoProd
     */
    public String getDescricaoProd() {
        return descricaoProd;
    }

    /**
     * @param descricaoProd the descricaoProd to set
     */
    public void setDescricaoProd(String descricaoProd) {
        this.descricaoProd = descricaoProd;
    }

    /**
     * @return the quantItem
     */
    public float getQuantItem() {
        return quantItem;
    }

    /**
     * @param quantItem the quantItem to set
     */
    public void setQuantItem(float quantItem) {
        this.quantItem = quantItem;
    }

    /**
     * @return the unidadeProd
     */
    public String getUnidadeProd() {
        return unidadeProd;
    }

    /**
     * @param unidadeProd the unidadeProd to set
     */
    public void setUnidadeProd(String unidadeProd) {
        this.unidadeProd = unidadeProd;
    }
}
