CREATE TABLE sucursal
(
    id UUID PRIMARY KEY,

    empresa_id UUID NOT NULL,

    codigo VARCHAR(20) NOT NULL,

    nombre VARCHAR(150) NOT NULL,

    direccion VARCHAR(255),

    comuna VARCHAR(100),

    telefono VARCHAR(30),

    email VARCHAR(150),

    activo BOOLEAN NOT NULL DEFAULT TRUE,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP,

    CONSTRAINT fk_sucursal_empresa
        FOREIGN KEY (empresa_id)
            REFERENCES empresa (id),

    CONSTRAINT uk_sucursal_empresa_codigo
        UNIQUE (empresa_id, codigo)
);

CREATE INDEX idx_sucursal_empresa
    ON sucursal (empresa_id);

CREATE INDEX idx_sucursal_nombre
    ON sucursal (nombre);

CREATE INDEX idx_sucursal_codigo
    ON sucursal (codigo);