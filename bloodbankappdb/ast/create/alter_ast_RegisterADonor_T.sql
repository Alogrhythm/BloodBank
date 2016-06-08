

ALTER TABLE `ast_RegisterADonor_T` ADD CONSTRAINT FOREIGN KEY (`gendr`) REFERENCES `ast_Gender_M`(`genderId`);



ALTER TABLE `ast_RegisterADonor_T` ADD CONSTRAINT FOREIGN KEY (`addr`) REFERENCES `ast_Address_T`(`addressId`);



ALTER TABLE `ast_RegisterADonor_T` ADD CONSTRAINT FOREIGN KEY (`bg`) REFERENCES `ast_BloodGroup_M`(`bloodGroupId`);

