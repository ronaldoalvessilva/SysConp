/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.InternosSaidaEducacional;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleInternosEducacional {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    InternosSaidaEducacional objIntEduca = new InternosSaidaEducacional();

    int codInterno;

    public InternosSaidaEducacional incluirAssistenciaEducativa(InternosSaidaEducacional objIntEduca) {
        buscarInternoCrc(objIntEduca.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO INTERNOS_SAIDA_EDUCACIONAL (IdEduca,IdInternoCrc,Motivo,TipoAcesso,Evadido,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, objIntEduca.getIdEduca());
            pst.setInt(2, codInterno);
            pst.setString(3, objIntEduca.getMotivo());
            pst.setInt(4, objIntEduca.getTipoAcesso());
            pst.setString(5, objIntEduca.getEvadidoEducacao());
            pst.setString(6, objIntEduca.getUsuarioInsert());
            pst.setString(7, objIntEduca.getDataInsert());
            pst.setString(8, objIntEduca.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objIntEduca;
    }

    public InternosSaidaEducacional alterarAssistenciaEducativa(InternosSaidaEducacional objIntEduca) {
        buscarInternoCrc(objIntEduca.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE INTERNOS_SAIDA_EDUCACIONAL SET IdEduca=?,IdInternoCrc=?,Motivo=?,TipoAcesso=?,Evadido=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objIntEduca.getIdItem() + "'");
            pst.setInt(1, objIntEduca.getIdEduca());
            pst.setInt(2, codInterno);
            pst.setString(3, objIntEduca.getMotivo());
            pst.setInt(4, objIntEduca.getTipoAcesso());
            pst.setString(5, objIntEduca.getEvadidoEducacao());
            pst.setString(6, objIntEduca.getUsuarioUp());
            pst.setString(7, objIntEduca.getDataUp());
            pst.setString(8, objIntEduca.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objIntEduca;
    }

    public InternosSaidaEducacional excluirAssistenciaEducativa(InternosSaidaEducacional objIntEduca) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM INTERNOS_SAIDA_EDUCACIONAL WHERE IdItem='" + objIntEduca.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO:" + ex);
        }
        conecta.desconecta();
        return objIntEduca;
    }

    public void buscarInternoCrc(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (INTERNO) a serem exibidos !!!\nERRO: " +ex);
        }
        conecta.desconecta();
    }
}
