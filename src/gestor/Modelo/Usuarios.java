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
public class Usuarios {
    
    private int IdUsuario;   
    private Boolean Status;
    private Date dataCadastro;
    private String NomeUsuario;
    private String Login;
    private String Senha1;
    private String Senha2;
    private int idUserGroup;
    private int IdGrupo;
    private String NomeGrupo; 
    private int idDepartamento;
    private String NomeDepartamento;
    private int idCargo;
    private String nomeCargo;
    private int idEmpresa;
    private String descricaoEmpresa;
    private int idModulo;
    private int idMod;
    private String nomeModulo;
    private String permissaoModulo;           

    public Usuarios(int IdUsuario, Boolean Status, Date dataCadastro, String NomeUsuario, String Login, String Senha1, String Senha2, int idUserGroup, int IdGrupo, String NomeGrupo, int idDepartamento, String NomeDepartamento, int idCargo, String nomeCargo, int idEmpresa, String descricaoEmpresa, int idModulo, int idMod, String nomeModulo, String permissaoModulo) {
        this.IdUsuario = IdUsuario;
        this.Status = Status;
        this.dataCadastro = dataCadastro;
        this.NomeUsuario = NomeUsuario;
        this.Login = Login;
        this.Senha1 = Senha1;
        this.Senha2 = Senha2;
        this.idUserGroup = idUserGroup;
        this.IdGrupo = IdGrupo;
        this.NomeGrupo = NomeGrupo;
        this.idDepartamento = idDepartamento;
        this.NomeDepartamento = NomeDepartamento;
        this.idCargo = idCargo;
        this.nomeCargo = nomeCargo;
        this.idEmpresa = idEmpresa;
        this.descricaoEmpresa = descricaoEmpresa;
        this.idModulo = idModulo;
        this.idMod = idMod;
        this.nomeModulo = nomeModulo;
        this.permissaoModulo = permissaoModulo;
    }

    public Usuarios() {
    }

    /**
     * @return the IdUsuario
     */
    public int getIdUsuario() {
        return IdUsuario;
    }

    /**
     * @param IdUsuario the IdUsuario to set
     */
    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    /**
     * @return the Status
     */
    public Boolean getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Boolean Status) {
        this.Status = Status;
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
     * @return the NomeUsuario
     */
    public String getNomeUsuario() {
        return NomeUsuario;
    }

    /**
     * @param NomeUsuario the NomeUsuario to set
     */
    public void setNomeUsuario(String NomeUsuario) {
        this.NomeUsuario = NomeUsuario;
    }

    /**
     * @return the Login
     */
    public String getLogin() {
        return Login;
    }

    /**
     * @param Login the Login to set
     */
    public void setLogin(String Login) {
        this.Login = Login;
    }

    /**
     * @return the Senha1
     */
    public String getSenha1() {
        return Senha1;
    }

    /**
     * @param Senha1 the Senha1 to set
     */
    public void setSenha1(String Senha1) {
        this.Senha1 = Senha1;
    }

    /**
     * @return the Senha2
     */
    public String getSenha2() {
        return Senha2;
    }

    /**
     * @param Senha2 the Senha2 to set
     */
    public void setSenha2(String Senha2) {
        this.Senha2 = Senha2;
    }

    /**
     * @return the idUserGroup
     */
    public int getIdUserGroup() {
        return idUserGroup;
    }

    /**
     * @param idUserGroup the idUserGroup to set
     */
    public void setIdUserGroup(int idUserGroup) {
        this.idUserGroup = idUserGroup;
    }

    /**
     * @return the IdGrupo
     */
    public int getIdGrupo() {
        return IdGrupo;
    }

    /**
     * @param IdGrupo the IdGrupo to set
     */
    public void setIdGrupo(int IdGrupo) {
        this.IdGrupo = IdGrupo;
    }

    /**
     * @return the NomeGrupo
     */
    public String getNomeGrupo() {
        return NomeGrupo;
    }

    /**
     * @param NomeGrupo the NomeGrupo to set
     */
    public void setNomeGrupo(String NomeGrupo) {
        this.NomeGrupo = NomeGrupo;
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
     * @return the NomeDepartamento
     */
    public String getNomeDepartamento() {
        return NomeDepartamento;
    }

    /**
     * @param NomeDepartamento the NomeDepartamento to set
     */
    public void setNomeDepartamento(String NomeDepartamento) {
        this.NomeDepartamento = NomeDepartamento;
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
     * @return the idEmpresa
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * @return the descricaoEmpresa
     */
    public String getDescricaoEmpresa() {
        return descricaoEmpresa;
    }

    /**
     * @param descricaoEmpresa the descricaoEmpresa to set
     */
    public void setDescricaoEmpresa(String descricaoEmpresa) {
        this.descricaoEmpresa = descricaoEmpresa;
    }

    /**
     * @return the idModulo
     */
    public int getIdModulo() {
        return idModulo;
    }

    /**
     * @param idModulo the idModulo to set
     */
    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    /**
     * @return the idMod
     */
    public int getIdMod() {
        return idMod;
    }

    /**
     * @param idMod the idMod to set
     */
    public void setIdMod(int idMod) {
        this.idMod = idMod;
    }

    /**
     * @return the nomeModulo
     */
    public String getNomeModulo() {
        return nomeModulo;
    }

    /**
     * @param nomeModulo the nomeModulo to set
     */
    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }

    /**
     * @return the permissaoModulo
     */
    public String getPermissaoModulo() {
        return permissaoModulo;
    }

    /**
     * @param permissaoModulo the permissaoModulo to set
     */
    public void setPermissaoModulo(String permissaoModulo) {
        this.permissaoModulo = permissaoModulo;
    }
}
