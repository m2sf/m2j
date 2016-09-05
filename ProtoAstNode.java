/* M2J -- Modula-2 to Java Translator & Compiler
 *
 * Copyright (c) 2016 The Modula-2 Software Foundation
 *
 * Author & Maintainer: Benjamin Kowarsch <trijezdci@org.m2sf>
 *
 * @synopsis
 *
 * M2J is a multi-dialect Modula-2 to Java translator and via-Java compiler.
 * It supports the dialects described in the 3rd and 4th editions of Niklaus
 * Wirth's book "Programming in Modula-2" (PIM) published by Springer Verlag,
 * and an extended mode with select features from the revised language by
 * B.Kowarsch and R.Sutcliffe "Modula-2 Revision 2010" (M2R10).
 *
 * In translator mode, M2J translates Modula-2 source to Java source files.
 * In compiler mode, M2J compiles Modula-2 source via Java source files
 * to Java .class files using the host system's resident Java compiler.
 *
 * @repository
 *
 * https://github.com/m2sf/m2j
 *
 * @file
 *
 * ProtoAstNode.java
 *
 * Public interface for the abstract syntax tree.
 *
 * @license
 *
 * M2J is free software: you can redistribute and/or modify it under the
 * terms of the GNU Lesser General Public License (LGPL) either version 2.1
 * or at your choice version 3 as published by the Free Software Foundation.
 * However, you may not alter the copyright, author and license information.
 *
 * M2J is distributed in the hope that it will be useful,  but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  Read the license for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with m2j.  If not, see <https://www.gnu.org/copyleft/lesser.html>.
 *
 * NB: Components in the domain part of email addresses are in reverse order.
 */

package org.m2sf.m2j;


interface ProtoAstNode {

public enum NodeType {

} /* NodeType */


/* --------------------------------------------------------------------------
 * method emptyNode()
 * --------------------------------------------------------------------------
 * Returns the empty node singleton.
 * ----------------------------------------------------------------------- */

public static final Result<ProtoAstNode, Status> emptyNode ();


/* --------------------------------------------------------------------------
 * method newNode(nodeType, subnode0, subnode1, subnode2, ...)
 * --------------------------------------------------------------------------
 * Allocates a new branch node of the given node type, stores the subnodes of
 * the argument list in the node and returns the node, or NULL on failure.
 *
 * pre-conditions:
 * o  node_type must be a valid node type
 * o  a NULL terminated argument list of valid ast nodes must be passed
 *    and type and number of subnodes must match the given node type.
 *
 * post-conditions:
 * o  newly allocated and populated ast node is returned
 *
 * error-conditions:
 * o  if allocation fails, no node is allocated and NULL is returned
 * o  if node_type is invalid, no node is allocated and NULL is returned
 * o  if type and number of subnodes does not match the given node type,
 *    no node is allocated and NULL is returned
 * ----------------------------------------------------------------------- */

public Result<ProtoAstNode, Status>
  newNode (NodeType nodeType, ProtoAstNode... subnodes);


/* --------------------------------------------------------------------------
 * method newListNode(nodeType, nodeList)
 * --------------------------------------------------------------------------
 * Allocates a new branch node of the given node type, stores the subnodes of
 * the given node list in the node and returns the node, or NULL on failure.
 * ----------------------------------------------------------------------- */

public Result<ProtoAstNode, Status>
  newListNode (NodeType nodeType, NodeList list);


/* --------------------------------------------------------------------------
 * method newTerminalNode(nodeType, value)
 * --------------------------------------------------------------------------
 * Allocates a new terminal node of the given node type, stores the given
 * terminal value in the node and returns the node, or NULL on failure.
 * ----------------------------------------------------------------------- */

public Result<ProtoAstNode, Status>
  newTerminalNode (NodeType nodeType, String value);


/* --------------------------------------------------------------------------
 * method newTerminalListNode(nodeType, terminalValueList)
 * --------------------------------------------------------------------------
 * Allocates a new terminal node of the given node type, stores the values of
 * the given value list in the node and returns the node, or NULL on failure.
 * ----------------------------------------------------------------------- */

public Result<ProtoAstNode, Status>
  newTerminalListNode (NodeType nodeType, TermList list);


/* --------------------------------------------------------------------------
 * method nodeTypeOf(node)
 * --------------------------------------------------------------------------
 * Returns the node type of node, or null if node is null.
 * ----------------------------------------------------------------------- */

public NodeType nodeTypeOf(ProtoAstNode node);


/* --------------------------------------------------------------------------
 * method subnodeCountOf(node)
 * --------------------------------------------------------------------------
 * Returns the number of subnodes or values of node. 
 * ----------------------------------------------------------------------- */

public int subnodeCountOf(ProtoAstNode node);


/* --------------------------------------------------------------------------
 * method subnodeForIndex(node, index)
 * --------------------------------------------------------------------------
 * Returns the subnode of node with the given index or null if no subnode of
 * the given index is stored in node.
 * ----------------------------------------------------------------------- */

public Result<ProtoAstNode, status>
  subnodeForIndex(ProtoAstNode node, int index);


/* --------------------------------------------------------------------------
 * method valueForIndex(node, index)
 * --------------------------------------------------------------------------
 * Returns the value stored at the given index in a terminal node,
 * or NULL if the node does not store any value at the given index.
 * ----------------------------------------------------------------------- */

public String valueForIndex (ProtoAstNode node, int index);


/* --------------------------------------------------------------------------
 * convenience method value(node)
 * --------------------------------------------------------------------------
 * Invokes valueForIndex() with an index of zero. 
 * ----------------------------------------------------------------------- */

public String value (ProtoAstNode node);


/* --------------------------------------------------------------------------
 * method replaceSubnode(inNode, atIndex, withSubnode)
 * --------------------------------------------------------------------------
 * Replaces a subnode and returns the replaced node, or null on failure.
 * ----------------------------------------------------------------------- */

public Result<ProtoAstNode, Status>
  replaceSubnode (ProtoAstNode inNode, int atIndex, ProtoAstNode withSubnode);


/* --------------------------------------------------------------------------
 * method replaceValue(inNode, atIndex, withValue)
 * --------------------------------------------------------------------------
 * Replaces a value and returns the replaced value, or null on failure.
 * ----------------------------------------------------------------------- */

public String
  replaceValue (ProtoAstNode inNode, int atIndex, String withValue);


} /* ProtoAstNode */

/* END OF FILE */