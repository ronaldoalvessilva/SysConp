/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProrrogarSaidaTemporariaPrisaoDomicilicar;
import static gestor.Visao.TelaProrrogracaoSaidaTemporariaDomiciliar.pTOTAL_REGISTROS_ATIVIDADES;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ListagemProrrogacaoSaidaTMPPD {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProrrogarSaidaTemporariaPrisaoDomicilicar objProrroga = new ProrrogarSaidaTemporariaPrisaoDomicilicar();

    public List<ProrrogarSaidaTemporariaPrisaoDomicilicar> read() throws Exception {
        pTOTAL_REGISTROS_ATIVIDADES = 0;
        List<ProrrogarSaidaTemporariaPrisaoDomicilicar> listaTodosInternos = new ArrayList<ProrrogarSaidaTemporariaPrisaoDomicilicar>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdProrroga,StatusRegistro,"
                    + "DataRegistro,Responsavel,TipoSaida "
                    + "FROM PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR");
            while (conecta.rs.next()) {
                ProrrogarSaidaTemporariaPrisaoDomicilicar pProrroga = new ProrrogarSaidaTemporariaPrisaoDomicilicar();
                pProrroga.setIdRegistro(conecta.rs.getInt("IdProrroga"));
                pProrroga.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
                pProrroga.setDataRegistro(conecta.rs.getDate("DataRegistro"));
                pProrroga.setResponsavel(conecta.rs.getString("Responsavel"));
                pProrroga.setTipoSaida(conecta.rs.getString("TipoSaida"));
                listaTodosInternos.add(pProrroga);
                pTOTAL_REGISTROS_ATIVIDADES = pTOTAL_REGISTROS_ATIVIDADES + 1;
            }
            return listaTodosInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ListagemProrrogacaoSaidaTMPPD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
