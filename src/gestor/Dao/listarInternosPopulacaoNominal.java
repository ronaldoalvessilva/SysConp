/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Dao;

import gestor.Modelo.GerarPopNominal;
import static gestor.Visao.TelaGerarPopulacaoNominalCrc.qtdInternosPop;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Socializa TI 02
 */
public class listarInternosPopulacaoNominal {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    GerarPopNominal objGravaIntComp = new GerarPopNominal();

    String situacaoENT = "ENTRADA NA UNIDADE";
    String situacaoRET = "RETORNO A UNIDADE";

    public List<GerarPopNominal> read() throws Exception {
        conecta.abrirConexao();
        List<GerarPopNominal> listaInternosKitComp = new ArrayList<GerarPopNominal>();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE SituacaoCrc='" + situacaoENT + "' "
                    + "OR SituacaoCrc='" + situacaoRET + "' "
                    + "ORDER BY NomeInternoCrc");
            while (conecta.rs.next()) {
                GerarPopNominal pDigi = new GerarPopNominal();
                pDigi.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setCnc(conecta.rs.getString("Cnc"));
                pDigi.setNomeInterno(conecta.rs.getString("NomeInternoCrc"));
                listaInternosKitComp.add(pDigi);
                qtdInternosPop = qtdInternosPop + 1;
            }
            return listaInternosKitComp;
        } catch (SQLException ex) {
            Logger.getLogger(listarInternosPopulacaoNominal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
