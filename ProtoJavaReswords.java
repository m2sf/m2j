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
 * ProtoJavaReswords.java
 *
 * Public interface for Java reserved word recogniser.
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

interface ProtoJavaReswords {

/* ---------------------------------------------------------------------------
 * method IsResword(lexeme)
 * ---------------------------------------------------------------------------
 * Tests if lexeme matches reserved words and reserved word literals of
 * the Java language and returns true in case of a match, otherwise false.
 *
 * Reserved words:
 *   abstract, assert, boolean, break, byte, case, catch, char, class, const,
 *   continue, default, do, double, else, enum, extends, final, finally,
 *   float, for, goto, if, implements, import, instanceof, int, interface,
 *   long, native, new, package, private, protected, public, return, short,
 *   static strictfp, super, switch, synchronized, this, throw, throws,
 *   transient, try, void, volatile, while;
 *
 * Reserved word literals:
 *   false, null, true; 
 * ------------------------------------------------------------------------ */

public boolean IsResword (String lexeme);


} /* ProtoJavaReswords */

/* END OF FILE */