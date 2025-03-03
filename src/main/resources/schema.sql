CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY,
    user_id BIGINT,
    title VARCHAR(255),
    body VARCHAR(255)
);