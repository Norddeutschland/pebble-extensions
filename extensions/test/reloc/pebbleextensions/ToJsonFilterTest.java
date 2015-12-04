package reloc.pebbleextensions;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.LinkedHashMap;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * @author armin
 */
public class ToJsonFilterTest {

  @Test
  public void toJsonFilter_shouldNotHaveAnyArguments() throws Exception {
    // assertion: should not have any arguments at all.
    assertThat(new ToJsonFilter().getArgumentNames()).describedAs("arguments").isNull();
  }

  @Test(dataProvider = "toJsonFilter input and output")
  public void toJsonFilter_shouldReturnJsonOutputForInput(final Object input, final String expectedOutput) throws Exception {
    // execution:
    final String result = (String) new ToJsonFilter().apply(input, new LinkedHashMap<>());

    // assertion: should have returned the expected json
    assertThat(result).describedAs("resulting output").isEqualTo(expectedOutput);
  }

  @DataProvider(name = "toJsonFilter input and output")
  public Object[][] getToJsonFilterExampleValues() {
    return new Object[][] {
      new Object[] { null, "null" },
      new Object[] { 1, "1" },
      new Object[] { "string", "\"string\"" },
      new Object[] { Collections.emptyList(), "[]" },
      new Object[] { Collections.emptyMap(), "{}" },
      new Object[] { Collections.singletonMap("key", "value"), "{\"key\":\"value\"}"}
    };
  }

}