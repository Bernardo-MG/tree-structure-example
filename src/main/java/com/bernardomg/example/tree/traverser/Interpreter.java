
package com.bernardomg.example.tree.traverser;

import com.bernardomg.example.tree.model.Node;

public interface Interpreter<V> {

    public V transform(final Node root);

}
