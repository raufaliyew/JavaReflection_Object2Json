* Run [The Code](performanceexample1) as `java -XX:+PrintCompilation Main 10`
* JIT compilers
    * C1 (Cache 1)
        * Native Level 1
        * Native Level 2
        * Native Level 3
    * C2 (Cache 2)
        * Native Level 4

* Check for code cache size: `-XX:+PrintCodeCache`
* Chance code cache size:
    * InitialCodeCacheSize – the initial code cache size, 160K default
        * VM Options: `java -XX:InitialCodeCacheSize=28` (28 -> bytes, 28k -> 28 kbytes, 28m -> 28 mbytes, 28g -> 28 gbytes)
    * ReservedCodeCacheSize – the default maximum size is 48MB
        * VM Options: `java -XX:ReservedCodeCacheSize=28` (28 -> bytes, 28k -> 28 kbytes, 28m -> 28 mbytes, 28g -> 28 gbytes)
    * CodeCacheExpansionSize – the expansion size of the code cache, 32KB or 64KB
        * VM Options: `java -XX:CodeCacheExpansionSize=28` (28 -> bytes, 28k -> 28 kbytes, 28m -> 28 mbytes, 28g -> 28 gbytes)


#### Resources:
* [Cache memory](https://www.baeldung.com/cs/cache-memory)
* [Java Codecache Tuning Oracle](https://docs.oracle.com/javase/8/embedded/develop-apps-platforms/codecache.htm)
* [Introduction to JVM Code Cache](https://www.baeldung.com/jvm-code-cache)