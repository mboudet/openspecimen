/**
 * <p>Title: Utility Class>
 * <p>Description:  Utility Class contain general methods used through out the application. </p>
 * Copyright:    Copyright (c) year
 * Company: Washington University, School of Medicine, St. Louis.
 * @author Gautam Shetty
 * @version 1.00
 */

package edu.wustl.catissuecore.util.global;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.wustl.catissuecore.domain.CellSpecimen;
import edu.wustl.catissuecore.domain.CellSpecimenRequirement;
import edu.wustl.catissuecore.domain.CheckInCheckOutEventParameter;
import edu.wustl.catissuecore.domain.CollectionEventParameters;
import edu.wustl.catissuecore.domain.EmbeddedEventParameters;
import edu.wustl.catissuecore.domain.FixedEventParameters;
import edu.wustl.catissuecore.domain.FluidSpecimen;
import edu.wustl.catissuecore.domain.FluidSpecimenRequirement;
import edu.wustl.catissuecore.domain.FrozenEventParameters;
import edu.wustl.catissuecore.domain.MolecularSpecimen;
import edu.wustl.catissuecore.domain.MolecularSpecimenRequirement;
import edu.wustl.catissuecore.domain.ReceivedEventParameters;
import edu.wustl.catissuecore.domain.Specimen;
import edu.wustl.catissuecore.domain.SpecimenEventParameters;
import edu.wustl.catissuecore.domain.SpecimenRequirement;
import edu.wustl.catissuecore.domain.TissueSpecimen;
import edu.wustl.catissuecore.domain.TissueSpecimenRequirement;
import edu.wustl.catissuecore.domain.TissueSpecimenReviewEventParameters;
import edu.wustl.catissuecore.domain.TransferEventParameters;
import edu.wustl.common.beans.NameValueBean;
import edu.wustl.common.cde.CDE;
import edu.wustl.common.cde.CDEManager;
import edu.wustl.common.cde.PermissibleValue;
import edu.wustl.common.util.dbManager.HibernateMetaData;
import edu.wustl.common.util.logger.Logger;

/**
 * Utility Class contain general methods used through out the application.
 * @author kapil_kaveeshwar
 */
public class Utility extends edu.wustl.common.util.Utility
{
    
    /**
     * @param selectedMenuID Menu that is clicked
     * @param currentMenuID Menu that is being checked
     * @param normalMenuClass style class for normal menu
     * @param selectedMenuClass style class for selected menu 
     * @param menuHoverClass  style class for hover effect
     * @return The String generated for the TD tag. Creates the selected menu or normal menu.
     */
    public static String setSelectedMenuItem(int selectedMenuID, int currentMenuID, String normalMenuClass , String selectedMenuClass , String menuHoverClass)
    {
    	String returnStr = "";
    	if(selectedMenuID == currentMenuID)
    	{
    		returnStr ="<td class=\"" + selectedMenuClass + "\" onmouseover=\"changeMenuStyle(this,\'" + selectedMenuClass + "\')\" onmouseout=\"changeMenuStyle(this,\'" + selectedMenuClass + "\')\">";
    	}
    	else
    	{
    		returnStr ="<td class=\"" + normalMenuClass + "\" onmouseover=\"changeMenuStyle(this,\'" + menuHoverClass + "\')\" onmouseout=\"changeMenuStyle(this,\'" + normalMenuClass + "\')\">";
    	}
    	 
    	return returnStr;
    }
    
	/**
	 * @param str String to be converted to Proper case.
	 * @return The String in Proper case.
	 */
	public static String initCap(String str)
	{
		String retStr="";
		if(str!=null && str.trim().length() >0 )
		{
			String firstCharacter = str.substring(0,1 );
			String otherData = str.substring(1 );
			retStr = firstCharacter.toUpperCase()+otherData.toLowerCase();
		}
		else
		{
			Logger.out.debug("Utility.initCap : - String provided is either empty or null" + str );
		}
		
		return retStr;
	}
	
