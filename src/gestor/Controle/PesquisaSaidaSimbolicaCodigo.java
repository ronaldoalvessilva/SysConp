/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.SaidaSimbolica;
import static gestor.Visao.TelaSaidaSimbolica.jCodigoReq;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronal
 */
public class PesquisaSaidaSimbolicaCodigo {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    SaidaSimbolica objSaida = new SaidaSimbolica();

    public List<SaidaSimbolica> read() throws Exception {
        conecta.abrirConexao();
        List<SaidaSimbolica> listaSaidaCodigo = new ArrayList<SaidaSimbolica>();
        try {
            conecta.executaSQL("SELECT IdRegSaida, "
                    + "StatusRegistro,DataRegistro,Nrdocumento, "
                    + "VaraCrime,NomeJuiz,LocalAudiencia, "
                    + "TipoBeneficio,MotivoSaida, "
                    + "UsuarioInsert,DataInsert, "
                    + "HorarioInsert,UsuarioUp, "
                    + "DataUp,HorarioUp "
                    + "FROM SAIDA_SIMBOLICA_CRC "
                    + "WHERE SAIDA_SIMBOLICA_CRC.IdRegistro='" + jCodigoReq.getText() + "'");
            while (conecta.rs.next()) {
                SaidaSimbolica pSaidaSimbolica = new SaidaSimbolica();
                pSaidaSimbolica.setIdRegSaida(conecta.rs.getInt("IdRegSaida"));
                pSaidaSimbolica.setStatusRegistro(conecta.rs.getString("StatusRegistro"));
                pSaidaSimbolica.setDataRegistro(conecta.rs.getDate("DataRegistro"));
                pSaidaSimbolica.setNrdocumento(conecta.rs.getString("Nrdocumento"));
                pSaidaSimbolica.setVaraCrime(conecta.rs.getString("VaraCrime"));
                pSaidaSimbolica.setNomeJuiz(conecta.rs.getString("NomeJuiz"));
                pSaidaSimbolica.setLocalAudiencia(conecta.rs.getString("LocalAudiencia"));
                pSaidaSimbolica.setTipoBeneficio(conecta.rs.getString("TipoBeneficio"));  
                pSaidaSimbolica.setMotivoSaida(conecta.rs.getString("MotivoSaida"));
                pSaidaSimbolica.setUsuarioInsert(conecta.rs.getString("UsuarioInsert"));
                pSaidaSimbolica.setUsuarioUp(conecta.rs.getString("UsuarioUp"));
                pSaidaSimbolica.setDataInsert(conecta.rs.getString("DataInsert"));
                pSaidaSimbolica.setDataUp(conecta.rs.getString("DataUp"));
                pSaidaSimbolica.setHorarioInsert(conecta.rs.getString("HorarioInsert"));
                pSaidaSimbolica.setHorarioUp(conecta.rs.getString("HorarioUp"));
                listaSaidaCodigo.add(pSaidaSimbolica);
            }
            return listaSaidaCodigo;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaSaidaSimbolicaCodigo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
