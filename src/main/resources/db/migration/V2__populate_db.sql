INSERT INTO client (name) VALUES
                              ('Alex'),
                              ('Ivan'),
                              ('Maria'),
                              ('Olga'),
                              ('Dmytro'),
                              ('Anna'),
                              ('John'),
                              ('Kate'),
                              ('Pavel'),
                              ('Sofia');

INSERT INTO planet (id, name) VALUES
                                  ('EARTH', 'Земля'),
                                  ('MARS', 'Марс'),
                                  ('VENUS', 'Венера'),
                                  ('JUPITER', 'Юпітер'),
                                  ('SATURN', 'Сатурн');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
                                                                             (CURRENT_TIMESTAMP, 1, 'EARTH', 'MARS'),
                                                                             (CURRENT_TIMESTAMP, 2, 'MARS', 'VENUS'),
                                                                             (CURRENT_TIMESTAMP, 3, 'VENUS', 'EARTH'),
                                                                             (CURRENT_TIMESTAMP, 4, 'EARTH', 'JUPITER'),
                                                                             (CURRENT_TIMESTAMP, 5, 'SATURN', 'EARTH'),
                                                                             (CURRENT_TIMESTAMP, 6, 'MARS', 'SATURN'),
                                                                             (CURRENT_TIMESTAMP, 7, 'VENUS', 'JUPITER'),
                                                                             (CURRENT_TIMESTAMP, 8, 'JUPITER', 'EARTH'),
                                                                             (CURRENT_TIMESTAMP, 9, 'EARTH', 'VENUS'),
                                                                             (CURRENT_TIMESTAMP, 10, 'SATURN', 'MARS');