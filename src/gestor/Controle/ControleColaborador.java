/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Cargos;
import gestor.Modelo.Departamentos;
import gestor.Modelo.Funcionarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleColaborador {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Cargos objCargo = new Cargos();
    Departamentos objDepto = new Departamentos();
    Funcionarios objCola = new Funcionarios();
    int codCargo;
    int codDepto;

    public Funcionarios incluirColaborador(Funcionarios objCola) {
        buscarCargo(objCola.getNomeCargo()); // Pesquisa o ID do CARGO
        buscarDepto(objCola.getNomeDepartamento()); // Pesquisa o ID do DEPARTAMENTO
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO COLABORADOR (StatusFunc,DataCadFunc,NomeFunc,MatriculaFunc,SexoFunc,EscolaFunc,EstadoCivil,DataNascimento,ImagemFunc,NomeMae,NomePai,Religiao,TipoSangue,IdCargo,IdDepartamento,CargaHoraria,RegimeTrabalho,HorarioInicio,HorarioFinal,Funcao,Nacionalidade,Pais,Naturalidade,EstadoNaturalidade,UsuarioInsert,DataInsert,HorarioInsert,ImagemFrenteCO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCola.getStatusFunc());
            pst.setTimestamp(2, new java.sql.Timestamp(objCola.getDataCadastro().getTime()));
            pst.setString(3, objCola.getNomeFuncionario());
            pst.setString(4, objCola.getMatricula());
            pst.setString(5, objCola.getSexo());
            pst.setString(6, objCola.getEscolaridade());
            pst.setString(7, objCola.getEstadoCivil());
            if (objCola.getDataNascimento() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objCola.getDataNascimento().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objCola.getFoto());
            pst.setString(10, objCola.getNomeMae());
            pst.setString(11, objCola.getNomePai());
            pst.setString(12, objCola.getReligiao());
            pst.setString(13, objCola.getTipoSangue());
            pst.setInt(14, codCargo);
            pst.setInt(15, codDepto);
            pst.setString(16, objCola.getCargaHoraria());
            pst.setString(17, objCola.getRegimeTrabalho());
            pst.setString(18, objCola.getHorarioInicio());
            pst.setString(19, objCola.getHorarioFinal());
            pst.setString(20, objCola.getFuncao());
            pst.setString(21, objCola.getNacionalidade());
            pst.setString(22, objCola.getPais());
            pst.setString(23, objCola.getNaturalidade());
            pst.setString(24, objCola.getEstadoNacionalidade());
            pst.setString(25, objCola.getUsuarioInsert());
            pst.setString(26, objCola.getDataInsert());
            pst.setString(27, objCola.getHorarioInsert());
            pst.setBytes(28, objCola.getImagemFrenteCO());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados.(COLABORADOR)\nERRO" + ex);
        }
        conecta.desconecta();
        return objCola;
    }

    public Funcionarios alterarColaborador(Funcionarios objCola) {
        buscarCargo(objCola.getNomeCargo()); // Pesquisa o ID do CARGO
        buscarDepto(objCola.getNomeDepartamento()); // Pesquisa o ID do DEPARTAMENTO
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COLABORADOR  SET StatusFunc=?,DataCadFunc=?,NomeFunc=?,MatriculaFunc=?,SexoFunc=?,EscolaFunc=?,EstadoCivil=?,DataNascimento=?,ImagemFunc=?,NomeMae=?,NomePai=?,Religiao=?,TipoSangue=?,IdCargo=?,IdDepartamento=?,CargaHoraria=?,RegimeTrabalho=?,HorarioInicio=?,HorarioFinal=?,Funcao=?,Nacionalidade=?,Pais=?,Naturalidade=?,EstadoNaturalidade=?,UsuarioUp=?,DataUp=?,HorarioUp=?,ImagemFrenteCO=? WHERE IdFunc='" + objCola.getIdFunc() + "'");
            pst.setString(1, objCola.getStatusFunc());
            pst.setTimestamp(2, new java.sql.Timestamp(objCola.getDataCadastro().getTime()));
            pst.setString(3, objCola.getNomeFuncionario());
            pst.setString(4, objCola.getMatricula());
            pst.setString(5, objCola.getSexo());
            pst.setString(6, objCola.getEscolaridade());
            pst.setString(7, objCola.getEstadoCivil());
            if (objCola.getDataNascimento() != null) {
                pst.setTimestamp(8, new java.sql.Timestamp(objCola.getDataNascimento().getTime()));
            } else {
                pst.setDate(8, null);
            }
            pst.setString(9, objCola.getFoto());
            pst.setString(10, objCola.getNomeMae());
            pst.setString(11, objCola.getNomePai());
            pst.setString(12, objCola.getReligiao());
            pst.setString(13, objCola.getTipoSangue());
            pst.setInt(14, codCargo);
            pst.setInt(15, codDepto);
            pst.setString(16, objCola.getCargaHoraria());
            pst.setString(17, objCola.getRegimeTrabalho());
            pst.setString(18, objCola.getHorarioInicio());
            pst.setString(19, objCola.getHorarioFinal());
            pst.setString(20, objCola.getFuncao());
            pst.setString(21, objCola.getNacionalidade());
            pst.setString(22, objCola.getPais());
            pst.setString(23, objCola.getNaturalidade());
            pst.setString(24, objCola.getEstadoNacionalidade());
            pst.setString(25, objCola.getUsuarioUp());
            pst.setString(26, objCola.getDataUp());
            pst.setString(27, objCola.getHorarioUp());
            pst.setBytes(28, objCola.getImagemFrenteCO());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCola;
    }

    public Funcionarios excluirColaborador(Funcionarios objCola) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst;
            pst = conecta.con.prepareStatement("DELETE FROM COLABORADOR WHERE IdFunc='" + objCola.getIdFunc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCola;
    }

    // Pesquisar CARGO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
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

    // Pesquisar DEPARTAMENTO do Colaborador para gravar na tabela de FUNCIONÁRIOS SIMPLES
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
