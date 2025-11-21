package pccth.sp.pccthspseedservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pccth.sp.pccthspseedservice.entity.TahnEntity;
import pccth.sp.pccthspseedservice.model.TahnModel;
import pccth.sp.pccthspseedservice.repository.TahnJDBCRepository;
import pccth.sp.pccthspseedservice.repository.TahnJPARepository;
import pccth.sp.pccthspseedservice.utils.DateUtil;

@Service
public class TahnService {
	

		@Autowired
		private TahnJPARepository tahnJPARepository;
		
		@Autowired
		private TahnJDBCRepository tahnJDBCRepository;
		
		
		public List<TahnModel> getData() {
			List<TahnModel> tahnModelList =  tahnJDBCRepository.findAll();
			return tahnModelList;
		}
		
		
		public List<TahnModel> getDataByName(String name) {
			List<TahnEntity> tahnEntityList =  tahnJPARepository.findByName(name);
			List<TahnModel> tahnModelList = new ArrayList<>();
			
			for(TahnEntity tahnEntity: tahnEntityList) {
				TahnModel tahnModel = new TahnModel();
				
				tahnModel.setFirstname(tahnEntity.getName());
				tahnModel.setLastname(tahnEntity.getLastname());
//				tahnModel.setAge(tahnEntity.getAge().intValue());
				
				tahnModelList.add(tahnModel);
			}
			return tahnModelList;
		}
		
//		public List<TahnModel> getDataByName(String name) {
//			List<TahnEntity> tahnEntityList =  tahnJPARepository.findByName(name);
//			List<TahnModel> tahnModelList = new ArrayList<>();
//			
//			for(TahnEntity tahnEntity: tahnEntityList) {
//				TahnModel tahnModel = new TahnModel();
//				
//				tahnModel.setFirstname(tahnEntity.getName());
//				tahnModel.setLastname(tahnEntity.getLastname());
////				tahnModel.setAge(tahnEntity.getAge().intValue());
//				
//				tahnModelList.add(tahnModel);
//			}
//			return tahnModelList;
//		}
		
		
		public void saveData(TahnModel tahnModel) {			
			tahnJDBCRepository.saveData(tahnModel);
		}
		
		
//		public void saveData(TahnModel tahnModel) {
//			TahnEntity tahnEntity = new TahnEntity();
//			tahnEntity.setName(tahnModel.getFirstname());
//			tahnEntity.setLastname(tahnModel.getLastname());
//			
//			//01/12/2550 string
//			tahnModel.getBirtday();
//			
//			//convert string to string
//			String dbString = DateUtil.convertDDMMYYYYBuddhistYearToYYYYMMDDChristianYear(tahnModel.getBirtday());
//			
//			// string to date
//			Date dbDate =  DateUtil.convertYYYYMMDDChristianYearToDate(dbString);
//			
//			//2007-12-01
//			tahnEntity.setBirtday(dbDate);
//			
//			tahnJPARepository.save(tahnEntity);
//		}
}
