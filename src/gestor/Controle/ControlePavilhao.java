/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Pavilhao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo Alves da Silva
 */
public class ControlePavilhao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Pavilhao objPav = new Pavilhao();

//Método para SALVAR PAVILHÃO
    public Pavilhao incluirPavilhao(Pavilhao objPav) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PAVILHAO (DescricaoPav,UsuarioInsert,DataInsert,HorarioInsert,StatusPav,Motivo,NivelPav) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objPav.getDescricaoPav());
            pst.setString(2, objPav.getUsuarioInsert());
            pst.setString(3, objPav.getDataInsert());
            pst.setString(4, objPav.getHoraInsert());
            pst.setString(5, objPav.getStatusPavilhao());
            pst.setString(6, objPav.getMotivoInativacao());
            pst.setString(7, objPav.getNivelPavilhao());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPav;

    }
//Método para ALTERAR PAVILHÃO

    public Pavilhao alterarPavilhao(Pavilhao objPav) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PAVILHAO SET DescricaoPav=?,UsuarioUp=?,DataUp=?,HorarioUp=?,StatusPav=?,Motivo=?,NivelPav=? WHERE IdPav='" + objPav.getIdPav()  + "'");
            pst.setString(1, objPav.getDescricaoPav());          
            pst.setString(2, objPav.getUsuarioUp());
            pst.setString(3, objPav.getDataUp());
            pst.setString(4, objPav.getHoraUp());
            pst.setString(5, objPav.getStatusPavilhao());
            pst.setString(6, objPav.getMotivoInativacao());
            pst.setString(7, objPav.getNivelPavilhao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPav;
    }

    /**
     *
     * @param objPav
     * @return
     */
    public Pavilhao excluirPavilhao(Pavilhao objPav) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM PAVILHAO WHERE IdPav='" + objPav.getIdPav() + "'");
            //  pst.setInt(1, objPav.getIdPav());
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPav;
    }
}
