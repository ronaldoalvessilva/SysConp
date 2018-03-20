/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Cargos;
import gestor.Modelo.Cidades;
import gestor.Modelo.Colaborador;
import gestor.Modelo.Departamentos;
import gestor.Modelo.Dependentes;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo Alves da Silva
 */
public class ControleFuncionarios {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Colaborador objCola = new Colaborador();
    Cidades objCida = new Cidades();
    Cargos objCargo = new Cargos();
    Departamentos objDepto = new Departamentos();
    Dependentes objDepen = new Dependentes();
    int codCidade;
    int codCargo;
    int codDepto;
    int codFunc;

    // Método para inserir PAIS
    public Colaborador incluirFunc(Colaborador objCola) throws SQLException {

        buscarCidade(objCola.getNomeCidade()); // Pesquisa o ID  da CIDADE
        buscarCargo(objCola.getNomeCargo()); // Pesquisa o ID do CARGO
        buscarDepto(objCola.getNomeDepartamento()); // Pesquisa o ID do DEPARTAMENTO
        conecta.abrirConexao();
        // Incluir Registro na tabela de FUNCIONÁRIOS
        try (PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FUNCIONARIOS (MatFunc, NomeFunc,DataCadFunc,DataNascFunc,"
                + "EstadoCivilFunc,SexoFunc,EscolaFunc,ReligiaoFunc,TipoSangFunc,MaeFunc,PaiFunc,ConjuFunc,DataNascConju,ImagemFunc,"
                + "IdCidade,IdCargo,IdDepartamento) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
            pst.setInt(1, objCola.getMatFunc());
            pst.setString(2, objCola.getNomeFunc());
            pst.setTimestamp(3, new java.sql.Timestamp(objCola.getDataCadFun().getTime()));
            pst.setTimestamp(4, new java.sql.Timestamp(objCola.getDataNascFunc().getTime()));            
            pst.setString(5, objCola.getEstadoCivilFunc());
            pst.setString(6, objCola.getSexoFunc());
            pst.setString(7, objCola.getEscolaFunc());
            pst.setString(8, objCola.getReligiaoFunc());
            pst.setString(9, objCola.getTipoSangFunc());
            pst.setString(10, objCola.getMaeFunc());
            pst.setString(11, objCola.getPaiFunc());
            pst.setString(12, objCola.getConjuFunc());
            pst.setTimestamp(13, new java.sql.Timestamp(objCola.getDataNasCon().getTime()));
            pst.setString(14, objCola.getFoto());
            pst.setInt(15, codCidade);
            pst.setInt(16, codCargo);
            pst.setInt(17, codDepto);            
            pst.execute();
        }
        conecta.desconecta();
        return objCola;

    }

    //Método para Alterar Funcionário
    public Colaborador alterarFunc(Colaborador objCola) throws SQLException {
        buscarCidade(objCola.getNomeCidade()); // Pesquisa o ID  da CIDADE
        buscarCargo(objCola.getNomeCargo()); // Pesquisa o ID do CARGO
        buscarDepto(objCola.getNomeDepartamento()); // Pesquisa o ID do DEPARTAMENTO
        conecta.abrirConexao();
        // Alterar Registro na tabela de FUNCIONÁRIOS
        try (PreparedStatement pst = conecta.con.prepareStatement("UPDATE FUNCIONARIOS SET NomeFunc=?,MatFunc=?, DataCadFunc=?,DataNascFunc=?,"
                + "EstadoCivilFunc=?,SexoFunc=?,ImagemFunc=?,EscolaFunc=?,ReligiaoFunc=?,TipoSangFunc=?,MaeFunc=?,PaiFunc=?,ConjuFunc=?,DataNascConju=?,"
                + "IdCidade=?,IdCargo=?,IdDepartamento=? WHERE IdFunc=?")) {
            pst.setString(1, objCola.getNomeFunc());
            pst.setInt(2, objCola.getMatFunc());
            pst.setTimestamp(3, new java.sql.Timestamp(objCola.getDataCadFun().getTime()));
            pst.setTimestamp(4, new java.sql.Timestamp(objCola.getDataNascFunc().getTime()));
            pst.setString(5, objCola.getEstadoCivilFunc());
            pst.setString(6, objCola.getSexoFunc());
            pst.setString(7, objCola.getFoto());
            pst.setString(8, objCola.getEscolaFunc());
            pst.setString(9, objCola.getReligiaoFunc());
            pst.setString(10, objCola.getTipoSangFunc());
            pst.setString(11, objCola.getMaeFunc());
            pst.setString(12, objCola.getPaiFunc());
            pst.setString(13, objCola.getConjuFunc());
            pst.setTimestamp(14, new java.sql.Timestamp(objCola.getDataNasCon().getTime()));
            pst.setInt(15, codCidade);
            pst.setInt(16, codCargo);
            pst.setInt(17, codDepto);
            pst.setInt(18, objCola.getIdFunc());
            pst.executeUpdate();
        }
        conecta.desconecta();
        return objCola;
    }
// Excluir COLABORADOR

    public Colaborador excluirFunc(Colaborador objCola) throws SQLException {
        conecta.abrirConexao();
        //  conecta.rs.first();
        try (PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FUNCIONARIOS WHERE IdFunc='" + objCola.getIdFunc() + "'")) {
// Foi retirado o comando abaixo, pois o paramentro está sendo passado com o objeto (objCola.getIdFunc)         
// Está funcioandndo, ou seja, excluindo o registro.            
//   pst.setInt(1, objCola.getIdFunc());
            pst.executeUpdate();
        }
        conecta.desconecta();
        return objCola;
    }

    // Pesquisar CIDADE do Colaborador para gravar na tabela de FUNCIONARIOS (INSERT)
    public void buscarCidade(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CIDADES WHERE NomeCidade='" + nome + "'");
            conecta.rs.first();
            codCidade = conecta.rs.getInt("IdCidade");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    // Pesquisar CARGO do Colaborador para gravar na tabela de FUNCIONÁRIOS
    public void buscarCargo(String nome) {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CARGOS WHERE NomeCargo='" + nome + "'");
            conecta.rs.first();
            codCargo = conecta.rs.getInt("IdCargo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    // Pesquisar DEPARTAMENTO do Colaborador para gravar na tabela de FUNCIONÁRIOS
    public void buscarDepto(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + nome + "'");
            conecta.rs.first();
            codDepto = conecta.rs.getInt("IdDepartamento");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
