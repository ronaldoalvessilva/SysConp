/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProrrogarSaidaTemporariaPrisaoDomicilicar;
import static gestor.Visao.TelaProrrogracaoSaidaTemporariaDomiciliar.jCodigo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ListagemProrrogacaoSelecionada {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProrrogarSaidaTemporariaPrisaoDomicilicar objProrroga = new ProrrogarSaidaTemporariaPrisaoDomicilicar();

    public List<ProrrogarSaidaTemporariaPrisaoDomicilicar> read() throws Exception {

        List<ProrrogarSaidaTemporariaPrisaoDomicilicar> listaTodasAtividades = new ArrayList<ProrrogarSaidaTemporariaPrisaoDomicilicar>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdProrroga,StatusRegistro,"
                    + "DataRegistro,Responsavel,TipoSaida,Documento,DataDocumento,Observacao "
                    + "FROM PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR "
                    + "WHERE IdProrroga='" + jCodigo.getText() + "' ");
            while (conecta.rs.next()) {
                ProrrogarSaidaTemporariaPrisaoDomicilicar pProrroga = new ProrrogarSaidaTemporariaPrisaoDomicilicar();
                pProrroga.setIdRegistro(conecta.rs.getInt("IdProrroga"));
                pProrroga.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
                pProrroga.setDataRegistro(conecta.rs.getDate("DataRegistro"));
                pProrroga.setResponsavel(conecta.rs.getString("Responsavel"));
                pProrroga.setTipoSaida(conecta.rs.getString("TipoSaida"));
                pProrroga.setDocumento(conecta.rs.getString("Documento"));
                pProrroga.setDataDocumento(conecta.rs.getDate("DataDocumento"));
                pProrroga.setObservacao(conecta.rs.getString("Observacao"));
                listaTodasAtividades.add(pProrroga);
            }
            return listaTodasAtividades;
        } catch (SQLException ex) {
            Logger.getLogger(ListagemProrrogacaoSelecionada.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
