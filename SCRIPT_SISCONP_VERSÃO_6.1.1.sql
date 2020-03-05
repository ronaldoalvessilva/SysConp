  -- INICIO EM 17/02/2020
  -- TERMINO EM 

-- ATENDIMENTO EM GRUPO TERAPIA OCUPACIONAL

-- ABA MANUTEN��O

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATENDIMENTO_GRUPO_TO'))
	CREATE TABLE ATENDIMENTO_GRUPO_TO
	(
	IdAtGrupoTO INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	StatusAtendGrupo VARCHAR(15) NULL,
	DataAtend DATETIME NULL,
	Responsavel VARCHAR(200) NULL,	
	IdPav INT FOREIGN KEY REFERENCES PAVILHAO(IdPav) NOT NULL,
	Ambiente VARCHAR(200) NULL,
	HoraioInicio VARCHAR(20) NULL,
	HorarioTermino VARCHAR(20) NULL,
	LocalAtividade VARCHAR(200) NULL,
	GrupoAtividade VARCHAR(200) NULL,	
	Observacao VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)

	-- ABA PLANEJAMENTO

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('PLANEJAMENTO_ATENDIMENTO_GRUPO_TO'))
	CREATE TABLE PLANEJAMENTO_ATENDIMENTO_GRUPO_TO
	(
	IdItemPlanTO INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 		
	IdAtGrupoTO INT FOREIGN KEY REFERENCES ATENDIMENTO_GRUPO_TO(IdAtGrupoTO) NOT NULL,
	Tema VARCHAR(200) NULL,
	HoraInicio VARCHAR(20) NULL,
	HoraTermino VARCHAR(20) NULL,
	Turno VARCHAR(80) NULL,
	Atividades VARCHAR(250) NULL,
	Recursos VARCHAR (250) NULL,	
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)

	-- ABA PARTICIPANTES

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('PARTICIPANTES_ATENDIMENTO_GRUPO_TO'))
	CREATE TABLE PARTICIPANTES_ATENDIMENTO_GRUPO_TO
	(
	IdItemPartTO INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 		
	IdAtGrupoTO INT FOREIGN KEY REFERENCES ATENDIMENTO_GRUPO_TO(IdAtGrupoTO) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,		
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)

	-- ABA AVALAI��O EM GRUPO

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('AVALICAO_ATENDIMENTO_GRUPO_TO'))
	CREATE TABLE AVALICAO_ATENDIMENTO_GRUPO_TO
	(
	IdItemAvagTO INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 		
	IdAtGrupoTO INT FOREIGN KEY REFERENCES ATENDIMENTO_GRUPO_TO(IdAtGrupoTO) NOT NULL,
	TextoAvalaiacaoGrupo VARCHAR(MAX) NULL,	
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)

	-- ABA AVALIA��O INDIVIDUAL

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_TO'))
	CREATE TABLE AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_TO
	(
	IdItemAvaiTO INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 		
	IdAtGrupoTO INT FOREIGN KEY REFERENCES ATENDIMENTO_GRUPO_TO(IdAtGrupoTO) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,		
	TextoAvalaiacaoInd VARCHAR(MAX) NULL,	
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('PRONTUARIOSCRC') AND NAME = 'DataEntradaAnt')
   ALTER TABLE PRONTUARIOSCRC ADD DataEntradaAnt DATETIME NULL


-- ADMISS�O ADICIONAL

