-- Bruker tabell
CREATE TABLE Users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    hashed_password VARCHAR(255) NOT NULL
);

-- Family tabell
CREATE TABLE Family (
    fam_id INT PRIMARY KEY AUTO_INCREMENT,
    fam_name VARCHAR(255) NOT NULL,
    admin_id INT,
    qr_code BLOB,
    FOREIGN KEY (admin_id) REFERENCES Users(id)
);

-- Household tabell
CREATE TABLE Household (
    family_id INT,
    device_id INT,
    CONSTRAINT pk_household PRIMARY KEY (family_id, device_id),
    FOREIGN KEY (family_id) REFERENCES Family(fam_id)
);

-- Familie medlemer tabell 
CREATE TABLE Members (
    family_id INT,
    user_id INT,
    CONSTRAINT pk_members PRIMARY KEY (family_id, user_id),
    FOREIGN KEY (family_id) REFERENCES Family(fam_id),
    FOREIGN KEY (user_id) REFERENCES Users(id)
);

