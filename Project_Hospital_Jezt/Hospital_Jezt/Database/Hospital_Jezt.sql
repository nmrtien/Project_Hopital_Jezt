CREATE DATABASE Hospital_Jezt

GO

USE Hospital_Jezt

GO

CREATE TABLE Category
(
	CaId int primary key identity(1,1),
	CaName nvarchar(100) not null,
	CaContent ntext,
	CaStatus bit	
)
ALTER TABLE Category ADD CaImage nvarchar(100)
GO

CREATE TABLE Medicine
(
	MeId int primary key identity(1,1),
	MeName nvarchar(100) not null,
	MePrice float not null,
	MeProducer nvarchar(100) not null,
	MeTitle nvarchar(50) not null,
	MeContent ntext,
	MeDateOfManufacture datetime not null,
	MeExpirationDate datetime not null,
	MeImage ntext,
	MeStatus bit,
	CaId int foreign key references Category(CaId)
)

GO

CREATE TABLE Oder
(
	OdId int primary key identity(1,1),
	OdName nvarchar(100) not null,
	OdAddress nvarchar(50) not null,
	OdPhone nvarchar(10) not null
)

GO

CREATE TABLE OderDetail
(
	OddId int primary key identity(1,1),
	OddMeName nvarchar(100) not null,
	OddMeQuantity int not null,
	OddMePrice float not null,
	OddAmount float not null,
	OdId int foreign key references Oder(OdId)
)

GO

CREATE TABLE Patients
(
	PaId int primary key identity(1,1),
	PaAcc varchar(100) not null,
	PaPass varchar(100) not null,
	PaFullName nvarchar(100) not null,
	PaPhone nvarchar(100) not null,
	PaAge int,
	PaEmail nvarchar(100),
	PaAvatar ntext,
	PaAddress ntext,
	PaContent ntext,
	PaStatus bit,
	DoId int foreign key references Doctor(DoId)
)
ALTER TABLE Patients DROP cOLUMN RollId INT DEFAULT 3;

GO

CREATE TABLE Doctor
(
	DoId int primary key identity(1,1),
	DoAcc varchar(100) not null,
	DoPass varchar(100) not null,
	DoFullName nvarchar(100) not null,
	DoPhone nvarchar(100) not null,
	DoAge int,
	DoEmail nvarchar(100),
	DoAvatar ntext,
	DoAddress ntext,
	DoContent ntext,
	DoStatus bit,
	CaId int foreign key references Category(CaId)
)
ALTER TABLE Doctor ADD RollId INT DEFAULT 2;
GO

CREATE TABLE Director
(
	DiId int primary key identity(1,1),
	DiAcc varchar(100) not null,
	DiPass varchar(100) not null,
	DiFullName nvarchar(100) not null,
	DiPhone nvarchar(100) not null,
	DiContent ntext,
	DiStatus bit
)
ALTER TABLE Director ADD RollId INT DEFAULT 1;

GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO

CREATE PROC checkLoginPatients
	@paAcc varchar(100),
	@paPass varchar(100)
AS
BEGIN
	SELECT * FROM Patients WHERE PaAcc = @paAcc and PaPass = @paPass;
END

GO

CREATE PROC getPatientsById
	@paId int
AS
BEGIN
	SELECT * FROM Patients WHERE PaId = @paId;
END

GO

EXEC checkLoginPatients @paAcc = "luong" , @paPass = "1";

GO

CREATE PROC insertPatients
	@paAcc varchar(100),
	@paPass varchar(100),
	@paFullName nvarchar(100),
	@paPhone nvarchar(100) ,
	@paAge int,
	@paEmail nvarchar(100),
	@paAvatar ntext,
	@paAddress ntext,
	@paContent ntext,
	@paStatus bit,
	@doId int,
	@rollId int

AS
BEGIN
	INSERT INTO Patients VALUES (@paAcc,@paPass,@paFullName,@paPhone,@paAge,@paEmail,@paAvatar,@paAddress,@paContent,@paStatus,@doId,@rollId);
END

GO

