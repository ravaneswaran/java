package rave.code.java.totp;

import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;
import org.apache.commons.codec.binary.Base32;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;

public class TOTPAuthenticator {

    public int getTOTP(String base32Secret) throws Exception {
        // Decode Base32
        Base32 base32 = new Base32();
        byte[] decodedKey = base32.decode(base32Secret);

        SecretKey secretKey =
                new SecretKeySpec(decodedKey, "HmacSHA1");

        // Google Authenticator uses:
        //  - 30 second time step
        //  - 6 digits
        TimeBasedOneTimePasswordGenerator totp = new TimeBasedOneTimePasswordGenerator();
        Instant now = Instant.now();

        return totp.generateOneTimePassword(secretKey, now);
    }
}
