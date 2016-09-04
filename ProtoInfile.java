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
 * ProtoInfile.java
 *
 * Public interface for M2J source file reader.
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

interface ProtoInfile {

/* ---------------------------------------------------------------------------
 * File size, line and column counter limits
 * ------------------------------------------------------------------------ */

public static char EOT = '\u04'; /* indicating EOF */

public static int INFILE_MAX_SIZE = 260000; /* chars */

public static int INFILE_MAX_LINES = 64000; /* lines */

public static int INFILE_MAX_COLUMNS = 250; /* columns */


/* ---------------------------------------------------------------------------
 * Status codes
 * ------------------------------------------------------------------------ */

public enum Status {
  INFILE_STATUS_SUCCESS,
  INFILE_STATUS_INVALID_REFERENCE,
  INFILE_STATUS_FILE_NOT_FOUND,
  INFILE_STATUS_FILE_ACCESS_DENIED,
  INFILE_STATUS_ALLOCATION_FAILED,
  INFILE_STATUS_FILE_EMPTY,
  INFILE_STATUS_ATTEMPT_TO_READ_PAST_EOF,
  INFILE_STATUS_IO_SUBSYSTEM_ERROR
} /* Status */


/* ---------------------------------------------------------------------------
 * constructor open(filename)
 * ---------------------------------------------------------------------------
 * Opens the given file, creates a new infile instance, associates the file
 * with the newly created instance and returns a result pair with the infile
 * reference and a status code.
 *
 * pre-conditions:
 * o  filename must reference an existing, accessible file.
 *
 * post-conditions:
 * o  new infile created and returned 
 * o  line and column counters of the newly created infile are set to 1
 * o  INFILE_STATUS_SUCCESS is returned in status
 *
 * error-conditions:
 * o  if the file represented by filename cannot be found
 *    infile is null, status is INFILE_STATUS_FILE_NOT_FOUND
 * o  if the file represented by filename cannot be accessed
 *    infile is null, status is INFILE_STATUS_FILE_ACCESS_DENIED
 * ------------------------------------------------------------------------ */

public Result<ProtoInfile, Status> open (String filename);


/* ---------------------------------------------------------------------------
 * method readChar()
 * ---------------------------------------------------------------------------
 * Reads the lookahead character from infile, advancing the current reading
 * position, updating line and column counter and returns its character code.
 * Returns EOT if the lookahead character lies beyond the end of infile.
 *
 * pre-conditions:
 * o  infile must be open
 *
 * post-conditions:
 * o  character code of lookahead character or EOT is returned
 * o  current reading position and line and column counters are updated
 * o  infile status is set to INFILE_STATUS_SUCCESS
 *
 * error-conditions:
 * o  none
 * ------------------------------------------------------------------------ */

public char readChar ();


/* ---------------------------------------------------------------------------
 * method markLexeme()
 * ---------------------------------------------------------------------------
 * Marks the current lookahead character as the start of a lexeme.
 *
 * pre-conditions:
 * o  infile must be open
 *
 * post-conditions:
 * o  position of lookahead character is stored internally
 *
 * error-conditions:
 * o  none
 * ------------------------------------------------------------------------ */

public void markLexeme ();


/* ---------------------------------------------------------------------------
 * method readMarkedLexeme()
 * ---------------------------------------------------------------------------
 * Returns a string object with the character sequence starting with the
 * character that has been marked using method markLexeme() and ending
 * with the last consumed character.  Returns null if no marker has
 * been set or if the marked character has not been consumed yet.
 *
 * pre-conditions:
 * o  infile must be open
 * o  lexeme must have been marked using method markLexeme()
 * o  character at the marked position must have been consumed
 *
 * post-conditions:
 * o  marked position is cleared
 * o  string with lexeme is returned
 *
 * error-conditions:
 * o  if no marker has been set or marked character has not been consumed,
 *    no operation is carried out and null is returned
 * ------------------------------------------------------------------------ */

public String readMarkedLexeme ();


/* ---------------------------------------------------------------------------
 * method sourceForLine(line)
 * ---------------------------------------------------------------------------
 * Returns a string object with the source of the given line number.
 *
 * pre-conditions:
 * o  infile must be open
 * o  parameter line must be greater than zero
 *
 * post-conditions:
 * o  string with source of line is returned
 *
 * error-conditions:
 * o  line is negative or zero upon entry,
 *    no operation is carried out and null is returned
 * ------------------------------------------------------------------------ */

public String sourceForLine (int line);


/* ---------------------------------------------------------------------------
 * method consumeChar()
 * ---------------------------------------------------------------------------
 * Consumes the current lookahead character, advancing the current reading
 * position, updating line and column counter and returns the character code
 * of the new lookahead character that follows the consumed character.
 * Returns EOF if the lookahead character lies beyond the end of infile.
 *
 * pre-conditions:
 * o  infile must be open
 *
 * post-conditions:
 * o  character code of lookahead character or EOT is returned
 * o  current reading position and line and column counters are updated
 * o  file status is set to INFILE_STATUS_SUCCESS
 *
 * error-conditions:
 * o  none
 * ------------------------------------------------------------------------ */

public int consumeChar ();


/* ---------------------------------------------------------------------------
 * method nextChar()
 * ---------------------------------------------------------------------------
 * Reads the lookahead character from infile without advancing the current
 * reading position and returns its character code.  Returns EOF if the
 * lookahead character lies beyond the end of infile.
 *
 * pre-conditions:
 * o  infile must be open
 *
 * post-conditions:
 * o  character code of lookahead character or EOT is returned
 * o  current reading position and line and column counters are NOT updated
 * o  file status is set to INFILE_STATUS_SUCCESS
 *
 * error-conditions:
 * o  none
 * ------------------------------------------------------------------------ */

public int nextChar ();


/* ---------------------------------------------------------------------------
 * method la2Char()
 * ---------------------------------------------------------------------------
 * Reads the second lookahead character from infile without advancing the
 * current reading position and returns its character code.  Returns EOF
 * if the second lookahead character lies beyond the end of infile.
 *
 * pre-conditions:
 * o  infile must be open
 *
 * post-conditions:
 * o  character code of second lookahead character or EOT is returned
 * o  current reading position and line and column counters are NOT updated
 * o  file status is set to INFILE_STATUS_SUCCESS
 *
 * error-conditions:
 * o  none
 * ------------------------------------------------------------------------ */

public int la2Char ();


/* ---------------------------------------------------------------------------
 * method filename()
 * ---------------------------------------------------------------------------
 * Returns the filename associated with infile.
 * ------------------------------------------------------------------------ */

public String filename ();


/* ---------------------------------------------------------------------------
 * method status()
 * ---------------------------------------------------------------------------
 * Returns the status of the last operation on infile.
 * ------------------------------------------------------------------------ */

public Status status ();


/* ---------------------------------------------------------------------------
 * method eof()
 * ---------------------------------------------------------------------------
 * Returns true if the current reading position of infile lies beyond the end
 * of the associated file, returns false otherwise.
 * ------------------------------------------------------------------------ */

public boolean eof ();


/* ---------------------------------------------------------------------------
 * method currentLine()
 * ---------------------------------------------------------------------------
 * Returns the current line counter of infile.
 * ------------------------------------------------------------------------ */

public int currentLine ();


/* ---------------------------------------------------------------------------
 * method currentColumn()
 * ---------------------------------------------------------------------------
 * Returns the current column counter of infile.
 * ------------------------------------------------------------------------ */

public int currentColumn ();


/* ---------------------------------------------------------------------------
 * method close()
 * ---------------------------------------------------------------------------
 * Closes the file associated with handle file, deallocates its file object
 * and returns a status code.
 *
 * pre-conditions:
 * o  infile must be open
 *
 * post-conditions:
 * o  associated file is closed
 * o  INFILE_STATUS_SUCCESS is passed back in status
 *
 * error-conditions:
 * o  none
 * ------------------------------------------------------------------------ */

public Status close ();


} /* ProtoInfile */

/* END OF FILE */