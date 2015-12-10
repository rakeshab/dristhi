package org.ei.drishti.reporting.handler;

import static ch.lambdaj.Lambda.collect;
import static ch.lambdaj.Lambda.collect;
import static ch.lambdaj.Lambda.collect;
import static ch.lambdaj.Lambda.on;
import java.util.List;
import org.ei.drishti.common.util.DateUtil;
import org.ei.drishti.reporting.controller.SMSController;
import org.ei.drishti.reporting.domain.ANCVisitDue;
import org.ei.drishti.reporting.domain.ANMVillages;
import org.ei.drishti.reporting.domain.EcRegDetails;
import org.ei.drishti.reporting.domain.HealthCenter;
import org.ei.drishti.reporting.domain.VisitConf;
import org.ei.drishti.reporting.repository.ANCVisitRepository;
import org.ei.drishti.reporting.service.ANMService;
import org.ei.drishti.reporting.service.VisitService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FormDatahandler {

    private SMSController smsController;
    private ANMService anmService;
    private ANCVisitRepository ancVisitRepository;
    private VisitService visitService;
    private DateUtil dateUtil;

    private static Logger logger = LoggerFactory.getLogger((String) FormDatahandler.class.toString());
    String regNumber = "";
    String wifeName = "";
    String phoneNumber = "";
    String village = "";
    String registrationDate = "";
  
    @Autowired
    public FormDatahandler(DateUtil dateUtil2,
			ANCVisitRepository ancVisitRepository2, ANMService anmService2,
			SMSController smsController2, VisitService visitService2) {
    	
    	this.dateUtil = dateUtil2;
    	this.ancVisitRepository = ancVisitRepository2;
    	 this.anmService = anmService2;
        this.smsController = smsController2;
         this.visitService = visitService2;
      
	}

    public void ecRegistration(JSONObject dataObject, String anmPhoneNumber) throws JSONException {
        String entityId = dataObject.getString("entityId");
        String anmid = dataObject.getString("anmId");
        String currentMethod = "";
        Integer numberOfCondomsSupplied = 0;
        String count = "";
        logger.info("ecregistration method");
        JSONArray fieldJsonArray = dataObject.getJSONObject("formInstance").getJSONObject("form").getJSONArray("fields");
        logger.info("ecregistration data fetch");
        for (int i = 0; i < fieldJsonArray.length(); i++) {

            JSONObject jsonObject = fieldJsonArray.getJSONObject(i);

            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("phoneNumber")) {

                phoneNumber = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("ecNumber")) {

                regNumber = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("wifeName")) {

                wifeName = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("registrationDate")) {

                registrationDate = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("currentMethod")) {

                currentMethod = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("numberOfCondomsSupplied") && jsonObject.has("value")
                    && jsonObject.getString("value") != null) {
                logger.info("test for");

                count = jsonObject.getString("value");
                numberOfCondomsSupplied = Integer.parseInt(count);

            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("village")) {

                village = (jsonObject.has("value")
                        && jsonObject.getString("value") != null) ? jsonObject
                                .getString("value") : "";
            }
        }
        if(!currentMethod.equalsIgnoreCase("none")&& !currentMethod.equalsIgnoreCase("none_ps") && !currentMethod.equalsIgnoreCase("none_ss")
            &&!currentMethod.equalsIgnoreCase("dmpa_injectable")&& !currentMethod.equalsIgnoreCase("traditional_methods") && !currentMethod.equalsIgnoreCase("centchroman"))
        {
            ancVisitRepository.reportinsert("", entityId, wifeName, anmid, "FP", currentMethod, numberOfCondomsSupplied, registrationDate, village, 0, "", "","");
        }
        
        logger.info("invoke sms controller******" + phoneNumber);
        smsController.sendSMSEC(phoneNumber, regNumber, wifeName, "EC");
        ancVisitRepository.ecinsert(entityId, phoneNumber);
        
    
   }

    public void recordECP(JSONObject dataObject, String anmPhoneNumber) throws JSONException {
        String entityId = dataObject.getString("entityId");
        String anmid = dataObject.getString("anmId");
        Integer numberOfECPsGiven = 0;
        String submissionDate = "";
        JSONArray fieldJsonArray = dataObject.getJSONObject("formInstance").getJSONObject("form").getJSONArray("fields");
        logger.info("ecregistration data fetch");
        for (int i = 0; i < fieldJsonArray.length(); i++) {

            JSONObject jsonObject = fieldJsonArray.getJSONObject(i);

            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("numberOfECPsGiven")) {

                String count = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
                numberOfECPsGiven = Integer.parseInt(count);
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("submissionDate")) {

                submissionDate = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("village")) {

                village = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
        }
        ancVisitRepository.reportinsert("", entityId, wifeName, anmid, "FP", "ecp", numberOfECPsGiven, submissionDate, village, 0, "", "","");
    }

    public void ecEdit(JSONObject dataObject, String anmPhoneNumber) throws JSONException {
        String entityId = dataObject.getString("entityId");
        logger.info("ecedit method");
        JSONArray fieldJsonArray = dataObject.getJSONObject("formInstance").getJSONObject("form").getJSONArray("fields");
        for (int i = 0; i < fieldJsonArray.length(); i++) {
            JSONObject jsonObject = fieldJsonArray.getJSONObject(i);

            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("phoneNumber")) {
                phoneNumber = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }

        }
        List ancregdetails = anmService.getPhoneNumber(entityId);
        String sid = collect(ancregdetails, on(EcRegDetails.class).id()).get(0).toString();
        String ptphoneNumber = collect(ancregdetails, on(EcRegDetails.class).phonenumber()).get(0).toString();
        int id = Integer.parseInt(sid);
        logger.info("id from db:" + id);
        if (!phoneNumber.equalsIgnoreCase(ptphoneNumber)) {

            ancVisitRepository.ecUpdate(id, phoneNumber);
            logger.info("update completed");
        }
    }

    public void ancEdit(JSONObject dataObject, String anmPhoneNumber) throws JSONException {
        String entityId = dataObject.getString("entityId");
        String ecId = "";
        logger.info("ancedit method");
        JSONArray fieldJsonArray = dataObject.getJSONObject("formInstance").getJSONObject("form").getJSONArray("fields");
        for (int i = 0; i < fieldJsonArray.length(); i++) {
            JSONObject jsonObject = fieldJsonArray.getJSONObject(i);

            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("phoneNumber")) {
                phoneNumber = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("ecId")) {

                ecId = (jsonObject.has("value") && jsonObject
                        .getString("value") != null) ? jsonObject
                                .getString("value") : "";
            }

        }
        List ancregdetails = visitService.getVisitDue(entityId);
        String sid = collect(ancregdetails, on(ANCVisitDue.class).id()).get(0).toString();
        String ptphoneNumber = collect(ancregdetails, on(ANCVisitDue.class).patientnum()).get(0).toString();
        int id = Integer.parseInt(sid);
        logger.info("id from db:" + id);
        if (!phoneNumber.equalsIgnoreCase(ptphoneNumber)) {

            ancVisitRepository.ancregUpdate(id, phoneNumber);
            logger.info("update completed");
        }
    }

    public void ancRegistration(JSONObject dataObject, String visittype, String anmNumber) throws JSONException {
        String edd = "";
        String ecNumber = "";

        logger.info("anc_registration handler");
        String anmid = dataObject.getString("anmId");
        String entityId = dataObject.getString("entityId");
        JSONArray fieldJsonArray = dataObject.getJSONObject("formInstance").getJSONObject("form").getJSONArray("fields");
        Integer visitnumber = 1;
        for (int i = 0; i < fieldJsonArray.length(); ++i) {
            JSONObject jsonObject = fieldJsonArray.getJSONObject(i);

            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("referenceDate")) {

                edd = jsonObject.has("value") && jsonObject.
                        getString("value") != null ? jsonObject
                                .getString("value") : "";

                logger.info("reference date: " + edd);
            }
            if (jsonObject.has("name") && jsonObject.getString("name").equals("phoneNumber")) {;
                phoneNumber = jsonObject.has("value") && jsonObject
                        .getString("value") != null ? jsonObject
                                .getString("value") : "";
            }

            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("ancNumber")) {

                regNumber = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("ecNumber")) {

                ecNumber = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("wifeName")) {

                wifeName = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("village")) {

                village = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("registrationDate")) {

                registrationDate = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }

        }
        List visitconf = visitService.getVisitconf();
        logger.info("vissit type details: " + visitconf);
        String visittime = collect(visitconf, on(VisitConf.class).anc_visit1_from_week()).get(0).toString();
        logger.info("visit time interval:" + visittime);
        int visitti = Integer.parseInt(visittime) * 7;
        String visitdate = dateUtil.dateFormat(edd, visitti);

        if (visittype.equalsIgnoreCase("anc_registration")) {
            List ancvisitdetails = anmService.getPhoneNumber(entityId);
            logger.info("anc_registration");

            String ptphoneNumber = collect(ancvisitdetails, on(EcRegDetails.class).phonenumber()).get(0).toString();
            logger.info("phonenumber: " + ptphoneNumber);

            ancVisitRepository.insert(entityId, ptphoneNumber, anmNumber, "anc_visit", visitnumber, edd, wifeName, visitdate, anmid);
            ancVisitRepository.reportinsert("", entityId, wifeName, anmid, "anc", "", 0, registrationDate, village, 0, edd, "","");
        }
        if (visittype.equalsIgnoreCase("anc_registration_oa")) {
            logger.info("trying to send sms");
            smsController.sendSMSEC(phoneNumber, regNumber, wifeName, "ANC");
            logger.info("sms sent done");
            ancVisitRepository.insert(entityId, phoneNumber, anmNumber, "anc_visit", visitnumber, edd, wifeName, visitdate, anmid);
            ancVisitRepository.reportinsert("", entityId, wifeName, anmid, "anc", "", 0, registrationDate, village, 0, edd, "","");
        }

    }

    public void ttData(JSONObject dataObject, String visittype) throws JSONException {
        String anmid = dataObject.getString("anmId");
        String entityId = dataObject.getString("entityId");
        String ecId = "";
        String ttDose = "";
        String ttInjectionPlace = "";
        String ttDate = "";
        JSONArray fieldJsonArray = dataObject.getJSONObject("formInstance").getJSONObject("form").getJSONArray("fields");
        for (int i = 0; i < fieldJsonArray.length(); i++) {

            JSONObject jsonObject = fieldJsonArray
                    .getJSONObject(i);
            if ((jsonObject.has("name"))
                    && jsonObject.getString("name").equals("ecId")) {

                ecId = (jsonObject.has("value") && jsonObject
                        .getString("value") != null) ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("village")) {

                village = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("ttDose")) {

                ttDose = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("ttInjectionPlace")) {

                ttInjectionPlace = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("ttDate")) {

                ttDate = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
        }
        ancVisitRepository.reportinsert(entityId, ecId, "", anmid, ttDose, "", 0, ttDate, village, 0, "", ttInjectionPlace,"");
    }

    public void ancVisit(JSONObject dataObject, String visittype, String anmnumber) throws JSONException {
        logger.info("anc_visit");
        String ecId = "";
        String newdate = "";
        String visittime = "";
        Integer visitno = null;
        Integer visitti = null;

        JSONArray fieldJsonArray = dataObject
                .getJSONObject("formInstance")
                .getJSONObject("form").getJSONArray("fields");

        for (int i = 0; i < fieldJsonArray.length(); i++) {

            JSONObject jsonObject = fieldJsonArray
                    .getJSONObject(i);
            if ((jsonObject.has("name"))
                    && jsonObject.getString("name").equals("ecId")) {

                ecId = (jsonObject.has("value") && jsonObject
                        .getString("value") != null) ? jsonObject
                                .getString("value") : "";
            }
        }
        logger.info("entityid" + ecId);
        List ancvisitdetails = visitService.getVisitDue(ecId);
        List visitconf = visitService.getVisitconf();
        logger.info("ancvisitpastdetails^^^^" + ancvisitdetails);
        String datetime = collect(ancvisitdetails, on(ANCVisitDue.class).lmpdate()).get(0).toString();
        String visit = collect(ancvisitdetails, on(ANCVisitDue.class).visitno()).get(0).toString();
        int visitnum = Integer.parseInt(visit);
        if (visitnum == 1) {
            visittime = collect(visitconf, on(VisitConf.class).anc_visit2_from_week()).get(0).toString();
            visitti = Integer.parseInt(visittime) * 7;
            newdate = dateUtil.dateFormat(datetime, visitti);
            visitno = 2;
        }
        if (visitnum == 2) {
            visittime = collect(visitconf, on(VisitConf.class).anc_visit3_from_week()).get(0).toString();
            logger.info("visit time interval:" + visittime);
            visitti = Integer.parseInt(visittime) * 7;
            newdate = dateUtil.dateFormat(datetime, visitti);
            visitno = 3;
        }
        if (visitnum == 3) {
            visittime = collect(visitconf, on(VisitConf.class).anc_visit4_from_week()).get(0).toString();
            logger.info("visit time interval:" + visittime);
            visitti = Integer.parseInt(visittime) * 7;
            logger.info("visit time converted interval:" + visitti);
            newdate = dateUtil.dateFormat(datetime, visitti);
            logger.info("visit time converted time:" + newdate);
            visitno = 4;
        }
        if (visitnum == 4) {
            newdate = "";
            logger.info("visit time converted time:" + newdate);
            visitno = 5;
        }
        logger.info("new date" + newdate);
        String sid = collect(ancvisitdetails, on(ANCVisitDue.class).id()).get(0).toString();
        logger.info("id from db:" + sid);
        int id = Integer.parseInt(sid);
        logger.info("id from db:" + id);
        ancVisitRepository.ancUpdate(id, newdate, visitno);
    }

    public void pncRegistration(JSONObject dataObject, String visittype, String anmNumber) throws JSONException {
        String child_dob = "";
        String deliveryPlace = "";
        String ptnumber = "";
        String ecId = "";
        String deliveryType = "";
        Integer weight = 0;
        Integer child_weight=0;
        String anmid = dataObject.getString("anmId");
        String entityId = dataObject.getString("entityId");
        logger.info("pnc registration");

        JSONArray fieldJsonArray = dataObject.getJSONObject("formInstance").getJSONObject("form").getJSONArray("fields");
        JSONArray subfieldJsonArray = dataObject.getJSONObject("formInstance").getJSONObject("form").getJSONArray("sub_forms");
        logger.info("sbform [0]:  " + subfieldJsonArray);
        JSONArray subfieldJsonArr = subfieldJsonArray.getJSONObject(0).getJSONArray("instances");
        logger.info("instances [0]:  " + subfieldJsonArr);
        logger.info("weight child:  " + subfieldJsonArr.getJSONObject(0).getString("weight"));
        if(!subfieldJsonArr.getJSONObject(0).getString("weight").equalsIgnoreCase("")){
        String chiweight=subfieldJsonArr.getJSONObject(0).getString("weight");
            child_weight=Integer.parseInt(chiweight);
        }
        logger.info("weight [0]:  " + child_weight);

        for (int i = 0; i < fieldJsonArray.length(); ++i) {
            JSONObject jsonObject = fieldJsonArray.getJSONObject(i);
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("referenceDate")) {

                child_dob = jsonObject.has("value") && jsonObject.
                        getString("value") != null ? jsonObject
                                .getString("value") : "";

                logger.info("reference date: " + child_dob);
            }
            if (jsonObject.has("name") && jsonObject.getString("name").equals("phoneNumber")) {
                phoneNumber = jsonObject.has("value") && jsonObject
                        .getString("value") != null ? jsonObject
                                .getString("value") : "";
            }

            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("pncNumber")) {

                regNumber = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("deliveryPlace")) {

                deliveryPlace = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("wifeName")) {

                wifeName = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("ecId")) {

                ecId = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";

            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("deliveryType")) {

                deliveryType = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";

            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("registrationDate")) {

                registrationDate = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("village")) {

                village = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
        }
        if (visittype.equalsIgnoreCase("delivery_outcome")) {

            List ancvisitdetails = visitService.getVisitDue(ecId);
            String womenName = collect(ancvisitdetails, on(ANCVisitDue.class).womenName()).get(0).toString();
            logger.info("women Name from db" + womenName);
            String womphoneNumber = collect(ancvisitdetails, on(ANCVisitDue.class).patientnum()).get(0).toString();
            logger.info("wom phone number from db" + womphoneNumber);
            smsController.sendSMSPNC(womphoneNumber, regNumber, womenName, "PNC");
            ancVisitRepository.reportinsert(entityId, ecId, wifeName, anmid, "pnc", deliveryType, 0, registrationDate, village, child_weight, "", deliveryPlace,child_dob);
        }
        if (visittype.equalsIgnoreCase("pnc_registration_oa")) {
            logger.info("phonenumber" + phoneNumber + "*** wife name" + wifeName + "***reg Number" + regNumber);
            smsController.sendSMSEC(phoneNumber, regNumber, wifeName, "PNC");
            ancVisitRepository.reportinsert("", entityId, wifeName, anmid, "pnc", deliveryType, 0, registrationDate, village, child_weight, "", deliveryPlace,child_dob);
        }
    }

    public void visitpoc(JSONObject dataObject, String visittype, String anmNumber) throws JSONException {
        String entityidEC = "";
        String motherName = "";
        JSONArray fieldsJsonArray = dataObject.getJSONObject("formInstance")
                .getJSONObject("form").getJSONArray("fields");
        String visitentityid = dataObject.getString("entityId");
        String anmid = dataObject.getString("anmId");
        for (int i = 0; i < fieldsJsonArray.length(); i++) {
            JSONObject jsonObject = fieldsJsonArray.getJSONObject(i);
            if ((jsonObject.has("name")) && jsonObject.getString("name").equals("ecId")) {
                entityidEC = (jsonObject.has("value") && jsonObject
                        .getString("value") != null) ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("wifeName")) {

                wifeName = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("motherName")) {

                motherName = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if ((jsonObject.has("name")) && jsonObject.getString("name").equals("isConsultDoctor")) {
                String isCon = (jsonObject.has("value") && jsonObject
                        .getString("value") != null) ? jsonObject
                                .getString("value") : "";
                logger.info("res1+++++" + isCon);
                if (isCon.equalsIgnoreCase("yes")) {

                    logger.info("anmid+++++" + anmid);
                    List subcenterForANM = anmService.getANMVillages(anmid);
                    String sid = collect(subcenterForANM, on(ANMVillages.class).subcenter()).get(0).toString();
                    logger.info("subcenter from db:" + sid);
                    Integer id = Integer.parseInt(sid);
                    List phcdetails = anmService.getPHCDetails(id);
                    String phcname = collect(phcdetails, on(HealthCenter.class).parent_hospital()).get(0).toString();
                    logger.info("phc name from healthcenters" + phcname);
                    String hospitaltype = collect(phcdetails, on(HealthCenter.class).hospital_type()).get(0).toString();
                    String date = dateUtil.datetimenow();
                    logger.info("date time converted" + date);

                    if (hospitaltype.equalsIgnoreCase("Subcenter")) {
                        if (visittype.equalsIgnoreCase("child_illness")) {
                            ancVisitRepository.pocinsert(visittype, visitentityid, entityidEC, anmid, phcname, date, motherName);
                        }
                        if (visittype.equalsIgnoreCase("anc_visit") || visittype.equalsIgnoreCase("pnc_visit")) {
                            ancVisitRepository.pocinsert(visittype, visitentityid, entityidEC, anmid, phcname, date, wifeName);
                        }

                    }

                    logger.info("invoking a service method");

                }
            }
        }
    }

    public void childRegistration(JSONObject dataObject, String visittype, String anmNumber) throws JSONException {
        String edd = "2015-09-09";
        String ecNumber = "";
        String motherName = "";
        String childId = "";
        String dateOfBirth = "";
        String immunizationsGiven="";
        String weight="";
        Integer birthWeight=0;

        String entityId = dataObject.getString("entityId");
        String anmid = dataObject.getString("anmId");

        logger.info("child registration handler");
        JSONArray fieldJsonArray = dataObject.getJSONObject("formInstance").getJSONObject("form").getJSONArray("fields");
        Integer visitnumber = 1;
        for (int i = 0; i < fieldJsonArray.length(); ++i) {
            JSONObject jsonObject = fieldJsonArray.getJSONObject(i);

            if (jsonObject.has("name") && jsonObject.getString("name").equals("phoneNumber")) {
                phoneNumber = jsonObject.has("value") && jsonObject
                        .getString("value") != null ? jsonObject
                                .getString("value") : "";
            }

            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("motherName")) {

                motherName = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("wifeName")) {

                wifeName = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("childId")) {

                childId = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("dateOfBirth")) {

                dateOfBirth = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("immunizationsGiven")) {

                immunizationsGiven = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("village")) {

                village = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("registrationDate")) {

                registrationDate = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("birthWeight")) {

                weight = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
                birthWeight=Integer.parseInt(weight);
                
            }
            
        }
        logger.info("immunizationgiven length"+immunizationsGiven.length());
        

        if (visittype.equalsIgnoreCase("child_registration_oa")) {
            logger.info("visittype: child_registration_oa");
            smsController.sendSMSChild(phoneNumber, motherName);
            ancVisitRepository.insert(entityId, phoneNumber, anmNumber, "child_Immunization", visitnumber, dateOfBirth, motherName, edd, anmid);
            ancVisitRepository.reportinsert("", entityId, motherName, anmid, "child", immunizationsGiven, 0, registrationDate, village, birthWeight, "", "",dateOfBirth);
        }
        if (visittype.equalsIgnoreCase("child_registration_ec")) {
            List ancvisitdetails = anmService.getPhoneNumber(entityId);

            String ptphoneNumber = collect(ancvisitdetails, on(EcRegDetails.class).phonenumber()).get(0);
            logger.info("phonenumber: " + ptphoneNumber);
            smsController.sendSMSChild(ptphoneNumber, wifeName);
            ancVisitRepository.insert(childId, ptphoneNumber, anmNumber, "child_Immunization", visitnumber, dateOfBirth, wifeName, edd, anmid);
            ancVisitRepository.reportinsert("", entityId, wifeName, anmid, "child", immunizationsGiven, 0, registrationDate, village, birthWeight,"" , "",dateOfBirth);

        }
        

    }
    public void childImmunization(JSONObject dataObject, String visittype) throws JSONException{
        String motherName="";
        String immunizationsReceived="";
        String immunizationDate="";
        String immunizationPlace="";
        String entityId = dataObject.getString("entityId");
        String anmid = dataObject.getString("anmId");
        JSONArray fieldJsonArray = dataObject.getJSONObject("formInstance").getJSONObject("form").getJSONArray("fields");
        for (int i = 0; i < fieldJsonArray.length(); ++i) {
            JSONObject jsonObject = fieldJsonArray.getJSONObject(i);

            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("motherName")) {

                motherName = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("immunizationsReceived")) {

                immunizationsReceived = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("submissionDate")) {

                registrationDate = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("village")) {

                village = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("immunizationDate")) {

                immunizationDate = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("immunizationPlace")) {

                immunizationPlace = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                                .getString("value") : "";
            }
            
        }
        ancVisitRepository.reportinsert("", entityId, motherName, anmid, "child", immunizationsReceived, 0, registrationDate, village, 0, immunizationDate, immunizationPlace,"");
    }
}