/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class listarParametros {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        List<AtividadesMensalRealizadaUnidades> listaParametros = new ArrayList<AtividadesMensalRealizadaUnidades>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT PagamentoKit "
                    + "FROM PARAMETROSCRC");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pParametros = new AtividadesMensalRealizadaUnidades();
                pParametros.setParametroKit(conecta.rs.getString("PagamentoKit"));
                listaParametros.add(pParametros);
            }
            return listaParametros;
        } catch (SQLException ex) {
            Logger.getLogger(listarParametros.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
