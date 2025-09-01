package rave.code.process;

import java.io.IOException;
import java.util.logging.Logger;

public class TestSubProcess extends SubProcess{

    private static final Logger LOGGER = Logger.getLogger(TestSubProcess.class.getName());

    public TestSubProcess(String[] args) {
        super(args);
    }

    @Override
    public SubProcess action() throws IOException {
        this.logMessages();
        return this;
    }
}
