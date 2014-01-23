package com.thoughtworks.league_manager.main;

import com.thoughtworks.league_manager.ProductionConfig;
import com.thoughtworks.league_manager.menu.Menu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context =
           new AnnotationConfigApplicationContext(ProductionConfig.class);

        Menu menu = context.getBean(Menu.class);
        menu.chooseOption();
        while (!menu.userDone()){
            menu.executeCurrentCommand();
            menu.chooseOption();
        }
    }
}
