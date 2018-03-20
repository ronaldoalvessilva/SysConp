/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.NaturezaPrisao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleNaturezaPrisao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    NaturezaPrisao objNatPri = new NaturezaPrisao();

    public NaturezaPrisao incluirNaturezaPrisao(NaturezaPrisao objNatPri) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO NATUREZA_PRISAO (StatusNatp,DataNatp,DescricaoNatureza,TextoNatureza,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objNatPri.getStatusNatp());
            pst.setTimestamp(2, new java.sql.Timestamp(objNatPri.getDataNatp().getTime()));
            pst.setString(3, objNatPri.getDescricaoNatureza());
            pst.setString(4, objNatPri.getTextoNatureza());
            pst.setString(5, objNatPri.getUsuarioInsert());
            pst.setString(6, objNatPri.getDataInsert());
            pst.setString(7, objNatPri.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objNatPri;
    }

    public NaturezaPrisao alterarNaturezaPrisao(NaturezaPrisao objNatPri) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE NATUREZA_PRISAO SET StatusNatp=?,DataNatp=?,DescricaoNatureza=?,TextoNatureza=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdNatp='" + objNatPri.getIdNatp()+ "'");
            pst.setString(1, objNatPri.getStatusNatp());
            pst.setTimestamp(2, new java.sql.Timestamp(objNatPri.getDataNatp().getTime()));
            pst.setString(3, objNatPri.getDescricaoNatureza());
            pst.setString(4, objNatPri.getTextoNatureza());
            pst.setString(5, objNatPri.getUsuarioUp());
            pst.setString(6, objNatPri.getDataUp());
            pst.setString(7, objNatPri.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objNatPri;
    }

    public NaturezaPrisao excluirNaturezaPrisao(NaturezaPrisao objNatPri) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM NATUREZA_PRISAO WHERE IdNatp='" + objNatPri.getIdNatp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objNatPri;
    }
}
