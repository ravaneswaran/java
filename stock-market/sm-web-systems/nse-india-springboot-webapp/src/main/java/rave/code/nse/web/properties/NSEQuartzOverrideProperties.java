package rave.code.nse.web.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class NSEQuartzOverrideProperties extends Properties {

    public NSEQuartzOverrideProperties() throws IOException {
        this.load(new FileInputStream("quartz-override.properties"));
    }
}
