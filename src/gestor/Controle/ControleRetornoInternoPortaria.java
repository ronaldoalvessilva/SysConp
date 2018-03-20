/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensRegistroRetornoInterno;
import gestor.Modelo.RegistroRetornoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRetornoInternoPortaria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensRegistroRetornoInterno objItensRetorno = new ItensRegistroRetornoInterno();
    RegistroRetornoInternos objRetorno = new RegistroRetornoInternos();
    int codInt;

    public ItensRegistroRetornoInterno incluirInternoRetorno(ItensRegistroRetornoInterno objItensRetorno) {
        buscarInternoCrc(objItensRetorno.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS (IdInternoCrc,IdRetorno,DataEntrada,DocEntrada,HoraEntrada,RetPort,RetCrc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetorno.getIdRetorno());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensRetorno.getDataRetorno().getTime()));
            pst.setString(4, objItensRetorno.getDocumento());
            pst.setString(5, objItensRetorno.getHorarioRetorno());
            pst.setString(6, objItensRetorno.getConfirmaRetorno());
            pst.setString(7, objItensRetorno.getConfirmaRetornoCrc());
            pst.setString(8, objItensRetorno.getUsuarioInsert());
            pst.setString(9, objItensRetorno.getDataInsert());
            pst.setString(10, objItensRetorno.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel interno na tabela (VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS) os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensRetorno;
    }

    public ItensRegistroRetornoInterno alterarInternoRetorno(ItensRegistroRetornoInterno objItensRetorno) {
        buscarInternoCrc(objItensRetorno.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS SET IdInternoCrc=?,IdRetorno=?,DataEntrada=?,DocEntrada=?,HoraEntrada=?,RetPort=?,RetCrc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRetorno='" + objItensRetorno.getIdRetorno() + "'AND IdInternoCrc='" + objItensRetorno.getIdInternoCrc() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetorno.getIdRetorno());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensRetorno.getDataRetorno().getTime()));
            pst.setString(4, objItensRetorno.getDocumento());
            pst.setString(5, objItensRetorno.getHorarioRetorno());
            pst.setString(6, objItensRetorno.getConfirmaRetorno());
            pst.setString(7, objItensRetorno.getConfirmaRetornoCrc());
            pst.setString(8, objItensRetorno.getUsuarioUp());
            pst.setString(9, objItensRetorno.getDataUp());
            pst.setString(10, objItensRetorno.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados. (VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS)\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensRetorno;
    }

    public ItensRegistroRetornoInterno excluirInternoRetorno(ItensRegistroRetornoInterno objItensRetorno) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS WHERE IdRetorno='" + objItensRetorno.getIdRetorno() + "'AND IdInternoCrc='" + objItensRetorno.getIdInternoCrc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensRetorno;

    }

    public void buscarInternoCrc(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
