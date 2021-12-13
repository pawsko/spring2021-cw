package pl.javastart.di.crypto;

public interface CipherService {
    String encrypt(String text);
    String decrypt(String cipher);
}
