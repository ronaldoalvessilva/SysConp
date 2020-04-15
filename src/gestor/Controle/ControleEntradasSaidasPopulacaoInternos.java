/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidasPolucaoInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControleEntradasSaidasPopulacaoInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidasPolucaoInternos objEntradaSaida = new EntradaSaidasPolucaoInternos();
    int codModulo;
    int codGrupo;

    public EntradaSaidasPolucaoInternos incluirEntradaSaidaPopulacao(EntradaSaidasPolucaoInternos objEntradaSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADAS_SAIDAS_POPULACAO_INTERNOS (DataMovimento,HorarioMovimento,TipoOperacao,Populacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntradaSaida.getDataMovimento().getTime()));
            pst.setString(2, objEntradaSaida.getHorarioMovimento());
            pst.setString(3, objEntradaSaida.getTipoOperacao());
            pst.setInt(4, objEntradaSaida.getPopulacao());
            pst.setString(5, objEntradaSaida.getUsuarioInsert());
            pst.setString(6, objEntradaSaida.getDataInsert());
            pst.setString(7, objEntradaSaida.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntradaSaida;
    }
}
