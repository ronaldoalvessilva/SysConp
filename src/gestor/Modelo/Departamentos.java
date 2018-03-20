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

    private int IdDepartamento;
    private boolean StatusDepartamento;
    private String NomeDepartamento;
  
    public Departamentos() {
    }

    /**
     * @return the IdDepartamento
     */
    public int getIdDepartamento() {
        return IdDepartamento;
    }

    /**
     * @param IdDepartamento the IdDepartamento to set
     */
    public void setIdDepartamento(int IdDepartamento) {
        this.IdDepartamento = IdDepartamento;
    }

    /**
     * @return the StatusDepartamento
     */
    public boolean isStatusDepartamento() {
        return StatusDepartamento;
    }

    /**
     * @param StatusDepartamento the StatusDepartamento to set
     */
    public void setStatusDepartamento(boolean StatusDepartamento) {
        this.StatusDepartamento = StatusDepartamento;
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

}
