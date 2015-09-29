package ejercicio1;

import java.security.MessageDigest;

import util.ArchivoUtil;
import util.StringUtil;

public class TestDigest {
	private static final String ALGORITMO = "SHA1";
	private static final String ARCHIVO_ORIGEN = "files/quijote.txt";
	private MessageDigest messageDigest;

	public TestDigest() throws Exception {
		this.messageDigest = MessageDigest.getInstance(ALGORITMO);
	}

	public static void main(String[] args) throws Exception {
		new TestDigest().iniciar();
	}

	private void iniciar() throws Exception {
		System.out.println("Hash de " + ARCHIVO_ORIGEN + " = " +
				hash(ARCHIVO_ORIGEN));
	}

	private String hash(String archivoOrigen) throws Exception {
		byte[] hash = messageDigest.digest(
				ArchivoUtil.leerArchivo(archivoOrigen));
		return StringUtil.getHex(hash);
	}

}