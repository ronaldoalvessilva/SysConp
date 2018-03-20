/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensRetornoMedico;
import gestor.Modelo.RetornoMedico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensRetornoMedico {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RetornoMedico objRetMedico = new RetornoMedico();
    ItensRetornoMedico objItensRetMed = new ItensRetornoMedico();
    int codInt;
    int qtdUnit = 1;
   //------------------------------- INCLUIR ITENS RETORNO MÉDICO ----------------------------------
    public ItensRetornoMedico incluirItensRetornoMedico(ItensRetornoMedico objItensRetMed) {
         buscarInternoCrc(objItensRetMed.getNomeInterno(), objItensRetMed.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSRETORNOMEDICO (IdInternoCrc,IdRetorno,DataRetorno,OrigemRetorno,IdRegistro,UsuarioInsert,DataInsert,HorarioInsert,HoraRetorno) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetMed.getIdRetorno());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensRetMed.getDataRetorno().getTime()));
            pst.setString(4, objItensRetMed.getOrigemRetorno());
            pst.setInt(5, objItensRetMed.getIdRegistro());
            pst.setString(6, objItensRetMed.getUsuarioInsert());
            pst.setString(7, objItensRetMed.getDataInsert());
            pst.setString(8, objItensRetMed.getHoraInsert());
            pst.setString(9, objItensRetMed.getHoraRetorno());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetMed;
    }
   //-------------------------- ALTERAR RETORNO MÉDICO ----------------------------------------------
    public ItensRetornoMedico alterarItensRetornoMedico(ItensRetornoMedico objItensRetMed) {
        buscarInternoCrc(objItensRetMed.getNomeInterno(), objItensRetMed.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSRETORNOMEDICO SET IdInternoCrc=?,IdRetorno=?,DataRetorno=?,OrigemRetorno=?,IdRegistro=?,UsuarioUp=?,DataUp=?,HorarioUp=?,HoraRetorno=? WHERE IdItem='" + objItensRetMed.getIdItem() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetMed.getIdRetorno());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensRetMed.getDataRetorno().getTime()));
            pst.setString(4, objItensRetMed.getOrigemRetorno());
            pst.setInt(5, objItensRetMed.getIdRegistro());
            pst.setString(6, objItensRetMed.getUsuarioUp());
            pst.setString(7, objItensRetMed.getDataUp());
            pst.setString(8, objItensRetMed.getHoraUp());
            pst.setString(9, objItensRetMed.getHoraRetorno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objItensRetMed;
    }

    //Método para excluir ITENS DE RETORNO MÉDICO
    public ItensRetornoMedico excluirItensRetornoMedico(ItensRetornoMedico objItensRetMed) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM ITENSRETORNOMEDICO WHERE IdItem='" + objItensRetMed.getIdItem() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItensRetMed;
    }
 //----------------------------------------- RETORNO AUDIENCIA COM ITENSREGISTRO PROTARIA -----------------------------------

    // Confirmar a utilização do registro de retorno no CRC na PORTARIA (ITENSREGISTRO)
    public ItensRetornoMedico alterarRegItensRetornoMedicoPortaria(ItensRetornoMedico objItensRetMed) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSREGISTRO SET ConfirmacaoRetorno=? WHERE IdItem='" + objItensRetMed.getIdItem() + "'OR IdItem='" + objItensRetMed.getIdRetorno() + "'");
            pst.setString(1, objItensRetMed.getConfirmaRetorno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetMed;
    }

    // Confirmar como "Não" a utilização do registro de retorno audiencia quando exluido no ITENSRETRONO MÉDICO
    public ItensRetornoMedico confirmaUtilizacaoItensRetornoMedico(ItensRetornoMedico objItensRetMed) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSREGISTRO SET ConfirmacaoRetorno=? WHERE IdItem='" + objItensRetMed.getIdRegistro() + "'AND IdInternoCrc='" + objItensRetMed.getIdInternoCrc() + "'");
            pst.setString(1, objItensRetMed.getConfirmaRetorno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetMed;
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
