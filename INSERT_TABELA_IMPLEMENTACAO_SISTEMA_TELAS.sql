/*

BEGIN TRANSACTION
ROLLBACK TRANSACTION
COMMIT TRANSACTION
*/

BEGIN TRANSACTION
SELECT * FROM TELAS

INSERT INTO 
            IMPLEMENTACAO_SISTEMA(IdModulo,
            IdTelas,IdPar,Habilitar)
       SELECT 
	        IdModulo,
			IdTelas,
			1,
			'N�o' 
			FROM TELAS

SELECT * FROM IMPLEMENTACAO_SISTEMA


COMMIT TRANSACTION
