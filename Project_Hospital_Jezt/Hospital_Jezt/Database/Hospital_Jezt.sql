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
	CaId int foreign key references Category(CaId),
)
GO
CREATE TABLE Oder
(
	OdId int primary key identity(1,1),
	OdName nvarchar(100) not null,
	OdCode varchar(50) not null,
	OdTotalPrice float,
	OdQuantity int,
	OdStatus bit,
	PaId int foreign key references Patient(PaId)
)
GO
CREATE TABLE OderDetail
(
	OddId int primary key identity(1,1),
	OddMeName nvarchar(100) not null,
	OddCreated datetime not null,
	OddMeQuantity int not null,
	OddMePrice float not null,
	OdId int foreign key references Oder(OdId),
	MeId int foreign key references Medicine(MeId)
)
GO
CREATE TABLE Patient
(
	PaId int primary key identity(1,1),
	PaAcc varchar(100) not null,
	PaPass varchar(100) not null,
	PaFullName nvarchar(100) not null,
	PaPhone nvarchar(100) not null,
	PaAge int,
	PaEmail nvarchar(100),
	PaAvatar ntext,
	PaAdress ntext,
	PaContent ntext,
	PaStatus bit,
	DoId int foreign key references Doctor(DoId)
)
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
	DoAdress ntext,
	DoContent ntext,
	DoStatus bit,
	CaId int foreign key references Category(CaId)
)
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
GO

CREATE PROC checkPatient
	@paAcc varchar(100),
	@paPass varchar(100)
AS
BEGIN
	SELECT PaAcc,PaPass FROM Patient WHERE PaAcc = @paAcc and PaPass = @paPass;
END
GO
CREATE PROC getPatientById
	@paId int
AS
BEGIN
	SELECT * FROM Patient WHERE PaId = @paId;
END
GO
EXEC checkPatient @paAcc = "luong" , @paPass = "1";
GO
CREATE PROC getAllPatientDoId
	@paId int,
	@paAcc varchar(100),
	@paPass varchar(100),
	@paFullName nvarchar(100),
	@paPhone nvarchar(100),
	@paAge int,
	@paEmail nvarchar(100),
	@paAvatar ntext,
	@paAdress ntext,
	@paContent ntext,
	@paStatus bit,
	@doId int
AS
BEGIN
	SELECT * FROM Patient WHERE DoId = @doId;
END
GO
EXEC @getAllPatient @doId = 1;
GO
CREATE PROC getAllPatient
	@paId int,
	@paAcc varchar(100),
	@paPass varchar(100),
	@paFullName nvarchar(100),
	@paPhone nvarchar(100),
	@paAge int,
	@paEmail nvarchar(100),
	@paAvatar ntext,
	@paAdress ntext,
	@paContent ntext,
	@paStatus bit,
	@doId int
AS
BEGIN
	SELECT * FROM Patient;
END
GO
GO
GO
CREATE PROC checkDoctor
	@doAcc varchar(100),
	@doPass varchar(100)
AS
BEGIN
	SELECT DoAcc,DoPass FROM Doctor WHERE DoAcc = @doAcc and DoPass = @doPass;
END
GO
CREATE PROC getDoctorById
	@doId int
AS
BEGIN
	SELECT * FROM Doctor WHERE DoId = @doId;
END
GO
EXEC checkDoctor @doAcc = "tien01" , @doPass = "1";
GO

GO
CREATE PROC getAllDoctor
	@doId int,
	@doAcc varchar(100),
	@doPass varchar(100),
	@doFullName nvarchar(100) ,
	@doPhone nvarchar(100) ,
	@doAge int,
	@doEmail nvarchar(100),
	@doAvatar ntext,
	@doAdress ntext,
	@doContent ntext,
	@doStatus bit,
	@caId int
AS
BEGIN
	SELECT * FROM Doctor;
END
GO
GO
GO
CREATE PROC checkDirector
	@diAcc varchar(100),
	@diPass varchar(100)
AS
BEGIN
	SELECT DiAcc,DiPass FROM Director WHERE DiAcc = @diAcc and DiPass = @diPass;
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
	@diStatus bit
AS
BEGIN
	UPDATE Director SET
	DiAcc = @diAcc,
	DiPass = @diPass,
	DiFullName = @diFullName,
	DiPhone = @diPhone,
	DiContent = @diContent,
	DiStatus = @diStatus
	WHERE DiId = @diId;
END
GO
GO
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
	@caStatus bit
AS
BEGIN
	UPDATE Category SET CaName = @caName,
						CaContent = @caContent,
						@caStatus = @caStatus
	WHERE CaId = @caId;
END
GO
CREATE PROC insertCategory
	@caName nvarchar(100),
	@caContent ntext,
	@caStatus bit
AS
BEGIN
	INSERT INTO Category VALUES (@caName,@caContent,@caStatus);
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
	SELECT Doctor.DoId , Doctor.DoAcc , Doctor.DoPass , Doctor.DoFullName , Doctor.DoPhone , Doctor.DoAge , Doctor.DoEmail, Doctor.DoAvatar, Doctor.DoAdress, Doctor.DoContent FROM Category INNER JOIN Doctor ON Category.CaId = Doctor.CaId WHERE Doctor.CaId = @caId;
END
EXEC getDoctorWithCaId @caId = 1;
GO