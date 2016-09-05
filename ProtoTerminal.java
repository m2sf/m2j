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
 * ProtoTerminal.java
 *
 * Public interface for Terminal's token and lexeme lookup.
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

interface ProtoTerminal {

/* ---------------------------------------------------------------------------
 * type Token
 * ---------------------------------------------------------------------------
 * Enumerated token values representing Modula-2 terminal symbols.
 * ------------------------------------------------------------------------ */

public enum Token {
  /* Null Token */
  
  UNKNOWN, /* invalid token */
  
  /* Reserved Words */

  AND, ARRAY, BEGIN, BY, CASE, CONST, DEFINITION, DIV, DO, ELSE, ELSIF, END,
  EXIT, EXPORT, FOR, FROM, IF, IMPLEMENTATION, IMPORT, IN, LOOP, MOD, MODULE,
  NOT, OF, OR, POINTER, PROCEDURE, QUALIFIED, RECORD, REPEAT, RETURN, SET,
  THEN, TO, TYPE, UNTIL, VAR, WHILE, WITH,
  
  /* Identifiers */
  
  IDENTIFIER,
  
  /* Literals */
  
  STRING_LITERAL, INT_LITERAL, REAL_LITERAL, CHAR_LITERAL,
  
  /* Malformed Literals */
  
  MALFORMED_STRING, MALFORMED_INTEGER, MALFORMED_REAL, /* invalid tokens */
  
  /* Pragmas */
  
  PRAGMA,
  
  /* Special Symbols */
  
  PLUS,            /* '+'  */
  MINUS,           /* '-'  */
  EQUAL,           /* '+'  */
  NOTEQUAL,        /* '#'  */
  LESS,            /* '<'  */
  LESS_EQUAL,      /* '<=' */
  GREATER,         /* '>'  */
  GREATER_EQUAL,   /* '>=' */
  ASTERISK,        /* '*'  */
  SOLIDUS,         /* '/'  */
  ASSIGN,          /* ':=' */
  COMMA,           /* ','  */
  PERIOD,          /* '.'  */
  COLON,           /* ':'  */
  SEMICOLON,       /* ';'  */
  RANGE,           /* '..' */
  DEREF,           /* '^'  */
  BAR,             /* '|'  */
  LEFT_PAREN,      /* '('  */
  RIGHT_PAREN,     /* ')'  */
  LEFT_BRACKET,    /* '['  */
  RIGHT_BRACKET,   /* ']'  */
  LEFT_BRACE,      /* '{'  */
  RIGHT_BRACE,     /* '}'  */
  END_OF_FILE;
  
  /* Synonyms */
  
  /*  '&' is a synonym for AND, mapped to token AND */
  /*  '~' is a synonym for NOT, mapped to token NOT */
  /* '<>' is a synonym for '#', mapped to token NOTEQUAL */

} /* Token */

/* ---------------------------------------------------------------------------
 * function isValid(token)
 * ---------------------------------------------------------------------------
 * Returns true if token represents a valid token, otherwise false.
 * ------------------------------------------------------------------------ */

public static boolean isValid (Token token);


/* ---------------------------------------------------------------------------
 * function isResword(token)
 * ---------------------------------------------------------------------------
 * Returns true if token represents a reserved word, otherwise false.
 * ------------------------------------------------------------------------ */

public static boolean isResword (Token token);


/* ---------------------------------------------------------------------------
 * function isLiteral(token)
 * ---------------------------------------------------------------------------
 * Returns true if token represents a literal, otherwise false.
 * ------------------------------------------------------------------------ */

public static boolean isLiteral (Token token);


/* ---------------------------------------------------------------------------
 * function isMalformedLiteral(token)
 * ---------------------------------------------------------------------------
 * Returns true if token represents a malformed literal, otherwise false.
 * ------------------------------------------------------------------------ */

public static boolean isMalformedLiteral (Token token);


/* ---------------------------------------------------------------------------
 * function isSpecialSymbol(token)
 * ---------------------------------------------------------------------------
 * Returns true if token represents a special symbol, otherwise false.
 * ------------------------------------------------------------------------ */

public static boolean isSpecialSymbol (Token token);


/* ---------------------------------------------------------------------------
 * function tokenForResword(lexeme, length)
 * ---------------------------------------------------------------------------
 * Tests if the given lexeme represents a reserved word and returns the
 * corresponding token or UNKNOWN if it does not match a reserved word.
 * ------------------------------------------------------------------------ */

public static Token tokenForResword (String lexeme, int length);


/* ---------------------------------------------------------------------------
 * function lexemeForResword(token)
 * ---------------------------------------------------------------------------
 * Returns a string with the lexeme for the reserved word represented by
 * token.  Returns NULL if the token does not represent a reserved word.
 * ------------------------------------------------------------------------ */

public static String lexemeForResword (Token token);


/* ---------------------------------------------------------------------------
 * function lexemeForSpecialSymbol(token)
 * ---------------------------------------------------------------------------
 * Returns a string with the lexeme for the special symbol represented by
 * token.  Returns NULL if the token does not represent a special symbol.
 * ------------------------------------------------------------------------ */

public static String lexemeForSpecialSymbol (Token token);


/* ---------------------------------------------------------------------------
 * function nameForToken(token)
 * ---------------------------------------------------------------------------
 * Returns a string with a human readable name for token.  Returns NULL if
 * token is not a valid token.
 * ------------------------------------------------------------------------ */

public String nameForToken (Token token);


} /* ProtoTerminal */

/* END OF FILE */