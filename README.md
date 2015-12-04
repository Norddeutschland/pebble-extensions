# pebble-extensions

This is a small but growing set of custom Extensions for the Pebble Template Engine we needed and want to share.

The only current extension is a filter that can be used to add datastructures to generated javascript using json.
 

## Usage:

I'm using the pebble template engine with spring-pebble. Thus I have a bena that supplies my webapp with a pebble instance.

```
 @Bean
 public PebbleEngine pebbleEngine(final Loader templateLoader) {
   final PebbleEngine pebbleEngine = new PebbleEngine(templateLoader);
   // add the custom filter.
   pebbleEngine.getFilters().put("ToJSon", new reloc.pebbleextensions.ToJsonFilter());
   return pebbleEngine;
  }
```

And when using pebble to generate my script / config I use this:

```
var GLOBAL_DATA = {{ data | ToJSon | raw }};
```

If you've got better Ideas, just tell me :-)
