INSERT INTO knowledge(k_name, category, predefined) VALUES ('Head First Java',
                                                            (SELECT category_id
                                                                FROM category
                                                                WHERE category_name = 'Books'),
                                                            false);

INSERT INTO knowledge(k_name, category, predefined) VALUES ('深入理解Java虚拟机',
                                                            (SELECT category_id
                                                             FROM category
                                                             WHERE category_name = 'Books'),
                                                            false);

INSERT INTO knowledge(k_name, category, predefined) VALUES ('DevOps：原理、方法与实践',
                                                            (SELECT category_id
                                                             FROM category
                                                             WHERE category_name = 'Books'),
                                                            false);

INSERT INTO knowledge(k_name, category, predefined) VALUES ('人月神话',
                                                            (SELECT category_id
                                                             FROM category
                                                             WHERE category_name = 'Books'),
                                                            false);

INSERT INTO knowledge(k_name, category, predefined) VALUES ('Peopleware',
                                                            (SELECT category_id
                                                             FROM category
                                                             WHERE category_name = 'Books'),
                                                            false);