CREATE PROC updatePatients
	@paId int,
	@paAcc varchar(100),
	@paPass varchar(100),
	@paFullName nvarchar(100),
	@paPhone nvarchar(100) ,
	@paAge int,
	@paEmail nvarchar(100),
	@paAvatar ntext,
	@paAddress ntext,
	@paContent ntext,
	@paStatus bit,
	@doId int,
	@rollId int
	
AS
BEGIN
	UPDATE Patients SET PaAcc = @paAcc,
						PaPass = @paPass,
						PaFullName = @paFullName,
						PaPhone = @paFullName,
						PaAge = @paAge,
						PaEmail = @paEmail,
						PaAvatar = @paAvatar,
						PaAddress = @paAddress,
						PaContent = @paContent,
						PaStatus = @paStatus,
						DoId = @doId,
						RollId = @rollId
	WHERE PaId = @paId;
END

GO

CREATE PROC deletePatients
	@paId int

AS
BEGIN
	DELETE FROM Patients WHERE PaId = @paId;
END

GO

CREATE PROC getAllPatientsDoId
	@doId int
AS
BEGIN
	SELECT * FROM Patients WHERE DoId = @doId;
END

GO

EXEC getAllPatientsDoId @doId = 2;
GO

CREATE PROC getAllPatients
	
AS
BEGIN
	SELECT * FROM Patients;
END

GO

CREATE PROC searchPatientsByName
	@paFullName nvarchar(100)
AS 
BEGIN
	SELECT * FROM Patients WHERE PaFullName = @paFullName;	
END

GO

CREATE PROC checkAccPatients
	@paAcc varchar(100)
AS
BEGIN
	SELECT PaAcc FROM Patients WHERE PaAcc = @paAcc;
END


GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO
GO

CREATE PROC checkLoginDoctor
	@doAcc varchar(100),
	@doPass varchar(100)
AS
BEGIN
	SELECT * FROM Doctor WHERE DoAcc = @doAcc and DoPass = @doPass;
END

GO

CREATE PROC getDoctorById
	@doId int
AS
BEGIN
	SELECT * FROM Doctor WHERE DoId = @doId;
END

GO

CREATE PROC insertDoctor
	@doAcc varchar(100),
	@doPass varchar(100),
	@doFullName nvarchar(100),
	@doPhone nvarchar(100),
	@doAge int,
	@doEmail nvarchar(100),
	@doAvatar ntext,
	@doAddress ntext,
	@doContent ntext,
	@doStatus bit,
	@caId int,
	@rollId int
AS
BEGIN
	INSERT INTO Doctor VALUES (@doAcc,@doPass,@doFullName,@doPhone,@doAge,@doEmail,@doAvatar,@doAddress,@doContent,@doStatus,@caId,@rollId);
END

GO

CREATE PROC updateDoctor
	@doId int,
	@doAcc varchar(100),
	@doPass varchar(100),
	@doFullName nvarchar(100),
	@doPhone nvarchar(100),
	@doAge int,
	@doEmail nvarchar(100),
	@doAvatar ntext,
	@doAddress ntext,
	@doContent ntext,
	@doStatus bit,
	@caId int,
	@rollId int
AS
BEGIN
	UPDATE Doctor SET DoAcc = @doAcc,
					  DoPass = @doPass,
					  DoFullName = @doFullName,
					  DoPhone = @doPhone,
					  DoAge = @doAge,
					  DoEmail = @doEmail,
					  DoAvatar = @doAvatar,
					  DoAddress = @doAddress,
					  DoContent = @doContent,
					  DoStatus = @doStatus,
					  CaId = @caId,
					  RollId = @rollId
	WHERE DoId = @doId;
END

GO

EXEC checkDoctor @doAcc = "tien01" , @doPass = "1";

GO

GO

CREATE PROC getAllDoctor
	
AS
BEGIN
	SELECT * FROM Doctor;
END
EXEC getAllDoctor;

GO

CREATE PROC deleteDoctor
	@doId int
AS
BEGIN
	DELETE FROM Doctor WHERE DoId = @doId;
END

GO

