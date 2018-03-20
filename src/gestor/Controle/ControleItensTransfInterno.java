/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensTransInterno;
import gestor.Modelo.TransferenciaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensTransfInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensTransInterno objItensTrans = new ItensTransInterno();
    TransferenciaInternos objTrans = new TransferenciaInternos();
    int codInt;
    int qtdUnit = 1;
    int codUnid;

    public ItensTransInterno incluirItensTransf(ItensTransInterno objItensTrans) {
        buscarInternoCrc(objItensTrans.getNomeInterno(),objItensTrans.getIdInternoCrc());
        buscarUnidade(objItensTrans.getNomeUnidade());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSTRANSFERENCIA (IdInternoCrc,IdTransf,DataTransf,IdUnid,DocumentoTransf,SaidaConfirmada,QtdTransf,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensTrans.getIdTrans());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensTrans.getDataTrans().getTime()));
            pst.setInt(4, codUnid);
            pst.setString(5, objItensTrans.getDocumento());
            pst.setString(6, objItensTrans.getConfirmaSaida());
            pst.setInt(7, qtdUnit);
            pst.setString(8, objItensTrans.getUsuarioInsert());
            pst.setString(9, objItensTrans.getDataInsert());
            pst.setString(10, objItensTrans.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTrans;
    }

    public ItensTransInterno alterarItensTransf(ItensTransInterno objItensTrans) {
        buscarInternoCrc(objItensTrans.getNomeInterno(),objItensTrans.getIdInternoCrc());
        buscarUnidade(objItensTrans.getNomeUnidade());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSTRANSFERENCIA  SET IdInternoCrc=?,IdTransf=?,DataTransf=?,IdUnid=?,DocumentoTransf=?,SaidaConfirmada=?,QtdTransf=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensTrans.getIdItemTrans() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensTrans.getIdTrans());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensTrans.getDataTrans().getTime()));
            pst.setInt(4, codUnid);
             pst.setString(5, objItensTrans.getDocumento());
            pst.setString(6, objItensTrans.getConfirmaSaida());
            pst.setInt(7, qtdUnit);
            pst.setString(8, objItensTrans.getUsuarioUp());
            pst.setString(9, objItensTrans.getDataUp());
            pst.setString(10, objItensTrans.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTrans;
    }

    //Método para excluir ITENS DE TRANSFERêNCIA

    public ItensTransInterno excluirItensTransf(ItensTransInterno objItensTrans) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM ITENSTRANSFERENCIA WHERE IdItem='" + objItensTrans.getIdItemTrans() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItensTrans;

    }
    //---------------------------------------- ITENSCRCPORTARIA ----------------------------------------------------------

    // Informa quais internos irão sair VINCULO ENTRE ITENSTRANSFERENCIA E ITENSREGPORTARIA
    public ItensTransInterno incluirItensRegTransfPortaria(ItensTransInterno objItensTrans) {

        buscarInternoCrc(objItensTrans.getNomeInterno(),objItensTrans.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSCRCPORTARIA (IdInternoCrc,IdSaida,IdItemSaida,DataSaida,DataRetorno,DestinoSaida,DocumentoSaida,SaidaConfirmada,Evadido) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensTrans.getIdTrans());
            pst.setInt(3, objItensTrans.getIdItemTrans());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensTrans.getDataTrans().getTime()));
            if (objItensTrans.getDataRetorno() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objItensTrans.getDataRetorno().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objItensTrans.getNomeDestino());
            pst.setString(7, objItensTrans.getDocumento());
            pst.setString(8, objItensTrans.getConfirmaSaida());
            pst.setString(9, objItensTrans.getInternoEvadido());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTrans;
    }

    public ItensTransInterno alterarItensRegTransfPortaria(ItensTransInterno objItensTrans) {

        buscarInternoCrc(objItensTrans.getNomeInterno(),objItensTrans.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSCRCPORTARIA SET IdInternoCrc=?,IdSaida=?,IdItemSaida=?,DataSaida=?,DataRetorno=?,DestinoSaida=?,DocumentoSaida=?,SaidaConfirmada=?,Evadido=? WHERE IdItemSaida='" + objItensTrans.getIdItemTrans() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItensTrans.getIdTrans());
            pst.setInt(3, objItensTrans.getIdItemTrans());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensTrans.getDataTrans().getTime()));
            if (objItensTrans.getDataRetorno() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objItensTrans.getDataRetorno().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objItensTrans.getNomeDestino());
            pst.setString(7, objItensTrans.getDocumento());
            pst.setString(8, objItensTrans.getConfirmaSaida());
            pst.setString(9, objItensTrans.getInternoEvadido());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTrans;
    }

    public ItensTransInterno excluirItensRegTransfPortaria(ItensTransInterno objItensTrans) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSCRCPORTARIA WHERE IdItemSaida='" + objItensTrans.getIdItemTrans() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensTrans;
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

    // Buscar UNIDADE PENAL

    public void buscarUnidade(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM UNIDADE WHERE DescricaoUnid='" + nome + "'");
            conecta.rs.first();
            codUnid = conecta.rs.getInt("IdUnid");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (UNIDADE PENAL) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
