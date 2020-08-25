/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SaidaSimbolica;
import static gestor.Visao.TelaSaidaSimbolica.dataFinal;
import static gestor.Visao.TelaSaidaSimbolica.dataInicial;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class PesquisaSaidaSimbolicaData {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaidaSimbolica objSaida = new SaidaSimbolica();

    public List<SaidaSimbolica> read() throws Exception {
        conecta.abrirConexao();
        List<SaidaSimbolica> listaSaidasSimbolicaData = new ArrayList<SaidaSimbolica>();
        try {
             conecta.executaSQL("SELECT IdRegSaida,StatusRegistro,DataRegistro, "
                    + "Nrdocumento,VaraCrime,NomeJuiz,LocalAudiencia,TipoBeneficio, "
                    + "MotivoSaida "
                    + "FROM SAIDA_SIMBOLICA_CRC "
                    + "WHERE DataRegistro BETWEEN '" + dataInicial + "' "
                    + "AND '" + dataFinal + "'");
            while (conecta.rs.next()) {
                SaidaSimbolica pSaidasSimbolicas = new SaidaSimbolica();
                pSaidasSimbolicas.setIdRegSaida(conecta.rs.getInt("IdRegSaida"));
                pSaidasSimbolicas.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
                pSaidasSimbolicas.setDataRegistro(conecta.rs.getDate("DataRegistro"));
                pSaidasSimbolicas.setNrdocumento(conecta.rs.getString("Nrdocumento"));
                pSaidasSimbolicas.setVaraCrime(conecta.rs.getString("VaraCrime"));
                pSaidasSimbolicas.setNomeJuiz(conecta.rs.getString("NomeJuiz"));
                pSaidasSimbolicas.setLocalAudiencia(conecta.rs.getString("LocalAudiencia"));
                pSaidasSimbolicas.setTipoBeneficio(conecta.rs.getString("TipoBeneficio"));
                pSaidasSimbolicas.setMotivoSaida(conecta.rs.getString("MotivoSaida"));
                listaSaidasSimbolicaData.add(pSaidasSimbolicas);
            }
            return listaSaidasSimbolicaData;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaSaidaSimbolicaData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
