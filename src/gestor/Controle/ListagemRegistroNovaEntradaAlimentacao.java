/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidasPolucaoInternos;
import static gestor.Visao.TelaNovaEntradaPortariaCrc.jIdlanc;
import java.sql.SQLException;

/**
 *
 * @author ronal
 */
public class ListagemRegistroNovaEntradaAlimentacao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidasPolucaoInternos objEntradaSaida = new EntradaSaidasPolucaoInternos();

    public EntradaSaidasPolucaoInternos selecionarRegistroEntrada(EntradaSaidasPolucaoInternos objEntradaSaida) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdDocumento,Populacao, "
                    + "DataMovimento,HorarioMovimento,Quantidade "
                    + "FROM ENTRADAS_SAIDAS_POPULACAO_INTERNOS "
                    + "WHERE IdDocumento='" + jIdlanc.getText() + "'");
            conecta.rs.first();
            objEntradaSaida.setIdDocumento(conecta.rs.getInt("IdDocumento"));
            objEntradaSaida.setDataMovimento(conecta.rs.getDate("DataMovimento"));
            objEntradaSaida.setHorarioMovimento(conecta.rs.getString("HorarioMovimento"));
            objEntradaSaida.setQuantidade(conecta.rs.getInt("Quantidade"));
        } catch (SQLException ex) {
          //  JOptionPane.showMessageDialog(null, "Não foi possível selecionar a registro.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaida;
    }
}
