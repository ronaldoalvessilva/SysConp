/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensRetornoTransferencia;
import gestor.Modelo.RetornoPorTransferencia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleItensRetornoPorTransferencia {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RetornoPorTransferencia objRetTrans = new RetornoPorTransferencia();
    ItensRetornoTransferencia objItensRetTrans = new ItensRetornoTransferencia();
    int codInt;
    int qtdUnit = 1;
    int codUnid;

    //------------------------------- INCLUIR ITENS RETORNO POR TRANSFERENCIA ----------------------------------
    public ItensRetornoTransferencia incluirItensRetornoTransferencia(ItensRetornoTransferencia objItensRetTrans) {
        buscarInternoCrc(objItensRetTrans.getNomeInterno(), objItensRetTrans.getIdInternoCrc());
        buscarUnidadePenal(objItensRetTrans.getDescricaoUnidade());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSRETORNOTRANSFERENCIA (IdInternoCrc,IdRetorno,DataRetorno,OrigemRetorno,IdRegistro,IdUnid,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetTrans.getIdRetorno());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensRetTrans.getDataRetorno().getTime()));
            pst.setString(4, objItensRetTrans.getOrigemRetorno());
            pst.setInt(5, objItensRetTrans.getIdRegistro());
            pst.setInt(6, codUnid);
            pst.setString(7, objItensRetTrans.getUsuarioInsert());
            pst.setString(8, objItensRetTrans.getDataInsert());
            pst.setString(9, objItensRetTrans.getHoraInsert());

            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetTrans;
    }

    //-------------------------- ALTERAR RETORNO POR TRANSFERENCIA ----------------------------------------------
    public ItensRetornoTransferencia alterarItensRetornoTransferencia(ItensRetornoTransferencia objItensRetTrans) {
        buscarInternoCrc(objItensRetTrans.getNomeInterno(), objItensRetTrans.getIdInternoCrc());
        buscarUnidadePenal(objItensRetTrans.getDescricaoUnidade());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSRETORNOTRANSFERENCIA SET IdInternoCrc=?,IdRetorno=?,DataRetorno=?,OrigemRetorno=?,IdRegistro=?,IdUnid=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensRetTrans.getIdItem() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensRetTrans.getIdRetorno());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensRetTrans.getDataRetorno().getTime()));
            pst.setString(4, objItensRetTrans.getOrigemRetorno());
            pst.setInt(5, objItensRetTrans.getIdRegistro());
            pst.setInt(6, codUnid);
            pst.setString(7, objItensRetTrans.getUsuarioUp());
            pst.setString(8, objItensRetTrans.getDataUp());
            pst.setString(9, objItensRetTrans.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetTrans;
    }

    //Método para excluir ITENS DE RETORNO POR TRANSFERENCIA
    public ItensRetornoTransferencia excluirItensRetornoTransferencia(ItensRetornoTransferencia objItensRetTrans) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM ITENSRETORNOTRANSFERENCIA WHERE IdItem='" + objItensRetTrans.getIdItem() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItensRetTrans;

    }

    public void buscarUnidadePenal(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM UNIDADE WHERE DescricaoUnid='" + desc + "'");
            conecta.rs.first();
            codUnid = conecta.rs.getInt("IdUnid");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (UNIDADE PENAL) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    //----------------------------------------- RETORNO POR TRANSFERENCIA COM ITENSREGISTRO PROTARIA -----------------------------------
    // Confirmar a utilização do registro de retorno no CRC na PORTARIA (ITENSREGISTRO)
    public ItensRetornoTransferencia alterarRegItensRetornoTransferenciaPortaria(ItensRetornoTransferencia objItensRetTrans) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSREGISTRO SET ConfirmacaoRetorno=? WHERE IdItem='" + objItensRetTrans.getIdItem() + "'OR IdItem='" + objItensRetTrans.getIdRetorno() + "'");
            pst.setString(1, objItensRetTrans.getConfirmaRetorno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetTrans;
    }

    // Confirmar como "Não" a utilização do registro de retorno audiencia quando exluido no ITENSRETORNO POR TRANSFERENCIA
    public ItensRetornoTransferencia confirmaUtilizacaoItensRetornoTransferencia(ItensRetornoTransferencia objItensRetTrans) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSREGISTRO SET ConfirmacaoRetorno=? WHERE IdItem='" + objItensRetTrans.getIdRegistro() + "'AND IdInternoCrc='" + objItensRetTrans.getIdInternoCrc() + "'");
            pst.setString(1, objItensRetTrans.getConfirmaRetorno());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensRetTrans;
    }

    //----------------------------------- MODIFICAR PRONTUARIOS DOS INTERNOS QUANDO RETORNO DE TRANSFERENCIA ------------------------------
    public ItensRetornoTransferencia alterarProntuarioRetronoTransferencia(ItensRetornoTransferencia objItensRetTrans) {
        
        buscarUnidadePenal(objItensRetTrans.getDescricaoUnidade());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DADOSPENAISINTERNOS SET DataEntrada=?,IdUnid=?,Regime=? WHERE IdInternoCrc='" + objItensRetTrans.getIdInternoCrc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objItensRetTrans.getDataRetorno().getTime()));
            pst.setInt(2, codUnid);
            pst.setString(3, objItensRetTrans.getRegime());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.(DADOS PENAIS DO INTERNO)\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensRetTrans;
    }

    // Buscar INTERNO

    public void buscarInternoCrc(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