-- 18/02/2020

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ADMISSAO_MEDICA_ADICIONAL'))
	CREATE TABLE ADMISSAO_MEDICA_ADICIONAL
	(
	IdAdmADI INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	StatusLanc VARCHAR(20) NULL,
	DataLanc DATETIME NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	IdLanc INT FOREIGN KEY REFERENCES ADMISSAOMEDICA(IdLanc) NOT NULL,
	CombBoxAR VARCHAR(3) NULL,
	CombBoxACV VARCHAR(3) NULL,
	CombBoxAGU VARCHAR(3) NULL,
	CombBoxCABPESC VARCHAR(3) NULL,
	CombBoxEXT VARCHAR(3) NULL,
	CombBoxABD VARCHAR(3) NULL,
	AR VARCHAR(80) NULL,
	ACV VARCHAR(80) NULL,
	AGU VARCHAR(80) NULL,
	CABPESC VARCHAR(80) NULL,
	EXT VARCHAR(80) NULL,
	ABD VARCHAR(80) NULL,
	Diagnostico VARCHAR(MAX) NULL,
	CirurgiasPrevisas VARCHAR(100) NULL,
	TratamentoCurso VARCHAR(100) NULL,
	Alergia VARCHAR(3) NULL,
	QuaisAlergias VARCHAR(100) NULL,
	QualDrogas VARCHAR(100) NULL,
	DrogaInjetavel VARCHAR(3) NULL,
	QualTipoDrogaInjet VARCHAR(200) NULL,
	QualEtilismo VARCHAR(100) NULL,
	QuantoTempoTabagismo VARCHAR(100) NULL,
	Drogas VARCHAR(10) NULL,
	Etilismo VARCHAR(10) NULL,
	Tabagismo VARCHAR(10) NULL,
	Sexualidade VARCHAR(30) NULL,
	UsaPreserva VARCHAR(20) NULL,
	NumeroPareceiro VARCHAR(10) NULL,
	TipoSangue VARCHAR(3) NULL,
	FatorRh VARCHAR(15) NULL,
	Vacinas VARCHAR(3) NULL,
	AtualizaIgnora VARCHAR(20) NULL,
	UsaMedicamento VARCHAR(3) NULL,
	QualMedicamento VARCHAR(300) NULL,
	OutrasAlergias VARCHAR(3) NULL,
	QuaisOutrasAlergias VARCHAR(100) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	UsuarioDelete VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	DataDelete VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	DiagnosticoInicial VARCHAR(MAX) NULL,
	TipoDiag VARCHAR(3) NULL,
	)

	IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAO_MEDICA_ADICIONAL') AND NAME = 'TipoDiag')
           ALTER TABLE ADMISSAO_MEDICA_ADICIONAL ADD TipoDiag VARCHAR(3) NULL

-- 

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ITENS_ADMISSAO_DOENCAS_ADICIONAL'))
	CREATE TABLE ITENS_ADMISSAO_DOENCAS_ADICIONAL
	(
	IdItemDAD INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	DataLanc DATETIME NULL,
	IdAdmADI INT FOREIGN KEY REFERENCES ADMISSAO_MEDICA_ADICIONAL(IdAdmADI) NOT NULL,
	IdDoenca INT FOREIGN KEY REFERENCES DOENCAS(IdDoenca) NOT NULL,
	)

-- TABELA QUE HABILITA A PORTA DE ENTRADA DOS INTERNOS

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('PORTA_ENTRADA'))
	CREATE TABLE PORTA_ENTRADA
	(
	IdAdm INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	DataEntrada DATETIME NULL,
	PSPEnf VARCHAR(100) NULL,
	HabEnf VARCHAR(3) NULL,
	PSPMed VARCHAR(100) NULL,
	HabMed VARCHAR(3) NULL,
	PSPJur VARCHAR(100) NULL,
	HabJur VARCHAR(3) NULL,
	PSPPed VARCHAR(100) NULL,
	HabPed VARCHAR(3) NULL,
	PSPPsi VARCHAR(100) NULL,
	HabPsi VARCHAR(3) NULL,
	PSPSso VARCHAR(100) NULL,
	HabSso VARCHAR(3) NULL,
	PSPOdo VARCHAR(100) NULL,
	HabOdo VARCHAR(3) NULL,
	PSPTer VARCHAR(100) NULL,
	HabTer VARCHAR(3) NULL,
	PSPEdu VARCHAR(100) NULL,
	HabEdu VARCHAR(3) NULL,
	)

-- INSERT E UPDATE PARA TABELA PORTA_ENTRA NAS UNIDADE

