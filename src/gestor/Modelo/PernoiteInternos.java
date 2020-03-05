/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Socializa TI 02
 */
public class PernoiteInternos {

    private int codigoRegistro;
    private String statusRegistro;
    private Date DataRegistro;
    private String DescricaoPavilhao;
    private String documento;
    private String descricaoCela;
    private String objetivo;
    private String unidadeOrigem;
    private String nomeCondutor;
    private String rgCondutor;
    private String cpfCondutor;
    private String veiculo;
    private String placa;
    private String motivo;
    private int codigoInterno;
    private String nomeInterno;
    private String nomeMae;
    private String nomePai;
    private Date dataEntrada;
    private String horaEntrada;
    private Date dataSaida;
    private String horaSaida;
    private byte[] ImgemInterno;
    private String usuarioInsert;
    private String dataInsert;
    private String horaInsert;
    private String usuarioUp;
    private String dataUp;
    private String horaUp;
    private String useuaroAdmin;

    public PernoiteInternos() {
    }

    public PernoiteInternos(int codigoRegistro, String statusRegistro, Date DataRegistro, String DescricaoPavilhao, String documento, String descricaoCela, String objetivo, String unidadeOrigem, String nomeCondutor, String rgCondutor, String cpfCondutor, String veiculo, String placa, String motivo, int codigoInterno, String nomeInterno, String nomeMae, String nomePai, Date dataEntrada, String horaEntrada, Date dataSaida, String horaSaida, byte[] ImgemInterno, String usuarioInsert, String dataInsert, String horaInsert, String usuarioUp, String dataUp, String horaUp, String useuaroAdmin) {
        this.codigoRegistro = codigoRegistro;
        this.statusRegistro = statusRegistro;
        this.DataRegistro = DataRegistro;
        this.DescricaoPavilhao = DescricaoPavilhao;
        this.documento = documento;
        this.descricaoCela = descricaoCela;
        this.objetivo = objetivo;
        this.unidadeOrigem = unidadeOrigem;
        this.nomeCondutor = nomeCondutor;
        this.rgCondutor = rgCondutor;
        this.cpfCondutor = cpfCondutor;
        this.veiculo = veiculo;
        this.placa = placa;
        this.motivo = motivo;
        this.codigoInterno = codigoInterno;
        this.nomeInterno = nomeInterno;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
        this.dataSaida = dataSaida;
        this.horaSaida = horaSaida;
        this.ImgemInterno = ImgemInterno;
        this.usuarioInsert = usuarioInsert;
        this.dataInsert = dataInsert;
        this.horaInsert = horaInsert;
        this.usuarioUp = usuarioUp;
        this.dataUp = dataUp;
        this.horaUp = horaUp;
        this.useuaroAdmin = useuaroAdmin;
    }

    /**
     * @return the codigoRegistro
     */
    public int getCodigoRegistro() {
        return codigoRegistro;
    }

