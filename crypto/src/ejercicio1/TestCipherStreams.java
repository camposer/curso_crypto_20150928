package ejercicio1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;

import util.ArchivoUtil;
import util.StringUtil;

public class TestCipherStreams {
	private static final String ALGORITMO = "DESede"; // Triple DES
	private static final String ARCHIVO_ORIGEN = "files/quijote.txt";
	private static final String ARCHIVO_DESTINO_CIFRADO = "files/quijote.cifrado.txt";
	private static final String ARCHIVO_DESTINO_DESCIFRADO = "files/quijote.descifrado.txt";
	private Cipher cipher;
	private Key key;

	public TestCipherStreams() throws Exception {
		this.cipher = Cipher.getInstance(ALGORITMO);
		this.key = getKey();
		System.out.println("key = " + StringUtil.getBase64(this.key.getEncoded()));
	}

	private Key getKey() throws Exception {
		return KeyGenerator.getInstance(ALGORITMO).generateKey();
	}
	
	public static void main(String[] args) throws Exception {
		new TestCipherStreams().iniciar();
	}

	private void iniciar() throws Exception {
		Long inicio = new Date().getTime();
		
		System.out.println("Cifrando " + ARCHIVO_ORIGEN);
		cifrar(ARCHIVO_ORIGEN, ARCHIVO_DESTINO_CIFRADO);
		
//		System.out.println("Descifrando " + ARCHIVO_DESTINO_CIFRADO);
//		descifrar(ARCHIVO_DESTINO_CIFRADO, ARCHIVO_DESTINO_DESCIFRADO);

		Long fin = new Date().getTime();
		System.out.println("Duración (mseg) = " + (fin - inicio));
	}

	private void cifrar1(String archivoOrigen, String archivoDestino) throws Exception {
		cipher.init(Cipher.DECRYPT_MODE, key);
		
		try (
			FileInputStream fis = new FileInputStream(archivoOrigen);
			FileOutputStream fos = new FileOutputStream(archivoDestino);
			CipherOutputStream cos = new CipherOutputStream(fos, cipher);
		) {
			byte b = (byte) fis.read();
			while (b != -1) {
				cos.write(b);
			}
		}
	}

	private void cifrar(String archivoOrigen, String archivoDestino) throws Exception {
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		FileInputStream fis = new FileInputStream(archivoOrigen);
		CipherInputStream cis = new CipherInputStream(fis, cipher);
		
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = 
				new BufferedReader(new InputStreamReader(cis))) {
			
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				
				line = br.readLine();
				sb.append(line);
			}
		}
		
		ArchivoUtil.escribirArchivo(sb.toString().getBytes(), 
				archivoDestino);
	
	}
}
