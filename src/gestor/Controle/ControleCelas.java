/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Celas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleCelas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Celas objCelas = new Celas();
    int codPav;

    //Método para SALVAR PAVILHÃO
    public Celas incluirCelas(Celas objCelas) {
        buscarPavilhao(objCelas.getDescricaoPavilhao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CELAS (EndCelaPav,IdPav,UsuarioInsert,DataInsert,HorarioInsert,StatusCela,Motivo,NivelCel,Capacidade,NrCela) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCelas.getEndCelaPav());
            pst.setInt(2, codPav);
            pst.setString(3, objCelas.getUsuarioInsert());
            pst.setString(4, objCelas.getDataInsert());
            pst.setString(5, objCelas.getHoraInsert());
            pst.setString(6, objCelas.getStatusCela());
            pst.setString(7, objCelas.getMotivo());
            pst.setString(8, objCelas.getNivelCela());
            pst.setInt(9, objCelas.getCapacidade());
            pst.setInt(10, objCelas.getNumeroCela());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCelas;

    }
    
    public Celas alterarCelas(Celas objCelas) {

        buscarPavilhao(objCelas.getDescricaoPavilhao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CELAS SET EndCelaPav=?,IdPav=?,UsuarioUp=?,DataUp=?,HorarioUp=?,StatusCela=?,Motivo=?,NivelCel=?,Capacidade=?,NrCela=? WHERE IdCela='" + objCelas.getIdCela() + "'");
            pst.setString(1, objCelas.getEndCelaPav());
            pst.setInt(2, codPav);
            pst.setString(3, objCelas.getUsuarioUp());
            pst.setString(4, objCelas.getDataUp());
            pst.setString(5, objCelas.getHoraUp());
            pst.setString(6, objCelas.getStatusCela());
            pst.setString(7, objCelas.getMotivo());
            pst.setString(8, objCelas.getNivelCela());
            pst.setInt(9, objCelas.getCapacidade());
            pst.setInt(10, objCelas.getNumeroCela());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCelas;
    }
    /**
     *
     * @param objCelas
     * @return
     */
    public Celas excluirCelas(Celas objCelas) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM CELAS WHERE IdCela=?");
            pst.setInt(1, objCelas.getIdCela());
            pst.execute();
            conecta.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCelas;

    }

    public void buscarPavilhao(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO WHERE DescricaoPav='" + nome + "'");
            conecta.rs.first();
            codPav = conecta.rs.getInt("IdPav");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (PAVILHÃO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
