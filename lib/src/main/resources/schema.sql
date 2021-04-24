CREATE TABLE ShotLocations (
    slID SERIAL PRIMARY KEY,
    locName varchar NOT NULL
);

CREATE TABLE Medicines (
    mID SERIAL PRIMARY KEY,
    mName varchar NOT NULL
);

CREATE TABLE Users (
    usID SERIAL PRIMARY KEY,
    fName varchar NOT NULL,
    lName varchar NOT NULL,
    userName varchar NOT NULL,
    password varchar NOT NULL
);

CREATE TABLE ShotRecords (
    srID SERIAL PRIMARY KEY,
    usID INTEGER NOT NULL REFERENCES Users (usID),
    mID INTEGER NOT NULL REFERENCES Medicines (mID),
    slID INTEGER NOT NULL REFERENCES ShotLocations (slID),
    notes varchar,
    dateAndTime varchar
);

INSERT INTO Medicines(mName) VALUES ('insulin'), ('Strensiq');
INSERT INTO ShotLocations (locName) VALUES ('Right Arm'), ('Left Arm'), ('Right Leg'), ('Left Leg'), ('Right Hip'), ('Left Hip'), ('Stomach');
