/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Social2PaiPsicoSocial;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleSocial2PsicoSocialPAI_NOVO {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Social2PaiPsicoSocial objSocial2Pai = new Social2PaiPsicoSocial();
    int codInt;

    public Social2PaiPsicoSocial incluirSocial2PsicoSocial(Social2PaiPsicoSocial objSocial2Pai) {
        buscarInternoCrc(objSocial2Pai.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FICHA_CADASTRO_PAI_CCGF_VF (IdPai,IdInternoCrc,NomeFamiliar,Vinculo,Idade,Ocupacao,Endereco,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objSocial2Pai.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objSocial2Pai.getNomeFamiliar());
            pst.setString(4, objSocial2Pai.getVinculo());
            pst.setInt(5, objSocial2Pai.getIdade());
            pst.setString(6, objSocial2Pai.getOcupacao());
            pst.setString(7, objSocial2Pai.getEnderecoTelefonePAI());
            pst.setString(8, objSocial2Pai.getUsuarioInsert());
            pst.setString(9, objSocial2Pai.getDataInsert());
            pst.setString(10, objSocial2Pai.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSocial2Pai;
    }

    public Social2PaiPsicoSocial alterarSocial2PsicoSocial(Social2PaiPsicoSocial objSocial2Pai) {
        buscarInternoCrc(objSocial2Pai.getNomeInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHA_CADASTRO_PAI_CCGF_VF SET IdPai=?,IdInternoCrc=?,NomeFamiliar=?,Vinculo=?,Idade=?,Ocupacao=?,Endereco=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdVF='" + objSocial2Pai.getIdFamiliar() + "'");
            pst.setInt(1, objSocial2Pai.getIdPai());
            pst.setInt(2, codInt);
            pst.setString(3, objSocial2Pai.getNomeFamiliar());
            pst.setString(4, objSocial2Pai.getVinculo());
            pst.setInt(5, objSocial2Pai.getIdade());
            pst.setString(6, objSocial2Pai.getOcupacao());
            pst.setString(7, objSocial2Pai.getEnderecoTelefonePAI());
            pst.setString(8, objSocial2Pai.getUsuarioUp());
            pst.setString(9, objSocial2Pai.getDataUp());
            pst.setString(10, objSocial2Pai.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSocial2Pai;
    }

    public Social2PaiPsicoSocial excluirSocial2PsicoSocial(Social2PaiPsicoSocial objSocial2Pai) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FICHA_CADASTRO_PAI_CCGF_VF WHERE IdVF='" + objSocial2Pai.getIdFamiliar() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objSocial2Pai;
    }

    public void buscarInternoCrc(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
