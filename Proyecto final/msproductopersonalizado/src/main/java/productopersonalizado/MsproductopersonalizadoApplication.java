package productopersonalizado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsproductopersonalizadoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsproductopersonalizadoApplication.class, args);
    }

}
