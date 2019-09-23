/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProntuarioCrc;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ControleListaLiberadorBASE_PSP {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc obj_PRONTO = new ProntuarioCrc();

    String pENTRADA = "ENTRADA NA UNIDADE";
    String pRETORNO = "RETORNO A UNIDADE";

    public List<ProntuarioCrc> read() throws Exception {
        conecta.abrirConexao();
        List<ProntuarioCrc> listaInternos = new ArrayList<ProntuarioCrc>();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE SituacaoCrc='" + pENTRADA + "' "
                    + "OR SituacaoCrc='" + pRETORNO + "'");
            while (conecta.rs.next()) {
                ProntuarioCrc pDigi = new ProntuarioCrc();
                pDigi.setIdInterno(conecta.rs.getInt("IdInternoCrc"));
                pDigi.setNomeInterno(conecta.rs.getString("NomeInternoCrc"));
                pDigi.setMaeInterno(conecta.rs.getString("MaeInternoCrc"));
                pDigi.setFotoInterno(conecta.rs.getString("FotoInternoCrc"));
                pDigi.setImagemInterno(conecta.rs.getBytes("ImagemFrente"));
                pDigi.setRegime(conecta.rs.getString("Regime"));
                pDigi.setCnc(conecta.rs.getString("Cnc"));
                listaInternos.add(pDigi);
//                qtdColaboradores++;
            }
            return listaInternos;
        } catch (SQLException ex) {
            Logger.getLogger(ControleListaLiberadorBASE_PSP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
