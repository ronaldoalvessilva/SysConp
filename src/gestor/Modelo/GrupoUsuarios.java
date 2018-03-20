/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor.Modelo;

import java.util.ArrayList;

/**
 *
 * @author Ronaldo
 */
public class GrupoUsuarios {

    public static ArrayList<GrupoUsuarios> getInternoNome(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int IdGrupo;
    private boolean StatusGrupo;
    private String NomeGrupo;

    public GrupoUsuarios(int IdGrupo, boolean StatusGrupo, String NomeGrupo) {
        this.IdGrupo = IdGrupo;
        this.StatusGrupo = StatusGrupo;
        this.NomeGrupo = NomeGrupo;
    }

    public GrupoUsuarios() {
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
     * @return the StatusGrupo
     */
    public boolean isStatusGrupo() {
        return StatusGrupo;
    }

    /**
     * @param StatusGrupo the StatusGrupo to set
     */
    public void setStatusGrupo(boolean StatusGrupo) {
        this.StatusGrupo = StatusGrupo;
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

    public void getNomeGrupo(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
}
