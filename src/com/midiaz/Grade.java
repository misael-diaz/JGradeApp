package com.midiaz;

import java.util.Scanner;
import java.util.ArrayList;
import com.midiaz.menu.Menu;

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

  public static void main (String args[])
  {
    Grade grade = new Grade(new Menu(new Scanner(System.in), new ArrayList<Integer>()));
    grade.prompt();
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

