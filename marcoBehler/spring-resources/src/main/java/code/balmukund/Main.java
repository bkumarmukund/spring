package code.balmukund;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

/**
 * spring girves us the ability to access resources via a nice little syntax
 * also the resource interface has s couple of interesting methods
 * - getInputStream()
 * - isOpen()
 * - exists()
 * - getDescription()
 * - getFile()
 * - getFileName()
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("spring-resources-demo");

        ApplicationContext ctx = new AnnotationConfigApplicationContext();

        // Resource aClassPathTemplate = ctx.getResource("classpath:res/resourceTypeClasspath.txt");
        Resource aClassPathTemplate = ctx.getResource("classpath:code/balmukund/res/resourceTypeClasspath.txtu");
        
        readAndPrintResource(aClassPathTemplate);
    }

    private static void readAndPrintResource(Resource resource) {
        System.out.println("we are reading: "+resource.getFilename());
        if(resource.exists()) {
            try (
                InputStream inputStream = resource.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            ) {
                String line;
                while ((line = bufferedReader.readLine())!= null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                System.out.println(String.format("error in reading {} ", resource.getFilename()));
            }
        } else {
            System.out.println("resource not available");
        }
    }
}