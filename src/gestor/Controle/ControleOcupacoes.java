/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Ocupacao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleOcupacoes {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Ocupacao objOcupa = new Ocupacao();

    public Ocupacao incluirOcupacao(Ocupacao Ocupacao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO OCUPACAO (StatusOcupa,DescricaoOcupa,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
            pst.setString(1, Ocupacao.getStatusOcupa());
            pst.setString(2, Ocupacao.getDescricaoOcupa());
            pst.setString(3, Ocupacao.getUsuarioInsert());
            pst.setString(4, Ocupacao.getDataInsert());
            pst.setString(5, Ocupacao.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return Ocupacao;
    }

    public Ocupacao alterarOcupacao(Ocupacao Ocupacao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OCUPACAO SET StatusOcupa=?,DescricaoOcupa=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdCodigoOcupa='" + Ocupacao.getIdCodigo() + "'");
            pst.setString(1, Ocupacao.getStatusOcupa());
            pst.setString(2, Ocupacao.getDescricaoOcupa());
            pst.setString(3, Ocupacao.getUsuarioUp());
            pst.setString(4, Ocupacao.getDataUp());
            pst.setString(5, Ocupacao.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return Ocupacao;
    }

    public Ocupacao excluirOcupacao(Ocupacao Ocupacao) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM OCUPACAO WHERE IdCodigoOcupa='" + Ocupacao.getIdCodigo() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return Ocupacao;
    }
}
