package rave.code.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

import java.io.File;

@Mojo(name = "copy_prod")
public class CopyProdDatabase extends AbstractStockMarketMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        this.makeProductionDatabaseDump();
        this.dropDevelopmentDatabase();
        this.createDevelopmentDatabase();
        this.copyProductionDatabase();
    }

    private void makeProductionDatabaseDump() {
        try {
            ProcessBuilder pb = new ProcessBuilder("mysqldump", "-u", "admin", "stock_market");
            pb.environment().put("MYSQL_PWD", "admin");
            pb.redirectErrorStream(true); // combine stdout + stderr
            Process process = pb.start();

            try (var input = process.getInputStream();
                 var file = new java.io.FileOutputStream("stock_market.sql")) {
                input.transferTo(file);
            }

            int exitCode = process.waitFor();

            if (0 == exitCode) {
                getLog().info(String.format("Production database dump made with status code : %s", exitCode));
            } else {
                getLog().error(String.format("Problem while creating the production database dump: %s", exitCode));
            }
        } catch (Exception exception) {
            getLog().error(exception.getMessage(), exception);
        }
    }

    private void dropDevelopmentDatabase() {
        try {
            ProcessBuilder pb = new ProcessBuilder("mysql", "-u", "admin", "-e", "DROP DATABASE IF EXISTS stock_market_dev");
            pb.environment().put("MYSQL_PWD", "admin");
            pb.redirectErrorStream(true); // combine stdout + stderr
            Process process = pb.start();

            int exitCode = process.waitFor();

            if (0 == exitCode) {
                getLog().info(String.format("Development database stock_market_dev is dropped with status code : %s", exitCode));
            } else {
                getLog().error(String.format("Problem while dropping development database stock_market_dev : %s", exitCode));
            }

        } catch (Exception exception) {
            getLog().error(exception.getMessage(), exception);
        }
    }

    private void createDevelopmentDatabase() {
        try {
            ProcessBuilder pb = new ProcessBuilder("mysql", "-u", "admin", "-e", "CREATE DATABASE IF NOT EXISTS stock_market_dev");
            pb.environment().put("MYSQL_PWD", "admin");
            pb.redirectErrorStream(true); // combine stdout + stderr
            Process process = pb.start();

            int exitCode = process.waitFor();
            if (0 == exitCode) {
                getLog().info(String.format("Development database stock_market_dev created successfully : %s", exitCode));
            } else {
                getLog().error(String.format("Error while creating development database stock_market_dev : %s", exitCode));
            }
        } catch (Exception exception) {
            getLog().error(exception.getMessage(), exception);
        }
    }

    private void copyProductionDatabase() {
        try {
            ProcessBuilder pb = new ProcessBuilder("mysql", "-u", "admin", "-D", "stock_market_dev");
            pb.environment().put("MYSQL_PWD", "admin");
            File sqlFile = new File("stock_market.sql");

            pb.redirectInput(sqlFile);  // < file
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

            Process process = pb.start();
            int exitCode = process.waitFor();

            if (0 == exitCode) {
                getLog().info(String.format("Production database dumped on to development successfully : %s", exitCode));
            } else {
                getLog().error(String.format("Error while dumping the production database on to development : %s", exitCode));
            }

        } catch (Exception exception) {
            getLog().error(exception.getMessage(), exception);
        }
    }
}


