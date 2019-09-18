/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Colaborador;
import gestor.Modelo.LiberadoresInternoColaboradores;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleLiberadorBasePSPLiberadores {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Colaborador objColaLib = new Colaborador();
    LiberadoresInternoColaboradores objLib = new LiberadoresInternoColaboradores();

    public LiberadoresInternoColaboradores incluirColaboradorLiberador(LiberadoresInternoColaboradores objLib) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_LIBERADOR_ESCOLTA_INTERNO_PSP (StatusFunc,IdLibe,IdFunc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setString(1, objLib.getStatusFunc());
            pst.setInt(2, objLib.getIdLibe());
            pst.setInt(3, objLib.getIdFunc());
            pst.setString(4, objLib.getUsuarioInsert());
            pst.setString(5, objLib.getDataInsert());
            pst.setString(6, objLib.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLib;
    }

    public LiberadoresInternoColaboradores alterarColaboradorLiberador(LiberadoresInternoColaboradores objLib) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_LIBERADOR_ESCOLTA_INTERNO_PSP SET StatusFunc=?,IdFunc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItemLibPSP='" + objLib.getIdItemLibPSP() + "'");
            pst.setString(1, objLib.getStatusFunc());
            pst.setInt(2, objLib.getIdFunc());
            pst.setString(3, objLib.getUsuarioUp());
            pst.setString(4, objLib.getDataUp());
            pst.setString(5, objLib.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLib;
    }

    public LiberadoresInternoColaboradores excluirColaboradorLiberador(LiberadoresInternoColaboradores objLib) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_LIBERADOR_ESCOLTA_INTERNO_PSP WHERE IdItemLibPSP='" + objLib.getIdItemLibPSP() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLib;
    }

    public List<Colaborador> read() throws Exception {
        conecta.abrirConexao();
        List<Colaborador> nomeColaborador = new ArrayList<Colaborador>();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR");
            while (conecta.rs.next()) {
                Colaborador pLibCola = new Colaborador();
                pLibCola.setIdFunc(conecta.rs.getInt("IdFunc"));
                pLibCola.setNomeFunc(conecta.rs.getString("NomeFunc"));
                nomeColaborador.add(pLibCola);
            }
            return nomeColaborador;
        } catch (SQLException ex) {
            Logger.getLogger(ControleLiberadorBasePSP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
