/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EscalaFolgas;
import static gestor.Visao.TelaCronogramaEscala.jComboBoxAnoReferencia;
import static gestor.Visao.TelaCronogramaEscala.jComboBoxMesReferencia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class PesquisaMesAnoCronograma {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EscalaFolgas objEscalas = new EscalaFolgas();

    public List<EscalaFolgas> read() throws Exception {
        List<EscalaFolgas> listaMesAnoCronograma = new ArrayList<EscalaFolgas>();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT IdCrono,IdFunc,MesReferencia,AnoReferencia "
                    + "FROM CRONOGRAMA_ESCALA_TRABALHO_FOLGA_COLABORADOR "
                    + "WHERE MesReferencia='" + jComboBoxMesReferencia.getSelectedItem() + "' "
                    + "AND AnoReferencia='" + jComboBoxAnoReferencia.getSelectedItem() + "'");
            while (conecta.rs.next()) {
                EscalaFolgas pEscalaMesAno = new EscalaFolgas();
                pEscalaMesAno.setIdCrono(conecta.rs.getInt("IdCrono"));
                pEscalaMesAno.setIdFunc(conecta.rs.getInt("IdFunc"));
                pEscalaMesAno.setMesReferencia(conecta.rs.getString("MesReferencia"));
                pEscalaMesAno.setAnoReferencia(conecta.rs.getString("AnoReferencia"));
                listaMesAnoCronograma.add(pEscalaMesAno);
            }
            return listaMesAnoCronograma;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaMesAnoCronograma.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
