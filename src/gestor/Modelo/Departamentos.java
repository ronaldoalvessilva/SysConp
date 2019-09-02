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
public class Departamentos {

    private int idDepartamento;
    private boolean statusDepartamento;
    private String nomeDepartamento;
    private int numeroSala;

    public Departamentos() {
    }

    public Departamentos(int idDepartamento, boolean statusDepartamento, String nomeDepartamento, int numeroSala) {
        this.idDepartamento = idDepartamento;
        this.statusDepartamento = statusDepartamento;
        this.nomeDepartamento = nomeDepartamento;
        this.numeroSala = numeroSala;
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
     * @return the statusDepartamento
     */
    public boolean isStatusDepartamento() {
        return statusDepartamento;
    }

    /**
     * @param statusDepartamento the statusDepartamento to set
     */
    public void setStatusDepartamento(boolean statusDepartamento) {
        this.statusDepartamento = statusDepartamento;
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
     * @return the numeroSala
     */
    public int getNumeroSala() {
        return numeroSala;
    }

    /**
     * @param numeroSala the numeroSala to set
     */
    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }
}
