/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ronaldo.silva7
 */
public class CancelamentoPagamentoKitHigiene {

    private Integer idRegistro;
    private String statusRegistro;
    private Date dataRegistro;
    private Integer idPav;
    private String descricaoPav;
    private Integer idCela;
    private String descricaoCela;
    private Integer idFunc;
    private String NomeFunc;
    private Integer idKit;
    private String tipoKit;
    private String situacaoInterno;
    private Integer idRegistroKit;
    private Date dataRegistroKit;
    private String motivoCancelamento;
    private Integer idItemSA;
    private Integer idItemINT;
    private Integer idInternoKit;
    private String matriculaInterno;
    private String regimeInterno;
    private String nomeInternoKit;
    private Integer idItemPRO;
    private Integer codigoProduto;
    private String descricaoProduto;
    private String unidadeProduto;
    private int quantidadeProduto;
    private Date dataEntrega;
    private String horario;
    private String usuarioInsert;
    private String usuarioUp;
    private String dataInsert;
    private String dataUp;
    private String horarioInsert;      
    private String horarioUp;            

    public CancelamentoPagamentoKitHigiene() {
    }

    public CancelamentoPagamentoKitHigiene(Integer idRegistro, String statusRegistro, Date dataRegistro, Integer idPav, String descricaoPav, Integer idCela, String descricaoCela, Integer idFunc, String NomeFunc, Integer idKit, String tipoKit, String situacaoInterno, Integer idRegistroKit, Date dataRegistroKit, String motivoCancelamento, Integer idItemSA, Integer idItemINT, Integer idInternoKit, String matriculaInterno, String regimeInterno, String nomeInternoKit, Integer idItemPRO, Integer codigoProduto, String descricaoProduto, String unidadeProduto, int quantidadeProduto, Date dataEntrega, String horario, String usuarioInsert, String usuarioUp, String dataInsert, String dataUp, String horarioInsert, String horarioUp) {
        this.idRegistro = idRegistro;
        this.statusRegistro = statusRegistro;
        this.dataRegistro = dataRegistro;
        this.idPav = idPav;
        this.descricaoPav = descricaoPav;
        this.idCela = idCela;
        this.descricaoCela = descricaoCela;
        this.idFunc = idFunc;
        this.NomeFunc = NomeFunc;
        this.idKit = idKit;
        this.tipoKit = tipoKit;
        this.situacaoInterno = situacaoInterno;
        this.idRegistroKit = idRegistroKit;
        this.dataRegistroKit = dataRegistroKit;
        this.motivoCancelamento = motivoCancelamento;
        this.idItemSA = idItemSA;
        this.idItemINT = idItemINT;
        this.idInternoKit = idInternoKit;
        this.matriculaInterno = matriculaInterno;
        this.regimeInterno = regimeInterno;
        this.nomeInternoKit = nomeInternoKit;
        this.idItemPRO = idItemPRO;
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.unidadeProduto = unidadeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.dataEntrega = dataEntrega;
        this.horario = horario;
        this.usuarioInsert = usuarioInsert;
        this.usuarioUp = usuarioUp;
        this.dataInsert = dataInsert;
        this.dataUp = dataUp;
        this.horarioInsert = horarioInsert;
        this.horarioUp = horarioUp;
    }


    /**
     * @return the usuarioInsert
     */
    public String getUsuarioInsert() {
        return usuarioInsert;
    }

    /**
     * @param usuarioInsert the usuarioInsert to set
     */
    public void setUsuarioInsert(String usuarioInsert) {
        this.usuarioInsert = usuarioInsert;
    }

    /**
     * @return the usuarioUp
     */
    public String getUsuarioUp() {
        return usuarioUp;
    }

    /**
     * @param usuarioUp the usuarioUp to set
     */
    public void setUsuarioUp(String usuarioUp) {
        this.usuarioUp = usuarioUp;
    }

    /**
     * @return the dataInsert
     */
    public String getDataInsert() {
        return dataInsert;
    }

    /**
     * @param dataInsert the dataInsert to set
     */
    public void setDataInsert(String dataInsert) {
        this.dataInsert = dataInsert;
    }

    /**
     * @return the dataUp
     */
    public String getDataUp() {
        return dataUp;
    }

    /**
     * @param dataUp the dataUp to set
     */
    public void setDataUp(String dataUp) {
        this.dataUp = dataUp;
    }

