package net.zoungrana;


import net.zoungrana.services.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="net.zoungrana")
public class Application {
    public static void main(String[] args) {
      ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Application.class);
        IMetier metier=applicationContext.getBean(IMetier.class);
        System.out.println(metier.getClass().getName());
        metier.process();
        System.out.println("Result: "+metier.compute());
    }
}
