#Ejercicio2 - Keytool

##Configuración

1.- Buscar el fichero keytool dentro de $JAVA_HOME/bin
- Por ejemplo: C:\Program files\Java\jdk_1.7\jre\bin

2.- Agregar la ruta a la variable de entorno PATH
- Abrir las propiedades de Equipo
- Pedir variables de entorno
- Agregar a la variable existente PATH la ruta obtenida en el paso 1 después de ; (punto y coma)

Por ejemplo:
PATH=XXXXXXXX;C:\Program files\Java\jdk_1.7\jre\bin

3.- Abrir una nueva consola y ejecutar:
C:\> keytool

##Uso

1.- Para generar keystore: 
```
$ keytool -genkeypair -keystore keystore.jks
```

2.- Para generar petición de certificado 
```
$ keytool -certreq -file Cert1.csr -keystore keystore.jks
```

3.- Para importar un certificado al keystore 
```
$ keytool -importcert -keystore keystore.jks -alias twitter -file ~/twitter.com.pem
```

NOTA: Previamente debe exportar el certificado (Ej. Twitter) desde el navegador en formato PEM

4.- Para consultar el keystore 
```
$ keytool -list -keystore keystore.jks
```

5.- Generar un certificado auto-firmado (lo almacena dentro del keystore) 
```
$ keytool -genkey -alias mycert -keyalg RSA -keystore keystore.jks
```

5.- Extraer certificados (exportar) del keystore 
```
$ keytool -export -alias mycert -keystore keystore.jks -file mycert.cer
```

7.- Extraer certificados del keystore JKS e importar keystore PKCS12
```
$ keytool -importkeystore -srckeystore keystore.jks -destkeystore keystore.p12 -srcstoretype JKS -deststoretype PKCS12 
```

8.- Con base en el enlace "Retrieving a Key Pair from a Key Store" en el README, refactorice el código de Firma digital (Ejercicio 1.4) para que ahora utilice las claves privada y pública del almacén.

