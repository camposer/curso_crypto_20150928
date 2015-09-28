package ejercicio1;

import java.security.Key;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import util.ArchivoUtil;
import util.StringUtil;

public class TestSK {
	private static final String ALGORITMO = "AES";
	private static final String ARCHIVO_ORIGEN = "files/quijote.txt";
	private static final String ARCHIVO_DESTINO_CIFRADO = "files/quijote.cifrado.txt";
	private static final String ARCHIVO_DESTINO_DESCIFRADO = "files/quijote.descifrado.txt";
	private Cipher cipher;
	private Key key;

	public TestSK() throws Exception {
		this.cipher = Cipher.getInstance(ALGORITMO);
		this.key = getKey();
		System.out.println("key = " + StringUtil.getBase64(this.key.getEncoded()));
	}

	private Key getKey() throws Exception {
		return KeyGenerator.getInstance(ALGORITMO).generateKey();
	}
	
	public static void main(String[] args) throws Exception {
		new TestSK().iniciar();
	}

	private void iniciar() throws Exception {
		Long inicio = new Date().getTime();
		
		System.out.println("Cifrando " + ARCHIVO_ORIGEN);
		cifrar(ARCHIVO_ORIGEN, ARCHIVO_DESTINO_CIFRADO);
		
		System.out.println("Descifrando " + ARCHIVO_DESTINO_CIFRADO);
		descifrar(ARCHIVO_DESTINO_CIFRADO, ARCHIVO_DESTINO_DESCIFRADO);

		Long fin = new Date().getTime();
		System.out.println("Duración (mseg) = " + (fin - inicio));
	}

	private void descifrar(String archivoOrigen, String archivoDestino) throws Exception {
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] text = cipher.doFinal(ArchivoUtil.leerArchivo(archivoOrigen));
		ArchivoUtil.escribirArchivo(text, archivoDestino);
	}

	private void cifrar(String archivoOrigen, String archivoDestino) throws Exception {
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] cipherText =  cipher.doFinal(ArchivoUtil.leerArchivo(archivoOrigen));
		ArchivoUtil.escribirArchivo(cipherText, archivoDestino);
	}
}
