package reloc.pebbleextensions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitchellbosecke.pebble.extension.Filter;

import java.util.List;
import java.util.Map;

/**
 * This is a filter that can be used to convert a complex java datastructure to inlined json.
 * This was something we had to do when we used pebble for generating large amounts of code.
 *
 * @author armin
 */
public class ToJsonFilter implements Filter {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  @Override
  public Object apply(final Object input, final Map<String, Object> args) {
    try {
      return OBJECT_MAPPER.writeValueAsString(input);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  @Override
  public List<String> getArgumentNames() {
    return null;
  }

}
