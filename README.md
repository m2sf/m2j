# m2j

[![Join the chat at https://gitter.im/modula-2/Lobby](https://badges.gitter.im/modula-2/Lobby.svg)](https://gitter.im/modula-2/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Modula-2 to Java Translator and Compiler

M2J is a multi-dialect Modula-2 to Java translator and via-Java compiler.
It supports the dialects described in the 3rd and 4th editions of Niklaus
Wirth's book "Programming in Modula-2" (PIM) published by Springer Verlag,
and an extended mode with select features from the revised language by
B.Kowarsch and R.Sutcliffe "Modula-2 Revision 2010" (M2R10).

In translator mode, M2J translates Modula-2 source to Java source files.
In compiler mode, M2J compiles Modula-2 source via Java source files to
Java .class files using the host system's resident Java compiler.

PIM dialects are supported to allow compilation of program examples from
Modula-2 literature which is largely based on PIM. Extended mode is
supported to facilitate bootstrapping of a full implementation of
M2R10 targeting the JVM.

For more information please visit the project wiki at the URL:
https://github.com/m2sf/m2j/wiki

+++
