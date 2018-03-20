/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;

/**
 *
 * @author Ronaldo
 */
public class ProntuarioCrc {

    private int IdInterno;
    private String Matricula;
    private Date DataCadast;
    private Date DataNasci;
    private String FotoInterno;
    private String FotoPerfil;
    private String FotoCorpo1;
    private String FotoCorpo2;
    private String FotoCorpo3;
    private String NomeInterno;
    private String MaeInterno;
    private String PaiInterno;
    private String Alcunha;
    private String RgInterno;
    private String CpfInterno;
    private String cartoaSus;
    private String Escolaridade;
    private String EstadoCivil;
    private String Sexo;
    private String situacao;
    private String nomePais;
    private String nomeCidade;
    private String Religiao;
    private String Profissao;
    private String Endereco;
    private String Bairro;
    private String Cidade;
    private String Estado;
    private String telefone;
    private String telefone1;
    private String celular;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horaInsert;
    private String horaUp;
    private String dataFechamento;
    private String horaFechamento;  
    private String confirmaEntrada;     
    private String cnc;   

    public ProntuarioCrc(int IdInterno, String Matricula, Date DataCadast, Date DataNasci, String FotoInterno, String FotoPerfil, String FotoCorpo1, String FotoCorpo2, String FotoCorpo3, String NomeInterno, String MaeInterno, String PaiInterno, String Alcunha, String RgInterno, String CpfInterno, String cartoaSus, String Escolaridade, String EstadoCivil, String Sexo, String situacao, String nomePais, String nomeCidade, String Religiao, String Profissao, String Endereco, String Bairro, String Cidade, String Estado, String telefone, String telefone1, String celular, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horaInsert, String horaUp, String dataFechamento, String horaFechamento, String confirmaEntrada, String cnc) {
        this.IdInterno = IdInterno;
        this.Matricula = Matricula;
        this.DataCadast = DataCadast;
        this.DataNasci = DataNasci;
        this.FotoInterno = FotoInterno;
        this.FotoPerfil = FotoPerfil;
        this.FotoCorpo1 = FotoCorpo1;
        this.FotoCorpo2 = FotoCorpo2;
        this.FotoCorpo3 = FotoCorpo3;
        this.NomeInterno = NomeInterno;
        this.MaeInterno = MaeInterno;
        this.PaiInterno = PaiInterno;
        this.Alcunha = Alcunha;
        this.RgInterno = RgInterno;
        this.CpfInterno = CpfInterno;
        this.cartoaSus = cartoaSus;
        this.Escolaridade = Escolaridade;
        this.EstadoCivil = EstadoCivil;
        this.Sexo = Sexo;
        this.situacao = situacao;
        this.nomePais = nomePais;
        this.nomeCidade = nomeCidade;
        this.Religiao = Religiao;
        this.Profissao = Profissao;
        this.Endereco = Endereco;
        this.Bairro = Bairro;
        this.Cidade = Cidade;
        this.Estado = Estado;
        this.telefone = telefone;
        this.telefone1 = telefone1;
        this.celular = celular;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horaInsert = horaInsert;
        this.horaUp = horaUp;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.confirmaEntrada = confirmaEntrada;
        this.cnc = cnc;
    }

    public ProntuarioCrc() {
    }

    /**
     * @return the IdInterno
     */
    public int getIdInterno() {
        return IdInterno;
    }

    /**
     * @param IdInterno the IdInterno to set
     */
    public void setIdInterno(int IdInterno) {
        this.IdInterno = IdInterno;
    }

    /**
     * @return the Matricula
     */
    public String getMatricula() {
        return Matricula;
    }

    /**
     * @param Matricula the Matricula to set
     */
    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    /**
     * @return the DataCadast
     */
    public Date getDataCadast() {
        return DataCadast;
    }

    /**
     * @param DataCadast the DataCadast to set
     */
    public void setDataCadast(Date DataCadast) {
        this.DataCadast = DataCadast;
    }

    /**
     * @return the DataNasci
     */
    public Date getDataNasci() {
        return DataNasci;
    }

    /**
     * @param DataNasci the DataNasci to set
     */
    public void setDataNasci(Date DataNasci) {
        this.DataNasci = DataNasci;
    }

    /**
     * @return the FotoInterno
     */
    public String getFotoInterno() {
        return FotoInterno;
    }

    /**
     * @param FotoInterno the FotoInterno to set
     */
    public void setFotoInterno(String FotoInterno) {
        this.FotoInterno = FotoInterno;
    }

    /**
     * @return the FotoPerfil
     */
    public String getFotoPerfil() {
        return FotoPerfil;
    }

    /**
     * @param FotoPerfil the FotoPerfil to set
     */
    public void setFotoPerfil(String FotoPerfil) {
        this.FotoPerfil = FotoPerfil;
    }

    /**
     * @return the FotoCorpo1
     */
    public String getFotoCorpo1() {
        return FotoCorpo1;
    }

    /**
     * @param FotoCorpo1 the FotoCorpo1 to set
     */
    public void setFotoCorpo1(String FotoCorpo1) {
        this.FotoCorpo1 = FotoCorpo1;
    }

    /**
     * @return the FotoCorpo2
     */
    public String getFotoCorpo2() {
        return FotoCorpo2;
    }

    /**
     * @param FotoCorpo2 the FotoCorpo2 to set
     */
    public void setFotoCorpo2(String FotoCorpo2) {
        this.FotoCorpo2 = FotoCorpo2;
    }

