<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="edu.wustl.catissuecore.util.global.Constants"%>
<%@ page import="edu.wustl.catissuecore.actionForm.StorageContainerForm"%>


<head>
	<script language="JavaScript">
		
		var win = null;
		function NewWindow(mypage,myname,w,h,scroll)
		{
			LeftPosition = (screen.width) ? (screen.width-w)/2 : 0;
			TopPosition = (screen.height) ? (screen.height-h)/2 : 0;

			mypage=mypage+document.forms[0].typeId.value;
			settings =
				'height='+h+',width='+w+',top='+TopPosition+',left='+LeftPosition+',scrollbars='+scroll+',resizable'
			win = open(mypage,myname,settings)
			if (win.opener == null)
				win.opener = self;
		}

		function onRadioButtonClick(element)
		{
			if(element.value == 1)
			{
				document.forms[0].siteId.disabled = false;
				document.forms[0].positionInParentContainer.disabled = true;
				document.forms[0].Map.disabled = true;
			}
			else
			{
				document.forms[0].positionInParentContainer.disabled = false;
				document.forms[0].Map.disabled = false;

				document.forms[0].siteId.disabled = true;
				//window.location.reload();
			}
		}
		
		function onTypeChange(element)
		{
			var action = "/catissuecore/StorageContainer.do?operation=add";
			document.forms[0].action = action;
			document.forms[0].submit();
		}
		
		function onSiteChange(element)
		{
			var list = document.getElementById('typeId');
			var type = list.options[list.selectedIndex].value;
			var action = "/catissuecore/StorageContainer.do?operation=add";
			document.forms[0].action = action;
			document.forms[0].submit();
		}
		
		function onContainerChange(element)
		{
		}
		
//  function to insert a row in the inner block

function insRow(subdivtag)
{

		var val = parseInt(document.forms[0].counter.value);
		val = val + 1;
		document.forms[0].counter.value = val;

	var r = new Array(); 
	r = document.getElementById(subdivtag).rows;
	var q = r.length;
	var x=document.getElementById(subdivtag).insertRow(q);
	
	// First Cell
	var spreqno=x.insertCell(0);
	spreqno.className="formSerialNumberField";
	sname=(q+1);
	var identifier = "value(StorageContainerDetails:" + (q+1) +"_systemIdentifier)";
	sname = sname + "<input type='hidden' name='" + identifier + "' value='' id='" + identifier + "'>";
	spreqno.innerHTML="" + sname;

	//Second Cell
	var spreqtype=x.insertCell(1);
	spreqtype.className="formField";
	spreqtype.colSpan=2;
	sname="";
	
	var name = "value(StorageContainerDetails:" + (q+1) +"_parameterName)";
	sname="<input type='text' name='" + name + "' class='formFieldSized10' id='" + name + "'>"        


	spreqtype.innerHTML="" + sname;

	//Third Cell
	var spreqsubtype=x.insertCell(2);
	spreqsubtype.className="formField";
	sname="";

	name = "value(StorageContainerDetails:" + (q+1) +"_parameterValue)";
	sname= "";

	var name = "value(StorageContainerDetails:" + (q+1) +"_parameterValue)";

	sname="<input type='text' name='" + name + "' class='formFieldSized10' id='" + name + "'>"        

	spreqsubtype.innerHTML="" + sname;
}

/*
// using createelement functions
function insRow(subdivtag)
{

		var val = parseInt(document.forms[0].counter.value);
		val = val + 1;
		document.forms[0].counter.value = val;

	var r = new Array(); 
	r = document.getElementById(subdivtag).rows;
	
	var q = r.length;
	var x=document.getElementById(subdivtag).insertRow(q);
	
	// First Cell
	var spreqno=x.insertCell(0);
	spreqno.className="formSerialNumberField";
	sname=(q+1);
	var textNode = document.createTextNode(sname);
	spreqno.appendChild(textNode);

// -------------------------------------------------
	//Second Cell
	var spreqtype=x.insertCell(1);
	spreqtype.className="formField";
	spreqtype.colSpan=2;
	sname="";
	var name = "value(StorageContainerDetails:" + (q+1) +"_parameterName)";
	var txtInp = document.createElement('input');

	txtInp.setAttribute('type', 'text');
	txtInp.setAttribute('name', name);
	txtInp.setAttribute('class', 'formFieldSized10');
	txtInp.setAttribute('id', name );
//--		document.storageContainerForm.appendChild(txtInp);
		
	spreqtype.appendChild(txtInp);
// -------------------------------------------------


	//Third Cell
	var spreqsubtype=x.insertCell(2);
	spreqsubtype.className="formField";

	var name1 = "value(StorageContainerDetails:" + (q+1) +"_parameterValue)";
	var txtInp1 = document.createElement('input');

	txtInp1.setAttribute('type', 'text');
	txtInp1.setAttribute('name', name1);
	txtInp1.setAttribute('class', 'formFieldSized10');
	txtInp1.setAttribute('id', name1 );
	
//--		document.storageContainerForm.appendChild(txtInp1);
	spreqsubtype.appendChild(txtInp1);
// -------------------------------------------------

}
*/
	</script>
