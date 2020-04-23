-- ATIVIDADES REALIZADAS NA UNIDADE 
-- DATA: 17/04/2020
--HORAS: 23:10HS
-- TELA DE MANUTENÇÃO
USE DB_SOCIALIZA_VC

-- ABA MANUTENÇÃO

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATIVIDADES_UNIDADE'))
CREATE TABLE ATIVIDADES_UNIDADE
	(
	IdAtividade INT IDENTITY(1,1) NOT NULL,
	StatusAtividade VARCHAR(11) NULL,
	DataCriacao DATETIME NOT NULL,
	DataAtualizacao DATETIME,
	IdUnidEmp INT NOT NULL,
	Populacao INT,
	DataInicial DATETIME NULL,
	DataFinal DATETIME NULL,
	MesReferencia VARCHAR(12) NULL,
	AnoReferencia VARCHAR(4) NULL,
	IdFunc INT NOT NULL,
	Observacao VARCHAR(MAX),
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	CONSTRAINT PK_Atividades_Unidade PRIMARY KEY (IdAtividade),
	CONSTRAINT FK_Colaborador FOREIGN KEY(IdFunc)
	REFERENCES COLABORADOR(IdFunc),
	CONSTRAINT FK_Unidade_Penal_Empresa FOREIGN KEY (IdUnidEmp)
	REFERENCES UNIDADE_PENAL_EMPRESA (IdUnidEmp)
	);

--ABA ASSI

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATIVIDADES_UNIDADE_SERVICO_SOCIAL'))
	CREATE TABLE ATIVIDADES_UNIDADE_SERVICO_SOCIAL
	(
	IdAtividade INT NOT NULL,
	AtendimentoPsicossocialPreso INT,
	AtendimentoPsicossocialFamiliaPreso INT,
	IdentificadoCivilmente INT,
	TotalServicoSocial INT,	
	CONSTRAINT PK_Atividades_Unidade_Servico_Social PRIMARY KEY (IdAtividade),
	CONSTRAINT FK_Atividades_Unidade_Servico_Social FOREIGN KEY (IdAtividade) 
	REFERENCES ATIVIDADES_UNIDADE (IdAtividade)
	);

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATIVIDADES_UNIDADE_VISITA_INTERNO'))
	CREATE TABLE ATIVIDADES_UNIDADE_VISITA_INTERNO
	(
	IdAtividade INT NOT NULL,
	NroDiasVisita INT,
	NroVisitantes INT,
	MediaVisitantesDia FLOAT,
	MediaVisitantesInterno FLOAT,
	NroCriancasVisitantes INT,	
	CONSTRAINT PK_Atividades_Unidade_visita_interno PRIMARY KEY (IdAtividade),
	CONSTRAINT FK_Atividades_Unidade_visita_interno FOREIGN KEY (IdAtividade) 
	REFERENCES ATIVIDADES_UNIDADE (IdAtividade)
	);

-- AFV
IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA'))
	CREATE TABLE ATIVIDADES_UNIDADE_ALIMENTACAO_FORNECIDA
	(
	IdAtividade INT NOT NULL,
	LanchesVisitantes INT,
	CafeContratada INT,
	AlmocoContratada INT,
	JantarContratada INT,
	LancheContratada INT,
	CafeContratante INT,
	AlmocoContratante INT,
	JantarContratante INT,
	LancheContratante INT,
	TotalAlimentacao INT,
	CONSTRAINT PK_Atividades_Unidade_Alimentacao_Fornecida PRIMARY KEY (IdAtividade),
	CONSTRAINT FK_Atividades_Unidade_Alimentacao_Fornecida FOREIGN KEY (IdAtividade) 
	REFERENCES ATIVIDADES_UNIDADE (IdAtividade)
	);

