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
public class ControleFornecedoresNUTRI {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Fornecedor objForn = new Fornecedor();

    public Fornecedor incluirFornecedorNUTRI(Fornecedor objForn) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FORNECEDORES_AC (ClassFor,StatusFor,RazaoSocial,Cnpj,InsEstadual,Telefone,Telefone1,Celular,Email,Fax,Endereco,Compl,Cep,Cidade,Estado,EnderecoCob,ComplCob,CepCob,CidadeCob,EstadoCob,Modulo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
            pst.setString(21, objForn.getModulo());
            pst.setString(22, objForn.getUsuarioInsert());
            pst.setString(23, objForn.getDataInsert());
            pst.setString(24, objForn.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objForn;
    }

    public Fornecedor alterarFornecedorNUTRI(Fornecedor objForn) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FORNECEDORES_AC SET ClassFor=?,StatusFor=?,RazaoSocial=?,Cnpj=?,InsEstadual=?,Telefone=?,Telefone1=?,Celular=?,Email=?,Fax=?,Endereco=?,Compl=?,Cep=?,Cidade=?,Estado=?,EnderecoCob=?,ComplCob=?,CepCob=?,CidadeCob=?,EstadoCob=?,Modulo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdForn='" + objForn.getIdForn() + "'");
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
            pst.setString(21, objForn.getModulo());
            pst.setString(22, objForn.getUsuarioUp());
            pst.setString(23, objForn.getDataUp());
            pst.setString(24, objForn.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objForn;
    }

    public Fornecedor excluirFornecedorNUTRI(Fornecedor objForn) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FORNECEDORES_AC WHERE IdForn='" + objForn.getIdForn() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objForn;
    }
}
