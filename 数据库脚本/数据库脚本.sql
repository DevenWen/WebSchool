ALTER TABLE `jiakoufen_table`
ADD COLUMN `score`  double ZEROFILL NOT NULL DEFAULT 0 COMMENT '分数' AFTER `stuid`;

--为加扣分表添加分值