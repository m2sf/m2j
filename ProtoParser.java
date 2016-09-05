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
 * ProtoParser.java
 *
 * Public parser interface.
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

interface ProtoParser {

/* --------------------------------------------------------------------------
 * method checkSyntaxForDef(filename)
 * --------------------------------------------------------------------------
 * Syntax checks a Modula-2 .DEF file represented by filename.
 * ----------------------------------------------------------------------- */

public Status checkSyntaxForDef (String filename);


/* --------------------------------------------------------------------------
 * method checkSyntaxForMod(filename)
 * --------------------------------------------------------------------------
 * Syntax checks a Modula-2 .MOD file represented by filename.
 * ----------------------------------------------------------------------- */

public Status checkSyntaxForMod (String filename);


/* --------------------------------------------------------------------------
 * method parseDef(filename)
 * --------------------------------------------------------------------------
 * Parses a Modula-2 .DEF file represented by filename and returns an AST.
 * ----------------------------------------------------------------------- */

public ProtoAstNode parseDef (String filename);


/* --------------------------------------------------------------------------
 * method parseMod(filename)
 * --------------------------------------------------------------------------
 * Parses a Modula-2 .MOD file represented by filename and returns an AST.
 * ----------------------------------------------------------------------- */

public ProtoAstNode parseMod (String filename);



} /* ProtoParser */

/* END OF FILE */