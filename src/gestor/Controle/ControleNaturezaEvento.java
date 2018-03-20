/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.NaturezaEvento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleNaturezaEvento {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    NaturezaEvento objNaturezaEven = new NaturezaEvento();

    public NaturezaEvento incluirNaturezaEvento(NaturezaEvento objNaturezaEven) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO NATUREZAEVENTOS (StatusNatureza,DescricaoNatureza,UsuarioInsert,DataInsert,HorarioInsert,TipoFalta,DescricaoDetalhadaFalta) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objNaturezaEven.getStatusNatureza());
            pst.setString(2, objNaturezaEven.getDescricaoNatureza());
            pst.setString(3, objNaturezaEven.getUsuarioInsert());
            pst.setString(4, objNaturezaEven.getDataInsert());
            pst.setString(5, objNaturezaEven.getHorarioInsert());
            pst.setString(6, objNaturezaEven.getTipoFalta());
            pst.setString(7, objNaturezaEven.getDescrucaoDetalhada());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objNaturezaEven;
    }

    public NaturezaEvento alterarNaturezaEvento(NaturezaEvento objNaturezaEven) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE NATUREZAEVENTOS SET StatusNatureza=?,DescricaoNatureza=?,UsuarioUp=?,DataUp=?,HorarioUp=?,TipoFalta=?,DescricaoDetalhadaFalta=? WHERE IdNatureza='" + objNaturezaEven.getIdNatureza() + "'");
            pst.setString(1, objNaturezaEven.getStatusNatureza());
            pst.setString(2, objNaturezaEven.getDescricaoNatureza());
            pst.setString(3, objNaturezaEven.getUsuarioUp());
            pst.setString(4, objNaturezaEven.getDataUp());
            pst.setString(5, objNaturezaEven.getHorarioUp());
            pst.setString(6, objNaturezaEven.getTipoFalta());
            pst.setString(7, objNaturezaEven.getDescrucaoDetalhada());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objNaturezaEven;
    }

    public NaturezaEvento excluirNaturezaEvento(NaturezaEvento objNaturezaEven) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM NATUREZAEVENTOS WHERE IdNatureza='" + objNaturezaEven.getIdNatureza() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETE os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objNaturezaEven;
    }
}
