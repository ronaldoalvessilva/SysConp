/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoFemininoP4;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleAtendimentoFemininoP4 {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoFemininoP4 objAfP4 = new AtendimentoFemininoP4();

    int codigoInterno;

    public AtendimentoFemininoP4 incluirAtendimentoFemininoP4(AtendimentoFemininoP4 objAfP4) {
        buscarInterno(objAfP4.getNomeInternoCrc(), objAfP4.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ADME_AFP4 (IdLanc,IdInternoCrc,PesoGestante,AlturaGestante,Face,Tronco,MembroInferior,MembroSuperior,InspecaoPeleMucosa,PalpacaoTireoide,ExameAbdomem,AlturaUterina,PosicaoFetal,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAfP4.getIdLanc());
            pst.setInt(2, codigoInterno);
            pst.setFloat(3, objAfP4.getPesoGestante());
            pst.setFloat(4, objAfP4.getAlturaGestante());
            pst.setInt(5, objAfP4.getFace());
            pst.setInt(6, objAfP4.getTronco());
            pst.setInt(7, objAfP4.getMembroInferior());
            pst.setInt(8, objAfP4.getMembroSuperior());
            pst.setString(9, objAfP4.getInspecaoPeleMucosa());
            pst.setString(10, objAfP4.getPalpacaoTireoide());
            pst.setString(11, objAfP4.getExameAbdomem());
            pst.setFloat(12, objAfP4.getAlturaUterina());
            pst.setString(13, objAfP4.getPosicaoFetal());
            pst.setString(14, objAfP4.getUsuarioInsert());
            pst.setString(15, objAfP4.getDataInsert());
            pst.setString(16, objAfP4.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAfP4;
    }

    public AtendimentoFemininoP4 alterarAtendimentoFemininoP4(AtendimentoFemininoP4 objAfP4) {
        buscarInterno(objAfP4.getNomeInternoCrc(), objAfP4.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADME_AFP4 SET IdLanc=?,IdInternoCrc=?,PesoGestante=?,AlturaGestante=?,Face=?,Tronco=?,MembroInferior=?,MembroSuperior=?,InspecaoPeleMucosa=?,PalpacaoTireoide=?,ExameAbdomem=?,AlturaUterina=?,PosicaoFetal=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAfp4='" + objAfP4.getIdAfp4() + "'");
            pst.setInt(1, objAfP4.getIdLanc());
            pst.setInt(2, codigoInterno);
            pst.setFloat(3, objAfP4.getPesoGestante());
            pst.setFloat(4, objAfP4.getAlturaGestante());
            pst.setInt(5, objAfP4.getFace());
            pst.setInt(6, objAfP4.getTronco());
            pst.setInt(7, objAfP4.getMembroInferior());
            pst.setInt(8, objAfP4.getMembroSuperior());
            pst.setString(9, objAfP4.getInspecaoPeleMucosa());
            pst.setString(10, objAfP4.getPalpacaoTireoide());
            pst.setString(11, objAfP4.getExameAbdomem());
            pst.setFloat(12, objAfP4.getAlturaUterina());
            pst.setString(13, objAfP4.getPosicaoFetal());
            pst.setString(14, objAfP4.getUsuarioUp());
            pst.setString(15, objAfP4.getDataUp());
            pst.setString(16, objAfP4.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAfP4;
    }

    public AtendimentoFemininoP4 excluirAtendimentoFemininoP4(AtendimentoFemininoP4 objAfP4) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ADME_AFP4 WHERE IdAfp4=" + objAfP4.getIdAfp4() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAfP4;
    }

    public void buscarInterno(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigo + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o interno.\nERRO: " + ex);
        }
    }
}
