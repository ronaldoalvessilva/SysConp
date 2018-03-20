/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DocumentosProcesso;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleDocumentosProcessos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    DocumentosProcesso objDocProcesso = new DocumentosProcesso();

    int codNatp;

    public DocumentosProcesso incluirDocumentosProcesso(DocumentosProcesso objDocProcesso) {
        buscarAmparo(objDocProcesso.getIdNatp(), objDocProcesso.getDescricaoNatureza());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DOCUMENTOS_PROCESSO (IdFicha,IdNatp,Documento,OrigemDoc,DataDoc,HoraDoc,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objDocProcesso.getIdFicha());
            pst.setInt(2, codNatp);
            pst.setString(3, objDocProcesso.getDocumento());
            pst.setString(4, objDocProcesso.getOrigemDoc());
            pst.setTimestamp(5, new java.sql.Timestamp(objDocProcesso.getDataDoc().getTime()));
            pst.setString(6, objDocProcesso.getHoraDoc());
            pst.setString(7, objDocProcesso.getObservacao());
            pst.setString(8, objDocProcesso.getUsuarioInsert());
            pst.setString(9, objDocProcesso.getDataInsert());
            pst.setString(10, objDocProcesso.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDocProcesso;
    }

    public DocumentosProcesso alterarDocumentosProcesso(DocumentosProcesso objDocProcesso) {
        buscarAmparo(objDocProcesso.getIdNatp(), objDocProcesso.getDescricaoNatureza());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DOCUMENTOS_PROCESSO SET IdFicha=?,IdNatp=?,Documento=?,OrigemDoc=?,DataDoc=?,HoraDoc=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdDocPro='" + objDocProcesso.getIdDocPro() + "'");
            pst.setInt(1, objDocProcesso.getIdFicha());
            pst.setInt(2, codNatp);
            pst.setString(3, objDocProcesso.getDocumento());
            pst.setString(4, objDocProcesso.getOrigemDoc());
            pst.setTimestamp(5, new java.sql.Timestamp(objDocProcesso.getDataDoc().getTime()));
            pst.setString(6, objDocProcesso.getHoraDoc());
            pst.setString(7, objDocProcesso.getObservacao());
            pst.setString(8, objDocProcesso.getUsuarioUp());
            pst.setString(9, objDocProcesso.getDataUp());
            pst.setString(10, objDocProcesso.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDocProcesso;
    }

    public DocumentosProcesso excluirDocumentosProcesso(DocumentosProcesso objDocProcesso) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DOCUMENTOS_PROCESSO WHERE IdDocPro='" + objDocProcesso.getIdDocPro() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDocProcesso;
    }

    public void buscarAmparo(int codigo, String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM NATUREZA_PRISAO WHERE IdNatp='" + codigo + "'AND DescricaoNatureza='" + desc + "'");
            conecta.rs.first();
            codNatp = conecta.rs.getInt("IdNatp");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
