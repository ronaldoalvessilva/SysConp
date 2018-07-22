/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ComposicaoKit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleComposicaoKit {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ComposicaoKit objComp = new ComposicaoKit();

    int codFunc;

    public ComposicaoKit incluirComposicaoKitlInternos(ComposicaoKit objComp) {
        buscarColaborador(objComp.getNomeColaborador(), objComp.getIdFunc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO COMPOSICAO_PAGAMENTO_KIT_INTERNOS (StatusComp,DataComp,IdKit,IdItem,IdFunc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objComp.getStatusComp());
            pst.setTimestamp(2, new java.sql.Timestamp(objComp.getDataComp().getTime()));
            pst.setInt(3, objComp.getIdKit());
            pst.setInt(4, objComp.getIdItem());
            pst.setInt(5, codFunc);
            pst.setString(6, objComp.getObservacao());
            pst.setString(7, objComp.getUsuarioInsert());
            pst.setString(8, objComp.getDataInsert());
            pst.setString(9, objComp.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objComp;
    }

    public ComposicaoKit alterarComposicaoKitlInternos(ComposicaoKit objComp) {
        buscarColaborador(objComp.getNomeColaborador(), objComp.getIdFunc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COMPOSICAO_PAGAMENTO_KIT_INTERNOS SET StatusComp=?,DataComp=?,IdKit=?,IdItem=?,IdFunc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRegistroComp='" + objComp.getIdRegistroComp() + "'");
            pst.setString(1, objComp.getStatusComp());
            pst.setTimestamp(2, new java.sql.Timestamp(objComp.getDataComp().getTime()));
            pst.setInt(3, objComp.getIdKit());
            pst.setInt(4, objComp.getIdItem());
            pst.setInt(5, codFunc);
            pst.setString(6, objComp.getObservacao());
            pst.setString(7, objComp.getUsuarioInsert());
            pst.setString(8, objComp.getDataInsert());
            pst.setString(9, objComp.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objComp;
    }

    public ComposicaoKit excluirComposicaoKitlInternos(ComposicaoKit objComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM COMPOSICAO_PAGAMENTO_KIT_INTERNOS WHERE IdRegistroComp='" + objComp.getIdRegistroComp() + "'");
            pst.setString(1, objComp.getStatusComp());
            pst.setTimestamp(2, new java.sql.Timestamp(objComp.getDataComp().getTime()));
            pst.setString(3, objComp.getUsuarioInsert());
            pst.setString(4, objComp.getDataInsert());
            pst.setString(5, objComp.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objComp;
    }

    public void buscarColaborador(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR WHERE NomeFunc=" + nome + "'AND IdFunc='" + codigo + "'");
            conecta.rs.first();
            codFunc = conecta.rs.getInt("IdFunc");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
