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

-- PLANEJAMENTO DE ATIVIDADES EM GRUPO

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('PLANEJAMENTO_ATIVIDADES_GRUPO'))
	CREATE TABLE PLANEJAMENTO_ATIVIDADES_GRUPO
	(
	IdPlan INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	DescricaoPlaneja VARCHAR(350) NULL,
	Sigla VARCHAR(2) NULL,
	Setor VARCHAR(80) NULL,
	)

/**
INSERT INTO PLANEJAMENTO_ATIVIDADES_GRUPO(DescricaoPlaneja,Sigla,Setor) VALUES('Vacinas','EN','Enfermaria')
INSERT INTO PLANEJAMENTO_ATIVIDADES_GRUPO(DescricaoPlaneja,Sigla,Setor) VALUES('Roda de Conversa','SS','Servi�o Social')
INSERT INTO PLANEJAMENTO_ATIVIDADES_GRUPO(DescricaoPlaneja,Sigla,Setor) VALUES('Palestras','SS','Servi�o Social')
INSERT INTO PLANEJAMENTO_ATIVIDADES_GRUPO(DescricaoPlaneja,Sigla,Setor) VALUES('Palestras','PS','Psicologia')
INSERT INTO PLANEJAMENTO_ATIVIDADES_GRUPO(DescricaoPlaneja,Sigla,Setor) VALUES('Projetos','EN','Enfermaria')
INSERT INTO PLANEJAMENTO_ATIVIDADES_GRUPO(DescricaoPlaneja,Sigla,Setor) VALUES('Projetos','PS','Psicologia')
INSERT INTO PLANEJAMENTO_ATIVIDADES_GRUPO(DescricaoPlaneja,Sigla,Setor) VALUES('Vermectina','EN','Enfermaria')
INSERT INTO PLANEJAMENTO_ATIVIDADES_GRUPO(DescricaoPlaneja,Sigla,Setor) VALUES('Oficinas','TO','Terapia Ocupacional')
INSERT INTO PLANEJAMENTO_ATIVIDADES_GRUPO(DescricaoPlaneja,Sigla,Setor) VALUES('Leituras','PE','Pedagogia')
INSERT INTO PLANEJAMENTO_ATIVIDADES_GRUPO(DescricaoPlaneja,Sigla,Setor) VALUES('Exames do ENEN','PE','Pedagogia')
INSERT INTO PLANEJAMENTO_ATIVIDADES_GRUPO(DescricaoPlaneja,Sigla,Setor) VALUES('Exame de Vestibular','PE','Pedagogia')
**/

-- PLANEJAMENTO ATENDIMENTO EM GRUPO ENFERMARIA
-- VACINAS

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM') AND NAME = 'TipoVacina')
   ALTER TABLE PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM ADD TipoVacina VARCHAR(80) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM') AND NAME = 'PD')
   ALTER TABLE PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM ADD PD INT NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM') AND NAME = 'SD')
   ALTER TABLE PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM ADD SD INT NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM') AND NAME = 'TD')
   ALTER TABLE PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM ADD TD INT NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM') AND NAME = 'RD')
   ALTER TABLE PLANEJAMENTO_ATENDIMENTO_GRUPO_ENFERMAGEM ADD RD INT NULL


-- ATENDIMENTO EM GRUPO SERVI�O SOCIAL