    /**
     * @return the horarioInsert
     */
    public String getHorarioInsert() {
        return horarioInsert;
    }

    /**
     * @param horarioInsert the horarioInsert to set
     */
    public void setHorarioInsert(String horarioInsert) {
        this.horarioInsert = horarioInsert;
    }

    /**
     * @return the horarioUp
     */
    public String getHorarioUp() {
        return horarioUp;
    }

    /**
     * @param horarioUp the horarioUp to set
     */
    public void setHorarioUp(String horarioUp) {
        this.horarioUp = horarioUp;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.getIdRegistro());
        hash = 73 * hash + Objects.hashCode(this.getIdPav());
        hash = 73 * hash + Objects.hashCode(this.getIdCela());
        hash = 73 * hash + Objects.hashCode(this.getIdFunc());
        hash = 73 * hash + Objects.hashCode(this.getIdRegistroKit());
        hash = 73 * hash + Objects.hashCode(this.getIdItemINT());
        hash = 73 * hash + Objects.hashCode(this.getIdInternoKit());
        hash = 73 * hash + Objects.hashCode(this.getIdItemPRO());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CancelamentoPagamentoKitHigiene other = (CancelamentoPagamentoKitHigiene) obj;
        if (!Objects.equals(this.idRegistro, other.idRegistro)) {
            return false;
        }
        if (!Objects.equals(this.idPav, other.idPav)) {
            return false;
        }
        if (!Objects.equals(this.idCela, other.idCela)) {
            return false;
        }
        if (!Objects.equals(this.idFunc, other.idFunc)) {
            return false;
        }
        if (!Objects.equals(this.idRegistroKit, other.idRegistroKit)) {
            return false;
        }
        if (!Objects.equals(this.idItemINT, other.idItemINT)) {
            return false;
        }
        if (!Objects.equals(this.idInternoKit, other.idInternoKit)) {
            return false;
        }
        if (!Objects.equals(this.idItemPRO, other.idItemPRO)) {
            return false;
        }
        return true;
    }

    /**
     * @return the idRegistro
     */
    public Integer getIdRegistro() {
        return idRegistro;
    }

    /**
     * @param idRegistro the idRegistro to set
     */
    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    /**
     * @return the statusRegistro
     */
    public String getStatusRegistro() {
        return statusRegistro;
    }

    /**
     * @param statusRegistro the statusRegistro to set
     */
    public void setStatusRegistro(String statusRegistro) {
        this.statusRegistro = statusRegistro;
    }

    /**
     * @return the dataRegistro
     */
    public Date getDataRegistro() {
        return dataRegistro;
    }

    /**
     * @param dataRegistro the dataRegistro to set
     */
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    /**
     * @return the idPav
     */
    public Integer getIdPav() {
        return idPav;
    }

    /**
     * @param idPav the idPav to set
     */
    public void setIdPav(Integer idPav) {
        this.idPav = idPav;
    }

    /**
     * @return the descricaoPav
     */
    public String getDescricaoPav() {
        return descricaoPav;
    }

    /**
     * @param descricaoPav the descricaoPav to set
     */
    public void setDescricaoPav(String descricaoPav) {
        this.descricaoPav = descricaoPav;
    }

    /**
     * @return the idCela
     */
    public Integer getIdCela() {
        return idCela;
    }

    /**
     * @param idCela the idCela to set
     */
    public void setIdCela(Integer idCela) {
        this.idCela = idCela;
    }

    /**
     * @return the descricaoCela
     */
    public String getDescricaoCela() {
        return descricaoCela;
    }

    /**
     * @param descricaoCela the descricaoCela to set
     */
    public void setDescricaoCela(String descricaoCela) {
        this.descricaoCela = descricaoCela;
    }

    /**
     * @return the idFunc
     */
    public Integer getIdFunc() {
        return idFunc;
    }

    /**
     * @param idFunc the idFunc to set
     */
    public void setIdFunc(Integer idFunc) {
        this.idFunc = idFunc;
    }

    /**
     * @return the NomeFunc
     */
    public String getNomeFunc() {
        return NomeFunc;
    }

    /**
     * @param NomeFunc the NomeFunc to set
     */
    public void setNomeFunc(String NomeFunc) {
        this.NomeFunc = NomeFunc;
    }

    /**
     * @return the idKit
     */
    public Integer getIdKit() {
        return idKit;
    }

    /**
     * @param idKit the idKit to set
     */
    public void setIdKit(Integer idKit) {
        this.idKit = idKit;
    }

    /**
     * @return the tipoKit
     */
    public String getTipoKit() {
        return tipoKit;
    }

    /**
     * @param tipoKit the tipoKit to set
     */
    public void setTipoKit(String tipoKit) {
        this.tipoKit = tipoKit;
    }

    /**
     * @return the situacaoInterno
     */
    public String getSituacaoInterno() {
        return situacaoInterno;
    }

    /**
     * @param situacaoInterno the situacaoInterno to set
     */
    public void setSituacaoInterno(String situacaoInterno) {
        this.situacaoInterno = situacaoInterno;
    }

    /**
     * @return the idRegistroKit
     */
    public Integer getIdRegistroKit() {
        return idRegistroKit;
    }

    /**
     * @param idRegistroKit the idRegistroKit to set
     */
    public void setIdRegistroKit(Integer idRegistroKit) {
        this.idRegistroKit = idRegistroKit;
    }

    /**
     * @return the dataRegistroKit
     */
    public Date getDataRegistroKit() {
        return dataRegistroKit;
    }

    /**
     * @param dataRegistroKit the dataRegistroKit to set
     */
    public void setDataRegistroKit(Date dataRegistroKit) {
        this.dataRegistroKit = dataRegistroKit;
    }

    /**
     * @return the motivoCancelamento
     */
    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    /**
     * @param motivoCancelamento the motivoCancelamento to set
     */
    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    /**
     * @return the idItemSA
     */
    public Integer getIdItemSA() {
        return idItemSA;
    }

    /**
     * @param idItemSA the idItemSA to set
     */
    public void setIdItemSA(Integer idItemSA) {
        this.idItemSA = idItemSA;
    }

    /**
     * @return the idItemINT
     */
    public Integer getIdItemINT() {
        return idItemINT;
    }

    /**
     * @param idItemINT the idItemINT to set
     */
    public void setIdItemINT(Integer idItemINT) {
        this.idItemINT = idItemINT;
    }

    /**
     * @return the idInternoKit
     */
    public Integer getIdInternoKit() {
        return idInternoKit;
    }

    /**
     * @param idInternoKit the idInternoKit to set
     */
    public void setIdInternoKit(Integer idInternoKit) {
        this.idInternoKit = idInternoKit;
    }

    /**
     * @return the matriculaInterno
     */
    public String getMatriculaInterno() {
        return matriculaInterno;
    }

    /**
     * @param matriculaInterno the matriculaInterno to set
     */
    public void setMatriculaInterno(String matriculaInterno) {
        this.matriculaInterno = matriculaInterno;
    }

    /**
     * @return the regimeInterno
     */
    public String getRegimeInterno() {
        return regimeInterno;
    }

    /**
     * @param regimeInterno the regimeInterno to set
     */
    public void setRegimeInterno(String regimeInterno) {
        this.regimeInterno = regimeInterno;
    }

    /**
     * @return the nomeInternoKit
     */
    public String getNomeInternoKit() {
        return nomeInternoKit;
    }

    /**
     * @param nomeInternoKit the nomeInternoKit to set
     */
    public void setNomeInternoKit(String nomeInternoKit) {
        this.nomeInternoKit = nomeInternoKit;
    }

    /**
     * @return the idItemPRO
     */
    public Integer getIdItemPRO() {
        return idItemPRO;
    }

    /**
     * @param idItemPRO the idItemPRO to set
     */
    public void setIdItemPRO(Integer idItemPRO) {
        this.idItemPRO = idItemPRO;
    }

    /**
     * @return the codigoProduto
     */
    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * @param codigoProduto the codigoProduto to set
     */
    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    /**
     * @return the unidadeProduto
     */
    public String getUnidadeProduto() {
        return unidadeProduto;
    }

    /**
     * @param unidadeProduto the unidadeProduto to set
     */
    public void setUnidadeProduto(String unidadeProduto) {
        this.unidadeProduto = unidadeProduto;
    }

    /**
     * @return the quantidadeProduto
     */
    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    /**
     * @param quantidadeProduto the quantidadeProduto to set
     */
    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    /**
     * @return the dataEntrega
     */
    public Date getDataEntrega() {
        return dataEntrega;
    }

    /**
     * @param dataEntrega the dataEntrega to set
     */
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }
}
