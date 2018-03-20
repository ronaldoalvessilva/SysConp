/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.Colaborador;
import gestor.Modelo.UnidadePenal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class ControleUnidades {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    UnidadePenal objUniPen = new UnidadePenal();

    // Método para inserir PAIS
    public UnidadePenal incluirUnid(UnidadePenal objUniPen) throws SQLException {

        // Incluir Registro na tabela de UNIDADE PENAL
        conecta.abrirConexao();
        try (PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO UNIDADE (ClassUnid, DescricaoUnid,EnderecoUnid,"
                + "ComplementoUnid,BairroUnid,CidadeUnid,EstadoUnid,CepUnid,TelefoneUnid,FoneUnid,FaxUnid,ObsUnid) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)")) {
            pst.setString(1, objUniPen.getClassUnid());
            pst.setString(2, objUniPen.getDescricaoUnid());
            pst.setString(3, objUniPen.getEnderecoUnid());
            pst.setString(4, objUniPen.getComplementoUnid());
            pst.setString(5, objUniPen.getBairroUnid());
            pst.setString(6, objUniPen.getCidadeUnid());
            pst.setString(7, objUniPen.getEstadoUnid());
            pst.setString(8, objUniPen.getCepUnid());
            pst.setString(9, objUniPen.getTelefoneUnid());
            pst.setString(10, objUniPen.getFoneUnid());
            pst.setString(11, objUniPen.getFaxUnid());
            pst.setString(12, objUniPen.getObsUnid());
            pst.execute();
        }
        conecta.desconecta();
        return objUniPen;

    }

    //Método para Alterar Unidade Prisional

    public UnidadePenal alterarUnid(UnidadePenal objUniPen) throws SQLException {
        conecta.abrirConexao();
        // Alterar Registro na tabela de UNIDADE PENAL
        try (PreparedStatement pst = conecta.con.prepareStatement("UPDATE UNIDADE SET ClassUnid=?,DescricaoUnid=?, EnderecoUnid=?,"
                + "ComplementoUnid=?,BairroUnid=?,CidadeUnid=?,EstadoUnid=?,CepUnid=?,TelefoneUnid=?,FoneUnid=?,FaxUnid=?,ObsUnid=? WHERE IdUnid=?")) {                
            pst.setString(1, objUniPen.getClassUnid());
            pst.setString(2, objUniPen.getDescricaoUnid());
            pst.setString(3, objUniPen.getEnderecoUnid());
            pst.setString(4, objUniPen.getComplementoUnid());
            pst.setString(5, objUniPen.getBairroUnid());
            pst.setString(6, objUniPen.getCidadeUnid());
            pst.setString(7, objUniPen.getEstadoUnid());
            pst.setString(8, objUniPen.getCepUnid());
            pst.setString(9, objUniPen.getTelefoneUnid());
            pst.setString(10, objUniPen.getFoneUnid());
            pst.setString(11, objUniPen.getFaxUnid());
            pst.setString(12, objUniPen.getObsUnid());
            pst.setInt(13, objUniPen.getIdUnid());
            pst.executeUpdate();
        }
        conecta.desconecta();
        return objUniPen;
    }

    // Exclusão da UNIDADE PENAL
    public UnidadePenal excluirUnid(UnidadePenal objUniPen) throws SQLException {
        conecta.abrirConexao();      
        try (PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM UNIDADE WHERE IdUnid='" + objUniPen.getIdUnid() + "'")) {       
            pst.executeUpdate();
        }
        conecta.desconecta();
        return objUniPen;
    }
}
