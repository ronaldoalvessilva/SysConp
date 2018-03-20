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
public class Cidades {

    private int IdCidade;
    private String NomeCidade;
    private String UfCidade;
    private int IdPais;
    private int DddCidade;
    private String NomePais;
    private String nomeusuario;    

    public Cidades(int IdCidade, String NomeCidade, String UfCidade, int IdPais, int DddCidade, String NomePais, String nomeusuario) {
        this.IdCidade = IdCidade;
        this.NomeCidade = NomeCidade;
        this.UfCidade = UfCidade;
        this.IdPais = IdPais;
        this.DddCidade = DddCidade;
        this.NomePais = NomePais;
        this.nomeusuario = nomeusuario;
    }

    public Cidades() {
    }

    /**
     * @return the IdCidade
     */
    public int getIdCidade() {
        return IdCidade;
    }

    /**
     * @param IdCidade the IdCidade to set
     */
    public void setIdCidade(int IdCidade) {
        this.IdCidade = IdCidade;
    }

    /**
     * @return the NomeCidade
     */
    public String getNomeCidade() {
        return NomeCidade;
    }

    /**
     * @param NomeCidade the NomeCidade to set
     */
    public void setNomeCidade(String NomeCidade) {
        this.NomeCidade = NomeCidade;
    }

    /**
     * @return the UfCidade
     */
    public String getUfCidade() {
        return UfCidade;
    }

    /**
     * @param UfCidade the UfCidade to set
     */
    public void setUfCidade(String UfCidade) {
        this.UfCidade = UfCidade;
    }

    /**
     * @return the IdPais
     */
    public int getIdPais() {
        return IdPais;
    }

    /**
     * @param IdPais the IdPais to set
     */
    public void setIdPais(int IdPais) {
        this.IdPais = IdPais;
    }

    /**
     * @return the DddCidade
     */
    public int getDddCidade() {
        return DddCidade;
    }

    /**
     * @param DddCidade the DddCidade to set
     */
    public void setDddCidade(int DddCidade) {
        this.DddCidade = DddCidade;
    }

    /**
     * @return the NomePais
     */
    public String getNomePais() {
        return NomePais;
    }

    /**
     * @param NomePais the NomePais to set
     */
    public void setNomePais(String NomePais) {
        this.NomePais = NomePais;
    }

    /**
     * @return the nomeusuario
     */
    public String getNomeusuario() {
        return nomeusuario;
    }

    /**
     * @param nomeusuario the nomeusuario to set
     */
    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }
}