-- ABA MANUTEN��O

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATENDIMENTO_GRUPO_SS'))
	CREATE TABLE ATENDIMENTO_GRUPO_SS
	(
	IdAtGrupoSS INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
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

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('PLANEJAMENTO_ATENDIMENTO_GRUPO_SS'))
	CREATE TABLE PLANEJAMENTO_ATENDIMENTO_GRUPO_SS
	(
	IdItemPlanSS INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 		
	IdAtGrupoSS INT FOREIGN KEY REFERENCES ATENDIMENTO_GRUPO_SS(IdAtGrupoSS) NOT NULL,
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

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('PARTICIPANTES_ATENDIMENTO_GRUPO_SS'))
	CREATE TABLE PARTICIPANTES_ATENDIMENTO_GRUPO_SS
	(
	IdItemPartSS INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 		
	IdAtGrupoSS INT FOREIGN KEY REFERENCES ATENDIMENTO_GRUPO_SS(IdAtGrupoSS) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,		
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)

	-- ABA AVALAI��O EM GRUPO

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('AVALICAO_ATENDIMENTO_GRUPO_SS'))
	CREATE TABLE AVALICAO_ATENDIMENTO_GRUPO_SS
	(
	IdItemAvagSS INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 		
	IdAtGrupoSS INT FOREIGN KEY REFERENCES ATENDIMENTO_GRUPO_SS(IdAtGrupoSS) NOT NULL,
	TextoAvalaiacaoGrupo VARCHAR(MAX) NULL,	
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)

	-- ABA AVALIA��O INDIVIDUAL

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_SS'))
	CREATE TABLE AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_SS
	(
	IdItemAvaiSS INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 		
	IdAtGrupoSS INT FOREIGN KEY REFERENCES ATENDIMENTO_GRUPO_SS(IdAtGrupoSS) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,		
	TextoAvalaiacaoInd VARCHAR(MAX) NULL,	
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)

-- ATENDIMENTO EM GRUPO PEDAGOGIA

