/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradasSaidasColaboradores;
import static gestor.Visao.TelaEntradaSaidasColaboradores.jIdRegistro;
import static gestor.Visao.TelaEntradaSaidasColaboradores.pTOTAL_registros;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo.silva7
 */
public class PesquisarGravacaoColaboradoresCodigo {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradasSaidasColaboradores objEntraSaiFunc = new EntradasSaidasColaboradores();
        
     public List<EntradasSaidasColaboradores> read() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<EntradasSaidasColaboradores> listaRegistroEntradasSaidasColaboradores = new ArrayList<EntradasSaidasColaboradores>();
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegistro, "
                    + "StatusRegistro, "
                    + "DataRegistro, "
                    + "Operacao, "
                    + "TipoMovimento, "
                    + "UnidadeOrigem, "
                    + "UnidadeDestino, "
                    + "Observacao "
                    + "FROM ENTRADAS_SAIDAS_COLABORADORES "
                    + "WHERE ENTRADAS_SAIDAS_COLABORADORES.IdRegistro='" + jIdRegistro.getText() + "'");
            while (conecta.rs.next()) {
                EntradasSaidasColaboradores pEntradaSaidaFunc = new EntradasSaidasColaboradores();
                pEntradaSaidaFunc.setIdRegistro(conecta.rs.getInt("IdRegistro"));
                pEntradaSaidaFunc.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
                pEntradaSaidaFunc.setDataRegistro(conecta.rs.getDate("DataRegistro"));
                pEntradaSaidaFunc.setOperacao(conecta.rs.getString("Operacao"));
                pEntradaSaidaFunc.setTipoMovimento(conecta.rs.getString("TipoMovimento"));
                pEntradaSaidaFunc.setUnidadeOrigem(conecta.rs.getString("UnidadeOrigem"));
                pEntradaSaidaFunc.setUnidadeDestino(conecta.rs.getString("UnidadeDestino"));
                pEntradaSaidaFunc.setMotivo(conecta.rs.getString("Motivo"));
                listaRegistroEntradasSaidasColaboradores.add(pEntradaSaidaFunc);
                pTOTAL_registros = pTOTAL_registros + 1;
            }
            return listaRegistroEntradasSaidasColaboradores;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarInternosSaidasSimbolicas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
