/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEntradaVeiculoUnidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensEntradaSaidaVeiculosUnidade {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaVeiculoUnidade objItensVeiUid = new ItensEntradaVeiculoUnidade();
    int codFunc;
    int codVeiculo;

    public ItensEntradaVeiculoUnidade incluirEntSaiVeiculoUnidade(ItensEntradaVeiculoUnidade objItensVeiUid) {
        buscarColaborador(objItensVeiUid.getNomeColaborador(), objItensVeiUid.getIdFunc());
        buscarVeiculo(objItensVeiUid.getModeloVeiculo(), objItensVeiUid.getIdVeiculo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSVEICULOSUNIDADE (IdFunc,Idlanc,IdVeiculo,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida,KmInicial,KmFinal,DestinoEntrada,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, codFunc);
            pst.setInt(2, objItensVeiUid.getIdlanc());
            pst.setInt(3, codVeiculo);
            if (objItensVeiUid.getDataEntrada() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objItensVeiUid.getDataEntrada().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objItensVeiUid.getHorarioEntrada());
            if (objItensVeiUid.getDataSaida() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objItensVeiUid.getDataSaida().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setString(7, objItensVeiUid.getHorarioSaida());
            pst.setFloat(8, objItensVeiUid.getKmInicial());
            pst.setFloat(9, objItensVeiUid.getKmFinal());
            pst.setString(10, objItensVeiUid.getDestinoEntrada());
            pst.setString(11, objItensVeiUid.getUsuarioInsert());
            pst.setString(12, objItensVeiUid.getDataInsert());
            pst.setString(13, objItensVeiUid.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVeiUid;
    }

    public ItensEntradaVeiculoUnidade alterarEntSaiVeiculoUnidade(ItensEntradaVeiculoUnidade objItensVeiUid) {
        buscarColaborador(objItensVeiUid.getNomeColaborador(), objItensVeiUid.getIdFunc());
        buscarVeiculo(objItensVeiUid.getModeloVeiculo(), objItensVeiUid.getIdVeiculo());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSVEICULOSUNIDADE SET IdFunc=?,Idlanc=?,IdVeiculo=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=?,KmInicial=?,KmFinal=?,DestinoEntrada=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItensVeiUid.getIdItem() + "'");
            pst.setInt(1, codFunc);
            pst.setInt(2, objItensVeiUid.getIdlanc());
            pst.setInt(3, codVeiculo);
            if (objItensVeiUid.getDataEntrada() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objItensVeiUid.getDataEntrada().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objItensVeiUid.getHorarioEntrada());
            if (objItensVeiUid.getDataSaida() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objItensVeiUid.getDataSaida().getTime()));
            } else {
                pst.setDate(6, null);
            }
            pst.setString(7, objItensVeiUid.getHorarioSaida());
            pst.setFloat(8, objItensVeiUid.getKmInicial());
            pst.setFloat(9, objItensVeiUid.getKmFinal());
            pst.setString(10, objItensVeiUid.getDestinoEntrada());
            pst.setString(11, objItensVeiUid.getUsuarioUp());
            pst.setString(12, objItensVeiUid.getDataUp());
            pst.setString(13, objItensVeiUid.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVeiUid;
    }

    public ItensEntradaVeiculoUnidade excluirEntSaiVeiculoUnidade(ItensEntradaVeiculoUnidade objItensVeiUid) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSVEICULOSUNIDADE WHERE IdItem='" + objItensVeiUid.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensVeiUid;
    }

    public void buscarColaborador(String desc, int codigoFunc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR "
                    + "WHERE NomeFunc='" + desc + "' "
                    + "AND IdFunc='" + codigoFunc + "'");
            conecta.rs.first();
            codFunc = conecta.rs.getInt("IdFunc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (COLABORADOR) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public void buscarVeiculo(String desc, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VEICULOS "
                    + "WHERE ModeloVeiculo='" + desc + "' "
                    + "AND IdVeiculo='" + codigo + "'");
            conecta.rs.first();
            codVeiculo = conecta.rs.getInt("IdVeiculo");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (VEICULO) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
