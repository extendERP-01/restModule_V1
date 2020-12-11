package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.LocationMasterDao;
import nirmalya.aatithya.restmodule.master.model.LocationMasterModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master")
public class LocationMasterRestController {
	
	Logger logger = LoggerFactory.getLogger(LocationMasterRestController.class);

	@Autowired
	LocationMasterDao locationMasterDao;

	@RequestMapping(value = "getLocationTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getLocationTypeList() {
		logger.info("Method : getLocationTypeList starts");
		
		logger.info("Method : getLocationTypeList ends");
		return locationMasterDao.getLocationTypeList();
	}
	
	@RequestMapping(value = "getCountryListForLocation", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryListForLocation() {
		logger.info("Method : getCountryListForLocation starts");
		
		logger.info("Method : getCountryListForLocation ends");
		return locationMasterDao.getCountryListForLocation();
	}
	
	@RequestMapping(value = "getLocationList", method = { RequestMethod.GET })
	public List<LocationMasterModel> getLocationList() {
		logger.info("Method : getLocationList starts");
		
		logger.info("Method : getLocationList ends");
		return locationMasterDao.getLocationList();
	}
	
	@RequestMapping(value = "getStateListForLoc", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateListForLoc(@RequestParam String id) {
		logger.info("Method : getStateListForLoc starts");
		
		logger.info("Method : getStateListForLoc ends");
		return locationMasterDao.getStateListForLoc(id);
	}
	
	@RequestMapping(value = "getCityForLocation", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCityForLocation(@RequestParam String id) {
		logger.info("Method : getCityForLocation starts");
		
		logger.info("Method : getCityForLocation ends");
		return locationMasterDao.getCityForLocation(id);
	}
	
	@RequestMapping(value = "saveLocationMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<LocationMasterModel>> saveLocationMaster(@RequestBody LocationMasterModel location) {
		logger.info("Method : saveLocationMaster starts");
		
		logger.info("Method : saveLocationMaster ends");
		return locationMasterDao.saveLocationMaster(location);
	}
}
