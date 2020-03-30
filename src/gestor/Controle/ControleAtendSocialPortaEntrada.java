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
public class ControleAtendSocialPortaEntrada {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtendimentoServicoSocial objAtendSocial = new AtendimentoServicoSocial();
    int codInt;

    // Incluir Atendimeto do Serviço Social
    public AtendimentoServicoSocial incluirAtendSocial(AtendimentoServicoSocial objAtendSocial) {
        buscarInternoCrc(objAtendSocial.getNomeInterno(), objAtendSocial.getIdInternoCrc());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PORTA_ENTRADA_SERVICO_SOCIAL (IdAtend,DataAtend,IdInternoCrc,StatusAtend,ContatoAtend,EnderecoAtend,TelefoneAtend,Telefone1Atend,CelularAtend,"
                    + "BairroAtend,CidadeAtend,EstadoAtend,CartTrabAtend,Periodo,RecebeRecluAtend,DireitoAuxAtend,RecebeBolAtend,QtdPessoasAtend,QtdTrabaAtend,CN1Atend,CN2Atend,RG1Atend,"
                    + "RG2atend,CPF1Atend,CPF2Atend,CTPS1Atend,CTPS2Atend,PossuiFilhosAtend,QtdFilhosAtend,FilhosNaoRegAtend,OutrosFilhosAtend,QtdFilhos2Atend,PaternidadeAtend,DefensorAtend,"
                    + "PartiFamiAtend,ConsiderAtend,UsuarioInsert,DataInsert,HorarioInsert,MunicipioNascimento,Tituloeleito1,Tituloeleito2,Reservista1,Reservista2,CartorioRegistro,RecebeBeneficio,"
                    + "TempoConvivencia,EsposoCompanheiro,NomeEsposoCompanheiro,PessoasResideCasa,EncaOutroSetor,QualSetor,CancelarVisita,MotivoCancelarVisita,EncaTirarDoc,DataEncaDoc,EncaRecPaternidade,"
                    + "DataRecPaternidade,RecebeVisita,CondicaoSegurado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, objAtendSocial.getIdAtend());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtendSocial.getDataAtend().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objAtendSocial.getStatusAtend());
            pst.setString(5, objAtendSocial.getContatoAtend());
            pst.setString(6, objAtendSocial.getEnderecoAtend());
            pst.setString(7, objAtendSocial.getTelefoneAtend());
            pst.setString(8, objAtendSocial.getTelefone1Atend());
            pst.setString(9, objAtendSocial.getCelualarAtend());
            pst.setString(10, objAtendSocial.getBairroAtend());
            pst.setString(11, objAtendSocial.getCidadeAtend());
            pst.setString(12, objAtendSocial.getEstadoAtend());
            pst.setString(13, objAtendSocial.getCartTrabAtend());
            pst.setString(14, objAtendSocial.getPeriodo());
            pst.setString(15, objAtendSocial.getRecebeRecluAtend());
            pst.setString(16, objAtendSocial.getDireitoAuxAtend());
            pst.setString(17, objAtendSocial.getRecebeBolAtend());
            pst.setString(18, objAtendSocial.getQtdPessoasAtend());
            pst.setString(19, objAtendSocial.getQtdTrabaAtend());
            pst.setString(20, objAtendSocial.getCN1Atend());
            pst.setString(21, objAtendSocial.getCN2Atend());
            pst.setString(22, objAtendSocial.getRG1Atend());
            pst.setString(23, objAtendSocial.getRG2atend());
            pst.setString(24, objAtendSocial.getCPF1Atend());
            pst.setString(25, objAtendSocial.getCPF2Atend());
            pst.setString(26, objAtendSocial.getCTPS1Atend());
            pst.setString(27, objAtendSocial.getCTPS2Atend());
            pst.setString(28, objAtendSocial.getPossuiFilhosAtend());
            pst.setString(29, objAtendSocial.getQtdFilhosAtend());
            pst.setString(30, objAtendSocial.getFilhosNaoRegAtend());
            pst.setString(31, objAtendSocial.getOutrosFilhosAtend());
            pst.setString(32, objAtendSocial.getQtdFilhos2Atend());
            pst.setString(33, objAtendSocial.getPaternidadeAtend());
            pst.setString(34, objAtendSocial.getDefensorAtend());
            pst.setString(35, objAtendSocial.getPartiFamiAtend());
            pst.setString(36, objAtendSocial.getConsiderAtend());
            pst.setString(37, objAtendSocial.getUsuarioInsert());
            pst.setString(38, objAtendSocial.getDataInsert());
            pst.setString(39, objAtendSocial.getHoraInsert());
            pst.setString(40, objAtendSocial.getMunicipioNascimento());
            pst.setString(41, objAtendSocial.getTituloEleito1());
            pst.setString(42, objAtendSocial.getTituloEleitor2());
            pst.setString(43, objAtendSocial.getReservista1());
            pst.setString(44, objAtendSocial.getReservista2());
            pst.setString(45, objAtendSocial.getCartorioRegistro());
            pst.setString(46, objAtendSocial.getRecebeBeneficio());
            pst.setString(47, objAtendSocial.getTempoConvivencia());
            pst.setString(48, objAtendSocial.getEsposaCompanheira());
            pst.setString(49, objAtendSocial.getNomeEsposaConvivencia());
            pst.setString(50, objAtendSocial.getQtdPessoasResiCasa());
            pst.setString(51, objAtendSocial.getEncaminhaOutrosSetore());
            pst.setString(52, objAtendSocial.getQualSetor());
            pst.setString(53, objAtendSocial.getCancelarVisita());
            pst.setString(54, objAtendSocial.getMotivo());
            pst.setString(55, objAtendSocial.getEncaminhaTirarDoc());
            if (objAtendSocial.getDataEncaminharTiraDoc() != null) {
                pst.setTimestamp(56, new java.sql.Timestamp(objAtendSocial.getDataEncaminharTiraDoc().getTime()));
            } else {
                pst.setDate(56, null);
            }
            pst.setString(57, objAtendSocial.getEncaminarReconhecerPaternidade());
            if (objAtendSocial.getDataEncaRecPaterna() != null) {
                pst.setTimestamp(58, new java.sql.Timestamp(objAtendSocial.getDataEncaRecPaterna().getTime()));
            } else {
                pst.setDate(58, null);
            }
            pst.setString(59, objAtendSocial.getRecebeVisita());
            pst.setString(60, objAtendSocial.getCondicaoSegurado());
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA_SERVICO_SOCIAL SET IdAtend=?,DataAtend=?,IdInternoCrc=?,StatusAtend=?,ContatoAtend=?,EnderecoAtend=?,TelefoneAtend=?,Telefone1Atend=?,CelularAtend=?,"
                    + "BairroAtend=?,CidadeAtend=?,EstadoAtend=?,CartTrabAtend=?,Periodo=?,RecebeRecluAtend=?,DireitoAuxAtend=?,RecebeBolAtend=?,QtdPessoasAtend=?,QtdTrabaAtend=?,CN1Atend=?,CN2Atend=?,RG1Atend=?,"
                    + "RG2atend=?,CPF1Atend=?,CPF2Atend=?,CTPS1Atend=?,CTPS2Atend=?,PossuiFilhosAtend=?,QtdFilhosAtend=?,FilhosNaoRegAtend=?,OutrosFilhosAtend=?,QtdFilhos2Atend=?,PaternidadeAtend=?,DefensorAtend=?,"
                    + "PartiFamiAtend=?,ConsiderAtend=?,UsuarioUp=?,DataUp=?,HorarioUp=?,MunicipioNascimento=?,Tituloeleito1=?,Tituloeleito2=?,Reservista1=?,Reservista2=?,CartorioRegistro=?,RecebeBeneficio=?,"
                    + "TempoConvivencia=?,EsposoCompanheiro=?,NomeEsposoCompanheiro=?,PessoasResideCasa=?,EncaOutroSetor=?,QualSetor=?,CancelarVisita=?,MotivoCancelarVisita=?,EncaTirarDoc=?,DataEncaDoc=?,EncaRecPaternidade=?,"
                    + "DataRecPaternidade=?,RecebeVisita=?,CondicaoSegurado=? WHERE IdAtendSS='" + objAtendSocial.getIdAtendNova()+ "'");
            pst.setInt(1, objAtendSocial.getIdAtend());
            pst.setTimestamp(2, new java.sql.Timestamp(objAtendSocial.getDataAtend().getTime()));
            pst.setInt(3, codInt);
            pst.setString(4, objAtendSocial.getStatusAtend());
            pst.setString(5, objAtendSocial.getContatoAtend());
            pst.setString(6, objAtendSocial.getEnderecoAtend());
            pst.setString(7, objAtendSocial.getTelefoneAtend());
            pst.setString(8, objAtendSocial.getTelefone1Atend());
            pst.setString(9, objAtendSocial.getCelualarAtend());
            pst.setString(10, objAtendSocial.getBairroAtend());
            pst.setString(11, objAtendSocial.getCidadeAtend());
            pst.setString(12, objAtendSocial.getEstadoAtend());
            pst.setString(13, objAtendSocial.getCartTrabAtend());
            pst.setString(14, objAtendSocial.getPeriodo());
            pst.setString(15, objAtendSocial.getRecebeRecluAtend());
            pst.setString(16, objAtendSocial.getDireitoAuxAtend());
            pst.setString(17, objAtendSocial.getRecebeBolAtend());
            pst.setString(18, objAtendSocial.getQtdPessoasAtend());
            pst.setString(19, objAtendSocial.getQtdTrabaAtend());
            pst.setString(20, objAtendSocial.getCN1Atend());
            pst.setString(21, objAtendSocial.getCN2Atend());
            pst.setString(22, objAtendSocial.getRG1Atend());
            pst.setString(23, objAtendSocial.getRG2atend());
            pst.setString(24, objAtendSocial.getCPF1Atend());
            pst.setString(25, objAtendSocial.getCPF2Atend());
            pst.setString(26, objAtendSocial.getCTPS1Atend());
            pst.setString(27, objAtendSocial.getCTPS2Atend());
            pst.setString(28, objAtendSocial.getPossuiFilhosAtend());
            pst.setString(29, objAtendSocial.getQtdFilhosAtend());
            pst.setString(30, objAtendSocial.getFilhosNaoRegAtend());
            pst.setString(31, objAtendSocial.getOutrosFilhosAtend());
            pst.setString(32, objAtendSocial.getQtdFilhos2Atend());
            pst.setString(33, objAtendSocial.getPaternidadeAtend());
            pst.setString(34, objAtendSocial.getDefensorAtend());
            pst.setString(35, objAtendSocial.getPartiFamiAtend());
            pst.setString(36, objAtendSocial.getConsiderAtend());
            pst.setString(37, objAtendSocial.getUsuarioUp());
            pst.setString(38, objAtendSocial.getDataUp());
            pst.setString(39, objAtendSocial.getHoraUp());
            pst.setString(40, objAtendSocial.getMunicipioNascimento());
            pst.setString(41, objAtendSocial.getTituloEleito1());
            pst.setString(42, objAtendSocial.getTituloEleitor2());
            pst.setString(43, objAtendSocial.getReservista1());
            pst.setString(44, objAtendSocial.getReservista2());
            pst.setString(45, objAtendSocial.getCartorioRegistro());
            pst.setString(46, objAtendSocial.getRecebeBeneficio());
            pst.setString(47, objAtendSocial.getTempoConvivencia());
            pst.setString(48, objAtendSocial.getEsposaCompanheira());
            pst.setString(49, objAtendSocial.getNomeEsposaConvivencia());
            pst.setString(50, objAtendSocial.getQtdPessoasResiCasa());
            pst.setString(51, objAtendSocial.getEncaminhaOutrosSetore());
            pst.setString(52, objAtendSocial.getQualSetor());
            pst.setString(53, objAtendSocial.getCancelarVisita());
            pst.setString(54, objAtendSocial.getMotivo());
            pst.setString(55, objAtendSocial.getEncaminhaTirarDoc());
            if (objAtendSocial.getDataEncaminharTiraDoc() != null) {
                pst.setTimestamp(56, new java.sql.Timestamp(objAtendSocial.getDataEncaminharTiraDoc().getTime()));
            } else {
                pst.setDate(56, null);
            }
            pst.setString(57, objAtendSocial.getEncaminarReconhecerPaternidade());
            if (objAtendSocial.getDataEncaRecPaterna() != null) {
                pst.setTimestamp(58, new java.sql.Timestamp(objAtendSocial.getDataEncaRecPaterna().getTime()));
            } else {
                pst.setDate(58, null);
            }
            pst.setString(59, objAtendSocial.getRecebeVisita());
            pst.setString(60, objAtendSocial.getCondicaoSegurado());
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
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PORTA_ENTRADA_SERVICO_SOCIAL WHERE IdAtendSS='" + objAtendSocial.getIdAtend() + "'");
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PORTA_ENTRADA_SERVICO_SOCIAL SET StatusAtend=? WHERE IdAtendSS='" + objAtendSocial.getIdAtendNova()+ "'");
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
