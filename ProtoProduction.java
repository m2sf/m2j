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
 * ProtoProduction.java
 *
 * Public interface for FIRST and FOLLOW set lookup.
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


interface ProtoProduction {

/* --------------------------------------------------------------------------
 * type Production
 * --------------------------------------------------------------------------
 * Enumerated production values representing Modula-2 non-terminal symbols.
 * ----------------------------------------------------------------------- */

public enum Production {
  /* Productions with unique FIRST and FOLLOW sets */

  DEFINITION_MODULE,        /* definitionModule */
  IMPORT,                   /* import */
  QUALIFIED_IMPORT,         /* qualifiedImport */
  UNQUALIFIED_IMPORT,       /* unqualifiedImport */
  IDENT_LIST,               /* identList */
  DEFINITION,               /* definition */
  CONST_DEFINITION,         /* constDefinition */
  TYPE_DEFINITION,          /* typeDefinition */
  TYPE,                     /* type */
  DERIVED_OR_SUBRANGE_TYPE, /* derivedOrSubrangeType */
  QUALIDENT,                /* qualident */
  RANGE,                    /* range */
  ENUM_TYPE,                /* enumType */
  SET_TYPE,                 /* setType */
  COUNTABLE_TYPE,           /* countableType */
  ARRAY_TYPE,               /* arrayType */
  EXTENSIBLE_RECORD_TYPE,   /* extensibleRecordType */
  FIELD_LIST_SEQUENCE,      /* fieldListSequence */
  VARIANT_RECORD_TYPE,      /* variantRecordType */
  VARIANT_FIELD_LIST_SEQ,   /* variantFieldListSeq */
  VARIANT_FIELD_LIST,       /* variantFieldList */
  VARIANT_FIELDS,           /* variantFields */
  VARIANT,                  /* variant */
  CASE_LABEL_LIST,          /* caseLabelList */
  CASE_LABELS,              /* caseLabels */
  POINTER_TYPE,             /* pointerType */
  PROCEDURE_TYPE,           /* procedureType */
  SIMPLE_FORMAL_TYPE,       /* simpleFormalType */
  PROCEDURE_HEADER,         /* procedureHeader */
  PROCEDURE_SIGNATURE,      /* procedureSignature */
  SIMPLE_FORMAL_PARAMS,     /* simpleFormalParams */
  IMPLEMENTATION_MODULE,    /* implementationModule */
  PROGRAM_MODULE,           /* programModule */
  MODULE_PRIORITY,          /* modulePriority */
  BLOCK,                    /* block */
  DECLARATION,              /* declaration */
  TYPE_DECLARATION,         /* typeDeclaration */
  VAR_SIZE_RECORD_TYPE,     /* varSizeRecordType */
  VARIABLE_DECLARATION,     /* variableDeclaration */
  PROCEDURE_DECLARATION,    /* procedureDeclaration */
  MODULE_DECLARATION,       /* moduleDeclaration */
  EXPORT,                   /* export */
  STATEMENT_SEQUENCE,       /* statementSequence */
  STATEMENT,                /* statement */
  ASSIGNMENT_OR_PROC_CALL,  /* assignmentOrProcCall */
  ACTUAL_PARAMETERS,        /* actualParameters */
  EXPRESSION_LIST,          /* expressionList */
  RETURN_STATEMENT,         /* returnStatement */
  WITH_STATEMENT,           /* withStatement */
  IF_STATEMENT,             /* ifStatement */
  CASE_STATEMENT,           /* caseStatement */
  CASE,                     /* case */
  LOOP_STATEMENT,           /* loopStatement */
  WHILE_STATEMENT,          /* whileStatement */
  REPEAT_STATEMENT,         /* repeatStatement */
  FOR_STATEMENT,            /* forStatement */
  DESIGNATOR,               /* designator */
  SELECTOR,                 /* selector */
  EXPRESSION,               /* expression */
  SIMPLE_EXPRESSION,        /* simpleExpression */
  TERM,                     /* term */
  SIMPLE_TERM,              /* simpleTerm */
  FACTOR,                   /* factor */
  DESIGNATOR_OR_FUNC_CALL,  /* designatorOrFuncCall */
  SET_VALUE,                /* setValue */
  ELEMENT,                  /* element */
  
  /* Productions with alternative FIRST or FOLLOW sets */
  
  /* Dependent on option --const-parameters */
  FORMAL_TYPE,              /* formalType */
  ATTRIBUTED_FORMAL_TYPE,   /* attributedFormalType */
  FORMAL_PARAM_LIST,        /* formalParamList */
  FORMAL_PARAMS,            /* formalParams */
  ATTRIB_FORMAL_PARAMS,     /* attribFormalParams */
  
  /* Dependent on option --no-variant-records */
  TYPE_DECLARATION_TAIL;    /* typeDeclarationTail */

} /* Production */


/* --------------------------------------------------------------------------
 * method count() -- Returns the number of productions
 * ----------------------------------------------------------------------- */

public int count ();


/* --------------------------------------------------------------------------
 * method isOptionDependent(p)
 * --------------------------------------------------------------------------
 * Returns true if p is dependent on any compiler option, else false.
 * ----------------------------------------------------------------------- */

public boolean isOptionDependent (Production p);


/* --------------------------------------------------------------------------
 * method isConstParamDependent(p)
 * --------------------------------------------------------------------------
 * Returns true if p is dependent on CONST parameter option, else false.
 * ----------------------------------------------------------------------- */

public boolean isConstParamDependent (Production p);


/* --------------------------------------------------------------------------
 * method isVariantRecordDependent(p)
 * --------------------------------------------------------------------------
 * Returns true if p is dependent on variant record type option, else false.
 * ----------------------------------------------------------------------- */

public boolean isVariantRecordDependent (Production p);


/* --------------------------------------------------------------------------
 * method FIRST(p)
 * --------------------------------------------------------------------------
 * Returns a tokenset with the FIRST set of production p.
 * ----------------------------------------------------------------------- */

public EnumSet<ProtoToken.Token> FIRST (Production p);


/* --------------------------------------------------------------------------
 * method FOLLOW(p)
 * --------------------------------------------------------------------------
 * Returns a tokenset with the FOLLOW set of production p.
 * ----------------------------------------------------------------------- */

public EnumSet<ProtoToken.Token> FOLLOW (Production p);


/* --------------------------------------------------------------------------
 * method nameForProduction(p)
 * --------------------------------------------------------------------------
 * Returns a string with a human readable name for production p.
 * ----------------------------------------------------------------------- */

public String nameForProduction (Production p);


} /* ProtoProduction */

/* END OF FILE */