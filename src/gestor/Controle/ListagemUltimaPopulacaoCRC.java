/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidasPolucaoInternos;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ListagemUltimaPopulacaoCRC {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidasPolucaoInternos objEntradaSaida = new EntradaSaidasPolucaoInternos();

    public EntradaSaidasPolucaoInternos selecionarPopulacao(EntradaSaidasPolucaoInternos objEntradaSaida) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT Populacao "
                    + "FROM ENTRADAS_SAIDAS_POPULACAO_INTERNOS");
            conecta.rs.last();
            objEntradaSaida.setPopulacao(conecta.rs.getInt("Populacao"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi selecionar a população.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaida;
    }
}
