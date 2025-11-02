package rave.code.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Mojo(name = "exportdb")
public class ExportDatabaseMojo extends AbstractStockMarketMojo {

    @Parameter(defaultValue = "${project.build.directory}", readonly = true, required = true)
    private File outputDirectory;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            List<String> command = Arrays.asList("mysqldump", "-u", this.username, String.format("-p%s", this.password), "stock_market");
            ProcessBuilder pb = new ProcessBuilder(command);
            // Option 1: redirect output to file
            pb.redirectOutput(new File(this.outputDirectory.getAbsolutePath(), "exported_stock_market_db.sql"));
            // Optionally merge stderr with stdout
            pb.redirectErrorStream(true);
            Process process = pb.start();
            int exitCode = process.waitFor();
            getLog().info("Database export exited with code: " + exitCode);
        } catch (Exception exception) {
            getLog().error(exception.getMessage(), exception);
        }
    }
}
