package rave.code.quartz.jobs;

import org.quartz.Job;
import rave.code.process.AbstractSubProcess;
import rave.code.process.SubProcess;

import java.io.IOException;

public abstract class AbstractQuartzJob extends AbstractSubProcess implements Job {

    @Override
    public SubProcess action() throws IOException {
        return null;
    }
}
