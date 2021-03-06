/**
 * Copyright 2019 the original author or authors
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.example.tree.model.BinaryNode;
import com.bernardomg.example.tree.model.Node;

/**
 * Breaks down the received expression into a preorder list.
 * <p>
 * The tree {@code ((1 + 2) - 3)} becomes {@code - + 1 2 3} with this
 * transformer.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class PreorderTraverser implements Traverser {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(PreorderTraverser.class);

    /**
     * Default constructor.
     */
    public PreorderTraverser() {
        super();
    }

    @Override
    public final Iterable<Node> traverse(final Node expression) {
        final Stack<Node> nodes;
        final Collection<Node> exps;
        Node current;

        checkNotNull(expression, "Received a null pointer as expression");

        nodes = new Stack<>();
        nodes.push(expression);

        exps = new ArrayList<>();
        while (!nodes.empty()) {
            current = nodes.pop();
            LOGGER.debug("Transforming expression {}", current);

            exps.add(current);

            if (current instanceof BinaryNode) {
                nodes.push(((BinaryNode) current).getRight());
                nodes.push(((BinaryNode) current).getLeft());
            }
        }

        return exps;
    }

}
