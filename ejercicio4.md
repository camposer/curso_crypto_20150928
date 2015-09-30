Ejercicio 2
===========

1.- Implementar un objeto remoto que ofrezca las operaciones CRUD+ sobre la entidad Persona

2.- Implementar un cliente que permita utilizar las operaciones CRUD+ sobre la entidad Persona a través de JRMI.

Por ejemplo:
```
Gestión de personas
1. Agregar
2. Obtener todos
? 1

Nombre? Juan
Apellido? Pérez
Edad? 30
		
Gestión de personas
1. Agregar
2. Obtener todos
? 2

[ Nombre = Juan, Apellido = Pérez, Edad = 30 ]
```

3.- Seguir el HOWTO COMO_CONF_SSL.txt (primera parte) y observar el funcionamiento de la aplicación utilizando SSL de 1 vía (1w).

IMPORTANTE: Antes de hacer funcionar esto debe configurar el SecureSocketFactory como se muestra en: https://blogs.oracle.com/lmalventosa/entry/using_the_ssl_tls_based

4.- Seguir el HOWTO COMO_CONF_SSL.txt (segunda parte) y observar el funcionamiento de la aplicación utilizando SSL de 2 vías (2w).
