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
 * ProtoAstNodeType.java
 *
 * Public interface for abstract syntax tree node types.
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


/* Face palm alert: Java doesn't allow interfaces on enums -- use abstract. */

abstract public enum ProtoAstNodeType {

/* --------------------------------------------------------------------------
 * type AstNodeType
 * --------------------------------------------------------------------------
 * Enumerated values representing AST node types.
 * ----------------------------------------------------------------------- */

  /* Empty Node Type */
  
  AST_EMPTY,
  
  /* Root Node Type */
  
  AST_ROOT,
  
  /* Definition Module Non-Terminal Node Types */

  AST_DEFMOD,             /* definition module node type */
  AST_IMPLIST,            /* qualified import list node type */
  AST_IMPORT,             /* qualified import list node type */
  AST_UNQIMP,             /* unqualified import list node type */
  AST_DEFLIST,            /* definition list node type */
  
  AST_CONSTDEF,           /* constant definition node type */
  AST_TYPEDEF,            /* type definition node type */
  AST_PROCDEF,            /* procedure definition node type */
  
  AST_SUBR,               /* subrange type node type */
  AST_ENUM,               /* enumeration type node type */
  AST_SET,                /* set type node type */
  AST_ARRAY,              /* array type node type */
  AST_RECORD,             /* simple record type node type */
  AST_POINTER,            /* pointer type node type */
  AST_PROCTYPE,           /* procedure type node type */
  
  AST_EXTREC,             /* extensible record type node type */
  AST_VRNTREC,            /* variant record type node type */
  
  AST_INDEXLIST,          /* array index type list node type */
  
  AST_FIELDLISTSEQ,       /* field list sequence node type */
  AST_FIELDLIST,          /* field list node type */
  AST_VFLISTSEQ,          /* variant field list sequence node type */
  AST_VFLIST,             /* variant field list node type */
  AST_VARIANTLIST,        /* variant list node type */
  AST_VARIANT,            /* variant node type */
  AST_CLABELLIST,         /* case label list node type */
  AST_CLABELS,            /* case labels node type */
  
  AST_FTYPELIST,          /* formal type list node type */
  AST_ARGLIST,            /* variadic parameter list formal type node type */
  AST_OPENARRAY,          /* open array formal type node type */
  AST_CONSTP,             /* CONST formal type node type */
  AST_VARP,               /* VAR formal type node type */
  AST_FPARAMLIST,         /* formal parameter list node type */
  AST_FPARAMS,            /* formal parameters node type */

  /* Implementation/Program Module AST Node Types */

  AST_IMPMOD,             /* implementation/program module node type */
  AST_BLOCK,              /* block node type */
  AST_DECLLIST,           /* declaration list node type */
  
  AST_TYPEDECL,           /* type declaration node type */
  AST_VARDECL,            /* variable declaration node type */
  AST_PROC,               /* procedure declaration node type */
  AST_MODDECL,            /* local module declaration node type */
  
  AST_VSREC,              /* variable size record type node type */
  AST_VSFIELD,            /* variable size field node type */
  
  AST_EXPORT,             /* unqualified export list node type */
  AST_QUALEXP,            /* qualified export list node type */
  
  AST_STMTSEQ,            /* statement sequence node type */
  
  AST_ASSIGN,             /* assignment node type */
  AST_PCALL,              /* procedure call node type */
  AST_RETURN,             /* RETURN statement node type */
  AST_WITH,               /* WITH statement node type */
  AST_IF,                 /* IF statement node type */
  AST_SWITCH,             /* CASE statement node type */
  AST_LOOP,               /* LOOP statement node type */
  AST_WHILE,              /* WHILE statement node type */
  AST_REPEAT,             /* REPEAT statement node type */
  AST_FORTO,              /* FOR TO statement node type */
  AST_EXIT,               /* EXIT statement node type */
  
  AST_ARGS,               /* actual parameter list node type */
  
  AST_ELSIFSEQ,           /* ELSIF branch sequence node type */
  AST_ELSIF,              /* ELSIF branch node type */
  AST_CASELIST,           /* case list node type */
  AST_CASE,               /* case branch node type */
  AST_ELEMLIST,           /* element list node type */
  AST_RANGE,              /* expression range node type */
  
  /* Designator Subnode Types */
  
  AST_FIELD,              /* record field selector node type */
  AST_INDEX,              /* array subscript node type */
  
  /* Expression Node Types */
  
  AST_DESIG,              /* designator node type */
  AST_DEREF,              /* pointer dereference node type */
  
  AST_NEG,                /* arithmetic negation sub-expression node */
  AST_NOT,                /* logical negation sub-expression node */
  
