#Ejercicio1

1.- Implementar una clase de prueba que cifre y descifre el archivo quijote.txt utilizando:
- AES (simétrico) - KeyGenerator
- RSA (asimétrico) - KeyPairGenerator

NOTA: Juegue un poco con las opciones de creación de claves

2.- Implementar una clase de prueba que cifre y descifre el archivo quijote.txt utilizando las clases CipherOutputStream (escribe cifrado) y CipherInputStream (lee cifrado).
NOTA: Debe utilizar como algoritmo Triple DES (consultar en Anexo A el nombre del algoritmo)

VER: http://docs.oracle.com/javase/6/docs/technotes/guides/security/crypto/CryptoSpec.html#CipherInput

3.- Implementar una clase de prueba que obtenga el hash (SHA1) del documento quijote.txt y lo muestre en pantalla en hexadecimal (compruebe con alguna herramienta en línea)
- http://onlinemd5.com/
- http://stackoverflow.com/questions/9655181/convert-from-byte-array-to-hex-string-in-java

4.- Implementar una clase de prueba que firme el documento quijote.txt y luego lo verifique
