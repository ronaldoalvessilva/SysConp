-- INICIO EM: 31/05/2019

-- PRORES
-- M�DULO ENFERMARIA

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAOENFERMEIRA') AND NAME = 'Hanseniase')
   ALTER TABLE ADMISSAOENFERMEIRA ADD Hanseniase VARCHAR(30) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAOENFERMEIRA') AND NAME = 'Escabiose')
   ALTER TABLE ADMISSAOENFERMEIRA ADD Escabiose VARCHAR(3) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAOENFERMEIRA') AND NAME = 'Dst')
   ALTER TABLE ADMISSAOENFERMEIRA ADD Dst VARCHAR(30) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ADMISSAOENFERMEIRA') AND NAME = 'Vacina')
   ALTER TABLE ADMISSAOENFERMEIRA ADD Vacina VARCHAR(3) NULL


IF NOT EXISTS (SELECT NULL FROM SYSOBJECTS WHERE ID = OBJECT_ID('ACOMPANHAMENTO_INTERNO_ENFERMARIA'))
	CREATE TABLE ACOMPANHAMENTO_INTERNO_ENFERMARIA
	(
	IdEnf INT IDENTITY (1,1) PRIMARY KEY NOT NULL,	
	IdLanc INT FOREIGN KEY REFERENCES ADMISSAOENFERMEIRA(IdLanc) NOT NULL,
	IdEvoEnfer INT NULL,
	IdInternoCrc INT FOREIGN KEY REFERENCES PRONTUARIOSCRC(IdInternoCrc) NOT NULL,
	DataReg DATETIME NULL,
	Diabetes VARCHAR(3) NULL,
	DiabControl VARCHAR(3) NULL,
	QtdDiabetes INT NULL,
	Hipertensao VARCHAR(3) NULL,
	HiperControl VARCHAR(3) NULL,
	QtdHipertensao INT NULL,
	Escabiose VARCHAR(3) NULL,
	EscabioseCura VARCHAR(3) NULL,
	QtdEscabiose INT NULL,
	Hanseniase VARCHAR(3) NULL,
	HanseniaseCura VARCHAR(3) NULL,
	QtdHanseniase INT NULL,
	Sifilis VARCHAR(13) NULL,
	SifilisCura VARCHAR(3) NULL,
	QtdSifilis INT NULL,
	Tuberculose VARCHAR(13) NULL,
	TuberculoseCura VARCHAR(3) NULL,
	QtdTuberculose INT NULL,
	Hiv VARCHAR(13) NULL,
	HivControlada VARCHAR(3) NULL,
	QtdHiv INT NULL,
	HepatiteB VARCHAR(13) NULL,
	HepatiteBCont VARCHAR(3) NULL,
	QtdHepatiteB INT NULL,
	HepatiteC VARCHAR(13) NULL,
	HepatiteCCont VARCHAR(3) NULL,
	QtdHepatiteC INT NULL,
	Dst VARCHAR(13) NULL,
	DstCurada VARCHAR(3) NULL,
	QtdDst INT NULL,
	Vdlr VARCHAR(13) NULL,
	VdlrCurada VARCHAR(3) NULL,
	QtdVdlr INT NULL,
	Vacina VARCHAR(3) NULL,
	VacinaCura VARCHAR(3) NULL,
	QtdVacina INT NULL,
	Observacao VARCHAR(MAX) NULL,
	UsuarioInsert VARCHAR(50) NULL,
	UsuarioUp VARCHAR(50) NULL,
	DataInsert VARCHAR(20) NULL,
	DataUp VARCHAR(20) NULL,
	HorarioInsert VARCHAR(10) NULL,
	HorarioUp VARCHAR(10) NULL,	
	)
-- TERMINO DA IMPLEMENTA��O DA ENFERMAGEM: 01/06/2019

-- INICIO DO M�DULO PEDAGOGIA
-- DATA: 03/06/2019

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ITENSMATRICULA') AND NAME = 'StatusAluno')
   ALTER TABLE ITENSMATRICULA ADD StatusAluno VARCHAR(30) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ITENSMATRICULA') AND NAME = 'SituacaoAluno')
   ALTER TABLE ITENSMATRICULA ADD SituacaoAluno VARCHAR(30) NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('ITENSMATRICULA') AND NAME = 'DataConDes')
   ALTER TABLE ITENSMATRICULA ADD DataConDes DATETIME NULL

IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('EVOLUCAO_ADMISSAO_PEDAGOGIA') AND NAME = 'AcessoUni')
   ALTER TABLE EVOLUCAO_ADMISSAO_PEDAGOGIA ADD AcessoUni VARCHAR(3) NULL
IF NOT EXISTS(SELECT 1 FROM SYSCOLUMNS WHERE ID = OBJECT_ID('EVOLUCAO_ADMISSAO_PEDAGOGIA') AND NAME = 'AnoIngresso')
   ALTER TABLE EVOLUCAO_ADMISSAO_PEDAGOGIA ADD AnoIngresso INT NULL
