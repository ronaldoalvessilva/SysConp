/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoFamiliar;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleAtendimentoFamiliar {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoFamiliar objAtendf = new AtendimentoFamiliar();
    int codInt;
    int codVisita;

    // Incluir Atendimento Familiar
    public AtendimentoFamiliar incluirAtendFamiliar(AtendimentoFamiliar objAtendf) {
        buscarVista(objAtendf.getNomeVisita());
        buscarInternoCrc(objAtendf.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATENDIMENTOFAMILIAR (DataAtendf,StatusAtendf,"
                    + "IdVisita,IdInternoCrc,Pergunta1Atendf,Pergunta2Atendf,UsuarioInsert,DataInsert,HorarioInsert,"
                    + "CompanheiroUnidade,VisitaInternoUnidade,CreasCreas,BolsaFamilia,ReconhecerPaternidade,AuxilioReclusao,"
                    + "OutroBerneficio,PossuiFilhos,QuantidadeFilhos,QualIdade,Estudam,TipoEscola,ParticipaProjeto,Endereco,"
                    + "Cidade,Estado,Telefone1,Telefone2,Celular,Trabalha,Escolaridade,ProblemaSaude,QualProblemaSaude,UsoMedicacao,"
                    + "QuaisMedicacoes,DoencaPermanente,QuaisDoencas) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objAtendf.getDataAtendf().getTime()));
            pst.setString(2, objAtendf.getStatusAtend());
            pst.setInt(3, codVisita);
            pst.setInt(4, codInt);
            pst.setString(5, objAtendf.getPergunta1Atendf());
            pst.setString(6, objAtendf.getPergunta2Atendf());
            pst.setString(7, objAtendf.getUsuarioInsert());
            pst.setString(8, objAtendf.getDataInsert());
            pst.setString(9, objAtendf.getHoraInsert());
            pst.setString(10, objAtendf.getCompanheiroUnidade());
            pst.setString(11, objAtendf.getVisitaInternoUnidade());
            pst.setString(12, objAtendf.getCreasCreas());
            pst.setString(13, objAtendf.getBolsaFamilia());
            pst.setString(14, objAtendf.getReconhecerPaternidade());
            pst.setString(15, objAtendf.getAuxilioReclusao());
            pst.setString(16, objAtendf.getOutroBerneficio());
            pst.setString(17, objAtendf.getPossuiFilhos());
            pst.setInt(18, objAtendf.getQuantidadeFilhos());
            pst.setString(19, objAtendf.getQualIdade());
            pst.setString(20, objAtendf.getEstudam());
            pst.setString(21, objAtendf.getTipoEscola());
            pst.setString(22, objAtendf.getParticipaProjeto());
            pst.setString(23, objAtendf.getEndereco());
            pst.setString(24, objAtendf.getCidade());
            pst.setString(25, objAtendf.getEstado());
            pst.setString(26, objAtendf.getTelefone1());
            pst.setString(27, objAtendf.getTelefone2());
            pst.setString(28, objAtendf.getCelular());
            pst.setString(29, objAtendf.getTrabalha());
            pst.setString(30, objAtendf.getEscolaridade());
            pst.setString(31, objAtendf.getProblemaSaude());
            pst.setString(32, objAtendf.getQuaisProblemaSaude());
            pst.setString(33, objAtendf.getUsoMedicacao());
            pst.setString(34, objAtendf.getQuaisMedicacoes());
            pst.setString(35, objAtendf.getDoencaPermanente());
            pst.setString(36, objAtendf.getQuaisDoencas());                    
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtendf;
    }

    // Alterar Atendimento Familiar
    public AtendimentoFamiliar alterarAtendFamiliar(AtendimentoFamiliar objAtendf) {
        buscarVista(objAtendf.getNomeVisita());
        buscarInternoCrc(objAtendf.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOFAMILIAR SET DataAtendf=?,"
                    + "StatusAtendf=?,IdVisita=?,IdInternoCrc=?,Pergunta1Atendf=?,Pergunta2Atendf=?,UsuarioUp=?,"
                    + "DataUp=?,HorarioUp=?,CompanheiroUnidade=?,VisitaInternoUnidade=?,CreasCreas=?,BolsaFamilia=?,"
                    + "ReconhecerPaternidade=?,AuxilioReclusao=?,OutroBerneficio=?,PossuiFilhos=?,QuantidadeFilhos=?,QualIdade=?,"
                    + "Estudam=?,TipoEscola=?,ParticipaProjeto=?,Endereco=?,Cidade=?,Estado=?,Telefone1=?,Telefone2=?,Celular=?,Trabalha=?,"
                    + "Escolaridade=?,ProblemaSaude=?,QualProblemaSaude=?,UsoMedicacao=?,QuaisMedicacoes=?,DoencaPermanente=?,"
                    + "QuaisDoencas=? WHERE IdAtendf='" + objAtendf.getIdAtendf() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objAtendf.getDataAtendf().getTime()));
            pst.setString(2, objAtendf.getStatusAtend());
            pst.setInt(3, codVisita);
            pst.setInt(4, codInt);
            pst.setString(5, objAtendf.getPergunta1Atendf());
            pst.setString(6, objAtendf.getPergunta2Atendf());
            pst.setString(7, objAtendf.getUsuarioUp());
            pst.setString(8, objAtendf.getDataUp());
            pst.setString(9, objAtendf.getHoraUp());
            pst.setString(10, objAtendf.getCompanheiroUnidade());
            pst.setString(11, objAtendf.getVisitaInternoUnidade());
            pst.setString(12, objAtendf.getCreasCreas());
            pst.setString(13, objAtendf.getBolsaFamilia());
            pst.setString(13, objAtendf.getBolsaFamilia());
            pst.setString(14, objAtendf.getReconhecerPaternidade());
            pst.setString(15, objAtendf.getAuxilioReclusao());
            pst.setString(16, objAtendf.getOutroBerneficio());
            pst.setString(17, objAtendf.getPossuiFilhos());
            pst.setInt(18, objAtendf.getQuantidadeFilhos());
            pst.setString(19, objAtendf.getQualIdade());
            pst.setString(20, objAtendf.getEstudam());
            pst.setString(21, objAtendf.getTipoEscola());
            pst.setString(22, objAtendf.getParticipaProjeto());
            pst.setString(23, objAtendf.getEndereco());
            pst.setString(24, objAtendf.getCidade());
            pst.setString(25, objAtendf.getEstado());
            pst.setString(26, objAtendf.getTelefone1());
            pst.setString(27, objAtendf.getTelefone2());
            pst.setString(28, objAtendf.getCelular());
            pst.setString(29, objAtendf.getTrabalha());
            pst.setString(30, objAtendf.getEscolaridade());
            pst.setString(31, objAtendf.getProblemaSaude());
            pst.setString(32, objAtendf.getQuaisProblemaSaude());
            pst.setString(33, objAtendf.getUsoMedicacao());
            pst.setString(34, objAtendf.getQuaisMedicacoes());
            pst.setString(35, objAtendf.getDoencaPermanente());
            pst.setString(36, objAtendf.getQuaisDoencas());           
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtendf;
    }

    // Excluir Atendimento Familiar

    public AtendimentoFamiliar excluirAtendFamiliar(AtendimentoFamiliar objAtendf) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATENDIMENTOFAMILIAR WHERE IdAtendf='" + objAtendf.getIdAtendf() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtendf;
    }

    public AtendimentoFamiliar finalizarAtendFamiliar(AtendimentoFamiliar objAtendf) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOFAMILIAR SET StatusAtendf=? WHERE IdAtendf='" + objAtendf.getIdAtendf() + "'");
            pst.setString(1, objAtendf.getStatusAtend());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR atendimento.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtendf;
    }

    // Buscar código de interno

    public void buscarVista(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITASINTERNO WHERE NomeVisita='" + desc + "'");
            conecta.rs.first();
            codVisita = conecta.rs.getInt("IdVisita");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (VISITAS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }

    // Buscar código de visita
    public void buscarInternoCrc(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
