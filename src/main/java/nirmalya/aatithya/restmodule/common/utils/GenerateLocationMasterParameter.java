package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.LocationMasterModel;

public class GenerateLocationMasterParameter {

	public static String saveLocation(LocationMasterModel location) {
		
		String s = "";
		
		if(location.getLocationId()!=null && location.getLocationId()!="") {
			s = s + "@p_locationId='" + location.getLocationId() + "',";
		}
		if(location.getLocationName()!=null && location.getLocationName()!="") {
			s = s + "@p_locationName='" + location.getLocationName() + "',";
		}
		if(location.getLocationCode()!=null && location.getLocationCode()!="") {
			s = s + "@p_locationCode='" + location.getLocationCode() + "',";
		}
		if(location.getLocVirtual()!=null && location.getLocVirtual()!="") {
			s = s + "@p_isVirtual='" + location.getLocVirtual() + "',";
		} else {
			s = s + "@p_isVirtual='" + 0 + "',";
		}
		if(location.getLocationType()!=null && location.getLocationType()!="") {
			s = s + "@p_locType='" + location.getLocationType() + "',";
		}
		if(location.getLocCountry()!=null && location.getLocCountry()!="") {
			s = s + "@p_locCountry='" + location.getLocCountry() + "',";
		}
		if(location.getLocState()!=null && location.getLocState()!="") {
			s = s + "@p_locState='" + location.getLocState() + "',";
		}
		if(location.getLocCity()!=null && location.getLocCity()!="") {
			s = s + "@p_locCity='" + location.getLocCity() + "',";
		}
		if(location.getLocStreet()!=null && location.getLocStreet()!="") {
			s = s + "@p_locStreet='" + location.getLocStreet() + "',";
		}
		if(location.getFileLocation()!=null && location.getFileLocation()!="") {
			s = s + "@p_fileLocation='" + location.getFileLocation() + "',";
		}
		if(location.getCreatedBy()!=null && location.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + location.getCreatedBy() + "',";
		}
		if(location.getLocStatus()!=null && location.getLocStatus()!="") {
			s = s + "@p_isActive='" + location.getLocStatus() + "',";
		} else {
			s = s + "@p_isActive='" + 0 + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}

}
