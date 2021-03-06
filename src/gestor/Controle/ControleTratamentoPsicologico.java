/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.TipoTratamentoPsicologico;
import gestor.Modelo.TratamentoPsicologico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleTratamentoPsicologico {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    TratamentoPsicologico objTrata = new TratamentoPsicologico();
    TipoTratamentoPsicologico objTipo = new TipoTratamentoPsicologico();
    int idInterno;

    public TratamentoPsicologico incluirTratamentoPsicologico(TratamentoPsicologico objTrata) {
        buscarInternoCrc(objTrata.getNomeInternoCrc(), objTrata.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO TRATAMENTO_PSICOLOGICO (StatusTrat,DataTrat,IdTipo,IdInternoCrc,ID_REGISTRO_ATEND_EVOL,DataInicio,DataTermino,TextoTratamento,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objTrata.getStatusTrat());
            pst.setTimestamp(2, new java.sql.Timestamp(objTrata.getDataTrat().getTime()));
            pst.setInt(3, objTrata.getIdTipo());
            pst.setInt(4, idInterno);
            pst.setInt(5, objTrata.getID_REGISTRO_ATEND_EVOL());
            if (objTrata.getDataInicio() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objTrata.getDataInicio().getTime()));
            } else {
                pst.setDate(6, null);
            }
            if (objTrata.getDataTermino() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objTrata.getDataTermino().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objTrata.getTextoTratamento());
            pst.setString(9, objTrata.getUsuarioInsert());
            pst.setString(10, objTrata.getDataInsert());
            pst.setString(11, objTrata.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTrata;
    }

    public TratamentoPsicologico alterarTratamentoPsicologico(TratamentoPsicologico objTrata) {
        buscarInternoCrc(objTrata.getNomeInternoCrc(), objTrata.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TRATAMENTO_PSICOLOGICO SET StatusTrat=?,DataTrat=?,IdTipo=?,IdInternoCrc=?,ID_REGISTRO_ATEND_EVOL=?,DataInicio=?,DataTermino=?,TextoTratamento=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdTRAT='" + objTrata.getIdTRAT() + "'");
            pst.setString(1, objTrata.getStatusTrat());
            pst.setTimestamp(2, new java.sql.Timestamp(objTrata.getDataTrat().getTime()));
            pst.setInt(3, objTrata.getIdTipo());
            pst.setInt(4, idInterno);
            pst.setInt(5, objTrata.getID_REGISTRO_ATEND_EVOL());
            if (objTrata.getDataInicio() != null) {
                pst.setTimestamp(6, new java.sql.Timestamp(objTrata.getDataInicio().getTime()));
            } else {
                pst.setDate(6, null);
            }
            if (objTrata.getDataTermino() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objTrata.getDataTermino().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objTrata.getTextoTratamento());
            pst.setString(9, objTrata.getUsuarioUp());
            pst.setString(10, objTrata.getDataUp());
            pst.setString(11, objTrata.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTrata;
    }

    public TratamentoPsicologico excluirTratamentoPsicologico(TratamentoPsicologico objTrata) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM TRATAMENTO_PSICOLOGICO WHERE IdTRAT='" + objTrata.getIdTRAT() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTrata;
    }

    public TratamentoPsicologico concluirTratamentoPsicologico(TratamentoPsicologico objTrata) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE TRATAMENTO_PSICOLOGICO SET StatusTrat=?,DataTermino=?,TextoTratamento=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdTRAT='" + objTrata.getIdTRAT() + "'");
            pst.setString(1, objTrata.getStatusTrat());
            if (objTrata.getDataTermino() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objTrata.getDataTermino().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objTrata.getUsuarioUp());
            pst.setString(4, objTrata.getDataUp());
            pst.setString(5, objTrata.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel CONCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objTrata;
    }

    public void buscarInternoCrc(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            idInterno = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    public List<TipoTratamentoPsicologico> read() throws Exception {

        conecta.abrirConexao();
        List<TipoTratamentoPsicologico> listaInternosNaoSelec = new ArrayList<TipoTratamentoPsicologico>();
        try {
            conecta.executaSQL("SELECT * FROM TIPOS_TRATAMENTO_PSICOLOGICO "
                    + "ORDER BY TIPOS_TRATAMENTO_PSICOLOGICO.DescricaoTipo");
            while (conecta.rs.next()) {
                TipoTratamentoPsicologico pListaTrata = new TipoTratamentoPsicologico();
                pListaTrata.setIdTipo(conecta.rs.getInt("IdTipo"));
                pListaTrata.setDescricaoTipo(conecta.rs.getString("DescricaoTipo"));
                listaInternosNaoSelec.add(pListaTrata);
            }
            return listaInternosNaoSelec;
        } catch (SQLException ex) {
            Logger.getLogger(ControleTratamentoPsicologico.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conecta.desconecta();
        }
        return null;
    }
}
