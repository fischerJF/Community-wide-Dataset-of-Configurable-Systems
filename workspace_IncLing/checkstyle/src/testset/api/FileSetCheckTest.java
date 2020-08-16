////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code for adherence to a set of rules.
// Copyright (C) 2001-2018 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
////////////////////////////////////////////////////////////////////////////////

package testset.api;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Test;

import api.AbstractFileSetCheck;
import api.Configuration;
import api.FileContents;
import api.FileText;
import testset.checkstyle.AbstractModuleTestSupport;
import utils.CommonUtil;
/*
import com.puppycrawl.tools.checkstyle.AbstractModuleTestSupport;
import com.puppycrawl.tools.checkstyle.utils.CommonUtil;
*/
public class FileSetCheckTest
    extends AbstractModuleTestSupport {

    @Override
    protected String getPackageLocation() {
        return "testset/api/fileset";
    }

//    @Test
//    public void testTranslation() throws Exception {
//        final Configuration checkConfig =
//            createModuleConfig(TestFileSetCheck.class);
//        final String[] expected = CommonUtil.EMPTY_STRING_ARRAY;
//        verify(checkConfig, getPath("InputFileSetIllegalTokens.java"), expected);
//
//        assertTrue("destroy() not called by Checker", TestFileSetCheck.isDestroyed());
//    }
    
//    @Test
//    public void testProcessCallsFinishBeforeCallingDestroy() throws Exception {
//        final Configuration checkConfig =
//            createModuleConfig(TestFileSetCheck.class);
//        final String[] expected = CommonUtil.EMPTY_STRING_ARRAY;
//
//        verify(checkConfig, getPath("InputFileSetIllegalTokens.java"), expected);
//
//        assertTrue("FileContent should be available during finishProcessing() call",
//                TestFileSetCheck.isFileContentAvailable());
//    }
    private static class TestFileSetCheck extends AbstractFileSetCheck {

        private static boolean destroyed;
        private static boolean fileContentAvailable;
        private static FileContents contents;

        @Override
        public void destroy() {
            destroyed = true;
        }

        public static boolean isDestroyed() {
            return destroyed;
        }

        public static boolean isFileContentAvailable() {
            return fileContentAvailable;
        }

        protected void processFiltered(File file, FileText fileText) {
            contents = new FileContents(fileText);
        }

        @Override
        public void finishProcessing() {
            fileContentAvailable = contents != null;
        }

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		protected void processFiltered(File file, List<String> lines) {
			// TODO Auto-generated method stub
			
		}

    }

}
