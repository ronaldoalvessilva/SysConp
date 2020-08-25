/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SaidaSimbolica;
import static gestor.Visao.TelaSaidaSimbolica.jCodigoReq;
import static gestor.Visao.TelaSaidaSimbolica.jIdRegistro;
import static gestor.Visao.TelaSaidaSimbolica.pTOTAL_registros;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo.silva7
 */
public class PesquisarGravacaoInterno {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaidaSimbolica objSaida = new SaidaSimbolica();
    
    
     public List<SaidaSimbolica> read() throws Exception {
        pTOTAL_registros = 0;
        conecta.abrirConexao();
        List<SaidaSimbolica> listaRegistroInternosSaidaSimbolica = new ArrayList<SaidaSimbolica>();
        try {
            conecta.executaSQL("SELECT "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.IdItem, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.IdRegSaida, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.IdInternoCrc, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.NrdocumentoSA, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.TipoBeneficioSA, "
                    + "ITENS_SAIDA_SIMBOLICA_CRC.DataRegistroSA, "
                    + "PRONTUARIOSCRC.NomeInternoCrc "
                    + "FROM ITENS_SAIDA_SIMBOLICA_CRC "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENS_SAIDA_SIMBOLICA_CRC.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ITENS_SAIDA_SIMBOLICA_CRC.IdRegSaida='" + jIdRegistro.getText() + "' "
                    + "ORDER BY IdItem");
            while (conecta.rs.next()) {
                SaidaSimbolica pInternosSaida = new SaidaSimbolica();
                pInternosSaida.setIdItem(conecta.rs.getInt("IdItem"));
                pInternosSaida.setIdInternoCrc(conecta.rs.getInt("IdInternoCrc"));
                pInternosSaida.setNomeInternoCrc(conecta.rs.getString("NomeInternoCrc"));
                pInternosSaida.setNrdocumentoSA(conecta.rs.getString("NrdocumentoSA"));
                pInternosSaida.setTipoBeneficioSA(conecta.rs.getString("TipoBeneficioSA"));
                pInternosSaida.setDataRegistroSA(conecta.rs.getDate("DataRegistroSA"));
                listaRegistroInternosSaidaSimbolica.add(pInternosSaida);
                pTOTAL_registros = pTOTAL_registros + 1;
            }
            return listaRegistroInternosSaidaSimbolica;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarInternosSaidasSimbolicas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
