IF OBJECT_ID('person_contacts', 'U') IS NULL
    CREATE TABLE person_contacts (
        id BIGINT IDENTITY(1,1) PRIMARY KEY,
        person NVARCHAR(50) NOT NULL UNIQUE,
        contacts NVARCHAR(1000) NOT NULL
    );

-- Queries to insert initial values to database
IF NOT EXISTS (SELECT * FROM person_contacts)
    BEGIN
        INSERT INTO person_contacts(person, contacts) VALUES(N'Иванов Иван', N'Сидоров Сидр; Александров Александр')
        INSERT INTO person_contacts(person, contacts) VALUES(N'Алексеев Алексей', N'')
        INSERT INTO person_contacts(person, contacts) VALUES(N'Сидоров Сидр', N'Петров Петр')
    END