  AST_EQ,                 /* equality sub-expression node */
  AST_NEQ,                /* inequality sub-expression node */
  AST_LT,                 /* less-than sub-expression node */
  AST_LTEQ,               /* less-than-or-equal sub-expression node */
  AST_GT,                 /* greater-than sub-expression node */
  AST_GTEQ,               /* greater-than-or-equal sub-expression node */
  AST_IN,                 /* set membership sub-expression node */
  AST_PLUS,               /* plus sub-expression node */
  AST_MINUS,              /* minus sub-expression node */
  AST_OR,                 /* logical disjunction sub-expression node */
  AST_ASTERISK,           /* asterisk sub-expression node */
  AST_SOLIDUS,            /* solidus sub-expression node */
  AST_DIV,                /* euclidean division sub-expression node */
  AST_MOD,                /* modulus sub-expression node */
  AST_AND,                /* logical conjunction expression node */
  
  AST_FCALL,              /* function call node */
  AST_SETVAL,             /* set value node */
  
  /* Identifier Node Types */
  
  AST_IDENT,              /* identifier node type */
  AST_QUALIDENT,          /* qualified identifier node type */
  
  /* Literal Value Node Types */
  
  AST_INTVAL,             /* whole number value node */
  AST_REALVAL,            /* real number value node */
  AST_CHRVAL,             /* character code value node */
  AST_QUOTEDVAL,          /* quoted literal value node */
  
  AST_IDENTLIST,          /* identifier list node type */
  
  /* Compilation Parameter Node Types */
  
  AST_FILENAME,           /* filename node type */
  AST_OPTIONS,            /* compiler option list node type */
  
  /* Invalid Node Type */
  
  AST_INVALID;            /* for use as failure indicator */


/* --------------------------------------------------------------------------
 * AST node type groupings.
 * --------------------------------------------------------------------------
 * first valid node type : AST_EMPTY
 * last valid node type : AST_QUOTEDVAL
 *
 * first non-terminal node type : AST_EMPTY
 * last non-terminal node type : AST_SETVAL
 *
 * first terminal node type :  AST_INTVAL
 * last terminal node type : AST_OPTIONS
 *
 * first definition node type : AST_CONSTDEF
 * last definition node type : AST_PROCDEF
 *
 * first type definition node type : AST_SUBR
 * last type definition node type : AST_VRNTREC
 *
 * first field type node type : AST_SUBR
 * last field type node type : AST_PROCTYPE
 *
 * first declaration node type : AST_TYPEDECL
 * last declaration node type : AST_MODDECL
 *
 * first statement node type : AST_ASSIGN
 * last statement node type : AST_EXIT
 *
 * first expression node type : AST_DESIG
 * last expression node type : AST_QUOTEDVAL
 *
 * first literal node type : AST_INTVAL
 * last literal node type : AST_QUOTEDVAL
 * ----------------------------------------------------------------------- */


/* --------------------------------------------------------------------------
 * method isValid(nodeType)
 * --------------------------------------------------------------------------
 * Returns true if nodeType is a valid node type, otherwise false.
 * ----------------------------------------------------------------------- */

abstract public boolean isValid(ProtoAstNodeType nodeType);


/* --------------------------------------------------------------------------
 * method isNonterminalType(nodeType)
 * --------------------------------------------------------------------------
 * Returns true if node_type is a nonterminal node type, otherwise false.
 * ----------------------------------------------------------------------- */

abstract public boolean isNonterminalType (ProtoAstNodeType nodeType);


/* --------------------------------------------------------------------------
 * method isTerminalType(nodeType)
 * --------------------------------------------------------------------------
 * Returns true if node_type is a terminal node type, otherwise false.
 * ----------------------------------------------------------------------- */

abstract public boolean isTerminalType (ProtoAstNodeType nodeType);


/* --------------------------------------------------------------------------
 * method isListType(nodeType)
 * --------------------------------------------------------------------------
 * Returns true if node_type is a list node type, otherwise false.
 * ----------------------------------------------------------------------- */

abstract public boolean isListType (ProtoAstNodeType nodeType);


/* --------------------------------------------------------------------------
 * method isLegalSubnodeCount(nodeType, subnodeCount)
 * --------------------------------------------------------------------------
 * Returns true if the given subnode count is a legal value for the given
 * node type, otherwise false.
 * ----------------------------------------------------------------------- */

abstract public boolean isLegalSubnodeCount
  (ProtoAstNodeType nodeType, int SubnodeCount);


/* --------------------------------------------------------------------------
 * method isLegalSubnodeType(inNodeType, subnodeType, index)
 * --------------------------------------------------------------------------
 * Returns true if the given subnode type is a legal node type for the given
 * index in a node of the given subnode type, otherwise false.
 * ----------------------------------------------------------------------- */

abstract public boolean isLegalSubnodeType
  (ProtoAstNodeType inNodeType, ProtoAstNodeType subnodeType, int index);


/* --------------------------------------------------------------------------
 * method nameForNodeType(nodeType)
 * --------------------------------------------------------------------------
 * Returns an immutable pointer to a NUL terminated character string with
 * a human readable name for node_type, or NULL if node_type is invalid.
 * ----------------------------------------------------------------------- */

abstract public String nameForNodeType (ProtoAstNodeType nodeType);


} /* ProtoNodeType */

/* END OF FILE */