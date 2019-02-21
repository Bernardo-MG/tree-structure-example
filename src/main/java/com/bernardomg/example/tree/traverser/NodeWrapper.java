/**
 * Copyright 2014-2019 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.bernardomg.example.tree.traverser;

import static com.google.common.base.Preconditions.checkNotNull;

import com.bernardomg.example.tree.model.Node;

/**
 * Wraps an expression to hide its type. Used for example when pruning a tree,
 * to create a node without children.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class NodeWrapper implements Node {

    /**
     * Wrapped expression.
     */
    private final Node wrappedNode;

    /**
     * Constructs a wrapper for the received expression.
     * 
     * @param node
     *            the expression to wrap
     */
    public NodeWrapper(final Node node) {
        super();

        wrappedNode = checkNotNull(node,
                "Received a null pointer as expression");
    }

    /**
     * Returns the wrapped expression.
     * 
     * @return the wrapped expression
     */
    public final Node getWrappedNode() {
        return wrappedNode;
    }

    @Override
    public final String getText() {
        return wrappedNode.getText();
    }

}
