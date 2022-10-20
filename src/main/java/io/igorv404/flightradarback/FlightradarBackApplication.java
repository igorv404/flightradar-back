package io.igorv404.flightradarback;

import io.igorv404.flightradarback.view.View;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightradarBackApplication implements CommandLineRunner {

  private final View view;

  public FlightradarBackApplication(View view) {
    this.view = view;
  }

  public static void main(String[] args) {
    SpringApplication.run(FlightradarBackApplication.class, args);
  }

  @Override
  public void run(String... args) {
      view.show();
  }
}
