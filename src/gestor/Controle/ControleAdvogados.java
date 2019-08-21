/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Advogados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleAdvogados {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Advogados objAdv = new Advogados();

    public Advogados incluirAdvogados(Advogados objAdv) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ADVOGADOS (DataCadastro,fotoAdvogado,NomeAdvogado,RgAdvogado,CpfAdvogado,OabAdvogado,ObsAdvogado,UsuarioInsert,DataInsert,HorarioInsert,StatusAdv,ImagemFrenteAD,NomeMae,NomePai,SituacaoCadastral) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objAdv.getDataCadastro().getTime()));
            pst.setString(2, objAdv.getFotoAdvogado());
            pst.setString(3, objAdv.getNomeAdvogado());
            pst.setString(4, objAdv.getRgAdvogado());
            pst.setString(5, objAdv.getCpfAdvogado());
            pst.setString(6, objAdv.getOabAdvogado());
            pst.setString(7, objAdv.getObsAdvogado());
            pst.setString(8, objAdv.getUsuarioInsert());
            pst.setString(9, objAdv.getDataInsert());
            pst.setString(10, objAdv.getHoraInsert());
            pst.setString(11, objAdv.getStatusAdv());
            pst.setBytes(12, objAdv.getImagemFrenteAD());
            pst.setString(13, objAdv.getNomeMae());
            pst.setString(14, objAdv.getNomePai());
            pst.setString(15, objAdv.getSituacaoCadastral());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdv;
    }

    public Advogados alterarAdvogados(Advogados objAdv) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ADVOGADOS SET DataCadastro=?,fotoAdvogado=?,NomeAdvogado=?,RgAdvogado=?,CpfAdvogado=?,OabAdvogado=?,ObsAdvogado=?,UsuarioUp=?,DataUp=?,HorarioUp=?,StatusAdv=?,ImagemFrenteAD=?,NomeMae=?,NomePai=?,SituacaoCadastral=? WHERE IdAdvogado='" + objAdv.getIdAdvogado() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objAdv.getDataCadastro().getTime()));
            pst.setString(2, objAdv.getFotoAdvogado());
            pst.setString(3, objAdv.getNomeAdvogado());
            pst.setString(4, objAdv.getRgAdvogado());
            pst.setString(5, objAdv.getCpfAdvogado());
            pst.setString(6, objAdv.getOabAdvogado());
            pst.setString(7, objAdv.getObsAdvogado());
            pst.setString(8, objAdv.getUsuarioUp());
            pst.setString(9, objAdv.getDataUp());
            pst.setString(10, objAdv.getHoraUp());
            pst.setString(11, objAdv.getStatusAdv());
            pst.setBytes(12, objAdv.getImagemFrenteAD());
            pst.setString(13, objAdv.getNomeMae());
            pst.setString(14, objAdv.getNomePai());
            pst.setString(15, objAdv.getSituacaoCadastral());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdv;
    }

    public Advogados excluirAdvogados(Advogados objAdv) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ADVOGADOS WHERE IdAdvogado='" + objAdv.getIdAdvogado() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAdv;
    }
}
