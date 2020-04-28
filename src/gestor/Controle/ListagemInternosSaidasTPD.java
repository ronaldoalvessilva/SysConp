/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProrrogarSaidaTemporariaPrisaoDomicilicar;
import static gestor.Visao.TelaProrrogracaoSaidaTemporariaDomiciliar.IdRegistro;
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
public class ListagemInternosSaidasTPD {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProrrogarSaidaTemporariaPrisaoDomicilicar objProrroga = new ProrrogarSaidaTemporariaPrisaoDomicilicar();

    public List<ProrrogarSaidaTemporariaPrisaoDomicilicar> read() throws Exception {
        List<ProrrogarSaidaTemporariaPrisaoDomicilicar> listaTodosInternosCodigo = new ArrayList<ProrrogarSaidaTemporariaPrisaoDomicilicar>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdItem,IdProrroga,IdInternoCrc, "
                    + "NomeInternoCrc,DataPrevRetorno,IdSaida "
                    + "FROM ITEM_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITEM_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE IdProrroga='" + IdRegistro.getText() + "'");
            while (conecta.rs.next()) {
                ProrrogarSaidaTemporariaPrisaoDomicilicar pProrroga = new ProrrogarSaidaTemporariaPrisaoDomicilicar();
                pProrroga.setIdItem(conecta.rs.getInt("IdItem"));
                pProrroga.setIdRegistro(conecta.rs.getInt("IdProrroga"));
                pProrroga.setStatusRegistro(conecta.rs.getString("IdInternoCrc"));                
                pProrroga.setResponsavel(conecta.rs.getString("NomeInternoCrc"));
                pProrroga.setDataRegistro(conecta.rs.getDate("DataPrevRetorno"));
                pProrroga.setIdItem(conecta.rs.getInt("IdSaida"));
                listaTodosInternosCodigo.add(pProrroga);
            }
            return listaTodosInternosCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(ListagemInternosSaidasTPD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
