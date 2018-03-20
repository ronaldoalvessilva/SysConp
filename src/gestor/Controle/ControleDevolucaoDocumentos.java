/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DocumentosInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleDevolucaoDocumentos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    DocumentosInternos objDocInternos = new DocumentosInternos();

    public DocumentosInternos incluirDevolucaoDocumentos(DocumentosInternos objDocInternos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DEVOLUCAO_DOCUMENTOS_SERVICO_SOCIAL (IdDoc,DataDevolucao,Horario,Documento,UsuarioInsert,DataInsert,HorarioInsert,MotivoDevolucao) VALUES(?,?,?,?,?,?,?,?)");           
            pst.setInt(1, objDocInternos.getIdDoc());
            if (objDocInternos.getDataDevolucaoDoc() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objDocInternos.getDataDevolucaoDoc().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objDocInternos.getHorario());
            pst.setString(4, objDocInternos.getTipoDocumento());
            pst.setString(5, objDocInternos.getUsuarioInsert());
            pst.setString(6, objDocInternos.getDataInsert());
            pst.setString(7, objDocInternos.getHorarioInsert());
            pst.setString(8, objDocInternos.getMotivoDevolucao());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objDocInternos;
    }

    public DocumentosInternos alterarDevolucaoDocumentos(DocumentosInternos objDocInternos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DEVOLUCAO_DOCUMENTOS_SERVICO_SOCIAL SET IdDoc=?,DataDevolucao=?,Horario=?,Documento=?,UsuarioUp=?,DataUp=?,HorarioUp=?,MotivoDevolucao=? WHERE IdRegistro='" + objDocInternos.getCodigoRegistro() + "'");
            pst.setInt(1, objDocInternos.getIdDoc());
            if (objDocInternos.getDataDevolucaoDoc() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objDocInternos.getDataDevolucaoDoc().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objDocInternos.getHorario());
            pst.setString(4, objDocInternos.getTipoDocumento());
            pst.setString(5, objDocInternos.getUsuarioUp());
            pst.setString(6, objDocInternos.getDataUp());
            pst.setString(7, objDocInternos.getHorarioUp());
            pst.setString(8, objDocInternos.getMotivoDevolucao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objDocInternos;
    }

    public DocumentosInternos excluirDevolucaoDocumentos(DocumentosInternos objDocInternos) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DEVOLUCAO_DOCUMENTOS_SERVICO_SOCIAL WHERE IdRegistro='" + objDocInternos.getCodigoRegistro() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objDocInternos;
    }
}
