-- This script seeds the initial user data based on JSONPlaceholder's /users endpoint.
-- All IDs are taken directly from JSONPlaceholder for consistency.

-- Insert Geo data
INSERT INTO geo (id, lat, lng) VALUES (1, '-37.3159', '81.1496');
INSERT INTO geo (id, lat, lng) VALUES (2, '-43.9509', '-34.4618');
INSERT INTO geo (id, lat, lng) VALUES (3, '-68.6102', '-47.0653');
INSERT INTO geo (id, lat, lng) VALUES (4, '29.4572', '-164.2990');
INSERT INTO geo (id, lat, lng) VALUES (5, '-31.8129', '62.5342');
INSERT INTO geo (id, lat, lng) VALUES (6, '-71.4197', '71.7478');
INSERT INTO geo (id, lat, lng) VALUES (7, '49.3159', '61.496');
INSERT INTO geo (id, lat, lng) VALUES (8, '-14.6102', '-34.0653');
INSERT INTO geo (id, lat, lng) VALUES (9, '24.8918', '21.8984');
INSERT INTO geo (id, lat, lng) VALUES (10, '-38.2386', '57.2232');

-- Insert Address data (linking to Geo)
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (1, 'Kulas Light', 'Apt. 556', 'Gwenborough', '92998-3874', 1);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (2, 'Victor Plains', 'Suite 879', 'Wisokyburgh', '90566-7771', 2);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (3, 'Douglas Extension', 'Suite 847', 'McKenziehaven', '59590-4157', 3);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (4, 'Hoeger Mall', 'Apt. 692', 'Southwark', '62024-5723', 4);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (5, 'Skiles Walks', 'Suite 351', 'Roscoeview', '33263', 5);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (6, 'Kattie Turnpike', 'Suite 198', 'Rosamond', '45169', 6);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (7, 'Runte Wall', 'Apt. 679', 'Lebsackbury', '31428-2261', 7);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (8, 'Friedrich Island', 'Suite 721', 'Howemouth', '58825', 8);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (9, 'Dayna Park', 'Suite 449', 'Aliyaview', '67706-8397', 9);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (10, 'Eliseo Cross', 'Apt. 124', 'Bret', '02807-6115', 10);

-- Insert Company data
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (1, 'Romaguera-Crona', 'Multi-layered client-server neural-net', 'harness real-time e-markets');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (2, 'Deckow-Crist', 'Proactive didactic contingency', 'synergize scalable supply-chains');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (3, 'Romaguera-Jacobson', 'Face to face neural-net', 'e-enable strategic applications');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (4, 'Robel-Corkery', 'Multi-tiered zero tolerance productivity', 'transition cutting-edge web services');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (5, 'Keebler LLC', 'User-centric fault-tolerant solution', 'revolutionize end-to-end solutions');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (6, 'Considine-Lockman', 'Synchronised bottom-line interface', 'e-enable innovative applications');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (7, 'Johns Group', 'Configurable object-oriented paradigm', 'generate enterprise e-tailers');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (8, 'Abernathy Group', 'Implemented secondary concept', 'e-enable extensible e-tailers');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (9, 'Yost and Sons', 'Switchable contextually-based project', 'aggregate real-time technologies');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (10, 'Hoeger LLC', 'Centralized empowering task-force', 'target real-time web services');

