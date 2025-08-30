DROP TABLE IF EXISTS users, requests, items, bookings, comments;

CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
    email VARCHAR(512) NOT NULL,
    CONSTRAINT UQ_USER_EMAIL UNIQUE (email)
    );

CREATE TABLE IF NOT EXISTS items (
                                     id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    available BOOLEAN,
    owner_id BIGINT,
    CONSTRAINT fk_items_to_users FOREIGN KEY (owner_id) REFERENCES users(id),
    CONSTRAINT UQ_ITEM_NAME UNIQUE (name)
    );

CREATE TABLE IF NOT EXISTS bookings (
                                        id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                        start_time TIMESTAMP NOT NULL,
                                        end_time TIMESTAMP NOT NULL,
                                        item_id BIGINT,
                                        booker_id BIGINT,
                                        status VARCHAR(50),
    CONSTRAINT fk_bookings_to_users FOREIGN KEY (booker_id) REFERENCES users(id),
    CONSTRAINT fk_bookings_to_items FOREIGN KEY (item_id) REFERENCES items(id)
    );

CREATE TABLE IF NOT EXISTS comments (
                                        id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                        text VARCHAR NOT NULL,
                                        item_id BIGINT REFERENCES items(id),
    author_id BIGINT REFERENCES users(id) ON DELETE CASCADE NOT NULL,
    created_date TIMESTAMP WITHOUT TIME ZONE
    );

CREATE TABLE IF NOT EXISTS requests (
                                        id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                        description VARCHAR NOT NULL,
                                        requester_id BIGINT REFERENCES users(id),
    created TIMESTAMP WITHOUT TIME ZONE NOT NULL
    );