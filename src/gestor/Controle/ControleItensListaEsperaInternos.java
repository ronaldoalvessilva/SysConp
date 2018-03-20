/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensListaEspera;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensListaEsperaInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensListaEspera objItensLista = new ItensListaEspera();
    int codInterno;

    public ItensListaEspera incluirItensListaEspera(ItensListaEspera objItensLista) {
        buscarInternos(objItensLista.getNomeInterno(), objItensLista.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSLISTAESPERA (IdLanc,IdInternoCrc,IdCela,ObsInt,Encaminhar,ProfissaoInterno,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objItensLista.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setInt(3, objItensLista.getIdCela());
            pst.setString(4, objItensLista.getObsInt());            
            pst.setString(5, objItensLista.getEncaminharAtividade());
            pst.setString(6, objItensLista.getProfissaoInterno());
            pst.setString(7, objItensLista.getUsuarioInsert());
            pst.setString(8, objItensLista.getDataInsert());
            pst.setString(9, objItensLista.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensLista;
    }

    public ItensListaEspera alterarItensListaEspera(ItensListaEspera objItensLista) {
        buscarInternos(objItensLista.getNomeInterno(), objItensLista.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSLISTAESPERA SET IdLanc=?,IdInternoCrc=?,IdCela=?,ObsInt=?,Encaminhar=?,ProfissaoInterno=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensLista.getIdItem() + "'");
            pst.setInt(1, objItensLista.getIdLanc());
            pst.setInt(2, codInterno);
            pst.setInt(3, objItensLista.getIdCela());
            pst.setString(4, objItensLista.getObsInt());           
            pst.setString(5, objItensLista.getEncaminharAtividade());
            pst.setString(6, objItensLista.getProfissaoInterno());
            pst.setString(7, objItensLista.getUsuarioUp());
            pst.setString(8, objItensLista.getDataUp());
            pst.setString(9, objItensLista.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objItensLista;
    }

    public ItensListaEspera excluirItensListaEspera(ItensListaEspera objItensLista) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSLISTAESPERA WHERE IdItem='" + objItensLista.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensLista;
    }

    public void buscarInternos(String desc, int codigoInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'AND IdInternoCrc='" + codigoInterno + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
