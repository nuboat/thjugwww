CREATE SEQUENCE userid_seq;

CREATE TABLE account(
	userid bigint NOT NULL UNIQUE default nextval('userid_seq'),
	username VARCHAR(256) NOT NULL UNIQUE,
	email VARCHAR(128) NOT NULL,
	mobile VARCHAR(16) NOT NULL,
	level integer,
	CONSTRAINT account_userid_pk PRIMARY KEY (userid)
);
