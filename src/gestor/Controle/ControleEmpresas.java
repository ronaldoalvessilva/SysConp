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
public class ControleEmpresas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Fornecedor objForn = new Fornecedor();

    public Fornecedor incluirEmpresa(Fornecedor objForn) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EMPRESA (StatusFor,DataCadastro,RazaoSocial,NomeFantasia,Cnpj,InsEstadual,NomeContato,Telefone,Telefone1,Celular,Email,Fax,Endereco,Compl,Cep,Cidade,Estado,EnderecoCob,ComplCob,CepCob,CidadeCob,EstadoCob,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objForn.getStatusFor());
            pst.setTimestamp(2, new java.sql.Timestamp(objForn.getDataCadastro().getTime()));
            pst.setString(3, objForn.getRazaoSocial());
            pst.setString(4, objForn.getNomeFantasia());
            pst.setString(5, objForn.getCnpj());
            pst.setString(6, objForn.getInsEstadual());
            pst.setString(7, objForn.getNomeContato());
            pst.setString(8, objForn.getTelefone());
            pst.setString(9, objForn.getTelefone1());
            pst.setString(10, objForn.getCelular());
            pst.setString(11, objForn.getEmail());
            pst.setString(12, objForn.getFax());
            pst.setString(13, objForn.getEndereco());
            pst.setString(14, objForn.getCompl());
            pst.setString(15, objForn.getCep());
            pst.setString(16, objForn.getCidade());
            pst.setString(17, objForn.getEstado());
            pst.setString(18, objForn.getEnderecoCob());
            pst.setString(19, objForn.getComplCob());
            pst.setString(20, objForn.getCepCob());
            pst.setString(21, objForn.getCidadeCob());
            pst.setString(22, objForn.getEstadoCob());
            pst.setString(23, objForn.getUsuarioInsert());
            pst.setString(24, objForn.getDataInsert());
            pst.setString(25, objForn.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objForn;
    }

    public Fornecedor alterarEmpresa(Fornecedor objForn) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EMPRESA SET StatusFor=?,DataCadastro=?,RazaoSocial=?,NomeFantasia=?,Cnpj=?,InsEstadual=?,NomeContato=?,Telefone=?,Telefone1=?,Celular=?,Email=?,Fax=?,Endereco=?,Compl=?,Cep=?,Cidade=?,Estado=?,EnderecoCob=?,ComplCob=?,CepCob=?,CidadeCob=?,EstadoCob=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEmpresa='" + objForn.getIdForn() + "'");
            pst.setString(1, objForn.getStatusFor());
            pst.setTimestamp(2, new java.sql.Timestamp(objForn.getDataCadastro().getTime()));
            pst.setString(3, objForn.getRazaoSocial());
            pst.setString(4, objForn.getNomeFantasia());
            pst.setString(5, objForn.getCnpj());
            pst.setString(6, objForn.getInsEstadual());
            pst.setString(7, objForn.getNomeContato());
            pst.setString(8, objForn.getTelefone());
            pst.setString(9, objForn.getTelefone1());
            pst.setString(10, objForn.getCelular());
            pst.setString(11, objForn.getEmail());
            pst.setString(12, objForn.getFax());
            pst.setString(13, objForn.getEndereco());
            pst.setString(14, objForn.getCompl());
            pst.setString(15, objForn.getCep());
            pst.setString(16, objForn.getCidade());
            pst.setString(17, objForn.getEstado());
            pst.setString(18, objForn.getEnderecoCob());
            pst.setString(19, objForn.getComplCob());
            pst.setString(20, objForn.getCepCob());
            pst.setString(21, objForn.getCidadeCob());
            pst.setString(22, objForn.getEstadoCob());
            pst.setString(23, objForn.getUsuarioUp());
            pst.setString(24, objForn.getDataUp());
            pst.setString(25, objForn.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objForn;
    }

    public Fornecedor excluirEmpresa(Fornecedor objForn) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EMPRESA WHERE IdForn='" + objForn.getIdForn() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objForn;
    }
}
