/**
 * 
 */
package edu.wustl.catissuecore.util.querysuite;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
 
import javax.servlet.http.HttpSession;

import edu.common.dynamicextensions.domaininterface.AssociationInterface;
import edu.common.dynamicextensions.domaininterface.AttributeInterface;
import edu.common.dynamicextensions.domaininterface.EntityInterface;
import edu.common.dynamicextensions.domaininterface.RoleInterface;
import edu.common.dynamicextensions.entitymanager.EntityManager;
import edu.common.dynamicextensions.entitymanager.EntityManagerInterface;
import edu.common.dynamicextensions.exception.DynamicExtensionsSystemException;
import edu.wustl.cab2b.server.cache.EntityCache;
import edu.wustl.catissuecore.util.global.Constants;
import edu.wustl.catissuecore.util.global.Variables;
import edu.wustl.common.beans.QueryResultObjectDataBean;
import edu.wustl.common.beans.SessionDataBean;
import edu.wustl.common.dao.DAOFactory;
import edu.wustl.common.dao.JDBCDAO;
import edu.wustl.common.querysuite.queryobject.IQuery;
import edu.wustl.common.querysuite.queryobject.IQueryEntity;
import edu.wustl.common.querysuite.queryobject.impl.OutputTreeDataNode;
import edu.wustl.common.querysuite.queryobject.impl.metadata.QueryOutputTreeAttributeMetadata;
import edu.wustl.common.util.dbManager.DAOException;
import edu.wustl.common.util.global.ApplicationProperties;
import edu.wustl.common.util.logger.Logger;


/**
 * @author supriya_dankh
 * This class contains all the methods required for CSM integration in query.
 */
public abstract class QueryCSMUtil
{
	
	/**This method will check if main objects for all the dependent objects are present in query or not.
	 * If yes then will create map of entity as key and main entity list as value.
	 * If not then will set error message in session.
	 * @param query
	 * @param session
	 * @param uniqueIdNodesMap
	 * @return
	 */
	public static Map<EntityInterface, List<EntityInterface>> setMainObjectErrorMessage(
			IQuery query, HttpSession session, Map<String, OutputTreeDataNode> uniqueIdNodesMap)
	{
		int status;
		Map<EntityInterface ,List<EntityInterface>> mainEntityMap = getMainEntitiesForAllQueryNodes(uniqueIdNodesMap);
		List<Long> queryDeEntities = getAllDEEntities(query);
		String errorMessg = getErrorMessage(mainEntityMap, uniqueIdNodesMap);
		if(!errorMessg.equals(""))
		{
			session.setAttribute(Constants.NO_MAIN_OBJECT_IN_QUERY, errorMessg);
			return null;
		}
		else
			session.setAttribute(Constants.MAIN_ENTITY_MAP, mainEntityMap);
		return mainEntityMap;
	}
	
