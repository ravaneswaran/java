package rave.code.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "cleandb")
public class CleanDatabaseMojo extends AbstractStockMarketMojo{

    private String fileName = "clean-database.sql";

    public void execute() throws MojoExecutionException {
        this.executeFile(this.fileName);
    }
}