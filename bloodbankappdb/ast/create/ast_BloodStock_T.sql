DROP TABLE IF EXISTS `ast_BloodStock_T`;

CREATE TABLE `ast_BloodStock_T` ( `bloodStockIsd` VARCHAR(256) NOT NULL, `bloodg` VARCHAR(256) NOT NULL, `noOfUnits` INT(10) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `versionId` INT(10) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(10) NULL DEFAULT NULL, PRIMARY KEY (`bloodStockIsd`));

