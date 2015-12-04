# pebble-extensions

This is a small but growing set of custom Extensions for the Pebble Template Engine we needed and want to share.

The only current extension is a filter that can be used to add datastructures to generated javascript using json.
 

## Usage:

I'm using the pebble template engine with spring-pebble. Thus I have a bena that supplies my webapp with a pebble instance.

```JAVA
 @Bean
 public PebbleEngine pebbleEngine(final Loader templateLoader) {
   final PebbleEngine pebbleEngine = new PebbleEngine(templateLoader);
   // add the custom filter.
   pebbleEngine.getFilters().put("ToJSon", new reloc.pebbleextensions.ToJsonFilter());
   return pebbleEngine;
  }
```

And when using pebble to generate my script / config I use this:

```JAVASCRIPT
var GLOBAL_DATA = {{ data | ToJSon | raw }};
```

If you've got better Ideas, just tell me :-)


## Why not contribute those directly into the pebble template engine?

That's a very good question. I will contribute anything directly into pebble but everything in this repo will add new dependencies, for example to ToJSon Filter adds a dependency to FasterXML/Jackson . This is a library that is present in lots of projects anyway but you might not want to have in a template engine just for one filter command.

