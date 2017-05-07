package web.rest;

import java.util.concurrent.atomic.AtomicLong;

import model.Greeting;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
public class GreetingsResource {

  private static final String template = "Hello, %s";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping(value = "greeting", method=RequestMethod.GET)
  public @ResponseBody Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }
}
