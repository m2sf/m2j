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
 * ProtoArgumentLexer.java
 *
 * Public interface for command line argument lexer.
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

interface ProtoArgumentLexer {

/* ---------------------------------------------------------------------------
 * type ArgumentToken
 * ---------------------------------------------------------------------------
 * Enumerated token values representing command line arguments.
 * ------------------------------------------------------------------------ */

public enum ArgumentToken {

  UNKNOWN,

  /* information options */

  HELP,                      /* --help, -h */
  VERSION,                   /* --version, -V */
  LICENSE,                   /* --license */

  /* dialect options */

  PIM3,                      /* --pim3 */
  PIM4,                      /* --pim4 */
  EXT,                       /* --ext */

  /* dialect qualifier options */

  SAFER,                     /* --safer */
  COMPLIANT,                 /* --compliant */

  /* singe product options */

  SYNTAX_ONLY,               /* --syntax-only */
  AST_ONLY,                  /* --ast-only */
  GRAPH_ONLY,                /* --graph-only */
  XLAT_ONLY,                 /* --xlat-only */
  OBJ_ONLY,                  /* --obj-only */

  /* multiple product options */

  AST,                       /* --ast */
  NO_AST,                    /* --no-ast */
  GRAPH,                     /* --graph */
  NO_GRAPH,                  /* --no-graph */
  XLAT,                      /* --xlat */
  NO_XLAT,                   /* --no-xlat */
  OBJ,                       /* --obj */
  NO_OBJ,                    /* --no-obj */

  /* identifier options */

  USE_IDENTIFIERS_VERBATIM,  /* --use-identifiers-verbatim */
  TRANSLITERATE_IDENTIFIERS, /* --transliterate-identifiers */

  /* comment options */

  PRESERVE_COMMENTS,         /* --preserve-comments */
  STRIP_COMMENTS,            /* --strip-comments */

  /* capability options */

  SYNONYMS,                  /* --synonyms */
  NO_SYNONYMS,               /* --no-synonyms */
  OCTAL_LITERALS,            /* --octal-literals */
  NO_OCTAL_LITERALS,         /* --no-octal-literals */
  EXPLICIT_CAST,             /* --explicit-cast */
  NO_EXPLICIT_CAST,          /* --no-explicit-cast */
  COROUTINES,                /* --coroutines */
  NO_COROUTINES,             /* --no-coroutines */
  VARIANT_RECORDS,           /* --variant-records */
  NO_VARIANT_RECORDS,        /* --no-variant-records */
  LOCAL_MODULES,ES,          /* --local-modules */
  NO_LOCAL_MODULES,          /* --no-local-modules */
  LOWLINE_IDENTIFIERS,       /* --lowline-identifiers */
  NO_LOWLINE_IDENTIFIERS,    /* --no-lowline-identifiers */
  TO_DO_STATEMENT,           /* --to-do-statement */
  NO_TO_DO_STATEMENT,        /* --no-to-do-statement */

  /* source file argument */

  SOURCE_FILE,

  /* diagnostic options */

  VERBOSE,                   /* --verbose, -v */
  LEXER_DEBUG,               /* --lexer-debug */
  PARSER_DEBUG,              /* --parser-debug */
  SHOW_SETTINGS,             /* --show-settings */
  ERRANT_SEMICOLONS,         /* --errant-semicolons */

  /* end of input sentinel */

  END_OF_INPUT

} /* ArgumentToken */


/* ---------------------------------------------------------------------------
 * method initWithArgs(args)
 * ---------------------------------------------------------------------------
 * Initialises the argument lexer class with the given arguments.
 * ------------------------------------------------------------------------ */

// public static void initWithArgs (string[] args);


/* ---------------------------------------------------------------------------
 * method nextToken()
 * ---------------------------------------------------------------------------
 * Reads and consumes the next commmand line argument and returns its token.
 * ------------------------------------------------------------------------ */

// public static ArgumentToken nextToken();


/* ---------------------------------------------------------------------------
 * method lastArg()
 * ---------------------------------------------------------------------------
 * Returns the argument string of the last consumed argument or null if the
 * end of input token has been returned by a prior call to NextToken().
 * ------------------------------------------------------------------------ */

// public static string lastArg ();


/* ---------------------------------------------------------------------------
 * method isInfoRequest(sym)
 * ---------------------------------------------------------------------------
 * Returns true if sym is an information request
 * ------------------------------------------------------------------------ */

// public static bool isInfoRequest (ArgumentToken sym);


/* ---------------------------------------------------------------------------
 * method isCompilationRequest(sym)
 * ---------------------------------------------------------------------------
 * Returns true if sym is a compilation request
 * ------------------------------------------------------------------------ */

// public static bool isCompilationRequest (ArgumentToken sym);


/* ---------------------------------------------------------------------------
 * method isDialectOption(sym)
 * ---------------------------------------------------------------------------
 * Returns true if sym is a dialect option
 * ------------------------------------------------------------------------ */

// public static bool isDialectOption (ArgumentToken sym);


/* ---------------------------------------------------------------------------
 * method isDialectQualifierOption(sym)
 * ---------------------------------------------------------------------------
 * Returns true if sym is a dialect qualifier option
 * ------------------------------------------------------------------------ */

// public static bool isDialectQualifierOption (ArgumentToken sym);


/* ---------------------------------------------------------------------------
 * method isProductOption(sym)
 * ---------------------------------------------------------------------------
 * Returns true if sym is a product option
 * ------------------------------------------------------------------------ */

// public static bool isProductOption (ArgumentToken sym);


/* ---------------------------------------------------------------------------
 * method isSingleProductOption(sym)
 * ---------------------------------------------------------------------------
 * Returns true if sym is a single product option
 * ------------------------------------------------------------------------ */

// public static bool isSingleProductOption (ArgumentToken sym);


/* ---------------------------------------------------------------------------
 * method isMultipleProductsOption(sym)
 * ---------------------------------------------------------------------------
 * Returns true if sym is a multiple product option
 * ------------------------------------------------------------------------ */

// public static bool isMultipleProductsOption (ArgumentToken sym);


/* ---------------------------------------------------------------------------
 * method isIdentifierOption(sym)
 * ---------------------------------------------------------------------------
 * Returns true if sym is an identifier option
 * ------------------------------------------------------------------------ */

// public static bool isIdentifierOption (ArgumentToken sym);


/* ---------------------------------------------------------------------------
 * method isCommentOption(sym)
 * ---------------------------------------------------------------------------
 * Returns true if sym is a comment option
 * ------------------------------------------------------------------------ */

// public static bool isCommentOption (ArgumentToken sym);


/* ---------------------------------------------------------------------------
 * method isCapabilityOption(sym)
 * ---------------------------------------------------------------------------
 * Returns true if sym is a capability option
 * ------------------------------------------------------------------------ */

// public static bool isCapabilityOption (ArgumentToken sym);


/* ---------------------------------------------------------------------------
 * method isDiagnosticsOption(sym)
 * ---------------------------------------------------------------------------
 * Returns true if sym is a diagnostic option
 * ------------------------------------------------------------------------ */

// public static bool isDiagnosticsOption (ArgumentToken sym);


} /* ProtoArgumentLexer */

/* END OF FILE */