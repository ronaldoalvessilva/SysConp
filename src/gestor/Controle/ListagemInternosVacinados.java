/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.listarInternosPopulacaoNominal;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import static gestor.Visao.TelaAtividadesMensalUnidade.jDataPeriodoFinal;
import static gestor.Visao.TelaAtividadesMensalUnidade.jDataPeriodoInicial;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static gestor.Visao.TelaAtividadesMensalUnidade.pQUANTIDADE_TOTAL_VACINAS;

/**
 *
 * @author ronal
 */
public class ListagemInternosVacinados {
    
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();
    //
    String pDATA_INICIAL;
    String pDATA_FINAL;
    String pVACINADO = "Reagente";

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        pQUANTIDADE_TOTAL_VACINAS = 0;        
        List<AtividadesMensalRealizadaUnidades> listaInfectoDiagnosticadoEVO = new ArrayList<AtividadesMensalRealizadaUnidades>();
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
            pDATA_INICIAL = formatoAmerica.format(jDataPeriodoInicial.getDate().getTime());
            pDATA_FINAL = formatoAmerica.format(jDataPeriodoFinal.getDate().getTime());
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            pDATA_INICIAL = formatoAmerica.format(jDataPeriodoInicial.getDate().getTime());
            pDATA_FINAL = formatoAmerica.format(jDataPeriodoFinal.getDate().getTime());
        }
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT DataCart "
                    + "FROM CARTILHA_VACINAS_INTERNOS "
                    + "WHERE "
                    + "CONVERT(DATE, DataCart) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "'");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pInfectoEvo = new AtividadesMensalRealizadaUnidades();
                pInfectoEvo.setDataAtendimento(conecta.rs.getDate("DataCart"));               
                pQUANTIDADE_TOTAL_VACINAS = pQUANTIDADE_TOTAL_VACINAS + 1;
                listaInfectoDiagnosticadoEVO.add(pInfectoEvo);
            }
            return listaInfectoDiagnosticadoEVO;
        } catch (SQLException ex) {
            Logger.getLogger(listarInternosPopulacaoNominal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
