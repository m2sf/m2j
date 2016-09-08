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
 * ProtoAstNodeTypeMgr.java
 *
 * Public interface for AST node type checking.
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

interface ProtoAstNodeTypeMgr {

/* ---------------------------------------------------------------------------
 * method isValid(nodeType)
 * ---------------------------------------------------------------------------
 * Returns true if nodeType is a valid node type, otherwise false.
 * ------------------------------------------------------------------------ */

public boolean isValid(ProtoAstNodeType nodeType);


/* ---------------------------------------------------------------------------
 * method isNonterminalType(nodeType)
 * ---------------------------------------------------------------------------
 * Returns true if nodeType is a nonterminal node type, otherwise false.
 * ------------------------------------------------------------------------ */

public boolean isNonterminalType (ProtoAstNodeType nodeType);


/* ---------------------------------------------------------------------------
 * method isTerminalType(nodeType)
 * ---------------------------------------------------------------------------
 * Returns true if nodeType is a terminal node type, otherwise false.
 * ------------------------------------------------------------------------ */

public boolean isTerminalType (ProtoAstNodeType nodeType);


/* ---------------------------------------------------------------------------
 * method isListType(nodeType)
 * ---------------------------------------------------------------------------
 * Returns true if nodeType is a list node type, otherwise false.
 * ------------------------------------------------------------------------ */

public boolean isListType (ProtoAstNodeType nodeType);


/* ---------------------------------------------------------------------------
 * method isLegalSubnodeCount(nodeType, subnodeCount)
 * ---------------------------------------------------------------------------
 * Returns true if the given subnode count is a legal value for the given
 * node type, otherwise false.
 * ------------------------------------------------------------------------ */

public boolean isLegalSubnodeCount
  (ProtoAstNodeType nodeType, int SubnodeCount);


/* ---------------------------------------------------------------------------
 * method isLegalSubnodeType(inNodeType, subnodeType, index)
 * ---------------------------------------------------------------------------
 * Returns true if the given subnode type is a legal node type for the given
 * index in a node of the given subnode type, otherwise false.
 * ------------------------------------------------------------------------ */

public boolean isLegalSubnodeType
  (ProtoAstNodeType inNodeType, ProtoAstNodeType subnodeType, int index);


/* ---------------------------------------------------------------------------
 * method nameForNodeType(nodeType)
 * ---------------------------------------------------------------------------
 * Returns a string with a human readable name for nodeType or null if the
 * given node type is invalid.
 * ------------------------------------------------------------------------ */

public String nameForNodeType (ProtoAstNodeType nodeType);


} /* ProtoAstNodeTypeMgr */

/* END OF FILE */