package basico;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class TestSignature {
	private static final String ALGORITMO_CIFRADO = "RSA"; 
	private static final String ALGORITMO_HASH = "SHA1"; 
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
		System.out.println("Firmando Hola mundo");
		String text = "Hola mundo";
		
		byte[] signatureText = firmar(text.getBytes());
		System.out.println("Firma = " + new String(signatureText));

		if (verficar(text.getBytes(), signatureText))
			System.out.println("El documento es válido");
		else
			System.out.println("El documento es inválido");
	}

	private boolean verficar(byte[] text, byte[] signatureText) throws Exception {
		signature.initVerify(publicKey);
		signature.update(text);
		return signature.verify(signatureText);
	}

	private byte[] firmar(byte[] sourceText) throws Exception {
		signature.initSign(privateKey);
		signature.update(sourceText);
		return signature.sign();
	}

}
