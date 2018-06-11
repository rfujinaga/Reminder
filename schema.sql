CREATE TABLE service (s_name CHAR(20) NOT NULL,
	r_date DATE NOT NULL,
	t_period DATE NOT NULL,	
	mailaddress CHAR(100),
	card_name CHAR(20),
	card_num CHAR(16),
	id CHAR(20),
	password CHAR(40),
	other CHAR(250));
	
INSERT INTO service VALUES ('DAZN',
	'2018-5-28',
	'2018-6-27',
	'test＠gmail.com',
	'VISAとか銀聯',
	'0000123456780000',
	'rfujinaga',
	'thisispassword',
	'追加でメモしておきたいことを入力');
