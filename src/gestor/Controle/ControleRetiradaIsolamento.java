/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RetirarIsolamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleRetiradaIsolamento {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RetirarIsolamento objRetirar = new RetirarIsolamento();

    int codDocumento;
    int codFunc;
    int codNaturezaEvento;

    public RetirarIsolamento incluirRetiradaDisciplinar(RetirarIsolamento objRetirar) {
        pesquisarColaborador(objRetirar.getNomeColaborador());
        pesquisarNaturezaEvento(objRetirar.getDescricaoNatureza());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO RETIRADAINTERNO (StatusLanc,DataLanc,TipoReg,IdFunc,IdLanc,IdNatureza,Motivo,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objRetirar.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objRetirar.getDataLanc().getTime()));
            pst.setInt(3, objRetirar.getTipoRegistro());
            pst.setInt(4, codFunc);
            pst.setInt(5, objRetirar.getIdLanc());
            pst.setInt(6, codNaturezaEvento);
            pst.setString(7, objRetirar.getMotivo());
            pst.setString(8, objRetirar.getObservacao());
            pst.setString(9, objRetirar.getUsuarioInsert());
            pst.setString(10, objRetirar.getDataInsert());
            pst.setString(11, objRetirar.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRetirar;
    }

    public RetirarIsolamento alterarRetiradaDisciplinar(RetirarIsolamento objRetirar) {
        pesquisarColaborador(objRetirar.getNomeColaborador());
        pesquisarNaturezaEvento(objRetirar.getDescricaoNatureza());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETIRADAINTERNO SET StatusLanc=?,DataLanc=?,TipoReg=?,IdFunc=?,IdLanc=?,IdNatureza=?,Motivo=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLancRet='" + objRetirar.getIdLancRet() + "'");
            pst.setString(1, objRetirar.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objRetirar.getDataLanc().getTime()));
            pst.setInt(3, objRetirar.getTipoRegistro());
            pst.setInt(4, codFunc);
            pst.setInt(5, objRetirar.getIdLanc());
            pst.setInt(6, codNaturezaEvento);
            pst.setString(7, objRetirar.getMotivo());
            pst.setString(8, objRetirar.getObservacao());
            pst.setString(9, objRetirar.getUsuarioUp());
            pst.setString(10, objRetirar.getDataUp());
            pst.setString(11, objRetirar.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRetirar;
    }

    public RetirarIsolamento excluiRetiradaDisciplinar(RetirarIsolamento objRetirar) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM RETIRADAINTERNO WHERE IdLancRet='" + objRetirar.getIdLancRet() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel excluir os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRetirar;
    }

    public RetirarIsolamento finalizarRetiradaDisciplinar(RetirarIsolamento objRetirar) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE RETIRADAINTERNO SET StatusLanc=? WHERE IdLancRet='" + objRetirar.getIdLancRet() + "'");
            pst.setString(1, objRetirar.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel finalizar os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRetirar;
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

    public void pesquisarDocumento(int doc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGISTROEVENTOS WHERE NomeFunc='" + doc + "'");
            conecta.rs.first();
            codDocumento = conecta.rs.getInt("IdLanc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!.\nERRO: " + ex);
        }
        conecta.desconecta();
    }
    //-------------------------------------------- ROL DE VISITAS -------------------------------------------
    // Abrir Rol de Visitas do(s) Interno(s)

    public RetirarIsolamento abrirRolInternos(RetirarIsolamento objRetirar) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ROLVISITAS SET StatusRol=?,ObsRol=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdInternoCrc='" + objRetirar.getIdInternoCrc() + "'");
            pst.setString(1, objRetirar.getStatusRol());
            pst.setString(2, objRetirar.getObservacao());
            pst.setString(3, objRetirar.getUsuarioUp());
            pst.setString(4, objRetirar.getDataUp());
            pst.setString(5, objRetirar.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel finalizar Rol do Interno.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRetirar;
    }
}
