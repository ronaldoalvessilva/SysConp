/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProrrogarSaidaTemporariaPrisaoDomicilicar;
import static gestor.Visao.TelaAtividadesMensalUnidade.jDataPesFinal;
import static gestor.Visao.TelaAtividadesMensalUnidade.jDataPesqInicial;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaProrrogracaoSaidaTemporariaDomiciliar.pTOTAL_REGISTROS_ATIVIDADES;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ListagemSaidasTMP_PD_Data {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProrrogarSaidaTemporariaPrisaoDomicilicar objProrroga = new ProrrogarSaidaTemporariaPrisaoDomicilicar();
    //
    String pDATA_INICIAL;
    String pDATA_FINAL;

    public List<ProrrogarSaidaTemporariaPrisaoDomicilicar> read() throws Exception {
        pTOTAL_REGISTROS_ATIVIDADES = 0;
        List<ProrrogarSaidaTemporariaPrisaoDomicilicar> listaRegistroData = new ArrayList<ProrrogarSaidaTemporariaPrisaoDomicilicar>();
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("yyyy/MM/dd");
            pDATA_INICIAL = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
            pDATA_FINAL = formatoAmerica.format(jDataPesFinal.getDate().getTime());
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            pDATA_INICIAL = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
            pDATA_FINAL = formatoAmerica.format(jDataPesFinal.getDate().getTime());
        }
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdProrroga,StatusRegistro,"
                    + "DataRegistro,Responsavel,TipoSaida "
                    + "FROM PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR "
                    + "WHERE CONVERT(DATE, DataRegistro,103) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' ");
            while (conecta.rs.next()) {
                ProrrogarSaidaTemporariaPrisaoDomicilicar pProrroga = new ProrrogarSaidaTemporariaPrisaoDomicilicar();
                pProrroga.setIdRegistro(conecta.rs.getInt("IdProrroga"));
                pProrroga.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
                pProrroga.setDataRegistro(conecta.rs.getDate("DataRegistro"));
                pProrroga.setResponsavel(conecta.rs.getString("Responsavel"));
                pProrroga.setTipoSaida(conecta.rs.getString("TipoSaida"));
                listaRegistroData.add(pProrroga);
                pTOTAL_REGISTROS_ATIVIDADES = pTOTAL_REGISTROS_ATIVIDADES + 1;
            }
            return listaRegistroData;
        } catch (SQLException ex) {
            Logger.getLogger(ListagemSaidasTMP_PD_Data.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
