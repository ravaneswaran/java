package rave.code.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "delete")
public class MySQLTablesDeleteMojo extends QuartzMySQLMojo {

    private String fileName = "tables-delete.sql";

    public void execute() throws MojoExecutionException {
        this.executeFile(this.fileName);
    }
}
