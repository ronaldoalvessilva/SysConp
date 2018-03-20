/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PaiPsicoSocial;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControlePAI {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PaiPsicoSocial objPaiPsico = new PaiPsicoSocial();
    int codInt;

    public PaiPsicoSocial incluirPAI(PaiPsicoSocial objPaiPsico) {
        buscarInternoCrc(objPaiPsico.getNomeInternoCrc(), objPaiPsico.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PAI_PSICOSOCIAL (StatusPai,DataPai,IdInternoCrc,IdadeInterno,OrientacaoSexual,DadosPessoais,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objPaiPsico.getStatusPai());
            pst.setTimestamp(2, new java.sql.Timestamp(objPaiPsico.getDataPai().getTime()));
            pst.setInt(3, codInt);
            pst.setInt(4, objPaiPsico.getIdadeInterno());
            pst.setString(5, objPaiPsico.getOrientacaoSexual());
            pst.setString(6, objPaiPsico.getDadosPessoais());
            pst.setString(7, objPaiPsico.getUsuarioInsert());
            pst.setString(8, objPaiPsico.getDataInsert());
            pst.setString(9, objPaiPsico.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPaiPsico;
    }

    public PaiPsicoSocial alterarPAI(PaiPsicoSocial objPaiPsico) {
        buscarInternoCrc(objPaiPsico.getNomeInternoCrc(), objPaiPsico.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PAI_PSICOSOCIAL SET StatusPai=?,DataPai=?,IdInternoCrc=?,IdadeInterno=?,OrientacaoSexual=?,DadosPessoais=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPai='" + objPaiPsico.getIdPai() + "'");
            pst.setString(1, objPaiPsico.getStatusPai());
            pst.setTimestamp(2, new java.sql.Timestamp(objPaiPsico.getDataPai().getTime()));
            pst.setInt(3, codInt);
            pst.setInt(4, objPaiPsico.getIdadeInterno());
            pst.setString(5, objPaiPsico.getOrientacaoSexual());
            pst.setString(6, objPaiPsico.getDadosPessoais());
            pst.setString(7, objPaiPsico.getUsuarioUp());
            pst.setString(8, objPaiPsico.getDataUp());
            pst.setString(9, objPaiPsico.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPaiPsico;
    }

    public PaiPsicoSocial excluirPAI(PaiPsicoSocial objPaiPsico) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PAI_PSICOSOCIAL WHERE IdPai='" + objPaiPsico.getIdPai() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPaiPsico;
    }

    public void buscarInternoCrc(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
