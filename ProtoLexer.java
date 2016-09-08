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
 * ProtoLexer.java
 *
 * Public lexer interface.
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

interface ProtoLexer {

/* ---------------------------------------------------------------------------
 * Lexical limits
 * ------------------------------------------------------------------------ */

public static int MAX_IDENT_LENGTH = 32;

public static int COMMENT_NESTING_LIMIT = 100;


/* ---------------------------------------------------------------------------
 * Lexer status codes
 * ------------------------------------------------------------------------ */

public enum Status {
  SUCCESS,
  FILE_NOT_FOUND,
  FILE_ACCESS_DENIED,
  NOT_INITIALIZED,
  TODO
} /* Status */


/* ---------------------------------------------------------------------------
 * constructor newLexer(filename)
 * ---------------------------------------------------------------------------
 * Creates a new lexer instance, opens an input file, associates the file with
 * the newly created lexer and returns a Result pair with the lexer reference
 * and a status value.
 *
 * pre-conditions:
 * o  filename must refer to an existing and accessible input file 
 *
 * post-conditions:
 * o  lexer is created
 * o  status is set to SUCCESS
 *
 * error-conditions:
 * o  if the file represented by filename cannot be found
 *    lexer is set to null, status is set to FILE_NOT_FOUND
 * o  if the file represented by filename cannot be accessed
 *    lexer is set to null, status is set to FILE_ACCESS_DENIED
 * ----------------------------------------------------------------------- */

public Result<ProtoLexer, Status> newLexer (String filename);


/* --------------------------------------------------------------------------
 * method readSym()
 * --------------------------------------------------------------------------
 * Reads the lookahead symbol from the source file associated with lexer and
 * consumes it, thus advancing the current reading position, then returns
 * the symbol's token.
 *
 * pre-conditions:
 * o  lexer instance must have been created with constructor newLexer()
 *    so that it is associated with an input source file
 *
 * post-conditions:
 * o  character code of lookahead character or EOF is returned
 * o  current reading position and line and column counters are updated
 * o  file status is set to SUCCESS
 *
 * error-conditions:
 * o  if no source file is associated with lexer, no operation is carried out
 *    and status is set to NOT_INITIALIZED
 * ----------------------------------------------------------------------- */

public ProtoTerminals.Token readSym();


/* --------------------------------------------------------------------------
 * method nextSym()
 * --------------------------------------------------------------------------
 * Reads the lookahead symbol from the source file associated with lexer but
 * does not consume it, thus not advancing the current reading position,
 * then returns the symbol's token.
 *
 * pre-conditions:
 * o  lexer instance must have been created with constructor newLexer()
 *    so that it is associated with an input source file
 *
 * post-conditions:
 * o  token of lookahead symbol is returned
 * o  current reading position and line and column counters are NOT updated
 * o  file status is set to SUCCESS
 *
 * error-conditions:
 * o  if no source file is associated with lexer, no operation is carried out
 *    and status is set to NOT_INITIALIZED
 * ----------------------------------------------------------------------- */

public ProtoTerminals.Token nextSym ();


/* --------------------------------------------------------------------------
 * method consumeSym()
 * --------------------------------------------------------------------------
 * Consumes the lookahead symbol and returns the token of the new lookahead
 * symbol.
 * ----------------------------------------------------------------------- */

public ProtoTerminals.Token consumeSym ();


/* --------------------------------------------------------------------------
 * method filename()
 * --------------------------------------------------------------------------
 * Returns the filename associated with the lexer instance.
 * ----------------------------------------------------------------------- */

public String filename ();


/* --------------------------------------------------------------------------
 * method status()
 * --------------------------------------------------------------------------
 * Returns the status of the last operation on lexer.
 * ----------------------------------------------------------------------- */

public Status status ();


/* --------------------------------------------------------------------------
 * method lookaheadLexeme()
 * --------------------------------------------------------------------------
 * Returns the lexeme of the lookahead symbol.
 * ----------------------------------------------------------------------- */

public String lookaheadLexeme ();


/* --------------------------------------------------------------------------
 * method currentLexeme()
 * --------------------------------------------------------------------------
 * Returns the lexeme of the most recently consumed symbol.
 * ----------------------------------------------------------------------- */

public String currentLexeme ();


/* --------------------------------------------------------------------------
 * method lookaheadLine()
 * --------------------------------------------------------------------------
 * Returns the line counter of the lookahead symbol.
 * ----------------------------------------------------------------------- */

public int lookaheadLine ();


/* --------------------------------------------------------------------------
 * method currentLine()
 * --------------------------------------------------------------------------
 * Returns the line counter of the most recently consumed symbol.
 * ----------------------------------------------------------------------- */

public int currentLine ();


/* --------------------------------------------------------------------------
 * method lookaheadColumn()
 * --------------------------------------------------------------------------
 * Returns the column counter of the lookahead symbol.
 * ----------------------------------------------------------------------- */

public int lookaheadColumn ();


/* --------------------------------------------------------------------------
 * method currentColumn()
 * --------------------------------------------------------------------------
 * Returns the column counter of the most recently consumed symbol.
 * ----------------------------------------------------------------------- */

public int currentColumn ();


/* --------------------------------------------------------------------------
 * method printLineAndMarkColumn(line, column)
 * --------------------------------------------------------------------------
 * Prints the given source line of the current symbol to the console and
 * marks the given coloumn with a caret '^'.
 * ----------------------------------------------------------------------- */

public void printLineAndMarkColumn (int line, int column);


} /* ProtoLexer */

/* END OF FILE */