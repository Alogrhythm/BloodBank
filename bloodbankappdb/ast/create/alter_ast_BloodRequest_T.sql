

ALTER TABLE `ast_BloodRequest_T` ADD CONSTRAINT FOREIGN KEY (`bldg`) REFERENCES `ast_BloodGroup_M`(`bloodGroupId`);

