/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProrrogarSaidaTemporariaPrisaoDomicilicar;
import static gestor.Visao.TelaProrrogracaoSaidaTemporariaDomiciliar.ID_ITEM;
import static gestor.Visao.TelaProrrogracaoSaidaTemporariaDomiciliar.IdRegistro;
import static gestor.Visao.TelaProrrogracaoSaidaTemporariaDomiciliar.jIdInternoPro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class PesquisaExistenciaInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProrrogarSaidaTemporariaPrisaoDomicilicar objProrroga = new ProrrogarSaidaTemporariaPrisaoDomicilicar();

    public List<ProrrogarSaidaTemporariaPrisaoDomicilicar> read() throws Exception {
        List<ProrrogarSaidaTemporariaPrisaoDomicilicar> listaExisteInterno = new ArrayList<ProrrogarSaidaTemporariaPrisaoDomicilicar>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdInternoCrc,IdItem,IdProrroga "
                    + "FROM ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR "
                    + "WHERE IdProrroga='" + IdRegistro.getText() + "' "
                    + "AND IdInternoCrc='" + jIdInternoPro.getText() + "'");
            while (conecta.rs.next()) {
                ProrrogarSaidaTemporariaPrisaoDomicilicar pExisteInterno = new ProrrogarSaidaTemporariaPrisaoDomicilicar();
                pExisteInterno.setIdItem(conecta.rs.getInt("IdItem"));
                pExisteInterno.setIdRegistro(conecta.rs.getInt("IdProrroga"));
                pExisteInterno.setIdInternoPro(conecta.rs.getInt("IdInternoCrc"));
                listaExisteInterno.add(pExisteInterno);
            }
            return listaExisteInterno;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaExistenciaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
