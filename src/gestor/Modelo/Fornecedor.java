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
public class Fornecedor {

    private int idForn;
    private String classFor;
    private Date dataCadastro;
    private String statusFor;
    private String razaoSocial;
    private String nomeFantasia;
    private String departamento;
    private String cnpj;
    private String insEstadual;
    private String nomeContato;
    private String telefone;
    private String telefone1;
    private String celular;
    private String email;
    private String fax;
    private String endereco;
    private String compl;
    private String cep;
    private String cidade;
    private String estado;
    private String enderecoCob;
    private String complCob;
    private String cepCob;
    private String cidadeCob;
    private String estadoCob;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;
    private String horarioUp;     
    private String modulo;        

    public Fornecedor(int idForn, String classFor, Date dataCadastro, String statusFor, String razaoSocial, String nomeFantasia, String departamento, String cnpj, String insEstadual, String nomeContato, String telefone, String telefone1, String celular, String email, String fax, String endereco, String compl, String cep, String cidade, String estado, String enderecoCob, String complCob, String cepCob, String cidadeCob, String estadoCob, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp, String modulo) {
        this.idForn = idForn;
        this.classFor = classFor;
        this.dataCadastro = dataCadastro;
        this.statusFor = statusFor;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.departamento = departamento;
        this.cnpj = cnpj;
        this.insEstadual = insEstadual;
        this.nomeContato = nomeContato;
        this.telefone = telefone;
        this.telefone1 = telefone1;
        this.celular = celular;
        this.email = email;
        this.fax = fax;
        this.endereco = endereco;
        this.compl = compl;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.enderecoCob = enderecoCob;
        this.complCob = complCob;
        this.cepCob = cepCob;
        this.cidadeCob = cidadeCob;
        this.estadoCob = estadoCob;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
        this.modulo = modulo;
    }

    public Fornecedor() {
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
     * @return the classFor
     */
    public String getClassFor() {
        return classFor;
    }

    /**
     * @param classFor the classFor to set
     */
    public void setClassFor(String classFor) {
        this.classFor = classFor;
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
     * @return the statusFor
     */
    public String getStatusFor() {
        return statusFor;
    }

    /**
     * @param statusFor the statusFor to set
     */
    public void setStatusFor(String statusFor) {
        this.statusFor = statusFor;
    }

    /**
     * @return the razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razaoSocial the razaoSocial to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * @return the nomeFantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * @param nomeFantasia the nomeFantasia to set
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the insEstadual
     */
    public String getInsEstadual() {
        return insEstadual;
    }

    /**
     * @param insEstadual the insEstadual to set
     */
    public void setInsEstadual(String insEstadual) {
        this.insEstadual = insEstadual;
    }

    /**
     * @return the nomeContato
     */
    public String getNomeContato() {
        return nomeContato;
    }

    /**
     * @param nomeContato the nomeContato to set
     */
    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
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
     * @return the compl
     */
    public String getCompl() {
        return compl;
    }

    /**
     * @param compl the compl to set
     */
    public void setCompl(String compl) {
        this.compl = compl;
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
     * @return the enderecoCob
     */
    public String getEnderecoCob() {
        return enderecoCob;
    }

    /**
     * @param enderecoCob the enderecoCob to set
     */
    public void setEnderecoCob(String enderecoCob) {
        this.enderecoCob = enderecoCob;
    }

    /**
     * @return the complCob
     */
    public String getComplCob() {
        return complCob;
    }

    /**
     * @param complCob the complCob to set
     */
    public void setComplCob(String complCob) {
        this.complCob = complCob;
    }

    /**
     * @return the cepCob
     */
    public String getCepCob() {
        return cepCob;
    }

    /**
     * @param cepCob the cepCob to set
     */
    public void setCepCob(String cepCob) {
        this.cepCob = cepCob;
    }

    /**
     * @return the cidadeCob
     */
    public String getCidadeCob() {
        return cidadeCob;
    }

    /**
     * @param cidadeCob the cidadeCob to set
     */
    public void setCidadeCob(String cidadeCob) {
        this.cidadeCob = cidadeCob;
    }

    /**
     * @return the estadoCob
     */
    public String getEstadoCob() {
        return estadoCob;
    }

    /**
     * @param estadoCob the estadoCob to set
     */
    public void setEstadoCob(String estadoCob) {
        this.estadoCob = estadoCob;
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
