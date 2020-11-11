/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EscalFolgas;
import static gestor.Visao.TelaEscalaFolgas.pTOTAL_registros;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo.silva7
 */
public class PesquisarTodasEscalas {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EscalFolgas objEscalas = new EscalFolgas();
        
     public List<EscalFolgas> read() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<EscalFolgas> listaRegistroEntradasSaidasColaboradores = new ArrayList<EscalFolgas>();
        try {
            conecta.executaSQL("SELECT "
                    + "IdRegistro, "
                    + "StatusEscala, "
                    + "DataCadastro, "
                    + "QuantidadeTrab, "
                    + "QuantidadeFolga, "
                    + "DescricaoEscala, "
                    + "Turno, "
                    + "Turma "
                    + "FROM ESCALA_TRABALHO");
            while (conecta.rs.next()) {
                EscalFolgas pEscalFolgas = new EscalFolgas();
                pEscalFolgas.setIdRegistro(conecta.rs.getInt("IdRegistro"));
                pEscalFolgas.setStatusEscala(conecta.rs.getString("StatusEscala"));
                pEscalFolgas.setDataCadastro(conecta.rs.getDate("DataCadastro"));
                pEscalFolgas.setQuantidadeTrab(conecta.rs.getInt("QuantidadeTrab"));
                pEscalFolgas.setQuantidadeFolga(conecta.rs.getInt("QuantidadeFolga"));
                pEscalFolgas.setDescricaoEscala(conecta.rs.getString("DescricaoEscala"));
                pEscalFolgas.setTurno(conecta.rs.getString("Turno"));
                pEscalFolgas.setTurma(conecta.rs.getString("Turma"));
                listaRegistroEntradasSaidasColaboradores.add(pEscalFolgas);
                pTOTAL_registros = pTOTAL_registros + 1;
            }
            return listaRegistroEntradasSaidasColaboradores;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarInternosSaidasSimbolicas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