</head>

<%
        String operation = (String) request.getAttribute(Constants.OPERATION);
        String formName;

        boolean readOnlyValue;
        if (operation.equals(Constants.EDIT))
        {
            formName = Constants.STORAGE_CONTAINER_EDIT_ACTION;
            readOnlyValue = true;
        }
        else
        {
            formName = Constants.STORAGE_CONTAINER_ADD_ACTION;
            readOnlyValue = false;
        }
	
		Object obj = request.getAttribute("storageContainerForm");
		int noOfRows=1;
		if(obj != null && obj instanceof StorageContainerForm)
		{
			StorageContainerForm form = (StorageContainerForm)obj;
			noOfRows = form.getCounter();
		}
		String number = (String)request.getAttribute("startNumber");
		System.out.println("number JSP "+number);
%>

<html:errors />

<html:form action="<%=Constants.STORAGE_CONTAINER_ADD_ACTION%>" method="post">	

	<table summary="" cellpadding="0" cellspacing="0" border="0" class="contentPage" width="600">
	<!-- NEW STORAGE CONTAINER REGISTRATION BEGINS-->
		<tr>
		<td>
			<table summary="" cellpadding="3" cellspacing="0" border="0" width="510">
				<tr>
					<td><html:hidden property="operation" value="<%=operation%>" /></td>
				</tr>
				<tr>
					<td><html:hidden property="systemIdentifier" /></td>
				</tr>
				<tr>
					<td><html:hidden property="positionDimensionOne" /></td>
				</tr>
				<tr>
					<td><html:hidden property="positionDimensionTwo" /></td>
				</tr>
				<tr>
					<td><html:hidden property="parentContainerId" /></td>
				</tr>
				<logic:notEqual name="<%=Constants.OPERATION%>" value="<%=Constants.SEARCH%>">
					<tr>
						<td class="formMessage" colspan="4">* indicates a required field</td>
					</tr>
					
					<tr>
						<td class="formTitle" height="20" colspan="4">
							<bean:message key="storageContainer.title" />
						</td>
					</tr>
					
					<tr>
						<td class="formRequiredNotice" width="5">*</td>
						<td class="formRequiredLabel" colspan="2">
							<label for="type">
								<bean:message key="storageContainer.type" />
							</label>
						</td>
						<td class="formField">
							<html:select property="typeId" styleClass="formFieldSized" styleId="typeId" size="1" onchange="onTypeChange(this)">
								<%-- html:options name="storageTypeIdList" labelName="storageTypeList" /--%>
								<html:options collection="<%=Constants.STORAGETYPELIST%>" labelProperty="name" property="value"/>
							</html:select>
							&nbsp;
							<html:link page="/StorageType.do?operation=add">
		 						<bean:message key="buttons.addNew" />
	 						</html:link>
						</td>
					</tr>
<!-- New row 1 -->
					<tr>
						<td class="formRequiredNoticeNoBottom" width="5">&nbsp;</td>
						<td class="formRequiredLabelRightBorder" colspan=2>
							<html:radio styleClass="" styleId="checkedButton" property="checkedButton" value="1" onclick="onRadioButtonClick(this)">
								<label for="siteId">
									<bean:message key="storageContainer.site" />
								</label>
							</html:radio>
						</td>
						<td class="formField">
							<logic:equal name="storageContainerForm" property="checkedButton" value="1">
							<html:select property="siteId" styleClass="formFieldSized" styleId="siteId" size="1" onchange="onSiteChange(this)">
								<html:options collection="<%=Constants.SITELIST%>" labelProperty="name" property="value"/>
							</html:select>
							</logic:equal>
							<logic:equal name="storageContainerForm" property="checkedButton" value="2">
							<html:select property="siteId" styleClass="formFieldSized15" styleId="siteId" size="1" onchange="onSiteChange(this)" disabled="true">
								<html:options collection="<%=Constants.SITELIST%>" labelProperty="name" property="value"/>
							</html:select>
							</logic:equal>
							
							&nbsp;
							<html:link page="/Site.do?operation=add" styleId="newSite">
		 						<bean:message key="buttons.addNew" />
	 						</html:link>
						
						</td>							
					</tr>
