/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Pavilhao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ControlPavilhaoPSP {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    public List<Pavilhao> read() throws Exception {
        conecta.abrirConexao();
        List<Pavilhao> nomePavilhao = new ArrayList<Pavilhao>();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO");
            while (conecta.rs.next()) {
                Pavilhao pLib = new Pavilhao();
                pLib.setIdPav(conecta.rs.getInt("IdPav"));
                pLib.setDescricaoPav(conecta.rs.getString("DescricaoPav"));
                nomePavilhao.add(pLib);
            }
            return nomePavilhao;
        } catch (SQLException ex) {
            Logger.getLogger(ControleLiberadorBasePSP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
