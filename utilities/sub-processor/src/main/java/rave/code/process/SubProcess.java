package rave.code.process;

import java.io.IOException;

public interface SubProcess {

    public SubProcess setUp();

    public SubProcess start() throws IOException;

    public abstract SubProcess action() throws IOException;

    public SubProcess exit() throws InterruptedException;

    public void logMessages() throws IOException;

    public Process getProcess();
}