	public static Map getSpecimenTypeMap()
	{
		CDE specimenClassCDE = CDEManager.getCDEManager().getCDE(Constants.CDE_NAME_SPECIMEN_CLASS);
    	Set setPV = specimenClassCDE.getPermissibleValues();
    	Iterator itr = setPV.iterator();
    	
		List specimenClassList = CDEManager.getCDEManager().getPermissibleValueList(Constants.CDE_NAME_SPECIMEN_CLASS,null);
		Map subTypeMap = new HashMap();
    	specimenClassList.add(new NameValueBean(Constants.SELECT_OPTION,"-1"));
		
		while(itr.hasNext())
		{
			List innerList =  new ArrayList();
			Object obj = itr.next();
			PermissibleValue pv = (PermissibleValue)obj;
			String tmpStr = pv.getValue();
			specimenClassList.add(new NameValueBean(tmpStr,tmpStr));
			
			Set list1 = pv.getSubPermissibleValues();
			Iterator itr1 = list1.iterator();
			innerList.add(new NameValueBean(Constants.SELECT_OPTION,"-1"));
			
			while(itr1.hasNext())
			{
				Object obj1 = itr1.next();
				PermissibleValue pv1 = (PermissibleValue)obj1;
				//Setting Specimen Type
				String tmpInnerStr = pv1.getValue(); 
				innerList.add(new NameValueBean( tmpInnerStr,tmpInnerStr));  
			}
			
			subTypeMap.put(pv.getValue(),innerList);
		}
		
		return subTypeMap;
	}
	
	public static List getSpecimenTypes(String specimenClass)
	{
		Map specimenTypeMap = getSpecimenTypeMap();
		List typeList = (List)specimenTypeMap.get(specimenClass);
		
		return typeList;
	}
	
	public static String getSpecimenClassName(SpecimenRequirement requirement)
	{
		if(requirement instanceof CellSpecimenRequirement)
		{
			return Constants.CELL;
		}
		else if(requirement instanceof MolecularSpecimenRequirement)
		{
			return Constants.MOLECULAR;
		}
		else if(requirement instanceof FluidSpecimenRequirement)
		{
			return Constants.FLUID;
		}
		else if(requirement instanceof TissueSpecimenRequirement)
		{
			return Constants.TISSUE;
		}
		
		return null;
	}
	
	public static String getSpecimenClassName(Specimen specimen)
	{
		if(specimen instanceof CellSpecimen)
		{
			return Constants.CELL;
		}
		else if(specimen instanceof MolecularSpecimen)
		{
			return Constants.MOLECULAR;
		}
		else if(specimen instanceof FluidSpecimen)
		{
			return Constants.FLUID;
		}
		else if(specimen instanceof TissueSpecimen)
		{
			return Constants.TISSUE;
		}
		
		return null;
	}
	
	public static int getEventParametersFormId(SpecimenEventParameters eventParameter)
	{
		if(eventParameter instanceof CheckInCheckOutEventParameter)
		{
			return Constants.CHECKIN_CHECKOUT_EVENT_PARAMETERS_FORM_ID;
		}
		else if(eventParameter instanceof CollectionEventParameters)
		{
			return Constants.COLLECTION_EVENT_PARAMETERS_FORM_ID;
		}
		else if(eventParameter instanceof EmbeddedEventParameters)
		{
			return Constants.EMBEDDED_EVENT_PARAMETERS_FORM_ID;
		}
		else if(eventParameter instanceof FixedEventParameters)
		{
			return Constants.FIXED_EVENT_PARAMETERS_FORM_ID;
		}
		else if(eventParameter instanceof FrozenEventParameters)
		{
			return Constants.FROZEN_EVENT_PARAMETERS_FORM_ID;
		}
		else if(eventParameter instanceof ReceivedEventParameters)
		{
			return Constants.RECEIVED_EVENT_PARAMETERS_FORM_ID;
		}
		else if(eventParameter instanceof TissueSpecimenReviewEventParameters)
		{
			return Constants.TISSUE_SPECIMEN_REVIEW_EVENT_PARAMETERS_FORM_ID;
		}
		else if(eventParameter instanceof TransferEventParameters)
		{
			return Constants.TRANSFER_EVENT_PARAMETERS_FORM_ID;
		}
		
		return -1;
	}
	
	/**
	 * This method is used in JSP pages to get the width of columns for the html fields. 
	 * It acts as a wrapper for the HibernateMetaData getColumnWidth() method.
	 * @param className Class name of the field
	 * @param attributeName Attribute name of the field.
	 * @return Length of the column. 
	 * @see HibernateMetaData.getColumnWidth()  
	 */
	public static String getColumnWidth(Class className, String attributeName)
	{
		String columnLength = toString(new Integer((HibernateMetaData.getColumnWidth(className,attributeName ))));
		Logger.out.debug(className.getName()+ " : "+ attributeName  + " : " + columnLength ); 
		return columnLength;
	}
	//Mandar 17-Apr-06 Bugid : 1667 : end
}