-- ABA MANUTEN��O

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ATENDIMENTO_GRUPO_PE'))
	CREATE TABLE ATENDIMENTO_GRUPO_PE
	(
	IdAtGrupoPE INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
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

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('PLANEJAMENTO_ATENDIMENTO_GRUPO_PE'))
	CREATE TABLE PLANEJAMENTO_ATENDIMENTO_GRUPO_PE
	(
	IdItemPlanPE INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 		
	IdAtGrupoPE INT FOREIGN KEY REFERENCES ATENDIMENTO_GRUPO_PE(IdAtGrupoPE) NOT NULL,
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

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('PARTICIPANTES_ATENDIMENTO_GRUPO_PE'))
	CREATE TABLE PARTICIPANTES_ATENDIMENTO_GRUPO_PE
	(
	IdItemPartPE INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 		
	IdAtGrupoPE INT FOREIGN KEY REFERENCES ATENDIMENTO_GRUPO_PE(IdAtGrupoPE) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,		
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)

	-- ABA AVALAI��O EM GRUPO

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('AVALICAO_ATENDIMENTO_GRUPO_PE'))
	CREATE TABLE AVALICAO_ATENDIMENTO_GRUPO_PE
	(
	IdItemAvagPE INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 		
	IdAtGrupoPE INT FOREIGN KEY REFERENCES ATENDIMENTO_GRUPO_PE(IdAtGrupoPE) NOT NULL,
	TextoAvalaiacaoGrupo VARCHAR(MAX) NULL,	
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)

	-- ABA AVALIA��O INDIVIDUAL

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_PE'))
	CREATE TABLE AVALICAO_INDIVIDUAL_ATENDIMENTO_GRUPO_PE
	(
	IdItemAvaiPE INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 		
	IdAtGrupoPE INT FOREIGN KEY REFERENCES ATENDIMENTO_GRUPO_PE(IdAtGrupoPE) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,		
	TextoAvalaiacaoInd VARCHAR(MAX) NULL,	
	UsuarioInsert VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)

	--ADMISS�O SECUND�RIA DE SERAVI�O SOCIAL.

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('PORTA_ENTRADA_SERVICO_SOCIAL'))
	CREATE TABLE PORTA_ENTRADA_SERVICO_SOCIAL
	(
	IdAtendSS INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	DataAtend DATETIME NULL,
	IdAtend INT FOREIGN KEY REFERENCES ATENDIMENTOSOCIAL(IdAtend) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	StatusAtend VARCHAR(30) NULL,
	ContatoAtend VARCHAR(200) NULL,
	TelefoneAtend VARCHAR(20) NULL,
	Telefone1Atend VARCHAR(20) NULL,
	CelularAtend VARCHAR(20) NULL,
	EnderecoAtend VARCHAR(250) NULL,
	BairroAtend VARCHAR(150) NULL,
	CidadeAtend VARCHAR(250) NULL,
	EstadoAtend VARCHAR(150) NULL,
	CartTrabAtend VARCHAR(10) NULL,
	Periodo VARCHAR(100) NULL,
	RecebeRecluAtend VARCHAR(10) NULL,
	DireitoAuxAtend VARCHAR(10) NULL,
	RecebeBolAtend VARCHAR(10) NULL,
	QtdPessoasAtend VARCHAR(10) NULL,
	QtdTrabaAtend VARCHAR(10) NULL,
	CN1Atend VARCHAR(10) NULL,
	CN2Atend VARCHAR(10) NULL,
	RG1Atend VARCHAR(10) NULL,
	RG2atend VARCHAR(10) NULL,
	CPF1Atend VARCHAR(10) NULL,
	CPF2Atend VARCHAR(10) NULL,
	CTPS1Atend VARCHAR(10) NULL,
	CTPS2Atend VARCHAR(10) NULL,
	PossuiFilhosAtend VARCHAR(10) NULL,
	QtdFilhosAtend VARCHAR(10) NULL,
	FilhosNaoRegAtend VARCHAR(10) NULL,
	OutrosFilhosAtend VARCHAR(10) NULL,
	QtdFilhos2Atend VARCHAR(10) NULL,
	PaternidadeAtend VARCHAR(10) NULL,
	DefensorAtend VARCHAR(50) NULL,
	PartiFamiAtend VARCHAR(30) NULL,
	ConsiderAtend VARCHAR(MAX) NULL,	
	MunicipioNascimento VARCHAR(100) NULL, 
    Tituloeleito1 VARCHAR(3) NULL,
    Tituloeleito2 VARCHAR(3) NULL,
    Reservista1 VARCHAR(20) NULL,
    Reservista2 VARCHAR(20) NULL,
    CartorioRegistro VARCHAR(80) NULL,
    RecebeBeneficio VARCHAR(15) NULL,
	TempoConvivencia VARCHAR(10) NULL,
	EsposoCompanheiro VARCHAR(20) NULL,
	NomeEsposoCompanheiro VARCHAR(60) NULL,
	PessoasResideCasa VARCHAR(10) NULL,
	EncaOutroSetor VARCHAR(3) NULL,
	QualSetor VARCHAR(40) NULL,
	CancelarVisita VARCHAR(3) NULL,
	MotivoCancelarVisita VARCHAR(50) NULL,
	EncaTirarDoc VARCHAR(3) NULL,
	DataEncaDoc DATETIME NULL,
	EncaRecPaternidade VARCHAR(3) NULL,
	DataRecPaternidade DATETIME NULL,
	RecebeVisita VARCHAR(3) NULL,
	CondicaoSegurado VARCHAR(3) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,	
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)


