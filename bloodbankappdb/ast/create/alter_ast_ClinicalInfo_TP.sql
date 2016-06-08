

ALTER TABLE `ast_ClinicalInfo_TP` ADD CONSTRAINT FOREIGN KEY (`donorVisitId`) REFERENCES `ast_DonorVisit_T`(`donorVisitId`);

