

ALTER TABLE `ast_RegisterACamp_T` ADD CONSTRAINT FOREIGN KEY (`addr`) REFERENCES `ast_Address_T`(`addressId`);

