/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EscalaFolgas;
import static gestor.Visao.TelaFuncionarios.jIDFunc;
import static gestor.Visao.TelaAlterarCronogramaEscala.pTOTAL_registros;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ControlePesquisarAlterarCronograma {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EscalaFolgas objEscalas = new EscalaFolgas();
    
     public List<EscalaFolgas> read() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<EscalaFolgas> listarTodosCronogramaColaborador = new ArrayList<EscalaFolgas>();
        try {
            conecta.executaSQL("SELECT "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.IdFunc, "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.IdRegistro, "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.IdCrono, "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.DataCronograma, "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.StatusTrabFolga, "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.IdEscala, "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.PrimeiroApt, "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.SegundoApt, "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.DataInicial, "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.DataFinal, "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.DataPrimeiraFolga, "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.MesReferencia, "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.AnoReferencia, "
                    + "ESCALA_TRABALHO.DescricaoEscala, "
                    + "ESCALA_TRABALHO_FOLGA_COLABORADOR.QuantidadeTrab, "
                    + "ESCALA_TRABALHO_FOLGA_COLABORADOR.QuantidadeFolga, "
                    + "ESCALA_TRABALHO.Turno, "
                    + "ESCALA_TRABALHO.Turma, "
                    + "CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.IdFunc, "
                    + "COLABORADOR.NomeFunc,MesReferencia,AnoReferencia "
                    + "FROM CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR "
                    + "INNER JOIN ESCALA_TRABALHO "
                    + "ON CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.IdRegistro=ESCALA_TRABALHO.IdRegistro "
                    + "INNER JOIN ESCALA_TRABALHO_FOLGA_COLABORADOR " 
                    + "ON CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.IdEscala=ESCALA_TRABALHO_FOLGA_COLABORADOR.IdEscala "
                    + "INNER JOIN COLABORADOR "
                    + "ON CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.IdFunc=COLABORADOR.IdFunc "
                    + "WHERE CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR.IdFunc='" + jIDFunc.getText() + "'");
            while (conecta.rs.next()) {
                EscalaFolgas pEscalFolgas = new EscalaFolgas();                
                pEscalFolgas.setIdCrono(conecta.rs.getInt("IdCrono"));
                pEscalFolgas.setDataCronograma(conecta.rs.getDate("DataCronograma"));
                pEscalFolgas.setStatusTrabFolga(conecta.rs.getString("StatusTrabFolga"));
                pEscalFolgas.setIdFunc(conecta.rs.getInt("IdFunc"));
                pEscalFolgas.setNomeFuncEscala(conecta.rs.getString("NomeFunc"));
                pEscalFolgas.setDataInicial(conecta.rs.getDate("DataInicial"));
                pEscalFolgas.setDataFinal(conecta.rs.getDate("DataFinal"));
                pEscalFolgas.setMesReferencia(conecta.rs.getString("MesReferencia"));
                pEscalFolgas.setAnoReferencia(conecta.rs.getString("AnoReferencia"));
                listarTodosCronogramaColaborador.add(pEscalFolgas);
                ++pTOTAL_registros;
            }
            return listarTodosCronogramaColaborador;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarInternosSaidasSimbolicas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
