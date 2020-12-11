package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateLocationMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.LocationMasterModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class LocationMasterDao {

	Logger logger = LoggerFactory.getLogger(LocationMasterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLocationTypeList() {
		logger.info("Method : getLocationTypeList starts");

		List<DropDownModel> locationTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getLocationTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				locationTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLocationTypeList ends");
		return locationTypeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryListForLocation() {
		logger.info("Method : getCountryListForLocation starts");

		List<DropDownModel> locationTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getCountryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				locationTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryListForLocation ends");
		return locationTypeList;
	}
	
	@SuppressWarnings("unchecked")
	public List<LocationMasterModel> getLocationList() {
		logger.info("Method : getLocationList starts");
		
		List<LocationMasterModel> locationList = new ArrayList<LocationMasterModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getLocationList").setParameter("actionValue", "").getResultList();
			
			for (Object[] m : x) {
				Object createDate = null;
				
				if(m[12]!=null) {
					createDate = DateFormatter.returnStringDateMonth(m[12]);
				}
				
				LocationMasterModel dropDownModel = new LocationMasterModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],createDate);
				locationList.add(dropDownModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : getLocationList ends");
		return locationList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateListForLoc(String id) {
		logger.info("Method : getStateListForLoc starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @P_Country='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getStateList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}
			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getStateListForLoc ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCityForLocation(String id) {
		logger.info("Method : getCityForLocation starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @P_State='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
					.setParameter("actionType", "getCityList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}
			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getCityForLocation ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<LocationMasterModel>> saveLocationMaster(LocationMasterModel location) {
		logger.info("Method : saveLocationMaster starts");

		Boolean validity = true;
		JsonResponse<LocationMasterModel> resp = new JsonResponse<LocationMasterModel>();
		resp.setMessage("");
		resp.setCode("");
		
		List<LocationMasterModel> newLoc = new ArrayList<LocationMasterModel>();

		if (location.getLocationName() == null || location.getLocationName() == "") {
			resp.setMessage("Location Name Required");
			validity = false;
		} else if (location.getLocationCode() == null || location.getLocationCode() == "") {
			resp.setMessage("Location Code Required");
			validity = false;
		} else if (location.getLocationType() == null || location.getLocationType() == "") {
			resp.setMessage("Location Type Required");
			validity = false;
		} else if (location.getLocCountry() == null || location.getLocCountry() == "") {
			resp.setMessage("Country Required");
			validity = false;
		} else if (location.getLocState() == null || location.getLocState() == "") {
			resp.setMessage("State Required");
			validity = false;
		} else if (location.getLocCity() == null || location.getLocCity() == "") {
			resp.setMessage("City Required");
			validity = false;
		} else if (location.getLocStreet() == null || location.getLocStreet() == "") {
			resp.setMessage("Street Required");
			validity = false;
		}
		
		if (validity)
			try {
				String values = GenerateLocationMasterParameter.saveLocation(location);
				
				if (location.getLocationId() != null && location.getLocationId() != "") {
					em.createNamedStoredProcedureQuery("locationMasterRoutines").setParameter("actionType", "modifyLocation")
							.setParameter("actionValue", values).execute();

				} else {
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("locationMasterRoutines")
							.setParameter("actionType", "addLocation")
							.setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {
						
						Object createDate = null;
						
						if(m[12]!=null) {
							createDate = DateFormatter.returnStringDate(m[12]);
						}
						
						LocationMasterModel item = new LocationMasterModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],createDate);
						newLoc.add(item);
					}
					/*
					 * em.createNamedStoredProcedureQuery("locationMasterRoutines")
					 * .setParameter("actionType", "addLocation") .setParameter("actionValue",
					 * values) .execute();
					 */

				}
				
				resp.setBody(newLoc.get(0));
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<LocationMasterModel>> response = new ResponseEntity<JsonResponse<LocationMasterModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveLocationMaster ends");
		return response;
	}
}
