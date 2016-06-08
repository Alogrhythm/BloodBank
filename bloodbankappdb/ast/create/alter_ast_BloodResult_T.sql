

ALTER TABLE `ast_BloodResult_T` ADD CONSTRAINT FOREIGN KEY (`donorVisitId`) REFERENCES `ast_DonorVisit_T`(`donorVisitId`);

