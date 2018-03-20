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
public class Cargos {
    private int IdCargo;
    private boolean StatusCargo;
    private String NomeCargo;

    public Cargos(int IdCargo, boolean StatusCargo, String NomeCargo) {
        this.IdCargo = IdCargo;
        this.StatusCargo = StatusCargo;
        this.NomeCargo = NomeCargo;
    }

    public Cargos() {
    }

    /**
     * @return the IdCargo
     */
    public int getIdCargo() {
        return IdCargo;
    }

    /**
     * @param IdCargo the IdCargo to set
     */
    public void setIdCargo(int IdCargo) {
        this.IdCargo = IdCargo;
    }

    /**
     * @return the StatusCargo
     */
    public boolean isStatusCargo() {
        return StatusCargo;
    }

    /**
     * @param StatusCargo the StatusCargo to set
     */
    public void setStatusCargo(boolean StatusCargo) {
        this.StatusCargo = StatusCargo;
    }

    /**
     * @return the NomeCargo
     */
    public String getNomeCargo() {
        return NomeCargo;
    }

    /**
     * @param NomeCargo the NomeCargo to set
     */
    public void setNomeCargo(String NomeCargo) {
        this.NomeCargo = NomeCargo;
    }
}