CREATE PROC searchDoctorByName
	@doFullName nvarchar(100)
AS 
BEGIN
	SELECT * FROM Doctor WHERE DoFullName = @doFullName;	
END

GO

CREATE PROC checkAccDoctor
	@doAcc varchar(100)
AS
BEGIN
	SELECT DoAcc FROM Doctor WHERE DoAcc = @doAcc;
END

GO

CREATE PROC countAllDoctor
AS
BEGIN
	SELECT COUNT(DISTINCT DoId) FROM Doctor;
END

GO

CREATE PROC selectTop8Doctor
AS
BEGIN
	SELECT TOP(8) * FROM Doctor;
END
EXEC selectTop8Doctor

GO
CREATE PROC getCaNameWithDoId
	@caId int
AS
BEGIN
	SELECT Doctor.DoId , Doctor.DoAcc , Doctor.DoPass , Doctor.DoFullName , Doctor.DoPhone , Doctor.DoAge , Doctor.DoEmail, Doctor.DoAvatar, Doctor.DoAddress, Doctor.DoContent, Category.CaName, Category.CaContent FROM Category INNER JOIN Doctor ON Category.CaId = Doctor.CaId WHERE Category.CaId = @caId;
END

GO
EXEC getDoctorWithCaId @caId = 3;
GO
GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO
GO
GO

CREATE PROC checkLoginDirector
	@diAcc varchar(100),
	@diPass varchar(100)
AS
BEGIN
	SELECT * FROM Director WHERE DiAcc = @diAcc and DiPass = @diPass;
END

GO

CREATE PROC getDirectorById
	@diId int
AS
BEGIN
	SELECT * FROM Director WHERE DiId = @diId;
END

GO

EXEC checkDirector @diAcc = "jezt" , @diPass = "1";

GO

CREATE PROC getDirector
AS
BEGIN
	SELECT * FROM Director;
END

GO

CREATE PROC updateDirector
	@diId int,
	@diAcc varchar(100),
	@diPass varchar(100),
	@diFullName nvarchar(100),
	@diPhone nvarchar(100),
	@diContent ntext,
	@diStatus bit,
	@rollId int
AS
BEGIN
	UPDATE Director SET
	DiAcc = @diAcc,
	DiPass = @diPass,
	DiFullName = @diFullName,
	DiPhone = @diPhone,
	DiContent = @diContent,
	DiStatus = @diStatus,
	RollId = @rollId
	WHERE DiId = @diId;
END

GO
GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO
GO

CREATE PROC getAllCategory
AS
BEGIN
	SELECT * FROM Category;
END

GO

CREATE PROC updateCategory
	@caId int,
	@caName nvarchar(100),
	@caContent ntext,
	@caStatus bit,
	@caImage nvarchar(100)
AS
BEGIN
	UPDATE Category SET CaName = @caName,
						CaContent = @caContent,
						CaStatus = @caStatus,
						CaImage = @caImage
	WHERE CaId = @caId;
END

GO

CREATE PROC insertCategory
	@caName nvarchar(100),
	@caContent ntext,
	@caStatus bit,
	@caImage nvarchar(100)
AS
BEGIN
	INSERT INTO Category VALUES (@caName,@caContent,@caStatus,@caImage);
END

GO

CREATE PROC getCategoryById
	@caId int
AS
BEGIN
	SELECT * FROM Category WHERE CaId = @caId;
END

GO

CREATE PROC deleteCategory
	@caId int
AS
BEGIN
	DELETE FROM Category WHERE CaId = @caId;
END

GO

CREATE PROC getDoctorWithCaId
	@caId int
AS
BEGIN
	SELECT Doctor.DoId , Doctor.DoAcc , Doctor.DoPass , Doctor.DoFullName , Doctor.DoPhone , Doctor.DoAge , Doctor.DoEmail, Doctor.DoAvatar, Doctor.DoAddress, Doctor.DoContent, Category.CaName, Category.CaContent FROM Category INNER JOIN Doctor ON Category.CaId = Doctor.CaId WHERE Category.CaId = @caId;
