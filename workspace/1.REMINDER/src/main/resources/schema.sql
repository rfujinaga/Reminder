CREATE TABLE service (id INT auto_increment,
	s_name CHAR(40) NOT NULL,
	r_date DATE NOT NULL,
	t_period DATE NOT NULL,	
	mailaddress CHAR(200),
	card_bra CHAR(40),
	card_num CHAR(16),
	s_id CHAR(40),
	password CHAR(40),
	other CHAR(400));
	
INSERT INTO service VALUES ('0',
	'DAZN',
	'2018-5-28',
	'2018-6-27',
	'test＠gmail.com',
	'VISAとか銀聯',
	'0000123456780000',
	'rfujinaga',
	'thisispassword',
	'追加でメモしておきたいことを入力');