	/**
	 * This method will return error message for main object.
	 * @param queryDeEntities list of ids of all the DE entities present in query.
	 * @param mainEntityMap main entity map.
	 * @param uniqueIdNodesMap contains all the entities in the query 
	 * @return
	 */
	private static String getErrorMessage(Map<EntityInterface, List<EntityInterface>> mainEntityMap, 
			Map<String, OutputTreeDataNode> uniqueIdNodesMap)
	{
		String errorMsg = "";
		
		for (Iterator iterator = mainEntityMap.entrySet().iterator(); iterator.hasNext();)
		{
			String mainEntityName = "";
			String entityName = "";
			String mainEntityNames = "";
			Map.Entry<EntityInterface ,List<EntityInterface>> mapValue = (Map.Entry<EntityInterface ,List<EntityInterface>>) iterator.next();
			String name = mapValue.getKey().getName();
			if(name!=null && !name.equals(""))
			{
			  entityName = name.substring(name.lastIndexOf(".")+1,name.length());
			}
			boolean isMainEntityPresent = false;
			for(EntityInterface mainEntity : mapValue.getValue())
			{
				mainEntityName = mainEntity.getName();
				if(mainEntityName!=null && !mainEntityName.equals(""))
					mainEntityName = mainEntityName.substring(mainEntityName.lastIndexOf(".")+1,mainEntityName.length());
				mainEntityNames = mainEntityNames + mainEntityName+" or ";
				// iterate through uniqueIdNodesMap and check if main entity is present.
				for (Iterator idMapIterator = uniqueIdNodesMap.entrySet().iterator(); idMapIterator.hasNext();)
				{	
					Map.Entry<String, OutputTreeDataNode> IdmapValue = (Map.Entry<String, OutputTreeDataNode>) idMapIterator.next();
					OutputTreeDataNode node = IdmapValue.getValue();				
					EntityInterface mapEntity = node.getOutputEntity().getDynamicExtensionsEntity();
					if (mainEntity.getName().equals(mapEntity.getName()))
					{
						isMainEntityPresent = true;
						break;
					}
				}
			} 
			if(!isMainEntityPresent)
			{
				mainEntityNames = mainEntityNames.substring(0, mainEntityNames.lastIndexOf("r")-1);
				String message = ApplicationProperties.getValue("query.mainObjectError");
				Object[] arguments = new Object[]{entityName,mainEntityNames};
				errorMsg = MessageFormat.format(message, arguments);
				break;
			}
		}
		return errorMsg;
	}
	/**
	 * @param query
	 * @return
	 */
	private static List<Long> getAllDEEntities(IQuery query)
	{
		Set<IQueryEntity> queryEntities = query.getConstraints().getQueryEntities();
		List<Long> queryDeEntities = new ArrayList<Long>();
		for(IQueryEntity queryEntity : queryEntities)
		{
			queryDeEntities.add(queryEntity.getDynamicExtensionsEntity().getId());
		}
		return queryDeEntities;
	}

	/**
	 * This method will return map of a entity as value and list of all the main entities of this perticuler entity as value. 
	 * @param uniqueIdNodesMap Map that will all nodes present in query as node id as key and node as value. 
	 * @return mainEntityMap Map of all main entities present in query.
	 */
	private static Map<EntityInterface, List<EntityInterface>> getMainEntitiesForAllQueryNodes(
			Map<String, OutputTreeDataNode> uniqueIdNodesMap)
	{
		Map<EntityInterface, List<EntityInterface>> mainEntityMap = new HashMap<EntityInterface, List<EntityInterface>>();

		for (OutputTreeDataNode queryNode : uniqueIdNodesMap.values())
		{
			List<EntityInterface> mainEntityList = new ArrayList<EntityInterface>();
			EntityInterface dynamicExtensionsEntity = queryNode.getOutputEntity()
					.getDynamicExtensionsEntity();
			mainEntityList = getAllMainEntities(dynamicExtensionsEntity, mainEntityList);
			if(!(mainEntityList!=null && mainEntityList.size()==1 &&mainEntityList.get(0).equals(dynamicExtensionsEntity)))
			    mainEntityMap.put(dynamicExtensionsEntity, mainEntityList);
		}
		return mainEntityMap;
	}
	/**This is a recursive method that will create list of all main entities (Entities for which entity passed to it is having containment association ) 
	 * @param entity
	 * @param mainEntityList
	 */
	private static List<EntityInterface> getAllMainEntities(EntityInterface entity,
			List<EntityInterface> mainEntityList) 
	{
		try
		{
			List<AssociationInterface> associationList = getIncomingContainmentAssociations(entity);
			if (associationList.size() != 0)
			{
				for (AssociationInterface assocoation : associationList)
				{
					mainEntityList = getAllMainEntities(assocoation.getEntity(), mainEntityList);
				}
			}
			else
				mainEntityList.add(entity);
		}
		catch (DynamicExtensionsSystemException deExeption)
		{
			deExeption.printStackTrace();
		}

		return mainEntityList;
	}
	
