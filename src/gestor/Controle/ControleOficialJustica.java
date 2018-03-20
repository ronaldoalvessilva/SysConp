/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.OficialJustica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleOficialJustica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    OficialJustica objOficial = new OficialJustica();

    public OficialJustica incluirOficialJustica(OficialJustica objOficial) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO OFICIAL_JUSTICA (DataCadastro,fotoOficial,NomeOficial,RgOficial,CpfOficial,REGOficial,ObsOficial,UsuarioInsert,DataInsert,HorarioInsert,StatusOficial) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objOficial.getDataCadastro().getTime()));           
            pst.setString(2, objOficial.getFotoOficial());
            pst.setString(3, objOficial.getNomeOficial());
            pst.setString(4, objOficial.getRgOficial());
            pst.setString(5, objOficial.getCpfOficial());
            pst.setString(6, objOficial.getRegOficial());
            pst.setString(7, objOficial.getObsOficial());
            pst.setString(8, objOficial.getUsuarioInsert());
            pst.setString(9, objOficial.getDataInsert());
            pst.setString(10, objOficial.getHoraInsert());
            pst.setString(11, objOficial.getStatusOficial());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOficial;
    }

    public OficialJustica alterarOficialJustica(OficialJustica objOficial) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE OFICIAL_JUSTICA SET DataCadastro=?,fotoOficial=?,NomeOficial=?,RgOficial=?,CpfOficial=?,REGOficial=?,ObsOficial=?,UsuarioUp=?,DataUp=?,HorarioUp=?,StatusOficial=? WHERE IdOficial='" + objOficial.getIdOficial() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objOficial.getDataCadastro().getTime()));
            pst.setString(2, objOficial.getFotoOficial());
            pst.setString(3, objOficial.getNomeOficial());
            pst.setString(4, objOficial.getRgOficial());
            pst.setString(5, objOficial.getCpfOficial());
            pst.setString(6, objOficial.getRegOficial());
            pst.setString(7, objOficial.getObsOficial());
            pst.setString(8, objOficial.getUsuarioUp());
            pst.setString(9, objOficial.getDataUp());
            pst.setString(10, objOficial.getHoraUp());
            pst.setString(11, objOficial.getStatusOficial());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOficial;
    }

    public OficialJustica excluirOficialJustica(OficialJustica objOficial) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM OFICIAL_JUSTICA WHERE IdOficial='" + objOficial.getIdOficial() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objOficial;
    }
}
