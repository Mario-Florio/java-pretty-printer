# java-pretty-printer
A `console.log` clone for Java.

## Setup
1. Clone/copy repo into project
2. Import project into project via `infrastructure.prettyprinter`
3. Create `PrettyPrinter` instance (with passed reference to `out` print stream)
4. Execute with `instance.log(obj)`

## Usage
```java
// Import with appropriate path
import pathto.prettyprinter;

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
