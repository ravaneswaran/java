package rave.code.process;

import java.io.IOException;
import java.util.logging.Logger;

public class TestSubProcess extends AbstractSubProcess {

    private static final Logger LOGGER = Logger.getLogger(TestSubProcess.class.getName());

    public TestSubProcess() {
        super();
    }

    @Override
    public AbstractSubProcess action() throws IOException {
        this.logMessages();
        return this;
    }
}
