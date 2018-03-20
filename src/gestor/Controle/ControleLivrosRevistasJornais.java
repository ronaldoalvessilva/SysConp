/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.LivrosRevistasJornais;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleLivrosRevistasJornais {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    LivrosRevistasJornais objLivros = new LivrosRevistasJornais();

    int codEditor, codCategoria, codLocal;

    public LivrosRevistasJornais incluirLivrosRevistasJornais(LivrosRevistasJornais objLivros) {
        buscarEditor(objLivros.getNomeEditora());
        buscarCategoria(objLivros.getDescricaoCategoria());
        buscarLocal(objLivros.getDescricaoLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LIVROS_REVISTAS_JORNAIS (StatusLivro,TipoLivro,TituloLivro,IdForn,CodigoBarra,PrazoEmp,Idioma,DataAquisicao,IdCat,ISBN,Volume,Edicao,Paginas,IdLocal,Observacao,Foto1,Foto2,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objLivros.getStatusLivro());
            pst.setString(2, objLivros.getTipoLivro());
            pst.setString(3, objLivros.getTituloLivro());
            pst.setInt(4, codEditor);
            pst.setString(5, objLivros.getCodigoBarra());
            pst.setInt(6, objLivros.getPrazoEmp());
            pst.setString(7, objLivros.getIdioma());
            if (objLivros.getDataAquisicao() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objLivros.getDataAquisicao().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setInt(9, codCategoria);
            pst.setString(10, objLivros.getiSBN());
            pst.setString(11, objLivros.getVolume());
            pst.setString(12, objLivros.getEdicao());
            pst.setString(13, objLivros.getPaginas());
            pst.setInt(14, codLocal);
            pst.setString(15, objLivros.getObservacao());
            pst.setString(16, objLivros.getFoto1());
            pst.setString(17, objLivros.getFoto2());
            pst.setString(18, objLivros.getUsuarioInsert());
            pst.setString(19, objLivros.getDataInsert());
            pst.setString(20, objLivros.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLivros;
    }

    public LivrosRevistasJornais alterarLivrosRevistasJornais(LivrosRevistasJornais objLivros) {
        buscarEditor(objLivros.getNomeEditora());
        buscarCategoria(objLivros.getDescricaoCategoria());
        buscarLocal(objLivros.getDescricaoLocal());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LIVROS_REVISTAS_JORNAIS SET StatusLivro=?,TipoLivro=?,TituloLivro=?,IdForn=?,CodigoBarra=?,PrazoEmp=?,Idioma=?,DataAquisicao=?,IdCat=?,ISBN=?,Volume=?,Edicao=?,Paginas=?,IdLocal=?,Observacao=?,Foto1=?,Foto2=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLivro='" + objLivros.getIdLivro() + "'");
            pst.setString(1, objLivros.getStatusLivro());
            pst.setString(2, objLivros.getTipoLivro());
            pst.setString(3, objLivros.getTituloLivro());
            pst.setInt(4, codEditor);
            pst.setString(5, objLivros.getCodigoBarra());
            pst.setInt(6, objLivros.getPrazoEmp());
            pst.setString(7, objLivros.getIdioma());
            if (objLivros.getDataAquisicao() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objLivros.getDataAquisicao().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setInt(9, codCategoria);
            pst.setString(10, objLivros.getiSBN());
            pst.setString(11, objLivros.getVolume());
            pst.setString(12, objLivros.getEdicao());
            pst.setString(13, objLivros.getPaginas());
            pst.setInt(14, codLocal);
            pst.setString(15, objLivros.getObservacao());
            pst.setString(16, objLivros.getFoto1());
            pst.setString(17, objLivros.getFoto2());
            pst.setString(18, objLivros.getUsuarioUp());
            pst.setString(19, objLivros.getDataUp());
            pst.setString(20, objLivros.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLivros;
    }

    public LivrosRevistasJornais excluirLivrosRevistasJornais(LivrosRevistasJornais objLivros) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LIVROS_REVISTAS_JORNAIS WHERE IdLivro='" + objLivros.getIdLivro() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objLivros;
    }

    public void buscarEditor(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EDITORAS_INSTITUICAO WHERE RazaoSocial='" + nome + "'");
            conecta.rs.first();
            codEditor = conecta.rs.getInt("IdForn");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar a editora solicitada." + e);
        }
    }

    public void buscarCategoria(String descCategoria) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CATEGORIA_LIVROS WHERE DescricaoCategoria='" + descCategoria + "'");
            conecta.rs.first();
            codCategoria = conecta.rs.getInt("IdCat");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar a categoria solicitada." + e);
        }
    }

    public void buscarLocal(String descLocal) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOCAL_ACERVO WHERE DescricaoLocal='" + descLocal + "'");
            conecta.rs.first();
            codLocal = conecta.rs.getInt("IdLocal");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o local solicitado." + e);
        }
    }
}
