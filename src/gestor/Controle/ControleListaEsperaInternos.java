/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ListaEsperaLaborativa;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleListaEsperaInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ListaEsperaLaborativa objLista = new ListaEsperaLaborativa();
    int codCela;

    public ListaEsperaLaborativa incluirListaEspera(ListaEsperaLaborativa objLista) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LISTAESPERA (StatusLanc,DataLanc,ObsLanc,UsuarioInsert,DataInsert,HorarioInsert,TipoListaEspera,Classificacao) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, objLista.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objLista.getDataLanc().getTime()));
            pst.setString(3, objLista.getObsLanc());
            pst.setString(4, objLista.getUsuarioInsert());
            pst.setString(5, objLista.getDataInsert());
            pst.setString(6, objLista.getHoraInsert());
            pst.setString(7, objLista.getTipoListaEspera());
            pst.setString(8, objLista.getClassificacao());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLista;
    }

    public ListaEsperaLaborativa alterarListaEspera(ListaEsperaLaborativa objLista) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LISTAESPERA SET StatusLanc=?,DataLanc=?,ObsLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=?,TipoListaEspera=?,Classificacao=? WHERE IdLanc='" + objLista.getIdLanc() + "'");
            pst.setString(1, objLista.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objLista.getDataLanc().getTime()));
            pst.setString(3, objLista.getObsLanc());
            pst.setString(4, objLista.getUsuarioUp());
            pst.setString(5, objLista.getDataUp());
            pst.setString(6, objLista.getHoraUp());
            pst.setString(7, objLista.getTipoListaEspera());
            pst.setString(8, objLista.getClassificacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLista;
    }

    public ListaEsperaLaborativa excluirListaEspera(ListaEsperaLaborativa objLista) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LISTAESPERA WHERE IdLanc='" + objLista.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objLista;
    }
}
