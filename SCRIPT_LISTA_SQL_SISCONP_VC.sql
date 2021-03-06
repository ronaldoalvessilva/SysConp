USE [master]
GO
/****** Object:  Database [DB_SOCIALIZA_VC]    Script Date: 01/06/2020 08:40:59 ******/
CREATE DATABASE [DB_SOCIALIZA_VC]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DB_SOCIALIZA_VC', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\DB_SOCIALIZA_VC.mdf' , SIZE = 1248320KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'DB_SOCIALIZA_VC_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\DB_SOCIALIZA_VC_log.ldf' , SIZE = 5605504KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DB_SOCIALIZA_VC].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET ARITHABORT OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET RECOVERY FULL 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET  MULTI_USER 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'DB_SOCIALIZA_VC', N'ON'
GO
USE [DB_SOCIALIZA_VC]
GO
/****** Object:  Table [dbo].[ACOMPANHAMENTO_INTERNO_ENFERMARIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ACOMPANHAMENTO_INTERNO_ENFERMARIA](
	[IdEnf] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdEvoEnfer] [int] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataReg] [datetime] NULL,
	[Diabetes] [varchar](3) NULL,
	[DiabControl] [varchar](3) NULL,
	[QtdDiabetes] [int] NULL,
	[Hipertensao] [varchar](3) NULL,
	[HiperControl] [varchar](3) NULL,
	[QtdHipertensao] [int] NULL,
	[Escabiose] [varchar](3) NULL,
	[EscabioseCura] [varchar](3) NULL,
	[QtdEscabiose] [int] NULL,
	[Hanseniase] [varchar](3) NULL,
	[HanseniaseCura] [varchar](3) NULL,
	[QtdHanseniase] [int] NULL,
	[Sifilis] [varchar](13) NULL,
	[SifilisCura] [varchar](3) NULL,
	[QtdSifilis] [int] NULL,
	[Tuberculose] [varchar](13) NULL,
	[TuberculoseCura] [varchar](3) NULL,
	[QtdTuberculose] [int] NULL,
	[Hiv] [varchar](13) NULL,
	[HivControlada] [varchar](3) NULL,
	[QtdHiv] [int] NULL,
	[HepatiteB] [varchar](13) NULL,
	[HepatiteBCont] [varchar](3) NULL,
	[QtdHepatiteB] [int] NULL,
	[HepatiteC] [varchar](13) NULL,
	[HepatiteCCont] [varchar](3) NULL,
	[QtdHepatiteC] [int] NULL,
	[Dst] [varchar](13) NULL,
	[DstCurada] [varchar](3) NULL,
	[QtdDst] [int] NULL,
	[Vdlr] [varchar](13) NULL,
	[VdlrCurada] [varchar](3) NULL,
	[QtdVdlr] [int] NULL,
	[Vacina] [varchar](3) NULL,
	[VacinaCura] [varchar](3) NULL,
	[QtdVacina] [int] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEnf] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ACUMULADOR_REMICAO_INTERNO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ACUMULADOR_REMICAO_INTERNO](
	[IdAcum] [int] IDENTITY(1,1) NOT NULL,
	[DataRegistro] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdResenha] [int] NOT NULL,
	[DiaResenha] [int] NULL,
	[Validacao] [real] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAcum] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ADME_AFP1]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADME_AFP1](
	[IdAfp1] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Hipertensao] [varchar](7) NULL,
	[Cardiopatias] [varchar](7) NULL,
	[Anemias] [varchar](7) NULL,
	[DoencasRenais] [varchar](7) NULL,
	[Diabetes] [varchar](7) NULL,
	[APAlergias] [varchar](7) NULL,
	[PortadorHIV] [varchar](7) NULL,
	[Transfusao] [varchar](7) NULL,
	[Retroviarias] [varchar](7) NULL,
	[QuaisRetroviarias] [varchar](50) NULL,
	[Cirurgias] [varchar](7) NULL,
	[DataCirurgia] [datetime] NULL,
	[TipoCirurgia] [varchar](100) NULL,
	[Ciclos] [varchar](max) NULL,
	[Metodos] [varchar](max) NULL,
	[Doencas] [varchar](max) NULL,
	[Colpocitologia] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAfp1] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ADME_AFP2]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADME_AFP2](
	[IdAfp2] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[NumeroGestacoes] [int] NULL,
	[NumeroPartos] [int] NULL,
	[NumeroAbortos] [int] NULL,
	[NumeroFilhosVivos] [int] NULL,
	[IdadePrimeiraGestacao] [int] NULL,
	[IntervaloGestacoes] [int] NULL,
	[Pretermo] [int] NULL,
	[Postermo] [int] NULL,
	[BaixoPeso] [int] NULL,
	[MortesNeonataisPrecoce] [int] NULL,
	[MotivoMorteNeonataisPrecoce] [varchar](250) NULL,
	[MortesNeonataisTardias] [int] NULL,
	[MotivoMortesNeonataisTardias] [varchar](250) NULL,
	[Natimortos] [int] NULL,
	[Ictericia] [int] NULL,
	[Transfusao] [int] NULL,
	[Hipoglicemia] [int] NULL,
	[IsoimunizacaoRH] [varchar](250) NULL,
	[IntercorrenciaComplicacoesGestoes] [varchar](max) NULL,
	[HistoriaAleitamentosAnteriores] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAfp2] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ADME_AFP3]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADME_AFP3](
	[IdAfp3] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataUltimaMenstruacao] [datetime] NULL,
	[Gestante] [varchar](7) NULL,
	[CertezaDuvidaGestacao] [varchar](200) NULL,
	[HabitosAlimentares] [varchar](200) NULL,
	[MedicamentoGestacao] [varchar](200) NULL,
	[InternacaoGestacao] [varchar](7) NULL,
	[OndeGestacao] [varchar](200) NULL,
	[Cigarro] [int] NULL,
	[Pacaia] [int] NULL,
	[Maconha] [int] NULL,
	[Cocaina] [int] NULL,
	[Craque] [int] NULL,
	[Alcool] [int] NULL,
	[Outros] [int] NULL,
	[QuaisDrogras] [varchar](100) NULL,
	[SinaisSintomas] [varchar](max) NULL,
	[OcupacaoHabitual] [varchar](max) NULL,
	[AceitacaoGravidez] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAfp3] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ADME_AFP4]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADME_AFP4](
	[IdAfp4] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[PesoGestante] [money] NULL,
	[AlturaGestante] [money] NULL,
	[Face] [int] NULL,
	[Tronco] [int] NULL,
	[MembroInferior] [int] NULL,
	[MembroSuperior] [int] NULL,
	[InspecaoPeleMucosa] [varchar](max) NULL,
	[PalpacaoTireoide] [varchar](max) NULL,
	[ExameAbdomem] [varchar](max) NULL,
	[AlturaUterina] [money] NULL,
	[PosicaoFetal] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAfp4] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ADMISSAO_EDUCACAO_FISICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADMISSAO_EDUCACAO_FISICA](
	[IdRegistroEF] [int] IDENTITY(1,1) NOT NULL,
	[StatusEF] [varchar](20) NULL,
	[DataRegistroEF] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[PesoEF] [float] NULL,
	[AlturaEF] [float] NULL,
	[AtividadeFisica] [varchar](3) NULL,
	[FrequenciaSemanal] [varchar](30) NULL,
	[NivelCondicionamento] [varchar](10) NULL,
	[RestricaoAtividadeFisica] [varchar](3) NULL,
	[QualRestricaoFisica] [varchar](100) NULL,
	[ProblemaCardiaco] [varchar](3) NULL,
	[QualProblemaCardiaco] [varchar](100) NULL,
	[AlgumTipoCirurgia] [varchar](3) NULL,
	[EspecificarCirurgia] [varchar](100) NULL,
	[ProblemaOrtopedico] [varchar](3) NULL,
	[HabitoFumar] [varchar](3) NULL,
	[QuantosCigarros] [int] NULL,
	[AlgumMedicamento] [varchar](3) NULL,
	[EspecificarMedicamento] [varchar](100) NULL,
	[Diabetico] [varchar](3) NULL,
	[PressaoSanguinea] [varchar](3) NULL,
	[DoresPeito] [varchar](3) NULL,
	[Desmaio] [varchar](3) NULL,
	[TextoEvolucaoAdmissao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRegistroEF] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ADMISSAO_EDUCACAO_FISICA_NOVA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADMISSAO_EDUCACAO_FISICA_NOVA](
	[IdRegistroEF_NOVA] [int] IDENTITY(1,1) NOT NULL,
	[StatusEF] [varchar](20) NULL,
	[DataRegistroEF] [datetime] NULL,
	[IdRegistroEF] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[PesoEF] [float] NULL,
	[AlturaEF] [float] NULL,
	[AtividadeFisica] [varchar](3) NULL,
	[FrequenciaSemanal] [varchar](30) NULL,
	[NivelCondicionamento] [varchar](10) NULL,
	[RestricaoAtividadeFisica] [varchar](3) NULL,
	[QualRestricaoFisica] [varchar](100) NULL,
	[ProblemaCardiaco] [varchar](3) NULL,
	[QualProblemaCardiaco] [varchar](100) NULL,
	[AlgumTipoCirurgia] [varchar](3) NULL,
	[EspecificarCirurgia] [varchar](100) NULL,
	[ProblemaOrtopedico] [varchar](3) NULL,
	[HabitoFumar] [varchar](3) NULL,
	[QuantosCigarros] [int] NULL,
	[AlgumMedicamento] [varchar](3) NULL,
	[EspecificarMedicamento] [varchar](100) NULL,
	[Diabetico] [varchar](3) NULL,
	[PressaoSanguinea] [varchar](3) NULL,
	[DoresPeito] [varchar](3) NULL,
	[Desmaio] [varchar](3) NULL,
	[TextoEvolucaoAdmissao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRegistroEF_NOVA] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ADMISSAO_ENFERMEIRA_COMPLEMENTAR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADMISSAO_ENFERMEIRA_COMPLEMENTAR](
	[IdADME] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[EstadoEmocional] [int] NULL,
	[SonoRepouso] [int] NULL,
	[NivelConsciencia] [int] NULL,
	[PressaoArterial] [varchar](10) NULL,
	[Hemograma] [varchar](10) NULL,
	[Temperatura] [varchar](10) NULL,
	[FrequenciaRespiratoria] [varchar](10) NULL,
	[Peso] [varchar](10) NULL,
	[FrequenciaCardiaca] [varchar](10) NULL,
	[UsaMedicamentos] [varchar](3) NULL,
	[QualMedicacao] [varchar](100) NULL,
	[Locomocao] [int] NULL,
	[AcuidadeVisual] [int] NULL,
	[AcuidadeAuditiva] [int] NULL,
	[FuncaoMotora] [int] NULL,
	[QualFuncaoMotora] [varchar](200) NULL,
	[FalaLinguagem] [int] NULL,
	[QualFala] [varchar](80) NULL,
	[Pele] [int] NULL,
	[Mucosa] [int] NULL,
	[TipoPele] [varchar](100) NULL,
	[Localizacao] [varchar](70) NULL,
	[Cabelos] [int] NULL,
	[Boca] [int] NULL,
	[FuncaoRespiratoria] [int] NULL,
	[Torax] [int] NULL,
	[FuncaoIntestinal] [int] NULL,
	[DiasConstipado] [varchar](20) NULL,
	[Abdome] [int] NULL,
	[FuncaoVesical] [int] NULL,
	[Genitalia] [int] NULL,
	[QualGenitalia] [varchar](100) NULL,
	[Vacinado] [varchar](10) NULL,
	[QuaisVacinas] [varchar](200) NULL,
	[Vdrl] [varchar](350) NULL,
	[HepatiteC] [varchar](350) NULL,
	[HepatiteB] [varchar](350) NULL,
	[Hiv] [varchar](350) NULL,
	[Cirurgias] [varchar](3) NULL,
	[QuaisCirurgias] [varchar](250) NULL,
	[UsuarioDrogas] [varchar](5) NULL,
	[QuaisDrogas] [varchar](300) NULL,
	[PortadorDoenca] [varchar](5) NULL,
	[QuaisDoencas] [varchar](300) NULL,
	[Alergias] [varchar](5) NULL,
	[QuaisAlergias] [varchar](300) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Sifilis] [varchar](20) NULL,
	[Hpv] [varchar](20) NULL,
	[Hipertensao] [varchar](20) NULL,
	[Diabetes] [varchar](20) NULL,
	[Tuberculose] [varchar](20) NULL,
	[Hanseniase] [varchar](30) NULL,
	[Escabiose] [varchar](3) NULL,
	[Dst] [varchar](30) NULL,
	[Vacina] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdADME] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ADMISSAO_JURIDICO_ADICIONAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADMISSAO_JURIDICO_ADICIONAL](
	[IdADM_JURI] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataEnca] [date] NULL,
	[TipoAdvogado] [varchar](50) NULL,
	[Resposta] [varchar](20) NULL,
	[HoraEnvio] [varchar](10) NULL,
	[SetorEncaminhamento] [varchar](300) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdADM_JURI] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ADMISSAO_MEDICA_ADICIONAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADMISSAO_MEDICA_ADICIONAL](
	[IdAdmADI] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdLanc] [int] NOT NULL,
	[CombBoxAR] [varchar](3) NULL,
	[CombBoxACV] [varchar](3) NULL,
	[CombBoxAGU] [varchar](3) NULL,
	[CombBoxCABPESC] [varchar](3) NULL,
	[CombBoxEXT] [varchar](3) NULL,
	[CombBoxABD] [varchar](3) NULL,
	[AR] [varchar](80) NULL,
	[ACV] [varchar](80) NULL,
	[AGU] [varchar](80) NULL,
	[CABPESC] [varchar](80) NULL,
	[EXT] [varchar](80) NULL,
	[ABD] [varchar](80) NULL,
	[Diagnostico] [varchar](max) NULL,
	[CirurgiasPrevisas] [varchar](100) NULL,
	[TratamentoCurso] [varchar](100) NULL,
	[Alergia] [varchar](3) NULL,
	[QuaisAlergias] [varchar](100) NULL,
	[QualDrogas] [varchar](100) NULL,
	[DrogaInjetavel] [varchar](3) NULL,
	[QualTipoDrogaInjet] [varchar](200) NULL,
	[QualEtilismo] [varchar](100) NULL,
	[QuantoTempoTabagismo] [varchar](100) NULL,
	[Drogas] [varchar](10) NULL,
	[Etilismo] [varchar](10) NULL,
	[Tabagismo] [varchar](10) NULL,
	[Sexualidade] [varchar](30) NULL,
	[UsaPreserva] [varchar](20) NULL,
	[NumeroPareceiro] [varchar](10) NULL,
	[TipoSangue] [varchar](3) NULL,
	[FatorRh] [varchar](15) NULL,
	[Vacinas] [varchar](3) NULL,
	[AtualizaIgnora] [varchar](20) NULL,
	[UsaMedicamento] [varchar](3) NULL,
	[QualMedicamento] [varchar](300) NULL,
	[OutrasAlergias] [varchar](3) NULL,
	[QuaisOutrasAlergias] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[DiagnosticoInicial] [varchar](max) NULL,
	[TipoDiag] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAdmADI] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ADMISSAO_PEDAGOGIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADMISSAO_PEDAGOGIA](
	[IdAdm] [int] IDENTITY(1,1) NOT NULL,
	[StatusAdm] [varchar](20) NULL,
	[DataAdm] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UltimaEscola] [varchar](150) NULL,
	[SerieAno] [varchar](80) NULL,
	[Turno] [varchar](100) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAdm] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ADMISSAO_PEDAGOGIA_NOVA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADMISSAO_PEDAGOGIA_NOVA](
	[IdAdmNova] [int] IDENTITY(1,1) NOT NULL,
	[StatusAdm] [varchar](20) NULL,
	[DataAdm] [datetime] NULL,
	[IdAdm] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UltimaEscola] [varchar](150) NULL,
	[SerieAno] [varchar](80) NULL,
	[Turno] [varchar](100) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAdmNova] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ADMISSAO_TERAPIA_PE]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADMISSAO_TERAPIA_PE](
	[IdATN] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Dominancia] [varchar](10) NULL,
	[Amputacao] [varchar](3) NULL,
	[DeficienciaOcupa] [varchar](3) NULL,
	[Reabilitacao] [varchar](3) NULL,
	[Motora] [varchar](3) NULL,
	[Cognitiva] [varchar](3) NULL,
	[Sensorial] [varchar](3) NULL,
	[IntPsi] [varchar](3) NULL,
	[AVD] [varchar](3) NULL,
	[AIVD] [varchar](3) NULL,
	[Lazer] [varchar](3) NULL,
	[Trabalho] [varchar](3) NULL,
	[ObsDesempenhoOcupacional] [varchar](max) NULL,
	[PaisVivos] [varchar](3) NULL,
	[TemCompanheira] [varchar](3) NULL,
	[TemFilhos] [varchar](3) NULL,
	[QuantosFilhos] [int] NULL,
	[VisitaFamiliar] [varchar](3) NULL,
	[SFSeg] [int] NULL,
	[SFTer] [int] NULL,
	[SFQua] [int] NULL,
	[SFQui] [int] NULL,
	[SFSex] [int] NULL,
	[SFSab] [int] NULL,
	[SFDom] [int] NULL,
	[VisitaIntima] [varchar](3) NULL,
	[IntSeg] [int] NULL,
	[IntTer] [int] NULL,
	[IntQua] [int] NULL,
	[IntQui] [int] NULL,
	[IntSex] [int] NULL,
	[IntSab] [int] NULL,
	[IntDom] [int] NULL,
	[ObsHistoricoFamiliar] [varchar](max) NULL,
	[Hipertensao] [varchar](3) NULL,
	[Diabetes] [varchar](3) NULL,
	[Cancer] [varchar](3) NULL,
	[ProRespiratorio] [varchar](3) NULL,
	[TransMental] [varchar](3) NULL,
	[InfectoContagiosa] [varchar](3) NULL,
	[DoencasDigestiva] [varchar](3) NULL,
	[DeficienciaVAF] [varchar](3) NULL,
	[ObsDadosClinicos] [varchar](max) NULL,
	[Humor] [varchar](3) NULL,
	[Insonia] [varchar](3) NULL,
	[Irritabilidade] [varchar](3) NULL,
	[Frustracao] [varchar](3) NULL,
	[DificuldadeConcentrar] [varchar](3) NULL,
	[Raiva] [varchar](3) NULL,
	[Inquietacao] [varchar](3) NULL,
	[Ansiedade] [varchar](3) NULL,
	[ObsAlteracoesPsicologicas] [varchar](max) NULL,
	[Tabagismo] [varchar](3) NULL,
	[QuantoTabagismo] [int] NULL,
	[TabagismoUsuario] [varchar](30) NULL,
	[Etilismo] [varchar](3) NULL,
	[TipoEtilismo] [varchar](32) NULL,
	[EtilismoUsuario] [varchar](30) NULL,
	[MedicacaoAlopatica] [varchar](3) NULL,
	[TipoMedicacaoAlopatica] [varchar](32) NULL,
	[MedicacaoAlopaticaUsuario] [varchar](32) NULL,
	[SPA] [varchar](3) NULL,
	[TipoSPA] [varchar](32) NULL,
	[SPAUsuario] [varchar](30) NULL,
	[ObsTriagemSPA] [varchar](max) NULL,
	[VidaSexual] [varchar](3) NULL,
	[MetodoContraCeptivo] [varchar](3) NULL,
	[QualMetodoContraCeptivo] [varchar](30) NULL,
	[Menarca] [varchar](3) NULL,
	[Menopausa] [varchar](3) NULL,
	[Gestante] [varchar](3) NULL,
	[Aborto] [varchar](3) NULL,
	[MotivoAborto] [varchar](60) NULL,
	[PraticaAtividadeFisica] [varchar](3) NULL,
	[QualAtividadeFisica] [varchar](60) NULL,
	[TrataPsicologico] [varchar](3) NULL,
	[ObsEstiloVida] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdATN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ADMISSAOENFERMEIRA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADMISSAOENFERMEIRA](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[EstadoEmocional] [int] NULL,
	[SonoRepouso] [int] NULL,
	[NivelConsciencia] [int] NULL,
	[PressaoArterial] [varchar](10) NULL,
	[Hemograma] [varchar](10) NULL,
	[Temperatura] [varchar](10) NULL,
	[FrequenciaRespiratoria] [varchar](10) NULL,
	[Peso] [varchar](10) NULL,
	[FrequenciaCardiaca] [varchar](10) NULL,
	[UsaMedicamentos] [varchar](3) NULL,
	[QualMedicacao] [varchar](100) NULL,
	[Locomocao] [int] NULL,
	[AcuidadeVisual] [int] NULL,
	[AcuidadeAuditiva] [int] NULL,
	[FuncaoMotora] [int] NULL,
	[QualFuncaoMotora] [varchar](200) NULL,
	[FalaLinguagem] [int] NULL,
	[QualFala] [varchar](80) NULL,
	[Pele] [int] NULL,
	[Mucosa] [int] NULL,
	[TipoPele] [varchar](100) NULL,
	[Localizacao] [varchar](70) NULL,
	[Cabelos] [int] NULL,
	[Boca] [int] NULL,
	[FuncaoRespiratoria] [int] NULL,
	[Torax] [int] NULL,
	[FuncaoIntestinal] [int] NULL,
	[DiasConstipado] [varchar](20) NULL,
	[Abdome] [int] NULL,
	[FuncaoVesical] [int] NULL,
	[Genitalia] [int] NULL,
	[QualGenitalia] [varchar](100) NULL,
	[Vacinado] [varchar](10) NULL,
	[QuaisVacinas] [varchar](200) NULL,
	[Vdrl] [varchar](350) NULL,
	[HepatiteC] [varchar](350) NULL,
	[HepatiteB] [varchar](350) NULL,
	[Hiv] [varchar](350) NULL,
	[Cirurgias] [varchar](3) NULL,
	[QuaisCirurgias] [varchar](250) NULL,
	[UsuarioDrogas] [varchar](5) NULL,
	[QuaisDrogas] [varchar](300) NULL,
	[PortadorDoenca] [varchar](5) NULL,
	[QuaisDoencas] [varchar](300) NULL,
	[Alergias] [varchar](5) NULL,
	[QuaisAlergias] [varchar](300) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Sifilis] [varchar](20) NULL,
	[Hpv] [varchar](20) NULL,
	[Diabetes] [varchar](20) NULL,
	[Hipertensao] [varchar](20) NULL,
	[Tuberculose] [varchar](20) NULL,
	[Hanseniase] [varchar](30) NULL,
	[Escabiose] [varchar](3) NULL,
	[Dst] [varchar](30) NULL,
	[Vacina] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ADMISSAOMEDICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADMISSAOMEDICA](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[CombBoxAR] [varchar](3) NULL,
	[CombBoxACV] [varchar](3) NULL,
	[CombBoxAGU] [varchar](3) NULL,
	[CombBoxCABPESC] [varchar](3) NULL,
	[CombBoxEXT] [varchar](3) NULL,
	[CombBoxABD] [varchar](3) NULL,
	[AR] [varchar](80) NULL,
	[ACV] [varchar](80) NULL,
	[AGU] [varchar](80) NULL,
	[CABPESC] [varchar](80) NULL,
	[EXT] [varchar](80) NULL,
	[ABD] [varchar](80) NULL,
	[Diagnostico] [varchar](max) NULL,
	[CirurgiasPrevisas] [varchar](100) NULL,
	[TratamentoCurso] [varchar](100) NULL,
	[Alergia] [varchar](3) NULL,
	[QuaisAlergias] [varchar](100) NULL,
	[QualDrogas] [varchar](100) NULL,
	[DrogaInjetavel] [varchar](3) NULL,
	[QualTipoDrogaInjet] [varchar](200) NULL,
	[QualEtilismo] [varchar](100) NULL,
	[QuantoTempoTabagismo] [varchar](100) NULL,
	[Drogas] [varchar](10) NULL,
	[Etilismo] [varchar](10) NULL,
	[Tabagismo] [varchar](10) NULL,
	[Sexualidade] [varchar](30) NULL,
	[UsaPreserva] [varchar](20) NULL,
	[NumeroPareceiro] [varchar](10) NULL,
	[TipoSangue] [varchar](3) NULL,
	[FatorRh] [varchar](15) NULL,
	[Vacinas] [varchar](3) NULL,
	[AtualizaIgnora] [varchar](20) NULL,
	[UsaMedicamento] [varchar](3) NULL,
	[QualMedicamento] [varchar](300) NULL,
	[OutrasAlergias] [varchar](3) NULL,
	[QuaisOutrasAlergias] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[DiagnosticoInicial] [varchar](max) NULL,
	[TipoDiag] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ADMISSAOPSI]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADMISSAOPSI](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[PresoAntes] [varchar](3) NULL,
	[FamiliaPreso] [varchar](3) NULL,
	[QuemFamiliaPreso] [varchar](80) NULL,
	[OndePreso] [varchar](80) NULL,
	[HistoricoCriminal] [varchar](max) NULL,
	[UsaDrogras] [varchar](3) NULL,
	[Alcool] [int] NULL,
	[Cigarro] [int] NULL,
	[Maconha] [int] NULL,
	[Crack] [int] NULL,
	[Cocaina] [int] NULL,
	[Cola] [int] NULL,
	[Outros] [int] NULL,
	[OutrasDrogas] [varchar](50) NULL,
	[QualIdade] [varchar](5) NULL,
	[PorqueUsaDrogas] [varchar](50) NULL,
	[Drogas] [varchar](max) NULL,
	[TratamentoPSI] [varchar](3) NULL,
	[MedicamentoPSI] [varchar](3) NULL,
	[QualMedicamento] [varchar](80) NULL,
	[AcompanhaPSI] [varchar](15) NULL,
	[TranstornoMental] [varchar](max) NULL,
	[DepartamentoEncaminha] [varchar](300) NULL,
	[DataEncaminhamento] [datetime] NULL,
	[HoraAcompanha] [varchar](10) NULL,
	[Encaminhamento] [varchar](max) NULL,
	[TratamentoSaude] [varchar](3) NULL,
	[QualTratamentoSaude] [varchar](40) NULL,
	[OndeFazTratamento] [varchar](90) NULL,
	[TratamentoAnteriores] [varchar](max) NULL,
	[SituacaoTraumatica] [varchar](3) NULL,
	[QualSituacaoTraumatica] [varchar](30) NULL,
	[HouveTentativaSuicidio] [varchar](3) NULL,
	[PorQueSuicidio] [varchar](50) NULL,
	[ComoFoiTentarSuicidio] [varchar](30) NULL,
	[OndeTentouSuicidio] [varchar](50) NULL,
	[TentativaSuicidio] [varchar](max) NULL,
	[QualMedicamentoUtiliza] [varchar](100) NULL,
	[PorqueUsaMedicamento] [varchar](100) NULL,
	[UsoMedicamentos] [varchar](max) NULL,
	[RecebeVisitas] [varchar](3) NULL,
	[Familiares] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ADVOGADOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADVOGADOS](
	[IdAdvogado] [int] IDENTITY(1,1) NOT NULL,
	[DataCadastro] [datetime] NULL,
	[FotoAdvogado] [varchar](350) NULL,
	[NomeAdvogado] [varchar](200) NULL,
	[RgAdvogado] [varchar](20) NULL,
	[CpfAdvogado] [varchar](20) NULL,
	[OabAdvogado] [varchar](20) NULL,
	[ObsAdvogado] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[StatusAdv] [varchar](100) NULL,
	[ImagemFrenteAD] [varbinary](max) NULL,
	[NomeMae] [varchar](200) NULL,
	[NomePai] [varchar](200) NULL,
	[SituacaoCadastral] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAdvogado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AGENDA_ATENDIMENTO_INTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AGENDA_ATENDIMENTO_INTERNOS](
	[IdReg] [int] IDENTITY(1,1) NOT NULL,
	[StatusReg] [varchar](30) NULL,
	[DataReg] [datetime] NULL,
	[Departamento] [varchar](250) NULL,
	[DataAg] [date] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReg] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA](
	[IdReg] [int] IDENTITY(1,1) NOT NULL,
	[StatusReg] [varchar](30) NULL,
	[DataReg] [datetime] NULL,
	[Departamento] [varchar](250) NULL,
	[DataAg] [date] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReg] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AGENDA_BENEFICIO_INTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AGENDA_BENEFICIO_INTERNOS](
	[IdReg] [int] IDENTITY(1,1) NOT NULL,
	[StatusReg] [varchar](30) NULL,
	[DataReg] [datetime] NULL,
	[TipoBeneficio] [varchar](250) NULL,
	[DataAg] [datetime] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReg] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AGENDA_COMPROMISSOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AGENDA_COMPROMISSOS](
	[IdAgenda] [int] IDENTITY(1,1) NOT NULL,
	[StatusAgenda] [varchar](30) NULL,
	[TipoEvento] [varchar](50) NULL,
	[DataAgenda] [date] NULL,
	[Assunto] [varchar](250) NULL,
	[Prioridade] [varchar](40) NULL,
	[Conclusao] [varchar](40) NULL,
	[DataInicio] [date] NULL,
	[DataTermino] [date] NULL,
	[HoraInicio] [varchar](10) NULL,
	[HoraTermino] [varchar](10) NULL,
	[DataLembrete] [date] NULL,
	[HoraLembrete] [varchar](5) NULL,
	[Texto] [varchar](max) NULL,
	[UsuarioAgenda] [varchar](250) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAgenda] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AGENDAESCOLTA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AGENDAESCOLTA](
	[IdAgenda] [int] IDENTITY(1,1) NOT NULL,
	[DataAgenda] [datetime] NULL,
	[StatusAgenda] [varchar](30) NULL,
	[ObsAgenda] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAgenda] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AGENDALABORATIVA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AGENDALABORATIVA](
	[IdAgenda] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](30) NULL,
	[DataCadastro] [datetime] NULL,
	[IdEmp] [int] NOT NULL,
	[ObsLanc] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAgenda] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AGENDARECADOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AGENDARECADOS](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[Horario] [varchar](10) NULL,
	[StatusAgenda] [varchar](30) NULL,
	[NomeUsuarioLogado] [varchar](300) NULL,
	[IdUsuario] [int] NOT NULL,
	[Recados] [varchar](max) NULL,
	[MensagemENviada] [varchar](10) NULL,
	[MensagemRecebida] [varchar](10) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA](
	[IdRegAlerta] [int] IDENTITY(1,1) NOT NULL,
	[IdRegistroAD] [int] NULL,
	[IdRegistroVI] [int] NULL,
	[IdRegistroOF] [int] NULL,
	[DataChegada] [datetime] NULL,
	[HoraChegada] [varchar](20) NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdPav] [int] NOT NULL,
	[IdVisita] [int] NULL,
	[IdAdvogado] [int] NULL,
	[IdOficial] [int] NULL,
	[AssinaturaDigitalVisita] [varbinary](max) NULL,
	[Confirmacao] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRegAlerta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AMPARO_LEGAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AMPARO_LEGAL](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](30) NULL,
	[DataLanc] [date] NULL,
	[DescricaoAmparoLegal] [varchar](350) NOT NULL,
	[Artigo] [varchar](17) NULL,
	[Paragrafo] [varchar](17) NULL,
	[Inciso] [varchar](17) NULL,
	[Alinea] [varchar](17) NULL,
	[Texto] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[APOIOPROCEDIMENTO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[APOIOPROCEDIMENTO](
	[IdApoio] [int] IDENTITY(1,1) NOT NULL,
	[IdProc] [int] NOT NULL,
	[IdFunc] [int] NOT NULL,
	[TipoAuxilio] [varchar](30) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdApoio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[APRAZAMENTO_MEDICACAO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[APRAZAMENTO_MEDICACAO](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdReq] [int] NULL,
	[IdItem] [int] NULL,
	[IdPres] [int] NULL,
	[Observacao] [varchar](max) NULL,
	[TipoAprazamento] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[APRENSSOES]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[APRENSSOES](
	[IdAprende] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdObjeto] [int] NOT NULL,
	[Qtd] [float] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAprende] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[APROVACAO_SOLICITACAO_COMPRAS_ADM]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[APROVACAO_SOLICITACAO_COMPRAS_ADM](
	[IdAprova] [int] IDENTITY(1,1) NOT NULL,
	[StatusAprova] [varchar](30) NULL,
	[DataAprova] [date] NULL,
	[UsuarioAprovador] [varchar](300) NULL,
	[IdSol] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[ValorSolicitado] [money] NULL,
	[ValorAutorizado] [money] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAprova] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[APROVADOR_REQUISICAO_MEDICAMENTOS_ENFAR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[APROVADOR_REQUISICAO_MEDICAMENTOS_ENFAR](
	[IdFuncAprova] [int] IDENTITY(1,1) NOT NULL,
	[FotoFuncAprova] [varchar](300) NULL,
	[StatusAprova] [varchar](20) NULL,
	[TipoAprova] [varchar](50) NULL,
	[NomeAprovador] [varchar](300) NULL,
	[IdDepartamento] [int] NOT NULL,
	[ValorRequisicao] [money] NULL,
	[ValorPedido] [money] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFuncAprova] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[APROVADOR_SOLICITACAO_COMPRAS_AC]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[APROVADOR_SOLICITACAO_COMPRAS_AC](
	[IdFuncAprova] [int] IDENTITY(1,1) NOT NULL,
	[StatusAprova] [varchar](20) NULL,
	[TipoAprova] [varchar](50) NULL,
	[NomeAprovador] [varchar](300) NULL,
	[IdFunc] [int] NOT NULL,
	[ValorSolicita] [money] NULL,
	[ValorPedido] [money] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFuncAprova] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[APROVADORES_OCORRENCIA_PORTARIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[APROVADORES_OCORRENCIA_PORTARIA](
	[IdAprova] [int] IDENTITY(1,1) NOT NULL,
	[StatusAprova] [varchar](15) NULL,
	[DataAprova] [date] NULL,
	[IdUsuario] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[ModDep] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAprova] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ASSISTENCIA_EDUCACAO_EXTERNA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ASSISTENCIA_EDUCACAO_EXTERNA](
	[IdEduca] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [date] NULL,
	[IdCod] [int] NOT NULL,
	[IdTurno] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[IdCurso] [int] NOT NULL,
	[DiaSeg] [int] NOT NULL,
	[DiaTer] [int] NOT NULL,
	[DiaQua] [int] NOT NULL,
	[DiaQui] [int] NOT NULL,
	[DiaSex] [int] NOT NULL,
	[DiaSab] [int] NOT NULL,
	[DiaDom] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEduca] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTO_GRUPO_EF]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTO_GRUPO_EF](
	[IdAtGrupoEF] [int] IDENTITY(1,1) NOT NULL,
	[StatusAtendGrupo] [varchar](15) NULL,
	[DataAtend] [datetime] NULL,
	[Responsavel] [varchar](200) NULL,
	[IdPav] [int] NOT NULL,
	[Ambiente] [varchar](200) NULL,
	[HoraioInicio] [varchar](20) NULL,
	[HorarioTermino] [varchar](20) NULL,
	[LocalAtividade] [varchar](200) NULL,
	[GrupoAtividade] [varchar](200) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAtGrupoEF] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTO_GRUPO_ENFERMAGEM]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTO_GRUPO_ENFERMAGEM](
	[IdAtGrupoEnf] [int] IDENTITY(1,1) NOT NULL,
	[StatusAtendGrupo] [varchar](15) NULL,
	[DataAtend] [datetime] NULL,
	[Responsavel] [varchar](200) NULL,
	[IdPav] [int] NOT NULL,
	[Ambiente] [varchar](200) NULL,
	[HoraioInicio] [varchar](20) NULL,
	[HorarioTermino] [varchar](20) NULL,
	[LocalAtividade] [varchar](200) NULL,
	[GrupoAtividade] [varchar](200) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAtGrupoEnf] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTO_GRUPO_PE]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTO_GRUPO_PE](
	[IdAtGrupoPE] [int] IDENTITY(1,1) NOT NULL,
	[StatusAtendGrupo] [varchar](15) NULL,
	[DataAtend] [datetime] NULL,
	[Responsavel] [varchar](200) NULL,
	[IdPav] [int] NOT NULL,
	[Ambiente] [varchar](200) NULL,
	[HoraioInicio] [varchar](20) NULL,
	[HorarioTermino] [varchar](20) NULL,
	[LocalAtividade] [varchar](200) NULL,
	[GrupoAtividade] [varchar](200) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAtGrupoPE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTO_GRUPO_PSICOLOGIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTO_GRUPO_PSICOLOGIA](
	[IdAtGrupoPsi] [int] IDENTITY(1,1) NOT NULL,
	[StatusAtendGrupo] [varchar](15) NULL,
	[DataAtend] [datetime] NULL,
	[Responsavel] [varchar](200) NULL,
	[IdPav] [int] NOT NULL,
	[Ambiente] [varchar](200) NULL,
	[HoraioInicio] [varchar](20) NULL,
	[HorarioTermino] [varchar](20) NULL,
	[LocalAtividade] [varchar](200) NULL,
	[GrupoAtividade] [varchar](200) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAtGrupoPsi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTO_GRUPO_SS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTO_GRUPO_SS](
	[IdAtGrupoSS] [int] IDENTITY(1,1) NOT NULL,
	[StatusAtendGrupo] [varchar](15) NULL,
	[DataAtend] [datetime] NULL,
	[Responsavel] [varchar](200) NULL,
	[IdPav] [int] NOT NULL,
	[Ambiente] [varchar](200) NULL,
	[HoraioInicio] [varchar](20) NULL,
	[HorarioTermino] [varchar](20) NULL,
	[LocalAtividade] [varchar](200) NULL,
	[GrupoAtividade] [varchar](200) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAtGrupoSS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTO_GRUPO_TO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTO_GRUPO_TO](
	[IdAtGrupoTO] [int] IDENTITY(1,1) NOT NULL,
	[StatusAtendGrupo] [varchar](15) NULL,
	[DataAtend] [datetime] NULL,
	[Responsavel] [varchar](200) NULL,
	[IdPav] [int] NOT NULL,
	[Ambiente] [varchar](200) NULL,
	[HoraioInicio] [varchar](20) NULL,
	[HorarioTermino] [varchar](20) NULL,
	[LocalAtividade] [varchar](200) NULL,
	[GrupoAtividade] [varchar](200) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAtGrupoTO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTO_PSP_INTERNO_TV]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTO_PSP_INTERNO_TV](
	[IdAPIT] [int] IDENTITY(1,1) NOT NULL,
	[StatusAtendimento] [varchar](80) NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdDepartamento] [int] NOT NULL,
	[IdRegistro] [int] NOT NULL,
	[Atendendo] [varchar](3) NULL,
	[UsuarioAtendente] [varchar](50) NULL,
	[DataAtendimento] [varchar](20) NULL,
	[HorarioInicio] [varchar](10) NULL,
	[HorarioTermino] [varchar](20) NULL,
	[Concluido] [varchar](3) NULL,
	[IdAdentimento] [int] NULL,
	[TipoAtendimento] [varchar](80) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAPIT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTODONTO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTODONTO](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TipoAtendimento] [varchar](30) NULL,
	[TratamentoMedico] [varchar](30) NULL,
	[Medicacao] [varchar](30) NULL,
	[Alegria] [varchar](30) NULL,
	[QueixaPrincipal] [varchar](80) NULL,
	[Afirmacao1] [varchar](80) NULL,
	[Afirmacao2] [varchar](80) NULL,
	[Afirmacao3] [varchar](80) NULL,
	[Hepatite] [varchar](30) NULL,
	[PlanoTratamento] [varchar](max) NULL,
	[Hiv] [varchar](30) NULL,
	[Asma] [varchar](30) NULL,
	[Fumante] [varchar](30) NULL,
	[Febre] [varchar](30) NULL,
	[Diabetes] [varchar](30) NULL,
	[Epilepsia] [varchar](30) NULL,
	[Cicatrizacao] [varchar](30) NULL,
	[Disturbios] [varchar](30) NULL,
	[Endocardite] [varchar](30) NULL,
	[Epatico] [varchar](30) NULL,
	[Renal] [varchar](30) NULL,
	[Cardiaco] [varchar](30) NULL,
	[Tensao] [varchar](30) NULL,
	[Cirurgia] [varchar](30) NULL,
	[Internacao] [varchar](30) NULL,
	[TextoDoenca] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Gestante] [varchar](7) NULL,
	[TempoGestacao] [varchar](5) NULL,
	[Observacao] [varchar](max) NULL,
	[Sifilis] [varchar](7) NULL,
	[Tuberculose] [varchar](7) NULL,
	[Outras] [varchar](7) NULL,
	[QualOutraDoenca] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTOFAMILIAR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTOFAMILIAR](
	[IdAtendf] [int] IDENTITY(1,1) NOT NULL,
	[DataAtendf] [datetime] NULL,
	[IdVisita] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[StatusAtendf] [varchar](30) NULL,
	[Pergunta1Atendf] [varchar](max) NULL,
	[Pergunta2Atendf] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[CompanheiroUnidade] [varchar](3) NULL,
	[VisitaInternoUnidade] [varchar](3) NULL,
	[CreasCreas] [varchar](3) NULL,
	[BolsaFamilia] [varchar](3) NULL,
	[ReconhecerPaternidade] [varchar](15) NULL,
	[AuxilioReclusao] [varchar](15) NULL,
	[OutroBerneficio] [varchar](60) NULL,
	[PossuiFilhos] [varchar](25) NULL,
	[QuantidadeFilhos] [int] NULL,
	[QualIdade] [varchar](25) NULL,
	[Estudam] [varchar](25) NULL,
	[TipoEscola] [varchar](60) NULL,
	[ParticipaProjeto] [varchar](max) NULL,
	[Endereco] [varchar](150) NULL,
	[Cidade] [varchar](100) NULL,
	[Estado] [varchar](60) NULL,
	[Telefone1] [varchar](100) NULL,
	[Telefone2] [varchar](100) NULL,
	[Celular] [varchar](100) NULL,
	[Trabalha] [varchar](100) NULL,
	[Escolaridade] [varchar](100) NULL,
	[ProblemaSaude] [varchar](100) NULL,
	[QualProblemaSaude] [varchar](100) NULL,
	[UsoMedicacao] [varchar](100) NULL,
	[QuaisMedicacoes] [varchar](60) NULL,
	[DoencaPermanente] [varchar](60) NULL,
	[QuaisDoencas] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAtendf] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTOFAMILIARJURIDICO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTOFAMILIARJURIDICO](
	[IdAtendf] [int] IDENTITY(1,1) NOT NULL,
	[DataAtendf] [datetime] NULL,
	[IdVisita] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[StatusAtendf] [varchar](30) NULL,
	[Evolucao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAtendf] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTOINTERNO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTOINTERNO](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](30) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[PedidoRec] [varchar](5) NULL,
	[DataPedRec] [datetime] NULL,
	[EncaSetor] [varchar](5) NULL,
	[QualSetor] [varchar](200) NULL,
	[EncaTirarDoc] [varchar](5) NULL,
	[DataTirarDoc] [datetime] NULL,
	[EncaRecPai] [varchar](5) NULL,
	[DataRecPai] [datetime] NULL,
	[CancelaVisita] [varchar](5) NULL,
	[MotivoCancelVisita] [varchar](100) NULL,
	[Outros] [varchar](300) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTOJURIDICO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTOJURIDICO](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataEnca] [date] NULL,
	[TipoAdvogado] [varchar](50) NULL,
	[Resposta] [varchar](20) NULL,
	[HoraEnvio] [varchar](10) NULL,
	[SetorEncaminhamento] [varchar](300) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTOS_ANTIGO_PSP]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTOS_ANTIGO_PSP](
	[IdATEND_ANTIGO] [int] IDENTITY(1,1) NOT NULL,
	[StatusAtendimento] [varchar](80) NULL,
	[DataRegistro] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TipoAtendimento] [varchar](50) NULL,
	[DataAtendimento] [datetime] NULL,
	[IdDepartamento] [int] NOT NULL,
	[UsuarioAtendente] [varchar](200) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdATEND_ANTIGO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTOSOCIAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTOSOCIAL](
	[IdAtend] [int] IDENTITY(1,1) NOT NULL,
	[DataAtend] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[StatusAtend] [varchar](30) NULL,
	[ContatoAtend] [varchar](200) NULL,
	[TelefoneAtend] [varchar](20) NULL,
	[Telefone1Atend] [varchar](20) NULL,
	[CelularAtend] [varchar](20) NULL,
	[EnderecoAtend] [varchar](250) NULL,
	[BairroAtend] [varchar](150) NULL,
	[CidadeAtend] [varchar](250) NULL,
	[EstadoAtend] [varchar](150) NULL,
	[CartTrabAtend] [varchar](10) NULL,
	[Periodo] [varchar](100) NULL,
	[RecebeRecluAtend] [varchar](10) NULL,
	[DireitoAuxAtend] [varchar](10) NULL,
	[RecebeBolAtend] [varchar](10) NULL,
	[QtdPessoasAtend] [varchar](10) NULL,
	[QtdTrabaAtend] [varchar](10) NULL,
	[CN1Atend] [varchar](10) NULL,
	[CN2Atend] [varchar](10) NULL,
	[RG1Atend] [varchar](10) NULL,
	[RG2atend] [varchar](10) NULL,
	[CPF1Atend] [varchar](10) NULL,
	[CPF2Atend] [varchar](10) NULL,
	[CTPS1Atend] [varchar](10) NULL,
	[CTPS2Atend] [varchar](10) NULL,
	[PossuiFilhosAtend] [varchar](10) NULL,
	[QtdFilhosAtend] [varchar](10) NULL,
	[FilhosNaoRegAtend] [varchar](10) NULL,
	[OutrosFilhosAtend] [varchar](10) NULL,
	[QtdFilhos2Atend] [varchar](10) NULL,
	[PaternidadeAtend] [varchar](10) NULL,
	[DefensorAtend] [varchar](50) NULL,
	[PartiFamiAtend] [varchar](30) NULL,
	[ConsiderAtend] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[MunicipioNascimento] [varchar](100) NULL,
	[Tituloeleito1] [varchar](3) NULL,
	[Tituloeleito2] [varchar](3) NULL,
	[Reservista1] [varchar](20) NULL,
	[Reservista2] [varchar](20) NULL,
	[CartorioRegistro] [varchar](80) NULL,
	[RecebeBeneficio] [varchar](15) NULL,
	[TempoConvivencia] [varchar](10) NULL,
	[EsposoCompanheiro] [varchar](20) NULL,
	[NomeEsposoCompanheiro] [varchar](60) NULL,
	[PessoasResideCasa] [varchar](10) NULL,
	[EncaOutroSetor] [varchar](3) NULL,
	[QualSetor] [varchar](40) NULL,
	[CancelarVisita] [varchar](3) NULL,
	[MotivoCancelarVisita] [varchar](50) NULL,
	[EncaTirarDoc] [varchar](3) NULL,
	[DataEncaDoc] [datetime] NULL,
	[EncaRecPaternidade] [varchar](3) NULL,
	[DataRecPaternidade] [datetime] NULL,
	[RecebeVisita] [varchar](3) NULL,
	[CondicaoSegurado] [varchar](3) NULL,
	[DataPeriodo2Atend] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAtend] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTOTECENFERMAGEM]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTOTECENFERMAGEM](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATENDIMENTOTERAPIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATENDIMENTOTERAPIA](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Dominancia] [varchar](10) NULL,
	[Amputacao] [varchar](3) NULL,
	[DeficienciaOcupa] [varchar](3) NULL,
	[Reabilitacao] [varchar](3) NULL,
	[Motora] [varchar](3) NULL,
	[Cognitiva] [varchar](3) NULL,
	[Sensorial] [varchar](3) NULL,
	[IntPsi] [varchar](3) NULL,
	[AVD] [varchar](3) NULL,
	[AIVD] [varchar](3) NULL,
	[Lazer] [varchar](3) NULL,
	[Trabalho] [varchar](3) NULL,
	[ObsDesempenhoOcupacional] [varchar](max) NULL,
	[PaisVivos] [varchar](3) NULL,
	[TemCompanheira] [varchar](3) NULL,
	[TemFilhos] [varchar](3) NULL,
	[QuantosFilhos] [int] NULL,
	[VisitaFamiliar] [varchar](3) NULL,
	[SFSeg] [int] NULL,
	[SFTer] [int] NULL,
	[SFQua] [int] NULL,
	[SFQui] [int] NULL,
	[SFSex] [int] NULL,
	[SFSab] [int] NULL,
	[SFDom] [int] NULL,
	[VisitaIntima] [varchar](3) NULL,
	[IntSeg] [int] NULL,
	[IntTer] [int] NULL,
	[IntQua] [int] NULL,
	[IntQui] [int] NULL,
	[IntSex] [int] NULL,
	[IntSab] [int] NULL,
	[IntDom] [int] NULL,
	[Hipertensao] [varchar](3) NULL,
	[Diabetes] [varchar](3) NULL,
	[Cancer] [varchar](3) NULL,
	[ProRespiratorio] [varchar](3) NULL,
	[TransMental] [varchar](3) NULL,
	[InfectoContagiosa] [varchar](3) NULL,
	[DoencasDigestiva] [varchar](3) NULL,
	[DeficienciaVAF] [varchar](3) NULL,
	[ObsDadosClinicos] [varchar](max) NULL,
	[Humor] [varchar](3) NULL,
	[Insonia] [varchar](3) NULL,
	[Irritabilidade] [varchar](3) NULL,
	[Frustracao] [varchar](3) NULL,
	[DificuldadeConcentrar] [varchar](3) NULL,
	[Raiva] [varchar](3) NULL,
	[Inquietacao] [varchar](3) NULL,
	[Ansiedade] [varchar](3) NULL,
	[ObsAlteracoesPsicologicas] [varchar](max) NULL,
	[Tabagismo] [varchar](3) NULL,
	[QuantoTabagismo] [int] NULL,
	[TabagismoUsuario] [varchar](30) NULL,
	[Etilismo] [varchar](3) NULL,
	[TipoEtilismo] [varchar](32) NULL,
	[EtilismoUsuario] [varchar](30) NULL,
	[MedicacaoAlopatica] [varchar](3) NULL,
	[MedicacaoAlopaticaUsuario] [varchar](32) NULL,
	[SPA] [varchar](3) NULL,
	[TipoSPA] [varchar](32) NULL,
	[SPAUsuario] [varchar](30) NULL,
	[ObsTriagemSPA] [varchar](max) NULL,
	[VidaSexual] [varchar](3) NULL,
	[MetodoContraCeptivo] [varchar](3) NULL,
	[QualMetodoContraCeptivo] [varchar](30) NULL,
	[Menarca] [varchar](3) NULL,
	[Menopausa] [varchar](3) NULL,
	[Gestante] [varchar](3) NULL,
	[Aborto] [varchar](3) NULL,
	[MotivoAborto] [varchar](60) NULL,
	[PraticaAtividadeFisica] [varchar](3) NULL,
	[QualAtividadeFisica] [varchar](60) NULL,
	[TrataPsicologico] [varchar](3) NULL,
	[ObsEstiloVida] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[ObsHistoricoFamiliar] [varchar](max) NULL,
	[TipoMedicacaoAlopatica] [varchar](32) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATESTADO_MEDICO_PSIQUIATRICO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATESTADO_MEDICO_PSIQUIATRICO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataAtesta] [datetime] NULL,
	[ModeloAtestado] [varchar](100) NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoAtestado] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATIVIDADES_COMPLEMENTARES_PEDAGOGICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATIVIDADES_COMPLEMENTARES_PEDAGOGICA](
	[IdAC] [int] IDENTITY(1,1) NOT NULL,
	[StatusAC] [varchar](15) NULL,
	[DataAC] [datetime] NULL,
	[IdCod] [int] NOT NULL,
	[IdProf] [int] NOT NULL,
	[CargaHoraria] [varchar](6) NULL,
	[TurnoAtividade] [varchar](80) NULL,
	[Dia2] [int] NULL,
	[Dia3] [int] NULL,
	[Dia4] [int] NULL,
	[Dia5] [int] NULL,
	[Dia6] [int] NULL,
	[Dia7] [int] NULL,
	[Dia8] [int] NULL,
	[IdCurso] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATIVIDADES_UNIDADE](
	[IdAtividade] [int] IDENTITY(1,1) NOT NULL,
	[StatusAtividade] [varchar](11) NULL,
	[DataCriacao] [datetime] NOT NULL,
	[DataAtualizacao] [datetime] NULL,
	[IdUnidEmp] [int] NOT NULL,
	[Populacao] [int] NULL,
	[DataInicial] [datetime] NULL,
	[DataFinal] [datetime] NULL,
	[MesReferencia] [varchar](12) NULL,
	[AnoReferencia] [varchar](4) NULL,
	[IdFunc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
 CONSTRAINT [PK_Atividades_Unidade] PRIMARY KEY CLUSTERED 
(
	[IdAtividade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA](
	[IdAtividade] [int] NOT NULL,
	[LanchesVisitantes] [int] NULL,
	[CafeContratada] [int] NULL,
	[AlmocoContratada] [int] NULL,
	[JantarContratada] [int] NULL,
	[LancheContratada] [int] NULL,
	[CafeContratante] [int] NULL,
	[AlmocoContratante] [int] NULL,
	[JantarContratante] [int] NULL,
	[LancheContratante] [int] NULL,
	[TotalAlimentacao] [int] NULL,
 CONSTRAINT [PK_Atividades_Unidade_Alimentacao_Fornecida] PRIMARY KEY CLUSTERED 
(
	[IdAtividade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_INTERNO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_INTERNO](
	[IdAtividade] [int] NOT NULL,
	[CafeInterno] [int] NULL,
	[AlmocoInterno] [int] NULL,
	[JantarInterno] [int] NULL,
	[TotalAlimentacaoInterno] [int] NULL,
 CONSTRAINT [PK_Atividades_Alimentacao_interno] PRIMARY KEY CLUSTERED 
(
	[IdAtividade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL](
	[IdAtividade] [int] NOT NULL,
	[Triagem] [int] NULL,
	[LaborativaRemunerada] [int] NULL,
	[LaborativaNaoRemunerada] [int] NULL,
	[TotalLaboral] [int] NULL,
 CONSTRAINT [PK_Atividades_Unidade_Assistencia_Laboral] PRIMARY KEY CLUSTERED 
(
	[IdAtividade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL](
	[IdAtividade] [int] NOT NULL,
	[Cobertor] [int] NULL,
	[Colchao] [int] NULL,
	[Lencol] [int] NULL,
	[Toalha] [int] NULL,
	[Pote] [int] NULL,
	[Caneca] [int] NULL,
	[AparelhoBarbear] [int] NULL,
	[CremeDental] [int] NULL,
	[EscovaDente] [int] NULL,
	[Absorvente] [int] NULL,
	[PapelHigienico] [int] NULL,
	[SabaoPo] [int] NULL,
	[Sabonete] [int] NULL,
	[Desodorante] [int] NULL,
	[Bermuda] [int] NULL,
	[CamisaCamiseta] [int] NULL,
	[Cueca] [int] NULL,
	[Chinelo] [int] NULL,
	[UniformeEsportivo] [int] NULL,
	[TotalMaterial] [int] NULL,
	[Colher] [int] NULL,
 CONSTRAINT [PK_Atividades_Assistencia_Material] PRIMARY KEY CLUSTERED 
(
	[IdAtividade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL](
	[IdAtividade] [int] NOT NULL,
	[MatriculadoEnsinoFormal] [int] NULL,
	[FrequentandoEnsinoFormal] [int] NULL,
	[MatriculadoCursoProfissionalizante] [int] NULL,
	[CertificadoCursoProfissionalizante] [int] NULL,
	[TotalEducacional] [int] NULL,
 CONSTRAINT [PK_Atividades_Unidade_Atendimento_Educacional] PRIMARY KEY CLUSTERED 
(
	[IdAtividade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE](
	[IdAtividade] [int] NOT NULL,
	[AtendimentoClinico] [int] NULL,
	[AtendimentoPsiquiatrico] [int] NULL,
	[AtendimentoEnfermagem] [int] NULL,
	[ProcedimentoOdontologico] [int] NULL,
	[AtendimentoPsicologico] [int] NULL,
	[TratamentoAgravosPNAISP] [int] NULL,
	[SensibilizadoSaudeBucal] [int] NULL,
	[SensibilizadoInfectocontagiosas] [int] NULL,
	[SensibilizadoHipertensao] [int] NULL,
	[SensibilizadoDiabetes] [int] NULL,
	[SensibilizadoSexualidade] [int] NULL,
	[VacinadosPNI] [int] NULL,
	[TotalSaude] [int] NULL,
 CONSTRAINT [PK_Atividades_Unidade_Atendimento_Saude] PRIMARY KEY CLUSTERED 
(
	[IdAtividade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_JURIDICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_JURIDICA](
	[IdAtividade] [int] NOT NULL,
	[InternoFamiliaSAJ] [int] NULL,
	[AlvaraSolturaRecebido] [int] NULL,
	[AlvaraSolturaCumprido] [int] NULL,
	[LivramentoCondicionalRequerido] [int] NULL,
	[AudienciaProvocada] [int] NULL,
	[AudienciaCumprida] [int] NULL,
	[JuriProvocado] [int] NULL,
	[JuriCumprido] [int] NULL,
	[LiberdadeProvisoriaRequerida] [int] NULL,
	[LiberdadeProvisoriaDeferida] [int] NULL,
	[IndultosRequeridos] [int] NULL,
	[IndultosDeferidos] [int] NULL,
	[RemicaoRequerida] [int] NULL,
	[RemicaoDeferida] [int] NULL,
	[CondicionalRequerida] [int] NULL,
	[CondicionalDeferida] [int] NULL,
	[ProgressaoRegimeRequerida] [int] NULL,
	[ProgressaoRegimeDeferida] [int] NULL,
	[SaidasTemporariasRequerida] [int] NULL,
	[SaidasTemporariasDeferida] [int] NULL,
	[HabeasCorpusRequerido] [int] NULL,
	[HabeasCorpusDeferido] [int] NULL,
	[LaudosPsicologicos] [int] NULL,
	[LaudosPsiquiatricos] [int] NULL,
	[TransferenciaProvimento] [int] NULL,
	[TotalJuridico] [int] NULL,
 CONSTRAINT [PK_Atividades_Unidade_Juridica] PRIMARY KEY CLUSTERED 
(
	[IdAtividade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_RECREATIVA_RELIGIOSA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_RECREATIVA_RELIGIOSA](
	[IdAtividade] [int] NOT NULL,
	[ArtesPlasticas] [int] NULL,
	[Literatura] [int] NULL,
	[CantoTeatroCinema] [int] NULL,
	[Esportes] [int] NULL,
	[Religiosa] [int] NULL,
	[TotalRecreativaReligiosa] [int] NULL,
 CONSTRAINT [PK_Atividades_Unidade_Recreativa_Religiosa] PRIMARY KEY CLUSTERED 
(
	[IdAtividade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_SEGURANCA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_SEGURANCA](
	[IdAtividade] [int] NOT NULL,
	[CelularLocalizadoConvivencia] [int] NULL,
	[ObjetoNaoAutorizadoLocalizadoConvivencia] [int] NULL,
	[RevistaCela] [int] NULL,
	[TentativaFuga] [int] NULL,
	[OcorrenciaFuga] [int] NULL,
	[OcorrenciaRebeliao] [int] NULL,
	[OcorrenciaFerido] [int] NULL,
	[OcorrenciaIndisciplina] [int] NULL,
	[OcorrenciaRefem] [int] NULL,
	[OcorrenciaGravementeFeridoMorto] [int] NULL,
	[HorasInterrupcaoCFTV] [int] NULL,
	[DiasInterrupcaoScannerCorporal] [int] NULL,
	[DiasInterrupcaoRaioXDetectorMetais] [int] NULL,
	[DiasInterrupcaoVeiculoTransportePreso] [int] NULL,
	[FalhaGeradorEnergia] [int] NULL,
	[HorasMauFuncionamentoBRS] [int] NULL,
	[AbsorventesEntreguesPortariaScanner] [int] NULL,
	[FraldasEntreguesPortariaScanner] [int] NULL,
 CONSTRAINT [PK_Atividades_Seguranca] PRIMARY KEY CLUSTERED 
(
	[IdAtividade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_SERVICO_SOCIAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_SERVICO_SOCIAL](
	[IdAtividade] [int] NOT NULL,
	[AtendimentoPsicossocialPreso] [int] NULL,
	[AtendimentoPsicossocialFamiliaPreso] [int] NULL,
	[IdentificadoCivilmente] [int] NULL,
	[TotalServicoSocial] [int] NULL,
 CONSTRAINT [PK_Atividades_Unidade_Servico_Social] PRIMARY KEY CLUSTERED 
(
	[IdAtividade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_VISITA_INTERNO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_VISITA_INTERNO](
	[IdAtividade] [int] NOT NULL,
	[NroDiasVisita] [int] NULL,
	[NroVisitantes] [int] NULL,
	[MediaVisitantesDia] [float] NULL,
	[MediaVisitantesInterno] [float] NULL,
	[NroCriancasVisitantes] [int] NULL,
 CONSTRAINT [PK_Atividades_Unidade_visita_interno] PRIMARY KEY CLUSTERED 
(
	[IdAtividade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ATIVIDADESJURIDICOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATIVIDADESJURIDICOS](
	[IdAtiv] [int] IDENTITY(1,1) NOT NULL,
	[StatusAtiv] [varchar](8) NULL,
	[DataAtiv] [datetime] NULL,
	[DescricaoAtiv] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAtiv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATUALIZACAO_DOCUMENTOS_INTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATUALIZACAO_DOCUMENTOS_INTERNOS](
	[CodigoDoc] [int] IDENTITY(1,1) NOT NULL,
	[StatusDoc] [varchar](10) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[RG] [varchar](15) NULL,
	[Orgao] [varchar](10) NULL,
	[Emissor] [varchar](2) NULL,
	[DataEmissao] [datetime] NULL,
	[CPF] [varchar](15) NULL,
	[CartaoSus] [varchar](50) NULL,
	[Escolaridade] [varchar](50) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[CodigoDoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ATUALIZAR_MATRICULA_INTERNO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ATUALIZAR_MATRICULA_INTERNO](
	[IdAtual] [int] IDENTITY(1,1) NOT NULL,
	[StatusAtual] [varchar](20) NULL,
	[DataRegistro] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdMat] [int] NOT NULL,
	[StatusAluno] [varchar](30) NULL,
	[SituacaoAluno] [varchar](30) NULL,
	[DataAvaliacao] [datetime] NULL,
	[Avaliacao] [real] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAtual] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AUDIENCIAS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AUDIENCIAS](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](30) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TipoJust] [varchar](100) NULL,
	[Justificativa] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AUTORES_LIVROS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AUTORES_LIVROS](
	[IdAutor] [int] IDENTITY(1,1) NOT NULL,
	[StatusAutor] [varchar](10) NULL,
	[DataLanc] [date] NULL,
	[NomeAutor] [varchar](500) NULL,
	[NacionalidadeAutor] [varchar](200) NULL,
	[PaisAutor] [varchar](200) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAutor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AUTORES_REGIMENTO_DISCIPLINAR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AUTORES_REGIMENTO_DISCIPLINAR](
	[IdAutor] [int] IDENTITY(1,1) NOT NULL,
	[IdReg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdPav] [int] NOT NULL,
	[IdCela] [int] NOT NULL,
	[QtdeDias] [float] NULL,
	[DataInicio] [date] NULL,
	[DataTermino] [date] NULL,
	[UtilizaSaida] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[PavilhaoOrigem] [varchar](200) NULL,
	[CelaOrigem] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAutor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AUTOREVENTOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AUTOREVENTOS](
	[IdAutor] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdCela] [int] NOT NULL,
	[QtdeDias] [float] NULL,
	[UtilizaSaida] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAutor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALIACAO_I]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALIACAO_I](
	[IdAvaliaI] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[ConhecoHabilidades] [varchar](7) NULL,
	[AcreditaRealizacoes] [varchar](7) NULL,
	[EsperoResultados] [varchar](7) NULL,
	[AcreditoRealizaTrabalho] [varchar](7) NULL,
	[AcreditoRealizaLar] [varchar](7) NULL,
	[AcreditoDiverteLazer] [varchar](7) NULL,
	[FacoAtividades] [varchar](7) NULL,
	[TenhoExpectativa] [varchar](7) NULL,
	[TenhoObjetoFuturo] [varchar](7) NULL,
	[IdentificoGostos] [varchar](7) NULL,
	[ParticipoProjetosImport] [varchar](7) NULL,
	[TenhoVariosInteresse] [varchar](7) NULL,
	[CostumoComprometo] [varchar](7) NULL,
	[DeEstudante] [varchar](7) NULL,
	[DeTrabalho] [varchar](7) NULL,
	[DeAmigo] [varchar](7) NULL,
	[DeFamiliar] [varchar](7) NULL,
	[ReconhecoPapeis] [varchar](7) NULL,
	[MantenhoVida] [varchar](7) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAvaliaI] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALIACAO_II]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALIACAO_II](
	[IdAvaliaII] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[OrganizoTempo] [varchar](7) NULL,
	[MantenhoPapeis] [varchar](7) NULL,
	[SouRotina] [varchar](7) NULL,
	[ConsigoOutros] [varchar](7) NULL,
	[TenhoSocial] [varchar](7) NULL,
	[PlanejoAgir] [varchar](7) NULL,
	[ConcentroTrabalho] [varchar](7) NULL,
	[IdentificoProblemas] [varchar](7) NULL,
	[IdentificoSolucaoProblemas] [varchar](7) NULL,
	[QuandoAgir] [varchar](7) NULL,
	[ConsigoHigiene] [varchar](7) NULL,
	[ConsigoCotidianas] [varchar](7) NULL,
	[ConsigoFinancas] [varchar](7) NULL,
	[ConsigoCasa] [varchar](7) NULL,
	[SintoPreciso] [varchar](7) NULL,
	[CostumoFrequentar] [varchar](7) NULL,
	[DataAplicacao] [datetime] NULL,
	[ResponsavelAplicacao] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAvaliaII] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALIACAO_MEDICA_PSIQUIATRICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALIACAO_MEDICA_PSIQUIATRICA](
	[IdAvalia] [int] IDENTITY(1,1) NOT NULL,
	[StatusAval] [varchar](20) NULL,
	[DataAval] [date] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoAvaliacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Fonte] [varchar](200) NULL,
	[Tamanho] [varchar](3) NULL,
	[BtEsq] [int] NULL,
	[BtCen] [int] NULL,
	[BtDir] [int] NULL,
	[BtJus] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAvalia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALIACAO_TO_I]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALIACAO_TO_I](
	[IdAvaliaTOI] [int] IDENTITY(1,1) NOT NULL,
	[IdATN] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[ConhecoHabilidades] [varchar](7) NULL,
	[AcreditaRealizacoes] [varchar](7) NULL,
	[EsperoResultados] [varchar](7) NULL,
	[AcreditoRealizaTrabalho] [varchar](7) NULL,
	[AcreditoRealizaLar] [varchar](7) NULL,
	[AcreditoDiverteLazer] [varchar](7) NULL,
	[FacoAtividades] [varchar](7) NULL,
	[TenhoExpectativa] [varchar](7) NULL,
	[TenhoObjetoFuturo] [varchar](7) NULL,
	[IdentificoGostos] [varchar](7) NULL,
	[ParticipoProjetosImport] [varchar](7) NULL,
	[TenhoVariosInteresse] [varchar](7) NULL,
	[CostumoComprometo] [varchar](7) NULL,
	[DeEstudante] [varchar](7) NULL,
	[DeTrabalho] [varchar](7) NULL,
	[DeAmigo] [varchar](7) NULL,
	[DeFamiliar] [varchar](7) NULL,
	[ReconhecoPapeis] [varchar](7) NULL,
	[MantenhoVida] [varchar](7) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAvaliaTOI] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALIACAO_TO_II]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALIACAO_TO_II](
	[IdAvaliaTOII] [int] IDENTITY(1,1) NOT NULL,
	[IdATN] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[OrganizoTempo] [varchar](7) NULL,
	[MantenhoPapeis] [varchar](7) NULL,
	[SouRotina] [varchar](7) NULL,
	[ConsigoOutros] [varchar](7) NULL,
	[TenhoSocial] [varchar](7) NULL,
	[PlanejoAgir] [varchar](7) NULL,
	[ConcentroTrabalho] [varchar](7) NULL,
	[IdentificoProblemas] [varchar](7) NULL,
	[IdentificoSolucaoProblemas] [varchar](7) NULL,
	[QuandoAgir] [varchar](7) NULL,
	[ConsigoHigiene] [varchar](7) NULL,
	[ConsigoCotidianas] [varchar](7) NULL,
	[ConsigoFinancas] [varchar](7) NULL,
	[ConsigoCasa] [varchar](7) NULL,
	[SintoPreciso] [varchar](7) NULL,
	[CostumoFrequentar] [varchar](7) NULL,
	[DataAplicacao] [datetime] NULL,
	[ResponsavelAplicacao] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAvaliaTOII] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALIACAOPSI]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALIACAOPSI](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[InfanciaPergunta1] [varchar](max) NULL,
	[InfanciaPergunta2] [varchar](max) NULL,
	[InfanciaPergunta3] [varchar](max) NULL,
	[InfanciaPergunta4] [varchar](max) NULL,
	[EscolaPergunta1] [varchar](max) NULL,
	[EscolaPergunta2] [varchar](max) NULL,
	[VidaLaborativa] [varchar](max) NULL,
	[RedeSocial] [varchar](max) NULL,
	[SubstanciaPsicoativa] [varchar](max) NULL,
	[RelacaoAfetiva] [varchar](max) NULL,
	[Pespectiva] [varchar](max) NULL,
	[HistoricoCriminal] [varchar](max) NULL,
	[HistoricoPrisional] [varchar](max) NULL,
	[DadosCognitivos] [varchar](max) NULL,
	[IndicadorPsicopatologico] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALICAO_ATENDIMENTO_GRUPO_EF]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALICAO_ATENDIMENTO_GRUPO_EF](
	[IdItemAvagEF] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoEF] [int] NOT NULL,
	[TextoAvalaiacaoGrupo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemAvagEF] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALICAO_ATENDIMENTO_GRUPO_ENFERMAGEM]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALICAO_ATENDIMENTO_GRUPO_ENFERMAGEM](
	[IdItemAvagEnf] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoEnf] [int] NOT NULL,
	[TextoAvalaiacaoGrupo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemAvagEnf] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALICAO_ATENDIMENTO_GRUPO_PE]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALICAO_ATENDIMENTO_GRUPO_PE](
	[IdItemAvagPE] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoPE] [int] NOT NULL,
	[TextoAvalaiacaoGrupo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemAvagPE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALICAO_ATENDIMENTO_GRUPO_PSICOLOGIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALICAO_ATENDIMENTO_GRUPO_PSICOLOGIA](
	[IdItemAvag] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoPsi] [int] NOT NULL,
	[TextoAvalaiacaoGrupo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemAvag] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALICAO_ATENDIMENTO_GRUPO_SS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALICAO_ATENDIMENTO_GRUPO_SS](
	[IdItemAvagSS] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoSS] [int] NOT NULL,
	[TextoAvalaiacaoGrupo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemAvagSS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALICAO_ATENDIMENTO_GRUPO_TO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALICAO_ATENDIMENTO_GRUPO_TO](
	[IdItemAvagTO] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoTO] [int] NOT NULL,
	[TextoAvalaiacaoGrupo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemAvagTO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_EF]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_EF](
	[IdItemAvaiEF] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoEF] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoAvalaiacaoInd] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemAvaiEF] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM](
	[IdItemAvaiEnf] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoEnf] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoAvalaiacaoInd] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemAvaiEnf] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_PE]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_PE](
	[IdItemAvaiPE] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoPE] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoAvalaiacaoInd] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemAvaiPE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_PSICOLOGIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_PSICOLOGIA](
	[IdItemAvai] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoPsi] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoAvalaiacaoInd] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemAvai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_SS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_SS](
	[IdItemAvaiSS] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoSS] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoAvalaiacaoInd] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemAvaiSS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_TO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_TO](
	[IdItemAvaiTO] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoTO] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoAvalaiacaoInd] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemAvaiTO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BAIXAINTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BAIXAINTERNOS](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [date] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BIOMETRIA_COLABORADORES]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BIOMETRIA_COLABORADORES](
	[IdBioFunc] [int] IDENTITY(1,1) NOT NULL,
	[DataCadastro] [datetime] NULL,
	[IdFunc] [int] NOT NULL,
	[CaminhoImagemDedo1] [varchar](200) NULL,
	[CaminhoImagemDedo2] [varchar](200) NULL,
	[CaminhoImagemDedo3] [varchar](200) NULL,
	[CaminhoImagemDedo4] [varchar](200) NULL,
	[BiometriaDedo1] [varbinary](max) NULL,
	[BiometriaDedo2] [varbinary](max) NULL,
	[BiometriaDedo3] [varbinary](max) NULL,
	[BiometriaDedo4] [varbinary](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdBioFunc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BIOMETRIA_INTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BIOMETRIA_INTERNOS](
	[IdBioInter] [int] IDENTITY(1,1) NOT NULL,
	[DataCadastro] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[BiometriaDedo1] [varbinary](max) NULL,
	[BiometriaDedo2] [varbinary](max) NULL,
	[BiometriaDedo3] [varbinary](max) NULL,
	[BiometriaDedo4] [varbinary](max) NULL,
	[CaminhoImagemDedo1] [varchar](200) NULL,
	[CaminhoImagemDedo2] [varchar](200) NULL,
	[CaminhoImagemDedo3] [varchar](200) NULL,
	[CaminhoImagemDedo4] [varchar](200) NULL,
	[CaminhoImagemDedo5] [varchar](200) NULL,
	[CaminhoImagemDedo6] [varchar](200) NULL,
	[CaminhoImagemDedo7] [varchar](200) NULL,
	[CaminhoImagemDedo8] [varchar](200) NULL,
	[CaminhoImagemDedo9] [varchar](200) NULL,
	[CaminhoImagemDedo10] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdBioInter] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CANCELAMENTO_VISITAS_EXTERNA_INTERNA_ROL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CANCELAMENTO_VISITAS_EXTERNA_INTERNA_ROL](
	[IdCan] [int] IDENTITY(1,1) NOT NULL,
	[StatusCan] [varchar](30) NULL,
	[DataCan] [datetime] NULL,
	[CodigoRol] [int] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CAPACITACAO_INTERNO_TO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CAPACITACAO_INTERNO_TO](
	[IdCap] [int] IDENTITY(1,1) NOT NULL,
	[StatusRegistro] [varchar](20) NULL,
	[DataRegistro] [datetime] NULL,
	[IdCurso] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CARGAHORARIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CARGAHORARIA](
	[IdCarga] [int] IDENTITY(1,1) NOT NULL,
	[StatusCarga] [varchar](30) NULL,
	[DataCad] [datetime] NULL,
	[DescricaoCarga] [varchar](300) NULL,
	[QtdDias] [int] NULL,
	[QtdHoras] [varchar](5) NULL,
	[MesReferencia] [varchar](30) NULL,
	[AnoReferencia] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCarga] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CARGOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CARGOS](
	[IdCargo] [int] IDENTITY(1,1) NOT NULL,
	[StatusCargo] [tinyint] NOT NULL,
	[NomeCargo] [varchar](50) NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCargo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CARTILHA_VACINAS_INTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CARTILHA_VACINAS_INTERNOS](
	[IdCart] [int] IDENTITY(1,1) NOT NULL,
	[StatusCart] [varchar](10) NULL,
	[DataCart] [datetime] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCart] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CATEGORIA_LIVROS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CATEGORIA_LIVROS](
	[IdCat] [int] IDENTITY(1,1) NOT NULL,
	[StatusCat] [varchar](10) NULL,
	[TipoCategoria] [varchar](20) NULL,
	[DataCat] [date] NULL,
	[DescricaoCategoria] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CATEGORIA_RECEITAS_NUTRI]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CATEGORIA_RECEITAS_NUTRI](
	[IdCat] [int] IDENTITY(1,1) NOT NULL,
	[StatusCat] [varchar](20) NULL,
	[TipoReceita] [varchar](200) NULL,
	[DataCat] [datetime] NULL,
	[DescricaoCategoria] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CELAS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CELAS](
	[IdCela] [int] IDENTITY(1,1) NOT NULL,
	[StatusCela] [varchar](10) NULL,
	[IdPav] [int] NOT NULL,
	[EndCelaPav] [varchar](50) NOT NULL,
	[Motivo] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[NivelCel] [varchar](1) NULL,
	[Capacidade] [int] NULL,
	[NrCela] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCela] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CHECK_LIST_DOCUMENTOS_INTERNO_CRC]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CHECK_LIST_DOCUMENTOS_INTERNO_CRC](
	[IdChek] [int] IDENTITY(1,1) NOT NULL,
	[DescricaoDocumentos] [varchar](250) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdChek] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CIDADES]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CIDADES](
	[IdCidade] [int] IDENTITY(1,1) NOT NULL,
	[NomeCidade] [varchar](80) NOT NULL,
	[UfCidade] [varchar](2) NOT NULL,
	[IdPais] [int] NOT NULL,
	[DddCidade] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCidade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[COLABORADOR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[COLABORADOR](
	[IdFunc] [int] IDENTITY(1,1) NOT NULL,
	[DataCadFunc] [datetime] NULL,
	[ImagemFunc] [varchar](200) NULL,
	[NomeFunc] [varchar](120) NOT NULL,
	[SexoFunc] [varchar](50) NULL,
	[EscolaFunc] [varchar](50) NULL,
	[MatriculaFunc] [varchar](100) NULL,
	[IdCargo] [int] NOT NULL,
	[IdDepartamento] [int] NOT NULL,
	[EstadoCivil] [varchar](20) NULL,
	[DataNascimento] [datetime] NULL,
	[NomeMae] [varchar](200) NULL,
	[NomePai] [varchar](200) NULL,
	[Religiao] [varchar](150) NULL,
	[TipoSangue] [varchar](50) NULL,
	[CargaHoraria] [varchar](50) NULL,
	[RegimeTrabalho] [varchar](50) NULL,
	[HorarioInicio] [varchar](10) NULL,
	[HorarioFinal] [varchar](10) NULL,
	[Funcao] [varchar](150) NULL,
	[Nacionalidade] [varchar](150) NULL,
	[Pais] [varchar](50) NULL,
	[Naturalidade] [varchar](200) NULL,
	[EstadoNaturalidade] [varchar](50) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[StatusFunc] [varchar](20) NULL,
	[ImagemFrenteCO] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFunc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[COLABORADORTESTEMUNHA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[COLABORADORTESTEMUNHA](
	[IdColaVit] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdFunc] [int] NOT NULL,
	[RgFuncTeste] [varchar](30) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdColaVit] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[COLABORADORVITIMA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[COLABORADORVITIMA](
	[IdColaVit] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdFunc] [int] NOT NULL,
	[RgFunc] [varchar](30) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdColaVit] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE](
	[IdRegistroComp] [int] IDENTITY(1,1) NOT NULL,
	[StatusComp] [varchar](20) NULL,
	[DataComp] [datetime] NULL,
	[IdKit] [int] NOT NULL,
	[IdItem] [int] NOT NULL,
	[IdFunc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[ProgGerada] [varchar](3) NULL,
	[DataProgramacao] [datetime] NULL,
	[KitPago] [varchar](3) NULL,
	[DataPagamento] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRegistroComp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[COMPRAS_ACERVO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[COMPRAS_ACERVO](
	[IdCompra] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[ClasseCompra] [varchar](20) NULL,
	[DataCompra] [date] NULL,
	[IdForn] [int] NOT NULL,
	[NumeroDoc] [int] NULL,
	[SerieDoc] [varchar](10) NULL,
	[DataRecebe] [date] NULL,
	[DataEmissao] [date] NULL,
	[FormaPagto] [int] NULL,
	[ValorProdutos] [float] NULL,
	[ValorNFE] [float] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCompra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CONFERE_INTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CONFERE_INTERNOS](
	[IdConfere] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataConfere] [datetime] NULL,
	[DataRealizacao] [varchar](20) NULL,
	[HorarioConfere] [varchar](20) NULL,
	[AssinaturaBiometricaInterno] [varbinary](max) NULL,
	[IdPav] [int] NOT NULL,
	[IdCela] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdConfere] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CONTROLIGA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CONTROLIGA](
	[IdControl] [int] IDENTITY(1,1) NOT NULL,
	[DataControl] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[StatusControl] [varchar](30) NULL,
	[TelefoneControl] [varchar](20) NULL,
	[TempoControl] [varchar](20) NULL,
	[LocalLigacao] [varchar](200) NULL,
	[ObsControl] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdControl] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CUMPRIMENTOALVARA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CUMPRIMENTOALVARA](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [date] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Historico] [varchar](max) NULL,
	[TipoCumprimento] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CURSOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CURSOS](
	[IdCurso] [int] IDENTITY(1,1) NOT NULL,
	[StatusCurso] [varchar](20) NULL,
	[DataCurso] [datetime] NULL,
	[DescricaoCurso] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[TipoCurso] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCurso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DADOSFISICOSINTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DADOSFISICOSINTERNOS](
	[IdDados] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Cutis] [varchar](20) NULL,
	[Olhos] [varchar](20) NULL,
	[Cabelos] [varchar](20) NULL,
	[Barba] [varchar](20) NULL,
	[Bigode] [varchar](20) NULL,
	[Nariz] [varchar](20) NULL,
	[Boca] [varchar](20) NULL,
	[Rosto] [varchar](20) NULL,
	[Labios] [varchar](20) NULL,
	[Camisa] [varchar](20) NULL,
	[Calca] [varchar](20) NULL,
	[Sapato] [varchar](20) NULL,
	[Peso] [varchar](20) NULL,
	[Altura] [varchar](20) NULL,
	[Sinais] [varchar](20) NULL,
	[Pescoco] [varchar](100) NULL,
	[Orelhas] [varchar](100) NULL,
	[Compleicao] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDados] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DADOSPENAISINTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DADOSPENAISINTERNOS](
	[IdPenais] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdUnid] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[DataCrime] [datetime] NULL,
	[DataPrisao] [datetime] NULL,
	[DataCondenacao] [datetime] NULL,
	[Participacao] [varchar](20) NULL,
	[Regime] [varchar](20) NULL,
	[Pena] [varchar](20) NULL,
	[VaraCondenatoria] [varchar](100) NULL,
	[Artigo1] [varchar](20) NULL,
	[Artigo2] [varchar](20) NULL,
	[Artigo3] [varchar](20) NULL,
	[Paragrafo1] [varchar](20) NULL,
	[Paragrafo2] [varchar](20) NULL,
	[Paragrafo3] [varchar](20) NULL,
	[CrimeEdiondo] [varchar](20) NULL,
	[TerminoPena] [datetime] NULL,
	[FotoPerfil] [varchar](300) NULL,
	[FotoCorpo] [varchar](300) NULL,
	[FotoCorpo1] [varchar](300) NULL,
	[FotoCorpo2] [varchar](300) NULL,
	[FotoPolegarDireito] [varchar](300) NULL,
	[FotoIndicadorDireito] [varchar](300) NULL,
	[FotoMedioDireito] [varchar](300) NULL,
	[FotoAnularDireito] [varchar](300) NULL,
	[FotoMinimoDireito] [varchar](300) NULL,
	[FotoPolegarEsquerdo] [varchar](300) NULL,
	[FotoIndicadorEsquerdo] [varchar](300) NULL,
	[FotoMedioEsquerdo] [varchar](300) NULL,
	[FotoAnularEsquerdo] [varchar](300) NULL,
	[FotoMinimoEsquerdo] [varchar](300) NULL,
	[Identificador] [varchar](80) NULL,
	[Identificador1] [varchar](80) NULL,
	[Identificador2] [varchar](80) NULL,
	[Identificador3] [varchar](80) NULL,
	[Perfil] [varchar](80) NULL,
	[RegiaoCorpo] [varchar](80) NULL,
	[RegiaoCorpo1] [varchar](80) NULL,
	[RegiaoCorpo2] [varchar](80) NULL,
	[RegiaoCorpo3] [varchar](80) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[DataNovaEntrada] [datetime] NULL,
	[ImagemPerfil] [varbinary](max) NULL,
	[ImagemCorpo] [varbinary](max) NULL,
	[ImagemCorpo1] [varbinary](max) NULL,
	[ImagemCorpo2] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPenais] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DEPARTAMENTOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DEPARTAMENTOS](
	[IdDepartamento] [int] IDENTITY(1,1) NOT NULL,
	[StatusDepartamento] [tinyint] NOT NULL,
	[NomeDepartamento] [varchar](50) NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[SalaNr] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDepartamento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DEPENDENTES]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DEPENDENTES](
	[IdDep] [int] IDENTITY(1,1) NOT NULL,
	[IdFunc] [int] NOT NULL,
	[NomeDep] [varchar](150) NULL,
	[DataNascDep] [datetime] NULL,
	[ParenteDep] [varchar](80) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDep] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DEPOSITO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DEPOSITO](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[ValorDeposito] [money] NULL,
	[Depositante] [varchar](200) NULL,
	[Observacao] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DEPOSITO_INATIVOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DEPOSITO_INATIVOS](
	[IdDepIna] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[ValorDeposito] [money] NULL,
	[Depositante] [varchar](200) NULL,
	[Observacao] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Tipo] [varchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDepIna] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DEPOSITOPORTARIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DEPOSITOPORTARIA](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](50) NULL,
	[DataLanc] [datetime] NULL,
	[NomeDepositante] [varchar](250) NULL,
	[Observacao] [varchar](max) NULL,
	[OrigemDeposito] [varchar](1) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DEVOLUCAO_ACERVO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DEVOLUCAO_ACERVO](
	[IdDevolucao] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NOT NULL,
	[DataDevol] [date] NULL,
	[IdEmprestimo] [int] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDevolucao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DEVOLUCAO_DOCUMENTOS_SERVICO_SOCIAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DEVOLUCAO_DOCUMENTOS_SERVICO_SOCIAL](
	[IdRegistro] [int] IDENTITY(1,1) NOT NULL,
	[IdDoc] [int] NOT NULL,
	[DataDevolucao] [datetime] NULL,
	[Horario] [varchar](20) NULL,
	[Documento] [varchar](100) NULL,
	[MotivoDevolucao] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRegistro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR](
	[IdDevo] [int] IDENTITY(1,1) NOT NULL,
	[StatusDevo] [varchar](20) NULL,
	[DataDevo] [datetime] NULL,
	[IdMot] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[IdFunc] [int] NOT NULL,
	[IdLocalDst] [int] NOT NULL,
	[DescricaoLocalDestino] [varchar](300) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDevo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DIETA_MEDICA_PSIQUIATRICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DIETA_MEDICA_PSIQUIATRICA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataDieta] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoDieta] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DISCIPLINAS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DISCIPLINAS](
	[IdDisc] [int] IDENTITY(1,1) NOT NULL,
	[StatusDisc] [varchar](20) NULL,
	[DataDisc] [datetime] NULL,
	[Descricao] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDisc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DISCIPLINASPROFESSOR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DISCIPLINASPROFESSOR](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdProf] [int] NOT NULL,
	[IdDisc] [int] NOT NULL,
	[ObsDisciplina] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DOCINTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DOCINTERNOS](
	[IdDoc] [int] IDENTITY(1,1) NOT NULL,
	[StatusDoc] [varchar](8) NULL,
	[DataDoc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[RgDoc] [varchar](3) NULL,
	[CpfDoc] [varchar](3) NULL,
	[CnhDoc] [varchar](3) NULL,
	[TituloDoc] [varchar](3) NULL,
	[ReservistaDoc] [varchar](3) NULL,
	[CtpsDoc] [varchar](3) NULL,
	[CNascimentoDoc] [varchar](3) NULL,
	[CCasamentoDoc] [varchar](3) NULL,
	[OutrosDoc] [varchar](3) NULL,
	[DataDevolucaoDoc] [datetime] NULL,
	[ObservacaoDoc] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[RgVia] [varchar](8) NULL,
	[CpfVia] [varchar](8) NULL,
	[CnhVia] [varchar](8) NULL,
	[ReservistaVia] [varchar](8) NULL,
	[CtpsVia] [varchar](8) NULL,
	[CertidaoNascVia] [varchar](8) NULL,
	[TituloVia] [varchar](8) NULL,
	[CertidaoCasaVia] [varchar](8) NULL,
	[PassaporteVia] [varchar](8) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DOCUMENTOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DOCUMENTOS](
	[IdDoc] [int] IDENTITY(1,1) NOT NULL,
	[IdFunc] [int] NOT NULL,
	[RgDoc] [varchar](20) NULL,
	[DataEmissaoDoc] [datetime] NULL,
	[OrgaoDoc] [varchar](50) NULL,
	[EstadoOrg] [varchar](2) NULL,
	[CpfDoc] [varchar](20) NULL,
	[PisDoc] [varchar](30) NULL,
	[DataCadPisDoc] [datetime] NULL,
	[TituloDoc] [varchar](40) NULL,
	[ZonaDoc] [varchar](20) NULL,
	[SecaoDoc] [varchar](20) NULL,
	[CtpsDoc] [varchar](20) NULL,
	[SerieDoc] [varchar](50) NULL,
	[HabiliDoc] [varchar](10) NULL,
	[ReservistaDoc] [varchar](20) NULL,
	[CateDoc] [varchar](30) NULL,
	[CartSaudeDoc] [varchar](50) NULL,
	[ProfDoc] [varchar](150) NULL,
	[AlturaDoc] [varchar](10) NULL,
	[PesoDoc] [varchar](10) NULL,
	[CalcaDoc] [varchar](10) NULL,
	[CamisaDoc] [varchar](10) NULL,
	[SapatoDoc] [varchar](10) NULL,
	[CarteiraDoc] [varchar](10) NULL,
	[TipoConjugue] [varchar](50) NULL,
	[DataNasConjugue] [date] NULL,
	[NomeConjugue] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DOCUMENTOS_PROCESSO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DOCUMENTOS_PROCESSO](
	[IdDocPro] [int] IDENTITY(1,1) NOT NULL,
	[IdFicha] [int] NOT NULL,
	[IdNatp] [int] NOT NULL,
	[Documento] [varchar](50) NULL,
	[OrigemDoc] [varchar](100) NULL,
	[DataDoc] [date] NULL,
	[HoraDoc] [varchar](20) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDocPro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DOENCAS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DOENCAS](
	[IdDoenca] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[Descricao] [varchar](70) NULL,
	[Cid] [varchar](20) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[DescricaoDetalhada] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDoenca] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EAPI_CRC_PAI_PSICOSOCIAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EAPI_CRC_PAI_PSICOSOCIAL](
	[IdEapi] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdUnid] [int] NOT NULL,
	[TempPenaSentenca] [varchar](20) NULL,
	[TempoPenaCumprida] [varchar](20) NULL,
	[AssistenciaJuridica] [varchar](3) NULL,
	[TempoPenaACumprir] [varchar](10) NULL,
	[ReintegraSistemaPenal] [varchar](3) NULL,
	[SituacaoJuridica] [varchar](80) NULL,
	[DataEntradaSistemaPenal] [datetime] NULL,
	[DefensorPublico] [varchar](3) NULL,
	[OutroDefensor] [varchar](3) NULL,
	[QualDefensor] [varchar](200) NULL,
	[TextoPSP] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEapi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EDITORAS_INSTITUICAO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EDITORAS_INSTITUICAO](
	[IdForn] [int] IDENTITY(1,1) NOT NULL,
	[ClassFor] [varchar](20) NULL,
	[StatusFor] [varchar](20) NULL,
	[RazaoSocial] [varchar](250) NULL,
	[Cnpj] [varchar](20) NULL,
	[InsEstadual] [varchar](20) NULL,
	[CpfFor] [varchar](20) NULL,
	[RgFor] [varchar](20) NULL,
	[Telefone] [varchar](20) NULL,
	[Telefone1] [varchar](20) NULL,
	[Celular] [varchar](20) NULL,
	[Email] [varchar](100) NULL,
	[Fax] [varchar](20) NULL,
	[Endereco] [varchar](300) NULL,
	[Compl] [varchar](200) NULL,
	[Cep] [varchar](20) NULL,
	[Cidade] [varchar](200) NULL,
	[Estado] [varchar](2) NULL,
	[EnderecoCob] [varchar](300) NULL,
	[ComplCob] [varchar](200) NULL,
	[CepCob] [varchar](20) NULL,
	[CidadeCob] [varchar](200) NULL,
	[EstadoCob] [varchar](2) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdForn] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ELIMIAR_ASSINATURA_INTERNO_PSP]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ELIMIAR_ASSINATURA_INTERNO_PSP](
	[IdCancel] [int] IDENTITY(1,1) NOT NULL,
	[StatusCancelamento] [varchar](80) NULL,
	[DataCancelamento] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdDepartamento] [int] NOT NULL,
	[IdRegistro] [int] NOT NULL,
	[UsuarioAtendente] [varchar](50) NULL,
	[DataRegistro] [datetime] NULL,
	[Horario] [varchar](20) NULL,
	[TipoAtendimento] [varchar](80) NULL,
	[Motivo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[HorarioInsert] [varchar](20) NULL,
	[DataInsert] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCancel] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EMISSAO_ATESTADO_RECLUSAO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EMISSAO_ATESTADO_RECLUSAO](
	[IdAtestado] [int] IDENTITY(1,1) NOT NULL,
	[StatusAtestado] [varchar](20) NULL,
	[ClassAtestado] [varchar](20) NULL,
	[DataAtestado] [datetime] NULL,
	[IdVisita] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[CodRegAux] [int] NOT NULL,
	[TextoAtestado] [varchar](max) NULL,
	[AssinaturaColaborador] [varbinary](max) NULL,
	[DataAssinatura] [varchar](20) NULL,
	[HoraAssinatura] [varchar](20) NULL,
	[CodigoValidador] [varbinary](max) NULL,
	[ChaveInterno] [varbinary](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[DataValidade] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAtestado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EMISSAO_ATESTADO_RECLUSAO_CRC]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EMISSAO_ATESTADO_RECLUSAO_CRC](
	[IdAtestado] [int] IDENTITY(1,1) NOT NULL,
	[StatusAtestado] [varchar](20) NULL,
	[ClassAtestado] [varchar](20) NULL,
	[DataAtestado] [datetime] NULL,
	[TipoSolicitante] [varchar](30) NULL,
	[DataValidade] [datetime] NULL,
	[IdVisita] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[CodRegAux] [int] NOT NULL,
	[TextoAtestado] [varchar](max) NULL,
	[AssinaturaColaborador] [varbinary](max) NULL,
	[DataAssinatura] [varchar](20) NULL,
	[HoraAssinatura] [varchar](20) NULL,
	[CodigoValidador] [varbinary](max) NULL,
	[ChaveInterno] [varbinary](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAtestado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EMPRESA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EMPRESA](
	[IdEmpresa] [int] IDENTITY(1,1) NOT NULL,
	[StatusFor] [varchar](20) NULL,
	[DataCadastro] [datetime] NULL,
	[RazaoSocial] [varchar](250) NULL,
	[NomeFantasia] [varchar](250) NULL,
	[Cnpj] [varchar](20) NULL,
	[InsEstadual] [varchar](20) NULL,
	[NomeContato] [varchar](300) NULL,
	[RgFor] [varchar](20) NULL,
	[Telefone] [varchar](20) NULL,
	[Telefone1] [varchar](20) NULL,
	[Celular] [varchar](20) NULL,
	[Email] [varchar](100) NULL,
	[Fax] [varchar](20) NULL,
	[Endereco] [varchar](300) NULL,
	[Compl] [varchar](200) NULL,
	[Cep] [varchar](20) NULL,
	[Cidade] [varchar](200) NULL,
	[Estado] [varchar](2) NULL,
	[EnderecoCob] [varchar](300) NULL,
	[ComplCob] [varchar](200) NULL,
	[CepCob] [varchar](20) NULL,
	[CidadeCob] [varchar](200) NULL,
	[EstadoCob] [varchar](2) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[VersaoAtual] [varchar](5) NULL,
	[DataVersao] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEmpresa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EMPRESALAB]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EMPRESALAB](
	[IdEmp] [int] IDENTITY(1,1) NOT NULL,
	[StatusEmp] [varchar](20) NULL,
	[DataCad] [datetime] NULL,
	[RazaoSocial] [varchar](250) NULL,
	[NomeFantasia] [varchar](200) NULL,
	[Cnpj] [varchar](200) NULL,
	[TipoEmpresa] [varchar](10) NULL,
	[InsEsta] [varchar](20) NULL,
	[Endereco] [varchar](300) NULL,
	[Cidade] [varchar](200) NULL,
	[Estado] [varchar](150) NULL,
	[Cep] [varchar](20) NULL,
	[Telefone] [varchar](20) NULL,
	[Telefone1] [varchar](20) NULL,
	[Contato] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEmp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EMPRESTIMO_ACERVO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EMPRESTIMO_ACERVO](
	[IdEmprestimo] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NOT NULL,
	[DataEmp] [date] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdReserva] [int] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEmprestimo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENCAMINHAMENTO_CIRURGIAS_ESPECIALISTAS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENCAMINHAMENTO_CIRURGIAS_ESPECIALISTAS](
	[IdEnca] [int] IDENTITY(1,1) NOT NULL,
	[StatusEnca] [varchar](20) NULL,
	[DataEnca] [datetime] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEnca] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENDERECOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENDERECOS](
	[IdEnd] [int] IDENTITY(1,1) NOT NULL,
	[IdFunc] [int] NOT NULL,
	[Endereco] [varchar](200) NULL,
	[BairroEnd] [varchar](100) NULL,
	[CompEnd] [varchar](80) NULL,
	[CidadeEnd] [varchar](100) NULL,
	[UfEnd] [varchar](5) NULL,
	[CepEnd] [varchar](30) NULL,
	[FoneEnd] [varchar](50) NULL,
	[TelEnd] [varchar](50) NULL,
	[CelEnd] [varchar](50) NULL,
	[EmailEnd] [varchar](200) NULL,
	[Url] [varchar](200) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEnd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADA_SAIDA_ALBERGADOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADA_SAIDA_ALBERGADOS](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[StatusLanc] [varchar](30) NULL,
	[ObsLanc] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADA_SAIDA_EDUCACAO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADA_SAIDA_EDUCACAO](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [date] NULL,
	[IdCod] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADA_SAIDA_VISITAS_RELIGIOSA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADA_SAIDA_VISITAS_RELIGIOSA](
	[IdEntSaiVisita] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdCod] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEntSaiVisita] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADAINTERNOSPORTARIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADAINTERNOSPORTARIA](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](30) NULL,
	[DataLanc] [datetime] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADALABORINTERNO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADALABORINTERNO](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[StatusLanc] [varchar](30) NULL,
	[IdEmp] [int] NOT NULL,
	[ObsLanc] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADALOTE]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADALOTE](
	[IdEntrada] [int] IDENTITY(1,1) NOT NULL,
	[StatusEnt] [varchar](30) NULL,
	[DataLancaMov] [datetime] NULL,
	[IdOp] [int] NOT NULL,
	[ObsEntrada] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEntrada] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADANOVA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADANOVA](
	[IdEntrada] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[TipoOperacao] [varchar](200) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEntrada] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADAOBJETOSPERTENCES]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADAOBJETOSPERTENCES](
	[IdEntrada] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](10) NULL,
	[DataLanc] [date] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEntrada] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADAPERTENCES]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADAPERTENCES](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[SituacaoEnt] [varchar](20) NULL,
	[Datalanc] [datetime] NULL,
	[IdVisita] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADAS_INTERNO_INTERNA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADAS_INTERNO_INTERNA](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[StatusLanc] [varchar](30) NULL,
	[ObsLanc] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADAS_OFICIAL_JUSTICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADAS_OFICIAL_JUSTICA](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[StatusLanc] [varchar](30) NULL,
	[ObsLanc] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADAS_OFICIAL_JUSTICA_INTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADAS_OFICIAL_JUSTICA_INTERNOS](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[IdOficial] [int] NOT NULL,
	[StatusLanc] [varchar](30) NULL,
	[ObsLanc] [varchar](max) NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADAS_SAIDAS_POPULACAO_INTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADAS_SAIDAS_POPULACAO_INTERNOS](
	[IdRegistro] [int] IDENTITY(1,1) NOT NULL,
	[DataMovimento] [datetime] NULL,
	[HorarioMovimento] [varchar](10) NULL,
	[TipoOperacao] [varchar](50) NULL,
	[Populacao] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](20) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](20) NULL,
	[Quantidade] [int] NULL,
	[IdDocumento] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRegistro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADASADVINTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADASADVINTERNOS](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[IdAdvogado] [int] NOT NULL,
	[StatusLanc] [varchar](30) NULL,
	[ObsLanc] [varchar](max) NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADASADVOGADOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADASADVOGADOS](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[StatusLanc] [varchar](30) NULL,
	[ObsLanc] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADASFAMILIAR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADASFAMILIAR](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[StatusLanc] [varchar](30) NULL,
	[ObsLanc] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADASFUNC]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADASFUNC](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[StatusLanc] [varchar](30) NULL,
	[ObsLanc] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADASVISITAS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADASVISITAS](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[StatusLanc] [varchar](30) NULL,
	[ObsLanc] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADAVEICULOCARGA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADAVEICULOCARGA](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusEnt] [varchar](30) NULL,
	[DataLanc] [datetime] NULL,
	[IdVisita] [int] NOT NULL,
	[IdVeiculo] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADAVEICULOSTERCEIRO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADAVEICULOSTERCEIRO](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[StatusLanc] [varchar](30) NULL,
	[ObsLanc] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENTRADAVEICULOSUNIDADE]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ENTRADAVEICULOSUNIDADE](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[StatusLanc] [varchar](30) NULL,
	[ObsLanc] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ESCOLTA_INTERNO_PSP]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ESCOLTA_INTERNO_PSP](
	[IdEsco] [int] IDENTITY(1,1) NOT NULL,
	[StatusEscolta] [varchar](30) NULL,
	[DataRegistro] [datetime] NULL,
	[IdFunc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataSaida] [datetime] NULL,
	[HoraSaida] [varchar](20) NULL,
	[DataRetorno] [datetime] NULL,
	[HoraRetorno] [varchar](20) NULL,
	[AssinaturaColaboradorSaida] [varbinary](max) NULL,
	[AssinaturaColaboradorRetorno] [varbinary](max) NULL,
	[AssinaturaInternoSaida] [varbinary](max) NULL,
	[AssinaturaInternoRetorno] [varbinary](max) NULL,
	[AssinaturaColaboradorLiberadorSaida] [varbinary](max) NULL,
	[AssinaturaColaboradorLiberadorRetorno] [varbinary](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEsco] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ESTOQUE_ACERVO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ESTOQUE_ACERVO](
	[IdEstoque] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [date] NULL,
	[NrDoc] [int] NULL,
	[TipoMov] [varchar](1) NULL,
	[IdLivro] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[SaldoEstoque] [float] NULL,
	[QtdReservada] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEstoque] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ESTOQUEPERTENCES]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ESTOQUEPERTENCES](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdMov] [int] NULL,
	[StatusMov] [varchar](1) NULL,
	[DataLanc] [date] NULL,
	[IdItemMov] [int] NULL,
	[IdPertence] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[QtdLanc] [float] NULL,
	[SaldoEstoque] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ESTORNO_DEPOSITO_SAQUE]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ESTORNO_DEPOSITO_SAQUE](
	[IdEstorno] [int] IDENTITY(1,1) NOT NULL,
	[StatusEstorno] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Tipo] [int] NULL,
	[ValorEstorno] [real] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataRegistro] [datetime] NULL,
	[IdRegistro] [int] NULL,
	[ValorDepositoSaque] [real] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEstorno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ESTORNO_PRODUTOS_AC]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ESTORNO_PRODUTOS_AC](
	[IdEst] [int] IDENTITY(1,1) NOT NULL,
	[StatusEst] [varchar](20) NULL,
	[DataEst] [datetime] NULL,
	[TipoEstorno] [int] NOT NULL,
	[DataReq] [date] NULL,
	[LocalEstoque] [int] NULL,
	[IdReq] [int] NOT NULL,
	[NomeRequisitante] [varchar](300) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEst] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ESTORNO_PRODUTOS_ENF]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ESTORNO_PRODUTOS_ENF](
	[IdEst] [int] IDENTITY(1,1) NOT NULL,
	[StatusEst] [varchar](20) NULL,
	[DataEst] [datetime] NULL,
	[TipoEstorno] [int] NOT NULL,
	[DataReq] [date] NULL,
	[LocalEstoque] [int] NULL,
	[IdReq] [int] NOT NULL,
	[NomeRequisitante] [varchar](300) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEst] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ESTORNO_PRODUTOS_FAR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ESTORNO_PRODUTOS_FAR](
	[IdEst] [int] IDENTITY(1,1) NOT NULL,
	[StatusEst] [varchar](20) NULL,
	[DataEst] [datetime] NULL,
	[TipoEstorno] [int] NOT NULL,
	[DataReq] [date] NULL,
	[LocalEstoque] [int] NULL,
	[IdReq] [int] NOT NULL,
	[NomeRequisitante] [varchar](300) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEst] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ESTORNO_PRODUTOS_NUTRI]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ESTORNO_PRODUTOS_NUTRI](
	[IdEst] [int] IDENTITY(1,1) NOT NULL,
	[StatusEst] [varchar](20) NULL,
	[DataEst] [datetime] NULL,
	[TipoEstorno] [int] NOT NULL,
	[DataReq] [date] NULL,
	[LocalEstoque] [int] NULL,
	[IdReq] [int] NOT NULL,
	[NomeRequisitante] [varchar](300) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEst] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EVADIDOSIND]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EVADIDOSIND](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[TipoOp] [varchar](100) NULL,
	[NrDocSaida] [varchar](100) NULL,
	[TipoEvasao] [int] NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[IdSaida] [int] NULL,
	[DataSaida] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EVOLUCAO_ADMISSAO_PEDAGOGIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EVOLUCAO_ADMISSAO_PEDAGOGIA](
	[IdEvolucao] [int] IDENTITY(1,1) NOT NULL,
	[IdAdm] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataEvolucao] [datetime] NULL,
	[NomeDepartamento] [varchar](200) NULL,
	[DataEncaminhamento] [datetime] NULL,
	[HoraEncaminhamento] [varchar](20) NULL,
	[TextoEvolucao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[AcessoUni] [varchar](3) NULL,
	[AnoIngresso] [int] NULL,
	[AdmEvo] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEvolucao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EVOLUCAO_ATENDIMENTO_FAMILIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EVOLUCAO_ATENDIMENTO_FAMILIA](
	[IdEvolucaoFam] [int] IDENTITY(1,1) NOT NULL,
	[DataEvolVisita] [datetime] NULL,
	[IdVisita] [int] NOT NULL,
	[IdAtendf] [int] NOT NULL,
	[TextoEvolucaoVisita] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEvolucaoFam] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EVOLUCAO_ATENDIMENTO_SOCIAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EVOLUCAO_ATENDIMENTO_SOCIAL](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataEvol] [datetime] NULL,
	[IdAtend] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoEvolucao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[AdmEvo] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EVOLUCAO_EDUCACAO_FISICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EVOLUCAO_EDUCACAO_FISICA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataEvolucaoEF] [datetime] NULL,
	[IdRegistroEF] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoEvolucaoEF] [varchar](max) NULL,
	[AdmEvo] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EVOLUCAO_PAI]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EVOLUCAO_PAI](
	[IdEvolucao] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[DataEvolucao] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoEvolucao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEvolucao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EVOLUCAO_PAI_NOVO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EVOLUCAO_PAI_NOVO](
	[IdEvolucao] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[DataEvolucao] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoEvolucao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEvolucao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EVOLUCAO_PSIQUIATRICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EVOLUCAO_PSIQUIATRICA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataEvol] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[EvolucaoPsiquiatrica] [varchar](max) NULL,
	[HipoteseDiagnostica] [varchar](max) NULL,
	[ExamesSolicitados] [varchar](max) NULL,
	[Patologia] [varchar](10) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[AdmEvo] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EVOLUCAOENFERMAGEM]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EVOLUCAOENFERMAGEM](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataEvol] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoEvolucao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[AdmEvo] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EVOLUCAOJURIDICO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EVOLUCAOJURIDICO](
	[IdEvo] [int] IDENTITY(1,1) NOT NULL,
	[DataEvo] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdLanc] [int] NOT NULL,
	[Evolucao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[DataEnca] [datetime] NULL,
	[TipoAdvogado] [varchar](50) NULL,
	[Resposta] [varchar](20) NULL,
	[HoraEnvio] [varchar](10) NULL,
	[SetorEncaminhamento] [varchar](300) NULL,
	[AdmEvo] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEvo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EVOLUCAOMEDICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EVOLUCAOMEDICA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataEvolu] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoEvolucao] [varchar](max) NULL,
	[HipoteseDiagnostica] [varchar](max) NULL,
	[ExamesSolicitados] [varchar](max) NULL,
	[Patologia] [varchar](10) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[AdmEvo] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EVOLUCAOPSICOLOGICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EVOLUCAOPSICOLOGICA](
	[IdEvolucao] [int] IDENTITY(1,1) NOT NULL,
	[StatusEvo] [varchar](100) NULL,
	[DataEvolucao] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Historico] [varchar](max) NULL,
	[NomeDepartamento] [varchar](200) NULL,
	[DataEncaminhamento] [datetime] NULL,
	[HoraEncaminhamento] [varchar](10) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[AdmEvo] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEvolucao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EVOLUCAOTECENFERMAGEM]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EVOLUCAOTECENFERMAGEM](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataEvol] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoEvolucao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EVOLUCAOTERAPIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EVOLUCAOTERAPIA](
	[IdEvo] [int] IDENTITY(1,1) NOT NULL,
	[DataEvo] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdLanc] [int] NOT NULL,
	[Evolucao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[AdmEvo] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEvo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FALTAS_INDISCIPLINAR_INDIVIDUAL_INTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FALTAS_INDISCIPLINAR_INDIVIDUAL_INTERNOS](
	[IdFaltaFO1] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Incitar] [int] NULL,
	[Fugir] [int] NULL,
	[Possuir] [int] NULL,
	[Provocar] [int] NULL,
	[Descumprir] [int] NULL,
	[Desobedecer] [int] NULL,
	[Recusar] [int] NULL,
	[Posse] [int] NULL,
	[PraticarFato] [int] NULL,
	[Realiza] [int] NULL,
	[PraticarAto] [int] NULL,
	[Dificultar] [int] NULL,
	[Circular] [int] NULL,
	[Fabricar] [int] NULL,
	[Fabricar2] [int] NULL,
	[Fisica] [int] NULL,
	[Impedir] [int] NULL,
	[Portar] [int] NULL,
	[Dificultar1] [int] NULL,
	[Improvisar] [int] NULL,
	[Induzir] [int] NULL,
	[Simular] [int] NULL,
	[Divulgar] [int] NULL,
	[Recusar1] [int] NULL,
	[Submeter] [int] NULL,
	[Deixar] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFaltaFO1] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FALTAS_INDISCIPLINAR_INDIVIDUAL_INTERNOS_01]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FALTAS_INDISCIPLINAR_INDIVIDUAL_INTERNOS_01](
	[IdFaltaFO2] [int] IDENTITY(1,1) NOT NULL,
	[IdReg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Incitar] [int] NULL,
	[Fugir] [int] NULL,
	[Possuir] [int] NULL,
	[Provocar] [int] NULL,
	[Descumprir] [int] NULL,
	[Desobedecer] [int] NULL,
	[Recusar] [int] NULL,
	[Posse] [int] NULL,
	[PraticarFato] [int] NULL,
	[Realiza] [int] NULL,
	[PraticarAto] [int] NULL,
	[Dificultar] [int] NULL,
	[Circular] [int] NULL,
	[Fabricar] [int] NULL,
	[Fabricar2] [int] NULL,
	[Fisica] [int] NULL,
	[Impedir] [int] NULL,
	[Portar] [int] NULL,
	[Dificultar1] [int] NULL,
	[Improvisar] [int] NULL,
	[Induzir] [int] NULL,
	[Simular] [int] NULL,
	[Divulgar] [int] NULL,
	[Recusar1] [int] NULL,
	[Submeter] [int] NULL,
	[Deixar] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFaltaFO2] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FAMILIA_ADMISSAO_PEDAGOGIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FAMILIA_ADMISSAO_PEDAGOGIA](
	[IdFam] [int] IDENTITY(1,1) NOT NULL,
	[IdAdm] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[RelacaoPai] [varchar](7) NULL,
	[RelacaoMae] [varchar](7) NULL,
	[Irmaos] [varchar](7) NULL,
	[PaisLerEscrever] [varchar](7) NULL,
	[PaisSeparados] [varchar](7) NULL,
	[Religiao] [varchar](200) NULL,
	[IdadeAndou] [int] NULL,
	[IdadeFalou] [int] NULL,
	[DificuldadeFala] [varchar](7) NULL,
	[QualDificuldadeFala] [varchar](200) NULL,
	[Comunicacao] [varchar](max) NULL,
	[Relacionamento] [varchar](7) NULL,
	[Lider] [varchar](7) NULL,
	[RepetiuAno] [varchar](7) NULL,
	[PorqueRepetiuAno] [varchar](200) NULL,
	[ProblemaProfessor] [varchar](7) NULL,
	[QualProblemaProfessor] [varchar](200) NULL,
	[ComoAtitudeSala] [varchar](200) NULL,
	[FaltaEscola] [varchar](7) NULL,
	[PorqueFaltaEscola] [varchar](200) NULL,
	[AchaEscola] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFam] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FAMILIA_ADMISSAO_PEDAGOGIA_NOVA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FAMILIA_ADMISSAO_PEDAGOGIA_NOVA](
	[IdFamNova] [int] IDENTITY(1,1) NOT NULL,
	[IdAdmNova] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[RelacaoPai] [varchar](7) NULL,
	[RelacaoMae] [varchar](7) NULL,
	[Irmaos] [varchar](7) NULL,
	[PaisLerEscrever] [varchar](7) NULL,
	[PaisSeparados] [varchar](7) NULL,
	[Religiao] [varchar](200) NULL,
	[IdadeAndou] [int] NULL,
	[IdadeFalou] [int] NULL,
	[DificuldadeFala] [varchar](7) NULL,
	[QualDificuldadeFala] [varchar](200) NULL,
	[Comunicacao] [varchar](max) NULL,
	[Relacionamento] [varchar](7) NULL,
	[Lider] [varchar](7) NULL,
	[RepetiuAno] [varchar](7) NULL,
	[PorqueRepetiuAno] [varchar](200) NULL,
	[ProblemaProfessor] [varchar](7) NULL,
	[QualProblemaProfessor] [varchar](200) NULL,
	[ComoAtitudeSala] [varchar](200) NULL,
	[FaltaEscola] [varchar](7) NULL,
	[PorqueFaltaEscola] [varchar](200) NULL,
	[AchaEscola] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFamNova] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FEMININO_ADMISSAO_PEDAGOGIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FEMININO_ADMISSAO_PEDAGOGIA](
	[IdFemAdm] [int] IDENTITY(1,1) NOT NULL,
	[IdAdm] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[FilhoDesejado] [varchar](7) NULL,
	[QueriaEngravidar] [varchar](7) NULL,
	[FoiAcidental] [varchar](7) NULL,
	[Perturbou] [varchar](7) NULL,
	[ComoFoiGestacao] [varchar](max) NULL,
	[ComoFoiParto] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFemAdm] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FEMININO_ADMISSAO_PEDAGOGIA_NOVA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FEMININO_ADMISSAO_PEDAGOGIA_NOVA](
	[IdFemAdmNova] [int] IDENTITY(1,1) NOT NULL,
	[IdAdmNova] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[FilhoDesejado] [varchar](7) NULL,
	[QueriaEngravidar] [varchar](7) NULL,
	[FoiAcidental] [varchar](7) NULL,
	[Perturbou] [varchar](7) NULL,
	[ComoFoiGestacao] [varchar](max) NULL,
	[ComoFoiParto] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFemAdmNova] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FICHA_CADASTRO_PAI_CCGF]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FICHA_CADASTRO_PAI_CCGF](
	[IdCCGF] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TemFilhos] [varchar](3) NULL,
	[QuantosFilhos] [int] NULL,
	[ReconhecerPaterna] [varchar](3) NULL,
	[DadosPaternidade] [varchar](200) NULL,
	[EstaoFilho] [varchar](100) NULL,
	[NecessidaEspecial] [varchar](3) NULL,
	[NecessidadeESP] [varchar](100) NULL,
	[CRAS] [varchar](3) NULL,
	[CREAS] [varchar](3) NULL,
	[RecebeBeneficio] [varchar](3) NULL,
	[QuaisBeneficiosFamilia] [varchar](80) NULL,
	[AntesBeneficio] [varchar](3) NULL,
	[QuaisBeneficiosAntesPrisao] [varchar](80) NULL,
	[NecessitaBeneficio] [varchar](3) NULL,
	[QuemNecessitaBeneficio] [varchar](80) NULL,
	[Moradia] [varchar](30) NULL,
	[Modalidade] [varchar](30) NULL,
	[Abastecimento] [varchar](30) NULL,
	[EliminaDejetos] [varchar](30) NULL,
	[Descarte] [varchar](30) NULL,
	[FamiliaVulneraSocial] [varchar](3) NULL,
	[ViveuRua] [varchar](3) NULL,
	[QuantoTempo] [int] NULL,
	[Motivo] [varchar](100) NULL,
	[FamiliaDetido] [varchar](30) NULL,
	[RestabelecerVinculo] [varchar](30) NULL,
	[ComoRestabelecer] [varchar](80) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCCGF] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FICHA_CADASTRO_PAI_CCGF_VF]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FICHA_CADASTRO_PAI_CCGF_VF](
	[IdVF] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[NomeFamiliar] [varchar](250) NULL,
	[Vinculo] [varchar](100) NULL,
	[Idade] [int] NULL,
	[Ocupacao] [varchar](100) NULL,
	[Endereco] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVF] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FICHA_CADASTRO_PAI_CCGF_VF1]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FICHA_CADASTRO_PAI_CCGF_VF1](
	[IdVF1] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdVisita] [int] NOT NULL,
	[Ocupacao] [varchar](100) NULL,
	[Idade] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVF1] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FICHA_CADASTRO_PAI_CCGF_VF2]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FICHA_CADASTRO_PAI_CCGF_VF2](
	[IdVF2] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdVisita] [int] NOT NULL,
	[Ocupacao] [varchar](100) NULL,
	[Idade] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVF2] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FICHA_CADASTRO_PAI_DEME]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FICHA_CADASTRO_PAI_DEME](
	[IdDEME] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[NecessitaFamilia] [varchar](3) NULL,
	[ParaQuemFamilia] [varchar](100) NULL,
	[EstaGravida] [varchar](3) NULL,
	[Comprovacao] [varchar](3) NULL,
	[PreNatal] [varchar](3) NULL,
	[OndePreNatal] [varchar](100) NULL,
	[DestinoBebe] [varchar](15) NULL,
	[SuspeitaGravidez] [varchar](3) NULL,
	[QuantosPartos] [int] NULL,
	[QuantosAbortos] [int] NULL,
	[QuantosPartosNornais] [int] NULL,
	[QuantasCesarianas] [int] NULL,
	[Contraceptivos] [varchar](3) NULL,
	[QualContraceptivos] [varchar](max) NULL,
	[Demanda] [varchar](3) NULL,
	[QualDemanda] [varchar](max) NULL,
	[Instrucao] [varchar](30) NULL,
	[EstudandoPreso] [varchar](3) NULL,
	[ParticipouPrisional] [varchar](3) NULL,
	[GostariaPrisional] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDEME] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FICHA_CADASTRO_PAI_DJ]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FICHA_CADASTRO_PAI_DJ](
	[IdDJ] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[RegimeAprisionamento] [varchar](100) NULL,
	[Artigo] [int] NULL,
	[Delito] [varchar](100) NULL,
	[Reincidente] [varchar](3) NULL,
	[PossuiPena] [varchar](3) NULL,
	[QualPena] [varchar](80) NULL,
	[PossuiJuridica] [varchar](3) NULL,
	[QualAssistenciaJuridica] [varchar](30) NULL,
	[PROMAE] [varchar](30) NULL,
	[AssistenciaJuridica] [varchar](30) NULL,
	[Trabalhaempresa] [varchar](3) NULL,
	[TelefoneContatoEmpresa] [varchar](13) NULL,
	[QualEmpresa] [varchar](200) NULL,
	[QualFuncaoExerce] [varchar](200) NULL,
	[CartaInformal] [varchar](3) NULL,
	[ParaOnde] [varchar](80) NULL,
	[TelefoneContato] [varchar](13) NULL,
	[EstudaUP] [varchar](3) NULL,
	[OndeEstuda] [varchar](200) NULL,
	[NecessitaTrabalho] [varchar](3) NULL,
	[QualNecessitaTrabalho] [varchar](100) NULL,
	[NecessitaEstudaFUP] [varchar](3) NULL,
	[QualNecessidadeEstudaFUP] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDJ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FICHA_CADASTRO_PAI_DPTL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FICHA_CADASTRO_PAI_DPTL](
	[IdDPTL] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[ProfissaoOcupacao] [varchar](200) NULL,
	[TrabalhaDetido] [varchar](3) NULL,
	[Desempregado] [varchar](3) NULL,
	[CarteiraAssinada] [varchar](3) NULL,
	[QuantoTempoCarteira] [int] NULL,
	[FaixaSalarial] [real] NULL,
	[TemBeneficios] [varchar](3) NULL,
	[QuemTemBeneficios] [varchar](80) NULL,
	[DemandaReclusao] [varchar](3) NULL,
	[DemandaDesemprego] [varchar](3) NULL,
	[PossuiRedimento] [varchar](3) NULL,
	[QualRendimento] [varchar](150) NULL,
	[ExerceAtividade] [varchar](3) NULL,
	[QualAtividadeExerce] [varchar](150) NULL,
	[GeracaoRenda] [varchar](3) NULL,
	[AptidaoProfissional] [varchar](3) NULL,
	[QualAptidao] [varchar](200) NULL,
	[DemandaProfissional] [varchar](3) NULL,
	[QualDemandaProfissional] [varchar](max) NULL,
	[AptidaoArt] [varchar](3) NULL,
	[QualAptidaoArt] [varchar](max) NULL,
	[DemandaLazer] [varchar](3) NULL,
	[QualDemandaLazer] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDPTL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FICHA_CADASTRO_PAI_DS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FICHA_CADASTRO_PAI_DS](
	[IdDS] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[RefereSaude] [varchar](3) NULL,
	[Hanseniase] [int] NULL,
	[Diabetes] [int] NULL,
	[Tuberculose] [int] NULL,
	[Hipertensao] [int] NULL,
	[Hepatites] [int] NULL,
	[Sifilis] [int] NULL,
	[Escabiose] [int] NULL,
	[HIV] [int] NULL,
	[OutrasDoencas] [varchar](100) NULL,
	[FazendoTratamento] [varchar](3) NULL,
	[Psiquiatrico] [varchar](3) NULL,
	[OndePsiquiatrico] [varchar](100) NULL,
	[Psicotropico] [varchar](3) NULL,
	[QualPsicotropico] [varchar](100) NULL,
	[Mental] [varchar](3) NULL,
	[Desanimo] [int] NULL,
	[Insonia] [int] NULL,
	[FaltaApetite] [int] NULL,
	[IsolamentoSocial] [int] NULL,
	[PensamentosSuicidas] [int] NULL,
	[Agressividade] [int] NULL,
	[Inquietacao] [int] NULL,
	[OutroDoencas] [int] NULL,
	[QualOutrosDoencas] [varchar](200) NULL,
	[InternadoPSI] [varchar](3) NULL,
	[DataInternaPSI] [datetime] NULL,
	[AcompanhaCAPS] [varchar](3) NULL,
	[DataCAPS] [datetime] NULL,
	[UsoPsicoativos] [varchar](3) NULL,
	[Alcool] [int] NULL,
	[Maconha] [int] NULL,
	[Cocaina] [int] NULL,
	[Cola] [int] NULL,
	[Crack] [int] NULL,
	[Injetaveis] [int] NULL,
	[OutrasSub] [int] NULL,
	[QualOutrasSub] [varchar](100) NULL,
	[CompartilhaCrack] [varchar](3) NULL,
	[Sudorese] [int] NULL,
	[Tremores] [int] NULL,
	[Fissura] [int] NULL,
	[BocaSeca] [int] NULL,
	[Nausea] [int] NULL,
	[Desejo] [int] NULL,
	[NaoPara] [int] NULL,
	[AumentoTolerancia] [int] NULL,
	[CAPSAD] [varchar](3) NULL,
	[DataCAPSAD] [datetime] NULL,
	[EsteveInternado] [varchar](3) NULL,
	[QuantoTempoInternado] [int] NULL,
	[AceitaDanos] [varchar](3) NULL,
	[SaudeBucal] [varchar](3) NULL,
	[NecessitaAtende] [varchar](3) NULL,
	[Enfermagem] [int] NULL,
	[Medico] [int] NULL,
	[PsiquiatricoN] [int] NULL,
	[Psicologico] [int] NULL,
	[PessoasQuimica] [varchar](3) NULL,
	[QuemNecessita] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FICHA_CADASTRO_PAI_EAPI1]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FICHA_CADASTRO_PAI_EAPI1](
	[IdEAP1] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[PSP] [varchar](max) NULL,
	[CEDEGEP] [varchar](max) NULL,
	[CRASCREAS] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEAP1] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FICHA_CADASTRO_PAI_EAPI2]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FICHA_CADASTRO_PAI_EAPI2](
	[IdEAPI2] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[ASSISTENCIA] [varchar](max) NULL,
	[DOCUMENTOCIVIL] [varchar](max) NULL,
	[EAPI2PAI] [varchar](max) NULL,
	[TecnicoServicoSocial] [varchar](200) NULL,
	[TecnicoPsicologico] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEAPI2] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FICHA_CADASTRO_PAI_PSICOSOCIAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FICHA_CADASTRO_PAI_PSICOSOCIAL](
	[IdPai] [int] IDENTITY(1,1) NOT NULL,
	[StatusPai] [varchar](20) NULL,
	[DataPai] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdadeInterno] [int] NULL,
	[Naturalidade] [varchar](200) NULL,
	[OrientacaoSexual] [varchar](3) NULL,
	[MunicipioRegistrado] [varchar](200) NULL,
	[TipoOrientacaoSexual] [varchar](60) NULL,
	[DocumentoDelega] [varchar](3) NULL,
	[QualDocumento] [varchar](200) NULL,
	[QualDelegacia] [varchar](200) NULL,
	[RegularizarDocumento] [varchar](3) NULL,
	[TipoDocumento] [varchar](200) NULL,
	[RGInternoPAI] [varchar](20) NULL,
	[Emissor] [varchar](20) NULL,
	[DataExpedicao] [datetime] NULL,
	[CPFInternoPAI] [varchar](20) NULL,
	[CartaoSUSPAI] [varchar](20) NULL,
	[TituloEleitor] [varchar](20) NULL,
	[Zona] [varchar](20) NULL,
	[Sessao] [varchar](20) NULL,
	[NIS] [varchar](20) NULL,
	[CTPS] [varchar](20) NULL,
	[Serie] [varchar](20) NULL,
	[Religiao] [varchar](200) NULL,
	[EstadoCivil] [varchar](200) NULL,
	[Endereco] [varchar](200) NULL,
	[Complemento] [varchar](200) NULL,
	[Referencia] [varchar](200) NULL,
	[Bairro] [varchar](200) NULL,
	[Cidade] [varchar](200) NULL,
	[Estado] [varchar](2) NULL,
	[Telefone] [varchar](20) NULL,
	[Telefone1] [varchar](20) NULL,
	[Celular] [varchar](20) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FICHA_JURIDICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FICHA_JURIDICA](
	[IdFicha] [int] IDENTITY(1,1) NOT NULL,
	[StatusFicha] [varchar](30) NULL,
	[DataFicha] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFicha] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FICHA_TECNICA_NUTRI]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FICHA_TECNICA_NUTRI](
	[IdFicha] [int] IDENTITY(1,1) NOT NULL,
	[StatusFicha] [varchar](20) NULL,
	[DataFicha] [datetime] NULL,
	[DescricaoFicha] [varchar](300) NOT NULL,
	[IdCat] [int] NOT NULL,
	[Porcoes] [int] NULL,
	[FotoReceita] [varchar](300) NULL,
	[ModoFazer] [varchar](max) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFicha] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FICHALABORATIVA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FICHALABORATIVA](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdEmp] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FORNECEDORES_AC]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FORNECEDORES_AC](
	[IdForn] [int] IDENTITY(1,1) NOT NULL,
	[ClassFor] [varchar](20) NULL,
	[StatusFor] [varchar](20) NULL,
	[RazaoSocial] [varchar](250) NULL,
	[NomeFantasia] [varchar](250) NULL,
	[Departamento] [varchar](200) NULL,
	[Cnpj] [varchar](20) NULL,
	[InsEstadual] [varchar](20) NULL,
	[CpfFor] [varchar](20) NULL,
	[NomeContato] [varchar](300) NULL,
	[RgFor] [varchar](20) NULL,
	[Telefone] [varchar](20) NULL,
	[Telefone1] [varchar](20) NULL,
	[Celular] [varchar](20) NULL,
	[Email] [varchar](100) NULL,
	[Fax] [varchar](20) NULL,
	[Endereco] [varchar](300) NULL,
	[Compl] [varchar](200) NULL,
	[Cep] [varchar](20) NULL,
	[Cidade] [varchar](200) NULL,
	[Estado] [varchar](2) NULL,
	[EnderecoCob] [varchar](300) NULL,
	[ComplCob] [varchar](200) NULL,
	[CepCob] [varchar](20) NULL,
	[CidadeCob] [varchar](200) NULL,
	[EstadoCob] [varchar](2) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Modulo] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdForn] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FORNECEDORES_ACERVO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FORNECEDORES_ACERVO](
	[IdForn] [int] IDENTITY(1,1) NOT NULL,
	[ClassFor] [varchar](20) NULL,
	[StatusFor] [varchar](20) NULL,
	[RazaoSocial] [varchar](250) NULL,
	[Cnpj] [varchar](20) NULL,
	[InsEstadual] [varchar](20) NULL,
	[CpfFor] [varchar](20) NULL,
	[RgFor] [varchar](20) NULL,
	[Telefone] [varchar](20) NULL,
	[Telefone1] [varchar](20) NULL,
	[Celular] [varchar](20) NULL,
	[Email] [varchar](100) NULL,
	[Fax] [varchar](20) NULL,
	[Endereco] [varchar](300) NULL,
	[Compl] [varchar](200) NULL,
	[Cep] [varchar](20) NULL,
	[Cidade] [varchar](200) NULL,
	[Estado] [varchar](2) NULL,
	[EnderecoCob] [varchar](300) NULL,
	[ComplCob] [varchar](200) NULL,
	[CepCob] [varchar](20) NULL,
	[CidadeCob] [varchar](200) NULL,
	[EstadoCob] [varchar](2) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdForn] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FREQUENCIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FREQUENCIA](
	[IdFreq] [int] IDENTITY(1,1) NOT NULL,
	[StatusFreq] [varchar](20) NULL,
	[DataFreq] [date] NULL,
	[IdMat] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFreq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA](
	[IdFAC] [int] IDENTITY(1,1) NOT NULL,
	[StatusFAC] [varchar](15) NULL,
	[DataFAC] [datetime] NULL,
	[IdCurso] [int] NOT NULL,
	[IdProf] [int] NOT NULL,
	[LocalEvento] [varchar](100) NULL,
	[IdCCAC] [int] NULL,
	[Dia2] [int] NULL,
	[Dia3] [int] NULL,
	[Dia4] [int] NULL,
	[Dia5] [int] NULL,
	[Dia6] [int] NULL,
	[Dia7] [int] NULL,
	[Dia8] [int] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFAC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FREQUENCIA_CAPACITACAO_INTERNO_TO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FREQUENCIA_CAPACITACAO_INTERNO_TO](
	[IdFreqCap] [int] IDENTITY(1,1) NOT NULL,
	[StatusRegistro] [varchar](20) NULL,
	[DataRegistro] [datetime] NULL,
	[IdCurso] [int] NOT NULL,
	[LocalCurso] [varchar](100) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFreqCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FREQUENCIA_LABORATIVA_EXTERNA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FREQUENCIA_LABORATIVA_EXTERNA](
	[IdFreqLab] [int] IDENTITY(1,1) NOT NULL,
	[StatusFreqLab] [varchar](20) NULL,
	[DataFreqLab] [datetime] NULL,
	[TipoAtiv] [int] NULL,
	[IdEmp] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[MesReferencia] [varchar](20) NULL,
	[AnoReferencia] [varchar](4) NULL,
	[DataInicio] [datetime] NULL,
	[DataTermino] [datetime] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFreqLab] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FREQUENCIA_PEDAGOGIA_EXTERNA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FREQUENCIA_PEDAGOGIA_EXTERNA](
	[IdFreqLab] [int] IDENTITY(1,1) NOT NULL,
	[StatusFreqLab] [varchar](20) NULL,
	[DataFreqLab] [datetime] NULL,
	[TipoAtiv] [int] NULL,
	[IdCod] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[MesReferencia] [varchar](20) NULL,
	[AnoReferencia] [varchar](4) NULL,
	[DataInicio] [datetime] NULL,
	[DataTermino] [datetime] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFreqLab] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[GRUPO_PRODUTOS_AC]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[GRUPO_PRODUTOS_AC](
	[IdGrupo] [int] IDENTITY(1,1) NOT NULL,
	[StatusGru] [varchar](20) NULL,
	[NomeGrupo] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Modulo] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdGrupo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[GRUPOUSUARIOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[GRUPOUSUARIOS](
	[IdGrupo] [int] IDENTITY(1,1) NOT NULL,
	[StatusGrupo] [tinyint] NOT NULL,
	[NomeGrupo] [varchar](50) NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdGrupo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HISTORICO_AVALICAO_SERVICO_SOCIAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HISTORICO_AVALICAO_SERVICO_SOCIAL](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Titulo] [varchar](300) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HISTORICO_COMPRA_AC]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HISTORICO_COMPRA_AC](
	[IdHistCompra] [int] IDENTITY(1,1) NOT NULL,
	[NfCompra] [int] NULL,
	[DataMov] [date] NULL,
	[IdNfEntrada] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[QtdeCompra] [float] NULL,
	[ValorUnit] [money] NULL,
	[ValorTotal] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHistCompra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HISTORICO_COMPRA_ACERVO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HISTORICO_COMPRA_ACERVO](
	[IdHistCompra] [int] IDENTITY(1,1) NOT NULL,
	[DataMov] [date] NULL,
	[IdCompra] [int] NOT NULL,
	[IdLivro] [int] NOT NULL,
	[QtdeCompra] [float] NULL,
	[ValorUnit] [float] NULL,
	[ValorTotal] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHistCompra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HISTORICO_COMPRA_FAR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HISTORICO_COMPRA_FAR](
	[IdHistCompra] [int] IDENTITY(1,1) NOT NULL,
	[NfCompra] [int] NULL,
	[DataMov] [date] NULL,
	[IdNfEntrada] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[QtdeCompra] [float] NULL,
	[ValorUnit] [money] NULL,
	[ValorTotal] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHistCompra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HISTORICO_COMPRA_NUTRI]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HISTORICO_COMPRA_NUTRI](
	[IdHistCompra] [int] IDENTITY(1,1) NOT NULL,
	[NfCompra] [int] NULL,
	[DataMov] [date] NULL,
	[IdNfEntrada] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[QtdeCompra] [decimal](18, 3) NULL,
	[ValorUnit] [money] NULL,
	[ValorTotal] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHistCompra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HISTORICO_DADOS_PENAIS_INTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HISTORICO_DADOS_PENAIS_INTERNOS](
	[IdHPenais] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdUnid] [int] NOT NULL,
	[IdEntrada] [int] NOT NULL,
	[IdItem] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[DataCrime] [datetime] NULL,
	[DataPrisao] [datetime] NULL,
	[DataCondenacao] [datetime] NULL,
	[DataNovaEntrada] [datetime] NULL,
	[Participacao] [varchar](20) NULL,
	[Regime] [varchar](20) NULL,
	[Pena] [varchar](20) NULL,
	[VaraCondenatoria] [varchar](100) NULL,
	[Artigo1] [varchar](20) NULL,
	[Artigo2] [varchar](20) NULL,
	[Artigo3] [varchar](20) NULL,
	[Paragrafo1] [varchar](20) NULL,
	[Paragrafo2] [varchar](20) NULL,
	[Paragrafo3] [varchar](20) NULL,
	[CrimeEdiondo] [varchar](20) NULL,
	[TerminoPena] [datetime] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHPenais] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HISTORICO_DOENCA_FAMILIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HISTORICO_DOENCA_FAMILIA](
	[IdHist] [int] IDENTITY(1,1) NOT NULL,
	[StatusHist] [varchar](20) NULL,
	[DataHist] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHist] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HISTORICO_EXTERNO_EDUCACIONAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HISTORICO_EXTERNO_EDUCACIONAL](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdCod] [int] NOT NULL,
	[IdItem] [int] NOT NULL,
	[DataEntrada] [date] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [date] NULL,
	[HorarioSaida] [varchar](20) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HISTORICO_INTERNO_EDUCACIONAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HISTORICO_INTERNO_EDUCACIONAL](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdCod] [int] NOT NULL,
	[IdItem] [int] NOT NULL,
	[DataEntrada] [date] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [date] NULL,
	[HorarioSaida] [varchar](20) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HISTORICO_LIBERADORES_BANCO_VIRTUAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HISTORICO_LIBERADORES_BANCO_VIRTUAL](
	[IdHist] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdUsuario] [int] NOT NULL,
	[Tipo] [int] NULL,
	[ValorLiberado] [real] NULL,
	[SaldoAtual] [real] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHist] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HISTORICO_LIBERADORES_BANCO_VIRTUAL_INATIVOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HISTORICO_LIBERADORES_BANCO_VIRTUAL_INATIVOS](
	[IdHist] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[IdDepIna] [int] NOT NULL,
	[IdUsuario] [int] NOT NULL,
	[Tipo] [int] NULL,
	[ValorLiberado] [real] NULL,
	[SaldoAtual] [real] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHist] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_AC]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_AC](
	[IdHistorico] [int] IDENTITY(1,1) NOT NULL,
	[IdProd] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[TipoOpe] [varchar](2) NULL,
	[NomeOperacao] [varchar](300) NULL,
	[IdDoc] [int] NULL,
	[DataMov] [date] NULL,
	[QtdItem] [float] NULL,
	[SaldoAtual] [float] NULL,
	[Modulo] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHistorico] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_ENF]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_ENF](
	[IdHistorico] [int] IDENTITY(1,1) NOT NULL,
	[IdProd] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[TipoOpe] [varchar](2) NULL,
	[NomeOperacao] [varchar](300) NULL,
	[IdDoc] [int] NULL,
	[DataMov] [date] NULL,
	[QtdItem] [float] NULL,
	[SaldoAtual] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHistorico] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_FAR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_FAR](
	[IdHistorico] [int] IDENTITY(1,1) NOT NULL,
	[IdProd] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[TipoOpe] [varchar](2) NULL,
	[NomeOperacao] [varchar](300) NULL,
	[IdDoc] [int] NULL,
	[DataMov] [date] NULL,
	[QtdItem] [float] NULL,
	[SaldoAtual] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHistorico] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_NUTRI]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_NUTRI](
	[IdHistorico] [int] IDENTITY(1,1) NOT NULL,
	[IdProd] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[TipoOpe] [varchar](2) NULL,
	[NomeOperacao] [varchar](300) NULL,
	[IdDoc] [int] NULL,
	[DataMov] [date] NULL,
	[QtdItem] [decimal](18, 3) NULL,
	[SaldoAtual] [decimal](18, 3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHistorico] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HISTORICO_PRODUTOS_FORNECEDOR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HISTORICO_PRODUTOS_FORNECEDOR](
	[IdHistCompra] [int] IDENTITY(1,1) NOT NULL,
	[NfCompra] [int] NULL,
	[DataMov] [date] NULL,
	[IdItem] [int] NOT NULL,
	[IdForn] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[QtdeCompra] [float] NULL,
	[ValorUnit] [money] NULL,
	[Modulo] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHistCompra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HISTORICO_PRODUTOS_FORNECEDOR_FAR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HISTORICO_PRODUTOS_FORNECEDOR_FAR](
	[IdHistCompra] [int] IDENTITY(1,1) NOT NULL,
	[NfCompra] [int] NULL,
	[DataMov] [date] NULL,
	[IdItem] [int] NOT NULL,
	[IdForn] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[QtdeCompra] [float] NULL,
	[ValorUnit] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHistCompra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HISTORICO_PRODUTOS_FORNECEDOR_NUTRI]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HISTORICO_PRODUTOS_FORNECEDOR_NUTRI](
	[IdHistCompra] [int] IDENTITY(1,1) NOT NULL,
	[NfCompra] [int] NULL,
	[DataMov] [date] NULL,
	[IdItem] [int] NOT NULL,
	[IdForn] [int] NOT NULL,
	[QtdeCompra] [decimal](18, 3) NULL,
	[ValorUnit] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHistCompra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HISTORICO_VISITA_EMPREGO_SERVICO_SOCIAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HISTORICO_VISITA_EMPREGO_SERVICO_SOCIAL](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Titulo] [varchar](300) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HISTORICO_VISITAS_RELIGIOSA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HISTORICO_VISITAS_RELIGIOSA](
	[IdVisita] [int] IDENTITY(1,1) NOT NULL,
	[IdCod] [int] NOT NULL,
	[IdVisitaRel] [int] NOT NULL,
	[IdEntSaiVisita] [int] NOT NULL,
	[DataEntrada] [date] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [date] NULL,
	[HorarioSaida] [varchar](20) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HISTORICOAUTOR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HISTORICOAUTOR](
	[IdHist] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Historico] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHist] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HISTORICOLABORINTERNO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HISTORICOLABORINTERNO](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdEmp] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HISTORICOVISITASINTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HISTORICOVISITASINTERNOS](
	[IdVSocial] [int] IDENTITY(1,1) NOT NULL,
	[IdVisita] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Idlanc] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVSocial] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INCIDENCIA_PENAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INCIDENCIA_PENAL](
	[IdInc] [int] IDENTITY(1,1) NOT NULL,
	[IdFicha] [int] NOT NULL,
	[IdLanc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdInc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INDICACAO_VISITA_INTERNO_SERVICO_SOCIAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INDICACAO_VISITA_INTERNO_SERVICO_SOCIAL](
	[IdInd] [int] IDENTITY(1,1) NOT NULL,
	[DataInd] [datetime] NULL,
	[IdAtend] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[NomeVisitante] [varchar](300) NULL,
	[GrauParentesco] [varchar](200) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdInd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO](
	[IdIndAco] [int] IDENTITY(1,1) NOT NULL,
	[StatusPerfil] [varchar](20) NULL,
	[MesRef] [varchar](30) NULL,
	[AnoRef] [int] NULL,
	[DataPerfil] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[OpcaoSexual] [varchar](100) NULL,
	[AnoNasc] [int] NULL,
	[ObservacaoPerfil] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdIndAco] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA](
	[IdEnf] [int] IDENTITY(1,1) NOT NULL,
	[IdIndAco] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataReg] [datetime] NULL,
	[Diabetes] [varchar](3) NULL,
	[DiabControl] [varchar](3) NULL,
	[QtdDiabetes] [int] NULL,
	[Hipertensao] [varchar](3) NULL,
	[HiperControl] [varchar](3) NULL,
	[QtdHipertensao] [int] NULL,
	[Escabiose] [varchar](3) NULL,
	[EscabioseCura] [varchar](3) NULL,
	[QtdEscabiose] [int] NULL,
	[Hanseniase] [varchar](3) NULL,
	[HanseniaseCura] [varchar](3) NULL,
	[QtdHanseniase] [int] NULL,
	[Sifilis] [varchar](13) NULL,
	[SifilisCura] [varchar](3) NULL,
	[QtdSifilis] [int] NULL,
	[Tuberculose] [varchar](13) NULL,
	[TuberculoseCura] [varchar](3) NULL,
	[QtdTuberculose] [int] NULL,
	[Hiv] [varchar](13) NULL,
	[HivControlada] [varchar](3) NULL,
	[QtdHiv] [int] NULL,
	[HepatiteB] [varchar](13) NULL,
	[HepatiteBCont] [varchar](3) NULL,
	[QtdHepatiteB] [int] NULL,
	[HepatiteC] [varchar](13) NULL,
	[HepatiteCCont] [varchar](3) NULL,
	[QtdHepatiteC] [int] NULL,
	[Dst] [varchar](13) NULL,
	[DstCurada] [varchar](3) NULL,
	[QtdDst] [int] NULL,
	[Vdlr] [varchar](13) NULL,
	[VdlrCurada] [varchar](3) NULL,
	[QtdVdlr] [int] NULL,
	[Vacina] [varchar](3) NULL,
	[VacinaCura] [varchar](3) NULL,
	[QtdVacina] [int] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEnf] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC](
	[IdJurCrc] [int] IDENTITY(1,1) NOT NULL,
	[IdIndAco] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataJurCrc] [datetime] NULL,
	[Processos] [varchar](3) NULL,
	[QtdProgresso] [int] NULL,
	[Documentacao] [varchar](3) NULL,
	[QtdDocumentacao] [int] NULL,
	[Progressao] [varchar](3) NULL,
	[QtdProgressao] [int] NULL,
	[Livramento] [varchar](3) NULL,
	[QtdLivramento] [int] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdJurCrc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA](
	[IdPedago] [int] IDENTITY(1,1) NOT NULL,
	[IdIndAco] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataPeda] [datetime] NULL,
	[ICAA] [varchar](3) NULL,
	[QtdICAA] [int] NULL,
	[IC1] [varchar](3) NULL,
	[QtdIC1] [int] NULL,
	[IC2P] [varchar](3) NULL,
	[QtdIC2P] [int] NULL,
	[IAAU] [varchar](3) NULL,
	[QtdIAAU] [int] NULL,
	[IC3] [varchar](3) NULL,
	[QtdIC3] [int] NULL,
	[IREL] [varchar](3) NULL,
	[QtdIREL] [int] NULL,
	[IAC] [varchar](3) NULL,
	[QtdIAC] [int] NULL,
	[ICU1] [varchar](3) NULL,
	[QtdICU1] [int] NULL,
	[IC2] [varchar](3) NULL,
	[QtdIC2] [int] NULL,
	[ICA] [varchar](3) NULL,
	[QtdICA] [int] NULL,
	[Observacao] [varchar](250) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPedago] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_PSI]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_PSI](
	[IdPsi] [int] IDENTITY(1,1) NOT NULL,
	[IdIndAco] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataPsi] [datetime] NULL,
	[Tratamento] [varchar](3) NULL,
	[QtdTratamento] [int] NULL,
	[Acompanha] [varchar](3) NULL,
	[QtdAcompanha] [int] NULL,
	[Recuperacao] [varchar](3) NULL,
	[QtdRecuperacao] [int] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPsi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_SS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_SS](
	[IdSS] [int] IDENTITY(1,1) NOT NULL,
	[IdIndAco] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataSS] [datetime] NULL,
	[AcompanhaSS] [varchar](3) NULL,
	[QtdAcompanhaSS] [int] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_TO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_TO](
	[IdTo] [int] IDENTITY(1,1) NOT NULL,
	[IdIndAco] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataTo] [datetime] NULL,
	[Programa] [varchar](3) NULL,
	[Qtdprograma] [int] NULL,
	[Curso] [varchar](3) NULL,
	[QtdCurso] [int] NULL,
	[Profissional] [varchar](3) NULL,
	[QtdProfissional] [int] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INGREDIENTES_FICHA_TECNICA_NUTRI]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INGREDIENTES_FICHA_TECNICA_NUTRI](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[Item] [int] NOT NULL,
	[IdFicha] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[QtdItem] [decimal](18, 3) NOT NULL,
	[Perda] [decimal](18, 3) NOT NULL,
	[QtdFinal] [decimal](18, 3) NOT NULL,
	[PesoBruto] [decimal](18, 3) NULL,
	[PesoLiquido] [decimal](18, 3) NULL,
	[FatorCorrecao] [decimal](18, 3) NULL,
	[FatorCoccao] [decimal](18, 3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INSTITUICAO_RELIGIOSA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INSTITUICAO_RELIGIOSA](
	[IdCod] [int] IDENTITY(1,1) NOT NULL,
	[StatusInst] [varchar](20) NULL,
	[DataCad] [datetime] NULL,
	[NomeInstituicao] [varchar](300) NULL,
	[Endereco] [varchar](300) NULL,
	[Cidade] [varchar](200) NULL,
	[Estado] [varchar](2) NULL,
	[Telefone] [varchar](20) NULL,
	[Telefone1] [varchar](20) NULL,
	[Celular] [varchar](20) NULL,
	[Celular1] [varchar](20) NULL,
	[Email] [varchar](200) NULL,
	[Contato] [varchar](300) NULL,
	[Observacao] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCod] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INSTITUICAOESCOLAR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INSTITUICAOESCOLAR](
	[IdCod] [int] IDENTITY(1,1) NOT NULL,
	[StatusInst] [varchar](20) NULL,
	[DataCad] [datetime] NULL,
	[NomeInstituicao] [varchar](300) NULL,
	[Endereco] [varchar](300) NULL,
	[Cidade] [varchar](200) NULL,
	[Estado] [varchar](2) NULL,
	[Telefone] [varchar](20) NULL,
	[Telefone1] [varchar](20) NULL,
	[Celular] [varchar](20) NULL,
	[Celular1] [varchar](20) NULL,
	[Email] [varchar](200) NULL,
	[Contato] [varchar](300) NULL,
	[Observacao] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCod] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INTERNOS_ENTRADA_SAIDA_EDUCACAO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INTERNOS_ENTRADA_SAIDA_EDUCACAO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataSaida] [date] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[DataEntrada] [date] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[Observacao] [varchar](300) NULL,
	[Evadido] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Obito] [varchar](60) NULL,
	[AssinaturaSaida] [varbinary](max) NULL,
	[AssinaturaEntrada] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INTERNOS_PAVILHAO_KIT_LOTE]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INTERNOS_PAVILHAO_KIT_LOTE](
	[IdRegIntSel] [int] IDENTITY(1,1) NOT NULL,
	[IdRegistroComp] [int] NOT NULL,
	[IdPav] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Utili] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRegIntSel] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INTERNOS_SAIDA_EDUCACIONAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INTERNOS_SAIDA_EDUCACIONAL](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdEduca] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Motivo] [varchar](300) NULL,
	[TipoAcesso] [int] NULL,
	[Evadido] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Obito] [varchar](60) NULL,
	[DiaSeg] [int] NOT NULL,
	[DiaTer] [int] NOT NULL,
	[DiaQua] [int] NOT NULL,
	[DiaQui] [int] NOT NULL,
	[DiaSex] [int] NOT NULL,
	[DiaSab] [int] NOT NULL,
	[DiaDom] [int] NOT NULL,
	[HoraSeg] [varchar](5) NULL,
	[HoraTer] [varchar](5) NULL,
	[HoraQua] [varchar](5) NULL,
	[HoraQui] [varchar](5) NULL,
	[HoraSex] [varchar](5) NULL,
	[HoraSab] [varchar](5) NULL,
	[HoraDom] [varchar](5) NULL,
	[HoraSegEnt] [varchar](5) NULL,
	[HoraTerEnt] [varchar](5) NULL,
	[HoraQuaEnt] [varchar](5) NULL,
	[HoraQuiEnt] [varchar](5) NULL,
	[HoraSexEnt] [varchar](5) NULL,
	[HoraSabEnt] [varchar](5) NULL,
	[HoraDomEnt] [varchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INTERNOSISOLAMENTO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INTERNOSISOLAMENTO](
	[IdIsola] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdLancRet] [int] NOT NULL,
	[IdLanc] [int] NOT NULL,
	[ConfirmaUtilizacao] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[IdPav] [int] NOT NULL,
	[IdCela] [int] NOT NULL,
	[PavilhaoDestino] [varchar](200) NULL,
	[CelaDestino] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdIsola] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INTERNOSPROCEDIMENTOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[INTERNOSPROCEDIMENTOS](
	[IdItensIntProc] [int] IDENTITY(1,1) NOT NULL,
	[IdProc] [int] NOT NULL,
	[IdItensPcip] [int] NOT NULL,
	[IdCela] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItensIntProc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[INTERNOSVITIMAS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INTERNOSVITIMAS](
	[IdIntVitima] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdIntVitima] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INTERNOTESTEMUNHA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INTERNOTESTEMUNHA](
	[IdIntTeste] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdIntTeste] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INVENTARIO_AC]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INVENTARIO_AC](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[TipoInventario] [varchar](30) NULL,
	[IdLocal] [int] NOT NULL,
	[Responsavel] [varchar](250) NULL,
	[DataInicio] [date] NULL,
	[DataTermino] [date] NULL,
	[HorarioInicio] [varchar](20) NULL,
	[HorarioTermino] [varchar](20) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Modulo] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INVENTARIO_FAR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INVENTARIO_FAR](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[TipoInventario] [varchar](30) NULL,
	[IdLocal] [int] NOT NULL,
	[Responsavel] [varchar](250) NULL,
	[DataInicio] [date] NULL,
	[DataTermino] [date] NULL,
	[HorarioInicio] [varchar](20) NULL,
	[HorarioTermino] [varchar](20) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Modulo] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INVENTARIO_LIVROS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INVENTARIO_LIVROS](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[TipoInventario] [varchar](30) NULL,
	[IdLocal] [int] NOT NULL,
	[Responsavel] [varchar](250) NULL,
	[DataInicio] [date] NULL,
	[DataTermino] [date] NULL,
	[HorarioInicio] [varchar](20) NULL,
	[HorarioTermino] [varchar](20) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[INVENTARIO_NUTRI]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[INVENTARIO_NUTRI](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[TipoInventario] [varchar](30) NULL,
	[IdLocal] [int] NOT NULL,
	[Responsavel] [varchar](250) NULL,
	[DataInicio] [date] NULL,
	[DataTermino] [date] NULL,
	[HorarioInicio] [varchar](20) NULL,
	[HorarioTermino] [varchar](20) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_ADMISSAO_DOENCAS_ADICIONAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ITENS_ADMISSAO_DOENCAS_ADICIONAL](
	[IdItemDAD] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[IdAdmADI] [int] NOT NULL,
	[IdDoenca] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemDAD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ITENS_AGENDA_ATENDIMENTO_INTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_AGENDA_ATENDIMENTO_INTERNOS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdReg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdReg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_AGENDA_BENEFICIO_INTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_AGENDA_BENEFICIO_INTERNOS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdReg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_APRAZAMENTO_MEDICACAO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_APRAZAMENTO_MEDICACAO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdProd] [int] NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[QtdItemAP] [int] NULL,
	[Unidade] [varchar](50) NULL,
	[Frequencia] [varchar](50) NULL,
	[DiasUso] [int] NULL,
	[DataInicio] [datetime] NULL,
	[DataTermino] [datetime] NULL,
	[PeriodoHoras] [varchar](100) NULL,
	[HorarioInicial] [varchar](10) NULL,
	[HorarioFinal] [varchar](10) NULL,
	[TextoObservacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataAprova] [date] NULL,
	[IdAprova] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[QtdAprova] [float] NULL,
	[ValorUnitario] [money] NULL,
	[ValorTotal] [money] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA](
	[IdItemAC] [int] IDENTITY(1,1) NOT NULL,
	[IdAC] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataInicio] [datetime] NULL,
	[DataConclusao] [datetime] NULL,
	[Situacao] [varchar](80) NULL,
	[Avalicao] [varchar](80) NULL,
	[Observacao] [varchar](max) NULL,
	[DiaSeg] [int] NULL,
	[DiaTer] [int] NULL,
	[DiaQua] [int] NULL,
	[DiaQui] [int] NULL,
	[DiaSex] [int] NULL,
	[DiaSab] [int] NULL,
	[DiaDom] [int] NULL,
	[HoraEntSeg] [varchar](15) NULL,
	[HoraEntTer] [varchar](15) NULL,
	[HoraEntQua] [varchar](15) NULL,
	[HoraEntQui] [varchar](15) NULL,
	[HoraEntSex] [varchar](15) NULL,
	[HoraEntSab] [varchar](15) NULL,
	[HoraEntDom] [varchar](15) NULL,
	[HoraSaiSeg] [varchar](15) NULL,
	[HoraSaiTer] [varchar](15) NULL,
	[HoraSaiQua] [varchar](15) NULL,
	[HoraSaiQui] [varchar](15) NULL,
	[HoraSaiSex] [varchar](15) NULL,
	[HoraSaiSab] [varchar](15) NULL,
	[HoraSaiDom] [varchar](15) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemAC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_AUTOR_LIVROS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_AUTOR_LIVROS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdAutor] [int] NOT NULL,
	[IdLivro] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_CANCELAMENTO_VISITAS_EXTERNA_ROL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_CANCELAMENTO_VISITAS_EXTERNA_ROL](
	[IdItemCanExt] [int] IDENTITY(1,1) NOT NULL,
	[DataRolCan] [datetime] NULL,
	[IdCan] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdVisita] [int] NOT NULL,
	[DataBloqueio] [datetime] NULL,
	[StatusVisita] [varchar](10) NULL,
	[Motivo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemCanExt] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_CANCELAMENTO_VISITAS_INTERNA_ROL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_CANCELAMENTO_VISITAS_INTERNA_ROL](
	[IdItemCanInt] [int] IDENTITY(1,1) NOT NULL,
	[DataRolCan] [datetime] NULL,
	[IdCan] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataBloqueio] [datetime] NULL,
	[StatusVisita] [varchar](10) NULL,
	[Motivo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemCanInt] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_CAPACITACAO_INTERNO_TO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_CAPACITACAO_INTERNO_TO](
	[IdItemCap] [int] IDENTITY(1,1) NOT NULL,
	[DataInicio] [datetime] NULL,
	[DataConclusao] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdCap] [int] NOT NULL,
	[SituacaoCurso] [varchar](80) NULL,
	[CargaHoraria] [varchar](20) NULL,
	[NotaAvalia] [real] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_CARTILHA_VACINAS_INTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_CARTILHA_VACINAS_INTERNOS](
	[IdItemCart] [int] IDENTITY(1,1) NOT NULL,
	[IdCart] [int] NOT NULL,
	[IdVacina] [int] NOT NULL,
	[Data1Dose] [datetime] NULL,
	[Data2Dose] [datetime] NULL,
	[Data3Dose] [datetime] NULL,
	[DataReforco] [datetime] NULL,
	[Lote1Dose] [varchar](50) NULL,
	[Lote2Dose] [varchar](50) NULL,
	[Lote3Dose] [varchar](50) NULL,
	[LoteReforco] [varchar](50) NULL,
	[DataValidade1] [datetime] NULL,
	[DataValidade2] [datetime] NULL,
	[DataValidade3] [datetime] NULL,
	[DataValidadeRef] [datetime] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemCart] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_COMPRA_ACERVO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_COMPRA_ACERVO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdCompra] [int] NOT NULL,
	[TipoCompra] [int] NULL,
	[TipoOperacao] [int] NULL,
	[IdLivro] [int] NOT NULL,
	[QtdItem] [float] NULL,
	[ValorUnit] [float] NULL,
	[ValorTotal] [float] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_COMPRAS_MATERIAIS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_COMPRAS_MATERIAIS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdPedido] [int] NULL,
	[IdNfEntrada] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[Lote] [varchar](50) NULL,
	[QtdItem] [float] NOT NULL,
	[ValorUN] [money] NOT NULL,
	[AliquotaICMS] [float] NULL,
	[AliquotaIPI] [float] NULL,
	[DataVctoLote] [date] NULL,
	[ValorTotalItem] [money] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_COMPRAS_MATERIAIS_FAR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_COMPRAS_MATERIAIS_FAR](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdPedido] [int] NULL,
	[IdNfEntrada] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[Lote] [varchar](50) NULL,
	[QtdItem] [float] NOT NULL,
	[ValorUN] [money] NOT NULL,
	[AliquotaICMS] [float] NULL,
	[AliquotaIPI] [float] NULL,
	[DataVctoLote] [date] NULL,
	[ValorTotalItem] [money] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_COMPRAS_MATERIAIS_NUTRI]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_COMPRAS_MATERIAIS_NUTRI](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdPedido] [int] NULL,
	[IdNfEntrada] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[Lote] [varchar](50) NULL,
	[QtdItem] [decimal](18, 3) NULL,
	[ValorUN] [money] NOT NULL,
	[AliquotaICMS] [float] NULL,
	[AliquotaIPI] [float] NULL,
	[DataVctoLote] [date] NULL,
	[ValorTotalItem] [money] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_CURSOS_LISTAESPERA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_CURSOS_LISTAESPERA](
	[IdItemCursos] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdCurso] [int] NOT NULL,
	[Encaminhamento] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemCursos] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdCurso] [int] NOT NULL,
	[IdHistoricoEdu] [int] NOT NULL,
	[PrioridadeCurso] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO](
	[IdItemICTHEN] [int] IDENTITY(1,1) NOT NULL,
	[IdATN] [int] NOT NULL,
	[IdCurso] [int] NOT NULL,
	[IdHistoricoEduN] [int] NOT NULL,
	[PrioridadeCurso] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemICTHEN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ITENS_DEVOLUCAO_ACERVO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_DEVOLUCAO_ACERVO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[TipoOperacao] [int] NULL,
	[IdDevolucao] [int] NOT NULL,
	[IdLivro] [int] NOT NULL,
	[QtdItem] [int] NULL,
	[QtdEmprestada] [float] NULL,
	[SaldoEstoque] [float] NULL,
	[UtilizaEmprestimo] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdDevo] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [float] NULL,
	[ValorUnitarioItem] [money] NULL,
	[ValorTotalItem] [money] NULL,
	[ReqAtend] [varchar](3) NULL,
	[EstornoProduto] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_EMPRESTIMO_ACERVO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_EMPRESTIMO_ACERVO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[TipoOperacao] [int] NULL,
	[IdEmprestimo] [int] NOT NULL,
	[IdLivro] [int] NOT NULL,
	[QtdItem] [int] NULL,
	[QtdReserva] [float] NULL,
	[SaldoEstoque] [float] NULL,
	[UtilizaReserva] [varchar](3) NULL,
	[UtilizadoDevolucao] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_ENCAMINHAMENTO_CIRURGIAS_ESPECIALISTAS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_ENCAMINHAMENTO_CIRURGIAS_ESPECIALISTAS](
	[IdItemEnca] [int] IDENTITY(1,1) NOT NULL,
	[IdEnca] [int] NOT NULL,
	[TipoEnca] [int] NULL,
	[DescricaoEncaminhamento] [varchar](200) NULL,
	[DataSaida] [datetime] NULL,
	[HoraSaida] [varchar](10) NULL,
	[DataRetorno] [datetime] NULL,
	[HoraRetorno] [varchar](10) NULL,
	[Motivo] [varchar](max) NULL,
	[Destino] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemEnca] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_ENTRADA_SAIDA_ALBERGADOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_ENTRADA_SAIDA_ALBERGADOS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[Evadido] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_ENTRADA_SAIDA_VISITAS_RELIGIOSA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_ENTRADA_SAIDA_VISITAS_RELIGIOSA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdEntSaiVisita] [int] NOT NULL,
	[IdCod] [int] NOT NULL,
	[IdVisitaRel] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_ENTRADAS_OFICIAL_JUSTICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_ENTRADAS_OFICIAL_JUSTICA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdOficial] [int] NOT NULL,
	[Idlanc] [int] NOT NULL,
	[IdDepartamento] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[Motivo] [varchar](80) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_ENTRADAS_OFICIAL_JUSTICA_INTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_ENTRADAS_OFICIAL_JUSTICA_INTERNOS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[Idlanc] [int] NOT NULL,
	[IdOficial] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_ESTORNO_PRODUTOS_AC]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_ESTORNO_PRODUTOS_AC](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdEst] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [float] NULL,
	[ValorUnitarioItem] [money] NULL,
	[ValorTotalItem] [money] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_ESTORNO_PRODUTOS_ENF]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_ESTORNO_PRODUTOS_ENF](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdEst] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [float] NULL,
	[ValorUnitarioItem] [float] NULL,
	[ValorTotalItem] [float] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_ESTORNO_PRODUTOS_FAR]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_ESTORNO_PRODUTOS_FAR](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdEst] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [float] NULL,
	[ValorUnitarioItem] [money] NULL,
	[ValorTotalItem] [money] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_ESTORNO_PRODUTOS_NUTRI]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_ESTORNO_PRODUTOS_NUTRI](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdEst] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [decimal](18, 3) NULL,
	[ValorUnitarioItem] [money] NULL,
	[ValorTotalItem] [money] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_EXPORTADO_LOCACAO_INTERNOS]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_EXPORTADO_LOCACAO_INTERNOS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[CodigoReg] [int] NOT NULL,
	[IdPav] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TipoPesq] [int] NULL,
	[ConfirmaBase] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA](
	[IdItemFAC] [int] IDENTITY(1,1) NOT NULL,
	[IdFAC] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HoraEntrada] [varchar](40) NULL,
	[HoraSaida] [varchar](40) NULL,
	[NotaAvalia] [varchar](40) NULL,
	[Frequencia] [varchar](40) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemFAC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO]    Script Date: 01/06/2020 08:40:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO](
	[IdItemFreqCap] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdFreqCap] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HoraEntrada] [varchar](20) NULL,
	[HoraSaida] [varchar](20) NULL,
	[NotaAvalia] [real] NULL,
	[Frequencia] [varchar](80) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemFreqCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_FREQUENCIA_LABORATIVA_EXTERNA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_FREQUENCIA_LABORATIVA_EXTERNA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdFreqLab] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TotalDias] [int] NULL,
	[MesReferencia] [varchar](20) NULL,
	[AnoReferencia] [varchar](4) NULL,
	[NrMes] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdFreqLab] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TotalDias] [int] NULL,
	[MesReferencia] [varchar](20) NULL,
	[AnoReferencia] [varchar](4) NULL,
	[NrMes] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_HISTORICO_DOENCA_FAMILIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_HISTORICO_DOENCA_FAMILIA](
	[ItensIdHist] [int] IDENTITY(1,1) NOT NULL,
	[IdHist] [int] NOT NULL,
	[IdDoenca] [int] NOT NULL,
	[GrauParentesco] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[ItensIdHist] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_INGREDIENTES_FICHA_TECNICA_CALCULADO_NUTRI]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_INGREDIENTES_FICHA_TECNICA_CALCULADO_NUTRI](
	[IdCalc] [int] IDENTITY(1,1) NOT NULL,
	[Item] [int] NOT NULL,
	[DataCalc] [datetime] NULL,
	[IdFicha] [int] NOT NULL,
	[StatusCalc] [varchar](70) NULL,
	[QtdPorcaoCalc] [decimal](18, 3) NOT NULL,
	[ItemCalc] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[Unidade] [varchar](50) NULL,
	[QtdPorcao] [decimal](18, 3) NOT NULL,
	[QtdTotal] [decimal](18, 3) NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCalc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO](
	[IdRegInternosKC] [int] IDENTITY(1,1) NOT NULL,
	[IdRegistroComp] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TipoKitCI] [int] NULL,
	[Agrupado] [varchar](3) NULL,
	[Gravado] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRegInternosKC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_INVENTARIO_AC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_INVENTARIO_AC](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[QtdItem] [float] NULL,
	[ValorCusto] [money] NULL,
	[Lote] [varchar](50) NULL,
	[DataLote] [date] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Modulo] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_INVENTARIO_ACERVO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_INVENTARIO_ACERVO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdLivro] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[Unidade] [varchar](10) NULL,
	[QtdItem] [float] NULL,
	[ValorCusto] [float] NULL,
	[Lote] [varchar](50) NULL,
	[DataLote] [date] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_INVENTARIO_FAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_INVENTARIO_FAR](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[QtdItem] [float] NULL,
	[ValorCusto] [money] NULL,
	[Lote] [varchar](50) NULL,
	[DataLote] [date] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Modulo] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_INVENTARIO_NUTRI]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_INVENTARIO_NUTRI](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[QtdItem] [decimal](18, 3) NULL,
	[ValorCusto] [money] NULL,
	[Lote] [varchar](50) NULL,
	[DataLote] [date] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_LIBERADOR_ESCOLTA_INTERNO_PSP]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_LIBERADOR_ESCOLTA_INTERNO_PSP](
	[IdItemLibPSP] [int] IDENTITY(1,1) NOT NULL,
	[IdLibe] [int] NOT NULL,
	[IdFunc] [int] NOT NULL,
	[StatusFunc] [varchar](30) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemLibPSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_LISTA_PASSAGEM_ALBERGADOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_LISTA_PASSAGEM_ALBERGADOS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdAgenda] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[StatusInterno] [varchar](20) NULL,
	[SituacaoInterno] [varchar](20) NULL,
	[ObservacaoInterno] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_LISTA_ROL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_LISTA_ROL](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdRol] [int] NOT NULL,
	[StatusInterna] [varchar](10) NULL,
	[DataValidade] [date] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[GrauParentesco] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_OCUPACAO_LISTAESPERA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_OCUPACAO_LISTAESPERA](
	[IdItemOcupa] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdCodigoOcupa] [int] NOT NULL,
	[Encaminhamento] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemOcupa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_ODONTOGRAMA_ADMISSAO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_ODONTOGRAMA_ADMISSAO](
	[IdOdonto] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdProcOdonto] [int] NOT NULL,
	[DataOdontograma] [datetime] NULL,
	[NumeroDente] [int] NULL,
	[NrFace] [int] NULL,
	[FacesDente] [varchar](60) NULL,
	[ParcialTotal] [varchar](60) NULL,
	[PlanoTratamento] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdOdonto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_PAGAMENTO_KIT_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_PAGAMENTO_KIT_INTERNOS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdPagto] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Copo] [int] NULL,
	[Prato] [int] NULL,
	[Colher] [int] NULL,
	[Vasilha] [int] NULL,
	[Garfo] [int] NULL,
	[Absorvente] [int] NULL,
	[Bermuda] [int] NULL,
	[Colchas] [int] NULL,
	[Colchao] [int] NULL,
	[Toalha] [int] NULL,
	[Camisa] [int] NULL,
	[Cueca] [int] NULL,
	[Sandalia] [int] NULL,
	[CremeDental] [int] NULL,
	[Sabonete] [int] NULL,
	[PapelHigienico] [int] NULL,
	[Barbeador] [int] NULL,
	[EscovaDente] [int] NULL,
	[MostraTodos] [int] NULL,
	[KitInicial] [int] NULL,
	[KitQuinzenal] [int] NULL,
	[TipoEntrada] [int] NULL,
	[DataEntrega] [datetime] NULL,
	[Horario] [varchar](20) NULL,
	[AssinaturaDigital] [varbinary](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Cobertor] [int] NULL,
	[BolaFutSal] [int] NULL,
	[CalcaoJg] [int] NULL,
	[CamisaJg] [int] NULL,
	[ParMeiao] [int] NULL,
	[SabaoPo] [int] NULL,
	[Desodorante] [int] NULL,
	[KitDecimal] [int] NULL,
	[KitSemestral] [int] NULL,
	[KitMensal] [int] NULL,
	[Personalizado] [int] NULL,
	[KitPersonalizado] [int] NULL,
	[KitAnual] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS](
	[IdItemProd] [int] IDENTITY(1,1) NOT NULL,
	[IdPagto] [int] NOT NULL,
	[IdItem] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[QuantProd] [float] NULL,
	[DataEntrega] [datetime] NULL,
	[Horario] [varchar](20) NULL,
	[AssinaturaDigitalInterno] [varbinary](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
	[IdInternoCrc] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemProd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_PAGAMENTO_REFEICAO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_PAGAMENTO_REFEICAO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdRef] [int] NOT NULL,
	[TipoRefeicao] [varchar](60) NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DiaSemana] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_PERNOITE_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_PERNOITE_INTERNOS](
	[IdItemPer] [int] IDENTITY(1,1) NOT NULL,
	[IdPer] [int] NOT NULL,
	[NomeInterno] [varchar](300) NULL,
	[NomeMae] [varchar](300) NULL,
	[NomePai] [varchar](300) NULL,
	[DataEntrada] [datetime] NULL,
	[HoraEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HoraSaida] [varchar](20) NULL,
	[ImagemInterno] [varbinary](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[TipoOperacaoEntrada] [varchar](50) NULL,
	[TipoOperacaoSaida] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemPer] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_PRE_LOCACAO_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_PRE_LOCACAO_INTERNOS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[CodigoReg] [int] NOT NULL,
	[IdPav] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdEntrada] [int] NOT NULL,
	[TipoPesq] [int] NULL,
	[Confirmacao] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO](
	[IdRegProdutosKC] [int] IDENTITY(1,1) NOT NULL,
	[IdRegistroComp] [int] NOT NULL,
	[IdKit] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[QuantProd] [float] NOT NULL,
	[Agrupado] [varchar](3) NULL,
	[TipoKitCI] [int] NULL,
	[Gravado] [int] NULL,
	[Liberado] [varchar](3) NULL,
	[Pago] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRegProdutosKC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE](
	[IdRegProdKit] [int] IDENTITY(1,1) NOT NULL,
	[IdRegistroComp] [int] NOT NULL,
	[IdKit] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[QuantProd] [int] NULL,
	[Utili] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRegProdKit] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdCodigoProf] [int] NOT NULL,
	[IdHistoricoLab] [int] NOT NULL,
	[InteresseLabor] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO](
	[IdItemPTHPN] [int] IDENTITY(1,1) NOT NULL,
	[IdATN] [int] NOT NULL,
	[IdCodigoProf] [int] NOT NULL,
	[IdHistoricoLabPN] [int] NOT NULL,
	[InteresseLabor] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemPTHPN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdProrroga] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdSaida] [int] NULL,
	[DataSaida] [datetime] NULL,
	[DataPrevisaoRetorno] [datetime] NULL,
	[DataNova] [datetime] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
	[IdSaidaTmp] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_REGISTRO_CANCELADO_NE]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_REGISTRO_CANCELADO_NE](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdRegCancel] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataSaida] [datetime] NULL,
	[HoraSaida] [varchar](10) NULL,
	[ConfirmacaoRegistro] [varchar](3) NULL,
	[NrDocumento] [varchar](30) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_REGISTRO_CANCELADO_RETORNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_REGISTRO_CANCELADO_RETORNOS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdRegCancel] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataSaida] [datetime] NULL,
	[HoraSaida] [varchar](10) NULL,
	[ConfirmacaoRegistro] [varchar](3) NULL,
	[NrDocumento] [varchar](30) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdReq] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [float] NULL,
	[ValorUnitarioItem] [money] NULL,
	[ValorTotalItem] [money] NULL,
	[EstornoProduto] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS_ENF]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS_ENF](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdReq] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [float] NULL,
	[QtdDosesAT] [int] NULL,
	[ValorUnitarioItem] [money] NULL,
	[ValorTotalItem] [money] NULL,
	[EstornoProduto] [varchar](3) NULL,
	[TipoReq] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS_FAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS_FAR](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdReq] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [float] NULL,
	[ValorUnitarioItem] [money] NULL,
	[ValorTotalItem] [money] NULL,
	[EstornoProduto] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS_NUTRI]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS_NUTRI](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdReq] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [decimal](18, 3) NULL,
	[ValorUnitarioItem] [money] NULL,
	[ValorTotalItem] [money] NULL,
	[EstornoProduto] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_REQUISICAO_PRODUTOS_CARDAPIO_NUTRI]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_CARDAPIO_NUTRI](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdReq] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [decimal](18, 3) NULL,
	[ValorUnitarioItem] [money] NULL,
	[ValorTotalItem] [money] NULL,
	[EstornoProduto] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_REQUISICAO_PRODUTOS_ENFERMARIA_ENFAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_ENFERMARIA_ENFAR](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdSol] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [float] NULL,
	[ValorUnitarioItem] [money] NULL,
	[ValorTotalItem] [money] NULL,
	[ReqAtend] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_REQUISICAO_PRODUTOS_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_INTERNOS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdReq] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [float] NULL,
	[ValorUnitarioItem] [money] NULL,
	[ValorTotalItem] [money] NULL,
	[EstornoProduto] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdReq] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [float] NULL,
	[QtdDosesAT] [int] NULL,
	[EstornoProduto] [varchar](3) NULL,
	[ValorUnitarioItem] [float] NULL,
	[ValorTotalItem] [float] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_REQUISICAO_PRODUTOS_INTERNOS_SEAC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_INTERNOS_SEAC](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdReq] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [float] NULL,
	[ValorUnitarioItem] [float] NULL,
	[ValorTotalItem] [float] NULL,
	[ReqAtend] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_REQUISICAO_PRODUTOS_NUTRI]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_NUTRI](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdReq] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [decimal](18, 3) NULL,
	[ValorUnitarioItem] [money] NULL,
	[ValorTotalItem] [money] NULL,
	[EstornoProduto] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_RESERVA_ACERVO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_RESERVA_ACERVO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[TipoOperacao] [int] NULL,
	[IdReserva] [int] NOT NULL,
	[IdLivro] [int] NOT NULL,
	[QtdItem] [int] NULL,
	[SaldoEstoque] [float] NULL,
	[UtilizaReserva] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_ROL_VISITAS_RELIGIOSA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_ROL_VISITAS_RELIGIOSA](
	[IdItemRol] [int] IDENTITY(1,1) NOT NULL,
	[DataRol] [datetime] NULL,
	[IdRol] [int] NOT NULL,
	[IdCod] [int] NOT NULL,
	[StatusVisita] [varchar](10) NULL,
	[IdVisitaRel] [int] NOT NULL,
	[DataInicio] [datetime] NULL,
	[Domingo] [int] NULL,
	[Segunda] [int] NULL,
	[Terca] [int] NULL,
	[Quarta] [int] NULL,
	[Quinta] [int] NULL,
	[Sexta] [int] NULL,
	[Sabado] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemRol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_SOLICITACAO_COMPRAS_ADM]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_SOLICITACAO_COMPRAS_ADM](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdSol] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[QtdItem] [float] NULL,
	[ValorUnitarioItem] [money] NULL,
	[ValorTotalItem] [money] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO](
	[IdItemExame] [int] IDENTITY(1,1) NOT NULL,
	[IdSolExame] [int] NOT NULL,
	[IdExame] [int] NOT NULL,
	[PrimeiraAmostra] [varchar](200) NULL,
	[SegundaAmostra] [varchar](200) NULL,
	[TerceiraAmostra] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[ExameReal] [varchar](30) NULL,
	[MotivoExame] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemExame] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_SOLICITACAO_PRODUTOS_ADM]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_SOLICITACAO_PRODUTOS_ADM](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdSol] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[StatusAprovacao] [varchar](30) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[QtdItem] [float] NULL,
	[ValorUnitarioItem] [money] NULL,
	[ValorTotalItem] [money] NULL,
	[AprovaSol] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_SOLICITANTES_COMPRAS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_SOLICITANTES_COMPRAS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdSeq] [int] NULL,
	[IdSoli] [int] NOT NULL,
	[IdFunc] [int] NOT NULL,
	[ValorMax] [money] NULL,
	[DataInicial] [datetime] NULL,
	[DataFinal] [datetime] NULL,
	[ValorVTA] [money] NULL,
	[ValorGAC] [money] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_TRANSFERENCIA_PRODUTO_FAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_TRANSFERENCIA_PRODUTO_FAR](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[CodigoBarras] [varchar](13) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[Lote] [varchar](50) NULL,
	[QtdItem] [float] NULL,
	[ValorUN] [money] NULL,
	[ValorTotal] [money] NULL,
	[EstornoProduto] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[IdItemLote] [int] NULL,
	[DataVencLote] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_TRANSIENTES_VISITAS_DIVERSAS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_TRANSIENTES_VISITAS_DIVERSAS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdTrans] [int] NOT NULL,
	[IdCodigo] [int] NULL,
	[TipoTrans] [int] NULL,
	[Destino] [varchar](200) NULL,
	[Motivo] [varchar](200) NULL,
	[DataEntrada] [datetime] NULL,
	[HoraEntrada] [varchar](10) NULL,
	[DataSaida] [datetime] NULL,
	[HoraSaida] [varchar](10) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[AssinaturaEntrada] [varbinary](max) NULL,
	[AssinaturaSaida] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_TRATAMENTOS_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_TRATAMENTOS_INTERNOS](
	[IdItemTrat] [int] IDENTITY(1,1) NOT NULL,
	[IdAvalia] [int] NOT NULL,
	[IdDoenca] [int] NOT NULL,
	[IdTipo] [int] NOT NULL,
	[Tratamento] [varchar](3) NULL,
	[Notificacao] [varchar](3) NULL,
	[Outros] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemTrat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_VISITA_INTERNA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_VISITA_INTERNA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdRol] [varchar](10) NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENS_VISITA_INTERNO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENS_VISITA_INTERNO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdRol] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSADMISSAODOENCAS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ITENSADMISSAODOENCAS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataLanc] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdDoenca] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ITENSADVOGADO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSADVOGADO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdAdvogado] [int] NOT NULL,
	[Idlanc] [int] NOT NULL,
	[IdDepartamento] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Motivo] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSADVOGADOINTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSADVOGADOINTERNOS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[Idlanc] [int] NOT NULL,
	[IdAdvogado] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSAGENDA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSAGENDA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdAgenda] [int] NOT NULL,
	[DataAgenda] [datetime] NULL,
	[HorarioAgenda] [varchar](20) NULL,
	[LocalAgenda] [varchar](200) NULL,
	[OficioAgenda] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[UtilizaAgenda] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSAGENDALABORATIVA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSAGENDALABORATIVA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdAgenda] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdEmp] [int] NOT NULL,
	[StatusInterno] [varchar](20) NULL,
	[ObservacaoInterno] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[TipoEmpresa] [varchar](10) NULL,
	[DiaSeg] [int] NULL,
	[DiaTer] [int] NULL,
	[DiaQua] [int] NULL,
	[DiaQui] [int] NULL,
	[DiaSex] [int] NULL,
	[DiaSab] [int] NULL,
	[DiaDom] [int] NULL,
	[HoraSeg] [varchar](5) NULL,
	[HoraTer] [varchar](5) NULL,
	[HoraQua] [varchar](5) NULL,
	[HoraQui] [varchar](5) NULL,
	[HoraSex] [varchar](5) NULL,
	[HoraSab] [varchar](5) NULL,
	[HoraDom] [varchar](5) NULL,
	[HoraSegEnt] [varchar](5) NULL,
	[HoraTerEnt] [varchar](5) NULL,
	[HoraQuaEnt] [varchar](5) NULL,
	[HoraQuiEnt] [varchar](5) NULL,
	[HoraSexEnt] [varchar](5) NULL,
	[HoraSabEnt] [varchar](5) NULL,
	[HoraDomEnt] [varchar](5) NULL,
	[Pulseira] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSATENDIMENTOJURI]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSATENDIMENTOJURI](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataItem] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdAtiv] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[QtdAtiv] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSBAIXAINTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSBAIXAINTERNOS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Motivo] [varchar](300) NULL,
	[Bloqueado] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSCRCPORTARIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSCRCPORTARIA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdSaida] [int] NULL,
	[IdItemSaida] [int] NULL,
	[DataSaida] [datetime] NULL,
	[DestinoSaida] [varchar](250) NULL,
	[DocumentoSaida] [varchar](80) NULL,
	[SaidaConfirmada] [varchar](5) NULL,
	[DataRetorno] [datetime] NULL,
	[Evadido] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSDEPOSITOPORTARIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSDEPOSITOPORTARIA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[Idlanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[ValorDeposito] [float] NULL,
	[DataDeposito] [datetime] NULL,
	[Efetuado] [varchar](5) NULL,
	[OrigemDeposito] [varchar](1) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSENTRADA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSENTRADA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdEntrada] [int] NOT NULL,
	[IdUnid] [int] NOT NULL,
	[QtdEntrada] [int] NULL,
	[DataEntrada] [datetime] NULL,
	[DataCrime] [datetime] NULL,
	[DataPrisao] [datetime] NULL,
	[DataCondenacao] [datetime] NULL,
	[Regime] [varchar](20) NULL,
	[Pena] [varchar](20) NULL,
	[Artigo1] [varchar](20) NULL,
	[Artigo2] [varchar](20) NULL,
	[Artigo3] [varchar](20) NULL,
	[Paragrafo1] [varchar](20) NULL,
	[Paragrafo2] [varchar](20) NULL,
	[Paragrafo3] [varchar](20) NULL,
	[TerminoPena] [datetime] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[ConfirmaUtil] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSENTRADAPORTARIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSENTRADAPORTARIA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HoraEntrada] [varchar](10) NULL,
	[OficioInternos] [varchar](30) NULL,
	[NomeInternoCrc] [varchar](200) NULL,
	[OrigemInterno] [varchar](300) NULL,
	[ConfirmaEntrada] [varchar](5) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[RegistroCancelado] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSENTRADASFUNC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSENTRADASFUNC](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdFunc] [int] NOT NULL,
	[Idlanc] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[AssinaturaEntrada] [varbinary](max) NULL,
	[AssinaturaSaida] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSFAMILIAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSFAMILIAR](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdVisita] [int] NOT NULL,
	[Idlanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdRol] [varchar](10) NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[TipoEntrada] [varchar](3) NULL,
	[TipoOperacao] [varchar](13) NULL,
	[AssinaturaEntrada] [varbinary](max) NULL,
	[AssinaturaSaida] [varbinary](max) NULL,
	[Quantidade] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSFICHALAB]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSFICHALAB](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataInicio] [datetime] NULL,
	[DataTermino] [datetime] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSFREQUENCIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSFREQUENCIA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdFreq] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[QtdFrequencia] [real] NULL,
	[DataEntrada] [datetime] NULL,
	[DataSaida] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[HorarioSaida] [varchar](20) NULL,
	[Presenca] [varchar](10) NULL,
	[Utilizado] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSLABORINTERNO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSLABORINTERNO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[Evadido] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Obito] [varchar](60) NULL,
	[AssinaturaSaida] [varbinary](max) NULL,
	[AssinaturaEntrada] [varbinary](max) NULL,
	[Tornozeleira] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSLISTAESPERA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSLISTAESPERA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdCela] [int] NOT NULL,
	[Encaminhar] [varchar](30) NULL,
	[ProfissaoInterno] [varchar](200) NULL,
	[ObsInt] [varchar](350) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSLOCACAOINTERNO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSLOCACAOINTERNO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLoca] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdCela] [int] NOT NULL,
	[QtdLanc] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSMATRICULA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSMATRICULA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdMat] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Bloqueio] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[StatusAluno] [varchar](30) NULL,
	[SituacaoAluno] [varchar](30) NULL,
	[DataConDes] [datetime] NULL,
	[Observacao] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSNOVAENTRADA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSNOVAENTRADA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdEntrada] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[NrOficio] [varchar](100) NULL,
	[DataEntrada] [datetime] NULL,
	[UtilizadoCrc] [varchar](3) NULL,
	[OrigemInterno] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[RegistroCancelado] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSOBJETOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSOBJETOS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdEntrada] [int] NOT NULL,
	[IdPertence] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[Quant] [float] NULL,
	[DataEntrada] [date] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSOBJETOSPROCEDIMENTO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSOBJETOSPROCEDIMENTO](
	[IdObjPro] [int] IDENTITY(1,1) NOT NULL,
	[IdProc] [int] NOT NULL,
	[IdCela] [int] NOT NULL,
	[IdObjeto] [int] NOT NULL,
	[Unid] [varchar](15) NULL,
	[Qtde] [float] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdObjPro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSOBJETOSSAIDA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSOBJETOSSAIDA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdSaida] [int] NOT NULL,
	[IdPertence] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[Quant] [float] NULL,
	[DataSaida] [date] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSPCIP]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSPCIP](
	[IdItensPcip] [int] IDENTITY(1,1) NOT NULL,
	[DataProc] [datetime] NULL,
	[IdProc] [int] NOT NULL,
	[IdPav] [int] NOT NULL,
	[IdCela] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Quantidade] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItensPcip] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSPERTENCES]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSPERTENCES](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[Idlanc] [int] NOT NULL,
	[IdPertence] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdVisita] [int] NOT NULL,
	[UndPertence] [varchar](10) NULL,
	[QtdPertence] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSPREVISAOSAIDA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSPREVISAOSAIDA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataPrevSaida] [datetime] NULL,
	[Beneficio] [varchar](200) NULL,
	[ConfirmaSaida] [varchar](3) NULL,
	[UtilizadoSaida] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSPROGRESSAOREGIME]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSPROGRESSAOREGIME](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataProgressao] [date] NULL,
	[NovoRegimePro] [varchar](20) NULL,
	[NovoTerminoPenaPro] [date] NULL,
	[Juizo] [varchar](400) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSRECAPTURA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSRECAPTURA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdRecaptura] [int] NOT NULL,
	[DataRetorno] [datetime] NULL,
	[OrigemRetorno] [varchar](250) NULL,
	[DocumentoRetorno] [varchar](80) NULL,
	[IdRegistro] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSREGISTRO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSREGISTRO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdRetorno] [int] NOT NULL,
	[DataRetorno] [datetime] NULL,
	[OrigemRetorno] [varchar](250) NULL,
	[DocumentoRetorno] [varchar](80) NULL,
	[HorarioRetorno] [varchar](20) NULL,
	[ConfirmacaoRetorno] [varchar](5) NULL,
	[QtdSaida] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[AssinaturaEntrada] [varbinary](max) NULL,
	[RegistroCancelado] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSREGISTROCANCELADO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSREGISTROCANCELADO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[DataSaida] [datetime] NULL,
	[NomeInternoCrc] [varchar](200) NULL,
	[HoraSaida] [varchar](10) NULL,
	[ConfirmacaoRegistro] [varchar](3) NULL,
	[NrDocumento] [varchar](30) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSREGRESSAOREGIME]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSREGRESSAOREGIME](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataRegressao] [date] NULL,
	[NovoRegimeReg] [varchar](20) NULL,
	[NovaDataCondenacao] [date] NULL,
	[NovaPena] [varchar](20) NULL,
	[NovoTerminoPenaReg] [date] NULL,
	[NovoCrimeHediondo] [varchar](3) NULL,
	[Juizo] [varchar](400) NULL,
	[NovoArtigo1] [varchar](12) NULL,
	[NovoArtigo2] [varchar](12) NULL,
	[NovoArtigo3] [varchar](12) NULL,
	[NovoParagrafo1] [varchar](16) NULL,
	[NovoParagrafo2] [varchar](16) NULL,
	[NovoParagrafo3] [varchar](16) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSREGSAIDA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSREGSAIDA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdSaida] [int] NOT NULL,
	[IdItemCrcPort] [int] NULL,
	[DataSaida] [datetime] NULL,
	[DestinoSaida] [varchar](250) NULL,
	[DocumentoSaida] [varchar](80) NULL,
	[ConfirmaSaida] [varchar](5) NULL,
	[IdSaidaTmp] [varchar](5) NULL,
	[HoraSaida] [varchar](10) NULL,
	[QtdSaida] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[AssinaturaSaida] [varbinary](max) NULL,
	[LocalSaida] [varchar](300) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSRETORNO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSRETORNO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdRetorno] [int] NOT NULL,
	[DataRetorno] [datetime] NULL,
	[OrigemRetorno] [varchar](250) NULL,
	[DocumentoRetorno] [varchar](80) NULL,
	[HorarioRetorno] [varchar](20) NULL,
	[QtdSaida] [int] NULL,
	[IdRegistro] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSRETORNOAUDIENCIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSRETORNOAUDIENCIA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdRetorno] [int] NOT NULL,
	[DataRetorno] [datetime] NULL,
	[OrigemRetorno] [varchar](250) NULL,
	[IdRegistro] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[HoraRetorno] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSRETORNOESPONTANEO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSRETORNOESPONTANEO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdRetorno] [int] NOT NULL,
	[DataRetorno] [datetime] NULL,
	[OrigemRetorno] [varchar](250) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSRETORNOMEDICO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSRETORNOMEDICO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdRetorno] [int] NOT NULL,
	[DataRetorno] [datetime] NULL,
	[OrigemRetorno] [varchar](250) NULL,
	[IdRegistro] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[HoraRetorno] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSRETORNOTRANSFERENCIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSRETORNOTRANSFERENCIA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdRetorno] [int] NOT NULL,
	[DataRetorno] [datetime] NULL,
	[OrigemRetorno] [varchar](400) NULL,
	[IdRegistro] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[IdUnid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSROL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSROL](
	[IdItemRol] [int] IDENTITY(1,1) NOT NULL,
	[DataRol] [datetime] NULL,
	[IdRol] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdVisita] [int] NOT NULL,
	[DataInicio] [datetime] NULL,
	[StatusVisita] [varchar](10) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemRol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSSAIDA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSSAIDA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdSaida] [int] NOT NULL,
	[DataSaida] [datetime] NULL,
	[DataRetorno] [datetime] NULL,
	[DestinoSaida] [varchar](250) NULL,
	[Evadido] [varchar](10) NULL,
	[DocumentoSaida] [varchar](80) NULL,
	[ConfirmaSaida] [varchar](5) NULL,
	[SaidaConfirmada] [varchar](5) NULL,
	[QtdSaida] [int] NULL,
	[ConfirmaEvasao] [varchar](10) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[HoraSaida] [varchar](10) NULL,
	[Obito] [varchar](60) NULL,
	[ConfirmaObito] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSTFDISCIPLINA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSTFDISCIPLINA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdTempo] [int] NOT NULL,
	[IdDisc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSTRANSFERENCIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSTRANSFERENCIA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdTransf] [int] NOT NULL,
	[idUnid] [int] NOT NULL,
	[DataTransf] [datetime] NULL,
	[DocumentoTransf] [varchar](80) NULL,
	[QtdTransf] [int] NULL,
	[SaidaConfirmada] [varchar](5) NULL,
	[ConfirmaSaida] [varchar](5) NULL,
	[Evadido] [varchar](30) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSVEICULOCARGA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSVEICULOCARGA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdVisita] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[OrigemEntrada] [varchar](200) NULL,
	[DestinoEntrada] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSVEICULOSTERCEIRO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSVEICULOSTERCEIRO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdVisita] [int] NOT NULL,
	[Idlanc] [int] NOT NULL,
	[IdVeiculo] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[OrigemEntrada] [varchar](100) NULL,
	[DestinoEntrada] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSVEICULOSUNIDADE]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSVEICULOSUNIDADE](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdFunc] [int] NOT NULL,
	[Idlanc] [int] NOT NULL,
	[IdVeiculo] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[KmInicial] [varchar](80) NULL,
	[KmFinal] [varchar](80) NULL,
	[DestinoEntrada] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ITENSVISITASDIVERSAS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ITENSVISITASDIVERSAS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdVisita] [int] NOT NULL,
	[Idlanc] [int] NOT NULL,
	[IdDepartamento] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[MotivoVisita] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[ImagemFrenteVI] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KITS_ANUAL_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KITS_ANUAL_INTERNOS](
	[IdKitAnual] [int] IDENTITY(1,1) NOT NULL,
	[IdRegistroComp] [int] NULL,
	[DataPagto] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[KitPago] [varchar](3) NULL,
	[Utilizado] [varchar](3) NULL,
	[ProximaData] [datetime] NULL,
	[DataPrevisaoPro] [datetime] NULL,
	[IDREG_PROG] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdKitAnual] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KITS_DECENDIAL_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KITS_DECENDIAL_INTERNOS](
	[IdKitDecendial] [int] IDENTITY(1,1) NOT NULL,
	[IdRegistroComp] [int] NULL,
	[DataPagto] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[KitPago] [varchar](3) NULL,
	[Utilizado] [varchar](3) NULL,
	[ProximaData] [datetime] NULL,
	[DataPrevisaoPro] [datetime] NULL,
	[PrimeiroDecendial] [varchar](3) NULL,
	[IDREG_PROG] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdKitDecendial] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KITS_HIGIENE_INTERNO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KITS_HIGIENE_INTERNO](
	[IdKit] [int] IDENTITY(1,1) NOT NULL,
	[StatusKit] [varchar](20) NULL,
	[DataKit] [datetime] NULL,
	[KitInicial] [int] NULL,
	[KitDecendial] [int] NULL,
	[KitQuinzenal] [int] NULL,
	[KitSemestral] [int] NULL,
	[KitMensal] [int] NULL,
	[KitAnual] [int] NULL,
	[ObservacaoKit] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdKit] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KITS_INICIAL_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KITS_INICIAL_INTERNOS](
	[IdKitInicial] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataChegada] [datetime] NULL,
	[DataPrevisaoPro] [datetime] NULL,
	[DataPagto] [datetime] NULL,
	[KitPago] [varchar](3) NULL,
	[Utilizado] [varchar](3) NULL,
	[IDREG_PROG] [int] NULL,
	[OBSERVACAO] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdKitInicial] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KITS_MENSAL_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KITS_MENSAL_INTERNOS](
	[IdKitMensal] [int] IDENTITY(1,1) NOT NULL,
	[IdRegistroComp] [int] NULL,
	[DataPagto] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[KitPago] [varchar](3) NULL,
	[Utilizado] [varchar](3) NULL,
	[ProximaData] [datetime] NULL,
	[DataPrevisaoPro] [datetime] NULL,
	[IDREG_PROG] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdKitMensal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KITS_QUINZENAL_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KITS_QUINZENAL_INTERNOS](
	[IdKitQuinzenal] [int] IDENTITY(1,1) NOT NULL,
	[IdRegistroComp] [int] NULL,
	[DataPagto] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[KitPago] [varchar](3) NULL,
	[Utilizado] [varchar](3) NULL,
	[DataPrevisaoPro] [datetime] NULL,
	[DataPrevisao] [datetime] NULL,
	[IDREG_PROG] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdKitQuinzenal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KITS_SEMESTRAL_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KITS_SEMESTRAL_INTERNOS](
	[IdKitSemestral] [int] IDENTITY(1,1) NOT NULL,
	[IdRegistroComp] [int] NULL,
	[DataPagto] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[KitPago] [varchar](3) NULL,
	[Utilizado] [varchar](3) NULL,
	[ProximaData] [datetime] NULL,
	[DataPrevisaoPro] [datetime] NULL,
	[IDREG_PROG] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdKitSemestral] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[L1A_ORGANOGRAMA_CRIME]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[L1A_ORGANOGRAMA_CRIME](
	[IdL1A] [int] IDENTITY(1,1) NOT NULL,
	[IdOrg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[CartaBaralho] [varbinary](max) NULL,
	[Observacao] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdL1A] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[L1B_ORGANOGRAMA_CRIME]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[L1B_ORGANOGRAMA_CRIME](
	[IdL1B] [int] IDENTITY(1,1) NOT NULL,
	[IdOrg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[CartaBaralho] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdL1B] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[L1C_ORGANOGRAMA_CRIME]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[L1C_ORGANOGRAMA_CRIME](
	[IdL1C] [int] IDENTITY(1,1) NOT NULL,
	[IdOrg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[CartaBaralho] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdL1C] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[L1D_ORGANOGRAMA_CRIME]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[L1D_ORGANOGRAMA_CRIME](
	[IdL1D] [int] IDENTITY(1,1) NOT NULL,
	[IdOrg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[CartaBaralho] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdL1D] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[L2A_ORGANOGRAMA_CRIME]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[L2A_ORGANOGRAMA_CRIME](
	[IdL2A] [int] IDENTITY(1,1) NOT NULL,
	[IdOrg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[CartaBaralho] [varbinary](max) NULL,
	[Observacao] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdL2A] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[L2B_ORGANOGRAMA_CRIME]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[L2B_ORGANOGRAMA_CRIME](
	[IdL2B] [int] IDENTITY(1,1) NOT NULL,
	[IdOrg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[CartaBaralho] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdL2B] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[L2C_ORGANOGRAMA_CRIME]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[L2C_ORGANOGRAMA_CRIME](
	[IdL2C] [int] IDENTITY(1,1) NOT NULL,
	[IdOrg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[CartaBaralho] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdL2C] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[L2D_ORGANOGRAMA_CRIME]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[L2D_ORGANOGRAMA_CRIME](
	[IdL2D] [int] IDENTITY(1,1) NOT NULL,
	[IdOrg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[CartaBaralho] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdL2D] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LIBERADOR_ESCOLTA_INTERNO_PSP]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LIBERADOR_ESCOLTA_INTERNO_PSP](
	[IdLibe] [int] IDENTITY(1,1) NOT NULL,
	[StatusLibera] [varchar](30) NULL,
	[DataRegistro] [datetime] NULL,
	[IdPav] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLibe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LIBERADORES_BANCO_VIRTUAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LIBERADORES_BANCO_VIRTUAL](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdUsuario] [int] NOT NULL,
	[Tipo] [int] NULL,
	[DataValidade] [datetime] NULL,
	[ValorLiberado] [real] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LISTA_DOCUMENTOS_INTERNO_CRC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LISTA_DOCUMENTOS_INTERNO_CRC](
	[IdLista] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdChek] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLista] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LISTA_PASSAGEM_ALBERGADOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LISTA_PASSAGEM_ALBERGADOS](
	[IdAgenda] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](30) NULL,
	[DataCadastro] [datetime] NULL,
	[IdOp] [int] NOT NULL,
	[ObsLanc] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAgenda] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LISTAESPERA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LISTAESPERA](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[TipoListaEspera] [varchar](60) NULL,
	[Classificacao] [varchar](60) NULL,
	[ObsLanc] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LIVROS_REVISTAS_JORNAIS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LIVROS_REVISTAS_JORNAIS](
	[IdLivro] [int] IDENTITY(1,1) NOT NULL,
	[StatusLivro] [varchar](10) NULL,
	[TipoLivro] [varchar](10) NULL,
	[TituloLivro] [varchar](300) NULL,
	[IdForn] [int] NOT NULL,
	[CodigoBarra] [varchar](30) NULL,
	[PrazoEmp] [varchar](5) NULL,
	[Idioma] [varchar](150) NULL,
	[DataAquisicao] [date] NULL,
	[IdCat] [int] NOT NULL,
	[ISBN] [varchar](30) NULL,
	[Volume] [varchar](100) NULL,
	[Edicao] [varchar](100) NULL,
	[Paginas] [varchar](100) NULL,
	[IdLocal] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[Foto1] [varchar](300) NULL,
	[Foto2] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLivro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LOCACAOINTERNO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LOCACAOINTERNO](
	[IdLoca] [int] IDENTITY(1,1) NOT NULL,
	[StatusLoca] [varchar](30) NULL,
	[DataLanca] [datetime] NULL,
	[IdCela] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLoca] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LOCAL_ACERVO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LOCAL_ACERVO](
	[IdLocal] [int] IDENTITY(1,1) NOT NULL,
	[StatusLocal] [varchar](10) NULL,
	[DescricaoLocal] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LOCAL_ARMAZENAMENTO_AC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LOCAL_ARMAZENAMENTO_AC](
	[IdLocal] [int] IDENTITY(1,1) NOT NULL,
	[StatusLocal] [varchar](20) NULL,
	[DescricaoLocal] [varchar](200) NULL,
	[NivelLocal] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Modulo] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LOCALEVENTOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LOCALEVENTOS](
	[IdLocal] [int] IDENTITY(1,1) NOT NULL,
	[StatusLocal] [varchar](10) NULL,
	[DescricaoLocal] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LOCALINTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LOCALINTERNOS](
	[IdLocal] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdCela] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LOCALPERTENCES]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LOCALPERTENCES](
	[IdLocal] [int] IDENTITY(1,1) NOT NULL,
	[StatusLocal] [varchar](10) NULL,
	[DescricaoLocal] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LOGSISTEMA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LOGSISTEMA](
	[IdLog] [int] IDENTITY(1,1) NOT NULL,
	[DataMov] [varchar](10) NULL,
	[HorarioMov] [varchar](20) NULL,
	[NomeModuloTela] [varchar](300) NULL,
	[IdLancMov] [int] NULL,
	[NomeUsuarioLogado] [varchar](50) NULL,
	[StatusMov] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLog] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LOTE_PRODUTOS_AC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LOTE_PRODUTOS_AC](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdProd] [int] NOT NULL,
	[IdLanc] [int] NULL,
	[DataVenc] [date] NULL,
	[Lote] [varchar](200) NULL,
	[Qtd] [float] NULL,
	[DataEstoque] [date] NULL,
	[Modulo] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LOTE_PRODUTOS_ENF]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LOTE_PRODUTOS_ENF](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdProd] [int] NOT NULL,
	[IdLanc] [int] NULL,
	[DataVenc] [date] NULL,
	[Lote] [varchar](200) NULL,
	[Qtd] [float] NULL,
	[IdItemLote] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MATRICULAESCOLAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MATRICULAESCOLAR](
	[IdMat] [int] IDENTITY(1,1) NOT NULL,
	[StatusMat] [varchar](20) NULL,
	[DataMat] [date] NULL,
	[IdCod] [int] NOT NULL,
	[IdTempo] [int] NOT NULL,
	[IdCarga] [int] NOT NULL,
	[IdSala] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdMat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MODULOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MODULOS](
	[IdModulo] [int] IDENTITY(1,1) NOT NULL,
	[NomeModulo] [varchar](200) NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdModulo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MOTIVO_SAIDA_PRODUTOS_ENFAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MOTIVO_SAIDA_PRODUTOS_ENFAR](
	[IdMot] [int] IDENTITY(1,1) NOT NULL,
	[StatusMot] [varchar](20) NULL,
	[DataMot] [datetime] NULL,
	[TituloMotivo] [varchar](300) NULL,
	[Motivo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdMot] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MOTIVO_SAIDA_PRODUTOS_FAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MOTIVO_SAIDA_PRODUTOS_FAR](
	[IdMot] [int] IDENTITY(1,1) NOT NULL,
	[StatusMot] [varchar](20) NULL,
	[DataMot] [datetime] NULL,
	[TituloMotivo] [varchar](300) NULL,
	[Motivo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdMot] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MOVIMENTACAO_KITS_HIGIENE_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MOVIMENTACAO_KITS_HIGIENE_INTERNOS](
	[IdConKit] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[KitInicial] [varchar](3) NULL,
	[KitIPago] [varchar](3) NULL,
	[DataPagKitIn] [datetime] NULL,
	[KitDecendial] [varchar](3) NULL,
	[KitDPago] [varchar](3) NULL,
	[DataPagKitDe] [datetime] NULL,
	[KitQuinzenal] [varchar](3) NULL,
	[KitQPago] [varchar](3) NULL,
	[DataPagKitQu] [datetime] NULL,
	[KitMensal] [varchar](3) NULL,
	[KitMPago] [varchar](3) NULL,
	[DataPagKitMe] [datetime] NULL,
	[KitSemestral] [varchar](3) NULL,
	[KitSPago] [varchar](3) NULL,
	[DataPagKitSe] [datetime] NULL,
	[KitAnual] [varchar](3) NULL,
	[KitAPago] [varchar](3) NULL,
	[DataPagKitAn] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdConKit] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MOVIMENTOCRC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MOVIMENTOCRC](
	[IdMovCrc] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[StMov] [varchar](20) NULL,
	[IdDoc] [int] NULL,
	[DataMov] [datetime] NULL,
	[NomeOpe] [varchar](250) NULL,
	[OrigemDestino] [varchar](250) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdMovCrc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MOVISR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MOVISR](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdSaida] [int] NULL,
	[DataSaida] [datetime] NULL,
	[DataPrevRetorno] [datetime] NULL,
	[NrDocSaida] [varchar](30) NULL,
	[IdRetorno] [int] NULL,
	[DataRetorno] [datetime] NULL,
	[NrDocRetorno] [varchar](30) NULL,
	[ConfirmaEvasao] [varchar](5) NULL,
	[DataEvasao] [varchar](20) NULL,
	[IdItemRetorno] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MOVPOPULACAO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MOVPOPULACAO](
	[IdPopMov] [int] IDENTITY(1,1) NOT NULL,
	[DataPopMov] [datetime] NULL,
	[StatusPop] [varchar](30) NULL,
	[TotalGeralAgentes] [int] NULL,
	[TotalGeralInternos] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPopMov] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MOVTECNICO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MOVTECNICO](
	[IdMov] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[StatusAtend] [varchar](30) NULL,
	[IdAtend] [int] NULL,
	[DataMov] [datetime] NULL,
	[NomeOpe] [varchar](250) NULL,
	[DeptoMov] [varchar](250) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdMov] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NATUREZA_PRISAO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NATUREZA_PRISAO](
	[IdNatp] [int] IDENTITY(1,1) NOT NULL,
	[StatusNatp] [varchar](30) NULL,
	[DataNatp] [date] NULL,
	[DescricaoNatureza] [varchar](350) NOT NULL,
	[TextoNatureza] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdNatp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NATUREZAEVENTOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NATUREZAEVENTOS](
	[IdNatureza] [int] IDENTITY(1,1) NOT NULL,
	[StatusNatureza] [varchar](10) NULL,
	[DescricaoNatureza] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[TipoFalta] [varchar](80) NULL,
	[DescricaoDetalhadaFalta] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdNatureza] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NF_COMPRAS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NF_COMPRAS](
	[IdNfEntrada] [int] IDENTITY(1,1) NOT NULL,
	[Modelo] [varchar](10) NULL,
	[SerieNf] [varchar](20) NULL,
	[NumeroNf] [varchar](30) NULL,
	[StatusNf] [varchar](20) NULL,
	[IdLocal] [int] NULL,
	[IdForn] [int] NOT NULL,
	[DataEmissao] [date] NULL,
	[Tipodocumento] [varchar](20) NULL,
	[FormaPagamento] [varchar](30) NULL,
	[DataEntrada] [date] NULL,
	[BaseCalculoICMS] [money] NULL,
	[ValorICMS] [money] NULL,
	[BaseCalculoICMSSub] [money] NULL,
	[ValorICMSSub] [money] NULL,
	[ValorTotalProdutos] [money] NULL,
	[ValorTotalFrete] [money] NULL,
	[ValorTotalSeguro] [money] NULL,
	[ValorTotalDesconto] [money] NULL,
	[ValorTotalIPI] [money] NULL,
	[ValorTotalNFE] [money] NULL,
	[ObservacaoNF] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdNfEntrada] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NF_COMPRAS_FAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NF_COMPRAS_FAR](
	[IdNfEntrada] [int] IDENTITY(1,1) NOT NULL,
	[Modelo] [varchar](10) NULL,
	[SerieNf] [varchar](20) NULL,
	[NumeroNf] [varchar](30) NULL,
	[StatusNf] [varchar](20) NULL,
	[IdLocal] [int] NULL,
	[IdForn] [int] NOT NULL,
	[DataEmissao] [date] NULL,
	[Tipodocumento] [varchar](20) NULL,
	[FormaPagamento] [varchar](30) NULL,
	[DataEntrada] [date] NULL,
	[BaseCalculoICMS] [money] NULL,
	[ValorICMS] [money] NULL,
	[BaseCalculoICMSSub] [money] NULL,
	[ValorICMSSub] [money] NULL,
	[ValorTotalProdutos] [money] NULL,
	[ValorTotalFrete] [money] NULL,
	[ValorTotalSeguro] [money] NULL,
	[ValorTotalDesconto] [money] NULL,
	[ValorTotalIPI] [money] NULL,
	[ValorTotalNFE] [money] NULL,
	[ObservacaoNF] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdNfEntrada] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NF_COMPRAS_NUTRI]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NF_COMPRAS_NUTRI](
	[IdNfEntrada] [int] IDENTITY(1,1) NOT NULL,
	[Modelo] [varchar](10) NULL,
	[SerieNf] [varchar](20) NULL,
	[NumeroNf] [varchar](30) NULL,
	[StatusNf] [varchar](20) NULL,
	[IdLocal] [int] NULL,
	[IdForn] [int] NOT NULL,
	[DataEmissao] [date] NULL,
	[Tipodocumento] [varchar](20) NULL,
	[FormaPagamento] [varchar](30) NULL,
	[DataEntrada] [date] NULL,
	[BaseCalculoICMS] [money] NULL,
	[ValorICMS] [money] NULL,
	[BaseCalculoICMSSub] [money] NULL,
	[ValorICMSSub] [money] NULL,
	[ValorTotalProdutos] [money] NULL,
	[ValorTotalFrete] [money] NULL,
	[ValorTotalSeguro] [money] NULL,
	[ValorTotalDesconto] [money] NULL,
	[ValorTotalIPI] [money] NULL,
	[ValorTotalNFE] [money] NULL,
	[ObservacaoNF] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdNfEntrada] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NOMES_OBJETOS_PROCEDIMENTO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NOMES_OBJETOS_PROCEDIMENTO](
	[IdNome] [int] IDENTITY(1,1) NOT NULL,
	[NomeObjeto] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdNome] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OBITOS_INTERNOS_EXTERNO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OBITOS_INTERNOS_EXTERNO](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[TipoOp] [varchar](100) NULL,
	[NrDocSaida] [int] NULL,
	[TipoObito] [int] NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdSaida] [int] NULL,
	[DataSaida] [datetime] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OBJETOSPROCEDIMENTOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OBJETOSPROCEDIMENTOS](
	[IdObjeto] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](10) NULL,
	[DataLanc] [datetime] NULL,
	[DescricaoObjeto] [varchar](200) NULL,
	[FotoObjeto] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Modelo] [varchar](200) NULL,
	[Marca] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdObjeto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIA_AUTORES]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIA_AUTORES](
	[IdOcr] [int] IDENTITY(1,1) NOT NULL,
	[DataOcr] [date] NULL,
	[IdReg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Ocorrencia] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdOcr] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIA_INDISCIPLINA_PORTARIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIA_INDISCIPLINA_PORTARIA](
	[IdOcr] [int] IDENTITY(1,1) NOT NULL,
	[IdReg] [int] NOT NULL,
	[IdVisita] [int] NOT NULL,
	[TextoOcorrecia] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdOcr] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS](
	[IdOcr] [int] IDENTITY(1,1) NOT NULL,
	[IdReg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoOcorrencia] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdOcr] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIAS_BASE_SEGURANCA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIAS_BASE_SEGURANCA](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Titulo] [varchar](300) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Fonte] [varchar](200) NULL,
	[Tamanho] [varchar](3) NULL,
	[BtEsq] [int] NULL,
	[BtCen] [int] NULL,
	[BtDir] [int] NULL,
	[BtJus] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIAS_BASE_SEGURANCA_AUXILIAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIAS_BASE_SEGURANCA_AUXILIAR](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Titulo] [varchar](300) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Fonte] [varchar](200) NULL,
	[Tamanho] [varchar](3) NULL,
	[BtEsq] [int] NULL,
	[BtCen] [int] NULL,
	[BtDir] [int] NULL,
	[BtJus] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIAS_EF]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIAS_EF](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Titulo] [varchar](300) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Fonte] [varchar](200) NULL,
	[Tamanho] [varchar](3) NULL,
	[BtEsq] [int] NULL,
	[BtCen] [int] NULL,
	[BtDir] [int] NULL,
	[BtJus] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIAS_JU]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIAS_JU](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Titulo] [varchar](300) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIAS_ME]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIAS_ME](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Titulo] [varchar](300) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIAS_OD]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIAS_OD](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Titulo] [varchar](300) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIAS_P1]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIAS_P1](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Titulo] [varchar](300) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Fonte] [varchar](200) NULL,
	[Tamanho] [varchar](3) NULL,
	[BtEsq] [int] NULL,
	[BtCen] [int] NULL,
	[BtDir] [int] NULL,
	[BtJus] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIAS_P1E]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIAS_P1E](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Titulo] [varchar](300) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Fonte] [varchar](200) NULL,
	[Tamanho] [varchar](3) NULL,
	[BtEsq] [int] NULL,
	[BtCen] [int] NULL,
	[BtDir] [int] NULL,
	[BtJus] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIAS_PE]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIAS_PE](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Titulo] [varchar](300) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIAS_PSI]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIAS_PSI](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Titulo] [varchar](300) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIAS_SERVICO_SOCIAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIAS_SERVICO_SOCIAL](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Titulo] [varchar](300) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIAS_TO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIAS_TO](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Titulo] [varchar](300) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCORRENCIASEGURANCA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCORRENCIASEGURANCA](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Titulo] [varchar](300) NULL,
	[TextoArea] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Fonte] [varchar](200) NULL,
	[Tamanho] [varchar](3) NULL,
	[BtEsq] [int] NULL,
	[BtCen] [int] NULL,
	[BtDir] [int] NULL,
	[BtJus] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCUPACAO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OCUPACAO](
	[IdCodigoOcupa] [int] IDENTITY(1,1) NOT NULL,
	[StatusOcupa] [varchar](20) NULL,
	[DescricaoOcupa] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCodigoOcupa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ODONTOGRAMA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ODONTOGRAMA](
	[IdOdonto] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdProcOdonto] [int] NOT NULL,
	[NumeroDente] [int] NULL,
	[DataOdontograma] [datetime] NULL,
	[FacesDente] [varchar](60) NULL,
	[Vermelho] [int] NULL,
	[Verde] [int] NULL,
	[Azul] [int] NULL,
	[PlanoTratamento] [varchar](200) NULL,
	[ParcialTotal] [varchar](60) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdOdonto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ODONTOGRAMA_ADMISSAO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ODONTOGRAMA_ADMISSAO](
	[IdOdonto] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdProcOdonto] [int] NOT NULL,
	[DataOdontograma] [datetime] NULL,
	[NumeroDente] [int] NULL,
	[NrFace] [int] NULL,
	[FacesDente] [varchar](60) NULL,
	[ParcialTotal] [varchar](60) NULL,
	[PlanoTratamento] [varchar](200) NULL,
	[TipoProc] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdOdonto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ODONTOGRAMA_EVOLUCAO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ODONTOGRAMA_EVOLUCAO](
	[IdODEvol] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdProcOdonto] [int] NOT NULL,
	[NumeroDente] [int] NULL,
	[DataOdontograma] [datetime] NULL,
	[FacesDente] [varchar](60) NULL,
	[ParcialTotal] [varchar](60) NULL,
	[PlanoTratamento] [varchar](200) NULL,
	[NrFace] [int] NULL,
	[TipoProc] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdODEvol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ODONTOPROCEDIMENTO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ODONTOPROCEDIMENTO](
	[IdPro] [int] IDENTITY(1,1) NOT NULL,
	[DataPro] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Procedimento] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OFICIAL_JUSTICA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OFICIAL_JUSTICA](
	[IdOficial] [int] IDENTITY(1,1) NOT NULL,
	[DataCadastro] [datetime] NULL,
	[FotoOficial] [varchar](350) NULL,
	[NomeOficial] [varchar](200) NULL,
	[RgOficial] [varchar](20) NULL,
	[CpfOficial] [varchar](20) NULL,
	[REGOficial] [varchar](20) NULL,
	[ObsOficial] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[StatusOficial] [varchar](100) NULL,
	[ImagemFrenteOF] [varbinary](max) NULL,
	[NomeMae] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdOficial] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OPERACAO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OPERACAO](
	[IdOp] [int] IDENTITY(1,1) NOT NULL,
	[TipoOp] [varchar](100) NOT NULL,
	[DescricaoOp] [varchar](200) NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[StatusOp] [varchar](60) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdOp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ORGANOGRAMA_CRIME]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ORGANOGRAMA_CRIME](
	[IdOrg] [int] IDENTITY(1,1) NOT NULL,
	[StatusOrg] [varchar](30) NULL,
	[DataOrg] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[CartaBaralho] [varbinary](max) NULL,
	[Faccao] [varchar](200) NULL,
	[IdPav] [int] NOT NULL,
	[IdCela] [int] NOT NULL,
	[Recompensa] [real] NULL,
	[SituacaoRegistro] [varchar](30) NULL,
	[ObservacaoFrente] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdOrg] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PAGAMENTO_KIT_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PAGAMENTO_KIT_INTERNOS](
	[IdPagto] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Responsavel] [varchar](200) NULL,
	[HoraInicio] [varchar](30) NULL,
	[HoraTermino] [varchar](30) NULL,
	[TipoKit] [varchar](100) NULL,
	[IdPav] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
	[AssinaturaDigital] [varbinary](max) NULL,
	[IdRegistro] [int] NULL,
	[IdKit] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPagto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PAGAMENTO_REFEICAO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PAGAMENTO_REFEICAO](
	[IdRef] [int] IDENTITY(1,1) NOT NULL,
	[StatusRef] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[Responsavel] [varchar](100) NULL,
	[HorarioInicial] [varchar](20) NULL,
	[HoraTermino] [varchar](100) NULL,
	[TipoRefeicao] [varchar](60) NULL,
	[IdPav] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRef] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PAI_PSICOSOCIAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PAI_PSICOSOCIAL](
	[IdPai] [int] IDENTITY(1,1) NOT NULL,
	[StatusPai] [varchar](20) NULL,
	[DataPai] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdadeInterno] [int] NULL,
	[OrientacaoSexual] [varchar](60) NULL,
	[DadosPessoais] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PAISES]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PAISES](
	[IdPais] [int] IDENTITY(1,1) NOT NULL,
	[NomePais] [varchar](80) NOT NULL,
	[CodPais] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPais] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PARAMETROSCRC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PARAMETROSCRC](
	[IdPar] [int] IDENTITY(1,1) NOT NULL,
	[QtdDias] [int] NULL,
	[QtdHoras] [int] NULL,
	[UsuarioAutorizado] [varchar](50) NULL,
	[RetornosPortaria] [varchar](30) NULL,
	[EntradasPortaria] [varchar](3) NULL,
	[DataValidade] [datetime] NULL,
	[LicencaValidade] [varchar](300) NULL,
	[DataAtualizacao] [datetime] NULL,
	[DocAudiencia] [varchar](3) NULL,
	[DocTrans] [varchar](3) NULL,
	[DocSaidaTmp] [varchar](3) NULL,
	[DocLivraPro] [varchar](3) NULL,
	[ValAudiencia] [varchar](3) NULL,
	[ValTrans] [varchar](3) NULL,
	[ValSaidaTmp] [varchar](3) NULL,
	[ValLivraPro] [varchar](3) NULL,
	[DocPro] [varchar](3) NULL,
	[DocAlvara] [varchar](3) NULL,
	[ValPro] [varchar](3) NULL,
	[ValAlvara] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[PopulacaoBgp] [varchar](15) NULL,
	[LocacaoBgp] [varchar](15) NULL,
	[TransferenciaBgp] [varchar](15) NULL,
	[PavilhaoCelaBgp] [varchar](15) NULL,
	[PopulacaoBpa] [varchar](15) NULL,
	[LocacaoBpa] [varchar](15) NULL,
	[TransferenciaBpa] [varchar](15) NULL,
	[PavilhaoCelaBpa] [varchar](15) NULL,
	[CaminhoImagemServicoSocial] [varchar](300) NULL,
	[CaminhoImagemCRCInterno] [varchar](300) NULL,
	[LocalFotoVisitasDiversas] [varchar](200) NULL,
	[LocalFotosAdvogados] [varchar](200) NULL,
	[LocalFotosOficialJustica] [varchar](200) NULL,
	[LocalFotosVisitasInternos] [varchar](200) NULL,
	[LocalFotosInternos] [varchar](200) NULL,
	[LocalFotosColaboradores] [varchar](200) NULL,
	[CaminhoImagemColaboradores] [varchar](200) NULL,
	[LocalFotosDiversos] [varchar](200) NULL,
	[BiometriaMedicos] [varchar](3) NULL,
	[BiometriaEnfermeiros] [varchar](3) NULL,
	[BiometriaTecnicos] [varchar](3) NULL,
	[CarcereFem] [varchar](3) NULL,
	[LocalPDF_PI] [varchar](200) NULL,
	[LocalPDF_PE] [varchar](200) NULL,
	[LocalPDF_B1] [varchar](200) NULL,
	[LocalPDF_B2] [varchar](200) NULL,
	[CaminhoExecutavel] [varchar](200) NULL,
	[DataVersao] [varchar](10) NULL,
	[NumeroVersao] [varchar](20) NULL,
	[LocalSaida] [varchar](300) NULL,
	[CaminhoExecutavelAntigo] [varchar](300) NULL,
	[PreLocacaoB1] [varchar](20) NULL,
	[PreLocacaoB2] [varchar](20) NULL,
	[NomeColaboradorPRI] [varchar](300) NULL,
	[NomeColaboradorSEG] [varchar](300) NULL,
	[AtendInterSocial] [varchar](3) NULL,
	[LigacaoTelSocial] [varchar](3) NULL,
	[AtendimentoBioPSI] [varchar](3) NULL,
	[AvaliacaoBioPSI] [varchar](3) NULL,
	[AdmissaoJuridico] [varchar](3) NULL,
	[AdmissaoTO] [varchar](3) NULL,
	[AdmissaoOdonto] [varchar](3) NULL,
	[HabilitarAlertaVisitasBaseI] [varchar](15) NULL,
	[HabilitarAlertaVisitasBaseII] [varchar](15) NULL,
	[NomeColaboradorCRC] [varchar](300) NULL,
	[NomeColaboradorCRCSEG] [varchar](300) NULL,
	[BiometriaPeda] [varchar](3) NULL,
	[NomeColaboradorTER] [varchar](300) NULL,
	[NomeColaboradorQUA] [varchar](300) NULL,
	[NomeColaboradorQUI] [varchar](300) NULL,
	[TipoServidor] [varchar](100) NULL,
	[TipoBancoDados] [varchar](100) NULL,
	[NomeColaboradorLiberaUm] [varchar](200) NULL,
	[NomeColaboradorLiberaDois] [varchar](200) NULL,
	[NomeColaboradorEncerraUm] [varchar](200) NULL,
	[NomeColaboradorEncerraDois] [varchar](200) NULL,
	[PagamentoKit] [varchar](3) NULL,
	[SistemaManutencao] [varchar](3) NULL,
	[BiometriaEF] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPar] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PARCELAS_COMPRAS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PARCELAS_COMPRAS](
	[IdParc] [int] IDENTITY(1,1) NOT NULL,
	[IdNfEntrada] [int] NOT NULL,
	[IdForn] [int] NOT NULL,
	[DataVcto] [date] NOT NULL,
	[ValorParcela] [money] NOT NULL,
	[ValorTotalParcelas] [money] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdParc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PARCELAS_COMPRAS_FAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PARCELAS_COMPRAS_FAR](
	[IdParc] [int] IDENTITY(1,1) NOT NULL,
	[IdNfEntrada] [int] NOT NULL,
	[IdForn] [int] NOT NULL,
	[DataVcto] [date] NOT NULL,
	[ValorParcela] [money] NOT NULL,
	[ValorTotalParcelas] [money] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdParc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PARCELAS_COMPRAS_NUTRI]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PARCELAS_COMPRAS_NUTRI](
	[IdParc] [int] IDENTITY(1,1) NOT NULL,
	[IdNfEntrada] [int] NOT NULL,
	[IdForn] [int] NOT NULL,
	[DataVcto] [date] NOT NULL,
	[ValorParcela] [money] NOT NULL,
	[ValorTotalParcelas] [money] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdParc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PARECER_PSI]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PARECER_PSI](
	[IdParecer] [int] IDENTITY(1,1) NOT NULL,
	[DataParecer] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[ParecerPsicologico] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdParecer] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_EF]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_EF](
	[IdItemPartEF] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoEF] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemPartEF] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM](
	[IdItemPartEnf] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoEnf] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemPartEnf] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_PE]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_PE](
	[IdItemPartPE] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoPE] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemPartPE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_PSICOLOGIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_PSICOLOGIA](
	[IdItemPart] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoPsi] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemPart] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_SS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_SS](
	[IdItemPartSS] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoSS] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemPartSS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_TO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_TO](
	[IdItemPartTO] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoTO] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemPartTO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PATOLOGIA_EVOLUCAO_MEDICA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PATOLOGIA_EVOLUCAO_MEDICA](
	[IdPatMed] [int] IDENTITY(1,1) NOT NULL,
	[DataReg] [datetime] NULL,
	[IdItem] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdDoenca] [int] NOT NULL,
	[TipoAna] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPatMed] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PATOLOGIA_EVOLUCAO_PSIQUIATRICA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PATOLOGIA_EVOLUCAO_PSIQUIATRICA](
	[IdPatPsi] [int] IDENTITY(1,1) NOT NULL,
	[DataReg] [datetime] NULL,
	[IdItem] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdDoenca] [int] NOT NULL,
	[TipoAna] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPatPsi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PAVILHAO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PAVILHAO](
	[IdPav] [int] IDENTITY(1,1) NOT NULL,
	[StatusPav] [varchar](10) NULL,
	[DescricaoPav] [varchar](150) NOT NULL,
	[Motivo] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[NivelPav] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPav] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PDF_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PDF_INTERNOS](
	[IdPdf] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DescricaoPdf] [varchar](200) NULL,
	[DocumentoPdf] [varbinary](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPdf] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PECULIARIDADE_COSTAS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PECULIARIDADE_COSTAS](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataPec] [date] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[RegiaoCostas] [varchar](200) NULL,
	[TextoPeculiaridade] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PECULIARIDADE_FRENTE]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PECULIARIDADE_FRENTE](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataPec] [date] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[RegiaoFrente] [varchar](200) NULL,
	[TextoPeculiaridade] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PERFIL_CARCERARIO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PERFIL_CARCERARIO](
	[IdPerfilCar] [int] IDENTITY(1,1) NOT NULL,
	[IdPerfil] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[ResidenciaFixa] [varchar](3) NULL,
	[FilhosRecPaternidade] [varchar](8) NULL,
	[FilhosMaior21] [varchar](7) NULL,
	[ComposicaoFamiliar] [varchar](7) NULL,
	[RG] [varchar](3) NULL,
	[FilhosMenor21] [varchar](7) NULL,
	[CPF] [varchar](3) NULL,
	[FamiliaRecBeneGov] [varchar](3) NULL,
	[TemVisita] [varchar](3) NULL,
	[Escolaridade] [varchar](50) NULL,
	[FrequentaEscolaUnid] [varchar](3) NULL,
	[FezENEN] [varchar](3) NULL,
	[AtividadeLabor] [varchar](3) NULL,
	[CarteiraAssinada] [varchar](3) NULL,
	[TranstornoMental] [varchar](3) NULL,
	[UsouDrogas] [varchar](3) NULL,
	[UsaDrogas] [varchar](3) NULL,
	[Diabetes] [varchar](3) NULL,
	[Hipertensao] [varchar](3) NULL,
	[Sifilis] [varchar](3) NULL,
	[Tuberculose] [varchar](50) NULL,
	[Hepatite] [varchar](3) NULL,
	[HIV] [varchar](3) NULL,
	[Hanseniase] [varchar](3) NULL,
	[Reu] [varchar](15) NULL,
	[Artigo] [varchar](8) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[AnemiaFalsiforme] [varchar](3) NULL,
	[InteresseTrabalhar] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPerfilCar] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PERFIL_CARCERARIO_INTERNO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PERFIL_CARCERARIO_INTERNO](
	[IdPerfil] [int] IDENTITY(1,1) NOT NULL,
	[StatusPerfil] [varchar](20) NULL,
	[DataPerfil] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[ObservacaoPerfil] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[OpcaoSexual] [varchar](100) NULL,
	[AnoNasc] [int] NULL,
	[AnoRef] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPerfil] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PERNOITE_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PERNOITE_INTERNOS](
	[IdPer] [int] IDENTITY(1,1) NOT NULL,
	[StatusRegistro] [varchar](30) NULL,
	[DataRegistro] [datetime] NULL,
	[DescricaoPavilhao] [varchar](200) NULL,
	[Documento] [varchar](80) NULL,
	[DescricaoCela] [varchar](200) NULL,
	[Objetivo] [varchar](80) NULL,
	[UnidadeOrigem] [varchar](200) NULL,
	[NomeCondutor] [varchar](200) NULL,
	[Rg] [varchar](20) NULL,
	[Cpf] [varchar](20) NULL,
	[Veiculo] [varchar](60) NULL,
	[Placa] [varchar](20) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Motivo] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPer] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PERTENCES]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PERTENCES](
	[IdPertence] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](10) NULL,
	[DataCadastro] [datetime] NULL,
	[DescricaoPertence] [varchar](200) NULL,
	[FotoPertence] [varchar](200) NULL,
	[Unidade] [varchar](5) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[ImagemFrentePER] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPertence] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_EF]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_EF](
	[IdItemPlanEF] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoEF] [int] NOT NULL,
	[Tema] [varchar](200) NULL,
	[HoraInicio] [varchar](20) NULL,
	[HoraTermino] [varchar](20) NULL,
	[Turno] [varchar](80) NULL,
	[Atividades] [varchar](250) NULL,
	[Recursos] [varchar](250) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemPlanEF] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM](
	[IdItemPlanEnf] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoEnf] [int] NOT NULL,
	[Tema] [varchar](200) NULL,
	[HoraInicio] [varchar](20) NULL,
	[HoraTermino] [varchar](20) NULL,
	[Turno] [varchar](80) NULL,
	[Atividades] [varchar](250) NULL,
	[Recursos] [varchar](250) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
	[TipoVacina] [varchar](80) NULL,
	[PD] [int] NULL,
	[SD] [int] NULL,
	[TD] [int] NULL,
	[RD] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemPlanEnf] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_PE]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_PE](
	[IdItemPlanPE] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoPE] [int] NOT NULL,
	[Tema] [varchar](200) NULL,
	[HoraInicio] [varchar](20) NULL,
	[HoraTermino] [varchar](20) NULL,
	[Turno] [varchar](80) NULL,
	[Atividades] [varchar](250) NULL,
	[Recursos] [varchar](250) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemPlanPE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_PSICOLOGIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_PSICOLOGIA](
	[IdItemPlan] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoPsi] [int] NOT NULL,
	[Tema] [varchar](200) NULL,
	[HoraInicio] [varchar](20) NULL,
	[HoraTermino] [varchar](20) NULL,
	[Turno] [varchar](80) NULL,
	[Atividades] [varchar](250) NULL,
	[Recursos] [varchar](250) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemPlan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_SS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_SS](
	[IdItemPlanSS] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoSS] [int] NOT NULL,
	[Tema] [varchar](200) NULL,
	[HoraInicio] [varchar](20) NULL,
	[HoraTermino] [varchar](20) NULL,
	[Turno] [varchar](80) NULL,
	[Atividades] [varchar](250) NULL,
	[Recursos] [varchar](250) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemPlanSS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_TO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_TO](
	[IdItemPlanTO] [int] IDENTITY(1,1) NOT NULL,
	[IdAtGrupoTO] [int] NOT NULL,
	[Tema] [varchar](200) NULL,
	[HoraInicio] [varchar](20) NULL,
	[HoraTermino] [varchar](20) NULL,
	[Turno] [varchar](80) NULL,
	[Atividades] [varchar](250) NULL,
	[Recursos] [varchar](250) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemPlanTO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PLANEJAMENTO_ATIVIDADES_GRUPO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PLANEJAMENTO_ATIVIDADES_GRUPO](
	[IdPlan] [int] IDENTITY(1,1) NOT NULL,
	[DescricaoPlaneja] [varchar](350) NULL,
	[Sigla] [varchar](2) NULL,
	[Setor] [varchar](80) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPlan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[POPAGENTES]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[POPAGENTES](
	[IdAgente] [int] IDENTITY(1,1) NOT NULL,
	[DataMov] [datetime] NULL,
	[IdPopMov] [int] NOT NULL,
	[AgenteMasc] [int] NULL,
	[AgenteFem] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Motoristas] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAgente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[POPBRASFEM]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[POPBRASFEM](
	[IdPopBrasm] [int] IDENTITY(1,1) NOT NULL,
	[DataPop] [datetime] NULL,
	[IdPopMov] [int] NOT NULL,
	[BrasMulherFec] [int] NULL,
	[BrasMulherAbe] [int] NULL,
	[BrasMulherSem] [int] NULL,
	[BrasMulherPro] [int] NULL,
	[TotalGeralBrasFem] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPopBrasm] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[POPBRASMASC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[POPBRASMASC](
	[IdPopBrash] [int] IDENTITY(1,1) NOT NULL,
	[DataPop] [datetime] NULL,
	[IdPopMov] [int] NOT NULL,
	[BrasHomemFec] [int] NULL,
	[BrasHomemAbe] [int] NULL,
	[BrasHomemSem] [int] NULL,
	[BrasHomemPro] [int] NULL,
	[TotalGeralBrasMasc] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPopBrash] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[POPESTRANGFEM]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[POPESTRANGFEM](
	[IdPopEstm] [int] IDENTITY(1,1) NOT NULL,
	[DataPop] [datetime] NULL,
	[IdPopMov] [int] NOT NULL,
	[EstraMulherFec] [int] NULL,
	[EstraMulherAbe] [int] NULL,
	[EstraMulherSem] [int] NULL,
	[EstraMulherPro] [int] NULL,
	[TotalGeralFem] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPopEstm] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[POPESTRANGMASC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[POPESTRANGMASC](
	[IdPopEsth] [int] IDENTITY(1,1) NOT NULL,
	[DataPop] [datetime] NULL,
	[IdPopMov] [int] NOT NULL,
	[EstraHomenFec] [int] NULL,
	[EstraHomenAbe] [int] NULL,
	[EstraHomenSem] [int] NULL,
	[EstraHomenPro] [int] NULL,
	[TotalGeralMasc] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPopEsth] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[POPULACAOINTERNOS_CRC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[POPULACAOINTERNOS_CRC](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataPop] [date] NULL,
	[IdInternoCrc] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PORTA_ENTRADA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PORTA_ENTRADA](
	[IdAdm] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[PSPEnf] [varchar](100) NULL,
	[HabEnf] [varchar](3) NULL,
	[PSPMed] [varchar](100) NULL,
	[HabMed] [varchar](3) NULL,
	[PSPJur] [varchar](100) NULL,
	[HabJur] [varchar](3) NULL,
	[PSPPed] [varchar](100) NULL,
	[HabPed] [varchar](3) NULL,
	[PSPPsi] [varchar](100) NULL,
	[HabPsi] [varchar](3) NULL,
	[PSPSso] [varchar](100) NULL,
	[HabSso] [varchar](3) NULL,
	[PSPOdo] [varchar](100) NULL,
	[HabOdo] [varchar](3) NULL,
	[PSPTer] [varchar](100) NULL,
	[HabTer] [varchar](3) NULL,
	[PSPEdu] [varchar](100) NULL,
	[HabEdu] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAdm] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PORTA_ENTRADA_PSICOLOGIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PORTA_ENTRADA_PSICOLOGIA](
	[IdPortaPSI] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[PresoAntes] [varchar](3) NULL,
	[FamiliaPreso] [varchar](3) NULL,
	[QuemFamiliaPreso] [varchar](80) NULL,
	[OndePreso] [varchar](80) NULL,
	[HistoricoCriminal] [varchar](max) NULL,
	[UsaDrogras] [varchar](3) NULL,
	[Alcool] [int] NULL,
	[Cigarro] [int] NULL,
	[Maconha] [int] NULL,
	[Crack] [int] NULL,
	[Cocaina] [int] NULL,
	[Cola] [int] NULL,
	[Outros] [int] NULL,
	[OutrasDrogas] [varchar](50) NULL,
	[QualIdade] [varchar](5) NULL,
	[PorqueUsaDrogas] [varchar](50) NULL,
	[Drogas] [varchar](max) NULL,
	[TratamentoPSI] [varchar](3) NULL,
	[MedicamentoPSI] [varchar](3) NULL,
	[QualMedicamento] [varchar](80) NULL,
	[AcompanhaPSI] [varchar](15) NULL,
	[TranstornoMental] [varchar](max) NULL,
	[DepartamentoEncaminha] [varchar](300) NULL,
	[DataEncaminhamento] [datetime] NULL,
	[HoraAcompanha] [varchar](10) NULL,
	[Encaminhamento] [varchar](max) NULL,
	[TratamentoSaude] [varchar](3) NULL,
	[QualTratamentoSaude] [varchar](40) NULL,
	[OndeFazTratamento] [varchar](90) NULL,
	[TratamentoAnteriores] [varchar](max) NULL,
	[SituacaoTraumatica] [varchar](3) NULL,
	[QualSituacaoTraumatica] [varchar](30) NULL,
	[HouveTentativaSuicidio] [varchar](3) NULL,
	[PorQueSuicidio] [varchar](50) NULL,
	[ComoFoiTentarSuicidio] [varchar](30) NULL,
	[OndeTentouSuicidio] [varchar](50) NULL,
	[TentativaSuicidio] [varchar](max) NULL,
	[QualMedicamentoUtiliza] [varchar](100) NULL,
	[PorqueUsaMedicamento] [varchar](100) NULL,
	[UsoMedicamentos] [varchar](max) NULL,
	[RecebeVisitas] [varchar](3) NULL,
	[Familiares] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPortaPSI] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PORTA_ENTRADA_SERVICO_SOCIAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PORTA_ENTRADA_SERVICO_SOCIAL](
	[IdAtendSS] [int] IDENTITY(1,1) NOT NULL,
	[DataAtend] [datetime] NULL,
	[IdAtend] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[StatusAtend] [varchar](30) NULL,
	[ContatoAtend] [varchar](200) NULL,
	[TelefoneAtend] [varchar](20) NULL,
	[Telefone1Atend] [varchar](20) NULL,
	[CelularAtend] [varchar](20) NULL,
	[EnderecoAtend] [varchar](250) NULL,
	[BairroAtend] [varchar](150) NULL,
	[CidadeAtend] [varchar](250) NULL,
	[EstadoAtend] [varchar](150) NULL,
	[CartTrabAtend] [varchar](10) NULL,
	[Periodo] [varchar](100) NULL,
	[RecebeRecluAtend] [varchar](10) NULL,
	[DireitoAuxAtend] [varchar](10) NULL,
	[RecebeBolAtend] [varchar](10) NULL,
	[QtdPessoasAtend] [varchar](10) NULL,
	[QtdTrabaAtend] [varchar](10) NULL,
	[CN1Atend] [varchar](10) NULL,
	[CN2Atend] [varchar](10) NULL,
	[RG1Atend] [varchar](10) NULL,
	[RG2atend] [varchar](10) NULL,
	[CPF1Atend] [varchar](10) NULL,
	[CPF2Atend] [varchar](10) NULL,
	[CTPS1Atend] [varchar](10) NULL,
	[CTPS2Atend] [varchar](10) NULL,
	[PossuiFilhosAtend] [varchar](10) NULL,
	[QtdFilhosAtend] [varchar](10) NULL,
	[FilhosNaoRegAtend] [varchar](10) NULL,
	[OutrosFilhosAtend] [varchar](10) NULL,
	[QtdFilhos2Atend] [varchar](10) NULL,
	[PaternidadeAtend] [varchar](10) NULL,
	[DefensorAtend] [varchar](50) NULL,
	[PartiFamiAtend] [varchar](30) NULL,
	[ConsiderAtend] [varchar](max) NULL,
	[MunicipioNascimento] [varchar](100) NULL,
	[Tituloeleito1] [varchar](3) NULL,
	[Tituloeleito2] [varchar](3) NULL,
	[Reservista1] [varchar](20) NULL,
	[Reservista2] [varchar](20) NULL,
	[CartorioRegistro] [varchar](80) NULL,
	[RecebeBeneficio] [varchar](15) NULL,
	[TempoConvivencia] [varchar](10) NULL,
	[EsposoCompanheiro] [varchar](20) NULL,
	[NomeEsposoCompanheiro] [varchar](60) NULL,
	[PessoasResideCasa] [varchar](10) NULL,
	[EncaOutroSetor] [varchar](3) NULL,
	[QualSetor] [varchar](40) NULL,
	[CancelarVisita] [varchar](3) NULL,
	[MotivoCancelarVisita] [varchar](50) NULL,
	[EncaTirarDoc] [varchar](3) NULL,
	[DataEncaDoc] [datetime] NULL,
	[EncaRecPaternidade] [varchar](3) NULL,
	[DataRecPaternidade] [datetime] NULL,
	[RecebeVisita] [varchar](3) NULL,
	[CondicaoSegurado] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAtendSS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PRE_LOCACAO_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PRE_LOCACAO_INTERNOS](
	[CodigoReg] [int] IDENTITY(1,1) NOT NULL,
	[StatusReg] [varchar](20) NULL,
	[DataReg] [datetime] NULL,
	[ObservacaoReg] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[CodigoReg] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PRESCRICAO_MEDICA_PSIQUIATRICA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PRESCRICAO_MEDICA_PSIQUIATRICA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataPres] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TipoP] [int] NULL,
	[TextoPrescricao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PRESCRICAO_ODONTOLOGIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PRESCRICAO_ODONTOLOGIA](
	[IdPre] [int] IDENTITY(1,1) NOT NULL,
	[DataPre] [datetime] NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoPrescricao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPre] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PREVISAOSAIDA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PREVISAOSAIDA](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdOp] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PROCEDIMENTOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PROCEDIMENTOS](
	[IdProc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](30) NULL,
	[DataLanc] [datetime] NULL,
	[HorarioInicial] [varchar](20) NULL,
	[HorarioTermino] [varchar](20) NULL,
	[Responsavel] [varchar](300) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdProc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PROCEDIMENTOS_ODONTOLOGICO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PROCEDIMENTOS_ODONTOLOGICO](
	[IdProcOdonto] [int] IDENTITY(1,1) NOT NULL,
	[StatusProc] [varchar](20) NULL,
	[Classificacao] [varchar](60) NULL,
	[DescricaoProcedimento] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdProcOdonto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PROCESSOS_JURIDICOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PROCESSOS_JURIDICOS](
	[IdProc] [int] IDENTITY(1,1) NOT NULL,
	[IdFicha] [int] NOT NULL,
	[NrProcesso] [varchar](50) NULL,
	[Inquerito] [varchar](100) NULL,
	[Regime] [varchar](50) NULL,
	[Sentenca] [varchar](100) NULL,
	[TipoSentenca] [varchar](100) NULL,
	[SituacaoPresoProcesso] [varchar](100) NULL,
	[Anos] [int] NULL,
	[Meses] [int] NULL,
	[Dias] [int] NULL,
	[DataInicio] [date] NULL,
	[DataTermino] [date] NULL,
	[TotalDias] [int] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdProc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PRODUTOS_AC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PRODUTOS_AC](
	[IdProd] [int] IDENTITY(1,1) NOT NULL,
	[StatusProd] [varchar](20) NULL,
	[CodigoBarra] [varchar](100) NULL,
	[DescricaoProd] [varchar](200) NULL,
	[UnidadeProd] [varchar](20) NULL,
	[ReferenciaProd] [varchar](200) NULL,
	[AplicarDose] [varchar](3) NULL,
	[QtdDoses] [int] NULL,
	[Topicos] [varchar](max) NULL,
	[ContraIndicacoes] [varchar](max) NULL,
	[Substancias] [varchar](max) NULL,
	[AcoesTerapeuticas] [varchar](max) NULL,
	[PesoBruto] [decimal](18, 3) NULL,
	[PesoLiquido] [decimal](18, 3) NULL,
	[FatorCorrecao] [money] NULL,
	[FatorCoccao] [money] NULL,
	[FotoProduto] [varchar](300) NULL,
	[FotoProduto2] [varchar](300) NULL,
	[IdGrupo] [int] NOT NULL,
	[IdForn] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[DataFabricacao] [date] NULL,
	[DataCompra] [date] NULL,
	[DataValidade] [date] NULL,
	[ValorCompra] [money] NULL,
	[QtdCompra] [float] NULL,
	[DataSaida] [date] NULL,
	[QtdSaida] [float] NULL,
	[AliquotaIcms] [float] NULL,
	[AliquotaIpi] [float] NULL,
	[ClassificacaoFiscal] [varchar](50) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Modulo] [varchar](1) NULL,
	[CompoeKit] [varchar](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdProd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PRODUTOS_KITS_HIGIENE_INTERNO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PRODUTOS_KITS_HIGIENE_INTERNO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdKit] [int] NOT NULL,
	[IdProd] [int] NOT NULL,
	[QuantItem] [float] NULL,
	[KitInicial] [int] NULL,
	[KitDecendial] [int] NULL,
	[KitQuinzenal] [int] NULL,
	[KitSemestral] [int] NULL,
	[KitMensal] [int] NULL,
	[KitAnual] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PROFESSORES]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PROFESSORES](
	[IdProf] [int] IDENTITY(1,1) NOT NULL,
	[NomeProfessor] [varchar](300) NULL,
	[StatusProf] [varchar](20) NULL,
	[FotoProf] [varchar](300) NULL,
	[DataNascProf] [datetime] NULL,
	[EstadoCivil] [varchar](100) NULL,
	[SexoProf] [varchar](100) NULL,
	[Telefone] [varchar](20) NULL,
	[Celular] [varchar](20) NULL,
	[Celular1] [varchar](20) NULL,
	[IdCod] [int] NOT NULL,
	[Cep] [varchar](20) NULL,
	[Endereco] [varchar](400) NULL,
	[Bairro] [varchar](300) NULL,
	[Cidade] [varchar](300) NULL,
	[Estado] [varchar](2) NULL,
	[Graduacao] [varchar](200) NULL,
	[Especialidade] [varchar](200) NULL,
	[Mestrado] [varchar](200) NULL,
	[Doutorado] [varchar](200) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdProf] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PROFISSAO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PROFISSAO](
	[IdCodigoProf] [int] IDENTITY(1,1) NOT NULL,
	[StatusProf] [varchar](20) NULL,
	[DescricaoProf] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCodigoProf] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PROGRAMACAO_PAGAMENTO_KITS_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PROGRAMACAO_PAGAMENTO_KITS_INTERNOS](
	[IdPROG] [int] IDENTITY(1,1) NOT NULL,
	[DataPROG] [datetime] NULL,
	[DataUltimoPagto] [datetime] NULL,
	[DataPrevisao] [datetime] NULL,
	[TipoKit] [int] NULL,
	[IdPav] [int] NOT NULL,
	[IdKit] [int] NOT NULL,
	[ProgGerada] [varchar](3) NULL,
	[KitPago] [varchar](3) NULL,
	[DataPagamento] [datetime] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPROG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PROGRESSAOREGIME]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PROGRESSAOREGIME](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[TipoMudanca] [varchar](15) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PRONTUARIOSCRC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PRONTUARIOSCRC](
	[IdInternoCrc] [int] IDENTITY(1,1) NOT NULL,
	[MatriculaCrc] [varchar](80) NULL,
	[DataCadastCrc] [datetime] NULL,
	[DataNasciCrc] [datetime] NULL,
	[FotoInternoCrc] [varchar](300) NULL,
	[NomeInternoCrc] [varchar](150) NOT NULL,
	[MaeInternoCrc] [varchar](120) NULL,
	[PaiInternoCrc] [varchar](120) NULL,
	[AlcunhaCrc] [varchar](200) NULL,
	[RgInternoCrc] [varchar](20) NULL,
	[CpfInternoCrc] [varchar](20) NULL,
	[EscolaridadeCrc] [varchar](80) NULL,
	[EstadoCivilCrc] [varchar](80) NULL,
	[CartaoSus] [varchar](100) NULL,
	[SexoCrc] [varchar](80) NULL,
	[SituacaoCrc] [varchar](100) NULL,
	[IdPais] [int] NOT NULL,
	[IdCidade] [int] NOT NULL,
	[ReligiaoCrc] [varchar](120) NULL,
	[ProfissaoCrc] [varchar](120) NULL,
	[EnderecoCrc] [varchar](300) NULL,
	[BairroCrc] [varchar](200) NULL,
	[CidadeCrc] [varchar](250) NULL,
	[EstadoCrc] [varchar](200) NULL,
	[TelefoneCrc] [varchar](20) NULL,
	[Telefone1Crc] [varchar](20) NULL,
	[CelularCrc] [varchar](20) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Cnc] [varchar](20) NULL,
	[ImagemFrente] [varbinary](max) NULL,
	[DocumentacaoCompleta] [varchar](20) NULL,
	[QuaisDocumentosFaltam] [varchar](200) NULL,
	[Tornozeleira] [varchar](8) NULL,
	[DataEntradaAnt] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdInternoCrc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PRONTUARIOSCRC_TRANSFERENCIA_UNIDADES]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PRONTUARIOSCRC_TRANSFERENCIA_UNIDADES](
	[IdInternoCrc] [int] IDENTITY(1,1) NOT NULL,
	[DataTrans] [datetime] NULL,
	[TransConf] [varchar](3) NULL,
	[UnidadeOrigem] [varchar](350) NULL,
	[UnidadeDestino] [varchar](350) NULL,
	[MatriculaCrc] [varchar](80) NULL,
	[Cnc] [varchar](20) NULL,
	[DataCadastCrc] [datetime] NULL,
	[DataNasciCrc] [datetime] NULL,
	[FotoInternoCrc] [varchar](300) NULL,
	[NomeInternoCrc] [varchar](150) NOT NULL,
	[MaeInternoCrc] [varchar](120) NULL,
	[PaiInternoCrc] [varchar](120) NULL,
	[AlcunhaCrc] [varchar](200) NULL,
	[RgInternoCrc] [varchar](20) NULL,
	[CpfInternoCrc] [varchar](20) NULL,
	[EscolaridadeCrc] [varchar](80) NULL,
	[EstadoCivilCrc] [varchar](80) NULL,
	[CartaoSus] [varchar](100) NULL,
	[SexoCrc] [varchar](80) NULL,
	[SituacaoCrc] [varchar](100) NULL,
	[IdPais] [int] NULL,
	[IdCidade] [int] NULL,
	[ReligiaoCrc] [varchar](120) NULL,
	[ProfissaoCrc] [varchar](120) NULL,
	[EnderecoCrc] [varchar](300) NULL,
	[BairroCrc] [varchar](200) NULL,
	[CidadeCrc] [varchar](250) NULL,
	[EstadoCrc] [varchar](200) NULL,
	[TelefoneCrc] [varchar](20) NULL,
	[Telefone1Crc] [varchar](20) NULL,
	[CelularCrc] [varchar](20) NULL,
	[Cutis] [varchar](20) NULL,
	[Olhos] [varchar](20) NULL,
	[Cabelos] [varchar](20) NULL,
	[Barba] [varchar](20) NULL,
	[Bigode] [varchar](20) NULL,
	[Nariz] [varchar](20) NULL,
	[Boca] [varchar](20) NULL,
	[Rosto] [varchar](20) NULL,
	[Labios] [varchar](20) NULL,
	[Camisa] [varchar](20) NULL,
	[Calca] [varchar](20) NULL,
	[Sapato] [varchar](20) NULL,
	[Peso] [varchar](20) NULL,
	[Altura] [varchar](20) NULL,
	[Sinais] [varchar](20) NULL,
	[Pescoco] [varchar](100) NULL,
	[Orelhas] [varchar](100) NULL,
	[Compleicao] [varchar](100) NULL,
	[IdUnid] [int] NULL,
	[DataEntrada] [datetime] NULL,
	[DataCrime] [datetime] NULL,
	[DataPrisao] [datetime] NULL,
	[DataCondenacao] [datetime] NULL,
	[Participacao] [varchar](20) NULL,
	[Regime] [varchar](20) NULL,
	[Pena] [varchar](20) NULL,
	[VaraCondenatoria] [varchar](100) NULL,
	[Artigo1] [varchar](20) NULL,
	[Artigo2] [varchar](20) NULL,
	[Artigo3] [varchar](20) NULL,
	[Paragrafo1] [varchar](20) NULL,
	[Paragrafo2] [varchar](20) NULL,
	[Paragrafo3] [varchar](20) NULL,
	[CrimeEdiondo] [varchar](20) NULL,
	[TerminoPena] [datetime] NULL,
	[Identificador] [varchar](80) NULL,
	[Identificador1] [varchar](80) NULL,
	[Identificador2] [varchar](80) NULL,
	[Identificador3] [varchar](80) NULL,
	[Perfil] [varchar](80) NULL,
	[RegiaoCorpo] [varchar](80) NULL,
	[RegiaoCorpo1] [varchar](80) NULL,
	[RegiaoCorpo2] [varchar](80) NULL,
	[RegiaoCorpo3] [varchar](80) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[DataNovaEntrada] [datetime] NULL,
	[ConfirmadoExp] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdInternoCrc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR](
	[IdProrroga] [int] IDENTITY(1,1) NOT NULL,
	[StatusRegistro] [varchar](15) NULL,
	[DataRegistro] [datetime] NULL,
	[Responsavel] [varchar](200) NULL,
	[TipoSaida] [varchar](200) NULL,
	[Documento] [varchar](20) NULL,
	[DataDocumento] [datetime] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdProrroga] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL](
	[IdPsiMed] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[FamiliaTranstornoMental] [varchar](3) NULL,
	[QuemTranstornoMental] [varchar](150) NULL,
	[QualTranstornoMental] [varchar](150) NULL,
	[NecessidadePSI] [varchar](3) NULL,
	[ConsultaPSI] [int] NULL,
	[AcompanhaPSI] [int] NULL,
	[FazUsoDroga] [varchar](3) NULL,
	[QuaisDrogas] [varchar](80) NULL,
	[CompartilhaDrogas] [varchar](3) NULL,
	[ReducaoDanos] [varchar](3) NULL,
	[PorqueReduzDanos] [varchar](150) NULL,
	[AceitaProgramasDanos] [varchar](3) NULL,
	[PorqueAceitaProgroReduDanos] [varchar](200) NULL,
	[QueixaProbSaude] [varchar](3) NULL,
	[Hipertensao] [int] NULL,
	[Diabetes] [int] NULL,
	[Tuberculose] [int] NULL,
	[DST] [int] NULL,
	[Hepatite] [int] NULL,
	[Hanseniase] [int] NULL,
	[OutrasDoencas] [int] NULL,
	[QuaisOutrasDoencas] [varchar](150) NULL,
	[ProblemasSaudeBucal] [varchar](3) NULL,
	[FazTratamentoBucal] [varchar](3) NULL,
	[QuaisTratamentoBucal] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPsiMed] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PSICOLOGIA_PAI_PSICOSOCIAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PSICOLOGIA_PAI_PSICOSOCIAL](
	[IdPsiPai] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TranstornoMental] [varchar](3) NULL,
	[TratamentoAnterior] [varchar](3) NULL,
	[QuaisTratamentosMentais] [varchar](15) NULL,
	[OutrosTratamento] [varchar](100) NULL,
	[FoiInternado] [varchar](3) NULL,
	[EspecificarFrequenciasLocais] [varchar](max) NULL,
	[MedicacoesUtilizadas] [varchar](max) NULL,
	[EpisodioDepressivo] [varchar](3) NULL,
	[SurtoPsicotico] [varchar](3) NULL,
	[TentativaSuicidio] [varchar](3) NULL,
	[ComportamentoViolento] [varchar](3) NULL,
	[EnvolveJustica] [varchar](3) NULL,
	[UsoMedicaPsiquia] [varchar](3) NULL,
	[ObservacaoDepressivo] [varchar](80) NULL,
	[ObservacaoSurto] [varchar](80) NULL,
	[ObservacaoTentativaSuicidio] [varchar](80) NULL,
	[ObservacaoComportamentoViolento] [varchar](80) NULL,
	[ObservacaoEnvolveJustica] [varchar](80) NULL,
	[ObservacaoUsoMedicacoPsiquiatrica] [varchar](80) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPsiPai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[RECAPTURA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[RECAPTURA](
	[IdRecaptura] [int] IDENTITY(1,1) NOT NULL,
	[StatusRet] [varchar](30) NULL,
	[DataLancRetorno] [datetime] NULL,
	[IdOp] [int] NOT NULL,
	[ObsRetorno] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRecaptura] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REGIMENTO_DISCIPLINAR_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REGIMENTO_DISCIPLINAR_INTERNOS](
	[IdReg] [int] IDENTITY(1,1) NOT NULL,
	[StatusReg] [varchar](20) NULL,
	[DataReg] [date] NULL,
	[HorarioEvento] [varchar](20) NULL,
	[IdFunc] [int] NOT NULL,
	[IdNatureza] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReg] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REGISTRO_ATENDIMENTO_INTERNO_PSP]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REGISTRO_ATENDIMENTO_INTERNO_PSP](
	[IdRegistro] [int] IDENTITY(1,1) NOT NULL,
	[DataReg] [datetime] NULL,
	[Horario] [varchar](30) NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TipoAtendimento] [varchar](80) NULL,
	[IdDepartamento] [int] NOT NULL,
	[AssinaturaDigital] [varbinary](max) NULL,
	[Atendido] [varchar](3) NULL,
	[IdAtend] [int] NULL,
	[IdEvol] [int] NULL,
	[DataAtendimento] [datetime] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[Impresso] [varchar](3) NULL,
	[IdFunc] [int] NULL,
	[DataAssinatura] [varchar](10) NULL,
	[HoraAssinatura] [varchar](10) NULL,
	[Motivo] [varchar](max) NULL,
	[AssinaturaLiberador] [varbinary](max) NULL,
	[AtendeEvol] [varchar](3) NULL,
	[Qtd] [int] NULL,
	[UsuarioAtendente] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRegistro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REGISTRO_CANCELADO_NE]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REGISTRO_CANCELADO_NE](
	[IdRegCancel] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](30) NULL,
	[DataLanc] [datetime] NULL,
	[Motivo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRegCancel] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REGISTRO_CANCELADO_RETORNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REGISTRO_CANCELADO_RETORNOS](
	[IdRegCancel] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](30) NULL,
	[DataLanc] [datetime] NULL,
	[Motivo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRegCancel] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA](
	[IdRegVisita] [int] IDENTITY(1,1) NOT NULL,
	[StatusReg] [varchar](20) NULL,
	[DataReg] [datetime] NULL,
	[IdVisita] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdRol] [int] NOT NULL,
	[DataChegada] [datetime] NULL,
	[HoraChegada] [varchar](20) NULL,
	[OrdemChegada] [int] NULL,
	[AssinaturaDigitalVisita] [varbinary](max) NULL,
	[TipoOperacao] [int] NULL,
	[MotivoNaoAssinarDigital] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRegVisita] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REGISTRO_INDISCIPLINA_PORTARIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REGISTRO_INDISCIPLINA_PORTARIA](
	[IdReg] [int] IDENTITY(1,1) NOT NULL,
	[StatusReg] [varchar](20) NULL,
	[TipoVisita] [varchar](10) NULL,
	[TipoOcorrencia] [varchar](30) NULL,
	[DataReg] [date] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[StatusAprovacao] [varchar](30) NULL,
	[DataAprovacao] [date] NULL,
	[UsuarioAutorizadorSeg] [varchar](250) NULL,
	[UsuarioAutorizadorSS] [varchar](250) NULL,
	[DataAprovacao1] [date] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReg] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REGISTROCANCELADO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REGISTROCANCELADO](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](30) NULL,
	[DataLanc] [datetime] NULL,
	[Motivo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REGISTROEVENTOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REGISTROEVENTOS](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [date] NULL,
	[HorarioEvento] [varchar](20) NULL,
	[HorarioTermino] [varchar](20) NULL,
	[Responsavel] [varchar](300) NULL,
	[IdPav] [int] NOT NULL,
	[IdCela] [int] NOT NULL,
	[IdNatureza] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REGOBSERVACOES]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REGOBSERVACOES](
	[IdReg] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReg] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REGRESSAOREGIME]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REGRESSAOREGIME](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[TipoMudanca] [varchar](15) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REGRETORNO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REGRETORNO](
	[IdRetorno] [int] IDENTITY(1,1) NOT NULL,
	[StatusRet] [varchar](30) NULL,
	[DataLancRetorno] [datetime] NULL,
	[IdOp] [int] NOT NULL,
	[ObsRetorno] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRetorno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REGSAIDACRC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REGSAIDACRC](
	[IdSaida] [int] IDENTITY(1,1) NOT NULL,
	[StatusSai] [varchar](30) NULL,
	[DatalancaMov] [datetime] NULL,
	[ObsSaida] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSaida] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REQUISICAO_AVULSA_PRODUTOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REQUISICAO_AVULSA_PRODUTOS](
	[IdReq] [int] IDENTITY(1,1) NOT NULL,
	[StatusReq] [varchar](20) NULL,
	[DataReq] [datetime] NULL,
	[IdLocal] [int] NOT NULL,
	[IdFunc] [int] NOT NULL,
	[IdFuncAut] [int] NULL,
	[MatriculaFuncAut] [varchar](20) NULL,
	[NomeFuncAut] [varchar](300) NULL,
	[NomeDepartamentoAut] [varchar](200) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REQUISICAO_AVULSA_PRODUTOS_ENF]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REQUISICAO_AVULSA_PRODUTOS_ENF](
	[IdReq] [int] IDENTITY(1,1) NOT NULL,
	[StatusReq] [varchar](20) NULL,
	[StatusReqAtend] [varchar](20) NULL,
	[DataReq] [datetime] NULL,
	[IdLocal] [int] NOT NULL,
	[IdFunc] [int] NOT NULL,
	[IdFuncAut] [int] NULL,
	[MatriculaFuncAut] [varchar](20) NULL,
	[NomeFuncAut] [varchar](300) NULL,
	[NomeDepartamentoAut] [varchar](200) NULL,
	[TipoReq] [int] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REQUISICAO_AVULSA_PRODUTOS_FAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REQUISICAO_AVULSA_PRODUTOS_FAR](
	[IdReq] [int] IDENTITY(1,1) NOT NULL,
	[StatusReq] [varchar](20) NULL,
	[DataReq] [datetime] NULL,
	[IdLocal] [int] NOT NULL,
	[IdFunc] [int] NOT NULL,
	[IdFuncAut] [int] NULL,
	[MatriculaFuncAut] [varchar](20) NULL,
	[NomeFuncAut] [varchar](300) NULL,
	[NomeDepartamentoAut] [varchar](200) NULL,
	[IdMot] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[ProdutosAV] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REQUISICAO_AVULSA_PRODUTOS_NUTRI]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REQUISICAO_AVULSA_PRODUTOS_NUTRI](
	[IdReq] [int] IDENTITY(1,1) NOT NULL,
	[StatusReq] [varchar](20) NULL,
	[DataReq] [datetime] NULL,
	[IdLocal] [int] NOT NULL,
	[IdFunc] [int] NOT NULL,
	[IdFuncAut] [int] NULL,
	[MatriculaFuncAut] [varchar](20) NULL,
	[NomeFuncAut] [varchar](300) NULL,
	[NomeDepartamentoAut] [varchar](200) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REQUISICAO_PRODUTOS_CARDAPIO_NUTRI]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REQUISICAO_PRODUTOS_CARDAPIO_NUTRI](
	[IdReq] [int] IDENTITY(1,1) NOT NULL,
	[StatusReq] [varchar](20) NULL,
	[DataReq] [datetime] NULL,
	[IdLocal] [int] NOT NULL,
	[IdCardapio] [int] NULL,
	[IdFunc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REQUISICAO_PRODUTOS_ENFERMARIA_ENFAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REQUISICAO_PRODUTOS_ENFERMARIA_ENFAR](
	[IdSol] [int] IDENTITY(1,1) NOT NULL,
	[StatusSol] [varchar](20) NULL,
	[DataSol] [datetime] NULL,
	[IdFuncSolici] [int] NOT NULL,
	[IdFuncAprova] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REQUISICAO_PRODUTOS_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REQUISICAO_PRODUTOS_INTERNOS](
	[IdReq] [int] IDENTITY(1,1) NOT NULL,
	[StatusReq] [varchar](20) NULL,
	[DataReq] [datetime] NULL,
	[IdLocal] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdReqUser] [int] NULL,
	[DescricaoPavilhao] [varchar](200) NULL,
	[DescricaoCela] [varchar](200) NULL,
	[IdFunc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REQUISICAO_PRODUTOS_INTERNOS_ENF]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REQUISICAO_PRODUTOS_INTERNOS_ENF](
	[IdReq] [int] IDENTITY(1,1) NOT NULL,
	[StatusReq] [varchar](20) NULL,
	[StatusReqAtend] [varchar](20) NULL,
	[DataReq] [datetime] NULL,
	[IdLocal] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdItem] [int] NOT NULL,
	[IdPres] [int] NULL,
	[DescricaoPavilhao] [varchar](200) NULL,
	[DescricaoCela] [varchar](200) NULL,
	[IdFunc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REQUISICAO_PRODUTOS_INTERNOS_SEAC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REQUISICAO_PRODUTOS_INTERNOS_SEAC](
	[IdReq] [int] IDENTITY(1,1) NOT NULL,
	[StatusReq] [varchar](20) NULL,
	[DataReq] [datetime] NULL,
	[IdLocal] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DescricaoPavilhao] [varchar](200) NULL,
	[DescricaoCela] [varchar](200) NULL,
	[IdFunc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REQUISICAO_PRODUTOS_NUTRI]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REQUISICAO_PRODUTOS_NUTRI](
	[IdReq] [int] IDENTITY(1,1) NOT NULL,
	[StatusReq] [varchar](20) NULL,
	[DataReq] [datetime] NULL,
	[IdLocal] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdReqUser] [int] NULL,
	[DescricaoPavilhao] [varchar](200) NULL,
	[DescricaoCela] [varchar](200) NULL,
	[IdFunc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[RESENHA_REMICAO_INTERNO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[RESENHA_REMICAO_INTERNO](
	[IdResenha] [int] IDENTITY(1,1) NOT NULL,
	[StatusResenha] [varchar](20) NULL,
	[DataResenha] [datetime] NULL,
	[IdLivro] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdFunc] [int] NOT NULL,
	[ResenhaEntregue] [varchar](30) NULL,
	[DataEntraga] [datetime] NULL,
	[NrResenha] [int] NULL,
	[ValidacaoResenha] [real] NULL,
	[Paragrafo] [real] NULL,
	[Margens] [real] NULL,
	[Legivel] [real] NULL,
	[Rasuras] [real] NULL,
	[Compreensao] [real] NULL,
	[Compatibilidade] [real] NULL,
	[Tema] [real] NULL,
	[Fidedignidade] [varchar](max) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdResenha] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[RESERVA_ACERVO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[RESERVA_ACERVO](
	[IdReserva] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NOT NULL,
	[DataReserva] [date] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReserva] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[RETIRADAINTERNO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[RETIRADAINTERNO](
	[IdLancRet] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [date] NULL,
	[IdFunc] [int] NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdNatureza] [int] NOT NULL,
	[Motivo] [varchar](max) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[TipoReg] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLancRet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[RETORNOAUDIENCIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[RETORNOAUDIENCIA](
	[IdRetorno] [int] IDENTITY(1,1) NOT NULL,
	[StatusRet] [varchar](30) NULL,
	[DataLancRetorno] [datetime] NULL,
	[IdOp] [int] NOT NULL,
	[ObsRetorno] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRetorno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[RETORNOESPONTANEO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[RETORNOESPONTANEO](
	[IdRetorno] [int] IDENTITY(1,1) NOT NULL,
	[StatusRet] [varchar](30) NULL,
	[DataLancRetorno] [datetime] NULL,
	[IdOp] [int] NOT NULL,
	[ObsRetorno] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRetorno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[RETORNOMEDICO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[RETORNOMEDICO](
	[IdRetorno] [int] IDENTITY(1,1) NOT NULL,
	[StatusRet] [varchar](30) NULL,
	[DataLancRetorno] [datetime] NULL,
	[IdOp] [int] NOT NULL,
	[ObsRetorno] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRetorno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[RETORNOSCRC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[RETORNOSCRC](
	[IdRetorno] [int] IDENTITY(1,1) NOT NULL,
	[StatusRet] [varchar](30) NULL,
	[DataLancRetorno] [datetime] NULL,
	[IdOp] [int] NOT NULL,
	[ObsRetorno] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRetorno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[RETORNOTRANSFERENCIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[RETORNOTRANSFERENCIA](
	[IdRetorno] [int] IDENTITY(1,1) NOT NULL,
	[StatusRet] [varchar](30) NULL,
	[DataLancRetorno] [datetime] NULL,
	[IdOp] [int] NOT NULL,
	[ObsRetorno] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRetorno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[REVALIDAR_ATESTADO_RECLUSAO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[REVALIDAR_ATESTADO_RECLUSAO](
	[IdRevAtestado] [int] IDENTITY(1,1) NOT NULL,
	[StatusRevAtestado] [varchar](20) NULL,
	[ClassRevAtestado] [varchar](20) NULL,
	[DataRevAtestado] [datetime] NULL,
	[DataValidade] [datetime] NULL,
	[IdVisita] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdAtestado] [int] NOT NULL,
	[TextoRevAtestado] [varchar](max) NULL,
	[AssinaturaColaborador] [varbinary](max) NULL,
	[DataAssinatura] [varchar](20) NULL,
	[HoraAssinatura] [varchar](20) NULL,
	[CodigoValidador] [varbinary](max) NULL,
	[ChaveInterno] [varbinary](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRevAtestado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ROL_VISITAS_RELIGIOSA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ROL_VISITAS_RELIGIOSA](
	[IdRol] [int] IDENTITY(1,1) NOT NULL,
	[StatusRol] [varchar](30) NULL,
	[DataRol] [datetime] NULL,
	[IdCod] [int] NOT NULL,
	[Domingo] [int] NULL,
	[Segunda] [int] NULL,
	[Terca] [int] NULL,
	[Quarta] [int] NULL,
	[Quinta] [int] NULL,
	[Sexta] [int] NULL,
	[Sabado] [int] NULL,
	[ObsRol] [varchar](max) NULL,
	[ObsPortaria] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ROLVISITAS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ROLVISITAS](
	[IdRol] [int] IDENTITY(1,1) NOT NULL,
	[DataRol] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[StatusRol] [varchar](30) NULL,
	[ObsRol] [varchar](max) NULL,
	[ObsPortaria] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SAIDACRC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SAIDACRC](
	[IdSaida] [int] IDENTITY(1,1) NOT NULL,
	[StatusSai] [varchar](30) NULL,
	[DatalancaMov] [datetime] NULL,
	[IdOp] [int] NOT NULL,
	[ObsSaida] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSaida] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SAIDAOBJETOSPERTENCES]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SAIDAOBJETOSPERTENCES](
	[IdSaida] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](10) NULL,
	[DataLanc] [date] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSaida] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SALAS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SALAS](
	[IdSala] [int] IDENTITY(1,1) NOT NULL,
	[StatusSala] [varchar](200) NULL,
	[DataCad] [datetime] NULL,
	[Descricao] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSala] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SALDO_ESTOQUE_AC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SALDO_ESTOQUE_AC](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdProd] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[DataEstoque] [date] NULL,
	[Lote] [varchar](200) NULL,
	[EstoqueMaximo] [float] NULL,
	[EstoqueMinimo] [float] NULL,
	[PontoPedido] [float] NULL,
	[SaldoAtual] [float] NULL,
	[InvEstoque] [varchar](1) NULL,
	[QtdReserva] [float] NULL,
	[Modulo] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SALDO_VALORES_INATIVOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SALDO_VALORES_INATIVOS](
	[IdSaldoAtual] [int] IDENTITY(1,1) NOT NULL,
	[DataMov] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdDoc] [int] NULL,
	[Historico] [varchar](250) NULL,
	[FavorecidoDepositante] [varchar](300) NULL,
	[TipoMov] [varchar](1) NULL,
	[ValorMov] [money] NULL,
	[SaldoAtual] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSaldoAtual] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SALDOVALORES]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SALDOVALORES](
	[IdMov] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdLanc] [int] NULL,
	[Historico] [varchar](250) NULL,
	[FavorecidoDepositante] [varchar](300) NULL,
	[DataMov] [datetime] NULL,
	[ValorMov] [money] NULL,
	[StatusMov] [varchar](2) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdMov] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SAQUE]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SAQUE](
	[IdSaq] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[ValorSaque] [money] NULL,
	[Favorecido] [varchar](200) NULL,
	[ReciboSaque] [varchar](max) NULL,
	[Observacao] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSaq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SAQUE_INATIVOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SAQUE_INATIVOS](
	[IdSaqIna] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[ValorSaque] [money] NULL,
	[Favorecido] [varchar](200) NULL,
	[ReciboSaque] [varchar](max) NULL,
	[Observacao] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSaqIna] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SENTENCAS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SENTENCAS](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[DocMudaRegime] [int] NULL,
	[MudancaRegime] [varchar](10) NULL,
	[DataLanc] [date] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DataEntrada] [date] NULL,
	[IdUnid] [int] NOT NULL,
	[DataCrime] [date] NULL,
	[DataPrisao] [date] NULL,
	[DataCondenacao] [date] NULL,
	[Participacao] [varchar](50) NULL,
	[Regime] [varchar](50) NULL,
	[Pena] [varchar](20) NULL,
	[Artigo1] [varchar](20) NULL,
	[Artigo2] [varchar](20) NULL,
	[Artigo3] [varchar](20) NULL,
	[Paragrafo1] [varchar](20) NULL,
	[Paragrafo2] [varchar](20) NULL,
	[Paragrafo3] [varchar](20) NULL,
	[CrimeHediondo] [varchar](3) NULL,
	[TerminoPena] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SINALIZATECNICO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SINALIZATECNICO](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[DataEmissao] [varchar](20) NULL,
	[IdInternoCrc] [int] NOT NULL,
	[UsuarioEmitente] [varchar](200) NULL,
	[DeptoEmitente] [varchar](300) NULL,
	[Utilizado] [varchar](3) NULL,
	[DataUtilizacao] [varchar](20) NULL,
	[DeptoUtilizado] [varchar](300) NULL,
	[UsuarioUtilizador] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SOCIAL1_PAI_PSICOSOCIAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SOCIAL1_PAI_PSICOSOCIAL](
	[IdPaiSS1] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[DocumentoCivil] [varchar](3) NULL,
	[CNascimento] [varchar](3) NULL,
	[RG] [varchar](3) NULL,
	[CPF] [varchar](3) NULL,
	[CTPS] [varchar](3) NULL,
	[OutrosDoc] [varchar](100) NULL,
	[QtdFilhosMaior] [int] NULL,
	[FilhosSemRegistros] [varchar](3) NULL,
	[QtdFilhosSemRegistro] [int] NULL,
	[QtdFilhosMenor] [int] NULL,
	[ObservacaoFilhos] [varchar](100) NULL,
	[VulnerabilidaSocial] [varchar](3) NULL,
	[AtendePrevistas] [varchar](3) NULL,
	[InseriProgramaSocial] [varchar](10) NULL,
	[QualProgramaSocial] [varchar](100) NULL,
	[PartFamiliaCumpre] [int] NULL,
	[IntervencaoPrograma] [varchar](3) NULL,
	[LocalizacaoFamiliares] [varchar](40) NULL,
	[ObservacaoParticipacaoFamilia] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPaiSS1] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SOCIAL2_FAMILIAR_PSICOSOCIAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SOCIAL2_FAMILIAR_PSICOSOCIAL](
	[IdSol2Visita] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdVisita] [int] NOT NULL,
	[Ocupacao] [varchar](100) NULL,
	[Idade] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSol2Visita] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SOCIAL2_PAI_PSICOSOCIAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SOCIAL2_PAI_PSICOSOCIAL](
	[IdFamiliar] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[NomeFamiliar] [varchar](250) NULL,
	[Vinculo] [varchar](100) NULL,
	[Idade] [int] NULL,
	[Ocupacao] [varchar](100) NULL,
	[Endereco] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFamiliar] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SOCIAL2_VISITA_INTIMA_PSICOSOCIAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SOCIAL2_VISITA_INTIMA_PSICOSOCIAL](
	[IdSol2Visita] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdVisita] [int] NOT NULL,
	[Ocupacao] [varchar](100) NULL,
	[Idade] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSol2Visita] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SOCIALIZACAO_ADMISSAO_PEDAGOGIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SOCIALIZACAO_ADMISSAO_PEDAGOGIA](
	[IdSocial] [int] IDENTITY(1,1) NOT NULL,
	[IdAdm] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[AmigosFacilidade] [varchar](200) NULL,
	[Introvertido] [int] NULL,
	[Afetuoso] [int] NULL,
	[Obediente] [int] NULL,
	[Resistente] [int] NULL,
	[Cooperador] [int] NULL,
	[Medroso] [int] NULL,
	[Inseguro] [int] NULL,
	[Outros] [int] NULL,
	[QualOutros] [varchar](80) NULL,
	[IdadeEscolar] [int] NULL,
	[FamiliarPresente] [varchar](7) NULL,
	[Adaptacao] [varchar](200) NULL,
	[Repetencias] [varchar](200) NULL,
	[Antecedentes] [varchar](7) NULL,
	[QualProblemaAprendizado] [varchar](max) NULL,
	[ObservacaoSocializacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSocial] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SOCIALIZACAO_ADMISSAO_PEDAGOGIA_NOVA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SOCIALIZACAO_ADMISSAO_PEDAGOGIA_NOVA](
	[IdSocialNova] [int] IDENTITY(1,1) NOT NULL,
	[IdAdmNova] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[AmigosFacilidade] [varchar](200) NULL,
	[Introvertido] [int] NULL,
	[Afetuoso] [int] NULL,
	[Obediente] [int] NULL,
	[Resistente] [int] NULL,
	[Cooperador] [int] NULL,
	[Medroso] [int] NULL,
	[Inseguro] [int] NULL,
	[Outros] [int] NULL,
	[QualOutros] [varchar](80) NULL,
	[IdadeEscolar] [int] NULL,
	[FamiliarPresente] [varchar](7) NULL,
	[Adaptacao] [varchar](200) NULL,
	[Repetencias] [varchar](200) NULL,
	[Antecedentes] [varchar](7) NULL,
	[QualProblemaAprendizado] [varchar](max) NULL,
	[ObservacaoSocializacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSocialNova] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SOLICITACAO_ATESTADO_RECLUSAO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SOLICITACAO_ATESTADO_RECLUSAO](
	[CodRegAux] [int] IDENTITY(1,1) NOT NULL,
	[StatusAux] [varchar](20) NULL,
	[DataRegAux] [datetime] NULL,
	[Finalidade] [varchar](30) NULL,
	[DataPedAux] [datetime] NULL,
	[DataPrevAux] [datetime] NULL,
	[IdVisita] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[MotivoAux] [varchar](max) NULL,
	[AssinaturaVisita] [varbinary](max) NULL,
	[DataAssinaturaVisita] [datetime] NULL,
	[HoraAssinaturaVisita] [varchar](30) NULL,
	[AssinaturaInterno] [varbinary](max) NULL,
	[DataAssinaturaInterno] [datetime] NULL,
	[HoraAssinaturaInterno] [varchar](30) NULL,
	[UtilizadoCrc] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[CodRegAux] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SOLICITACAO_ATESTADO_RECLUSAO_CRC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SOLICITACAO_ATESTADO_RECLUSAO_CRC](
	[CodRegAux] [int] IDENTITY(1,1) NOT NULL,
	[StatusAux] [varchar](20) NULL,
	[DataRegAux] [datetime] NULL,
	[Finalidade] [varchar](30) NULL,
	[DataPedAux] [datetime] NULL,
	[DataPrevAux] [datetime] NULL,
	[IdVisita] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[MotivoAux] [varchar](max) NULL,
	[UtilizadoCrc] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[CodRegAux] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO](
	[IdSolExame] [int] IDENTITY(1,1) NOT NULL,
	[StatusSolExame] [varchar](10) NULL,
	[DataSolExame] [datetime] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[NomeSolicitante] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSolExame] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SOLICITACAO_PRODUTOS_ADM]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SOLICITACAO_PRODUTOS_ADM](
	[IdSol] [int] IDENTITY(1,1) NOT NULL,
	[StatusSol] [varchar](20) NULL,
	[Situacao] [varchar](30) NULL,
	[DataSol] [datetime] NULL,
	[IdFunc] [int] NOT NULL,
	[IdFuncAprova] [int] NOT NULL,
	[IdLocal] [int] NOT NULL,
	[TipoValor] [int] NULL,
	[Modulo] [varchar](3) NULL,
	[ValorAprovado] [money] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SOLICITANTE_REQUISICAO_MEDICAMENTOS_ENFAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SOLICITANTE_REQUISICAO_MEDICAMENTOS_ENFAR](
	[IdFuncSolici] [int] IDENTITY(1,1) NOT NULL,
	[FotoFuncSolici] [varchar](300) NULL,
	[StatusSolici] [varchar](20) NULL,
	[NomeSolicitante] [varchar](300) NULL,
	[Matricula] [varchar](100) NULL,
	[Cargo] [varchar](200) NULL,
	[IdDepartamento] [int] NOT NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFuncSolici] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SOLICITANTES_COMPRAS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SOLICITANTES_COMPRAS](
	[IdSoli] [int] IDENTITY(1,1) NOT NULL,
	[StatusSoli] [varchar](20) NULL,
	[DataSoli] [datetime] NOT NULL,
	[IdDepartamento] [int] NOT NULL,
	[TipoValor] [int] NOT NULL,
	[ValorMax] [money] NULL,
	[ValorGAC] [money] NULL,
	[DataInicial] [datetime] NULL,
	[DataFinal] [datetime] NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSoli] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SS3_PAI_PSICOSOCIAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SS3_PAI_PSICOSOCIAL](
	[IdSS3] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TextoCEDEGEP] [varchar](max) NULL,
	[TextoCRASCREAS] [varchar](max) NULL,
	[TextoASSISTENCIA] [varchar](max) NULL,
	[TextoDOCUMENTOCIVIL] [varchar](max) NULL,
	[DataInclusaoPAI] [datetime] NULL,
	[TecnicoServicoSocial] [varchar](200) NULL,
	[TecnicoPsicologico] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSS3] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[STATUS_INTERNO_PSICOLOGIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[STATUS_INTERNO_PSICOLOGIA](
	[IdSE] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[StatusAtendimento] [varchar](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TAREFASDIVERSAS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TAREFASDIVERSAS](
	[IdTarefa] [int] IDENTITY(1,1) NOT NULL,
	[StatusTarefa] [varchar](20) NULL,
	[DataTarefa] [datetime] NULL,
	[DescricaoTarefa] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTarefa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TELAS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TELAS](
	[IdTelas] [int] IDENTITY(1,1) NOT NULL,
	[IdModulo] [int] NOT NULL,
	[NomeTela] [varchar](600) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTelas] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TELAS_ACESSO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TELAS_ACESSO](
	[IdTela] [int] IDENTITY(1,1) NOT NULL,
	[IdUsuario] [int] NULL,
	[NomeTela] [varchar](500) NOT NULL,
	[Abrir] [int] NULL,
	[Incluir] [int] NULL,
	[Alterar] [int] NULL,
	[Excluir] [int] NULL,
	[Gravar] [int] NULL,
	[Consultar] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[NomeModulo] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTela] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TEMPOFORMATIVO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TEMPOFORMATIVO](
	[IdTempo] [int] IDENTITY(1,1) NOT NULL,
	[StatusTempo] [varchar](20) NULL,
	[DataCad] [datetime] NULL,
	[DescricaoTempo] [varchar](300) NULL,
	[IdTurno] [int] NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[GrauInstrucaoEquivalente] [varchar](60) NULL,
	[Eixo] [varchar](60) NULL,
	[Duracao] [real] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTempo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TERAPIA_PEDAGOGIA_PSICOSOCIAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TERAPIA_PEDAGOGIA_PSICOSOCIAL](
	[IdToPed] [int] IDENTITY(1,1) NOT NULL,
	[IdPai] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Escolaridade] [varchar](200) NULL,
	[DemandaEscolar] [varchar](3) NULL,
	[FrequnetaEscola] [varchar](3) NULL,
	[QualEscola] [varchar](300) NULL,
	[Instrucao] [int] NULL,
	[ObservacaoTOPED] [varchar](300) NULL,
	[Profissao] [varchar](300) NULL,
	[ParticipaLabor] [varchar](3) NULL,
	[QualLabor] [varchar](300) NULL,
	[ObservacaoLabor] [varchar](300) NULL,
	[DemandaQualiProf] [varchar](3) NULL,
	[QualDemanda] [varchar](120) NULL,
	[ExperienciaTrabRenda] [varchar](3) NULL,
	[QualExperiencia] [varchar](80) NULL,
	[Habilidades] [varchar](250) NULL,
	[ParticipaAtividade] [varchar](3) NULL,
	[QuaisAtividades] [varchar](250) NULL,
	[DemandaParticaCultura] [varchar](3) NULL,
	[Esportte] [varchar](3) NULL,
	[QualEsporte] [varchar](80) NULL,
	[Lazer] [varchar](3) NULL,
	[QualLazer] [varchar](80) NULL,
	[Cultura] [varchar](3) NULL,
	[QualCultura] [varchar](150) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdToPed] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TIPOS_EXAMES_MEDICO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TIPOS_EXAMES_MEDICO](
	[IdExame] [int] IDENTITY(1,1) NOT NULL,
	[StatusExame] [varchar](10) NULL,
	[Classificacao] [varchar](50) NULL,
	[DescricaoExame] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdExame] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TIPOS_TRATAMENTO_PSICOLOGICO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TIPOS_TRATAMENTO_PSICOLOGICO](
	[IdTipo] [int] IDENTITY(1,1) NOT NULL,
	[StatusTipo] [varchar](7) NULL,
	[DataTipo] [datetime] NULL,
	[DescricaoTipo] [varchar](300) NULL,
	[Texto] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTipo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TIPOS_TRATAMENTOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TIPOS_TRATAMENTOS](
	[IdTipo] [int] IDENTITY(1,1) NOT NULL,
	[DescricaoTipo] [varchar](150) NULL,
	[StatusTipo] [varchar](30) NULL,
	[DataTipo] [datetime] NULL,
	[ObservacaoTipo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTipo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TIPOS_VACINAS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TIPOS_VACINAS](
	[IdVacina] [int] IDENTITY(1,1) NOT NULL,
	[StatusVacina] [varchar](10) NULL,
	[Classificacao] [varchar](50) NULL,
	[DescricaoVacina] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVacina] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TO_HISTORICO_EDUCACIONAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TO_HISTORICO_EDUCACIONAL](
	[IdHistoricoEdu] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[EscreveProprioNome] [varchar](3) NULL,
	[SabeLerEscrever] [varchar](3) NULL,
	[NivelInstrucao] [varchar](30) NULL,
	[InteresseEstudar] [varchar](3) NULL,
	[CursoProfissionalizante] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHistoricoEdu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TO_HISTORICO_EDUCACIONAL_NOVO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TO_HISTORICO_EDUCACIONAL_NOVO](
	[IdHistoricoEduN] [int] IDENTITY(1,1) NOT NULL,
	[IdATN] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[EscreveProprioNome] [varchar](3) NULL,
	[SabeLerEscrever] [varchar](3) NULL,
	[NivelInstrucao] [varchar](30) NULL,
	[InteresseEstudar] [varchar](3) NULL,
	[CursoProfissionalizante] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHistoricoEduN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TO_HISTORICO_PROFISSIONAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TO_HISTORICO_PROFISSIONAL](
	[IdHistoricoLab] [int] IDENTITY(1,1) NOT NULL,
	[IdLanc] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TemProfissao] [varchar](3) NULL,
	[QualProfissao] [varchar](200) NULL,
	[ExperienciaProfissional] [varchar](3) NULL,
	[QualExperienciaProfissional] [varchar](200) NULL,
	[DesejaTrabalharUnid] [varchar](3) NULL,
	[InteresseLabor] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHistoricoLab] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TO_HISTORICO_PROFISSIONAL_NOVO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TO_HISTORICO_PROFISSIONAL_NOVO](
	[IdHistoricoLabPN] [int] IDENTITY(1,1) NOT NULL,
	[IdATN] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TemProfissao] [varchar](3) NULL,
	[QualProfissao] [varchar](200) NULL,
	[ExperienciaProfissional] [varchar](3) NULL,
	[QualExperienciaProfissional] [varchar](200) NULL,
	[DesejaTrabalharUnid] [varchar](3) NULL,
	[InteresseLabor] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHistoricoLabPN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TRANSFERENCIA_INTERNOS_PORTARIAS_UNIDADES]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TRANSFERENCIA_INTERNOS_PORTARIAS_UNIDADES](
	[IdTransPortUni] [int] IDENTITY(1,1) NOT NULL,
	[Cnc] [varchar](100) NULL,
	[Matricula] [varchar](100) NULL,
	[NomeInterno] [varchar](250) NULL,
	[DataExp] [datetime] NULL,
	[HoraSaida] [varchar](20) NULL,
	[Documento] [varchar](100) NULL,
	[UnidadeOrigem] [varchar](300) NULL,
	[UnidadeDestino] [varchar](300) NULL,
	[ConfirmadoExp] [varchar](3) NULL,
	[ConfirmadoImp] [varchar](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTransPortUni] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TRANSFERENCIA_PRODUTO_FAR]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TRANSFERENCIA_PRODUTO_FAR](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdLocal] [int] NOT NULL,
	[IdFunc] [int] NOT NULL,
	[IdReqEnf] [int] NULL,
	[IdLocalDst] [int] NULL,
	[DescricaoLocalDestino] [varchar](200) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TRANSFERENCIA_VALORES_INATIVOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TRANSFERENCIA_VALORES_INATIVOS](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[TipoTransferencia] [varchar](20) NULL,
	[SaldoContaAtiva] [money] NULL,
	[ValorTransferido] [money] NULL,
	[Motivo] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TRANSFERENCIACRC]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TRANSFERENCIACRC](
	[IdTransf] [int] IDENTITY(1,1) NOT NULL,
	[StatusTran] [varchar](30) NULL,
	[DataLancTransf] [datetime] NULL,
	[IdOp] [int] NOT NULL,
	[ObsTransf] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTransf] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TRANSFERENCIALOCAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TRANSFERENCIALOCAL](
	[IdLanc] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdCela] [int] NOT NULL,
	[DescricaoCelaOrigem] [varchar](200) NULL,
	[DescricaoPavilhaoOrigem] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLanc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TRANSIENTES]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TRANSIENTES](
	[IdTrans] [int] IDENTITY(1,1) NOT NULL,
	[StatusTrans] [varchar](20) NULL,
	[DataTrans] [datetime] NULL,
	[Observacao] [varchar](100) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTrans] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TRATAMENTO_PSICOLOGICO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TRATAMENTO_PSICOLOGICO](
	[IdTRAT] [int] IDENTITY(1,1) NOT NULL,
	[StatusTrat] [varchar](15) NULL,
	[DataTrat] [datetime] NULL,
	[IdTipo] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[ID_REGISTRO_ATEND_EVOL] [int] NOT NULL,
	[DataInicio] [datetime] NULL,
	[DataTermino] [datetime] NULL,
	[TextoTratamento] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTRAT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TRIAGEM_OCUPACIONAL]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TRIAGEM_OCUPACIONAL](
	[IdTriagem] [int] IDENTITY(1,1) NOT NULL,
	[StatusLanc] [varchar](20) NULL,
	[DataLanc] [datetime] NULL,
	[IdInternoCrc] [int] NOT NULL,
	[JaTrabalho] [varchar](3) NULL,
	[OndeTrabalhou] [varchar](200) NULL,
	[InteresseUnidade] [varchar](3) NULL,
	[QualTipoAtividade] [varchar](200) NULL,
	[VisitasFinaisSemana] [varchar](3) NULL,
	[Observacao] [varchar](max) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTriagem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TURNOSAULA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TURNOSAULA](
	[IdTurno] [int] IDENTITY(1,1) NOT NULL,
	[StatusTurno] [varchar](30) NULL,
	[DataCad] [datetime] NULL,
	[DescricaoTurno] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTurno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[UNIDADE]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[UNIDADE](
	[IdUnid] [int] IDENTITY(1,1) NOT NULL,
	[DescricaoUnid] [varchar](250) NOT NULL,
	[ClassUnid] [varchar](20) NULL,
	[EnderecoUnid] [varchar](300) NULL,
	[BairroUnid] [varchar](150) NULL,
	[ComplementoUnid] [varchar](100) NULL,
	[CepUnid] [varchar](20) NULL,
	[CidadeUnid] [varchar](250) NULL,
	[EstadoUnid] [varchar](100) NULL,
	[TelefoneUnid] [varchar](20) NULL,
	[FoneUnid] [varchar](20) NULL,
	[FaxUnid] [varchar](20) NULL,
	[ObsUnid] [varchar](250) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdUnid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[UNIDADE_PENAL_EMPRESA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[UNIDADE_PENAL_EMPRESA](
	[IdUnidEmp] [int] IDENTITY(1,1) NOT NULL,
	[IdEmpresa] [int] NOT NULL,
	[DescricaoUnidade] [varchar](300) NULL,
	[Endereco] [varchar](300) NULL,
	[Bairro] [varchar](100) NULL,
	[Cidade] [varchar](250) NULL,
	[Estado] [varchar](15) NULL,
	[Regime] [varchar](150) NULL,
	[CapacidadeMas] [int] NULL,
	[CapacidadeFen] [int] NULL,
	[CapacidadeTotal] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdUnidEmp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[USERCONECTADOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[USERCONECTADOS](
	[IdUser] [int] IDENTITY(1,1) NOT NULL,
	[DataPlugado] [varchar](20) NULL,
	[HorarioPlugado] [varchar](20) NULL,
	[DataDesconectado] [varchar](20) NULL,
	[HorarioDesconectado] [varchar](20) NULL,
	[NomeUsuario] [varchar](300) NULL,
	[ConectadoDesconectado] [varchar](20) NULL,
	[HostName] [varchar](200) NULL,
	[IpHost] [varchar](200) NULL,
	[StatusFlag] [varchar](10) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[USUARIOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[USUARIOS](
	[IdUsuario] [int] IDENTITY(1,1) NOT NULL,
	[StatusUsuario] [tinyint] NOT NULL,
	[NomeDepartamento] [varchar](300) NULL,
	[NomeCargo] [varchar](300) NULL,
	[NomeUsuario] [varchar](50) NOT NULL,
	[DataCadastro] [datetime] NULL,
	[LoginUsuario] [varchar](20) NOT NULL,
	[SenhaUsuario] [varchar](20) NOT NULL,
	[ConfirmaSenhaUsuario] [varchar](20) NOT NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[AcessoTodasUnidades] [varchar](12) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[USUARIOS_GRUPOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USUARIOS_GRUPOS](
	[IdUserGroup] [int] IDENTITY(1,1) NOT NULL,
	[IdUsuario] [int] NOT NULL,
	[IdGrupo] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdUserGroup] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[USUARIOS_MODULOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[USUARIOS_MODULOS](
	[IdMod] [int] IDENTITY(1,1) NOT NULL,
	[IdUsuario] [int] NOT NULL,
	[IdGrupo] [int] NOT NULL,
	[IdModulo] [int] NOT NULL,
	[Permissao] [varchar](3) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdMod] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[VEICULOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[VEICULOS](
	[IdVeiculo] [int] IDENTITY(1,1) NOT NULL,
	[DataCadastro] [datetime] NULL,
	[NomeVeiculo] [varchar](200) NULL,
	[PlacaVeiculo] [varchar](30) NULL,
	[ModeloVeiculo] [varchar](200) NULL,
	[MarcaVEiculo] [varchar](200) NULL,
	[CidadeVeiculo] [varchar](200) NULL,
	[EstadoVeiculo] [varchar](200) NULL,
	[FotoFrente] [varchar](200) NULL,
	[FotoLadoDireito] [varchar](200) NULL,
	[FotoLadoEsquerdo] [varchar](200) NULL,
	[FotoFundo] [varchar](200) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[StatusVei] [varchar](100) NULL,
	[ImagemFrenteVE] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVeiculo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[VERIFICA_DOCUMENTOS_VISITA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[VERIFICA_DOCUMENTOS_VISITA](
	[IdVerDoc] [int] IDENTITY(1,1) NOT NULL,
	[IdVisita] [int] NOT NULL,
	[Ident] [int] NULL,
	[DFoto] [int] NULL,
	[Ant] [int] NULL,
	[Comp] [int] NULL,
	[Decla] [int] NULL,
	[Autori] [int] NULL,
	[Responsavel] [varchar](150) NULL,
	[Justificativa] [varchar](max) NULL,
	[Aprova] [varchar](3) NULL,
	[Ates] [int] NULL,
	[VisApr] [int] NULL,
	[VisRep] [int] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[IdInternoCrc] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVerDoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS](
	[IdEntraSaida] [int] IDENTITY(1,1) NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[IdSaida] [int] NULL,
	[DocSaida] [varchar](100) NULL,
	[DataSaida] [datetime] NULL,
	[HoraSaida] [varchar](10) NULL,
	[TipoSaida] [varchar](200) NULL,
	[IdRetorno] [int] NULL,
	[DocEntrada] [varchar](100) NULL,
	[DataEntrada] [datetime] NULL,
	[HoraEntrada] [varchar](10) NULL,
	[RetPort] [varchar](3) NULL,
	[RetCrc] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[RegistroCancelado] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEntraSaida] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[VISITAS_INTERNAS_OCORRENCIA_PORTARIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[VISITAS_INTERNAS_OCORRENCIA_PORTARIA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdReg] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[StatusVisitaRol] [varchar](30) NULL,
	[BloqLib] [int] NULL,
	[TipoBloq] [int] NULL,
	[DataBloq] [date] NULL,
	[DataBloq1] [date] NULL,
	[DataLib] [date] NULL,
	[DataAprovaSocial] [date] NULL,
	[Confirmar] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[VISITAS_OCORRENCIA_PORTARIA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[VISITAS_OCORRENCIA_PORTARIA](
	[IdItem] [int] IDENTITY(1,1) NOT NULL,
	[IdReg] [int] NOT NULL,
	[IdVisita] [int] NOT NULL,
	[StatusVisitaRol] [varchar](30) NULL,
	[BloqLib] [int] NULL,
	[TipoBloq] [int] NULL,
	[DataBloq] [date] NULL,
	[DataBloq1] [date] NULL,
	[DataLib] [date] NULL,
	[DataAprovaSocial] [date] NULL,
	[Confirmar] [varchar](3) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[VISITAS_OFICIAL_JUSTICA]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[VISITAS_OFICIAL_JUSTICA](
	[IdVisita] [int] IDENTITY(1,1) NOT NULL,
	[IdOficial] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Idlanc] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVisita] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[VISITAS_RELIGIOSA_INTERNOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[VISITAS_RELIGIOSA_INTERNOS](
	[IdVisitaRel] [int] IDENTITY(1,1) NOT NULL,
	[StatusVisitaRel] [varchar](100) NULL,
	[ImagemVisitaRel] [varchar](350) NULL,
	[NomeVisitaRel] [varchar](300) NULL,
	[ReligiaoVisitaRel] [varchar](250) NULL,
	[DataNascRel] [datetime] NULL,
	[SexoVisitaRel] [varchar](100) NULL,
	[DataCadVisitaRel] [datetime] NULL,
	[ClassificacaoRel] [varchar](15) NULL,
	[EnderecoVisitaRel] [varchar](300) NULL,
	[BairroVisitaRel] [varchar](200) NULL,
	[CidadeVisitaRel] [varchar](250) NULL,
	[CepVisitaRel] [varchar](20) NULL,
	[EstadoVisitaRel] [varchar](150) NULL,
	[TelefoneVisitaRel] [varchar](20) NULL,
	[Telefone1VisitaRel] [varchar](20) NULL,
	[CelularVisitaRel] [varchar](20) NULL,
	[Celular1VisitaRel] [varchar](20) NULL,
	[RgVisitaRel] [varchar](20) NULL,
	[EmissorVisitaRel] [varchar](30) NULL,
	[CpfVisitaRel] [varchar](20) NULL,
	[DataValiAnteRel] [datetime] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[ImagemFrenteVR] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVisitaRel] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[VISITASADVOGADOS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[VISITASADVOGADOS](
	[IdVisita] [int] IDENTITY(1,1) NOT NULL,
	[IdAdvogado] [int] NOT NULL,
	[IdInternoCrc] [int] NOT NULL,
	[Idlanc] [int] NOT NULL,
	[DataEntrada] [datetime] NULL,
	[HorarioEntrada] [varchar](20) NULL,
	[DataSaida] [datetime] NULL,
	[HorarioSaida] [varchar](20) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVisita] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[VISITASDIVERSAS]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[VISITASDIVERSAS](
	[IdVisita] [int] IDENTITY(1,1) NOT NULL,
	[DataCadastro] [datetime] NULL,
	[FotoVisita] [varchar](350) NULL,
	[NomeVisita] [varchar](300) NULL,
	[RgVisita] [varchar](20) NULL,
	[CpfVisita] [varchar](20) NULL,
	[CnhVisita] [varchar](80) NULL,
	[ClasseVisita] [varchar](80) NULL,
	[ObsVisita] [varchar](300) NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[TipoVisita] [varchar](60) NULL,
	[ImagemFrenteVD] [varbinary](max) NULL,
	[NomeMae] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVisita] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[VISITASINTERNO]    Script Date: 01/06/2020 08:41:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[VISITASINTERNO](
	[IdVisita] [int] IDENTITY(1,1) NOT NULL,
	[StatusVisita] [varchar](100) NULL,
	[ImagemVisita] [varchar](350) NULL,
	[NomeVisita] [varchar](300) NULL,
	[ParentescoVisita] [varchar](250) NULL,
	[DataNasc] [datetime] NULL,
	[SexoVisita] [varchar](100) NULL,
	[DataCadVisita] [datetime] NULL,
	[Classificacao] [varchar](15) NULL,
	[EnderecoVisita] [varchar](300) NULL,
	[BairroVisita] [varchar](200) NULL,
	[CidadeVisita] [varchar](250) NULL,
	[CepVisita] [varchar](20) NULL,
	[EstadoVisita] [varchar](150) NULL,
	[TelefoneVisita] [varchar](20) NULL,
	[Telefone1Visita] [varchar](20) NULL,
	[CelularVisita] [varchar](20) NULL,
	[Celular1Visita] [varchar](20) NULL,
	[RgVisita] [varchar](20) NULL,
	[EmissorVisita] [varchar](30) NULL,
	[CpfVisita] [varchar](20) NULL,
	[DataValiAnte] [datetime] NULL,
	[UsuarioInsert] [varchar](50) NULL,
	[UsuarioUp] [varchar](50) NULL,
	[UsuarioDelete] [varchar](50) NULL,
	[DataInsert] [varchar](20) NULL,
	[DataUp] [varchar](20) NULL,
	[DataDelete] [varchar](20) NULL,
	[HorarioInsert] [varchar](10) NULL,
	[HorarioUp] [varchar](10) NULL,
	[VisitaIntima] [varchar](3) NULL,
	[Nacionalidade] [varchar](200) NULL,
	[DataEmissao] [datetime] NULL,
	[BiometriaDedo1] [varbinary](max) NULL,
	[BiometriaDedo2] [varbinary](max) NULL,
	[BiometriaDedo3] [varbinary](max) NULL,
	[BiometriaDedo4] [varbinary](max) NULL,
	[ImagemFrenteVI] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVisita] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[ACOMPANHAMENTO_INTERNO_ENFERMARIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ACOMPANHAMENTO_INTERNO_ENFERMARIA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOENFERMEIRA] ([IdLanc])
GO
ALTER TABLE [dbo].[ACUMULADOR_REMICAO_INTERNO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ACUMULADOR_REMICAO_INTERNO]  WITH CHECK ADD FOREIGN KEY([IdResenha])
REFERENCES [dbo].[RESENHA_REMICAO_INTERNO] ([IdResenha])
GO
ALTER TABLE [dbo].[ADME_AFP1]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ADME_AFP1]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOENFERMEIRA] ([IdLanc])
GO
ALTER TABLE [dbo].[ADME_AFP2]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ADME_AFP2]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOENFERMEIRA] ([IdLanc])
GO
ALTER TABLE [dbo].[ADME_AFP3]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ADME_AFP3]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOENFERMEIRA] ([IdLanc])
GO
ALTER TABLE [dbo].[ADME_AFP4]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ADME_AFP4]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOENFERMEIRA] ([IdLanc])
GO
ALTER TABLE [dbo].[ADMISSAO_EDUCACAO_FISICA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ADMISSAO_EDUCACAO_FISICA_NOVA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ADMISSAO_EDUCACAO_FISICA_NOVA]  WITH CHECK ADD FOREIGN KEY([IdRegistroEF])
REFERENCES [dbo].[ADMISSAO_EDUCACAO_FISICA] ([IdRegistroEF])
GO
ALTER TABLE [dbo].[ADMISSAO_ENFERMEIRA_COMPLEMENTAR]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ADMISSAO_ENFERMEIRA_COMPLEMENTAR]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOENFERMEIRA] ([IdLanc])
GO
ALTER TABLE [dbo].[ADMISSAO_JURIDICO_ADICIONAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ADMISSAO_JURIDICO_ADICIONAL]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTOJURIDICO] ([IdLanc])
GO
ALTER TABLE [dbo].[ADMISSAO_MEDICA_ADICIONAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ADMISSAO_MEDICA_ADICIONAL]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOMEDICA] ([IdLanc])
GO
ALTER TABLE [dbo].[ADMISSAO_PEDAGOGIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ADMISSAO_PEDAGOGIA_NOVA]  WITH CHECK ADD FOREIGN KEY([IdAdm])
REFERENCES [dbo].[ADMISSAO_PEDAGOGIA] ([IdAdm])
GO
ALTER TABLE [dbo].[ADMISSAO_PEDAGOGIA_NOVA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ADMISSAO_TERAPIA_PE]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ADMISSAO_TERAPIA_PE]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTOTERAPIA] ([IdLanc])
GO
ALTER TABLE [dbo].[ADMISSAOENFERMEIRA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ADMISSAOMEDICA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ADMISSAOPSI]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[AGENDALABORATIVA]  WITH CHECK ADD FOREIGN KEY([IdEmp])
REFERENCES [dbo].[EMPRESALAB] ([IdEmp])
GO
ALTER TABLE [dbo].[AGENDARECADOS]  WITH CHECK ADD FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[USUARIOS] ([IdUsuario])
GO
ALTER TABLE [dbo].[ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA]  WITH CHECK ADD FOREIGN KEY([IdAdvogado])
REFERENCES [dbo].[ADVOGADOS] ([IdAdvogado])
GO
ALTER TABLE [dbo].[ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA]  WITH CHECK ADD FOREIGN KEY([IdOficial])
REFERENCES [dbo].[OFICIAL_JUSTICA] ([IdOficial])
GO
ALTER TABLE [dbo].[ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[APOIOPROCEDIMENTO]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[APOIOPROCEDIMENTO]  WITH CHECK ADD FOREIGN KEY([IdProc])
REFERENCES [dbo].[PROCEDIMENTOS] ([IdProc])
GO
ALTER TABLE [dbo].[APRAZAMENTO_MEDICACAO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[APRENSSOES]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[APRENSSOES]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[REGISTROEVENTOS] ([IdLanc])
GO
ALTER TABLE [dbo].[APRENSSOES]  WITH CHECK ADD FOREIGN KEY([IdObjeto])
REFERENCES [dbo].[OBJETOSPROCEDIMENTOS] ([IdObjeto])
GO
ALTER TABLE [dbo].[APROVACAO_SOLICITACAO_COMPRAS_ADM]  WITH CHECK ADD FOREIGN KEY([IdSol])
REFERENCES [dbo].[SOLICITACAO_PRODUTOS_ADM] ([IdSol])
GO
ALTER TABLE [dbo].[APROVADOR_REQUISICAO_MEDICAMENTOS_ENFAR]  WITH CHECK ADD FOREIGN KEY([IdDepartamento])
REFERENCES [dbo].[DEPARTAMENTOS] ([IdDepartamento])
GO
ALTER TABLE [dbo].[APROVADOR_SOLICITACAO_COMPRAS_AC]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[APROVADORES_OCORRENCIA_PORTARIA]  WITH CHECK ADD FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[USUARIOS] ([IdUsuario])
GO
ALTER TABLE [dbo].[ASSISTENCIA_EDUCACAO_EXTERNA]  WITH CHECK ADD FOREIGN KEY([IdCod])
REFERENCES [dbo].[INSTITUICAOESCOLAR] ([IdCod])
GO
ALTER TABLE [dbo].[ASSISTENCIA_EDUCACAO_EXTERNA]  WITH CHECK ADD FOREIGN KEY([IdTurno])
REFERENCES [dbo].[TURNOSAULA] ([IdTurno])
GO
ALTER TABLE [dbo].[ATENDIMENTO_GRUPO_EF]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[ATENDIMENTO_GRUPO_ENFERMAGEM]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[ATENDIMENTO_GRUPO_PE]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[ATENDIMENTO_GRUPO_PSICOLOGIA]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[ATENDIMENTO_GRUPO_SS]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[ATENDIMENTO_GRUPO_TO]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[ATENDIMENTO_PSP_INTERNO_TV]  WITH CHECK ADD FOREIGN KEY([IdDepartamento])
REFERENCES [dbo].[DEPARTAMENTOS] ([IdDepartamento])
GO
ALTER TABLE [dbo].[ATENDIMENTO_PSP_INTERNO_TV]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ATENDIMENTO_PSP_INTERNO_TV]  WITH CHECK ADD FOREIGN KEY([IdRegistro])
REFERENCES [dbo].[REGISTRO_ATENDIMENTO_INTERNO_PSP] ([IdRegistro])
GO
ALTER TABLE [dbo].[ATENDIMENTODONTO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ATENDIMENTOFAMILIAR]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ATENDIMENTOFAMILIAR]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[ATENDIMENTOFAMILIARJURIDICO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ATENDIMENTOFAMILIARJURIDICO]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[ATENDIMENTOINTERNO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ATENDIMENTOJURIDICO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ATENDIMENTOS_ANTIGO_PSP]  WITH CHECK ADD FOREIGN KEY([IdDepartamento])
REFERENCES [dbo].[DEPARTAMENTOS] ([IdDepartamento])
GO
ALTER TABLE [dbo].[ATENDIMENTOS_ANTIGO_PSP]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ATENDIMENTOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ATENDIMENTOTECENFERMAGEM]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ATENDIMENTOTERAPIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ATESTADO_MEDICO_PSIQUIATRICO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ATESTADO_MEDICO_PSIQUIATRICO]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOMEDICA] ([IdLanc])
GO
ALTER TABLE [dbo].[ATIVIDADES_COMPLEMENTARES_PEDAGOGICA]  WITH CHECK ADD FOREIGN KEY([IdCod])
REFERENCES [dbo].[INSTITUICAOESCOLAR] ([IdCod])
GO
ALTER TABLE [dbo].[ATIVIDADES_COMPLEMENTARES_PEDAGOGICA]  WITH CHECK ADD FOREIGN KEY([IdCurso])
REFERENCES [dbo].[CURSOS] ([IdCurso])
GO
ALTER TABLE [dbo].[ATIVIDADES_COMPLEMENTARES_PEDAGOGICA]  WITH CHECK ADD FOREIGN KEY([IdProf])
REFERENCES [dbo].[PROFESSORES] ([IdProf])
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE]  WITH CHECK ADD  CONSTRAINT [FK_Colaborador] FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE] CHECK CONSTRAINT [FK_Colaborador]
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE]  WITH CHECK ADD  CONSTRAINT [FK_Unidade_Penal_Empresa] FOREIGN KEY([IdUnidEmp])
REFERENCES [dbo].[UNIDADE_PENAL_EMPRESA] ([IdUnidEmp])
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE] CHECK CONSTRAINT [FK_Unidade_Penal_Empresa]
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Alimentacao_Fornecida] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA] CHECK CONSTRAINT [FK_Atividades_Unidade_Alimentacao_Fornecida]
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_INTERNO]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Alimentacao_interno] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_INTERNO] CHECK CONSTRAINT [FK_Atividades_Alimentacao_interno]
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Assistencia_Laboral] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL] CHECK CONSTRAINT [FK_Atividades_Unidade_Assistencia_Laboral]
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Assistencia_Material] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL] CHECK CONSTRAINT [FK_Atividades_Assistencia_Material]
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Atendimento_Educacional] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL] CHECK CONSTRAINT [FK_Atividades_Unidade_Atendimento_Educacional]
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Atendimento_Saude] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE] CHECK CONSTRAINT [FK_Atividades_Unidade_Atendimento_Saude]
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_JURIDICA]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Juridica] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_JURIDICA] CHECK CONSTRAINT [FK_Atividades_Unidade_Juridica]
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_RECREATIVA_RELIGIOSA]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Recreativa_Religiosa] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_RECREATIVA_RELIGIOSA] CHECK CONSTRAINT [FK_Atividades_Unidade_Recreativa_Religiosa]
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_SEGURANCA]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Seguranca] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_SEGURANCA] CHECK CONSTRAINT [FK_Atividades_Seguranca]
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_SERVICO_SOCIAL]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Servico_Social] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_SERVICO_SOCIAL] CHECK CONSTRAINT [FK_Atividades_Unidade_Servico_Social]
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_VISITA_INTERNO]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_visita_interno] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO
ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_VISITA_INTERNO] CHECK CONSTRAINT [FK_Atividades_Unidade_visita_interno]
GO
ALTER TABLE [dbo].[ATUALIZACAO_DOCUMENTOS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ATUALIZAR_MATRICULA_INTERNO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ATUALIZAR_MATRICULA_INTERNO]  WITH CHECK ADD FOREIGN KEY([IdMat])
REFERENCES [dbo].[MATRICULAESCOLAR] ([IdMat])
GO
ALTER TABLE [dbo].[AUDIENCIAS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[AUTORES_REGIMENTO_DISCIPLINAR]  WITH CHECK ADD FOREIGN KEY([IdCela])
REFERENCES [dbo].[CELAS] ([IdCela])
GO
ALTER TABLE [dbo].[AUTORES_REGIMENTO_DISCIPLINAR]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[AUTORES_REGIMENTO_DISCIPLINAR]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[AUTORES_REGIMENTO_DISCIPLINAR]  WITH CHECK ADD FOREIGN KEY([IdReg])
REFERENCES [dbo].[REGIMENTO_DISCIPLINAR_INTERNOS] ([IdReg])
GO
ALTER TABLE [dbo].[AUTOREVENTOS]  WITH CHECK ADD FOREIGN KEY([IdCela])
REFERENCES [dbo].[CELAS] ([IdCela])
GO
ALTER TABLE [dbo].[AUTOREVENTOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[AUTOREVENTOS]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[REGISTROEVENTOS] ([IdLanc])
GO
ALTER TABLE [dbo].[AVALIACAO_I]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[AVALIACAO_I]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTOTERAPIA] ([IdLanc])
GO
ALTER TABLE [dbo].[AVALIACAO_II]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[AVALIACAO_II]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTOTERAPIA] ([IdLanc])
GO
ALTER TABLE [dbo].[AVALIACAO_MEDICA_PSIQUIATRICA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[AVALIACAO_TO_I]  WITH CHECK ADD FOREIGN KEY([IdATN])
REFERENCES [dbo].[ADMISSAO_TERAPIA_PE] ([IdATN])
GO
ALTER TABLE [dbo].[AVALIACAO_TO_I]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[AVALIACAO_TO_II]  WITH CHECK ADD FOREIGN KEY([IdATN])
REFERENCES [dbo].[ADMISSAO_TERAPIA_PE] ([IdATN])
GO
ALTER TABLE [dbo].[AVALIACAO_TO_II]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[AVALIACAOPSI]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[AVALICAO_ATENDIMENTO_GRUPO_EF]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoEF])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_EF] ([IdAtGrupoEF])
GO
ALTER TABLE [dbo].[AVALICAO_ATENDIMENTO_GRUPO_ENFERMAGEM]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoEnf])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_ENFERMAGEM] ([IdAtGrupoEnf])
GO
ALTER TABLE [dbo].[AVALICAO_ATENDIMENTO_GRUPO_PE]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoPE])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_PE] ([IdAtGrupoPE])
GO
ALTER TABLE [dbo].[AVALICAO_ATENDIMENTO_GRUPO_PSICOLOGIA]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoPsi])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_PSICOLOGIA] ([IdAtGrupoPsi])
GO
ALTER TABLE [dbo].[AVALICAO_ATENDIMENTO_GRUPO_SS]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoSS])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_SS] ([IdAtGrupoSS])
GO
ALTER TABLE [dbo].[AVALICAO_ATENDIMENTO_GRUPO_TO]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoTO])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_TO] ([IdAtGrupoTO])
GO
ALTER TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_EF]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoEF])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_EF] ([IdAtGrupoEF])
GO
ALTER TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_EF]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoEnf])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_ENFERMAGEM] ([IdAtGrupoEnf])
GO
ALTER TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_ENFERMAGEM]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_PE]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoPE])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_PE] ([IdAtGrupoPE])
GO
ALTER TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_PE]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_PSICOLOGIA]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoPsi])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_PSICOLOGIA] ([IdAtGrupoPsi])
GO
ALTER TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_PSICOLOGIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_SS]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoSS])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_SS] ([IdAtGrupoSS])
GO
ALTER TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_SS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_TO]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoTO])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_TO] ([IdAtGrupoTO])
GO
ALTER TABLE [dbo].[AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_TO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[BIOMETRIA_COLABORADORES]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[BIOMETRIA_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[CANCELAMENTO_VISITAS_EXTERNA_INTERNA_ROL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[CAPACITACAO_INTERNO_TO]  WITH CHECK ADD FOREIGN KEY([IdCurso])
REFERENCES [dbo].[CURSOS] ([IdCurso])
GO
ALTER TABLE [dbo].[CARTILHA_VACINAS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[CELAS]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[CIDADES]  WITH CHECK ADD FOREIGN KEY([IdPais])
REFERENCES [dbo].[PAISES] ([IdPais])
GO
ALTER TABLE [dbo].[COLABORADOR]  WITH CHECK ADD FOREIGN KEY([IdCargo])
REFERENCES [dbo].[CARGOS] ([IdCargo])
GO
ALTER TABLE [dbo].[COLABORADOR]  WITH CHECK ADD FOREIGN KEY([IdDepartamento])
REFERENCES [dbo].[DEPARTAMENTOS] ([IdDepartamento])
GO
ALTER TABLE [dbo].[COLABORADORTESTEMUNHA]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[COLABORADORTESTEMUNHA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[REGISTROEVENTOS] ([IdLanc])
GO
ALTER TABLE [dbo].[COLABORADORVITIMA]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[COLABORADORVITIMA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[REGISTROEVENTOS] ([IdLanc])
GO
ALTER TABLE [dbo].[COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE]  WITH CHECK ADD FOREIGN KEY([IdItem])
REFERENCES [dbo].[PRODUTOS_KITS_HIGIENE_INTERNO] ([IdItem])
GO
ALTER TABLE [dbo].[COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE]  WITH CHECK ADD FOREIGN KEY([IdKit])
REFERENCES [dbo].[KITS_HIGIENE_INTERNO] ([IdKit])
GO
ALTER TABLE [dbo].[COMPRAS_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdForn])
REFERENCES [dbo].[FORNECEDORES_ACERVO] ([IdForn])
GO
ALTER TABLE [dbo].[CONFERE_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdCela])
REFERENCES [dbo].[CELAS] ([IdCela])
GO
ALTER TABLE [dbo].[CONFERE_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[CONFERE_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[CONTROLIGA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[CUMPRIMENTOALVARA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[DADOSFISICOSINTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[DADOSPENAISINTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[DADOSPENAISINTERNOS]  WITH CHECK ADD FOREIGN KEY([IdUnid])
REFERENCES [dbo].[UNIDADE] ([IdUnid])
GO
ALTER TABLE [dbo].[DEPENDENTES]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[DEPOSITO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[DEPOSITO_INATIVOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[DEVOLUCAO_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[DEVOLUCAO_DOCUMENTOS_SERVICO_SOCIAL]  WITH CHECK ADD FOREIGN KEY([IdDoc])
REFERENCES [dbo].[DOCINTERNOS] ([IdDoc])
GO
ALTER TABLE [dbo].[DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR]  WITH CHECK ADD FOREIGN KEY([IdMot])
REFERENCES [dbo].[MOTIVO_SAIDA_PRODUTOS_ENFAR] ([IdMot])
GO
ALTER TABLE [dbo].[DIETA_MEDICA_PSIQUIATRICA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[DIETA_MEDICA_PSIQUIATRICA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOMEDICA] ([IdLanc])
GO
ALTER TABLE [dbo].[DISCIPLINASPROFESSOR]  WITH CHECK ADD FOREIGN KEY([IdDisc])
REFERENCES [dbo].[DISCIPLINAS] ([IdDisc])
GO
ALTER TABLE [dbo].[DISCIPLINASPROFESSOR]  WITH CHECK ADD FOREIGN KEY([IdProf])
REFERENCES [dbo].[PROFESSORES] ([IdProf])
GO
ALTER TABLE [dbo].[DOCINTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[DOCUMENTOS]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[DOCUMENTOS_PROCESSO]  WITH CHECK ADD FOREIGN KEY([IdFicha])
REFERENCES [dbo].[FICHA_JURIDICA] ([IdFicha])
GO
ALTER TABLE [dbo].[DOCUMENTOS_PROCESSO]  WITH CHECK ADD FOREIGN KEY([IdNatp])
REFERENCES [dbo].[NATUREZA_PRISAO] ([IdNatp])
GO
ALTER TABLE [dbo].[EAPI_CRC_PAI_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EAPI_CRC_PAI_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[EAPI_CRC_PAI_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdUnid])
REFERENCES [dbo].[UNIDADE] ([IdUnid])
GO
ALTER TABLE [dbo].[ELIMIAR_ASSINATURA_INTERNO_PSP]  WITH CHECK ADD FOREIGN KEY([IdDepartamento])
REFERENCES [dbo].[DEPARTAMENTOS] ([IdDepartamento])
GO
ALTER TABLE [dbo].[ELIMIAR_ASSINATURA_INTERNO_PSP]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EMISSAO_ATESTADO_RECLUSAO]  WITH CHECK ADD FOREIGN KEY([CodRegAux])
REFERENCES [dbo].[SOLICITACAO_ATESTADO_RECLUSAO] ([CodRegAux])
GO
ALTER TABLE [dbo].[EMISSAO_ATESTADO_RECLUSAO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EMISSAO_ATESTADO_RECLUSAO]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[EMISSAO_ATESTADO_RECLUSAO_CRC]  WITH CHECK ADD FOREIGN KEY([CodRegAux])
REFERENCES [dbo].[SOLICITACAO_ATESTADO_RECLUSAO_CRC] ([CodRegAux])
GO
ALTER TABLE [dbo].[EMISSAO_ATESTADO_RECLUSAO_CRC]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EMPRESTIMO_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ENCAMINHAMENTO_CIRURGIAS_ESPECIALISTAS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ENDERECOS]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[ENTRADA_SAIDA_EDUCACAO]  WITH CHECK ADD FOREIGN KEY([IdCod])
REFERENCES [dbo].[INSTITUICAOESCOLAR] ([IdCod])
GO
ALTER TABLE [dbo].[ENTRADA_SAIDA_VISITAS_RELIGIOSA]  WITH CHECK ADD FOREIGN KEY([IdCod])
REFERENCES [dbo].[INSTITUICAO_RELIGIOSA] ([IdCod])
GO
ALTER TABLE [dbo].[ENTRADALABORINTERNO]  WITH CHECK ADD FOREIGN KEY([IdEmp])
REFERENCES [dbo].[EMPRESALAB] ([IdEmp])
GO
ALTER TABLE [dbo].[ENTRADALOTE]  WITH CHECK ADD FOREIGN KEY([IdOp])
REFERENCES [dbo].[OPERACAO] ([IdOp])
GO
ALTER TABLE [dbo].[ENTRADAOBJETOSPERTENCES]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ENTRADAPERTENCES]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ENTRADAPERTENCES]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[ENTRADAS_OFICIAL_JUSTICA_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdOficial])
REFERENCES [dbo].[OFICIAL_JUSTICA] ([IdOficial])
GO
ALTER TABLE [dbo].[ENTRADASADVINTERNOS]  WITH CHECK ADD FOREIGN KEY([IdAdvogado])
REFERENCES [dbo].[ADVOGADOS] ([IdAdvogado])
GO
ALTER TABLE [dbo].[ENTRADAVEICULOCARGA]  WITH CHECK ADD FOREIGN KEY([IdVeiculo])
REFERENCES [dbo].[VEICULOS] ([IdVeiculo])
GO
ALTER TABLE [dbo].[ENTRADAVEICULOCARGA]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASDIVERSAS] ([IdVisita])
GO
ALTER TABLE [dbo].[ESCOLTA_INTERNO_PSP]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[ESCOLTA_INTERNO_PSP]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ESTOQUE_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdLivro])
REFERENCES [dbo].[LIVROS_REVISTAS_JORNAIS] ([IdLivro])
GO
ALTER TABLE [dbo].[ESTOQUE_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ACERVO] ([IdLocal])
GO
ALTER TABLE [dbo].[ESTOQUEPERTENCES]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ESTOQUEPERTENCES]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCALPERTENCES] ([IdLocal])
GO
ALTER TABLE [dbo].[ESTOQUEPERTENCES]  WITH CHECK ADD FOREIGN KEY([IdPertence])
REFERENCES [dbo].[PERTENCES] ([IdPertence])
GO
ALTER TABLE [dbo].[ESTORNO_DEPOSITO_SAQUE]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EVADIDOSIND]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EVOLUCAO_ADMISSAO_PEDAGOGIA]  WITH CHECK ADD FOREIGN KEY([IdAdm])
REFERENCES [dbo].[ADMISSAO_PEDAGOGIA] ([IdAdm])
GO
ALTER TABLE [dbo].[EVOLUCAO_ADMISSAO_PEDAGOGIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EVOLUCAO_ATENDIMENTO_FAMILIA]  WITH CHECK ADD FOREIGN KEY([IdAtendf])
REFERENCES [dbo].[ATENDIMENTOFAMILIAR] ([IdAtendf])
GO
ALTER TABLE [dbo].[EVOLUCAO_ATENDIMENTO_FAMILIA]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[EVOLUCAO_ATENDIMENTO_SOCIAL]  WITH CHECK ADD FOREIGN KEY([IdAtend])
REFERENCES [dbo].[ATENDIMENTOSOCIAL] ([IdAtend])
GO
ALTER TABLE [dbo].[EVOLUCAO_ATENDIMENTO_SOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EVOLUCAO_EDUCACAO_FISICA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EVOLUCAO_EDUCACAO_FISICA]  WITH CHECK ADD FOREIGN KEY([IdRegistroEF])
REFERENCES [dbo].[ADMISSAO_EDUCACAO_FISICA] ([IdRegistroEF])
GO
ALTER TABLE [dbo].[EVOLUCAO_PAI]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EVOLUCAO_PAI]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[EVOLUCAO_PAI_NOVO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EVOLUCAO_PAI_NOVO]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[FICHA_CADASTRO_PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[EVOLUCAO_PSIQUIATRICA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EVOLUCAO_PSIQUIATRICA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOMEDICA] ([IdLanc])
GO
ALTER TABLE [dbo].[EVOLUCAOENFERMAGEM]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EVOLUCAOENFERMAGEM]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOENFERMEIRA] ([IdLanc])
GO
ALTER TABLE [dbo].[EVOLUCAOJURIDICO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EVOLUCAOJURIDICO]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTOJURIDICO] ([IdLanc])
GO
ALTER TABLE [dbo].[EVOLUCAOMEDICA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EVOLUCAOMEDICA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOMEDICA] ([IdLanc])
GO
ALTER TABLE [dbo].[EVOLUCAOPSICOLOGICA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EVOLUCAOPSICOLOGICA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOPSI] ([IdLanc])
GO
ALTER TABLE [dbo].[EVOLUCAOTECENFERMAGEM]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EVOLUCAOTECENFERMAGEM]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTOTECENFERMAGEM] ([IdLanc])
GO
ALTER TABLE [dbo].[EVOLUCAOTERAPIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[EVOLUCAOTERAPIA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTOTERAPIA] ([IdLanc])
GO
ALTER TABLE [dbo].[FALTAS_INDISCIPLINAR_INDIVIDUAL_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FALTAS_INDISCIPLINAR_INDIVIDUAL_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[REGISTROEVENTOS] ([IdLanc])
GO
ALTER TABLE [dbo].[FALTAS_INDISCIPLINAR_INDIVIDUAL_INTERNOS_01]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FALTAS_INDISCIPLINAR_INDIVIDUAL_INTERNOS_01]  WITH CHECK ADD FOREIGN KEY([IdReg])
REFERENCES [dbo].[REGIMENTO_DISCIPLINAR_INTERNOS] ([IdReg])
GO
ALTER TABLE [dbo].[FAMILIA_ADMISSAO_PEDAGOGIA]  WITH CHECK ADD FOREIGN KEY([IdAdm])
REFERENCES [dbo].[ADMISSAO_PEDAGOGIA] ([IdAdm])
GO
ALTER TABLE [dbo].[FAMILIA_ADMISSAO_PEDAGOGIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FAMILIA_ADMISSAO_PEDAGOGIA_NOVA]  WITH CHECK ADD FOREIGN KEY([IdAdmNova])
REFERENCES [dbo].[ADMISSAO_PEDAGOGIA_NOVA] ([IdAdmNova])
GO
ALTER TABLE [dbo].[FAMILIA_ADMISSAO_PEDAGOGIA_NOVA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FEMININO_ADMISSAO_PEDAGOGIA]  WITH CHECK ADD FOREIGN KEY([IdAdm])
REFERENCES [dbo].[ADMISSAO_PEDAGOGIA] ([IdAdm])
GO
ALTER TABLE [dbo].[FEMININO_ADMISSAO_PEDAGOGIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FEMININO_ADMISSAO_PEDAGOGIA_NOVA]  WITH CHECK ADD FOREIGN KEY([IdAdmNova])
REFERENCES [dbo].[ADMISSAO_PEDAGOGIA_NOVA] ([IdAdmNova])
GO
ALTER TABLE [dbo].[FEMININO_ADMISSAO_PEDAGOGIA_NOVA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_CCGF]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_CCGF]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[FICHA_CADASTRO_PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_CCGF_VF]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_CCGF_VF]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[FICHA_CADASTRO_PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_CCGF_VF1]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_CCGF_VF1]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[FICHA_CADASTRO_PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_CCGF_VF1]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_CCGF_VF2]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_CCGF_VF2]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[FICHA_CADASTRO_PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_CCGF_VF2]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_DEME]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_DEME]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[FICHA_CADASTRO_PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_DJ]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_DJ]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[FICHA_CADASTRO_PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_DPTL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_DPTL]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[FICHA_CADASTRO_PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_DS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_DS]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[FICHA_CADASTRO_PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_EAPI1]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_EAPI1]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[FICHA_CADASTRO_PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_EAPI2]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_EAPI2]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[FICHA_CADASTRO_PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[FICHA_CADASTRO_PAI_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FICHA_JURIDICA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[FICHA_TECNICA_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdCat])
REFERENCES [dbo].[CATEGORIA_RECEITAS_NUTRI] ([IdCat])
GO
ALTER TABLE [dbo].[FICHALABORATIVA]  WITH CHECK ADD FOREIGN KEY([IdEmp])
REFERENCES [dbo].[EMPRESALAB] ([IdEmp])
GO
ALTER TABLE [dbo].[FREQUENCIA]  WITH CHECK ADD FOREIGN KEY([IdMat])
REFERENCES [dbo].[MATRICULAESCOLAR] ([IdMat])
GO
ALTER TABLE [dbo].[FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA]  WITH CHECK ADD FOREIGN KEY([IdCurso])
REFERENCES [dbo].[CURSOS] ([IdCurso])
GO
ALTER TABLE [dbo].[FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA]  WITH CHECK ADD FOREIGN KEY([IdProf])
REFERENCES [dbo].[PROFESSORES] ([IdProf])
GO
ALTER TABLE [dbo].[FREQUENCIA_CAPACITACAO_INTERNO_TO]  WITH CHECK ADD FOREIGN KEY([IdCurso])
REFERENCES [dbo].[CURSOS] ([IdCurso])
GO
ALTER TABLE [dbo].[FREQUENCIA_LABORATIVA_EXTERNA]  WITH CHECK ADD FOREIGN KEY([IdEmp])
REFERENCES [dbo].[EMPRESALAB] ([IdEmp])
GO
ALTER TABLE [dbo].[FREQUENCIA_PEDAGOGIA_EXTERNA]  WITH CHECK ADD FOREIGN KEY([IdCod])
REFERENCES [dbo].[INSTITUICAOESCOLAR] ([IdCod])
GO
ALTER TABLE [dbo].[HISTORICO_AVALICAO_SERVICO_SOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[HISTORICO_COMPRA_AC]  WITH CHECK ADD FOREIGN KEY([IdNfEntrada])
REFERENCES [dbo].[NF_COMPRAS] ([IdNfEntrada])
GO
ALTER TABLE [dbo].[HISTORICO_COMPRA_AC]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[HISTORICO_COMPRA_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdCompra])
REFERENCES [dbo].[COMPRAS_ACERVO] ([IdCompra])
GO
ALTER TABLE [dbo].[HISTORICO_COMPRA_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdLivro])
REFERENCES [dbo].[LIVROS_REVISTAS_JORNAIS] ([IdLivro])
GO
ALTER TABLE [dbo].[HISTORICO_COMPRA_FAR]  WITH CHECK ADD FOREIGN KEY([IdNfEntrada])
REFERENCES [dbo].[NF_COMPRAS_FAR] ([IdNfEntrada])
GO
ALTER TABLE [dbo].[HISTORICO_COMPRA_FAR]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[HISTORICO_COMPRA_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdNfEntrada])
REFERENCES [dbo].[NF_COMPRAS_NUTRI] ([IdNfEntrada])
GO
ALTER TABLE [dbo].[HISTORICO_COMPRA_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[HISTORICO_DADOS_PENAIS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdEntrada])
REFERENCES [dbo].[ENTRADALOTE] ([IdEntrada])
GO
ALTER TABLE [dbo].[HISTORICO_DADOS_PENAIS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[HISTORICO_DADOS_PENAIS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdItem])
REFERENCES [dbo].[ITENSENTRADA] ([IdItem])
GO
ALTER TABLE [dbo].[HISTORICO_DADOS_PENAIS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdUnid])
REFERENCES [dbo].[UNIDADE] ([IdUnid])
GO
ALTER TABLE [dbo].[HISTORICO_DOENCA_FAMILIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[HISTORICO_EXTERNO_EDUCACIONAL]  WITH CHECK ADD FOREIGN KEY([IdCod])
REFERENCES [dbo].[INSTITUICAOESCOLAR] ([IdCod])
GO
ALTER TABLE [dbo].[HISTORICO_EXTERNO_EDUCACIONAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[HISTORICO_EXTERNO_EDUCACIONAL]  WITH CHECK ADD FOREIGN KEY([IdItem])
REFERENCES [dbo].[INTERNOS_ENTRADA_SAIDA_EDUCACAO] ([IdItem])
GO
ALTER TABLE [dbo].[HISTORICO_INTERNO_EDUCACIONAL]  WITH CHECK ADD FOREIGN KEY([IdCod])
REFERENCES [dbo].[INSTITUICAOESCOLAR] ([IdCod])
GO
ALTER TABLE [dbo].[HISTORICO_INTERNO_EDUCACIONAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[HISTORICO_INTERNO_EDUCACIONAL]  WITH CHECK ADD FOREIGN KEY([IdItem])
REFERENCES [dbo].[ITENSFREQUENCIA] ([IdItem])
GO
ALTER TABLE [dbo].[HISTORICO_LIBERADORES_BANCO_VIRTUAL]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[DEPOSITO] ([IdLanc])
GO
ALTER TABLE [dbo].[HISTORICO_LIBERADORES_BANCO_VIRTUAL]  WITH CHECK ADD FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[USUARIOS] ([IdUsuario])
GO
ALTER TABLE [dbo].[HISTORICO_LIBERADORES_BANCO_VIRTUAL_INATIVOS]  WITH CHECK ADD FOREIGN KEY([IdDepIna])
REFERENCES [dbo].[DEPOSITO_INATIVOS] ([IdDepIna])
GO
ALTER TABLE [dbo].[HISTORICO_LIBERADORES_BANCO_VIRTUAL_INATIVOS]  WITH CHECK ADD FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[USUARIOS] ([IdUsuario])
GO
ALTER TABLE [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_AC]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_AC]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_ENF]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_ENF]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_FAR]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_FAR]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[HISTORICO_MOVIMENTACAO_ESTOQUE_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[HISTORICO_PRODUTOS_FORNECEDOR]  WITH CHECK ADD FOREIGN KEY([IdForn])
REFERENCES [dbo].[FORNECEDORES_AC] ([IdForn])
GO
ALTER TABLE [dbo].[HISTORICO_PRODUTOS_FORNECEDOR]  WITH CHECK ADD FOREIGN KEY([IdItem])
REFERENCES [dbo].[ITENS_COMPRAS_MATERIAIS] ([IdItem])
GO
ALTER TABLE [dbo].[HISTORICO_PRODUTOS_FORNECEDOR]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[HISTORICO_PRODUTOS_FORNECEDOR_FAR]  WITH CHECK ADD FOREIGN KEY([IdForn])
REFERENCES [dbo].[FORNECEDORES_AC] ([IdForn])
GO
ALTER TABLE [dbo].[HISTORICO_PRODUTOS_FORNECEDOR_FAR]  WITH CHECK ADD FOREIGN KEY([IdItem])
REFERENCES [dbo].[ITENS_COMPRAS_MATERIAIS_FAR] ([IdItem])
GO
ALTER TABLE [dbo].[HISTORICO_PRODUTOS_FORNECEDOR_FAR]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[HISTORICO_PRODUTOS_FORNECEDOR_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdForn])
REFERENCES [dbo].[FORNECEDORES_AC] ([IdForn])
GO
ALTER TABLE [dbo].[HISTORICO_PRODUTOS_FORNECEDOR_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdItem])
REFERENCES [dbo].[ITENS_COMPRAS_MATERIAIS_NUTRI] ([IdItem])
GO
ALTER TABLE [dbo].[HISTORICO_VISITA_EMPREGO_SERVICO_SOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[HISTORICO_VISITAS_RELIGIOSA]  WITH CHECK ADD FOREIGN KEY([IdCod])
REFERENCES [dbo].[INSTITUICAO_RELIGIOSA] ([IdCod])
GO
ALTER TABLE [dbo].[HISTORICO_VISITAS_RELIGIOSA]  WITH CHECK ADD FOREIGN KEY([IdEntSaiVisita])
REFERENCES [dbo].[ENTRADA_SAIDA_VISITAS_RELIGIOSA] ([IdEntSaiVisita])
GO
ALTER TABLE [dbo].[HISTORICO_VISITAS_RELIGIOSA]  WITH CHECK ADD FOREIGN KEY([IdVisitaRel])
REFERENCES [dbo].[VISITAS_RELIGIOSA_INTERNOS] ([IdVisitaRel])
GO
ALTER TABLE [dbo].[HISTORICOAUTOR]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[HISTORICOAUTOR]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[REGISTROEVENTOS] ([IdLanc])
GO
ALTER TABLE [dbo].[HISTORICOLABORINTERNO]  WITH CHECK ADD FOREIGN KEY([IdEmp])
REFERENCES [dbo].[EMPRESALAB] ([IdEmp])
GO
ALTER TABLE [dbo].[HISTORICOLABORINTERNO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[HISTORICOVISITASINTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[HISTORICOVISITASINTERNOS]  WITH CHECK ADD FOREIGN KEY([Idlanc])
REFERENCES [dbo].[ENTRADASFAMILIAR] ([IdLanc])
GO
ALTER TABLE [dbo].[HISTORICOVISITASINTERNOS]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[INCIDENCIA_PENAL]  WITH CHECK ADD FOREIGN KEY([IdFicha])
REFERENCES [dbo].[FICHA_JURIDICA] ([IdFicha])
GO
ALTER TABLE [dbo].[INCIDENCIA_PENAL]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[AMPARO_LEGAL] ([IdLanc])
GO
ALTER TABLE [dbo].[INDICACAO_VISITA_INTERNO_SERVICO_SOCIAL]  WITH CHECK ADD FOREIGN KEY([IdAtend])
REFERENCES [dbo].[ATENDIMENTOSOCIAL] ([IdAtend])
GO
ALTER TABLE [dbo].[INDICACAO_VISITA_INTERNO_SERVICO_SOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA]  WITH CHECK ADD FOREIGN KEY([IdIndAco])
REFERENCES [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO] ([IdIndAco])
GO
ALTER TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_ENFERMARIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC]  WITH CHECK ADD FOREIGN KEY([IdIndAco])
REFERENCES [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO] ([IdIndAco])
GO
ALTER TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_JURIDICO_CRC]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA]  WITH CHECK ADD FOREIGN KEY([IdIndAco])
REFERENCES [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO] ([IdIndAco])
GO
ALTER TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_PEDAGOGIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_PSI]  WITH CHECK ADD FOREIGN KEY([IdIndAco])
REFERENCES [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO] ([IdIndAco])
GO
ALTER TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_PSI]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_SS]  WITH CHECK ADD FOREIGN KEY([IdIndAco])
REFERENCES [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO] ([IdIndAco])
GO
ALTER TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_SS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_TO]  WITH CHECK ADD FOREIGN KEY([IdIndAco])
REFERENCES [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO] ([IdIndAco])
GO
ALTER TABLE [dbo].[INDICADOR_ACOMPANHAMENTO_INTERNO_TO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[INGREDIENTES_FICHA_TECNICA_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdFicha])
REFERENCES [dbo].[FICHA_TECNICA_NUTRI] ([IdFicha])
GO
ALTER TABLE [dbo].[INGREDIENTES_FICHA_TECNICA_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[INTERNOS_ENTRADA_SAIDA_EDUCACAO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[INTERNOS_ENTRADA_SAIDA_EDUCACAO]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ENTRADA_SAIDA_EDUCACAO] ([IdLanc])
GO
ALTER TABLE [dbo].[INTERNOS_PAVILHAO_KIT_LOTE]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[INTERNOS_PAVILHAO_KIT_LOTE]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[INTERNOS_PAVILHAO_KIT_LOTE]  WITH CHECK ADD FOREIGN KEY([IdRegistroComp])
REFERENCES [dbo].[COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE] ([IdRegistroComp])
GO
ALTER TABLE [dbo].[INTERNOS_SAIDA_EDUCACIONAL]  WITH CHECK ADD FOREIGN KEY([IdEduca])
REFERENCES [dbo].[ASSISTENCIA_EDUCACAO_EXTERNA] ([IdEduca])
GO
ALTER TABLE [dbo].[INTERNOS_SAIDA_EDUCACIONAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[INTERNOSISOLAMENTO]  WITH CHECK ADD FOREIGN KEY([IdCela])
REFERENCES [dbo].[CELAS] ([IdCela])
GO
ALTER TABLE [dbo].[INTERNOSISOLAMENTO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[INTERNOSISOLAMENTO]  WITH CHECK ADD FOREIGN KEY([IdLancRet])
REFERENCES [dbo].[RETIRADAINTERNO] ([IdLancRet])
GO
ALTER TABLE [dbo].[INTERNOSISOLAMENTO]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[REGISTROEVENTOS] ([IdLanc])
GO
ALTER TABLE [dbo].[INTERNOSISOLAMENTO]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[INTERNOSPROCEDIMENTOS]  WITH CHECK ADD FOREIGN KEY([IdCela])
REFERENCES [dbo].[CELAS] ([IdCela])
GO
ALTER TABLE [dbo].[INTERNOSPROCEDIMENTOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[INTERNOSPROCEDIMENTOS]  WITH CHECK ADD FOREIGN KEY([IdItensPcip])
REFERENCES [dbo].[ITENSPCIP] ([IdItensPcip])
GO
ALTER TABLE [dbo].[INTERNOSPROCEDIMENTOS]  WITH CHECK ADD FOREIGN KEY([IdProc])
REFERENCES [dbo].[PROCEDIMENTOS] ([IdProc])
GO
ALTER TABLE [dbo].[INTERNOSVITIMAS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[INTERNOSVITIMAS]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[REGISTROEVENTOS] ([IdLanc])
GO
ALTER TABLE [dbo].[INTERNOTESTEMUNHA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[INTERNOTESTEMUNHA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[REGISTROEVENTOS] ([IdLanc])
GO
ALTER TABLE [dbo].[INVENTARIO_AC]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[INVENTARIO_FAR]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[INVENTARIO_LIVROS]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ACERVO] ([IdLocal])
GO
ALTER TABLE [dbo].[INVENTARIO_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[ITENS_ADMISSAO_DOENCAS_ADICIONAL]  WITH CHECK ADD FOREIGN KEY([IdAdmADI])
REFERENCES [dbo].[ADMISSAO_MEDICA_ADICIONAL] ([IdAdmADI])
GO
ALTER TABLE [dbo].[ITENS_ADMISSAO_DOENCAS_ADICIONAL]  WITH CHECK ADD FOREIGN KEY([IdDoenca])
REFERENCES [dbo].[DOENCAS] ([IdDoenca])
GO
ALTER TABLE [dbo].[ITENS_AGENDA_ATENDIMENTO_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_AGENDA_ATENDIMENTO_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdReg])
REFERENCES [dbo].[AGENDA_ATENDIMENTO_INTERNOS] ([IdReg])
GO
ALTER TABLE [dbo].[ITENS_AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA]  WITH CHECK ADD FOREIGN KEY([IdReg])
REFERENCES [dbo].[AGENDA_ATENDIMENTO_INTERNOS_PEDAGOGIA] ([IdReg])
GO
ALTER TABLE [dbo].[ITENS_AGENDA_BENEFICIO_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_AGENDA_BENEFICIO_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdReg])
REFERENCES [dbo].[AGENDA_BENEFICIO_INTERNOS] ([IdReg])
GO
ALTER TABLE [dbo].[ITENS_APRAZAMENTO_MEDICACAO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_APRAZAMENTO_MEDICACAO]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[APRAZAMENTO_MEDICACAO] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENS_APRAZAMENTO_MEDICACAO]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM]  WITH CHECK ADD FOREIGN KEY([IdAprova])
REFERENCES [dbo].[APROVACAO_SOLICITACAO_COMPRAS_ADM] ([IdAprova])
GO
ALTER TABLE [dbo].[ITENS_APROVACAO_SOLICITACAO_COMPRAS_ADM]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA]  WITH CHECK ADD FOREIGN KEY([IdAC])
REFERENCES [dbo].[ATIVIDADES_COMPLEMENTARES_PEDAGOGICA] ([IdAC])
GO
ALTER TABLE [dbo].[ITENS_AUTOR_LIVROS]  WITH CHECK ADD FOREIGN KEY([IdAutor])
REFERENCES [dbo].[AUTORES_LIVROS] ([IdAutor])
GO
ALTER TABLE [dbo].[ITENS_AUTOR_LIVROS]  WITH CHECK ADD FOREIGN KEY([IdLivro])
REFERENCES [dbo].[LIVROS_REVISTAS_JORNAIS] ([IdLivro])
GO
ALTER TABLE [dbo].[ITENS_CANCELAMENTO_VISITAS_EXTERNA_ROL]  WITH CHECK ADD FOREIGN KEY([IdCan])
REFERENCES [dbo].[CANCELAMENTO_VISITAS_EXTERNA_INTERNA_ROL] ([IdCan])
GO
ALTER TABLE [dbo].[ITENS_CANCELAMENTO_VISITAS_EXTERNA_ROL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_CANCELAMENTO_VISITAS_EXTERNA_ROL]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[ITENS_CANCELAMENTO_VISITAS_INTERNA_ROL]  WITH CHECK ADD FOREIGN KEY([IdCan])
REFERENCES [dbo].[CANCELAMENTO_VISITAS_EXTERNA_INTERNA_ROL] ([IdCan])
GO
ALTER TABLE [dbo].[ITENS_CANCELAMENTO_VISITAS_INTERNA_ROL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_CAPACITACAO_INTERNO_TO]  WITH CHECK ADD FOREIGN KEY([IdCap])
REFERENCES [dbo].[CAPACITACAO_INTERNO_TO] ([IdCap])
GO
ALTER TABLE [dbo].[ITENS_CAPACITACAO_INTERNO_TO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_CARTILHA_VACINAS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdCart])
REFERENCES [dbo].[CARTILHA_VACINAS_INTERNOS] ([IdCart])
GO
ALTER TABLE [dbo].[ITENS_CARTILHA_VACINAS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdVacina])
REFERENCES [dbo].[TIPOS_VACINAS] ([IdVacina])
GO
ALTER TABLE [dbo].[ITENS_COMPRA_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdCompra])
REFERENCES [dbo].[COMPRAS_ACERVO] ([IdCompra])
GO
ALTER TABLE [dbo].[ITENS_COMPRA_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdLivro])
REFERENCES [dbo].[LIVROS_REVISTAS_JORNAIS] ([IdLivro])
GO
ALTER TABLE [dbo].[ITENS_COMPRAS_MATERIAIS]  WITH CHECK ADD FOREIGN KEY([IdNfEntrada])
REFERENCES [dbo].[NF_COMPRAS] ([IdNfEntrada])
GO
ALTER TABLE [dbo].[ITENS_COMPRAS_MATERIAIS]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_COMPRAS_MATERIAIS_FAR]  WITH CHECK ADD FOREIGN KEY([IdNfEntrada])
REFERENCES [dbo].[NF_COMPRAS_FAR] ([IdNfEntrada])
GO
ALTER TABLE [dbo].[ITENS_COMPRAS_MATERIAIS_FAR]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_COMPRAS_MATERIAIS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdNfEntrada])
REFERENCES [dbo].[NF_COMPRAS_NUTRI] ([IdNfEntrada])
GO
ALTER TABLE [dbo].[ITENS_COMPRAS_MATERIAIS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_CURSOS_LISTAESPERA]  WITH CHECK ADD FOREIGN KEY([IdCurso])
REFERENCES [dbo].[CURSOS] ([IdCurso])
GO
ALTER TABLE [dbo].[ITENS_CURSOS_LISTAESPERA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_CURSOS_LISTAESPERA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[LISTAESPERA] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL]  WITH CHECK ADD FOREIGN KEY([IdCurso])
REFERENCES [dbo].[CURSOS] ([IdCurso])
GO
ALTER TABLE [dbo].[ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL]  WITH CHECK ADD FOREIGN KEY([IdHistoricoEdu])
REFERENCES [dbo].[TO_HISTORICO_EDUCACIONAL] ([IdHistoricoEdu])
GO
ALTER TABLE [dbo].[ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTOTERAPIA] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO]  WITH CHECK ADD FOREIGN KEY([IdATN])
REFERENCES [dbo].[ADMISSAO_TERAPIA_PE] ([IdATN])
GO
ALTER TABLE [dbo].[ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO]  WITH CHECK ADD FOREIGN KEY([IdCurso])
REFERENCES [dbo].[CURSOS] ([IdCurso])
GO
ALTER TABLE [dbo].[ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO]  WITH CHECK ADD FOREIGN KEY([IdHistoricoEduN])
REFERENCES [dbo].[TO_HISTORICO_EDUCACIONAL_NOVO] ([IdHistoricoEduN])
GO
ALTER TABLE [dbo].[ITENS_DEVOLUCAO_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdDevolucao])
REFERENCES [dbo].[DEVOLUCAO_ACERVO] ([IdDevolucao])
GO
ALTER TABLE [dbo].[ITENS_DEVOLUCAO_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdLivro])
REFERENCES [dbo].[LIVROS_REVISTAS_JORNAIS] ([IdLivro])
GO
ALTER TABLE [dbo].[ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR]  WITH CHECK ADD FOREIGN KEY([IdDevo])
REFERENCES [dbo].[DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR] ([IdDevo])
GO
ALTER TABLE [dbo].[ITENS_DEVOLUCAO_PRODUTOS_ENFERMARIA_ENFAR]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_EMPRESTIMO_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdEmprestimo])
REFERENCES [dbo].[EMPRESTIMO_ACERVO] ([IdEmprestimo])
GO
ALTER TABLE [dbo].[ITENS_EMPRESTIMO_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdLivro])
REFERENCES [dbo].[LIVROS_REVISTAS_JORNAIS] ([IdLivro])
GO
ALTER TABLE [dbo].[ITENS_ENCAMINHAMENTO_CIRURGIAS_ESPECIALISTAS]  WITH CHECK ADD FOREIGN KEY([IdEnca])
REFERENCES [dbo].[ENCAMINHAMENTO_CIRURGIAS_ESPECIALISTAS] ([IdEnca])
GO
ALTER TABLE [dbo].[ITENS_ENTRADA_SAIDA_ALBERGADOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_ENTRADA_SAIDA_ALBERGADOS]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ENTRADA_SAIDA_ALBERGADOS] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENS_ENTRADA_SAIDA_VISITAS_RELIGIOSA]  WITH CHECK ADD FOREIGN KEY([IdCod])
REFERENCES [dbo].[INSTITUICAO_RELIGIOSA] ([IdCod])
GO
ALTER TABLE [dbo].[ITENS_ENTRADA_SAIDA_VISITAS_RELIGIOSA]  WITH CHECK ADD FOREIGN KEY([IdEntSaiVisita])
REFERENCES [dbo].[ENTRADA_SAIDA_VISITAS_RELIGIOSA] ([IdEntSaiVisita])
GO
ALTER TABLE [dbo].[ITENS_ENTRADA_SAIDA_VISITAS_RELIGIOSA]  WITH CHECK ADD FOREIGN KEY([IdVisitaRel])
REFERENCES [dbo].[VISITAS_RELIGIOSA_INTERNOS] ([IdVisitaRel])
GO
ALTER TABLE [dbo].[ITENS_ENTRADAS_OFICIAL_JUSTICA]  WITH CHECK ADD FOREIGN KEY([IdDepartamento])
REFERENCES [dbo].[DEPARTAMENTOS] ([IdDepartamento])
GO
ALTER TABLE [dbo].[ITENS_ENTRADAS_OFICIAL_JUSTICA]  WITH CHECK ADD FOREIGN KEY([Idlanc])
REFERENCES [dbo].[ENTRADAS_OFICIAL_JUSTICA] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENS_ENTRADAS_OFICIAL_JUSTICA]  WITH CHECK ADD FOREIGN KEY([IdOficial])
REFERENCES [dbo].[OFICIAL_JUSTICA] ([IdOficial])
GO
ALTER TABLE [dbo].[ITENS_ENTRADAS_OFICIAL_JUSTICA_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_ENTRADAS_OFICIAL_JUSTICA_INTERNOS]  WITH CHECK ADD FOREIGN KEY([Idlanc])
REFERENCES [dbo].[ENTRADAS_OFICIAL_JUSTICA_INTERNOS] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENS_ENTRADAS_OFICIAL_JUSTICA_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdOficial])
REFERENCES [dbo].[OFICIAL_JUSTICA] ([IdOficial])
GO
ALTER TABLE [dbo].[ITENS_ESTORNO_PRODUTOS_AC]  WITH CHECK ADD FOREIGN KEY([IdEst])
REFERENCES [dbo].[ESTORNO_PRODUTOS_AC] ([IdEst])
GO
ALTER TABLE [dbo].[ITENS_ESTORNO_PRODUTOS_AC]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_ESTORNO_PRODUTOS_ENF]  WITH CHECK ADD FOREIGN KEY([IdEst])
REFERENCES [dbo].[ESTORNO_PRODUTOS_ENF] ([IdEst])
GO
ALTER TABLE [dbo].[ITENS_ESTORNO_PRODUTOS_ENF]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_ESTORNO_PRODUTOS_FAR]  WITH CHECK ADD FOREIGN KEY([IdEst])
REFERENCES [dbo].[ESTORNO_PRODUTOS_FAR] ([IdEst])
GO
ALTER TABLE [dbo].[ITENS_ESTORNO_PRODUTOS_FAR]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_ESTORNO_PRODUTOS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdEst])
REFERENCES [dbo].[ESTORNO_PRODUTOS_NUTRI] ([IdEst])
GO
ALTER TABLE [dbo].[ITENS_ESTORNO_PRODUTOS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_EXPORTADO_LOCACAO_INTERNOS]  WITH CHECK ADD FOREIGN KEY([CodigoReg])
REFERENCES [dbo].[PRE_LOCACAO_INTERNOS] ([CodigoReg])
GO
ALTER TABLE [dbo].[ITENS_EXPORTADO_LOCACAO_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_EXPORTADO_LOCACAO_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[ITENS_FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA]  WITH CHECK ADD FOREIGN KEY([IdFAC])
REFERENCES [dbo].[FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA] ([IdFAC])
GO
ALTER TABLE [dbo].[ITENS_FREQUENCIA_ATIVIDADES_COMPLEMENTARES_PEDAGOGICA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO]  WITH CHECK ADD FOREIGN KEY([IdFreqCap])
REFERENCES [dbo].[FREQUENCIA_CAPACITACAO_INTERNO_TO] ([IdFreqCap])
GO
ALTER TABLE [dbo].[ITENS_FREQUENCIA_CAPACITACAO_INTERNO_TO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_FREQUENCIA_LABORATIVA_EXTERNA]  WITH CHECK ADD FOREIGN KEY([IdFreqLab])
REFERENCES [dbo].[FREQUENCIA_LABORATIVA_EXTERNA] ([IdFreqLab])
GO
ALTER TABLE [dbo].[ITENS_FREQUENCIA_LABORATIVA_EXTERNA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA]  WITH CHECK ADD FOREIGN KEY([IdFreqLab])
REFERENCES [dbo].[FREQUENCIA_PEDAGOGIA_EXTERNA] ([IdFreqLab])
GO
ALTER TABLE [dbo].[ITENS_FREQUENCIA_PEDAGOGIA_EXTERNA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_HISTORICO_DOENCA_FAMILIA]  WITH CHECK ADD FOREIGN KEY([IdDoenca])
REFERENCES [dbo].[DOENCAS] ([IdDoenca])
GO
ALTER TABLE [dbo].[ITENS_HISTORICO_DOENCA_FAMILIA]  WITH CHECK ADD FOREIGN KEY([IdHist])
REFERENCES [dbo].[HISTORICO_DOENCA_FAMILIA] ([IdHist])
GO
ALTER TABLE [dbo].[ITENS_INGREDIENTES_FICHA_TECNICA_CALCULADO_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdFicha])
REFERENCES [dbo].[FICHA_TECNICA_NUTRI] ([IdFicha])
GO
ALTER TABLE [dbo].[ITENS_INGREDIENTES_FICHA_TECNICA_CALCULADO_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_INTERNOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO]  WITH CHECK ADD FOREIGN KEY([IdRegistroComp])
REFERENCES [dbo].[COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE] ([IdRegistroComp])
GO
ALTER TABLE [dbo].[ITENS_INVENTARIO_AC]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[INVENTARIO_AC] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENS_INVENTARIO_AC]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[ITENS_INVENTARIO_AC]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_INVENTARIO_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[INVENTARIO_LIVROS] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENS_INVENTARIO_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdLivro])
REFERENCES [dbo].[LIVROS_REVISTAS_JORNAIS] ([IdLivro])
GO
ALTER TABLE [dbo].[ITENS_INVENTARIO_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ACERVO] ([IdLocal])
GO
ALTER TABLE [dbo].[ITENS_INVENTARIO_FAR]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[INVENTARIO_FAR] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENS_INVENTARIO_FAR]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[ITENS_INVENTARIO_FAR]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_INVENTARIO_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[INVENTARIO_NUTRI] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENS_INVENTARIO_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[ITENS_INVENTARIO_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_LIBERADOR_ESCOLTA_INTERNO_PSP]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[ITENS_LIBERADOR_ESCOLTA_INTERNO_PSP]  WITH CHECK ADD FOREIGN KEY([IdLibe])
REFERENCES [dbo].[LIBERADOR_ESCOLTA_INTERNO_PSP] ([IdLibe])
GO
ALTER TABLE [dbo].[ITENS_LISTA_PASSAGEM_ALBERGADOS]  WITH CHECK ADD FOREIGN KEY([IdAgenda])
REFERENCES [dbo].[LISTA_PASSAGEM_ALBERGADOS] ([IdAgenda])
GO
ALTER TABLE [dbo].[ITENS_LISTA_PASSAGEM_ALBERGADOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_LISTA_ROL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_LISTA_ROL]  WITH CHECK ADD FOREIGN KEY([IdRol])
REFERENCES [dbo].[ROLVISITAS] ([IdRol])
GO
ALTER TABLE [dbo].[ITENS_OCUPACAO_LISTAESPERA]  WITH CHECK ADD FOREIGN KEY([IdCodigoOcupa])
REFERENCES [dbo].[OCUPACAO] ([IdCodigoOcupa])
GO
ALTER TABLE [dbo].[ITENS_OCUPACAO_LISTAESPERA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_OCUPACAO_LISTAESPERA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[LISTAESPERA] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENS_ODONTOGRAMA_ADMISSAO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_ODONTOGRAMA_ADMISSAO]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTODONTO] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENS_ODONTOGRAMA_ADMISSAO]  WITH CHECK ADD FOREIGN KEY([IdProcOdonto])
REFERENCES [dbo].[PROCEDIMENTOS_ODONTOLOGICO] ([IdProcOdonto])
GO
ALTER TABLE [dbo].[ITENS_PAGAMENTO_KIT_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_PAGAMENTO_KIT_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdPagto])
REFERENCES [dbo].[PAGAMENTO_KIT_INTERNOS] ([IdPagto])
GO
ALTER TABLE [dbo].[ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS]  WITH CHECK ADD FOREIGN KEY([IdItem])
REFERENCES [dbo].[ITENS_PAGAMENTO_KIT_INTERNOS] ([IdItem])
GO
ALTER TABLE [dbo].[ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS]  WITH CHECK ADD FOREIGN KEY([IdPagto])
REFERENCES [dbo].[PAGAMENTO_KIT_INTERNOS] ([IdPagto])
GO
ALTER TABLE [dbo].[ITENS_PAGAMENTO_KIT_INTERNOS_PRODUTOS]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_PAGAMENTO_REFEICAO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_PAGAMENTO_REFEICAO]  WITH CHECK ADD FOREIGN KEY([IdRef])
REFERENCES [dbo].[PAGAMENTO_REFEICAO] ([IdRef])
GO
ALTER TABLE [dbo].[ITENS_PERNOITE_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdPer])
REFERENCES [dbo].[PERNOITE_INTERNOS] ([IdPer])
GO
ALTER TABLE [dbo].[ITENS_PRE_LOCACAO_INTERNOS]  WITH CHECK ADD FOREIGN KEY([CodigoReg])
REFERENCES [dbo].[PRE_LOCACAO_INTERNOS] ([CodigoReg])
GO
ALTER TABLE [dbo].[ITENS_PRE_LOCACAO_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdEntrada])
REFERENCES [dbo].[ENTRADALOTE] ([IdEntrada])
GO
ALTER TABLE [dbo].[ITENS_PRE_LOCACAO_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_PRE_LOCACAO_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO]  WITH CHECK ADD FOREIGN KEY([IdKit])
REFERENCES [dbo].[KITS_HIGIENE_INTERNO] ([IdKit])
GO
ALTER TABLE [dbo].[ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_PRODUTOS_AGRUPADOS_KIT_COMPLETO_INCOMPLETO]  WITH CHECK ADD FOREIGN KEY([IdRegistroComp])
REFERENCES [dbo].[COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE] ([IdRegistroComp])
GO
ALTER TABLE [dbo].[ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE]  WITH CHECK ADD FOREIGN KEY([IdKit])
REFERENCES [dbo].[KITS_HIGIENE_INTERNO] ([IdKit])
GO
ALTER TABLE [dbo].[ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_PRODUTOS_INTERNOS_PAVILHAO_KIT_LOTE]  WITH CHECK ADD FOREIGN KEY([IdRegistroComp])
REFERENCES [dbo].[COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE] ([IdRegistroComp])
GO
ALTER TABLE [dbo].[ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL]  WITH CHECK ADD FOREIGN KEY([IdCodigoProf])
REFERENCES [dbo].[PROFISSAO] ([IdCodigoProf])
GO
ALTER TABLE [dbo].[ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL]  WITH CHECK ADD FOREIGN KEY([IdHistoricoLab])
REFERENCES [dbo].[TO_HISTORICO_PROFISSIONAL] ([IdHistoricoLab])
GO
ALTER TABLE [dbo].[ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTOTERAPIA] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO]  WITH CHECK ADD FOREIGN KEY([IdATN])
REFERENCES [dbo].[ADMISSAO_TERAPIA_PE] ([IdATN])
GO
ALTER TABLE [dbo].[ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO]  WITH CHECK ADD FOREIGN KEY([IdCodigoProf])
REFERENCES [dbo].[PROFISSAO] ([IdCodigoProf])
GO
ALTER TABLE [dbo].[ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO]  WITH CHECK ADD FOREIGN KEY([IdHistoricoLabPN])
REFERENCES [dbo].[TO_HISTORICO_PROFISSIONAL_NOVO] ([IdHistoricoLabPN])
GO
ALTER TABLE [dbo].[ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR]  WITH CHECK ADD FOREIGN KEY([IdProrroga])
REFERENCES [dbo].[PRORROGAR_SAIDA_TEMPORARIA_PRISAO_DOMICILIAR] ([IdProrroga])
GO
ALTER TABLE [dbo].[ITENS_REGISTRO_CANCELADO_NE]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_REGISTRO_CANCELADO_NE]  WITH CHECK ADD FOREIGN KEY([IdRegCancel])
REFERENCES [dbo].[REGISTRO_CANCELADO_NE] ([IdRegCancel])
GO
ALTER TABLE [dbo].[ITENS_REGISTRO_CANCELADO_RETORNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_REGISTRO_CANCELADO_RETORNOS]  WITH CHECK ADD FOREIGN KEY([IdRegCancel])
REFERENCES [dbo].[REGISTRO_CANCELADO_RETORNOS] ([IdRegCancel])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS]  WITH CHECK ADD FOREIGN KEY([IdReq])
REFERENCES [dbo].[REQUISICAO_AVULSA_PRODUTOS] ([IdReq])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS_ENF]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS_ENF]  WITH CHECK ADD FOREIGN KEY([IdReq])
REFERENCES [dbo].[REQUISICAO_AVULSA_PRODUTOS_ENF] ([IdReq])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS_FAR]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS_FAR]  WITH CHECK ADD FOREIGN KEY([IdReq])
REFERENCES [dbo].[REQUISICAO_AVULSA_PRODUTOS_FAR] ([IdReq])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_AVULSA_PRODUTOS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdReq])
REFERENCES [dbo].[REQUISICAO_AVULSA_PRODUTOS_NUTRI] ([IdReq])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_CARDAPIO_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_CARDAPIO_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdReq])
REFERENCES [dbo].[REQUISICAO_PRODUTOS_CARDAPIO_NUTRI] ([IdReq])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_ENFERMARIA_ENFAR]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_ENFERMARIA_ENFAR]  WITH CHECK ADD FOREIGN KEY([IdSol])
REFERENCES [dbo].[REQUISICAO_PRODUTOS_ENFERMARIA_ENFAR] ([IdSol])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdReq])
REFERENCES [dbo].[REQUISICAO_PRODUTOS_INTERNOS] ([IdReq])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_INTERNOS_ENF]  WITH CHECK ADD FOREIGN KEY([IdReq])
REFERENCES [dbo].[REQUISICAO_PRODUTOS_INTERNOS_ENF] ([IdReq])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_INTERNOS_SEAC]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_INTERNOS_SEAC]  WITH CHECK ADD FOREIGN KEY([IdReq])
REFERENCES [dbo].[REQUISICAO_PRODUTOS_INTERNOS_SEAC] ([IdReq])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_REQUISICAO_PRODUTOS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdReq])
REFERENCES [dbo].[REQUISICAO_PRODUTOS_NUTRI] ([IdReq])
GO
ALTER TABLE [dbo].[ITENS_RESERVA_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdLivro])
REFERENCES [dbo].[LIVROS_REVISTAS_JORNAIS] ([IdLivro])
GO
ALTER TABLE [dbo].[ITENS_RESERVA_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdReserva])
REFERENCES [dbo].[RESERVA_ACERVO] ([IdReserva])
GO
ALTER TABLE [dbo].[ITENS_ROL_VISITAS_RELIGIOSA]  WITH CHECK ADD FOREIGN KEY([IdCod])
REFERENCES [dbo].[INSTITUICAO_RELIGIOSA] ([IdCod])
GO
ALTER TABLE [dbo].[ITENS_ROL_VISITAS_RELIGIOSA]  WITH CHECK ADD FOREIGN KEY([IdRol])
REFERENCES [dbo].[ROL_VISITAS_RELIGIOSA] ([IdRol])
GO
ALTER TABLE [dbo].[ITENS_ROL_VISITAS_RELIGIOSA]  WITH CHECK ADD FOREIGN KEY([IdVisitaRel])
REFERENCES [dbo].[VISITAS_RELIGIOSA_INTERNOS] ([IdVisitaRel])
GO
ALTER TABLE [dbo].[ITENS_SOLICITACAO_COMPRAS_ADM]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_SOLICITACAO_COMPRAS_ADM]  WITH CHECK ADD FOREIGN KEY([IdSol])
REFERENCES [dbo].[SOLICITACAO_PRODUTOS_ADM] ([IdSol])
GO
ALTER TABLE [dbo].[ITENS_SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO]  WITH CHECK ADD FOREIGN KEY([IdExame])
REFERENCES [dbo].[TIPOS_EXAMES_MEDICO] ([IdExame])
GO
ALTER TABLE [dbo].[ITENS_SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO]  WITH CHECK ADD FOREIGN KEY([IdSolExame])
REFERENCES [dbo].[SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO] ([IdSolExame])
GO
ALTER TABLE [dbo].[ITENS_SOLICITACAO_PRODUTOS_ADM]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_SOLICITACAO_PRODUTOS_ADM]  WITH CHECK ADD FOREIGN KEY([IdSol])
REFERENCES [dbo].[SOLICITACAO_PRODUTOS_ADM] ([IdSol])
GO
ALTER TABLE [dbo].[ITENS_SOLICITANTES_COMPRAS]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[ITENS_SOLICITANTES_COMPRAS]  WITH CHECK ADD FOREIGN KEY([IdSoli])
REFERENCES [dbo].[SOLICITANTES_COMPRAS] ([IdSoli])
GO
ALTER TABLE [dbo].[ITENS_TRANSFERENCIA_PRODUTO_FAR]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[TRANSFERENCIA_PRODUTO_FAR] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENS_TRANSFERENCIA_PRODUTO_FAR]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[ITENS_TRANSFERENCIA_PRODUTO_FAR]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[ITENS_TRANSIENTES_VISITAS_DIVERSAS]  WITH CHECK ADD FOREIGN KEY([IdTrans])
REFERENCES [dbo].[TRANSIENTES] ([IdTrans])
GO
ALTER TABLE [dbo].[ITENS_TRATAMENTOS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdAvalia])
REFERENCES [dbo].[AVALIACAO_MEDICA_PSIQUIATRICA] ([IdAvalia])
GO
ALTER TABLE [dbo].[ITENS_TRATAMENTOS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdDoenca])
REFERENCES [dbo].[DOENCAS] ([IdDoenca])
GO
ALTER TABLE [dbo].[ITENS_TRATAMENTOS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdTipo])
REFERENCES [dbo].[TIPOS_TRATAMENTOS] ([IdTipo])
GO
ALTER TABLE [dbo].[ITENS_VISITA_INTERNA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_VISITA_INTERNA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ENTRADAS_INTERNO_INTERNA] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENS_VISITA_INTERNO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENS_VISITA_INTERNO]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ENTRADAS_INTERNO_INTERNA] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSADMISSAODOENCAS]  WITH CHECK ADD FOREIGN KEY([IdDoenca])
REFERENCES [dbo].[DOENCAS] ([IdDoenca])
GO
ALTER TABLE [dbo].[ITENSADMISSAODOENCAS]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOMEDICA] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSADVOGADO]  WITH CHECK ADD FOREIGN KEY([IdAdvogado])
REFERENCES [dbo].[ADVOGADOS] ([IdAdvogado])
GO
ALTER TABLE [dbo].[ITENSADVOGADO]  WITH CHECK ADD FOREIGN KEY([IdDepartamento])
REFERENCES [dbo].[DEPARTAMENTOS] ([IdDepartamento])
GO
ALTER TABLE [dbo].[ITENSADVOGADO]  WITH CHECK ADD FOREIGN KEY([Idlanc])
REFERENCES [dbo].[ENTRADASADVOGADOS] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSADVOGADOINTERNOS]  WITH CHECK ADD FOREIGN KEY([IdAdvogado])
REFERENCES [dbo].[ADVOGADOS] ([IdAdvogado])
GO
ALTER TABLE [dbo].[ITENSADVOGADOINTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSADVOGADOINTERNOS]  WITH CHECK ADD FOREIGN KEY([Idlanc])
REFERENCES [dbo].[ENTRADASADVINTERNOS] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSAGENDA]  WITH CHECK ADD FOREIGN KEY([IdAgenda])
REFERENCES [dbo].[AGENDAESCOLTA] ([IdAgenda])
GO
ALTER TABLE [dbo].[ITENSAGENDA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSAGENDALABORATIVA]  WITH CHECK ADD FOREIGN KEY([IdAgenda])
REFERENCES [dbo].[AGENDALABORATIVA] ([IdAgenda])
GO
ALTER TABLE [dbo].[ITENSAGENDALABORATIVA]  WITH CHECK ADD FOREIGN KEY([IdEmp])
REFERENCES [dbo].[EMPRESALAB] ([IdEmp])
GO
ALTER TABLE [dbo].[ITENSAGENDALABORATIVA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSATENDIMENTOJURI]  WITH CHECK ADD FOREIGN KEY([IdAtiv])
REFERENCES [dbo].[ATIVIDADESJURIDICOS] ([IdAtiv])
GO
ALTER TABLE [dbo].[ITENSATENDIMENTOJURI]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSATENDIMENTOJURI]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTOJURIDICO] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSBAIXAINTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSBAIXAINTERNOS]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[BAIXAINTERNOS] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSCRCPORTARIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSDEPOSITOPORTARIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSDEPOSITOPORTARIA]  WITH CHECK ADD FOREIGN KEY([Idlanc])
REFERENCES [dbo].[DEPOSITOPORTARIA] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSENTRADA]  WITH CHECK ADD FOREIGN KEY([IdEntrada])
REFERENCES [dbo].[ENTRADALOTE] ([IdEntrada])
GO
ALTER TABLE [dbo].[ITENSENTRADA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSENTRADA]  WITH CHECK ADD FOREIGN KEY([IdUnid])
REFERENCES [dbo].[UNIDADE] ([IdUnid])
GO
ALTER TABLE [dbo].[ITENSENTRADAPORTARIA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ENTRADAINTERNOSPORTARIA] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSENTRADASFUNC]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[ITENSENTRADASFUNC]  WITH CHECK ADD FOREIGN KEY([Idlanc])
REFERENCES [dbo].[ENTRADASFUNC] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSFAMILIAR]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSFAMILIAR]  WITH CHECK ADD FOREIGN KEY([Idlanc])
REFERENCES [dbo].[ENTRADASFAMILIAR] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSFAMILIAR]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[ITENSFICHALAB]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSFICHALAB]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[FICHALABORATIVA] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSFREQUENCIA]  WITH CHECK ADD FOREIGN KEY([IdFreq])
REFERENCES [dbo].[FREQUENCIA] ([IdFreq])
GO
ALTER TABLE [dbo].[ITENSFREQUENCIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSLABORINTERNO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSLABORINTERNO]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ENTRADALABORINTERNO] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSLISTAESPERA]  WITH CHECK ADD FOREIGN KEY([IdCela])
REFERENCES [dbo].[CELAS] ([IdCela])
GO
ALTER TABLE [dbo].[ITENSLISTAESPERA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSLISTAESPERA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[LISTAESPERA] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSLOCACAOINTERNO]  WITH CHECK ADD FOREIGN KEY([IdCela])
REFERENCES [dbo].[CELAS] ([IdCela])
GO
ALTER TABLE [dbo].[ITENSLOCACAOINTERNO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSLOCACAOINTERNO]  WITH CHECK ADD FOREIGN KEY([IdLoca])
REFERENCES [dbo].[LOCACAOINTERNO] ([IdLoca])
GO
ALTER TABLE [dbo].[ITENSMATRICULA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSMATRICULA]  WITH CHECK ADD FOREIGN KEY([IdMat])
REFERENCES [dbo].[MATRICULAESCOLAR] ([IdMat])
GO
ALTER TABLE [dbo].[ITENSNOVAENTRADA]  WITH CHECK ADD FOREIGN KEY([IdEntrada])
REFERENCES [dbo].[ENTRADANOVA] ([IdEntrada])
GO
ALTER TABLE [dbo].[ITENSNOVAENTRADA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSOBJETOS]  WITH CHECK ADD FOREIGN KEY([IdEntrada])
REFERENCES [dbo].[ENTRADAOBJETOSPERTENCES] ([IdEntrada])
GO
ALTER TABLE [dbo].[ITENSOBJETOS]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCALPERTENCES] ([IdLocal])
GO
ALTER TABLE [dbo].[ITENSOBJETOS]  WITH CHECK ADD FOREIGN KEY([IdPertence])
REFERENCES [dbo].[PERTENCES] ([IdPertence])
GO
ALTER TABLE [dbo].[ITENSOBJETOSPROCEDIMENTO]  WITH CHECK ADD FOREIGN KEY([IdCela])
REFERENCES [dbo].[CELAS] ([IdCela])
GO
ALTER TABLE [dbo].[ITENSOBJETOSPROCEDIMENTO]  WITH CHECK ADD FOREIGN KEY([IdObjeto])
REFERENCES [dbo].[OBJETOSPROCEDIMENTOS] ([IdObjeto])
GO
ALTER TABLE [dbo].[ITENSOBJETOSPROCEDIMENTO]  WITH CHECK ADD FOREIGN KEY([IdProc])
REFERENCES [dbo].[PROCEDIMENTOS] ([IdProc])
GO
ALTER TABLE [dbo].[ITENSOBJETOSSAIDA]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCALPERTENCES] ([IdLocal])
GO
ALTER TABLE [dbo].[ITENSOBJETOSSAIDA]  WITH CHECK ADD FOREIGN KEY([IdPertence])
REFERENCES [dbo].[PERTENCES] ([IdPertence])
GO
ALTER TABLE [dbo].[ITENSOBJETOSSAIDA]  WITH CHECK ADD FOREIGN KEY([IdSaida])
REFERENCES [dbo].[SAIDAOBJETOSPERTENCES] ([IdSaida])
GO
ALTER TABLE [dbo].[ITENSPCIP]  WITH CHECK ADD FOREIGN KEY([IdCela])
REFERENCES [dbo].[CELAS] ([IdCela])
GO
ALTER TABLE [dbo].[ITENSPCIP]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[ITENSPCIP]  WITH CHECK ADD FOREIGN KEY([IdProc])
REFERENCES [dbo].[PROCEDIMENTOS] ([IdProc])
GO
ALTER TABLE [dbo].[ITENSPERTENCES]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSPERTENCES]  WITH CHECK ADD FOREIGN KEY([Idlanc])
REFERENCES [dbo].[ENTRADAPERTENCES] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSPERTENCES]  WITH CHECK ADD FOREIGN KEY([IdPertence])
REFERENCES [dbo].[PERTENCES] ([IdPertence])
GO
ALTER TABLE [dbo].[ITENSPERTENCES]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[ITENSPREVISAOSAIDA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSPREVISAOSAIDA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[PREVISAOSAIDA] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSPROGRESSAOREGIME]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSPROGRESSAOREGIME]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[PROGRESSAOREGIME] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSRECAPTURA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSRECAPTURA]  WITH CHECK ADD FOREIGN KEY([IdRecaptura])
REFERENCES [dbo].[RECAPTURA] ([IdRecaptura])
GO
ALTER TABLE [dbo].[ITENSREGISTRO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSREGISTRO]  WITH CHECK ADD FOREIGN KEY([IdRetorno])
REFERENCES [dbo].[REGRETORNO] ([IdRetorno])
GO
ALTER TABLE [dbo].[ITENSREGISTROCANCELADO]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[REGISTROCANCELADO] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSREGRESSAOREGIME]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSREGRESSAOREGIME]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[REGRESSAOREGIME] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSREGSAIDA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSREGSAIDA]  WITH CHECK ADD FOREIGN KEY([IdSaida])
REFERENCES [dbo].[REGSAIDACRC] ([IdSaida])
GO
ALTER TABLE [dbo].[ITENSRETORNO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSRETORNO]  WITH CHECK ADD FOREIGN KEY([IdRetorno])
REFERENCES [dbo].[RETORNOSCRC] ([IdRetorno])
GO
ALTER TABLE [dbo].[ITENSRETORNOAUDIENCIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSRETORNOAUDIENCIA]  WITH CHECK ADD FOREIGN KEY([IdRetorno])
REFERENCES [dbo].[RETORNOAUDIENCIA] ([IdRetorno])
GO
ALTER TABLE [dbo].[ITENSRETORNOESPONTANEO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSRETORNOESPONTANEO]  WITH CHECK ADD FOREIGN KEY([IdRetorno])
REFERENCES [dbo].[RETORNOESPONTANEO] ([IdRetorno])
GO
ALTER TABLE [dbo].[ITENSRETORNOMEDICO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSRETORNOMEDICO]  WITH CHECK ADD FOREIGN KEY([IdRetorno])
REFERENCES [dbo].[RETORNOMEDICO] ([IdRetorno])
GO
ALTER TABLE [dbo].[ITENSRETORNOTRANSFERENCIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSRETORNOTRANSFERENCIA]  WITH CHECK ADD FOREIGN KEY([IdRetorno])
REFERENCES [dbo].[RETORNOTRANSFERENCIA] ([IdRetorno])
GO
ALTER TABLE [dbo].[ITENSROL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSROL]  WITH CHECK ADD FOREIGN KEY([IdRol])
REFERENCES [dbo].[ROLVISITAS] ([IdRol])
GO
ALTER TABLE [dbo].[ITENSROL]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[ITENSSAIDA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSSAIDA]  WITH CHECK ADD FOREIGN KEY([IdSaida])
REFERENCES [dbo].[SAIDACRC] ([IdSaida])
GO
ALTER TABLE [dbo].[ITENSTFDISCIPLINA]  WITH CHECK ADD FOREIGN KEY([IdDisc])
REFERENCES [dbo].[DISCIPLINAS] ([IdDisc])
GO
ALTER TABLE [dbo].[ITENSTFDISCIPLINA]  WITH CHECK ADD FOREIGN KEY([IdTempo])
REFERENCES [dbo].[TEMPOFORMATIVO] ([IdTempo])
GO
ALTER TABLE [dbo].[ITENSTRANSFERENCIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ITENSTRANSFERENCIA]  WITH CHECK ADD FOREIGN KEY([IdTransf])
REFERENCES [dbo].[TRANSFERENCIACRC] ([IdTransf])
GO
ALTER TABLE [dbo].[ITENSTRANSFERENCIA]  WITH CHECK ADD FOREIGN KEY([idUnid])
REFERENCES [dbo].[UNIDADE] ([IdUnid])
GO
ALTER TABLE [dbo].[ITENSVEICULOCARGA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ENTRADAVEICULOCARGA] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSVEICULOCARGA]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASDIVERSAS] ([IdVisita])
GO
ALTER TABLE [dbo].[ITENSVEICULOSTERCEIRO]  WITH CHECK ADD FOREIGN KEY([Idlanc])
REFERENCES [dbo].[ENTRADAVEICULOSTERCEIRO] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSVEICULOSTERCEIRO]  WITH CHECK ADD FOREIGN KEY([IdVeiculo])
REFERENCES [dbo].[VEICULOS] ([IdVeiculo])
GO
ALTER TABLE [dbo].[ITENSVEICULOSTERCEIRO]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASDIVERSAS] ([IdVisita])
GO
ALTER TABLE [dbo].[ITENSVEICULOSUNIDADE]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[ITENSVEICULOSUNIDADE]  WITH CHECK ADD FOREIGN KEY([Idlanc])
REFERENCES [dbo].[ENTRADAVEICULOSUNIDADE] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSVEICULOSUNIDADE]  WITH CHECK ADD FOREIGN KEY([IdVeiculo])
REFERENCES [dbo].[VEICULOS] ([IdVeiculo])
GO
ALTER TABLE [dbo].[ITENSVISITASDIVERSAS]  WITH CHECK ADD FOREIGN KEY([IdDepartamento])
REFERENCES [dbo].[DEPARTAMENTOS] ([IdDepartamento])
GO
ALTER TABLE [dbo].[ITENSVISITASDIVERSAS]  WITH CHECK ADD FOREIGN KEY([Idlanc])
REFERENCES [dbo].[ENTRADASVISITAS] ([IdLanc])
GO
ALTER TABLE [dbo].[ITENSVISITASDIVERSAS]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASDIVERSAS] ([IdVisita])
GO
ALTER TABLE [dbo].[KITS_ANUAL_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[KITS_DECENDIAL_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[KITS_INICIAL_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[KITS_MENSAL_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[KITS_QUINZENAL_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[KITS_SEMESTRAL_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[L1A_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[L1A_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdOrg])
REFERENCES [dbo].[ORGANOGRAMA_CRIME] ([IdOrg])
GO
ALTER TABLE [dbo].[L1B_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[L1B_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdOrg])
REFERENCES [dbo].[ORGANOGRAMA_CRIME] ([IdOrg])
GO
ALTER TABLE [dbo].[L1C_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[L1C_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdOrg])
REFERENCES [dbo].[ORGANOGRAMA_CRIME] ([IdOrg])
GO
ALTER TABLE [dbo].[L1D_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[L1D_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdOrg])
REFERENCES [dbo].[ORGANOGRAMA_CRIME] ([IdOrg])
GO
ALTER TABLE [dbo].[L2A_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[L2A_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdOrg])
REFERENCES [dbo].[ORGANOGRAMA_CRIME] ([IdOrg])
GO
ALTER TABLE [dbo].[L2B_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[L2B_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdOrg])
REFERENCES [dbo].[ORGANOGRAMA_CRIME] ([IdOrg])
GO
ALTER TABLE [dbo].[L2C_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[L2C_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdOrg])
REFERENCES [dbo].[ORGANOGRAMA_CRIME] ([IdOrg])
GO
ALTER TABLE [dbo].[L2D_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[L2D_ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdOrg])
REFERENCES [dbo].[ORGANOGRAMA_CRIME] ([IdOrg])
GO
ALTER TABLE [dbo].[LIBERADOR_ESCOLTA_INTERNO_PSP]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[LIBERADORES_BANCO_VIRTUAL]  WITH CHECK ADD FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[USUARIOS] ([IdUsuario])
GO
ALTER TABLE [dbo].[LISTA_DOCUMENTOS_INTERNO_CRC]  WITH CHECK ADD FOREIGN KEY([IdChek])
REFERENCES [dbo].[CHECK_LIST_DOCUMENTOS_INTERNO_CRC] ([IdChek])
GO
ALTER TABLE [dbo].[LISTA_DOCUMENTOS_INTERNO_CRC]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[LISTA_PASSAGEM_ALBERGADOS]  WITH CHECK ADD FOREIGN KEY([IdOp])
REFERENCES [dbo].[OPERACAO] ([IdOp])
GO
ALTER TABLE [dbo].[LIVROS_REVISTAS_JORNAIS]  WITH CHECK ADD FOREIGN KEY([IdCat])
REFERENCES [dbo].[CATEGORIA_LIVROS] ([IdCat])
GO
ALTER TABLE [dbo].[LIVROS_REVISTAS_JORNAIS]  WITH CHECK ADD FOREIGN KEY([IdForn])
REFERENCES [dbo].[EDITORAS_INSTITUICAO] ([IdForn])
GO
ALTER TABLE [dbo].[LIVROS_REVISTAS_JORNAIS]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ACERVO] ([IdLocal])
GO
ALTER TABLE [dbo].[LOCACAOINTERNO]  WITH CHECK ADD FOREIGN KEY([IdCela])
REFERENCES [dbo].[CELAS] ([IdCela])
GO
ALTER TABLE [dbo].[LOCALINTERNOS]  WITH CHECK ADD FOREIGN KEY([IdCela])
REFERENCES [dbo].[CELAS] ([IdCela])
GO
ALTER TABLE [dbo].[LOCALINTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[LOTE_PRODUTOS_AC]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[LOTE_PRODUTOS_ENF]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[MATRICULAESCOLAR]  WITH CHECK ADD FOREIGN KEY([IdCarga])
REFERENCES [dbo].[CARGAHORARIA] ([IdCarga])
GO
ALTER TABLE [dbo].[MATRICULAESCOLAR]  WITH CHECK ADD FOREIGN KEY([IdCod])
REFERENCES [dbo].[INSTITUICAOESCOLAR] ([IdCod])
GO
ALTER TABLE [dbo].[MATRICULAESCOLAR]  WITH CHECK ADD FOREIGN KEY([IdSala])
REFERENCES [dbo].[SALAS] ([IdSala])
GO
ALTER TABLE [dbo].[MATRICULAESCOLAR]  WITH CHECK ADD FOREIGN KEY([IdTempo])
REFERENCES [dbo].[TEMPOFORMATIVO] ([IdTempo])
GO
ALTER TABLE [dbo].[MOVIMENTACAO_KITS_HIGIENE_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[MOVIMENTOCRC]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[MOVISR]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[MOVTECNICO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[NF_COMPRAS]  WITH CHECK ADD FOREIGN KEY([IdForn])
REFERENCES [dbo].[FORNECEDORES_AC] ([IdForn])
GO
ALTER TABLE [dbo].[NF_COMPRAS_FAR]  WITH CHECK ADD FOREIGN KEY([IdForn])
REFERENCES [dbo].[FORNECEDORES_AC] ([IdForn])
GO
ALTER TABLE [dbo].[NF_COMPRAS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdForn])
REFERENCES [dbo].[FORNECEDORES_AC] ([IdForn])
GO
ALTER TABLE [dbo].[OBITOS_INTERNOS_EXTERNO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[OCORRENCIA_AUTORES]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[OCORRENCIA_AUTORES]  WITH CHECK ADD FOREIGN KEY([IdReg])
REFERENCES [dbo].[REGIMENTO_DISCIPLINAR_INTERNOS] ([IdReg])
GO
ALTER TABLE [dbo].[OCORRENCIA_INDISCIPLINA_PORTARIA]  WITH CHECK ADD FOREIGN KEY([IdReg])
REFERENCES [dbo].[REGISTRO_INDISCIPLINA_PORTARIA] ([IdReg])
GO
ALTER TABLE [dbo].[OCORRENCIA_INDISCIPLINA_PORTARIA]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdReg])
REFERENCES [dbo].[REGISTRO_INDISCIPLINA_PORTARIA] ([IdReg])
GO
ALTER TABLE [dbo].[ODONTOGRAMA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ODONTOGRAMA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTODONTO] ([IdLanc])
GO
ALTER TABLE [dbo].[ODONTOGRAMA]  WITH CHECK ADD FOREIGN KEY([IdProcOdonto])
REFERENCES [dbo].[PROCEDIMENTOS_ODONTOLOGICO] ([IdProcOdonto])
GO
ALTER TABLE [dbo].[ODONTOGRAMA_ADMISSAO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ODONTOGRAMA_ADMISSAO]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTODONTO] ([IdLanc])
GO
ALTER TABLE [dbo].[ODONTOGRAMA_ADMISSAO]  WITH CHECK ADD FOREIGN KEY([IdProcOdonto])
REFERENCES [dbo].[PROCEDIMENTOS_ODONTOLOGICO] ([IdProcOdonto])
GO
ALTER TABLE [dbo].[ODONTOGRAMA_EVOLUCAO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ODONTOGRAMA_EVOLUCAO]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTODONTO] ([IdLanc])
GO
ALTER TABLE [dbo].[ODONTOGRAMA_EVOLUCAO]  WITH CHECK ADD FOREIGN KEY([IdProcOdonto])
REFERENCES [dbo].[PROCEDIMENTOS_ODONTOLOGICO] ([IdProcOdonto])
GO
ALTER TABLE [dbo].[ODONTOPROCEDIMENTO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ODONTOPROCEDIMENTO]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTODONTO] ([IdLanc])
GO
ALTER TABLE [dbo].[ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdCela])
REFERENCES [dbo].[CELAS] ([IdCela])
GO
ALTER TABLE [dbo].[ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[ORGANOGRAMA_CRIME]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[PAGAMENTO_KIT_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[PAGAMENTO_REFEICAO]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[PAI_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PARCELAS_COMPRAS]  WITH CHECK ADD FOREIGN KEY([IdForn])
REFERENCES [dbo].[FORNECEDORES_AC] ([IdForn])
GO
ALTER TABLE [dbo].[PARCELAS_COMPRAS]  WITH CHECK ADD FOREIGN KEY([IdNfEntrada])
REFERENCES [dbo].[NF_COMPRAS] ([IdNfEntrada])
GO
ALTER TABLE [dbo].[PARCELAS_COMPRAS_FAR]  WITH CHECK ADD FOREIGN KEY([IdForn])
REFERENCES [dbo].[FORNECEDORES_AC] ([IdForn])
GO
ALTER TABLE [dbo].[PARCELAS_COMPRAS_FAR]  WITH CHECK ADD FOREIGN KEY([IdNfEntrada])
REFERENCES [dbo].[NF_COMPRAS_FAR] ([IdNfEntrada])
GO
ALTER TABLE [dbo].[PARCELAS_COMPRAS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdForn])
REFERENCES [dbo].[FORNECEDORES_AC] ([IdForn])
GO
ALTER TABLE [dbo].[PARCELAS_COMPRAS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdNfEntrada])
REFERENCES [dbo].[NF_COMPRAS_NUTRI] ([IdNfEntrada])
GO
ALTER TABLE [dbo].[PARECER_PSI]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PARECER_PSI]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOPSI] ([IdLanc])
GO
ALTER TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_EF]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoEF])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_EF] ([IdAtGrupoEF])
GO
ALTER TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_EF]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoEnf])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_ENFERMAGEM] ([IdAtGrupoEnf])
GO
ALTER TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_ENFERMAGEM]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_PE]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoPE])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_PE] ([IdAtGrupoPE])
GO
ALTER TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_PE]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_PSICOLOGIA]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoPsi])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_PSICOLOGIA] ([IdAtGrupoPsi])
GO
ALTER TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_PSICOLOGIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_SS]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoSS])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_SS] ([IdAtGrupoSS])
GO
ALTER TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_SS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_TO]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoTO])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_TO] ([IdAtGrupoTO])
GO
ALTER TABLE [dbo].[PARTICIPANTES_ATENDIMENTO_GRUPO_TO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PATOLOGIA_EVOLUCAO_MEDICA]  WITH CHECK ADD FOREIGN KEY([IdDoenca])
REFERENCES [dbo].[DOENCAS] ([IdDoenca])
GO
ALTER TABLE [dbo].[PATOLOGIA_EVOLUCAO_MEDICA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PATOLOGIA_EVOLUCAO_MEDICA]  WITH CHECK ADD FOREIGN KEY([IdItem])
REFERENCES [dbo].[EVOLUCAOMEDICA] ([IdItem])
GO
ALTER TABLE [dbo].[PATOLOGIA_EVOLUCAO_PSIQUIATRICA]  WITH CHECK ADD FOREIGN KEY([IdDoenca])
REFERENCES [dbo].[DOENCAS] ([IdDoenca])
GO
ALTER TABLE [dbo].[PATOLOGIA_EVOLUCAO_PSIQUIATRICA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PATOLOGIA_EVOLUCAO_PSIQUIATRICA]  WITH CHECK ADD FOREIGN KEY([IdItem])
REFERENCES [dbo].[EVOLUCAO_PSIQUIATRICA] ([IdItem])
GO
ALTER TABLE [dbo].[PDF_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PECULIARIDADE_COSTAS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PECULIARIDADE_FRENTE]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PERFIL_CARCERARIO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PERFIL_CARCERARIO]  WITH CHECK ADD FOREIGN KEY([IdPerfil])
REFERENCES [dbo].[PERFIL_CARCERARIO_INTERNO] ([IdPerfil])
GO
ALTER TABLE [dbo].[PERFIL_CARCERARIO_INTERNO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_EF]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoEF])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_EF] ([IdAtGrupoEF])
GO
ALTER TABLE [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoEnf])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_ENFERMAGEM] ([IdAtGrupoEnf])
GO
ALTER TABLE [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_PE]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoPE])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_PE] ([IdAtGrupoPE])
GO
ALTER TABLE [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_PSICOLOGIA]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoPsi])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_PSICOLOGIA] ([IdAtGrupoPsi])
GO
ALTER TABLE [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_SS]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoSS])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_SS] ([IdAtGrupoSS])
GO
ALTER TABLE [dbo].[PLANEJAMENTO_ATENDIMENTO_GRUPO_TO]  WITH CHECK ADD FOREIGN KEY([IdAtGrupoTO])
REFERENCES [dbo].[ATENDIMENTO_GRUPO_TO] ([IdAtGrupoTO])
GO
ALTER TABLE [dbo].[POPAGENTES]  WITH CHECK ADD FOREIGN KEY([IdPopMov])
REFERENCES [dbo].[MOVPOPULACAO] ([IdPopMov])
GO
ALTER TABLE [dbo].[POPBRASFEM]  WITH CHECK ADD FOREIGN KEY([IdPopMov])
REFERENCES [dbo].[MOVPOPULACAO] ([IdPopMov])
GO
ALTER TABLE [dbo].[POPBRASMASC]  WITH CHECK ADD FOREIGN KEY([IdPopMov])
REFERENCES [dbo].[MOVPOPULACAO] ([IdPopMov])
GO
ALTER TABLE [dbo].[POPESTRANGFEM]  WITH CHECK ADD FOREIGN KEY([IdPopMov])
REFERENCES [dbo].[MOVPOPULACAO] ([IdPopMov])
GO
ALTER TABLE [dbo].[POPESTRANGMASC]  WITH CHECK ADD FOREIGN KEY([IdPopMov])
REFERENCES [dbo].[MOVPOPULACAO] ([IdPopMov])
GO
ALTER TABLE [dbo].[POPULACAOINTERNOS_CRC]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PORTA_ENTRADA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PORTA_ENTRADA_PSICOLOGIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PORTA_ENTRADA_PSICOLOGIA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ADMISSAOPSI] ([IdLanc])
GO
ALTER TABLE [dbo].[PORTA_ENTRADA_SERVICO_SOCIAL]  WITH CHECK ADD FOREIGN KEY([IdAtend])
REFERENCES [dbo].[ATENDIMENTOSOCIAL] ([IdAtend])
GO
ALTER TABLE [dbo].[PORTA_ENTRADA_SERVICO_SOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PRESCRICAO_MEDICA_PSIQUIATRICA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PRESCRICAO_ODONTOLOGIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PRESCRICAO_ODONTOLOGIA]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTODONTO] ([IdLanc])
GO
ALTER TABLE [dbo].[PREVISAOSAIDA]  WITH CHECK ADD FOREIGN KEY([IdOp])
REFERENCES [dbo].[OPERACAO] ([IdOp])
GO
ALTER TABLE [dbo].[PROCESSOS_JURIDICOS]  WITH CHECK ADD FOREIGN KEY([IdFicha])
REFERENCES [dbo].[FICHA_JURIDICA] ([IdFicha])
GO
ALTER TABLE [dbo].[PRODUTOS_AC]  WITH CHECK ADD FOREIGN KEY([IdForn])
REFERENCES [dbo].[FORNECEDORES_AC] ([IdForn])
GO
ALTER TABLE [dbo].[PRODUTOS_AC]  WITH CHECK ADD FOREIGN KEY([IdGrupo])
REFERENCES [dbo].[GRUPO_PRODUTOS_AC] ([IdGrupo])
GO
ALTER TABLE [dbo].[PRODUTOS_AC]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[PRODUTOS_KITS_HIGIENE_INTERNO]  WITH CHECK ADD FOREIGN KEY([IdKit])
REFERENCES [dbo].[KITS_HIGIENE_INTERNO] ([IdKit])
GO
ALTER TABLE [dbo].[PRODUTOS_KITS_HIGIENE_INTERNO]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[PROFESSORES]  WITH CHECK ADD FOREIGN KEY([IdCod])
REFERENCES [dbo].[INSTITUICAOESCOLAR] ([IdCod])
GO
ALTER TABLE [dbo].[PROGRAMACAO_PAGAMENTO_KITS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdKit])
REFERENCES [dbo].[KITS_HIGIENE_INTERNO] ([IdKit])
GO
ALTER TABLE [dbo].[PROGRAMACAO_PAGAMENTO_KITS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[PRONTUARIOSCRC]  WITH CHECK ADD FOREIGN KEY([IdCidade])
REFERENCES [dbo].[CIDADES] ([IdCidade])
GO
ALTER TABLE [dbo].[PRONTUARIOSCRC]  WITH CHECK ADD FOREIGN KEY([IdPais])
REFERENCES [dbo].[PAISES] ([IdPais])
GO
ALTER TABLE [dbo].[PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PSICOLOGIA_MEDICO_PAI_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[PSICOLOGIA_PAI_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[PSICOLOGIA_PAI_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[RECAPTURA]  WITH CHECK ADD FOREIGN KEY([IdOp])
REFERENCES [dbo].[OPERACAO] ([IdOp])
GO
ALTER TABLE [dbo].[REGIMENTO_DISCIPLINAR_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[REGIMENTO_DISCIPLINAR_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCALEVENTOS] ([IdLocal])
GO
ALTER TABLE [dbo].[REGIMENTO_DISCIPLINAR_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdNatureza])
REFERENCES [dbo].[NATUREZAEVENTOS] ([IdNatureza])
GO
ALTER TABLE [dbo].[REGISTRO_ATENDIMENTO_INTERNO_PSP]  WITH CHECK ADD FOREIGN KEY([IdDepartamento])
REFERENCES [dbo].[DEPARTAMENTOS] ([IdDepartamento])
GO
ALTER TABLE [dbo].[REGISTRO_ATENDIMENTO_INTERNO_PSP]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA]  WITH CHECK ADD FOREIGN KEY([IdRol])
REFERENCES [dbo].[ROLVISITAS] ([IdRol])
GO
ALTER TABLE [dbo].[REGISTRO_CHEGADA_VISITAS_INTERNOS_PORTARIA_EXTERNA]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[REGISTRO_INDISCIPLINA_PORTARIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[REGISTROEVENTOS]  WITH CHECK ADD FOREIGN KEY([IdCela])
REFERENCES [dbo].[CELAS] ([IdCela])
GO
ALTER TABLE [dbo].[REGISTROEVENTOS]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCALEVENTOS] ([IdLocal])
GO
ALTER TABLE [dbo].[REGISTROEVENTOS]  WITH CHECK ADD FOREIGN KEY([IdNatureza])
REFERENCES [dbo].[NATUREZAEVENTOS] ([IdNatureza])
GO
ALTER TABLE [dbo].[REGISTROEVENTOS]  WITH CHECK ADD FOREIGN KEY([IdPav])
REFERENCES [dbo].[PAVILHAO] ([IdPav])
GO
ALTER TABLE [dbo].[REGOBSERVACOES]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[REGRETORNO]  WITH CHECK ADD FOREIGN KEY([IdOp])
REFERENCES [dbo].[OPERACAO] ([IdOp])
GO
ALTER TABLE [dbo].[REQUISICAO_AVULSA_PRODUTOS]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[REQUISICAO_AVULSA_PRODUTOS]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[REQUISICAO_AVULSA_PRODUTOS_ENF]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[REQUISICAO_AVULSA_PRODUTOS_ENF]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[REQUISICAO_AVULSA_PRODUTOS_FAR]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[REQUISICAO_AVULSA_PRODUTOS_FAR]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[REQUISICAO_AVULSA_PRODUTOS_FAR]  WITH CHECK ADD FOREIGN KEY([IdMot])
REFERENCES [dbo].[MOTIVO_SAIDA_PRODUTOS_FAR] ([IdMot])
GO
ALTER TABLE [dbo].[REQUISICAO_AVULSA_PRODUTOS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[REQUISICAO_AVULSA_PRODUTOS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_CARDAPIO_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_CARDAPIO_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_ENFERMARIA_ENFAR]  WITH CHECK ADD FOREIGN KEY([IdFuncSolici])
REFERENCES [dbo].[SOLICITANTE_REQUISICAO_MEDICAMENTOS_ENFAR] ([IdFuncSolici])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_ENFERMARIA_ENFAR]  WITH CHECK ADD FOREIGN KEY([IdFuncAprova])
REFERENCES [dbo].[APROVADOR_REQUISICAO_MEDICAMENTOS_ENFAR] ([IdFuncAprova])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_ENFERMARIA_ENFAR]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_INTERNOS]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_INTERNOS_ENF]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_INTERNOS_ENF]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_INTERNOS_ENF]  WITH CHECK ADD FOREIGN KEY([IdItem])
REFERENCES [dbo].[PRESCRICAO_MEDICA_PSIQUIATRICA] ([IdItem])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_INTERNOS_ENF]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_INTERNOS_SEAC]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_INTERNOS_SEAC]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_INTERNOS_SEAC]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[REQUISICAO_PRODUTOS_NUTRI]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[RESENHA_REMICAO_INTERNO]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[RESENHA_REMICAO_INTERNO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[RESENHA_REMICAO_INTERNO]  WITH CHECK ADD FOREIGN KEY([IdLivro])
REFERENCES [dbo].[LIVROS_REVISTAS_JORNAIS] ([IdLivro])
GO
ALTER TABLE [dbo].[RESERVA_ACERVO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[RETIRADAINTERNO]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[RETIRADAINTERNO]  WITH CHECK ADD FOREIGN KEY([IdNatureza])
REFERENCES [dbo].[NATUREZAEVENTOS] ([IdNatureza])
GO
ALTER TABLE [dbo].[RETORNOAUDIENCIA]  WITH CHECK ADD FOREIGN KEY([IdOp])
REFERENCES [dbo].[OPERACAO] ([IdOp])
GO
ALTER TABLE [dbo].[RETORNOESPONTANEO]  WITH CHECK ADD FOREIGN KEY([IdOp])
REFERENCES [dbo].[OPERACAO] ([IdOp])
GO
ALTER TABLE [dbo].[RETORNOMEDICO]  WITH CHECK ADD FOREIGN KEY([IdOp])
REFERENCES [dbo].[OPERACAO] ([IdOp])
GO
ALTER TABLE [dbo].[RETORNOSCRC]  WITH CHECK ADD FOREIGN KEY([IdOp])
REFERENCES [dbo].[OPERACAO] ([IdOp])
GO
ALTER TABLE [dbo].[RETORNOTRANSFERENCIA]  WITH CHECK ADD FOREIGN KEY([IdOp])
REFERENCES [dbo].[OPERACAO] ([IdOp])
GO
ALTER TABLE [dbo].[REVALIDAR_ATESTADO_RECLUSAO]  WITH CHECK ADD FOREIGN KEY([IdAtestado])
REFERENCES [dbo].[EMISSAO_ATESTADO_RECLUSAO] ([IdAtestado])
GO
ALTER TABLE [dbo].[REVALIDAR_ATESTADO_RECLUSAO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[REVALIDAR_ATESTADO_RECLUSAO]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[ROL_VISITAS_RELIGIOSA]  WITH CHECK ADD FOREIGN KEY([IdCod])
REFERENCES [dbo].[INSTITUICAO_RELIGIOSA] ([IdCod])
GO
ALTER TABLE [dbo].[ROLVISITAS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SAIDACRC]  WITH CHECK ADD FOREIGN KEY([IdOp])
REFERENCES [dbo].[OPERACAO] ([IdOp])
GO
ALTER TABLE [dbo].[SAIDAOBJETOSPERTENCES]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SALDO_ESTOQUE_AC]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[SALDO_ESTOQUE_AC]  WITH CHECK ADD FOREIGN KEY([IdProd])
REFERENCES [dbo].[PRODUTOS_AC] ([IdProd])
GO
ALTER TABLE [dbo].[SALDO_VALORES_INATIVOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SALDOVALORES]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SAQUE]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SAQUE_INATIVOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SENTENCAS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SENTENCAS]  WITH CHECK ADD FOREIGN KEY([IdUnid])
REFERENCES [dbo].[UNIDADE] ([IdUnid])
GO
ALTER TABLE [dbo].[SINALIZATECNICO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SOCIAL1_PAI_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SOCIAL1_PAI_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[SOCIAL2_FAMILIAR_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SOCIAL2_FAMILIAR_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[SOCIAL2_FAMILIAR_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[SOCIAL2_PAI_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SOCIAL2_PAI_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[SOCIAL2_VISITA_INTIMA_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SOCIAL2_VISITA_INTIMA_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[SOCIAL2_VISITA_INTIMA_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[SOCIALIZACAO_ADMISSAO_PEDAGOGIA]  WITH CHECK ADD FOREIGN KEY([IdAdm])
REFERENCES [dbo].[ADMISSAO_PEDAGOGIA] ([IdAdm])
GO
ALTER TABLE [dbo].[SOCIALIZACAO_ADMISSAO_PEDAGOGIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SOCIALIZACAO_ADMISSAO_PEDAGOGIA_NOVA]  WITH CHECK ADD FOREIGN KEY([IdAdmNova])
REFERENCES [dbo].[ADMISSAO_PEDAGOGIA_NOVA] ([IdAdmNova])
GO
ALTER TABLE [dbo].[SOCIALIZACAO_ADMISSAO_PEDAGOGIA_NOVA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SOLICITACAO_ATESTADO_RECLUSAO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SOLICITACAO_ATESTADO_RECLUSAO]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[SOLICITACAO_ATESTADO_RECLUSAO_CRC]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SOLICITACAO_EXAMES_MEDICO_PSIQUIATRICO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SOLICITACAO_PRODUTOS_ADM]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[SOLICITACAO_PRODUTOS_ADM]  WITH CHECK ADD FOREIGN KEY([IdFuncAprova])
REFERENCES [dbo].[APROVADOR_SOLICITACAO_COMPRAS_AC] ([IdFuncAprova])
GO
ALTER TABLE [dbo].[SOLICITACAO_PRODUTOS_ADM]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[SOLICITANTE_REQUISICAO_MEDICAMENTOS_ENFAR]  WITH CHECK ADD FOREIGN KEY([IdDepartamento])
REFERENCES [dbo].[DEPARTAMENTOS] ([IdDepartamento])
GO
ALTER TABLE [dbo].[SOLICITANTES_COMPRAS]  WITH CHECK ADD FOREIGN KEY([IdDepartamento])
REFERENCES [dbo].[DEPARTAMENTOS] ([IdDepartamento])
GO
ALTER TABLE [dbo].[SS3_PAI_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[SS3_PAI_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[STATUS_INTERNO_PSICOLOGIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[TELAS]  WITH CHECK ADD FOREIGN KEY([IdModulo])
REFERENCES [dbo].[MODULOS] ([IdModulo])
GO
ALTER TABLE [dbo].[TEMPOFORMATIVO]  WITH CHECK ADD FOREIGN KEY([IdTurno])
REFERENCES [dbo].[TURNOSAULA] ([IdTurno])
GO
ALTER TABLE [dbo].[TERAPIA_PEDAGOGIA_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[TERAPIA_PEDAGOGIA_PSICOSOCIAL]  WITH CHECK ADD FOREIGN KEY([IdPai])
REFERENCES [dbo].[PAI_PSICOSOCIAL] ([IdPai])
GO
ALTER TABLE [dbo].[TO_HISTORICO_EDUCACIONAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[TO_HISTORICO_EDUCACIONAL]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTOTERAPIA] ([IdLanc])
GO
ALTER TABLE [dbo].[TO_HISTORICO_EDUCACIONAL_NOVO]  WITH CHECK ADD FOREIGN KEY([IdATN])
REFERENCES [dbo].[ADMISSAO_TERAPIA_PE] ([IdATN])
GO
ALTER TABLE [dbo].[TO_HISTORICO_EDUCACIONAL_NOVO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[TO_HISTORICO_PROFISSIONAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[TO_HISTORICO_PROFISSIONAL]  WITH CHECK ADD FOREIGN KEY([IdLanc])
REFERENCES [dbo].[ATENDIMENTOTERAPIA] ([IdLanc])
GO
ALTER TABLE [dbo].[TO_HISTORICO_PROFISSIONAL_NOVO]  WITH CHECK ADD FOREIGN KEY([IdATN])
REFERENCES [dbo].[ADMISSAO_TERAPIA_PE] ([IdATN])
GO
ALTER TABLE [dbo].[TO_HISTORICO_PROFISSIONAL_NOVO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[TRANSFERENCIA_PRODUTO_FAR]  WITH CHECK ADD FOREIGN KEY([IdFunc])
REFERENCES [dbo].[COLABORADOR] ([IdFunc])
GO
ALTER TABLE [dbo].[TRANSFERENCIA_PRODUTO_FAR]  WITH CHECK ADD FOREIGN KEY([IdLocal])
REFERENCES [dbo].[LOCAL_ARMAZENAMENTO_AC] ([IdLocal])
GO
ALTER TABLE [dbo].[TRANSFERENCIA_VALORES_INATIVOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[TRANSFERENCIACRC]  WITH CHECK ADD FOREIGN KEY([IdOp])
REFERENCES [dbo].[OPERACAO] ([IdOp])
GO
ALTER TABLE [dbo].[TRANSFERENCIALOCAL]  WITH CHECK ADD FOREIGN KEY([IdCela])
REFERENCES [dbo].[CELAS] ([IdCela])
GO
ALTER TABLE [dbo].[TRANSFERENCIALOCAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[TRATAMENTO_PSICOLOGICO]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[TRATAMENTO_PSICOLOGICO]  WITH CHECK ADD FOREIGN KEY([IdTipo])
REFERENCES [dbo].[TIPOS_TRATAMENTO_PSICOLOGICO] ([IdTipo])
GO
ALTER TABLE [dbo].[TRIAGEM_OCUPACIONAL]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[UNIDADE_PENAL_EMPRESA]  WITH CHECK ADD FOREIGN KEY([IdEmpresa])
REFERENCES [dbo].[EMPRESA] ([IdEmpresa])
GO
ALTER TABLE [dbo].[USUARIOS_GRUPOS]  WITH CHECK ADD FOREIGN KEY([IdGrupo])
REFERENCES [dbo].[GRUPOUSUARIOS] ([IdGrupo])
GO
ALTER TABLE [dbo].[USUARIOS_GRUPOS]  WITH CHECK ADD FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[USUARIOS] ([IdUsuario])
GO
ALTER TABLE [dbo].[USUARIOS_MODULOS]  WITH CHECK ADD FOREIGN KEY([IdGrupo])
REFERENCES [dbo].[GRUPOUSUARIOS] ([IdGrupo])
GO
ALTER TABLE [dbo].[USUARIOS_MODULOS]  WITH CHECK ADD FOREIGN KEY([IdModulo])
REFERENCES [dbo].[MODULOS] ([IdModulo])
GO
ALTER TABLE [dbo].[USUARIOS_MODULOS]  WITH CHECK ADD FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[USUARIOS] ([IdUsuario])
GO
ALTER TABLE [dbo].[VERIFICA_DOCUMENTOS_VISITA]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[VERIFICA_DOCUMENTOS_VISITA]  WITH CHECK ADD  CONSTRAINT [FK_VERIFICA_DOCUMENTOS_VISITA_PRONTUARIOSCRC] FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[VERIFICA_DOCUMENTOS_VISITA] CHECK CONSTRAINT [FK_VERIFICA_DOCUMENTOS_VISITA_PRONTUARIOSCRC]
GO
ALTER TABLE [dbo].[VERIFICA_RETORNO_AUDIENCIA_MEDICO_OUTROS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[VISITAS_INTERNAS_OCORRENCIA_PORTARIA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[VISITAS_INTERNAS_OCORRENCIA_PORTARIA]  WITH CHECK ADD FOREIGN KEY([IdReg])
REFERENCES [dbo].[REGISTRO_INDISCIPLINA_PORTARIA] ([IdReg])
GO
ALTER TABLE [dbo].[VISITAS_OCORRENCIA_PORTARIA]  WITH CHECK ADD FOREIGN KEY([IdReg])
REFERENCES [dbo].[REGISTRO_INDISCIPLINA_PORTARIA] ([IdReg])
GO
ALTER TABLE [dbo].[VISITAS_OCORRENCIA_PORTARIA]  WITH CHECK ADD FOREIGN KEY([IdVisita])
REFERENCES [dbo].[VISITASINTERNO] ([IdVisita])
GO
ALTER TABLE [dbo].[VISITAS_OFICIAL_JUSTICA]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[VISITAS_OFICIAL_JUSTICA]  WITH CHECK ADD FOREIGN KEY([Idlanc])
REFERENCES [dbo].[ENTRADAS_OFICIAL_JUSTICA_INTERNOS] ([IdLanc])
GO
ALTER TABLE [dbo].[VISITAS_OFICIAL_JUSTICA]  WITH CHECK ADD FOREIGN KEY([IdOficial])
REFERENCES [dbo].[OFICIAL_JUSTICA] ([IdOficial])
GO
ALTER TABLE [dbo].[VISITASADVOGADOS]  WITH CHECK ADD FOREIGN KEY([IdAdvogado])
REFERENCES [dbo].[ADVOGADOS] ([IdAdvogado])
GO
ALTER TABLE [dbo].[VISITASADVOGADOS]  WITH CHECK ADD FOREIGN KEY([IdInternoCrc])
REFERENCES [dbo].[PRONTUARIOSCRC] ([IdInternoCrc])
GO
ALTER TABLE [dbo].[VISITASADVOGADOS]  WITH CHECK ADD FOREIGN KEY([Idlanc])
REFERENCES [dbo].[ENTRADASADVINTERNOS] ([IdLanc])
GO
USE [master]
GO
ALTER DATABASE [DB_SOCIALIZA_VC] SET  READ_WRITE 
GO
