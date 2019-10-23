/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : luokine_user

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-10-23 19:13:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识(0-未删除，1-已删除)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'luokine1', '$2a$10$c/LHq8imWUWgY7KCECf2hedfZqKc0Zg1X50vAWnNytC5Mr355LSAS', '0', '2019-10-23 11:53:57', '2019-10-23 11:53:57');
INSERT INTO `user_info` VALUES ('2', 'luokine2', '$2a$10$YTgTeqZ/PafqwTamt4h94udnSIdk7ght4HcD56o.o0S931.yAUOJ6', '0', '2019-10-23 11:53:57', '2019-10-23 11:53:57');
INSERT INTO `user_info` VALUES ('3', 'luokine3', '$2a$10$13CEAZTNCjglQV6cOyjZT.C13VK2NI9akOgE6/vbgfvIWvACyWPOu', '0', '2019-10-23 11:53:57', '2019-10-23 11:53:57');
INSERT INTO `user_info` VALUES ('4', 'luokine4', '$2a$10$HkNJf.u95DbhicMwKh7dN.u5HS7c1D0IShMSKeiWD0TNnoJT8/XBW', '0', '2019-10-23 11:53:58', '2019-10-23 11:53:58');
INSERT INTO `user_info` VALUES ('5', 'luokine5', '$2a$10$MT6wRTWWY8wHheYzDiYZOOpn4FVwMoX5YXji7vDS5uvB4EeHIYu6a', '0', '2019-10-23 11:53:58', '2019-10-23 11:53:58');
INSERT INTO `user_info` VALUES ('6', 'luokine6', '$2a$10$VLlgLCSagLApgvYtBU6VrOBEmKefy7mws.gwzuLGCg1Mjh/Bniane', '0', '2019-10-23 11:53:58', '2019-10-23 11:53:58');
INSERT INTO `user_info` VALUES ('7', 'luokine7', '$2a$10$2r/1U1Zl1HTjCfKaz7wjUuJ53RjpBtPtIIUsSr3vf2LoGP4CxfDc2', '0', '2019-10-23 11:53:58', '2019-10-23 11:53:58');
INSERT INTO `user_info` VALUES ('8', 'luokine8', '$2a$10$gZyqIvPVi6Kg7/WOcRub1eaJoRYOZOIteFm4hDjyKNBmUx1pbeLHW', '0', '2019-10-23 11:53:58', '2019-10-23 11:53:58');
INSERT INTO `user_info` VALUES ('9', 'luokine9', '$2a$10$/9HQFUNC6LPT51ZIO/hDROtTXv8LRC9XxKG2n3KFxfHQ8J8bPCulK', '0', '2019-10-23 11:53:58', '2019-10-23 11:53:58');
INSERT INTO `user_info` VALUES ('10', 'luokine10', '$2a$10$aO6p6KxX/TXtgJT1CQZ0heSXVf28UzOIrOvB1m8hKz4v13gKOkrKu', '0', '2019-10-23 11:53:58', '2019-10-23 11:53:58');
INSERT INTO `user_info` VALUES ('11', 'luokine11', '$2a$10$tlt7oXzch0wvZlFxyr.df.TOibtoMexIbmNJ1r0QsNkTBnWgdRcO.', '0', '2019-10-23 11:53:58', '2019-10-23 11:53:58');
INSERT INTO `user_info` VALUES ('12', 'luokine12', '$2a$10$8lj1FBaCfUnqtnErvPwDJO/dw.H3TzWs3g5gMzQwel1JRZr7PGSmi', '0', '2019-10-23 11:53:59', '2019-10-23 11:53:59');
INSERT INTO `user_info` VALUES ('13', 'luokine13', '$2a$10$.rLDmILTH6DBcbzr0/835uBWeE5gkdubhXE4hqnPquUnp6/K.kGJS', '0', '2019-10-23 11:53:59', '2019-10-23 11:53:59');
INSERT INTO `user_info` VALUES ('14', 'luokine14', '$2a$10$ebexaFJQPFpLYatkSGTcLuNCDZVteHPXK2VByvaCmQIm5B1m0CD4W', '0', '2019-10-23 11:53:59', '2019-10-23 11:53:59');
INSERT INTO `user_info` VALUES ('15', 'luokine15', '$2a$10$tjU9W80rC4fK8BKcc8Q.GuG46Fiynw5np500hFbajw2U1J6slR19.', '0', '2019-10-23 11:53:59', '2019-10-23 11:53:59');
INSERT INTO `user_info` VALUES ('16', 'luokine16', '$2a$10$8j48bvO01zvBFCo9kRlijuSXE3BdJ64ETTdJ2zy8Um414lq4raU6e', '0', '2019-10-23 11:53:59', '2019-10-23 11:53:59');
INSERT INTO `user_info` VALUES ('17', 'luokine17', '$2a$10$wkcmOPioG.kLyOsvj3E6iuyJyZQrm9Nm3CBR.zgzO7aiKrtV3PLam', '0', '2019-10-23 11:53:59', '2019-10-23 11:53:59');
INSERT INTO `user_info` VALUES ('18', 'luokine18', '$2a$10$BsWcgibXzcW0AhEqoSyG7e0p4vXazyZNNESTDI6C3FQZd5qFyzDQ6', '0', '2019-10-23 11:53:59', '2019-10-23 11:53:59');
INSERT INTO `user_info` VALUES ('19', 'luokine19', '$2a$10$FbjOTjRVVwnazzGK5cfTkuxlSQgjz3yLh1s2/.jBOIwOi2Z0kmXQ2', '0', '2019-10-23 11:53:59', '2019-10-23 11:53:59');
INSERT INTO `user_info` VALUES ('20', 'luokine20', '$2a$10$clIrXpwEnGintUNYIdpTxuCnzSqHF2v5RIengf641qwfJNy5cgYV6', '0', '2019-10-23 11:54:00', '2019-10-23 11:54:00');
INSERT INTO `user_info` VALUES ('21', 'luokine21', '$2a$10$Omdg.DCeTAnXpON9OO/Ki.UVbUeFBKuCpvtNpt1UgvZXpzl82iJZe', '0', '2019-10-23 11:54:00', '2019-10-23 11:54:00');
INSERT INTO `user_info` VALUES ('22', 'luokine22', '$2a$10$7yGz.Ibg4cmxIyMOSSOjy.Oa10ssdRJNFfNnezJKIUjSng4O83BhS', '0', '2019-10-23 11:54:00', '2019-10-23 11:54:00');
INSERT INTO `user_info` VALUES ('23', 'luokine23', '$2a$10$VTadiQWDy0TyLN5aX5vOyOsYwk1PrQmVUHwM2D9o7MD8a70A7.eIq', '0', '2019-10-23 11:54:00', '2019-10-23 11:54:00');
INSERT INTO `user_info` VALUES ('24', 'luokine24', '$2a$10$/9mNWPCwSzy0VVUkfiFUe.V3IvGGq/tUhnw0HLe2cJkchJx7.wjfG', '0', '2019-10-23 11:54:00', '2019-10-23 11:54:00');
INSERT INTO `user_info` VALUES ('25', 'luokine25', '$2a$10$feGG.Kza4S36R4CkhbqOm.oDDSBdUDcKkmItN//nF9XYYX2ym2YK2', '0', '2019-10-23 11:54:00', '2019-10-23 11:54:00');
