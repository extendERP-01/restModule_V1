package nirmalya.aatithya.restmodule.asset.controller;

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

import nirmalya.aatithya.restmodule.asset.dao.AssetVehicleAssignDao;
import nirmalya.aatithya.restmodule.asset.model.AssetVehicleModel;
import nirmalya.aatithya.restmodule.asset.model.ItemAssetModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "asset/")
public class AssetVehicleAssignRestController {
	
	Logger logger = LoggerFactory.getLogger(AssetVehicleAssignRestController.class);
	
	@Autowired
	AssetVehicleAssignDao assetVehicleAssignDao;
	
	@RequestMapping(value = "/getStoreForAssign", method = { RequestMethod.GET })
	public List<DropDownModel> getStoreForAssign() {
		logger.info("Method : getStoreForAssign starts");
		
		logger.info("Method : getStoreForAssign end");
		return assetVehicleAssignDao.getStoreForAssign();
	}
	
	@RequestMapping(value = "/getVehicleDetailsForAssign", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> getVehicleDetailsForAssign(@RequestBody DropDownModel id) {
		logger.info("Method : getVehicleDetailsForAssign starts");

		logger.info("Method : getVehicleDetailsForAssign ends");
		return assetVehicleAssignDao.getVehicleDetailsForAssign(id);
	}
	
	@RequestMapping(value = "/getVehicleForReport", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVehicleForReport(@RequestParam String id) {
		logger.info("Method : getVehicleForReport starts");

		logger.info("Method : getVehicleForReport ends");
		return assetVehicleAssignDao.getVehicleForReport(id);
	}
	
	@RequestMapping(value = "/getAssetForAssign", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> getAssetForAssign(@RequestParam String id) {
		logger.info("Method : getAssetForAssign starts");
		
		logger.info("Method : getAssetForAssign ends");
		return assetVehicleAssignDao.getAssetForAssign(id);
	}
	
	@RequestMapping(value="assignAssetToVehicle" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> assignAssetToVehicle(@RequestBody  List<AssetVehicleModel> assignedAsset) {
		logger.info("Method : assignAssetToVehicle for rest controller starts");
		
		logger.info("Method : assignAssetToVehicle for rest controller ends");
		return assetVehicleAssignDao.assignAssetToVehicle(assignedAsset);
	}
	
	@RequestMapping(value = "/getAssignedAssetVehicleDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AssetVehicleModel>>> getAssignedAssetVehicleDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAssignedAssetVehicleDetails starts");

		logger.info("Method : getAssignedAssetVehicleDetails ends");
		return assetVehicleAssignDao.getAssignedAssetVehicleDetails(request);
	}
	
	@RequestMapping(value = "/editAssignedAsset", method = { RequestMethod.GET })
	public List<AssetVehicleModel> editAssignedAsset(@RequestParam("id")String id, @RequestParam("vehicleAsset") String vehicleAsset) {
		logger.info("Method : editAssignedAsset for rest controller starts");
		
		logger.info("Method : editAssignedAsset for rest controller ends");
		return assetVehicleAssignDao.editAssignedAsset(id,vehicleAsset);
	}
	
	@RequestMapping(value = "/getAssignedAssetForView", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AssetVehicleModel>>> getAssignedAssetForView(@RequestParam String id) {
		logger.info("Method : getAssignedAssetForView starts");
		
		logger.info("Method : getAssignedAssetForView ends");
		return assetVehicleAssignDao.getAssignedAssetForView(id);
	}
	
	@RequestMapping(value = "/changeAssignStatus", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> changeAssignStatus(@RequestBody AssetVehicleModel searchValue) {
		logger.info("Method : changeAssignStatus starts");
		
		logger.info("Method : changeAssignStatus ends");
		return assetVehicleAssignDao.changeAssignStatus(searchValue);
	}
	
	@RequestMapping(value = "getVehicleAssetSummaryReportForPreview", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AssetVehicleModel>>> getVehicleAssetSummaryReportForPreview(
			@RequestBody DataTableRequest request) {
		logger.info("Method : RESTMODULE getVehicleAssetSummaryReportForPreview starts");
		logger.info("Method : RESTMODULE getVehicleAssetSummaryReportForPreview end");
		return assetVehicleAssignDao.getVehicleAssetSummaryReportForPreview(request);
	}
	
	@RequestMapping(value = "getVehicleAssetSummaryReportPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AssetVehicleModel>>> getVehicleAssetSummaryReportPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method : RESTMODULE getVehicleAssetSummaryReportPdf starts");
		logger.info("Method : RESTMODULE getVehicleAssetSummaryReportPdf end");
		return assetVehicleAssignDao.getVehicleAssetSummaryReportPdf(request);
	}
	
	@RequestMapping(value="restLogoImage-VehicleAssetSummary" , method={RequestMethod.GET})
	public List<DropDownModel> restHotelLogoImage(@RequestParam("logoType") String logoType) {
		logger.info("Method : restHotelLogoImage starts");

		logger.info("Method : restHotelLogoImage ends");
		return assetVehicleAssignDao.getHotelLogoImage(logoType);
	}
	
	@RequestMapping(value = "getVehicleCurrentAssetReportForPreview", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AssetVehicleModel>>> getVehicleCurrentAssetReportForPreview(
			@RequestBody DataTableRequest request) {
		logger.info("Method : RESTMODULE getVehicleCurrentAssetReportForPreview starts");
		logger.info("Method : RESTMODULE getVehicleCurrentAssetReportForPreview end");
		return assetVehicleAssignDao.getVehicleCurrentAssetReportForPreview(request);
	}
	
	@RequestMapping(value = "getVehicleCurrentAssetReportPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AssetVehicleModel>>> getVehicleCurrentAssetReportPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method : RESTMODULE getVehicleCurrentAssetReportPdf starts");
		logger.info("Method : RESTMODULE getVehicleCurrentAssetReportPdf end");
		return assetVehicleAssignDao.getVehicleCurrentAssetReportPdf(request);
	}
}
