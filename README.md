# java-pretty-printer
A `console.log` clone for Java.

## Setup

**Prerequisites:**
- Java 17 or higher
- Maven 3.8+ installed

**1. Clone/copy repo into project:**
```bash
git clone https://github.com/mario-florio/java-pretty-printer.git
cd java-pretty-printer
```

**2. Install to local library with Maven:**
```bash
mvn clean install
```

**3. Add as dependency in Maven project:**
```xml
<dependency>
  <groupId>com.marioflorio</groupId>
  <artifactId>prettyprinter</artifactId>
  <version>0.1.0</version>
</dependency>
```

**4. Import in project:**
```java
import com.marioflorio.prettyprinter.PrettyPrinter;
```

## Usage
```java
import com.marioflorio.prettyprinter.PrettyPrinter;

public class Main {
    // Declare instance with standard output stream
    private static PrettyPrinter console = new PrettyPrinter(System.out);

    public static void main(String[] args) {

        // Call with console.log
        console.log("Hello, World.");

        // Formats:
           Map<Object, Object> map = new HashMap<>();
           // add entries..
           console.log(map) // -> {key: value..N}

           List<Object> list = new ArrayList<>();
           // add items..
           console.log(list); // -> [item..]

           console.log(PrettyPrinter.class) // -> [class PrettyPrinter] {}

           console.log(console); // ->
              /**
               * PrettyPrinter {
               *   out: java.io.PrintStream@57167ccb, 
               *   engine: Engine {
               *     renderer: StringRenderer {
               *       applyFormat: true, 
               *       applyColor: true, 
               *       renderText: [Method: renderText], 
               *       renderWrapper: [Method: renderWrapper], 
               *       renderConcat: [Method: renderConcat], 
               *       renderLineBreak: [Method: renderLineBreak], 
               *       renderIndentBlock: [Method: renderIndentBlock], 
               *       render: [Method: render], 
               *       setApplyFormat: [Method: setApplyFormat], 
               *       setApplyColor: [Method: setApplyColor]
               *     }, 
               *     run: [Method: run], 
               *     configure: [Method: configure]
               *   }, 
               *   log: [Method: log]
               * }
               */

            // See /docs/design-doc.md#general-behavior for all supported types

    }
}
```

## Tests
Unit and Integration tests are available. Run with:
```bash
mvn test
```

## Demo
A demo is available in [`Main.java`](./src/main/java/com/marioflorio/prettyprinter/Main.java).

**1. Build project:**
```bash
mvn compile
```

**2. Run:**
```bash
# Maven
mvn compile exec:java -Dexec.mainClass="com.marioflorio.prettyprinter.Main"

# Native Java
java -cp target/classes com.marioflorio.prettyprinter.Main
```