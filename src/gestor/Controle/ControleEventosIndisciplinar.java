/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegistroEventosIndisciplinar;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleEventosIndisciplinar {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroEventosIndisciplinar objRegEvenDisciplinar = new RegistroEventosIndisciplinar();

    int codNaturezaEvento;
    int codLocalEvento;
    int codPavilhao;
    int codCela;
    int codInterno; // Pesquisar interno no rol para finalizar

    public RegistroEventosIndisciplinar incluirEventoDisciplinar(RegistroEventosIndisciplinar objRegEvenDisciplinar) {
        pesquisarNaturezaEvento(objRegEvenDisciplinar.getDescricaoNatureza());
        pesquisarLocalEvento(objRegEvenDisciplinar.getDescricaoLocalEvento());
        pesquisarPavilhao(objRegEvenDisciplinar.getDescricaoPavilhao());
        pesquisarCela(objRegEvenDisciplinar.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REGISTROEVENTOS (StatusLanc,DataLanc,HorarioEvento,IdNatureza,IdLocal,IdPav,IdCela,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objRegEvenDisciplinar.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objRegEvenDisciplinar.getDataLanc().getTime()));
            pst.setString(3, objRegEvenDisciplinar.getHorarioEvento());
            pst.setInt(4, codNaturezaEvento);
            pst.setInt(5, codLocalEvento);
            pst.setInt(6, codPavilhao);
            pst.setInt(7, codCela);
            pst.setString(8, objRegEvenDisciplinar.getObservacao());
            pst.setString(9, objRegEvenDisciplinar.getUsuarioInsert());
            pst.setString(10, objRegEvenDisciplinar.getDataInsert());
            pst.setString(11, objRegEvenDisciplinar.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegEvenDisciplinar;
    }

    public RegistroEventosIndisciplinar alterarEventoDisciplinar(RegistroEventosIndisciplinar objRegEvenDisciplinar) {
        pesquisarNaturezaEvento(objRegEvenDisciplinar.getDescricaoNatureza());
        pesquisarLocalEvento(objRegEvenDisciplinar.getDescricaoLocalEvento());
        pesquisarPavilhao(objRegEvenDisciplinar.getDescricaoPavilhao());
        pesquisarCela(objRegEvenDisciplinar.getDescricaoCela());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTROEVENTOS SET StatusLanc=?,DataLanc=?,HorarioEvento=?,IdNatureza=?,IdLocal=?,IdPav=?,IdCela=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objRegEvenDisciplinar.getIdLanc() + "'");
            pst.setString(1, objRegEvenDisciplinar.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objRegEvenDisciplinar.getDataLanc().getTime()));
            pst.setString(3, objRegEvenDisciplinar.getHorarioEvento());
            pst.setInt(4, codNaturezaEvento);
            pst.setInt(5, codLocalEvento);
            pst.setInt(6, codPavilhao);
            pst.setInt(7, codCela);
            pst.setString(8, objRegEvenDisciplinar.getObservacao());
            pst.setString(9, objRegEvenDisciplinar.getUsuarioUp());
            pst.setString(10, objRegEvenDisciplinar.getDataUp());
            pst.setString(11, objRegEvenDisciplinar.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegEvenDisciplinar;
    }

    public RegistroEventosIndisciplinar excluirEventoDisciplinar(RegistroEventosIndisciplinar objRegEvenDisciplinar) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REGISTROEVENTOS WHERE IdLanc='" + objRegEvenDisciplinar.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegEvenDisciplinar;
    }

    public RegistroEventosIndisciplinar finalizarEventoDisciplinar(RegistroEventosIndisciplinar objRegEvenDisciplinar) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGISTROEVENTOS SET StatusLanc=? WHERE IdLanc='" + objRegEvenDisciplinar.getIdLanc() + "'");
            pst.setString(1, objRegEvenDisciplinar.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel finalizar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegEvenDisciplinar;
    }
    //-------------------------------------------- ROL DE VISITAS -------------------------------------------
    // Finalizar Rol de Visitas do(s) Interno(s)

    public RegistroEventosIndisciplinar finalizarEventoDisciplinarRol(RegistroEventosIndisciplinar objRegEvenDisciplinar) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ROLVISITAS SET StatusRol=?,ObsRol=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdInternoCrc='" + objRegEvenDisciplinar.getIdInternoCrc() + "'");
            pst.setString(1, objRegEvenDisciplinar.getStatusLanc());
            pst.setString(2, objRegEvenDisciplinar.getObservacao());
            pst.setString(3, objRegEvenDisciplinar.getUsuarioUp());
            pst.setString(4, objRegEvenDisciplinar.getDataUp());
            pst.setString(5, objRegEvenDisciplinar.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel finalizar Rol do Interno.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegEvenDisciplinar;
    }

    public void pesquisarPavilhao(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO WHERE DescricaoPav='" + nome + "'");
            conecta.rs.first();
            codPavilhao = conecta.rs.getInt("IdPav");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void pesquisarCela(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CELAS WHERE EndCelaPav='" + nome + "'");
            conecta.rs.first();
            codCela = conecta.rs.getInt("IdCela");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void pesquisarNaturezaEvento(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM NATUREZAEVENTOS WHERE DescricaoNatureza='" + nome + "'");
            conecta.rs.first();
            codNaturezaEvento = conecta.rs.getInt("IdNatureza");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void pesquisarLocalEvento(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOCALEVENTOS WHERE DescricaoLocal='" + nome + "'");
            conecta.rs.first();
            codLocalEvento = conecta.rs.getInt("IdLocal");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void pesquisarInternoRol(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nome + "'");
            conecta.rs.first();
            codInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
}
