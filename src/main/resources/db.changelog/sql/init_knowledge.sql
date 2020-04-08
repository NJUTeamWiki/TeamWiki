INSERT INTO category(category_name, predefined) VALUE ('First Day', true);
INSERT INTO category(category_name, predefined) VALUE ('Workflow', true);
INSERT INTO category(category_name, predefined) VALUE ('Websites', true);
INSERT INTO category(category_name, predefined) VALUE ('Books', true);


INSERT INTO knowledge(k_name, category, predefined) VALUE ('Company Introduction',
                                                              (SELECT category_id
                                                               FROM category
                                                               WHERE category_name = 'First Day'),
                                                              true);
INSERT INTO knowledge(k_name, category, predefined) VALUE ('Team Introduction',
                                                              (SELECT category_id
                                                               FROM category
                                                               WHERE category_name = 'First Day'),
                                                              true);
INSERT INTO knowledge(k_name, category, predefined) VALUE ('Projects Introduction',
                                                              (SELECT category_id
                                                               FROM category
                                                               WHERE category_name = 'First Day'),
                                                              true);
INSERT INTO knowledge(k_name, category, predefined) VALUE ('Office Environment & Facilities',
                                                              (SELECT category_id
                                                               FROM category
                                                               WHERE category_name = 'First Day'),
                                                              true);
INSERT INTO knowledge(k_name, category, predefined) VALUE ('Development Environment Setup',
                                                              (SELECT category_id
                                                               FROM category
                                                               WHERE category_name = 'First Day'),
                                                              true);
INSERT INTO knowledge(k_name, category, predefined) VALUE ('Accounts',
                                                              (SELECT category_id
                                                               FROM category
                                                               WHERE category_name = 'First Day'),
                                                              true);
INSERT INTO knowledge(k_name, category, predefined) VALUE ('Permissions',
                                                              (SELECT category_id
                                                               FROM category
                                                               WHERE category_name = 'First Day'),
                                                              true);


INSERT INTO knowledge(k_name, category, predefined) VALUE ('Workflow Overview',
                                                              (SELECT category_id
                                                               FROM category
                                                               WHERE category_name = 'Workflow'),
                                                             true);

INSERT INTO knowledge(k_name, category, predefined) VALUE ('Source Code Management',
                                                              (SELECT category_id
                                                               FROM category
                                                               WHERE category_name = 'Workflow'),
                                                              true);

INSERT INTO knowledge(k_name, category, predefined) VALUE ('Programming Guidelines',
                                                              (SELECT category_id
                                                               FROM category
                                                               WHERE category_name = 'Workflow'),
                                                              true);

INSERT INTO knowledge(k_name, category, predefined) VALUE ('Testing Guidelines',
                                                              (SELECT category_id
                                                               FROM category
                                                               WHERE category_name = 'Workflow'),
                                                              true);

INSERT INTO knowledge(k_name, category, predefined) VALUE ('CI Guidelines',
                                                              (SELECT category_id
                                                               FROM category
                                                               WHERE category_name = 'Workflow'),
                                                              true);

INSERT INTO knowledge(k_name, category, predefined) VALUE ('CD Guidelines',
                                                              (SELECT category_id
                                                               FROM category
                                                               WHERE category_name = 'Workflow'),
                                                              true);


