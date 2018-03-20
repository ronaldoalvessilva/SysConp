/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensPrevisaoSaida;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensPrevisaoSaida {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensPrevisaoSaida objItensPreSaida = new ItensPrevisaoSaida();
    int codInt;

    public ItensPrevisaoSaida incluirItensPrevisaoSaida(ItensPrevisaoSaida objItensPreSaida) {
        buscarInterno(objItensPreSaida.getNomeInterno(),objItensPreSaida.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSPREVISAOSAIDA (IdLanc,IdInternoCrc,DataPrevSaida,Beneficio,ConfirmaSaida,UtilizadoSaida,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensPreSaida.getIdLanc());
            pst.setInt(2, codInt);
            pst.setTimestamp(3, new java.sql.Timestamp(objItensPreSaida.getDataPrevSaida().getTime()));
            pst.setString(4, objItensPreSaida.getBeneficio());
            pst.setString(5, objItensPreSaida.getConfirmaSaida());
            pst.setString(6, objItensPreSaida.getUtilizadoSaida());
            pst.setString(7, objItensPreSaida.getUsuarioInsert());
            pst.setString(8, objItensPreSaida.getDataInsert());
            pst.setString(9, objItensPreSaida.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensPreSaida;
    }

    public ItensPrevisaoSaida alterarItensPrevisaoSaida(ItensPrevisaoSaida objItensPreSaida) {
        buscarInterno(objItensPreSaida.getNomeInterno(),objItensPreSaida.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSPREVISAOSAIDA SET IdLanc=?,IdInternoCrc=?,DataPrevSaida=?,Beneficio=?,ConfirmaSaida=?,UtilizadoSaida=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensPreSaida.getIdItem() + "'");
            pst.setInt(1, objItensPreSaida.getIdLanc());
            pst.setInt(2, codInt);
            pst.setTimestamp(3, new java.sql.Timestamp(objItensPreSaida.getDataPrevSaida().getTime()));
            pst.setString(4, objItensPreSaida.getBeneficio());
            pst.setString(5, objItensPreSaida.getConfirmaSaida());
            pst.setString(6, objItensPreSaida.getUtilizadoSaida());
            pst.setString(7, objItensPreSaida.getUsuarioUp());
            pst.setString(8, objItensPreSaida.getDataUp());
            pst.setString(9, objItensPreSaida.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensPreSaida;
    }

    public ItensPrevisaoSaida excluirItensPrevisaoSaida(ItensPrevisaoSaida objItensPreSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSPREVISAOSAIDA WHERE IdItem='" + objItensPreSaida.getIdItem() + "'");
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensPreSaida;
    }
//------------------------------------- Alterar utilização dos internos na tabela ITENSPREVISAOSAIDA como "Sim"
    public ItensPrevisaoSaida alterarUtilizacaoPrevisaoSaida(ItensPrevisaoSaida objItensPreSaida) {
      
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSPREVISAOSAIDA SET UtilizadoSaida=? WHERE IdInternoCrc='" + objItensPreSaida.getIdInternoCrc()+ "'");                     
            pst.setString(1, objItensPreSaida.getUtilizadoSaida());           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensPreSaida;
    }
    //------------------------------- Alterar confirmação do interno na saida da portaria como "Sim" após a saida
     public ItensPrevisaoSaida atualizaConfirmacaoSaidaPortaria(ItensPrevisaoSaida objItensPreSaida) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSPREVISAOSAIDA SET ConfirmaSaida=? WHERE IdInternoCrc='" + objItensPreSaida.getIdInternoCrc()+ "'AND Beneficio='" +  objItensPreSaida.getBeneficio() + "'");           
            pst.setString(1, objItensPreSaida.getConfirmaSaida());            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CONFIRMAR SAIDA do Interno\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensPreSaida;
    }
    public void buscarInterno(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "' "
                    + "AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados INTERNO a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
