INSERT INTO PORTA_ENTRADA(IdInternoCrc,DataEntrada,PSPEnf,HabEnf,PSPMed,HabMed,PSPJur,HabJur,PSPPed,HabPed,PSPPsi,HabPsi,PSPSso,HabSso,PSPOdo,HabOdo,PSPTer,HabTer,PSPEdu,HabEdu) VALUES('02-06-2020','ENFERMARIA','Sim','ENFERMARIA','Sim','JURIDICO','Sim','PEDAGOGIA','Sim','PSICOLOGIA','Sim','SERVICO SOCIAL','Sim','ODONTOLOGIA','Sim','TERAPIA OCUPACIONAL','Sim','EDUCACAO FISICA','Sim')

-- QUANDO O INTERNO J� EXISTE NA UNIDADE

UPDATE PORTA_ENTRADA SET DataEntrada='02-06-2020',PSPEnf='ENFERMARIA',HabEnf='Sim',PSPMed='ENFERMARIA',HabMed='Sim',PSPJur='JURIDICO',HabJur='Sim',PSPPed='PEDAGOGIA',HabPed='Sim',PSPPsi='PSICOLOGIA',HabPsi='Sim',PSPSso='SERVICO SOCIAL',HabSso='Sim',PSPOdo='ODONTOLOGIA',HabOdo='Sim',PSPTer='TERAPIA OCUPACIONAL',HabTer='Sim',PSPEdu='EDUCACAO FISICA',HabEdu='Sim' WHERE IdInternoCrc=148

