/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.DevolucaoMedEnfermariaFarmacia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleDevolucaoMedicamentosENFAR {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    DevolucaoMedEnfermariaFarmacia objDevolucaoMed = new DevolucaoMedEnfermariaFarmacia();
    int codFunc;
    int codMotivo;
    int idLocal;

    public DevolucaoMedEnfermariaFarmacia incluirDevolucaoMedicamentosENFAR(DevolucaoMedEnfermariaFarmacia objDevolucaoMed) {
        buscarColaborador(objDevolucaoMed.getNomecolaborador());
        buscarMotivoRequisicao(objDevolucaoMed.getDescricaoMotivo());
        buscarLocalOrigem(objDevolucaoMed.getDescricaoLocalOrigem());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR (StatusDevo,DataDevo,IdMot,IdLocal,IdFunc,IdLocalDst,DescricaoLocalDestino,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objDevolucaoMed.getStatusDevo());
            pst.setTimestamp(2, new java.sql.Timestamp(objDevolucaoMed.getDataDevo().getTime()));
            pst.setInt(3, codMotivo);
            pst.setInt(4, idLocal);
            pst.setInt(5, codFunc);
            pst.setInt(6, objDevolucaoMed.getIdLocalDst());
            pst.setString(7, objDevolucaoMed.getDescricaoLocalDestino());
            pst.setString(8, objDevolucaoMed.getObservacao());
            pst.setString(9, objDevolucaoMed.getUsuarioInsert());
            pst.setString(10, objDevolucaoMed.getDataInsert());
            pst.setString(11, objDevolucaoMed.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDevolucaoMed;
    }

    public DevolucaoMedEnfermariaFarmacia alterarDevolucaoMedicamentosENFAR(DevolucaoMedEnfermariaFarmacia objDevolucaoMed) {
        buscarColaborador(objDevolucaoMed.getNomecolaborador());
        buscarMotivoRequisicao(objDevolucaoMed.getDescricaoMotivo());
        buscarLocalOrigem(objDevolucaoMed.getDescricaoLocalOrigem());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR SET StatusDevo=?,DataDevo=?,IdMot=?,IdLocal=?,IdFunc=?,IdLocalDst=?,DescricaoLocalDestino=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdDevo='" + objDevolucaoMed.getIdDevo() + "'");
            pst.setString(1, objDevolucaoMed.getStatusDevo());
            pst.setTimestamp(2, new java.sql.Timestamp(objDevolucaoMed.getDataDevo().getTime()));
            pst.setInt(3, codMotivo);
            pst.setInt(4, idLocal);
            pst.setInt(5, codFunc);
            pst.setInt(6, objDevolucaoMed.getIdLocalDst());
            pst.setString(7, objDevolucaoMed.getDescricaoLocalDestino());
            pst.setString(8, objDevolucaoMed.getObservacao());
            pst.setString(9, objDevolucaoMed.getUsuarioUp());
            pst.setString(10, objDevolucaoMed.getDataUp());
            pst.setString(11, objDevolucaoMed.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDevolucaoMed;
    }

    public DevolucaoMedEnfermariaFarmacia excluirDevolucaoMedicamentosENFAR(DevolucaoMedEnfermariaFarmacia objDevolucaoMed) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR WHERE IdDevo='" + objDevolucaoMed.getIdDevo() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDevolucaoMed;
    }

    public DevolucaoMedEnfermariaFarmacia finalizarDevolucaoMedicamentosENFAR(DevolucaoMedEnfermariaFarmacia objDevolucaoMed) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR SET StatusDevo=? WHERE IdDevo='" + objDevolucaoMed.getIdDevo() + "'");
            pst.setString(1, objDevolucaoMed.getStatusDevo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível FINALIZAR requisição.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objDevolucaoMed;
    }

    public void buscarColaborador(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR WHERE NomeFunc='" + nome + "'");
            conecta.rs.first();
            codFunc = conecta.rs.getInt("IdFunc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados dao COLABORADOR a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarMotivoRequisicao(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MOTIVO_SAIDA_PRODUTOS_ENFAR WHERE TituloMotivo='" + nome + "'");
            conecta.rs.first();
            codMotivo = conecta.rs.getInt("IdMot");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados dao MOTIVO a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void buscarLocalOrigem(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOCAL_ARMAZENAMENTO_AC WHERE DescricaoLocal='" + nome + "'");
            conecta.rs.first();
            idLocal = conecta.rs.getInt("IdLocal");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados do LOCAL a serem exibidos !!!");
        }
        conecta.desconecta();
    }
}
