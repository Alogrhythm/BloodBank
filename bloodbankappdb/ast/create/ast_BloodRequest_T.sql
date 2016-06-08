DROP TABLE IF EXISTS `ast_BloodRequest_T`;

CREATE TABLE `ast_BloodRequest_T` ( `bloodRequestId` VARCHAR(256) NOT NULL, `noOfUnits` INT(10) NOT NULL, `patientName` VARCHAR(256) NOT NULL, `requestedByDoctor` VARCHAR(256) NOT NULL, `requestedByHospital` VARCHAR(256) NOT NULL, `dateNeededBy` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, `dispatchedToPatientOn` TIMESTAMP NULL, `bldg` VARCHAR(256) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `versionId` INT(10) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(10) NULL DEFAULT NULL, PRIMARY KEY (`bloodRequestId`));

