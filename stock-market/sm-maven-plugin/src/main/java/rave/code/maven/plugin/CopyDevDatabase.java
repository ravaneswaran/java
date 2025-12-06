package rave.code.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

import java.io.File;

@Mojo(name = "copy_dev")
public class CopyDevDatabase extends AbstractStockMarketMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        this.makeDevelopmentDatabaseDump();
        this.dropProductionDatabase();
        this.createProductionDatabase();
        this.copyDevelopmentDatabase();
    }

    private void makeDevelopmentDatabaseDump() {
        try {
            ProcessBuilder pb = new ProcessBuilder("mysqldump", "-u", "admin", "stock_market_dev");
            pb.environment().put("MYSQL_PWD", "admin");
            pb.redirectErrorStream(true); // combine stdout + stderr
            Process process = pb.start();

            try (var input = process.getInputStream();
                 var file = new java.io.FileOutputStream("stock_market_dev.sql")) {
                input.transferTo(file);
            }

            int exitCode = process.waitFor();

            if (0 == exitCode) {
                getLog().info(String.format("Development database dump made with status code : %s", exitCode));
            } else {
                getLog().error(String.format("Problem while creating the development database dump: %s", exitCode));
            }
        } catch (Exception exception) {
            getLog().error(exception.getMessage(), exception);
        }
    }

    private void dropProductionDatabase() {
        try {
            ProcessBuilder pb = new ProcessBuilder("mysql", "-u", "admin", "-e", "DROP DATABASE IF EXISTS stock_market");
            pb.environment().put("MYSQL_PWD", "admin");
            pb.redirectErrorStream(true); // combine stdout + stderr
            Process process = pb.start();

            int exitCode = process.waitFor();

            if (0 == exitCode) {
                getLog().info(String.format("Production database stock_market is dropped with status code : %s", exitCode));
            } else {
                getLog().error(String.format("Problem while dropping production database stock_market : %s", exitCode));
            }

        } catch (Exception exception) {
            getLog().error(exception.getMessage(), exception);
        }
    }

    private void createProductionDatabase() {
        try {
            ProcessBuilder pb = new ProcessBuilder("mysql", "-u", "admin", "-e", "CREATE DATABASE IF NOT EXISTS stock_market");
            pb.environment().put("MYSQL_PWD", "admin");
            pb.redirectErrorStream(true); // combine stdout + stderr
            Process process = pb.start();

            int exitCode = process.waitFor();
            if (0 == exitCode) {
                getLog().info(String.format("Production database stock_market created successfully : %s", exitCode));
            } else {
                getLog().error(String.format("Error while creating production database stock_market:  %s", exitCode));
            }
        } catch (Exception exception) {
            getLog().error(exception.getMessage(), exception);
        }
    }

    private void copyDevelopmentDatabase() {
        try {
            ProcessBuilder pb = new ProcessBuilder("mysql", "-u", "admin", "-D", "stock_market");
            pb.environment().put("MYSQL_PWD", "admin");
            File sqlFile = new File("stock_market_dev.sql");

            pb.redirectInput(sqlFile);  // < file
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

            Process process = pb.start();
            int exitCode = process.waitFor();

            if (0 == exitCode) {
                getLog().info(String.format("Development database dumped on to production successfully : %s", exitCode));
            } else {
                getLog().error(String.format("Error while dumping the development database onto production: %s", exitCode));
            }

        } catch (Exception exception) {
            getLog().error(exception.getMessage(), exception);
        }
    }
}

