package __tests__.Engine.methods;

import java.util.Collection;
import java.util.HashSet;

import interfaceadapters.Engine;
import shared.testing.Test;

public class CollectionTests {
    private static Engine engine = new Engine();

    public static final void run() {
        System.out.println("COLLECTION");

        Test.it("Formats empty Collection correctly", () -> {
            Collection<String> collection = new HashSet<String>();

            String result = engine.run(collection);

            Test.expect(result.equals("[]"));
        });

        Test.it("Formats single-element Collection correctly", () -> {
            Collection<String> collection = new HashSet<String>();
            collection.add("String");

            String result = engine.run(collection);

            Test.expect(result.equals("['String']"));
        });

        Test.it("Formats multi-element Collection correctly", () -> {
            Collection<String> collection = new HashSet<String>();
            collection.add("String 1");
            collection.add("String 2");
            collection.add("String 3");
            collection.add("String 4");

            String result = engine.run(collection);

            Test.expect(result.equals("['String 1', 'String 2', 'String 3', 'String 4']"));
        });

        Test.it("Formats nested Collection correctly", () -> {
            Collection<Collection<String>> collection = new HashSet<>();
            Collection<String> innerCollectionA = new HashSet<String>();
            innerCollectionA.add("String 1");
            innerCollectionA.add("String 2");
            Collection<String> innerCollectionB = new HashSet<String>();
            innerCollectionB.add("String 3");
            innerCollectionB.add("String 4");
            collection.add(innerCollectionA);
            collection.add(innerCollectionB);

            String result = engine.run(collection);

            Test.expect(result.equals("[['String 1', 'String 2'], ['String 3', 'String 4']]"));
        });
    }
}
