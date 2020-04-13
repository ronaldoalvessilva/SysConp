USE [DB_SOCIALIZA_VC]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA] DROP CONSTRAINT [FK_Atividades_Unidade_Alimentacao_Fornecida]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA]    Script Date: 13/04/2020 07:51:41 ******/
DROP TABLE [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA]    Script Date: 13/04/2020 07:51:41 ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Alimentacao_Fornecida] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA] CHECK CONSTRAINT [FK_Atividades_Unidade_Alimentacao_Fornecida]
GO

-------------------------------------------------------------------------------------------------------------------------

USE [DB_SOCIALIZA_VC]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL] DROP CONSTRAINT [FK_Atividades_Unidade_Assistencia_Laboral]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL]    Script Date: 13/04/2020 08:05:07 ******/
DROP TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL]    Script Date: 13/04/2020 08:05:07 ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Assistencia_Laboral] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL] CHECK CONSTRAINT [FK_Atividades_Unidade_Assistencia_Laboral]
GO

------------------------------------------------------------------------------------------------------------------------

USE [DB_SOCIALIZA_VC]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL] DROP CONSTRAINT [FK_Atividades_Assistencia_Material]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL]    Script Date: 13/04/2020 08:10:54 ******/
DROP TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL]    Script Date: 13/04/2020 08:10:54 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL](
	[IdAtividade] [int] NOT NULL,
	[CafeInterno] [int] NULL,
	[AlmocoInterno] [int] NULL,
	[JantarInterno] [int] NULL,
	[AudienciaProvocada] [int] NULL,
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
 CONSTRAINT [PK_Atividades_Assistencia_Material] PRIMARY KEY CLUSTERED 
(
	[IdAtividade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Assistencia_Material] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL] CHECK CONSTRAINT [FK_Atividades_Assistencia_Material]
GO

----------------------------------------------------------------------------------------------------------------------

USE [DB_SOCIALIZA_VC]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL] DROP CONSTRAINT [FK_Atividades_Unidade_Atendimento_Educacional]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL]    Script Date: 13/04/2020 08:13:08 ******/
DROP TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL]    Script Date: 13/04/2020 08:13:08 ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Atendimento_Educacional] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL] CHECK CONSTRAINT [FK_Atividades_Unidade_Atendimento_Educacional]
GO


-------------------------------------------------------------------------------------------------------------------------

USE [DB_SOCIALIZA_VC]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE] DROP CONSTRAINT [FK_Atividades_Unidade_Atendimento_Saude]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE]    Script Date: 13/04/2020 08:15:39 ******/
DROP TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE]    Script Date: 13/04/2020 08:15:39 ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Atendimento_Saude] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE] CHECK CONSTRAINT [FK_Atividades_Unidade_Atendimento_Saude]
GO


------------------------------------------------------------------------------------------------------------------------
USE [DB_SOCIALIZA_VC]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_JURIDICA] DROP CONSTRAINT [FK_Atividades_Unidade_Juridica]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_JURIDICA]    Script Date: 13/04/2020 08:18:44 ******/
DROP TABLE [dbo].[ATIVIDADES_UNIDADE_JURIDICA]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_JURIDICA]    Script Date: 13/04/2020 08:18:44 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_JURIDICA](
	[IdAtividade] [int] NOT NULL,
	[InternoFamiliaSAJ] [int] NULL,
	[AlvaraSolturaRecebido] [int] NULL,
	[AlvaraSolturaCumprido] [int] NULL,
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_JURIDICA]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Juridica] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_JURIDICA] CHECK CONSTRAINT [FK_Atividades_Unidade_Juridica]
GO

-------------------------------------------------------------------------------------------------------------------------
USE [DB_SOCIALIZA_VC]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA]    Script Date: 13/04/2020 08:49:10 ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Alimentacao_Fornecida] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA] CHECK CONSTRAINT [FK_Atividades_Unidade_Alimentacao_Fornecida]
GO
------------------------------------------------------------------------------------------------------------------------------------------------

USE [DB_SOCIALIZA_VC]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL]    Script Date: 13/04/2020 08:51:58 ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Assistencia_Laboral] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL] CHECK CONSTRAINT [FK_Atividades_Unidade_Assistencia_Laboral]
GO


