/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import gestor.Modelo.EntradaSaidasPolucaoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ConversaoDatasEntradasSaidaPopulacaoAlimento {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidasPolucaoInternos objEntradaSaida = new EntradaSaidasPolucaoInternos();

    //ENTRADAS_SAIDAS_POPULACAO_INTERNOS 
    public EntradaSaidasPolucaoInternos alterarDataEntradaSaidaInternosPop(EntradaSaidasPolucaoInternos objEntradaSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAS_SAIDAS_POPULACAO_INTERNOS SET DataMovimento=CONVERT(DATE, DataMovimento,103)");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR (ENTRADAS_SAIDAS_POPULACAO_INTERNOS) os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaida;
    }
}
