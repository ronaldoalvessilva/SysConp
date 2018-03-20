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
 * @author Ronaldo
 */
public class ControleInclusaoListaEspera {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensListaEspera objItensLista = new ItensListaEspera();

    int codCurso, idInternoCrc, codOcupa;

    public ItensListaEspera incluirListaEsperaOcupa(ItensListaEspera objItensLista) {
        buscarOcupacao(objItensLista.getDescricaoOcupacao());
        buscarInterno(objItensLista.getNomeInterno(), objItensLista.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_OCUPACAO_LISTAESPERA (IdLanc,IdInternoCrc,IdCodigoOcupa,Encaminhamento) VALUES(?,?,?,?)");
            pst.setInt(1, objItensLista.getIdLanc());           
            pst.setInt(2, idInternoCrc);
            pst.setInt(3, codOcupa);
            pst.setString(4, objItensLista.getEncaminhamentoOcupa());           
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + e);
        }
        conecta.desconecta();
        return objItensLista;
    }

    public ItensListaEspera alterarListaEsperaOcupa(ItensListaEspera objItensLista) {
        buscarOcupacao(objItensLista.getDescricaoOcupacao());
        buscarInterno(objItensLista.getNomeInterno(), objItensLista.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_OCUPACAO_LISTAESPERA SET IdLanc=?,IdInternoCrc=?,IdCodigoOcupa=?,Encaminhamento=? WHERE IdItemOcupa='" + objItensLista.getIdItemOcupa() + "'");
            pst.setInt(1, objItensLista.getIdLanc());           
            pst.setInt(2, idInternoCrc);
            pst.setInt(3, codOcupa);
            pst.setString(4, objItensLista.getEncaminhamentoOcupa());           
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + e);
        }
        conecta.desconecta();
        return objItensLista;
    }

    public ItensListaEspera excluirListaEsperaOcupa(ItensListaEspera objItensLista) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_OCUPACAO_LISTAESPERA WHERE IdLanc='" + objItensLista.getIdLanc()+ "'AND IdInternoCrc='" + objItensLista.getIdInternoCrc() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados (ITENS_OCUPACAO_LISTAESPERA).\nERRO: " + e);
        }
        conecta.desconecta();
        return objItensLista;
    }

    //----------------------------- ***** CURSOS *****---------------------------------------------
    public ItensListaEspera incluirListaEsperaCurso(ItensListaEspera objItensLista) {
        buscarCursos(objItensLista.getDescricaoCurso());
        buscarInterno(objItensLista.getNomeInterno(), objItensLista.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_CURSOS_LISTAESPERA (IdLanc,IdInternoCrc,IdCurso,Encaminhamento) VALUES(?,?,?,?)");
            pst.setInt(1, objItensLista.getIdLanc());           
            pst.setInt(2, idInternoCrc);
            pst.setInt(3, codCurso);          
            pst.setString(4, objItensLista.getEncaminhamentoCurso());     
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + e);
        }
        conecta.desconecta();
        return objItensLista;
    }
 public ItensListaEspera alterarListaEsperaCurso(ItensListaEspera objItensLista) {
        buscarCursos(objItensLista.getDescricaoCurso());
        buscarInterno(objItensLista.getNomeInterno(), objItensLista.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_CURSOS_LISTAESPERA  SET IdLanc=?,IdItem=?,IdInternoCrc=?,IdCurso=?,Encaminhamento=? WHERE IdItemCursos'" + objItensLista.getIdItemCursos()  + "'");
            pst.setInt(1, objItensLista.getIdLanc());
            pst.setInt(2, objItensLista.getIdItemCursos());
            pst.setInt(3, idInternoCrc);
            pst.setInt(4, codCurso);            
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.\nERRO: " + e);
        }
        conecta.desconecta();
        return objItensLista;
    }
    public ItensListaEspera excluirListaEsperaCurso(ItensListaEspera objItensLista) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_CURSOS_LISTAESPERA WHERE IdLanc='" + objItensLista.getIdLanc()+ "'AND IdInternoCrc='" + objItensLista.getIdInternoCrc() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados (ITENS_CURSOS_LISTAESPERA).\nERRO: " + e);
        }
        conecta.desconecta();
        return objItensLista;
    }

    public void buscarOcupacao(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OCUPACAO WHERE DescricaoOcupa='" + desc + "'");
            conecta.rs.first();
            codOcupa = conecta.rs.getInt("IdCodigoOcupa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (OCUPAÇÃO) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarCursos(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CURSOS WHERE DescricaoCurso='" + nome + "'");
            conecta.rs.first();
            codCurso = conecta.rs.getInt("IdCurso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (CURSOS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarInterno(String nomeInterno, int codigoInterno) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + nomeInterno + "'AND IdInternoCrc='" + codigoInterno + "'");
            conecta.rs.first();
            idInternoCrc = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Existe dados (INTERNOS) a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
