/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EmpresaUnidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleEmpresaUnidade {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EmpresaUnidade objEmpUni = new EmpresaUnidade();

    int codEmpresa;

    public EmpresaUnidade incluirUnidadeEmpresa(EmpresaUnidade objEmpUni) {
        buscarEmpresa(objEmpUni.getDescricaoEmpresa());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO UNIDADE_PENAL_EMPRESA (IdEmpresa,DescricaoUnidade,Endereco,Bairro,Cidade,Estado,Regime,CapacidadeMas,CapacidadeFen,CapacidadeTotal,UsuarioInsert,DataInsert,HorarioInsert,Sigla) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codEmpresa);
            pst.setString(2, objEmpUni.getDescricaoUnidade());
            pst.setString(3, objEmpUni.getEndereco());
            pst.setString(4, objEmpUni.getBairro());
            pst.setString(5, objEmpUni.getCidade());
            pst.setString(6, objEmpUni.getEstado());
            pst.setString(7, objEmpUni.getRegime());
            pst.setInt(8, objEmpUni.getCapacidadeMas());
            pst.setInt(9, objEmpUni.getCapacidadeFen());
            pst.setInt(10, objEmpUni.getCapacidadeTotal());
            pst.setString(11, objEmpUni.getUsuarioInsert());
            pst.setString(12, objEmpUni.getDataInsert());
            pst.setString(13, objEmpUni.getHorarioInsert());
            pst.setString(14, objEmpUni.getSigla());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objEmpUni;
    }

    public EmpresaUnidade alterarUnidadeEmpresa(EmpresaUnidade objEmpUni) {
        buscarEmpresa(objEmpUni.getDescricaoEmpresa());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE UNIDADE_PENAL_EMPRESA SET IdEmpresa=?,DescricaoUnidade=?,Endereco=?,Bairro=?,Cidade=?,Estado=?,Regime=?,CapacidadeMas=?,CapacidadeFen=?,CapacidadeTotal=?,UsuarioUp=?,DataUp=?,HorarioUp=?,Sigla=? WHERE IdUnidEmp='" + objEmpUni.getIdUnidEmp() + "'");
            pst.setInt(1, codEmpresa);
            pst.setString(2, objEmpUni.getDescricaoUnidade());
            pst.setString(3, objEmpUni.getEndereco());
            pst.setString(4, objEmpUni.getBairro());
            pst.setString(5, objEmpUni.getCidade());
            pst.setString(6, objEmpUni.getEstado());
            pst.setString(7, objEmpUni.getRegime());
            pst.setInt(8, objEmpUni.getCapacidadeMas());
            pst.setInt(9, objEmpUni.getCapacidadeFen());
            pst.setInt(10, objEmpUni.getCapacidadeTotal());
            pst.setString(11, objEmpUni.getUsuarioUp());
            pst.setString(12, objEmpUni.getDataUp());
            pst.setString(13, objEmpUni.getHorarioUp());
            pst.setString(14, objEmpUni.getSigla());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objEmpUni;
    }

    public EmpresaUnidade excluirUnidadeEmpresa(EmpresaUnidade objEmpUni) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM UNIDADE_PENAL_EMPRESA WHERE IdUnidEmp='" + objEmpUni.getIdUnidEmp() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados\n\nERRO:" + ex);
        }
        conecta.desconecta();
        return objEmpUni;
    }

    public void buscarEmpresa(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EMPRESA WHERE RazaoSocial='" + desc + "'");
            conecta.rs.first();
            codEmpresa = conecta.rs.getInt("IdEmpresa");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
