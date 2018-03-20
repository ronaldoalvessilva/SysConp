/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensPrevisaoSaida;
import gestor.Modelo.ItensSaidaInterno;
import gestor.Modelo.SaidaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensSaidaInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensSaidaInterno objItemSaida = new ItensSaidaInterno();
    SaidaInternos objSaida = new SaidaInternos();
    ItensPrevisaoSaida objItensPreSaida = new ItensPrevisaoSaida();
    int codInt;
    int qtdUnit = 1;

    public ItensSaidaInterno incluirItensSaida(ItensSaidaInterno objItemSaida) {

        buscarInternoCrc(objItemSaida.getNomeInterno(), objItemSaida.getIdInternoSaida());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSSAIDA (IdInternoCrc,IdSaida,DataSaida,DataRetorno,DestinoSaida,DocumentoSaida,SaidaConfirmada,QtdSaida,UsuarioInsert,DataInsert,HorarioInsert,Evadido) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItemSaida.getIdSaida());
            pst.setTimestamp(3, new java.sql.Timestamp(objItemSaida.getDataSaida().getTime()));
            if (objItemSaida.getDataRetorno()!= null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objItemSaida.getDataRetorno().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objItemSaida.getNomeDestino());
            pst.setString(6, objItemSaida.getDocumento());
            pst.setString(7, objItemSaida.getConfirmaSaida());
            pst.setInt(8, qtdUnit);
            pst.setString(9, objItemSaida.getUsuarioInsert());
            pst.setString(10, objItemSaida.getDataInsert());
            pst.setString(11, objItemSaida.getHoraInsert());
            pst.setString(12, objItemSaida.getInternoEvadido());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    public ItensSaidaInterno alterarItensSaida(ItensSaidaInterno objItemSaida) {
        //Pesquisar Nome do Interno através do código
        buscarInternoCrc(objItemSaida.getNomeInterno(), objItemSaida.getIdInternoSaida());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSSAIDA SET IdInternoCrc=?,IdSaida=?,DataSaida=?,DataRetorno=?,DestinoSaida=?,DocumentoSaida=?,SaidaConfirmada=?,QtdSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=?,Evadido=? WHERE IdItem='" + objItemSaida.getIdItemSaida() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItemSaida.getIdSaida());
            pst.setTimestamp(3, new java.sql.Timestamp(objItemSaida.getDataSaida().getTime()));
            if (objItemSaida.getDataRetorno()!= null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objItemSaida.getDataRetorno().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objItemSaida.getNomeDestino());
            pst.setString(6, objItemSaida.getDocumento());
            pst.setString(7, objItemSaida.getConfirmaSaida());
            pst.setInt(8, qtdUnit);
            pst.setString(9, objItemSaida.getUsuarioInsert());
            pst.setString(10, objItemSaida.getDataInsert());
            pst.setString(11, objItemSaida.getHoraInsert());
            pst.setString(12, objItemSaida.getInternoEvadido());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    //Método para excluir ITENS DE SAIDA
    public ItensSaidaInterno excluirItensSaida(ItensSaidaInterno objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM ITENSSAIDA WHERE IdItem='" + objItemSaida.getIdItemSaida() + "'");
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\n ERRO\n" + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    //---------------------------------------- ITENSCRCPORTARIA ----------------------------------------------------------
    
    // Informa quais internos irão sair VINCULO ENTRE ITENSSAIDA E ITENSREGPORTARIA
     public ItensSaidaInterno incluirItensSaidaPortaria(ItensSaidaInterno objItemSaida) {

        buscarInternoCrc(objItemSaida.getNomeInterno(), objItemSaida.getIdInternoSaida());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSCRCPORTARIA (IdInternoCrc,IdSaida,IdItemSaida,DataSaida,DataRetorno,DestinoSaida,DocumentoSaida,SaidaConfirmada,Evadido) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, objItemSaida.getIdSaida());
            pst.setInt(3, objItemSaida.getIdItemSaida());
            pst.setTimestamp(4, new java.sql.Timestamp(objItemSaida.getDataSaida().getTime()));   
            if (objItemSaida.getDataRetorno()!= null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objItemSaida.getDataRetorno().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objItemSaida.getNomeDestino());
            pst.setString(7, objItemSaida.getDocumento());
            pst.setString(8, objItemSaida.getConfirmaSaida()); 
            pst.setString(9, objItemSaida.getInternoEvadido());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }
     
     public ItensSaidaInterno alterarItensSaidaPortaria(ItensSaidaInterno objItemSaida) {

        buscarInternoCrc(objItemSaida.getNomeInterno(), objItemSaida.getIdInternoSaida());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSCRCPORTARIA SET IdInternoCrc=?,IdSaida=?,IdItemSaida=?,DataSaida=?,DataRetorno=?,DestinoSaida=?,DocumentoSaida=?,SaidaConfirmada=?,Evadido=? WHERE IdItemSaida='" + objItemSaida.getIdItemSaida()  + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, objItemSaida.getIdSaida());
            pst.setInt(3, objItemSaida.getIdItemSaida());
            pst.setTimestamp(4, new java.sql.Timestamp(objItemSaida.getDataSaida().getTime()));   
            if (objItemSaida.getDataRetorno()!= null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objItemSaida.getDataRetorno().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objItemSaida.getNomeDestino());
            pst.setString(7, objItemSaida.getDocumento());
            pst.setString(8, objItemSaida.getConfirmaSaida()); 
            pst.setString(9, objItemSaida.getInternoEvadido());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }
     // Excluir interno na portaria
     public ItensSaidaInterno excluirItensSaidaPortaria(ItensSaidaInterno objItemSaida) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSCRCPORTARIA WHERE IdItemSaida='" + objItemSaida.getIdItemSaida()  + "'");                     
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }
     // Excluir o interno pelo CRC quando não for usado na portaria - TESTADO E FUNCIONADO
     public ItensSaidaInterno excluirItensCrcPortaria(ItensSaidaInterno objItemSaida) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSCRCPORTARIA WHERE IdSaida='" + objItemSaida.getIdSaida()  + "'AND IdInternoCrc='" + objItemSaida.getIdInternoSaida()  + "'");                     
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }
     //--------------------------------------- ITENSPREVISAOSAIDA -----------------
      public ItensPrevisaoSaida incluirInternoPrevSaida(ItensPrevisaoSaida objItensPreSaida) {
   
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSSAIDA (IdInternoCrc,IdSaida,DataSaida,DataRetorno,DestinoSaida,DocumentoSaida,SaidaConfirmada,QtdSaida,UsuarioInsert,DataInsert,HorarioInsert,Evadido) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
          //  pst.setInt(1, codInt);
            pst.setInt(1, objItensPreSaida.getIdInternoCrc());
            pst.setInt(2, objItensPreSaida.getIdLanc());
            pst.setTimestamp(3, new java.sql.Timestamp(objItensPreSaida.getDataSaida().getTime()));
            if (objItensPreSaida.getDataPrevRetorno()!= null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objItensPreSaida.getDataPrevRetorno().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objItensPreSaida.getBeneficio());
            pst.setString(6, objItensPreSaida.getNumeroDocumento());
            pst.setString(7, objItensPreSaida.getConfirmaSaida());
            pst.setInt(8, qtdUnit);
            pst.setString(9, objItensPreSaida.getUsuarioInsert());
            pst.setString(10, objItensPreSaida.getDataInsert());
            pst.setString(11, objItensPreSaida.getHorarioInsert());
            pst.setString(12, objItensPreSaida.getEvadidos());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensPreSaida;
    }
    // Buscar INTERNO
    public void buscarInternoCrc(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
