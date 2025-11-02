package rave.code.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "maketabs")
public class MakeTablesMojo extends AbstractStockMarketMojo{

    private String fileName = "create-tables.sql";

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        this.executeFile(this.fileName);
    }
}
