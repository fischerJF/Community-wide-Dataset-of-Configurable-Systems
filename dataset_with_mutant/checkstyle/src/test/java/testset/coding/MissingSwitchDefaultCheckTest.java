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

package testset.coding;

import static checks.coding.MissingSwitchDefaultCheck.MSG_KEY;

import org.junit.Assert;
import org.junit.Test;

import checks.coding.MissingSwitchDefaultCheck;
import checkstyle.DefaultConfiguration;
import testset.checkstyle.AbstractModuleTestSupport;

public class MissingSwitchDefaultCheckTest
    extends AbstractModuleTestSupport {

    @Override
    protected String getPackageLocation() {
        return "com/puppycrawl/tools/checkstyle/checks/coding/missingswitchdefault";
    }

    @Test
    public void testMissingSwitchDefault() throws Exception {
        final DefaultConfiguration checkConfig =
                createModuleConfig(MissingSwitchDefaultCheck.class);
        final String[] expected = {
            "17: " + getCheckMessage(MSG_KEY, "default"),
        };
        verify(
            checkConfig,
            getPath("InputMissingSwitchDefault.java"),
            expected);
    }

    @Test
    public void testTokensNotNull() {
        final MissingSwitchDefaultCheck check = new MissingSwitchDefaultCheck();
        Assert.assertNotNull("Acceptable tokens should not be null", check.getAcceptableTokens());
        Assert.assertNotNull("Default tokens should not be null", check.getDefaultTokens());
        Assert.assertNotNull("Required tokens should not be null", check.getRequiredTokens());
    }

}
