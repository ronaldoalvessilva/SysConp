/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleEditoresInstituicao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Fornecedor objForn = new Fornecedor();

    public Fornecedor incluirFornecedor(Fornecedor objForn) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EDITORAS_INSTITUICAO (ClassFor,StatusFor,RazaoSocial,Cnpj,InsEstadual,Telefone,Telefone1,Celular,Email,Fax,Endereco,Compl,Cep,Cidade,Estado,EnderecoCob,ComplCob,CepCob,CidadeCob,EstadoCob,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objForn.getClassFor());
            pst.setString(2, objForn.getStatusFor());
            pst.setString(3, objForn.getRazaoSocial());
            pst.setString(4, objForn.getCnpj());
            pst.setString(5, objForn.getInsEstadual());
            pst.setString(6, objForn.getTelefone());
            pst.setString(7, objForn.getTelefone1());
            pst.setString(8, objForn.getCelular());
            pst.setString(9, objForn.getEmail());
            pst.setString(10, objForn.getFax());
            pst.setString(11, objForn.getEndereco());
            pst.setString(12, objForn.getCompl());
            pst.setString(13, objForn.getCep());
            pst.setString(14, objForn.getCidade());
            pst.setString(15, objForn.getEstado());
            pst.setString(16, objForn.getEnderecoCob());
            pst.setString(17, objForn.getComplCob());
            pst.setString(18, objForn.getCepCob());
            pst.setString(19, objForn.getCidadeCob());
            pst.setString(20, objForn.getEstadoCob());
            pst.setString(21, objForn.getUsuarioInsert());
            pst.setString(22, objForn.getDataInsert());
            pst.setString(23, objForn.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objForn;
    }

    public Fornecedor alterarFornecedor(Fornecedor objForn) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EDITORAS_INSTITUICAO SET ClassFor=?,StatusFor=?,RazaoSocial=?,Cnpj=?,InsEstadual=?,Telefone=?,Telefone1=?,Celular=?,Email=?,Fax=?,Endereco=?,Compl=?,Cep=?,Cidade=?,Estado=?,EnderecoCob=?,ComplCob=?,CepCob=?,CidadeCob=?,EstadoCob=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdForn='" + objForn.getIdForn() + "'");
            pst.setString(1, objForn.getClassFor());
            pst.setString(2, objForn.getStatusFor());
            pst.setString(3, objForn.getRazaoSocial());
            pst.setString(4, objForn.getCnpj());
            pst.setString(5, objForn.getInsEstadual());
            pst.setString(6, objForn.getTelefone());
            pst.setString(7, objForn.getTelefone1());
            pst.setString(8, objForn.getCelular());
            pst.setString(9, objForn.getEmail());
            pst.setString(10, objForn.getFax());
            pst.setString(11, objForn.getEndereco());
            pst.setString(12, objForn.getCompl());
            pst.setString(13, objForn.getCep());
            pst.setString(14, objForn.getCidade());
            pst.setString(15, objForn.getEstado());
            pst.setString(16, objForn.getEnderecoCob());
            pst.setString(17, objForn.getComplCob());
            pst.setString(18, objForn.getCepCob());
            pst.setString(19, objForn.getCidadeCob());
            pst.setString(20, objForn.getEstadoCob());
            pst.setString(21, objForn.getUsuarioUp());
            pst.setString(22, objForn.getDataUp());
            pst.setString(23, objForn.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objForn;
    }

    public Fornecedor excluirFornecedor(Fornecedor objForn) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EDITORAS_INSTITUICAO WHERE IdForn='" + objForn.getIdForn() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objForn;
    }
}