	/**
	 * This method will create queryResultObjectDataBean for a node passed to it.
	 * @param node node for which QueryResultObjectDataBean is to be created.
	 * @param mainEntityMap main entity map. 
	 * @return queryResultObjectDataBean.
	 */
	public static  QueryResultObjectDataBean getQueryResulObjectDataBean(
			OutputTreeDataNode node, Map<EntityInterface, List<EntityInterface>> mainEntityMap)
	{   
		QueryResultObjectDataBean queryResultObjectDataBean = new QueryResultObjectDataBean();
		boolean readDeniedObject = false;
		if(node!=null)
		{
		EntityInterface dynamicExtensionsEntity = node.getOutputEntity()
				.getDynamicExtensionsEntity();
		String entityName;
		queryResultObjectDataBean
				.setPrivilegeType(edu.wustl.common.querysuite.security.utility.Utility
						.getPrivilegeType(dynamicExtensionsEntity));
		queryResultObjectDataBean.setEntity(dynamicExtensionsEntity);

		List<EntityInterface> mainEntityList = mainEntityMap.get(dynamicExtensionsEntity);
		if (mainEntityList != null)
		{
			EntityInterface mainEntity = getMainEntity(mainEntityList, node);
			queryResultObjectDataBean.setMainEntity(mainEntity);
			entityName = mainEntity.getName();
		}
		else
		{
			entityName = dynamicExtensionsEntity.getName();
		}
		
		queryResultObjectDataBean.setCsmEntityName(entityName);
		setEntityName(queryResultObjectDataBean, entityName);
		readDeniedObject = isReadDeniedObject(queryResultObjectDataBean.getCsmEntityName());
		queryResultObjectDataBean.setReadDeniedObject(readDeniedObject);
		}
		return queryResultObjectDataBean;
	}

	/**If main entity is inherited from an entity (e.g. Fluid Specimen is inherited from Specimen) and present in INHERITED_ENTITY_NAMES  
	 * then csmEntityName of queryResultObjectDataBean will be set to it's parent entity name.(as Sql for getting CP ids id retrived 
	 * according to parent entity name from entityCPSqlMap in Variables class).
	 * @param queryResultObjectDataBean
	 * @param name
	 */
	private static void setEntityName(QueryResultObjectDataBean queryResultObjectDataBean, String name)
	{
		boolean presentInArray = QueryModuleUtil.isPresentInArray(name,
				Constants.INHERITED_ENTITY_NAMES);
		
		if (presentInArray)
		{
			EntityInterface parentEntity = queryResultObjectDataBean.getEntity().getParentEntity();
			if (parentEntity != null)
			{
				queryResultObjectDataBean.setCsmEntityName(parentEntity.getName());
			}
		}
	}
	
	/**This method will check if for an entity read denied has to checked or not. All theses entities are present in 
	 * Variables.queryReadDeniedObjectList list.
	 * @param name
	 * @return
	 */
	private static boolean isReadDeniedObject(String entityName)
	{  
		if (Variables.queryReadDeniedObjectList.contains(entityName))
			return true;
		else
			return false;
	}

	/**This method will return main entity for node passed in context of query (i.e. If one texcontent node is associated with Identified and 
	 * other with deidentified then it will return appropriate main object for textcontent)
	 * @param mainEntityList
	 * @param node
	 */
	private static EntityInterface getMainEntity(List<EntityInterface> mainEntityList, OutputTreeDataNode node)

	{

		if (node != null)

		{ 

			EntityInterface dynamicExtensionsEntity = node.getOutputEntity()
					.getDynamicExtensionsEntity();

			if (mainEntityList.contains(dynamicExtensionsEntity))

				return dynamicExtensionsEntity;

			else if (node.getParent() != null)

				return getMainEntity(mainEntityList, node.getParent());

		}

		if (node != null)

		{

			List<OutputTreeDataNode> children = node.getChildren();

			for (OutputTreeDataNode childNode : children)

			{

				return getMainEntity(mainEntityList, childNode);

			}

		}

		return null;

	} 



