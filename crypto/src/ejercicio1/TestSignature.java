package ejercicio1;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

import util.ArchivoUtil;

public class TestSignature {
	private static final String ALGORITMO_CIFRADO = "RSA"; 
	private static final String ALGORITMO_HASH = "SHA1";
	private static final String ARCHIVO_ORIGEN = "files/quijote.txt";
	private static final String ARCHIVO_FIRMA = "files/quijote.sig.txt"; 
	private Signature signature;
	private PublicKey publicKey;
	private PrivateKey privateKey;

	public TestSignature() throws Exception {
		this.signature = Signature.getInstance(ALGORITMO_HASH + "with" + 
				ALGORITMO_CIFRADO);
		generateKeys();
	}

	private void generateKeys() throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITMO_CIFRADO);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		this.publicKey = keyPair.getPublic();
		this.privateKey = keyPair.getPrivate();
	}
	
	public static void main(String[] args) throws Exception {
		new TestSignature().iniciar();
	}

	private void iniciar() throws Exception {
		firmar(ARCHIVO_ORIGEN, ARCHIVO_FIRMA);
		
		if (verficar(ARCHIVO_ORIGEN, ARCHIVO_FIRMA))
			System.out.println("El documento es válido");
		else
			System.out.println("El documento es inválido");
	}

	private boolean verficar(String archivoOrigen, String archivoFirma) throws Exception {
		byte[] signatureText = ArchivoUtil.leerArchivo(archivoFirma);
		
		signature.initVerify(publicKey);
		signature.update(ArchivoUtil.leerArchivo(archivoOrigen));
		return signature.verify(signatureText);
	}

	private void firmar(String archivoOrigen, String archivoFirma) throws Exception {
		signature.initSign(privateKey);
		signature.update(ArchivoUtil.leerArchivo(archivoOrigen));
		byte[] signatureText = signature.sign();
		ArchivoUtil.escribirArchivo(signatureText, archivoFirma);
	}

}
