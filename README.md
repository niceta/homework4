# homework4
tests-name:
{TestKatalon}
{TestXpath  } old
{TestCss    }

MainTest
TinkoffMobileTest

Launch from firefox:

-Dtest=test-name -Dbrowser=firefox verify

from chrome:
-Dtest=test-name -Dbrowser=chrome verify

default launch = chrome:
-Dtest=test-name verify
