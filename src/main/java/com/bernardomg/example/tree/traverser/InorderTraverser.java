
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
 * Breaks down the received expression into an inorder list.
 * <p>
 * The tree {@code ((1 + 2) - 3)} becomes {@code 1 + 2 - 3} with this
 * transformer.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class InorderTraverser implements Interpreter<Iterable<Node>> {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(InorderTraverser.class);

    /**
     * Default constructor.
     */
    public InorderTraverser() {
        super();
    }

    @Override
    public final Iterable<Node> transform(final Node expression) {
        final Stack<Node> nodes;
        final Collection<Node> exps;
        Node current;

        checkNotNull(expression, "Received a null pointer as expression");

        current = expression;

        nodes = new Stack<>();
        exps = new ArrayList<>();
        while ((!nodes.isEmpty()) || (current != null)) {
            LOGGER.debug("Transforming expression {}", current);
            if (current == null) {
                // Left nodes exhausted
                // Moves to the previous right node
                current = nodes.pop();

                // This is the next node for inorder traverse
                exps.add(current);

                if (current instanceof BinaryNode) {
                    // Moves to a right node
                    current = ((BinaryNode) current).getRight();
                } else {
                    // Not binary node
                    // There is no right node
                    current = null;
                }
            } else {
                // Store and keep moving
                nodes.push(current);
                if (current instanceof BinaryNode) {
                    // Next left node
                    current = ((BinaryNode) current).getLeft();
                } else {
                    // Not binary node
                    // There is no left node
                    current = null;
                }
            }
        }

        return exps;
    }

}
