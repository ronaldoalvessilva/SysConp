/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProrrogarSaidaTemporariaPrisaoDomicilicar;
import static gestor.Visao.TelaProrrogracaoSaidaTemporariaDomiciliar.IdItem;
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
public class ListagemProrrogacaoInternosSelecionados {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProrrogarSaidaTemporariaPrisaoDomicilicar objProrroga = new ProrrogarSaidaTemporariaPrisaoDomicilicar();

    public List<ProrrogarSaidaTemporariaPrisaoDomicilicar> read() throws Exception {

        List<ProrrogarSaidaTemporariaPrisaoDomicilicar> listaTodasAtividades = new ArrayList<ProrrogarSaidaTemporariaPrisaoDomicilicar>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR.IdItem, "
                    + "ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR.IdProrroga, "
                    + "ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR.IdInternoCrc, "
                    + "ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR.DataNova, "
                    + "ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR.IdSaida, "
                    + "ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR.DataSaida, "
                    + "PRONTUARIOSCRC.NomeInternoCrc,ITENSREGSAIDA.DestinoSaida "
                    + "FROM ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR "
                    + "INNER JOIN MOVISR "
                    + "ON ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR.IdInternoCrc=MOVISR.IdInternoCrc "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN ITENSREGSAIDA "
                    + "ON MOVISR.IdInternoCrc=ITENSREGSAIDA.IdInternoCrc "
                    + "WHERE ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR.IdItem='" + IdItem + "' ");
            while (conecta.rs.next()) {
                ProrrogarSaidaTemporariaPrisaoDomicilicar pProrroga = new ProrrogarSaidaTemporariaPrisaoDomicilicar();
                pProrroga.setIdItem(conecta.rs.getInt("IdItem"));
                pProrroga.setIdRegistro(conecta.rs.getInt("IdProrroga"));
                pProrroga.setIdInternoPro(conecta.rs.getInt("IdInternoCrc"));
                pProrroga.setNomeInternoPro(conecta.rs.getString("NomeInternoCrc"));
                pProrroga.setSituacaoPro(conecta.rs.getString("DestinoSaida"));
                pProrroga.setIdSaida(conecta.rs.getInt("IdSaida"));
                pProrroga.setDataSaida(conecta.rs.getDate("DataSaida"));               
                pProrroga.setDataNova(conecta.rs.getDate("DataNova"));
                listaTodasAtividades.add(pProrroga);
            }
            return listaTodasAtividades;
        } catch (SQLException ex) {
            Logger.getLogger(ListagemProrrogacaoInternosSelecionados.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
