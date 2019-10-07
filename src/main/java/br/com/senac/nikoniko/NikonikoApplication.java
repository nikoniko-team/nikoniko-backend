package br.com.senac.nikoniko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NikonikoApplication {

    public static void main(String[] args) {
        showAppVersionInfo();
        SpringApplication.run(NikonikoApplication.class, args);
    }


    private static void showAppVersionInfo() {
        Logger logger = LoggerFactory.getLogger(NikonikoApplication.class);
        logger.info("");
        logger.info("########################################################################################");
        logger.info("## |  java.version  |   " + System.getProperty("java.version"));
        logger.info("## |  java.home     |   " + System.getProperty("java.home"));
        logger.info("## |  java.vendor   |   " + System.getProperty("java.vendor"));
        logger.info("## |  os.arch       |   " + System.getProperty("os.arch"));
        logger.info("## |  os.name       |   " + System.getProperty("os.name"));
        logger.info("## |  os.version    |   " + System.getProperty("os.version"));
        logger.info("## |  spring-boot   |   " + SpringBootApplication.class.getPackage().getImplementationVersion());
        logger.info("########################################################################################");
        logger.info("");
    }

}
