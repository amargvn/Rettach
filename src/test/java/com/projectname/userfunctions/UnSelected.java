package com.projectname.userfunctions;

import com.projectname.base.ActionElements;
import com.projectname.utils.TestConstants;
import org.openqa.selenium.WebElement;

public class UnSelected
{
  public boolean unSelected(String keyword, String keywordtype, String object, String objectProp)
    throws Exception
  {
    boolean isSelected = false;
    ActionElements acElem = new ActionElements();
    TestConstants tc = acElem.actionElement(keyword, keywordtype, object, 
      objectProp);
    WebElement wb = tc.welement;
    if (!wb.isSelected()) {
      isSelected = true;
    }
    return isSelected;
  }
}
