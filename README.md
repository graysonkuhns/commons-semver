# XELLITIX Commons - Semantic Versioning

Semantic versioning Java library.

## Usage

Parsing a Semantic Version
``` java
// Create the Google Guice injector
Injector injector = Guice.createInjector(new SemanticVersionModule());

// Create the version parser
SemanticVersionParser parser = injector.getInstance(SemanticVersionParser.class);

// Parse the version
SemanticVersion version = parser.parse("1.0.0-rc.1+x86-64.2");

// Get the version properties
version.getMajorVersion()       // int                : 1
version.getMinorVersion()       // int                : 0
version.getPatchVersion()       // int                : 0
version.getPreReleaseMetadata() // Optional<Metadata> : "rc.1"
version.getBuildMetadata()      // Optional<Metadata> : "x86-64.2"
```

Building a Semantic Version
``` java
// Create the Google Guice injector
Injector injector = Guice.createInjector(new SemanticVersionModule());

// Create the version builder
SemanticVersionBuilder builder = injector.getInstance(SemanticVersionBuilder.class);

// Build the Semantic Version
SemanticVersion version = builder
    .setMajorVersion(1)
    .addPreReleaseMetadataIdentifier("rc")
    .addPreReleaseMetadataIdentifier(1)
    .addBuildMetadataIdentifier("arm32")
    .addBuildMetadataIdentifier(54L)
    .build();

// Get the string representation of the version
version.toString(); // "1.0.0-rc.1+arm32.54";
```

## Style

This project aims to adhere to the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).

## Versioning

This project aims to adhere to [Semantic Versioning 2.0.0](http://semver.org/).

## Authors

- [Grayson Kuhns](https://www.linkedin.com/in/graysonkuhns/) ([Send email](mailto:grayson.kuhns@xellitix.com))
