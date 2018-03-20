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
public class Paises {
    private int IdPais;
    private String NomePais;
    private int CodPais;
    private String nomeUsuario;   

    public Paises(int IdPais, String NomePais, int CodPais, String nomeUsuario) {
        this.IdPais = IdPais;
        this.NomePais = NomePais;
        this.CodPais = CodPais;
        this.nomeUsuario = nomeUsuario;
    }

    public Paises() {
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
     * @return the CodPais
     */
    public int getCodPais() {
        return CodPais;
    }

    /**
     * @param CodPais the CodPais to set
     */
    public void setCodPais(int CodPais) {
        this.CodPais = CodPais;
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
