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
public class Funcionarios {

    private int idFunc;
    private String statusFunc;
    private Date dataCadastro;
    private String foto;
    private String nomeFuncionario;
    private String sexo;
    private String escolaridade;
    private String matricula;
    private int idCargo;
    private String nomeCargo;
    private int idDepartamento;
    private String nomeDepartamento;
    private String estadoCivil;
    private Date dataNascimento;
    private String nomeMae;
    private String nomePai;
    private String religiao;
    private String tipoSangue;
    private String cargaHoraria;
    private String regimeTrabalho;
    private String horarioInicio;
    private String horarioFinal;
    private String funcao;
    private String nacionalidade;
    private String pais;
    private String naturalidade;
    private String estadoNacionalidade;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;
    private byte[] imagemFrenteCO;

    public Funcionarios() {
    }

    public Funcionarios(int idFunc, String statusFunc, Date dataCadastro, String foto, String nomeFuncionario, String sexo, String escolaridade, String matricula, int idCargo, String nomeCargo, int idDepartamento, String nomeDepartamento, String estadoCivil, Date dataNascimento, String nomeMae, String nomePai, String religiao, String tipoSangue, String cargaHoraria, String regimeTrabalho, String horarioInicio, String horarioFinal, String funcao, String nacionalidade, String pais, String naturalidade, String estadoNacionalidade, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, byte[] imagemFrenteCO) {
        this.idFunc = idFunc;
        this.statusFunc = statusFunc;
        this.dataCadastro = dataCadastro;
        this.foto = foto;
        this.nomeFuncionario = nomeFuncionario;
        this.sexo = sexo;
        this.escolaridade = escolaridade;
        this.matricula = matricula;
        this.idCargo = idCargo;
        this.nomeCargo = nomeCargo;
        this.idDepartamento = idDepartamento;
        this.nomeDepartamento = nomeDepartamento;
        this.estadoCivil = estadoCivil;
        this.dataNascimento = dataNascimento;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.religiao = religiao;
        this.tipoSangue = tipoSangue;
        this.cargaHoraria = cargaHoraria;
        this.regimeTrabalho = regimeTrabalho;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.funcao = funcao;
        this.nacionalidade = nacionalidade;
        this.pais = pais;
        this.naturalidade = naturalidade;
        this.estadoNacionalidade = estadoNacionalidade;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.imagemFrenteCO = imagemFrenteCO;
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
     * @return the statusFunc
     */
    public String getStatusFunc() {
        return statusFunc;
    }

    /**
     * @param statusFunc the statusFunc to set
     */
    public void setStatusFunc(String statusFunc) {
        this.statusFunc = statusFunc;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the nomeFuncionario
     */
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    /**
     * @param nomeFuncionario the nomeFuncionario to set
     */
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the escolaridade
     */
    public String getEscolaridade() {
        return escolaridade;
    }

    /**
     * @param escolaridade the escolaridade to set
     */
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the idCargo
     */
    public int getIdCargo() {
        return idCargo;
    }

    /**
     * @param idCargo the idCargo to set
     */
    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    /**
     * @return the nomeCargo
     */
    public String getNomeCargo() {
        return nomeCargo;
    }

    /**
     * @param nomeCargo the nomeCargo to set
     */
    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
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
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
     * @return the religiao
     */
    public String getReligiao() {
        return religiao;
    }

    /**
     * @param religiao the religiao to set
     */
    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    /**
     * @return the tipoSangue
     */
    public String getTipoSangue() {
        return tipoSangue;
    }

    /**
     * @param tipoSangue the tipoSangue to set
     */
    public void setTipoSangue(String tipoSangue) {
        this.tipoSangue = tipoSangue;
    }

    /**
     * @return the cargaHoraria
     */
    public String getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @param cargaHoraria the cargaHoraria to set
     */
    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @return the regimeTrabalho
     */
    public String getRegimeTrabalho() {
        return regimeTrabalho;
    }

    /**
     * @param regimeTrabalho the regimeTrabalho to set
     */
    public void setRegimeTrabalho(String regimeTrabalho) {
        this.regimeTrabalho = regimeTrabalho;
    }

    /**
     * @return the horarioInicio
     */
    public String getHorarioInicio() {
        return horarioInicio;
    }

    /**
     * @param horarioInicio the horarioInicio to set
     */
    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    /**
     * @return the horarioFinal
     */
    public String getHorarioFinal() {
        return horarioFinal;
    }

    /**
     * @param horarioFinal the horarioFinal to set
     */
    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    /**
     * @return the funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * @return the nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @param nacionalidade the nacionalidade to set
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the naturalidade
     */
    public String getNaturalidade() {
        return naturalidade;
    }

    /**
     * @param naturalidade the naturalidade to set
     */
    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    /**
     * @return the estadoNacionalidade
     */
    public String getEstadoNacionalidade() {
        return estadoNacionalidade;
    }

    /**
     * @param estadoNacionalidade the estadoNacionalidade to set
     */
    public void setEstadoNacionalidade(String estadoNacionalidade) {
        this.estadoNacionalidade = estadoNacionalidade;
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
     * @return the imagemFrenteCO
     */
    public byte[] getImagemFrenteCO() {
        return imagemFrenteCO;
    }

    /**
     * @param imagemFrenteCO the imagemFrenteCO to set
     */
    public void setImagemFrenteCO(byte[] imagemFrenteCO) {
        this.imagemFrenteCO = imagemFrenteCO;
    }

}
