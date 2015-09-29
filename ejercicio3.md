#Ejercicio 3 - SSL en Tomcat

0.- Descargar Apache Tomcat 
http://ftp.cixug.es/apache/tomcat/tomcat-8/v8.0.21/bin/apache-tomcat-8.0.21.zip

1.- Descomentar la etiqueta XML mostrada abajo dentro del archivo $TOMCAT_HOME/conf/server.xml

```
<Connector 
           port="8443" maxThreads="200"
           scheme="https" secure="true" SSLEnabled="true"
           keystoreFile="${user.home}/.keystore" keystorePass="changeit"
           clientAuth="false" sslProtocol="TLS" keyAlias="changeit"/>
```

NOTA: Si omite el keystoreFile utilizará por defecto ${user.home}/.keystore. Puede cambiarlo a cualquiera de los que estamos utilizando ahora

2.- Configurar la variable de entorno JAVA_HOME. Debe apuntar a la carpeta donde está el JRE. Por ejemplo: C:\Program files\Java\jdk_7\

3.- Iniciar el tomcat. Debe ejecutar (doble-clic) el fichero: $TOMCAT_HOME/bin/startup.bat

4.- Probar (mirar certificado). Abrir con el navegador: https://localhost:8443
