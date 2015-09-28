Curso de Criptografía y Seguridad en Java
=========================================

Agenda
------
- Introducción
- Criptografía en java
	- Introducción. Servicios criptográficos.
	- Proveedores . Clases motor (engine classes)
	- Claves criptográficas. Ecriptación.
	- Message digest. Firma digital
- Infraestructura PKI con java
	- Certificados y autoridades certificadoras. Certificados X.509
	- Listas de anulación de certificados (crls)
	- ¿Qué API de java se usa para acceder y gestionar certificados?
	- Key and certificate management tool (keytool)
- Control de acceso
- Security manager
- Ficheros de políticas de seguridad (policy files)
- Aplicaciones con java SSL
	- Panorámica de SSL
	- Extensión de socket seguro de java (JSSE)
	- Keystores
	- Truststores
- RMI sobre SSL

Enlaces
-------

- Introducción
	- Java SE Security
	http://www.oracle.com/technetwork/java/javase/tech/index-jsp-136007.html

- Criptografía
	- Java ™ Cryptography Architecture (JCA) Reference Guide
	http://docs.oracle.com/javase/6/docs/technotes/guides/security/crypto/CryptoSpec.html
	- Java ™ Cryptography Architecture Standard Algorithm Name Documentation
	http://docs.oracle.com/javase/6/docs/technotes/guides/security/StandardNames.html
	- Java AES and using my own Key
	http://stackoverflow.com/questions/3451670/java-aes-and-using-my-own-key
	- Should I use Cipher.WRAP_MODE OR Cipher.ENCRYPT_MODE to encrypt a session key?
	http://stackoverflow.com/questions/16586627/should-i-use-cipher-wrap-mode-or-cipher-encrypt-mode-to-encrypt-a-session-key

- Certificados y PKI
	- X.509 Certificates and Certificate Revocation Lists (CRLs)
	http://docs.oracle.com/javase/8/docs/technotes/guides/security/cert3.html
	- X.509
	http://es.wikipedia.org/wiki/X.509
	- DER vs. CRT vs. CER vs. PEM Certificates and How To Convert Them
	https://support.ssl.com/Knowledgebase/Article/View/19/0/der-vs-crt-vs-cer-vs-pem-certificates-and-how-to-convert-them
	https://www.sslshopper.com/ssl-converter.html
	- Keytool
	http://docs.oracle.com/javase/6/docs/technotes/tools/solaris/keytool.html
	-  Creating the Truststore and Keystore
	https://docs.continuent.com/tungsten-replicator-2.1/deployment-ssl-stores.html
	- Java PKI Programmer's Guide
	http://docs.oracle.com/javase/8/docs/technotes/guides/security/certpath/CertPathProgGuide.html
	- Retrieving a Key Pair from a Key Store
	http://www.java2s.com/Code/Java/Security/RetrievingaKeyPairfromaKeyStore.htm
	- RSA keypair generation and storing to keystore
	http://stackoverflow.com/questions/5263156/rsa-keypair-generation-and-storing-to-keystore
	
- Control de Acceso
	- Permissions and Security Policies
	http://docs.oracle.com/javase/8/docs/technotes/guides/security/spec/security-spec.doc3.html#a19802
	- Security Manager
	http://docs.oracle.com/javase/8/docs/technotes/guides/security/spec/security-spec.doc6.html#a19349
	http://www.javablogging.com/using-java-securitymanager-to-grantdeny-access-to-system-functions/
	- Access Control Mechanisms and Algorithms
	http://docs.oracle.com/javase/8/docs/technotes/guides/security/spec/security-spec.doc4.html#a20389
	http://stackoverflow.com/questions/8703234/accesscontroller-usage
	- New Security Mechanisms in Sun's Java 2
	http://www.securingjava.com/chapter-three/chapter-three-7.html
	- Signing and Verifying JAR Files
	https://docs.oracle.com/javase/tutorial/deployment/jar/signindex.html

- SSL y JRMIS
	- Infografía Handshake SSL
	http://upload.wikimedia.org/wikipedia/commons/e/e5/Ssl_handshake_with_two_way_authentication_with_certificates.png
	- Java Secure Socket Extension (JSSE) Reference Guide 
	http://docs.oracle.com/javase/8/docs/technotes/guides/security/jsse/JSSERefGuide.html
	- Autenticación SSL de dos vías
	http://publib.boulder.ibm.com/infocenter/tivihelp/v5r1/index.jsp?topic=%2Fcom.ibm.itim.infocenter.doc%2Fcpt%2Fcpt_ic_security_ssl_authent2way.html
	- JRMI
	http://docs.oracle.com/javase/tutorial/rmi/
	- Using the SSL/TLS-based RMI Socket Factories in J2SE 5.0 
	https://blogs.oracle.com/lmalventosa/entry/using_the_ssl_tls_based

Algoritmos
----------

- Generación de claves aleatorias: SHA1PRNG (basado en SHA-1)
- Generación de resúmenes: SHA-1, MD5
- Cifrado simétrico: AES, 3DES y DES (ya en desuso)
- Cifrado asimétrico: RSA, DSA, DiffieHellman. Longitudes de clave de 256, 521, 1024


Enlaces
-------

- Crypto JS
	- https://code.google.com/p/crypto-js/
- XDR y CORS
	- http://camposer-techie.blogspot.com.es/2011/08/cors-xdm-same-origin-policy-prototype-y.html
	- http://docs.sencha.com/extjs/4.0.7/#!/api/Ext.data.proxy.JsonP


