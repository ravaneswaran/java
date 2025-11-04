package rave.code.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "deltest")
public class DeleteTestDataMojo extends AbstractStockMarketMojo{

    private String fileName = "delete-test-data.sql";

    public void execute() throws MojoExecutionException {
        this.executeFile(this.fileName);
    }
}