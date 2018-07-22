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

    public ComposicaoKit incluirComposicaoKitlInternos(ComposicaoKit objComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO COMPOSICAO_PAGAMENTO_KIT_INTERNOS (StatusComp,DataComp,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?)");
            pst.setString(1, objComp.getStatusComp());
            pst.setTimestamp(2, new java.sql.Timestamp(objComp.getDataComp().getTime()));
            pst.setString(3, objComp.getUsuarioInsert());
            pst.setString(4, objComp.getDataInsert());
            pst.setString(5, objComp.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR registro.\nERRO: " + ex);
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
}
