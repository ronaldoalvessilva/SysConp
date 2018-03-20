/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.LogSistema;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleLogSistema {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    LogSistema objLogSys = new LogSistema();

    public LogSistema incluirLogSistema(LogSistema objLogSys) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LOGSISTEMA (DataMov,HorarioMov,NomeModuloTela,IdLancMov,NomeUsuarioLogado,StatusMov) VALUES(?,?,?,?,?,?)");         
            pst.setString(1, objLogSys.getDataMov());
            pst.setString(2, objLogSys.getHorarioMov());
            pst.setString(3, objLogSys.getNomeModuloTela());
            pst.setInt(4, objLogSys.getIdLancMov());
            pst.setString(5, objLogSys.getNomeUsuarioLogado());
            pst.setString(6, objLogSys.getStatusMov());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel gravar o log.\nERRO" + ex);
        }
        conecta.desconecta();
        return objLogSys;
    }
}
