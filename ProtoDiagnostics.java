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
 * ProtoDiagnostics.java
 *
 * Public interface for emitting compiler warnings and error messages.
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

import java.util.enumset;

interface ProtoDiagnostics {

/* ---------------------------------------------------------------------------
 * type Code
 * ---------------------------------------------------------------------------
 * Enumerated diagnostic codes representing compilation warnings and errors.
 * ------------------------------------------------------------------------ */

public enum Code {
  /* Null Error */
  
  UNKNOWN,
  
  /* Option Errors */
  
  ERROR_INVALID_OPTION,
  ERROR_INVALID_ARGUMENT,
  ERROR_MISSING_FILENAME,
  ERROR_INVALID_FILENAME,
  ERROR_INPUT_FILE_NOT_FOUND,
  
  /* Lexical Warnings and Errors */
  
  WARN_DISABLED_CODE_SECTION,
  ERROR_INVALID_INPUT_CHAR,
  ERROR_EOF_IN_BLOCK_COMMENT,
  ERROR_NEW_LINE_IN_STRING_LITERAL,
  ERROR_EOF_IN_STRING_LITERAL,
  ERROR_INVALID_ESCAPE_SEQUENCE,
  ERROR_EOF_IN_PRAGMA,
  ERROR_MISSING_STRING_DELIMITER,
  ERROR_MISSING_SUFFIX,
  ERROR_MISSING_EXPONENT,
  
  /* Syntax Warnings and Errors */
  
  ERROR_UNEXPECTED_TOKEN,
  WARN_SEMICOLON_AFTER_FIELD_LIST_SEQ,
  WARN_EMPTY_FIELD_LIST_SEQ,
  WARN_SEMICOLON_AFTER_FORMAL_PARAM_LIST,
  WARN_SEMICOLON_AFTER_STMT_SEQ,
  WARN_EMPTY_STMT_SEQ,
  ERROR_Y,              /* Y */
  
  /* Semantic Errors */
  
  ERROR_Z;              /* Z */
  
} /* Code */


/* ---------------------------------------------------------------------------
 * method isOptionError(code)
 * ---------------------------------------------------------------------------
 * Returns true if code represents an option error code, otherwise false.
 * ------------------------------------------------------------------------ */

public boolean isOptionError (Code code);


/* ---------------------------------------------------------------------------
 * method isLexicalError(code)
 * ---------------------------------------------------------------------------
 * Returns true if code represents a lexical error code, otherwise false.
 * ------------------------------------------------------------------------ */

public boolean isLexicalError (Code code);


/* ---------------------------------------------------------------------------
 * method isSyntaxError(error)
 * ---------------------------------------------------------------------------
 * Returns true if code represents a syntax error code, otherwise false.
 * ------------------------------------------------------------------------ */

public boolean isSyntaxError (Code code);


/* ---------------------------------------------------------------------------
 * method isSemanticError(code)
 * ---------------------------------------------------------------------------
 * Returns true if code represents a semantic error code, otherwise false.
 * ------------------------------------------------------------------------ */

public boolean isSemanticError (Code code);


/* ---------------------------------------------------------------------------
 * method diagMsgText(code)
 * ---------------------------------------------------------------------------
 * Returns a pointer to an immutable human readable message string for the
 * given diagnostic code or null if the code is not a valid diagnostic code.
 * ------------------------------------------------------------------------ */

public String diagMsgText (Code code);


/* ---------------------------------------------------------------------------
 * method emitError(code)
 * ---------------------------------------------------------------------------
 * Emits an error message for code to the console.
 * ------------------------------------------------------------------------ */

public void emitError (Code code);


/* ---------------------------------------------------------------------------
 * method emitErrorWithOffendingStr(code, offendingStr)
 * ---------------------------------------------------------------------------
 * Emits an error message for code and offendingStr to the console.
 * ------------------------------------------------------------------------ */

public void emitErrorWithOffendingStr (Code code, String offendingStr);


/* ---------------------------------------------------------------------------
 * method emitErrorWithPos(code, line, column)
 * ---------------------------------------------------------------------------
 * Emits an error message for code, line and column to the console.
 * ------------------------------------------------------------------------ */

public void emitErrorWithPos (Code code, int line, int column);


/* ---------------------------------------------------------------------------
 * method emitErrorWithChr(error, line, column, offendingChr)
 * ---------------------------------------------------------------------------
 * Emits an error message for code, line, column and offendingChr to the
 * console.
 * ------------------------------------------------------------------------ */

public void emitErrorWithChr
  (Code code, int line, int column, char offendingChr);


/* ---------------------------------------------------------------------------
 * method m2c_emit_error_w_lex(error, line, column, offendingLexeme)
 * ---------------------------------------------------------------------------
 * Emits an error message for code, line, column and offendingLexeme to the
 * console.
 * ------------------------------------------------------------------------ */

public void emitErrorWithLex
  (Code code, int line, int column, String offendingLexeme);


/* ---------------------------------------------------------------------------
 * method emitSyntaxErrorWithToken(line, col, unexpToken, offLex, expToken)
 * ---------------------------------------------------------------------------
 * Emits a syntax error message of the following format to the console:
 * line: n, column: m, unexpected offending-symbol offending-lexeme found
 *   expected token
 * ------------------------------------------------------------------------ */

public void emitSyntaxErrorWithToken
  (int line, int column,
   ProtoTerminal.Token unexpectedToken,
   String offendingLexeme,
   ProtoTerminal.Token expectedToken);


/* ---------------------------------------------------------------------------
 * method emitSyntaxErrorWithSet(line, col, unexpToken, offLex, expTokenSet)
 * ---------------------------------------------------------------------------
 * Emits a syntax error message of the following format to the console:
 * line: n, column: m, unexpected offending-symbol offending-lexeme found
 *   expected set-symbol-1, set-symbol-2, set-symbol-3, ... or set-symbol-N
 * ------------------------------------------------------------------------ */

public void emitSyntaxErrorWithSet
  (int line, int column,
   ProtoTerminal.Token unexpectedToken,
   String offendingLexeme,
   EnumSet<ProtoTerminal.Token> expectedTokenSet);


/* ---------------------------------------------------------------------------
 * method emitWarningWithPos(code, line, column)
 * ---------------------------------------------------------------------------
 * Emits a warning message for code, line and column to the console.
 * ------------------------------------------------------------------------ */

public void emitWarningWithPos (Code code, int line, int column);


/* ---------------------------------------------------------------------------
 * method emitWarningWithRange(error, firstLine, lastLine)
 * ---------------------------------------------------------------------------
 * Emits a warning message for range from firstLine to lastLine.
 * ------------------------------------------------------------------------ */

public void emitWarningWithRange (Code code, int firstLine, int lastLine);


} /* ProtoDiagnostics */

/* END OF FILE */