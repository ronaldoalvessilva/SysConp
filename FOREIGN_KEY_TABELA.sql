SELECT * FROM EQUIPAMENTOS_SEGURANCA_EPI

ALTER TABLE EQUIPAMENTOS_SEGURANCA_EPI ADD CONSTRAINT FK_EQUIPAMENTOS_SEGURANCA_EPI_LOCAL_ARMAZENAMENTO_ARMAS_EPI FOREIGN KEY (IdLocal) REFERENCES LOCAL_ARMAZENAMENTO_ARMAS_EPI(IdLocal)
ON DELETE CASCADE
ON UPDATE CASCADE