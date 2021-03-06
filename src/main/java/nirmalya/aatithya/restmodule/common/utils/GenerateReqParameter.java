package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.recruitment.model.AddRecruitentModel;

public class GenerateReqParameter {
	public static String getAddreqParam(AddRecruitentModel form) {
		String s = "";
		String qItem = "";
		String addReq = "";
		
		for (int i =0; i < form.getBenefits().size() ; i++) {
			qItem = qItem + "(@p_requisitionId,\"" + form.getBenefits().get(i) + "\",\"" + form.getCreatedBy()+ "\",\"" + form.getCreatedBy() + "\"),";
		}
		qItem = qItem.substring(0, qItem.length() - 1);

		addReq = addReq + "(@p_requisitionId,\"" + form.getJobTitle() + "\",\"" + form.getJobType() + "\",\"" + form.getJobLocation() + "\",\"" + 
				form.getMinEducation() + "\",\"" + form.getMinSalary() + "\",\"" + form.getMaxSalary() + "\",\"" + form.getDepartment() + "\",\"" +
				form.getHiringManager() + "\",\"" + form.getNoPosition() + "\",\"" + form.getWorkHour() + "\",\"" + form.getBand() + "\",\"" + form.getJoinDate() + "\",\"" + 
				form.getPositionSummary() + "\",\"" + form.getPositionResponsibility() + "\",\"" + form.getRequiredSkillExperience() +
				"\",\"" + form.getApprover() + "\",\"" + form.getAbout() + "\",\"" + form.getCreatedBy()+ "\",\"" + form.getCreatedBy() +"\",1),";
		addReq = addReq.substring(0, addReq.length() - 1);
		
		s = s + "@p_benefitsData='" + qItem + "',";
		s = s + "@p_addRequisition='" + addReq + "',";
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}
}


