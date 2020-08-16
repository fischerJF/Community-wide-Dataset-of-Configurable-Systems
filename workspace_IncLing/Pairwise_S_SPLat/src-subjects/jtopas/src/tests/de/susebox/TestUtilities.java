/*
 * TestUtilities.java: utility methods for JUnit tests
 *
 * Copyright (C) 2002 Heiko Blau
 *
 * This file belongs to the Susebox Java core test suite.
 * The Susebox Java core test suite is free software; you can redistribute it 
 * and/or modify it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation; either version 2.1 of the License, 
 * or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
 * FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along 
 * with the Susebox Java core test suite. If not, write to the
 *
 *   Free Software Foundation, Inc.
 *   59 Temple Place, Suite 330, 
 *   Boston, MA 02111-1307 
 *   USA
 *
 * or check the Internet: http://www.fsf.org
 *
 * The Susebox Java core test suite uses the test framework JUnit by Kent Beck 
 * and Erich Gamma. You should have received a copy of their JUnit licence 
 * agreement along with the Susebox Java test suite.
 *
 * We do NOT provide the JUnit archive junit.jar nessecary to compile and run 
 * our tests, since we assume, that You  either have it already or would like 
 * to get the current release Yourself. 
 * Please visit either:
 *   http://sourceforge.net/projects/junit
 * or
 *   http://junit.org
 * to obtain JUnit.
 *
 * Contact:
 *   email: heiko@susebox.de 
 */

package tests.de.susebox;

import de.susebox.java.lang.ThrowableList;

//-----------------------------------------------------------------------------
// Imports
//

//-----------------------------------------------------------------------------
// Class TestUtilities
//

/**<p>
 * This class is a generic test for implementations of the {@link ThrowableList}
 * interface. Instead of testing each implementation by its own, the common
 * pattern of all these exceptions is used to define tests on all of them.
 *</p>
 *
 * @see     ThrowableList
 * @author  Heiko Blau
 */
public class TestUtilities {
  
  /**
   * The method looks for an explicitely given TestRunner type in the first
   * element of the given argument array. Valid values are:
   *<ul><li>
   *  swingui:  use the class {@link junit.swingui.TestRunner}
   *</li><li>
   *  awtui:  use the class {@link junit.awtui.TestRunner}
   *</li><li>
   *  textui:  use the class {@link junit.textui.TestRunner}
   *</li></ul>
   * If no type is given the method will use an {@link junit.textui.TestRunner}
   * instance.
   *
   * @param tests an array containing the test classes to run
   * @param args  the command line arguments
   */
//  public static void run(String[] tests, String[] args) {
//    if (args != null && args.length > 0) {
//      if (args[0].equals("swingui")) {
////        new junit.swingui.TestRunner().main(tests);
//      } else if (args[0].equals("awtui")) {
////        new junit.awtui.TestRunner().main(tests);
//      } else {
//        new junit.textui.TestRunner().main(tests);
//      }
//    } else {
//      new junit.textui.TestRunner().main(tests);
//    }
//  }
}  
