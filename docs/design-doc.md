# Java Pretty Printer

## Context & Purpose
Java's native printing utility (`System.out.print`) lacks comprehensive pretty printing capabilities. This project aims to create a printing utility which mimics the pretty formatting of JavaScripts `console.log`.

## Architecture
```
     +---------+
     | Printer |
     +---------+
          |
          v
     +----------+
     |  Engine  |
     +----------+
       |      |
       v      v
+---------+ +----------+
| Modeler | | Renderer |
+---------+ +----------+
         |   |
         v   v
        +-----+
        | Doc |
        +-----+
```

### Core

#### Entities
* **Doc**:
  * Structural rules for *modeled* `Object`s
  * Basis for tree structure

#### Use Cases
* **Modeler**:
  * Recieves Java `Object`s
  * Returns `Doc` tree

* **Renderer**:
  * Recieves `Doc` tree
  * Returns formatted string

### Interface Adapter

#### Controller
* **Engine**:
  * Orchestrates *use cases*
  * Returns rendered string

### Infrastructure
* **Printer**:
  * Sets `out` stream
  * Recieves client input (Java `Object`s)
  * Prints rendered strings to `out` stream

## General Behavior

### Primitives
All primitives are printed as strings using inherent `toString` method on wrapper classes.

### String
`String`s are printed as is. Strings are wrapper in single quotations (I.e. `'`) if string is:
* a value in a `Map`
* a key in a `Map` with white space
* an item of an `Array`
* an item of a `List`

### Invocables
* `Method` -> `[Method: methodName]`
* `Constructor` -> `[Constructor]`

### Functions
* `Runnable`   -> `[Runnable]`
* `Callable`   -> `[Callable]`
* `Function`   -> `[Function]`
* `Consumer`   -> `[Consumer]`
* `BiFunction` -> `[BiFunction]`
* `BiConsumer` -> `[BiConsumer]`
* `Supplier`   -> `[Supplier]`

### Map
Wraps all entries in curly brackets and separates key value pairs via colon and a space:
```java
Map<String, int> map = new LinkedHashMap<>();
map.put("prop1", 1);
map.put("prop2", 2);
map.put("prop3", 3);
map.put("prop4", 4);

PrettyPrinter console = new PrettyPrinter(System.out);
console.log(map);
// prints: {prop1: 1, prop2: 2, prop3: 3, prop4: 4}
```

### Class
`[ClassType: ClassName]`

Example: `[interface List]`

If `Class` is user defined, it prints out all static entries and methods as a `Map` (see [Map](#map)):
```java
class User {
    static List<int> types = new ArrayList<>();
    static void getType() {}
    public String name;
    public User(name) {}
}
//...
console.log(User.class);
// prints:
// [class User] {
//     types: []
//     getType: [Method: getType]    
// }
```

### User Defined Objects
```java
// ...
console.log(new User("Bob"));
// prints:
// User {name: 'Bob'}
```

### Array & List
Wraps all items in square brackets: `[item1, item2, ..N]`
