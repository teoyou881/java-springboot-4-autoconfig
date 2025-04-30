package hello.config;

import memory.MemoryController;
import memory.MemoryFinder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @Conditional(MemoryCondition.class) // 추가
//@ConditionalOnProperty` 도 우리가 만든 것과 동일하게 내부에는 `@Conditional` 을 사용한다.
// 그리고 그 안에 `Condition` 인터페이스를 구현한' OnPropertyCondition` 를 가지고 있다.
@ConditionalOnProperty(name = "memory", havingValue = "on") // 추가
public class MemoryConfig {

  @Bean
  public MemoryController memoryController() {
    return new MemoryController(memoryFinder());
  }

  @Bean
  public MemoryFinder memoryFinder() {
    return new MemoryFinder();
  }
}