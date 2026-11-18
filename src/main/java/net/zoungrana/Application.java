package net.zoungrana;

import net.zoungrana.services.IMetier;
import net.zoungrana.services.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="net.zoungrana")
public class Application {
    public static void main(String[] args) {
        SecurityContext.authenticate("root","1234",new String[]{"USER"});
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Application.class);
        IMetier metier=applicationContext.getBean(IMetier.class);
        System.out.println(metier.getClass().getName());
        try{
            metier.process();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            System.out.println("Result: "+metier.compute());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
