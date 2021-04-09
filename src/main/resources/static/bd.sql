CREATE DATABASE ventas;

USE ventas;

CREATE TABLE clientes(
    cedula VARCHAR(25) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    UNIQUE (email),
    PRIMARY KEY(cedula)
);

CREATE TABLE categorias(
    id INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(250) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE productos(
    codigo INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(250) NOT NULL,
    precio_unitario DOUBLE NOT NULL,
    stock INT NOT NULL,
    id_categoria INT NOT NULL,
    PRIMARY KEY(codigo),
    FOREIGN KEY (id_categoria) REFERENCES categorias(id)
);

CREATE TABLE pedidos(
    id INT AUTO_INCREMENT,
    id_cliente VARCHAR(25) NOT NULL,
    fecha DATETIME NOT NULL,
    -- iva DOUBLE NOT NULL,
    -- total DOUBLE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente) REFERENCES clientes(cedula)
);
-- items de la factura
CREATE TABLE productos_pedidos(
    id INT AUTO_INCREMENT,
    id_pedido INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id),
    FOREIGN KEY (id_producto) REFERENCES productos(codigo)
);

INSERT INTO clientes (cedula, nombre, apellido, direccion, email)   
VALUES ('10967153','Julio', 'Martinez', 'Calle 10', 'j@gmail.com');
-- categorias
INSERT INTO categorias(id, nombre,descripcion)
VALUES (1, 'ropa', 'para vestir');

INSERT INTO categorias(id, nombre,descripcion)
VALUES (2, 'accesorios', 'para lucir');
-- productos
INSERT INTO productos(codigo,nombre,descripcion,precio_unitario,stock,id_categoria)
VALUES (1, 'camisa', 'camisa x', 30000, 10, 1);

INSERT INTO productos(codigo,nombre,descripcion,precio_unitario,stock,id_categoria)
VALUES (2, 'pantalon', 'pantalon x', 20000, 10, 1);

INSERT INTO productos(codigo,nombre,descripcion,precio_unitario,stock,id_categoria)
VALUES (3, 'gorra', 'gorra x', 10000, 10, 1);

/*
-- json de prueba
{
    "cliente":{
        "cedula": "10967153"
    },
    "productoPedido":[
        {
            "cantidad": 2,
            "producto":{
                "codigo": 1
            }
        },
        {
            "cantidad": 3,
            "producto":{
                "codigo": 2
            }
        },
        {
            "cantidad": 1,
            "producto":{
                "codigo": 3
            }
        }
    ]
}
*/