--ABA ASI

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE'))
	CREATE TABLE ATIVIDADES_UNIDADE_ATENDIMENTO_SAUDE
	(
	IdAtividade INT NOT NULL,
	AtendimentoClinico INT,
	AtendimentoPsiquiatrico INT,
	AtendimentoEnfermagem INT,
	ProcedimentoOdontologico INT,
	AtendimentoPsicologico INT,
	TratamentoAgravosPNAISP INT,
	SensibilizadoSaudeBucal INT,
	SensibilizadoInfectocontagiosas INT,
	SensibilizadoHipertensao INT,
	SensibilizadoDiabetes INT,
	SensibilizadoSexualidade INT,
	VacinadosPNI INT,
	TotalSaude INT,	
	CONSTRAINT PK_Atividades_Unidade_Atendimento_Saude PRIMARY KEY (IdAtividade),
	CONSTRAINT FK_Atividades_Unidade_Atendimento_Saude FOREIGN KEY (IdAtividade) 
	REFERENCES ATIVIDADES_UNIDADE (IdAtividade)
	);

--AEI

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL'))
	CREATE TABLE ATIVIDADES_UNIDADE_ATENDIMENTO_EDUCACIONAL
	(
	IdAtividade INT NOT NULL,
	MatriculadoEnsinoFormal INT,
	FrequentandoEnsinoFormal INT,
	MatriculadoCursoProfissionalizante INT,
	CertificadoCursoProfissionalizante INT,
	TotalEducacional INT,	
	CONSTRAINT PK_Atividades_Unidade_Atendimento_Educacional PRIMARY KEY (IdAtividade),
	CONSTRAINT FK_Atividades_Unidade_Atendimento_Educacional FOREIGN KEY (IdAtividade) 
	REFERENCES ATIVIDADES_UNIDADE (IdAtividade)
	);

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATIVIDADES_UNIDADE_RECREATIVA_RELIGIOSA'))
	CREATE TABLE ATIVIDADES_UNIDADE_RECREATIVA_RELIGIOSA
	(
	IdAtividade INT NOT NULL,
	ArtesPlasticas INT,
	Literatura INT,
	CantoTeatroCinema INT,
	Esportes INT,
	Religiosa INT,
	TotalRecreativaReligiosa INT,	
	CONSTRAINT PK_Atividades_Unidade_Recreativa_Religiosa PRIMARY KEY (IdAtividade),
	CONSTRAINT FK_Atividades_Unidade_Recreativa_Religiosa FOREIGN KEY (IdAtividade) 
	REFERENCES ATIVIDADES_UNIDADE (IdAtividade)
	);



IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL'))
	CREATE TABLE ATIVIDADES_UNIDADE_ASSISTENCIA_MATERIAL
	(
	IdAtividade INT NOT NULL,
	Cobertor INT,
	Colchao INT,
	Colher INT,
	Lencol INT,
	Toalha INT,
	Pote INT,
	Caneca INT,
	AparelhoBarbear INT,
	CremeDental INT,
	EscovaDente INT,
	Absorvente INT,
	PapelHigienico INT,
	SabaoPo INT,
	Sabonete INT,
	Desodorante INT,
	Bermuda INT,
	CamisaCamiseta INT,
	Cueca INT,
	Chinelo INT,
	UniformeEsportivo INT,
	TotalMaterial INT,	
	CONSTRAINT PK_Atividades_Assistencia_Material PRIMARY KEY (IdAtividade),
	CONSTRAINT FK_Atividades_Assistencia_Material FOREIGN KEY (IdAtividade) 
	REFERENCES ATIVIDADES_UNIDADE (IdAtividade)
	);

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATIVIDADES_UNIDADE_SEGURANCA'))
	CREATE TABLE ATIVIDADES_UNIDADE_SEGURANCA
	(
	IdAtividade INT NOT NULL,
	CelularLocalizadoConvivencia INT,
	ObjetoNaoAutorizadoLocalizadoConvivencia INT,
	RevistaCela INT,
	TentativaFuga INT,
	OcorrenciaFuga INT,
	OcorrenciaRebeliao INT,
	OcorrenciaFerido INT,	
	OcorrenciaIndisciplina INT,
	OcorrenciaRefem INT,
	OcorrenciaGravementeFeridoMorto INT,
	HorasInterrupcaoCFTV INT,
	DiasInterrupcaoScannerCorporal INT,
	DiasInterrupcaoRaioXDetectorMetais INT,
	DiasInterrupcaoVeiculoTransportePreso INT,
	FalhaGeradorEnergia INT,
	HorasMauFuncionamentoBRS INT,
	AbsorventesEntreguesPortariaScanner INT,
	FraldasEntreguesPortariaScanner INT,
	CONSTRAINT PK_Atividades_Seguranca PRIMARY KEY (IdAtividade),
	CONSTRAINT FK_Atividades_Seguranca FOREIGN KEY (IdAtividade) 
	REFERENCES ATIVIDADES_UNIDADE (IdAtividade)
	);

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATIVIDADES_UNIDADE_JURIDICA'))
	CREATE TABLE ATIVIDADES_UNIDADE_JURIDICA
	(
	IdAtividade INT NOT NULL,
	InternoFamiliaSAJ INT,
	AlvaraSolturaRecebido INT,
	AlvaraSolturaCumprido INT,
	LivramentoCondicionalRequerido INT,
	AudienciaProvocada INT,
	AudienciaCumprida INT,
	JuriProvocado INT,
	JuriCumprido INT,
	LiberdadeProvisoriaRequerida INT,
	LiberdadeProvisoriaDeferida INT,
	IndultosRequeridos INT,
	IndultosDeferidos INT,
	RemicaoRequerida INT,
	RemicaoDeferida INT,
	CondicionalRequerida INT,
	CondicionalDeferida INT,
	ProgressaoRegimeRequerida INT,
	ProgressaoRegimeDeferida INT,
	SaidasTemporariasRequerida INT,
	SaidasTemporariasDeferida INT,
	HabeasCorpusRequerido INT,
	HabeasCorpusDeferido INT,
	LaudosPsicologicos INT,
	LaudosPsiquiatricos INT,
	TransferenciaProvimento INT,
	TotalJuridico INT,	
	CONSTRAINT PK_Atividades_Unidade_Juridica PRIMARY KEY (IdAtividade),
	CONSTRAINT FK_Atividades_Unidade_Juridica FOREIGN KEY (IdAtividade) 
	REFERENCES ATIVIDADES_UNIDADE (IdAtividade)
	);

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL'))
	CREATE TABLE ATIVIDADES_UNIDADE_ASSISTENCIA_LABORAL
	(
	IdAtividade INT NOT NULL,
	Triagem INT,
	LaborativaRemunerada INT,
	LaborativaNaoRemunerada INT,
	TotalLaboral INT,
	CONSTRAINT PK_Atividades_Unidade_Assistencia_Laboral PRIMARY KEY (IdAtividade),
	CONSTRAINT FK_Atividades_Unidade_Assistencia_Laboral FOREIGN KEY (IdAtividade) 
	REFERENCES ATIVIDADES_UNIDADE (IdAtividade)
	);

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATIVIDADES_UNIDADE_ALIMENTACAO_INTERNO'))
	CREATE TABLE ATIVIDADES_UNIDADE_ALIMENTACAO_INTERNO
	(
	IdAtividade INT NOT NULL,
	CafeInterno INT,
	AlmocoInterno INT,
	JantarInterno INT,
	TotalAlimentacaoInterno INT,	
	CONSTRAINT PK_Atividades_Alimentacao_interno PRIMARY KEY (IdAtividade),
	CONSTRAINT FK_Atividades_Alimentacao_interno FOREIGN KEY (IdAtividade) 
	REFERENCES ATIVIDADES_UNIDADE (IdAtividade)
	);