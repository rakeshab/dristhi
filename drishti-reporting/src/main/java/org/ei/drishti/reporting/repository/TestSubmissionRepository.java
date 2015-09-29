package org.ei.drishti.reporting.repository;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class TestSubmissionRepository {

    private DataAccessTemplate dataAccessTemplate;

    private static Logger logger = LoggerFactory
            .getLogger(TestSubmissionRepository.class.toString());

    @Autowired
    public TestSubmissionRepository(@Qualifier("serviceProvidedDataAccessTemplate") DataAccessTemplate dataAccessTemplate) {
        this.dataAccessTemplate = dataAccessTemplate;
    }

    public void requestConsultationTest(String visittype, String visitentityid,
            String entityidEC, String anmid) {

        logger.info("Fetch visit due details***" + visittype);

        logger.info("Fetch visit due details***" + visitentityid);
        logger.info("Fetch visit due details***" + entityidEC);
        logger.info("Fetch visit due details***" + anmid);

        logger.info(" This is my TestSubmission Repository");

        String sql = "select p.parent_hospital from report.health_centers p where p.hospital_name=(select s.subcenter from report.user_masters s where s.user_id='anmid')and p.hospital_type='Subcenter';";
        List<String> hospitalname = dataAccessTemplate.getSessionFactory()
                .getCurrentSession().createSQLQuery(sql).list();

        if (hospitalname != null && hospitalname.size() > 0) {
            logger.info("*******parent_hospitalphc is *****" + hospitalname.get(0));
            String phc = hospitalname.get(0);

            logger.info(" This is my  after search TestSubmissionRepository-----------------------");

      String  sql2="insert into report.poc_table VALUES('visitentityid','entityidEC','anmid','visittype','phc','1',' ',' ',' ')";
            
            dataAccessTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql2);

            logger.info(" This is my  after save TestSubmissionRepository>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        }

    }
}
