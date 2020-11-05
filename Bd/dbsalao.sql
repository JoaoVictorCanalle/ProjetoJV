-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.13-MariaDB - Source distribution
-- Server OS:                    Linux
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for dbsalao
DROP DATABASE IF EXISTS `dbsalao`;
CREATE DATABASE IF NOT EXISTS `dbsalao` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `dbsalao`;

-- Dumping structure for table dbsalao.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `categoria_id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_descricao` varchar(45) NOT NULL,
  `categoria_tipo` int(11) NOT NULL,
  PRIMARY KEY (`categoria_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table dbsalao.categoria: ~0 rows (approximately)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Dumping structure for table dbsalao.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `cliente_id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_nome` varchar(45) NOT NULL,
  `cliente_endereco` varchar(45) DEFAULT NULL,
  `cliente_bairro` varchar(30) DEFAULT NULL,
  `cliente_cidade` varchar(30) DEFAULT NULL,
  `cliente_uf` varchar(2) DEFAULT NULL,
  `cliente_cep` varchar(9) DEFAULT NULL,
  `cliente_telefone` varchar(13) DEFAULT NULL,
  `cliente_ficha_id` int(11) NOT NULL,
  PRIMARY KEY (`cliente_id`),
  KEY `fk_fichacliente` (`cliente_ficha_id`),
  CONSTRAINT `fk_fichacliente` FOREIGN KEY (`cliente_ficha_id`) REFERENCES `ficha` (`ficha_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table dbsalao.cliente: ~0 rows (approximately)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Dumping structure for table dbsalao.estoque
CREATE TABLE IF NOT EXISTS `estoque` (
  `estoque_id` int(11) NOT NULL AUTO_INCREMENT,
  `estoque_id_produto` int(11) NOT NULL,
  `estoque_quant` int(11) NOT NULL,
  `estoque_valor` double NOT NULL,
  PRIMARY KEY (`estoque_id`),
  KEY `fk_estoqueproduto` (`estoque_id_produto`),
  CONSTRAINT `fk_estoqueproduto` FOREIGN KEY (`estoque_id_produto`) REFERENCES `produto` (`produto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table dbsalao.estoque: ~0 rows (approximately)
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;

-- Dumping structure for table dbsalao.ficha
CREATE TABLE IF NOT EXISTS `ficha` (
  `ficha_id` int(11) NOT NULL AUTO_INCREMENT,
  `ficha_valortotal` double(9,2) NOT NULL,
  `ficha_ultpagamento` date DEFAULT NULL,
  `ficha_ultcompra` date DEFAULT NULL,
  `ficha_pontuacao` int(11) NOT NULL,
  `ficha_dtabertura` date NOT NULL,
  PRIMARY KEY (`ficha_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table dbsalao.ficha: ~0 rows (approximately)
/*!40000 ALTER TABLE `ficha` DISABLE KEYS */;
/*!40000 ALTER TABLE `ficha` ENABLE KEYS */;

-- Dumping structure for table dbsalao.formapagamento
CREATE TABLE IF NOT EXISTS `formapagamento` (
  `formpag_id` int(11) NOT NULL AUTO_INCREMENT,
  `formpag_descricao` varchar(45) NOT NULL,
  `formpag_tipo` int(11) NOT NULL,
  `formpag_qtde_parc` int(11) NOT NULL,
  PRIMARY KEY (`formpag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table dbsalao.formapagamento: ~0 rows (approximately)
/*!40000 ALTER TABLE `formapagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `formapagamento` ENABLE KEYS */;

-- Dumping structure for table dbsalao.itensvenda
CREATE TABLE IF NOT EXISTS `itensvenda` (
  `itensvenda_id_venda` int(11) NOT NULL,
  `itensvenda_id_produto` int(11) NOT NULL,
  `itensvenda_descricao` varchar(45) NOT NULL,
  `itensvenda_quant` int(11) NOT NULL,
  `itensvenda_total` double(9,2) NOT NULL,
  KEY `fk_itensvendavenda` (`itensvenda_id_venda`),
  KEY `fk_itensvendaproduto` (`itensvenda_id_produto`),
  CONSTRAINT `fk_itensvendaproduto` FOREIGN KEY (`itensvenda_id_produto`) REFERENCES `produto` (`produto_id`),
  CONSTRAINT `fk_itensvendavenda` FOREIGN KEY (`itensvenda_id_venda`) REFERENCES `venda` (`venda_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table dbsalao.itensvenda: ~0 rows (approximately)
/*!40000 ALTER TABLE `itensvenda` DISABLE KEYS */;
/*!40000 ALTER TABLE `itensvenda` ENABLE KEYS */;

-- Dumping structure for table dbsalao.pag_parc
CREATE TABLE IF NOT EXISTS `pag_parc` (
  `pag_parc_id` int(11) NOT NULL,
  `pag_parc_item` int(11) NOT NULL,
  `pag_parc_data` date NOT NULL,
  `pag_parc_valor` double(9,2) NOT NULL,
  `pag_parc_tipo` int(11) DEFAULT NULL,
  `pag_parc_cod_ficha` int(11) NOT NULL,
  PRIMARY KEY (`pag_parc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table dbsalao.pag_parc: ~0 rows (approximately)
/*!40000 ALTER TABLE `pag_parc` DISABLE KEYS */;
/*!40000 ALTER TABLE `pag_parc` ENABLE KEYS */;

-- Dumping structure for table dbsalao.parcela
CREATE TABLE IF NOT EXISTS `parcela` (
  `parcela_id` int(11) NOT NULL AUTO_INCREMENT,
  `parcela_cod_venda` int(11) NOT NULL,
  `parcela_data` date NOT NULL,
  `parcela_pago` double(9,2) DEFAULT NULL,
  `parcela_aberto` double(9,2) DEFAULT NULL,
  `parcela_cod_ficha` int(11) NOT NULL,
  PRIMARY KEY (`parcela_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table dbsalao.parcela: ~0 rows (approximately)
/*!40000 ALTER TABLE `parcela` DISABLE KEYS */;
/*!40000 ALTER TABLE `parcela` ENABLE KEYS */;

-- Dumping structure for table dbsalao.produto
CREATE TABLE IF NOT EXISTS `produto` (
  `produto_id` int(11) NOT NULL AUTO_INCREMENT,
  `produto_descricao` varchar(45) NOT NULL,
  `produto_data` date NOT NULL,
  `produto_valor` double(9,2) NOT NULL,
  `produto_categoria_id` int(11) NOT NULL,
  `produto_pontfid` int(11) NOT NULL,
  `produto_status` int(11) NOT NULL,
  PRIMARY KEY (`produto_id`),
  KEY `fk_produtocategoria` (`produto_categoria_id`),
  CONSTRAINT `fk_produtocategoria` FOREIGN KEY (`produto_categoria_id`) REFERENCES `categoria` (`categoria_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table dbsalao.produto: ~0 rows (approximately)
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;

-- Dumping structure for table dbsalao.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `usuario_id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_nome` varchar(40) NOT NULL,
  `usuario_login` varchar(20) NOT NULL,
  `usuario_senha` varchar(20) NOT NULL,
  `usuario_perfil` varchar(20) NOT NULL,
  `perfil` varchar(20) NOT NULL,
  PRIMARY KEY (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table dbsalao.usuario: ~1 rows (approximately)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`usuario_id`, `usuario_nome`, `usuario_login`, `usuario_senha`, `usuario_perfil`, `perfil`) VALUES
	(1, 'administrador', 'admin', '123', 'admin', '');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Dumping structure for table dbsalao.venda
CREATE TABLE IF NOT EXISTS `venda` (
  `venda_id` int(11) NOT NULL AUTO_INCREMENT,
  `venda_id_formadepagamento` int(11) NOT NULL,
  `venda_id_cliente` int(11) NOT NULL,
  `venda_datavenda` date NOT NULL,
  `venda_valortotal` double(9,2) NOT NULL,
  `venda_desconto` double(9,2) DEFAULT NULL,
  PRIMARY KEY (`venda_id`),
  KEY `fk_vendaformadepagamento` (`venda_id_formadepagamento`),
  KEY `fk_vendacliente` (`venda_id_cliente`),
  CONSTRAINT `fk_vendacliente` FOREIGN KEY (`venda_id_cliente`) REFERENCES `cliente` (`cliente_id`),
  CONSTRAINT `fk_vendaformadepagamento` FOREIGN KEY (`venda_id_formadepagamento`) REFERENCES `formapagamento` (`formpag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table dbsalao.venda: ~0 rows (approximately)
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
