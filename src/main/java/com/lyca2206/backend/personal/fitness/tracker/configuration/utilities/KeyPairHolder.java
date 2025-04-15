package com.lyca2206.backend.personal.fitness.tracker.configuration.utilities;

import io.jsonwebtoken.Jwts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class KeyPairHolder {
    private KeyPair keyPair;

    public KeyPairHolder(Path publicKeyPath, Path privateKeyPath) {
        try {
            readKeysThenInstanceAndAssignPair(
                    publicKeyPath,
                    privateKeyPath
            );
        } catch (IOException e) {
            generateThenSaveAndAssignPair(
                    publicKeyPath,
                    privateKeyPath
            );
        }
    }

    private void readKeysThenInstanceAndAssignPair(
            Path publicKeyPath,
            Path privateKeyPath
    ) throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();

        byte[] publicKeyBytes = decoder.decode(Files.readAllBytes(publicKeyPath));
        byte[] privateKeyBytes = decoder.decode(Files.readAllBytes(privateKeyPath));

        this.keyPair = createKeyPairInstance(
                publicKeyBytes,
                privateKeyBytes
        );
    }

    private KeyPair createKeyPairInstance(
            byte[] publicKeyBytes,
            byte[] privateKeyBytes
    ) {
        try {

            KeyFactory keyFactory = KeyFactory.getInstance("EC");

            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);

            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

            return new KeyPair(publicKey, privateKey);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void generateThenSaveAndAssignPair(
            Path publicKeyPath,
            Path privateKeyPath
    ) {
        try {

            Base64.Encoder encoder = Base64.getEncoder();
            KeyPair keyPair = Jwts.SIG.ES512.keyPair().build();

            Files.write(
                    publicKeyPath,
                    encoder.encode(keyPair.getPublic().getEncoded())
            );

            Files.write(
                    privateKeyPath,
                    encoder.encode(keyPair.getPrivate().getEncoded())
            );

            this.keyPair = keyPair;

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public PublicKey getPublic() {
        return keyPair.getPublic();
    }

    public PrivateKey getPrivate() {
        return keyPair.getPrivate();
    }
}