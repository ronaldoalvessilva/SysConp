/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.PernoiteInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class PernoiteDao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    PernoiteInternos objPernoite = new PernoiteInternos();

    public PernoiteInternos incluirPernoite(PernoiteInternos objPernoite) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PERNOITE_INTERNOS (StatusRegistro,DataRegistro,DescricaoPavilhao,Documento,DescricaoCela,Objetivo,UnidadeOrigem,NomeCondutor,Rg,Cpf,Veiculo,Placa,Motivo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objPernoite.getStatusRegistro());
            pst.setTimestamp(2, new java.sql.Timestamp(objPernoite.getDataRegistro().getTime()));
            pst.setString(3, objPernoite.getDescricaoPavilhao());
            pst.setString(4, objPernoite.getDocumento());
            pst.setString(5, objPernoite.getDescricaoCela());
            pst.setString(6, objPernoite.getObjetivo());
            pst.setString(7, objPernoite.getUnidadeOrigem());
            pst.setString(8, objPernoite.getNomeCondutor());
            pst.setString(9, objPernoite.getRgCondutor());
            pst.setString(10, objPernoite.getCpfCondutor());
            pst.setString(11, objPernoite.getVeiculo());
            pst.setString(12, objPernoite.getPlaca());
            pst.setString(13, objPernoite.getMotivo());
            pst.setString(14, objPernoite.getUsuarioInsert());
            pst.setString(15, objPernoite.getDataInsert());
            pst.setString(16, objPernoite.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPernoite;
    }

    public PernoiteInternos alterarPernoite(PernoiteInternos objPernoite) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PERNOITE_INTERNOS SET StatusRegistro=?,DataRegistro=?,DescricaoPavilhao=?,Documento=?,DescricaoCela=?,Objetivo=?,UnidadeOrigem=?,NomeCondutor=?,Rg=?,Cpf=?,Veiculo=?,Placa=?,Motivo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPer='" + objPernoite.getIdRegistro() + "'");
            pst.setString(1, objPernoite.getStatusRegistro());
            pst.setTimestamp(2, new java.sql.Timestamp(objPernoite.getDataRegistro().getTime()));
            pst.setString(3, objPernoite.getDescricaoPavilhao());
            pst.setString(4, objPernoite.getDocumento());
            pst.setString(5, objPernoite.getDescricaoCela());
            pst.setString(6, objPernoite.getObjetivo());
            pst.setString(7, objPernoite.getUnidadeOrigem());
            pst.setString(8, objPernoite.getNomeCondutor());
            pst.setString(9, objPernoite.getRgCondutor());
            pst.setString(10, objPernoite.getCpfCondutor());
            pst.setString(11, objPernoite.getVeiculo());
            pst.setString(12, objPernoite.getPlaca());
            pst.setString(13, objPernoite.getMotivo());
            pst.setString(14, objPernoite.getUsuarioUp());
            pst.setString(15, objPernoite.getDataUp());
            pst.setString(16, objPernoite.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPernoite;
    }

    public PernoiteInternos excluirPernoite(PernoiteInternos objPernoite) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PERNOITE_INTERNOS WHERE IdPer='" + objPernoite.getIdRegistro() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPernoite;
    }

    public PernoiteInternos finalizarPernoite(PernoiteInternos objPernoite) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PERNOITE_INTERNOS SET StatusRegistro=? WHERE IdPer='" + objPernoite.getIdRegistro() + "'");
            pst.setString(1, objPernoite.getStatusRegistro());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPernoite;
    }

    //------------------------- INTERNOS DA PERENOITE
    public PernoiteInternos incluirInternosPernoite(PernoiteInternos objPernoite) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENS_PERNOITE_INTERNOS (IdPer,NomeInterno,NomeMae,NomePai,DataEntrada,HoraEntrada,DataSaida,HoraSaida,TipoOperacaoEntrada,ImagemInterno,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objPernoite.getIdRegistro());
            pst.setString(2, objPernoite.getNomeInterno());
            pst.setString(3, objPernoite.getNomeMae());
            pst.setString(4, objPernoite.getNomePai());
            if (objPernoite.getDataEntrada() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objPernoite.getDataEntrada().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objPernoite.getHoraEntrada());
            if (objPernoite.getDataSaida() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objPernoite.getDataSaida().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objPernoite.getHoraSaida());
            pst.setString(9, objPernoite.getTipoOperacaoEntrada());            
            pst.setBytes(10, objPernoite.getImgemInterno());
            pst.setString(11, objPernoite.getUsuarioInsert());
            pst.setString(12, objPernoite.getDataInsert());
            pst.setString(13, objPernoite.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPernoite;
    }
    public PernoiteInternos alterarInternosPernoite(PernoiteInternos objPernoite) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENS_PERNOITE_INTERNOS SET IdPer=?,NomeInterno=?,NomeMae=?,NomePai=?,DataEntrada=?,HoraEntrada=?,DataSaida=?,HoraSaida=?,TipoOperacaoSaida=?,ImagemInterno=?,UsuarioUp=?,DatauP=?,HorariouP=? WHERE IdItemPer='" + objPernoite.getIdRegistroInterno() + "'");
            pst.setInt(1, objPernoite.getIdRegistro());
            pst.setString(2, objPernoite.getNomeInterno());
            pst.setString(3, objPernoite.getNomeMae());
            pst.setString(4, objPernoite.getNomePai());
            if (objPernoite.getDataEntrada() != null) {
                pst.setTimestamp(5, new java.sql.Timestamp(objPernoite.getDataEntrada().getTime()));
            } else {
                pst.setDate(5, null);
            }
            pst.setString(6, objPernoite.getHoraEntrada());
            if (objPernoite.getDataSaida() != null) {
                pst.setTimestamp(7, new java.sql.Timestamp(objPernoite.getDataSaida().getTime()));
            } else {
                pst.setDate(7, null);
            }
            pst.setString(8, objPernoite.getHoraSaida());
            pst.setString(9, objPernoite.getTipoOperacaoSaida());            
            pst.setBytes(10, objPernoite.getImgemInterno());
            pst.setString(11, objPernoite.getUsuarioUp());
            pst.setString(12, objPernoite.getDataUp());
            pst.setString(13, objPernoite.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPernoite;
    }
    
    public PernoiteInternos excluirInternosPernoite(PernoiteInternos objPernoite) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENS_PERNOITE_INTERNOS WHERE IdItemPer='" + objPernoite.getIdRegistroInterno() + "'");            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objPernoite;
    }
}
