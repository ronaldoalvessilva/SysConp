/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtividadesMensalRealizadaUnidades;
import static gestor.Visao.TelaAtividadesMensalUnidade.jDataPesFinal;
import static gestor.Visao.TelaAtividadesMensalUnidade.jDataPesqInicial;
import static gestor.Visao.TelaAtividadesMensalUnidade.pTOTAL_REGISTROS_ATIVIDADES;
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
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
public class ListagemAtividadesUnidadePorData {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesMensalRealizadaUnidades objAtividade = new AtividadesMensalRealizadaUnidades();
    //
    String pDATA_INICIAL;
    String pDATA_FINAL;

    public List<AtividadesMensalRealizadaUnidades> read() throws Exception {
        pTOTAL_REGISTROS_ATIVIDADES = 0;
        List<AtividadesMensalRealizadaUnidades> listaTodasAtividades = new ArrayList<AtividadesMensalRealizadaUnidades>();
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
            conecta.executaSQL("SELECT IdAtividade,StatusAtividade,"
                    + "DataCriacao,Populacao, "
                    + "MesReferencia,AnoReferencia, "
                    + "DescricaoUnidade "
                    + "FROM ATIVIDADES_UNIDADE "
                    + "INNER JOIN UNIDADE_PENAL_EMPRESA "
                    + "ON ATIVIDADES_UNIDADE.IdUnidEmp=UNIDADE_PENAL_EMPRESA.IdUnidEmp "
                    + "WHERE CONVERT(DATE, DataInsert,103) BETWEEN'" + pDATA_INICIAL + "' "
                    + "AND '" + pDATA_FINAL + "' ");
            while (conecta.rs.next()) {
                AtividadesMensalRealizadaUnidades pAtividade = new AtividadesMensalRealizadaUnidades();
                pAtividade.setChave(conecta.rs.getInt("IdAtividade"));
                pAtividade.setStatus(conecta.rs.getString("StatusAtividade"));
                pAtividade.setDataCriacao(conecta.rs.getDate("DataCriacao"));
                pAtividade.setMediaPopulacao(conecta.rs.getInt("Populacao"));
                pAtividade.setMesReferencia(conecta.rs.getString("MesReferencia"));
                pAtividade.setAnoReferencia(conecta.rs.getString("AnoReferencia"));
                pAtividade.setUnidadePrisional(conecta.rs.getString("DescricaoUnidade"));
                listaTodasAtividades.add(pAtividade);
                pTOTAL_REGISTROS_ATIVIDADES = pTOTAL_REGISTROS_ATIVIDADES + 1;
            }
            return listaTodasAtividades;
        } catch (SQLException ex) {
            Logger.getLogger(ListagemAtividadesUnidadePorData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
