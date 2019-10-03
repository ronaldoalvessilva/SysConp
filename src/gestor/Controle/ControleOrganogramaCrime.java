/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.OrganogramaCrime;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleOrganogramaCrime {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    OrganogramaCrime objOrg = new OrganogramaCrime();

    int codigoInterno = 0;
    int codigoPav = 0;
    int codigoCela = 0;

    public OrganogramaCrime incluirOrganograma_PRINCIPAL(OrganogramaCrime objOrg) {
        buscarInternoCrc(objOrg.getNomeInterno(), objOrg.getIdInternoCrc());
        buscarPavilhao(objOrg.getDescricaoPav());
        buscarCela(objOrg.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ORGANOGRAMA_CRIME (StatusOrg,DataOrg,IdInternoCrc,CartaBaralho,Faccao,IdPav,IdCela,Recompensa,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objOrg.getStatusOrg());
            pst.setTimestamp(2, new java.sql.Timestamp(objOrg.getDataOrg().getTime()));
            pst.setInt(3, codigoInterno);
            pst.setBytes(4, objOrg.getCartaBaralho());
            pst.setString(5, objOrg.getFaccao());
            pst.setInt(6, codigoPav);
            pst.setInt(7, codigoCela);
            pst.setDouble(8, objOrg.getRecompensa());
            pst.setString(9, objOrg.getUsuarioInsert());
            pst.setString(10, objOrg.getDataInsert());
            pst.setString(11, objOrg.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime alterarOrganograma_PRINCIPAL(OrganogramaCrime objOrg) {
        buscarInternoCrc(objOrg.getNomeInterno(), objOrg.getIdInternoCrc());
        buscarPavilhao(objOrg.getDescricaoPav());
        buscarCela(objOrg.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ORGANOGRAMA_CRIME SET StatusOrg,DataOrg,IdInternoCrc,CartaBaralho,Faccao,IdPav,IdCela,Recompensa,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdOrg='" + objOrg.getIdOrg() + "'");
            pst.setString(1, objOrg.getStatusOrg());
            pst.setTimestamp(2, new java.sql.Timestamp(objOrg.getDataOrg().getTime()));
            pst.setInt(3, codigoInterno);
            pst.setBytes(4, objOrg.getCartaBaralho());
            pst.setString(5, objOrg.getFaccao());
            pst.setInt(6, codigoPav);
            pst.setInt(7, codigoCela);
            pst.setDouble(8, objOrg.getRecompensa());
            pst.setString(9, objOrg.getUsuarioUp());
            pst.setString(10, objOrg.getDataUp());
            pst.setString(11, objOrg.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public OrganogramaCrime excluirOrganograma_PRINCIPAL(OrganogramaCrime objOrg) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ORGANOGRAMA_CRIME WHERE IdOrg='" + objOrg.getIdOrg() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOrg;
    }

    public void buscarInternoCrc(String nome, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + nome + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarPavilhao(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO "
                    + "WHERE DescricaoPav='" + desc + "'");
            conecta.rs.first();
            codigoPav = conecta.rs.getInt("IdPav");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (PAVILHAO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarCela(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CELAS "
                    + "WHERE EndCelaPav='" + desc + "'");
            conecta.rs.first();
            codigoCela = conecta.rs.getInt("IdCela");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (CELAS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
