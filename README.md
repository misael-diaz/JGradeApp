# JGradeApp

## Compile

Instructions to compile the application in Mac OS X and GNU/Linux.

First create the directory to host the classes:

```sh
mkdir bin
```

Note that the Java compiler won't create it for you so this is a mandatory step.

Then issue the following instructions to the Java compiler:

```sh
javac -d bin ./src/com/midiaz/*/*.java ./src/com/midiaz/Grade.java
```

Upon a successful build all the classes are going to be located in the binaries directory `bin`.

## Archive

To package the application into a standalone Java application you will need to archive it.

To create the Java Archive (JAR) issue the following command:

```sh
jar --create --file JGradeApp.jar --main-class com.midiaz.Grade -C bin com
```

Upon completion you should see `JGradeApp.jar` at the top level of the repository.

## Execute

To execute the standalone Java application pass the following instructions to the
Java launcher:

```sh
java -jar JGradeApp.jar
```
