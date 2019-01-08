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
public class ControleRegimentoDisciplinarInterno {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroEventosIndisciplinar objRegEvenDisciplinar = new RegistroEventosIndisciplinar();

    int codNaturezaEvento;
    int codLocalEvento;
    int codFunc;
    int codInterno; // Pesquisar interno no rol para finalizar

    public RegistroEventosIndisciplinar incluirRegimentoDisciplinar(RegistroEventosIndisciplinar objRegEvenDisciplinar) {
        pesquisarColaborador(objRegEvenDisciplinar.getNomeColaborador());
        pesquisarNaturezaEvento(objRegEvenDisciplinar.getDescricaoNatureza());
        pesquisarLocalEvento(objRegEvenDisciplinar.getDescricaoLocalEvento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO REGIMENTO_DISCIPLINAR_INTERNOS (StatusReg,DataReg,HorarioEvento,IdFunc,IdNatureza,IdLocal,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objRegEvenDisciplinar.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objRegEvenDisciplinar.getDataLanc().getTime()));
            pst.setString(3, objRegEvenDisciplinar.getHorarioEvento());
            pst.setInt(4, codFunc);
            pst.setInt(5, codNaturezaEvento);
            pst.setInt(6, codLocalEvento);
            pst.setString(7, objRegEvenDisciplinar.getObservacao());
            pst.setString(8, objRegEvenDisciplinar.getUsuarioInsert());
            pst.setString(9, objRegEvenDisciplinar.getDataInsert());
            pst.setString(10, objRegEvenDisciplinar.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegEvenDisciplinar;
    }

    public RegistroEventosIndisciplinar alterarRegimentoDisciplinar(RegistroEventosIndisciplinar objRegEvenDisciplinar) {
        pesquisarColaborador(objRegEvenDisciplinar.getNomeColaborador());
        pesquisarNaturezaEvento(objRegEvenDisciplinar.getDescricaoNatureza());
        pesquisarLocalEvento(objRegEvenDisciplinar.getDescricaoLocalEvento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGIMENTO_DISCIPLINAR_INTERNOS SET StatusReg=?,DataReg=?,HorarioEvento=?,IdFunc=?,IdNatureza=?,IdLocal=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdReg='" + objRegEvenDisciplinar.getIdLanc() + "'");
            pst.setString(1, objRegEvenDisciplinar.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objRegEvenDisciplinar.getDataLanc().getTime()));
            pst.setString(3, objRegEvenDisciplinar.getHorarioEvento());
            pst.setInt(4, codFunc);
            pst.setInt(5, codNaturezaEvento);
            pst.setInt(6, codLocalEvento);
            pst.setString(7, objRegEvenDisciplinar.getObservacao());
            pst.setString(8, objRegEvenDisciplinar.getUsuarioUp());
            pst.setString(9, objRegEvenDisciplinar.getDataUp());
            pst.setString(10, objRegEvenDisciplinar.getHorarioUp());            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegEvenDisciplinar;
    }

    public RegistroEventosIndisciplinar excluirRegimentoDisciplinar(RegistroEventosIndisciplinar objRegEvenDisciplinar) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM REGIMENTO_DISCIPLINAR_INTERNOS WHERE IdReg='" + objRegEvenDisciplinar.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegEvenDisciplinar;
    }

    public RegistroEventosIndisciplinar finalizarRegimentoDisciplinar(RegistroEventosIndisciplinar objRegEvenDisciplinar) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE REGIMENTO_DISCIPLINAR_INTERNOS SET StatusReg=? WHERE IdReg='" + objRegEvenDisciplinar.getIdLanc() + "'");
            pst.setString(1, objRegEvenDisciplinar.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel finalizar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRegEvenDisciplinar;
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

    public void pesquisarColaborador(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR WHERE NomeFunc='" + nome + "'");
            conecta.rs.first();
            codFunc = conecta.rs.getInt("IdFunc");
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
    //-------------------------------------------- ROL DE VISITAS -------------------------------------------
    // Finalizar Rol de Visitas do(s) Interno(s)

    public RegistroEventosIndisciplinar finalizarEventoDisciplinarRol(RegistroEventosIndisciplinar objRegEvenDisciplinar) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ROLVISITAS SET StatusRol=?,ObsPortaria=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdInternoCrc='" + objRegEvenDisciplinar.getIdInternoCrc() + "'");
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
}
