/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensRetornoEspontaneo;
import gestor.Modelo.ItensRetornoInterno;
import gestor.Modelo.RetornoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensRetornoInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensRetornoInterno objItensRetorno = new ItensRetornoInterno();
    RetornoInternos objRetorno = new RetornoInternos();
    ItensRetornoEspontaneo objItensRetEsp = new ItensRetornoEspontaneo();
    int codInt;
    int qtdUnit = 1;

    public ItensRetornoInterno incluirItensRetorno(ItensRetornoInterno objItensRetorno) {
        buscarInternoCrc(objItensRetorno.getNomeInterno(), objItensRetorno.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSRETORNO (IdInternoCrc,IdRetorno,DataRetorno,OrigemRetorno,DocumentoRetorno,QtdSaida,IdRegistro,HorarioRetorno,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetorno.getIdRetorno());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensRetorno.getDataRetorno().getTime()));
            pst.setString(4, objItensRetorno.getNomerOrigem());
            pst.setString(5, objItensRetorno.getDocumento());
            pst.setInt(6, qtdUnit);
            pst.setInt(7, objItensRetorno.getIdRegistro());
            pst.setString(8, objItensRetorno.getHorarioRetorno());
            pst.setString(9, objItensRetorno.getUsuarioInsert());
            pst.setString(10, objItensRetorno.getDataInsert());
            pst.setString(11, objItensRetorno.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetorno;
    }

    public ItensRetornoInterno alterarItensRetorno(ItensRetornoInterno objItensRetorno) {
        buscarInternoCrc(objItensRetorno.getNomeInterno(), objItensRetorno.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSRETORNO SET IdInternoCrc=?,IdRetorno=?,DataRetorno=?,OrigemRetorno=?,DocumentoRetorno=?,QtdSaida=?,IdRegistro=?,HorarioRetorno=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensRetorno.getIdItemRetorno() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetorno.getIdRetorno());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensRetorno.getDataRetorno().getTime()));
            pst.setString(4, objItensRetorno.getNomerOrigem());
            pst.setString(5, objItensRetorno.getDocumento());
            pst.setInt(6, qtdUnit);
            pst.setInt(7, objItensRetorno.getIdRegistro());
            pst.setString(8, objItensRetorno.getHorarioRetorno());
            pst.setString(9, objItensRetorno.getUsuarioInsert());
            pst.setString(10, objItensRetorno.getDataInsert());
            pst.setString(11, objItensRetorno.getHoraInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetorno;
    }

    //Método para excluir ITENS DE SAIDA

    public ItensRetornoInterno excluirItensRetorno(ItensRetornoInterno objItensRetorno) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM ITENSRETORNO WHERE IdItem='" + objItensRetorno.getIdItemRetorno() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItensRetorno;

    }
// Confirmar a utilização do registro de retorno
    public ItensRetornoInterno alterarRegistroItensRetorno(ItensRetornoInterno objItensRetorno) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSREGISTRO SET ConfirmacaoRetorno=? WHERE IdItem='" + objItensRetorno.getIdItemRetorno() + "'OR IdItem='" + objItensRetorno.getIdRegistro() + "'");            
            pst.setString(1, objItensRetorno.getConfirmaRetorno());            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensRetorno;
    }
    // Buscar INTERNO

    public void buscarInternoCrc(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
