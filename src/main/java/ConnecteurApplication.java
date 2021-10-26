
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Connecteur CPagei - Net Entreprise.
 */
@SpringBootApplication
@EnableScheduling
public class ConnecteurApplication {
  final Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * @param args arguments
   */
  public static void main(final String[] args) {
    SpringApplication.run(ConnecteurApplication.class, args);
  }

  @EnableAsync
  @Configuration
  class AsyncConfiguration implements AsyncConfigurer {

    @Value("${thread.pool.core:4}")
    int core;
    @Value("${thread.pool.max:32}")
    int max;
    @Value("${thread.pool.capacity:10000}")
    int capacity;

    @Override
    @Bean
    public Executor getAsyncExecutor() {
      ConnecteurApplication.this.logger.info("Init thread pool: core = {}, max = {}, capacity = {}", this.core, this.max, this.capacity);
      final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
      executor.setCorePoolSize(this.core);
      executor.setMaxPoolSize(this.max);
      executor.setQueueCapacity(this.capacity);
      executor.setThreadNamePrefix("default-te-");
      return executor;
    }
  }

}
