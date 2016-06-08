

ALTER TABLE `ast_DonorVisit_T` ADD CONSTRAINT FOREIGN KEY (`dType`) REFERENCES `ast_DonationType_M`(`donationTypeId`);



ALTER TABLE `ast_DonorVisit_T` ADD CONSTRAINT FOREIGN KEY (`camp`) REFERENCES `ast_RegisterACamp_T`(`campId`);



ALTER TABLE `ast_DonorVisit_T` ADD CONSTRAINT FOREIGN KEY (`donor`) REFERENCES `ast_RegisterADonor_T`(`donorId`);

