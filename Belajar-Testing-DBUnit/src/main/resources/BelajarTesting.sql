USE `BelajarTesting`;
CREATE TABLE IF NOT EXISTS `mahasiswa` (
  `npm` VARCHAR (10) NOT NULL,
  `nama` VARCHAR (30) NOT NULL,
  `kelas` VARCHAR(10) NOT NULL,
  `jurusan` VARCHAR(30) NOT NULL,
  `tanggalLahir` DATE NOT NULL,
  PRIMARY KEY (npm)
) ENGINE = InnoDB;