package bitcamp.myapp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

@SpringBootApplication
@EnableTransactionManagement
@PropertySource({
        "file:${HOME}/config/jdbc.properties",
        "file:${HOME}/config/ncp.properties",
        "file:${HOME}/config/ncp-secret.properties"
})
@Controller
public class App {

  private static Log log = LogFactory.getLog(App.class);

  public static void main(String[] args) throws Exception {
    log.info("과제관리 시스템 서버 실행!");
    SpringApplication.run(App.class, args);
    Properties props = System.getProperties();
    Set<Entry<Object, Object>> entrySet = props.entrySet();

    for (Entry<Object, Object> entry : entrySet) {
      System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());

    }
  }



  @GetMapping("/home")
  public void home() {
  }

  @GetMapping("/about")
  public void about() {
  }

}