/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.EntradaSaidaAdvogados;
import gestor.Modelo.EntradaSaidaOficialJustica;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleEntSaiOficialJustica {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    EntradaSaidaOficialJustica objEntSaiOficialJustica = new EntradaSaidaOficialJustica();

    public EntradaSaidaOficialJustica incluirEntOficialJustica(EntradaSaidaOficialJustica objEntSaiOficialJustica) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ENTRADAS_OFICIAL_JUSTICA (DataLanc,StatusLanc,ObsLanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiOficialJustica.getDataLanc().getTime()));
            pst.setString(2, objEntSaiOficialJustica.getStatusLanc());
            pst.setString(3, objEntSaiOficialJustica.getObsLanc());
            pst.setString(4, objEntSaiOficialJustica.getUsuarioInsert());
            pst.setString(5, objEntSaiOficialJustica.getDataInsert());
            pst.setString(6, objEntSaiOficialJustica.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiOficialJustica;
    }

    public EntradaSaidaOficialJustica alterarEntOficialJustica(EntradaSaidaOficialJustica objEntSaiOficialJustica) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAS_OFICIAL_JUSTICA SET DataLanc=?,StatusLanc=?,ObsLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objEntSaiOficialJustica.getIdLanc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objEntSaiOficialJustica.getDataLanc().getTime()));
            pst.setString(2, objEntSaiOficialJustica.getStatusLanc());
            pst.setString(3, objEntSaiOficialJustica.getObsLanc());
            pst.setString(4, objEntSaiOficialJustica.getUsuarioUp());
            pst.setString(5, objEntSaiOficialJustica.getDataUp());
            pst.setString(6, objEntSaiOficialJustica.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiOficialJustica;
    }

    public EntradaSaidaOficialJustica excluirEntOficialJustica(EntradaSaidaOficialJustica objEntSaiOficialJustica) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ENTRADAS_OFICIAL_JUSTICA WHERE IdLanc='" + objEntSaiOficialJustica.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objEntSaiOficialJustica;
    }

    public EntradaSaidaOficialJustica finalizarEntradaSaiOficialJustica(EntradaSaidaOficialJustica objEntSaiOficialJustica) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ENTRADAS_OFICIAL_JUSTICA SET StatusLanc=? WHERE IdLanc='" + objEntSaiOficialJustica.getIdLanc() + "'");
            pst.setString(1, objEntSaiOficialJustica.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR atendimento\nERRO: " + ex);
        }
        conecta.desconecta();
        return objEntSaiOficialJustica;
    }
}