<!-- New row two -->					
					<tr>
						<td class="formRequiredNotice" width="5">&nbsp;</td>
						<td class="formRequiredLabel" colspan=2>
							<html:radio styleClass="" styleId="checkedButton" property="checkedButton" value="2" onclick="onRadioButtonClick(this)">
								<label for="site">
									<bean:message key="storageContainer.parentContainer" />
								</label>
							</html:radio>							
						</td>
						<td class="formField">
	 						<logic:equal name="storageContainerForm" property="checkedButton" value="1">							
							<html:text styleClass="formFieldSized" size="30" styleId="positionInParentContainer" property="positionInParentContainer" readonly="true" disabled="true"/>
							&nbsp;
							<html:button property="mapButton" styleClass="actionButton" styleId="Map" 
								onclick="NewWindow('ShowFramedPage.do?pageOf=pageOfStorageLocation&amp;storageType=','name','810','320','yes');return false" disabled="true">
								<bean:message key="buttons.map"/>
							</html:button>
							
							</logic:equal>
							
							<logic:equal name="storageContainerForm" property="checkedButton" value="2">
							
							<html:text styleClass="formFieldSized" size="30" styleId="positionInParentContainer" property="positionInParentContainer" readonly="true"/>
							&nbsp;
							<html:button property="mapButton" styleClass="actionButton" styleId="Map" 
								onclick="NewWindow('ShowFramedPage.do?pageOf=pageOfStorageLocation&amp;storageType=','name','810','320','yes');return false" >
								<bean:message key="buttons.map"/>
							</html:button>
							
							</logic:equal>
						
						</td>							
					</tr>

					<logic:notEqual name="<%=Constants.OPERATION%>" value="<%=Constants.EDIT%>">
					<tr>
						<td class="formRequiredNotice" width="5">&nbsp;</td>
						<td class="formLabel" colspan="2">
							<label for="noOfContainers">
								<bean:message key="storageContainer.noOfContainers" />
							</label>
						</td>
						<td class="formField">
							<html:text styleClass="formFieldSized10" size="30" styleId="noOfContainers" property="noOfContainers" readonly="<%=readOnlyValue%>" onchange="onContainerChange(this)"/>
						</td>
					</tr>
					</logic:notEqual>
					
					<tr>
						<td class="formRequiredNotice" width="5">&nbsp;</td>
						<td class="formLabel" colspan="2">
							<label for="startNumber">
								<bean:message key="storageContainer.startNumber" />
							</label>
						</td>
						<td class="formField">
						<logic:notEqual name="<%=Constants.OPERATION%>" value="<%=Constants.EDIT%>">
							<html:text styleClass="formFieldSized10" size="30" styleId="startNumber" property="startNumber" value="<%=number%>" readonly="TRUE"/>
						</logic:notEqual>
						<logic:equal name="<%=Constants.OPERATION%>" value="<%=Constants.EDIT%>">
							<html:text styleClass="formFieldSized10" size="30" styleId="startNumber" property="startNumber" readonly="TRUE"/>
						</logic:equal>
						</td>
					</tr>
					
					<tr>
						<td class="formRequiredNotice" width="5">&nbsp;</td>
						<td class="formLabel" colspan="2">
							<label for="barcode">
								<bean:message key="storageContainer.barcode" />
							</label>
						</td>
						<td class="formField">
							<html:text styleClass="formFieldSized10" size="30" styleId="barcode" property="barcode"/>
						</td>
					</tr>
					
					<tr>
						<td class="formRequiredNotice" width="5">&nbsp;</td>
						<td class="formLabel" colspan="2">
							<label for="defaultTemperature">
								<bean:message key="storageContainer.temperature" />
							</label>
						</td>
						<td class="formField">
							<html:text styleClass="formFieldSized10" size="30" styleId="defaultTemperature" property="defaultTemperature"/>
							�C
						</td>
					</tr>
					
					<logic:equal name="<%=Constants.OPERATION%>" value="<%=Constants.EDIT%>">
					<tr>
						<td class="formRequiredNotice" width="5">*</td>
						<td class="formRequiredLabel" colspan="2">
							<label for="activityStatus">
								<bean:message key="site.activityStatus" />
							</label>
						</td>
						<td class="formField">
							<html:select property="activityStatus" styleClass="formFieldSized10" styleId="activityStatus" size="1">
								<html:options name="<%=Constants.ACTIVITYSTATUSLIST%>" labelName="<%=Constants.ACTIVITYSTATUSLIST%>" />
							</html:select>
						</td>
					</tr>
					</logic:equal>
					
					<tr>
						<td class="formTitle" colspan="4">
							<label for="capacity">
								<bean:message key="storageContainer.capacity" />
							</label>
						</td>
					</tr>
					
					<tr>
						<td class="formRequiredNotice" width="5">&nbsp;</td>
						<td class="formLabel" colspan="2">
							<label for="oneDimensionLabel">
								<%--<bean:message key="storageContainer.oneDimensionLabel" />--%>
								<bean:write name="storageContainerForm" property="oneDimensionLabel"/>
							</label>
						</td>
						<td class="formField">
							<html:text styleClass="formFieldSized10" size="30" styleId="oneDimensionCapacity" property="oneDimensionCapacity"/>
						</td>
					</tr>
					
					<tr>
						<td class="formRequiredNotice" width="5">&nbsp;</td>
						<td class="formLabel" colspan="2">
							<label for="twoDimensionLabel">
								<%--<bean:message key="storageContainer.twoDimensionLabel" />--%>								
								<bean:write name="storageContainerForm" property="twoDimensionLabel"/>
							</label>
						</td>
						<td class="formField">
							<html:text styleClass="formFieldSized10" size="30" styleId="twoDimensionCapacity" property="twoDimensionCapacity"/>
						</td>
					</tr>
					
					<tr>
						<td class="formTitle" colspan="3" nowrap>
							<label for="details">
								<bean:message key="storageContainer.details" />
							</label>
						</td>
						<td class="formTitle" align="Right">
						<html:button property="addKeyValue" styleClass="actionButton" onclick="insRow('addMore')">
						<bean:message key="buttons.addMore"/>
						</html:button>
						<html:hidden property="counter"/>
						</td>
					</tr>
									
					<tr>
						<td class="formLeftSubTableTitle" width="5">#</td>
						<td class="formRightSubTableTitle" colspan="2">
							<label for="key">
								<bean:message key="storageContainer.key" />
							</label>
						</td>
						<td class="formRightSubTableTitle">
							<label for="value">
								<bean:message key="storageContainer.value" />
							</label>
						</td>
					</tr>
					
					<tbody id="addMore">
						<%
						
							for(int rowCount=1;rowCount<=noOfRows;rowCount++)
							{
								String keyName = "value(StorageContainerDetails:" + rowCount +"_parameterName)";
								String valueName = "value(StorageContainerDetails:" + rowCount +"_parameterValue)";
								String identifier = "value(StorageContainerDetails:" + rowCount +"_systemIdentifier)";
						%>
					<tr>
						<td class="formSerialNumberField" width="5"><%=rowCount%>.
							<html:hidden property="<%=identifier%>" />
						</td>
						<td class="formField" colspan="2">
							<html:text styleClass="formFieldSized10" size="30" styleId="<%=keyName%>" property="<%=keyName%>"/>
						</td>
						<td class="formField">
							<html:text styleClass="formFieldSized10" size="30" styleId="<%=valueName%>" property="<%=valueName%>"/>
						</td>
					</tr>
						<%
							} // for
						%>

					</tbody>
				<%--	</logic:equal> --%>
				</table>
				
				<table summary="" cellpadding="3" cellspacing="0" border="0" width="500">	
					<tr>
						<td align="right">
						<%
        					String changeAction = "setFormAction('" + formName + "');";
				        %> 
						
						<!-- action buttons begins -->
						<table cellpadding="4" cellspacing="0" border="0">
							<tr>
								<td>
						   				<html:submit styleClass="actionButton" onclick="<%=changeAction%>">
						   					<bean:message key="buttons.submit"/>
						   				</html:submit>
						   		</td>
								<td>
										<html:reset styleClass="actionButton">
											<bean:message key="buttons.reset"/>
										</html:reset>
								</td> 
							</tr>
						</table>
						<!-- action buttons end -->
						</td>
					</tr>
					
				</logic:notEqual>
			</table>

			</td>
		</tr>

		<!-- NEW STORAGE CONTAINER REGISTRATION ends-->
	</table>
</html:form> 