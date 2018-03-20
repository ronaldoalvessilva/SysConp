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
public class RetornoPortariaCrc {

    private int idInternoCrc;
    private String confirmaCrc;
    private String respostaCrc;   

    public RetornoPortariaCrc(int idInternoCrc, String confirmaCrc, String respostaCrc) {
        this.idInternoCrc = idInternoCrc;
        this.confirmaCrc = confirmaCrc;
        this.respostaCrc = respostaCrc;
    }

    public RetornoPortariaCrc() {
    }

    /**
     * @return the idInternoCrc
     */
    public int getIdInternoCrc() {
        return idInternoCrc;
    }

    /**
     * @param idInternoCrc the idInternoCrc to set
     */
    public void setIdInternoCrc(int idInternoCrc) {
        this.idInternoCrc = idInternoCrc;
    }

    /**
     * @return the confirmaCrc
     */
    public String getConfirmaCrc() {
        return confirmaCrc;
    }

    /**
     * @param confirmaCrc the confirmaCrc to set
     */
    public void setConfirmaCrc(String confirmaCrc) {
        this.confirmaCrc = confirmaCrc;
    }

    /**
     * @return the respostaCrc
     */
    public String getRespostaCrc() {
        return respostaCrc;
    }

    /**
     * @param respostaCrc the respostaCrc to set
     */
    public void setRespostaCrc(String respostaCrc) {
        this.respostaCrc = respostaCrc;
    }
  }
