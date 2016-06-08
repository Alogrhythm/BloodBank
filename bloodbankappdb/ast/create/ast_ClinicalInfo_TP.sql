DROP TABLE IF EXISTS `ast_ClinicalInfo_TP`;

CREATE TABLE `ast_ClinicalInfo_TP` ( `donorVisitId` VARCHAR(256) NOT NULL, `clinicalInfoId` VARCHAR(256) NOT NULL, `height` VARCHAR(256) NOT NULL, `weight` VARCHAR(256) NOT NULL, `pulse` VARCHAR(256) NOT NULL, `bp` VARCHAR(256) NOT NULL, `temprature` VARCHAR(256) NOT NULL, `unitsOfBlood` INT(10) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `versionId` INT(10) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(10) NULL DEFAULT NULL, PRIMARY KEY (`clinicalInfoId`));

