DROP TABLE IF EXISTS ACCOUNT CASCADE;
DROP TABLE IF EXISTS PERSON CASCADE;
DROP TABLE IF EXISTS POST CASCADE;
DROP TABLE IF EXISTS CATEGORY CASCADE;
DROP TABLE IF EXISTS TAG CASCADE;
DROP TABLE IF EXISTS POST_TAG CASCADE;

CREATE TABLE ACCOUNT (
                         id VARCHAR PRIMARY KEY,
                         password VARCHAR NOT NULL,
                         username VARCHAR,
                         enabled BOOLEAN DEFAULT TRUE,
                         last_password_modified_at TIMESTAMP,
                         created_at TIMESTAMP,
                         created_ip VARCHAR,
                         modified_at TIMESTAMP,
                         modified_ip VARCHAR
);

CREATE TABLE PERSON (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        account_id VARCHAR NOT NULL,
                        age BIGINT,
                        phone VARCHAR,
                        email VARCHAR,
                        created_at TIMESTAMP,
                        created_ip VARCHAR,
                        modified_at TIMESTAMP,
                        modified_ip VARCHAR
);

CREATE TABLE POST (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      category_id BIGINT NOT NULL,
                      title VARCHAR,
                      content VARCHAR,
                      enabled BOOLEAN DEFAULT TRUE,
                      view_count BIGINT,
                      created_at TIMESTAMP,
                      created_id VARCHAR,
                      created_ip VARCHAR,
                      modified_at TIMESTAMP,
                      modified_id VARCHAR,
                      modified_ip VARCHAR
);

CREATE TABLE CATEGORY (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          category_name VARCHAR,
                          parent_id BIGINT,
                          created_at TIMESTAMP,
                          created_ip VARCHAR,
                          modified_at TIMESTAMP,
                          modified_ip VARCHAR
);

CREATE TABLE TAG (
                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                     tag_name VARCHAR,
                     created_at TIMESTAMP,
                     created_ip VARCHAR,
                     modified_at TIMESTAMP,
                     modified_ip VARCHAR
);

CREATE TABLE POST_TAG (
                          post_id BIGINT NOT NULL,
                          tag_id BIGINT NOT NULL
);

CREATE TABLE ITEM (
                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                     item_name VARCHAR,
                     item_price BIGINT,
                     item_number VARCHAR,
                     enabled BOOLEAN DEFAULT TRUE,
                     created_at TIMESTAMP,
                     created_ip VARCHAR,
                     modified_at TIMESTAMP,
                     modified_ip VARCHAR
);
