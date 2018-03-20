/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Professores;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleProfessores {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Professores objProf = new Professores();
    int codUnid;

    public Professores incluirProfessor(Professores objProf) {
        buscarInstituicao(objProf.getDescricaoInstituicao());      
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PROFESSORES "
                    + "(NomeProfessor,StatusProf,FotoProf,DataNascProf,EstadoCivil,SexoProf,"
                    + "Telefone,Celular,Celular1,IdCod,Cep,Endereco,Bairro,Cidade,Estado,"
                    + "Graduacao,Especialidade,Mestrado,Doutorado,Observacao,"
                    + "UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objProf.getNomeProfessor());
            pst.setString(2, objProf.getStatusProf());
            pst.setString(3, objProf.getFotoProf());
            pst.setTimestamp(4, new java.sql.Timestamp(objProf.getDataNascProf().getTime()));
            pst.setString(5, objProf.getEstadoCivil());
            pst.setString(6, objProf.getSexoProf());
            pst.setString(7, objProf.getTelefone());
            pst.setString(8, objProf.getCelular());
            pst.setString(9, objProf.getCelular1());
            pst.setInt(10, codUnid);
            pst.setString(11, objProf.getCep());
            pst.setString(12, objProf.getEndereco());
            pst.setString(13, objProf.getBairro());
            pst.setString(14, objProf.getCidade());
            pst.setString(15, objProf.getEstado());
            pst.setString(16, objProf.getGraduacao());
            pst.setString(17, objProf.getEspecialidade());
            pst.setString(18, objProf.getMestrado());
            pst.setString(19, objProf.getDoutorado());
            pst.setString(20, objProf.getObservacao());                      
            pst.setString(21, objProf.getUsuarioInsert());
            pst.setString(22, objProf.getDataInsert());
            pst.setString(23, objProf.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados do (PROFESSOR)\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objProf;
    }

    public Professores alterarProfessor(Professores objProf) {
        buscarInstituicao(objProf.getDescricaoInstituicao());   
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PROFESSORES SET "
                    + "NomeProfessor=?,StatusProf=?,FotoProf=?,DataNascProf=?,EstadoCivil=?,SexoProf=?,"
                    + "Telefone=?,Celular=?,Celular1=?,IdCod=?,Cep=?,Endereco=?,Bairro=?,Cidade=?,Estado=?,"
                    + "Graduacao=?,Especialidade=?,Mestrado=?,Doutorado=?,Observacao=?,"
                    + "UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdProf='" + objProf.getIdProf() + "'");
            pst.setString(1, objProf.getNomeProfessor());
            pst.setString(2, objProf.getStatusProf());
            pst.setString(3, objProf.getFotoProf());
            pst.setTimestamp(4, new java.sql.Timestamp(objProf.getDataNascProf().getTime()));
            pst.setString(5, objProf.getEstadoCivil());
            pst.setString(6, objProf.getSexoProf());
            pst.setString(7, objProf.getTelefone());
            pst.setString(8, objProf.getCelular());
            pst.setString(9, objProf.getCelular1());
            pst.setInt(10, codUnid);
            pst.setString(11, objProf.getCep());
            pst.setString(12, objProf.getEndereco());
            pst.setString(13, objProf.getBairro());
            pst.setString(14, objProf.getCidade());
            pst.setString(15, objProf.getEstado());
            pst.setString(16, objProf.getGraduacao());
            pst.setString(17, objProf.getEspecialidade());
            pst.setString(18, objProf.getMestrado());
            pst.setString(19, objProf.getDoutorado());
            pst.setString(20, objProf.getObservacao());                      
            pst.setString(21, objProf.getUsuarioUp());
            pst.setString(22, objProf.getDataUp());
            pst.setString(23, objProf.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados do (PROFESSOR)\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objProf;
    }

    public Professores excluirProfessor(Professores objProf) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PROFESSORES WHERE IdProf='" + objProf.getIdProf() + "'");           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados do (PROFESSOR)\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objProf;
    }

    public void buscarInstituicao(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INSTITUICAOESCOLAR WHERE NomeInstituicao='" + desc + "'");
            conecta.rs.first();
            codUnid = conecta.rs.getInt("IdCod");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INSTITUIÇÃO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }   
}
