package com.krishagni.catissueplus.core.biospecimen.repository.impl;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import com.krishagni.catissueplus.core.biospecimen.domain.StagedParticipant;
import com.krishagni.catissueplus.core.biospecimen.events.PmiDetail;
import com.krishagni.catissueplus.core.biospecimen.repository.StagedParticipantDao;
import com.krishagni.catissueplus.core.common.repository.AbstractDao;

public class StagedParticipantDaoImpl extends AbstractDao<StagedParticipant> implements StagedParticipantDao {

	@Override
	public Class<StagedParticipant> getType() {
		return StagedParticipant.class;
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<StagedParticipant> getByPmis(List<PmiDetail> pmis) {
		Criteria query = getByPmisQuery(pmis);
		return query != null ? query.list() : Collections.emptyList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public StagedParticipant getByEmpi(String empi) {
		List<StagedParticipant> participants = getCurrentSession().getNamedQuery(GET_BY_EMPI)
			.setString("empi", empi.toLowerCase())
			.list();
		return CollectionUtils.isEmpty(participants) ? null : participants.iterator().next();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<StagedParticipant> getByMrn(String mrn) {
		return getCurrentSession().getNamedQuery(GET_BY_MRN)
			.setParameter("mrn", mrn.toLowerCase())
			.list();
	}

	@Override
	public int deleteOldParticipants(int olderThanDays) {
		Date olderThanDt = Date.from(Instant.now().minus(Duration.ofDays(olderThanDays)));
		deleteOldParticipantRecs(DEL_OLD_PARTICIPANT_PMIS, olderThanDt);
		deleteOldParticipantRecs(DEL_OLD_PARTICIPANT_RACES, olderThanDt);
		deleteOldParticipantRecs(DEL_OLD_PARTICIPANT_ETHNICITIES, olderThanDt);
		return deleteOldParticipantRecs(DEL_OLD_PARTICIPANTS, olderThanDt);
	}

	private Criteria getByPmisQuery(List<PmiDetail> pmis) {
		Criteria query = getCurrentSession().createCriteria(StagedParticipant.class)
			.createAlias("pmis", "pmi");
		
		Disjunction junction = Restrictions.disjunction();
		boolean added = false;
		for (PmiDetail pmi : pmis) {
			if (StringUtils.isBlank(pmi.getSiteName()) || StringUtils.isBlank(pmi.getMrn())) {
				continue;
			}
			
			junction.add(
				Restrictions.and(
					Restrictions.ilike("pmi.medicalRecordNumber", pmi.getMrn()),
					Restrictions.ilike("pmi.site", pmi.getSiteName())));
			added = true;
		}

		return added ? query.add(junction) : null;
	}

	private int deleteOldParticipantRecs(String query, Date olderThanDt) {
		return getCurrentSession().getNamedQuery(query).setTimestamp("olderThanDt", olderThanDt).executeUpdate();
	}

	private static final String FQN = StagedParticipant.class.getName();

	private static final String GET_BY_EMPI = FQN + ".getByEmpi";

	private static final String GET_BY_MRN = FQN + ".getByMrn";

	private static final String DEL_OLD_PARTICIPANTS = FQN + ".deleteOldParticipants";

	private static final String DEL_OLD_PARTICIPANT_PMIS = FQN + ".deleteOldParticipantPmis";

	private static final String DEL_OLD_PARTICIPANT_RACES = FQN + ".deleteOldParticipantRaces";

	private static final String DEL_OLD_PARTICIPANT_ETHNICITIES = FQN + ".deleteOldParticipantEthnicities";
}