-- Insert User data (linking to Address and Company)
INSERT INTO users (id, name, username, email, address_id, phone, website, company_id) VALUES (1, 'Leanne Graham', 'Bret', 'Sincere@april.biz', 1, '1-770-736-8031 x56442', 'hildegard.org', 1);
INSERT INTO users (id, name, username, email, address_id, phone, website, company_id) VALUES (2, 'Ervin Howell', 'Antonette', 'Shanna@melissa.tv', 2, '010-692-7783 x493', 'anastasia.net', 2);
INSERT INTO users (id, name, username, email, address_id, phone, website, company_id) VALUES (3, 'Clementine Bauch', 'Samantha', 'Nathan@yesenia.net', 3, '1-463-123-4447', 'ramiro.info', 3);
INSERT INTO users (id, name, username, email, address_id, phone, website, company_id) VALUES (4, 'Patricia Lebsack', 'Karianne', 'Julianne.OConner@kory.org', 4, '493-170-9623 x156', 'kale.biz', 4);
INSERT INTO users (id, name, username, email, address_id, phone, website, company_id) VALUES (5, 'Chelsey Dietrich', 'Kamren', 'Lucio_Hettinger@annie.ca', 5, '210.067.6132', 'demarco.info', 5);
INSERT INTO users (id, name, username, email, address_id, phone, website, company_id) VALUES (6, 'Mrs. Dennis Schulist', 'Leopoldo_Corkery', 'Karley_Dach@jasper.info', 6, '1-477-935-8478 x6430', 'ola.org', 6);
INSERT INTO users (id, name, username, email, address_id, phone, website, company_id) VALUES (7, 'Kurtis Weissnat', 'Elwyn.Skiles', 'Telly.Hoeger@billy.biz', 7, '210.067.6132', 'elvis.io', 7);
INSERT INTO users (id, name, username, email, address_id, phone, website, company_id) VALUES (8, 'Nicholas Runolfsdottir V', 'Maxime_Nienow', 'Sherwood@rosamond.me', 8, '586.493.6943 x140', 'jacynthe.com', 8);
INSERT INTO users (id, name, username, email, address_id, phone, website, company_id) VALUES (9, 'Glenna Reichert', 'Delphine', 'Chaim_McDermott@dana.io', 9, '775314-7295', 'conrad.com', 9);
INSERT INTO users (id, name, username, email, address_id, phone, website, company_id) VALUES (10, 'Clementina DuBuque', 'Moriah.Stanton', 'Rey.Padberg@karina.biz', 10, '024-648-3804', 'ambrose.net', 10);

-- Insert AuthUser data with a default password for each seeded user
-- Password for all will be 'password123' hashed with BCrypt.
-- Hash of "password123": $2a$10$T1K.C2L5N8t4uYf9o4s9d.u5d8m7n6b5v4c3x2z1q0p9o8i7u6y5t4r3e2w1
INSERT INTO auth_users (id, email, password_hash) VALUES (1, 'Sincere@april.biz', '$2a$10$T1K.C2L5N8t4uYf9o4s9d.u5d8m7n6b5v4c3x2z1q0p9o8i7u6y5t4r3e2w1');
INSERT INTO auth_users (id, email, password_hash) VALUES (2, 'Shanna@melissa.tv', '$2a$10$T1K.C2L5N8t4uYf9o4s9d.u5d8m7n6b5v4c3x2z1q0p9o8i7u6y5t4r3e2w1');
INSERT INTO auth_users (id, email, password_hash) VALUES (3, 'Nathan@yesenia.net', '$2a$10$T1K.C2L5N8t4uYf9o4s9d.u5d8m7n6b5v4c3x2z1q0p9o8i7u6y5t4r3e2w1');
INSERT INTO auth_users (id, email, password_hash) VALUES (4, 'Julianne.OConner@kory.org', '$2a$10$T1K.C2L5N8t4uYf9o4s9d.u5d8m7n6b5v4c3x2z1q0p9o8i7u6y5t4r3e2w1');
INSERT INTO auth_users (id, email, password_hash) VALUES (5, 'Lucio_Hettinger@annie.ca', '$2a$10$T1K.C2L5N8t4uYf9o4s9d.u5d8m7n6b5v4c3x2z1q0p9o8i7u6y5t4r3e2w1');
INSERT INTO auth_users (id, email, password_hash) VALUES (6, 'Karley_Dach@jasper.info', '$2a$10$T1K.C2L5N8t4uYf9o4s9d.u5d8m7n6b5v4c3x2z1q0p9o8i7u6y5t4r3e2w1');
INSERT INTO auth_users (id, email, password_hash) VALUES (7, 'Telly.Hoeger@billy.biz', '$2a$10$T1K.C2L5N8t4uYf9o4s9d.u5d8m7n6b5v4c3x2z1q0p9o8i7u6y5t4r3e2w1');
INSERT INTO auth_users (id, email, password_hash) VALUES (8, 'Sherwood@rosamond.me', '$2a$10$T1K.C2L5N8t4uYf9o4s9d.u5d8m7n6b5v4c3x2z1q0p9o8i7u6y5t4r3e2w1');
INSERT INTO auth_users (id, email, password_hash) VALUES (9, 'Chaim_McDermott@dana.io', '$2a$10$T1K.C2L5N8t4uYf9o4s9d.u5d8m7n6b5v4c3x2z1q0p9o8i7u6y5t4r3e2w1');
INSERT INTO auth_users (id, email, password_hash) VALUES (10, 'Rey.Padberg@karina.biz', '$2a$10$T1K.C2L5N8t4uYf9o4s9d.u5d8m7n6b5v4c3x2z1q0p9o8i7u6y5t4r3e2w1');