	/**This method will internally call  getIncomingAssociationIds of DE which will return all incoming associations 
	 * for entities passed.This method will filter out all incoming containment associations and return list of them.
	 * @param entity
	 */
	public static List<AssociationInterface> getIncomingContainmentAssociations(EntityInterface entity) throws DynamicExtensionsSystemException
	{   
		EntityManagerInterface entityManager = EntityManager.getInstance();
		List<Long> allIds = (List<Long>)entityManager.getIncomingAssociationIds(entity);
		List<AssociationInterface> list = new ArrayList<AssociationInterface>();
		EntityCache cache = EntityCache.getInstance();
		for (Long id: allIds)
		{
			AssociationInterface associationById = cache.getAssociationById(id);
			
			RoleInterface targetRole = associationById.getTargetRole();
			if (associationById!=null && targetRole.getAssociationsType().getValue().equals(Constants.CONTAINTMENT_ASSOCIATION))
				list.add(associationById);
		}
		return list;
	}
	
		
	/**
	 * @param queryResultObjectDataBean
	 * @param columnIndex
	 * @param selectSql 
	 * @param entityIdIndexMap 
	 * @param defineViewEntityList 
	 */
	public static String updateEntityIdIndexMap(QueryResultObjectDataBean queryResultObjectDataBean,
			int columnIndex, String selectSql, List<EntityInterface> defineViewNodeList, Map<EntityInterface, Integer> entityIdIndexMap)
	{
		String[] split = selectSql.split(",");
		if (defineViewNodeList != null)
		{
			Map<String, OutputTreeDataNode> uniqueIdNodesMap = QueryModuleUtil.uniqueIdNodesMap;
			Set<String> keySet = uniqueIdNodesMap.keySet();
			for (Iterator iterator = keySet.iterator(); iterator.hasNext();)
			{
				String key = "";
				Object nextObject = iterator.next();
				if (nextObject instanceof String)
				{
					key = (String) nextObject;
					OutputTreeDataNode outputTreeDataNode = uniqueIdNodesMap.get(key);
					if (outputTreeDataNode != null)
					{
						List<QueryOutputTreeAttributeMetadata> attributes = outputTreeDataNode
								.getAttributes();
						for (QueryOutputTreeAttributeMetadata attributeMetaData : attributes)
						{
							AttributeInterface attribute = attributeMetaData.getAttribute();
							String sqlColumnName = attributeMetaData.getColumnName().trim();
							if (attribute.getName().equals(Constants.ID))
							{
								if (selectSql.contains(sqlColumnName))
								{
									for (int i = 0; i < split.length; i++)
									{
										String string = split[i].trim();
										if (string.equals(sqlColumnName))
										{
											entityIdIndexMap.put(attribute.getEntity(), i);
											break;
										}
									}
								}
								else
								{
									selectSql += ", " + sqlColumnName;

									entityIdIndexMap.put(attribute.getEntity(), columnIndex);
									columnIndex++;
									break;
								}
							}
						}
					}
				}
			}
		}
		else
		{
			OutputTreeDataNode outputTreeDataNode = getMatchingEntityNode(queryResultObjectDataBean
					.getMainEntity());
			if (outputTreeDataNode != null)
			{
				List<QueryOutputTreeAttributeMetadata> attributes = outputTreeDataNode
						.getAttributes();
				for (QueryOutputTreeAttributeMetadata attributeMetaData : attributes)
				{
					AttributeInterface attribute = attributeMetaData.getAttribute();
					String sqlColumnName = attributeMetaData.getColumnName();
					if (attribute.getName().equals(Constants.ID))
					{
						if (selectSql.contains(sqlColumnName.trim()))
						{
							for (int i = 0; i < split.length; i++)
							{
								if (split[i].equals(sqlColumnName))
								{
									entityIdIndexMap.put(attribute.getEntity(), i);
									break;
								}
							}
						}
						else
						{
							selectSql += ", " + sqlColumnName;
							entityIdIndexMap.put(attribute.getEntity(), columnIndex);
							columnIndex++;
							break;
						}
					}
				}
			}
		}
		if (queryResultObjectDataBean != null)
			queryResultObjectDataBean.setEntityIdIndexMap(entityIdIndexMap);
		return selectSql;
	}
 
	/**This method will return node currosponding to an entity from query.
	 * @param entity
	 * @return outputTreeDataNode
	 */
	private static OutputTreeDataNode getMatchingEntityNode(EntityInterface entity)
	{
		Iterator<OutputTreeDataNode> iterator = QueryModuleUtil.uniqueIdNodesMap.values().iterator(); 
		while (iterator.hasNext())
		{
			OutputTreeDataNode outputTreeDataNode = (OutputTreeDataNode) iterator.next();
			if(outputTreeDataNode.getOutputEntity().getDynamicExtensionsEntity().equals(entity))
				return outputTreeDataNode;
		}
		return null;
	}
	
} 
