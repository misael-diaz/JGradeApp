package com.midiaz;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.InputStream;
import com.midiaz.menu.Menu;
import com.midiaz.util.MathGrader;
import com.midiaz.util.SpanishGrader;
import com.midiaz.util.EnglishGrader;

public class Grade
{
  private Menu menu;

  Grade (Menu menu)
  {
    this.menu = menu;
  }

  public void prompt ()
  {
    this.menu.prompt();
  }

  public void grade ()
  {
    this.menu.grade();
  }

  public void report ()
  {
    this.menu.report();
  }

  public static void main (String args[])
  {
    InputStream in = System.in;
    Grade grade = new Grade(new Menu(new Scanner(in), new ArrayList<Integer>(),
			    new MathGrader(new Scanner(in), new ArrayList<Double>()),
			    new SpanishGrader(new Scanner(in), new ArrayList<Double>()),
			    new EnglishGrader(new Scanner(in), new ArrayList<Double>())));
    grade.prompt();
    grade.grade();
    grade.report();
  }
}

/*

   JGradeApp					April 23, 2024

source: Grade.java
author: misael-diaz

Copyright (c) 2024 Misael Díaz-Maldonado
This file is released under the GNU General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

*/

