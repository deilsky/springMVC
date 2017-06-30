/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : spell

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-06-30 11:26:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_manager`;
CREATE TABLE `t_manager` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `passWord` varchar(32) NOT NULL,
  `sex` int(1) NOT NULL,
  `realName` varchar(10) NOT NULL,
  `idCard` varchar(255) NOT NULL,
  `mobile` varchar(255) NOT NULL,
  `encryption` varchar(8) NOT NULL,
  `birth` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_manager
-- ----------------------------
INSERT INTO `t_manager` VALUES ('1', 'admin', 'SC88C6626A021096F76302153F006C78', '1', '帷幕', '111111111111111111', '11111111111111', 'admin', '1989-02-21');

-- ----------------------------
-- Table structure for t_shopper
-- ----------------------------
DROP TABLE IF EXISTS `t_shopper`;
CREATE TABLE `t_shopper` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `passWord` varchar(32) NOT NULL,
  `sex` int(1) NOT NULL,
  `realName` varchar(10) NOT NULL,
  `idCard` varchar(255) NOT NULL,
  `mobile` varchar(255) NOT NULL,
  `encryption` varchar(8) NOT NULL,
  `birth` date NOT NULL,
  `type` int(1) NOT NULL,
  `regTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shopper
-- ----------------------------
INSERT INTO `t_shopper` VALUES ('1', 'test1001', 'e10adc3949ba59abbe56e057f20f883', '1', '商户101', '123456789987654321', '12345678901', '123456', '2017-06-22', '1', '2017-06-05 11:33:17');
INSERT INTO `t_shopper` VALUES ('2', 'test1002', 'e10adc3949ba59abbe56e057f20f883', '1', '商户102', '123456789987654321', '12345678902', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('3', 'test1003', 'e10adc3949ba59abbe56e057f20f883', '1', '商户103', '123456789987654321', '12345678903', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('4', 'test1004', 'e10adc3949ba59abbe56e057f20f883', '1', '商户104', '123456789987654321', '12345678904', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('5', 'test1005', 'e10adc3949ba59abbe56e057f20f883', '1', '商户105', '123456789987654321', '12345678905', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('6', 'test1006', 'e10adc3949ba59abbe56e057f20f883', '1', '商户106', '123456789987654321', '12345678906', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('7', 'test1007', 'e10adc3949ba59abbe56e057f20f883', '1', '商户107', '123456789987654321', '12345678907', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('8', 'test1008', 'e10adc3949ba59abbe56e057f20f883', '1', '商户108', '123456789987654321', '12345678908', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('9', 'test1009', 'e10adc3949ba59abbe56e057f20f883', '1', '商户109', '123456789987654321', '12345678909', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('10', 'test1010', 'e10adc3949ba59abbe56e057f20f883', '1', '商户110', '123456789987654321', '12345678910', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('11', 'test1011', 'e10adc3949ba59abbe56e057f20f883', '1', '商户111', '123456789987654321', '12345678911', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('12', 'test1012', 'e10adc3949ba59abbe56e057f20f883', '1', '商户112', '123456789987654321', '12345678912', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('13', 'test1013', 'e10adc3949ba59abbe56e057f20f883', '1', '商户113', '123456789987654321', '12345678913', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('14', 'test1014', 'e10adc3949ba59abbe56e057f20f883', '1', '商户114', '123456789987654321', '12345678914', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('15', 'test1015', 'e10adc3949ba59abbe56e057f20f883', '1', '商户115', '123456789987654321', '12345678915', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('16', 'test1016', 'e10adc3949ba59abbe56e057f20f883', '1', '商户116', '123456789987654321', '12345678916', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('17', 'test1017', 'e10adc3949ba59abbe56e057f20f883', '1', '商户117', '123456789987654321', '12345678917', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('18', 'test1018', 'e10adc3949ba59abbe56e057f20f883', '1', '商户118', '123456789987654321', '12345678918', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('19', 'test1019', 'e10adc3949ba59abbe56e057f20f883', '1', '商户119', '123456789987654321', '12345678919', '123456', '2017-06-22', '1', '2017-06-22 11:33:17');
INSERT INTO `t_shopper` VALUES ('20', 'test1020', 'e10adc3949ba59abbe56e057f20f883', '1', '商户120', '123456789987654321', '12345678920', '123456', '2017-06-22', '1', '2017-06-23 11:33:17');