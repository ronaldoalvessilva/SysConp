/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import static gestor.Controle.ControleItensRegSaidaInternos.qtdInternos;
import gestor.Dao.ConexaoBancoDados;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class ControleListaInternoBase {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    //
    String pBio = null;
    String confirmacaoSaida = "Não";
    
     public List<DigitalInternos> read() throws Exception {
        conecta.abrirConexao();
        List<DigitalInternos> listaInternosSaida = new ArrayList<DigitalInternos>();
        try {
            conecta.executaSQL("SELECT * FROM ITENSCRCPORTARIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSCRCPORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "INNER JOIN ITENSLOCACAOINTERNO "
                    + "ON ITENSCRCPORTARIA.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "INNER JOIN BIOMETRIA_INTERNOS "
                    + "ON ITENSCRCPORTARIA.IdInternoCrc=BIOMETRIA_INTERNOS.IdInternoCrc "
                    + "WHERE SaidaConfirmada='" + confirmacaoSaida + "' "
                    + "AND BiometriaDedo1!='" + pBio + "'");
            while (conecta.rs.next()) {
                DigitalInternos pDigital = new DigitalInternos();
                pDigital.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pDigital.setMatriculaPenal(conecta.rs.getString("MatriculaCrc"));
                pDigital.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pDigital.setCaminhoFotoInterno(conecta.rs.getString("FotoInternoCrc"));
                pDigital.setRegime(conecta.rs.getString("Regime"));
                pDigital.setPavilhao(conecta.rs.getString("DescricaoPav"));
                pDigital.setCela(conecta.rs.getString("EndCelaPav"));
                pDigital.setIdItemSaida(conecta.rs.getString("IdSaida"));
                pDigital.setIdItemCrcPort(conecta.rs.getInt("IdItemSaida"));                
                pDigital.setBiometriaDedo1(conecta.rs.getBytes("BiometriaDedo1"));
                pDigital.setBiometriaDedo2(conecta.rs.getBytes("BiometriaDedo2"));
                pDigital.setBiometriaDedo3(conecta.rs.getBytes("BiometriaDedo3"));
                pDigital.setBiometriaDedo4(conecta.rs.getBytes("BiometriaDedo4"));
              //  pDigital.setImagemFrente(conecta.rs.getBytes("ImagemFente"));
                listaInternosSaida.add(pDigital);
                qtdInternos++;
            }
            return listaInternosSaida;
        } catch (SQLException ex) {
            Logger.getLogger(ControleVisitaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }    
}