    /**
     * @return the FotoCorpo3
     */
    public String getFotoCorpo3() {
        return FotoCorpo3;
    }

    /**
     * @param FotoCorpo3 the FotoCorpo3 to set
     */
    public void setFotoCorpo3(String FotoCorpo3) {
        this.FotoCorpo3 = FotoCorpo3;
    }

    /**
     * @return the NomeInterno
     */
    public String getNomeInterno() {
        return NomeInterno;
    }

    /**
     * @param NomeInterno the NomeInterno to set
     */
    public void setNomeInterno(String NomeInterno) {
        this.NomeInterno = NomeInterno;
    }

    /**
     * @return the MaeInterno
     */
    public String getMaeInterno() {
        return MaeInterno;
    }

    /**
     * @param MaeInterno the MaeInterno to set
     */
    public void setMaeInterno(String MaeInterno) {
        this.MaeInterno = MaeInterno;
    }

    /**
     * @return the PaiInterno
     */
    public String getPaiInterno() {
        return PaiInterno;
    }

    /**
     * @param PaiInterno the PaiInterno to set
     */
    public void setPaiInterno(String PaiInterno) {
        this.PaiInterno = PaiInterno;
    }

    /**
     * @return the Alcunha
     */
    public String getAlcunha() {
        return Alcunha;
    }

    /**
     * @param Alcunha the Alcunha to set
     */
    public void setAlcunha(String Alcunha) {
        this.Alcunha = Alcunha;
    }

    /**
     * @return the RgInterno
     */
    public String getRgInterno() {
        return RgInterno;
    }

    /**
     * @param RgInterno the RgInterno to set
     */
    public void setRgInterno(String RgInterno) {
        this.RgInterno = RgInterno;
    }

    /**
     * @return the CpfInterno
     */
    public String getCpfInterno() {
        return CpfInterno;
    }

    /**
     * @param CpfInterno the CpfInterno to set
     */
    public void setCpfInterno(String CpfInterno) {
        this.CpfInterno = CpfInterno;
    }

    /**
     * @return the cartoaSus
     */
    public String getCartoaSus() {
        return cartoaSus;
    }

    /**
     * @param cartoaSus the cartoaSus to set
     */
    public void setCartoaSus(String cartoaSus) {
        this.cartoaSus = cartoaSus;
    }

    /**
     * @return the Escolaridade
     */
    public String getEscolaridade() {
        return Escolaridade;
    }

    /**
     * @param Escolaridade the Escolaridade to set
     */
    public void setEscolaridade(String Escolaridade) {
        this.Escolaridade = Escolaridade;
    }

    /**
     * @return the EstadoCivil
     */
    public String getEstadoCivil() {
        return EstadoCivil;
    }

    /**
     * @param EstadoCivil the EstadoCivil to set
     */
    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    /**
     * @return the Sexo
     */
    public String getSexo() {
        return Sexo;
    }

    /**
     * @param Sexo the Sexo to set
     */
    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the nomePais
     */
    public String getNomePais() {
        return nomePais;
    }

    /**
     * @param nomePais the nomePais to set
     */
    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    /**
     * @return the nomeCidade
     */
    public String getNomeCidade() {
        return nomeCidade;
    }

    /**
     * @param nomeCidade the nomeCidade to set
     */
    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    /**
     * @return the Religiao
     */
    public String getReligiao() {
        return Religiao;
    }

    /**
     * @param Religiao the Religiao to set
     */
    public void setReligiao(String Religiao) {
        this.Religiao = Religiao;
    }

    /**
     * @return the Profissao
     */
    public String getProfissao() {
        return Profissao;
    }

    /**
     * @param Profissao the Profissao to set
     */
    public void setProfissao(String Profissao) {
        this.Profissao = Profissao;
    }

    /**
     * @return the Endereco
     */
    public String getEndereco() {
        return Endereco;
    }

    /**
     * @param Endereco the Endereco to set
     */
    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    /**
     * @return the Bairro
     */
    public String getBairro() {
        return Bairro;
    }

    /**
     * @param Bairro the Bairro to set
     */
    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    /**
     * @return the Cidade
     */
    public String getCidade() {
        return Cidade;
    }

    /**
     * @param Cidade the Cidade to set
     */
    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the telefone1
     */
    public String getTelefone1() {
        return telefone1;
    }

    /**
     * @param telefone1 the telefone1 to set
     */
    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
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
     * @return the dataFechamento
     */
    public String getDataFechamento() {
        return dataFechamento;
    }

    /**
     * @param dataFechamento the dataFechamento to set
     */
    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    /**
     * @return the horaFechamento
     */
    public String getHoraFechamento() {
        return horaFechamento;
    }

    /**
     * @param horaFechamento the horaFechamento to set
     */
    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    /**
     * @return the confirmaEntrada
     */
    public String getConfirmaEntrada() {
        return confirmaEntrada;
    }

    /**
     * @param confirmaEntrada the confirmaEntrada to set
     */
    public void setConfirmaEntrada(String confirmaEntrada) {
        this.confirmaEntrada = confirmaEntrada;
    }

    /**
     * @return the cnc
     */
    public String getCnc() {
        return cnc;
    }

    /**
     * @param cnc the cnc to set
     */
    public void setCnc(String cnc) {
        this.cnc = cnc;
    }
}
