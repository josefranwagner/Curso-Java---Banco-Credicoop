# Curso-Java - Banco-Credicoop

**Objetivo:** Diseño de una plataforma de E-Commerce para la venta de productos de indumentaria semi-personalizados utilizando interfaz API Rest.

**Implementación:** Arquitectura de microservicios orquestados a través de un *API Gateway* y un servidor de nombres *Eureka Server*.

-----------------------------------------------------------

## Microservicios

- Producto base
- Producto personalizado
- Ventas

## Puertos utilizados

Gateway -> Puerto = 8765

Eureka Server -> Puerto = 8000

Producto Base -> Puerto = 8080 y Puerto = 8081

Producto Personalizado -> Puerto = 8090

Ventas -> Puerto = 8092

Conexión a la base de datos -> Puerto = 3306

## Endopints

### Producto base

http://localhost:8081/productobase/  -  Da de alta un producto base

http://localhost:8081/productobase/{idProdBase}  -  Retorna producto base según id

http://localhost:8081/productobase/{idProdBase}/existe  -  Devuelve valor de verdad de existencia de un producto base según id

http://localhost:8081/posiblepersonalizacion/{idPosiblePersonalizacion}  -  Devuelve valor de verdad de existencia de posible personalización según id

### Producto personalizado

http://localhost:8090/productopersonalizado/  -  Da de alta un producto personalizado

http://localhost:8090/productopersonalizado/{idProdPers}  -  Retorna producto personalizado según id

http://localhost:8090/productopersonalizado/{idProdPers}/existe  -  Devuelve valor de verdad de existencia de producto personalizado según id

### Ventas

http://localhost:8092/carrito  -  Da de alta un carrito de compra

http://localhost:8092/vendedor  -  Da de alta un vendedor

http://localhost:8092/crearpublicacion/{idTienda}  -  Da de alta una publicación en la tienda según id

http://localhost:8092/publicacion/{idPublicacion}/pausar  -  Cambia estado de Activa a Pausada para publicación según id

http://localhost:8092/carrito/{idCarrito}/{idPublicacion}  -  Adiciona publicación según id a carrito según id

http://localhost:8092/carrito/{idCarrito}/mediodepago/{idMedioPago}  -  Valida medio de pago correcto y confirma compra

http://localhost:8092/vendedor/compra/{idCompra}/generarfactura  -  Devuelve información relacionada a la compra según id