-- TABELA DE ADMISS�O PSICOLOGICA

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('PORTA_ENTRADA_PSICOLOGIA'))
	CREATE TABLE PORTA_ENTRADA_PSICOLOGIA
	(
	IdPortaPSI INT IDENTITY PRIMARY KEY NOT NULL,	
	StatusLanc VARCHAR(20) NULL,
	DataLanc DATETIME NULL,
	IdLanc INT FOREIGN KEY REFERENCES ADMISSAOPSI(IdLanc) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	PresoAntes VARCHAR(3) NULL,
    FamiliaPreso  VARCHAR(3) NULL,
    QuemFamiliaPreso VARCHAR(80) NULL,
    OndePreso VARCHAR(80) NULL,
    HistoricoCriminal VARCHAR(MAX) NULL,
    -- DROGAS
    UsaDrogras VARCHAR(3) NULL,
    Alcool INT NULL,
    Cigarro INT NULL,
    Maconha INT NULL,
    Crack INT NULL,
    Cocaina INT NULL,
    Cola INT NULL,
    Outros INT NULL,
    OutrasDrogas VARCHAR(50) NULL,
    QualIdade VARCHAR(5) NULL,
    PorqueUsaDrogas VARCHAR(50) NULL,
    Drogas VARCHAR(MAX) NULL,
	-- TRANSTORNO MENTAL
    TratamentoPSI VARCHAR(3) NULL,
    MedicamentoPSI VARCHAR(3) NULL,
    QualMedicamento VARCHAR(80) NULL,
    AcompanhaPSI VARCHAR(15) NULL,
    TranstornoMental VARCHAR(MAX) NULL,
    -- ENCAMINHAMENTOS
    DepartamentoEncaminha VARCHAR(300) NULL,
    DataEncaminhamento DATETIME NULL,
    HoraAcompanha VARCHAR(10) NULL,
    Encaminhamento VARCHAR(MAX) NULL,
    -- TRATAMENTOS ANTERIORES
    TratamentoSaude VARCHAR(3) NULL,
    QualTratamentoSaude VARCHAR(40) NULL,
    OndeFazTratamento VARCHAR(90) NULL,
    TratamentoAnteriores VARCHAR(MAX) NULL,
    -- TENTATIVA DE SUICIDIO
    SituacaoTraumatica VARCHAR(3) NULL,
    QualSituacaoTraumatica VARCHAR(30) NULL,
    HouveTentativaSuicidio VARCHAR(3) NULL,
    PorQueSuicidio VARCHAR(50) NULL,
    ComoFoiTentarSuicidio VARCHAR(30) NULL,
    OndeTentouSuicidio VARCHAR(50) NULL,
    TentativaSuicidio VARCHAR(MAX) NULL,
    -- USO DE MEDICAMENTOS
    QualMedicamentoUtiliza VARCHAR(100) NULL,
    PorqueUsaMedicamento VARCHAR(100) NULL,
    UsoMedicamentos VARCHAR(MAX) NULL,
    -- FAMILIARES
    RecebeVisitas VARCHAR(3) NULL,
    Familiares VARCHAR(MAX) NULL,	
	--															
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,	
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- NOVA ADMISS�ODA PEDAGOGIA.

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ADMISSAO_PEDAGOGIA_NOVA'))
	CREATE TABLE ADMISSAO_PEDAGOGIA_NOVA
	(
	IdAdmNova INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	StatusAdm VARCHAR(20) NULL,
	DataAdm DATETIME NULL,
	IdAdm INT FOREIGN KEY REFERENCES ADMISSAO_PEDAGOGIA(IdAdm) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	UltimaEscola VARCHAR(150) NULL,
	SerieAno VARCHAR(80) NULL,
	Turno VARCHAR(100) NULL,
	Observacao VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('FAMILIA_ADMISSAO_PEDAGOGIA_NOVA'))
	CREATE TABLE FAMILIA_ADMISSAO_PEDAGOGIA_NOVA
	(
	IdFamNova INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdAdmNova INT FOREIGN KEY REFERENCES ADMISSAO_PEDAGOGIA_NOVA(IdAdmNova) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	RelacaoPai VARCHAR(7) NULL,
	RelacaoMae VARCHAR(7) NULL,
	Irmaos VARCHAR(7) NULL,
	PaisLerEscrever VARCHAR(7) NULL,
	PaisSeparados VARCHAR(7) NULL,
	Religiao VARCHAR(200) NULL,
	IdadeAndou INT NULL,
	IdadeFalou INT NULL,
	DificuldadeFala VARCHAR(7) NULL,
	QualDificuldadeFala VARCHAR(200) NULL,
	Comunicacao VARCHAR(MAX) NULL,
	Relacionamento VARCHAR(7) NULL,
	Lider VARCHAR(7) NULL,
	RepetiuAno VARCHAR(7) NULL,
	PorqueRepetiuAno VARCHAR(200) NULL,
	ProblemaProfessor VARCHAR(7) NULL,
	QualProblemaProfessor VARCHAR(200) NULL,
	ComoAtitudeSala VARCHAR(200) NULL,
	FaltaEscola VARCHAR(7) NULL,
	PorqueFaltaEscola VARCHAR(200) NULL,
	AchaEscola VARCHAR(100) NULL,		
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('SOCIALIZACAO_ADMISSAO_PEDAGOGIA_NOVA'))
	CREATE TABLE SOCIALIZACAO_ADMISSAO_PEDAGOGIA_NOVA
	(
	IdSocialNova INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdAdmNova INT FOREIGN KEY REFERENCES ADMISSAO_PEDAGOGIA_NOVA(IdAdmNova) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	AmigosFacilidade VARCHAR(200) NULL,
	Introvertido INT NULL,
	Afetuoso INT NULL,
	Obediente INT NULL,
	Resistente INT NULL,
	Cooperador INT NULL,
	Medroso INT NULL,
	Inseguro INT NULL,
	Outros INT NULL,
	QualOutros VARCHAR(80) NULL,
	IdadeEscolar INT NULL,
	FamiliarPresente VARCHAR(7) NULL,
	Adaptacao VARCHAR(200) NULL,
	Repetencias VARCHAR(200) NULL,
	Antecedentes VARCHAR(7) NULL,
	QualProblemaAprendizado VARCHAR(MAX) NULL,
	ObservacaoSocializacao VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('FEMININO_ADMISSAO_PEDAGOGIA_NOVA'))
	CREATE TABLE FEMININO_ADMISSAO_PEDAGOGIA_NOVA
	(
	IdFemAdmNova INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdAdmNova INT FOREIGN KEY REFERENCES ADMISSAO_PEDAGOGIA_NOVA(IdAdmNova) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	FilhoDesejado VARCHAR(7) NULL,
	QueriaEngravidar VARCHAR(7) NULL,
	FoiAcidental VARCHAR(7) NULL,
	Perturbou VARCHAR(7) NULL,
	ComoFoiGestacao VARCHAR(MAX) NULL,
	ComoFoiParto VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)


-- NOVA ADMISS�O TERAPIA OCUPACIONAL
-- INICIADA: 18/03/2020 - EM DESENVOLVIMENTO
-- TERMINO:

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ADMISSAO_TERAPIA_PE'))
	CREATE TABLE ADMISSAO_TERAPIA_PE
	(
	IdATN INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	StatusLanc VARCHAR(20) NULL,
	DataLanc DATETIME NULL,
	IdLanc INT FOREIGN KEY REFERENCES ATENDIMENTOTERAPIA(IdLanc) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,	
	Dominancia VARCHAR(10) NULL,
	Amputacao VARCHAR(3) NULL,
	DeficienciaOcupa VARCHAR(3) NULL,
	Reabilitacao VARCHAR(3) NULL,
	Motora VARCHAR(3) NULL,
	Cognitiva VARCHAR(3) NULL,
	Sensorial VARCHAR(3) NULL,
	IntPsi VARCHAR(3) NULL,
	AVD VARCHAR(3) NULL,
	AIVD VARCHAR(3) NULL,
	Lazer VARCHAR(3) NULL,
	Trabalho VARCHAR(3) NULL,
	ObsDesempenhoOcupacional VARCHAR(MAX) NULL,
	PaisVivos VARCHAR(3) NULL,
    TemCompanheira VARCHAR(3) NULL,
    TemFilhos VARCHAR(3) NULL,
    QuantosFilhos INT NULL,
    VisitaFamiliar VARCHAR(3) NULL,
    SFSeg INT NULL,
    SFTer INT NULL,
    SFQua INT NULL,
    SFQui INT NULL,
    SFSex INT NULL,
    SFSab INT NULL,
	SFDom INT NULL,
    VisitaIntima VARCHAR(3) NULL,            
    IntSeg INT NULL,
    IntTer INT NULL,
    IntQua INT NULL,
    IntQui INT NULL,
    IntSex INT NULL,
    IntSab INT NULL,
    IntDom INT NULL,
	ObsHistoricoFamiliar VARCHAR(MAX) NULL,
	Hipertensao VARCHAR(3) NULL,
	Diabetes VARCHAR(3) NULL,
	Cancer VARCHAR(3) NULL,
	ProRespiratorio VARCHAR(3) NULL,
	TransMental VARCHAR(3) NULL,
	InfectoContagiosa VARCHAR(3) NULL,
	DoencasDigestiva VARCHAR(3) NULL,
	DeficienciaVAF VARCHAR(3) NULL,
	ObsDadosClinicos VARCHAR(MAX) NULL,	
	Humor VARCHAR(3) NULL,
	Insonia VARCHAR(3) NULL,
	Irritabilidade VARCHAR(3) NULL,
	Frustracao VARCHAR(3) NULL,
	DificuldadeConcentrar VARCHAR(3) NULL,
	Raiva VARCHAR(3) NULL,
	Inquietacao VARCHAR(3) NULL,
	Ansiedade VARCHAR(3) NULL,
	ObsAlteracoesPsicologicas VARCHAR(MAX) NULL,	
	Tabagismo VARCHAR(3) NULL,
	QuantoTabagismo INT NULL,
	TabagismoUsuario VARCHAR(30) NULL,
	Etilismo VARCHAR(3) NULL,
	TipoEtilismo VARCHAR(32) NULL,
	EtilismoUsuario VARCHAR(30) NULL,
	MedicacaoAlopatica VARCHAR(3) NULL,
	TipoMedicacaoAlopatica VARCHAR(32) NULL,
	MedicacaoAlopaticaUsuario VARCHAR(32) NULL,
	SPA VARCHAR(3) NULL,
	TipoSPA VARCHAR(32) NULL,		
	SPAUsuario VARCHAR(30) NULL,
	ObsTriagemSPA VARCHAR(MAX) NULL,
	VidaSexual VARCHAR(3) NULL,
	MetodoContraCeptivo VARCHAR(3) NULL,
	QualMetodoContraCeptivo VARCHAR(30) NULL, 
	Menarca VARCHAR(3) NULL,
	Menopausa VARCHAR(3) NULL,
	Gestante VARCHAR(3) NULL,
	Aborto VARCHAR(3) NULL,
	MotivoAborto VARCHAR(60) NULL,
	PraticaAtividadeFisica VARCHAR(3) NULL,
	QualAtividadeFisica VARCHAR(60) NULL,
	TrataPsicologico VARCHAR(3) NULL,
	ObsEstiloVida VARCHAR(MAX) NULL,	
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- TABELA DE AVALI��O I

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('AVALIACAO_TO_I'))
	CREATE TABLE AVALIACAO_TO_I
	(
	IdAvaliaTOI INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdATN INT FOREIGN KEY REFERENCES ADMISSAO_TERAPIA_PE(IdATN) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	ConhecoHabilidades VARCHAR(7) NULL,
	AcreditaRealizacoes VARCHAR(7) NULL,
	EsperoResultados VARCHAR(7) NULL,
	AcreditoRealizaTrabalho VARCHAR(7) NULL,
	AcreditoRealizaLar VARCHAR(7) NULL,
	AcreditoDiverteLazer VARCHAR(7) NULL,
	FacoAtividades VARCHAR(7) NULL,
	TenhoExpectativa VARCHAR(7) NULL,
	TenhoObjetoFuturo VARCHAR(7) NULL,
	IdentificoGostos VARCHAR(7) NULL,
	ParticipoProjetosImport VARCHAR(7) NULL,
	TenhoVariosInteresse VARCHAR(7) NULL,
	CostumoComprometo VARCHAR(7) NULL,
	DeEstudante VARCHAR(7) NULL,
	DeTrabalho VARCHAR(7) NULL,
	DeAmigo VARCHAR(7) NULL,
	DeFamiliar VARCHAR(7) NULL,
	ReconhecoPapeis VARCHAR(7) NULL,
	MantenhoVida VARCHAR(7) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- TABELA DE AVALIA��O II SOAF

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('AVALIACAO_TO_II'))
	CREATE TABLE AVALIACAO_TO_II
	(
	IdAvaliaTOII INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdATN INT FOREIGN KEY REFERENCES ADMISSAO_TERAPIA_PE(IdATN) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	OrganizoTempo VARCHAR(7) NULL,
	MantenhoPapeis VARCHAR(7) NULL,
	SouRotina VARCHAR(7) NULL,
	ConsigoOutros VARCHAR(7) NULL,
	TenhoSocial VARCHAR(7) NULL,
	PlanejoAgir VARCHAR(7) NULL,
	ConcentroTrabalho VARCHAR(7) NULL,
	IdentificoProblemas VARCHAR(7) NULL,
	IdentificoSolucaoProblemas VARCHAR(7) NULL,
	QuandoAgir VARCHAR(7) NULL,
	ConsigoHigiene VARCHAR(7) NULL,
	ConsigoCotidianas VARCHAR(7) NULL,
	ConsigoFinancas VARCHAR(7) NULL,
	ConsigoCasa VARCHAR(7) NULL,
	SintoPreciso VARCHAR(7) NULL,
	CostumoFrequentar VARCHAR(7) NULL,
	DataAplicacao DATETIME NULL,
	ResponsavelAplicacao VARCHAR(200) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('TO_HISTORICO_EDUCACIONAL_NOVO'))
	CREATE TABLE TO_HISTORICO_EDUCACIONAL_NOVO
	(
	IdHistoricoEduN INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdATN INT FOREIGN KEY REFERENCES ADMISSAO_TERAPIA_PE(IdATN) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	EscreveProprioNome VARCHAR(3) NULL,
	SabeLerEscrever VARCHAR(3) NULL,
	NivelInstrucao VARCHAR(30) NULL,
	InteresseEstudar VARCHAR(3) NULL,
	CursoProfissionalizante VARCHAR(3) NULL,	
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- TABELA COM AS PROFISSOES DA TABELA HISTORICO EDUCACIONAL

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO'))
	CREATE TABLE ITENS_CURSOS_TO_HISTORICO_EDUCACIONAL_NOVO
	(
	IdItemICTHEN INT IDENTITY (1,1) PRIMARY KEY NOT NULL,	
	IdATN INT FOREIGN KEY REFERENCES ADMISSAO_TERAPIA_PE(IdATN) NOT NULL,
	IdCurso INT FOREIGN KEY REFERENCES CURSOS(IdCurso) NOT NULL,
	IdHistoricoEduN INT FOREIGN KEY REFERENCES TO_HISTORICO_EDUCACIONAL_NOVA(IdHistoricoEduN) NOT NULL,
	PrioridadeCurso INT NULL,
	)

-- HISTORICO PROFISSIONAL

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('TO_HISTORICO_PROFISSIONAL_NOVO'))
	CREATE TABLE TO_HISTORICO_PROFISSIONAL_NOVO
	(
	IdHistoricoLabPN INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	IdATN INT FOREIGN KEY REFERENCES ADMISSAO_TERAPIA_PE(IdATN) NOT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	TemProfissao VARCHAR(3) NULL,
	QualProfissao VARCHAR(200) NULL,
	ExperienciaProfissional VARCHAR(3) NULL,
	QualExperienciaProfissional VARCHAR(200) NULL,
	DesejaTrabalharUnid VARCHAR(3) NULL,	
	InteresseLabor INT NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,
	)

-- TABELA COM AS PROFISSOES DA TABELA HISTORICO PROFISSIONAL

IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO'))
	CREATE TABLE ITENS_PROFISSAO_TO_HISTORICO_PROFISSIONAL_NOVO
	(
	IdItemPTHPN INT IDENTITY (1,1) PRIMARY KEY NOT NULL,	
	IdATN INT FOREIGN KEY REFERENCES ADMISSAO_TERAPIA_PE(IdATN) NOT NULL,
	IdCodigoProf INT FOREIGN KEY REFERENCES PROFISSAO(IdCodigoProf) NOT NULL,
	IdHistoricoLabN INT FOREIGN KEY REFERENCES TO_HISTORICO_PROFISSIONAL(IdHistoricoLabN) NOT NULL,
	InteresseLabor INT NULL,
	)