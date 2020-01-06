package pl.dominisz.bulkemailgenerator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TemplateServiceTest {

  @ParameterizedTest
  @MethodSource
  void shouldGenerateEmail(List<String> template, List<String> email) {
    var templateService = new TemplateService();

    var actualResult = templateService.generate(template);

    assertEquals(email, actualResult);
  }

  static Stream<Arguments> shouldGenerateEmail() {
    return Stream.of(Testcase.values())
        .map(testcase -> arguments(testcase.getInput(), testcase.getOutput()));
  }
}