END

GO
EXEC getDoctorWithCaId @caId = 3;
GO
GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO GO

CREATE PROC getAllMedicine
AS
BEGIN
	SELECT * FROM Medicine;
END

GO

CREATE PROC insertMedicine
	@meName nvarchar(100),
	@mePrice float,
	@meProducer nvarchar(100),
	@meTitle nvarchar(50),
	@meContent ntext,
	@meDateOfManufacture datetime,
	@meExpirationDate datetime ,
	@meImage ntext,
	@meStatus bit,
	@caId int
AS
BEGIN
	INSERT INTO Medicine VALUES (@meName,@mePrice,@meProducer,@meTitle,@meContent,@meDateOfManufacture,@meExpirationDate,@meImage,@meStatus,@caId);
END

GO

CREATE PROC updateMedicine
	@meId int,
	@meName nvarchar(100),
	@mePrice float,
	@meProducer nvarchar(100),
	@meTitle nvarchar(50),
	@meContent ntext,
	@meDateOfManufacture datetime,
	@meExpirationDate datetime ,
	@meImage ntext,
	@meStatus bit,
	@caId int
AS
BEGIN
	UPDATE Medicine SET MeName = @meName,
						MePrice = @mePrice,
						MeProducer = @meProducer,
						MeTitle = @meTitle,
						MeContent = @meContent,
						MeDateOfManufacture = @meDateOfManufacture,
						MeExpirationDate = @meExpirationDate,
						MeImage = @meImage,
						MeStatus = @meStatus,
						CaId = @caId
	WHERE MeId = @meId;
END

GO

CREATE PROC deleteMedicine
	@meId int
AS
BEGIN
	DELETE FROM Medicine WHERE MeId = @meId;
END

GO

CREATE PROC getMedicineById
	@meId int
AS
BEGIN
	SELECT * FROM Medicine WHERE MeId = @meId;
END

GO

CREATE PROC searchMedicineByName
	@meName nvarchar(100)
AS
BEGIN
	SELECT * FROM Medicine WHERE MeName = @meName;
END

GO

CREATE PROC getMedicineWithCaId
	@caId int
AS
BEGIN
	SELECT Medicine.MeId,Medicine.MeName,Medicine.MePrice,Medicine.MeProducer,Medicine.MeTitle,Medicine.MeContent,Medicine.MeDateOfManufacture,Medicine.MeExpirationDate,Medicine.MeImage,Medicine.MeStatus,Medicine.CaId FROM Category INNER JOIN Medicine ON Category.CaId = Medicine.CaId WHERE Medicine.CaId = @caId;
END

GO
EXEC getMedicineWithCaId @caId = 2;
GO

GO GO GO

CREATE PROC getAllOder
AS
BEGIN
	SELECT * FROM Oder;
END

GO

CREATE PROC getOderId
AS
BEGIN
	SELECT MAX(OdId) FROM Oder;
END

GO

CREATE PROC searchOderById
	@odId int
AS
BEGIN
	SELECT * FROM Oder WHERE OdId = @odId;
END
EXEC searchOderById @odId = 1;

GO

CREATE PROC deleteOder
	@odId int
AS
BEGIN
	DELETE FROM Oder WHERE OdId = @odId;
END


CREATE PROC insertOder
	@odName nvarchar(100),
	@odAddress nvarchar(50),
	@odPhone nvarchar(10)
AS
BEGIN
	INSERT INTO Oder VALUES(@odName,@odAddress,@odPhone);
END

GO

GO GO GO GO

CREATE PROC getOderDetail
	@odId int 
AS
BEGIN
	SELECT * FROM OderDetail WHERE OdId = @odId;
END
EXEC getOderDetail @odId = 1;

GO

CREATE PROC insertOderDetail
	@oddMeName nvarchar(100),
	@oddMeQuantity int,
	@oddMePrice float,
	@oddAmount float,
	@odId int
AS
BEGIN
	INSERT INTO OderDetail VALUES(@oddMeName,@oddMeQuantity,@oddMePrice,@oddAmount,@odId);
END