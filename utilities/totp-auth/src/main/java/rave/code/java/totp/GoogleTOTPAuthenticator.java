package rave.code.java.totp;

import rave.code.utilities.file.UserCredentialsFileReader;

import java.io.File;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GoogleTOTPAuthenticator extends TOTPAuthenticator {

    public static final Logger LOGGER = Logger.getLogger(GoogleTOTPAuthenticator.class.getName());

    public int getGoogleAuthenticatorTOTP() {
        UserCredentialsFileReader userCredentialsFileReader = new UserCredentialsFileReader();
        try {
            Map<String, String> keyValue = userCredentialsFileReader.read(new File("stock-market/.username-and-passwords"));
            String base32Secret = keyValue.get("google-auth-totp");
            return super.getTOTP(base32Secret);
        } catch (Exception exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
            return -1;
        }
    }

    public static void main(String[] args) {
        GoogleTOTPAuthenticator googleTOTPAuthenticator = new GoogleTOTPAuthenticator();
        int totp = googleTOTPAuthenticator.getGoogleAuthenticatorTOTP();
        System.out.println("-------------------->>>>>>> " + totp);
    }
}
