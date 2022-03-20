package me.motemere.laforeapi;

import me.motemere.code.utils.Writer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaforeApiApplication {

  public static void main(String[] args) {
    Writer writer = new Writer() {
    };

    writer.writeLine(String.format("Hello, World from '%s' and special thx for Robert W. Lafore.",
        LaforeApiApplication.class));

    SpringApplication.run(LaforeApiApplication.class, args);
  }

}
