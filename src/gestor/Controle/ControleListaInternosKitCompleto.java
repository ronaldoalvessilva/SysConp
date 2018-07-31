/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.GravarInternosKitCompleto;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.jIdRegistroComp;
import static gestor.Visao.TelaMontagemPagamentoKitInterno.qtdInternosKitComp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ControleListaInternosKitCompleto {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    GravarInternosKitCompleto objGravaIntComp = new GravarInternosKitCompleto();

    public List<GravarInternosKitCompleto> read() throws Exception {
        conecta.abrirConexao();
        List<GravarInternosKitCompleto> listaInternosKitComp = new ArrayList<GravarInternosKitCompleto>();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO.IdInternoCrc "
                    + "WHERE ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO.IdRegistroComp='" + jIdRegistroComp.getText() + "' "
                    + "ORDER BY PRONTUARIOSCRC.NomeInternoCrc");
            while (conecta.rs.next()) {
                GravarInternosKitCompleto pDigi = new GravarInternosKitCompleto();
                pDigi.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigi.setGravado(conecta.rs.getInt("Gravado"));
                listaInternosKitComp.add(pDigi);
                qtdInternosKitComp = qtdInternosKitComp + 1;
            }
            return listaInternosKitComp;
        } catch (SQLException ex) {
            Logger.getLogger(ControlePavilhaoInternosMontaKit.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
