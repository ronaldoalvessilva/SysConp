/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtendimentoServicoSocial;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleAtendSocial {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoServicoSocial objAtendSocial = new AtendimentoServicoSocial();
    int codInt;

    // Incluir Atendimeto do Serviço Social
    public AtendimentoServicoSocial incluirAtendSocial(AtendimentoServicoSocial objAtendSocial) {
        buscarInternoCrc(objAtendSocial.getNomeInterno(), objAtendSocial.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ATENDIMENTOSOCIAL (DataAtend,IdInternoCrc,StatusAtend,ContatoAtend,EnderecoAtend,TelefoneAtend,Telefone1Atend,CelularAtend,"
                    + "BairroAtend,CidadeAtend,EstadoAtend,CartTrabAtend,Periodo,RecebeRecluAtend,DireitoAuxAtend,RecebeBolAtend,QtdPessoasAtend,QtdTrabaAtend,CN1Atend,CN2Atend,RG1Atend,"
                    + "RG2atend,CPF1Atend,CPF2Atend,CTPS1Atend,CTPS2Atend,PossuiFilhosAtend,QtdFilhosAtend,FilhosNaoRegAtend,OutrosFilhosAtend,QtdFilhos2Atend,PaternidadeAtend,DefensorAtend,"
                    + "PartiFamiAtend,ConsiderAtend,UsuarioInsert,DataInsert,HorarioInsert,MunicipioNascimento,Tituloeleito1,Tituloeleito2,Reservista1,Reservista2,CartorioRegistro,RecebeBeneficio,"
                    + "TempoConvivencia,EsposoCompanheiro,NomeEsposoCompanheiro,PessoasResideCasa,EncaOutroSetor,QualSetor,CancelarVisita,MotivoCancelarVisita,EncaTirarDoc,DataEncaDoc,EncaRecPaternidade,"
                    + "DataRecPaternidade,RecebeVisita,CondicaoSegurado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objAtendSocial.getDataAtend().getTime()));
            pst.setInt(2, codInt);
            pst.setString(3, objAtendSocial.getStatusAtend());
            pst.setString(4, objAtendSocial.getContatoAtend());
            pst.setString(5, objAtendSocial.getEnderecoAtend());
            pst.setString(6, objAtendSocial.getTelefoneAtend());
            pst.setString(7, objAtendSocial.getTelefone1Atend());
            pst.setString(8, objAtendSocial.getCelualarAtend());
            pst.setString(9, objAtendSocial.getBairroAtend());
            pst.setString(10, objAtendSocial.getCidadeAtend());
            pst.setString(11, objAtendSocial.getEstadoAtend());
            pst.setString(12, objAtendSocial.getCartTrabAtend());
            pst.setString(13, objAtendSocial.getPeriodo());
            pst.setString(14, objAtendSocial.getRecebeRecluAtend());
            pst.setString(15, objAtendSocial.getDireitoAuxAtend());
            pst.setString(16, objAtendSocial.getRecebeBolAtend());
            pst.setString(17, objAtendSocial.getQtdPessoasAtend());
            pst.setString(18, objAtendSocial.getQtdTrabaAtend());
            pst.setString(19, objAtendSocial.getCN1Atend());
            pst.setString(20, objAtendSocial.getCN2Atend());
            pst.setString(21, objAtendSocial.getRG1Atend());
            pst.setString(22, objAtendSocial.getRG2atend());
            pst.setString(23, objAtendSocial.getCPF1Atend());
            pst.setString(24, objAtendSocial.getCPF2Atend());
            pst.setString(25, objAtendSocial.getCTPS1Atend());
            pst.setString(26, objAtendSocial.getCTPS2Atend());
            pst.setString(27, objAtendSocial.getPossuiFilhosAtend());
            pst.setString(28, objAtendSocial.getQtdFilhosAtend());
            pst.setString(29, objAtendSocial.getFilhosNaoRegAtend());
            pst.setString(30, objAtendSocial.getOutrosFilhosAtend());
            pst.setString(31, objAtendSocial.getQtdFilhos2Atend());
            pst.setString(32, objAtendSocial.getPaternidadeAtend());
            pst.setString(33, objAtendSocial.getDefensorAtend());
            pst.setString(34, objAtendSocial.getPartiFamiAtend());
            pst.setString(35, objAtendSocial.getConsiderAtend());
            pst.setString(36, objAtendSocial.getUsuarioInsert());
            pst.setString(37, objAtendSocial.getDataInsert());
            pst.setString(38, objAtendSocial.getHoraInsert());
            pst.setString(39, objAtendSocial.getMunicipioNascimento());
            pst.setString(40, objAtendSocial.getTituloEleito1());
            pst.setString(41, objAtendSocial.getTituloEleitor2());
            pst.setString(42, objAtendSocial.getReservista1());
            pst.setString(43, objAtendSocial.getReservista2());
            pst.setString(44, objAtendSocial.getCartorioRegistro());
            pst.setString(45, objAtendSocial.getRecebeBeneficio());
            pst.setString(46, objAtendSocial.getTempoConvivencia());
            pst.setString(47, objAtendSocial.getEsposaCompanheira());
            pst.setString(48, objAtendSocial.getNomeEsposaConvivencia());
            pst.setString(49, objAtendSocial.getQtdPessoasResiCasa());
            pst.setString(50, objAtendSocial.getEncaminhaOutrosSetore());
            pst.setString(51, objAtendSocial.getQualSetor());
            pst.setString(52, objAtendSocial.getCancelarVisita());
            pst.setString(53, objAtendSocial.getMotivo());
            pst.setString(54, objAtendSocial.getEncaminhaTirarDoc());
            if (objAtendSocial.getDataEncaminharTiraDoc() != null) {
                pst.setTimestamp(55, new java.sql.Timestamp(objAtendSocial.getDataEncaminharTiraDoc().getTime()));
            } else {
                pst.setDate(55, null);
            }
            pst.setString(56, objAtendSocial.getEncaminarReconhecerPaternidade());
            if (objAtendSocial.getDataEncaRecPaterna() != null) {
                pst.setTimestamp(57, new java.sql.Timestamp(objAtendSocial.getDataEncaRecPaterna().getTime()));
            } else {
                pst.setDate(57, null);
            }

            pst.setString(58, objAtendSocial.getRecebeVisita());
            pst.setString(59, objAtendSocial.getCondicaoSegurado());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtendSocial;
    }

    // Alterar Atendimento do Serviço Social
    public AtendimentoServicoSocial alterarAtendSocial(AtendimentoServicoSocial objAtendSocial) {
        buscarInternoCrc(objAtendSocial.getNomeInterno(), objAtendSocial.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOSOCIAL SET DataAtend=?,IdInternoCrc=?,StatusAtend=?,ContatoAtend=?,EnderecoAtend=?,TelefoneAtend=?,Telefone1Atend=?,CelularAtend=?,"
                    + "BairroAtend=?,CidadeAtend=?,EstadoAtend=?,CartTrabAtend=?,Periodo=?,RecebeRecluAtend=?,DireitoAuxAtend=?,RecebeBolAtend=?,QtdPessoasAtend=?,QtdTrabaAtend=?,CN1Atend=?,CN2Atend=?,RG1Atend=?,"
                    + "RG2atend=?,CPF1Atend=?,CPF2Atend=?,CTPS1Atend=?,CTPS2Atend=?,PossuiFilhosAtend=?,QtdFilhosAtend=?,FilhosNaoRegAtend=?,OutrosFilhosAtend=?,QtdFilhos2Atend=?,PaternidadeAtend=?,DefensorAtend=?,"
                    + "PartiFamiAtend=?,ConsiderAtend=?,UsuarioUp=?,DataUp=?,HorarioUp=?,MunicipioNascimento=?,Tituloeleito1=?,Tituloeleito2=?,Reservista1=?,Reservista2=?,CartorioRegistro=?,RecebeBeneficio=?,"
                    + "TempoConvivencia=?,EsposoCompanheiro=?,NomeEsposoCompanheiro=?,PessoasResideCasa=?,EncaOutroSetor=?,QualSetor=?,CancelarVisita=?,MotivoCancelarVisita=?,EncaTirarDoc=?,DataEncaDoc=?,EncaRecPaternidade=?,"
                    + "DataRecPaternidade=?,RecebeVisita=?,CondicaoSegurado=? WHERE IdAtend='" + objAtendSocial.getIdAtend() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objAtendSocial.getDataAtend().getTime()));
            pst.setInt(2, codInt);
            pst.setString(3, objAtendSocial.getStatusAtend());
            pst.setString(4, objAtendSocial.getContatoAtend());
            pst.setString(5, objAtendSocial.getEnderecoAtend());
            pst.setString(6, objAtendSocial.getTelefoneAtend());
            pst.setString(7, objAtendSocial.getTelefone1Atend());
            pst.setString(8, objAtendSocial.getCelualarAtend());
            pst.setString(9, objAtendSocial.getBairroAtend());
            pst.setString(10, objAtendSocial.getCidadeAtend());
            pst.setString(11, objAtendSocial.getEstadoAtend());
            pst.setString(12, objAtendSocial.getCartTrabAtend());
            pst.setString(13, objAtendSocial.getPeriodo());
            pst.setString(14, objAtendSocial.getRecebeRecluAtend());
            pst.setString(15, objAtendSocial.getDireitoAuxAtend());
            pst.setString(16, objAtendSocial.getRecebeBolAtend());
            pst.setString(17, objAtendSocial.getQtdPessoasAtend());
            pst.setString(18, objAtendSocial.getQtdTrabaAtend());
            pst.setString(19, objAtendSocial.getCN1Atend());
            pst.setString(20, objAtendSocial.getCN2Atend());
            pst.setString(21, objAtendSocial.getRG1Atend());
            pst.setString(22, objAtendSocial.getRG2atend());
            pst.setString(23, objAtendSocial.getCPF1Atend());
            pst.setString(24, objAtendSocial.getCPF2Atend());
            pst.setString(25, objAtendSocial.getCTPS1Atend());
            pst.setString(26, objAtendSocial.getCTPS2Atend());
            pst.setString(27, objAtendSocial.getPossuiFilhosAtend());
            pst.setString(28, objAtendSocial.getQtdFilhosAtend());
            pst.setString(29, objAtendSocial.getFilhosNaoRegAtend());
            pst.setString(30, objAtendSocial.getOutrosFilhosAtend());
            pst.setString(31, objAtendSocial.getQtdFilhos2Atend());
            pst.setString(32, objAtendSocial.getPaternidadeAtend());
            pst.setString(33, objAtendSocial.getDefensorAtend());
            pst.setString(34, objAtendSocial.getPartiFamiAtend());
            pst.setString(35, objAtendSocial.getConsiderAtend());
            pst.setString(36, objAtendSocial.getUsuarioUp());
            pst.setString(37, objAtendSocial.getDataUp());
            pst.setString(38, objAtendSocial.getHoraUp());
            pst.setString(39, objAtendSocial.getMunicipioNascimento());
            pst.setString(40, objAtendSocial.getTituloEleito1());
            pst.setString(41, objAtendSocial.getTituloEleitor2());
            pst.setString(42, objAtendSocial.getReservista1());
            pst.setString(43, objAtendSocial.getReservista2());
            pst.setString(44, objAtendSocial.getCartorioRegistro());
            pst.setString(45, objAtendSocial.getRecebeBeneficio());
            pst.setString(46, objAtendSocial.getTempoConvivencia());
            pst.setString(47, objAtendSocial.getEsposaCompanheira());
            pst.setString(48, objAtendSocial.getNomeEsposaConvivencia());
            pst.setString(49, objAtendSocial.getQtdPessoasResiCasa());
            pst.setString(50, objAtendSocial.getEncaminhaOutrosSetore());
            pst.setString(51, objAtendSocial.getQualSetor());
            pst.setString(52, objAtendSocial.getCancelarVisita());
            pst.setString(53, objAtendSocial.getMotivo());
            pst.setString(54, objAtendSocial.getEncaminhaTirarDoc());
            if (objAtendSocial.getDataEncaminharTiraDoc() != null) {
                pst.setTimestamp(55, new java.sql.Timestamp(objAtendSocial.getDataEncaminharTiraDoc().getTime()));
            } else {
                pst.setDate(55, null);
            }
            pst.setString(56, objAtendSocial.getEncaminarReconhecerPaternidade());
            if (objAtendSocial.getDataEncaRecPaterna() != null) {
                pst.setTimestamp(57, new java.sql.Timestamp(objAtendSocial.getDataEncaRecPaterna().getTime()));
            } else {
                pst.setDate(57, null);
            }

            pst.setString(58, objAtendSocial.getRecebeVisita());
            pst.setString(59, objAtendSocial.getCondicaoSegurado());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtendSocial;
    }

    // Excluir Atendimento do Serviço Social
    public AtendimentoServicoSocial excluirAtendSocial(AtendimentoServicoSocial objAtendSocial) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ATENDIMENTOSOCIAL WHERE IdAtend='" + objAtendSocial.getIdAtend() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtendSocial;
    }

    // Excluir Atendimento do Serviço Social
    public AtendimentoServicoSocial finalizarAtendSocial(AtendimentoServicoSocial objAtendSocial) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOSOCIAL SET StatusAtend=? WHERE IdAtend='" + objAtendSocial.getIdAtend() + "'");
            pst.setString(1, objAtendSocial.getStatusAtend());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objAtendSocial;
    }

    // Buscar INTERNO
    public void buscarInternoCrc(String desc, int cod) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE NomeInternoCrc='" + desc + "' "
                    + "AND IdInternoCrc='" + cod + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