    /**
     * @param codigoRegistro the codigoRegistro to set
     */
    public void setCodigoRegistro(int codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    /**
     * @return the statusRegistro
     */
    public String getStatusRegistro() {
        return statusRegistro;
    }

    /**
     * @param statusRegistro the statusRegistro to set
     */
    public void setStatusRegistro(String statusRegistro) {
        this.statusRegistro = statusRegistro;
    }

    /**
     * @return the DataRegistro
     */
    public Date getDataRegistro() {
        return DataRegistro;
    }

    /**
     * @param DataRegistro the DataRegistro to set
     */
    public void setDataRegistro(Date DataRegistro) {
        this.DataRegistro = DataRegistro;
    }

    /**
     * @return the DescricaoPavilhao
     */
    public String getDescricaoPavilhao() {
        return DescricaoPavilhao;
    }

    /**
     * @param DescricaoPavilhao the DescricaoPavilhao to set
     */
    public void setDescricaoPavilhao(String DescricaoPavilhao) {
        this.DescricaoPavilhao = DescricaoPavilhao;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the descricaoCela
     */
    public String getDescricaoCela() {
        return descricaoCela;
    }

    /**
     * @param descricaoCela the descricaoCela to set
     */
    public void setDescricaoCela(String descricaoCela) {
        this.descricaoCela = descricaoCela;
    }

    /**
     * @return the objetivo
     */
    public String getObjetivo() {
        return objetivo;
    }

    /**
     * @param objetivo the objetivo to set
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * @return the unidadeOrigem
     */
    public String getUnidadeOrigem() {
        return unidadeOrigem;
    }

    /**
     * @param unidadeOrigem the unidadeOrigem to set
     */
    public void setUnidadeOrigem(String unidadeOrigem) {
        this.unidadeOrigem = unidadeOrigem;
    }

    /**
     * @return the nomeCondutor
     */
    public String getNomeCondutor() {
        return nomeCondutor;
    }

    /**
     * @param nomeCondutor the nomeCondutor to set
     */
    public void setNomeCondutor(String nomeCondutor) {
        this.nomeCondutor = nomeCondutor;
    }

    /**
     * @return the rgCondutor
     */
    public String getRgCondutor() {
        return rgCondutor;
    }

    /**
     * @param rgCondutor the rgCondutor to set
     */
    public void setRgCondutor(String rgCondutor) {
        this.rgCondutor = rgCondutor;
    }

    /**
     * @return the cpfCondutor
     */
    public String getCpfCondutor() {
        return cpfCondutor;
    }

    /**
     * @param cpfCondutor the cpfCondutor to set
     */
    public void setCpfCondutor(String cpfCondutor) {
        this.cpfCondutor = cpfCondutor;
    }

    /**
     * @return the veiculo
     */
    public String getVeiculo() {
        return veiculo;
    }

    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the codigoInterno
     */
    public int getCodigoInterno() {
        return codigoInterno;
    }

    /**
     * @param codigoInterno the codigoInterno to set
     */
    public void setCodigoInterno(int codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    /**
     * @return the nomeInterno
     */
    public String getNomeInterno() {
        return nomeInterno;
    }

    /**
     * @param nomeInterno the nomeInterno to set
     */
    public void setNomeInterno(String nomeInterno) {
        this.nomeInterno = nomeInterno;
    }

    /**
     * @return the nomeMae
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * @param nomeMae the nomeMae to set
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    /**
     * @return the nomePai
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * @param nomePai the nomePai to set
     */
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    /**
     * @return the dataEntrada
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the horaEntrada
     */
    public String getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
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
     * @return the horaSaida
     */
    public String getHoraSaida() {
        return horaSaida;
    }

    /**
     * @param horaSaida the horaSaida to set
     */
    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    /**
     * @return the ImgemInterno
     */
    public byte[] getImgemInterno() {
        return ImgemInterno;
    }

    /**
     * @param ImgemInterno the ImgemInterno to set
     */
    public void setImgemInterno(byte[] ImgemInterno) {
        this.ImgemInterno = ImgemInterno;
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
     * @return the horaInsert
     */
    public String getHoraInsert() {
        return horaInsert;
    }

    /**
     * @param horaInsert the horaInsert to set
     */
    public void setHoraInsert(String horaInsert) {
        this.horaInsert = horaInsert;
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
     * @return the horaUp
     */
    public String getHoraUp() {
        return horaUp;
    }

    /**
     * @param horaUp the horaUp to set
     */
    public void setHoraUp(String horaUp) {
        this.horaUp = horaUp;
    }

    /**
     * @return the useuaroAdmin
     */
    public String getUseuaroAdmin() {
        return useuaroAdmin;
    }

    /**
     * @param useuaroAdmin the useuaroAdmin to set
     */
    public void setUseuaroAdmin(String useuaroAdmin) {
        this.useuaroAdmin = useuaroAdmin;
    }
}
