package kafka.example.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ProducerApplication {

    public static final String TOPIC = "topic-test";

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(TOPIC)
                .partitions(2)
                .replicas(1)
                .build();
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
        return args -> {
            while (true) {
                template.send(TOPIC, UUID.randomUUID().toString())
                        .thenApply(r -> System.out.printf(r.toString()));
                template.flush();
                TimeUnit.SECONDS.sleep(1);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

}
