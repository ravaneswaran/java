package rave.code.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractSubProcess implements SubProcess {

    private static final Logger LOGGER = Logger.getLogger(SubProcessor.class.getName());

    private ProcessBuilder processBuilder;
    private Process process;
    private long parentProcessId;
    private long exitCode;

    public AbstractSubProcess() {
        this.parentProcessId = ProcessHandle.current().pid();
    }

    public SubProcess setUp() {
        this.processBuilder = new ProcessBuilder(
                "java", this.getClass().getName(), "hello");
        // Ensure the child runs in the current directory (so it finds ChildProgram.class)
        File currentDir = new File("./utilities/sub-processor/target/classes/");
        this.processBuilder.directory(currentDir);
        // Redirect error stream into standard output
        this.processBuilder.redirectErrorStream(true);
        return this;
    }

    public SubProcess start() throws IOException {
        this.process = this.processBuilder.start();
        String logMessage = String.format("SUB-PROCESS[%s with PPID:%s, PID:%s] is started...", this.getClass().getName(), this.parentProcessId, process.pid());
        LOGGER.log(Level.INFO, logMessage);
        return this;
    }

    public abstract SubProcess action() throws IOException;

    public SubProcess exit() throws InterruptedException {
        if (null != this.process && this.process.isAlive()) {
            this.exitCode = this.process.waitFor();
            String logMessage = String.format("SUB-PROCESS[%s with PPID:%s, PID:%s] is exited with EXIT-CODE[%s]...", this.getClass().getName(), this.parentProcessId, process.pid(), exitCode);
            LOGGER.log(Level.INFO, logMessage);
        }
        return this;
    }

    public void logMessages() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                LOGGER.log(Level.WARNING, line);
            }
        }
    }

    public Process getProcess() {
        return this.process;
    }

}
