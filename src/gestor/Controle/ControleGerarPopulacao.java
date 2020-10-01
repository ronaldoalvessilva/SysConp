/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FechamentoRegistros;
import gestor.Modelo.GerarPopNominal;
import static gestor.Visao.TelaApagarPopulacaoCRC.jDataExclusao;
import static gestor.Visao.TelaApagarPopulacaoCRC.pDATA_PESQUISA;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static gestor.Visao.TelaApagarPopulacaoCRC.pRESPOSTA;
import static gestor.Visao.TelaApagarPopulacaoCRC.pREPSOSTA_existencia;
import static gestor.Visao.TelaFechamentoSistema.jDataFechamento;
import static gestor.Visao.TelaApagarPopulacaoCRC.pQUANTIDADE_registros;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ronaldo
 */
public class ControleGerarPopulacao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    GerarPopNominal objPopNom = new GerarPopNominal();

    //Método para SALVAR POPULAÇÃO NOMINAL
    public GerarPopNominal incluirPopulacaoNominal(GerarPopNominal objPopNom) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO POPULACAOINTERNOS_CRC (DataPop,IdInternoCrc)VALUES(?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objPopNom.getDataLanc().getTime()));
            pst.setInt(2, objPopNom.getIdInternoCrc());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopNom;
    }

    //EXCLUIR POPULAÇÃO CRC
    public GerarPopNominal excluirPopulacaoNominal(GerarPopNominal objPopNom) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM POPULACAOINTERNOS_CRC WHERE DataPop='" + objPopNom.getDataExclusaoPop() + "'");
            pst.executeUpdate();
            pRESPOSTA = "Sim";
        } catch (SQLException ex) {
            pRESPOSTA = "Não";
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objPopNom;
    }

    // VERIFICAR POPULAÇÃO NO LINUX
    public GerarPopNominal verificarPopulacaoLINUX_WINDOWS(GerarPopNominal objPopNom) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DataPop FROM POPULACAOINTERNOS_CRC WHERE DataPop='" + objPopNom.getDataExclusaoPop() + "'");
            conecta.rs.first();
            pREPSOSTA_existencia = conecta.rs.getString("DataPop");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
        return objPopNom;
    }

    public List<FechamentoRegistros> read() throws Exception {
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
            pDATA_PESQUISA = formatoAmerica.format(jDataExclusao.getDate().getTime());
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            pDATA_PESQUISA = formatoAmerica.format(jDataExclusao.getDate().getTime());
        }
        pQUANTIDADE_registros = 0;
        List<FechamentoRegistros> LISTAR_populacao = new ArrayList<FechamentoRegistros>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM "
                    + "POPULACAOINTERNOS_CRC "
                    + "WHERE DataPop='" + pDATA_PESQUISA + "'");
            while (conecta.rs.next()) {
                FechamentoRegistros pPopulcao = new FechamentoRegistros();
                pPopulcao.setDataFechamento(conecta.rs.getString("DataPop"));
                LISTAR_populacao.add(pPopulcao);
                pQUANTIDADE_registros = pQUANTIDADE_registros + 1;
            }
            return LISTAR_populacao;
        } catch (SQLException ex) {
            Logger.getLogger(ListagemOcorrenciaEF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
