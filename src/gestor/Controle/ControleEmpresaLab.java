/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EmpresaLab;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleEmpresaLab {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EmpresaLab objEmpLab = new EmpresaLab();

    public EmpresaLab incluirEmpresa(EmpresaLab objEmpLab) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EMPRESALAB (StatusEmp,DataCad,RazaoSocial,NomeFantasia,Cnpj,TipoEmpresa,InsEsta,Endereco,Cidade,Estado,Cep,Telefone,Telefone1,Contato,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objEmpLab.getStatusEmp());
            pst.setTimestamp(2, new java.sql.Timestamp(objEmpLab.getDataCad().getTime()));
            pst.setString(3, objEmpLab.getRazaosocial());
            pst.setString(4, objEmpLab.getNomeFantasia());
            pst.setString(5, objEmpLab.getCnpj());
            pst.setString(6, objEmpLab.getTipoEmpresa());
            pst.setString(7, objEmpLab.getInsEsta());
            pst.setString(8, objEmpLab.getEndereco());
            pst.setString(9, objEmpLab.getCidade());
            pst.setString(10, objEmpLab.getEstado());
            pst.setString(11, objEmpLab.getCep());
            pst.setString(12, objEmpLab.getTelefone());
            pst.setString(13, objEmpLab.getTelefone1());
            pst.setString(14, objEmpLab.getContato());
            pst.setString(15, objEmpLab.getUsuarioInsert());
            pst.setString(16, objEmpLab.getDataInsert());
            pst.setString(17, objEmpLab.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEmpLab;
    }

    public EmpresaLab alterarEmpresa(EmpresaLab objEmpLab) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EMPRESALAB SET StatusEmp=?,DataCad=?,RazaoSocial=?,NomeFantasia=?,Cnpj=?,TipoEmpresa=?,InsEsta=?,Endereco=?,Cidade=?,Estado=?,Cep=?,Telefone=?,Telefone1=?,Contato=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdEmp='" + objEmpLab.getIdEmp() + "'");
            pst.setString(1, objEmpLab.getStatusEmp());
            pst.setTimestamp(2, new java.sql.Timestamp(objEmpLab.getDataCad().getTime()));
            pst.setString(3, objEmpLab.getRazaosocial());
            pst.setString(4, objEmpLab.getNomeFantasia());
            pst.setString(5, objEmpLab.getCnpj());
            pst.setString(6, objEmpLab.getTipoEmpresa());
            pst.setString(7, objEmpLab.getInsEsta());
            pst.setString(8, objEmpLab.getEndereco());
            pst.setString(9, objEmpLab.getCidade());
            pst.setString(10, objEmpLab.getEstado());
            pst.setString(11, objEmpLab.getCep());
            pst.setString(12, objEmpLab.getTelefone());
            pst.setString(13, objEmpLab.getTelefone1());
            pst.setString(14, objEmpLab.getContato());
            pst.setString(15, objEmpLab.getUsuarioUp());
            pst.setString(16, objEmpLab.getDataUp());
            pst.setString(17, objEmpLab.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEmpLab;
    }

    public EmpresaLab excluirEmpresa(EmpresaLab objEmpLab) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EMPRESALAB WHERE IdEmp='" + objEmpLab.getIdEmp() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEmpLab;
    }
}