INSERT INTO PORTA_ENTRADA(IdInternoCrc) SELECT IdInternoCrc FROM PRONTUARIOSCRC

-- ATUALIZAR A TABELA PARA DA INICIO A IMPLAMENTA��O, SE N�O N�O IR� FUNCIONAR ADEQUADAMENTE.

UPDATE PORTA_ENTRADA SET DataEntrada='2020-02-19',PSPEnf='ENFERMARIA',HabEnf='N�o',PSPMed='ENFERMARIA',HabMed='N�o',PSPJur='JURIDICO',HabJur='N�o',PSPPed='PEDAGOGIA',HabPed='N�o',PSPPsi='PSICOLOGIA',HabPsi='N�o',PSPSso='SERVICO SOCIAL',HabSso='N�o',PSPOdo='ODONTOLOGIA',HabOdo='N�o',PSPTer='TERAPIA OCUPACIONAL',HabTer='N�o',PSPEdu='EDUCACAO FISICA',HabEdu='N�o'

-- ADMISS�O COMPLEMENTAR DA ENFERMEIRA

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ADMISSAO_ENFERMEIRA_COMPLEMENTAR'))
	CREATE TABLE ADMISSAO_ENFERMEIRA_COMPLEMENTAR
	(
	IdADME INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdLanc INT FOREIGN KEY REFERENCES ADMISSAOENFERMEIRA(IdLanc) NOT NULL,
	StatusLanc VARCHAR(20) NULL,
	DataLanc DATETIME NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	EstadoEmocional INT NULL,
	SonoRepouso INT NULL,
	NivelConsciencia INT NULL,
	PressaoArterial VARCHAR(10) NULL,
	Hemograma VARCHAR(10) NULL,
	Temperatura VARCHAR(10) NULL,
	FrequenciaRespiratoria VARCHAR(10) NULL,
	Peso VARCHAR(10) NULL,
	FrequenciaCardiaca VARCHAR(10) NULL,
	UsaMedicamentos VARCHAR(3) NULL,
	QualMedicacao VARCHAR(100) NULL,
	Locomocao INT NULL,
	AcuidadeVisual INT NULL,
	AcuidadeAuditiva INT NULL,
	FuncaoMotora INT NULL,
	QualFuncaoMotora VARCHAR(200) NULL,
	FalaLinguagem INT NULL,
	QualFala VARCHAR(80) NULL,
	Pele INT NULL,
	Mucosa INT NULL,
	TipoPele VARCHAR(100) NULL,
	Localizacao VARCHAR(70) NULL,
	Cabelos INT NULL,
	Boca INT NULL,
	FuncaoRespiratoria INT NULL,
	Torax INT NULL,
	FuncaoIntestinal INT NULL,
	DiasConstipado VARCHAR(20) NULL,
	Abdome INT NULL,
	FuncaoVesical INT NULL,
	Genitalia INT NULL,
	QualGenitalia VARCHAR(100) NULL,
	Vacinado VARCHAR(10) NULL,
	QuaisVacinas varchar(200) NULL,                    
	Vdrl VARCHAR(350) NULL,
	HepatiteC VARCHAR(350) NULL,
	HepatiteB VARCHAR(350) NULL,
	Hiv VARCHAR(350) NULL,
	Cirurgias VARCHAR(3) NULL,
	QuaisCirurgias VARCHAR(250) NULL,
	UsuarioDrogas VARCHAR(5) NULL,
	QuaisDrogas VARCHAR(300) NULL,
	PortadorDoenca VARCHAR(5) NULL,
	QuaisDoencas VARCHAR(300) NULL,
	Alergias VARCHAR(5) NULL,
	QuaisAlergias VARCHAR(300) NULL,
	Observacao VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	UsuarioDelete VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	DataDelete VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAO_ENFERMEIRA_COMPLEMENTAR') AND NAME = 'Sifilis')
   ALTER TABLE ADMISSAO_ENFERMEIRA_COMPLEMENTAR ADD Sifilis VARCHAR(20) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAO_ENFERMEIRA_COMPLEMENTAR') AND NAME = 'Hpv')
   ALTER TABLE ADMISSAO_ENFERMEIRA_COMPLEMENTAR ADD Hpv VARCHAR(20) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAO_ENFERMEIRA_COMPLEMENTAR') AND NAME = 'Hipertensao')
   ALTER TABLE ADMISSAO_ENFERMEIRA_COMPLEMENTAR ADD Hipertensao VARCHAR(20) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAO_ENFERMEIRA_COMPLEMENTAR') AND NAME = 'Diabetes')
   ALTER TABLE ADMISSAO_ENFERMEIRA_COMPLEMENTAR ADD Diabetes VARCHAR(20) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAO_ENFERMEIRA_COMPLEMENTAR') AND NAME = 'Tuberculose')
   ALTER TABLE ADMISSAO_ENFERMEIRA_COMPLEMENTAR ADD Tuberculose VARCHAR(20) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAO_ENFERMEIRA_COMPLEMENTAR') AND NAME = 'Hanseniase')
   ALTER TABLE ADMISSAO_ENFERMEIRA_COMPLEMENTAR ADD Hanseniase VARCHAR(30) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAO_ENFERMEIRA_COMPLEMENTAR') AND NAME = 'Escabiose')
   ALTER TABLE ADMISSAO_ENFERMEIRA_COMPLEMENTAR ADD Escabiose VARCHAR(3) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAO_ENFERMEIRA_COMPLEMENTAR') AND NAME = 'Dst')
   ALTER TABLE ADMISSAO_ENFERMEIRA_COMPLEMENTAR ADD Dst VARCHAR(30) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAO_ENFERMEIRA_COMPLEMENTAR') AND NAME = 'Vacina')
   ALTER TABLE ADMISSAO_ENFERMEIRA_COMPLEMENTAR ADD Vacina VARCHAR(3) NULL

-- ALTERAR CAMPO DA TABELA DE VACINAS

ALTER TABLE ITENS_CARTILHA_VACINAS_INTERNOS ALTER COLUMN Data1Dose DATETIME NULL

-- CAMPO PARA DEFINIR QUEM ACESSA TODAS AS UNIDADES

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('USUARIOS') AND NAME = 'AcessoTodasUnidades')
   ALTER TABLE USUARIOS ADD AcessoTodasUnidades VARCHAR(12) NULL


