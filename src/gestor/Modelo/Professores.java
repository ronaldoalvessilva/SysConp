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
public class Professores {

    private int idProf;
    private int idDisc;
    private int idItem;
    private Date dataNascProf;
    private String nomeProfessor;
    private String statusProf;
    private String fotoProf;
    private String estadoCivil;
    private String sexoProf;
    private String telefone;
    private String celular;
    private String celular1;
    private String idCod;
    private String descricaoInstituicao;
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String graduacao;
    private String especialidade;
    private String mestrado;
    private String doutorado;
    private String observacao;
    private String disciplina;
    private String obsDisciplina;
    private String usuarioInsert;
    private String usuarioUp;
    private String dsuarioDelete;
    private String dataInsert;
    private String dataUp;
    private String dataDelete;
    private String horarioInsert;
    private String horarioUp;      

    public Professores(int idProf, int idDisc, int idItem, Date dataNascProf, String nomeProfessor, String statusProf, String fotoProf, String estadoCivil, String sexoProf, String telefone, String celular, String celular1, String idCod, String descricaoInstituicao, String cep, String endereco, String bairro, String cidade, String estado, String graduacao, String especialidade, String mestrado, String doutorado, String observacao, String disciplina, String obsDisciplina, String usuarioInsert, String usuarioUp, String dsuarioDelete, String dataInsert, String dataUp, String dataDelete, String horarioInsert, String horarioUp) {
        this.idProf = idProf;
        this.idDisc = idDisc;
        this.idItem = idItem;
        this.dataNascProf = dataNascProf;
        this.nomeProfessor = nomeProfessor;
        this.statusProf = statusProf;
        this.fotoProf = fotoProf;
        this.estadoCivil = estadoCivil;
        this.sexoProf = sexoProf;
        this.telefone = telefone;
        this.celular = celular;
        this.celular1 = celular1;
        this.idCod = idCod;
        this.descricaoInstituicao = descricaoInstituicao;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.graduacao = graduacao;
        this.especialidade = especialidade;
        this.mestrado = mestrado;
        this.doutorado = doutorado;
        this.observacao = observacao;
        this.disciplina = disciplina;
        this.obsDisciplina = obsDisciplina;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dsuarioDelete = dsuarioDelete;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.dataDelete = dataDelete;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }

    public Professores() {
    }

    /**
     * @return the idProf
     */
    public int getIdProf() {
        return idProf;
    }

    /**
     * @param idProf the idProf to set
     */
    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    /**
     * @return the idDisc
     */
    public int getIdDisc() {
        return idDisc;
    }

    /**
     * @param idDisc the idDisc to set
     */
    public void setIdDisc(int idDisc) {
        this.idDisc = idDisc;
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
     * @return the dataNascProf
     */
    public Date getDataNascProf() {
        return dataNascProf;
    }

    /**
     * @param dataNascProf the dataNascProf to set
     */
    public void setDataNascProf(Date dataNascProf) {
        this.dataNascProf = dataNascProf;
    }

    /**
     * @return the nomeProfessor
     */
    public String getNomeProfessor() {
        return nomeProfessor;
    }

    /**
     * @param nomeProfessor the nomeProfessor to set
     */
    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    /**
     * @return the statusProf
     */
    public String getStatusProf() {
        return statusProf;
    }

    /**
     * @param statusProf the statusProf to set
     */
    public void setStatusProf(String statusProf) {
        this.statusProf = statusProf;
    }

    /**
     * @return the fotoProf
     */
    public String getFotoProf() {
        return fotoProf;
    }

    /**
     * @param fotoProf the fotoProf to set
     */
    public void setFotoProf(String fotoProf) {
        this.fotoProf = fotoProf;
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
     * @return the sexoProf
     */
    public String getSexoProf() {
        return sexoProf;
    }

    /**
     * @param sexoProf the sexoProf to set
     */
    public void setSexoProf(String sexoProf) {
        this.sexoProf = sexoProf;
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
     * @return the celular1
     */
    public String getCelular1() {
        return celular1;
    }

    /**
     * @param celular1 the celular1 to set
     */
    public void setCelular1(String celular1) {
        this.celular1 = celular1;
    }

    /**
     * @return the idCod
     */
    public String getIdCod() {
        return idCod;
    }

    /**
     * @param idCod the idCod to set
     */
    public void setIdCod(String idCod) {
        this.idCod = idCod;
    }

    /**
     * @return the descricaoInstituicao
     */
    public String getDescricaoInstituicao() {
        return descricaoInstituicao;
    }

    /**
     * @param descricaoInstituicao the descricaoInstituicao to set
     */
    public void setDescricaoInstituicao(String descricaoInstituicao) {
        this.descricaoInstituicao = descricaoInstituicao;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the graduacao
     */
    public String getGraduacao() {
        return graduacao;
    }

    /**
     * @param graduacao the graduacao to set
     */
    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    /**
     * @return the especialidade
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * @return the mestrado
     */
    public String getMestrado() {
        return mestrado;
    }

    /**
     * @param mestrado the mestrado to set
     */
    public void setMestrado(String mestrado) {
        this.mestrado = mestrado;
    }

    /**
     * @return the doutorado
     */
    public String getDoutorado() {
        return doutorado;
    }

    /**
     * @param doutorado the doutorado to set
     */
    public void setDoutorado(String doutorado) {
        this.doutorado = doutorado;
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
     * @return the disciplina
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the obsDisciplina
     */
    public String getObsDisciplina() {
        return obsDisciplina;
    }

    /**
     * @param obsDisciplina the obsDisciplina to set
     */
    public void setObsDisciplina(String obsDisciplina) {
        this.obsDisciplina = obsDisciplina;
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
     * @return the dsuarioDelete
     */
    public String getDsuarioDelete() {
        return dsuarioDelete;
    }

    /**
     * @param dsuarioDelete the dsuarioDelete to set
     */
    public void setDsuarioDelete(String dsuarioDelete) {
        this.dsuarioDelete = dsuarioDelete;
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
     * @return the dataDelete
     */
    public String getDataDelete() {
        return dataDelete;
    }

    /**
     * @param dataDelete the dataDelete to set
     */
    public void setDataDelete(String dataDelete) {
        this.dataDelete = dataDelete;
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

    @Override
    public String toString() {
        return getNomeProfessor(); //To change body of generated methods, choose Tools | Templates.
    }    
}