--------------------------------------------------------------------------------------------------------------------------------------------
USE [DB_SOCIALIZA_VC]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL]    Script Date: 13/04/2020 08:52:32 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL](
	[IdAtividade] [int] NOT NULL,
	[CafeInterno] [int] NULL,
	[AlmocoInterno] [int] NULL,
	[JantarInterno] [int] NULL,
	[AudienciaProvocada] [int] NULL,
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
 CONSTRAINT [PK_Atividades_Assistencia_Material] PRIMARY KEY CLUSTERED 
(
	[IdAtividade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Assistencia_Material] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL] CHECK CONSTRAINT [FK_Atividades_Assistencia_Material]
GO


---------------------------------------------------------------------------------------------------------------------------------------------
USE [DB_SOCIALIZA_VC]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL]    Script Date: 13/04/2020 08:53:00 ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Atendimento_Educacional] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL] CHECK CONSTRAINT [FK_Atividades_Unidade_Atendimento_Educacional]
GO


-------------------------------------------------------------------------------------------------------------------------------------------
USE [DB_SOCIALIZA_VC]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE]    Script Date: 13/04/2020 08:53:28 ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Atendimento_Saude] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE] CHECK CONSTRAINT [FK_Atividades_Unidade_Atendimento_Saude]
GO


--------------------------------------------------------------------------------------------------------------------------------------------
USE [DB_SOCIALIZA_VC]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_JURIDICA]    Script Date: 13/04/2020 08:54:02 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_JURIDICA](
	[IdAtividade] [int] NOT NULL,
	[InternoFamiliaSAJ] [int] NULL,
	[AlvaraSolturaRecebido] [int] NULL,
	[AlvaraSolturaCumprido] [int] NULL,
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_JURIDICA]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Juridica] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_JURIDICA] CHECK CONSTRAINT [FK_Atividades_Unidade_Juridica]
GO


---------------------------------------------------------------------------------------------------------------------------------
USE [DB_SOCIALIZA_VC]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_RECREATIVA_RELIGIOSA]    Script Date: 13/04/2020 08:54:27 ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_RECREATIVA_RELIGIOSA]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Recreativa_Religiosa] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_RECREATIVA_RELIGIOSA] CHECK CONSTRAINT [FK_Atividades_Unidade_Recreativa_Religiosa]
GO


--------------------------------------------------------------------------------------------------------------------------------------------
USE [DB_SOCIALIZA_VC]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_SEGURNACA]    Script Date: 13/04/2020 08:54:54 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ATIVIDADES_UNIDADE_SEGURNACA](
	[IdAtividade] [int] NOT NULL,
	[CelularLocalizadoConvivencia] [int] NULL,
	[ObjetoNaoAutorizadoLocalizadoConvivencia] [int] NULL,
	[TentativaFuga] [int] NULL,
	[OcorrenciaFuga] [int] NULL,
	[OcorrenciaRebeliao] [int] NULL,
	[OcorrenciaFerido] [int] NULL,
	[OcorrenciaIndisciplina] [int] NULL,
	[OcorrenciaGravementeFeridoMorto] [int] NULL,
	[HorasInterrupcaoCFTV] [int] NULL,
	[DiasInterrupcaoScannerCorporal] [int] NULL,
	[DiasInterrupcaoRaioXDetectorMetais] [int] NULL,
	[DiasInterrupcaoVeiculoTransportePreso] [int] NULL,
	[FalhaGeradorEnergia] [int] NULL,
	[HorasMauFuncionamentoBRS] [int] NULL,
	[AbsorventesEntreguesPortariaScanner] [int] NULL,
	[FraldasEntreguesPortariaScanner] [int] NULL,
	[TotalMaterial] [int] NULL,
 CONSTRAINT [PK_Atividades_Seguranca] PRIMARY KEY CLUSTERED 
(
	[IdAtividade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_SEGURNACA]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Seguranca] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_SEGURNACA] CHECK CONSTRAINT [FK_Atividades_Seguranca]
GO


----------------------------------------------------------------------------------------------------------------------------------------------
USE [DB_SOCIALIZA_VC]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_SERVICO_SOCIAL]    Script Date: 13/04/2020 08:55:19 ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_SERVICO_SOCIAL]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade_Servico_Social] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_SERVICO_SOCIAL] CHECK CONSTRAINT [FK_Atividades_Unidade_Servico_Social]
GO


------------------------------------------------------------------------------------------------------------------------------------------------

USE [DB_SOCIALIZA_VC]
GO

/****** Object:  Table [dbo].[ATIVIDADES_UNIDADE_VISITA_INTERNO]    Script Date: 13/04/2020 08:55:46 ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_VISITA_INTERNO]  WITH CHECK ADD  CONSTRAINT [FK_Atividades_Unidade] FOREIGN KEY([IdAtividade])
REFERENCES [dbo].[ATIVIDADES_UNIDADE] ([IdAtividade])
GO

ALTER TABLE [dbo].[ATIVIDADES_UNIDADE_VISITA_INTERNO] CHECK CONSTRAINT [FK_Atividades_Unidade]
GO