-- TABELA DE PERNOITE DE INTERNOS NA UNIDADE PRISIONAL

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('PERNOITE_INTERNOS'))
	CREATE TABLE PERNOITE_INTERNOS
	(
	IdPer INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	StatusRegistro VARCHAR(30) NULL,
	DataRegistro DATETIME NULL,
	DescricaoPavilhao VARCHAR(200) NULL,
	Documento VARCHAR(80) NULL,
	DescricaoCela VARCHAR(200) NULL,
	Objetivo VARCHAR(80) NULL,
	UnidadeOrigem VARCHAR(200) NULL,
	NomeCondutor VARCHAR(200) NULL,
	Rg VARCHAR(20) NULL,
	Cpf VARCHAR(20) NULL,
	Veiculo VARCHAR(60) NULL,
	Placa VARCHAR(20) NULL,

	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,	
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ITENS_PERNOITE_INTERNOS'))
	CREATE TABLE ITENS_PERNOITE_INTERNOS
	(
	IdItemPer INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdPer INT FOREIGN KEY REFERENCES PERNOITE_INTERNOS(IdPer) NOT NULL,
	NomeInterno VARCHAR(300) NULL,
	NomeMae VARCHAR(300) NULL,
	NomePai VARCHAR(300) NULL,
	DataEntrada DATETIME NULL,
	HoraEntrada VARCHAR(20) NULL,
	DataSaida DATETIME NULL,
	HoraSaida VARCHAR(20) NULL,
	ImagemInterno VARBINARY(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,	
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)